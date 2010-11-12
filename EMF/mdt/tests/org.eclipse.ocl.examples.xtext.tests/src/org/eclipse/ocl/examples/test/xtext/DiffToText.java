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
 * $Id: DiffToText.java,v 1.1 2010/05/03 05:34:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.xtext;

import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

class DiffToText extends DiffSwitch<Boolean>
{
	protected final StringBuffer s;
	protected int depth = 0;

	public DiffToText(StringBuffer s) {
		this.s = s;
	}

	@Override
	public Boolean caseDiffElement(DiffElement object) {
		indent();
		s.append(object.toString());
		return true;
	}

	@Override
	public Boolean caseDiffGroup(DiffGroup object) {
		boolean isRoot = object.eContainer() instanceof DiffModel;
		if (!isRoot) {				
			indent();
			depth++;
			s.append(object.toString());
		}
		for (DiffElement diffElement : object.getSubDiffElements()) {
			doSwitch(diffElement);
		}
		if (!isRoot) {
			depth--;
		}
		return true;
	}

	@Override
	public Boolean caseDiffModel(DiffModel object) {
		for (DiffElement diffElement : object.getOwnedElements()) {
			doSwitch(diffElement);
		}
		return true;
	}

	@Override
	public Boolean caseUpdateAttribute(UpdateAttribute object) {
		indent();
		s.append(object.toString());
		return false;
	}

	@Override
	public Boolean caseUpdateReference(UpdateReference object) {
		indent();
		s.append(object.toString());
		return false;
	}

	@Override
	public Boolean defaultCase(EObject object) {
		indent();
		s.append("<<");
		s.append(object.getClass());
		s.append(">>");
		for (EStructuralFeature eFeature : object.eClass().getEAllStructuralFeatures()) {
			if ((eFeature instanceof EReference) && ((EReference)eFeature).isContainment()) {
				depth++;
				Object child = object.eGet(eFeature);
				if (eFeature.isMany()) {
					@SuppressWarnings("unchecked")
					List<? extends EObject> children = (List<? extends EObject>)child;
					for (EObject eObject : children)
						doSwitch(eObject);
				}
				else {
					doSwitch((EObject) child);
				}
				depth--;
			}
		}
		return super.defaultCase(object);
	}

	protected void indent() {
		s.append("\n");
		for (int i = 0; i < depth; i++) {
			s.append("  ");
		}
	}
}