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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferencesTab;
import org.eclipse.imp.preferences.PreferencesUtilities;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.prefs.BackingStoreException;

/**
 * A field editor for a combo box that allows the drop-down selection of one of a list of items.
 * 
 * SMS:  This is a copy of ComboFieldEditor, found in org.eclipse.imp.preferences.fields,
 * which itself is a copy from org.eclipse.search.internal.ui.util, as indicated by the
 * following comment (copied from the "original"):
 * 
 *    XXX: Note this is a copy from org.eclipse.search.internal.ui.util<br>
 *    This class can be removed once a published (non-internal, visible) version is available.
 */
public class ComboFieldEditor extends FieldEditor {
    /**
     * The <code>Combo</code> widget.
     */
    private Combo fCombo = null;

    /**
     * The value (not the name) of the currently selected item in the Combo widget.
     */
    private String fValue = null;

    /**
     * The previous value (not the previous name) of the currently selected item in the Combo widget.
     */
    //private String fPreviousValue = null;
    
    
    /**
     * The names (labels) and underlying values to populate the combo widget.
     */
    private List<String> fEntryLabels;

    private List<String> fEntryValues;

    private int fNumColumns;

    /*
     * Note:  The specialValue may be one that is used as a default or
     * one that signifies no meaningful value selected.  It is assumed
     * here NOT to occur in entryNamesAndValues, and it is added to
     * the head of the array of names and values used here to create
     * the combo box entries.
     */
    public ComboFieldEditor(
            PreferencePage page, PreferencesTab tab,
            IPreferencesService service, String level,
            String name, String labelText, String[] values, String[] labels, int numColumns,
            Composite parent, boolean isEnabled, boolean isRemovable)
    {
        Assert.isTrue(values.length == labels.length);
        init(name, labelText);

        preferencesService = service;
        preferencesLevel = level;
        this.parent = parent;
        prefPage = page;
        setPage(prefPage);
        prefTab = tab;

        fEntryLabels= new ArrayList<String>(labels.length);
        fEntryValues= new ArrayList<String>(values.length);
        for(int i=0; i < labels.length; i++) {
            fEntryLabels.add(labels[i]);
            fEntryValues.add(values[i]);
        }
        fNumColumns= numColumns;

        // Create control after setting fEntryNamesAndValues
        // because that is referenced in creating the control
        createControl(parent);

        this.isRemovable = isRemovable;
    }


    /*
     * @see FieldEditor#adjustForNumColumns(int)
     */
    protected void adjustForNumColumns(int numColumns) {
        Control control= getLabelControl();
        if (control != null) {
            ((GridData) control.getLayoutData()).horizontalSpan= numColumns;
        }
        ((GridData) fCombo.getLayoutData()).horizontalSpan= numColumns;
    }

    /*
     * @see FieldEditor#(Composite, int)
     */
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        Control control= getLabelControl(parent);
        GridData gd= new GridData();
        gd.horizontalSpan= 1;
        control.setLayoutData(gd);
        control= getComboBoxControl();
        gd= new GridData();
        gd.horizontalSpan= 1;
        control.setLayoutData(gd);
    }

    @Override
    protected void doSetToolTip() {
        if (toolTipText != null) {
            getComboBoxControl().setToolTipText(toolTipText);
        }
    }
    
    
    /**
     * Overrides method defined in FieldEditor.
     * 
     * Initializes this field editor with the preference value from
     * the preference store.
     */
