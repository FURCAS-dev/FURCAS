/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

public abstract class PreferencesInitializer extends AbstractPreferenceInitializer {
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public abstract void initializeDefaultPreferences();

	/**
	 * For the given preferences level, clear the values of preferences that
	 * are initialized by this initializer.
	 * 
	 * @param level	The name of the preferences level for which preference
	 * 				values are to be cleared.
	 */
	public abstract void clearPreferencesOnLevel(String level);
}
