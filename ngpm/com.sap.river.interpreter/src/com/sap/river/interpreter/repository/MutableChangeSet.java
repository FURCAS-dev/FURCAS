package com.sap.river.interpreter.repository;

import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;



/**
 * Change set that can be changed by adding created/deleted object/link entries
 * 
 * @author Axel Uhl (D043530)
 */
public interface MutableChangeSet extends ChangeSet {
    /**
     * Postcondition: <tt>this.isEmpty()</tt>
     */
    void clear();

    void entityCreated(EntityObject entity);
    
    void entityDeleted(EntityObject entity);
    
    /**
     * Records a link creation.
     * 
     * @param at for ordered associations, specify the position at which the link was added.
     * <tt>null</tt> or <tt>-1</tt> are not allowed if <tt>link.isOrdered()</tt>. The real
     * insert position must be specified instead which then equals the size of the ordered
     * collection holding the links when viewed from the unordered end.
     */
    void linkCreated(Link link, Integer at);
    
    void linkDeleted(Link link, Integer at);
}
