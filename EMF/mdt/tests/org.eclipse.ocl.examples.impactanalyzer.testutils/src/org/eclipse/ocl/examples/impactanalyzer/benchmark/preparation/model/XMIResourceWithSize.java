package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.model;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class XMIResourceWithSize extends XMIResourceImpl implements ResourceWithSize {
    private int size = -1;
    
    public XMIResourceWithSize(URI uri) {
        super(uri);
    }
    
    /**
     * If a size >=0 is provided, it is used as the result of {@link #getSize} regardless of
     * actual resource contents.
     */
    public XMIResourceWithSize(URI uri, int size) {
        super(uri);
        this.size = size;
    }
    
    /**
     * Copies whatever is known of resourceWithSize's size. If the size is not yet known,
     * the -1 is simply copied.
     */
    public XMIResourceWithSize(URI uri, XMIResourceWithSize resourceWithSize) {
        super(uri);
        size = resourceWithSize.size;
    }

    /**
     * Once the size has been queried, the result is cached and won't be updated anymore.
     */
    public int getSize() {
        if (size == -1) {
            size = internalGetSize();
        }
        return size;
    }

    private int internalGetSize() {
        int resourceSize = 0;
        TreeIterator<EObject> iterator = getAllContents();
        while(iterator.hasNext()){
            iterator.next();
            resourceSize++;
        }
        return resourceSize;
    }

}
