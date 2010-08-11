package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;

/**
 * Expected to return a {@link ReturnInterpreter.ReturnResult} from the
 * {@link #evaluate(RiverInterpreter)} method.
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class NativeInterpreter<MetaClass extends EObject,
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
implements Interpreter<NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> {
    private NativeType nativeImpl;
    private AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> formatter;

    public NativeInterpreter(NativeType nativeImpl, AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> formatter) {
	this.nativeImpl = nativeImpl;
	this.formatter = formatter;
    }

    @Override
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> evaluate(
	    InterpreterType interpreter)
	    throws SecurityException, IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	Interpreter<? extends NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> extensionInterpreter = interpreter
		.getNativeInterpreterFor(nativeImpl);
	if (extensionInterpreter != null) {
	    return extensionInterpreter.evaluate(interpreter);
	}
	throw new RuntimeException("Unknown native method " + formatter.formatSignatureOfImpl(nativeImpl)
		+ " and no native interpreter registered for class " + formatter.formatOwnerOfSignatureOfImpl(nativeImpl));
    }

}
