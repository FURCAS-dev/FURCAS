/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.expressions;

import java.util.Map;

import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 * @author Tim Klinger (tklinger)
 *
 * A visitor which can evaluate an OCLExpression
 */
public interface EvaluationVisitor extends org.eclipse.emf.ocl.expressions.Visitor {
	EvaluationEnvironment getEvalEnvironment();
	void setEvalEnvironment(EvaluationEnvironment env);
	Map getExtentMap();
	void setExtentMap(Map extentMap);

}
