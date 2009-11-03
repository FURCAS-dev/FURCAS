package com.sap.tc.moin.repository.cps;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.SpiValueTypeEnum;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiAttributeInfo;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

public abstract class ParserCallbackImpl implements SpiParserCallback {

    private final SpiPartitionSerializationManager serializationManager;

    private final SpiMetamodelService metamodelService;

    private final PRI pri;

    private final boolean indexMode;

    public ParserCallbackImpl( SpiPartitionSerializationManager serializationManager, SpiMetamodelService metamodelService, PRI pri, boolean indexMode ) {

        this.serializationManager = serializationManager;
        this.metamodelService = metamodelService;
        this.pri = pri;
        this.indexMode = indexMode;
    }

    protected final SpiPartitionSerializationManager getSerializationManager( ) {

        return serializationManager;
    }

    public final PRI getPri( ) {

        return pri;
    }

    protected final SpiMetamodelService getMetamodelService( ) {

        return metamodelService;
    }

    protected final boolean getIndexMode( ) {

        return indexMode;
    }

    public final void callOtherParser( String serializationId, InputStream input, SpiParserCallback callback, long fileSize ) throws IOException {

        this.serializationManager.parse( serializationId, input, callback, fileSize );
    }

    public final LRI createLri( String facilityId, String dataAreaName, String mofId ) {

        return getMetamodelService( ).createLri( facilityId, dataAreaName, mofId );
    }

    public final String calculateElementMofId( SpiClass mofClass, String... logicalKey ) {

        return getMetamodelService( ).calculateElementMofId( mofClass, logicalKey );
    }

    public final SpiAttributeInfo createAttributeInfo( String name, String mofId, SpiValueTypeEnum type, boolean isMultiValued, boolean isObjectValued ) {

        return getMetamodelService( ).createAttributeInfo( name, mofId, type, isMultiValued, isObjectValued );
    }

    public final SpiClass getClassForNonExistingMofClass( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName, List<SpiAttributeInfo> attributeInfos ) {

        return metamodelService.getClassForNonExistingMofClass( typeMofId, metamodelContainer, dotSeparatedQualifiedName, attributeInfos );
    }

    public final SpiClass getClass( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        return metamodelService.getClass( serializationManager, this, getPri( ), indexMode, typeMofId, metamodelContainer, dotSeparatedQualifiedName );
    }

    public final SpiAssociation getAssociation( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        return metamodelService.getAssociation( serializationManager, this, getPri( ), indexMode, typeMofId, metamodelContainer, dotSeparatedQualifiedName );
    }

    public final SpiStructureType getStructureType( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        return metamodelService.getStructureType( serializationManager, this, getPri( ), indexMode, typeMofId, metamodelContainer, dotSeparatedQualifiedName );
    }

    public final SpiType getType( String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName ) {

        return metamodelService.getType( serializationManager, this, getPri( ), indexMode, typeMofId, metamodelContainer, dotSeparatedQualifiedName );
    }

    public final SpiElement addElement( ClassDescriptor<?, ?> mofClass, String mofId ) {

        String qName = createQualifiedName( mofClass.getQualifiedName( ) );
        SpiType type = this.getType( mofClass.getMofId( ), mofClass.getModelContainerName( ), qName );
        if ( type == null ) {
            throw new IllegalArgumentException( MessageFormat.format( "The type {0} does not exist.", new Object[] { qName } ) ); //$NON-NLS-1$
        }
        if ( type instanceof SpiClass ) {
            return this.addElement( (SpiClass) type, mofId );
        }
        throw new IllegalArgumentException( MessageFormat.format( "The type parameter is not a class ({0})", new Object[] { qName } ) ); //$NON-NLS-1$
    }

