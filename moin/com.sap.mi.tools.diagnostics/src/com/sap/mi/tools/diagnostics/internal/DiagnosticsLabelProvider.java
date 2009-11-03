package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;
import com.sap.mi.tools.diagnostics.internal.model.EditorNode;
import com.sap.mi.tools.diagnostics.internal.model.TreeNode;

/**
 * Label provider for the diagnostics view
 * 
 * @author d031150
 */
public class DiagnosticsLabelProvider 
        extends LabelProvider 
        implements ILabelProvider, IFontProvider, IColorProvider {
    
    @Override
    public String getText(Object element) {
        if (element instanceof TreeNode) {
            TreeNode node = (TreeNode) element;
            String text = node.getText();
            return text;
            
        }
        // called by TabbedPropertySheet as this class is also registered as Tab title provider
        else if (element instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) element;
			String text = getText(sel.getFirstElement());
			return text;
		}
        return super.getText(element);
    }
    
    @Override
    public Image getImage(Object element) {
        return super.getImage(element);
    }

    public Font getFont(Object element) {
        if (element instanceof ConnectionNode) {
//            ConnectionNode node = (ConnectionNode) element;
//            if (node.getDelegate() == Connection.getCurrentConnection()) {
//                return JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
//            }
        }
        if (element instanceof EditorNode) {
        	EditorNode node = (EditorNode) element;
        	if (node.isDefault()) {
        		return JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
    		}
        }
        return null;
    }

	public Color getBackground(Object element) {
		return null;
	}

	public Color getForeground(Object element) {
        if (element instanceof ConnectionNode) {
          ConnectionNode node = (ConnectionNode) element;
          if (!node.isAlive()) {
              return PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND);
          }
        }
        return null;
	}
    
    

}
