package day9;

public class AppException extends Exception {
	
//	private String message;
	
	private static final long serialVersionUID = 1L;
	
	public AppException(String msg) {
		super(msg);
	}
}
