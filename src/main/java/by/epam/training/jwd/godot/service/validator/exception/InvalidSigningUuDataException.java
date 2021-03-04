package by.epam.training.jwd.godot.service.validator.exception;

public class InvalidSigningUuDataException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidSigningUuDataException() {
		super();
	}

	public InvalidSigningUuDataException(String message) {
		super(message);
	}

	public InvalidSigningUuDataException(Exception e) {
		super(e);
	}

	public InvalidSigningUuDataException(String message, Exception e) {
		super(message, e);
	}

}
