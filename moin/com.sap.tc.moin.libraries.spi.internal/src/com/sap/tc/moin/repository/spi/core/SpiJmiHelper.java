/*
 * Created on 06.07.2006
 */
package com.sap.tc.moin.repository.spi.core;

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
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;

/**
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d044711
 */
public interface SpiJmiHelper {

    public static final byte STORED_END_0 = 0;

    public static final byte STORED_END_1 = 1;

    public static final String TRANSLATABLE_TEXT_QNAME = "textverticalization.TranslatableText"; //$NON-NLS-1$

    public static final String TRANSLATABLE_TEXT_FRAGMENT_QNAME = "textverticalization.TranslatableTextFragment"; //$NON-NLS-1$

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
    @Deprecated
    public List<Attribute> getAttributes( MofClass mofClass, boolean includeSupertypes );

    public List<Attribute> getAttributes( Session session, MofClass mofClass, boolean includeSupertypes );

    /**
     * Returns the {@link com.sap.tc.moin.repository.mmi.model.Attribute Attribute} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} with the given name or null if
     * the class does not have any attribute with that name.
     * 
     * @param mofClass the MofClass of which the attribute is returned
     * @param attributeName the name of the attribute that is returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     */
    public Attribute getAttributeByName( Connection connection, MofClass mofClass, String attributeName, boolean includeSupertypes );

    /**
     * Fetches all association ends that have as their
     * {@link AssociationEnd#getType() type} the <tt>classifier</tt> passed. If
     * <tt>includeSupertypes</tt> is set to <tt>true</tt>, the result also
     * includes the association ends that have as their type any of
     * <tt>mofClass</tt>'s supertypes. Association ends inherited via multiple
     * paths are included only once in the resulting set.
     */
    public Set<AssociationEnd> getAssociationEnds( Session session, Classifier classifier, boolean includeSupertypes );

    /**
     * Fetches all association ends that have as their
     * {@link AssociationEnd#getType() type} the <tt>classifier</tt> passed, and
     * for which {@link #isEndStored(AssociationEnd)} returns <code>true</code>.
     * If <tt>includeSupertypes</tt> is set to <tt>true</tt>, the result also
     * includes the association ends that have as their type any of
     * <tt>mofClass</tt>'s supertypes and that match the other criteria
     * described above. Association ends inherited via multiple paths are
     * included only once in the resulting set.
     */
    public Set<AssociationEnd> getStoredAssociationEnds( Session session, Classifier classifier, boolean includeSupertypes );

    /**
     * Fetches all association ends that have as their
     * {@link AssociationEnd#getType() type} the <tt>classifier</tt> passed, and
     * for which {@link #isEndStored(AssociationEnd)} returns <code>false</code>
     * , and for which <tt>otherEnd().isComposite()</tt> returns <tt>true</tt>,
     * meaning that the end on <tt>classifier</tt> represents the component
     * (child) in the composition.
     * <p>
     * If <tt>includeSupertypes</tt> is set to <tt>true</tt>, the result also
     * includes the association ends that have as their type any of
     * <tt>mofClass</tt>'s supertypes and that match the other criteria
     * described above. Association ends inherited via multiple paths are
     * included only once in the resulting set.
     */
    public Set<AssociationEnd> getUnstoredCompositeAssociationEndsOnChild( Session session, Classifier classifier, boolean includeSupertypes, boolean findFirstOnly );

