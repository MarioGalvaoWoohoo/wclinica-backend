package com.woohoo.wClinica.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
@Data
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 10, nullable = false, unique = true)
	private String crm;

	@Column(length = 30, nullable = false)
	private String document;

	@Column(name = "type_document", length = 40, nullable = false)
	private String typeDocument;

	@Column(length = 50, nullable = false)
	private String specialty;

	@ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;

	@CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
		
}
