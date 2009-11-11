package com.sap.ide.moftool.editor.provider;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeLabelProvider;

public class MOFToolLabelProvider extends TreeNodeLabelProvider {

	private static String getShortName(String u) {
		if (u.lastIndexOf('.') >= 0) {
			return u.substring(u.lastIndexOf('.') + 1);
		}
		return u;
	}

	@Override
	public Image getImage(Object element) {
		if (element != null) {
			if (element instanceof String) {
				String str = (String) element;
				return MOFToolEditorPlugin.getDefault().getImage(str);
			}
			if (element instanceof RefBaseObject) {
				if (!ModelAdapter.getInstance().getConnection(
						(RefBaseObject) element).isAlive()) {
					return null;
				}
				String str = "metamodel/" //$NON-NLS-1$
						+ getShortName(MofService.getName(MofService
								.getMofClass((RefBaseObject) element)));
				return MOFToolEditorPlugin.getDefault().getImage(str);
			}
			RefObject refObject = MOFToolEditorPlugin
					.getBusinessRefObject(element);
			if (refObject != null) {
				return getImage(refObject);
			}
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element != null) {
			if (element instanceof RefObject) {
				RefObject devobj = (RefObject) element;
				Attribute p = MofService.getAttribute(MofService
						.getMofClass(devobj), "id"); //$NON-NLS-1$

				if (p != null) {
					String u = (String) MofService.getAttributeValue(devobj, p);
					if (u != null)
						return u;
				}
				return MofService.getName((RefObject) element);
			}
			RefObject refObject = MOFToolEditorPlugin
					.getBusinessRefObject(element);
			if (refObject != null) {
				return getText(refObject);
			}
		}
		return super.getText(element);
	}
}
