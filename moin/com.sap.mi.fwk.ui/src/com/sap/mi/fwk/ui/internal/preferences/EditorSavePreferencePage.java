package com.sap.mi.fwk.ui.internal.preferences;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;

public class EditorSavePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_EDITORS);

	public EditorSavePreferencePage() {
		super(GRID);
		setPreferenceStore(MiFwkUIPlugin.getDefault().getPreferenceStore());
		setDescription(MiFwkUiMessages.ModelEditorSavePreferencePage_mode_editor_save_operations);
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {

		addField(new BooleanFieldEditor(EditorSaveConstants.SHOW_EDITOR_SAVE_DIALOG,
				MiFwkUiMessages.ModelEditorSavePreferencePage_show_editor_save_dialog, getFieldEditorParent()));

		if (sTracer.isLoggable(Level.FINE)) {
			sTracer.logp(Level.FINE, "EditorSavePreferencePage", "createFieldEditors", "Fields created"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
