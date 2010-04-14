/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: DiagramPreferenceInitializer.java,v 1.5 2009/02/02 08:39:08 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize new preferences added to support Sexy UI feature
	 * 
	 * @generated NOT
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramPrintingPreferencePage.initDefaults(store);
		DiagramGeneralPreferencePage.initDefaults(store);
		DiagramAppearancePreferencePage.initDefaults(store);
		DiagramConnectionsPreferencePage.initDefaults(store);
		DiagramRulersAndGridPreferencePage.initDefaults(store);

		store.setDefault(IEcoreToolsPreferenceConstants.PREF_FILL_FIGURE_USING_GRADIENT, true);
		store.setDefault(IEcoreToolsPreferenceConstants.PREF_USE_SHADOW_ON_BORDER, true);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return EcoreDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
