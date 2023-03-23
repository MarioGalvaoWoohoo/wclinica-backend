package com.woohoo.wClinica.models;

import javax.persistence.*;

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

    @Column(nullable = false)
    private Integer accessType;
	
}
