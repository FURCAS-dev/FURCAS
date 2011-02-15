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
 * $Id: StringValueImpl.java,v 1.3 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.StringValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class StringValueImpl extends AbstractValue implements StringValue
{
	private final String value;
	
	public StringValueImpl(ValueFactory valueFactory, String value) {
		super(valueFactory);
		this.value = value;
	}

	public Object asObject() {
		return value;
	}

	@Override
	public String asString() {
		return value;
	}

	@Override
	public StringValue asStringValue() {
		return this;
	}

	public int compareTo(StringValue o) {
		return value.compareTo(o.asString());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StringValue)) {
			return false;
		}
		return value.equals(((StringValue)obj).asString());
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return typeManager.getStringType();
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public String toString() {
		return "'" + value + "'";
	}

	@Override
	public void toString(StringBuffer s, int sizeLimit) {
		s.append("'");
		int length = value.length();
		int available = sizeLimit - (length + 1);
		if (length <= available) {
			s.append(value);
		}
		else {
			if (available > 0) {
				s.append(value.substring(0, available));
			}
			s.append("...");
		}
		s.append("'");
	}
}
