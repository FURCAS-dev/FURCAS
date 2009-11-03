package com.sap.mi.tools.cockpit.editor.model.properties;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * @author d003456
 * 
 */
public class ModelBrowserTextPropertyDescriptor extends
		ModelBrowserPropertyDescriptor {

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param displayName
	 */
	public ModelBrowserTextPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.PropertyDescriptor#createPropertyEditor(org.eclipse.swt.widgets.Composite)
	 */
	public CellEditor createPropertyEditor(Composite parent) {

		CellEditor editor = new TextCellEditor(parent);
		if (getValidator() != null) {
			editor.setValidator(getValidator());
		}
		return editor;

	}
}
