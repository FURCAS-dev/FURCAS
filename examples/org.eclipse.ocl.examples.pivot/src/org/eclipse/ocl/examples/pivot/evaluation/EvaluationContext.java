/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluationContext.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.evaluation;

import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotEnvironment;

public interface EvaluationContext
{
	NamedElement getSpecificationContext();
	PivotEnvironment getEnvironment();
	void setSpecificationContext(NamedElement context);
	void setEnvironment(PivotEnvironment environment);
}
