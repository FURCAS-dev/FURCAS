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
 * $Id: EssentialOCLUtils.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;

public class EssentialOCLUtils	// FIXME Find some extensible instantiation echanism
{
	/**
	 * Return the element associated with csElement for which there is a
	 * pivot element with an identical moniker.
	 * @param csElement
	 * @return the csElement with a matching pivot element
	 */
	public static MonikeredElementCS getPivotedCS(EObject csElement) {
		if (csElement instanceof InfixExpCS) {
			OperatorCS csOperator = ((InfixExpCS)csElement).getOwnedOperator().get(0);
			while (csOperator.getParent() != null) {
				csOperator = csOperator.getParent();
			}
			return getPivotedCS(csOperator);
		}
		else if (csElement instanceof NavigatingArgCS) {
			return getPivotedCS(((NavigatingArgCS)csElement).getName());
		}
		else if (csElement instanceof NavigatingExpCS) {
			return getPivotedCS(((NavigatingExpCS)csElement).getNamedExp());
		}
		else if (csElement instanceof NavigationOperatorCS) {
			return getPivotedCS(((NavigationOperatorCS)csElement).getArgument());
//			if (argument instanceof NameExpCS) {
//				return (MonikeredElementCS) csElement;	// PropertyCall
//				OperatorCS parent = ((NavigationOperatorCS)csElement).getParent();
//				return  parent != null ? parent : getPivotedCS(csElement.eContainer().eContainer());	// PropertyCall
//			}
//			else {
//				return getPivotedCS(argument);			// OperationCall
//			}
		}
		else if (csElement instanceof NestedExpCS) {
			return getPivotedCS(((NestedExpCS)csElement).getSource());
		}
		else if (csElement instanceof PrefixExpCS) {
			return getPivotedCS(((PrefixExpCS)csElement).getOwnedOperator().get(0));
		}
		else if (csElement instanceof MonikeredElementCS) {
			return (MonikeredElementCS) csElement;
		}
		else {
			return null;
		}
	}

	/**
	 * Return the CS element from the CS elements associated with the
	 * same pivot element as csElement, whose child-parent relationship
	 * corresponds to the child-parent relationship of the pivot element.
	 * 
	 * @param csElement for which the child counterpart is required
	 * @return the child counterpart
	 */
	public static ElementCS getPivotingChildCS(ElementCS csElement) {
//		assert csElement == getPivotedCS(csElement);
		if (csElement instanceof ExpCS) {
			OperatorCS operator = ((ExpCS) csElement).getParent();
			if ((operator instanceof NavigationOperatorCS) && (csElement != operator.getSource())) {
				return getPivotingChildCS(operator);
			}
			else if (operator != null) {
				return csElement;
			}
		}
		if (csElement instanceof NavigatingArgCS) {
			return csElement;
		}
		EObject csParent = csElement.eContainer();
		if (csParent instanceof InfixExpCS) {
			return getPivotingChildCS((InfixExpCS) csParent);
		}
		else if (csParent instanceof NavigatingArgCS) {
			return (NavigatingArgCS) csParent;
//			return getPivotingChildCS((NavigatingArgCS) csParent);
		}
		else if (csParent instanceof NavigatingExpCS) {
			return getPivotingChildCS((NavigatingExpCS) csParent);
//			NavigatingExpCS csNavigatingExp = (NavigatingExpCS)csParent;
//			if (csElement == csNavigatingExp.getNamedExp()) {
//				return getChildCS(csNavigatingExp.getParent());
//			}
//			else {
//				return csElement;
//			}
		}
		else if (csParent instanceof NestedExpCS) {
			return getPivotingChildCS((NestedExpCS) csParent);
		}
		else if (csParent instanceof PrefixExpCS) {
			return getPivotingChildCS((PrefixExpCS) csParent);
		}
		else {
			return csElement;
		}
	}

	// FIXME Simplify since csElement is the immediate child
	public static MonikeredElementCS getPivotingParentCS(ElementCS csElement) {
//		assert csElement == getPivotingChildCS(csElement);
		if (csElement instanceof ExpCS) {
			OperatorCS operator = ((ExpCS) csElement).getParent();
			if (operator != null) {
				return operator;
			}
		}
		EObject csParent = csElement.eContainer();
/*		if (csParent instanceof InfixExpCS) {
			return getPivotingParentCS((InfixExpCS)csParent);
		}
		else if (csParent instanceof NavigatingArgCS) {
			return getPivotingParentCS((NavigatingArgCS)csParent);
		}
		else if (csParent instanceof NavigatingExpCS) {
			NavigatingExpCS csNavigatingExp = (NavigatingExpCS)csParent;
			if (csElement == csNavigatingExp.getNamedExp()) {
				return getPivotingParentCS(csNavigatingExp.getParent());
			}
			else {
				return (MonikeredElementCS) csParent;
//				return getParent(csNavigatingExp);
			}
		}
		else if (csParent instanceof NestedExpCS) {
			return getPivotingParentCS((NestedExpCS)csParent);
		}
		else if (csParent instanceof PrefixExpCS) {
			return getPivotingParentCS((PrefixExpCS)csParent);
		}
		else*/ if (csParent instanceof MonikeredElementCS) {
			return (MonikeredElementCS) csParent;
		}
		else {
			return null;
		}
	}

	// FIXME Simplify since csElement is the immediate child
	public static EReference getPivotingFeature(ElementCS csChildElement, ElementCS csParentElement) {
		assert csChildElement == getPivotingChildCS(csChildElement);
		assert csParentElement == getPivotingParentCS(csChildElement);
		if (csParentElement instanceof OperatorCS) {
			if (((OperatorCS)csParentElement).getSource() == csChildElement) {
				return EssentialOCLCSTPackage.Literals.OPERATOR_CS__SOURCE;
			}
			else {
				return EssentialOCLCSTPackage.Literals.BINARY_OPERATOR_CS__ARGUMENT;
			}
		}
		return (EReference) csChildElement.eContainingFeature();
/*		EObject csParent = csChildElement.eContainer();
		if (csParent instanceof InfixExpCS) {
			return getPivotingFeature((InfixExpCS) csParent);
		}
		else if (csParent instanceof NavigatingArgCS) {
//			return EssentialOCLCSTPackage.Literals.NAVIGATING_EXP_CS__ARGS; //getParentChildFeature((NavigatingArgCS) csParent);
			return getPivotingFeature((NavigatingArgCS) csParent);
		}
		else if (csParent instanceof NavigatingExpCS) {
			NavigatingExpCS csNavigatingExp = (NavigatingExpCS)csParent;
			if (csChildElement == csNavigatingExp.getNamedExp()) {
				return getPivotingFeature(csNavigatingExp.getParent());
			}
			else {
				return EssentialOCLCSTPackage.Literals.NAVIGATING_EXP_CS__ARGUMENT;
			}
		}
		else if (csParent instanceof NestedExpCS) {
			return getPivotingFeature((NestedExpCS) csParent);
		}
		else if (csParent instanceof PrefixExpCS) {
			return getPivotingFeature((PrefixExpCS) csParent);
		}
		else {
			return (EReference) csChildElement.eContainingFeature();
		} */
	}
}
