/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *
 * $Id: IEcoreToolsPreferenceConstants.java,v 1.2 2009/01/29 10:02:08 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.preferences;

/**
 * Defines custom preference constants for the Ecore Tools graphical editor
 * <p>
 * This interface defines constants only, it is <EM>not</EM> intended to be
 * implemented by clients.
 * </p>
 * 
 * @author Jacques Lescot
 */
public interface IEcoreToolsPreferenceConstants {

	/** use Gradient to render figures - Appearance Preference */
	public static final String PREF_FILL_FIGURE_USING_GRADIENT = "Appearance.fillFigureUsingGradient"; //$NON-NLS-1$

	/** use Shadow on borders when rendering figures - Appearance Preference */
	public static final String PREF_USE_SHADOW_ON_BORDER = "Appearance.useShadowOnBorder"; //$NON-NLS-1$
}
