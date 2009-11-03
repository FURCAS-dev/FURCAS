package com.sap.tc.moin.ocl.ia.relevance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;

import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.stdlibrary.StdLibraryPackage;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * This class represents a navigation path.
 * <p>
 * A navigation path is a sequence of attribute call expressions and association
 * end call expressions. It also offers the possibility to convert a navigation
 * path to OCL, so the evaluator can compute affected context instances by
 * evaluating the navigation path.
 */
public class NavigationPath {

    private final List<ModelElement> path = new ArrayList<ModelElement>( );

    private Operation and;

    private Operation not;

    private Operation oclIsUndefined;

    /**
     * The constructor
     */
    public NavigationPath( ) {

        // nothing particular 
    }

    private void initializeOperations( MoinJmiCreator jc ) {

        MofPackageImpl stdLibPkg = (MofPackageImpl) jc.getPackage( StdLibraryPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );
        try {
            Classifier bool = (Classifier) stdLibPkg.lookupElement( jc.getConnection( ), OclConstants.T_BOOLEANSTDLIB );
            this.and = (Operation) MoinMetamodelCode.lookupElement( jc.getConnection( ), bool, (RefObjectImpl) bool, OclConstants.OP_AND );
            this.not = (Operation) MoinMetamodelCode.lookupElement( jc.getConnection( ), bool, (RefObjectImpl) bool, OclConstants.OP_NOT );
            this.oclIsUndefined = (Operation) MoinMetamodelCode.lookupElementExtended( jc.getConnection( ), bool, (RefObjectImpl) bool, OclConstants.OP_OCLISUNDEFINED );
        } catch ( NameNotFoundException ne ) {
            throw new RuntimeException( ne );
        }
    }

    /**
     * Add ModelElement me to the navigation path
     * 
     * @param me the ModelElement to add to the path.
     */
    public void add( ModelElement me ) {

        this.path.add( me );
    }

    /**
     * @param mes model elements
     */
    public void addAll( List<ModelElement> mes ) {

        for ( ModelElement me : mes ) {
            this.path.add( me );
        }
    }

