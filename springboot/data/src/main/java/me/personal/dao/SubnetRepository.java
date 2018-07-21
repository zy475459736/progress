package me.personal.dao;

import me.personal.entity.SubnetEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface SubnetRepository extends BaseJpaRepository<SubnetEntity, Long> ,JpaSpecificationExecutor<SubnetEntity>{
    List<SubnetEntity> findBySubnet(String subnet);
    SubnetEntity findByHost(String host);
}
