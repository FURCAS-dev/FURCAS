/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.conditions.numbers;

import org.eclipse.emf.query.conditions.Condition;

/**
 * A <code>Condition</code> object that tests for numeric arguments. The
 * arguments being evaluated are adapted to a <code>Number</code> first using
 * a <code>NumberAdapter</code> and then compared to the initialization value
 * of this <code>NumberCondition</code>. It evaluates to <code>true</code>
 * when the values are equal or if the value is within the range of supplied
 * lower-bound and upper-bound
 */

public abstract class NumberCondition
	extends Condition {

	/** The upper bound of a range condition. */
	protected Number upperBound;

	/** The lower bound of a range condition. */
	protected Number lowerBound;

	/**
	 * Adapts elements to numbers (usually according to some numeric
	 * {@link org.eclipse.emf.ecore.EAttribute}.
	 */
	protected NumberAdapter adapter;

	private NumberCondition(Number lowerBound, Number upperBound,
		NumberAdapter adapter) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.adapter = adapter;
	}

	/**
	 * A subclass of <code>NumberCondition</code> to be used to test for
	 * integer values Clients can either use the default implementation supplied
	 * or have their own.
	 */
	public static class IntegerValue
		extends NumberCondition {

		/**
		 * A simple constructor, it takes only one <code>Integer</code>
		 * argument which means in its evaluation the values passed to it must
		 * be equal to this <code>Integer</code> value passed. It defaults to
		 * using the NumberAdapter.IntegerAdapter.DEFAULT for adapting the
		 * objects being evaluated to an integer value.
		 * 
		 * @param number
		 *            the <code>Integer</code> object to use for equality
		 *            testing
		 */
		public IntegerValue(Integer number) {
			this(number, NumberAdapter.IntegerAdapter.DEFAULT);
		}

		/**
		 * A simple constructor, it takes only one <code>Integer</code>
		 * argument which means in its evaluation the values passed to it must
		 * be equal to this <code>Integer</code> value passed.
		 * 
		 * @param number
		 *            the <code>Integer</code> object to use for equality
		 *            testing
		 * @param adapter
		 *            the <code>NumberAdapter.IntegerAdapter</code> to use to
		 *            extract integer values from objects being evaluated.
		 */
		public IntegerValue(Integer number, NumberAdapter.IntegerAdapter adapter) {
			this(number, number, adapter);
		}

		/**
		 * A constructor, it takes two <code>Integer</code> arguments, a
		 * lowerBound and an upperBound, which means in its evaluation the
		 * values passed to it must be equal to any these two
		 * <code>Integer</code> values passed or fall in between. It defaults
		 * to using the NumberAdapter.IntegerAdapter.DEFAULT for adapting the
		 * objects being evaluated to an integer value.
		 * 
		 * @param lowerBound
		 *            the <code>Integer</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Integer</code> value representing the
		 *            upper-bound in range testing
		 */
		public IntegerValue(Integer lowerBound, Integer upperBound) {
			this(lowerBound, upperBound, NumberAdapter.IntegerAdapter.DEFAULT);
		}

		/**
		 * A constructor, besides the <code>NumberAdapter.IntegerAdapter</code>,
		 * it also takes two <code>Integer</code> arguments, a lowerBound and
		 * an upperBound, which means in its evaluation the values passed to it
		 * must be equal to any these two <code>Integer</code> values passed
		 * or fall in between.
		 * 
		 * @param lowerBound
		 *            the <code>Integer</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Integer</code> value representing the
		 *            upper-bound in range testing
		 * @param adapter
		 *            the <code>NumberAdapter.IntegerAdapter</code> to use to
		 *            extract integer values from objects being evaluated.
		 */
		public IntegerValue(Integer lowerBound, Integer upperBound,
			NumberAdapter.IntegerAdapter adapter) {
			super(lowerBound, upperBound, adapter);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
		 */
		public boolean isSatisfied(Object object) {
			return isSatisfied(((NumberAdapter.IntegerAdapter) adapter)
				.intValue(object));
		}

	}

	/**
	 * A subclass of <code>NumberCondition</code> to be used to test for byte
	 * values Clients can either use the default implementation supplied or have
	 * their own.
	 */
	public static class ByteValue
		extends NumberCondition {

		/**
		 * A simple constructor, it takes only one <code>Byte</code> argument
		 * which means in its evaluation the values passed to it must be equal
		 * to this <code>Byte</code> value passed. It defaults to using the
		 * NumberAdapter.ByteAdapter.DEFAULT for adapting the objects being
		 * evaluated to a byte value.
		 * 
		 * @param number
		 *            the <code>Byte</code> object to use for equality testing
		 */
		public ByteValue(Byte number) {
			this(number, NumberAdapter.ByteAdapter.DEFAULT);
		}

		/**
		 * A simple constructor, it takes only one <code>Byte</code> argument
		 * which means in its evaluation the values passed to it must be equal
		 * to this <code>Byte</code> value passed.
		 * 
		 * @param number
		 *            the <code>Byte</code> object to use for equality testing
		 * @param adapter
		 *            the <code>NumberAdapter.ByteAdapter</code> to use to
		 *            extract byte values from objects being evaluated.
		 */
		public ByteValue(Byte number, NumberAdapter.ByteAdapter adapter) {
			this(number, number, adapter);
		}

		/**
		 * A constructor, it takes two <code>Byte</code> arguments, a
		 * lowerBound and an upperBound, which means in its evaluation the
		 * values passed to it must be equal to any these two <code>Byte</code>
		 * values passed or fall in between. It defaults to using the
		 * NumberAdapter.ByteAdapter.DEFAULT for adapting the objects being
		 * evaluated to a byte value.
		 * 
		 * @param lowerBound
		 *            the <code>Byte</code> value representing the lower-bound
		 *            in range testing
		 * @param upperBound
		 *            the <code>Byte</code> value representing the upper-bound
		 *            in range testing
		 */
		public ByteValue(Byte lowerBound, Byte upperBound) {
			this(lowerBound, upperBound, NumberAdapter.ByteAdapter.DEFAULT);
		}

		/**
		 * A constructor, besides the <code>NumberAdapter.ByteAdapter</code>,
		 * it also takes two <code>Byte</code> arguments, a lowerBound and an
		 * upperBound, which means in its evaluation the values passed to it
		 * must be equal to any these two <code>Byte</code> values passed or
		 * fall in between.
		 * 
		 * @param lowerBound
		 *            the <code>Byte</code> value representing the lower-bound
		 *            in range testing
		 * @param upperBound
		 *            the <code>Byte</code> value representing the upper-bound
		 *            in range testing
		 * @param adapter
		 *            the <code>NumberAdapter.ByteAdapter</code> to use to
		 *            extract byte values from objects being evaluated.
		 */
		public ByteValue(Byte lowerBound, Byte upperBound,
			NumberAdapter.ByteAdapter adapter) {
			super(lowerBound, upperBound, adapter);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
		 */
		public boolean isSatisfied(Object object) {
			return isSatisfied(((NumberAdapter.ByteAdapter) adapter)
				.byteValue(object));
		}
	}

	/**
	 * A subclass of <code>NumberCondition</code> to be used to test for
	 * double values Clients can either use the default implementation supplied
	 * or have their own.
	 */
	public static class DoubleValue
		extends NumberCondition {

		/**
		 * A simple constructor, it takes only one <code>Double</code>
		 * argument which means in its evaluation the values passed to it must
		 * be equal to this <code>Double</code> value passed. It defaults to
		 * using the NumberAdapter.DoubleAdapter.DEFAULT for adapting the
		 * objects being evaluated to a double value.
		 * 
		 * @param number
		 *            the <code>Double</code> object to use for equality
		 *            testing
		 */
		public DoubleValue(Double number) {
			this(number, NumberAdapter.DoubleAdapter.DEFAULT);
		}

		/**
		 * A simple constructor, it takes only one <code>Double</code>
		 * argument which means in its evaluation the values passed to it must
		 * be equal to this <code>Double</code> value passed.
		 * 
		 * @param number
		 *            the <code>Double</code> object to use for equality
		 *            testing
		 * @param adapter
		 *            the <code>NumberAdapter.DoubleAdapter</code> to use to
		 *            extract double values from objects being evaluated.
		 */
		public DoubleValue(Double number, NumberAdapter.DoubleAdapter adapter) {
			this(number, number, adapter);
		}

		/**
		 * A constructor, it takes two <code>Double</code> arguments, a
		 * lowerBound and an upperBound, which means in its evaluation the
		 * values passed to it must be equal to any these two
		 * <code>Double</code> values passed or fall in between. It defaults
		 * to using the NumberAdapter.DoubleAdapter.DEFAULT for adapting the
		 * objects being evaluated to a double value.
		 * 
		 * @param lowerBound
		 *            the <code>Double</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Double</code> value representing the
		 *            upper-bound in range testing
		 */
		public DoubleValue(Double lowerBound, Double upperBound) {
			this(lowerBound, upperBound, NumberAdapter.DoubleAdapter.DEFAULT);
		}

		/**
		 * A constructor, besides the <code>NumberAdapter.DoubleAdapter</code>,
		 * it also takes two <code>Double</code> arguments, a lowerBound and
		 * an upperBound, which means in its evaluation the values passed to it
		 * must be equal to any these two <code>Double</code> values passed or
		 * fall in between.
		 * 
		 * @param lowerBound
		 *            the <code>Double</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Double</code> value representing the
		 *            upper-bound in range testing
		 * @param adapter
		 *            the <code>NumberAdapter.DoubleAdapter</code> to use to
		 *            extract double values from objects being evaluated.
		 */
		public DoubleValue(Double lowerBound, Double upperBound,
			NumberAdapter.DoubleAdapter adapter) {
			super(lowerBound, upperBound, adapter);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
		 */
		public boolean isSatisfied(Object object) {
			return isSatisfied(((NumberAdapter.DoubleAdapter) adapter)
				.doubleValue(object));
		}
	}

	/**
	 * A subclass of <code>NumberCondition</code> to be used to test for float
	 * values Clients can either use the default implementation supplied or have
	 * their own.
	 */
	public static class FloatValue
		extends NumberCondition {

		/**
		 * A simple constructor, it takes only one Float argument which means in
		 * its evaluation the values passed to it must be equal to this Float
		 * value passed. It defaults to using the
		 * NumberAdapter.FloatAdapter.DEFAULT for adapting the objects being
		 * evaluated to a float value.
		 * 
		 * @param number
		 *            the <code>Float</code> object to use for equality
		 *            testing
		 */
		public FloatValue(Float number) {
			this(number, NumberAdapter.FloatAdapter.DEFAULT);
		}

		/**
		 * A simple constructor, it takes only one <code>Float</code> argument
		 * which means in its evaluation the values passed to it must be equal
		 * to this <code>Float</code> value passed.
		 * 
		 * @param number
		 *            the <code>Float</code> object to use for equality
		 *            testing
		 * @param adapter
		 *            the <code>NumberAdapter.FloatAdapter</code> to use to
		 *            extract float values from objects being evaluated.
		 */
		public FloatValue(Float number, NumberAdapter.FloatAdapter adapter) {
			this(number, number, adapter);
		}

		/**
		 * A constructor, it takes two <code>Float</code> arguments, a
		 * lowerBound and an upperBound, which means in its evaluation the
		 * values passed to it must be equal to any these two <code>Float</code>
		 * values passed or fall in between. It defaults to using the
		 * NumberAdapter.FloatAdapter.DEFAULT for adapting the objects being
		 * evaluated to a float value.
		 * 
		 * @param lowerBound
		 *            the <code>Float</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Float</code> value representing the
		 *            upper-bound in range testing
		 */
		public FloatValue(Float lowerBound, Float upperBound) {
			this(lowerBound, upperBound, NumberAdapter.FloatAdapter.DEFAULT);
		}

		/**
		 * A constructor, besides the <code>NumberAdapter.FloatAdapter</code>,
		 * it also it takes two <code>Float</code> arguments, a lowerBound and
		 * an upperBound, which means in its evaluation the values passed to it
		 * must be equal to any these two <code>Float</code> values passed or
		 * fall in between.
		 * 
		 * @param lowerBound
		 *            the <code>Float</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Float</code> value representing the
		 *            upper-bound in range testing
		 * @param adapter
		 *            the <code>NumberAdapter.FloatAdapter</code> to use to
		 *            extract float values from objects being evaluated.
		 */
		public FloatValue(Float lowerBound, Float upperBound,
			NumberAdapter.FloatAdapter adapter) {
			super(lowerBound, upperBound, adapter);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
		 */
		public boolean isSatisfied(Object object) {
			return isSatisfied(((NumberAdapter.FloatAdapter) adapter)
				.floatValue(object));
		}
	}

	/**
	 * A subclass of <code>NumberCondition</code> to be used to test for long
	 * values Clients can either use the default implementation supplied or have
	 * their own.
	 */
	public static class LongValue
		extends NumberCondition {

		/**
		 * A simple constructor, it takes only one Long argument which means in
		 * its evaluation the values passed to it must be equal to this Long
		 * value passed. It defaults to using the
		 * NumberAdapter.LongAdapter.DEFAULT for adapting the objects being
		 * evaluated to a long value.
		 * 
		 * @param number
		 *            the <code>Long</code> object to use for equality testing
		 */
		public LongValue(Long number) {
			this(number, NumberAdapter.LongAdapter.DEFAULT);
		}

		/**
		 * A simple constructor, it takes only one <code>Long</code> argument
		 * which means in its evaluation the values passed to it must be equal
		 * to this <code>Long</code> value passed.
		 * 
		 * @param number
		 *            the <code>Long</code> object to use for equality testing
		 * @param adapter
		 *            the <code>NumberAdapter.LongAdapter</code> to use to
		 *            extract long values from objects being evaluated.
		 */
		public LongValue(Long number, NumberAdapter.LongAdapter adapter) {
			this(number, number, adapter);
		}

		/**
		 * A constructor, it takes two <code>Long</code> arguments, a
		 * lowerBound and an upperBound, which means in its evaluation the
		 * values passed to it must be equal to any these two <code>Long</code>
		 * values passed or fall in between. It defaults to using the
		 * NumberAdapter.LongAdapter.DEFAULT for adapting the objects being
		 * evaluated to a long value.
		 * 
		 * @param lowerBound
		 *            the <code>Long</code> value representing the lower-bound
		 *            in range testing
		 * @param upperBound
		 *            the <code>Long</code> value representing the upper-bound
		 *            in range testing
		 */
		public LongValue(Long lowerBound, Long upperBound) {
			this(lowerBound, upperBound, NumberAdapter.LongAdapter.DEFAULT);
		}

		/**
		 * A constructor, besides the <code>NumberAdapter.LongAdapter</code>,
		 * it also takes two <code>Long</code> arguments, a lowerBound and an
		 * upperBound, which means in its evaluation the values passed to it
		 * must be equal to any these two <code>Long</code> values passed or
		 * fall in between.
		 * 
		 * @param lowerBound
		 *            the <code>Long</code> value representing the lower-bound
		 *            in range testing
		 * @param upperBound
		 *            the <code>Long</code> value representing the upper-bound
		 *            in range testing
		 * @param adapter
		 *            the <code>NumberAdapter.LongAdapter</code> to use to
		 *            extract long values from objects being evaluated.
		 */
		public LongValue(Long lowerBound, Long upperBound,
			NumberAdapter.LongAdapter adapter) {
			super(lowerBound, upperBound, adapter);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
		 */
		public boolean isSatisfied(Object object) {
			return isSatisfied(((NumberAdapter.LongAdapter) adapter)
				.longValue(object));
		}
	}

	/**
	 * A subclass of <code>NumberCondition</code> to be used to test for short
	 * values Clients can either use the default implementation supplied or have
	 * their own.
	 */
	public static class ShortValue
		extends NumberCondition {

		/**
		 * A simple constructor, it takes only one Short argument which means in
		 * its evaluation the values passed to it must be equal to this Short
		 * value passed. It defaults to using the
		 * NumberAdapter.ShortAdapter.DEFAULT for adapting the objects being
		 * evaluated to a short value.
		 * 
		 * @param number
		 *            the Short object to use for equality testing
		 */
		public ShortValue(Short number) {
			this(number, NumberAdapter.ShortAdapter.DEFAULT);
		}

		/**
		 * A simple constructor, it takes only one <code>Short</code> argument
		 * which means in its evaluation the values passed to it must be equal
		 * to this <code>Short</code> value passed.
		 * 
		 * @param number
		 *            the <code>Short</code> object to use for equality
		 *            testing
		 * @param adapter
		 *            the <code>NumberAdapter.ShortAdapter</code> to use to
		 *            extract short values from objects being evaluated.
		 */
		public ShortValue(Short number, NumberAdapter.ShortAdapter adapter) {
			this(number, number, adapter);
		}

		/**
		 * A constructor, it takes two <code>Short</code> arguments, a
		 * lowerBound and an upperBound, which means in its evaluation the
		 * values passed to it must be equal to any these two <code>Short</code>
		 * values passed or fall in between. It defaults to using the
		 * NumberAdapter.ShortAdapter.DEFAULT for adapting the objects being
		 * evaluated to a short value.
		 * 
		 * @param lowerBound
		 *            the <code>Short</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Short</code> value representing the
		 *            upper-bound in range testing
		 */
		public ShortValue(Short lowerBound, Short upperBound) {
			this(lowerBound, upperBound, NumberAdapter.ShortAdapter.DEFAULT);
		}

		/**
		 * A constructor, besides the <code>NumberAdapter.ShortAdapter</code>,
		 * it also takes two <code>Short</code> arguments, a lowerBound and an
		 * upperBound, which means in its evaluation the values passed to it
		 * must be equal to any these two <code>Short</code> values passed or
		 * fall in between.
		 * 
		 * @param lowerBound
		 *            the <code>Short</code> value representing the
		 *            lower-bound in range testing
		 * @param upperBound
		 *            the <code>Short</code> value representing the
		 *            upper-bound in range testing
		 * @param adapter
		 *            the <code>NumberAdapter.ShortAdapter</code> to use to
		 *            extract short values from objects being evaluated.
		 */
		public ShortValue(Short lowerBound, Short upperBound,
			NumberAdapter.ShortAdapter adapter) {
			super(lowerBound, upperBound, adapter);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
		 */
		public boolean isSatisfied(Object object) {
			return isSatisfied(((NumberAdapter.ShortAdapter) adapter)
				.shortValue(object));
		}
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param byteNumber
	 *            The <code>Byte</code> object whose value will be used in
	 *            testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(Byte byteNumber) {
		return isSatisfied(byteNumber.byteValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param byteValue
	 *            The byte value which will be used in testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(byte byteValue) {
		return (byteValue >= lowerBound.byteValue())
			&& (byteValue <= upperBound.byteValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param doubleNumber
	 *            The <code>Double</code> object whose value will be used in
	 *            testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(Double doubleNumber) {
		return isSatisfied(doubleNumber.doubleValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param doubleValue
	 *            The double value which will be used in testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(double doubleValue) {
		return (doubleValue >= lowerBound.doubleValue())
			&& (doubleValue <= upperBound.doubleValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param floatNumber
	 *            The <code>Float</code> object whose value will be used in
	 *            testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(Float floatNumber) {
		return isSatisfied(floatNumber.floatValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param floatValue
	 *            The float value which will be used in testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(float floatValue) {
		return (floatValue >= lowerBound.floatValue())
			&& (floatValue <= upperBound.floatValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param intNumber
	 *            The <code>Integer</code> object whose value will be used in
	 *            testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(Integer intNumber) {
		return isSatisfied(intNumber.intValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param intValue
	 *            The int value which will be used in testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(int intValue) {
		return (intValue >= lowerBound.intValue())
			&& (intValue <= upperBound.intValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param longNumber
	 *            The <code>Long</code> object whose value will be used in
	 *            testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(Long longNumber) {
		return isSatisfied(longNumber.longValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param longValue
	 *            The long value which will be used in testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(long longValue) {
		return (longValue >= lowerBound.longValue())
			&& (longValue <= upperBound.longValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param shortNumber
	 *            The <code>Short</code> object whose value will be used in
	 *            testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(Short shortNumber) {
		return isSatisfied(shortNumber.shortValue());
	}

	/**
	 * Tests if the argument's value equals/in-range the initialization
	 * number(s)
	 * 
	 * @param shortValue
	 *            The short value which will be used in testing
	 * @return true if values are equal/in-range, false otherwise
	 */
	public boolean isSatisfied(short shortValue) {
		return (shortValue >= lowerBound.shortValue())
			&& (shortValue <= upperBound.shortValue());
	}
}