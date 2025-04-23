package com.example.jobportal.Entities;

import java.time.LocalDate;
// import java.util.Locale.Category;
import java.util.List;

import jakarta.persistence.CascadeType;
// import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
// import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "job")
@Data
@Builder
public class JobForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobid;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String CompanyName;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Show approval = Show.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkMode workmode;

    private enum Category{
        Tech,Design;
    }

    @PrePersist
    protected void onCreate() {
        this.date = LocalDate.now();
    }

    private enum WorkMode{
        REMOTE,HYBRID,HOME
    }

    private enum Show{
        PENDING,APPROVED,REJECTED;
    }

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobRequest> jobRequests;
}
