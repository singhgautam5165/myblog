package com.telecom.Telecom.Service;

import com.telecom.Telecom.Entity.PortingRequest;
import com.telecom.Telecom.Repository.PortingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortingRequestService {

    @Autowired
    private PortingRequestRepository repository;

    public List<PortingRequest> getAllRequests() {
        return repository.findAll();
    }

    public Optional<PortingRequest> getRequestById(Long id) {
        return repository.findById(id);
    }

    public PortingRequest saveRequest(PortingRequest request) {
        return repository.save(request);
    }

    public PortingRequest updateRequest(Long id, PortingRequest updatedRequest) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setMobileNumber(updatedRequest.getMobileNumber());
                    existing.setDonorOperator(updatedRequest.getDonorOperator());
                    existing.setRecipientOperator(updatedRequest.getRecipientOperator());
                    existing.setCustomerName(updatedRequest.getCustomerName());
                    existing.setStatus(updatedRequest.getStatus());
                    existing.setRemarks(updatedRequest.getRemarks());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
