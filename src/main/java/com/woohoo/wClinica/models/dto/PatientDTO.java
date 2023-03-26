package com.woohoo.wClinica.models.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    
    private Long id;
    
    @NotNull
    private String name;
	
	@NotNull
    private String document;
	
    @NotNull
    private String typeDocument;
	
    @NotNull
    private Date dateOfBirth;

	private String address;

	private String city;
    
	private String state;
    
}
