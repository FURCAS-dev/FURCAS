package com.sap.runlet.interpreter.rucola;

import java.util.Date;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.TypeDefinition;

public class Value extends ClassTypedObject {
    private static Fraction maxInt = new Fraction(Integer.MAX_VALUE);
    private static Fraction minInt = new Fraction(Integer.MIN_VALUE);

    public Value(Rucola rucola, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> object) {
	super(rucola, object);
    }

    @Override
    public Value asValue() {
	return this;
    }
    
    @Override
    public String asString() {
	if (size() == 0) {
	    return null;
	}
	Object no = ((NativeObject) getSingleObject()).getNativeObject();
	if (no instanceof String) {
	    return (String) no;
	} else {
	    throw new RucolaException("Native object has type "+no.getClass().getName()+" which is not a string");
	}
    }
    
    @Override
    public Date asDate() {
	if (size() == 0) {
	    return null;
	}
	Object no = ((NativeObject) getSingleObject()).getNativeObject();
	if (no instanceof Date) {
	    return (Date) no;
	} else {
	    throw new RucolaException("Native object has type "+no.getClass().getName()+" which is not a Date");
	}
    }
    
    @Override
    public Fraction asFraction() {
	if (size() == 0) {
	    return null;
	}
	Object no = ((NativeObject) getSingleObject()).getNativeObject();
	if (no instanceof Fraction) {
	    return (Fraction) no;
	} else {
	    throw new RucolaException("Native object has type "+no.getClass().getName()+" which is not a fraction");
	}
    }
    
    @Override
    public int asInt() {
	Object no = ((NativeObject) getSingleObject()).getNativeObject();
	if (no instanceof Fraction) {
	    Fraction f = (Fraction) no;
	    if (f.compareTo(maxInt) <= 0 && f.compareTo(minInt) >= 0) {
		return f.intValue();
	    } else {
		throw new RucolaException("Number "+f+" does not fit into an int");
	    }
	} else {
	    throw new RucolaException("Native object has type "+no.getClass().getName()+" which is not a fraction");
	}
    }

    @Override
    public double asDouble() {
	Object no = ((NativeObject) getSingleObject()).getNativeObject();
	if (no instanceof Fraction) {
	    Fraction f = (Fraction) no;
	    return f.asDouble();
	} else {
	    throw new RucolaException("Native object has type "+no.getClass().getName()+" which is not a fraction");
	}
    }
    
    @Override
    public float asFloat() {
	Object no = ((NativeObject) getSingleObject()).getNativeObject();
	if (no instanceof Fraction) {
	    Fraction f = (Fraction) no;
	    return f.asFloat();
	} else {
	    throw new RucolaException("Native object has type "+no.getClass().getName()+" which is not a fraction");
	}
    }
}
