/***********************************************************************
 * Copyright (c) 2007,2008 Harman/Becker Automotive Systems GmbH and 
 * others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * ProjectPropertyPage.java
 * 
 * Contributors:
 *    Daniel Weber - initial API and implementation
 *    Lucas Bigeardel - IP integration
 * 
 * $Id: ProjectPropertyPage.java,v 1.3 2008/04/28 12:23:25 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.codegen.builder.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecoretools.codegen.builder.EmfBuilderPrefsInitializer;
import org.eclipse.emf.ecoretools.codegen.builder.genmodelBuilder.l10n.Messages;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * Implementation of a properties page for projects. It leverages preference
 * page's field editors to modify properties. Properties are mapped to
 * project-scoped preferences.
 * 
 * @author DaWeber
 */
public class ProjectPropertyPage extends FieldEditorPreferencePage implements
      IWorkbenchPropertyPage
{

   private IProject              project         = null;
   private ScopedPreferenceStore preferenceStore = null;

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.jface.preference.PreferencePage#doGetPreferenceStore()
    */
   @Override
   protected IPreferenceStore doGetPreferenceStore()
   {
      // create lazily. Is set to null for new projects
      if(null == preferenceStore)
      {
         preferenceStore = new ScopedPreferenceStore(new ProjectScope(project),
               EmfBuilderPrefsInitializer.PREFERENCE_NODE_NAME);
      }
      return preferenceStore;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
    */
   @Override
   protected void createFieldEditors()
   {
      addField(new BooleanFieldEditor(
            EmfBuilderPrefsInitializer.PREF_GENERATE_MODEL_CODE, Messages.getString("ProjectPropertyPage.GenModel.Label"), //$NON-NLS-1$
            getFieldEditorParent()));
      addField(new BooleanFieldEditor(EmfBuilderPrefsInitializer.PREF_GENERATE_EDIT_CODE,
    		  Messages.getString("ProjectPropertyPage.GenEdit.Label"),  //$NON-NLS-1$
    		  getFieldEditorParent()));
      addField(new BooleanFieldEditor(
            EmfBuilderPrefsInitializer.PREF_GENERATE_EDITOR_CODE, Messages.getString("ProjectPropertyPage.GenEditor.Label"), //$NON-NLS-1$
            getFieldEditorParent()));
      addField(new BooleanFieldEditor(EmfBuilderPrefsInitializer.PREF_GENERATE_TEST_CODE,
    		  Messages.getString("ProjectPropertyPage.GenTest.Label"),  //$NON-NLS-1$
    		  getFieldEditorParent()));
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.ui.IWorkbenchPropertyPage#getElement()
    */
   public IAdaptable getElement()
   {
      return project;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.ui.IWorkbenchPropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
    */
   public void setElement(IAdaptable element)
   {
      if(element != project)
      {
         preferenceStore = null;
         this.project = (IProject)element.getAdapter(IProject.class);
      }
   }
}
