package com.sap.tc.moin.friends;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;


/**
 * RefObjectUtil is an interface that provides extended functionality for the
 * {@link RefObject} interface.
 */
public interface RefObjectUtil {

    /**
     * Convenience method. Same as calling
     * {@link #addLinkTarget(RefObject, AssociationEnd, LRI, int)} with -1 as
     * last argument.
     * 
     * @param host the element where the link to add is stored.
     * @param targetAssociationEnd the {@link AssociationEnd} of the target
     * element (implicitly specifies the type of the target element and the
     * Association on whose behalf the link is to be added).
     * @param target the target element which is to be linked to the host
     * element
     * @see #addLinkTarget(RefObject, AssociationEnd, LRI, int)
     */
    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target );

    /**
     * Adds a link between the elements <tt>host</tt> and <tt>target</tt> on
     * behalf of the {@link Association} implicitly specified by
     * <code>targetAssociationEnd.getContainer()</code>. The
     * {@link AssociationEnd} of the <tt>host</tt> element is implicitly
     * specified by <code>targetAssociationEnd.otherEnd()</code>. The target
     * element is only specified by its {@link LRI} and therefore needs not
     * necessarily exist. Thus it is possible to create a "dangling" link i.e. a
     * link to a non-resolvable element. The host element must be of the type
     * specified by <code>targetAssociationEnd.otherEnd().getType()</code>. The
     * target element must be of the type specified by
     * <code>targetAssociationEnd.getType()</code>. This will only be checked if
     * the target element is existing and loaded to memory.<br>
     * The link will be stored at the host element therefore the
     * {@link AssociationEnd} of the host element (i.e.
     * <code>targetAssociationEnd.otherEnd()</code>) must be stored. Or in other
     * words, the statement
     * <code>JmiHelper.isEndStored(targetAssociationEnd.otherEnd())</code> must
     * return <code>true</code>.<br>
     * If the <tt>targetAssociationEnd</tt> has a multiplicity > 1 and is
     * ordered, the <tt>position</tt> of the link to add can be specified,
     * otherwise only -1 is allowed as position. If the <tt>position</tt> is -1,
     * the link will be appended. No link replacement takes place, the link will
     * be inserted at the specified position i.e. that all links at a position
     * >= <tt>position</tt> will be shifted up by one position.<br>
     * If the specified link already exists, calling this method is a no-op.<br>
     * If the upper cardinality (
     * <code>targetAssociationEnd.getMultiplicity().getUpper()</code>) would be
     * exceeded by adding the specified link, a {@link WrongSizeException} is
     * thrown, no kind of replacement takes place.
     * 
     * @param host the element where the link to add is stored.
     * @param targetAssociationEnd the {@link AssociationEnd} of the target
     * element (implicitly specifies the type of the target element and the
     * Association on whose behalf the link is to be added).
     * @param target the target element which is to be linked to the host
     * element
     * @param position -1 is always valid or otherwise a specific position where
     * to add the link
     * @throws IllegalArgumentException thrown if either <tt>host</tt>,
     * <tt>targetAssociationEnd</tt> or <tt>target</tt> is null. Also thrown if
     * the association end of the host element is not stored and thrown if the
     * association end of the target is not ordered and <tt>position</tt> != -1.
     * @throws TypeMismatchException thrown if either the specified
     * <tt>host</tt> element is not of type
     * <code>targetAssociationEnd.otherEnd().getType()</code> or the
     * <tt>target</tt> element is loaded and not of type
     * <code>targetAssociationEnd.getType()</code>. If the <tt>target</tt>
     * element is not existing, the type cannot be checked.
     * @throws IndexOutOfBoundsException thrown if the specified
     * <tt>position</tt> is not within the index range of the existing
     * collection of links, except for -1 which is always a valid value for the
     * <tt>position</tt>.
     * @throws WrongSizeException thrown if the upper cardinality (
     * <code>targetAssociationEnd.getMultiplicity().getUpper()</code>) would be
     * exceeded by adding the specified link.
     */
    public void addLinkTarget( RefObject host, AssociationEnd targetAssociationEnd, LRI target, int position );

    /**
     * Deletes the given element and all links which are stored at the element.
     * In contrast to the regular {@link RefObject#refDelete()}, no delete
     * propagation (i.e. deletion of composite children elements) takes place,
     * links where the element is at the non-stored end are not deleted and no
     * composite child elements have their partition assignment changed.
     * <p>
     * Only the links which are stored at the element are deleted whereas all
     * links where the element is at the non-stored end are not changed and
     * therefore will be dangling after execution of this method.<br>
     * No "partition magic" takes place at all, therefore every element
     * (especially composite children of the deleted element) will have the same
     * {@link ModelPartition partition} assigned as before execution of this
     * method.
     * 
     * @param elementToDelete the element to be deleted
     * @throws IllegalArgumentException thrown if the element to delete is
     * <code>null</code>
     */
    public void deleteIsolated( RefObject elementToDelete );

    /**
     * Returns a snapshot of all {@link AssociationLink links} that are stored
     * at the given element.
     * <p>
     * Only links on behalf of {@link Association associations} are returned, no
     * links on behalf of {@link Attribute object-valued attributes}.<br>
     * Only links that are stored at the element are returned, no links where
     * the element is only at the {@link AssociationLink#getOtherEnd()
     * non-stored end}.
     * 
     * @param element the element for which to get all {@link AssociationLink
     * links} that are stored at the element
     * @return all {@link AssociationLink links} that are stored at the given
     * element, an empty collection if there are no links, never
     * <code>null</code>.
     * @throws IllegalArgumentException thrown if the element is
     * <code>null</code>
     */
    public Collection<AssociationLink> getAssociationLinks( RefObject element );

    /**
     * Returns the link which backs the "immediate composite" association
     * 
     * @param child the child
     * @return the link, or null if the child is not contained anywhere or if it
     * is contained as attribute
     */
    public AssociationLink getCompositeAssociationParentLink( RefObject child );
}
