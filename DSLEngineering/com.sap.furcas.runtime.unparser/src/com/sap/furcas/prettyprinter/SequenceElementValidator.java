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
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.exceptions.ForcedBoundMismatchException;
import com.sap.furcas.prettyprinter.exceptions.PropertyInitMismatchException;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * Validates if a model element matches the requirements of a particular {@link SequenceElement}.
 * A template is considered matching for a model element, if all validations of {@link SequenceElement}s
 * pass.
 * 
 * @author Stephan Erb
 *
 */
public class SequenceElementValidator {
    
    private final TCSSpecificOCLEvaluator oclEvaluator;
    
    public SequenceElementValidator(TCSSpecificOCLEvaluator oclEvaluator) {
        this.oclEvaluator = oclEvaluator;
    }
    
    /**
     * Check if the property value of a modelelement is equal to the expected result
     * of the corresponding OCL lookup query, as required by a template. 
     */
    public void validateLookupPropertyInit(EObject modelElement, LookupPropertyInit propInit, PrintContext context) throws SyntaxMismatchException {
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
                throw new PropertyInitMismatchException(actualValueInModel, expectedValueByPropInit, propInit);
            }
        } catch (ModelAdapterException e) {
            throw new RuntimeException("Failed to validate property init: " + e.getMessage(), e);
        }
    }

    /**
     * Check if the property value of a modelelement is equal to the expected,
     * corresponding property init of a template. 
     */
    public void validatePrimitivePropertyInit(Object element, PrimitivePropertyInit propInit) throws SyntaxMismatchException {
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
            throw new PropertyInitMismatchException(actualValueInModel, expectedValueByPropInit, propInit);
        }
    }

    /**
     * Check if the forced upper and forced lower bounds of a property
     * are satisfied by the corresponding propertyValue of a model element.
     */
    public void validateBounds(Property prop, Object propValue) throws ForcedBoundMismatchException  {
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
                throw new ForcedBoundMismatchException(propValue, prop, lowerArg, null);
            }
        }
        if (upperArg != null) {
            int upperBound = upperArg.getValue();
            if (elementsInPropValue > upperBound) {
                throw new ForcedBoundMismatchException(propValue, prop, null, upperArg);
            }
        }
    }
    
}
