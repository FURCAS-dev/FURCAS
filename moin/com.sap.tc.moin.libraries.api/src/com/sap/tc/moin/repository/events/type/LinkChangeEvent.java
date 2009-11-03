package com.sap.tc.moin.repository.events.type;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * LinkChangeEvents are fired when instances of meta model associations (=links)
 * are created or removed. The abstract LinkChangeEvent carries the information
 * about the two elements the link connects and the meta object the link
 * corresponds to. The position of the link is additionally stored and can be
 * obtained by calling either {@link #getFirstLinkEndMri()} or
 * {@link #getSecondLinkEndMri()}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Martin Kolb
 */
public interface LinkChangeEvent extends ModelChangeEvent {

    /**
     * Retrieves the link end at the "storage" side of the link. The storage
     * side of a link is always available if a link is added or removed.
     * Therefore this link end can be retrieved via a {link {@link MRI}.
     * 
     * @return the {link {@link MRI} of the link end at the storage side.
     */
    public MRI getStoredLinkEndMri( );

    /**
     * Retrieves the link end at the "non-storage" side of the link. The
     * non-storage side of a link might be unavailable if a link is added or
     * removed. The reason might be a dangling link or a link where the
     * non-storage side is not yet loaded into memory. Therefore the non-storage
     * can link end can be retrieved via a {link {@link LRI}.
     * 
     * @return the {link {@link LRI} of the link end at the storage side.
     */
    public LRI getNonStoredLinkEndLri( );

    /**
     * If the corresponding association is ordered and has a upper multiplicity
     * greater than 1, the position of the current link end can be obtained by
     * calling this method. If not, "-1" will be returned.
     * 
     * @return the position of the link end or "-1" if the link end is not
     * ordered.
     */
    public int getPosition( );

    /**
     * Returns an instance of the meta object of the link (more precisely the
     * MRI that points to that instance).
     * 
     * @return an {@link MRI} that points to the meta object.
     */
    public MRI getAffectedMetaObjectMri( );

    /**
     * resolves the MRI which can be retrieved using the
     * {@link #getAffectedMetaObjectMri()}method.
     * 
     * @param resolvingConnection the connection used to resolve the MRI.
     * @return the meta object of the link (its type)
     */
    public RefFeatured getAffectedMetaObject( Connection resolvingConnection );

    /**
     * This method returns the first object that the link connects.
     * 
     * @return an {@link MRI MRI}that points to one of the two elements which
     * are connected by the current link.
     */
    public MRI getFirstLinkEndMri( );

    /**
     * Resolves the MRI which can be retrieved using the
     * {@link #getFirstLinkEndMri()}method.
     * 
     * @param resolvingConnection the connection used to resolve the MRI.
     * @return the element the link end points to.
     */
    public RefObject getFirstLinkEnd( Connection resolvingConnection );

    /**
     * This methods returns the second object that the link connects.
     * 
     * @return an {@link MRI MRI}that points to one of the two elements which
     * are connected by the current link.
     */
    public MRI getSecondLinkEndMri( );

    /**
     * Resolves the MRI which can be retrieved using the
     * {@link #getSecondLinkEndMri()}method.
     * 
     * @param resolvingConnection the connection used to resolve the MRI.
     * @return the element the link end points to.
     */
    public RefObject getSecondLinkEnd( Connection resolvingConnection );

}