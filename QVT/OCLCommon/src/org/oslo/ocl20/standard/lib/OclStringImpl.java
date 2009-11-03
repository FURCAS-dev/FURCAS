package org.oslo.ocl20.standard.lib;

import java.util.regex.PatternSyntaxException;

import org.oslo.ocl20.semantics.bridge.Classifier;

public class OclStringImpl extends OclAnyImpl implements OclString {
	public OclStringImpl(java.lang.String s, StdLibAdapter adapter) {
		super(adapter);
		_implementation = s;
	}

	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildStringType();
		return adapter.Type(type);
	}

	String _implementation;
	public String implementation() {
		return _implementation;
	}

	public Object asJavaObject() {
		return implementation();
	}
	//--- IOclString ---
	public OclBoolean equalTo(OclString string2) {
		return string2 instanceof OclStringImpl ? adapter.Boolean(implementation().equals(((OclStringImpl) string2).implementation())) : adapter.Boolean(false);
	}

	public OclInteger size() {
		return adapter.Integer(implementation().length());
	}

	public OclString concat(OclString string2) {
		if (string2 instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.String(implementation() + ((OclStringImpl) string2).implementation());
	}

	public OclString substring(OclInteger lower, OclInteger upper) {
		try {
			return adapter.String(implementation().substring(((OclIntegerImpl)lower).int_impl()-1, ((OclIntegerImpl)upper).int_impl()));	
		} catch (IndexOutOfBoundsException e) {
			return adapter.Undefined();
		}
	}
	
	public OclInteger toInteger() {
		try {
			return adapter.Integer( Integer.parseInt(implementation()) );
		} catch (NumberFormatException e) {
			return adapter.Undefined();
		}
	}

	public OclReal toReal() {
		try {
			return adapter.Real( Double.parseDouble(implementation()) );
		} catch (NumberFormatException e) {
			return adapter.Undefined();
		}
	}

	//--- IOclVisitable ---
	public Object accept(OclVisitor v, Object obj) {
		return v.visit(this, obj);
	}
	//--- Object ---
	public String toString() {
		return "'" + _implementation + "'";
	}

	public boolean equals(Object o) {
		return (o instanceof OclString) ? ((OclBooleanImpl)equalTo((OclString)o)) == OclBooleanImpl.TRUE : false;
	}

	public int hashCode() {
		return implementation().hashCode();
	}

	public Object clone() {
		return adapter.String(_implementation);
	}

	public OclString toLower() {
		return adapter.String(implementation().toLowerCase());
	}

	public OclString toUpper() {
		return adapter.String(implementation().toUpperCase());
	}

	public OclString firstToUpper() {
		if (implementation().length() <= 0) {
			return this;
		}
		return adapter.String(implementation().substring(0,1).toUpperCase() + implementation().substring(1));
	}

	public OclBoolean toBoolean() {
		if (implementation().equalsIgnoreCase("true") || 
				implementation().equals("1")) {
			return adapter.Boolean(true);
		} else if (implementation().equalsIgnoreCase("false") || 
				implementation().equals("0")) {
			return adapter.Boolean(false);			
		} else {
			return adapter.Undefined();
		}
	}

	public OclString firstToLower() {
		if (implementation().length() <= 0) {
			return this;
		}
		return adapter.String(implementation().substring(0,1).toLowerCase() + implementation().substring(1));
	}

	public OclInteger indexOf(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.Integer(implementation().indexOf(((OclStringImpl)match).implementation()));
	}

	public OclInteger indexOf(OclString match, OclInteger from) {
		if (match instanceof OclUndefined || from instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.Integer(implementation().indexOf(((OclStringImpl)match).implementation(),((OclIntegerImpl)from).int_impl()));
	}

	public OclInteger lastIndexOf(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.Integer(implementation().lastIndexOf(((OclStringImpl)match).implementation()));
	}

	public OclInteger lastIndexOf(OclString match, OclInteger from) {
		if (match instanceof OclUndefined || from instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.Integer(implementation().lastIndexOf(((OclStringImpl)match).implementation(),((OclIntegerImpl)from).int_impl()));
	}

	public OclBoolean endsWith(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.Boolean(implementation().endsWith(((OclStringImpl)match).implementation()));
	}

	public OclBoolean startsWith(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		return adapter.Boolean(implementation().startsWith(((OclStringImpl)match).implementation()));
	}

	public OclString trim() {
		return adapter.String(implementation().trim());
	}

	public OclBoolean equalsIgnoreCase(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Boolean(false);
		}
		return adapter.Boolean(implementation().equalsIgnoreCase(((OclStringImpl)match).implementation()));
	}

	public OclString substringBefore(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		String value = implementation();
		String matchString = ((OclStringImpl)match).implementation();
		int index = value.indexOf(matchString);

		if (index < 0) {
			return adapter.Undefined();
		}
		
		return adapter.String(implementation().substring(0, index));
	}

	public OclString substringAfter(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		String value = implementation();
		String matchString = ((OclStringImpl)match).implementation();
		int index = value.indexOf(matchString);

		if (index < 0) {
			return adapter.Undefined();
		}
		
		return adapter.String(implementation().substring(index + matchString.length(), implementation().length()));
	}

	public OclBoolean containsOnlyLetters() {
		char [] value = implementation().toCharArray();
		for (int i = 0; i < value.length; i++) {
			char currentChar = value[i];
			if (!Character.isLetter(currentChar)) {
				return adapter.Boolean(false);
			}
		}
		return adapter.Boolean(true);
	}

	public OclBoolean containsOnlyDigits() {
		char [] value = implementation().toCharArray();
		for (int i = 0; i < value.length; i++) {
			char currentChar = value[i];
			if (!Character.isDigit(currentChar)) {
				return adapter.Boolean(false);
			}
		}
		return adapter.Boolean(true);
	}

	public OclBoolean containsOnlyDigitsAndLetters() {
		char [] value = implementation().toCharArray();
		for (int i = 0; i < value.length; i++) {
			char currentChar = value[i];
			if (!Character.isLetterOrDigit(currentChar)) {
				return adapter.Boolean(false);
			}
		}
		return adapter.Boolean(true);
	}

	public OclString replace(OclString match, OclString replacement) {
		if (match instanceof OclUndefined || replacement instanceof OclUndefined) {
			return adapter.Undefined();
		}
		try {
			return adapter.String(implementation().replaceAll(((OclStringImpl)match).implementation(), ((OclStringImpl)replacement).implementation()));			
		} catch (PatternSyntaxException e) {
			return adapter.Undefined();
		}
	}

	public OclString replaceFirst(OclString match, OclString replacement) {
		if (match instanceof OclUndefined || replacement instanceof OclUndefined) {
			return adapter.Undefined();
		}
		try {
			return adapter.String(implementation().replaceFirst(((OclStringImpl)match).implementation(), ((OclStringImpl)replacement).implementation()));
		} catch (PatternSyntaxException e) {
			return adapter.Undefined();
		}
	}

	public OclSequence split(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Sequence(adapter.getProcessor().getTypeFactory().buildVoidType());
		}
		try {
			return adapter.Sequence(adapter.getProcessor().getTypeFactory().buildStringType(), implementation().split(((OclStringImpl)match).implementation()));
		} catch (PatternSyntaxException e) {
			return adapter.Sequence(adapter.getProcessor().getTypeFactory().buildVoidType());
		}
	}

	public OclSequence split(OclString match, OclInteger limit) {
		if (match instanceof OclUndefined || limit instanceof OclUndefined) {
			return adapter.Sequence(adapter.getProcessor().getTypeFactory().buildVoidType());
		}
		try {
			return adapter.Sequence(adapter.getProcessor().getTypeFactory().buildStringType(), implementation().split(((OclStringImpl)match).implementation(), ((OclIntegerImpl)limit).int_impl()));
		} catch (PatternSyntaxException e) {
			return adapter.Sequence(adapter.getProcessor().getTypeFactory().buildVoidType());
		}
	}

	public OclBoolean matches(OclString match) {
		if (match instanceof OclUndefined) {
			return adapter.Undefined();
		}
		try {
			return adapter.Boolean(implementation().matches(((OclStringImpl)match).implementation()));
		} catch (PatternSyntaxException e) {
			return adapter.Undefined();
		}
	}

	public OclString add(OclString s2) {
		return this.concat(s2);
	}
}
