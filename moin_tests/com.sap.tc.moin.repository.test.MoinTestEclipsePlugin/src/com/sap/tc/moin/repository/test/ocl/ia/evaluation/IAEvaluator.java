package com.sap.tc.moin.repository.test.ocl.ia.evaluation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclInvalid;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclModelElement;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclVoid;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;

/**
 * This class provides some convenient methods for the test application which
 * will be integrated into the OCL evaluator. Its main task is to provide a
 * <tt>evaluate</tt> -method which takes <tt>EvaluationUnit</tt>s.
 */
public class IAEvaluator {

    private ExpressionEvaluator evaluator = ExpressionEvaluator.instance( );

    private final MoinJmiCreator myCreator;


    /**
     * Constructor taking a package finder
     */
    public IAEvaluator( MoinJmiCreator creator ) {

        this.myCreator = creator;
    }

    /**
     * @param eu
     * @return the affected instances
     */
    public Collection<RefObject> computeAffectedInstances( EvaluationUnit eu ) {

        Collection<RefObject> affectedInstances = new HashSet<RefObject>( );
        // get all affected instances
        for ( Iterator<InstanceSet> i = eu.getInstanceSets( ).iterator( ); i.hasNext( ); ) {
            InstanceSet is = i.next( );
            Collection<RefObject> instances;
            if ( is.getStartingPoints( ).isEmpty( ) ) {
                instances = this.getAllInstances( eu.getAffectedStatement( ) );
            } else {
                OclExpression expr = is.getNavigationStatement( ).getExpression( );
                Collection<OclAny> oclInstances = evaluate( expr, is.getStartingPoints( ) );
                instances = new HashSet<RefObject>( );
                for ( OclAny anyObject : oclInstances ) {
                    if ( anyObject instanceof OclVoid ) {
                        continue;
                    }
                    Object wrapped = anyObject.getWrappedObject( );
                    if ( wrapped instanceof RefObject ) {
                        instances.add( (RefObject) wrapped );
                    }
                }
            }
            affectedInstances.addAll( instances );
        }
        return affectedInstances;
    }

    /**
     * Returns all instances of an OclStatement's context.
     * 
     * @param stmt the statement
     * @return all instances of an OclStatement's context.
     */
    public Collection<RefObject> getAllInstances( OclStatement stmt ) {

        if ( stmt.getContext( ) instanceof Classifier ) {
            Classifier cls = (Classifier) stmt.getContext( );
            List<String> qName = cls.getQualifiedName( );
            String[] pkgName = new String[qName.size( ) - 1];
            for ( int i = 0; i < qName.size( ) - 1; i++ ) {
                pkgName[i] = qName.get( i );
            }
            String typeName = qName.get( qName.size( ) - 1 );
            return this.myCreator.findPackage( pkgName ).refClass( typeName ).refAllOfClass( );
        } else if ( stmt.getContext( ) instanceof Feature ) {
            throw new RuntimeException( "Feature context not implemented" );
        } else {
            throw new RuntimeException( "Unknown context" );
        }
    }

    /**
     * Evaluates a OclExpression for a Collection of instances (RefObjects)
     * 
     * @param expr the OclExpression to evaluate
     * @param instances a Collection of RefObjects to evaluate expr for
     * @return A Collection of OclAny which is the accumulated result for the
     * evaluation of expr for each element in instances.
     */
    public Collection<OclAny> evaluate( OclExpression expr, Collection<? extends RefFeatured> instances ) {

        OclAny res = null;
        Collection<OclAny> resSet = new HashSet<OclAny>( );
        for ( Iterator<? extends RefFeatured> i = instances.iterator( ); i.hasNext( ); ) {
            Object o = i.next( );
            RefObject instance;
            if ( o instanceof RefObject ) {
                instance = (RefObject) o;
            } else if ( o instanceof OclVoid ) {
                // don't care about OclUndefined
                continue;
            } else if ( o instanceof OclInvalid ) {
                // don't care about OclInvalid
                continue;
            } else if ( o instanceof OclAny ) {
                instance = (RefObject) ( (OclAny) o ).getWrappedObject( );
            } else {
                throw new ClassCastException( );
            }
            res = evaluate( expr, instance );

            if ( res instanceof OclCollection ) {
                // if an OclCollection has been returned add the elements
                // to our result set
                resSet.addAll( ( (OclCollection) res ).getWrappedCollection( ) );
            } else if ( res instanceof OclModelElement ) {
                // a model element has been returned.
                // add it to the result set.
                // TODO why the wrapped one? -> class cast
                resSet.add( res );
                // resSet.add((OclAny) ((OclModelElement) res).getWrappedObject());
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
     * @param exp The OclExpression to evaluate
     * @param object the instance for which to evaluate exp for
     * @return result of the evaluation
     */
    private OclAny evaluate( OclExpression exp, RefObject object ) {

        OclAny self = OclFactory.instance( ).create( object );
        EvaluationContext ctx;
        try {
            ctx = new EvaluationContextImpl( self );
        } catch ( IllegalStateException e ) {
            EvaluationContext.CurrentContext.reset( );
            ctx = new EvaluationContextImpl( self );
        }
        OclAny result = this.evaluator.evaluate( myCreator.getConnection( ), exp, ctx );

        return result;
    }
}
