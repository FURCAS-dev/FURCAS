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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer.OclExpressionWithPackage;


public class OCLExpressionWithContext {
    private OCLExpression expr;
    private EClass classifier;
    private OclExpressionWithPackage oclWithPackage;

    public OCLExpressionWithContext(OCLExpression e, EClass c) {
        this(e,c,null);
    }

    public OCLExpressionWithContext(OCLExpression e, EClass c, OclExpressionWithPackage oclWithPackage) {
        this.setOclWithPackage(oclWithPackage);
	setContext(c);
        setExpression(e);
    }

    @Override
    public String toString() {
        return "context " + getContext().getName() + " : " + getExpression().toString();
    }

    public void setContext(EClass classifier) {
	this.classifier = classifier;
    }

    public EClass getContext() {
	return classifier;
    }

    public void setExpression(OCLExpression expr) {
	this.expr = expr;
    }

    public OCLExpression getExpression() {
	return expr;
    }

    public void setOclWithPackage(OclExpressionWithPackage oclWithPackage) {
	this.oclWithPackage = oclWithPackage;
    }

    public OclExpressionWithPackage getOclWithPackage() {
	return oclWithPackage;
    }

}
