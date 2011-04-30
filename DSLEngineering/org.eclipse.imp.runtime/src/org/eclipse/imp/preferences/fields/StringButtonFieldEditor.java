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

import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferencesTab;
import org.eclipse.imp.preferences.PreferencesUtilities;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public abstract class StringButtonFieldEditor extends StringFieldEditor {

	public StringButtonFieldEditor(
			PreferencePage page, PreferencesTab tab,
    		IPreferencesService service, String level, String name, String labelText,
    		int width, int strategy, Composite parent)
    {
    	super(page, tab, service, level, name, labelText, width, strategy, parent);
    }
	
	
    /**
     * Creates a IMP string button field editor.
     * Use the method <code>setTextLimit</code> to limit the text.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param width the width of the text input field in characters,
     *  or <code>UNLIMITED</code> for no limit
     * @param parent the parent of the field editor's control
     */
    public StringButtonFieldEditor(
			PreferencePage page, PreferencesTab tab,
    		IPreferencesService service, String level, String name, String labelText,
    		int width, Composite parent)
    {
        super(page, tab, service, level, name, labelText, width, org.eclipse.jface.preference.StringFieldEditor.VALIDATE_ON_KEY_STROKE, parent);
    }
	
    
    /**
     * Creates a IMP string button field editor.
     * Use the method <code>setTextLimit</code> to limit the text.
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param parent the parent of the field editor's control
     */
    public StringButtonFieldEditor(
			PreferencePage page, PreferencesTab tab,
			IPreferencesService service, String level, String name, String labelText, Composite parent)
    {
        super(page, tab, service, level, name, labelText, parent);
    }
    
    
    
    
    /**
     * Informs this field editor's listener, if it has one, about a change
     * to the value (<code>VALUE</code> property) provided that the old and
     * new values are different.
     * <p>
     * This hook is <em>not</em> called when the text is initialized 
     * (or reset to the default value) from the preference store.
     * </p>
     * This extension sets converts any inherited field to a local one.
     * This is done because we don't want to allow inehrited fields to
     * be edited as such.  This extension also maintains the local copy
     * of the previous value.	
     */
    protected boolean valueChanged() {
    	
    	return super.valueChanged();
    }
    
    
	
	/*
	 * Following is all copied from org.eclipse.jface.StringButtonFieldEditor
	 */
	
	
   /**
     * The change button, or <code>null</code> if none
     * (before creation and after disposal).
     */
    private Button changeButton;

    /**
     * The text for the change button, or <code>null</code> if missing.
     */
    private String changeButtonText;


    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void adjustForNumColumns(int numColumns) {
        ((GridData) getTextControl(parent).getLayoutData()).horizontalSpan = numColumns - 2;
    }

    /**
     * Notifies that this field editor's change button has been pressed.
     * <p>
     * Subclasses must implement this method to provide a corresponding
     * new string for the text field. If the returned value is <code>null</code>,
     * the currently displayed value remains.
     * </p>
     *
     * @return the new string to display, or <code>null</code> to leave the
     *  old string showing
     */
    protected abstract String changePressed();

    /* (non-Javadoc)
     * Method declared on StringFieldEditor (and FieldEditor).
     */
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        super.doFillIntoGrid(parent, numColumns - 1);
        changeButton = getChangeControl(parent);
        GridData gd = new GridData();
        gd.horizontalAlignment = GridData.FILL;
        int widthHint = convertHorizontalDLUsToPixels(changeButton,
                IDialogConstants.BUTTON_WIDTH);
        gd.widthHint = Math.max(widthHint, changeButton.computeSize(
                SWT.DEFAULT, SWT.DEFAULT, true).x);
        changeButton.setLayoutData(gd);
    }

    /**
     * Get the change control. Create it in parent if required.
     * @param parent
     * @return Button
     */
    public Button getChangeControl(Composite parent) {
        if (changeButton == null) {
            // Set enabled according to the associated text
            // field, if defined
            boolean enabled = false;
            Control[] children = parent.getChildren();
            for (int i = 0; i < children.length; i++) {
                if (children[i] instanceof Text) {
                    enabled = children[i].isEnabled();
                }
            }

            changeButton = new Button(parent, SWT.PUSH);
            if (changeButtonText == null)
                changeButtonText = JFaceResources.getString("openChange"); //$NON-NLS-1$
            changeButton.setText(changeButtonText);
            changeButton.setFont(parent.getFont());
            changeButton.setEnabled(enabled);	// added
            changeButton.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    String newValue = changePressed();
                    if (newValue != null) {
                    	// SMS 28 Nov 2006
                    	// Added setting of fields where setStringValue(..) is called
                    	// and (below) setting of background color
                    	levelFromWhichLoaded = preferencesLevel;
                    	setInherited(false);
                        setPresentsDefaultValue(false);
                        
                        setStringValue(newValue);
                        
                        Text text = getTextControl();
                       	text.setBackground(PreferencesUtilities.colorWhite);
                    }
                }
            });
            changeButton.addDisposeListener(new DisposeListener() {
                public void widgetDisposed(DisposeEvent event) {
                    changeButton = null;
                }
            });
        } else {
            checkParent(changeButton, parent);
        }
        return changeButton;
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    public int getNumberOfControls() {
        return 3;
    }

    /**
     * Returns this field editor's shell.
     *
     * @return the shell
     */
    protected Shell getShell() {
        if (changeButton == null)
            return null;
        return changeButton.getShell();
    }

    /**
     * Sets the text of the change button.
     *
     * @param text the new text
     */
    public void setChangeButtonText(String text) {
        Assert.isNotNull(text);
        changeButtonText = text;
        if (changeButton != null)
            changeButton.setText(text);
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.preference.FieldEditor#setEnabled(boolean, org.eclipse.swt.widgets.Composite)
     */
    public void setEnabled(boolean enabled, Composite parent) {
    	super.setEnabled(enabled, parent);
        if (changeButton != null) {
            changeButton.setEnabled(enabled);
        }
    }

	
	
	
}
