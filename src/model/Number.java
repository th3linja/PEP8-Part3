package model;

public class Number {
	/** String representation of 'this' number */
	String number;

	/**
	 * @param number - String value that initializes the number field.
	 */
	public Number(String number) {
		this.number = number;
	}

	/**
	 * @param other - the number we are comparing to 'this' number.
	 * @return negative if 'this' number is less than 'other' number.
	 * @return positive if 'this' number is greater than 'other' number.
	 * @return zero if 'this' number is equal to 'other' number.
	 */
	public int compare(Object other) {
		Number otherNumber = (Number) other;
		return Integer.parseInt(number) - Integer.parseInt(otherNumber.getNumber());
	}

	/**
	 *
	 * @param other - the number we are comparing to 'this' number.
	 * @return true if 'this' number and 'other' number are equal.
	 * @return false if 'this' number and 'other' number are not equal.
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Number)) {
			return false;
		}
		Number theOther = (Number) other;
		return (this.compare(theOther.getNumber()) == 0);
	}

	/**
	 * @return the String representation of 'this' number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param newNumber - replaces String representation of 'this' number to
	 *                  newNumber.
	 */
	public void setNumber(String newNumber) {
		this.number = newNumber;
	}
}
