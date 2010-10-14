package com.sap.runlet.abstractinterpreter.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 File: Fraction.java

 Originally written by Doug Lea and released into the public domain.
 This may be used for any purposes whatsoever without acknowledgment.
 Thanks for the assistance and support of Sun Microsystems Labs,
 and everyone contributing, testing, and using this code.

 History:
 Date       Who                What
 7Jul1998  dl               Create public version
 11Oct1999 dl               add hashCode
 */

/**
 * An immutable class representing fractions as pairs of longs. Fractions are always maintained in
 * reduced form.
 * 
 * @author Doug Lea
 * @author Axel Uhl (D043530)
 */
public class Fraction implements Cloneable, Comparable<Fraction>, java.io.Serializable {
    private static final long serialVersionUID = -6276838246898440605L;
    public static final Fraction ZERO = new Fraction(0);
    public static final Fraction ONE  = new Fraction(1);
    
    private final BigInteger numerator_;
    private final BigInteger denominator_;

    /** Return the numerator * */
    public final BigInteger numerator() {
	return numerator_;
    }

    /** Return the denominator * */
    public final BigInteger denominator() {
	return denominator_;
    }
    
    public Fraction(int i) {
	this(BigInteger.valueOf(i), BigInteger.ONE);
    }

    public Fraction(long i) {
	this(BigInteger.valueOf(i), BigInteger.ONE);
    }
    
    public Fraction(BigInteger bi) {
	this(bi, BigInteger.ONE);
    }
    
    public Fraction(BigDecimal bd) {
	this(bd.unscaledValue(), BigInteger.TEN.pow(bd.scale()));
    }

    /** Create a Fraction equal in value to num / den * */
    public Fraction(BigInteger num, BigInteger den) {
	// normalize while constructing
	boolean numNonnegative = (num.compareTo(BigInteger.ZERO) >= 0);
	boolean denNonnegative = (den.compareTo(BigInteger.ZERO) >= 0);
	BigInteger a = numNonnegative ? num : num.negate();
	BigInteger b = denNonnegative ? den : den.negate();
	BigInteger g = gcd(a, b);
	numerator_ = (numNonnegative == denNonnegative) ? (a.divide(g)) : (a.negate().divide(g));
	denominator_ = b.divide(g);
    }

    /** Create a Fraction equal in value to num / den * */
    public Fraction(int num, int den) {
	// normalize while constructing
	boolean numNonnegative = (num >= 0);
	boolean denNonnegative = (den >= 0);
	BigInteger a = BigInteger.valueOf(numNonnegative ? num : -num);
	BigInteger b = BigInteger.valueOf(denNonnegative ? den : -den);
	BigInteger g = gcd(a, b);
	numerator_ = (numNonnegative == denNonnegative) ? (a.divide(g)) : (a.negate().divide(g));
	denominator_ = b.divide(g);
    }

    /** Create a fraction with the same value as Fraction f * */
    public Fraction(Fraction f) {
	numerator_ = f.numerator();
	denominator_ = f.denominator();
    }
    
    /**
     * Creates a fraction based on the decimal number. The period "." separates
     * the decimal fraction from the integer value.
     */
    public Fraction(String s) {
	this(new BigDecimal(s));
    }

    public String toString() {
	if (denominator().equals(BigInteger.ONE))
	    return "" + numerator();
	else
	    return numerator() + "/" + denominator();
    }

    public Object clone() {
	return new Fraction(this);
    }

    /** Return the value of the Fraction as a double * */
    public double asDouble() {
	return numerator().doubleValue() / denominator().doubleValue();
    }

    /** Return the value of the Fraction as a float * */
    public float asFloat() {
	return numerator().floatValue() / denominator().floatValue();
    }

    /**
     * Compute the nonnegative greatest common divisor of a and b. (This is needed for normalizing
     * Fractions, but can be useful on its own.)
     */
    public static BigInteger gcd(BigInteger a, BigInteger b) {
	BigInteger x;
	BigInteger y;

	if (a.signum() < 0)
	    a = a.negate();
	if (b.signum() < 0)
	    b = b.negate();

	if (a.compareTo(b) >= 0) {
	    x = a;
	    y = b;
	} else {
	    x = b;
	    y = a;
	}

	while (y.signum() != 0) {
	    BigInteger t = x.mod(y);
	    x = y;
	    y = t;
	}
	return x;
    }

