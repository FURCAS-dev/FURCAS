/**
 * 
 */
package com.sap.runlet.abstractinterpreter;

public enum Side {
    LEFT(0), RIGHT(1);

    private int endNumber;

    private Side(int endNumber) {
	this.endNumber = endNumber;
    }

    public int endNumber() {
	return endNumber;
    }

    public Side otherEnd() {
	if (this == LEFT) {
	    return RIGHT;
	} else {
	    return LEFT;
	}
    }

    public int otherEndNumber() {
	return values().length - 1 - endNumber();
    }
}