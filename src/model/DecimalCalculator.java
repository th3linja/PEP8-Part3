package model;

public class DecimalCalculator {
    public static final int BASE_TEN = 10;

    /**
     * Method that adds two Decimal Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - Added Result
     */
    public static Number add(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TEN);
        String number = "" +(aNum + bNum);
        Number result = new Decimal("" +number);
        return result;
    }

    /**
     * Method that subtracts two Decimal Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - subtracted Result
     */
    public static Number subtract(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TEN);
        String number = "" +(aNum - bNum);
        Number result = new Decimal("" +number);
        return result;
    }

    /**
     * Method that multiplies two Decimal Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - multiplied Result
     */
    public static Number multiply(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TEN);
        String number = "" +(aNum * bNum);
        Number result = new Decimal("" +number);
        return result;
    }

    /**
     * Method that divides two Decimal Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - divided Result
     */
    public static Number divide(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TEN);
        String number = "" +(aNum / bNum);
        Number result = new Decimal("" +number);
        return result;
    }

    /**
     * Method that mods two Decimal Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - mod Result
     */
    public static Number mod(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TEN);
        String number = "" +(aNum % bNum);
        Number result = new Decimal("" +number);
        return result;
    }
}
