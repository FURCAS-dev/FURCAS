package org.eclipse.emf.query.index.ui.internal.view;

import java.util.Map;

import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.PropertyCategory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class IndexViewTableLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		}

	@Override
	public void dispose() {
		}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof Map.Entry<?,?>){
			if(columnIndex == 0)
				return ((Map.Entry<String,String>)element).getKey();
			if(columnIndex==1)
				return ((Map.Entry<String,String>)element).getValue();
		}else if(element instanceof PropertyCategory)
			if(columnIndex==0)
			return Messages.QueryIndexView_IndexViewTableLabelProvider_PropertyCategory;
		return null;
	}
}
