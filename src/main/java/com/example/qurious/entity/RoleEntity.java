package com.example.qurious.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // for optimistic locking hibernate uses version
    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @NotBlank(message = "Every role must be identified by unique id")
    @Column(name = "uuid")
    private String uuid;

    @NotBlank(message = "Every role must have a role type")
    @Size(max = 50)
    @Column(name = "role_type")
    private String roleType;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "active")
    private boolean active;

    @NotNull
    @Column(name = "created_by")
    private UserEntity createdBy;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

}
