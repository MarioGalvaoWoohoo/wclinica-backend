package com.woohoo.wClinica.models;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String crm;
	private String document;
	private String typeDocument;
	private Date dateOfBirth;
	private String address;
	private String city;
	private String state;
	private String specialty;
		
}
