/**
 * <copyright>
 *
 * Copyright (c) 2007,2011 IBM Corporation and others.
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
 * $Id: OCLHelperImpl.java,v 1.5 2011/02/11 20:00:29 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * Implementation of the {@link OclMetaModel.Helper} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLHelperImpl extends OCLBaseHelperImpl
{
	public OCLHelperImpl(OCL ocl) {
		super(ocl);
    }

	public ExpressionInOcl createBodyCondition(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createDerivedValueExpression(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createInvariant(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createPostcondition(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createPrecondition(String expression) throws ParserException {
		return createSpecification(expression);
	}

	public ExpressionInOcl createQuery(String expression) throws ParserException {
		return createSpecification(expression);
	}

	protected ExpressionInOcl createSpecification(String expression) throws ParserException {
		PivotEnvironment environment = (PivotEnvironment) getEnvironment();
		TypeManager typeManager = environment.getTypeManager();
		Type contextClassifier = environment.getContextClassifier();
		return PivotUtil.resolveSpecification(typeManager, contextClassifier, expression);
	}
}
