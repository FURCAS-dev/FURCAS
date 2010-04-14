/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Simon Bernard (Anyware Technologies) - initial API and implementation
 *
 * $Id: AlphaResizableShapeEditPolicy.java,v 1.1 2008/08/12 13:24:50 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.emf.ecoretools.diagram.edit.figures.GhostRectangleFigure;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

/**
 * ResizableShapeEditPolicy which draw rectangle feedback with alpha property
 * instead of XOR<br>
 * Useful to have a best display with gradient figure <br>
 * creation : 17 mai. 08
 * 
 * @author <a href="mailto:simon.bernard@anyware-tech.com">Simon Bernard</a>
 */
public class AlphaResizableShapeEditPolicy extends ResizableShapeEditPolicy {

	@Override
	protected IFigure createDragSourceFeedbackFigure() {
		// Use a ghost rectangle for feedback
		RectangleFigure r = new GhostRectangleFigure();
		r.setBounds(getInitialFeedbackBounds());
		addFeedback(r);
		return r;
	}

}
