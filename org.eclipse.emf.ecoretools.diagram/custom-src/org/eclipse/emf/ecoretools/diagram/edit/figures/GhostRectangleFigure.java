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
 * $Id: GhostRectangleFigure.java,v 1.1 2008/08/12 13:24:50 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;

/**
 * A "ghost" rectangleFigure <br>
 * Useful for feedback on figures which use gradient <br>
 * creation : 17 mai. 08
 * 
 * @author <a href="mailto:simon.bernard@anyware-tech.com">Simon Bernard</a>
 */
public class GhostRectangleFigure extends RectangleFigure {

	public GhostRectangleFigure() {
		setBackgroundColor(DiagramColorConstants.diagramGray);
		setForegroundColor(DiagramColorConstants.black);
		setLineStyle(Graphics.LINE_DOT);
	}

	@Override
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setAlpha(125);
		super.fillShape(graphics);
		graphics.popState();
	}
}
