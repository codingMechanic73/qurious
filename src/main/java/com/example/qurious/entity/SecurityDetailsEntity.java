package com.example.qurious.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "security_details")
public class SecurityDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private int version;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private UserEntity createdBy;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifier_id", referencedColumnName = "id")
    private UserEntity modifiedBy;

    @Column(name = "last_password_change_at")
    private LocalDateTime lastPasswordChangeAt;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Min(0)
    @Max(5)
    @Column(name = "failed_login_count")
    private int failedLoginCount;

}
