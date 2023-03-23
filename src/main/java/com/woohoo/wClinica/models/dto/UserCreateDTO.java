package com.woohoo.wClinica.models.dto;

import javax.validation.constraints.NotNull;

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

}
