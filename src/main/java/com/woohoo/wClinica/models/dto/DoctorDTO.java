package com.woohoo.wClinica.models.dto;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
    
    private Long id;
    
    @NotNull
    private String name;
	@NotNull
    private String crm;
	@NotNull
    private String document;
	@NotNull
    private String typeDocument;
	@NotNull
    private String specialty;

    
}
