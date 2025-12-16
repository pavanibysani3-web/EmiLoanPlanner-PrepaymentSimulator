package service;

	import model.*;
	import java.util.*;

	public class SavingsCalculator {
	    public static double totalInterest(List<Installment> list) {
	    return list.stream().mapToDouble(i -> i.interest).sum();
	    }
	}
