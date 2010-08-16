package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.EObject;

/**
 * For a model element, such as an expression, finds the most adequate
 * interpreter. This implementation decides based on the actual type of the
 * model element.
 * <p>
 * 
 * Interpreters are registered for one or more concrete types. If this would
 * lead to an ambiguity for resolving interpreters, an exception is thrown.
 * <p>
 * 
 * The factory chooses the interpreter that can handle the actual type of the
 * model element and for which no other interpreter is registered for a type to
 * which the model element conforms and that conforms to the type the chosen
 * interpreter can handle. In other words, the most specific handling
 * interpreter is selected.
 * <p>
 * 
 * @param <C>
 *            the type class on which direct supertypes can be computed which
 *            defines a conformance relation for finding the most specific
 *            interpreter
 * @param <T>
 *            the type of the model elements that interpreters managed by this
 *            factory can interpret. Example: <tt>Expression</tt> as the abstract
 *            superclass of all expressions. In particular, elements passed to
 *            {@link #getInterpreterFor(EObject)} have to be at least of that
 *            type.
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class InterpreterFactory<C, T extends EObject, MetaClass extends EObject,
TypeUsage extends EObject,
ClassUsage extends TypeUsage,
LinkMetaObject extends EObject,
LinkEndMetaObject extends EObject,
StatementType extends EObject,
ExpressionType extends EObject,
SignatureImplementationType extends EObject,
StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>,
NativeType extends SignatureImplementationType,
InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>>
extends GenericFactory<C, T, Interpreter<? extends T, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> {
    public void registerInterpreter(Class<? extends Interpreter<? extends T, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> handlerClass, C... classes) {
	registerHandlerClass(handlerClass, classes);
    }
    
    public Interpreter<? extends T, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getInterpreterFor(T o) throws SecurityException, IllegalArgumentException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	return getHandlerFor(o);
    }
}
