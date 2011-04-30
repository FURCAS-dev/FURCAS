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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferencesTab;
import org.eclipse.imp.preferences.PreferencesUtilities;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.osgi.service.prefs.BackingStoreException;

/**
 * A field editor for an enumeration type preference.
 * The choices are presented as a list of radio buttons.
 */
public class RadioGroupFieldEditor extends FieldEditor {
    /**
     * List of radio button entries of the form [label,value].
     */
    protected String[] values;

    protected String[] labels;

    /**
     * Number of columns into which to arrange the radio buttons.
     */
    protected int numColumns;

    /**
     * Indent used for the first column of the radio button matrix.
     */
    protected int indent = HORIZONTAL_GAP;
    
    /**
     * The current value, or <code>null</code> if none.
     */
    protected String value;

    /**
     * The box of radio buttons, or <code>null</code> if none
     * (before creation and after disposal).
     */
    protected Composite radioBox;

    /**
     * The radio buttons, or <code>null</code> if none
     * (before creation and after disposal).
     */
    protected Button[] radioButtons;

    /**
     * Whether to use a Group control.
     */
    protected boolean useGroup;

  
    
    /**
     * Creates a new radio group field editor 
     */
    protected RadioGroupFieldEditor() {
    }

    // Public constructors all adapted from RadioGroupFieldEditor.
    
    /**
     * Creates a radio group field editor.  
     * This constructor does not use a <code>Group</code> to contain the radio buttons.
     * It is equivalent to using the following constructor with <code>false</code>
     * for the <code>useGroup</code> argument.
     * <p>
     * Example usage:
     * <pre>
     *     RadioGroupFieldEditor editor= new RadioGroupFieldEditor(
     *         "GeneralPage.DoubleClick", resName, 1,
     *         new String[][] {
     *             {"Open Browser", "open"},
     *             {"Expand Tree", "expand"}
     *         },
     *         parent);
     * </pre>
     * </p>
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param numColumns the number of columns for the radio button presentation
     * @param labelAndValues list of radio button [label, value] entries;
     *  the value is returned when the radio button is selected
     * @param parent the parent of the field editor's control
     */
    public RadioGroupFieldEditor(
            PreferencePage page, PreferencesTab tab,
            IPreferencesService service, String level,
            String name, String labelText, int numColumns,
            String[] values, String[] labels, Composite parent,
            boolean isEnabled, boolean isRemovable)
    {
        this(page, tab, service, level, name, labelText, numColumns, values, labels, parent, false);
    }

    /**
     * Creates a radio group field editor.
     * <p>
     * Example usage:
     * <pre>
     *      RadioGroupFieldEditor editor= new RadioGroupFieldEditor(
     *          "GeneralPage.DoubleClick", resName, 1,
     *          new String[][] {
     *              {"Open Browser", "open"},
     *              {"Expand Tree", "expand"}
     *          },
     *          parent,
     *          true);
     * </pre>
     * </p>
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param numColumns the number of columns for the radio button presentation
     * @param labelAndValues list of radio button [label, value] entries;
     *  the value is returned when the radio button is selected
     * @param parent the parent of the field editor's control
     * @param useGroup whether to use a Group control to contain the radio buttons
     */
    public RadioGroupFieldEditor(
            PreferencePage page, PreferencesTab tab,
            IPreferencesService service, String level,
            String name, String labelText, int numColumns,
            String[] values, String[] labels, Composite parent, boolean useGroup)
    {
        super(page, tab, service, level, name, labelText, parent);

        // Adapted from RadioGroupFieldEditor
        Assert.isTrue(values.length == labels.length);
        this.values = values;
        this.numColumns = numColumns;
        this.useGroup = useGroup;
        this.labels= labels;
        createControl(parent);
    }
    


    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void adjustForNumColumns(int numColumns) {
        Control control = getLabelControl();
        if (control != null) {
            // should be true if !useGroup, and !useGroup should be true,
            // so should not occur
            ((GridData) control.getLayoutData()).horizontalSpan = numColumns;
        }
        ((GridData) radioBox.getLayoutData()).horizontalSpan = numColumns;
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        if (useGroup) {
            Control control = getRadioBoxControl(parent);
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            control.setLayoutData(gd);
        } else {
            Control control = getLabelControl(parent);
            GridData gd = new GridData();
            gd.horizontalSpan = numColumns;
            control.setLayoutData(gd);
            control = getRadioBoxControl(parent);
            gd = new GridData();
            gd.horizontalSpan = numColumns;
            gd.horizontalIndent = indent;
            control.setLayoutData(gd);
        }
    }

