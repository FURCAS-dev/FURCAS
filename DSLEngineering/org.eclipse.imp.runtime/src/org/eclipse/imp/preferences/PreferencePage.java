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

import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
    public PreferencePage() {
        super(GRID);
        setPreferenceStore(RuntimePlugin.getInstance().getPreferenceStore());
        setDescription("Preferences for the IMP framework");
    }

    public void createFieldEditors() {
        final BooleanFieldEditor spacesForTabsField= new BooleanFieldEditor(PreferenceConstants.P_SPACES_FOR_TABS, "Use spaces instead of tabs",
                getFieldEditorParent());
        addField(spacesForTabsField);

        final BooleanFieldEditor emitMessagesField= new BooleanFieldEditor(PreferenceConstants.P_EMIT_MESSAGES, "E&mit diagnostic messages from IMP UI",
                getFieldEditorParent());
        addField(emitMessagesField);

        final BooleanFieldEditor dumpTokensField= new BooleanFieldEditor(PreferenceConstants.P_DUMP_TOKENS, "&Dump tokens after scanning",
                getFieldEditorParent());
        addField(dumpTokensField);

        final BooleanFieldEditor emitBuilderDiagnosticsField= new BooleanFieldEditor(PreferenceConstants.P_EMIT_BUILDER_DIAGNOSTICS, "Emit diagnostic messages while building",
                getFieldEditorParent());
        addField(emitBuilderDiagnosticsField);

        final IntegerFieldEditor tabWidthField= new IntegerFieldEditor(PreferenceConstants.P_TAB_WIDTH, "&Tab width:", getFieldEditorParent());
        tabWidthField.setValidRange(1, 16);
        tabWidthField.setTextLimit(2);
        tabWidthField.setEmptyStringAllowed(false);
        addField(tabWidthField);

        final FontFieldEditor fontField= new FontFieldEditor(PreferenceConstants.P_SOURCE_FONT, "Source font:", getFieldEditorParent());
        addField(fontField);

        // Don't need a preference store listener here; the UniversalEditor already listens
        // to the preference store, and takes the necessary actions. Moreover, some preference
        // changes require some resource management that only it can do properly (e.g. it must
        // only dispose of the old Font *after* telling the ITextViewer to use the new one).
    }

    public void init(IWorkbench workbench) {
    }
}
