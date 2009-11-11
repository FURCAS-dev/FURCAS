package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.sap.tc.moin.repository.Connection;

public abstract class ListWidgetHelper {

	public ModelElement openAddDialog(Shell parent, Connection con, RefBaseObject modelElement) {
		ElementListSelectionDialog dialog = getDialog(parent);
		dialog.setElements(executeQuery(con, modelElement));
		if (dialog.open() == ElementListSelectionDialog.OK) {
			return (ModelElement)dialog.getFirstResult();
		}
		return null;
	}

	protected ElementListSelectionDialog getDialog(Shell parent) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(parent, new LabelProvider() {
			@Override
			public String getText(Object element) {
				return (String) getToUiConverter().convert(element);
			}
		});
		dialog.setBlockOnOpen(true);

		dialog.setMultipleSelection(false);

		dialog.setMatchEmptyString(true);
		dialog.setTitle(getTitle());
		dialog.setMessage(getMessage());
		return dialog;
	}

	protected abstract String getMessage();

	protected abstract String getTitle();

	protected abstract ModelElement[] executeQuery(Connection con, RefBaseObject modelElement);

	public abstract IConverter getToModelConverter(Connection con);

	public IConverter getToUiConverter() {
		return ConverterUtil.Ui.ModelElement2QualifiedName;
	}

}