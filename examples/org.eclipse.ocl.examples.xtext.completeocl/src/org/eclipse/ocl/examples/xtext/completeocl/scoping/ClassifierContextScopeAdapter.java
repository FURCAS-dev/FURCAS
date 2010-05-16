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
 * $Id: ClassifierContextScopeAdapter.java,v 1.4 2010/05/16 19:26:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;

public class ClassifierContextScopeAdapter extends EssentialOCLScopeAdapter<ClassifierContextDeclCS>
{
	public ClassifierContextScopeAdapter(ClassifierContextDeclCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSTPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS__CLASSIFIER) {
			return scopeView.getOuterScope();
		}
		else {
			ClassifierRefCS csClassifierRef = getTarget().getClassifier();
			while (csClassifierRef instanceof QualifiedClassifierRefCS) {
				csClassifierRef = ((QualifiedClassifierRefCS)csClassifierRef).getElement();
			}
			if (csClassifierRef instanceof SimpleClassifierRefCS) {
				SimpleClassifierRefCS csSimpleClassifierRef = (SimpleClassifierRefCS)csClassifierRef;
				ClassifierCS classifier = csSimpleClassifierRef.getClassifier();
				environmentView.addElementsOfScope(classifier, scopeView);
				environmentView.addElement("self", classifier, scopeView.getBindings());
			}
			return scopeView.getOuterScope();
		}
	}
}
