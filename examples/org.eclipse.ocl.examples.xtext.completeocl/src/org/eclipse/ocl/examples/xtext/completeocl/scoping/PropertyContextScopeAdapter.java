/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: PropertyContextScopeAdapter.java,v 1.1 2010/05/03 05:58:37 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class PropertyContextScopeAdapter extends EssentialOCLScopeAdapter<PropertyContextDeclCS>
{
	public PropertyContextScopeAdapter(PropertyContextDeclCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == CompleteOCLCSTPackage.Literals.PROPERTY_CONTEXT_DECL_CS__PROPERTY) {
		}
		else {
			StructuralFeatureRefCS csStructuralFeatureRef = getTarget().getProperty();
			while (csStructuralFeatureRef instanceof QualifiedStructuralFeatureRefCS) {
				csStructuralFeatureRef = ((QualifiedStructuralFeatureRefCS)csStructuralFeatureRef).getFeature();
			}
			if (csStructuralFeatureRef instanceof SimpleStructuralFeatureRefCS) {
				SimpleStructuralFeatureRefCS csSimpleStructuralFeatureRef = (SimpleStructuralFeatureRefCS)csStructuralFeatureRef;
				StructuralFeatureCS classifier = csSimpleStructuralFeatureRef.getFeature();
				filteredAccesses.addElementsOfScope(classifier);
				filteredAccesses.addElement("self", (ElementCS) classifier.eContainer());
			}
		}
	}
}
