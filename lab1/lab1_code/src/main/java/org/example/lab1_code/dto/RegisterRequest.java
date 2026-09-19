package org.example.lab1_code.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9_.-]{3,32}")
    private String username;

    @NotBlank
    @Size(min = 8, max = 64)
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}