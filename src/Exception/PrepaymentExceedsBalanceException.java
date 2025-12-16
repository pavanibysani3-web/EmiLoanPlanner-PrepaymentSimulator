package Exception;

public class PrepaymentExceedsBalanceException extends RuntimeException {
	    public PrepaymentExceedsBalanceException() {
	        super("Prepayment exceeds balance");
	    }
	}

