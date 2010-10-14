package com.sap.runlet.interpreter.test;

import junit.framework.TestCase;

public class FractionPerformanceTest extends TestCase {
    private long lastTimestamp;
    private int TIMES = 100000000;
    
    @Override
    public void setUp() {
	startTimer();
    }
    
    /*
    public void testAddInts() {
	Fraction[] numbers = new Fraction[TIMES];
	for (int i=0; i<TIMES; i++) {
	    numbers[i] = new Fraction(i);
	}
	printLap("Creating "+TIMES+" Fraction objects");
	Fraction sum = new Fraction(0);
	for (int i=0; i<TIMES; i++) {
	    sum = sum.plus(numbers[i]);
	}
	printLap("Adding "+TIMES+" Fraction objects that were all integers, result "+sum);
    }
    */
    
    public void testLongAdditions() {
	long[] numbers = new long[TIMES];
	for (int i=0; i<TIMES; i++) {
	    numbers[i] = i;
	}
	printLap("Creating "+TIMES+" long values");
	long sum = 0;
	for (int i=0; i<TIMES; i++) {
	    sum = sum + numbers[i];
	}
	printLap("Adding "+TIMES+" long values, result "+sum);
    }
    
    public void testIntAdditionsWithPotentialOverflow() {
	int[] numbers = new int[TIMES];
	for (int i=0; i<TIMES; i++) {
	    numbers[i] = i;
	}
	printLap("Creating "+TIMES+" int values");
	int sum = 0;
	for (int i=0; i<TIMES; i++) {
	    sum = sum + numbers[i];
	}
	printLap("Adding "+TIMES+" int values, result "+sum);
    }
    
    public void testIntAdditionsInLong() {
	int[] numbers = new int[TIMES];
	for (int i=0; i<TIMES; i++) {
	    numbers[i] = i;
	}
	printLap("Creating "+TIMES+" int values");
	long sum = 0;
	for (int i=0; i<TIMES; i++) {
	    sum = sum + numbers[i];
	}
	printLap("Adding "+TIMES+" int values into a long, result "+sum);
    }
    
    private void startTimer() {
	lastTimestamp = System.currentTimeMillis();
    }
    
    private void printLap(String whatTookSoLong) {
	long now = System.currentTimeMillis();
	long lap = now-lastTimestamp;
	System.out.println(whatTookSoLong+" took "+lap+"ms");
	lastTimestamp = System.currentTimeMillis();
    }
}
