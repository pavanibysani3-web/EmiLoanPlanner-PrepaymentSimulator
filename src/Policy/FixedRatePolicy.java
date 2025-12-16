package Policy;

	public class FixedRatePolicy  {
	    public double monthlyRate(double annualRate) {
	         return annualRate / 12 / 100;
	     }
}