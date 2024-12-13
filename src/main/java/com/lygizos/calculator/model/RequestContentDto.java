package com.lygizos.calculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record RequestContentDto(
        // first digit
        @NotNull(message = "first_number field is mandatory")
        @JsonProperty("first_number")
        double x,
        // second digit
        @NotNull(message = "second_number field is mandatory")
        @JsonProperty("second_number")
        double y
) {
}
