package com.example.qurious.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Since topics, posts and votes are not searched based on name there is no
 * need of following relation:
 * user -> topic, user -> post, user -> vote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // for optimistic locking hibernate uses version
    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @Size(max = 64)
    @Column(name = "uuid")
    private String uuid;

    @Email
    @NotBlank(message = "Enter valid email id")
    @Size(max = 200)
    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;

    @ToString.Exclude
    @NotBlank
    @Size(max = 200)
    @Column(name = "salt")
    private String salt;

    @Column(name = "is_verified")
    private boolean isVerified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profileEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "security_details_id")
    private SecurityDetailsEntity userSecurityDetails;

}
