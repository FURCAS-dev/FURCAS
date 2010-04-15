package de.hpi.sam.bp2009.moin.impactAnalyzer.relevance;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;

import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.tag.ExpressionKind;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclStatementImpl;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * This class is a association class. For each pair (OclStatement,InternalEvent)
 * there is a instance of this class. It holds the navigation paths for an
 * InternalEvent and a OclStatement.
 * 
 * @author Thomas Hettel (D039141)
 */
public abstract class Relevance {

    private final InternalEvent event;

    private ExpressionKind kind = ExpressionKind.INSTANCE;

    private final Set<NavigationPath> navigationPaths = new HashSet<NavigationPath>( );

    private final OclStatement stmt;

    /**
     * Creates a new Relevance object for a OclStatement, InternalEvent pair.
     * 
     * @param theStmt the OclStatement
     * @param theEvent the InternalEvent
     */
    public Relevance( OclStatement theStmt, InternalEvent theEvent ) {

        this.stmt = theStmt;
        this.event = theEvent;
    }

    /**
     * @return Returns the event.
     */
    public InternalEvent getEvent( ) {

        return this.event;
    }

    /**
     * Returns the kind of this relevance object. Kind can be Instance or CLASS
     * 
     * @return Returns the kind.
     */
    public ExpressionKind getKind( ) {

        return this.kind;
    }

    /**
     * @return Returns the navigation paths.
     */
    public Set<NavigationPath> getNavigationPaths( ) {

        return this.navigationPaths;
    }

    /**
     * @return Returns the stmt.
     */
    public OclStatement getStmt( ) {

        return this.stmt;
    }

    /**
     * Sets the kind of this relevance. Kind can be INSTANCE or CLASS. Once set
     * to CLASS it cannot be set to INSTANCE anymore. Setting to CLASS causes
     * the navigation paths to be deleted because they are irrelevant.
     * 
     * @param theKind The kind to set.
     */
    public void setKind( ExpressionKind theKind ) {

        // once set to CLASS it cannot be changed anymore.
        if ( this.kind == ExpressionKind.CLASS )
            return;
        // changing to CLASS
        if ( theKind == ExpressionKind.CLASS ) {
            // navigation paths are irrelevant now!
            this.navigationPaths.clear( );
        }
        this.kind = theKind;
    }

    /**
     * Adds NavigationPath <tt>navPath</tt> to the set of NaviagationPaths.
     * 
     * @param navPath the NavigationPath to add
     */
    public void addNavPath( NavigationPath navPath ) {

        this.navigationPaths.add( navPath );
        if ( this.kind == ExpressionKind.CLASS ) {
            // $JL-EXC$ TODO logging?
        }
    }

    /**
     * Creates an OclExpressions which evaluate to the set of instances for
     * which statement must be evaluated.
     * 
     * @param context context
     * @param jmiCreator {@link MoinJmiCreator}
     * @return Collection of OclStatements which evaluate to the set of
     * instances for which statement must be evaluated.
     */
    public Set<OclStatement> turnIntoOcl( RefObject context, MoinJmiCreator jmiCreator ) {

        Set<OclStatement> navPaths = new HashSet<OclStatement>( );

        if ( this.kind == ExpressionKind.CLASS ) {
            // return allInstances()
            RefObject resContext = this.stmt.getContext( );
            RefObject classifierContext = this.stmt.getContext( );
            // make sure we get the Classifier and not just the class proxy
            if ( !( classifierContext instanceof Classifier ) ) {
                classifierContext = classifierContext.refMetaObject( );
            }
            try {
                OclExpression allInstances = createAllInstancesExp( (Classifier) classifierContext, jmiCreator );
                navPaths.add( new OclStatementImpl( resContext, allInstances, OclStatement.EXPRESSION, OclConstants.OP_ALLINSTANCES ) );
            } catch ( OclSemanticException e ) {
                throw new MoinLocalizedBaseRuntimeException( e );
            }

        } else if ( this.kind == ExpressionKind.INSTANCE ) {
            try {
                // create a union of the collections returned by each path
                RefObject resContext = context;
                // make sure we get the Classifier and not just the proxy
                RefObject stmtContext = this.stmt.getContext( );
                if ( !( stmtContext instanceof Classifier ) ) {
                    stmtContext = stmtContext.refMetaObject( );
                }

                VariableDeclaration self = jmiCreator.createVariableDeclaration( OclConstants.VAR_SELF, (Classifier) context, null );

                for ( NavigationPath navPath : this.navigationPaths ) {
                    navPaths.add( new OclStatementImpl( resContext, navPath.turnIntoOcl( self, jmiCreator ), OclStatement.EXPRESSION, "instance" ) ); //$NON-NLS-1$
                }
            } catch ( OclSemanticException e ) {
                throw new MoinLocalizedBaseRuntimeException( e );
            }
        }
        return navPaths;
    }

