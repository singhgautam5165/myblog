package com.telecom.Telecom.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "porting_requests")
public class PortingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String mobileNumber;

    private String donorOperator;   // current operator
    private String recipientOperator; // new operator
    private String customerName;
    private String status; // APPROVED / REJECTED / PENDING
    private String remarks;

    public PortingRequest() {}

    public PortingRequest(String mobileNumber, String donorOperator, String recipientOperator,
                          String customerName, String status, String remarks) {
        this.mobileNumber = mobileNumber;
        this.donorOperator = donorOperator;
        this.recipientOperator = recipientOperator;
        this.customerName = customerName;
        this.status = status;
        this.remarks = remarks;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getDonorOperator() { return donorOperator; }
    public void setDonorOperator(String donorOperator) { this.donorOperator = donorOperator; }

    public String getRecipientOperator() { return recipientOperator; }
    public void setRecipientOperator(String recipientOperator) { this.recipientOperator = recipientOperator; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