    /** return a Fraction representing the negated value of this Fraction * */
    public Fraction negative() {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	return new Fraction(an.negate(), ad);
    }

    /** return a Fraction representing 1 / this Fraction * */
    public Fraction inverse() {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	return new Fraction(ad, an);
    }

    /** return a Fraction representing this Fraction plus b * */
    public Fraction plus(Fraction b) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = b.numerator();
	BigInteger bd = b.denominator();
	return new Fraction(an.multiply(bd).add(bn.multiply(ad)), ad.multiply(bd));
    }

    /** return a Fraction representing this Fraction plus n * */
    public Fraction plus(BigInteger n) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = n;
	return new Fraction(an.add(bn.multiply(ad)), ad);
    }

    /** return a Fraction representing this Fraction minus b * */
    public Fraction minus(Fraction b) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = b.numerator();
	BigInteger bd = b.denominator();
	return new Fraction(an.multiply(bd).subtract(bn.multiply(ad)), ad.multiply(bd));
    }

    /** return a Fraction representing this Fraction minus n * */
    public Fraction minus(BigInteger n) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = n;
	return new Fraction(an.subtract(bn.multiply(ad)), ad);
    }

    /** return a Fraction representing this Fraction times b * */
    public Fraction times(Fraction b) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = b.numerator();
	BigInteger bd = b.denominator();
	return new Fraction(an.multiply(bn), ad.multiply(bd));
    }

    /** return a Fraction representing this Fraction times n * */
    public Fraction times(BigInteger n) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = n;
	return new Fraction(an.multiply(bn), ad);
    }

    /** return a Fraction representing this Fraction divided by b * */
    public Fraction dividedBy(Fraction b) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = b.numerator();
	BigInteger bd = b.denominator();
	return new Fraction(an.multiply(bd), ad.multiply(bn));
    }

    /** return a Fraction representing this Fraction divided by n * */
    public Fraction dividedBy(BigInteger n) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = n;
	return new Fraction(an, ad.multiply(bn));
    }
    
    /**
     * Returns a fraction that is this fraction raised to the power specified.
     */
    public Fraction pow(int p) {
	BigInteger an = numerator().pow(p);
	BigInteger ad = denominator().pow(p);
	return new Fraction(an, ad);
    }

    /**
     * return a number less, equal, or greater than zero reflecting whether this Fraction is less,
     * equal or greater than the value of Fraction other.
     */
    public int compareTo(Fraction other) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = other.numerator();
	BigInteger bd = other.denominator();
	BigInteger l = an.multiply(bd);
	BigInteger r = bn.multiply(ad);
	return (l.compareTo(r) < 0) ? -1 : ((l.equals(r)) ? 0 : 1);
    }

    /**
     * return a number less, equal, or greater than zero reflecting whether this Fraction is less,
     * equal or greater than n.
     */
    public int compareTo(BigInteger n) {
	BigInteger an = numerator();
	BigInteger ad = denominator();
	BigInteger bn = n;
	BigInteger l = an;
	BigInteger r = bn.multiply(ad);
	return (l.compareTo(r) < 0) ? -1 : ((l.equals(r)) ? 0 : 1);
    }

    public boolean equals(Object other) {
	return compareTo((Fraction) other) == 0;
    }

    public boolean equals(BigInteger n) {
	return compareTo(n) == 0;
    }

    public int hashCode() {
	return (numerator_.hashCode() ^ denominator_.hashCode());
    }

    public int intValue() {
	int result;
	if (denominator().equals(BigInteger.ONE)) {
	    result = numerator().intValue();
	} else {
	    result = numerator().divide(denominator()).intValue();
	}
	return result;
    }

    public long asLong() {
	BigInteger result = numerator_.divide(denominator_);
	return result.longValue();
    }

}
