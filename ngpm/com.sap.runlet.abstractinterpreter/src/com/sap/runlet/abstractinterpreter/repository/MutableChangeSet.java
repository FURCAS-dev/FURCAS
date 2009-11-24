package com.sap.runlet.abstractinterpreter.repository;

import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;



/**
 * Change set that can be changed by adding created/deleted object/link entries
 * 
 * @author Axel Uhl (D043530)
 */
public interface MutableChangeSet<LinkMetaObject extends RefObject, LinkEndMetaObject extends RefObject,
MetaClass extends RefObject, TypeUsage extends RefObject, ClassUsage extends TypeUsage>
extends ChangeSet<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    /**
     * Postcondition: <tt>this.isEmpty()</tt>
     */
    void clear();

    void entityCreated(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity);
    
    void entityDeleted(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity);
    
    /**
     * Records a link creation.
     * 
     * @param at for ordered associations, specify the position at which the link was added.
     * <tt>null</tt> or <tt>-1</tt> are not allowed if <tt>link.isOrdered()</tt>. The real
     * insert position must be specified instead which then equals the size of the ordered
     * collection holding the links when viewed from the unordered end.
     */
    void linkCreated(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at);
    
    void linkDeleted(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at);
}
