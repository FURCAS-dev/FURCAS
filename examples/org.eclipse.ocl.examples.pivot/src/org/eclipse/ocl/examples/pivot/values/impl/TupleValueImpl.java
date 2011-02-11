/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: TupleValueImpl.java,v 1.4 2011/02/11 20:00:28 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.TupleValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * UML implementation of a tuple value.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TupleValueImpl extends AbstractValue implements TupleValue
{
    private final TupleType type;
    private final Map<String, Value> parts = new java.util.HashMap<String, Value>();
    private final int hashCode;			// FIXME just for debugging

    /**
     * Initializes me with a map of part values.
     * 
     * @param type my type
     * @param values my parts
     */
    public TupleValueImpl(ValueFactory valueFactory, TupleType type, Map<? extends TypedElement, Value> values) {
		super(valueFactory);
        this.type = type;
        for (Map.Entry<? extends TypedElement, Value> entry : values.entrySet()) {
            parts.put(entry.getKey().getName(), entry.getValue());
        }
        this.hashCode = computeHashCode();
//        System.out.println(this + " : " + getTupleType().getMoniker() + " @* " + hashCode + " = " + type.hashCode() + " + " + parts.hashCode());
    }
    
    /**
     * Convenience constructor to initialize me with a pair of part values as
     * required by the Collection::product() operation.
     * 
     * @param type my type
     * @param firstValue my first value
     * @param secondValue my second value
     */
    public TupleValueImpl(ValueFactory valueFactory, TupleType type, Value firstValue, Value secondValue) {
		super(valueFactory);
        this.type = type;						// FIXME use optimised ProductTupleImpl
        parts.put("first", firstValue);			// FIXME define "first" elsewhere
        parts.put("second", secondValue);
        this.hashCode = computeHashCode();
//        System.out.println(this + " : " + getTupleType().getMoniker() + " @2 " + hashCode + " = " + type.hashCode() + " + " + parts.hashCode());
    }

	public Object asObject() {
		return parts;
	}
	
    private int computeHashCode() {
        int typeHashCode = type.hashCode();
		int partsHashCode = parts.hashCode();
		return 37 * typeHashCode + 17 * partsHashCode;
    }

    // implements the inherited specification
    public TupleType getTupleType() {
        return type;
    }

    // implements the inherited specification
    public Value getValue(String partName) {
        return parts.get(partName);
    }

    // implements the inherited specification
    public Value getValue(Property part) {
        return getValue(part.getName());
    }

    // overrides the inherited implementation
    @Override
    public boolean equals(Object o) {
        boolean result = o instanceof TupleValueImpl;

        if (result) {
            TupleValueImpl other = (TupleValueImpl) o;

            result &= other.type.equals(type);
            result &= other.parts.equals(parts);
        }

        return result;
    }

	public Type getType(TypeManager typeManager, Type staticType) {
		return type;
	}

    // overrides the inherited implementation
    @Override
    public int hashCode() {
//        int typeHashCode = type.hashCode();
//		int partsHashCode = parts.hashCode();
//		return 37 * typeHashCode + 17 * partsHashCode;
		return hashCode;
    }
    
    @Override
	public boolean isInvalid() {
    	for (Value part : parts.values()) {
    		if (part.isInvalid()) {
    			return true;
    		}
    	}
		return false;
	}

	@Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Tuple{"); //$NON-NLS-1$
        
        for (Iterator<Property> iter =  getTupleType().getOwnedAttributes().iterator();
                iter.hasNext();) {
            
            Property p = iter.next();
            
            result.append(p.getName());
            result.append(" = "); //$NON-NLS-1$
            result.append(toString(getValue(p)));
            
            if (iter.hasNext()) {
                result.append(", "); //$NON-NLS-1$
            }
        }
        
        result.append("}"); //$NON-NLS-1$
        return result.toString();
    }
    
    private String toString(Object o) {
        /*if (o instanceof String) {
            return "'" + (String) o + "'"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if (o instanceof NullValue) {
            return o.toString();
        } else if (o instanceof CollectionValue) {
            return toString((CollectionValue) o);
        } else*/ if (o == null) {
            return "null"; //$NON-NLS-1$
        } else {
            return o.toString();
        }
    }
	
	/**
	 * Computes the string representation of a collection value using syntax
	 * like OCL's collection literals (e.g., <tt>OrderedSet{...}</tt>) instead
	 * of Java's default (i.e., <tt>[...]</tt>).
	 * 
	 * @param c a collection (not <code>null</code>)
	 * @return the string representation of the specified collection
	 * 
	 * @since 1.2
	 */
	public static String toString(CollectionValue c) {
	    StringBuilder result = new StringBuilder();
	    
        result.append(c.getKind().getName());
        result.append('{');
        
        boolean notFirst = false;
        for (Iterator<?> iter = c.iterator();;) {
            if (iter.hasNext()) {
                if (notFirst) {
                    result.append(", "); //$NON-NLS-1$
                } else {
                    notFirst = true;
                }
                
                Object next = iter.next();
                if (next instanceof CollectionValue) {
                    // nested collection
                    result.append(toString((CollectionValue) next));
                } else if (next instanceof String) {
                    // string literal
                    result.append('\'').append(next).append('\'');
                } else {
                    result.append(next);
                }
            } else {
                break;
            }
        }
        
        result.append('}');
        
	    return result.toString();
	}
}
