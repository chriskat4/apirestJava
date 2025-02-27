package com.Api.tcc.dtos;

import java.util.List;
import java.util.UUID;


public record TaskDto(
                    List<String> tasks,
                    Boolean done,
                    UUID userID
                    ) {

}
