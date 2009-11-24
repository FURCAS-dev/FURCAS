package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.InvocationTargetException;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * An interpreter for model elements of type <tt>T</tt>. The interpreter has to provide
 * exactly one public constructor. This constructor must accept as argument an object of type <tt>T</tt>.
 * 
 * @author Axel Uhl (D043530)
 *
 * @param <T>
 */
public interface Interpreter<T,
			     MetaClass extends RefObject,
			     TypeUsage extends RefObject,
			     ClassUsage extends TypeUsage,
			     LinkMetaObject extends RefObject,
			     LinkEndMetaObject extends RefObject,
			     StatementType extends RefObject,
			     ExpressionType extends RefObject,
			     SignatureImplementationType extends RefObject,
			     StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>,
			     NativeType extends SignatureImplementationType,
			     InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> {
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> evaluate(
	    InterpreterType interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException;
}
