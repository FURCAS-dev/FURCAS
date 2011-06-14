/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: AbstractOperationFilter.java,v 1.3 2011/04/25 19:39:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public abstract class AbstractOperationFilter implements EnvironmentView.Filter
{
	protected final TypeManager typeManager;
	protected final Type sourceType;
	
	public AbstractOperationFilter(TypeManager typeManager, Type sourceType) {
		this.typeManager = typeManager;
		this.sourceType = PivotUtil.getBehavioralType(sourceType);
	}

	public int compareMatches(EObject match1, Map<TemplateParameter, ParameterableElement> bindings1,
			EObject match2, Map<TemplateParameter, ParameterableElement> bindings2) {
		int comparison = typeManager.compareOperationMatches((Operation)match1, bindings1,
			(Operation)match2, bindings2);
//		if (comparison == 0) {
//			typeManager.compareOperationMatches((Operation)match1, bindings1,
//				(Operation)match2, bindings2);	// FIXME Debugging
//		}
		return comparison;
	}

	protected Map<TemplateParameter, ParameterableElement> getOperationBindings(Operation candidateOperation) {
		Type sourceType = this.sourceType;
		if (!(sourceType instanceof CollectionType) && (candidateOperation.getClass_() instanceof CollectionType)) {
			sourceType = typeManager.getCollectionType("Set", sourceType);		// Implicit oclAsSet()
		}			
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
//			PivotUtil.getAllTemplateParameterSubstitutions(bindings, candidateOperation);
		TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
		if (templateSignature != null) {
			for (TemplateParameter templateParameter : templateSignature.getOwnedParameters()) {
				if (bindings == null) {
					bindings = new HashMap<TemplateParameter, ParameterableElement>();
				}
				bindings.put(templateParameter, null);
			}
		}
		return bindings;
	}

	protected void installBindings(EnvironmentView environmentView, Type forType, EObject eObject,
			Map<TemplateParameter, ParameterableElement> bindings) {
		environmentView.setBindings(eObject, bindings);
	}
}