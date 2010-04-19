package de.hpi.sam.bp2009.moin.impactAnalyzer.relevance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.ocl.ecore.AssociationClassCallExp;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.impl.IteratorExpImpl;
import org.eclipse.ocl.ecore.impl.OperationCallExpImpl;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.utilities.OCLFactory;

/**
 * This class represents a navigation path.
 * <p>
 * A navigation path is a sequence of attribute call expressions and association
 * end call expressions. It also offers the possibility to convert a navigation
 * path to OCL, so the evaluator can compute affected context instances by
 * evaluating the navigation path.
 */
public class NavigationPath {

    private final List<EModelElement> path = new ArrayList<EModelElement>( );

    private EOperation and;

    private EOperation not;

    private EOperation oclIsUndefined;

    /**
     * The constructor
     */
    public NavigationPath( ) {

        // nothing particular 
    }

    private void initializeOperations( ) {

        MofPackageImpl stdLibPkg = (MofPackageImpl) jc.getPackage( StdLibraryPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );
        
            Classifier bool = (Classifier) stdLibPkg.lookupElement( jc.getConnection( ), OclConstants.T_BOOLEANSTDLIB );
            this.and = (Operation) MoinMetamodelCode.lookupElement( jc.getConnection( ), bool, (RefObjectImpl) bool, OclConstants.OP_AND );
            this.not = (Operation) MoinMetamodelCode.lookupElement( jc.getConnection( ), bool, (RefObjectImpl) bool, OclConstants.OP_NOT );
            this.oclIsUndefined = (Operation) MoinMetamodelCode.lookupElementExtended( jc.getConnection( ), bool, (RefObjectImpl) bool, OclConstants.OP_OCLISUNDEFINED );
    }

    /**
     * Add ModelElement me to the navigation path
     * 
     * @param me the ModelElement to add to the path.
     */
    public void add( EModelElement me ) {

        this.path.add( me );
    }

    /**
     * @param mes model elements
     */
    public void addAll( List<EModelElement> mes ) {

        for ( EModelElement me : mes ) {
            this.path.add( me );
        }
    }

    /**
     * @return the path
     */
    public List<EModelElement> getPath( ) {

        return this.path;
    }

    /**
     * Adds NavigationPath <tt>navPath</tt> to the set of NaviagationPaths. Do
     * not use <tt>getPath().add(navPath)</tt> instead, since the Set for path
     * does not check for duplicates properly
     * 
     * @param navPath the NavigationPath to add
     */
    // public void addNavPath(NavigationPath navPath) {
    // if (!path.contains(navPath)) {
    // path.add(navPath);
    // }
    // }
    /**
     * Creates an OclExpression for the reverse NaviagationPath
     * 
     * @param self {@link VariableDeclaration}
     * @return Returns a OclExpression which evaluates to a Set of relevant
     * instances
     */
    public OCLExpression turnIntoOcl( VariableExp self ) {

        // store the jmiCreator in an instance variable so
        // it has not to be passed on all the time
        // the reverse navigation path starts with self
        initializeOperations( );
        OCLExpression revNavPath = self;
        // reverse the path and create its representation in OCL
        for ( int i = this.path.size( ) - 1; i >= 0; i-- ) {
            EModelElement me = this.path.get( i );
            if ( me instanceof EReference ) {
                // reverse the association end
            	EReference assocEnd = (EReference) me;
                revNavPath = reverseAssociationEndCall( revNavPath, assocEnd);
                // revNavPath =
                // jmiCreator.createAssociationCallExpExt(revNavPath,
                // assocEnd.otherEnd());
            } else if ( me instanceof EAttribute ) {
                // an attribute call is not so easy to be reversed.
                EAttribute attr = (EAttribute) me;
                revNavPath = reverseAttributeCall( revNavPath, attr );
            } else {
            	throw new RuntimeException("Reverse navigation not supported");
                //throw new MoinLocalizedBaseRuntimeException( OclServiceExceptions.REVNAVNOTSUPPORTED, me.getClass( ).getName( ) );
            }
        }

        return revNavPath;
    }

