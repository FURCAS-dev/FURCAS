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
 * $Id: ElementNode.java,v 1.1 2011/05/15 20:18:00 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * ElementNode provide an outline node for the Pivot element that provides the AST of a CST element.
 */
public final class ElementNode extends EObjectNode
{
	public ElementNode(EObject eObject, IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(eObject, parent, image, text, isLeaf);
	}

	@Override
	public <T> T readOnly(final IUnitOfWork<T, EObject> work) {
		if (getEObjectURI() != null) {
			return getDocument().readOnly(new IUnitOfWork<T, XtextResource>() {
				public T exec(XtextResource state) throws Exception {
					CS2PivotResourceAdapter converter = CS2PivotResourceAdapter.findAdapter((BaseCSResource)state);
					if (converter != null) {
						Resource pivotResource = converter.getPivotResource(state);
						if (pivotResource != null) {
							EObject eObject = pivotResource.getEObject(getEObjectURI().fragment());
							return work.exec(eObject);
						}
					}
					return null;
				}

			});
		} else {
			return null;
		}
	}
}