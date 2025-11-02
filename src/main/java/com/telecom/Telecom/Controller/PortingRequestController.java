package com.telecom.Telecom.Controller;

import com.telecom.Telecom.Entity.PortingRequest;
import com.telecom.Telecom.Service.PortingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/porting")
public class PortingRequestController {

    @Autowired
    private PortingRequestService service;

    // ✅ GET all records
    @GetMapping
    public ResponseEntity<List<PortingRequest>> getAllRequests() {
        List<PortingRequest> requests = service.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    // ✅ GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<PortingRequest> getRequestById(@PathVariable Long id) {
        PortingRequest request = service.getRequestById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with ID: " + id));
        return ResponseEntity.ok(request);
    }

    // ✅ CREATE new record
    @PostMapping
    public ResponseEntity<PortingRequest> createRequest(@RequestBody PortingRequest request) {
        PortingRequest saved = service.saveRequest(request);
        return ResponseEntity.ok(saved);
    }

    // ✅ UPDATE record
    @PutMapping("/{id}")
    public ResponseEntity<PortingRequest> updateRequest(@PathVariable Long id, @RequestBody PortingRequest updatedRequest) {
        PortingRequest updated = service.updateRequest(id, updatedRequest);
        return ResponseEntity.ok(updated);
    }

    // ✅ DELETE record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully with ID: " + id);
    }
}
