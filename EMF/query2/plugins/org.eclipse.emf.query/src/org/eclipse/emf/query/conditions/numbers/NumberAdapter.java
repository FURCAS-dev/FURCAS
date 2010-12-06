/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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

import org.eclipse.emf.query.conditions.IDataTypeAdapter;

/**
 * An Adapter class to be used to extract from -adapt- the argument object to
 * some numeric value that would later be used in Condition evaluation.
 * 
 * Clients can subclass it and provide their own implementation.
 * <p>
 * Since the 1.2 release, this class is no longer abstract and can be used
 * as a generic number adapter for all number types.
 * </p>
 * 
 * @param <N> the kind of number to which I adapt input values
 * 
 * @see NumberCondition
 */

public class NumberAdapter<N extends Number & Comparable<? super N>>
	implements IDataTypeAdapter<N> {

	/**
	 * A default number adapter, that simply assumes that
	 * input values are of my number kind and casts them appropriately.
	 * Note that the declaration of this default as type Integer actually
	 * doesn't matter at all, because the "cast" to (N), in this case (Integer),
	 * doesn't actually exist; hence the "unchecked" warning in the default
	 * implementation of {@link #adapt(Object)}.
	 */
	private static final NumberAdapter<?> DEFAULT = new NumberAdapter<Integer>();
	
	/**
	 * Initializes me as a default number adapter, that simply assumes that
	 * input values are of my number kind and casts them appropriately.
	 * 
	 * @since 1.2
	 */
	public NumberAdapter() {
		super();
	}
	
	/**
	 * Obtains a default number adapter, that simply assumes that input
	 * values are of the required number kind and casts them appropriately.
	 * 
	 * @since 1.2
	 */
	@SuppressWarnings("unchecked")
	public static <N extends Number & Comparable<? super N>> NumberAdapter<N> getDefault() {
		return (NumberAdapter<N>) DEFAULT;
	}

	/**
	 * A subclass of <code>NumberAdapter</code> to be used to adapt an
	 * argument object to <code>int</code> values Clients can either use the
	 * default implementation supplied or have their own.
	 */
	public static abstract class IntegerAdapter
		extends NumberAdapter<Integer> {

		/**
		 * The simplest <code>IntegerAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Integer
		 * object itself.
		 */
		public static final IntegerAdapter DEFAULT = new IntegerAdapter() {

			@Override
			public int intValue(Object object) {
				return ((Integer) object).intValue();
			}
			
			@Override
			public Integer adapt(Object value) {
				return (Integer) value;
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
	 * the default implementation supplied or have their own.
	 */
	public static abstract class DoubleAdapter
		extends NumberAdapter<Double> {

		/**
		 * The simplest <code>DoubleAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Double
		 * object itself.
		 */
		public static final DoubleAdapter DEFAULT = new DoubleAdapter() {

			@Override
			public double doubleValue(Object object) {
				return ((Double) object).doubleValue();
			}
			
			@Override
			public Double adapt(Object value) {
				return (Double) value;
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
	 * default implementation supplied or have their own.
	 */
	public static abstract class ByteAdapter
		extends NumberAdapter<Byte> {

		/**
		 * The simplest <code>ByteAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Byte object
		 * itself.
		 */
		public static final ByteAdapter DEFAULT = new ByteAdapter() {

			@Override
			public byte byteValue(Object object) {
				return ((Byte) object).byteValue();
			}
			
			@Override
			public Byte adapt(Object value) {
				return (Byte) value;
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
	 * default implementation supplied or have their own.
	 */
	public static abstract class LongAdapter
		extends NumberAdapter<Long> {

		/**
		 * The simplest <code>LongAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Long object
		 * itself.
		 */
		public static final LongAdapter DEFAULT = new LongAdapter() {

			@Override
			public long longValue(Object object) {
				return ((Long) object).longValue();
			}
			
			@Override
			public Long adapt(Object value) {
				return (Long) value;
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
	 * default implementation supplied or have their own.
	 */
	public static abstract class FloatAdapter
		extends NumberAdapter<Float> {

		/**
		 * The simplest <code>FloatAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Float
		 * object itself.
		 */
		public static final FloatAdapter DEFAULT = new FloatAdapter() {

			@Override
			public float floatValue(Object object) {
				return ((Float) object).floatValue();
			}
			
			@Override
			public Float adapt(Object value) {
				return (Float) value;
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
	 * default implementation supplied or have their own.
	 */
	public static abstract class ShortAdapter
		extends NumberAdapter<Short> {

		/**
		 * The simplest <code>ShortAdapter</code> implementation that
		 * represents the case when to argument object to adapt is a Short
		 * object itself.
		 */
		public static final ShortAdapter DEFAULT = new ShortAdapter() {

			@Override
			public short shortValue(Object object) {
				return ((Short) object).shortValue();
			}
			
			@Override
			public Short adapt(Object value) {
				return (Short) value;
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

	@SuppressWarnings("unchecked")
	public N adapt(Object value) {
		return (N) value;
	}
}