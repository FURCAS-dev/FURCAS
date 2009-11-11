package com.sap.ide.moftool.editor.core.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

/**
 * Main preference page for Metamodel editing.
 * Available settings:
 * - Creation of references for navigable association ends. The user can choose if for each
 * new (or changed) navigable association end a reference will be created or not. Additionally
 * he can choose where the reference will be created; possible containing classes are the type
 * (must be a class) of the exposed end of the association of one of its subclasses. This 
 * setting is evaluated whenever a new association is created (a new association always has one
 * navigable end) or an existing association end is set to navigable.
 * - Automatically activate OCL constraints. The user can decide to switch off the automatical
 * activation of edited OCL constraints. Standard is that the constraints are automatically 
 * updated after saving a changed constraint via an Eclipse builder. After switching off the user
 * has to manually trigger the activation via the context menu entry "MOF Editor -> Activate OCL
 * Constraints" from the project context menu in the Metamodel project explorer.
 * @author d027044
 */
public class MainPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public MainPreferencePage() {
		super(GRID);
		setPreferenceStore(MOFToolEditorPlugin.getDefault().getPreferenceStore());
		setDescription(LocalizationMessages.MainPreferencePage_0_XGRP);
	}
	
	public void createFieldEditors() {
		// Creation of references for navigable association ends
		RadioGroupFieldEditor editor = new RadioGroupFieldEditor(PreferenceConstants.NAME_REFERENCE_CREATION,
				LocalizationMessages.MainPreferencePage_1_XMSG, 1,
				new String[][]{{LocalizationMessages.MainPreferencePage_2_XMSG, PreferenceConstants.VALUE_REFERENCE_CREATION_AUTO},
					{LocalizationMessages.MainPreferencePage_3_XMSG, PreferenceConstants.VALUE_REFERENCE_CREATION_ASK},
					{LocalizationMessages.MainPreferencePage_4_XCKL, PreferenceConstants.VALUE_REFERENCE_CREATION_NEVER}},
				getFieldEditorParent(), true);
		addField(editor);
		
		// Add some space before OCL stuff
		new Label(getFieldEditorParent(), SWT.None);
		
		// OCL constraint activation
		BooleanFieldEditor oclActivationEditor = new BooleanFieldEditor(PreferenceConstants.NAME_OCL_AUTO_ACTIVATION,
				LocalizationMessages.MainPreferencePage_5_XMSG,
				getFieldEditorParent());
		addField(oclActivationEditor);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		super.initialize();
	}
}