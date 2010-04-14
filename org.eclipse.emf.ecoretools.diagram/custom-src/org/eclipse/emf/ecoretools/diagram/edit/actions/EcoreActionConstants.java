/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *
 * $Id: EcoreActionConstants.java,v 1.1 2009/03/19 14:35:47 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.actions;

/**
 * Defines Action constants
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface EcoreActionConstants {

	/** The ID for the navigation to the parent diagram action. */
	String OPEN_PARENT_DIAGRAM = "org.eclipse.emf.ecoretools.diagram.edit.actions.openParentDiagram"; //$NON-NLS-1$

	/** The ID for the previous diagram action. */
	String PREVIOUS_DIAGRAM = "org.eclipse.emf.ecoretools.diagram.edit.actions.previousDiagram"; //$NON-NLS-1$

	/** The ID for the next diagram action. */
	String NEXT_DIAGRAM = "org.eclipse.emf.ecoretools.diagram.edit.actions.nextDiagram"; //$NON-NLS-1$
}