    /**
     * This method creates an OCL expression which finds the owner of an
     * object-valued attribute value. The resulting OCL expression looks
     * something like that:
     * <p>
     * 
     * <pre>
     *    &lt;T&gt;.allInstances()-&gt;select(iter | 
     *      &lt;source&gt;-&gt;includes(iter.&lt;attr&gt;))
     * </pre>
     * &lt;T&gt; is the type of the attribute's owner, &lt;attr&gt;, the
     * attribute to be navigated in opposite direction, &lt;source&gt; the
     * source from where to navigate backwards.
     * 
     * @param source the source form where to navigate backwards
     * @param attr the attribute to navigate backwards
     * @return a ocl expression representing a reverse navigation through a
     * attribute.
     * @throws OclSemanticException
     */
    private OCLExpression reverseAttributeCall( OCLExpression source, EAttribute attr ) {

        // get the attribute's owner's type
        EClassifier attrOwnerType = (EClassifier) ( (EAttributeImpl) attr ).refImmediateComposite( );
        // create the allInstances call
        OperationCallExp allInstances = createAllInstances( attrOwnerType );
        // the iterator variable
        VariableExp iter = jmiCreator.createVariableDeclaration( "iter", attrOwnerType, null ); //$NON-NLS-1$

        OCLExpression body = createBody( source, attr, iter);
        // create the select LoopExp
        IteratorExp select = createSelect( allInstances, iter, body );
        return select;
    }

    /**
     * Reverses an AssociationEndCall.
     * <p>
     * Problem is that an AssociationEnd might not be available on the way back.
     * Imagine class A and a sub-class B. Navigating forward, we reach B by some
     * navigations and then access another association end defined on A.
     * Reversing the path brings us back to A again but from here we cannot
     * navigate further backwards as the association is only defined on B.
     * Solution is to select only those As which are Bs actually.
     * <p>
     * <code>toA->iterate(e; acc:Set(B)=Set{} | if e.oclIsTypeOf(B) then 
     * 									acc.including(e) 
     * 								  else acc endif)</code>
     * 
     * @param source the source
     * @param end the association end to reverse
     * @return an OclExpression for reverse navigation of <tt>end</tt>
     * @throws OclSemanticException
     */
    private OCLExpression reverseAssociationEndCall( OCLExpression source, EReference end ) {

        Classifier sourceType = ( (OclExpressionInternal) source ).getType( conn );
        Classifier endType = ( (AssociationEndImpl) end ).getType( conn );
        OclExpression revNavPath;
        if ( isSubType( jmiCreator.getConnection( ), endType, sourceType ) ) {
            // TODO this is untested!
            // endType is a subtype of sourceType.
            // we have to do the fancy stuff
            if ( sourceType instanceof CollectionType ) {
                // we have to insert a code snippet as discussed above
                OclExpression bridge = createBridgingCode( source, end, jmiCreator );
                // an association end call is simply reversed by
                // navigating along the opposite association end.
                AssociationEnd otherEnd = ( (AssociationEndImpl) end ).otherEnd( conn );
                revNavPath = jmiCreator.createAssociationCallExpExt( bridge, otherEnd, false );
            } else {
                // a simple type cast does the job
                TypeExp refEndType = jmiCreator.createTypeExp( ( (AssociationEndImpl) end ).getType( conn ) );
                Operation oclAsType = jmiCreator.getStdLibraryOperation( OclConstants.T_OCLANYSTDLIB, OclConstants.OP_OCLASTYPE );
                OperationCallExp oclAsTypeOpCall = jmiCreator.createOperationCallExp( oclAsType, source, refEndType );
                // an association end call is simply reversed by
                // navigating along the opposite association end.
                AssociationEnd otherEnd = ( (AssociationEndImpl) end ).otherEnd( conn );
                revNavPath = jmiCreator.createAssociationCallExpExt( oclAsTypeOpCall, otherEnd, false );
            }
        } else {
            // simply reverse associationEnd and we are done.
            // an association end call is simply reversed by
            // navigating along the opposite association end.
            AssociationEnd otherEnd = ( (AssociationEndImpl) end ).otherEnd( conn );
            revNavPath = jmiCreator.createAssociationCallExpExt( source, otherEnd, false );
        }
        return revNavPath;
    }

