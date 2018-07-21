package me.personal.dao;

import me.personal.entity.IPEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IPRepository extends BaseJpaRepository<IPEntity, Long> ,JpaSpecificationExecutor<IPEntity>{
    
    List<IPEntity> findByHost(String host);
    
    void deleteByHost(String host);
    
    void deleteByIp(String ip);
    
    IPEntity findByIp(String ip);
}
