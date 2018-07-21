package me.personal.service;

import me.personal.dao.AuditLogRepository;
import me.personal.entity.AuditLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuditLogService {

	@Autowired
	private AuditLogRepository auditLogRepository;

	@Transactional
	public void addLog(AuditLogEntity entity) {
		this.auditLogRepository.save(entity);
	}

}
