package com.ms.users.DTO;


import java.time.LocalDateTime;

public record UserDTO(String name,
                      String address,
                      String email,
                      String phone,
                      LocalDateTime creationDate) {
}