    /**
     * @return the path
     */
    public List<ModelElement> getPath( ) {

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
     * @param jmiCreator {@link MoinJmiCreator}
     * @return Returns a OclExpression which evaluates to a Set of relevant
     * instances
     * @throws OclSemanticException Exception
     */
    public OclExpression turnIntoOcl( VariableDeclaration self, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        // store the jmiCreator in an instance variable so
        // it has not to be passed on all the time
        // the reverse navigation path starts with self
        initializeOperations( jmiCreator );
        OclExpression revNavPath = jmiCreator.createVariableExp( self );
        // reverse the path and create its representation in OCL
        for ( int i = this.path.size( ) - 1; i >= 0; i-- ) {
            ModelElement me = this.path.get( i );
            if ( me instanceof AssociationEnd ) {
                // reverse the association end
                AssociationEnd assocEnd = (AssociationEnd) me;
                revNavPath = reverseAssociationEndCall( revNavPath, assocEnd, jmiCreator );
                // revNavPath =
                // jmiCreator.createAssociationCallExpExt(revNavPath,
                // assocEnd.otherEnd());
            } else if ( me instanceof Attribute ) {
                // an attribute call is not so easy to be reversed.
                Attribute attr = (Attribute) me;
                revNavPath = reverseAttributeCall( revNavPath, attr, jmiCreator );
            } else {
                throw new MoinLocalizedBaseRuntimeException( OclServiceExceptions.REVNAVNOTSUPPORTED, me.getClass( ).getName( ) );
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
    private OclExpression reverseAttributeCall( OclExpression source, Attribute attr, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        // get the attribute's owner's type
        Classifier attrOwnerType = (Classifier) ( (AttributeImpl) attr ).refImmediateComposite( jmiCreator.getSession( ) );
        // create the allInstances call
        OperationCallExp allInstances = createAllInstances( attrOwnerType, jmiCreator );
        // the iterator variable
        VariableDeclaration iter = jmiCreator.createVariableDeclaration( "iter", attrOwnerType, null ); //$NON-NLS-1$

        OclExpression body = createBody( source, attr, iter, jmiCreator );
        // create the select LoopExp
        IteratorExp select = createSelect( allInstances, iter, body, jmiCreator );
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
    private OclExpression reverseAssociationEndCall( OclExpression source, AssociationEnd end, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        CoreConnection conn = jmiCreator.getConnection( );
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
    private OclExpression createBridgingCode( OclExpression source, AssociationEnd end, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        // create iterate
        CoreConnection conn = jmiCreator.getConnection( );
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( conn );
        Classifier endType = ( (AssociationEndImpl) end ).getType( conn );

        // create condition of if Expression : e.oclIsKindOf(<T>)
        Classifier sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( conn );
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
    private boolean isSubType( CoreConnection connection, Classifier endType, Classifier sourceType ) {

        Classifier t1 = endType;
        Classifier t2 = sourceType;
        // if one of the types is a CollectionType we unwrap it
        if ( sourceType instanceof CollectionType || endType instanceof CollectionType ) {
            if ( endType instanceof CollectionType ) {
                t1 = ( (CollectionTypeInternal) endType ).getElementType( connection );
            }
            if ( sourceType instanceof CollectionType ) {
                t2 = ( (CollectionTypeInternal) sourceType ).getElementType( connection );
            }
            return isSubType( connection, t1, t2 );
        }
        return MoinMetamodelCode.allSupertypes( connection, endType, (RefObjectImpl) endType ).contains( sourceType );
    }

    /**
     * @param source
     * @param attr
     * @param iter
     * @return the expression
     * @throws OclSemanticException
     */
    private OclExpression createBody( OclExpression source, Attribute attr, VariableDeclaration iter, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        OclExpression body;
        // setting up the body

        /*
         * -- we need to construct something like -- let s1: <source type> =
         * <source> in -- let s2: <attr call type> = <attr call> in -- not
         * s1.oclIsUndefined() and not s2.oclIsUndefined() and s1 <"=" |
         * ".includes("> s2 <|")">
         */

        CoreConnection conn = jmiCreator.getConnection( );
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
    private OperationCallExp createAllInstances( Classifier type, MoinJmiCreator jmiCreator ) throws OclSemanticException {

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
    private IteratorExp createSelect( OclExpression source, VariableDeclaration iterator, OclExpression body, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        IteratorExpImpl select = (IteratorExpImpl) jmiCreator.createIteratorExp( "select", source, iterator, null, body ); //$NON-NLS-1$
        // we know that source is of type Set(x)
        select.setType( jmiCreator.getConnection( ), ( (OclExpressionInternal) source ).getType( jmiCreator.getConnection( ) ) );
        return select;
    }

    @Override
    public String toString( ) {

        String s = "< self"; //$NON-NLS-1$
        for ( ModelElement me : this.path ) {
            s += ", " + me.getName( ); //$NON-NLS-1$
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
        for ( Iterator<ModelElement> i = this.path.iterator( ); i.hasNext( ); ) {
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
     * @throws OclSemanticException
     */
    private OclExpression and( OclExpression source, OclExpression arg, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        List<Classifier> args = new ArrayList<Classifier>( 2 );
        args.add( jmiCreator.getBoolClass( ) );
        args.add( jmiCreator.getBoolClass( ) );

        OperationCallExp andCall = jmiCreator.createOperationCallExp( this.and, source, arg );
        return andCall;
    }

    /**
     * Creates a <tt>not</tt> OperationCallExp
     * 
     * @param source the source for <tt>not</tt>
     * @return a <tt>not</tt> OperationCallExp
     * @throws OclSemanticException
     */
    private OclExpression not( OclExpression source, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        List<Classifier> args = new ArrayList<Classifier>( 1 );
        args.add( jmiCreator.getBoolClass( ) );
        OperationCallExp notCall = jmiCreator.createOperationCallExp( this.not, source );
        return notCall;
    }

    /**
     * Creates a <tt>isOclUndefined</tt> OperationCallExp
     * 
     * @param source the source for <tt>isOclUndefined</tt>
     * @return a <tt>isOclUndefined</tt> OperationCallExp
     * @throws OclSemanticException
     */
    private OclExpression oclIsUndefined( OclExpression source, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        OperationCallExp isOclUndefinedCall = jmiCreator.createOperationCallExp( this.oclIsUndefined, source );
        return isOclUndefinedCall;
    }
}