    @Override
    protected void doSetToolTip() {
        if (toolTipText != null) {
            getRadioBoxControl().setToolTipText(toolTipText);
        }
    }


    /**
     *
     * Override of method from RadioGroupFieldEditor.
     * 
     * Method declared on FieldEditor.
     */
    protected void doLoad() {
        //updateValue(getPreferenceStore().getString(getPreferenceName()));

        //if (getTextControl() != null) {
        if (radioButtons != null) {
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
            setPreviousStringValue(value);
            updateValue(value);
        }
    }

    
    /**
     * Method declared on FieldEditor.
     * 
     * SMS 23 Dec 2006:  This method is probably inapropriate and should probably
     * be removed.  The effect as programmed is to update the field without going
     * through inheritance and without updating the model, and what that might mean
     * hasn't been well defined.  Also, there hasn't been a demonstrated need for
     * this method.
     */
    protected void doLoadDefault() {
        //updateValue(getPreferenceStore().getDefaultString(getPreferenceName()));

        if (radioButtons != null) {
            String value = preferencesService.getStringPreference(IPreferencesService.DEFAULT_LEVEL, getPreferenceName());
            updateValue(value); // calls valueChanged()
        }
    }

    
    
    /**
     * Override of method from RadioGroupFieldEditor.
     * 
     * SMS 23 Dec 2006:  Should probably remove this method for reasons similar
     * to those given for loadDefault
     * 
     * Method declared on FieldEditor.
     */
    protected void doLoadLevel(String level) {
        if (radioButtons != null) {
            String value = null;
            if (preferencesLevel != null) {
                value = preferencesService.getStringPreference(level, getPreferenceName());
            } else {
                // TODO:  Check whether this is right
                value = preferencesService.getStringPreference(getPreferenceName());
            }
            updateValue(value); // calls valueChanged()
        }
    }



    /**
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

        // We loaded it at this level or inherited it from some other level
        // (need to set before calling updateValue(..))
        setInherited(fieldLevelIndex != levelAtWhichFound);

        // Set the field to the value we found
        updateValue(value);

        // Since we just loaded some new value, it won't be modified yet
        fieldModified = false;
        setPreviousStringValue(value);

        // Set the background color of the field according to where found
        setFieldColors();

        //System.out.println("doLoadWithInheritance:  preferencesName = " + getPreferenceName() + "; preferenceLevel = " + preferencesLevel + "; levelLoaded = " + levelLoaded);     
        return levelLoaded;
    }
    
 
    
    protected void setFieldColors() {
        Control buttonBox = getRadioBoxControl(parent);
        Color color = isInherited() ? PreferencesUtilities.colorBluish : PreferencesUtilities.colorWhite;

        buttonBox.setBackground(PreferencesUtilities.colorWhite);
        if (radioButtons != null) {
            for (int i = 0; i < radioButtons.length; i++) {
                ((Button) radioButtons[i]).setBackground(color);
            }
        }
    }
    
  

    /**
     * Overrides method implemented in RadioGroupFieldEditor.
     * 
     * Abstract method declared on FieldEditor.
     */
    protected void doStore() {
        String value = getStringValue();
        boolean isEmpty = value.equals(""); // Want empty value, but can't call method to retrieve it
                                            // with fields where empty is not allowed
        // isEmpty shouldn't really occur with a radio group field,
        // but address that case just in case
        if (isEmpty) {
            // We have an empty value where that isn't allowed, so clear the
            // preference.  Expect that clearing the preferences at a level will
            // trigger a loading with inheritance at that level
            preferencesService.clearPreferenceAtLevel(preferencesLevel, getPreferenceName());
            // If the preference value was previously empty (e.g., if previously inherited)
            // then clearing the preference node now doesn't cause a change event, so
            // doesn't trigger reloading with inheritance.  So we should just load the
            // field again to make sure any inheritance occurs if needed
            loadWithInheritance();
            return;
        }
        if (isInherited() && !fieldModified) {              // If inherited, why do we care whether it's modified?
            // We have a value but it's inherited           // shouldn't want to store in any case, should we?
            // (left over from after the last time we cleared the field)
            // so don't need (or want) to store it
            return;
        }
        // We have a value (possibly empty, if that is allowed) that has changed
        // from the previous value, so store it
        preferencesService.setStringPreference(preferencesLevel, getPreferenceName(), value);

        // If we've just stored the field, we've addressed any modifications
        // and levelFromWhichLoaded is equivalent to levelOnWhichStored
        // (which also means that the field isn't inherited)
        fieldModified = false;
        levelFromWhichLoaded = preferencesLevel;
        setInherited(false);
        setPresentsDefaultValue(
                value.equals(preferencesService.getStringPreference(IPreferencesService.DEFAULT_LEVEL, getPreferenceName())));

        // If we've stored the field then it's not inherited, so be sure it's
        // color indicates that.
        setFieldColors();

        IEclipsePreferences node = preferencesService.getNodeForLevel(preferencesLevel);
        try {
            if (node != null) node.flush();
        } catch (BackingStoreException e) {
            System.err.println("RadioGroupFieldEditor.doStore():  BackingStoreException flushing node;  node may not have been flushed:" + 
                    "\n\tnode path = " + node.absolutePath() + ", preferences level = "  + preferencesLevel);
        }
    }
    
    

