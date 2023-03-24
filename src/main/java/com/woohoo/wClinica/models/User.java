package com.woohoo.wClinica.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(length = 100, nullable = false)
	private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String login;

    @Column(length = 60, nullable = false)
    private String password;
	
    @Column(length = 100, nullable = false, unique = true)
    private String email;
	
    @Column(nullable = false)
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "access_type_id", nullable = true)
    private AccessType accessTypeId;


    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
	
}
