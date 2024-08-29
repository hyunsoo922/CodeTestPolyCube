package kr.co.polycube.backendtest;

import jakarta.persistence.Column;

import java.util.Set;

public class LottoResponse {
    private Integer[] numbers;

    public LottoResponse(Integer[] numbers) {
        this.numbers = numbers;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer[] numbers) {
        this.numbers = numbers;
    }
}
