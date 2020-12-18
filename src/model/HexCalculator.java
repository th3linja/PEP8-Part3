package model;

public class HexCalculator {
    public static final int BASE_SIXTEEN = 16;

    /**
     * Method that adds two Hex Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - Added Result
     */
    public static Number add(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_SIXTEEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_SIXTEEN);
        String number = Integer.toHexString(aNum + bNum);
        Number result = new Hexadecimal("" +number);
        return result;
    }

    /**
     * Method that subtracts two Hex Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - subtracted Result
     */
    public static Number subtract(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_SIXTEEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_SIXTEEN);
        String number = Integer.toHexString(aNum - bNum);
        Number result = new Hexadecimal("" +number);
        return result;
    }

    /**
     * Method that multiplies two Hex Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - multiplied Result
     */
    public static Number multiply(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_SIXTEEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_SIXTEEN);
        String number = Integer.toHexString(aNum * bNum);
        Number result = new Hexadecimal("" +number);
        return result;
    }

    /**
     * Method that divides two Hex Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - divided Result
     */
    public static Number divide(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_SIXTEEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_SIXTEEN);
        String number = Integer.toHexString(aNum / bNum);
        Number result = new Hexadecimal("" +number);
        return result;
    }

    /**
     * Method that mods two Hex Numbers
     * @param a - First Number
     * @param b - Second Number
     * @return - mod Result
     */
    public static Number mod(Number a, Number b) {
        int aNum = Integer.parseInt(a.getNumber(), BASE_SIXTEEN);
        int bNum = Integer.parseInt(b.getNumber(), BASE_SIXTEEN);
        String number = Integer.toHexString(aNum % bNum);
        Number result = new Hexadecimal("" +number);
        return result;
    }
}
