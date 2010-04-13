/***********************************************************************
 * Copyright (c) 2007,2008 Harman/Becker Automotive Systems GmbH and 
 * others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * EmfBuilderPrefsInitializer.java
 * 
 * Contributors:
 *    Harman/Becker - initial API and implementation
 *    Lucas Bigeardel - IP integration
 * 
 * $Id: EmfBuilderPrefsInitializer.java,v 1.3 2008/09/06 17:05:00 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.codegen.builder;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * Provides default values for EMF generator builder preferences
 * 
 * @author DaWeber
 */
public class EmfBuilderPrefsInitializer extends AbstractPreferenceInitializer
{
   public static final String PREFERENCE_NODE_NAME      = "org.eclipse.emf.ecoretools.codegen.builder"; //$NON-NLS-1$
   public static final String PREF_GENERATE_MODEL_CODE  = "generate.modelCode"; //$NON-NLS-1$
   public static final String PREF_GENERATE_EDIT_CODE   = "generate.editCode"; //$NON-NLS-1$
   public static final String PREF_GENERATE_EDITOR_CODE = "generate.editorCode"; //$NON-NLS-1$
   public static final String PREF_GENERATE_TEST_CODE   = "generate.testCode"; //$NON-NLS-1$

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
    */
   @Override
   public void initializeDefaultPreferences()
   {
      IEclipsePreferences node = new DefaultScope().getNode(PREFERENCE_NODE_NAME);
      // build only model code by default
      node.putBoolean(PREF_GENERATE_MODEL_CODE, true);
      node.putBoolean(PREF_GENERATE_EDIT_CODE, false);
      node.putBoolean(PREF_GENERATE_EDITOR_CODE, false);
      node.putBoolean(PREF_GENERATE_TEST_CODE, false);
   }

}
