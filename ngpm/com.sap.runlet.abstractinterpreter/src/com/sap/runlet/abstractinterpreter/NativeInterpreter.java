package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.InvocationTargetException;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Expected to return a {@link ReturnInterpreter.ReturnResult} from the
 * {@link #evaluate(RiverInterpreter)} method.
 * 
 * @author Axel Uhl (D043530)
 */
public abstract class NativeInterpreter<MetaClass extends RefObject,
			     TypeUsage extends RefObject,
			     ClassUsage extends TypeUsage,
			     LinkMetaObject extends RefObject,
			     LinkEndMetaObject extends RefObject,
			     StatementType extends RefObject,
			     ExpressionType extends RefObject,
			     SignatureImplementationType extends RefObject,
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
