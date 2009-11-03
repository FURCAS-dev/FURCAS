package com.sap.tc.moin.repository.core.cps.parser;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiInstantiator;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.cps.ParserCallbackImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLinkManager;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.cps.SpiParserCallbackInternal;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.errorhandler.SpiParserErrorHandler;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiPartitionParseException;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

public final class CoreParserCallbackImpl extends ParserCallbackImpl implements SpiParserCallbackInternal {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CPS, CoreParserCallbackImpl.class );

    private final CoreSession session;

    private final CoreModelPartition partitionToLoad;

    private final JmiInstantiator jmiInstantiator;

    private final SpiLinkManager linkManager;

    public CoreParserCallbackImpl( SpiPartitionSerializationManager serializationManager, CoreSession session, CoreModelPartition partition ) {

        super( serializationManager, partition.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getCore( ).getMetamodelService( ), partition.getPri( ), false /* indexMode */);
        this.session = session; // can be 'null' !
        this.partitionToLoad = partition;
        this.jmiInstantiator = partition.getWorkspace( ).getJmiInstantiator( );
        this.linkManager = partition.getWorkspace( ).getMemoryLinkManager( );
    }

    @Override
    protected final SpiSession getSession( ) {

        return session;
    }

    public CoreModelPartition getPartitionToLoad( ) {

        return this.partitionToLoad;
    }

    public SpiElement addElement( SpiClass mofClass, String mofId ) {

        addElementCommon( mofClass, mofId );
        // TODO would actually have to check if the MOF ID will go into the index; but currently this is easiest checked by comparing the facility ID to "PF"
        if ( getPartitionToLoad().getPri().getDataAreaDescriptor().getFacilityId().equals("PF") &&
        	mofId.length( ) != Utilities.MOFID_LENGTH ) {
            throw new MoinIllegalArgumentException( CoreCpsParserMessages.MOFIDPARAMETERMUSTBEASTRINGOFLENGTH, Utilities.MOFID_LENGTH );
        }
        if ( getMetamodelService( ).isClassForNonExistingMofClass( mofClass ) ) {
            SpiElement element = getMetamodelService( ).createElementForNonExistingMofClass( mofClass, mofId );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                SpiClass clazz = element.get___Type( );
                getSerializationManager( ).elementOfNonExistingMofClassAdded( getPri( ), clazz.get___MetamodelContainer( ), clazz.get___QualifiedName( ), clazz.get___MofId( ), mofId );
            }
            return element;
        }
        RefObject newElement = null;
        try {
            RefClass refClass = (RefClass) mofClass;
            MofClass mc = refClass.refMetaObject( );
            RefPackage immediatePackage = refClass.refImmediatePackage( );
            // We can pass in "null" as first argument (Connection) because this is only used 
            // in case of element "creation", but not on "loading".
            newElement = jmiInstantiator.createRefObject( null /* connection */, mofId, immediatePackage, mc, refClass, partitionToLoad );
        } catch ( Exception ex ) {
            throw new SpiPartitionParseException( ex, "addElement failed" ); //$NON-NLS-1$
        }
        SpiElement spiElement = new CoreElementImpl( this, mofClass, newElement );
        if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
            getSerializationManager( ).elementAdded( getPri( ), spiElement );
        }
        return spiElement;
    }

    public void addLink( SpiAssociation association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        if ( !addLinkCommon( association, elementAtFirstEnd, elementAtSecondEnd ) ) {
            Association assoc = ( (RefAssociation) association ).refMetaObject( );
            SpiPartitionable firstElement = ( (CoreElementImpl) elementAtFirstEnd ).getRefObject( );
            SpiPartitionable secondElement = ( (CoreElementImpl) elementAtSecondEnd ).getRefObject( );
            if ( session != null ) {
                if ( !getMetamodelService( ).linkEndCompatible( session, assoc, (RefObject) firstElement, 0 ) ) {
                    if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                	SpiJmiHelper jmiHelper = getMetamodelService().getJmiHelper();
                        LOGGER.trace(MoinSeverity.ERROR,
                        	"Element {0} of type {1} is not compatible with end {2} of association {3} which has type {4}",
                        	new Object[] { secondElement.toString(),
					((MofClass) ((RefObject) firstElement).refMetaObject()).getName(),
					jmiHelper.getAssociationEnds(getSession(), assoc).get(0).getName(), assoc.getName(),
					jmiHelper.getAssociationEnds(getSession(), assoc).get(0).getType().getName() }); //$NON-NLS-1$
                    }
                    // throw new MoinIllegalArgumentException( CoreCpsParserMessages.ELEMENTATFIRSTENDISNOTCOMPATIBLE );
                } else if ( !getMetamodelService( ).linkEndCompatible( session, assoc, (RefObject) secondElement, 1 ) ) {
                    if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                	SpiJmiHelper jmiHelper = getMetamodelService().getJmiHelper();
                        LOGGER.trace(MoinSeverity.ERROR,
                        	"Element {0} of type {1} is not compatible with end {2} of association {3} which has type {4}",
                        	new Object[] { secondElement.toString(),
					((MofClass) ((RefObject) secondElement).refMetaObject()).getName(),
					jmiHelper.getAssociationEnds(getSession(), assoc).get(1).getName(), assoc.getName(),
					jmiHelper.getAssociationEnds(getSession(), assoc).get(1).getType().getName() }); //$NON-NLS-1$
                    }
                    // throw new MoinIllegalArgumentException( CoreCpsParserMessages.ELEMENTATSECONDENDISNOTCOMPATIBLE );
                } else {
                    loadLink(association, elementAtFirstEnd, elementAtSecondEnd, assoc, firstElement, secondElement);
                }
            } else {
                loadLink(association, elementAtFirstEnd, elementAtSecondEnd, assoc, firstElement, secondElement);
            }
        }
    }

    private void loadLink(SpiAssociation association, SpiElement elementAtFirstEnd, SpiElement elementAtSecondEnd,
	    Association assoc, SpiPartitionable firstElement, SpiPartitionable secondElement) {
	linkManager.loadLink( session, firstElement, secondElement, assoc );
	if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
	    getSerializationManager( ).linkAdded( getPri( ), association, elementAtFirstEnd, elementAtSecondEnd );
	}
    }

    public void addLink( SpiAssociation association, SpiElement elementAtFirstEnd, LRI lriOfElementAtSecondEnd ) {

        if ( !addLinkCommon( association, elementAtFirstEnd, lriOfElementAtSecondEnd ) ) {
            Association assoc = ( (RefAssociation) association ).refMetaObject( );
            SpiPartitionable firstElement = ( (CoreElementImpl) elementAtFirstEnd ).getRefObject( );
            if ( session != null ) {
                if ( !getMetamodelService( ).linkEndCompatible( session, assoc, (RefObject) firstElement, 0 ) ) {
                    throw new MoinIllegalArgumentException( CoreCpsParserMessages.ELEMENTATFIRSTENDISNOTCOMPATIBLE );
                }
            }
            linkManager.loadLink( session, firstElement, lriOfElementAtSecondEnd, assoc );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                getSerializationManager( ).linkAdded( getPri( ), association, elementAtFirstEnd, lriOfElementAtSecondEnd );
            }
        }
    }

    public void addLink( SpiAssociation association, LRI lriOfElementAtFirstEnd, SpiElement elementAtSecondEnd ) {

        if ( !addLinkCommon( association, lriOfElementAtFirstEnd, elementAtSecondEnd ) ) {
            Association assoc = ( (RefAssociation) association ).refMetaObject( );
            SpiPartitionable secondElement = ( (CoreElementImpl) elementAtSecondEnd ).getRefObject( );
            if ( session != null ) {
                if ( !getMetamodelService( ).linkEndCompatible( session, assoc, (RefObject) secondElement, 1 ) ) {
                    throw new MoinIllegalArgumentException( CoreCpsParserMessages.ELEMENTATSECONDENDISNOTCOMPATIBLE );
                }
            }
            linkManager.loadLink( session, lriOfElementAtFirstEnd, secondElement, assoc );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                getSerializationManager( ).linkAdded( getPri( ), association, lriOfElementAtFirstEnd, elementAtSecondEnd );
            }
        }
    }

    public SpiStructuredValue createStructuredValue( ) {

        return new CoreStructuredValueImpl( );
    }

    public SpiStructuredValue createStructuredValue( SpiStructureType structureType ) {

        return new CoreStructuredValueImpl( structureType );
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
                if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                    LOGGER.trace( t, MoinSeverity.ERROR, "Error handler {0} threw exception in handleUnknownAttribute( ) while parsing {1}", new Object[] { errorHandler.toString( ), getPri( ).toString( ) } ); //$NON-NLS-1$
                }
            }
        }
        partitionToLoad.markHadErrorsDuringLoad( );
        if ( !errorHandled ) {
            partitionToLoad.markHadUnhandledErrorsDuringLoad( );
            // Minimal own handling: log the incident and continue 
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                LOGGER.trace( MoinSeverity.WARNING, "Encountered unknown attribute, skipping it (PRI: " + getPri( ) + ", model element: " + getTypeString( element.get___Type( ) ) + ", attribute: " + attributeName + ", value: " + attributeValue ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
        }
    }

    @Override
    protected final void handleIllegalAttributeValue( SpiElement element, Attribute attribute, String attributeName, Object attributeValue ) {

        boolean errorHandled = false;
        SpiParserErrorHandler errorHandler = getSerializationManager( ).getParserErrorHandler( ( (Partitionable) attribute ).get___Partition( ).getPri( ).getContainerName( ), null );
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
                errorHandled = errorHandler.handleIllegalAttributeValue( this, element, attributeName, attributeValue );
                if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                    getSerializationManager( ).errorHandlerEnd( errorHandler, errorHandled, "handleIllegalAttributeValue" ); //$NON-NLS-1$
                }
            } catch ( Throwable t ) {
                if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                    LOGGER.trace( t, MoinSeverity.ERROR, "Error handler {0} threw exception in handleIllegalAttributeValue( ) while parsing {1}", new Object[] { errorHandler.toString( ), getPri( ).toString( ) } ); //$NON-NLS-1$
                }
            }
        }
        partitionToLoad.markHadErrorsDuringLoad( );
        if ( !errorHandled ) {
            partitionToLoad.markHadUnhandledErrorsDuringLoad( );
            // minimal own error handling: log the incident and continue 
            if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                LOGGER.trace( MoinSeverity.ERROR, "Encountered illegal attribute value, skipping it (PRI: " + getPri( ) + ", model element: " + getTypeString( element.get___Type( ) ) + ", attribute: " + attributeName + ", value: " + attributeValue ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
        }
    }

    @Override
    protected void handleResolvedAttributeValue( SpiElement element, Attribute attribute, String attributeName, Classifier attributeType, Object originalValue, Object resolvedValue ) {

        try {
            RefFeaturedExtension refObj = ( (CoreElementImpl) element ).getRefObject( );
            refObj.addOrSet___Value( session, attribute.getName( ), resolvedValue );
            if ( JMX_ENABLED && getSerializationManager( ).isJmxNotificationsEnabled( ) ) {
                getSerializationManager( ).attributeValueAdded( getPri( ), element, attribute, originalValue );
            }
        } catch ( Exception ex ) {
            handleIllegalAttributeValue( element, attribute, attributeName, originalValue );
        }
    }

    private String getTypeString( SpiType type ) {

        return "[MOF id: " + type.get___MofId( ) + ", metamodel: " + type.get___MetamodelContainer( ) + ", qualified name: " + type.get___QualifiedName( ) + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
    }

    public void markHadErrorsDuringLoad( ) {

        this.partitionToLoad.markHadErrorsDuringLoad( );
    }

    public void markHadUnhandledErrorsDuringLoad( ) {

        this.partitionToLoad.markHadUnhandledErrorsDuringLoad( );
    }

    public void notifyOnUsedMetamodel( String metamodelContainer, String version ) {

        if ( metamodelContainer != null ) {
            CoreMoin moin = partitionToLoad.getWorkspace( ).getWorkspaceSet( ).getMoin( );
            SpiDataArea metamodelDataArea = moin.getMetamodelDataArea( );
            CRI cri = metamodelDataArea.getFacility( ).getRIFactory( ).createCri( metamodelDataArea.getName( ), metamodelContainer );
            if ( moin.getMetaModelRegistry( ).isDeployed( cri ) ) {
                this.partitionToLoad.addUsedMetamodel( cri, version );
            }
        }
    }
}