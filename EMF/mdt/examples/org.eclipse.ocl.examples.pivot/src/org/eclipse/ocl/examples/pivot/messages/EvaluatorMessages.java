/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluatorMessages.java,v 1.1 2011/05/07 16:41:14 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class EvaluatorMessages
{	
	static {
		NLS.initializeMessages(EvaluatorMessages.class.getName(), EvaluatorMessages.class);
	}

	public static String ConvertibleValueRequired;
	public static String EObjectRequired;
	public static String EmptyCollection;
	public static String ImplementationClassLoadFailure;
	public static String IncompatibleArgumentType;
	public static String IndexOutOfRange;
	public static String IndexesOutOfRange;
	public static String InvalidArgument;
	public static String InvalidInteger;
	public static String InvalidOperation;
	public static String InvalidReal;
	public static String InvalidSource;
	public static String MissingResult;
	public static String MissingSourceType;
	public static String MissingSourceValue;
	public static String MissingValue;
	public static String NonBinaryOperation;
	public static String NonFiniteIntegerValue;
	public static String NonPositiveUnlimitedNaturalValue;
	public static String TypedResultRequired;
	public static String TypedValueRequired;
	public static String UndefinedBody;
	public static String UndefinedInitialiser;
	public static String UndefinedOperation;
	public static String UndefinedResult;
	public static String UnknownSourceType;
}
