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
package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ocl.ecore.ExpressionInOCL;

public class ExampleApp extends AdapterImpl {
    private final ExpressionInOCL expression;
    private final HashSet<ExpressionInOCL> affectedStmts;

    public ExampleApp(ExpressionInOCL exp, HashSet<ExpressionInOCL> affectedStmts) {
        this.expression = exp;
        this.affectedStmts = affectedStmts;
    }

    @Override
    public void notifyChanged(Notification msg) {
        this.affectedStmts.add(expression);
    }

}
