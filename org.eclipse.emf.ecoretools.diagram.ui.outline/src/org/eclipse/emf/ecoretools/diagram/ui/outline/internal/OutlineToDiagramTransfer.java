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
 * $Id: OutlineToDiagramTransfer.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.internal;

import org.eclipse.gef.dnd.SimpleObjectTransfer;

/**
 * This Transfer expects a java.util.List as the object being transferred.
 * 
 * <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public final class OutlineToDiagramTransfer extends SimpleObjectTransfer {

	/**
	 * <code>TYPE_NAME</code>: key used to mark the type of transfer
	 */
	public static final String TYPE_NAME = "Outline To Diagram Transfer"; //$NON-NLS-1$

	private static OutlineToDiagramTransfer TRANSFER = null;

	private static final int TYPE_ID = registerType(TYPE_NAME);

	private OutlineToDiagramTransfer() {
		// Do nothing
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the singleton
	 */
	public static OutlineToDiagramTransfer getInstance() {
		if (TRANSFER == null) {
			TRANSFER = new OutlineToDiagramTransfer();
		}

		return TRANSFER;
	}

	/**
	 * @see org.eclipse.swt.dnd.Transfer#getTypeIds()
	 */
	protected int[] getTypeIds() {
		return new int[] { TYPE_ID };
	}

	/**
	 * @see org.eclipse.swt.dnd.Transfer#getTypeNames()
	 */
	protected String[] getTypeNames() {
		return new String[] { TYPE_NAME };
	}

}
