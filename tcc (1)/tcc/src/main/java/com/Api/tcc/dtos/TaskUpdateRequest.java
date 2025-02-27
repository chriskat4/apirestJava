package com.Api.tcc.dtos;

import java.util.List;
import java.util.UUID;

public record TaskUpdateRequest(String task,
                                Boolean done,
                                UUID userID
                                ) {

}
