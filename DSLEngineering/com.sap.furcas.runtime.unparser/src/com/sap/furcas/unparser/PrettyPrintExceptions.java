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
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
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
 	
 	@Override
 	public synchronized Throwable fillInStackTrace() {
 	    // Do not create a stack trace as we don't need it.
 	    // It is very costly when all we want is a deep return.
 	    return this;
 	}

 	protected abstract String getMismatchError();

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
    
    public static class OperatorTemplateOperatorMissmatchException extends SyntaxMismatchException {

        private static final long serialVersionUID = 1L;
        private final String operator;
        private final OperatorTemplate template;

        public OperatorTemplateOperatorMissmatchException(PrettyPrintContext context, String operator, OperatorTemplate template) {
            super(context);
            this.operator = operator;
            this.template = template;
        }

        @Override
        protected String getMismatchError() {
            return "Operator and template missmatch. Template " + EMFModelInspector.getTypeName(template) +
                " does not support the operator " + operator;
        }
    }
}
