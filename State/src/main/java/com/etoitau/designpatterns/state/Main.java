package com.etoitau.designpatterns.state;


class CombinationLock
{
    enum State {
        LOCKED,
        OPEN,
        ATTEMPTING,
        ERROR,
    }

    private int [] combination;
    private String combo;
    public String status;
    public State state;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        comboToString();
        state = State.LOCKED;
        status = "LOCKED";
    }

    public void enterDigit(int digit)
    {
        switch (state) {
            case OPEN:
            case ERROR:
                return;
            case LOCKED:
                state = State.ATTEMPTING;
                status = "" + digit;
                check();
                break;
            case ATTEMPTING:
                status += digit;
                check();
                break;
        }
    }

    private void comboToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combination.length; i++) {
            sb.append(combination[i]);
        }
        combo = sb.toString();
    }

    private void check() {
        if (status.length() == combo.length()) {
            if (status.equals(combo)) {
                state = State.OPEN;
                status = "OPEN";
            } else {
                state = State.ERROR;
                status = "ERROR";
            }
        }
    }
}
