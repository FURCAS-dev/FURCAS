/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: Value.java,v 1.6 2011/05/07 16:41:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * asXXX returns an XXX if self is an XXX and not Null (and is not Invalid),
 * Null (and Invalid) throw an InvalidValueException.
 * 
 * isXXX returns an XXX-related value if self is an XXX and is not Null (and is not Invalid).
 * 
 * toXXX returns an XXX if self is or can be converted to an XXX; Invalid otherwise.
 */
public interface Value
{	
	interface BinaryOperation {
		Value evaluate(ValueFactory valueFactory, Value result, Value element) throws InvalidValueException;
	}
	
	public static final String INVALID_NAME = "invalid";

	BagValue asBagValue() throws InvalidValueException;
	boolean asBoolean() throws InvalidValueException;
	BooleanValue asBooleanValue() throws InvalidValueException;
	CollectionValue asCollectionValue() throws InvalidValueException;
	Double asDouble() throws InvalidValueException;
	Element asElement(); 
	ElementValue<?> asElementValue() throws InvalidValueException;
	Integer asInteger() throws InvalidValueException;
	IntegerValue asIntegerValue() throws InvalidValueException;
	Object asObject();
	ObjectValue asObjectValue() throws InvalidValueException;
	OrderedCollectionValue asOrderedCollectionValue() throws InvalidValueException;
	OrderedSetValue asOrderedSetValue() throws InvalidValueException;
	RealValue asRealValue() throws InvalidValueException;
	SequenceValue asSequenceValue() throws InvalidValueException;
	SetValue asSetValue() throws InvalidValueException;
	String asString() throws InvalidValueException;
	StringValue asStringValue() throws InvalidValueException;
	TypeValue asTypeValue() throws InvalidValueException;
	UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException;
	Value asValidValue() throws InvalidValueException;
	Type getType(TypeManager typeManager, Type staticType);
	ValueFactory getValueFactory();	
	CollectionValue isCollectionValue();
	boolean isFalse();
	IntegerValue isIntegerValue();
	boolean isInvalid();
	boolean isNull();
	RealValue isRealValue();
	boolean isTrue();
	boolean isUndefined();
	boolean isUnlimited();
	boolean isUnlimitedNatural();
	String oclToString();
	IntegerValue toIntegerValue() throws InvalidValueException;
	RealValue toRealValue() throws InvalidValueException;
	void toString(StringBuffer s, int sizeLimit);
}
