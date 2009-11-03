package com.sap.tc.moin.repository.spi.core.cps;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.parser.SpiAttributeInfo;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * This interface is used by the custom parser / serializer framework, by both
 * MOIN core and index. It provides methods for retrieving metamodel information
 * and for calculating MOF ids.
 */
public interface SpiMetamodelService {

    /**
     * Represents an illegal attribute value, i.e. a value not conforming to an
     * attribute's type.
     */
    public static final Object ILLEGAL_ATTRIBUTE_VALUE = new Object( );

    public SpiClass getClass( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI partition, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    public SpiAssociation getAssociation( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI partition, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    public SpiStructureType getStructureType( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI partition, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    public SpiType getType( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, PRI partition, boolean indexMode, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    public Attribute getAttribute( SpiClass mofClass, String attributeName );

    /**
     * Returns the type of the specified {@link Attribute attribute}.
     * 
     * @param attribute the attribute whose type is requested
     * @return the type of the specified attribute
     */
    public Classifier getType( Attribute attribute );

    /**
     * Returns the type MOF-Id of a structured value. Argument must be an
     * instance of RefStructImpl.
     * 
     * @param structuredValue
     * @return
     */
    public String getTypeMofId( SpiStructuredValueBase structuredValue );

    /**
     * Calculates a MOF id using the specified parameters (for details see
     * {@link RefClassCalculatedMofId#calculateMofId(Class, String[])}).
     */
    public String calculateElementMofId( SpiClass mofClass, String[] logicalKey );

    public Object resolveValueForType( SpiSession session, PRI parsedPartition, Classifier type, Object value, boolean indexMode );

    public LRI createLri( String facilityId, String dataAreaName, String mofId );

    public SpiAttributeInfo createAttributeInfo( String name, String mofId, SpiValueTypeEnum type, boolean isMultiValued, boolean isObjectValued );

    public SpiClass getClassForNonExistingMofClass( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName, List<SpiAttributeInfo> attributeInfos );

    public boolean isClassForNonExistingMofClass( SpiClass mofClass );

    public SpiElement createElementForNonExistingMofClass( SpiClass mofClass, String mofId );

    public SpiType getSpiType( Classifier classifier );

    public List<StructureField> getStructureFields( SpiStructuredValueBase structuredValue );

    public SpiValueTypeEnum getValueType( Classifier type );

    public boolean linkEndCompatible( Session session, Association association, RefObject element, int endNumber );

    public boolean handleAttributeValueOfNonExistingMofClass( SpiPartitionSerializationManager serializationManager, SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue );

    public SpiJmiHelper getJmiHelper( );
}