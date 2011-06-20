package com.sap.furcas.ide.editor.imp.services;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;


/**
 * An {@link ILabelProvider} to be used by the IMP outline view.
 * This implementation is backed by the generated EMF label provider.
 * 
 * @author Stephan Erb
 *
 */
public class FurcasLabelProvider implements ILabelProvider {
    
    private org.eclipse.jface.viewers.ILabelProvider labelProvider;
    private final Collection<ILabelProviderListener> deferredListeners = new ArrayList<ILabelProviderListener>(1);    
    
    /**
     * Set a label provider that this provider shall delegate to.
     * 
     * We use this deferred initalization because then language implementations don't
     * have to register their own label provider. They can use this generic implementation. 
     */
    public void plugProvider(org.eclipse.jface.viewers.ILabelProvider provider) {
        Assert.isLegal(labelProvider == null, "Re-plugging not supported");
        this.labelProvider = provider;
        
        for (ILabelProviderListener listener : deferredListeners) {
            labelProvider.addListener(listener);
        }
        deferredListeners.clear();
    }
    
    private Object unwrap(Object object) {
        if (object instanceof TextBlock) {
            TextBlock block = (TextBlock) object;
            if (!block.getCorrespondingModelElements().isEmpty()) {
                return block.getCorrespondingModelElements().iterator().next();
            }
            return object;
        } else if (object instanceof LexedToken) {
            LexedToken token = (LexedToken) object;
            if (!token.getReferencedElements().isEmpty()) {
                return token.getReferencedElements().iterator().next();
            }
            return object;
        } else if (object instanceof ModelTreeNode) {
            return unwrap(((ModelTreeNode) object).getASTNode());
        } else {
            return object;
        }
    }

    @Override
    public Image getImage(Object element) {
        if (labelProvider != null) {
            return labelProvider.getImage(unwrap(element));
        } else {
            return null;
        }
    }

    @Override
    public String getText(Object element) {
        if (labelProvider != null) {
            return labelProvider.getText(unwrap(element));
        } else {
            return null;
        }
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
        if (labelProvider != null) {
            labelProvider.addListener(listener);
        } else {
            this.deferredListeners.add(listener);
        }
    }

    @Override
    public void dispose() {
        if (labelProvider != null) {
            labelProvider.dispose();
        } 
        labelProvider = null;
        deferredListeners.clear();
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        if (labelProvider != null) {
            return labelProvider.isLabelProperty(unwrap(element), property);
        } else {
            return false;
        }
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        if (labelProvider != null) {
            labelProvider.removeListener(listener);
        } else {
            this.deferredListeners.remove(listener);
        }
    }
    
}
