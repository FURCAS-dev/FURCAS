package de.hpi.sam.bp2009.moin.impactAnalyzer.expressions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.LoopExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;

import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.relevance.NavigationPath;
import com.sap.tc.moin.ocl.ia.relevance.Relevance;
import com.sap.tc.moin.ocl.ia.relevance.RelevanceFactory;
import com.sap.tc.moin.ocl.ia.tag.ExpressionKind;
import com.sap.tc.moin.ocl.ia.tag.NodeTag;
import com.sap.tc.moin.ocl.ia.tag.NodeTagFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Sub expressions identify parts of an OclExpression which contain navigation starting with self, an iterator variable,
 * operation parameter, literal or allInstances() and ending with an operation returning a primitive type or with a node
 * being the body of a LoopExp.
 * <p>
 * Sub classes of this class model direct sub expressions (i.e. starting with self or allInstance()) and indirect sub
 * expressions (i.e. starting with a iterator variable) Sub expressions can have a kind (i.e. CLASS or INSTANCE). They
 * are of kind CLASS if they contain a call to allInstances() and else of kind INSTANCE. Furthermore sub expressions can
 * have a number of children (i.e. indirect sub expressions).
 */
public abstract class SubExpression {

    /**
     * The set of children of this sub expression.
     */
    private Set<SubExpression> childSubExp = new HashSet<SubExpression>( );

    /**
     * the nodes of the OCL AST which make up this sub expression
     */
    private List<OclExpression> expressionParts = new Vector<OclExpression>( );

    /**
     * The kind of this sub expression. Can be INSTANCE or CLASS
     */
    private ExpressionKind kind = ExpressionKind.INSTANCE;

    /**
     * the OclStatement to which this sub expression belongs to
     */
    private final OclStatement statement;

    protected CoreConnection connection;

    /**
     * Creates a new SubExpression
     * 
     * @param actConnection {@link CoreConnection}
     * @param theStatement the OclStatement to which this sub expression belongs
     * to.
     */
    public SubExpression( CoreConnection actConnection, OclStatement theStatement ) {

        this.connection = actConnection;
        this.statement = theStatement;
    }

    /**
     * @return Returns the set of child sub expressions.
     */
    public Set<SubExpression> getChildSubExp( ) {

        return this.childSubExp;
    }

    /**
     * @return Returns the expressionParts.
     */
    public List<OclExpression> getExpressionParts( ) {

        return this.expressionParts;
    }

    /**
     * Sets the kind of a sub expression recursively. Once set to CLASS it
     * cannot be set to INSTANCE.
     * 
     * @param theKind the kind of this sub expression {CLASS, INSTANCE}
     */
    public void setKind( ExpressionKind theKind ) {

        // once a class sub expression always a class sub expression
        if ( this.kind != ExpressionKind.CLASS ) {
            this.kind = theKind;
        }
        // propagate the new kind down to the child sub expressions
        for ( Iterator<SubExpression> i = this.getChildSubExp( ).iterator( ); i.hasNext( ); ) {
            SubExpression subExp = i.next( );
            subExp.setKind( theKind );
        }
    }

    /**
     * @return Returns the kind.
     */
    public ExpressionKind getKind( ) {

        return this.kind;
    }

    /**
     * @return Returns the statement.
     */
    public OclStatement getStatement( ) {

        return this.statement;
    }

    /**
     * Builds up a set of navigation paths for each tuple (OclStatement,
     * InternalEvent). Relevance implements that tuple.
     * 
     * @param relFactory the factory to get Relevance instances from
     * @param tagFactory the factory to get NodeTags form
     */
    public void identifyNavPaths( RelevanceFactory relFactory, NodeTagFactory tagFactory ) {

        Set<NavigationPath> navPaths = new HashSet<NavigationPath>( );
        navPaths.add( new NavigationPath( ) );
        this.identifyNavPaths( relFactory, tagFactory, navPaths );
    }

    /**
     * Builds up a set of navigation paths for each tuple (OclStatement,
     * InternalEvent). Relevance implements that tuple.
     * 
     * @param relFactory the factory to get Relevance instances from
     * @param tagFactory the factory to get NodeTags form
     * @param navPaths the navigation paths of a previous sub expression.
     * @return the navigation paths
     */
    Set<NavigationPath> identifyNavPaths( RelevanceFactory relFactory, NodeTagFactory tagFactory, Set<NavigationPath> navPaths ) {

        //        NavigationPath navPath = new NavigationPath();
        // go through all nodes of this sub expression
        for ( OclExpression node : this.getExpressionParts( ) ) {

            NodeTag tag = tagFactory.getTag( node );

            // for each node go through the set of relevant events
            for ( InternalEvent ev : tag.getEvents( ) ) {
                addRelevance( navPaths, ev, relFactory );
            }

            if ( node instanceof LoopExp ) {
                LoopExp loop = (LoopExp) node;
                if ( loop.getName( ).equals( "collect" ) || loop.getName( ).equals( "iterate" ) ) { //$NON-NLS-1$//$NON-NLS-2$
                    // if we have a "collect" or an "iterate" LoopExp we have to
                    // append the navigation path of its body

                    navPaths = recurseIntoChildSubExp( (LoopExp) node, navPaths, relFactory, tagFactory );
                } else {
                    // descent into INDIRECT sub expressions
                    recurseIntoChildSubExp( (LoopExp) node, navPaths, relFactory, tagFactory );
                }
            }

            // build up navigation path
            if ( this.getKind( ) == ExpressionKind.INSTANCE ) {
                buildUpNavigationPath( navPaths, node );
            }

        }
        // return the complete navigation path
        return navPaths;
    }

