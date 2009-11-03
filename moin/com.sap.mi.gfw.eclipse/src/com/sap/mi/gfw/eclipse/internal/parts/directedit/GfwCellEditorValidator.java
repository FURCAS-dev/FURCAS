package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import org.eclipse.jface.viewers.ICellEditorValidator;

public class GfwCellEditorValidator implements ICellEditorValidator {
	private IDirectEditHolder directEditHolder;

	public GfwCellEditorValidator(IDirectEditHolder directEditHolder) {
		this.directEditHolder = directEditHolder;
	}

	public String isValid(Object value) {
		String ret = null;

		if (value instanceof String) {
			ret = directEditHolder.getDirectEditingFeature().checkValueValid((String) value, directEditHolder.getDirectEditingContext());
		}
		return ret;
	}
}
