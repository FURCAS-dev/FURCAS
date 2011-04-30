package org.eclipse.imp.preferences.fields;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferencesTab;
import org.eclipse.imp.preferences.PreferencesUtilities;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.prefs.BackingStoreException;

public class ColorFieldEditor extends ChangeButtonFieldEditor {
    public static final RGB COLOR_DEFAULT= new RGB(0,0,0);

    public static final String COLOR_DEFAULT_SPEC= StringConverter.asString(COLOR_DEFAULT);

    /**
     * The color selector, or <code>null</code> if none.
     */
    private ColorSelector colorSelector;

    public ColorFieldEditor(PreferencePage page, PreferencesTab tab, IPreferencesService service, String level, String name, String labelText, Composite parent) {
        super(page, tab, service, level, name, labelText, parent);
        createControl(parent);
    }

    /*
     * (non-Javadoc) Method declared on FieldEditor.
     */
    protected void adjustForNumColumns(int numColumns) {
        ((GridData) colorSelector.getButton().getLayoutData()).horizontalSpan= numColumns - 1;
    }

    /**
     * Computes the size of the color image displayed on the button.
     * <p>
     * This is an internal method and should not be called by clients.
     * </p>
     * 
     * @param window
     *            the window to create a GC on for calculation.
     * @return Point The image size
     * 
     */
    protected Point computeImageSize(Control window) {
        // Make the image height as high as a corresponding character. This
        // makes sure that the button has the same size as a "normal" text
        // button.
        GC gc= new GC(window);
        Font f= JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT);
        gc.setFont(f);
        int height= gc.getFontMetrics().getHeight();
        gc.dispose();
        Point p= new Point(height * 3 - 6, height);
        return p;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
     */
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        Control control= getLabelControl(parent);
        GridData gd= new GridData();
        gd.horizontalSpan= numColumns - 1;
        control.setLayoutData(gd);

