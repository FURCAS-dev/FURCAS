/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSResource.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;

public class EssentialOCLCSResource extends LazyLinkingResource
	implements BaseCSResource, EvaluationContext
{
	private PivotEnvironment environment = null;
	
	public CS2Pivot createCS2Pivot(
			Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			TypeManager typeManager) {
		return new EssentialOCLCS2Pivot(cs2pivotResourceMap, typeManager);
	}

	public TypeManager createTypeManager() {
		return new TypeManager();
	}

	public PivotEnvironment getEnvironment() {
		return environment;
	}

	public ProblemHandler getProblemHandler() {
		return environment != null ? environment.getProblemHandler() : null;
	}

	public void setEnvironment(PivotEnvironment environment) {
		this.environment = environment;
	}
}
