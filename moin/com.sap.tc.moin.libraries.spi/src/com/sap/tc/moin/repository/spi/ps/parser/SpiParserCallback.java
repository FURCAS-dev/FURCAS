package com.sap.tc.moin.repository.spi.ps.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;

/**
 * An instance of {@link SpiParserCallback} is passed to the
 * {@link SpiCustomParser#parse(java.io.InputStream, SpiParserCallback, long)
 * parse} method of a custom parser, and is used by the parser during the
 * parsing process to report findings such as model elements and their
 * attributes, as well as links between model elements. Implementations could
 * for example instantiate model elements and links in memory, or populate an
 * index with the parsed content.
 */
public interface SpiParserCallback {

    /**
     * Returns the {@link PRI} of the currently parsed partition.
     * 
     * @return the {@link PRI} of the currently parsed partition
     */
    public PRI getPri( );

    /**
     * Returns a {@link LRI} created with the specified parameters.
     * 
     * @param facilityId the id of the {@link Facility facility} (e.g. "PF")
     * @param dataAreaName the name of the {@link DataArea data area} (e.g.
     * "LocalDevelopment[local]")
     * @param mofId the MOF id of the model element
     * @return a LRI created with the specified parameters
     */
    public LRI createLri( String facilityId, String dataAreaName, String mofId );

    /**
     * Computes and returns a calculated MOF id for an instance of the given
     * {@link SpiClass class}, using the specified locality and logical key.
     * 
     * @param mofClass the {@link SpiClass} representing the {@link MofClass}
     * used for MOF id computation
     * @param logicalKey see
     * {@link RefClassCalculatedMofId#calculateMofId(String[])} for details on
     * this parameter
     * @return a calculated MOF id
     * @throws IllegalArgumentException if the type parameter does not represent
     * a {@link MofClass}
     */
    public String calculateElementMofId( SpiClass mofClass, String... logicalKey );

    /**
     * Computes and returns a calculated MOF id for an instance of the given
     * {@link ClassDescriptor class}, using the specified locality and logical
     * key.
     * 
     * @param mofClass the {@link ClassDescriptor} representing the
     * {@link MofClass} used for MOF id computation
     * @param logicalKey see
     * {@link RefClassCalculatedMofId#calculateMofId(String[])} for details on
     * this parameter
     * @return a calculated MOF id
     * @throws IllegalArgumentException if the type parameter does not represent
     * a {@link MofClass}
     */
    public String calculateElementMofId( ClassDescriptor<?, ?> mofClassDescritor, String... logicalKey );

    /**
     * Returns a new instance of {@link SpiStructuredValue}, representing the
     * value of a structure-typed attribute. The methods offered by
     * {@link SpiStructuredValue} should then be used to populate the fields.
     * 
     * @return a new instance of {@link SpiStructuredValue}
     */
    public SpiStructuredValue createStructuredValue( );

    /**
     * Returns a new instance of the specified {@link SpiStructureType},
     * representing the value of a structure-typed attribute. The methods
     * offered by {@link SpiStructuredValue} should then be used to populate the
     * fields.
     * 
     * @param structureType the {@link SpiStructureType} representing the MOF
     * {@link StructureType} of the StructuredValue to create
     * @return a new instance of {@link SpiStructuredValue}
     * @throws IllegalArgumentException if the specified type is
     * <code>null</code>
     */
    public SpiStructuredValue createStructuredValue( SpiStructureType structureType );

