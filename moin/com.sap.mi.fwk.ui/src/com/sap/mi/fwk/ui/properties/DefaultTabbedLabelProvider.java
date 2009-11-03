package com.sap.mi.fwk.ui.properties;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.IViewerLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerLabel;

import com.sap.mi.fwk.ModelManager;

/**
 * A label provider for {@link RefObject} showing a human-raedable name as text
 * 
 * @author d031150
 */
public final class DefaultTabbedLabelProvider extends LabelProvider implements IViewerLabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) element;
			if (sel.size() == 1) {
				return ModelManager.getInstance().getObjectName(sel.getFirstElement());
			} else {
				return ""; //$NON-NLS-1$
			}
		}
		return super.getText(element);
	}

	public void updateLabel(ViewerLabel label, Object element) {
		String text = getText(element);
		label.setText(text);
	}

}
