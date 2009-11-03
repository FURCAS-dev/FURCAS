/*
 * Created on 07.10.2005
 */
package com.sap.tc.moin.repository.core.jmi.extension;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;

/**
 * @author d024227
 */
public interface RefClassExtension extends RefClass, RefFeaturedExtension {

    public RefObject get___Instance( ) throws JmiException;

    public boolean is___Abstract( ) throws JmiException;

    public boolean is___Singleton( ) throws JmiException;

    /**
     * Returns either the Attribute or the Reference specified by its name
     * 
     * @param name the name of the Attribute or Reference
     * @return the Attribute or Reference specified by name
     */
    public RefObject get___AttributeOrReferenceByName( String name );

    /**
     * Returns either the Attribute or the AssociationEnd specified by either
     * the Attribute's name or the name of the Reference referencing the
     * AssociationEnd.
     * 
     * @param name the name of the Attribute or Reference
     * @return the Attribute or AssociationEnd specified by name
     */
    public RefObject get___AttributeOrAssociationEndByName( String name );

    /**
     * Checks if this instance may have a link to a composite parent that may be
     * stored only in a partition different from that holding this model
     * element. This is the case if there exists a composite association with
     * this element's class (or a superclass thereof) on the component (child)
     * end that has no storage for the component (child) end.
     * <p>
     * The results of this operation are cached for this class extent.
     * 
     * @param connection
     * @return <tt>true</tt> if and only if this instance may be linked to a
     * composite parent by a link that is not stored in the partition holding
     * this model element.
     * <p>
     */
    public boolean ___mayHaveParentLinkInOtherPartition( CoreSession session );

    public Set<AssociationEnd> get___UnstoredCompositeChildAssociationEnds( CoreSession session );

    public Set<AssociationEnd> get___UnstoredCompositeParentAssociationEnds( CoreSession session );

    /**
     * Checks if this instance may have a link to a composite parent that may be
     * stored only in a partition different from that holding this model
     * element. This is the case if there exists a composite association with
     * this element's class (or a superclass thereof) on the component (child)
     * end that has no storage for the component (child) end.
     * <p>
     * The results of this operation are cached for this class extent.
     * 
     * @return <tt>true</tt> if and only if this instance may be linked to a
     * composite parent by a link that is not stored in the partition holding
     * this model element.
     * <p>
     * @throws JmiException with cause NameNotFoundException in case the
     * IsOfType association couldn't be resolved which is required to determine
     * the association ends on <tt>classifier</tt>. This is typically the
     * case during the construction of the MOF ROM.
     */
    public boolean ___mayHaveChildLinkInOtherPartition( CoreSession session );

    public void ___refresh( );

    public EndAndMetaObject get___EndAndMetaObject( String mofId, int endNumberOfToEnd );
}