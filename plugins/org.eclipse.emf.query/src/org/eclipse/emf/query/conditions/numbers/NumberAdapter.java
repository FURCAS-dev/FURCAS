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

/**
 * An Adapter class to be used to extract from -adapt- the argument object to
 * some numeric value that would later be used in Condition evaluation.
 * 
 * Clients can subclass it and provide their own implementation
 * 
 * @see NumberCondition
 */

public abstract class NumberAdapter {

	private NumberAdapter() {
		//private
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>int</code> values Clients can either use the
	 * default implemantation supplied or have their own.
	 */
	public static abstract class IntegerAdapter
		extends NumberAdapter {

		/**
		 * The simplest <code>IntegerAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Integer
		 * object itself.
		 */
		public static final IntegerAdapter DEFAULT = new IntegerAdapter() {

			public int intValue(Object object) {
				return ((Integer) object).intValue();
			}
		};

		/**
		 * An adapting function whose responsible of extracting the
		 * <code>int</code> value of interest from an the argument object
		 * 
		 * @param object
		 *            The <code>Object</code> to adapt to <code>int</code>
		 * @return The <code>int</code> value of interest that got extracted
		 *         by this adapter from the argument object
		 */
		public abstract int intValue(Object object);
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>double</code> values Clients can either use
	 * the default implemantation supplied or have their own.
	 */
	public static abstract class DoubleAdapter
		extends NumberAdapter {

		/**
		 * The simplest <code>DoubleAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Double
		 * object itself.
		 */
		public static final DoubleAdapter DEFAULT = new DoubleAdapter() {

			public double doubleValue(Object object) {
				return ((Double) object).doubleValue();
			}
		};

		/**
		 * An adapting function whose responsible of extracting the
		 * <code>double</code> value of interest from an the argument object
		 * 
		 * @param object
		 *            The <code>Object</code> to adapt to <code>double</code>
		 * @return The <code>double</code> value of interest that got
		 *         extracted by this adapter from the argument object
		 */
		public abstract double doubleValue(Object object);
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>byte</code> values Clients can either use the
	 * default implemantation supplied or have their own.
	 */
	public static abstract class ByteAdapter
		extends NumberAdapter {

		/**
		 * The simplest <code>ByteAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Byte object
		 * itself.
		 */
		public static final ByteAdapter DEFAULT = new ByteAdapter() {

			public byte byteValue(Object object) {
				return ((Byte) object).byteValue();
			}
		};

		/**
		 * An adapting function whose responsible of extracting the
		 * <code>byte</code> value of interest from an the argument object
		 * 
		 * @param object
		 *            The <code>Object</code> to adapt to <code>byte</code>
		 * @return The <code>byte</code> value of interest that got extracted
		 *         by this adapter from the argument object
		 */
		public abstract byte byteValue(Object object);
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>long</code> values Clients can either use the
	 * default implemantation supplied or have their own.
	 */
	public static abstract class LongAdapter
		extends NumberAdapter {

		/**
		 * The simplest <code>LongAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Long object
		 * itself.
		 */
		public static final LongAdapter DEFAULT = new LongAdapter() {

			public long longValue(Object object) {
				return ((Long) object).longValue();
			}
		};

		/**
		 * An adapting function whose responsible of extracting the
		 * <code>long</code> value of interest from an the argument object
		 * 
		 * @param object
		 *            The <code>Object</code> to adapt to <code>long</code>
		 * @return The <code>long</code> value of interest that got extracted
		 *         by this adapter from the argument object
		 */
		public abstract long longValue(Object object);
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>float</code> values Clients can either use the
	 * default implemantation supplied or have their own.
	 */
	public static abstract class FloatAdapter
		extends NumberAdapter {

		/**
		 * The simplest <code>FloatAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Float
		 * object itself.
		 */
		public static final FloatAdapter DEFAULT = new FloatAdapter() {

			public float floatValue(Object object) {
				return ((Float) object).floatValue();
			}
		};

		/**
		 * An adapting function whose responsible of extracting the
		 * <code>float</code> value of interest from an the argument object
		 * 
		 * @param object
		 *            The <code>Object</code> to adapt to <code>float</code>
		 * @return The <code>float</code> value of interest that got extracted
		 *         by this adapter from the argument object
		 */
		public abstract float floatValue(Object object);
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>short</code> values Clients can either use the
	 * default implemantation supplied or have their own.
	 */
	public static abstract class ShortAdapter
		extends NumberAdapter {

		/**
		 * The simplest <code>ShortAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Short
		 * object itself.
		 */
		public static final ShortAdapter DEFAULT = new ShortAdapter() {

			public short shortValue(Object object) {
				return ((Short) object).shortValue();
			}
		};

		/**
		 * An adapting function whose responsible of extracting the
		 * <code>short</code> value of interest from an the argument object
		 * 
		 * @param object
		 *            The <code>Object</code> to adapt to <code>short</code>
		 * @return The <code>short</code> value of interest that got extracted
		 *         by this adapter from the argument object
		 */
		public abstract short shortValue(Object object);
	}

}