package loan;

import model.*;
import Policy.*;
import Exception.*;

import java.util.*;

public abstract class Loan {
protected double principal;
protected double annualRate;
protected int months;
protected RatePolicy ratePolicy;


public Loan(double principal, double annualRate, int months, RatePolicy ratePolicy) {
if (months <= 0) throw new InvalidTenorException();
this.principal = principal;
this.annualRate = annualRate;
this.months = months;
this.ratePolicy = ratePolicy;
}


public abstract List<Installment> generateSchedule(List<Prepayment> prepayments);
}