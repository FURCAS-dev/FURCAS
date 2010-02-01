package com.sap.tc.moin.repository.core.ocl.service.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.getExceptionAsString;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.openmbean.ArrayType;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OclNamedElement;

import com.sap.tc.moin.ocl.ia.instancescope.PathCache;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreOclEditorService;
import com.sap.tc.moin.repository.core.CoreOclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.core.CoreOclMofConstraintRegistry;
import com.sap.tc.moin.repository.core.CoreOclRegistryService;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.core.jmi.util.OclHelperFunctions;
import com.sap.tc.moin.repository.core.ocl.editorutils.OclEditorServiceImpl;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmx.OclRegistryServiceMBean;
import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.__impl.AttachesToInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TagInternal;
import com.sap.tc.moin.repository.mmi.reflect.ConstraintViolationException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.ConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;

/**
 * The {@link CoreOclRegistryService} implementation
 */
public class OclRegistryServiceImpl implements CoreOclRegistryService {



    private static class ConstraintStatusItemWrapper implements MoinLocalizedString {

        private final DeferredConstraintViolationStatusItem myItem;

        public ConstraintStatusItemWrapper( DeferredConstraintViolationStatusItem item ) {

            this.myItem = item;
        }

        public String getLocalizedMessage( Locale locale ) {

            return this.myItem.getConstraintViolationMessage( locale );
        }

        public String format( Object... args ) {

            return this.myItem.getConstraintViolationMessage( );
        }
    }

    protected OclMetaModelConstraintRegistryImpl myMetamodelRegistry;

    protected OclFreestyleRegistryImpl myFreestyleRegistry;

    protected OclMofConstraintRegistryImpl myMofConstraintRegistry;

    protected OclEditorServiceImpl myOclEditorService;
    
    private PathCache myInstanceScopeImpactAnalysisPathCache;