    /**
     * Fetches all association ends that have as their
     * {@link AssociationEnd#getType() type} the <tt>classifier</tt> passed, and
     * for which {@link #isEndStored(AssociationEnd)} returns <code>false</code>
     * , and for which <tt>isComposite()</tt> returns <tt>true</tt>, meaning
     * that the end on <tt>classifier</tt> represents the composite (parent) in
     * the composition.
     * <p>
     * If <tt>includeSupertypes</tt> is set to <tt>true</tt>, the result also
     * includes the association ends that have as their type any of
     * <tt>mofClass</tt>'s supertypes and that match the other criteria
     * described above. Association ends inherited via multiple paths are
     * included only once in the resulting set.
     * 
     * @throws JmiException with cause NameNotFoundException in case the
     * IsOfType association couldn't be resolved which is required to determine
     * the association ends on <tt>classifier</tt>. This is typically the case
     * during the construction of the MOF ROM.
     */
    public Set<AssociationEnd> getUnstoredCompositeAssociationEndsOnParent( Session session, Classifier classifier, boolean includeSupertypes, boolean findFirstOnly );

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
     * <li>{@link com.sap.tc.moin.repository.mmi.model.AggregationKindEnum#COMPOSITE COMPOSITE}</li>
     * <li>{@link com.sap.tc.moin.repository.mmi.model.AggregationKindEnum#NONE NONE}</li>
     * <li>{@link com.sap.tc.moin.repository.mmi.model.AggregationKindEnum#SHARED SHARED}</li>
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
    @Deprecated
    public List<Reference> getReferences( MofClass mofClass, AggregationKind aggregationKind, boolean includeSupertypes );

    public List<Reference> getReferences( Session session, MofClass mofClass, boolean includeSupertypes );

    public List<Reference> getReferences( Session session, MofClass mofClass, AggregationKind aggregationKind, boolean includeSupertypes );

    public List<StructuralFeature> getStructuralFeatures( Session session, MofClass mofClass, boolean includeSupertypes );

    /**
     * Returns the reference for a mofClass given by its name. If
     * includeSupertypes==true, then the supertypes of the mofClass are also
     * considered. If no feature is found, then null is returned
     */
    public Reference getReferenceByName( Connection connection, MofClass mofClass, String referenceName, boolean includeSupertypes );

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
     * @see #getAttributes(Connection, MofClass, boolean)
     */
    public Map<Attribute, Object /* value */> getAttributesWithValues( Connection connection, RefObject refObject, boolean includeSupertypes );

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
    public Collection<Reference> getReferences( Session session, AssociationEnd ae );

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
    public Class<?> getJavaPrimitiveOrWrapperType( Connection connection, StructuralFeature structuralFeature );

    /**
     * Returns the Java wrapper class of the given {@link Classifier type} if
     * its MOF type is of type {com.sap.tc.moin.repository.mmi.model.PrimitiveType PrimitiveType}. In
     * all other cases <code>null</code> is returned.
     * <p>
     * The returned Java type {@link java.lang.Class Class} can be one of these
     * values:
     * <ul>
     * <li>{@link java.lang.String String}.class in case of <code>String</code></li>
     * <li>{@link java.lang.Boolean Boolean}.class in case of
     * <code>Boolean</code></li>
     * <li>{@link java.lang.Integer Integer}.class in case of
     * <code>Integer</code></li>
     * <li>{@link java.lang.Long Long}.class in case of <code>Long</code></li>
     * <li>{@link java.lang.Float Float}.class in case of <code>Float</code></li>
     * <li>{@link java.lang.Double Double}.class in case of <code>Double</code></li>
     * <li><code>null</code> in all other cases</li>
     * </ul>
     * 
     * @param type for which the Java wrapper class should be returned
     * @return the Java type of the MOF type or null
     * @author d024227
     */
    public Class<?> getJavaWrapperType( Connection connection, Classifier type );

    public Classifier getNonAliasType( Session session, TypedElement typedElement );

    public Classifier getNonAliasType( Session session, Classifier type );

    public Tag getTag( Session session, ModelElement tagged, String tagId );

    /**
     * Obtains the first of the values of the tag with the specified name on the
     * model element passed, and converts the value to a string.
     * 
     * @param tagged the model element on which to look for a tag named
     * <tt>tagId</tt>
     * @param tagId The name of the tag to look for on model element
     * <tt>tagged</tt>
     * @return The first value of the tag converted to a string if the tag was
     * found and has at least one value; <tt>null</tt> otherwise.
     * @author d024227
     */
    public String getTagValue( Session session, ModelElement tagged, String tagId );

    /**
     * Returns the association ends of the association specified.
     * 
     * @param a the association of which to determine the ends
     * @return the list of {@link AssociationEnd}s that constitute the ends of
     * the association <tt>a</tt>
     */
    public List<AssociationEnd> getAssociationEnds( Session session, Association a );

    public byte getAssociationEndNumber( Session session, AssociationEnd ae );

    /**
     * For an association finds out if any of its end is composite, and if so,
     * which one. Being composite means that the
     * {@link AssociationEnd#getAggregation()} is
     * {@link com.sap.tc.moin.repository.mmi.model.AggregationKindEnum#COMPOSITE}).
     * 
     * @param a The association for which to find a composite end
     * @return the index of the association end (0 means the first end) which is
     * composite, or -1 if none of the association's ends are composite
     */
    public byte getCompositeEnd( Session session, Association a );

    /**
     * For an association finds out if any of its end is composed, and if so,
     * which one. Being composed means that the
     * {@link AssociationEnd#getAggregation()} of the other end is
     * {@link com.sap.tc.moin.repository.mmi.model.AggregationKindEnum#COMPOSITE}).
     * 
     * @param a The association for which to find a composed end
     * @return the index of the association end (0 means the first end) which is
     * composed, or -1 if none of the association's ends are composed
     */
    public byte getComponentEnd( Session session, Association a );

    public byte getStoredEnd( SpiSession session, Association association );

    public byte getStoredEnd( SpiSession session, RefObject attributeOrAssociation );

    /**
     * Returns a byte which contains the stored end numbers of the specified
     * attribute.
     * 
     * @param attribute the attribute of which to retrieve the stored end number
     * @return a byte which contains the stored ends number of the specified
     * attribute.
     */
    public byte getStoredEnd( Attribute attribute );

    /**
     * Searches for the {@link ModelElement} with the given qualified name,
     * recursively descending from the given outermost package.
     * 
     * @param qualifiedNameToSearch The qualified name for which the
     * {@link RefPackage package extent} should be found.
     * @param outermostPackage The {@link RefPackage} from which to start the
     * search.
     * @return The {@link ModelElement} matching the given qualified name.
     * @author d027299
     */
    public ModelElement findElementByQualifiedName( Session session, List<String> qualifiedNameToSearch, RefPackage outermostPackage );

    /**
     * Searches for the {@link ModelElement} with the given qualified name,
     * recursively descending from the given outermost package.
     * 
     * @param qualifiedNameToSearch The qualified name for which the
     * {@link RefPackage package extent} should be found.
     * @param outermostPackage The {@link RefPackage} from which to start the
     * search.
     * @return The {@link ModelElement} matching the given qualified name.
     * @author d027299
     */
    public ModelElement findElementByQualifiedName( Session session, String[] qualifiedNameToSearch, RefPackage outermostPackage );

    public RefPackage findRefPackageByQualifiedName( List<String> qualifiedNameToSearch, RefPackage outermostPackage );

    /**
     * Tries to match the given qualified name (<tt>qname</tt>) using
     * {@link RefPackage#refPackage(String)} and calling itself recursively. If
     * the package cannot be found, the
     * {@link com.sap.tc.moin.repository.mmi.reflect.InvalidNameException} is caught and
     * <tt>null</tt> is returned.
     * 
     * @param qname
     * @param index
     * @param extent
     * @return the {@link RefPackage} matching the given qualified name or
     * <tt>null</tt> if it cannot be found
     */
    public RefBaseObject matchQNameInExtent( String[] qname, int index, RefBaseObject extent );

    /**
     * Uses a breadth first search to find the {@link ModelElement} belonging to
     * the given qualifed name. First tries to match the first part of the
     * qualified name to any nested or clusteredly imported package. If a match
     * is found it tries to match the hole qname against the Namespace structure
     * by calling {@link #matchQNameInNamespace(List, int, Namespace)}. If the
     * {@link ModelElement} wasn't found it searches all direct children of the
     * clusterdly imported packages of the current package. And only for those
     * because according to the MOF constraint C-49 nested packages may not have
     * any further imports and because the first part of the qualified name
     * didn't match the nested package it is sure that it isn't located in the
     * nested packages.
     * 
     * @param qnameToSearch The qualified name for which the
     * {@link ModelElement} should be found
     * @param mofPackage The {@link MofPackage} from which to start the search
     * @return The {@link ModelElement} matching the given qualified name
     * @author Thomas Hettel
     */
    public ModelElement findElementByQualifiedName( Connection connection, List<String> qnameToSearch, MofPackage mofPackage );

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
    public Collection<GeneralizableElement> getSubTypes( Connection connection, GeneralizableElement generalizableElement );

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
    public Collection<GeneralizableElement> getAllSubtypes( Connection connection, GeneralizableElement aGeneralizableElement );

    public List<ModelElement> getAllContent( Connection connection, ModelElement modelElement );

    /**
     * This method computes all contained model elements of the model element
     * passed taking all its super types into account, and returns them keyed by
     * their name.
     */
    public Map<String, ModelElement> getAllContentMap( Session session, Namespace namespace );

    /**
     * This method computes the collection of enumeration labels of the
     * enumeration type passed and of all super enumeration types
     */
    public Collection<String> getAllEnumerationLabels( EnumerationType enumerationType );

    public Classifier getType( Session session, TypedElement typedElement );

    /**
     * This methods returns the structure field for the field name of give
     * structure type. If the field does not exist, null is returned.
     */
    /**
     * Returns the {@link com.sap.tc.moin.repository.mmi.model.StructureField Field} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.StructureType StructureType} with the given name
     * or null if the structure does not have any field with that name.
     * 
     * @param structureType the StructureType of which the field is returned
     * @param fieldName the name of the field that is returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.StructureField Field} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.StructureType StructureType} should be returned
     * too
     */
    public StructureField getStructureFieldByName( Connection connection, StructureType structureType, String fieldName, boolean includeSupertypes );

    /**
     * Returns the substitute name of a model element or null if the model
     * element does not have one.
     * 
     * @param connection a connection to MOIN
     * @param modelElement the model element for which the substitute name
     * should be returned
     * @return the substitute name or null if the model element does not have
     * one
     */
    public String getSubstituteName( Connection connection, ModelElement modelElement );

    public String getJavaReturnInitialValueByType( String type );

    public Object getJavaReturnInitialWrapperValueFromClassifier( Connection connection, Classifier classifier );

    public boolean isOrdered( SpiSession session, RefObject metaObject, byte endNumber );

    public Map<String, RefEnum> getEnumerationConstantsMap( Session session, EnumerationType enumerationType );

    public ModelElement lookupElementExtended( Connection connection, GeneralizableElement namespace, String nameToSearch ) throws NameNotFoundException;

    public void initializeCaches( );

    public boolean isQueryNeededForNavigation( Attribute attribute );

    public boolean isQueryNeededForNavigation( SpiSession session, Association association, int fromEnd );

    public int getAttributeToEndNumber( Attribute attribute );

    public List<GeneralizableElement> getAllSupertypes( Session session, GeneralizableElement aGeneralizableElement );

    public boolean isEndStored( SpiSession session, int endNumber, RefObject metaObject );

    public boolean isEndStored( SpiSession session, int endNumber, Association association );

    public boolean isEndStored( SpiSession session, AssociationEnd ae );

    public Collection<PRI> getAffectedPartitionsForRefDelete( Session session, RefObject rootElement );

    public List<RefObject> getCompositeChildrenStable( Session session, RefObject rootElement, boolean recursively );

    public Collection<RefObject> getCompositeChildren( Session session, RefObject rootElement, boolean recursively );

    public RefPackage getRefPackageForMofPackage( Session session, MofPackage mofPackage );

    @Deprecated
    public RefAssociation getRefAssociationForAssociation( Connection connection, Association association );

    public RefAssociation getRefAssociationForAssociation( Session session, Association association );

    public RefClass getRefClassForMofClass( Session session, MofClass mofClass );

    public <T extends RefStruct> T cloneStruct( Connection connection, T structToClone, StructureFieldContainer<? extends T> containerForFieldsToSet );

    public AssociationEnd getCompositeAssociationEnd( Connection connection, Association a );

    public Collection<Association> getCompositeAssociations( Connection connection, MofClass parentClass, MofClass childClass );

    public List<RefEnum> getEnumerationConstants( Session session, EnumerationType enumerationType );

    public boolean isFirstAssociationEnd( Connection connection, Association a, AssociationEnd ae );

    public byte getOrderedEnd( SpiSession session, RefObject metaObject );

    public byte getOrderedEnd( SpiSession session, Association association );

    Set<Attribute> getObjectValuedAttributesOfType( Session session, MofClass mofClass, boolean includeSupertypes );

    public String getJMIPackageIdentifierQualified( Connection connection, Namespace namespace );

    public String getJMIIdentifier( Connection connection, ModelElement modelElement );

    public String getJmiInterfaceName( Connection connection, Namespace namespace );

    public String getJmiPackageName( Connection connection, MofPackage mofPackage );

    public String correctName( String name, boolean forConstant );

    public List<StructureField> getStructureFields( SpiSession session, StructureType type, boolean includeSuperTypes );

    public boolean isTranslatableText( SpiSession session, StructureType type );

    public boolean isTranslatableTextFragment( SpiSession session, StructureType type );

    public boolean hasTranslatableTextFragmentAttribute( SpiSession session, MofClass mofClass );

    public List<Attribute> getTranslatableTextFragmentAttributes( SpiSession session, MofClass mofClass );

    public String getQualifiedName( SpiSession session, ModelElement modelElement );

    public MultiplicityType createMultiplicityType( Connection connection, int lower, int upper, boolean isOrdered, boolean isUnique );

    public List<Attribute> getAllStructureTypedAttributes( Session session, MofClass mofClass );

    public List<Attribute> getAllObjectValuedAttributes( Session session, MofClass mofClass );

    public boolean checkTypeCompatibility( Connection connection, Classifier classifier, Object objectToCheck );
}