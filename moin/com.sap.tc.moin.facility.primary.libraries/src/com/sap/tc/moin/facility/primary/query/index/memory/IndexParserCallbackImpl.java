package com.sap.tc.moin.facility.primary.query.index.memory;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cps.ParserCallbackImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.core.cps.SpiParserCallbackInternal;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

public class IndexParserCallbackImpl extends ParserCallbackImpl implements SpiParserCallbackInternal {

    private static final SpiStructuredValue STRUCTURED_VALUE = new IndexStructuredValueImpl( );

    protected final IndexImpl index;

    boolean isMetamodelPartition; // accessed by IndexElementImpl

    private boolean isErrorHandled = false;

    public IndexParserCallbackImpl( SpiPartitionSerializationManager serializationManager, IndexImpl index, SpiMetamodelService metamodelService, PRI partitionToIndex, boolean indexMode ) {

        super( serializationManager, metamodelService, partitionToIndex, indexMode );
        this.index = index;
        this.isMetamodelPartition = partitionToIndex.isMetaModelPartition( );
    }

    @Override
    protected final SpiSession getSession( ) {

        return null;
    }

    public SpiElement addElement( SpiClass mofClass, String mofId ) {

        addElementCommon( mofClass, mofId );
        if ( mofId.length( ) != Utilities.MOFID_LENGTH ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_STRING_OF_LENGTH, "mofId", Utilities.MOFID_LENGTH ); //$NON-NLS-1$
        }
        if ( getMetamodelService( ).isClassForNonExistingMofClass( mofClass ) ) {
            SpiElement element = getMetamodelService( ).createElementForNonExistingMofClass( mofClass, mofId );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                SpiClass clazz = element.get___Type( );
                getSerializationManager( ).elementOfNonExistingMofClassAdded( getPri( ), clazz.get___MetamodelContainer( ), clazz.get___QualifiedName( ), clazz.get___MofId( ), mofId );
            }
            return element;
        }
        IndexParserElementImpl ipe = this.createParserElement( mofClass, mofId );
        IndexModelElement me = index.addElement( ipe );
        ipe.set___IndexModelElement( me );
        if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
            getSerializationManager( ).elementAdded( getPri( ), ipe );
        }
        return ipe;
    }

    protected IndexParserElementImpl createParserElement( SpiClass mofClass, String mofId ) {

        return new IndexParserElementImpl( this, mofClass, mofId );
    }

    public void addLink( SpiAssociation association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        if ( !addLinkCommon( association, elementAtFirstEnd, elementAtSecondEnd ) ) {
            index.addIntraPartitionLink( elementAtFirstEnd.get___MofId( ), elementAtSecondEnd.get___MofId( ), association.get___MofId( ), association.get___StoredEndNumber( ) );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                getSerializationManager( ).linkAdded( getPri( ), association, elementAtFirstEnd, elementAtSecondEnd );
            }
        }
    }

    public void addLink( SpiAssociation association, SpiElement elementAtFirstEnd, LRI lriOfElementAtSecondEnd ) {

        if ( !addLinkCommon( association, elementAtFirstEnd, lriOfElementAtSecondEnd ) ) {
            index.addCrossPartitionLink( elementAtFirstEnd.get___MofId( ), lriOfElementAtSecondEnd, association.get___MofId( ) );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                getSerializationManager( ).linkAdded( getPri( ), association, elementAtFirstEnd, lriOfElementAtSecondEnd );
            }
        }
    }

    public void addLink( SpiAssociation association, LRI lriOfElementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        if ( !addLinkCommon( association, lriOfElementAtFirstEnd, elementAtSecondEnd ) ) {
            index.addCrossPartitionLink( lriOfElementAtFirstEnd, elementAtSecondEnd.get___MofId( ), association.get___MofId( ) );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                getSerializationManager( ).linkAdded( getPri( ), association, lriOfElementAtFirstEnd, elementAtSecondEnd );
            }
        }
    }

    public SpiStructuredValue createStructuredValue( ) {

        return STRUCTURED_VALUE;
    }

    public SpiStructuredValue createStructuredValue( SpiStructureType structureType ) {

        return STRUCTURED_VALUE;
    }

    @Override
    protected void handleResolvedAttributeValue( SpiElement element, Attribute attribute, String attributeName, Classifier attributeType, Object originalValue, Object resolvedValue ) {

        if ( attributeType instanceof MofClass ) {
            if ( originalValue instanceof LRI ) {
                // Currently, the only attributes for which we need to take action are cross-partition object-valued attributes.
                index.addCrossPartitionLink( element.get___MofId( ), (LRI) originalValue, attribute.refMofId( ) );
            }
        }
        if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
            getSerializationManager( ).attributeValueAdded( getPri( ), element, attribute, originalValue );
        }
    }

    @Override
    protected final void handleUnknownAttribute( SpiElement element, String attributeName, Object attributeValue ) {

        boolean errorHandled = false;
        Set<SpiParserErrorHandler> potentialErrorHandlers = getPotentialErrorHandlers( element.get___Type( ) );
        for ( SpiParserErrorHandler errorHandler : potentialErrorHandlers ) {
            try {
                if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                    Map<String, String> args = new LinkedHashMap<String, String>( );
                    args.put( "PRI", getPri( ).toString( ) ); //$NON-NLS-1$
                    args.put( "Element", element.toString( ) ); //$NON-NLS-1$
                    args.put( "AttributeName", attributeName ); //$NON-NLS-1$
                    args.put( "AttributeValue", String.valueOf( attributeValue ) ); //$NON-NLS-1$
                    getSerializationManager( ).errorHandlerStart( errorHandler, "handleUnknownAttribute", args ); //$NON-NLS-1$
                }
                errorHandled = errorHandler.handleUnknownAttribute( this, element, attributeName, attributeValue );
                if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                    getSerializationManager( ).errorHandlerEnd( errorHandler, errorHandled, "handleUnknownAttribute" ); //$NON-NLS-1$
                }
                if ( errorHandled ) {
                    break;
                }
            } catch ( Throwable t ) {
                // TODO log this!
                continue;
            }
        }
    }

    @Override
    protected final void handleIllegalAttributeValue( SpiElement element, Attribute attribute, String attributeName, Object attributeValue ) {

        SpiParserErrorHandler errorHandler = this.getErrorHandler( element.get___Type( ).get___MetamodelContainer( ), null );
        if ( errorHandler != null ) {
            try {
                if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                    Map<String, String> args = new LinkedHashMap<String, String>( );
                    args.put( "PRI", getPri( ).toString( ) ); //$NON-NLS-1$
                    args.put( "Element", element.toString( ) ); //$NON-NLS-1$
                    args.put( "AttributeName", attributeName ); //$NON-NLS-1$
                    args.put( "AttributeValue", String.valueOf( attributeValue ) ); //$NON-NLS-1$
                    getSerializationManager( ).errorHandlerStart( errorHandler, "handleIllegalAttributeValue", args ); //$NON-NLS-1$
                }
                boolean errorHandled = errorHandler.handleIllegalAttributeValue( this, element, attributeName, attributeValue );
                if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                    getSerializationManager( ).errorHandlerEnd( errorHandler, errorHandled, "handleIllegalAttributeValue" ); //$NON-NLS-1$
                }
            } catch ( Throwable t ) {
                // TODO log this!
                return;
            }
        }
    }

    private SpiParserErrorHandler getErrorHandler( String metamodelContainerName, String modelVersion ) {

        this.isErrorHandled = true;
        return getSerializationManager( ).getParserErrorHandler( metamodelContainerName, modelVersion );
    }

    public boolean isErrorHandled( ) {

        return this.isErrorHandled;
    }

    public void markHadErrorsDuringLoad( ) {

        this.isErrorHandled = true;
    }

    public void markHadUnhandledErrorsDuringLoad( ) {

        this.isErrorHandled = true;
    }

    public void notifyOnUsedMetamodel( String metamodelContainer, String version ) {

        // information currently not used
    }
}