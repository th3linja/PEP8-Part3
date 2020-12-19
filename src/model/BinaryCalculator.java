package model;

public class BinaryCalculator {

    public static final int BASE_TWO = 2;

    /**
     * Method that adds two Binary Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - Added Result
     */
    public static Number add(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TWO);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TWO);
        String number = Integer.toBinaryString(aNum + bNum);
        Number result = new Binary("" +number);
        return result;
    }

    /**
     * Method that subtracts two Binary Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - subtracted Result
     */
    public static Number subtract(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TWO);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TWO);
        String number = Integer.toBinaryString(aNum - bNum);
        Number result = new Binary("" +number);
        return result;
    }

    /**
     * Method that multiplies two Binary Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - multiplied Result
     */
    public static Number multiply(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TWO);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TWO);
        String number = Integer.toBinaryString(aNum * bNum);
        Number result = new Binary("" +number);
        return result;
    }

    /**
     * Method that divides two Binary Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - divided Result
     */
    public static Number divide(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TWO);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TWO);
        String number = Integer.toBinaryString(aNum / bNum);
        Number result = new Binary("" +number);
        return result;
    }

    /**
     * Method that mods two Binary Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - mod Result
     */
    public static Number mod(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_TWO);
        int bNum = Integer.parseInt(b.getNumber(), BASE_TWO);
        String number = Integer.toBinaryString(aNum % bNum);
        Number result = new Binary("" +number);
        return result;
    }
}
