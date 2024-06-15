package com.lygizos.calculator;

public class ResponseContentDto {
    public ResponseContentDto(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseContent{" +
                "result=" + result +
                '}';
    }

    private final Double result;
}
