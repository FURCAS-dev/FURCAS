package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;

/**
 * An interpreter for model elements of type <tt>T</tt>. The interpreter has to provide
 * exactly one public constructor. This constructor must accept as argument an object of type <tt>T</tt>.
 * 
 * @author Axel Uhl (D043530)
 *
 * @param <T>
 */
public interface Interpreter<T,
			     MetaClass extends EObject,
			     TypeUsage extends EObject,
			     ClassUsage extends TypeUsage,
			     LinkMetaObject extends EObject,
			     LinkEndMetaObject extends EObject,
			     StatementType extends EObject,
			     ExpressionType extends EObject,
			     SignatureImplementationType extends EObject,
			     StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>,
			     NativeType extends SignatureImplementationType,
			     InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> {
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> evaluate(
	    InterpreterType interpreter)
	    throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException;
}
