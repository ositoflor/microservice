package com.api.microservice.microservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String email;
    private String name;
    private String cpf;
    private String typeUser;
}
