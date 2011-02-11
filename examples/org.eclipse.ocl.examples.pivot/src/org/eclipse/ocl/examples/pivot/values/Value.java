/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: Value.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * isXXX returns true if self is an XXX and is not Null and is not Invalid.
 * asXXX returns an XXX if self is an XXX, null otherwise; note Null, Invalid are an XXX.
 * toXXX returns an XXX if self is or can be converted to an XXX; Invalid otherwise.
 */
public interface Value
{	
	interface BinaryOperation {
		Value evaluate(ValueFactory valueFactory, Value result, Value element);
	}

	BagValue asBagValue();
	BooleanValue asBooleanValue();
	CollectionValue asCollectionValue();
	Element asElement(); 
	BooleanValue asFalse(); 
	Integer asInteger();
	IntegerValue asIntegerValue();
	InvalidValue asInvalidValue();
	Object asObject();
	OrderedCollectionValue asOrderedCollectionValue();
	OrderedSetValue asOrderedSetValue();
	RealValue asRealValue();
	SequenceValue asSequenceValue();
	SetValue asSetValue();
	String asString();
	StringValue asStringValue();
	BooleanValue asTrue();
	TypeValue asTypeValue();
	UniqueCollectionValue asUniqueCollectionValue();
	Type getType(TypeManager typeManager, Type staticType);
	ValueFactory getValueFactory();	
	boolean isFalse();
	boolean isInvalid();
	boolean isNull();
	boolean isTrue();
	boolean isUndefined();
	boolean isUnlimited();
	boolean isUnlimitedNatural();
	String oclToString();
	RealValue toRealValue();
	void toString(StringBuffer s, int sizeLimit);
	InvalidValue toInvalidValue();
}