    public final void addLink( AssociationDescriptor<?> association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        String qName = createQualifiedName( association.getQualifiedName( ) );
        SpiType type = this.getType( association.getMofId( ), association.getModelContainerName( ), qName );
        if ( type == null ) {
            throw new IllegalArgumentException( MessageFormat.format( "The type {0} does not exist.", new Object[] { qName } ) ); //$NON-NLS-1$
        }
        if ( type instanceof SpiAssociation ) {
            this.addLink( (SpiAssociation) type, elementAtFirstEnd, elementAtSecondEnd );
        } else {
            throw new IllegalArgumentException( "The type parameter is not an association." ); //$NON-NLS-1$
        }
    }

    public final void addLink( AssociationDescriptor<?> association, SpiElement elementAtFirstEnd, LRI lriOfElementAtSecondEnd ) {

        String qName = createQualifiedName( association.getQualifiedName( ) );
        SpiType type = this.getType( association.getMofId( ), association.getModelContainerName( ), qName );
        if ( type == null ) {
            throw new IllegalArgumentException( MessageFormat.format( "The type {0} does not exist.", new Object[] { qName } ) ); //$NON-NLS-1$
        }
        if ( type instanceof SpiAssociation ) {
            this.addLink( (SpiAssociation) type, elementAtFirstEnd, lriOfElementAtSecondEnd );
        } else {
            throw new IllegalArgumentException( "The type parameter is not an association." ); //$NON-NLS-1$
        }
    }

    public final void addLink( AssociationDescriptor<?> association, LRI lriOfElementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        String qName = createQualifiedName( association.getQualifiedName( ) );
        SpiType type = this.getType( association.getMofId( ), association.getModelContainerName( ), qName );
        if ( type == null ) {
            throw new IllegalArgumentException( MessageFormat.format( "The type {0} does not exist.", new Object[] { qName } ) ); //$NON-NLS-1$
        }
        if ( type instanceof SpiAssociation ) {
            this.addLink( (SpiAssociation) type, lriOfElementAtFirstEnd, elementAtSecondEnd );
        } else {
            throw new IllegalArgumentException( "The type parameter is not an association." ); //$NON-NLS-1$
        }
    }

    public final String calculateElementMofId( ClassDescriptor<?, ?> mofClassDescritor, String... logicalKey ) {

        String qName = createQualifiedName( mofClassDescritor.getQualifiedName( ) );
        SpiType type = this.getType( mofClassDescritor.getMofId( ), mofClassDescritor.getModelContainerName( ), qName );
        if ( type == null ) {
            throw new IllegalArgumentException( MessageFormat.format( "The type {0} does not exist.", new Object[] { qName } ) ); //$NON-NLS-1$
        }
        if ( type instanceof SpiClass ) {
            return this.calculateElementMofId( (SpiClass) type, logicalKey );
        }
        throw new IllegalArgumentException( "The type parameter is not a class." ); //$NON-NLS-1$
    }

    protected final void addElementCommon( SpiClass mofClass, String mofId ) {

        assertParameterNotNull( "mofClass", mofClass ); //$NON-NLS-1$
        assertParameterNotNull( "mofId", mofId ); //$NON-NLS-1$
    }

    protected final boolean addLinkCommon( SpiAssociation association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        assertParameterNotNull( "association", association ); //$NON-NLS-1$
        assertParameterNotNull( "elementAtFirstEnd", elementAtFirstEnd ); //$NON-NLS-1$
        assertParameterNotNull( "elementAtSecondEnd", elementAtSecondEnd ); //$NON-NLS-1$
        boolean unsupported = false;
        if ( getMetamodelService( ).isClassForNonExistingMofClass( elementAtFirstEnd.get___Type( ) ) || getMetamodelService( ).isClassForNonExistingMofClass( elementAtSecondEnd.get___Type( ) ) ) {
            unsupported = true;
        }
        return unsupported;
    }

