package com.sap.runlet.interpreter.expressions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.expressions.literals.NumberLiteral;

public class NumberLiteralInterpreter implements Interpreter<NumberLiteral, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private NumberLiteral literal;

    public NumberLiteralInterpreter(NumberLiteral literal) {
	this.literal = literal;
    }

    @Override
    public ValueObject evaluate(RunletInterpreter interpreter) {
	Fraction fraction = new Fraction(literal.getLiteral());
	Fraction precision = getPrecision();
	// leaving precision's precision parameter undefined; this assumes that
	// the precision's
	// actual object parameter is never evaluated
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> precisionPrecision = Collections.emptyList();
	NativeObject precisionAsRiverObject = new NativeObject((ClassTypeDefinition) literal.getType(), precisionPrecision, precision,
		interpreter.getDefaultSnapshot(), interpreter);
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> actualObjectParameters = new ArrayList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>(
		1);
	actualObjectParameters.add(precisionAsRiverObject);
	// a native object is used to encode the number value
	return new NativeObject((ClassTypeDefinition) literal.getType(), actualObjectParameters, fraction,
		interpreter.getDefaultSnapshot(), interpreter);
    }

    /**
     * From the literal determines the number of decimal places, counting the
     * digits after the decimal point. The precision is returned again as a
     * fraction wrapped by a {@link NativeObject}.
     * <p>
     * 
     * A precision of 1 means integer numbers. A precision of 0 means arbitrary
     * precision across all fractions. A precision of a/b means that a value
     * will be rounded to the next whole multiple of a/b.
     * <p>
     */
    private Fraction getPrecision() {
	int decimalPlaces = 0;
	String number = literal.getLiteral();
	int periodPos = number.indexOf('.');
	if (periodPos >= 0) {
	    decimalPlaces = number.length() - periodPos - 1;
	}
	Fraction precision = new Fraction(BigInteger.ONE, BigInteger.TEN.pow(decimalPlaces));
	return precision;
    }

}
