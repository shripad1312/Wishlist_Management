package com.example.xindus.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString

@Builder
public class AddUserDto {
    private String name;
    private String username;
    private String password;
}
