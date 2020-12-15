package model;

public class Binary extends Number {

	/** @param number - String value that initializes the number field. */
	public Binary(String number) {
		super(number);
	}

	/**
	 * @param other - the number we are comparing to 'this' number.
	 * @return negative if 'this' number is less than 'other' number.
	 * @return positive if 'this' number is greater than 'other' number.
	 * @return zero if 'this' number is equal to 'other' number.
	 */
	@Override
	public int compare(Object other) {
		Binary otherBinary = (Binary) other;
		return Integer.parseInt(number, 2) - Integer.parseInt(otherBinary.getNumber(), 2);
	}
}
