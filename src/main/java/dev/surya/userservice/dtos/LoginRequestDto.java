package dev.surya.userservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    @JsonProperty("Email")
    String email;
    @JsonProperty("Password")
    String password ;
}
