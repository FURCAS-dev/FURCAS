package com.sap.runlet.abstractinterpreter.util;

import java.util.Date;

/**
 * A date subclass that uses nanosecond resolution for the internal timestamp so as
 * to provide better comparison resolution than {@link java.util.Date}.
 * 
 * @author Axel Uhl (D043530)
 */
public class NanoDate extends Date {
    private static final long serialVersionUID = -2683539606714238004L;
    private long nanos;
    
    public NanoDate() {
	super();
	this.nanos = System.nanoTime();
    }
    
    public NanoDate(long nanoTimestamp) {
	this.nanos = nanoTimestamp;
	setTime(0);
    }

    @Override
    public boolean before(Date date) {
	if (date instanceof NanoDate) {
	    return getNanos() < ((NanoDate) date).getNanos();
	} else {
	    return super.before(date);
	}
    }

    @Override
    public boolean after(Date date) {
	if (date instanceof NanoDate) {
	    return getNanos() > ((NanoDate) date).getNanos();
	} else {
	    return super.after(date);
	}
    }
    
    @Override
    public boolean equals(Object date) {
	if (date instanceof NanoDate) {
	    return getNanos() == ((NanoDate) date).getNanos();
	} else {
	    return super.equals(date);
	}
    }
    
    @Override
    public String toString() {
	return super.toString()+"@"+nanos;
    }
    
    public long getNanos() {
	return nanos;
    }
}
