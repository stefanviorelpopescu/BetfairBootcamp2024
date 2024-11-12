package org.example.design_patterns.src.main.java.code._4_student_effort;

import java.util.Map;

public class BanknoteHandler {

    private final Banknote banknote;
    private BanknoteHandler nextHandler;

    public BanknoteHandler(Banknote banknote) {
        this.banknote = banknote;
    }

    public BanknoteHandler andThen(BanknoteHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public Map<Banknote, Integer> handle(Integer sumOfMoney, Map<Banknote, Integer> partialResult) throws CannotWithdrawSumException {

        int banknoteValue = banknote.getValue();

        //can handle
        if (sumOfMoney < banknoteValue) {
            return nextHandler.handle(sumOfMoney, partialResult);
        }

        //process
        int noOfBills = sumOfMoney / banknoteValue;
        sumOfMoney = sumOfMoney % banknoteValue;
        partialResult.put(banknote, noOfBills);

        //pass on
        if (sumOfMoney == 0) {
            return partialResult;
        }
        if (nextHandler == null) {
            throw new CannotWithdrawSumException("Cannot withdraw!");
        }
        return nextHandler.handle(sumOfMoney, partialResult);

    }

}
