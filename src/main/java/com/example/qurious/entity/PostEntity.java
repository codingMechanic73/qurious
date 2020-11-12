package com.example.qurious.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "post")
public class PostEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // for optimistic locking hibernate uses version
    @Version
    @Column(name = "version", nullable = false)
    private int version;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Please give some description about the post")
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    @Column(name = "vote_count")
    private Integer voteCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private TopicEntity topic;
}
