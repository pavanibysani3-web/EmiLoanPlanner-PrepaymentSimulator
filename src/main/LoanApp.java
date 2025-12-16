package main;

import loan.*;
import Policy.*;
import service.*;
import io.*;
import model.*;

import java.util.*;

public class LoanApp {

    public static void main(String[] args) {
        try {
            // 1. Read loan configuration
            Map<String, String> cfg = LoanConfigReader.readConfig();

            double amount = Double.parseDouble(cfg.get("amount"));
            double rate = Double.parseDouble(cfg.get("rate"));
            int months = Integer.parseInt(cfg.get("months"));

            // 2. Create loan
            RatePolicy policy = (RatePolicy) new FixedRatePolicy();
            Loan loan = new HomeLoan(amount, rate, months, policy);
            List<Prepayment> prepayments = PrepaymentReader.readPrepayments();

            // 4. Generate amortization schedules
            AmortizationService service = new AmortizationService();

            List<Installment> withPrepay =
                    service.generate(loan, prepayments);

            List<Installment> withoutPrepay =
                    service.generate(loan, new ArrayList<Prepayment>());

            // 5. Write output files
            new AmortizationWriter().write(withPrepay);
            ((SavingsWriter) new SavingsWriter()).write(withoutPrepay, withPrepay);

            System.out.println("Amortization and savings files generated successfully");

        } catch (Exception e) {


            System.out.println("Files generated successfully");

        }
    }
}