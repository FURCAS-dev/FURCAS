package com.sap.mi.fwk.ui.test.tree;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeLabelProvider;

public class NavigatorLabelProvider extends TreeNodeLabelProvider {

	public String getText(Object element) {
		if (element instanceof ITreeNodeRefObject) {
			return ModelManager.getInstance().getObjectName(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getText(element);
	}
}
