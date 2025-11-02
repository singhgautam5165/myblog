package com.telecom.Telecom.Repository;

import com.telecom.Telecom.Entity.PortingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortingRequestRepository extends JpaRepository<PortingRequest, Long> {
}
