package com.api.microservice.microservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String name;
    private String cpf;
    private String typeUser;
}