//    public void load() {
//        if (preferencesService != null) {
//            //isDefaultPresented = false;
//            doLoad();
//            refreshValidState();
//        }
//    }
    
    
    /*
     * @see FieldEditor#doLoad()
     */
    protected void doLoad() {
        //if (getTextControl() != null) {
        if (fCombo != null) {
            String value = null;
            if (preferencesLevel != null) {
                // The "normal" case, in which field corresponds to a preferences level
                value = preferencesService.getStringPreference(preferencesLevel, getPreferenceName());
                levelFromWhichLoaded = preferencesLevel;
                setInherited(false);
            } else {
                // Not normal, exactly, but possible if loading is being done into a
                // field that is not associated with a specific level
                value = preferencesService.getStringPreference(getPreferenceName());
                levelFromWhichLoaded = preferencesService.getApplicableLevel(getPreferenceName(), preferencesLevel);
                setInherited(true);
            }
            if (IPreferencesService.DEFAULT_LEVEL.equals(levelFromWhichLoaded))
                setPresentsDefaultValue(true);

            previousValue = value;

            updateComboForValue(value);
        }
    }
    
    
    /*
     * SMS 23 Dec 2006:
     * Probably want to eliminate loadDefault(..) and loadLevel(..) unless a need can be
     * demonstrated and their semantics reasonably defined.
     */
    

    /*
     * @see FieldEditor#doLoadDefault()
     */
    protected void doLoadDefault() {
        //updateComboForValue(getPreferenceStore().getDefaultString(getPreferenceName()));

        if (fCombo != null) {
            String value = preferencesService.getStringPreference(IPreferencesService.DEFAULT_LEVEL, getPreferenceName());
            updateComboForValue(value);
        }
    }
    
    /**
     * Do the work of loading the value for the given level into the field.
     */
    protected void doLoadLevel(String level) {
        if (fCombo != null) {
            String value = preferencesService.getStringPreference(level, getPreferenceName());
            updateComboForValue(value);
        }
    }


    

    /*
     * Load into the button field the value for this preference that is either
     * the value defined on this preferences level, if any, or the value inherited
     * from the next applicable level, if any.  Return the level at which the
     * value loaded was found.  Load nothing and return null if no value is found.
     */
    protected String doLoadWithInheritance()
    {
        String levelLoaded = null;

        String[] levels = IPreferencesService.levels;
        int fieldLevelIndex = 0;

        // If we're loading with inheritance for some field that is
        // not attached to a preferences level then assume that we
        // should just search from the bottom up
        String tmpPreferencesLevel = (preferencesLevel == null) ? levels[0] : preferencesLevel;

        // Find the index of the level to which this field belongs
        for (int i = 0; i < levels.length; i++) {
            if (tmpPreferencesLevel.equals(levels[i])) {
                fieldLevelIndex = i;
                break;
            }
        }

        String value = null;
        int levelAtWhichFound = -1;

        // Search up levels starting from the level of this field
        for (int level = fieldLevelIndex; level < levels.length; level++) {
            value = preferencesService.getStringPreference(levels[level], getPreferenceName());
            if (value == null) continue;
            levelAtWhichFound = level;
            levelLoaded = levels[levelAtWhichFound];
            break;
        }

        levelFromWhichLoaded = levelLoaded;
        setInherited(fieldLevelIndex != levelAtWhichFound);
        setPresentsDefaultValue(IPreferencesService.DEFAULT_LEVEL.equals(levelFromWhichLoaded));

        // Set the field to the value we found
        updateComboForValue(value);

        fieldModified = false; // Since we just loaded some new value, it won't be modified yet
        previousValue = value; // TODO: Check on use of previous value

        // Set the background color of the field according to where found
        setFieldColors();

        return levelLoaded;
    }
 

    protected void setFieldColors() {
        Control comboBox = getComboBoxControl();
        Color color = isInherited() ? PreferencesUtilities.colorBluish : PreferencesUtilities.colorWhite;
        comboBox.setBackground(color);
    }
    
 
    /**
     * Overrides method implemented in RadioGroupFieldEditor.
     * 
     * Abstract method declared on FieldEditor.
     */
    protected void doStore() {
        String value = getStringValue();

        // We have a value (possibly empty, if that is allowed) that has changed
        // from the previous value, so store it
        preferencesService.setStringPreference(preferencesLevel, getPreferenceName(), value);

        // If we've just stored the field, we've addressed any modifications
        //System.out.println("STFE.doStore:  setting fieldModified to FALSE");
        fieldModified = false;
        // "Level from which loaded" (or set, as the case may be) is now this level
        levelFromWhichLoaded = preferencesLevel;
        // If we've stored the field then it's not inherited, so be sure it's
        // color indicates that.
        setFieldColors();
        //getComboBoxControl(parent).setBackground(PreferencesUtilities.colorWhite);

        IEclipsePreferences node = preferencesService.getNodeForLevel(preferencesLevel);
        try {
            if (node != null) node.flush();
        } catch (BackingStoreException e) {
            System.err.println("ComboFieldEditor.doStore():  BackingStoreException flushing node;  node may not have been flushed:" + 
                    "\n\tnode path = " + node.absolutePath() + ", preferences level = "  + preferencesLevel);
        }
    }
    
    
    /*
     * @see FieldEditor#getNumberOfControls()
     */
    public int getNumberOfControls() {
        return fNumColumns;
    }

    /*
     * Lazily create and return the Combo control.
     */
    public Combo getComboBoxControl() {
        if (fCombo == null) {
            fCombo= new Combo(parent, SWT.READ_ONLY);
            for(String entryName: fEntryLabels) {
                fCombo.add(entryName);
            }
            fCombo.setFont(parent.getFont());
            fCombo.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent evt) {
                    String name= fCombo.getText();
                    fValue= getValueForName(name);
                    setPresentsDefaultValue(false);
                    // SMS 23 Dec 2006
                    fieldModified = true;
                    setInherited(false);
                    valueChanged();
                }
            });
        }
        return fCombo;
    }

    @Override
    public Composite getHolder() {
        return getComboBoxControl().getParent();
    }

    /*
     * Given the name (label) of an entry, return the corresponding value.
     */
    protected String getValueForName(String name) {
        int idx= fEntryLabels.indexOf(name);
        return (idx >= 0) ? fEntryValues.get(idx) : "";
    }

    /*
     * Set the name in the combo widget to match the specified value.
     */
    protected void updateComboForValue(String value) {
        if (value == null)
            value = "";
        previousValue = getStringValue();
        setPreviousStringValue(getStringValue());

        int idx= fEntryValues.indexOf(value);

        if (idx < 0) { idx = 0; }
        fValue = fEntryValues.get(idx);
        fCombo.setText(fEntryLabels.get(idx));

        valueChanged();
    }
    
    
    /**
     * Informs this field editor's listener, if it has one, about a change
     * to the value (<code>VALUE</code> property) provided that the old and
     * new values are different.  Also informs the listener (if there is one)
     * of a change in the validity of the field (<code>IS_VALID</code> property). 
     * 
     * This hook is <em>not</em> called when the text is initialized 
     * (or reset to the default value) from the preference store.
     * (That comment is taken from the original implementation of this
     * method.  I've tried to follow it consistently for IMP preferences,
     * but I'm not sure if the original intention translates into the
     * multi-level model.  Still, so far there seems to be no problem
     * with it.  SMS 16 Nov 2006)
     * 
     * Copied from StringFieldEditor and adapted to use in IMP.
     * Added return of a boolean value.  Not intended to set any attributes
     * of the field editor, just to signal changes to listeners.
     */
    protected boolean valueChanged() {
        return valueChanged(false);
    }
    
    protected boolean valueChanged(boolean assertChanged) {
        // Check for change in value
        boolean valueChanged = assertChanged || inheritanceChanged();
        String prevValue = getPreviousStringValue();
        if (!valueChanged) {
            if ((fValue != null && prevValue == null) ||
                (fValue == null && prevValue != null))
            {
                valueChanged = true;
            }

            if (fValue != null && prevValue != null) {
                if (!fValue.equals(prevValue)) {
                    valueChanged = true;
                }
            }
        }

        if (valueChanged) {
            fireValueChanged(VALUE, prevValue, fValue);
            fieldModified = true;
            setPreviousStringValue(fValue);
            setModifiedMarkOnLabel();
        }

        return valueChanged;
    }


    /**
     * 
     */
    protected String getPreviousStringValue() {
        return (String) previousValue;
    }
    
    
    protected void setPreviousStringValue(String value) {
        previousValue = value;
    }
    
    
    
    /**
     * Set the value of this field directly, from outside of
     * the field, without loading a value from the preferences
     * service.
     *
     * Intended for use by external clients of the field.
     * 
     * In addition to setting the value of the field this method
     * also sets several attributes to appropriately characterize
     * a field that has been set in this way.
     * 
     * @param newValue
     */
    public void setFieldValueFromOutside(String newValue) {
        setPreviousStringValue(getStringValue());
        setInherited(false);
        setPresentsDefaultValue(false);
        levelFromWhichLoaded = null;
        updateComboForValue(newValue);
    }


    /**
     * Gets the current String value of the field, corresponding
     * to the currently selected item.
     * 
     * @return The current String value of the field, corresponding
     * to the currently selected item.
     */
    public String getStringValue() {
        return fValue;
    }


    public String getSpecialStringValue() {
        if (!hasSpecialValue) {
            throw new IllegalStateException("ComboFieldEditor.getSpecialValue():  field does not have a special value");
        }
        return (String) specialValue;
    }


    /**
     * Set the special value associated with this field to be the given string.
     * Overrides the method in the supertype to check that the given value is
     * a String.
     * 
     * @param specialValue	The special value to associate with this field
     * @throws IllegalStateException	if the field has no special value
     * @throws IllegalArgumentException	if the given value is null or empty
     */
    public void setSpecialValue(String specialValue) {
        throw new IllegalStateException("ComboField.setSpecialValue(String):  field has no special value");			
    }
}
