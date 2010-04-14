/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: PackageLabelRectangle.java,v 1.4 2008/04/28 08:41:33 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * 
 * Figure of the label EPackage <br>
 * creation : 01 sept. 2007
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class PackageLabelRectangle extends RectangleFigure {

	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle r = getBounds();
		int x = r.x + lineWidth / 2;
		int y = r.y + lineWidth / 2;
		int h = r.height;
		int w = r.width - Math.max(1, lineWidth);

		Point p1 = new Point(x, y + h);
		Point p2 = new Point(x, y);
		Point p3 = new Point(x + w, y);
		Point p4 = new Point(x + w, y + h);

		graphics.drawLine(p1, p2);
		graphics.drawLine(p2, p3);
		graphics.drawLine(p3, p4);
	}
}
