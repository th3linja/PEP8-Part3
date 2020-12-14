package model;

public class Branch extends Instruction {

    public Branch(String opCode, String registerSpec, String addressingMode, String operand) {
        super(opCode, registerSpec, addressingMode, operand);
    }

    @Override
    public void execute(ControlUnit controlUnit) throws InterruptedException {
        switch (getOpcode()) {
            case "0000010":
                executeBR(controlUnit);
                break;
            case "0000011":
                executeBRLE(controlUnit);
                break;
            case "0000100":
                executeBRLT(controlUnit);
                break;
            case "0000101":
                executeBREQ(controlUnit);
                break;
            case "0000110":
                executeBRNE(controlUnit);
                break;
            case "0000111":
                executeBRGE(controlUnit);
                break;
            case "0001000":
                executeBRGT(controlUnit);
                break;
        }
    }

    /**
     * Branch unconditionally.
     *
     * @param controlUnit
     */
    private void executeBR(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        controlUnit.setPC(addrInt);
    }

    /**
     * Branch if less-than-or-equal.
     *
     * @param controlUnit
     */
    private void executeBRLE(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        if (controlUnit.getAR() <= addrInt) {
            controlUnit.setPC(addrInt);
        }
    }

    /**
     * Branch if less-than.
     *
     * @param controlUnit
     */
    private void executeBRLT(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        if (controlUnit.getAR() < addrInt) {
            controlUnit.setPC(addrInt);
        }
    }

    /**
     * Branch if equal to.
     *
     * @param controlUnit
     */
    private void executeBREQ(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        if (controlUnit.getAR() == addrInt) {
            controlUnit.setPC(addrInt);
        }
    }

    /**
     * Branch if not equal to.
     *
     * @param controlUnit
     */
    private void executeBRNE(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        if (controlUnit.getAR() != addrInt) {
            controlUnit.setPC(addrInt);
        }
    }

    /**
     * Branch if greater-than-or-equal.
     *
     * @param controlUnit
     */
    private void executeBRGE(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        if (controlUnit.getAR() >= addrInt) {
            controlUnit.setPC(addrInt);
        }
    }

    /**
     * Branch if greater-than.
     *
     * @param controlUnit
     */
    private void executeBRGT(ControlUnit controlUnit) {
        int addrInt = Integer.parseInt(getOperand(), 2);
        if (controlUnit.getAR() > addrInt) {
            controlUnit.setPC(addrInt);
        }
    }
}
