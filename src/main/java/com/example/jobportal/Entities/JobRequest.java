package com.example.jobportal.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job_requests")
@Data
@Builder
public class JobRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who applied
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    // Job that was applied to
    @ManyToOne
    @JoinColumn(name = "jobid", nullable = false)
    private JobForm job;


    private String userLocation;

    @Column(nullable = false)
    private String userEmail;

    @Lob
    @Column(columnDefinition = "LONGTEXT",nullable = false)
    private String resumeBase64; 

    @ElementCollection
    @CollectionTable(name = "job_posting_skills", joinColumns = @JoinColumn(name = "job_posting_id"))
    @Column(name = "skill")
    private List<String> skills;

    // @Lob
    @Column(nullable = false)
    private Education education;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false)
    private JobPostingStatus status = JobPostingStatus.PENDING;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum JobPostingStatus {
        PENDING,
        RECEIVED,
        INTERVIEW,
        HIRED,
        REJECTED
    }

    public enum Education {
        BTECH,
        UNDER_GRADUATE,
        MASTERS,
        OTHER
    }
}
