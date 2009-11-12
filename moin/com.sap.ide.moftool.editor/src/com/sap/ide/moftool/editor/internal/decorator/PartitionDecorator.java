package com.sap.ide.moftool.editor.internal.decorator;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

public class PartitionDecorator extends LabelProvider implements ILightweightLabelDecorator {

	@SuppressWarnings("unchecked")
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof ITreeNodeRefObject) {
			ITreeNodeRefObject<RefObject> tnRo = (ITreeNodeRefObject<RefObject>) element;
			if (tnRo.getValue() instanceof MofPackage) {
				IFile file = ModelAdapter.getInstance().getFile(tnRo.getValue());
				if (file != null) {
					decoration.addSuffix(" [" + file.getFullPath().toPortableString() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
					decoration.getDecorationContext().getProperties();
				}
			}
		}
	}
}
