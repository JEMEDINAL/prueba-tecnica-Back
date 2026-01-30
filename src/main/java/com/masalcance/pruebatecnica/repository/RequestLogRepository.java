package com.masalcance.pruebatecnica.repository;

import com.masalcance.pruebatecnica.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog,Long> {
}
