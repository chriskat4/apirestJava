package com.Api.tcc.dtos;

public record UserDto(
                        Long id,
                        String email,
                        String name,
                        String password,
                        String tasks
                        ) {

}
