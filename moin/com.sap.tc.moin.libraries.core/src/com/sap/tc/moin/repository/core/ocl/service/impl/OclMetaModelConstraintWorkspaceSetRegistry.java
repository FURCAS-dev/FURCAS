package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EvaluationKind;
import com.sap.tc.moin.repository.mmi.model.EvaluationKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.__impl.TagImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.LocalWhereEntry;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.Operation;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.mql.WhereEntry;
import com.sap.tc.moin.repository.mql.WhereString;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.QualifiedName;

/**
 * The connection-independent part of the OclMetamodelConstraintRegistry
 */
public class OclMetaModelConstraintWorkspaceSetRegistry {

    static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclMetaModelConstraintWorkspaceSetRegistry.class );

    private final Map<String, Map<OclStatement, OclRegistrationSeverity>> categoryToSeverityMap = new HashMap<String, Map<OclStatement, OclRegistrationSeverity>>( );

    private final Map<String, Set<OclConstraint>> constraintRegistry = new HashMap<String, Set<OclConstraint>>( );

    private final Map<OclStatement, String> stmtToConstraintMofId = new HashMap<OclStatement, String>( );

    private final Map<OclConstraint, OclRegistrationSeverity> constraintSeverityMap = new HashMap<OclConstraint, OclRegistrationSeverity>( );

    private final Map<List<String>, OclConstraintImpl> qNameToOclConstraints = new HashMap<List<String>, OclConstraintImpl>( );

    final Map<String, OclMetaModelConstraintRegistration> constraintMofIdToConstraintInfo = new HashMap<String, OclMetaModelConstraintRegistration>( );

    /**
     * @param connection used to access MOIN
     */
    public OclMetaModelConstraintWorkspaceSetRegistry( CoreConnection connection ) {

        long startInitMs = System.currentTimeMillis( );

        boolean debug = LOGGER.isTraced( MoinSeverity.DEBUG );
        try {
            WorkspaceSet workspaceSet = connection.getSession( ).getWorkspaceSet( );
            if ( !workspaceSet.getMoin( ).isSecondStageInjected( ) ) {
                workspaceSet.getMoin( ).injectSecondMofRomStage( );
            }

            // in the finally block, we will just log the completion of the method
            if ( debug ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTQUERYMMCONSTRAINTREGISTRY, connection.toString( ) );
            }
            // first, let's get all instances of OclConstraint

            MQLProcessor processor = connection.getMQLProcessor( );

            FromType fromOclConstraints = new FromType( "constraint", new String[] { "OCL", "Attaching", "OclConstraint" }, "sap.com/tc/moin/mof_1.4", true ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$//$NON-NLS-5$
            FromEntry[] fromEntries = new FromEntry[] { fromOclConstraints };

            // we only need the MRIs
            SelectAlias selectMri = new SelectAlias( "constraint" ); //$NON-NLS-1$
            SelectEntry[] selectEntries = new SelectEntry[] { selectMri };


            // the actual query
            MQLQuery query = new MQLQuery( selectEntries, fromEntries );
            MQLPreparedQuery preparedQuery = processor.prepare( query );

            long startQuery = System.nanoTime( );
            MQLResultSet foundConstraints = processor.execute( preparedQuery );
            long duration = ( System.nanoTime( ) - startQuery ) / 1000000;

            for ( int i = 0; i < foundConstraints.getSize( ); i++ ) {
                MRI mri = foundConstraints.getMri( i, "constraint" ); //$NON-NLS-1$

                // this may happen if the metamodel project is also imported
                // into the workspace (not just deployed):
                if ( !mri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
                    continue;
                }

                OclConstraintImpl constraint = (OclConstraintImpl) connection.getElement( mri );

                if ( constraint.getLanguage( ) == null ) {
                    // trace an error
                    List<String> qualifiedName = MoinMetamodelCode.getQualifiedName( connection, constraint, constraint );
                    String qName = QualifiedName.toDotSeparatedString( qualifiedName );
                    LOGGER.trace( MoinSeverity.ERROR, OclServiceTraces.NOLANGUAGEFOROCLCONSTRAINT, qName );
                    continue;
                }
                // skip initializer constraints
                if ( constraint.getLanguage( ).equals( OclConstants.L_OCL ) ) {
                    this.qNameToOclConstraints.put( MoinMetamodelCode.getQualifiedName( connection, constraint, constraint ), constraint );
                }

            }

            if ( debug ) {
                if ( this.qNameToOclConstraints.isEmpty( ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.NOOCLCONSTRAINTSFOUND );
                    return;
                }
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.CONSTRAINTQUERYRESULT, Integer.valueOf( this.qNameToOclConstraints.size( ) ), Long.valueOf( duration ) );
            }

            Map<OclConstraint, Set<String>> constraintsToCategory = new HashMap<OclConstraint, Set<String>>( );

            for ( final OclConstraint constraint : this.qNameToOclConstraints.values( ) ) {

                EvaluationKind evaluationPolicy = constraint.getEvaluationPolicy( );
                String pseudoCategory;
                if ( evaluationPolicy == EvaluationKindEnum.IMMEDIATE ) {
                    pseudoCategory = OclRegistrationCategory.immediate.name( );
                } else {
                    pseudoCategory = OclRegistrationCategory.deferred.name( );
                }
                Set<String> categories = new HashSet<String>( );
                categories.add( pseudoCategory );

                constraintsToCategory.put( constraint, categories );
            }

            // select from tags
            FromType seltags = new FromType( "tags", new String[] { "Model", "Tag" }, "sap.com/tc/moin/mof_1.4", false ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            fromEntries = new FromEntry[] { seltags };

            // we only need the MRIs
            // SelectAttrs selectTagId = new SelectAttrs("tags", new String[] { "tagId" });
            SelectAlias alias = new SelectAlias( "tags" ); //$NON-NLS-1$
            selectEntries = new SelectEntry[] { alias };

            // where tagid = constraintCategory
            WhereString whereId = new WhereString( "tagId", Operation.EQUAL, "org.omg.sap2mof.constraintCategory" ); //$NON-NLS-1$ //$NON-NLS-2$
            WhereEntry whereIdEntry = new LocalWhereEntry( "tags", whereId ); //$NON-NLS-1$
            WhereEntry[] whereEntries = new WhereEntry[] { whereIdEntry };
            // execute the query
            query = new MQLQuery( selectEntries, fromEntries, whereEntries );
            preparedQuery = processor.prepare( query );

            startQuery = System.nanoTime( );
            MQLResultSet foundTags = processor.execute( preparedQuery );
            duration = ( System.nanoTime( ) - startQuery ) / 1000000;

            for ( int i = 0; i < foundTags.getSize( ); i++ ) {
                TagImpl tag = (TagImpl) connection.getElement( foundTags.getMri( i, "tags" ) ); //$NON-NLS-1$

                List<String> tagValues = tag.getValues( connection );
                // we need to tokenize this
                Set<String> categoryValues = new HashSet<String>( );

                for ( String tagValue : tagValues ) {
                    StringTokenizer tok = new StringTokenizer( tagValue );
                    if ( tok.countTokens( ) == 1 ) {
                        categoryValues.add( tagValue );
                    } else {
                        while ( tok.hasMoreTokens( ) ) {
                            categoryValues.add( tok.nextToken( ) );
                        }
                    }
                }

                for ( String categoryValue : categoryValues ) {
                    final String actcategory;

                    int offset = categoryValue.lastIndexOf( ':' );
                    if ( offset > 0 ) {
                        actcategory = categoryValue.substring( 0, offset );
                    } else {
                        actcategory = categoryValue;
                    }

                    // the tags may not point to an OCL constraint (but to a
                    // constraint instead):
                    JmiList<ModelElement> tagged = (JmiList<ModelElement>) tag.getElements( connection );
                    for ( Iterator<ModelElement> taggedit = tagged.iterator( connection ); taggedit.hasNext( ); ) {
                        ModelElement taggedEl = taggedit.next( );
                        if ( taggedEl instanceof OclConstraint ) {
                            OclConstraint constraint = (OclConstraint) taggedEl;
                            if(constraintsToCategory.get( constraint ) != null) {
                                constraintsToCategory.get( constraint ).add( actcategory );
                            }
                        }
                    }
                }

            }

            // query the tags with violationSeverity
            whereId = new WhereString( "tagId", Operation.EQUAL, "org.omg.sap2mof.deferredConstraintViolationSeverity" ); //$NON-NLS-1$ //$NON-NLS-2$
            whereIdEntry = new LocalWhereEntry( "tags", whereId ); //$NON-NLS-1$
            whereEntries = new WhereEntry[] { whereIdEntry };

            query = new MQLQuery( selectEntries, fromEntries, whereEntries );
            preparedQuery = processor.prepare( query );

            startQuery = System.nanoTime( );
            foundTags = processor.execute( preparedQuery );
            duration = ( System.nanoTime( ) - startQuery ) / 1000000;

            for ( int i = 0; i < foundTags.getSize( ); i++ ) {
                TagImpl tag = (TagImpl) connection.getElement( foundTags.getMri( i, "tags" ) ); //$NON-NLS-1$
                String tagValue = tag.getValues( connection ).get( 0 );
                // the tags may not point to an OCL constraint (but to a
                // constraint instead):
                JmiList<ModelElement> tagged = (JmiList<ModelElement>) tag.getElements( connection );
                for ( Iterator<ModelElement> taggedit = tagged.iterator( connection ); taggedit.hasNext( ); ) {
                    ModelElement taggedEl = taggedit.next( );
                    if ( taggedEl instanceof OclConstraint ) {
                        OclConstraint constraint = (OclConstraint) taggedEl;
                        if ( tagValue.equals( OclRegistrationSeverity.Warning.name( ) ) ) {
                            this.constraintSeverityMap.put( constraint, OclRegistrationSeverity.Warning );
                        } else if ( tagValue.equals( OclRegistrationSeverity.Error.name( ) ) ) {
                            this.constraintSeverityMap.put( constraint, OclRegistrationSeverity.Error );
                        } else if ( tagValue.equals( OclRegistrationSeverity.Info.name( ) ) ) {
                            this.constraintSeverityMap.put( constraint, OclRegistrationSeverity.Info );
                        } else {
                            this.constraintSeverityMap.put( constraint, OclRegistrationSeverity.Error );
                        }
                    }

                }
            }

            for ( final OclConstraintImpl constraint : this.qNameToOclConstraints.values( ) ) {

                Set<String> constrainedElements = new HashSet<String>( );
                JmiList<ModelElement> constrained = (JmiList<ModelElement>) constraint.getConstrainedElements( connection );
                for ( Iterator<ModelElement> it = constrained.iterator( connection ); it.hasNext( ); ) {
                    constrainedElements.add( it.next( ).getName( ) );
                }

                OclRegistrationSeverity severity = this.constraintSeverityMap.get( constraint );
                if ( severity == null ) {
                    // make sure we have an entry even if the tag was not found
                    severity = OclRegistrationSeverity.Error;
                    this.constraintSeverityMap.put( constraint, severity );
                }
                Set<String> categories = constraintsToCategory.get( constraint );
                List<OclExpression> violationExpression = constraint.getViolationMessageExpression( connection );

                OclMetaModelConstraintRegistration info = new MetaModelConstraintInfoImpl( connection.getSession( ), (JmiList<OclExpression>) violationExpression, constraint.getQualifiedName( connection ), constraint.getExpression( ), severity, categories, constrainedElements, constraint );

                for ( String category : categories ) {
                    Set<OclConstraint> constraints = this.constraintRegistry.get( category );
                    if ( constraints == null ) {
                        constraints = new HashSet<OclConstraint>( );
                        this.constraintRegistry.put( category, constraints );
                    }
                    constraints.add( constraint );
                }

                this.constraintMofIdToConstraintInfo.put( constraint.refMofId( ), info );
            }

            if ( debug ) {
                // debug trace
                if ( this.constraintRegistry.isEmpty( ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.CONSTRAINTREGISTRYISEMPTY );
                }
                for ( Map.Entry<String, Set<OclConstraint>> registryEntry : this.constraintRegistry.entrySet( ) ) {

                    LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.CATEGORYNUMCONSTRAINTS, registryEntry.getKey( ), Integer.valueOf( registryEntry.getValue( ).size( ) ) );
                    int index = 0;
                    for ( OclConstraint constraint : registryEntry.getValue( ) ) {
                        index++;
                        LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.CONSTRAINTINDEXANDNAME, Integer.valueOf( index ), constraint.getName( ) );
                    }
                }
            }
        } finally {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.INITOCLMMCONSTRAINTREGISTRYDUR, Long.valueOf( System.currentTimeMillis( ) - startInitMs ) );
            }
        }
    }

    /**
     * @param connection connection
     * @param category category
     * @return the map
     * @throws OclConstraintManagerException internal
     */
    public Map<OclStatement, OclRegistrationSeverity> getSeverityMap( CoreConnection connection, String category ) throws OclConstraintManagerException {

        if ( this.categoryToSeverityMap.containsKey( category ) ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.REUSINGMAPPING, category );
            }
            Map<OclStatement, OclRegistrationSeverity> result = this.categoryToSeverityMap.get( category );
            if ( result.isEmpty( ) ) {
                throw new OclConstraintManagerException( OclServiceExceptions.NOREGISTRATIONSFORCAT, category );
            }
            return result;
        }

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.BUILDINGMAPPING, category );
        }

        Map<OclStatement, OclRegistrationSeverity> result = new HashMap<OclStatement, OclRegistrationSeverity>( );

        Set<OclConstraint> constraints = this.constraintRegistry.get( category );

        if ( constraints == null || constraints.isEmpty( ) ) {
            OclConstraintManagerException ex = new OclConstraintManagerException( OclServiceExceptions.NOREGISTRATIONSFORCAT, category );
            LOGGER.trace( ex, MoinSeverity.WARNING );
            throw ex;
        }

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.NUMCONSTRAINTSFORCAT, category, Integer.valueOf( constraints.size( ) ) );
        }

        for ( OclConstraint constr : constraints ) {
            final OclConstraintImpl constraint = (OclConstraintImpl) constr;
            final OclExpression expression = constraint.getOclExpression( connection );
            JmiList<Classifier> constrainedElements = (JmiList<Classifier>) constraint.getInvariantOf( connection );
            for ( Iterator<Classifier> it = constrainedElements.iterator( connection ); it.hasNext( ); ) {
                final RefObject context = it.next( );
                OclStatement stmt = new OclStatement( ) {

                    public String getName( ) {

                        return constraint.getName( );
                    }

                    public int getKind( ) {

                        return OclStatement.INVARIANT;
                    }

                    public OclExpression getExpression( ) {

                        return expression;
                    }

                    public RefObject getContext( ) {

                        return context;
                    }

                    @Override
                    public String toString( ) {

                        return "Name: " + this.getName( ) + " OclExpression: " + constraint.getExpression( ); //$NON-NLS-1$//$NON-NLS-2$
                    }

                };
                result.put( stmt, this.constraintSeverityMap.get( constraint ) );
                this.stmtToConstraintMofId.put( stmt, constraint.refMofId( ) );
            }
        }

        if ( result.isEmpty( ) ) {
            LOGGER.trace( MoinSeverity.WARNING, OclServiceExceptions.NOSTMTSFORCATEGORY, category );
            throw new OclConstraintManagerException( OclServiceExceptions.NOSTMTSFORCATEGORY, category );
        }

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.NUMSTMTSFORCAT, category, Integer.valueOf( constraints.size( ) ) );
        }
        this.categoryToSeverityMap.put( category, result );
        return result;
    }

    /**
     * @param constraintMofId mofid
     * @return the constraint registration
     */
    public OclMetaModelConstraintRegistration getInfo( String constraintMofId ) {

        return this.constraintMofIdToConstraintInfo.get( constraintMofId );
    }

    /**
     * @return the available meta model constraints
     */
    public Set<OclMetaModelConstraintRegistration> getAvailableMetamodelConstraints( ) {

        Set<OclMetaModelConstraintRegistration> result = new HashSet<OclMetaModelConstraintRegistration>( );
        result.addAll( this.constraintMofIdToConstraintInfo.values( ) );
        return result;
    }

    /**
     * @return the internal registration table (mapping of category to
     * constraints)
     */
    public Map<String, Set<OclConstraint>> getRegistryInternal( ) {

        return this.constraintRegistry;
    }

    /**
     * @return the map
     */
    public Map<OclStatement, String> getStmtConstraintMap( ) {

        return this.stmtToConstraintMofId;
    }

    /**
     * @param qualifiedName qname
     * @return the constraint
     */
    public OclConstraint getConstraint( List<String> qualifiedName ) {

        return this.qNameToOclConstraints.get( qualifiedName );
    }
}
