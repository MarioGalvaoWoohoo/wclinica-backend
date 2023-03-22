package com.woohoo.wClinica.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

    @Column(length = 100, nullable = false, unique = true)
    @NotNull
    @NotEmpty
	private String login;

    @Column(length = 60, nullable = false)
    @NotNull
    @NotEmpty
	private String password;
	
    @Column(length = 100, nullable = false, unique = true)
    @NotNull
    @NotEmpty
    private String email;
	
    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private Boolean status;

    @Column(length = 2, nullable = false)
    @NotNull
    @NotEmpty
	private Integer accessType;
	
	
}
