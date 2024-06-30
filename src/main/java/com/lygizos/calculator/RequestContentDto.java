package com.lygizos.calculator;

import com.fasterxml.jackson.annotation.JsonAlias;

public record RequestContentDto(
        // first digit
        @JsonAlias("first_number")
        double x,
        // second digit
        @JsonAlias("second_number")
        double y
) {
}
