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

package org.eclipse.imp.preferences.fields;

import java.io.File;
import java.util.Stack;

import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferencesTab;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

public class FileFieldEditor extends StringButtonFieldEditor
{
	
	public FileFieldEditor(
			PreferencePage page, PreferencesTab tab,
    		IPreferencesService service, String level, String name, String labelText,
    		int width, int strategy, Composite parent)
    {
    	super(page, tab, service, level, name, labelText, width, strategy, parent);
    	this.getChangeControl(parent).setText(PreferenceDialogConstants.BROWSE_LABEL);
    }
	
	
    /**
     * Creates an IMP file field editor.
     * Use the method <code>setTextLimit</code> to limit the text.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param width the width of the text input field in characters,
     *  or <code>UNLIMITED</code> for no limit
     * @param parent the parent of the field editor's control
     */
    public FileFieldEditor(
			PreferencePage page, PreferencesTab tab,
    		IPreferencesService service, String level, String name, String labelText,
    		int width, Composite parent)
    {
        super(page, tab, service, level, name, labelText, width, StringFieldEditor.VALIDATE_ON_KEY_STROKE, parent);
    	this.getChangeControl(parent).setText(PreferenceDialogConstants.BROWSE_LABEL);
    }
    
    
    /**	
     * Creates an IMP string button field editor.
     * Use the method <code>setTextLimit</code> to limit the text.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param parent the parent of the field editor's control
     */
    public FileFieldEditor(
			PreferencePage page, PreferencesTab tab,
    		IPreferencesService service, String level, String name, String labelText, Composite parent)
    {
        super(page, tab, service, level, name, labelText, parent);
    	this.getChangeControl(parent).setText(PreferenceDialogConstants.BROWSE_LABEL);
    }
 
    
    
    /*
     * Below copied from org.eclipse.jface.preference.FileFieldEditor
     */

    
    /**
     * List of legal file extension suffixes, or <code>null</code>
     * for system defaults.
     */
    private String[] extensions = null;

    /**
     * Indicates whether the path must be absolute;
     * <code>false</code> by default.
     */
    private boolean enforceAbsolute = false;


    /* (non-Javadoc)
     * Method declared on StringButtonFieldEditor.
     * Opens the file chooser dialog and returns the selected file.
     */
    protected String changePressed() {    	
        File f = new File(getTextControl(parent).getText());
        if (!f.exists())
            f = null;
        File d = getFile(f);
        if (d == null)
            return null;

        return d.getAbsolutePath();
    }

    public boolean getEnforceAbsolute() {
        return enforceAbsolute;
    }


    public void setEnforceAbsolute(boolean enforceAbsolute) {
        this.enforceAbsolute = enforceAbsolute;
    }

    /**
     * Helper to open the file chooser dialog.
     * @param startingDirectory the directory to open the dialog on.
     * @return File The File the user selected or <code>null</code> if they
     * do not.
     */
    protected File getFile(File startingDirectory) {
        FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
        if (startingDirectory != null)
            dialog.setFileName(startingDirectory.getPath());
        if (extensions != null)
            dialog.setFilterExtensions(extensions);
        String file = dialog.open();
        if (file != null) {
            file = file.trim();
            if (file.length() > 0)
                return new File(file);
        }
        return null;
    }

    /**
     * Sets this file field editor's file extension filter.
     *
     * @param extensions a list of file extension, or <code>null</code> 
     * to set the filter to the system's default value
     */
    public void setFileExtensions(String[] extensions) {
        this.extensions = extensions;
    }
	    
    
    
    
 
    // getErrorMessage() is defined on StringFieldEditor,
    // and can be set with setErrorMessage(String);
    
    
    protected boolean doCheckState()
    {	
        
        String msg = null;

        // Here we check for empty or null strings, although
        // this may very well be checked at a higher level
        // (so we might not ever get here with this problem)
        String path = getTextControl(parent).getText();
        path= preferencesService.performSubstitutions(path);
        if (path != null)
            path = path.trim();
        else
            path = "";//$NON-NLS-1$
        if (path.length() == 0 && !emptyStringAllowed) {
        		setErrorMessage(getFieldMessagePrefix() + "Path length is zero when empty string is not allowed");
                return false;
        }
        
        // Check for balanced quotes
        final String singleQuote = "'";
        final String doubleQuote = "\"";
        Stack stack = new Stack();
        for (int i = 0; i < path.length(); i++) {
        	if (path.charAt(i) == '\'') {
        		if (!stack.empty() && singleQuote.equals(stack.peek()))
        			stack.pop();
        		else
        			stack.push(singleQuote);
        	}
        	if (path.charAt(i) == '"') {
        		if (!stack.empty() && doubleQuote.equals(stack.peek()))
        			stack.pop();
        		else
        			stack.push(doubleQuote);
        	}
        }
        if (stack.size() != 0)
        	return false;

        // Now validate list segments between quotes
        path = path.replace("\"", "'");
        String[] splits = path.split("'");       
        boolean splitsVerified = true;
        int start = path.startsWith("'") ? 1 : 0;
        for (int i = start; i < splits.length; i++) {
        	splitsVerified = splitsVerified && doCheckState(splits[i]);
        	if (!splitsVerified) {
        		if (!hasErrorMessage()) {
        			setErrorMessage(getFieldMessagePrefix() + "Path segment \"splits[i]\" failed verification");
        		}
        		return false;
        	}
        }
    	clearErrorMessage();
        return true;
    	
    }
    
    
    protected boolean doCheckState(String path)
    {	// This is the real work of the original doCheckState()
        String msg = null;
        File file = new File(path);
        if (file.isFile()) {
            if (enforceAbsolute && !file.isAbsolute())
                msg = JFaceResources.getString("FileFieldEditor.errorMessage2");//$NON-NLS-1$
        } else {
            msg = "Path does not designate a valid file";
        }

        boolean result = true;
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
