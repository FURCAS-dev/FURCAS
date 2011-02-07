package com.sap.furcas.ide.editor.imp.services;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;

/**
 * An {@link ILabelProvider} to be used by the IMP outline view.
 * This implementation is backed by the generated EMF label provider.
 * 
 * @author Stephan Erb
 *
 */
public class FurcasLabelProvider implements ILabelProvider {
    
    private final org.eclipse.jface.viewers.ILabelProvider labelProvider;
    
    public FurcasLabelProvider(ComposeableAdapterFactory adapterFactory) {
        this.labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
    }
    
    private Object unwrap(Object object) {
        if (object instanceof DocumentNode) {
            return ((DocumentNode) object).getCorrespondingModelElements().iterator().next();
        } else if (object instanceof ModelTreeNode) {
            return unwrap(((ModelTreeNode) object).getASTNode());
        } else {
            return object;
        }
    }

    @Override
    public Image getImage(Object element) {
        return labelProvider.getImage(unwrap(element));
    }

    @Override
    public String getText(Object element) {
        return labelProvider.getText(unwrap(element));
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
        labelProvider.addListener(listener);
    }

    @Override
    public void dispose() {
        labelProvider.dispose();
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        return labelProvider.isLabelProperty(unwrap(element), property);
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        labelProvider.removeListener(listener);
    }
    
}