    /**
     * creates the following code to get only a suitable subset of elements to
     * which a certain association end navigation can be applied.
     * <p>
     * 
     * <pre>
     * source->iterate(e; acc:Set(T)=Set{} | if e.oclIsTypeOf(T) then 
     * 	 acc.including(e)  else acc endif)
     * </pre>
     * 
     * @param source
     * @param end
     * @return the expression
     * @throws OclSemanticException
     */
    private OCLExpression createBridgingCode( OCLExpression source, AssociationClassCallExp end ) {

        // create iterate
        EClassifier sourceType = source.getType( );
        EClassifier endType = end.getType( );

        // create condition of if Expression : e.oclIsKindOf(<T>)
        EClassifier sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( );
        VariableDeclaration e = jmiCreator.createVariableDeclaration( "e", sourceElmType, null ); //$NON-NLS-1$
        VariableExp eVarExp = jmiCreator.createVariableExp( e );
        TypeExp refEndType = jmiCreator.createTypeExp( endType );
        Operation oclIsKindOf = jmiCreator.getStdLibraryOperation( OclConstants.T_OCLANYSTDLIB, OclConstants.OP_OCLISKINDOF );
        OperationCallExp oclIsKindOfCall = jmiCreator.createOperationCallExp( oclIsKindOf, eVarExp, refEndType );

        // create then expression: acc.including(e.oclAsType(<T>))
        refEndType = jmiCreator.createTypeExp( endType );
        eVarExp = jmiCreator.createVariableExp( e );
        Operation oclAsType = jmiCreator.getStdLibraryOperation( OclConstants.T_OCLANYSTDLIB, OclConstants.OP_OCLASTYPE );
        OperationCallExp oclAsTypeOpCall = jmiCreator.createOperationCallExp( oclAsType, eVarExp, refEndType );
        CollectionType accType = jmiCreator.createSetType( endType );
        CollectionLiteralExp accInit = jmiCreator.createCollectionLiteralExp( accType, new ArrayList<CollectionLiteralPart>( ) );
        VariableDeclaration acc = jmiCreator.createVariableDeclaration( "acc", accType, accInit ); //$NON-NLS-1$
        VariableExp accVarExp = jmiCreator.createVariableExp( acc );
        Operation including = jmiCreator.getStdLibraryOperation( OclConstants.T_SETTYPESTDLIB, OclConstants.OP_INCLUDING );
        OperationCallExp includingOpCall = jmiCreator.createOperationCallExp( including, accVarExp, oclAsTypeOpCall );

        // create else expression: acc
        accVarExp = jmiCreator.createVariableExp( acc );
        // create the if expression
        IfExp ifExp = jmiCreator.createIfExp( oclIsKindOfCall, includingOpCall, accVarExp, accType );
        // create the iterate expression
        IterateExp iterate = jmiCreator.createIterate( source, e, null, acc, ifExp );

        return iterate;
    }

    /**
     * @param endType
     * @param sourceType
     * @return true if it is a subtype
     */
    private boolean isSubType( EClassifier endType, EClassifier sourceType ) {

        EClassifier t1 = endType;
        EClassifier t2 = sourceType;
        // if one of the types is a CollectionType we unwrap it
        if ( sourceType instanceof CollectionType || endType instanceof CollectionType ) {
            if ( endType instanceof CollectionType ) {
                t1 = ((org.eclipse.ocl.types.CollectionType<EClassifier, EOperation>) endType).getElementType( );
            }
            if ( sourceType instanceof CollectionType ) {
                t2 = ((org.eclipse.ocl.types.CollectionType<EClassifier, EOperation>) sourceType).getElementType( );
            }
            return isSubType( t1, t2 );
        }
        return MoinMetamodelCode.allSupertypes( endType, (RefObjectImpl) endType ).contains( sourceType );
    }

    /**
     * @param source
     * @param attr
     * @param iter
     * @return the expression
     * @throws OclSemanticException
     */
    private OCLExpression createBody( OCLExpression source, EAttribute attr, VariableExp iter ) {

        OCLExpression body;
        // setting up the body

        /*
         * -- we need to construct something like -- let s1: <source type> =
         * <source> in -- let s2: <attr call type> = <attr call> in -- not
         * s1.oclIsUndefined() and not s2.oclIsUndefined() and s1 <"=" |
         * ".includes("> s2 <|")">
         */

        Classifier sourceType = ( (OclExpressionInternal) source ).getType( conn );
        VariableDeclaration var1 = jmiCreator.createVariableDeclaration( "s1", sourceType, source ); //$NON-NLS-1$
        VariableExp iterVarExp = jmiCreator.createVariableExp( iter );
        AttributeCallExpImpl attrCall = (AttributeCallExpImpl) jmiCreator.createAttributeCallExp( iterVarExp, attr, false );
        VariableDeclaration var2 = jmiCreator.createVariableDeclaration( "s2", attrCall.getType( conn ), attrCall ); //$NON-NLS-1$

        if ( sourceType instanceof CollectionType ) {
            // if source returns a collection ...
            Operation includes = jmiCreator.getStdLibraryOperation( OclConstants.T_COLLTYPESTDLIB, OclConstants.OP_INCLUDES );
            body = jmiCreator.createOperationCallExp( includes, jmiCreator.createVariableExp( var1 ), jmiCreator.createVariableExp( var2 ) );
        } else {
            // if source returns a simple type
            // an equals operation is enough to compare the attribute values
            Operation equals = jmiCreator.getStdLibraryOperation( OclConstants.T_OCLANYSTDLIB, OclConstants.OP_EQSTDLIB );
            body = jmiCreator.createOperationCallExp( equals, jmiCreator.createVariableExp( var1 ), jmiCreator.createVariableExp( var2 ) );
        }

        VariableExp varExp1 = jmiCreator.createVariableExp( var1 );
        VariableExp varExp2 = jmiCreator.createVariableExp( var2 );

        OclExpression in = and( not( oclIsUndefined( varExp1, jmiCreator ), jmiCreator ), and( not( oclIsUndefined( varExp2, jmiCreator ), jmiCreator ), body, jmiCreator ), jmiCreator );

        LetExp let2 = jmiCreator.createLetExp( in, var2 );
        LetExp let1 = jmiCreator.createLetExp( let2, var1 );

        return let1;
    }

