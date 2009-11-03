/*
 * Created on 02.03.2005
 */
package com.sap.tc.moin.repository.core;

/**
 * Declares the capability to obtain a parent in a composition hierarchy as
 * required by the {@link TreeSorter}.
 * 
 * @author D043530
 */
public interface ParentRetriever<T> {

    /**
     * Determines the composition parent of the model element passed. Assignment
     * to model partitions by default also applies to all composed subelements.
     * Therefore, vice versa, a model element can determine its partition
     * assignment by ascending the composition hierarchy until it reaches an
     * element that is explicitly assigned to a partition.
     * 
     * @param modelElement the model element for which to obtain the parent
     * @return the parent
     */
    public T getCompositionParent( T modelElement );

}
