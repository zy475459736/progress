package me.personal.dao;


import me.personal.entity.AuditLogEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuditLogRepository extends CrudRepository<AuditLogEntity, Long> {
}