    /**
     * Creates an operation call representing <tt>allInstances()</tt>
     * 
     * @param type the type form which to get all instances
     * @return the expression
     * @throws OclSemanticException
     */
    private OperationCallExp createAllInstances( EClassifier type ) {

        TypeExp owner = jmiCreator.createTypeExp( type );
        jmiCreator.createSetType( type );
        Operation allInstancesOp = jmiCreator.getStdLibraryOperation( OclConstants.T_OCLTYPESTDLIB, OclConstants.OP_ALLINSTANCES );
        OperationCallExp allInstances = jmiCreator.createOperationCallExp( allInstancesOp, owner );
        return allInstances;
    }

    /**
     * Creates a select iterator expression.
     * 
     * @param source the source of the select
     * @param iterator the iterator variable
     * @param body the body of the select
     * @return a IteratorExp representing a select
     */
    private IteratorExp createSelect( OCLExpression source, VariableExp iterator, OCLExpression body ) {

        IteratorExpImpl select = (IteratorExpImpl) jmiCreator.createIteratorExp( "select", source, iterator, null, body ); //$NON-NLS-1$
        // we know that source is of type Set(x)
        select.setType( jmiCreator.getConnection( ), ( (OclExpressionInternal) source ).getType( jmiCreator.getConnection( ) ) );
        return select;
    }

    @Override
    public String toString( ) {

        String s = "< self"; //$NON-NLS-1$
        for ( EModelElement me : this.path ) {
            s += ", " + me.toString(); //$NON-NLS-1$
        }
        return s + " >"; //$NON-NLS-1$
    }

    @Override
    public boolean equals( Object arg0 ) {

        if ( arg0 instanceof NavigationPath ) {
            // NavigationPaths are equals if their paths are equal
            return this.path.equals( ( (NavigationPath) arg0 ).getPath( ) );
        }
        return false;

    }

    /**
     * @return the Hash
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        int code = Integer.MAX_VALUE;
        for ( Iterator<EModelElement> i = this.path.iterator( ); i.hasNext( ); ) {
            code = code ^ i.next( ).hashCode( );
        }
        return code;
    }

    /**
     * Creates a <tt>and</tt> OperationCallExp
     * 
     * @param source the source for <tt>and</tt>
     * @param arg the argument
     * @return a <tt>and</tt> OperationCallExp
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private OCLExpression and( OCLExpression source, OCLExpression arg ) throws InstantiationException, IllegalAccessException {

//        List<EClassifier> args = new ArrayList<EClassifier>( 2 );
//        args.add( jmiCreator.getBoolClass( ) );
//        args.add( jmiCreator.getBoolClass( ) );

//        OperationCallExp andCall = jmiCreator.createOperationCallExp( this.and, source, arg );
    	// TODO add second OCLExpression
    	OperationCallExp andCall = OperationCallExp.class.newInstance();
    	andCall.setSource(source);
    	andCall.setReferredOperation(this.and);
        return andCall;
    }

    /**
     * Creates a <tt>not</tt> OperationCallExp
     * 
     * @param source the source for <tt>not</tt>
     * @return a <tt>not</tt> OperationCallExp
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private OCLExpression not( OCLExpression source ) throws InstantiationException, IllegalAccessException {

        //List<EClassifier> args = new ArrayList<EClassifier>( 1 );
        //args.add( jmiCreator.getBoolClass( ) );
        OperationCallExp notCall = OperationCallExp.class.newInstance();
        notCall.setSource(source);
        notCall.setReferredOperation(this.not);
        return notCall;
    }

    /**
     * Creates a <tt>isOclUndefined</tt> OperationCallExp
     * 
     * @param source the source for <tt>isOclUndefined</tt>
     * @return a <tt>isOclUndefined</tt> OperationCallExp
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    private OCLExpression oclIsUndefined( OCLExpression source ) throws InstantiationException, IllegalAccessException {

        OperationCallExp isOclUndefinedCall = OperationCallExp.class.newInstance();
        isOclUndefinedCall.setSource(source);
        isOclUndefinedCall.setReferredOperation(this.oclIsUndefined);
        return isOclUndefinedCall;
    }
}
