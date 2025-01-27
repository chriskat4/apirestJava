package com.Api.tcc.dtos;

import java.util.UUID;

public record UserDto(
                        UUID id,
                        String email,
                        String name,
                        String password
                        ) {

}
