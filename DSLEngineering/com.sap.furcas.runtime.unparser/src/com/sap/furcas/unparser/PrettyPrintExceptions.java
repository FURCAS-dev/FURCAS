/*******************************************************************************
 * Copyright (c) 2008-2011 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     SAP AG - API and implementation enhancements
 ******************************************************************************/
package com.sap.furcas.unparser;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;

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
 	    error += TcsUtil.joinNameList(EcoreHelper.getQualifiedName(ct.getMetaReference()));
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
	private final ForcedLowerPArg lowerArg;
	private final Property p;
	private final String propertyName;
	private final ForcedUpperPArg upperArg;

	public ForcedBoundsException(Object element, Property p, ForcedLowerPArg lowerArg, ForcedUpperPArg upperArg,
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
	    if (element instanceof EObject) {
		propValue = TcsUtil.getPropertyValue((EObject) element, p.getPropertyReference());
// FIXME
//	    } else if (element instanceof RefStruct) {
//		propValue = TcsUtil.getPropertyValue((RefStruct) element, p.getPropertyReference());
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

	public NoTemplateMatchFoundException(PrettyPrintContext context, EObject element, String typeName, String mode) {
	    super(context);
	    this.typeName = typeName;
	    this.mode = mode;
	}
// FIXME: Structure types not yet supported
//	public NoTemplateMatchFoundException(PrettyPrintContext context, RefStruct s, String typeName, String mode) {
//	    super(context);
//	    this.typeName = typeName;
//	    this.mode = mode;
//	}

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
// FIXME: Structure types not yet supported
//	    if (element instanceof RefStruct) {
//		error += " is " + ((RefStruct) element).refGetValue(propertyName);
//	    } else if (element instanceof EObject) {
		error += " is " + ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature((propertyName)));
//	    }
	    error += " instead of the expected " + p.getValue();

	    return error;
	}
	
	private String getLookupPropertyInitError(LookupPropertyInit p) {
	    return "LookupPropertyInit: property " + propertyName + " does not match OCL query " + p.getValue();
	}
    }
}
