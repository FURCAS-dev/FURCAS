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
 * $Id: OverviewComposite.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.internal;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This is a sample implementation of an outline control showing an overview of
 * a graphical editor. <br>
 * creation : 8 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class OverviewComposite extends Composite {

	/** the control of the _overview */
	private Canvas _overview;

	/** the root edit part */
	private ScalableFreeformRootEditPart _rootEditPart;

	/** the _thumbnail */
	private Thumbnail thumbnail;

	/**
	 * Creates a new OverviewOutlinePage instance.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param rootEditPart
	 *            the root edit part
	 */
	public OverviewComposite(Composite parent, ScalableFreeformRootEditPart rootEditPart) {
		super(parent, SWT.BORDER);
		_rootEditPart = rootEditPart;

		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);
		setLayoutData(new GridData(GridData.FILL_BOTH));
		createControl(this);
	}

	/**
	 * Creates the inner controls
	 * 
	 * @param parent
	 *            the parent composite
	 */
	public void createControl(Composite parent) {
		// create canvas and lws
		_overview = new Canvas(parent, SWT.NONE);
		_overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		LightweightSystem lws = new LightweightSystem(_overview);

		// create _thumbnail
		thumbnail = new ScrollableThumbnail((Viewport) _rootEditPart.getFigure());
		thumbnail.setBorder(new MarginBorder(3));
		thumbnail.setSource(_rootEditPart.getLayer(LayerConstants.SCALABLE_LAYERS));

		lws.setContents(thumbnail);
		// _thumbnail.setSource(_rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS));
		// lws.setContents(_thumbnail);
	}

	/**
	 * @see org.eclipse.ui.part.IPage#dispose()
	 */
	public void dispose() {
		if (null != thumbnail) {
			thumbnail.deactivate();
			thumbnail = null;
		}

		super.dispose();
	}

	/**
	 * @see org.eclipse.swt.widgets.Control#setVisible(boolean)
	 */
	public void setVisible(boolean state) {
		thumbnail.setVisible(state);
		super.setVisible(state);
	}

	/**
	 * @return the main control
	 */
	public Control getControl() {
		return _overview;
	}

	/**
	 * @return <code>true</code> if the focus succeed
	 */
	public boolean setFocus() {
		if (getControl() != null) {
			return getControl().setFocus();
		}

		return false;
	}
}
