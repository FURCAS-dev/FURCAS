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
 * $Id: GradientRectangleFigure.java,v 1.2 2009/01/29 10:02:08 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;

/**
 * A Rectangle which is draw with gradient property<br>
 * creation : 17 mai. 08
 * 
 * @author <a href="mailto:simon.bernard@anyware-tech.com">Simon Bernard</a>
 */
public class GradientRectangleFigure extends RectangleFigure {

	private boolean useGradient = true;

	/**
	 * Sets whether the gradient should be used when rendering the figure
	 * 
	 * @param drawDropShadow
	 */
	public void setShouldUseGradient(boolean shouldUseGradient) {
		this.useGradient = shouldUseGradient;
	}

	/**
	 * @return true if gradient should be used when rendering the figure
	 */
	public boolean shouldUseGradient() {
		return useGradient;
	}

	@Override
	protected void fillShape(Graphics graphics) {
		if (shouldUseGradient()) {
			graphics.pushState();
			graphics.setBackgroundColor(DiagramColorConstants.white);
			graphics.setForegroundColor(getBackgroundColor());
			graphics.fillGradient(getBounds(), true);
			graphics.popState();
		} else {
			super.fillShape(graphics);
		}
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);
	}
}