        Button colorButton= getChangeControl(parent);
        colorButton.setLayoutData(new GridData());
    }

    /*
     * (non-Javadoc) Method declared on FieldEditor.
     */
    public int getNumberOfControls() {
        return 2;
    }

    /**
     * Get the color selector used by the receiver.
     * 
     * @return ColorSelector/
     */
    public ColorSelector getColorSelector() {
        return colorSelector;
    }

    @Override
    public Button getChangeControl() {
        if (colorSelector == null)
            return null;
        return colorSelector.getButton();
    }

    @Override
    public Composite getHolder() {
        return getChangeControl().getParent();
    }

    /**
     * Returns the change button for this field editor.
     * 
     * @param parent
     *            The control to create the button in if required.
     * @return the change button
     */
    protected Button getChangeControl(Composite parent) {
        if (colorSelector == null) {
            colorSelector= new ColorSelector(parent);
            colorSelector.addListener(new IPropertyChangeListener() {
                // forward the property change of the color selector
                public void propertyChange(PropertyChangeEvent event) {
                    ColorFieldEditor.this.fireValueChanged(event.getProperty(), event.getOldValue(), event.getNewValue());
                    setPresentsDefaultValue(false);
                    setInherited(false);
                    fieldModified= true;
                }
            });

        } else {
            checkParent(colorSelector.getButton(), parent);
        }
        return colorSelector.getButton();
    }

    @Override
    protected void doSetToolTip() {
        getLabelControl().setToolTipText(toolTipText);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.FieldEditor#setEnabled(boolean, org.eclipse.swt.widgets.Composite)
     */
    public void setEnabled(boolean enabled, Composite parent) {
        super.setEnabled(enabled, parent);
        getChangeControl(parent).setEnabled(enabled);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.FieldEditor#doLoad()
     */
    protected void doLoad() {
        if (colorSelector == null) {
            return;
        }
        updateColor(preferencesService.getStringPreference(getPreferenceName()));
    }

    /*
     * (non-Javadoc) Method declared on FieldEditor.
     */
    protected void doLoadDefault() {
        if (colorSelector == null) {
            return;
        }
        updateColor(preferencesService.getStringPreference(IPreferencesService.DEFAULT_LEVEL, getPreferenceName()));
    }

    @Override
    protected void doLoadLevel(String level) {
        String colorValue = preferencesService.getStringPreference(level, getPreferenceName());

        updateColor(colorValue);
    }

    private void updateColor(String colorSpec) {
        RGB color = StringConverter.asRGB(colorSpec, null);

        if (color == null) {
            color= COLOR_DEFAULT;
        }
        colorSelector.setColorValue(color);
    }

    @Override
    protected String doLoadWithInheritance() {
        String levelLoaded = null;
        String[] levels = IPreferencesService.levels;
        
        // If we're loading with inheritance for some field that is
        // not attached to a preferences level then assume that we
        // should just search from the bottom up
        int startingLevelIdx = (preferencesLevel == null) ? 0 : PREFS_LEVELS_AS_LIST.indexOf(preferencesLevel);
        int levelAtWhichFound = -1;

        String encodedColorValue = null;
        // Search up levels starting from the level of this field
        for (int level = startingLevelIdx; level < levels.length; level++) {
            encodedColorValue = preferencesService.getRawStringPreference(levels[level], getPreferenceName());
            if (encodedColorValue != null) {
                levelAtWhichFound = level;
                levelLoaded = levels[levelAtWhichFound];
                break;
            }
        }
        if (encodedColorValue == null) {
            encodedColorValue= COLOR_DEFAULT_SPEC;
        }

        // TODO should this be calling updateColor() instead of the following?
        levelFromWhichLoaded = levelLoaded;
        setInherited(startingLevelIdx != levelAtWhichFound);
        setPresentsDefaultValue(IPreferencesService.DEFAULT_LEVEL.equals(levelFromWhichLoaded));
        fieldModified = true;
//      valueChanged(); // should not be called when field set from preference store

        previousValue= colorSelector.getColorValue(); // not clear whether this needs to be done on initial load from store
        colorSelector.setColorValue(StringConverter.asRGB(encodedColorValue));

        updateColor(encodedColorValue);
        return levelLoaded;
    }

    /*
     * (non-Javadoc) Method declared on FieldEditor.
     */
    protected void doStore() {
        RGB value = colorSelector.getColorValue();

        // Not inherited, and modified:  field must have been set on this level, so store it.
        // Storing here should trigger preference-change listeners at each level below this.
        preferencesService.setStringPreference(preferencesLevel, getPreferenceName(), StringConverter.asString(value));

        // If we've just stored the field, we've addressed any modifications
        //System.out.println("SBFE.doStore:  setting fieldModified to FALSE");
        fieldModified = false;
        // If we've stored the field then it's not inherited, so be sure it's
        // color indicates that.
        // Note that for the checkbox wiget (which is the only one used so far)
        // the background color is the color behind the label (not the checkbox
        // itself), so it should be light gray like the background in the rest
        // of the tab.
        // TODO:  figure out how to determine the actual prevailing background
        // color and use that here
        getLabelControl().setBackground(PreferencesUtilities.colorWhite);

        // Now write out the node
        IEclipsePreferences node = preferencesService.getNodeForLevel(preferencesLevel);

        try {
            if (node != null) node.flush();
        } catch (BackingStoreException e) {
            System.err.println("SCFE.doStore(): BackingStoreException; node may not have been flushed:" + 
                    "\n\tnode path = " + node.absolutePath() + ", preferences level = "  + preferencesLevel);
        }
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
        previousValue = colorSelector.getColorValue();
        setInherited(false);
        setPresentsDefaultValue(false);
        levelFromWhichLoaded = null;
        updateColor(newValue);
    }

    @Override
    protected boolean valueChanged() {
        // Check for change in value
        boolean valueChanged = inheritanceChanged();
        RGB chosenColor= colorSelector.getColorValue();

        if (!valueChanged) {
            if ((chosenColor != null && previousValue == null) ||
                (chosenColor == null && previousValue != null))
            {
                valueChanged = true;
            }
            
            if (chosenColor != null && previousValue != null) {
                if (!chosenColor.equals(previousValue)) {
                    valueChanged = true;
                }
            }
        }
        
        if (valueChanged) {
            fireValueChanged(VALUE, previousValue, chosenColor);
            fieldModified = true;
            previousValue = chosenColor;
            setModifiedMarkOnLabel();
        }
        return valueChanged;
    }
}
