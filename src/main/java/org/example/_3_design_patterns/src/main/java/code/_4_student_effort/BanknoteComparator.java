package org.example._3_design_patterns.src.main.java.code._4_student_effort;

import java.util.Comparator;

public class BanknoteComparator implements Comparator<Banknote> {
    @Override
    public int compare(Banknote o1, Banknote o2) {
        return o1.getValue() - o2.getValue();
    }
}
