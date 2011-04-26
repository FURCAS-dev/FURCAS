package org.eclipse.emf.query.index.ui.internal.view;

import java.util.Map;

import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.PropertyCategory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class IndexViewTableLabelProvider implements ITableLabelProvider {

	
	public void addListener(ILabelProviderListener listener) {
		}

	
	public void dispose() {
		}

	
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	
	public void removeListener(ILabelProviderListener listener) {
		}

	
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@SuppressWarnings("unchecked")
	
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