    /*
     * For radio group fields we override the following two methods because
     * the means of accessing the text to be modified is different.
     * 
     * The representation of RadioGroups used here uses a Group to hold the buttons.
     * The text associated with this group is used to label the field, so it is this
     * text on which "modified" marks are set and cleared.  The implementations of
     * the methods that set and clear the marks assume the use of a group to hold
     * the buttons.  If groups are not used for this purpose, then the methods to
     * set and clear the marks will need to be adapted accordingly.
     * 
     * @see org.eclipse.imp.preferences.fields.FieldEditor#setModifiedMarkOnLabel()
     * @see org.eclipse.imp.preferences.fields.FieldEditor#clearModifiedMarkOnLabel()
     */
    
    
    public void setModifiedMarkOnLabel() {
        if (radioBox != null && useGroup) {
            Group radioGroup = (Group) radioBox;

            radioGroup.setForeground(PreferencesUtilities.colorRed);
        }
    }

    
    public void clearModifiedMarkOnLabel() {
        if (radioBox != null && useGroup) {
            Group radioGroup = (Group) radioBox;

            radioGroup.setForeground(PreferencesUtilities.colorBlack);
        }
    }
    
    
    
    /**
     * Returns this field editor's radio group control, using the
     * locally cached reference to parent to obtain it.
     * 
     * @return the radio group control
     */
    public Composite getRadioBoxControl()
    {
        Composite radioBox = getRadioBoxControl(parent);
        return radioBox;
    }

