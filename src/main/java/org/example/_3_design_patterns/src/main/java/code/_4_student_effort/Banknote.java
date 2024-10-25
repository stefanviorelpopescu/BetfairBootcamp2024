package org.example._3_design_patterns.src.main.java.code._4_student_effort;

import lombok.Getter;

@Getter
public enum Banknote{
    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ;

    private final int value;

    Banknote(int value) {
        this.value = value;
    }
}
