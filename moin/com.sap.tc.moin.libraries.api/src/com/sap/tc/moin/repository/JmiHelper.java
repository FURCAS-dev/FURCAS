package com.sap.tc.moin.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AggregationKind;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;

/**
 * The JmiHelper can be retrieved by calling {@link Connection#getJmiHelper()}
 * on a {@link Connection} instance.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JmiHelper {

    /**
     * Constant which indicates that the multiplicity of a
     * {@link MultiplicityType} is infinite.
     */
    public static final int MULTIPLICITY_BOUND_INFINITE = -1;

    /**
     * Returns the enumeration constants for the given {@link EnumerationType
     * enumerationType}.
     * 
     * @param enumerationType the type for which to find the corresponding
     * constants.
     * @return the enumeration constants for the given {@link EnumerationType
     * enumerationType}
     */
    public List<RefEnum> getEnumerationConstants( EnumerationType enumerationType );

    /**
     * Uses a breadth first search to find the
     * {@link com.sap.tc.moin.repository.mmi.model.ModelElement} belonging to the given qualified
     * name. First tries to match the first part of the qualified name to any
     * nested or clusteredly imported package. If a match is found it tries to
     * match the hole qname against the Namespace structure. If the
     * {@link com.sap.tc.moin.repository.mmi.model.ModelElement} wasn't found it searches all direct
     * children of the clusterdly imported packages of the current package. And
     * only for those because according to the MOF constraint C-49 nested
     * packages may not have any further imports and because the first part of
     * the qualified name didn't match the nested package it is sure that it
     * isn't located in the nested packages.
     * 
     * @param qnameToSearch The qualified name for which the
     * {@link com.sap.tc.moin.repository.mmi.model.ModelElement} should be found
     * @param mofPackage The {@link com.sap.tc.moin.repository.mmi.model.MofPackage} from which to
     * start the search
     * @return The {@link com.sap.tc.moin.repository.mmi.model.ModelElement} matching the given
     * qualified name
     * @author Thomas Hettel
     */
    public ModelElement findElementByQualifiedName( List<String> qnameToSearch, MofPackage mofPackage );

    /**
     * Searches for the {@link com.sap.tc.moin.repository.mmi.model.ModelElement} with the given
     * qualified name, recursively descending from the given outermost package.
     * 
     * @param qualifiedNameToSearch The qualified name for which the
     * {@link RefPackage package extent} should be found.
     * @param outermostPackage The {@link RefPackage} from which to start the
     * search.
     * @return The {@link com.sap.tc.moin.repository.mmi.model.ModelElement} matching the given
     * qualified name.
     * @author d027299
     */
    public ModelElement findElementByQualifiedName( List<String> qualifiedNameToSearch, RefPackage outermostPackage );

    /**
     * This method computes the collection of all subtypes of the passed
     * mofClass according to the current meta model, i.e. it collects also the
     * subtypes of all subtypes and so on. <br>
     * 
     * @param aGeneralizableElement the element for which the subclasses shall
     * be computed
     * @return a Collection of GeneralizableElements which are subtypes of the
     * passed GeneralizableElement
     */
    public Collection<GeneralizableElement> getAllSubtypes( GeneralizableElement aGeneralizableElement );

    /**
     * This method computes the list of all supertypes of the passed
     * GeneralizableElement according to the current meta model, i.e. it
     * collects also the supertypes of all supertypes and so on. <br>
     * 
     * @param aGeneralizableElement the element for which the super classes
     * shall be computed
     * @return a List of GeneralizableElements which are supertypes of the
     * passed GeneralizableElement
     */
    public List<GeneralizableElement> getAllSupertypes( GeneralizableElement aGeneralizableElement );

    /**
     * Returns the association ends of the association specified.
     * 
     * @param a the association of which to determine the ends
     * @return the list of {@link com.sap.tc.moin.repository.mmi.model.AssociationEnd}s that
     * constitute the ends of the association <tt>a</tt>
     */
    public List<AssociationEnd> getAssociationEnds( Association a );

    /**
     * Fetches all association ends that have as their
     * {@link com.sap.tc.moin.repository.mmi.model.AssociationEnd#getType() type} the
     * <tt>classifier</tt> passed. If <tt>includeSupertypes</tt> is set to
     * <tt>true</tt>, the result also includes the association ends that have as
     * their type any of <tt>mofClass</tt>'s supertypes. Association ends
     * inherited via multiple paths are included only once in the resulting set.
     * 
     * @param classifier the classifier for which to find the
     * {@link AssociationEnd}s
     * @param includeSupertypes if <code>true</code>, the supertypes of the
     * given classifier are also considered
     * @return the {@link AssociationEnd}s which have the given classifier as
     * their {@link com.sap.tc.moin.repository.mmi.model.AssociationEnd#getType() type}
     */
    public Set<AssociationEnd> getAssociationEnds( Classifier classifier, boolean includeSupertypes );

    /**
     * For an association finds out if any of its end is composite, and if so,
     * which one. Being composite means that the
     * {@link AssociationEnd#getAggregation()} is
     * {@link AggregationKindEnum#COMPOSITE}).
     * 
     * @param a The association for which to find a composite end
     * @return the association end which is composite, or null if none of the
     * association's ends are composite
     */
    public AssociationEnd getCompositeAssociationEnd( Association a );

    /**
     * Checks if the given {@link AssociationEnd} is the first of the two ends
     * of association <tt>a</tt>. This is important for appropriate access to
     * the associations container where the association instances (links) are
     * stored in an ordered way. Therefore, when trying to access an association
     * end, its position in the association decides how to access the
     * associations container.
     * 
     * @param a the Association for which to check if the given AssociationEnd
     * is the fist end.
     * @param ae the AssociationEnd for which to check if it is the first end of
     * the given Association.
     * @return <code>true</code> if the given AssociationEnd is the first end of
     * the given Association, <code>false</code> otherwise.
     */
    public boolean isFirstAssociationEnd( Association a, AssociationEnd ae );

    /**
     * Returns the {@link com.sap.tc.moin.repository.mmi.model.Attribute Attribute} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} with the given name or null if
     * the class does not have any attribute with that name.
     * 
     * @param mofClass the MofClass the attribute of which is returned
     * @param attributeName the attribute name
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     * @return the {@link com.sap.tc.moin.repository.mmi.model.Attribute Attribute} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} with the given name.
     * <code>null<code> if the class does not have any attribute with the given name.
     */
    public Attribute getAttributeByName( MofClass mofClass, String attributeName, boolean includeSupertypes );

    /**
     * Returns all {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}. If includeSupertypes is set to
     * true, all {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of all supertypes
     * of the given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} are returned too.
     * 
     * @param mofClass the MofClass the attributes of which are returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     * @return the List of {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the
     * given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}
     */
    public List<Attribute> getAttributes( MofClass mofClass, boolean includeSupertypes );

    /**
     * Returns the {@link com.sap.tc.moin.repository.mmi.reflect.RefObject RefObject's}
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute attributes} associated with its values.
     * 
     * @param refObject the RefObject for which
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} with its values are to be
     * returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.reflect.RefObject RefObject's}
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     * @return a LinkedHashMap with having the
     * {@link com.sap.tc.moin.repository.mmi.reflect.RefObject RefObject's}
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} associated with its values.
     * If the values are of a primitive Java type, instances of the according
     * wrapper classes are returned. If the cardinality of the Attribute is
     * greater than one, a {@link java.util.Collection Collection} or in case of
     * an ordered Association a {@link java.util.List List} is returned.
     * @see #getAttributes(MofClass, boolean)
     */
    public Map<Attribute, Object /* value */> getAttributesWithValues( RefObject refObject, boolean includeSupertypes );

    /**
     * Returns the Java type of the StructuralFeature if the StructuralFeature's
     * MOF type is of type {com.sap.tc.moin.repository.mmi.model.PrimitiveType PrimitiveType}. It
     * depends then on the cardinality, if a Java Wrapper class or a Java
     * primitive type is used. Only if the multiplicity is defined as lower = 1
     * and upper = 1 then a Java primitive type is used in JMI, otherwise it is
     * a Java Wrapper class. In all other cases <code>null</code> is returned.
     * <p>
     * The returned Java type {@link java.lang.Class Class} can be one of these
     * values:
     * <ul>
     * <li>{@link java.lang.String String}.class in case of <code>String</code></li>
     * <li>{@link java.lang.Boolean Boolean}.class in case of
     * <code>Boolean</code></li>
     * <li>{@link java.lang.Boolean Boolean}.TYPE in case of
     * <code>boolean</code></li>
     * <li>{@link java.lang.Integer Integer}.class in case of
     * <code>Integer</code></li>
     * <li>{@link java.lang.Integer Integer}.TYPE in case of <code>int</code></li>
     * <li>{@link java.lang.Long Long}.class in case of <code>Long</code></li>
     * <li>{@link java.lang.Long Long}.TYPE in case of <code>long</code></li>
     * <li>{@link java.lang.Float Float}.class in case of <code>Float</code></li>
     * <li>{@link java.lang.Float Float}.TYPE in case of <code>float</code></li>
     * <li>{@link java.lang.Double Double}.class in case of <code>Double</code></li>
     * <li>{@link java.lang.Double Double}.TYPE in case of <code>double</code></li>
     * <li><code>null</code> in all other cases</li>
     * </ul>
     * 
     * @param structuralFeature the StructuralFeature (which is either an
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attribute} or
     * {@link com.sap.tc.moin.repository.mmi.model.Reference Reference}) for which the Java type
     * should be returned
     * @return the Java type of the StructuralFeature or null
     * @author d024227
     */
    public Class<?> getJavaPrimitiveOrWrapperType( StructuralFeature structuralFeature );

    /**
     * Returns the non-alias type for the given type. If the specified type is
     * an alias type the alias is recursively asked for its type till a
     * non-alias type is found which is then returned. Dependency cycles are not
     * allowed; in case one is detected a RuntimeException is thrown. See MOF
     * spec chapter 5.5 which says "An AliasType, CollectionType, or
     * StructureType may not depend on itself via a chain of IsOfType and
     * Contains links between DataType or StructureField instances. For example,
     * MOF DataTypes that map to IDL recursive data types are not supported."
     * 
     * @param type The TypedElement for which the type should be returned
     * @return the non-alias type of the specified TypedElement
     * @author d024227
     */
    public Classifier getNonAliasType( Classifier type );

    /**
     * Returns the non-alias type of the TypedElement. If the specified type is
     * an alias type the alias is recursively asked for its type till a
     * non-alias type is found which is then returned. Dependency cycles are not
     * allowed; in case one is detected a RuntimeException is thrown. See MOF
     * spec chapter 5.5 which says "An AliasType, CollectionType, or
     * StructureType may not depend on itself via a chain of IsOfType and
     * Contains links between DataType or StructureField instances. For example,
     * MOF DataTypes that map to IDL recursive data types are not supported."
     * 
     * @param typedElement the TypedElement for which the type should be
     * returned
     * @return the non-alias type of the specified TypedElement
     * @author d024227
     */
    public Classifier getNonAliasType( TypedElement typedElement );

    /**
     * Returns the reference for a mofClass given by its name. If
     * includeSupertypes==true, then the supertypes of the mofClass are also
     * considered. If no feature is found, then null is returned.
     * 
     * @param mofClass the class for which to find a reference by the given name
     * @param referenceName the name of the reference to find
     * @param includeSupertypes if <code>true</code>, the supertypes of the
     * given class are also considered
     * @return the reference for the given class and name, <code>null</code> if
     * not found.
     */
    public Reference getReferenceByName( MofClass mofClass, String referenceName, boolean includeSupertypes );

    /**
     * Obtains the references that expose a specific association end. This
     * convenience operation obtains the <tt>Exposes</tt> association from the
     * MOF <tt>model</tt> package and uses it to navigate from the association
     * end to its referring references.
     * 
     * @param ae the association end to look for exposing reference for
     * @return the reference whose <tt>exposedEnd</tt> is the association end
     * passed as <tt>ae</tt>, or <tt>null</tt> if no such reference exists.
     */
    public Collection<Reference> getReferences( AssociationEnd ae );

    /**
     * Returns all {@link com.sap.tc.moin.repository.mmi.model.Reference references} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}. If includeSupertypes is set to
     * true, all {@link com.sap.tc.moin.repository.mmi.model.Reference references} of all supertypes
     * of the given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} are returned too.
     * The parameter aggregationKind of type
     * {@link com.sap.tc.moin.repository.mmi.model.AggregationKind AggregationKind} specifies the
     * kind of {@link com.sap.tc.moin.repository.mmi.model.Reference references} which should be
     * returned:
     * <p>
     * <ul>
     * <li>{@link AggregationKindEnum#COMPOSITE COMPOSITE}</li>
     * <li>{@link AggregationKindEnum#NONE NONE}</li>
     * <li>{@link AggregationKindEnum#SHARED SHARED}</li>
     * </ul>
     * <p>
     * If it is set to null, all kinds of {@link com.sap.tc.moin.repository.mmi.model.Reference
     * references} are returned.
     * 
     * @param mofClass the MofClass the attributes of which are returned
     * @param aggregationKind the kind of references which should be returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Reference references} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     * @return the List of {@link com.sap.tc.moin.repository.mmi.model.Reference references} of the
     * given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}
     */
    public List<Reference> getReferences( MofClass mofClass, AggregationKind aggregationKind, boolean includeSupertypes );

    /**
     * This method computes the collection of direct subtypes of the passed
     * mofClass according to the current meta model. <br>
     * The call is forwarded to
     * {@link com.sap.tc.moin.repository.mmi.model.Generalizes#getSubtype(GeneralizableElement)}.
     * 
     * @param generalizableElement the element (M2 Layer) for which the
     * subclasses shall be computed
     * @return a Collection of GeneralizableElements which are subtypes of the
     * passed element
     */
    public Collection<GeneralizableElement> getSubTypes( GeneralizableElement generalizableElement );

    // -----

    /**
     * Searches for the {@link RefPackage} with the given qualified name,
     * recursively descending from the given outermost package.
     * 
     * @param qualifiedNameToSearch The qualified name for which the
     * {@link RefPackage package extent} should be found.
     * @param outermostPackage The {@link com.sap.tc.moin.repository.mmi.reflect.RefPackage} from
     * which to start the search.
     * @return The {@link RefPackage} matching the given qualified name.
     * @author d027299
     */
    public RefPackage findRefPackageByQualifiedName( List<String> qualifiedNameToSearch, RefPackage outermostPackage );

    /**
     * Determines whether this association has a stored representation at the
     * end with the specified number.
     * 
     * @param endNumber the number of the end for which to check storage.
     * @param association the association to check one of its ends for storage.
     * @return <code>true</code> the specified end number is stored in the
     * specified association, <code>false</code> otherwise (this includes the
     * case where the end number is neither 0 or 1).
     */
    public boolean isEndStored( int endNumber, Association association );

    /**
     * Determines whether links of an association are stored at the given
     * {@link AssociationEnd}.
     * 
     * @param associationEnd the end to be checked for storage
     * @return <code>true</code> if the given end is considered to have storage,
     * <code>false</code> otherwise.
     */
    public boolean isEndStored( AssociationEnd associationEnd );

    /**
     * Collects the composite children of the given <code>rootElement</code>.
     * The composite children are collected no matter in which
     * {@link ModelPartition} they reside or which Association/Attribute they
     * belong to. There is no order guaranteed and even after a save/reload
     * cycle the order of the elements can differ! If the order needs to be
     * stable, use the {@link #getCompositeChildrenStable(RefObject, boolean)}
     * instead (but be aware that that method is much more expensive than this
     * one!).
     * 
     * @param rootElement The element for which the children shall be retrieved
     * @param recursively If this parameter is <code>true</code> then the
     * complete child hierarchy is retrieved. If <code>false</code> then only
     * the direct children will be returned.
     * @return the composite children of the given element. An empty collection
     * if there are no children, therefore never <code>null</code>.
     */
    public Collection<RefObject> getCompositeChildren( RefObject rootElement, boolean recursively );

    /**
     * Collects the composite children of the given <code>rootElement</code>.
     * The composite children are collected no matter in which
     * {@link ModelPartition} they reside or which Association/Attribute they
     * belong to. The order of the returned elements is guaranteed to be stable.
     * If an involved Association/Attribute is ordered, the order of the
     * elements is kept. <br>
     * <b>This method is much more expensive than
     * {@link #getCompositeChildren(RefObject, boolean)} which guarantees no
     * stable order.</b>
     * 
     * @param rootElement The element for which the children shall be retrieved
     * @param recursively If this parameter is <code>true</code> then the
     * complete child hierarchy is retrieved. If <code>false</code> then only
     * the direct children will be returned.
     * @return the composite children of the given element. An empty collection
     * if there are no children, therefore never <code>null</code>.
     * @see #getCompositeChildren(RefObject, boolean)
     */
    public Collection<RefObject> getCompositeChildrenStable( RefObject rootElement, boolean recursively );

    /**
     * Collects the partitions that will be made dirty if this element is
     * deleted. This list contains all partitions if the composite children (see
     * {@link #getCompositeChildren(RefObject, boolean)}). In addition all
     * partitions that have stored links that pointed into the composition
     * hierarchy.
     * 
     * @param rootElement The element for which the partitions shall be
     * retrieved
     * @return the affected partitions if the given element is deleted.
     */
    public Collection<PRI> getAffectedPartitionsForRefDelete( RefObject rootElement );

    /**
     * Calculates how elements of the given parent and child classes can be set
     * in a direct composition relation
     * 
     * @param parentClass Class of the element to act as parent of the
     * composition
     * @param childClass Class of the element to be the composite
     * @return a set of possible composite associations between the given
     * classes
     */
    public Collection<Association> getCompositeAssociations( MofClass parentClass, MofClass childClass );

    /**
     * Returns the {@link RefPackage} corresponding to the given
     * {@link MofPackage}.
     * 
     * @param mofPackage the {@link MofPackage} for which to find the
     * corresponding {@link RefPackage}
     * @return the {@link RefPackage} corresponding to the given
     * {@link MofPackage}, <code>null</code> if not existing.
     */
    public RefPackage getRefPackageForMofPackage( MofPackage mofPackage );

    /**
     * Returns the {@link RefAssociation} corresponding to the given
     * {@link Association}.
     * 
     * @param association the {@link Association} for which to find the
     * corresponding {@link RefAssociation}
     * @return the {@link RefAssociation} corresponding to the given
     * {@link Association}, <code>null</code> if not existing.
     */
    public RefAssociation getRefAssociationForAssociation( Association association );

    /**
     * Returns the {@link RefClass} corresponding to the given {@link MofClass}.
     * 
     * @param mofClass the {@link MofClass} for which to find the corresponding
     * {@link RefClass}
     * @return the {@link RefClass} corresponding to the given {@link MofClass},
     * <code>null</code> if not existing.
     */
    public RefClass getRefClassForMofClass( MofClass mofClass );

    /**
     * Clones the given source structure and optionally sets field values for
     * the clone. All other fields remain the same.
     * 
     * @param structToClone the {@link RefStruct} that should be cloned
     * @param containerForFieldsToSet an optional structure field container for
     * the field values that should be set for the clone, if <code>null</code>
     * all fields remain the same in the clone as in the source structure
     * @return a {@link RefStruct} clone
     */
    public <T extends RefStruct> T cloneStruct( T structToClone, StructureFieldContainer<? extends T> containerForFieldsToSet );
}
