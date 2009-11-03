package com.sap.tc.moin.repository.mmi.reflect;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Association;

/**
 * Provides the metaobject description of an association. It also provides
 * generic operations querying and updating the links that belong to the
 * association.
 * <p>
 * The model of association supported by this interface is of collection of two
 * ended asymmetric links between objects. The links may be viewed as ordered on
 * one or other of the ends, and there may be some form of cardinality
 * constraints on either end.
 * <p>
 * The <code>RefAssociation</code> interface is designed to be used with
 * associations that contain no duplicate links, though this is not an absolute
 * requirement. There is no assumption that different association objects for a
 * given association type are mutually aware. Links are modeled as having no
 * object identity. (A data model that required "heavy weight" links with object
 * identity (e.g., so that attributes could be attached to them) would need to
 * represent them as {@link RefObject} instances. The
 * <code>RefAssociation</code> interface could be used to mange light weight
 * links between the heavy weight link objects they connect. Similar techniques
 * could be used to represent n-ary associations. However, in both cases better
 * performance would be achieved using a purpose built reflective layer.)
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefAssociation extends RefBaseObject {

    /**
     * Returns true if and only if the supplied link is a member of the link set
     * for this association object.
     * 
     * @param firstEnd the {@link RefObject} at the one end of the association
     * @param secondEnd the {@link RefObject} at the other end of the
     * association
     * @return true if and only if the supplied link is a member of the link set
     * for this association object.
     * @throws TypeMismatchException if the parameters do not match the types of
     * the respective association ends.
     */
    public boolean refLinkExists( RefObject firstEnd, RefObject secondEnd );

    /**
     * Returns a list containing all instance objects that are linked to the
     * supplied <code>queryObject</code> by links in the extent of this
     * association object, where the links all have the <code>queryObject</code>
     * at the <code>queryEnd</code>.
     * 
     * @param queryEnd the association end for this association object
     * @param queryObject the object at the <code>queryEnd</code>
     * @return a list containing all instance object that are linked to the
     * supplied <code>queryObject</code>.
     * @throws InvalidCallException if the <code>queryEnd</code> parameter does
     * not designate an association end for this association object.
     * @throws TypeMismatchException if the <code>queryObject</code> parameter
     * is an instance object whose type is incompatible with the type of the
     * <code>queryEnd</code> of the association.
     */
    public Collection<RefObject> refQuery( RefObject queryEnd, RefObject queryObject );

    /**
     * Returns a list containing all instance objects that are linked to the
     * supplied <code>queryObject</code> by links in the extent of this
     * association object, where the links all have the <code>queryObject</code>
     * at the association end with the name <code>endName</code>.
     * 
     * @param endName the name of the association end for this association
     * object
     * @param queryObject the object at the <code>queryEnd</code>
     * @return a list containing all instance object that are linked to the
     * supplied <code>queryObject</code>.
     * @throws InvalidCallException if the <code>queryEnd</code> parameter does
     * not designate an association end for this association object.
     * @throws TypeMismatchException if the <code>queryObject</code> parameter
     * is an instance object whose type is incompatible with the type of the
     * <code>queryEnd</code> of the association.
     */
    public Collection<RefObject> refQuery( String endName, RefObject queryObject );

    /**
     * Adds <code>newLink</code> into the set of links in the extent of this
     * association object. If one or other of the association's ends is ordered,
     * the link is inserted after the last link with respect to that ordering.
     * 
     * @param firstEnd the object at the first end of the association
     * @param secondEnd the object at the second end of the association
     * @return <code>true</code> if the association did not already contain the
     * link, and the link was successfully added
     * @throws TypeMismatchException if the instance objects are not compatible
     * with the association.
     * @throws InvalidObjectException if one or more instance objects are not
     * valid instance objects.
     */
    public boolean refAddLink( RefObject firstEnd, RefObject secondEnd );


    /**
     * Removes the existing link from the association.
     * 
     * @param firstEnd the object at the first end of the association
     * @param secondEnd the object at the second end of the association
     * @return <code>true</code> if the link was successfully removed
     * @throws WrongSizeException if removing the link causes the association
     * end to violate the specified multiplicity.
     */
    public boolean refRemoveLink( RefObject firstEnd, RefObject secondEnd );

    public Association refMetaObject( );
}
