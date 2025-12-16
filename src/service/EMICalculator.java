package service;

	public class EMICalculator {
		public static double emi(double p, double r, int n) {
			return p * r * Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1);
			}
	}