    protected final boolean addLinkCommon( SpiAssociation association, SpiElement elementAtFirstEnd, LRI lriOfElementAtSecondEnd ) {

        assertParameterNotNull( "association", association ); //$NON-NLS-1$
        assertParameterNotNull( "elementAtFirstEnd", elementAtFirstEnd ); //$NON-NLS-1$
        assertParameterNotNull( "lriOfElementAtSecondEnd", lriOfElementAtSecondEnd ); //$NON-NLS-1$
        boolean unsupported = false;
        if ( getMetamodelService( ).isClassForNonExistingMofClass( elementAtFirstEnd.get___Type( ) ) ) {
            unsupported = true;
        }
        return unsupported;
    }

    protected final boolean addLinkCommon( SpiAssociation association, LRI lriOfElementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        assertParameterNotNull( "association", association ); //$NON-NLS-1$
        assertParameterNotNull( "lriOfElementAtFirstEnd", lriOfElementAtFirstEnd ); //$NON-NLS-1$
        assertParameterNotNull( "elementAtSecondEnd", elementAtSecondEnd ); //$NON-NLS-1$
        boolean unsupported = false;
        if ( getMetamodelService( ).isClassForNonExistingMofClass( elementAtSecondEnd.get___Type( ) ) ) {
            unsupported = true;
        }
        return unsupported;
    }

    protected abstract void handleUnknownAttribute( SpiElement element, String attributeName, Object attributeValue );

    protected abstract void handleIllegalAttributeValue( SpiElement element, Attribute attribute, String attributeName, Object attributeValue );

    protected abstract SpiSession getSession( );

    protected abstract void handleResolvedAttributeValue( SpiElement element, Attribute attribute, String attributeName, Classifier attributeType, Object originalValue, Object resolvedValue );

    public void addAttributeValue( SpiElement element, String attributeName, Object value ) {

        Attribute attribute = getMetamodelService( ).getAttribute( element.get___Type( ), attributeName );
        if ( attribute == null ) {
            handleUnknownAttribute( element, attributeName, value );
        } else {
            boolean handled = getMetamodelService( ).handleAttributeValueOfNonExistingMofClass( getSerializationManager( ), this, element, attributeName, value );
            if ( !handled ) {
                Classifier attributeType = getMetamodelService( ).getType( attribute );
                Object resolvedValue = getMetamodelService( ).resolveValueForType( getSession( ), getPri( ), attributeType, value, getIndexMode( ) );
                if ( resolvedValue == SpiMetamodelService.ILLEGAL_ATTRIBUTE_VALUE ) {
                    handleIllegalAttributeValue( element, attribute, attributeName, value );
                } else {
                    handleResolvedAttributeValue( element, attribute, attributeName, attributeType, value, resolvedValue );
                }
            }
        }
    }

    protected final Set<SpiParserErrorHandler> getPotentialErrorHandlers( SpiClass clazz ) {

        Set<SpiParserErrorHandler> result = null;
        SpiParserErrorHandler ownErrorhandler = getSerializationManager( ).getParserErrorHandler( clazz.get___MetamodelContainer( ), null );
        if ( ownErrorhandler != null ) {
            result = new LinkedHashSet<SpiParserErrorHandler>( );
            result.add( ownErrorhandler );
        }
        for ( SpiType supertype : clazz.get___AllSuperTypes( ) ) {
            SpiParserErrorHandler errorHandlerOfSupertype = getSerializationManager( ).getParserErrorHandler( supertype.get___MetamodelContainer( ), null );
            if ( errorHandlerOfSupertype != null ) {
                if ( result == null ) {
                    result = new LinkedHashSet<SpiParserErrorHandler>( );
                }
                result.add( errorHandlerOfSupertype );
            }
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptySet( );
    }
    
    private final void assertParameterNotNull( String parameterName, Object parameterValue ) {

        if ( parameterValue == null ) {
            throw new MoinIllegalNullArgumentException( parameterName );
        }
    }

    private static String createQualifiedName( String[] parts ) {

        return StringUtils.combine( parts, '.', '\\' );
    }
}