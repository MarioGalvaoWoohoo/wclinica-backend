package com.woohoo.wClinica.models;

import java.util.Date;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String document;
	private String typeDocument;
	private Date dateOfBirth;
	private String address;
	private String city;
	private String state;
	
	// contrutor da class em branco, não obrigando informa-lo.	

}
