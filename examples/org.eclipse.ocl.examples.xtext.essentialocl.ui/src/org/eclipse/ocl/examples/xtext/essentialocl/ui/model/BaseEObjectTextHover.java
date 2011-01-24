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
 * $Id: BaseEObjectTextHover.java,v 1.2 2011/01/24 21:30:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintNameVisitor;
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
			Namespace namespace = PrettyPrintNameVisitor.getNamespace(pivotElement);
			String description = PrettyPrintNameVisitor.prettyPrint(pivotElement, namespace);
			return pivotElement.eClass().getName() + ": " + description;
//			return pivotElement.eClass().getName() + " <b>" + description + "</b>";
		}
		else {
			return eObject.eClass().getName();		// FIXME do better					
		}
	}
}