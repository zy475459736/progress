package me.personal.service;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import me.personal.common.BaseException;
import me.personal.common.IPState;
import me.personal.common.MessageType;
import me.personal.common.PageResult;
import me.personal.dao.IPRepository;
import me.personal.dao.SubnetRepository;
import me.personal.entity.IPEntity;
import me.personal.entity.IPVO;
import me.personal.entity.SubnetEntity;
import me.personal.entity.SubnetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import utils.util.IPUtil;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class IPAMService {

	@Autowired
	private SubnetRepository subnetRepository;
	
	@Autowired
	private IPRepository ipRepository;
	
	private LoadingCache<String, Optional<IPEntity>> ipCache = CacheBuilder.newBuilder().maximumSize(1000)
	        .expireAfterWrite(10, TimeUnit.MINUTES)	
	        .build(
	            new CacheLoader<String, Optional<IPEntity>>() {
                    @Override
	                public Optional<IPEntity> load(String ip) {
	                	IPEntity entity = ipRepository.findByIp(ip);
	                	return Optional.fromNullable(entity);
	                }
	
	        });

	@Transactional
	public void addSubnet(String host,String subnet){
		SubnetEntity subnetEntity = new SubnetEntity();
		subnetEntity.setHost(host);
		subnetEntity.setSubnet(subnet);
		subnetRepository.save(subnetEntity);
	}
	
	@Transactional
	public void deleteSubnet(long id){
		SubnetEntity subnetEntity = subnetRepository.findOne(id);
		
		if(subnetEntity != null){
			ipRepository.deleteByHost(subnetEntity.getHost());
			subnetRepository.delete(id);
		}
	}
	
	@Transactional
	public String leaseIP(String host) throws Exception{
		
		SubnetEntity subnetEntity = subnetRepository.findByHost(host);
		Preconditions.checkState(subnetEntity != null, "This host has not subnet.");
		List<IPEntity> ipEntityList = ipRepository.findByHost(host); 
		
		List<String> excludeIps = Lists.newArrayList();
		if(!CollectionUtils.isEmpty(ipEntityList)){
			ipEntityList.forEach(ipEntity ->{
				if(ipEntity.getStatus() != IPState.FREE.getCode()){
					excludeIps.add(ipEntity.getIp());
				}
			});
		}		
		
		List<String> freeIpList = IPUtil.getIpsFromSubnet(subnetEntity.getSubnet(), excludeIps);
		
		Preconditions.checkState(!CollectionUtils.isEmpty(freeIpList),"freeipList is empty.");
		
		IPEntity ipEntity = null;
		for(String ip : freeIpList){
			Optional<IPEntity> cacheEntity = ipCache.get(ip);
			if(!cacheEntity.isPresent()){
				ipEntity = new IPEntity();
				ipEntity.setHost(host);
				ipEntity.setStatus(IPState.USED.getCode());
				ipEntity.setIp(ip);
				ipCache.put(ip, Optional.of(ipEntity));
				break;//有效ip退出循环
			}
		}

		Preconditions.checkState(ipEntity != null,"lease ip fail.");
		ipRepository.save(ipEntity);
		return ipEntity.getIp();
	}
	
	@Transactional
	public void releaseIP(String ip){	
		IPEntity ipEntity = ipRepository.findByIp(ip);		
		if(ipEntity != null && ipEntity.getStatus() == IPState.USED.getCode()){
			ipRepository.deleteByIp(ip);
		}
	}
	
	@Transactional
	public void addIP(String host,String ip,IPState state){
		IPEntity ipEntity = new IPEntity();
		ipEntity.setHost(host);
		ipEntity.setStatus(state.getCode());
		ipEntity.setIp(ip);
		ipRepository.save(ipEntity);
	}
	
	@Transactional
	public void updateIP(String ip,IPState state){
		IPEntity ipEntity = ipRepository.findByIp(ip);	
		
		if(ipEntity == null){
			BaseException.newException(MessageType.ERROR, "ip:%s is not existed.", ip);
		}
		ipEntity.setStatus(state.getCode());
		ipRepository.save(ipEntity);
	}
	
	@Transactional
	public void deleteIP(long id){
		ipRepository.delete(id);
	}
	
	public PageResult<List<SubnetVO>> querySubnetByField(final String field, final String value, int page, int count){
		
		Specification<SubnetEntity> specification = new Specification<SubnetEntity>() {

			@Override
			public Predicate toPredicate(Root<SubnetEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				Path<String> _name = root.get(field);
				Predicate _key = criteriaBuilder.like(_name, "%" + value + "%");
				return criteriaBuilder.and(_key);
			}
			
		};
		
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page - 1, count, sort);
		Page<SubnetEntity> subnetPage = subnetRepository.findAll(specification, pageable);
		
		
		List<SubnetVO> subnetVOList = Lists.newArrayList();
		if (!CollectionUtils.isEmpty(subnetPage.getContent())) {
			
			subnetPage.getContent().forEach(entity ->{
				subnetVOList.add(new SubnetVO(entity));
			});
			
		}
		
		PageResult<List<SubnetVO>> pageResult = new PageResult<List<SubnetVO>>();

		pageResult.getPage().setCurrent(page);
		pageResult.getPage().setPageSize(subnetPage.getSize());
		pageResult.getPage().setTotal(subnetPage.getTotalElements());
		pageResult.setData(subnetVOList);
		
		return pageResult;
	}
	
	public PageResult<List<IPVO>> queryIPByField(final String field, final String value, int page, int count){
		
		Specification<IPEntity> specification = new Specification<IPEntity>() {

			@Override
			public Predicate toPredicate(Root<IPEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				Path<String> _name = root.get(field);
				Predicate _key = criteriaBuilder.like(_name, "%" + value + "%");
				return criteriaBuilder.and(_key);
			}
			
		};
		
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page - 1, count, sort);
		Page<IPEntity> ipPage = ipRepository.findAll(specification, pageable);
		
		
		List<IPVO> ipVOList = Lists.newArrayList();
		if (!CollectionUtils.isEmpty(ipPage.getContent())) {
			
			ipPage.getContent().forEach(entity ->{
				ipVOList.add(new IPVO(entity));
			});
			
		}
		
		PageResult<List<IPVO>> pageResult = new PageResult<List<IPVO>>();

		pageResult.getPage().setCurrent(page);
		pageResult.getPage().setPageSize(ipPage.getSize());
		pageResult.getPage().setTotal(ipPage.getTotalElements());
		pageResult.setData(ipVOList);
		
		return pageResult;
	}
	
}
