package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.OclPackage;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclStatementImpl;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

/**
 * The WorkspaceSet registration object for MOF Constraints
 * <p>
 * The {@link OclMofConstraintRegistry} has two parts, one which is specific for
 * a {@link com.sap.tc.moin.repository.Connection} and another one which is
 * independent of the {@link com.sap.tc.moin.repository.Connection}. This
 * represents the connection-independent part of the initialization.
 */
public class OclMofConstraintWorkspaceSetRegistry {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclMofConstraintWorkspaceSetRegistry.class );

    private final Map<List<String>, Map<List<String>, OclStatement>> qNameToCtxStmtMap = new HashMap<List<String>, Map<List<String>, OclStatement>>( );

    private final Map<OclStatement, OclMetaModelConstraintRegistration> stmtToInfoMapping = new HashMap<OclStatement, OclMetaModelConstraintRegistration>( );

    private final Set<OclStatement> multiplictyTypeStmts = new HashSet<OclStatement>( );

    final Map<OclRegistrationCategory, ImpactAnalyzer> categoryIaMap = new HashMap<OclRegistrationCategory, ImpactAnalyzer>( );

    /**
     * The constructor needs a {@link Connection} in order to be able to create
     * the OCL objects
     * 
     * @param connection used for accessing MOIN
     * @throws OclManagerException Exception
     */
    public OclMofConstraintWorkspaceSetRegistry( CoreConnection connection ) throws OclManagerException {

        initFromUnparsed( connection, new JmiCreator( connection ) );
    }

    /**
     * @return a Map from {@link OclRegistrationCategory} to
     * {@link ImpactAnalyzer}
     */
    public Map<OclRegistrationCategory, ImpactAnalyzer> getCategoryImpactAnalyzerMap( ) {

        return this.categoryIaMap;
    }

    /**
     * @return the Set of {@link OclStatement}s relevant for Multiplicity checks
     */
    public Set<OclStatement> getMultiplicityStatements( ) {

        return this.multiplictyTypeStmts;
    }

    /**
     * @return the Map
     */
    public Map<List<String>, Map<List<String>, OclStatement>> getQnameToStmtMapping( ) {

        return this.qNameToCtxStmtMap;
    }

    /**
     * @return a Map from {@link OclStatement} to
     * {@link OclMetaModelConstraintRegistration}
     */
    public Map<OclStatement, OclMetaModelConstraintRegistration> getStmtToInfoMapping( ) {

        return this.stmtToInfoMapping;
    }

    private void initFromUnparsed( CoreConnection connection, MoinJmiCreator jmiCreator ) throws OclManagerException {

        Set<OclStatement> statementsToAnalyzeImmediate = new HashSet<OclStatement>( );
        Set<OclStatement> statementsToAnalyzeDeferred = new HashSet<OclStatement>( );
        Map<OclRegistrationCategory, Set<OclStatement>> categoryStmtMap = new HashMap<OclRegistrationCategory, Set<OclStatement>>( );

        long starttime = System.nanoTime( );
        long startInit = System.nanoTime( );

        categoryStmtMap.put( OclRegistrationCategory.immediate, statementsToAnalyzeImmediate );
        categoryStmtMap.put( OclRegistrationCategory.deferred, statementsToAnalyzeDeferred );

        Set<Constraint> constraints = new HashSet<Constraint>( );

        Collection<CorePartitionable> instances = connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ).getInstanceManager( ).getInstances( );

        for ( SpiPartitionable instance : instances ) {
            if ( instance instanceof ConstraintImpl ) {
                ConstraintImpl constraint = (ConstraintImpl) instance;
                String firstNameComponent = constraint.getQualifiedName( connection ).get( 0 );
                // we only need the Model and OCL constraints with the language "OCL",
                // i.e. don't consider attribute initializer, they have the language "OCLInit"
                if ( OclConstants.L_OCL.equals( constraint.getLanguage( ) ) && ( OclConstants.P_MODEL.equals( firstNameComponent ) || OclConstants.P_OCL.equals( firstNameComponent ) ) ) {
                    constraints.add( constraint );
                }
            }
        }

        if ( constraints.isEmpty( ) ) {
            OclManagerException ex = new OclManagerException( OclServiceExceptions.MOFCONSTRAINTSNOTFOUND );
            LOGGER.logAndTrace( MoinSeverity.ERROR, OclServiceExceptions.MOFCONSTRAINTSNOTFOUND );
            throw ex;
        }

        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        OclPackage oclPackage = connection.getPackage( OclPackage.PACKAGE_DESCRIPTOR );
        RefPackage[] typesPackages = new RefPackage[] { modelPackage, oclPackage };
        IOclParser parser = OclParserFactory.create( jmiCreator );

        Map<String, List<ModelElement>> modelElementsByName = new HashMap<String, List<ModelElement>>( );
        Map<String, ModelElement> modelElementsByOclQualifiedName = new HashMap<String, ModelElement>( );

        StringBuilder qname = new StringBuilder( );

        ModelPartition mp = ( (Partitionable) modelPackage ).get___Partition( );
        for ( Partitionable p : mp.getElements( ) ) {
            RefObject element;
            if ( p instanceof RefBaseObject ) {
                element = ( (RefBaseObject) p ).refMetaObject( );
            } else {
                continue;
            }
            if ( element instanceof ModelElement ) {
                ModelElement me = (ModelElement) element;
                /*
                 * we only need the Model stuff; furthermore, since this
                 * partition contains all meta models, there is the potential
                 * for naming conflicts that must be avoided
                 */
                if ( !( (ModelElementInternal) me ).getQualifiedName( connection ).get( 0 ).equals( OclConstants.P_MODEL ) ) {
                    continue;
                }
                String name = me.getName( );
                qname.setLength( 0 );
                List<String> qnamelist = ( (ModelElementInternal) me ).getQualifiedName( connection );
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
                // TODO why do we encounter "Package" twice, for example?
                if ( !elements.contains( me ) ) {
                    elements.add( me );
                }
                modelElementsByOclQualifiedName.put( qname.toString( ), me );

            }
        }

        starttime = System.nanoTime( );

        Map<Classifier, Set<Feature>> helpers = OclServiceImpl.getInstance( ).initHelpers( parser, modelElementsByName, modelElementsByOclQualifiedName, null );

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            long helpOpsTime = ( System.nanoTime( ) - starttime ) / 1000000;
            LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.HELPEROPSCREATIONDUR, helpOpsTime );
        }

        int index = 0;
        long parsingTime = 0l;

        for ( final Constraint constr : constraints ) {
            index++;
            ConstraintImpl constraint = (ConstraintImpl) constr;
            String ocl = constraint.getExpression( );
            // we use the JmiList here for performance
            JmiList<ModelElement> constrainedElements = (JmiList<ModelElement>) constraint.getConstrainedElements( connection );
            if ( constrainedElements.isEmpty( connection.getSession( ) ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.NOCONSTRAINEDELSFOUND, constraint.getQualifiedName( connection ).toString( ) );
            }

            final Set<String> constrainedElementNames = new HashSet<String>( );
            for ( Iterator<ModelElement> it = constrainedElements.iterator( connection ); it.hasNext( ); ) {
                constrainedElementNames.add( it.next( ).getName( ) );
            }

            OclMetaModelConstraintRegistration info = new MofConstraintInfoImpl( constraint, constrainedElementNames );

            for ( Iterator<ModelElement> it = constrainedElements.iterator( connection ); it.hasNext( ); ) {
                RefObject context = it.next( );

                boolean isMultiplictyType = false;
                if ( context instanceof StructureType && ( (StructureType) context ).getName( ).equals( OclConstants.T_MULTIPLICITYTYPE ) ) {
                    isMultiplictyType = true;
                }

                Set<OclStatement> parsingResult;
                try {
                    long startParse = System.nanoTime( );
                    parsingResult = parser.parseString( ocl, context, typesPackages, helpers );

                    if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                        Object[] parameters = new Object[3];

                        parameters[0] = constraint.getQualifiedName( connection ).toString( );
                        if ( context instanceof ModelElement ) {
                            parameters[1] = MoinMetamodelCode.getQualifiedName( connection, (ModelElement) context, (RefObjectImpl) context ).toString( );
                        } else {
                            parameters[1] = context.refMofId( );
                        }
                        parameters[2] = ocl;
                        LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.SUCCESSPARSE, parameters );
                    }
                    parsingTime = parsingTime + System.nanoTime( ) - startParse;
                    if ( parsingResult.size( ) != 1 ) {
                        continue;
                    }

                    for ( OclStatement stmt : parsingResult ) {

                        if ( stmt instanceof OclStatementImpl ) {
                            ( (OclStatementImpl) stmt ).setName( constraint.getName( ) );
                        }

                        this.stmtToInfoMapping.put( stmt, info );

                        if ( isMultiplictyType ) {
                            this.multiplictyTypeStmts.add( stmt );
                        } else {
                            List<String> qName = ( (ConstraintInternal) constraint ).getQualifiedName( connection );
                            Map<List<String>, OclStatement> meStmtMap = this.qNameToCtxStmtMap.get( qName );
                            if ( meStmtMap == null ) {
                                meStmtMap = new HashMap<List<String>, OclStatement>( );
                                this.qNameToCtxStmtMap.put( qName, meStmtMap );
                            }
                            meStmtMap.put( MoinMetamodelCode.getQualifiedName( connection, (ModelElement) stmt.getContext( ), (RefObjectImpl) stmt.getContext( ) ), stmt );
                        }
                    }

                } catch ( Exception e ) {
                    LOGGER.trace( e, MoinSeverity.WARNING, OclServiceTraces.COULDNOTPARSEMOFCONSTRAINT, constraint.getName( ) );
                    e.printStackTrace( );
                    continue;
                }

                if ( !isMultiplictyType ) {
                    if ( info.getCategories( ).contains( OclRegistrationCategory.immediate.toString( ) ) ) {
                        statementsToAnalyzeImmediate.addAll( parsingResult );
                    } else {
                        statementsToAnalyzeDeferred.addAll( parsingResult );
                    }
                }
            }
        }

        for ( Entry<OclRegistrationCategory, Set<OclStatement>> e : categoryStmtMap.entrySet( ) ) {
            ImpactAnalyzer ia = new ImpactAnalyzer( false );
            ia.analyze( e.getValue( ), jmiCreator );
            this.categoryIaMap.put( e.getKey( ), ia );
        }

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.PARSEMOFDURATIN, index, ( parsingTime / 1000000 ) );
            LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.INITMOFWSREGDUR, ( ( System.nanoTime( ) - startInit ) / 1000000 ) );
        }

    }
}
