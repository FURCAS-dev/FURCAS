package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OclNamedElement;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclStatementImpl;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.ocl.service.OclService;
import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EvaluationKind;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TagImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;

/**
 * This is the implementation for the OCL services
 */
public class OclServiceImpl implements OclService {

    private static final class OpAndOwner {

        final Operation operation;

        public final Classifier owner;

        OpAndOwner( Operation op, Classifier own ) {

            this.operation = op;
            this.owner = own;
        }
    }

    private final static OclServiceImpl INSTANCE = new OclServiceImpl( );

    private final static Set<String> helperBodies = new HashSet<String>( );

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclServiceImpl.class );

    static {
        helperBodies.add( "context Namespace def: extendedNamespace() : Set(ModelElement) = self.contents->asSet()" ); //$NON-NLS-1$
        helperBodies.add( "context ModelElement def: format1Name() : String = self.name" ); //$NON-NLS-1$
        helperBodies.add( "context ModelElement def:repositoryId() : String = '???'" ); //$NON-NLS-1$
        helperBodies.add( "context ModelElement ::isVisible(otherElement : ModelElement): Boolean body: true" ); //$NON-NLS-1$
        helperBodies.add( "context GeneralizableElement def: extendedNamespace() : Set(ModelElement) = " + "self.contents->asSet()->union(self.allSupertypes() -> collect(s | s.contents)->asSet())" ); //$NON-NLS-1$ //$NON-NLS-2$
        helperBodies.add( "context Package " + "def: extendedNamespace() : Set(ModelElement) = " + "let ens = self.contents->asSet()->union(self.allSupertypes() -> collect(s | s.contents)->asSet()) in " //$NON-NLS-1$  //$NON-NLS-2$ //$NON-NLS-3$
                          + "let imports = ens -> select(e | e.oclIsKindOf(Import)) ->collect(i | i.oclAsType(Import).imported)->asSet() in " + "ens -> union(imports)" ); //$NON-NLS-1$  //$NON-NLS-2$

    }

    private OclServiceImpl( ) {

        // singleton
    }

    /**
     * Get the singleton instance of this service
     * 
     * @return the instance
     */
    public static OclServiceImpl getInstance( ) {

        return INSTANCE;
    }

    /**
     * @param connection connection
     * @param constraintInfo constraint
     * @param contextPackage context package
     * @param constrainedElements elements
     * @param modelElementsByName model element index
     * @param modelElementsByOclQualifiedName qualified index
     * @param typesPartition partition
     * @param ocldefinedFeatures features
     * @param container container
     * @return the new OclConstraint
     * @throws OclManagerException internal
     */
    public OclConstraint parseExpressionAndAttachSyntaxTree( CoreConnection connection, InstanceInfo constraintInfo, MofPackageInternal contextPackage, Collection<ModelElement> constrainedElements, Map<String, List<ModelElement>> modelElementsByName,
        Map<String, ModelElement> modelElementsByOclQualifiedName, ModelPartition typesPartition, Map<Classifier, Set<Feature>> ocldefinedFeatures, Namespace container ) throws OclManagerException {

        String expression = (String) constraintInfo.getAttributeValuesByName( ).get( OclConstants.F_EXPRESSION );
        String name = (String) constraintInfo.getAttributeValuesByName( ).get( OclConstants.F_NAME );

        String language = (String) constraintInfo.getAttributeValuesByName( ).get( OclConstants.F_LANGUAGE );
        String annotation = (String) constraintInfo.getAttributeValuesByName( ).get( OclConstants.F_ANNOTATION );
        if ( annotation == null ) {
            annotation = OclConstants.EMPTY;
        }

        EvaluationKind evaluationPolicy = (EvaluationKind) constraintInfo.getAttributeValuesByName( ).get( OclConstants.F_EVALUATIONPOLICY );

        MoinJmiCreator myJmiCreator = new JmiCreator( connection, true, typesPartition );

        OclStatement statement;
        IOclParser parser = OclParserFactory.create( myJmiCreator );

        Map<Classifier, Set<Feature>> oclFeatures = initHelpers( parser, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTPARSEEXPR, name, expression );
        }

        TypedElementInternal initializedElement = null;

        boolean needsCleanup = false;
        RefObject defaultContext;
        try {
            Collection<OclStatement> stmts = parser.parseString( expression, (MofPackage) contextPackage, modelElementsByName, modelElementsByOclQualifiedName, oclFeatures );
            if ( stmts.size( ) != 1 ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.MUSTPARSETOONE, name, Integer.valueOf( stmts.size( ) ), expression );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                needsCleanup = true;
                throw ex;
            }
            statement = stmts.iterator( ).next( );

            if ( language.equals( OclConstants.L_OCL ) && statement.getKind( ) != OclStatement.INVARIANT ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.ONLYINVFOROCL, name );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                needsCleanup = true;
                throw ex;
            } else if ( language.equals( OclConstants.L_OCLINIT ) && statement.getKind( ) != OclStatement.INIT_EXPRESSION ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.ONLYATTRIBINITFORLANGOCLINIT, name );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                needsCleanup = true;
                throw ex;
            } else if ( !language.equals( OclConstants.L_OCL ) && !language.equals( OclConstants.L_OCLINIT ) ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.ONLYATTRIBINITFORLANGOCLINIT, name );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                needsCleanup = true;
                throw ex;
            }
            defaultContext = statement.getContext( );


            if ( statement.getKind( ) == OclStatement.INIT_EXPRESSION ) {
                if ( defaultContext instanceof AttributeInternal ) {
                    AttributeInternal att = (AttributeInternal) defaultContext;
                    initializedElement = att;
                    defaultContext = (RefObject) ( (RefObjectImpl) att ).refImmediateComposite( connection.getSession( ) );
                } else if ( defaultContext instanceof StructureFieldInternal ) {
                    StructureFieldInternal sf = (StructureFieldInternal) defaultContext;
                    initializedElement = sf;
                    defaultContext = (RefObject) ( (RefObjectImpl) sf ).refImmediateComposite( connection.getSession( ) );
                }
            }

            // check that the default context fits together with the constrained elements
            for ( ModelElement me : constrainedElements ) {
                if ( me.equals( defaultContext ) ) {
                    continue;
                } else if ( me instanceof GeneralizableElementInternal ) {
                    GeneralizableElementInternal ge = (GeneralizableElementInternal) me;
                    if ( ge.allSupertypes( connection ).contains( defaultContext ) ) {
                        continue;
                    }
                }
                String defCtxName;
                if ( defaultContext instanceof ModelElementInternal ) {
                    defCtxName = ( (ModelElementInternal) defaultContext ).getQualifiedName( connection ).toString( );
                } else {
                    defCtxName = defaultContext.refMofId( );
                }
                OclSemanticException ex = new OclSemanticException( OclServiceExceptions.CONSTRAINEDTYPEINCOMPATIBLE, ( (ModelElementInternal) me ).getQualifiedName( connection ).toString( ), defCtxName );
                throw new OclManagerException( ex );
            }

            LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.SUCCESSPARSE, name, contextPackage.getQualifiedName( connection ).toString( ), expression );
        } catch ( FatalParsingException fpe ) {
            OclManagerException ex = new OclManagerException( fpe, OclServiceExceptions.EXCEPTIONPARSINGEXPR, expression );
            LOGGER.trace( ex, MoinSeverity.ERROR );
            needsCleanup = true;
            throw ex;
        } catch ( RuntimeException re ) {
            OclManagerException ex = new OclManagerException( re, OclServiceExceptions.EXCEPTIONPARSINGEXPR, expression );
            LOGGER.trace( ex, MoinSeverity.ERROR );
            needsCleanup = true;
            throw ex;
        } catch ( ParsingException pe ) {
            OclManagerException ex = new OclManagerException( pe, OclServiceExceptions.EXCEPTIONPARSINGEXPR, expression );
            LOGGER.trace( ex, MoinSeverity.ERROR, pe.getReport().toString() );
            needsCleanup = true;
            throw ex;
        } finally {
            // cleanup the transient partition
            if ( needsCleanup ) {
                try {
                    // concurrent modification exception when using the iterator
                    // directly
                    Set<ModelElement> elements = new HashSet<ModelElement>( );
                    for ( Iterator<Partitionable> mEs = connection.getNullPartition( ).getElements( ).iterator( ); mEs.hasNext( ); ) {
                        Partitionable next = mEs.next( );
                        if ( next instanceof ModelElement ) {
                            elements.add( (ModelElement) next );
                        }
                    }
                    for ( ModelElement me : elements ) {
                        try {
                            me.refDelete( );
                        } catch ( RuntimeException e ) {
                            // $JL-EXC$ cleanup
                        }
                    }
                } catch ( Exception e ) {
                    // $JL-EXC$ cleanup
                }
            }
        }

        OclConstraintInternal constraint = (OclConstraintInternal) myJmiCreator.createOclConstraint( name, annotation, expression, evaluationPolicy );
        constraint.setLanguage( connection, language );

        ( (JmiList<ModelElement>) ( (NamespaceInternal) container ).getContents( connection ) ).add( connection, (OclConstraint) constraint );

        try {
            if ( statement.getKind( ) == OclStatement.INVARIANT ) {
                // make sure the expression is boolean
                ( (OclExpressionInternal) statement.getExpression( ) ).setType( connection, myJmiCreator.getBoolClass( ) );
                if ( statement instanceof OclStatementImpl ) {
                    ( (OclStatementImpl) statement ).setName( name );
                }
                ModelPartition partition = ( (Partitionable) statement.getContext( ) ).get___Partition( );
                ( (CorePartitionable) statement.getExpression( ) ).assign___PartitionIncludingChildren( connection, partition );
                constraint.setOclExpression( connection, statement.getExpression( ) );

                for ( ModelElement me : constrainedElements ) {
                    ( (JmiList) constraint.getInvariantOf( connection ) ).add( connection, me );
                    ( (JmiList) ( (ClassifierInternal) me ).getConstraints( connection ) ).add( connection, constraint );
                }

                moveGenModelElementsToGenPackage( connection, typesPartition, myJmiCreator );

            } else if ( statement.getKind( ) == OclStatement.INIT_EXPRESSION ) {
                constraint.setOclExpression( connection, statement.getExpression( ) );
                if ( initializedElement instanceof AttributeInternal ) {
                    constraint.setInitializedAttribute( connection, (Attribute) initializedElement );
                    constraint.setInitializedElement( connection, (TypedElement) initializedElement );
                } else if ( initializedElement instanceof StructureFieldInternal ) {
                    constraint.setInitializedElement( connection, (TypedElement) initializedElement );

                }
            }

        } catch ( Exception e ) {

            LOGGER.trace( e, MoinSeverity.ERROR, OclServiceTraces.ATTACHEXCEPTION, name, statement.getExpression( ).getName( ) );
            new ProcessWarningImpl( e.getStackTrace( ), OclServiceExceptions.CONTEXTATTACHREPORT, e.getMessage( ) );
            parser.getReport( ).reportWarning( new ProcessWarningImpl( e.getStackTrace( ), OclServiceExceptions.CONTEXTATTACHREPORT, e.getMessage( ) ) );
        }

        return (OclConstraint) constraint;
    }

    /**
     * @param connection connection
     * @param theConstraint constraint
     * @param targetPartition partition
     * @param modelElementsByName element index
     * @param modelElementsByOclQualifiedName qualified index
     * @param ocldefinedFeatures features
     * @throws ParsingException internal
     * @throws OclManagerException internal
     */
    public void parseExpressionAndAttachSyntaxTree( CoreConnection connection, OclConstraint theConstraint, ModelPartition targetPartition, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> ocldefinedFeatures )
        throws ParsingException, OclManagerException {

        OclConstraintInternal constraint = (OclConstraintInternal) theConstraint;
        String name = constraint.getName( );
        String expression = constraint.getExpression( );

        if ( expression == null || expression.length( ) == 0 ) {
            throw new OclManagerException( OclServiceExceptions.EMPTYEXPRESSIONNOTPARSABLE, name );
        }
        JmiList<ModelElement> constrainedElements = (JmiList<ModelElement>) ( (OclConstraintImpl) constraint ).getConstrainedElements( connection );

        MofPackage constraintPackage = null;
        RefFeatured parent = ( (RefObjectImpl) constraint ).refImmediateComposite( connection.getSession( ) );
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

        OclStatement statement;

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTPARSEEXPR, name, expression );
        }

        MoinJmiCreator jmiCreator = new JmiCreator( connection, true, targetPartition );
        IOclParser parser = OclParserFactory.create( jmiCreator );

        try {

            Map<Classifier, Set<Feature>> oclFeatures = initHelpers( parser, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );

            Collection<OclStatement> stmts = parser.parseString( expression, constraintPackage, modelElementsByName, modelElementsByOclQualifiedName, oclFeatures );
            if ( stmts.size( ) != 1 ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.MUSTPARSETOONE, name, Integer.valueOf( stmts.size( ) ), expression );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                throw ex;
            }
            statement = stmts.iterator( ).next( );
            String language = constraint.getLanguage( );

            if ( language.equals( OclConstants.L_OCL ) && statement.getKind( ) != OclStatement.INVARIANT ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.ONLYINVFOROCL, name );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                throw ex;
            } else if ( language.equals( OclConstants.L_OCLINIT ) && statement.getKind( ) != OclStatement.INIT_EXPRESSION ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.ONLYATTRIBINITFORLANGOCLINIT, name );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                throw ex;
            } else if ( !language.equals( OclConstants.L_OCL ) && !language.equals( OclConstants.L_OCLINIT ) ) {
                OclManagerException ex = new OclManagerException( OclServiceExceptions.ONLYOCLANDOCLINITASLANGU, name, language );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                throw ex;
            }

            if ( statement instanceof OclStatementImpl ) {
                // set the name to the name of the constraint (helpful for debugging)
                ( (OclStatementImpl) statement ).setName( name );
            }

            RefObject defaultContext = statement.getContext( );

            if ( statement.getKind( ) == OclStatement.INIT_EXPRESSION ) {
                // set the initialized attribute
                if ( defaultContext instanceof AttributeInternal ) {
                    AttributeInternal att = (AttributeInternal) defaultContext;
                    // TODO the initializedAttribute assoc should go away eventually
                    // after all metamodels were re-converted
                    constraint.setInitializedAttribute( connection, (Attribute) att );
                    constraint.setInitializedElement( connection, (Attribute) att );
                    defaultContext = (RefObject) ( (RefObjectImpl) att ).refImmediateComposite( connection.getSession( ) );
                } else if ( defaultContext instanceof StructureFieldInternal ) {
                    StructureFieldInternal sf = (StructureFieldInternal) defaultContext;
                    if ( !( sf.getType( connection ) instanceof PrimitiveType ) ) {
                        // some checks are already in the parser, just to make sure we check again
                        throw new OclManagerException( OclServiceExceptions.PRIMITIVEINITONLY );
                    }
                    constraint.setInitializedElement( connection, (TypedElement) sf );
                    defaultContext = (RefObject) ( (RefObjectImpl) sf ).refImmediateComposite( connection.getSession( ) );
                } else {
                    // some checks are already in the parser, just to make sure we check again
                    throw new OclManagerException( OclServiceExceptions.ONLYATTANDSTRUCTINIT );
                }
            } else if ( statement.getKind( ) == OclStatement.INVARIANT ) {
                // make sure the expression is of type Boolean and set the name
                ( (OclExpressionInternal) statement.getExpression( ) ).setType( connection, jmiCreator.getBoolClass( ) );
                if ( statement instanceof OclStatementImpl ) {
                    ( (OclStatementImpl) statement ).setName( name );
                }
                // set the "invariant of" association
                Iterator<ModelElement> constrainedElementsIterator = constrainedElements.iteratorReadOnly( connection.getSession( ) );
                for ( ; constrainedElementsIterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) constrainedElementsIterator.next( );
                    ( (JmiList<Classifier>) constraint.getInvariantOf( connection ) ).add( connection, (Classifier) me );
                    ( (JmiList<Constraint>) ( (ClassifierInternal) me ).getConstraints( connection ) ).add( connection, (OclConstraint) constraint );
                }
            }

            // check that the default context fits together with the constrained elements
            Iterator<ModelElement> constrainedElementsIterator = constrainedElements.iteratorReadOnly( connection.getSession( ) );
            for ( ; constrainedElementsIterator.hasNext( ); ) {
                ModelElementInternal me = (ModelElementInternal) constrainedElementsIterator.next( );
                if ( me.equals( defaultContext ) ) {
                    continue;
                } else if ( me instanceof GeneralizableElementInternal ) {
                    GeneralizableElementInternal ge = (GeneralizableElementInternal) me;
                    if ( ge.allSupertypes( connection ).contains( defaultContext ) ) {
                        continue;
                    }
                }
                String defCtxName;
                if ( defaultContext instanceof ModelElementInternal ) {
                    defCtxName = ( (ModelElementInternal) defaultContext ).getQualifiedName( connection ).toString( );
                } else {
                    defCtxName = defaultContext.refMofId( );
                }
                throw new OclManagerException( OclServiceExceptions.CONSTRAINEDTYPEINCOMPATIBLE, me.getQualifiedName( connection ).toString( ), defCtxName );
            }

            OclExpression oldExpression = constraint.getOclExpression( connection );
            if ( oldExpression != null ) {
                ( (RefObjectImpl) oldExpression ).refDelete( connection );
            }
            ( (OclConstraintImpl) constraint ).setOclExpression( connection, statement.getExpression( ) );

            this.moveGenModelElementsToGenPackage( connection, targetPartition, jmiCreator );

            LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.SUCCESSPARSE, name, ( (RefObjectImpl) statement.getContext( ) ).refGetValue( connection, "name" ), expression ); //$NON-NLS-1$
        } catch ( FatalParsingException fpe ) {
            LOGGER.trace( fpe, MoinSeverity.ERROR );
            throw fpe;
        } catch ( ParsingException pe ) {
            LOGGER.trace( pe, MoinSeverity.ERROR );
            throw pe;
        }

    }

    private void moveGenModelElementsToGenPackage( CoreConnection conn, ModelPartition targetPartition, MoinJmiCreator jmiCreator ) throws OclManagerException {

        MofPackageInternal targetPkg = (MofPackageInternal) jmiCreator.getOrCreatePackageForGeneratedObjects( true );

        JmiList<ModelElement> contentsList = (JmiList<ModelElement>) targetPkg.getContents( conn );

        for ( Partitionable element : targetPartition.getElements( ) ) {
            if ( element instanceof ModelElement ) {
                ModelElement me = (ModelElement) element;
                if ( ( me instanceof CollectionType || me instanceof TupleType ) && ( (RefObjectImpl) me ).refImmediateComposite( conn.getSession( ) ) == null ) {
                    contentsList.add( conn, me );
                }
            } else if ( element instanceof OclNamedElement ) {
                // TODO add a composite association and put all the dangling OclNamedElements under the "root"
            }
        }
    }



    /**
     * @param parser parser
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @param ocldefinedFeatures features
     * @return the map with the helper operations
     * @throws OclManagerException internal
     */
    public Map<Classifier, Set<Feature>> initHelpers( IOclParser parser, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> ocldefinedFeatures ) throws OclManagerException {

        Map<Classifier, Set<Feature>> oclFeatures = new HashMap<Classifier, Set<Feature>>( );
        if ( ocldefinedFeatures != null ) {
            oclFeatures.putAll( ocldefinedFeatures );
        }


        Map<Classifier, Set<Feature>> helpers = createHelperOperations( parser, modelElementsByName, modelElementsByOclQualifiedName );
        for ( Entry<Classifier, Set<Feature>> entry : helpers.entrySet( ) ) {
            Set<Feature> fs = oclFeatures.get( entry.getKey( ) );
            if ( fs == null ) {
                fs = new HashSet<Feature>( );
                oclFeatures.put( entry.getKey( ), fs );
            }
            fs.addAll( entry.getValue( ) );
        }


        return oclFeatures;
    }



    public Object evaluateOclBodyExpression( final CoreConnection connection, String opName, RefObject context, Map<String, Object> inputParameters ) throws MoinBaseException {

        Object result = null;
        EvaluationContext ctx = null;
        try {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                StringBuilder sb = new StringBuilder( );
                sb.append( "Operation parameters: " ); //$NON-NLS-1$
                if ( inputParameters == null || inputParameters.isEmpty( ) ) {
                    sb.append( "\n<Empty>" ); //$NON-NLS-1$
                } else {
                    int index = 1;
                    for ( Map.Entry<String, Object> entry : inputParameters.entrySet( ) ) {
                        sb.append( "\nParameter " ); //$NON-NLS-1$
                        sb.append( index );
                        sb.append( ": Name: <" ); //$NON-NLS-1$
                        sb.append( entry.getKey( ) );
                        sb.append( "> Value: <" ); //$NON-NLS-1$
                        sb.append( entry.getValue( ) );
                        sb.append( ">" ); //$NON-NLS-1$
                        index++;
                    }
                }
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.OCLSERVICEVALOCLBODY, opName, ( context + sb.toString( ) ) );
            }
            String className;
            try {
                MofClassImpl clazz = (MofClassImpl) context.refMetaObject( );
                className = StringHelper.toPathName( clazz.getQualifiedName( connection ) );

                Object child;
                try {
                    child = clazz.lookupElementExtended( connection, opName );
                } catch ( NameNotFoundException e ) {
                    OclManagerException ex = new OclManagerException( e, OclServiceExceptions.OPNOTFOUND, opName, className );
                    throw ex;
                } catch ( JmiException e ) {
                    OclManagerException ex = new OclManagerException( e, OclServiceExceptions.OPNOTFOUND, opName, className );
                    throw ex;
                }
                if ( child instanceof Operation ) {
                    Operation op = (Operation) child;
                    if ( op.getName( ).equals( opName ) ) {
                        OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
                        OclExpression exp = assoc.getBody( connection, op );
                        if ( exp == null ) {
                            OclConstraintManagerException ex = new OclConstraintManagerException( OclServiceExceptions.OCLBODYNOTFOUND, opName, className );
                            LOGGER.trace( ex, MoinSeverity.ERROR );
                            throw ex;
                        }

                        OclFactory oclFactory = OclFactory.instance( );

                        ctx = new EvaluationContextImpl( oclFactory.create( context ) );
                        if ( inputParameters != null ) {
                            for ( Map.Entry<String, Object> entry : inputParameters.entrySet( ) ) {
                                ctx.setVariable( entry.getKey( ), oclFactory.create( entry.getValue( ) ) );
                            }
                        }
                        OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, exp, ctx );
                        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.EVALRESULT, oclResult );
                        }
                        if ( oclResult instanceof OclCollection ) {
                            OclCollection coll = (OclCollection) oclResult;
                            return coll.getUnwrappingCollection( false );
                        }
                        result = oclResult.getWrappedObject( );

                        if ( result instanceof InvalidValueException ) {
                            throw (InvalidValueException) result;
                        }

                        return result;
                    }
                }
                OclConstraintManagerException ex = new OclConstraintManagerException( OclServiceExceptions.OPNOTFOUND, opName, context.refGetValue( OclConstants.F_NAME ) );
                throw ex;
            } catch ( ClassCastException e ) {
                OclConstraintManagerException ex = new OclConstraintManagerException( OclServiceExceptions.NOTAMOFCLASS );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                throw ex;
            }
        } finally {
            if ( ctx != null ) {
                EvaluationContext.CurrentContext.reset( );
            }
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.OCLSERVICEEVALOCLBODYRES, result );
            }
        }
    }

    /**
     * @param connection connection
     * @param bodyExpressionTag expression tag
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @param ocldefinedFeatures features
     * @throws OclManagerException internal
     */
    public void parseBodyExpression( final CoreConnection connection, Tag bodyExpressionTag, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> ocldefinedFeatures ) throws OclManagerException {

        String expression;
        List<String> values = ( (TagImpl) bodyExpressionTag ).getValues( connection );
        if ( values.size( ) > 1 ) {
            StringBuilder builder = new StringBuilder( );
            for ( String value : values ) {
                builder.append( value );
                builder.append( OclConstants.SPACE );
            }
            expression = builder.toString( );
        } else {
            expression = values.get( 0 );
        }
        JmiList<ModelElement> ops = (JmiList<ModelElement>) ( (TagImpl) bodyExpressionTag ).getElements( connection );
        Set<Operation> operations = new HashSet<Operation>( );
        for ( Iterator<ModelElement> it = ops.iterator( connection ); it.hasNext( ); ) {
            operations.add( (Operation) it.next( ) );
        }
        ModelPartition targetPartition = null;
        RefFeatured parent = ( (TagImpl) bodyExpressionTag ).refImmediateComposite( connection.getSession( ) );

        // get the target package
        while ( parent != null ) {

            if ( parent instanceof MofPackage ) {
                targetPartition = ( (Partitionable) parent ).get___Partition( );
                break;
            }
            if ( parent instanceof RefObject ) {
                parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) );
            }
        }

        if ( targetPartition == null ) {
            throw new OclManagerException( OclServiceExceptions.COULDNOTDETERMINETARGETPARTITION );
        }

        if ( operations.isEmpty( ) ) {
            throw new OclManagerException( OclServiceExceptions.BODYEXPRTAGSMUSTBEATTACHED );
        }

        MoinJmiCreator myJmiCreator = new JmiCreator( connection, true, targetPartition );


        OclStatement statement;
        IOclParser parser = OclParserFactory.create( myJmiCreator );

        for ( Operation operation : operations ) {
            String opName = ( (OperationImpl) operation ).getQualifiedName( connection ).toString( );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTPARSEBODYEXPR, opName, expression );
            }
            boolean needsCleanup = false;
            try {
                Collection<OclStatement> stmts = parser.parseString( expression, operation, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );
                if ( stmts.size( ) != 1 ) {
                    OclSemanticException ex = new OclSemanticException( OclServiceExceptions.MUSTPARSETOONE, opName, Integer.valueOf( stmts.size( ) ), expression );
                    LOGGER.trace( ex, MoinSeverity.ERROR );
                    needsCleanup = true;
                    throw new OclManagerException( ex );
                }
                statement = stmts.iterator( ).next( );
                if ( statement.getKind( ) != OclStatement.OPERATION_BODY ) {
                    OclSemanticException ex = new OclSemanticException( OclServiceExceptions.BODYEXPRONLY );
                    LOGGER.trace( ex, MoinSeverity.ERROR );
                    needsCleanup = true;
                    throw new OclManagerException( ex );
                }
            } catch ( FatalParsingException fpe ) {
                OclManagerException ex = new OclManagerException( fpe, OclServiceExceptions.EXCEPTIONPARSINGEXPR, expression );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                needsCleanup = true;
                throw ex;
            } catch ( RuntimeException re ) {
                OclManagerException ex = new OclManagerException( re, OclServiceExceptions.EXCEPTIONPARSINGEXPR, expression );
                LOGGER.trace( ex, MoinSeverity.ERROR );
                needsCleanup = true;
                throw ex;
            } catch ( ParsingException pe ) {
                OclManagerException ex = new OclManagerException( pe, OclServiceExceptions.EXCEPTIONPARSINGEXPR, expression );
                LOGGER.trace( ex, MoinSeverity.ERROR, pe.getReport().toString() );
                needsCleanup = true;
                throw ex;

            } finally {
                // cleanup the transient partition
                if ( needsCleanup ) {
                    try {
                        // concurrent modification exception when using the
                        // iterator directly
                        Set<ModelElement> elements = new HashSet<ModelElement>( );
                        for ( Iterator<Partitionable> mEs = connection.getNullPartition( ).getElements( ).iterator( ); mEs.hasNext( ); ) {
                            Partitionable next = mEs.next( );
                            if ( next instanceof ModelElement ) {
                                elements.add( (ModelElement) next );
                            }
                        }
                        for ( ModelElement me : elements ) {
                            try {
                                ( (RefObjectImpl) me ).refDelete( connection );
                            } catch ( RuntimeException e ) {
                                // $JL-EXC$ well, we are cleaning up
                            }
                        }
                    } catch ( Exception e ) {
                        // $JL-EXC$ cleaning up
                    }
                }
            }

            // attach the operation body definition
            OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
            JmiList<Operation> defines = (JmiList<Operation>) assoc.getDefines( connection, statement.getExpression( ) );
            if (assoc.getBody(connection, (Operation) statement.getContext()) != null) {
        	assoc.remove(connection, assoc.getBody(connection, (Operation) statement.getContext()), (Operation) statement.getContext());
            }
            defines.add( connection, (Operation) statement.getContext( ) );

            this.moveGenModelElementsToGenPackage( connection, targetPartition, myJmiCreator );

        }
    }

    /**
     * @param connection connection
     * @param expression expression
     * @param context context
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @param targetPartition partition
     * @return the expression expression
     * @throws OclManagerException internal
     * @throws ParsingException internal
     */
    public OclExpression parseViolationMessageExpression( CoreConnection connection, String expression, RefObject context, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, ModelPartition targetPartition )
        throws OclManagerException, ParsingException {

        MoinJmiCreator jmiCreator = new JmiCreator( connection, true, targetPartition );


        IOclParser parser = OclParserFactory.create( jmiCreator );
        Set<OclStatement> stmt = parser.parseString( expression, context, modelElementsByName, modelElementsByOclQualifiedName, new HashMap<Classifier, Set<Feature>>( ) );

        if ( stmt.size( ) != 1 ) {
            // TODO name
            throw new OclManagerException( OclServiceExceptions.MUSTPARSETOONE, "ViolationMessage", Integer.valueOf( stmt.size( ) ), expression ); //$NON-NLS-1$
        }

        return stmt.iterator( ).next( ).getExpression( );
    }

    private Map<Classifier, Set<Feature>> createHelperOperations( IOclParser parser, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName ) throws OclManagerException {

        Map<Classifier, Set<Feature>> moinHelpers = new HashMap<Classifier, Set<Feature>>( );

        if ( modelElementsByOclQualifiedName.containsKey( "Model::Namespace" ) ) { //$NON-NLS-1$

            if ( modelElementsByOclQualifiedName.containsKey( "Model::Namespace::extendedNamespace" ) ) { //$NON-NLS-1$
                return moinHelpers;
            }

            for ( String body : helperBodies ) {
                try {
                    OpAndOwner opAndOwner = parseHelperOperation( parser, body, modelElementsByName, modelElementsByOclQualifiedName );

                    Set<Feature> features = moinHelpers.get( opAndOwner.owner );
                    if ( features == null ) {
                        features = new HashSet<Feature>( );
                        moinHelpers.put( opAndOwner.owner, features );
                    }
                    features.add( opAndOwner.operation );

                } catch ( ParsingException e ) {
                    LOGGER.trace( MoinSeverity.DEBUG, e.getReport( ).toString( ) );
                    throw new OclManagerException( (Throwable) e, OclServiceExceptions.EXPRESSIONNOTPARSABLE, body );
                } catch ( JmiException e ) {
                    throw new OclManagerException( e, OclServiceExceptions.JMICREATINHELPERS );
                } catch ( Exception e ) {
                    throw new OclManagerException( e, OclServiceExceptions.EXCEPTIONCREATINGHELPER );
                }
            }
        }
        return moinHelpers;
    }

    private OpAndOwner parseHelperOperation( IOclParser parser, String expression, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByQualifiedName ) throws ParsingException {

        Set<OclStatement> statements = Collections.emptySet( );
        try {
            statements = parser.parseString( expression, modelElementsByName, modelElementsByQualifiedName, null );
            if ( statements.size( ) != 1 ) {
                LOGGER.trace( MoinSeverity.WARNING, OclServiceTraces.CONSTRAINTHELPERPARSENONUNIQUE, expression );
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, parser.getReport( ).toString( ) );
                }
                return null;
            }

            OclStatement stmt = statements.iterator( ).next( );
            Operation op = (Operation) stmt.getContext( );

            StringTokenizer tok = new StringTokenizer( expression );
            tok.nextToken( );
            String contextName = tok.nextToken( );
            Classifier cls = (Classifier) modelElementsByName.get( contextName ).get( 0 );

            return new OpAndOwner( op, cls );

        } catch ( ParsingException e ) {
            LOGGER.trace( e, MoinSeverity.WARNING, OclServiceTraces.MOFCONSTRAINTHELPERNOTPARSED, expression );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, parser.getReport( ).toString( ) );
            }
            throw e;
        }
    }

}
