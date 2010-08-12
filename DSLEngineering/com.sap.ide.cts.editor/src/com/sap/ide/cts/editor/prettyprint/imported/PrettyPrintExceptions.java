package com.sap.ide.cts.editor.prettyprint.imported;

import java.util.Collection;

import tcs.ClassTemplate;
import tcs.ForcedLowerParg;
import tcs.ForcedUpperParg;
import tcs.LookupPropertyInit;
import tcs.PrimitivePropertyInit;
import tcs.Property;
import tcs.PropertyInit;

import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

public class PrettyPrintExceptions {
    
    
    public static abstract class SyntaxMismatchException extends Exception {

 	private static final long serialVersionUID = 1L;
 	private final PrettyPrintContext context;

 	public SyntaxMismatchException(PrettyPrintContext context) {
 	    this.context = context.clone();
 	}

 	@Override
 	public String getMessage() {
 	    ClassTemplate ct = context.getClassTemplates().peek();
 	    String error = "Mismatch in PropertyInit of ClassTemplate ";
 	    error += TcsUtil.joinNameList(ct.getMetaReference().getQualifiedName());
 	    if (ct.getMode() != null) {
 		error += " #" + ct.getMode();
 	    }

 	    error += ". ";
 	    error += getMismatchError();

 	    return error;
 	}

 	protected abstract String getMismatchError();

     }
    
    public static class ForcedBoundsException extends SyntaxMismatchException {

	private static final long serialVersionUID = 1L;
	private final Object element;
	private final ForcedLowerParg lowerArg;
	private final Property p;
	private final String propertyName;
	private final ForcedUpperParg upperArg;

	public ForcedBoundsException(Object element, Property p, ForcedLowerParg lowerArg, ForcedUpperParg upperArg,
		PrettyPrintContext context) {
	    super(context);
	    this.element = element;
	    this.p = p;
	    this.propertyName = TcsUtil.getPropertyName(p.getPropertyReference());
	    this.lowerArg = lowerArg;
	    this.upperArg = upperArg;
	}

	@Override
	protected String getMismatchError() {
	    Object propValue = null;
	    if (element instanceof RefObject) {
		propValue = TcsUtil.getPropertyValue((RefObject) element, p.getPropertyReference());
	    } else if (element instanceof RefStruct) {
		propValue = TcsUtil.getPropertyValue((RefStruct) element, p.getPropertyReference());
	    }

	    Integer propValueSize = 0;
	    if (!(propValue == null)) {
		propValueSize = 1;
	    }

	    if (propValue instanceof Collection<?>) {
		Collection<?> c = (Collection<?>) propValue;
		propValueSize = c.size();
	    }

	    String error = "ForcedBoundsError: ";
	    error += "property " + propertyName;
	    error += " has " + propValueSize + " elements with";

	    if (lowerArg != null) {
		error += " forced lower " + lowerArg.getValue();
	    }
	    if (upperArg != null) {
		error += " forced upper " + upperArg.getValue();
	    }
	    return error;
	}

    }

    public static class NoTemplateMatchFoundException extends SyntaxMismatchException {

	private static final long serialVersionUID = 1L;
	private final String mode;
	private final String typeName;

	public NoTemplateMatchFoundException(PrettyPrintContext context, RefObject element, String typeName, String mode) {
	    super(context);
	    this.typeName = typeName;
	    this.mode = mode;
	}

	public NoTemplateMatchFoundException(PrettyPrintContext context, RefStruct s, String typeName, String mode) {
	    super(context);
	    this.typeName = typeName;
	    this.mode = mode;
	}

	@Override
	protected String getMismatchError() {
	    return "Did not find templat for type: " + typeName + " with mode: " + mode;
	}
    }

    public static class PropertyInitException extends SyntaxMismatchException {

	private static final long serialVersionUID = 1L;
	private final Object element;
	private final PropertyInit propertyInit;
	private final String propertyName;

	public PropertyInitException(Object element, PropertyInit propertyInit, PrettyPrintContext context) {
	    super(context);
	    this.element = element;
	    this.propertyInit = propertyInit;
	    this.propertyName = TcsUtil.getPropertyName(propertyInit.getPropertyReference());
	}

	@Override
	protected String getMismatchError() {
	    if (propertyInit instanceof PrimitivePropertyInit) {
		return getPrimitivePropertyInitError((PrimitivePropertyInit) propertyInit);
	    }
	    if (propertyInit instanceof LookupPropertyInit) {
		return getLookupPropertyInitError((LookupPropertyInit) propertyInit);
	    }
	    return "unknown property init type";
	}

	private String getPrimitivePropertyInitError(PrimitivePropertyInit p) {
	    String error = "PrimitivePropertyInit: ";
	    error += "property " + propertyName;
	    if (element instanceof RefStruct) {
		error += " is " + ((RefStruct) element).refGetValue(propertyName);
	    } else if (element instanceof RefObject) {
		error += " is " + ((RefObject) element).refGetValue(propertyName);
	    }
	    error += " instead of the expected " + p.getValue();

	    return error;
	}
	
	private String getLookupPropertyInitError(LookupPropertyInit p) {
	    return "LookupPropertyInit: property " + propertyName + " does not match OCL query " + p.getValue();
	}
    }
}
