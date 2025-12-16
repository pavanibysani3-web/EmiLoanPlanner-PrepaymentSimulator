package io;
	import model.*;
	import service.*;
	import java.io.*;
	import java.util.*;


	public class SavingsWriter {
	        public void write(List<Installment> noPrepay, List<Installment> prepay) throws Exception {
	            double i1 = SavingsCalculator.totalInterest(noPrepay);
	            double i2 = SavingsCalculator.totalInterest(prepay);


	              PrintWriter pw = new PrintWriter("savings.txt");
	              pw.println("Total Interest without Prepayment : " + i1);
	              pw.println("Total Interest with Prepayment : " + i2);
	              pw.println("Interest Saved : " + (i1 - i2));
	              pw.close();
	    }
	}

