/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer.OclExpressionWithPackage;
import org.eclipse.ocl.utilities.ExpressionInOCL;


/**
 * The {@link OCLExpressionFromClassTcsPicker} parses the OCL expressions which were extracted
 * out of the FURCAS/MOIN Class.tcs file. This extracted expressions are retrieved
 * in a textual representation by using the {@link OCLTestExpressionContainer}
 * and are then parsed within this class
 *
 * @author Manuel Holzleitner (D049667)
 */
public class OCLExpressionFromClassTcsPicker implements OCLExpressionPicker {

    public List<OCLExpressionWithContext> pickUpExpressions() {
	ArrayList<OCLExpressionWithContext> result = new ArrayList<OCLExpressionWithContext>();

	for (OclExpressionWithPackage expression : OCLTestExpressionContainer.getExpressionList()) {
	    result.add(parse(expression.getOcl(), expression.getPackage(), expression));
	}

	return result;
    }

    public OCLExpressionWithContext pickUpExpression(int index){
	return parse(OCLTestExpressionContainer.getExpressionList().get(index).getOcl(), OCLTestExpressionContainer.getExpressionList().get(index).getPackage(), OCLTestExpressionContainer.getExpressionList().get(index));
    }

    /**
     * @param expression
     *            to parse
     * @return a list of {@link Constraint}s parsed from given expression
     */
    protected OCLExpressionWithContext parse(String expression, EPackage basePackage,
            OclExpressionWithPackage oclWithPackage) {
        OCLInput exp = new OCLInput(expression);
        String nsPrefix = basePackage.getNsPrefix();
        EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
        ArrayList<String> path = new ArrayList<String>();
        path.add(nsPrefix);
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance();
        ocl = OCL.newInstance(new EnvironmentFactory().createPackageContext(ocl.getEnvironment(), basePackage));
        OCLExpressionWithContext result = null;
        try {
            @SuppressWarnings("rawtypes")
            ExpressionInOCL specification = ocl.parse(exp).iterator().next().getSpecification();
            OCLExpression expr = (OCLExpression) specification.getBodyExpression();

            result = new OCLExpressionWithContext(expr, (EClass) specification.getContextVariable().getType(),
                    oclWithPackage);

        } catch (ParserException e) {
            System.err.println("Error while parsing Expression:" + exp);
            e.printStackTrace();
            System.exit(0);
        }
        return result;
    }

}
