package service;

import model.*;
import Policy.*;
import Exception.*;
import loan.Loan;

import java.util.*;

public class AmortizationService {

    // ✅ THIS METHOD WAS MISSING
    public List<Installment> generate(Loan loan, List<Prepayment> prepayments) {
        return loan.generateSchedule(prepayments);
    }
    public static List<Installment> coreSchedule(
            double principal,
            double annualRate,
            int months,
            RatePolicy policy,
            List<Prepayment> prepayments) {

        List<Installment> list = new ArrayList<>();
        double balance = principal;
        double r = policy.monthlyRate(annualRate);
        double emi = EMICalculator.emi(principal, r, months);

        for (int m = 1; m <= months && balance > 0; m++) {
            double interest = balance * r;
            double principalPaid = emi - interest;
            balance -= principalPaid;

            for (Prepayment p : prepayments) {
                if (p.month == m) {
                    if (p.amount > balance)
                        throw new PrepaymentExceedsBalanceException();
                    balance -= p.amount;
                }
            }

            list.add(new Installment(
                    m, emi, interest, principalPaid, Math.max(balance, 0)));
        }
        return list;
    }
}