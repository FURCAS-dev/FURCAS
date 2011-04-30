package org.eclipse.imp.preferences.fields;

import java.io.File;

import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferencesTab;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;

public class DirectoryFieldEditor extends FileFieldEditor {
    public DirectoryFieldEditor(PreferencePage page, PreferencesTab tab, IPreferencesService service, String level,
            String name, String labelText, int width, int strategy, Composite parent) {
        super(page, tab, service, level, name, labelText, width, strategy, parent);
    }

    public DirectoryFieldEditor(PreferencePage page, PreferencesTab tab, IPreferencesService service, String level,
            String name, String labelText, int width, Composite parent) {
        super(page, tab, service, level, name, labelText, width, parent);
    }

    public DirectoryFieldEditor(PreferencePage page, PreferencesTab tab, IPreferencesService service, String level,
            String name, String labelText, Composite parent) {
        super(page, tab, service, level, name, labelText, parent);
    }

    /**
     * Helper to open the directory chooser dialog.
     * @param startingDirectory the directory to open the dialog on.
     * @return File The directory the user selected or <code>null</code> if they
     * do not.
     */
    @Override
    protected File getFile(File startingDirectory) {
        DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN);
        if (startingDirectory != null)
            dialog.setFilterPath(startingDirectory.getPath());
        String dir = dialog.open();
        if (dir != null) {
            dir = dir.trim();
            if (dir.length() > 0)
                return new File(dir);
        }
        return null;
    }

    @Override
    protected boolean doCheckState(String path) {
        String msg = null;
        if (emptyStringAllowed && path == null || path.length() == 0) {
            clearErrorMessage();
            return true;
        }
        File file = new File(path);
        boolean result = true;

        if (file.isDirectory()) {
            if (getEnforceAbsolute() && !file.isAbsolute())
                msg = JFaceResources.getString("FileFieldEditor.errorMessage2");//$NON-NLS-1$
        } else {
            msg = "Path does not designate a valid directory";
        }

        if (msg != null) {
            setErrorMessage(getFieldMessagePrefix() + msg);
            result = false;
        } else {
            clearErrorMessage();
            result = true;
        }
        return result;
    }
}
