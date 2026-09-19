package org.example.lab1_code.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateDataRequest {

    @NotBlank
    @Size(max = 500)
    private String content;

    public CreateDataRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}