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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.examples.impactanalyzer.util.OCL;

/**
 * The {@link OCLExpressionFromModelPicker} extracts constraints out of the
 * NGPM meta model and parses them.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class OCLExpressionFromModelPicker implements OCLExpressionPicker {

    public List<OCLExpressionWithContext> pickUpExpressions() {
        return pickUpExpressions(data.classes.ClassesPackage.eINSTANCE,
        	data.constraints.ConstraintsPackage.eINSTANCE, data.documents.DocumentsPackage.eINSTANCE,
        	data.generics.GenericsPackage.eINSTANCE, data.quantitystructure.QuantitystructurePackage.eINSTANCE,
        	data.timedependency.TimedependencyPackage.eINSTANCE, data.tuples.TuplesPackage.eINSTANCE,

        	dataaccess.analytics.AnalyticsPackage.eINSTANCE, dataaccess.expressions.ExpressionsPackage.eINSTANCE,
        	dataaccess.expressions.fp.FpPackage.eINSTANCE, dataaccess.expressions.literals.LiteralsPackage.eINSTANCE,
        	dataaccess.query.QueryPackage.eINSTANCE,

        	behavioral.actions.ActionsPackage.eINSTANCE, behavioral.bpdm.BpdmPackage.eINSTANCE,
        	behavioral.businesstasks.BusinesstasksPackage.eINSTANCE, behavioral.events.EventsPackage.eINSTANCE,
        	behavioral.rules.RulesPackage.eINSTANCE,

        	persistence.actions.ActionsPackage.eINSTANCE, persistence.expressions.ExpressionsPackage.eINSTANCE);
    }

    public List<OCLExpressionWithContext> pickUpExpressions(EPackage... packages){
        List<OCLExpressionWithContext> expressionSet = new ArrayList<OCLExpressionWithContext>(
                searchAndParseExpressions(packages));
        return expressionSet;
    }

    private Collection<OCLExpressionWithContext> searchAndParseExpressions(EPackage... ps) {
        Collection<OCLExpressionWithContext> allConstraints = new HashSet<OCLExpressionWithContext>();
	for (EPackage p : ps) {
	    for (EClassifier c : p.getEClassifiers()) {
	        if (c instanceof EClass) {
	            for (OCLExpression invariant : getInvariants((EClass) c)) {
	                allConstraints.add(new OCLExpressionWithContext(invariant, (EClass) c));
	            }
                    for (EAttribute at : ((EClass) c).getEAttributes()) {
                        EAnnotation a = at.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
                        if (a != null) {
                            System.out.println("hurra");
                            allConstraints.add(new OCLExpressionWithContext(SettingBehavior.INSTANCE.getFeatureBody(
                                    OCL.newInstance(), at), (EClass) c));
                        }
                    }
	        }
	    }
	}
	return allConstraints;
    }
    
    private Collection<OCLExpression> getInvariants(EClass c) {
        Collection<OCLExpression> result = new HashSet<OCLExpression>();
        EAnnotation ann = c.getEAnnotation(EcorePackage.eNS_URI);
        if (ann != null) {
            String spaceSeparatedConstraintNames = ann.getDetails().get("constraints");
            if (spaceSeparatedConstraintNames != null) {
                String[] constraintNames = spaceSeparatedConstraintNames.split(" ");
                for (final String constraintName : constraintNames) {
                    OCLExpression invariant = ValidationBehavior.INSTANCE.getInvariant(c,
                            constraintName, OCL.newInstance());
                    result.add(invariant);
                }
            }
        }
        return result;
    }
}
