package com.sap.ide.cts.editor;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;

public class TextBlocksContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof TextBlock) {
			return TbNavigationUtil.getSubNodes((TextBlock) parentElement)
					.toArray();
		} else {
			return new Object[0];
		}
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof DocumentNode) {
			return TbNavigationUtil.getParentBlock((DocumentNode) element);
		} else {
			return null;
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof TextBlock) {
			return TbNavigationUtil.getSubNodesSize((TextBlock) element) > 0;
		} else {
			return false;
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		//this is always the root block
		if (inputElement instanceof TextBlock) {
			return TbNavigationUtil.getSubNodes((TextBlock) inputElement)
					.toArray();
		} else {
			return new Object[0];
		}
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}

}