    /**
     * Builds up the navigation paths
     * 
     * @param navPaths the current navigation paths
     * @param node the node to append
     */
    private void buildUpNavigationPath( Set<NavigationPath> navPaths, OclExpression node ) {

        // the navigation path is only relevant for instance sub
        // expressions.
        // build up navigation path

        // add the current node to all navigation paths
        for ( Iterator<NavigationPath> i = navPaths.iterator( ); i.hasNext( ); ) {
            NavigationPath navPath = i.next( );
            if ( node instanceof AssociationEndCallExp ) {
                navPath.add( ( (AssociationEndCallExpInternal) node ).getReferredAssociationEnd( this.connection ) );
            } else if ( node instanceof AttributeCallExp ) {
                navPath.add( ( (AttributeCallExpInternal) node ).getReferredAttribute( this.connection ) );
            }
            //            else if (node instanceof OperationCallExp
            //                    && ((OperationCallExp) node).getReferredOperation()
            //                            .getName().equals("oclAsType")) {
            //                navPath.add(((OperationCallExp) node).getReferredOperation());
            //            }
        }
    }

    /**
     * Recurses into possible child sub expressions. There is something nasty
     * about a special kind of sub expressions. With "collect" and "iterate" it
     * is possible to have an actual navigation in the body which effects all
     * subsequent navigations after the "collect" or "iterate". The problem
     * there is that they can cause to split the navigation paths.
     * <p>
     * Example:
     * 
     * <pre>
     * ...-&gt;collect(d:Department | d.employee-&gt;union(d.boss)).salary-&gt;sum()
     * </pre>
     * There are now two sub expressions :<tt>d.employee</tt> and
     * <tt>d.boss</tt>. Coming to <tt>salary</tt> we do not know how we got
     * there. We could have reached <tt>salary</tt> via <tt>d.employee</tt> or
     * <tt>d.boss</tt>. Therefore we have to consider both which leads to a
     * splitting of all navigation paths after the <tt>collect</tt> or
     * <tt>iterate</tt>. That's why there is a set of navigation paths. This
     * affects most of the other methods in this class.
     * 
     * @param node
     * @param navPaths
     * @param relFactory
     * @param tagFactory
     * @return Set of navigation paths
     */
    private Set<NavigationPath> recurseIntoChildSubExp( LoopExp node, Set<NavigationPath> navPaths, RelevanceFactory relFactory, NodeTagFactory tagFactory ) {

        Set<NavigationPath> newNavPaths = new HashSet<NavigationPath>( );
        for ( Iterator<SubExpression> j = this.childSubExp.iterator( ); j.hasNext( ); ) {
            IndirectSubExpression iSubExp = (IndirectSubExpression) j.next( );
            // only descent into indirect sub expressions
            // which are children of this sub expression!!!
            if ( iSubExp.isChildOf( node ) ) {
                // create a copy of all navigation path so we don't change
                // the existing paths
                Set<NavigationPath> subNavPaths = new HashSet<NavigationPath>( );
                for ( Iterator<NavigationPath> i = navPaths.iterator( ); i.hasNext( ); ) {
                    NavigationPath navPath = i.next( );
                    NavigationPath subNavPath = new NavigationPath( );
                    subNavPath.addAll( navPath.getPath( ) );
                    subNavPaths.add( subNavPath );
                }
                // descent into child sub expression
                Set<NavigationPath> np = iSubExp.identifyNavPaths( relFactory, tagFactory, subNavPaths );
                newNavPaths.addAll( np );
            }
        }
        return newNavPaths;
    }

    /**
     * Add for each event the navigation path to its relevance object.
     * 
     * @param navPaths
     * @param ev
     * @param relFactory
     */
    private void addRelevance( Set<NavigationPath> navPaths, InternalEvent ev, RelevanceFactory relFactory ) {

        Relevance r = relFactory.getRelevance( this.getStatement( ), ev );
        // if relevance is set to CLASS it cannot be changed again.
        if ( r.getKind( ) != ExpressionKind.CLASS ) {
            r.setKind( this.getKind( ) );
        }
        if ( r.getKind( ) == ExpressionKind.INSTANCE ) {
            // make a copy of all current navigation paths
            for ( NavigationPath p : navPaths ) {
                NavigationPath newPath = new NavigationPath( );
                newPath.addAll( p.getPath( ) );
                r.addNavPath( newPath );
            }
        }
    }

    /**
     * @return a deep copy of this SubExpression
     */
    public abstract SubExpression copy( );

    /**
     * Adds a node in the AST to the list of expression parts.
     * 
     * @param node the node to add to the list of expression parts
     */
    public void addExpressionParts( OclExpression node ) {

        this.expressionParts.add( node );
    }

    @Override
    public String toString( ) {

        return "SubExpr for Statement: " + this.statement.toString( ); //$NON-NLS-1$
    }

}