    /**
     * Returns an instance of {@link SpiClass} representing the {@link MofClass}
     * from the metamodel given by the metamodel container name and identified
     * by the given MOF id and dot-separated qualified name. If the class cannot
     * be resolved, <code>null</code> is returned. Note that from the three
     * parameters, only the <code>typeMofId</code> parameter is optional.
     * 
     * @param typeMofId the MOF id of the requested class; can be
     * <code>null</code>
     * @param metamodelContainer the name of the metamodel container of the
     * requested class
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * requested class
     * @return an instance of {@link SpiClass} representing a {@link MofClass},
     * or <code>null</code>
     * @throws IllegalArgumentException if :
     * <ul>
     * <li>the specified MOF id is not <code>null</code> but does not denote a
     * valid MOF id, or</li>
     * <li>one of the parameters <code>metamodelContainer
     * </code> or
     * <code>dotSeparatedQualifiedName</code> is <code>null</code></li>
     * </ul>
     */
    public SpiClass getClass( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    /**
     * Returns an instance of {@link SpiAssociation} representing the
     * {@link Association} from the metamodel given by the metamodel container
     * name and identified by the given MOF id and dot-separated qualified name.
     * If the association cannot be resolved, <code>null</code> is returned.
     * Note that from the three parameters, only the <code>typeMofId</code>
     * parameter is optional.
     * 
     * @param typeMofId the MOF id of the requested association; can be
     * <code>null</code>
     * @param metamodelContainer the name of the metamodel container of the
     * requested association
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * requested association
     * @return an instance of {@link SpiAssociation} representing a
     * {@link Association}, or <code>null</code>
     * @throws IllegalArgumentException if :
     * <ul>
     * <li>the specified MOF id is not <code>null</code> but does not denote a
     * valid MOF id, or</li>
     * <li>one of the parameters <code>metamodelContainer
     * </code> or
     * <code>dotSeparatedQualifiedName</code> is <code>null</code></li>
     * </ul>
     */
    public SpiAssociation getAssociation( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    /**
     * Returns an instance of {@link SpiStructureType} representing the
     * {@link StructureType} from the metamodel given by the metamodel container
     * name and identified by the given MOF id and dot-separated qualified name.
     * If the StructureType cannot be resolved, <code>null</code> is returned.
     * Note that from the three parameters, only the <code>typeMofId</code>
     * parameter is optional.
     * 
     * @param typeMofId the MOF id of the requested StructureType; can be
     * <code>null</code>
     * @param metamodelContainer the name of the metamodel container of the
     * requested StructureType
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * requested StructureType
     * @return an instance of {@link SpiStructureType} representing a
     * {@link StructureType}, or <code>null</code>
     * @throws IllegalArgumentException if :
     * <ul>
     * <li>the specified MOF id is not <code>null</code> but does not denote a
     * valid MOF id, or</li>
     * <li>one of the parameters <code>metamodelContainer
     * </code> or
     * <code>dotSeparatedQualifiedName</code> is <code>null</code></li>
     * </ul>
     */
    public SpiStructureType getStructureType( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    /**
     * Returns an instance of {@link SpiType} representing either the
     * {@link MofClass} or the {@link Association} from the metamodel given by
     * the metamodel container name and identified by the given MOF id and
     * dot-separated qualified name. If the metamodel element cannot be
     * resolved, <code>null</code> is returned. Note that from the three
     * parameters, only the <code>typeMofId</code> parameter is optional.
     * <p>
     * This method is provided for the situation that a parser knows the MOF id
     * / qualified name of the type, but does <b>not</b> know whether the type
     * behind it actually is a class or an association. If on the other hand the
     * caller exactly knows that he is requesting a class or association, he
     * should call the methods {@link #getClass(String, String, String)} or
     * {@link #getAssociation(String, String, String)} instead.
     * 
     * @param typeMofId the MOF id of the requested metamodel element; can be
     * <code>null</code>
     * @param metamodelContainer the name of the metamodel container of the
     * requested metamodel element
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * requested metamodel element
     * @return an instance of either {@link SpiClass} or {@link SpiAssociation},
     * or <code>null</code>
     * @throws IllegalArgumentException if :
     * <ul>
     * <li>the specified MOF id is not <code>null</code> but does not denote a
     * valid MOF id, or</li> <li>one of the parameters <code>metamodelContainer
     * </code> or <code>dotSeparatedQualifiedName</code> is <code>null</code>
     * </li>
     * </ul>
     */
    public SpiType getType( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    /**
     * Creates and returns a new instance of {@link SpiElement}, representing a
     * {@link RefObject}. The {@link SpiType type} and the MOF id of the new
     * element must passed as parameters. The methods offered by
     * {@link SpiElement} should then be used to populate the element's
     * attributes. The new model element is automatically assigned to the parsed
     * partition directly after creation.
     * 
     * @param mofClass the {@link SpiClass} representing the {@link MofClass} of
     * the element to create
     * @throws IllegalArgumentException if the specified type is
     * <code>null</code>, or the specified String does not represent a valid MOF
     * id
     */
    public SpiElement addElement( SpiClass mofClass, String mofId );

    /**
     * Creates and returns a new instance of {@link SpiElement}, representing a
     * {@link RefObject}. The {@link ClassDescriptor} and the MOF id of the new
     * element must passed as parameters. The methods offered by
     * {@link SpiElement} should then be used to populate the element's
     * attributes. The new model element is automatically assigned to the parsed
     * partition directly after creation.
     * 
     * @param mofClass the {@link ClassDescriptor} representing the
     * {@link MofClass} of the element to create
     * @throws IllegalArgumentException if the specified type is
     * <code>null</code>, or the specified String does not represent a valid MOF
     * id
     */
    public SpiElement addElement( ClassDescriptor<?, ?> mofClass, String mofId );

    /**
     * Establishes a link of the specified {@link SpiAssociation association}
     * between the two given {@link SpiElement elements}. This method must be
     * used if both elements belong to the partition being parsed, i.e. an
     * inner-partition link should be established.
     * 
     * @param association the {@link SpiAssociation association} for which a new
     * link should be established
     * @param elementAtFirstEnd the {@link SpiElement element} at the first end
     * (as defined in the metamodel) of the association
     * @param elementAtSecondEnd the {@link SpiElement element} at the second
     * end (as defined in the metamodel) of the association
     * @throws IllegalArgumentException if one of the specified parameters is
     * <code>null</code>
     */
    public void addLink( SpiAssociation association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd );

    /**
     * Establishes a link of the specified {@link AssociationDescriptor} between
     * the two given {@link SpiElement elements}. This method must be used if
     * both elements belong to the partition being parsed, i.e. an
     * inner-partition link should be established.
     * 
     * @param association the {@link AssociationDescriptor} for which a new link
     * should be established
     * @param elementAtFirstEnd the {@link SpiElement element} at the first end
     * (as defined in the metamodel) of the association
     * @param elementAtSecondEnd the {@link SpiElement element} at the second
     * end (as defined in the metamodel) of the association
     * @throws IllegalArgumentException if one of the specified parameters is
     * <code>null</code>
     */
    public void addLink( AssociationDescriptor<?> association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd );

    /**
     * Establishes a link of the specified {@link SpiAssociation association}
     * between the two given elements, one given as an instance of
     * {@link SpiElement} and one given by its MOF id. This method must be used
     * if the element at the first end belongs to the partition being parsed,
     * and the element at the second end is external, i.e. a cross-partition
     * link should be established.
     * 
     * @param association the {@link SpiAssociation association} for which a new
     * link should be established
     * @param elementAtFirstEnd the {@link SpiElement element} at the first end
     * (as defined in the metamodel) of the association; belongs to the
     * partition being parsed
     * @param lriOfElementAtSecondEnd the LRI of the element at the second end
     * (as defined in the metamodel) of the association; belongs to some other
     * model partition
     * @throws IllegalArgumentException if one of the specified parameters is
     * <code>null</code>
     */
    public void addLink( SpiAssociation association, SpiElement elementAtFirstEnd, LRI lriOfElementAtSecondEnd );

    /**
     * Establishes a link of the specified {@link AssociationDescriptor} between
     * the two given elements, one given as an instance of {@link SpiElement}
     * and one given by its MOF id. This method must be used if the element at
     * the first end belongs to the partition being parsed, and the element at
     * the second end is external, i.e. a cross-partition link should be
     * established.
     * 
     * @param association the {@link AssociationDescriptor} for which a new link
     * should be established
     * @param elementAtFirstEnd the {@link SpiElement element} at the first end
     * (as defined in the metamodel) of the association; belongs to the
     * partition being parsed
     * @param lriOfElementAtSecondEnd the LRI of the element at the second end
     * (as defined in the metamodel) of the association; belongs to some other
     * model partition
     * @throws IllegalArgumentException if one of the specified parameters is
     * <code>null</code>
     */
    public void addLink( AssociationDescriptor<?> association, SpiElement elementAtFirstEnd, LRI lriOfElementAtSecondEnd );

    /**
     * Establishes a link of the specified {@link SpiAssociation association}
     * between the two given elements, one given as an instance of
     * {@link SpiElement} and one given by its MOF id. This method must be used
     * if the element at the second end belongs to the partition being parsed,
     * and the element at the first end is external, i.e. a cross-partition link
     * should be established.
     * 
     * @param association the {@link SpiAssociation association} for which a new
     * link should be established
     * @param lriOfElementAtFirstEnd the LRI of the element at the first end (as
     * defined in the metamodel) of the association; belongs to some other model
     * partition
     * @param elementAtSecondEnd the {@link SpiElement element} at the second
     * end (as defined in the metamodel) of the association; belongs to the
     * partition being parsed
     * @throws IllegalArgumentException if one of the specified parameters is
     * <code>null</code>
     */
    public void addLink( SpiAssociation association, LRI lriOfElementAtFirstEnd, SpiElement elementAtSecondEnd );

    /**
     * Establishes a link of the specified {@link AssociationDescriptor} between
     * the two given elements, one given as an instance of {@link SpiElement}
     * and one given by its MOF id. This method must be used if the element at
     * the second end belongs to the partition being parsed, and the element at
     * the first end is external, i.e. a cross-partition link should be
     * established.
     * 
     * @param association the {@link AssociationDescriptor} for which a new link
     * should be established
     * @param lriOfElementAtFirstEnd the LRI of the element at the first end (as
     * defined in the metamodel) of the association; belongs to some other model
     * partition
     * @param elementAtSecondEnd the {@link SpiElement element} at the second
     * end (as defined in the metamodel) of the association; belongs to the
     * partition being parsed
     * @throws IllegalArgumentException if one of the specified parameters is
     * <code>null</code>
     */
    public void addLink( AssociationDescriptor<?> association, LRI lriOfElementAtFirstEnd, SpiElement elementAtSecondEnd );

    /**
     * Creates and returns an instance of {@link SpiAttributeInfo}, describing
     * an {@link Attribute} of a {@link MofClass}. These instances are required
     * in error handler coding to mitigate the deletion of a MofClass from a
     * metamodel (see
     * {@link #getClassForNonExistingMofClass(String, String, String, List)}).
     * 
     * @param name the attribute's name
     * @param mofId the attribute's MOF id
     * @param type the attribute's type
     * @param isMultiValued whether the attribute is multi-valued
     * @param isObjectValued whether the attribute is object-valued
     * @return an instance of SpiAttributeInfo, describing an attribute of a
     * MofClass
     */
    public SpiAttributeInfo createAttributeInfo( String name, String mofId, SpiValueTypeEnum type, boolean isMultiValued, boolean isObjectValued );

    /**
     * Returns a "virtual" class representing a {@link MofClass} which does not
     * exist in the metamodel (e.g. it once existed but has now been deleted).
     * This method can be used in migration scenarios, and is intended to be
     * called by {@link SpiParserErrorHandler error handlers} in their
     * {@link SpiParserErrorHandler#handleUnknownType(SpiParserCallback, String, String, String)}
     * method when the type for a non-existent {@link MofClass} is requested by
     * the {@link SpiCustomParser parser}. Returning such a special type allows
     * the parser to transparently create "virtual" elements of this type that
     * serve as data containers and store the parsed attribute values, although
     * under the hood no real model element is actually instantiated. Thus, they
     * allow for an on-the-fly migration of legacy instances of the the
     * non-existent MofClass.
     * 
     * @param typeMofId the MOF id of the non-existent MofClass
     * @param metamodelContainer the metamodel container name of the
     * non-existent MofClass
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * non-existent MofClass
     * @param attributeInfos a list of {@link SpiAttributeInfo} instances
     * describing all attributes of the non-existent MofClass, including those
     * from supertypes
     * @return a special {@link SpiClass type} representing a {@link MofClass}
     * which does not exist in the metamodel
     */
    public SpiClass getClassForNonExistingMofClass( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName, List<SpiAttributeInfo> attributeInfos );

    /**
     * Delegates to another parser identified by the serialization id. The
     * serialization id is provided in the registration file for a custom parser
     * / serializer.
     * <p>
     * The serialization id for the MOIN built-in parser is
     * {@link SpiCustomParserSerializerFactory#DEFAULT_SERIALIZATION}.
     * 
     * @param serializationId
     * @param input
     * @param callback
     * @param fileSize
     * @throws IOException
     */
    public void callOtherParser( String serializationId, InputStream input, SpiParserCallback callback, long fileSize ) throws IOException;

    /**
     * This method should be called by a parser implementor to notify MOIN about
     * each metamodel that is used in the partition being parsed. A metamodel is
     * considered as used if at least one model element, link or RefStruct
     * instance is contained in the partition, whose meta object belongs to the
     * metamodel in question. Optionally, a String specifying the metamodel
     * version can be provided.
     * <p>
     * Note that providing this information is not mandatory, and many
     * persistence formats do not have a notion of a version.
     * <p>
     * The information about the used metamodels can later be retrieved via
     * {@link ModelPartition#getUsedMetamodels()}.
     */
    public void notifyOnUsedMetamodel( String metamodelContainer, String version );
}