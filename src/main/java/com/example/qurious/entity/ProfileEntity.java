package com.example.qurious.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // for optimistic locking hibernate uses version
    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @NotBlank(message = "First name should not be empty")
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 50)
    @Column(name = "second_name")
    private String lastName;

    @NotBlank(message = "Mobile number should not be empty")
    @Size(max = 50)
    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Lob
    @Column(name = "profile_thumbnail")
    private Byte[] profileThumbnail;

}
