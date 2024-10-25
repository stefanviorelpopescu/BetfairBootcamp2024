package org.example._3_design_patterns.src.main.java.code._4_student_effort;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.example._3_design_patterns.src.main.java.code._4_student_effort.Banknote.*;

public class Atm {

    private final BanknoteHandler banknoteHandler;

    public Atm() {
        this.banknoteHandler = new BanknoteHandler(FIVE_HUNDRED);
        this.banknoteHandler
                .andThen(new BanknoteHandler(TWO_HUNDRED))
                .andThen(new BanknoteHandler(ONE_HUNDRED))
                .andThen(new BanknoteHandler(FIFTY))
                .andThen(new BanknoteHandler(TEN));
    }

    public Map<Banknote, Integer> withdraw(Integer sumToWithdraw) throws CannotWithdrawSumException {
        return banknoteHandler.handle(sumToWithdraw, new TreeMap<>(new BanknoteComparator().reversed()));
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        try {
            System.out.println(atm.withdraw(475).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
