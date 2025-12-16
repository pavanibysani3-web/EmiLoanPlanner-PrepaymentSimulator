package loan;

import model.*;
import Policy.*;
import service.*;


import java.util.*;


public class HomeLoan extends Loan {
public HomeLoan(double p, double r, int m, RatePolicy rp) {
super(p, r, m, rp);
}


@Override
public List<Installment> generateSchedule(List<Prepayment> prepayments) {
return AmortizationService.coreSchedule(principal, annualRate, months, ratePolicy, prepayments);
}
}