    final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclRegistryServiceImpl.class );

    private final static Set<OclRegistrationCategory> EMPTY_CAT = new HashSet<OclRegistrationCategory>( );

    private final static Set<String> EMPTY_STRINGCAT = new HashSet<String>( );

    /**
     * The {@link ObjectName} identifying this OclRegistryService instance in
     * JMX.
     */
    private ObjectName objectName;

    /**
     * Whether the OCL trace is currently enabled or not.
     */
    volatile boolean jmxNotificationsEnabled = false;

    /**
     * The MBean instance that gets registered in the MBeanServer.
     */
    JmxAdapter jmxAdapter;

    protected final CoreSession session;

    /**
     * Constructor
     * 
     * @param actSession session
     */
    public OclRegistryServiceImpl( CoreSession actSession ) {

        this.session = actSession;
    }

    public OclFreestyleRegistry getFreestyleRegistry( CoreConnection connection ) {

        if ( this.myFreestyleRegistry == null ) {
            this.myFreestyleRegistry = new OclFreestyleRegistryImpl( this, connection );
        }
        return this.myFreestyleRegistry;
    }

    public PathCache getInstanceScopeImpactAnalysisPathCache() {
	if (myInstanceScopeImpactAnalysisPathCache == null) {
	    myInstanceScopeImpactAnalysisPathCache = new PathCache();
	}
        return myInstanceScopeImpactAnalysisPathCache;
    }

    public CoreOclMetamodelConstraintRegistry getMetamodelConstraintRegistry( CoreConnection connection ) {

        if ( this.myMetamodelRegistry == null ) {
            this.myMetamodelRegistry = new OclMetaModelConstraintRegistryImpl( this, connection.getSession( ) );
        }
        return this.myMetamodelRegistry;
    }

    public CoreOclMofConstraintRegistry getCoreOclMofConstraintRegistry( CoreConnection connection ) throws OclManagerException {

        return getMofConstraintRegistry( connection );
    }

    public CoreOclMofConstraintRegistry getMofConstraintRegistry( CoreConnection connection ) throws OclManagerException {

        if ( this.myMofConstraintRegistry == null ) {
            this.myMofConstraintRegistry = new OclMofConstraintRegistryImpl( this );
        }
        return this.myMofConstraintRegistry;
    }

    public boolean analyzeCollectedEvents( CoreConnection connection, String category ) throws OclManagerException {

        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            analyzeCollectedEventsStart( category );
            long timestamp = System.nanoTime( );
            boolean evaluated = ( (OclMetaModelConstraintRegistryImpl) this.getMetamodelConstraintRegistry( connection ) ).analyzeCollectedEvents( connection, category );
            evaluated = evaluated | ( (OclFreestyleRegistryImpl) this.getFreestyleRegistry( connection ) ).evaluateCollectedEvents( category );
            long duration = ( System.nanoTime( ) - timestamp ) / 1000000;
            analyzeCollectedEventsEnd( duration, evaluated );
            return evaluated;
        }
        boolean evaluated = ( (OclMetaModelConstraintRegistryImpl) this.getMetamodelConstraintRegistry( connection ) ).analyzeCollectedEvents( connection, category );
        evaluated = evaluated | ( (OclFreestyleRegistryImpl) this.getFreestyleRegistry( connection ) ).evaluateCollectedEvents( category );
        return evaluated;
    }

    public boolean analyzeModelPartitions( CoreConnection connection, String category, Set<PRI> partitions ) throws OclManagerException {

        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            analyzeModelPartitionsStart( category );
            long timestamp = System.nanoTime( );
            boolean evaluated = ( (OclMetaModelConstraintRegistryImpl) this.getMetamodelConstraintRegistry( connection ) ).triggerCategoryEvaluation( connection, category, partitions );
            evaluated = evaluated | ( (OclFreestyleRegistryImpl) this.getFreestyleRegistry( connection ) ).evaluatePartitions( category, partitions );
            long duration = ( System.nanoTime( ) - timestamp ) / 1000000;
            analyzeModelPartitionsEnd( partitions, duration, evaluated );
            return evaluated;
        }
        boolean evaluated = ( (OclMetaModelConstraintRegistryImpl) this.getMetamodelConstraintRegistry( connection ) ).triggerCategoryEvaluation( connection, category, partitions );
        evaluated = evaluated | ( (OclFreestyleRegistryImpl) this.getFreestyleRegistry( connection ) ).evaluatePartitions( category, partitions );
        return evaluated;
    }

    public void resetEvents( CoreConnection connection, String category ) throws OclManagerException {

        ( (OclMetaModelConstraintRegistryImpl) this.getMetamodelConstraintRegistry( connection ) ).resetEvents( category );
        ( (OclFreestyleRegistryImpl) this.getFreestyleRegistry( connection ) ).resetEvents( category );
        eventsReset( category );
    }

    /**
     * Just for testing
     * 
     * @param connection connection
     * @return the filter
     * @throws OclManagerException internal
     */
    // TODO just for testing
    public EventFilter getMofConstraintEventFilter( CoreConnection connection ) throws OclManagerException {

        return ( (OclMofConstraintRegistryImpl) this.getMofConstraintRegistry( connection ) ).getEventFilter( connection, OclRegistrationCategory.deferred );
    }

    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, RefObject targetObject ) throws OclManagerException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTVERIFYCONSTRAINTS, targetObject.refMofId( ) );
        }
        DeferredConstraintViolationStatus status = null;
        try {
            if ( targetObject instanceof ModelElement ) {
                status = ( (OclMofConstraintRegistryImpl) this.getMofConstraintRegistry( connection ) ).verifyConstraints( connection, (ModelElementInternal) targetObject, EMPTY_CAT );
            } else {
                status = ( (OclMetaModelConstraintRegistryImpl) getMetamodelConstraintRegistry( connection ) ).verifyConstraints( connection, targetObject, EMPTY_STRINGCAT );
            }
        } catch ( RuntimeException re ) {
            OclManagerException e = new OclManagerException( OclServiceExceptions.EXCEPTIONWHILEVERIFYCONSTRAINTS );
            e.initCause( re );
            throw e;
        } finally {
            if ( status != null && LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.COMPLETEVERIFYCONSTRAINTS, Integer.valueOf( status.getErrors( ).size( ) ), Integer.valueOf( status.getWarnings( ).size( ) ) );
            }
        }
        return status;
    }

    /**
     * Used in the refVerifyConstraints method
     * 
     * @param targetObject object
     * @return the collection of {@link JmiException}s
     */
    public Collection<JmiException> refVerifyConstraints( CoreConnection conn, RefObject targetObject, boolean deepVerify ) {

        Collection<JmiException> result = new ArrayList<JmiException>( );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTREFVERIFYCONSTRAINTS, targetObject.refMofId( ) );
        }
        try {
            DeferredConstraintViolationStatus status = verifyConstraints( conn, targetObject );
            for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                ConstraintStatusItemWrapper wrapper = new ConstraintStatusItemWrapper( item );
                JmiException jmiException = new ConstraintViolationException( targetObject, null, wrapper, item.getConstraintRegistration( ).getName( ) );
                result.add( jmiException );
            }

            if ( deepVerify ) {
                Collection<RefObject> children = conn.getCoreJmiHelper( ).getCompositeChildren( conn.getSession( ), targetObject, true );
                for ( RefObject child : children ) {
                    status = verifyConstraints( conn, child );
                    for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                        ConstraintStatusItemWrapper wrapper = new ConstraintStatusItemWrapper( item );
                        JmiException jmiException = new ConstraintViolationException( child, null, wrapper, item.getConstraintRegistration( ).getName( ) );
                        result.add( jmiException );
                    }
                }
            }
        } catch ( OclManagerException oe ) {
            LOGGER.trace( oe, MoinSeverity.ERROR );
            result.add( new JmiException( targetObject, null, oe ) );
        } finally {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.COMPLETEREFVERIFYCONSTRAINTS, Integer.valueOf( result.size( ) ) );
            }
        }

        return result;
    }

    public Map<ProcessReport, MRI> parseOclConstraints( CoreConnection connection, Set<CoreModelPartition> partitions ) throws OclManagerException {

        OclServiceImpl srv = OclServiceImpl.getInstance( );
        Map<ProcessReport, MRI> result = new HashMap<ProcessReport, MRI>( );

        List<OclConstraint> constraints = new ArrayList<OclConstraint>( );
        List<Tag> bodyExpressionTags = new ArrayList<Tag>( );

        Map<String, List<ModelElement>> modelElementsByName = new HashMap<String, List<ModelElement>>( );
        Map<String, ModelElement> modelElementsByOclQualifiedName = new HashMap<String, ModelElement>( );

        StringBuilder qname = new StringBuilder( );

        Set<CoreModelPartition> filteredPartitions = new HashSet<CoreModelPartition>( );
        for ( CoreModelPartition partition : partitions ) {
            PRI pri = partition.getPri( );
            if ( !pri.isMetaModelPartition( ) && !pri.isVolatilePartition( ) ) {
                CoreModelPartition privateCopyOfPartition = connection.getSession( ).createPrivateCopyOfPartition( pri );
                filteredPartitions.add( privateCopyOfPartition );
            } else {
                filteredPartitions.add( partition );
            }
        }

        for ( CoreModelPartition partition : filteredPartitions ) {

            this.clearGeneratedOclPackage( connection, partition );

            for ( Partitionable p : partition.getElements( ) ) {
                if ( p instanceof ModelElement ) {
                    ModelElement me = (ModelElement) p;
                    String name = me.getName( );
                    qname.setLength( 0 );
                    List<String> qnamelist = MoinMetamodelCode.getQualifiedName( connection, me, (RefObjectImpl) me );
                    for ( Iterator<String> it = qnamelist.iterator( ); it.hasNext( ); ) {
                        qname.append( it.next( ) );
                        if ( it.hasNext( ) ) {
                            qname.append( OclConstants.PATHSEP );
                        }
                    }
                    List<ModelElement> elements = modelElementsByName.get( name );
                    if ( elements == null ) {
                        elements = new ArrayList<ModelElement>( );
                        modelElementsByName.put( name, elements );
                    }
                    elements.add( me );
                    modelElementsByOclQualifiedName.put( qname.toString( ), me );

                }

                if ( p instanceof OclConstraint ) {
                    constraints.add( (OclConstraint) p );
                }

                if ( p instanceof Tag ) {
                    Tag tag = (Tag) p;
                    if ( tag.getTagId( ).equals( OclConstants.TAG_OPBODY ) ) {
                        bodyExpressionTags.add( tag );
                    }
                }

            }
        }

        for ( Tag tag : bodyExpressionTags ) {
            srv.parseBodyExpression( connection, tag, modelElementsByName, modelElementsByOclQualifiedName, new HashMap<Classifier, Set<Feature>>( ) );
        }

        for ( OclConstraint oc : constraints ) {
            ModelPartition partition = ( (Partitionable) oc ).get___Partition( );
            try {

                srv.parseExpressionAndAttachSyntaxTree( connection, oc, partition, modelElementsByName, modelElementsByOclQualifiedName, null );

                List<OclExpression> expressionsToDelete = new ArrayList<OclExpression>( );
                JmiList<OclExpression> oldExpressions = (JmiList<OclExpression>) ( (OclConstraintInternal) oc ).getViolationMessageExpression( connection );
                for ( int i = 0, n = oldExpressions.size( connection.getSession( ) ); i < n; i++ ) {
                    expressionsToDelete.add( oldExpressions.get( connection.getSession( ), i ) );
                }

                // get the tags and parse the violation message expressions

                AttachesToInternal attachesTo = (AttachesToInternal) connection.getAssociation( AttachesTo.ASSOCIATION_DESCRIPTOR );
                JmiList<Tag> tags = (JmiList<Tag>) attachesTo.getTag( connection, oc );
                if ( tags == null || tags.isEmpty( connection.getSession( ) ) ) {
                    continue;
                }
                String tagValue = null;
                for ( Iterator<Tag> it = tags.iterator( connection ); it.hasNext( ); ) {
                    Tag tag = it.next( );
                    if ( tag.getTagId( ).equals( OclConstants.TAG_VIOLATIONMESSAGE ) ) {
                        tagValue = ( (TagInternal) tag ).getValues( connection ).get( 0 );
                    }
                }

                if ( tagValue == null || tagValue.length( ) == 0 ) {
                    continue;
                }

                String[] expressions = StringUtils.split( tagValue, OclConstants.VIOLATIONMESSAGEEXPSPLITTER );

                for ( int i = 0; i < expressions.length; i++ ) {
                    String expression = expressions[i];

                    MofPackage constraintPackage = null;
                    RefFeatured parent = ( (RefObjectImpl) oc ).refImmediateComposite( connection.getSession( ) );
                    while ( constraintPackage == null ) {
                        if ( parent == null ) {
                            break;
                        }
                        if ( parent instanceof MofPackage ) {
                            constraintPackage = (MofPackage) parent;
                        }
                        if ( parent instanceof RefObject ) {
                            parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) );
                        } else {
                            parent = null;
                        }
                    }

                    Set<RefObject> contexts = new HashSet<RefObject>( );
                    OclHelperFunctions.addAll( this.session, (JmiList<ModelElement>) ( (OclConstraintInternal) oc ).getConstrainedElements( connection ), contexts );
                    // TODO use the real default context

                    OclExpression expr = OclServiceImpl.getInstance( ).parseViolationMessageExpression( connection, expression, contexts.iterator( ).next( ), modelElementsByName, modelElementsByOclQualifiedName, partition );
                    ( (JmiList<OclExpression>) ( (OclConstraintInternal) oc ).getViolationMessageExpression( connection ) ).add( connection, expr );

                }

                for ( OclExpression exp : expressionsToDelete ) {
                    ( (RefObjectImpl) exp ).refDelete( connection );
                }

            } catch ( ParsingException e ) {
                result.put( e.getReport( ), ( (Partitionable) oc ).get___Mri( ) );
            } catch ( OclManagerException e ) {
                ProcessReportImpl report = new ProcessReportImpl( );
                report.reportError( new ProcessErrorImpl( e ) );
                result.put( report, ( (Partitionable) oc ).get___Mri( ) );
            }
        }

        return result;

    }

    public ObjectName getObjectName( ) {

        return this.objectName;
    }

    /**
     * If JMX is enabled, this method is called and registers the MBean for this
     * OclRegistryService instance.
     * 
     * @param actSession session
     */
    public void registerMBean( CoreSession actSession ) {

        try {
            this.objectName = new ObjectName( MOIN_DOMAIN + "type=OclRegistryService,moin=" + actSession.getMoin( ).getId( ) + ",session=" + actSession.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
        this.jmxAdapter = new JmxAdapter( this, this.objectName, actSession.getMoin( ).getReferenceQueue( ) );
    }

    /**
     * Called by
     * {@link OclMofConstraintRegistryImpl#resetEvents(CoreConnection, OclRegistrationCategory...)}
     * and {@link OclMetaModelConstraintRegistryImpl#resetEvents(String)}. If
     * JMX is enabled, sends out a JMX notification with the stack trace.
     */
    void eventsReset( String... categories ) {

        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            this.jmxAdapter.eventsReset( Thread.currentThread( ).getStackTrace( ), getCategoriesString( categories ) );
        }
    }

    void analyzeCollectedEventsStart( String... categories ) {

        this.jmxAdapter.analyzeCollectedEventsStart( Thread.currentThread( ).getStackTrace( ), getCategoriesString( categories ) );
    }

    void analyzeCollectedEventsEnd( long duration, boolean evaluationPerformed ) {

        this.jmxAdapter.analyzeCollectedEventsEnd( duration, evaluationPerformed );
    }

    void analyzeModelPartitionsStart( String... categories ) {

        this.jmxAdapter.analyzeModelPartitionsStart( Thread.currentThread( ).getStackTrace( ), getCategoriesString( categories ) );
    }

    void analyzeModelPartitionsEnd( Set<PRI> partitions, long duration, boolean evaluationPerformed ) {

        this.jmxAdapter.analyzeModelPartitionsEnd( partitions, duration, evaluationPerformed );
    }

    void analyzeModelPartitionsEnd( Set<PRI> partitions, long totalTime, long evaluatorTime, int numEvaluations ) {

        this.jmxAdapter.analyzeModelPartitionsEnd( partitions, totalTime, evaluatorTime, numEvaluations );
    }

    private String getCategoriesString( String... categories ) {

        StringBuilder result = new StringBuilder( "Categories=" ); //$NON-NLS-1$
        for ( int i = 0, n = categories.length; i < n; i++ ) {
            if ( categories[i] != null ) {
                if ( result.length( ) > 11 ) {
                    result.append( ", " ); //$NON-NLS-1$
                }
                result.append( categories[i] );
            }
        }
        return result.toString( );
    }

    void constraintViolationsDetected( ConstraintViolationStatus status ) {

        this.jmxAdapter.constraintViolationsDetected( status );
    }

    @SuppressWarnings( "nls" )
    private static final class JmxAdapter extends NotificationBroadcasterSupport implements OclRegistryServiceMBean {

        private static final CompositeType compositeTypeForOclRegistration;

        private static final TabularType tabularTypeForOclRegistration;

        static {
            try {
                String[] itemNames = new String[] { "1: Name", "2: Expression", "3: Type", "4: Categories", "5: Severity", "6: Qualified Name", "7: Constrained Elements" };
                OpenType[] itemTypes = new OpenType[] { SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, new ArrayType( 1, SimpleType.STRING ), SimpleType.STRING, SimpleType.STRING, new ArrayType( 1, SimpleType.STRING ) };
                compositeTypeForOclRegistration = new CompositeType( "OclRegistrationInfo", "OclRegistrationInfo", itemNames, itemNames, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                tabularTypeForOclRegistration = new TabularType( "OclRegistrations", "OclRegistrations", compositeTypeForOclRegistration, new String[] { "1: Name" } ); //$NON-NLS-1$ //$NON-NLS-2$
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e ); // not expected to occur
            }
        }

        private final WeakReferenceWithObjectName<OclRegistryServiceImpl> registryServiceRef;

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private final ObjectName objectName;

        JmxAdapter( OclRegistryServiceImpl registryService, ObjectName actObjectName, ReferenceQueue actRefQueue ) {

            this.objectName = actObjectName;
            this.registryServiceRef = new WeakReferenceWithObjectName<OclRegistryServiceImpl>( registryService, actObjectName, actRefQueue );
            registerBroadcastingMBean( this, OclRegistryServiceMBean.class, actObjectName );
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( OclRegistryServiceMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by an OclRegistryService MBean" ) };
            return notifsInfo;
        }

        public void startNotifications( ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                registryService.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                return registryService.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                registryService.jmxNotificationsEnabled = false;
            }
        }

        public TabularData getAvailableMofConstraints( ) throws IOException {

            return computeTabularDataForConstraintRegistrations( getConstraints( true ) );
        }

        public String showSummaryOfAvailableMofConstraints( ) {

            return createSummaryOfConstraintRegistrations( true );
        }

        public TabularData getAvailableMetamodelConstraints( ) throws IOException {

            return computeTabularDataForConstraintRegistrations( getConstraints( false ) );
        }

        public String showSummaryOfAvailableMetamodelConstraints( ) {

            return createSummaryOfConstraintRegistrations( false );
        }

        private Set<OclMetaModelConstraintRegistration> getConstraints( boolean mofConstraints ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                Set<CoreConnection> connections = registryService.session.getConnections( );
                if ( !connections.isEmpty( ) ) {
                    CoreConnection conn = connections.iterator( ).next( );
                    Set<OclMetaModelConstraintRegistration> constraints = null;
                    if ( mofConstraints ) {
                        try {
                            constraints = registryService.getMofConstraintRegistry( conn ).getAvailableMofConstraints( conn );
                        } catch ( OclConstraintManagerException e ) {
                            throw new MoinLocalizedBaseRuntimeException( e );
                        } catch ( OclManagerException e ) {
                            throw new MoinLocalizedBaseRuntimeException( e );
                        }
                    } else {
                        try {
                            constraints = registryService.getMetamodelConstraintRegistry( conn ).getAvailableMetamodelConstraints( conn );
                        } catch ( OclConstraintManagerException e ) {
                            throw new MoinLocalizedBaseRuntimeException( e );
                        }
                    }
                    Set<OclMetaModelConstraintRegistration> result = new TreeSet<OclMetaModelConstraintRegistration>( new Comparator<OclMetaModelConstraintRegistration>( ) {

                        public int compare( OclMetaModelConstraintRegistration o1, OclMetaModelConstraintRegistration o2 ) {

                            String qn1 = QualifiedName.toDotSeparatedString( o1.getQualifiedName( ) );
                            String qn2 = QualifiedName.toDotSeparatedString( o2.getQualifiedName( ) );
                            return qn1.compareTo( qn2 );
                        }
                    } );
                    result.addAll( constraints );
                    return result;
                }
            }
            return Collections.emptySet( );
        }

        @SuppressWarnings( "unchecked" )
        private TabularData computeTabularDataForConstraintRegistrations( Set<OclMetaModelConstraintRegistration> constraints ) {

            TabularData result = new TabularDataSupport( tabularTypeForOclRegistration );
            for ( OclMetaModelConstraintRegistration registration : constraints ) {
                Map map = new LinkedHashMap<String, Object>( );
                map.put( "1: Name", registration.getName( ) );
                map.put( "2: Expression", registration.getOclExpression( ) );
                map.put( "3: Type", registration.getType( ).toString( ) );
                map.put( "4: Categories", registration.getCategories( ).toArray( new String[0] ) );
                map.put( "5: Severity", registration.getSeverity( ).toString( ) );
                map.put( "6: Qualified Name", QualifiedName.toDotSeparatedString( registration.getQualifiedName( ) ) );
                map.put( "7: Constrained Elements", registration.getConstrainedElements( ).toArray( new String[0] ) );
                CompositeData row;
                try {
                    row = new CompositeDataSupport( compositeTypeForOclRegistration, map );
                } catch ( OpenDataException e ) {
                    throw new RuntimeException( e );
                }
                result.put( row );
            }
            return result;
        }

        private String createSummaryOfConstraintRegistrations( boolean mofConstraints ) {

            Set<OclMetaModelConstraintRegistration> constraints = getConstraints( mofConstraints );
            StringBuilder result = new StringBuilder( "Number of constraints: " ).append( constraints.size( ) );
            if ( !constraints.isEmpty( ) ) {
                result.append( "\n\n" ); //$NON-NLS-1$
            }
            for ( OclMetaModelConstraintRegistration registration : constraints ) {
                result.append( getRegistrationString( registration ) ).append( "\n" ); //$NON-NLS-1$
            }
            return result.toString( );
        }

        private String getRegistrationString( OclRegistration registration ) {

            StringBuilder result = new StringBuilder( );
            if ( registration instanceof OclMetaModelConstraintRegistration ) {
                result.append( "Qualified Name:   " ).append( QualifiedName.toDotSeparatedString( ( (OclMetaModelConstraintRegistration) registration ).getQualifiedName( ) ) ).append( "\n" ); //$NON-NLS-2$
            }
            result.append( "Type:             " ).append( registration.getType( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
            result.append( "Categories:       " );
            Set<String> categories = registration.getCategories( );
            for ( Iterator<String> it = categories.iterator( ); it.hasNext( ); ) {
                result.append( it.next( ) );
                if ( it.hasNext( ) ) {
                    result.append( ',' );
                }
            }
            result.append( "\n" ); //$NON-NLS-1$
            result.append( "Severity:         " ).append( registration.getSeverity( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
            result.append( "Constraining:     " );
            if ( registration instanceof OclMetaModelConstraintRegistration ) {
                Set<String> constrainedElements = ( (OclMetaModelConstraintRegistration) registration ).getConstrainedElements( );
                if ( constrainedElements == null || constrainedElements.isEmpty( ) ) {
                    result.append( "n/a" ); //$NON-NLS-1$
                } else {
                    for ( Iterator<String> it = constrainedElements.iterator( ); it.hasNext( ); ) {
                        result.append( it.next( ) );
                        if ( it.hasNext( ) ) {
                            result.append( ',' );
                        }
                    }
                }
            } else {
                result.append( "n/a" ); //$NON-NLS-1$
            }
            result.append( "\n" ).append( "OCL Expression:   " ); //$NON-NLS-1$
            String expression;
            try {
                expression = registration.getOclExpression( );
                if ( expression == null || expression.length( ) == 0 ) {
                    result.append( "n/a" ); //$NON-NLS-1$
                } else {
                    result.append( StringUtils.indentString( expression, 18 ) );
                }
            } catch ( MoinUnsupportedOperationException ex ) {
                result.append( "n/a" ); //$NON-NLS-1$
            }
            return result.toString( );
        }

//        public TabularData getFreestyleEventListeners( ) {
//
//            OclRegistryServiceImpl registryService = registryServiceRef.get( );
//            if ( registryService != null ) {
//            }
//            return null;
//        }
//
//        public TabularData getFreestylePartitionListeners( ) {
//
//            OclRegistryServiceImpl registryService = registryServiceRef.get( );
//            if ( registryService != null ) {
//            }
//            return null;
//        }
//
//        public TabularData getFreestyleImmediateListeners( ) {
//
//            OclRegistryServiceImpl registryService = registryServiceRef.get( );
//            if ( registryService != null ) {
//            }
//            return null;
//        }

        void eventsReset( StackTraceElement[] stackTrace, String resetCategories ) {

            Notification notification = new Notification( OclRegistryServiceMBean.RESET_COLLECTED_EVENTS, this.objectName, this.seqNo.incrementAndGet( ), resetCategories );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        void verifyMofConstraintsStart( StackTraceElement[] stackTrace ) {

            Notification notification = new Notification( OclRegistryServiceMBean.VERIFY_MOF_CONSTRAINTS_START, this.objectName, this.seqNo.incrementAndGet( ), null );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        void verifyMofConstraintsEnd( long duration, Collection<JmiException> result ) {

            StringBuilder message = new StringBuilder( );
            if ( !result.isEmpty( ) ) {
                message.append( "Constraint Violations:\n\n" );
                for ( JmiException violation : result ) {
                    message.append( violation.getMessage( ) ).append( "\n\n" ); //$NON-NLS-1$
                }
            }
            Notification notification = new Notification( OclRegistryServiceMBean.VERIFY_MOF_CONSTRAINTS_END, this.objectName, this.seqNo.incrementAndGet( ), message.toString( ) );
            notification.setUserData( "Time=" + duration + "ms,ConstraintViolations=" + result.size( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            sendNotification( notification );
        }

        void analyzeCollectedEventsStart( StackTraceElement[] stackTrace, String categories ) {

            Notification notification = new Notification( OclRegistryServiceMBean.ANALYZE_COLLECTED_EVENTS_START, this.objectName, this.seqNo.incrementAndGet( ), categories );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        void analyzeCollectedEventsEnd( long duration, boolean evaluationPerformed ) {

            Notification notification = new Notification( OclRegistryServiceMBean.ANALYZE_COLLECTED_EVENTS_END, this.objectName, this.seqNo.incrementAndGet( ), null );
            notification.setUserData( "Time=" + duration + "ms,EvaluationPerformed=" + evaluationPerformed ); //$NON-NLS-1$ //$NON-NLS-2$
            sendNotification( notification );
        }

        void analyzeModelPartitionsStart( StackTraceElement[] stackTrace, String categories ) {

            Notification notification = new Notification( OclRegistryServiceMBean.ANALYZE_PARTITIONS_START, this.objectName, this.seqNo.incrementAndGet( ), categories );
            notification.setUserData( stackTrace );
            sendNotification( notification );
        }

        void analyzeModelPartitionsEnd( Set<PRI> partitions, long duration, boolean evaluationPerformed ) {

            StringBuilder message = new StringBuilder( "Analyzed model partition" );
            if ( partitions.size( ) == 1 ) {
                message.append( ":\n\n" ); //$NON-NLS-1$
            } else {
                message.append( "s:\n\n" ); //$NON-NLS-1$
            }
            for ( PRI pri : partitions ) {
                message.append( pri.toString( ) ).append( "\n" ); //$NON-NLS-1$
            }
            Notification notification = new Notification( OclRegistryServiceMBean.ANALYZE_PARTITIONS_END, this.objectName, this.seqNo.incrementAndGet( ), message.toString( ) );
            notification.setUserData( "Time=" + duration + "ms,EvaluationPerformed=" + evaluationPerformed ); //$NON-NLS-1$ //$NON-NLS-2$
            sendNotification( notification );
        }

        void analyzeModelPartitionsEnd( Set<PRI> partitions, long totalTime, long evaluatorTime, int numEvaluations ) {

            StringBuilder message = new StringBuilder( "Analyzed model partition" );
            if ( partitions.size( ) == 1 ) {
                message.append( ":\n\n" ); //$NON-NLS-1$
            } else {
                message.append( "s:\n\n" ); //$NON-NLS-1$
            }
            for ( PRI pri : partitions ) {
                message.append( pri.toString( ) ).append( "\n" ); //$NON-NLS-1$
            }
            Notification notification = new Notification( OclRegistryServiceMBean.ANALYZE_PARTITIONS_END, this.objectName, this.seqNo.incrementAndGet( ), message.toString( ) );
            notification.setUserData( "Time=" + totalTime + "ms,EvaluationTime=" + evaluatorTime + "ms,Evaluations=" + numEvaluations ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            sendNotification( notification );
        }

        public int getMofConstraintsCollectedEventsImmediate( ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                OclMofConstraintRegistryImpl registry = registryService.myMofConstraintRegistry;
                if ( registry != null ) {
                    return registry.collectedEventsForImmediate.size( );
                }
            }
            return -1;
        }

        public int getMofConstraintsCollectedEventsDeferred( ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                OclMofConstraintRegistryImpl registry = registryService.myMofConstraintRegistry;
                if ( registry != null ) {
                    return registry.collectedEventsForDeferred.size( );
                }
            }
            return -1;
        }

        public String showMofConstraintsCollectedEventsImmediate( ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                OclMofConstraintRegistryImpl registry = registryService.myMofConstraintRegistry;
                if ( registry != null ) {
                    Set<ModelChangeEvent> events = new LinkedHashSet<ModelChangeEvent>( registry.collectedEventsForImmediate );
                    if ( !events.isEmpty( ) ) {
                        StringBuilder result = new StringBuilder( "Collected events for immediate constraints:\n\n" );
                        for ( Iterator<ModelChangeEvent> it = events.iterator( ); it.hasNext( ); ) {
                            result.append( it.next( ).toString( ) );
                            if ( it.hasNext( ) ) {
                                result.append( "\n" ); //$NON-NLS-1$
                            }
                        }
                        return result.toString( );
                    }
                }
            }
            return null;
        }

        public String showMofConstraintsCollectedEventsDeferred( ) {

            OclRegistryServiceImpl registryService = this.registryServiceRef.get( );
            if ( registryService != null ) {
                OclMofConstraintRegistryImpl registry = registryService.myMofConstraintRegistry;
                if ( registry != null ) {
                    Set<ModelChangeEvent> events = new LinkedHashSet<ModelChangeEvent>( registry.collectedEventsForDeferred );
                    if ( !events.isEmpty( ) ) {
                        StringBuilder result = new StringBuilder( "Collected events for deferred constraints:\n\n" );
                        for ( Iterator<ModelChangeEvent> it = events.iterator( ); it.hasNext( ); ) {
                            result.append( it.next( ).toString( ) );
                            if ( it.hasNext( ) ) {
                                result.append( "\n" ); //$NON-NLS-1$
                            }
                        }
                        return result.toString( );
                    }
                }
            }
            return null;
        }

        void constraintViolationsDetected( ConstraintViolationStatus status ) {

            String message = null;
            if ( status instanceof DeferredConstraintViolationStatus ) {
                message = getDeferredConstraintViolationMessage( (DeferredConstraintViolationStatus) status );
            } else if ( status instanceof EventBasedConstraintViolationStatus ) {
                message = getEventBasedConstraintViolationMessage( (EventBasedConstraintViolationStatus) status );
            }
            Notification notification = new Notification( OclRegistryServiceMBean.CONSTRAINT_VIOLATIONS_DETECTED, this.objectName, this.seqNo.incrementAndGet( ), message );
            notification.setUserData( Thread.currentThread( ).getStackTrace( ) );
            sendNotification( notification );
        }

        private String getDeferredConstraintViolationMessage( DeferredConstraintViolationStatus status ) {

            StringBuilder message = new StringBuilder( );
            List<DeferredConstraintViolationStatusItem> errors = status.getErrors( );
            for ( Iterator<DeferredConstraintViolationStatusItem> it = errors.iterator( ); it.hasNext( ); ) {
                DeferredConstraintViolationStatusItem error = it.next( );
                message.append( "Message:          " );
                String violationMessage = error.getConstraintViolationMessage( );
                if ( violationMessage != null ) {
                    message.append( violationMessage );
                } else {
                    message.append( "n/a" ); //$NON-NLS-1$
                }
                message.append( "\n" ); //$NON-NLS-1$
                message.append( "Offending MRI:    " ).append( error.getOffendingMRI( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
                message.append( getRegistrationString( error.getConstraintRegistration( ) ) ).append( "\n" ); //$NON-NLS-1$
                if ( error.oclExceptionOccurred( ) ) {
                    String string = StringUtils.indentString( getExceptionAsString( error.getOclManagerException( ) ), 18 );
                    message.append( "OCL Exception:    " ).append( string ).append( "\n" ); //$NON-NLS-2$
                }
                if ( it.hasNext( ) ) {
                    message.append( "\n" ); //$NON-NLS-1$
                }
            }
            List<DeferredConstraintViolationStatusItem> warnings = status.getWarnings( );
            for ( Iterator<DeferredConstraintViolationStatusItem> it = warnings.iterator( ); it.hasNext( ); ) {
                DeferredConstraintViolationStatusItem warning = it.next( );
                message.append( "Message:          " );
                String violationMessage = warning.getConstraintViolationMessage( );
                if ( violationMessage != null ) {
                    message.append( violationMessage );
                } else {
                    message.append( "n/a" ); //$NON-NLS-1$
                }
                message.append( "\n" ); //$NON-NLS-1$
                message.append( "Offending MRI:    " ).append( warning.getOffendingMRI( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
                message.append( getRegistrationString( warning.getConstraintRegistration( ) ) ).append( "\n" ); //$NON-NLS-1$
                if ( warning.oclExceptionOccurred( ) ) {
                    String string = StringUtils.indentString( getExceptionAsString( warning.getOclManagerException( ) ), 18 );
                    message.append( "OCL Exception:    " ).append( string ).append( "\n" ); //$NON-NLS-2$
                }
                if ( it.hasNext( ) ) {
                    message.append( "\n" ); //$NON-NLS-1$
                }
            }
            return message.toString( );
        }

        private String getEventBasedConstraintViolationMessage( EventBasedConstraintViolationStatus status ) {

            StringBuilder message = new StringBuilder( );
            List<EventBasedConstraintViolationStatusItem> errors = status.getErrors( );
            for ( EventBasedConstraintViolationStatusItem error : errors ) {
                message.append( "Message:          " );
                String violationMessage = error.getConstraintViolationMessage( );
                if ( violationMessage != null ) {
                    message.append( violationMessage );
                } else {
                    message.append( "n/a" ); //$NON-NLS-1$
                }
                message.append( "\n" ); //$NON-NLS-1$
                message.append( "Offending Event:  " ).append( error.getOffendingChangeEvent( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
                message.append( "Offending MRI:    " ).append( error.getOffendingMRI( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
                message.append( getRegistrationString( error.getConstraintRegistration( ) ) ).append( "\n" ); //$NON-NLS-1$
                if ( error.oclExceptionOccurred( ) ) {
                    String string = StringUtils.indentString( getExceptionAsString( error.getOclManagerException( ) ), 18 );
                    message.append( "OCL Exception:    " ).append( string ).append( "\n" ); //$NON-NLS-2$
                }
                message.append( "\n" ); //$NON-NLS-1$
            }
            List<EventBasedConstraintViolationStatusItem> warnings = status.getWarnings( );
            for ( EventBasedConstraintViolationStatusItem warning : warnings ) {
                message.append( "Message:          " );
                String violationMessage = warning.getConstraintViolationMessage( );
                if ( violationMessage != null ) {
                    message.append( violationMessage );
                } else {
                    message.append( "n/a" ); //$NON-NLS-1$
                }
                message.append( "\n" ); //$NON-NLS-1$
                message.append( "Offending Event:  " ).append( warning.getOffendingChangeEvent( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
                message.append( "Offending MRI:    " ).append( warning.getOffendingMRI( ).toString( ) ).append( "\n" ); //$NON-NLS-2$
                message.append( getRegistrationString( warning.getConstraintRegistration( ) ) ).append( "\n" ); //$NON-NLS-1$
                if ( warning.oclExceptionOccurred( ) ) {
                    String string = StringUtils.indentString( getExceptionAsString( warning.getOclManagerException( ) ), 18 );
                    message.append( "OCL Exception:    " ).append( string ).append( "\n" ); //$NON-NLS-2$
                }
                message.append( "\n" ); //$NON-NLS-1$
            }
            return message.toString( );
        }
    }

    public CoreOclEditorService getOclEditorService( Connection connection ) {

        if ( this.myOclEditorService == null ) {
            this.myOclEditorService = new OclEditorServiceImpl( );
        }
        return this.myOclEditorService;
    }

    private void clearGeneratedOclPackage( CoreConnection connection, ModelPartition partition ) throws OclManagerException {

        JmiCreator creator = new JmiCreator( connection, true, partition );
        MofPackageInternal mp = (MofPackageInternal) creator.getOrCreatePackageForGeneratedObjects( false );
        if ( mp == null ) {
            return;
        }

        // cleanup the parent-less OclNamedElements directly contained in the partition without package container

        Set<OclNamedElement> deleteables = new HashSet<OclNamedElement>( );

        for ( Partitionable p : partition.getElements( ) ) {
            if ( p instanceof OclNamedElement ) {
                OclNamedElement ne = (OclNamedElement) p;
                RefFeatured parent = ( (RefObjectImpl) ne ).refImmediateComposite( connection.getSession( ) );
                if ( parent == null ) {
                    deleteables.add( ne );
                }
            }
        }

        for ( OclNamedElement element : deleteables ) {
            ( (RefObjectImpl) element ).refDelete( connection );
        }

        JmiList<ModelElement> contents = (JmiList<ModelElement>) mp.getContents( connection );
        Set<ModelElement> elementsToDelete = new HashSet<ModelElement>( );
        for ( int i = 0, n = contents.size( connection.getSession( ) ); i < n; i++ ) {
            elementsToDelete.add( contents.get( connection.getSession( ), i ) );
        }
        for ( ModelElement element : elementsToDelete ) {
            if ( element instanceof Tag ) {
                continue;
            }
            ( (RefObjectImpl) element ).refDelete( connection );
        }
    }
}
