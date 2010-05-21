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
 * $Id: ClassifierContextScopeAdapter.java,v 1.5 2010/05/21 20:20:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
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
			if (csClassifierRef != null) {
				ClassifierCS csClassifier = csClassifierRef.getClassifier();
				environmentView.addElementsOfScope(csClassifier, scopeView);
				String selfName = getTarget().getSelfName();
				if (selfName == null) {
					selfName = "self";
				}
				environmentView.addElement(selfName, csClassifier, scopeView.getBindings());
				DocumentCS document = getDocumentScopeAdapter().getTarget();
				for (Iterator<EObject> it = document.eAllContents(); it.hasNext(); ) {
					EObject eObject = it.next();	// FIXME Need to create the csClassifier features
					if (eObject instanceof ClassifierContextDeclCS) {
						ClassifierContextDeclCS csClassifierContext2 = (ClassifierContextDeclCS)eObject;
						ClassifierRefCS csClassifierRef2 = csClassifierContext2.getClassifier();
						ClassifierCS csClassifier2 = csClassifierRef2 != null ? csClassifierRef2.getClassifier() : null;
						if (csClassifier == csClassifier2) {
							for (DefCS def : csClassifierContext2.getDefs()) {
								environmentView.addElement(def.getConstrainedName(), def, scopeView.getBindings());
							}
						}
					}
				}
			}
			return scopeView.getOuterScope();
		}
	}
}