    /**
     * Creates the initial OCL Statement which then evaluates to the set of
     * relevant instances. The initial OCL Statement is
     * <tt>let relInstances:Set(&lt;context&gt;) = Set{} in relInstances</tt>.
     * We need to do that because we might run into the following problem if we
     * don't: context is of type T and has a subtype T'. Imagine the first
     * navigation path results in Set(T'). It would not be possible to add any
     * instances of type T since T does not conform to T' (T' conforms to T!).
     * Having defined a variable of type Set(T) we can add any subtype of T to
     * it.
     * 
     * @param context the type of the context
     * @param jmiCreator the JmiCreator used to create OCL ASTs
     * @return a LetExp
     * @throws OclSemanticException
     */
    // private LetExp createInitialExp(Classifier context, JmiCreator jmiCreator)
    // throws OclSemanticException {
    // // type of the variable
    // SetType setType = jmiCreator.createSetType(context);
    // // the empty collection literal
    // CollectionLiteralExp emptySet =
    // jmiCreator.createCollectionLiteralExp(setType,
    // new Vector<CollectionLiteralPart>());
    // // define variable "relInstances"
    // VariableDeclaration relInstances =
    // jmiCreator.createVariableDeclaration("relInstances", setType, emptySet);
    // LetExp initialExp = jmiCreator.createLetExp(relInstances);
    //
    // return initialExp;
    // }
    /**
     * Appends another <tt>union()</tt> or <tt>including()</tt> to
     * <tt>source</tt>. e.g.: <tt>source.union(exp2)</tt>
     * 
     * @param source
     * @param exp2
     * @param jmiCreator
     * @return an OperationCallExp representing a <tt>union</tt> of
     * <tt>source</tt> and <tt>exp2</tt>
     * @throws OclSemanticException
     */
    // private OclExpression append(OclExpression source, OclExpression exp2,
    // JmiCreator jmiCreator)
    // throws OclSemanticException {
    // OclExpression res;
    // if (source == null) {
    // return exp2;
    // }
    // Classifier argType = exp2.getType();
    // OclExpression second;
    // if (argType instanceof CollectionType) {
    // // the argument is already a CollectionType
    // if (!(argType instanceof SetType)) {
    // // the argument is not a Set
    // // convert it!
    // second = asSet(exp2, jmiCreator);
    // } else {
    // // it is a set, so there is nothing to convert
    // second = exp2;
    // }
    // res = union(source, second, jmiCreator);
    // } else {
    // // the argument is a simple type
    // // we have to use including() instead of union()
    // res = including(source, exp2, jmiCreator);
    // }
    //
    // return res;
    // }
    /**
     * Creates an <tt>including</tt> OperationCallExp
     * 
     * @param source the source of the OperationCallExp
     * @param exp1 the element to include
     * @param jmiCreator the JmiCreator to create JMI instances
     * @return an <tt>including</tt> OperationCallExp
     * @throws OclSemanticException
     */
    // private OclExpression including(OclExpression source, OclExpression exp1,
    // JmiCreator jmiCreator)
    // throws OclSemanticException {
    // Operation including = jmiCreator.getStdLibraryOperation("SetType",
    // "including");
    // OperationCallExp asSetCall = jmiCreator.createOperationCallExp(including,
    // source, exp1);
    // return asSetCall;
    // }
    /**
     * Creates a "union" operationCallExp
     * 
     * @param source the source for the OperationCallExp
     * @param argument the argument of the OperationCallExp
     * @param jmiCreator
     * @return an OperationCallExp representing a <tt>union</tt> of
     * <tt>source</tt> and <tt>exp2</tt>
     * @throws OclSemanticException
     */
    // private OclExpression union(OclExpression source, OclExpression argument,
    // JmiCreator jmiCreator)
    // throws OclSemanticException {
    // // create a union operation
    // Operation union = jmiCreator.getStdLibraryOperation("SetType","union");
    // OperationCallExp unionCall = jmiCreator.createOperationCallExp(union, source,
    // argument);
    // return unionCall;
    // }
    //
    // /**
    // * @param exp1
    // * @param jmiCreator
    // * @return the converted expression
    // * @throws OclSemanticException
    // */
    // private OclExpression asSet(OclExpression exp1, JmiCreator jmiCreator) throws
    // OclSemanticException {
    // Operation asSet = jmiCreator.getStdLibraryOperation("OclAny","asSet");
    // OperationCallExp asSetCall = jmiCreator.createOperationCallExp(asSet, exp1);
    // return asSetCall;
    // }
    /**
     * Creates a <tt>&lt;context&gt;.allInstances()</tt> expression
     * 
     * @param context
     * @param jmiCreator
     * @return a OCL expression representing a <tt>allInstances()</tt> call to
     * <tt>context</tt>
     * @throws OclSemanticException
     */
    private OclExpression createAllInstancesExp( Classifier context, MoinJmiCreator jmiCreator ) throws OclSemanticException {

        TypeExp contextType = jmiCreator.createTypeExp( context );
        jmiCreator.createSetType( context );
        Operation allInstances = jmiCreator.getStdLibraryOperation( OclConstants.T_OCLTYPESTDLIB, OclConstants.OP_ALLINSTANCES );
        OperationCallExp allInstancesCall = jmiCreator.createOperationCallExp( allInstances, contextType );
        return allInstancesCall;
    }

    /**
     * @return the equality
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object arg0 ) {

        if ( arg0 instanceof Relevance ) {
            Relevance rel = (Relevance) arg0;
            if ( this.kind != rel.getKind( ) ) {
                return false;
            }
            if ( !this.event.equals( rel.getEvent( ) ) ) {
                return false;
            }
            if ( !this.stmt.equals( rel.getStmt( ) ) ) {
                return false;
            }
            if ( !this.navigationPaths.equals( rel.getNavigationPaths( ) ) ) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * @return the Hash
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        // the hashCode is determined by xor-ing the hashCodes of event, kind,
        // navigationPaths and stmt
        int code = this.event.hashCode( );
        code = code ^ this.kind.hashCode( );
        code = code ^ this.navigationPaths.hashCode( );
        code = code ^ this.stmt.hashCode( );
        return code;
    }

    /**
     * @return the String representation
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return OclConstants.BRACKETLEFT + this.stmt.getName( ) + ", " + this.event.toString( ) + ", " + this.kind.toString( ) + OclConstants.BRACKETRIGHT + "\n" + this.navigationPaths.toString( ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
    }
}