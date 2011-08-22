/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.prettyprinter;

import java.util.Collection;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.exceptions.ForcedBoundMismatchException;
import com.sap.furcas.prettyprinter.exceptions.PropertyInitMismatchException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * @author Stephan Erb
 *
 */
public class SequenceElementValidator {
    
    private final TCSSpecificOCLEvaluator oclEvaluator;
    
    public SequenceElementValidator(TCSSpecificOCLEvaluator oclEvaluator) {
        this.oclEvaluator = oclEvaluator;
    }
    
    public void validateLookupPropertyInit(EObject modelElement, LookupPropertyInit propInit, PrintContext context) throws PropertyInitMismatchException {
        if (propInit.isDefault()) {
            // only validate PropertyInit, if it is mandatory and not just a default for the parser
            return;
        }
        Object actualValueInModel = TcsUtil.getPropertyValue(modelElement, propInit.getPropertyReference());

        String oclQuery = propInit.getValue();
        EObject contextObject = context.getContextElementMatchingTag(TcsUtil.getContextTag(oclQuery));
        try {
            Collection<?> expectedValueByPropInit = oclEvaluator.findElementsWithOCLQuery(modelElement,
            /*key*/null, oclQuery, contextObject, /*foreachObject*/null);

            if (!TcsUtil.isPropValueAndOclResultEqual(actualValueInModel, expectedValueByPropInit)) {
                throw new PropertyInitMismatchException();
            }
        } catch (ModelAdapterException e) {
            throw new PropertyInitMismatchException();
        }
    }

    public void validatePrimitivePropertyInit(Object element, PrimitivePropertyInit propInit, PrintContext context) throws PropertyInitMismatchException {
        if (propInit.isDefault()) {
            // only validate PropertyInit, if it is mandatory and not just a default for the parser
            return;
        }
        Object actualValueInModel = TcsUtil.getPropertyValue((EObject) element, propInit.getPropertyReference());
        
        if (actualValueInModel instanceof EEnum) {
            actualValueInModel = actualValueInModel.getClass().getName() + "." + actualValueInModel.toString().toUpperCase();
        } else if (actualValueInModel != null) {
            actualValueInModel = actualValueInModel.toString();
        } else {
            actualValueInModel = "";
        }
        String expectedValueByPropInit = propInit.getValue();
        if (expectedValueByPropInit != null && expectedValueByPropInit.startsWith("\"")) {
            // TODO this is a HACK until no more java code allowed in primitive property inits
            expectedValueByPropInit = expectedValueByPropInit.substring(1, expectedValueByPropInit.length() - 1);
        }
        if (!actualValueInModel.equals(expectedValueByPropInit)) {
            throw new PropertyInitMismatchException();
        }
    }
    

    /**
     * Check for forced upper and forced lower validity of model element
     */
    public void validateBounds(Object modelElement, Property prop, Object propValue) throws ForcedBoundMismatchException  {
        ForcedLowerPArg lowerArg = PropertyArgumentUtil.getForcedLowerPArg(prop);
        ForcedUpperPArg upperArg = PropertyArgumentUtil.getForcedUpperPArg(prop);

        int elementsInPropValue = 0;
        if (propValue instanceof Collection<?>) {
            elementsInPropValue = ((Collection<?>) propValue).size();
        } else if (propValue != null) {
            elementsInPropValue = 1;
        }
        if (lowerArg != null) {
            int lowerBound = lowerArg.getValue();
            if (lowerBound > elementsInPropValue) {
                throw new ForcedBoundMismatchException();
            }
        }
        if (upperArg != null) {
            int upperBound = upperArg.getValue();
            if (elementsInPropValue > upperBound) {
                throw new ForcedBoundMismatchException();
            }
        }
    }
    
}
