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
public class UserCreateDTO {
    
    @NotNull
    private String name;

    @NotNull
    private String login;

    @NotNull
    private String password;
    
    @NotNull
    @Email
    private String email;
    
    @NotNull
    private Boolean status;
    
    private Long accessTypeId;
}
