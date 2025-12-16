package model;
	public class Installment {
		public int month;
		public double emi, interest, principal, balance;


		public Installment(int m, double e, double i, double p, double b) {
		month = m; emi = e; interest = i; principal = p; balance = b;
		}

	}

