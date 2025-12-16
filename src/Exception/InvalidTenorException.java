package Exception;

	public class InvalidTenorException extends RuntimeException {

	    public InvalidTenorException() {
	        super("Invalid loan tenor");
	    }
	}

