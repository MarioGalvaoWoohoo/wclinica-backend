package com.woohoo.wClinica.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.woohoo.wClinica.models.AccessType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccessTypeDTO {
    
    private Long id;
    
    @NotNull
    private String accessName;

}