    /**
     * Returns this field editor's radio group control.
     * @param parent The parent to create the radioBox in
     * @return the radio group control
     */
    public Composite getRadioBoxControl(Composite parent) {
        if (radioBox == null) {
            Font font = parent.getFont();

            if (useGroup) {
                Group group = new Group(parent, SWT.NONE);
                group.setFont(font);
                String text = getLabelText();
                // This puts the label in the border around the button group
                // (but is not responsible for the field label outside the box)
                if (text != null)
                    group.setText(text);
                radioBox = group;
                GridLayout layout = new GridLayout();
                layout.horizontalSpacing = HORIZONTAL_GAP;
                layout.numColumns = numColumns;
                radioBox.setLayout(layout);
            } else {
                radioBox = new Composite(parent, SWT.NONE);
                GridLayout layout = new GridLayout();
                layout.marginWidth = 0;
                layout.marginHeight = 0;
                layout.horizontalSpacing = HORIZONTAL_GAP;
                layout.numColumns = numColumns;
                radioBox.setLayout(layout);
                radioBox.setFont(font);
            }

            radioButtons = new Button[values.length];
            for (int i = 0; i < values.length; i++) {
                Button radio = new Button(radioBox, SWT.RADIO | SWT.LEFT);
                radioButtons[i] = radio;
                radio.setText(labels[i]);
                radio.setData(values[i]);
                radio.setFont(font);
                radio.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent event) {
//                      String oldValue = value;
                        value = (String) event.widget.getData();
                        setPresentsDefaultValue(false);
                        // SMS 12 Dec 2006
                        setInherited(false);
//                      boolean valueChanged = valueChanged(true);
                        //fireValueChanged(VALUE, oldValue, value);
                        // Added:
                        //fieldModified = true;

                    }
                });
            }
            radioBox.addDisposeListener(new DisposeListener() {
                public void widgetDisposed(DisposeEvent event) {
                    radioBox = null;
                    radioButtons = null;
                }
            });
        } else {
            checkParent(radioBox, parent);
        }
        return radioBox;
    }

    @Override
    public Composite getHolder() {
        return getRadioBoxControl().getParent();
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
        updateValue(newValue);
    }
  
    

    /**
     * Select the radio button that conforms to the given value.
     * 
     * Note:  This is (or should be) called whenever the value is
     * updated through the API (including but not limited to the
     * loading of the field from the preferences model).  It provides
     * a common place to address certain concerns for all of those
     * cases (of which there are several).  However, the field value
     * can also be changed through the GUI, in which case these
     * concerns may need to be addressed somewhere appropriate to
     * that case.  (The concerns include, for example, setting the
     * modified mark on the field label and signaling that the
     * value has changed.)
     * 
     * Overrides the method from RadioGroupFieldEditor.
     * @param selectedValue the selected value
     */
    protected void updateValue(String selectedValue)
    {
        value = selectedValue;
        if (radioButtons == null)
            return;
        
        setPreviousStringValue(getStringValue());

        // Check each button for a match to selectedValue
        // and set its selection accordingly.  Also note
        // whether a button matching selectedValue was found.
        boolean found = false;
        if (value != null) {
            for (int i = 0; i < radioButtons.length; i++) {
                Button radio = radioButtons[i];
                boolean selection = false;
                if (((String) radio.getData()).equals(value)) {
                    selection = true;
                    found = true;
                }
                // Whether selection is true or false
                radio.setSelection(selection);
            }
        }

        // If we weren't able to find the value, select the first
        // radio button as a default
        if (!found && radioButtons.length > 0) {
            radioButtons[0].setSelection(true);
            value = (String) radioButtons[0].getData();
            found = true; // in effect
        }

        // Should *always* have "found" some selection at this point
        if (found) {
            //fieldModified = true;
            //setModifiedMarkOnLabel();
            valueChanged();
        }

        return;
    }

    
    /**
     * Informs this field editor's listener, if it has one, about a change
     * to the value (<code>VALUE</code> property) provided that the old and
     * new values are different.  Not concerned with validity of values,
     * here, on the assumption that if no valid value was entered then
     * some valid value will be selected by default.
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
     * Added return of a boolean value.  Sets certain attributes of
     * the field that do not depend on the context of the call.  Does
     * not set other attributes that do depend on the context (so those
     * must be set separately).
     */
    protected boolean valueChanged() {
        return valueChanged(false);
    }
    
    protected boolean valueChanged(boolean assumeChanged)
    {
        // Check for change in value
        boolean valueChanged = assumeChanged || inheritanceChanged();
        String newValue = getStringValue(); //getText();
        if (!valueChanged) {
            //String newValue = getStringValue(); //getText();
            if (!newValue.equals(getPreviousStringValue())) {
                valueChanged = true;
                // Inform the listener
                //fireValueChanged(VALUE, getPreviousStringValue(), newValue);
            }
        }

        if (valueChanged) {
            // Update the following attributes of the field,
            // which can be done without regard to context
            // Inform the listener
            fireValueChanged(VALUE, getPreviousStringValue(), newValue);
            fieldModified = true;
            // SMS 23 Dec 2006:  Don't do these here because they may
            // (or should) have been done before valueChanged was called.
            setPreviousStringValue(newValue);
            setModifiedMarkOnLabel();
        }
        return valueChanged;
    }
    
    
   
    public Button[] getRadioButtons() {
        return radioButtons;
    }


    protected String getPreviousStringValue() {
        return (String) previousValue;
    }
    
    
    protected void setPreviousStringValue(String value) {
        previousValue = value;
    }
    
    
    
    /**
     * Gets the current String value of the field, corresponding
     * to the currently pressed button.
     * 
     * Note:  This method, and the value of the current selection,
     * are not available from RadioGroupFieldEditor.
     * 
     * @return The current String value of the field, corresponding
     * to the currently pressed button.
     */
    public String getStringValue() {
        return value;
    }
    
    
    /* 
     * Method declared on FieldEditor.
     * Copied from RadioGroupFieldEditor.
     */
    public int getNumberOfControls() {
        return 1;
    }

    
    /*
     * @see FieldEditor.setEnabled(boolean,Composite).
     */
    public void setEnabled(boolean enabled, Composite parent) {
        if (!useGroup)
            super.setEnabled(enabled, parent);
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setEnabled(enabled);
        }

    }
}
