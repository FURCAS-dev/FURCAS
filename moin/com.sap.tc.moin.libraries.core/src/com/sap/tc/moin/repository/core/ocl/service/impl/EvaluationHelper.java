package com.sap.tc.moin.repository.core.ocl.service.impl;

import static com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys.OCL_SHOW_JMI_TREE;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclModelElement;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclVoid;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.parser.treeviewer.JmiTreeViewer;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.ocl.utils.impl.OclSerializer;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Evaluation related helper methods
 */
public class EvaluationHelper {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL_EVALUATOR, EvaluationHelper.class );

    /**
     * Returns the collection of direct or indirect instances of a Classifier.
     * If a Classifier is abstract it returns all instances of its concrete
     * subclasses. This method is needed since there are no Class proxies
     * generated for abstract classes and hence no instances thereof can be
     * obtained. TODO perhaps we can optimize this
     * 
     * @param connection
     * @param c the classifier for which to return all instances
     * @param pkg
     * @return all direct and indirect instances of c
     */
    private Set<RefObject> getAllInstancesOfClassifier( CoreConnection connection, Classifier c ) {

        Set<RefObject> classifiers = new HashSet<RefObject>( );

        if ( c.isAbstract( ) ) {
            JmiList<GeneralizableElement> subTypes = (JmiList<GeneralizableElement>) connection.getCoreJmiHelper( ).getSubTypes( connection, c );
            for ( Iterator<GeneralizableElement> i = subTypes.iterator( connection ); i.hasNext( ); ) {
                GeneralizableElement e1 = i.next( );
                if ( !( e1 instanceof Classifier ) ) {
                    continue;
                }
                if ( !e1.isAbstract( ) ) {
                    try {
                        Classifier cls = (Classifier) e1;
                        List<String> qName = MoinMetamodelCode.getQualifiedName( connection, cls, (RefObjectImpl) cls );
                        classifiers.addAll( this.queryInstancesOfClassifier( connection, qName ) );
                        return classifiers;
                    } catch ( RuntimeException e ) {
                        // TODO severity?
                        LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.CLASSPROXYNOTFOUND, printQName( e1 ) );
                    }
                } else {
                    return getAllInstancesOfClassifier( connection, (Classifier) e1 );
                }
            }
        }

        List<String> qName = MoinMetamodelCode.getQualifiedName( connection, c, (RefObjectImpl) c );
        classifiers.addAll( this.queryInstancesOfClassifier( connection, qName ) );
        return classifiers;
    }

    private Set<RefObject> queryInstancesOfClassifier( CoreConnection connection, List<String> qNameOfClassifier ) {

        String[] qName = new String[qNameOfClassifier.size( )];
        qNameOfClassifier.toArray( qName );

        Set<RefObject> result = new HashSet<RefObject>( );

        MQLProcessor processor = connection.getMQLProcessor( );

        FromType oclConstraints = new FromType( "constraint", qName, null, true ); //$NON-NLS-1$
        FromEntry[] fromEntries = new FromEntry[] { oclConstraints };

        // we only need the MRIs
        SelectAlias selectMri = new SelectAlias( "constraint" ); //$NON-NLS-1$

        SelectEntry[] selectEntries = new SelectEntry[] { selectMri };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries );

        MQLPreparedQuery preparedQuery = processor.prepare( query );

        MQLResultSet foundConstraints = processor.execute( preparedQuery );

        for ( int i = 0; i < foundConstraints.getSize( ); i++ ) {
            MRI mri = foundConstraints.getMri( i, "constraint" ); //$NON-NLS-1$
            result.add( (RefObject) connection.getElement( mri ) );
        }
        return result;
    }

    /**
     * Returns all instances of an OclStatement's context.
     * 
     * @param connection the core connection
     * @param context the context
     * @return all instances of an OclStatement's context.
     */
    public Set<RefObject> getAllInstances( CoreConnection connection, Classifier context ) {

        return getAllInstancesOfClassifier( connection, context );
    }

    /**
     * Returns the qualified name of a ModelElement as a String
     * 
     * @param e1 the ModelElement
     * @return the qualified name of a ModelElement as a String
     */
    private String printQName( ModelElement e1 ) {

        List<String> qName = e1.getQualifiedName( );
        if ( qName == null || qName.size( ) == 0 ) {
            return e1.getName( );
        }
        String s = OclConstants.EMPTY;
        int index = 0;
        for ( Iterator<String> i = qName.iterator( ); i.hasNext( ); index++ ) {
            s += i.next( );
            if ( index < qName.size( ) - 1 ) {
                s += OclConstants.PATHSEP;
            }
        }
        return s;

    }

    private ExpressionEvaluator evaluator = ExpressionEvaluator.instance( );

    /**
     * Constructor taking a package finder
     */
    public EvaluationHelper( ) {

// nothing
    }

    /**
     * Evaluates a EvaluationUnit
     * 
     * @param connection the core connection
     * @param eu the EvaluationUnit to evaluate
     * @return the evaluation result
     */
    public Set<OclAny> getAffectedInstances( CoreConnection connection, EvaluationUnit eu ) {

        RefObject contextType = eu.getAffectedStatement( ).getContext( );

        Set<OclAny> result = new HashSet<OclAny>( );
        // get all affected instances
        for ( InstanceSet is : eu.getInstanceSets( ) ) {
            result.addAll( this.computeAffectedInstances( connection, is, contextType ) );
        }
        return result;
    }

    /**
     * @param connection the core connection
     * @param eu the evaluation unit
     * @return the affected RefObjects
     */
    public Set<RefObject> getAffectedRefObjects( CoreConnection connection, EvaluationUnit eu ) {

        Set<RefObject> result = new HashSet<RefObject>( );
        for ( OclAny any : this.getAffectedInstances( connection, eu ) ) {
            Object next = any.getWrappedObject( );
            if ( next instanceof RefObject ) {
                result.add( (RefObject) next );
            }
        }
        return result;
    }

    /**
     * @param connection
     * @param eu
     * @return the affected instances
     */
    private Set<OclAny> computeAffectedInstances( CoreConnection connection, InstanceSet is, RefObject contextType ) {

        Set<OclAny> affectedInstances = new HashSet<OclAny>( );
        // get all affected instances
        Set<RefObject> startingPoints = new HashSet<RefObject>( );
        startingPoints.addAll( is.getStartingPoints( ) );

        if ( startingPoints.isEmpty( ) && is.getNavigationStatement( ).getContext( ) instanceof Classifier ) {
            startingPoints = this.getAllInstances( connection, (Classifier) is.getNavigationStatement( ).getContext( ) );
        }

        OclExpression expr = is.getNavigationStatement( ).getExpression( );
        Collection<OclAny> oclInstances = evaluate( connection, expr, startingPoints );
        for ( OclAny anyObject : oclInstances ) {
            if ( anyObject instanceof OclVoid ) {
                continue;
            }
            try {
                Object wrapped = anyObject.getWrappedObject( );
                if ( wrapped instanceof RefObject ) {
                    RefObject ro = (RefObject) wrapped;
                    RefObject meta = ro.refMetaObject( );

                    if ( meta.equals( contextType ) ) {
                        affectedInstances.add( anyObject );
                    } else if ( meta instanceof GeneralizableElement ) {
                        if ( MoinMetamodelCode.allSupertypes( connection, (GeneralizableElement) meta, (RefObjectImpl) meta ).contains( contextType ) ) {
                            affectedInstances.add( anyObject );
                        }
                    }
                }
            } catch ( InvalidValueException e ) {
                // $JL-EXC$
            }
        }

        return affectedInstances;
    }

    /**
     * Evaluates a OclExpression for a Collection of instances (RefObjects)
     * 
     * @param connection the core connection
     * @param expr the OclExpression to evaluate
     * @param instances a Collection of RefObjects to evaluate the expression
     * for
     * @return A Collection of OclAny which is the accumulated result for the
     * evaluation of the expression for each element in instances.
     */
    public Collection<OclAny> evaluate( CoreConnection connection, OclExpression expr, Set<? extends RefFeatured> instances ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            try {
                String result = OclSerializer.getInstance( connection ).serialize( expr, new RefPackage[0] );
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.SERIALIZEDEXPRESSION, result );
            } catch ( OclSerializationException e1 ) {
                LOGGER.trace( MoinSeverity.WARNING, OclServiceTraces.SERIALIZATIONFAILEDFORTRACE );
            }
        }

        OclAny res = null;
        Collection<OclAny> resSet = new HashSet<OclAny>( );
        for ( Iterator<? extends RefFeatured> i = instances.iterator( ); i.hasNext( ); ) {

            res = evaluateInstance( connection, expr, (RefObject) i.next( ) );

            if ( res instanceof OclCollection ) {
                // if an OclCollection has been returned add the elements
                // to our result set
                resSet.addAll( ( (OclCollection) res ).getWrappedCollection( ) );
            } else if ( res instanceof OclModelElement ) {
                // a model element has been returned.
                // add it to the result set.
                // TODO why the wrapped one? -> class cast
                resSet.add( res );
                // resSet.add((OclAny) ((OclModelElement)
                // res).getWrappedObject());
            } else {
                // a simple element has been returned.
                // add it to the result set.
                resSet.add( res );
            }
        }
        return resSet;
    }

    /**
     * Evaluates a OclExpression for a single instance
     * 
     * @param connection
     * @param exp The OclExpression to evaluate
     * @param object the instance for which to evaluate the expression
     * @return result of the evaluation
     */
    private OclAny evaluateInstance( CoreConnection connection, OclExpression exp, RefObject object ) {

        try {
            EvaluationContext ctx;
            OclAny self = OclFactory.instance( ).create( object );
            try {
                ctx = new EvaluationContextImpl( self );
            } catch ( IllegalStateException e ) {
                EvaluationContext.CurrentContext.reset( );
                ctx = new EvaluationContextImpl( self );
            }
            return this.evaluator.evaluate( connection, exp, ctx );
        } catch ( RuntimeException rte ) {
            if ( OclConstants.TRUE.equalsIgnoreCase( System.getProperty( OCL_SHOW_JMI_TREE ) ) ) {
                JmiTreeViewer tv = new JmiTreeViewer( exp, connection );
                tv.setModal( true );
                tv.setBounds( new Rectangle( 100, 100, 400, 500 ) );
                tv.setVisible( true );
            }
            throw rte;
        } finally {
            EvaluationContext.CurrentContext.reset( );
        }
    }

}
