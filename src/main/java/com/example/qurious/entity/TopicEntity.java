package com.example.qurious.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "topic")
public class TopicEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // for optimistic locking hibernate uses version
    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @NotBlank(message = "Topic name cannot be empty")
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @Size(max = 200)
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private Set<PostEntity> posts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity createdBY;

    @Lob
    @Column(name = "topic_thumbnail")
    private Byte[] topicThumbnail;

}
