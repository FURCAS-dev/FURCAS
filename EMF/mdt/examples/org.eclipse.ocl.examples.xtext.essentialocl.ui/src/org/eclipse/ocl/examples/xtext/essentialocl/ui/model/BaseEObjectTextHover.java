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
 * $Id: BaseEObjectTextHover.java,v 1.3 2011/02/15 19:58:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintExprVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintNameVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintTypeVisitor;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;

public class BaseEObjectTextHover extends DispatchingEObjectTextHover
{
	@Override
	public Object getHoverInfo(EObject eObject, ITextViewer textViewer, IRegion hoverRegion) {
		Element pivotElement = null;
		if (eObject instanceof Pivotable) {
			pivotElement = PivotUtil.getPivot(Element.class, (Pivotable)eObject);
		}
		else if (eObject instanceof Element) {
			pivotElement = (Element)eObject;
		}
		if (pivotElement != null) {
			Namespace namespace = PrettyPrintExprVisitor.getNamespace(pivotElement);
			String description;
			if (pivotElement instanceof CallExp) {
				description = PrettyPrintNameVisitor.prettyPrint(PivotUtil.getReferredFeature((CallExp)pivotElement), namespace);
			}
			else if (pivotElement instanceof OclExpression) {
				description = PrettyPrintTypeVisitor.prettyPrint(((OclExpression)pivotElement).getType(), namespace);
			}
			else {
				description = PrettyPrintExprVisitor.prettyPrint(pivotElement, namespace);
			}
			return pivotElement.eClass().getName() + ": " + description;
//			return pivotElement.eClass().getName() + " <b>" + description + "</b>";
		}
		else {
			return eObject.eClass().getName();		// FIXME do better					
		}
	}
}