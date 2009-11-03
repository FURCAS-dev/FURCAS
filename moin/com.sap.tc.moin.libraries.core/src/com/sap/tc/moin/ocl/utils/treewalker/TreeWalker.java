package com.sap.tc.moin.ocl.utils.treewalker;

import java.util.Iterator;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.EnumLiteralExp;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionRangeImpl;
import org.omg.ocl.expressions.__impl.IfExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;

import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * This class is an abstract TreeWalker for an OCL-Tree.
 * <p>
 * The TreeWalker traverses the tree in depth first manner. Only nodes in
 * package <tt>org.omg.ocl.expressions</tt> are visited. The visiting algorithm
 * for each node is defined in <tt>visit...()</tt>. See the JavaDoc for each
 * <tt>visit...()</tt> method to see the visiting order of the children.
 * <p>
 * Each <tt>visit...()</tt> method has a corresponding <tt>down...()</tt> and
 * <tt>up...()</tt> method. The <tt>down...()</tt> method is called before any
 * of the node's children have been visited. The <tt>up...()</tt> method is call
 * after all of the node's children have been visited.
 * <p>
 * To use the TreeWalker subclass it and just implement the <tt>up...()</tt> and
 * <tt>down...()</tt> methods of the nodes you are interested in. You don't have
 * to implement all of these methods.
 */
public abstract class TreeWalker {

    protected final CoreConnection connection;

    /**
     * Creates a new TreeWalker
     * 
     * @param actConnection the core connection
     */
    public TreeWalker( CoreConnection actConnection ) {

        this.connection = actConnection;
    }

    /**
     * This is a dispatcher method. For each non-abstract subclass of
     * OclExpression it calls the respective visit method. There is no
     * corresponding <code>down()</code> or <code>up()</code> method.
     * 
     * @param exp the OclExpression to visit
     */
    private void visitOclExpression( OclExpression exp ) {

        if ( exp == null ) {
            return;
        }
        if ( exp instanceof AssociationEndCallExp ) {
            visitAssociationEndCallExp( (AssociationEndCallExp) exp );
        } else if ( exp instanceof AttributeCallExp ) {
            visitAttributeCallExp( (AttributeCallExp) exp );
        } else if ( exp instanceof BooleanLiteralExp ) {
            visitBooleanLiteralExp( (BooleanLiteralExp) exp );
        } else if ( exp instanceof CollectionLiteralExp ) {
            visitCollectionLiteralExp( (CollectionLiteralExp) exp );
        } else if ( exp instanceof EnumLiteralExp ) {
            visitEnumLiteralExp( (EnumLiteralExp) exp );
        } else if ( exp instanceof IfExp ) {
            visitIfExp( (IfExp) exp );
        } else if ( exp instanceof IntegerLiteralExp ) {
            visitIntegerLiteralExp( (IntegerLiteralExp) exp );
        } else if ( exp instanceof IterateExp ) {
            visitIterateExp( (IterateExp) exp );
        } else if ( exp instanceof IteratorExp ) {
            visitIteratorExp( (IteratorExp) exp );
        } else if ( exp instanceof LetExp ) {
            visitLetExp( (LetExp) exp );
        } else if ( exp instanceof OperationCallExp ) {
            visitOperationCallExp( (OperationCallExp) exp );
        } else if ( exp instanceof RealLiteralExp ) {
            visitRealLiteralExp( (RealLiteralExp) exp );
        } else if ( exp instanceof StringLiteralExp ) {
            visitStringLiteralExp( (StringLiteralExp) exp );
        } else if ( exp instanceof TupleLiteralExp ) {
            visitTupleLiteralExp( (TupleLiteralExp) exp );
        } else if ( exp instanceof TypeExp ) {
            visitTypeExp( (TypeExp) exp );
        } else if ( exp instanceof VariableExp ) {
            visitVariableExp( (VariableExp) exp );
        } else {
            // error unknown class
            throw new MoinLocalizedBaseRuntimeException( OclServiceExceptions.NOVISITORFORCLASS, exp.getClass( ).getName( ) );
        }
    }

    /**
     * Starts the traversal of the tree
     * 
     * @param root the root of the OCL AST to walk
     */
    protected void walk( OclExpression root ) {

        visitOclExpression( root );
    }

    /**
     * Implements the visiting algorithm for <code>AssociationEndCallExp</code>.
     * <p>
     * Visiting order:
     * <ul>
     * <li>source</li>
     * </ul>
     * 
     * @param exp the <code>AssociationEndCallExp</code> to visit
     */
    private void visitAssociationEndCallExp( AssociationEndCallExp exp ) {

        if ( exp == null ) {
            return;
        }
        downAssociationEndCallExp( exp );
        visitOclExpression( ( (AssociationEndCallExpInternal) exp ).getSource( this.connection ) );
        upAssociationEndCallExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>AttributeCallExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>source</li>
     * </ul>
     * 
     * @param exp the <code>AttributeCallExp</code> to visit
     */
    private void visitAttributeCallExp( AttributeCallExp exp ) {

        if ( exp == null ) {
            return;
        }
        downAttributeCallExp( exp );
        visitOclExpression( ( (AttributeCallExpInternal) exp ).getSource( this.connection ) );
        upAttributeCallExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>BooleanLiteralExp</code>.
     * <p>
     * Visiting order: This is a leaf-node
     * 
     * @param exp the <code>BooleanLiteralExp</code> to visit
     */
    private void visitBooleanLiteralExp( BooleanLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downBooleanLiteralExp( exp );
        upBooleanLiteralExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>CollectionItem</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>item</li>
     * </ul>
     * 
     * @param item the <code>CollectionItem</code> to visit
     */
    private void visitCollectionItem( CollectionItem item ) {

        if ( item == null ) {
            return;
        }
        downCollectionItem( item );
        visitOclExpression( item.getItem( ) );
        upCollectionItem( item );
    }

    /**
     * Implements the visiting algorithm for <code>CollectionLiteralExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>parts</li>
     * </ul>
     * 
     * @param exp the <code>CollectionLiteralExp</code> to visit
     */
    private void visitCollectionLiteralExp( CollectionLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downCollectionLiteralExp( exp );
        JmiList<CollectionLiteralPart> parts = (JmiList<CollectionLiteralPart>) ( (CollectionLiteralExpImpl) exp ).getParts( this.connection );
        for ( int i = 0, n = parts.size( this.connection.getSession( ) ); i < n; i++ ) {
            visitCollectionLiteralPart( parts.get( this.connection.getSession( ), i ) );
        }
        upCollectionLiteralExp( exp );
    }

    /**
     * This is dispatcher method. It calls visitCollectionItem or
     * visitCollectionRange depending on the concrete type of part. There is no
     * corresponding down or up method.
     * 
     * @param part the CollectionLiteralPart to visit.
     */
    private void visitCollectionLiteralPart( CollectionLiteralPart part ) {

        if ( part == null ) {
            return;
        }
        if ( part instanceof CollectionItem ) {
            visitCollectionItem( (CollectionItem) part );
        } else if ( part instanceof CollectionRange ) {
            visitCollectionRange( (CollectionRange) part );
        }
    }

    /**
     * Implements the visiting algorithm for <code>CollectionRange</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>first</li>
     * <li>last</li>
     * </ul>
     * 
     * @param range the <code>CollectionRange</code> to visit
     */
    private void visitCollectionRange( CollectionRange range ) {

        if ( range == null ) {
            return;
        }
        downCollectionRange( range );
        visitOclExpression( ( (CollectionRangeImpl) range ).getFirst( this.connection ) );
        visitOclExpression( ( (CollectionRangeImpl) range ).getLast( this.connection ) );
        upCollectionRange( range );
    }

    /**
     * Implements the visiting algorithm for <code>EnumLiteralExp</code>.
     * <p>
     * Visiting order: This is a leaf-node.
     * 
     * @param exp the <code>EnumLiteralExp</code> to visit
     */
    private void visitEnumLiteralExp( EnumLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downEnumLiteralExp( exp );
        upEnumLiteralExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>IfExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>condition</li>
     * <li>thenExpression</li>
     * <li>elseExpression</li>
     * </ul>
     * 
     * @param exp the <code>IfExp</code> to visit
     */
    private void visitIfExp( IfExp exp ) {

        if ( exp == null ) {
            return;
        }
        downIfExp( exp );
        visitOclExpression( ( (IfExpImpl) exp ).getCondition( this.connection ) );
        visitOclExpression( ( (IfExpImpl) exp ).getThenExpression( this.connection ) );
        visitOclExpression( ( (IfExpImpl) exp ).getElseExpression( this.connection ) );
        upIfExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>IntegerLiteralExp</code>.
     * <p>
     * Visiting order: This is a leaf node.
     * 
     * @param exp the <code>IntegerLiteralExp</code> to visit
     */
    private void visitIntegerLiteralExp( IntegerLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downIntegerLiteralExp( exp );
        upIntegerLiteralExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>IterateExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>source</li>
     * <li>iterators</li>
     * <li>result</li>
     * <li>body</li>
     * </ul>
     * 
     * @param exp the <code>IterateExp</code> to visit
     */
    private void visitIterateExp( IterateExp exp ) {

        if ( exp == null ) {
            return;
        }
        downIterateExp( exp );
        visitOclExpression( ( (IterateExpImpl) exp ).getSource( this.connection ) );
        for ( Iterator<VariableDeclaration> i = ( (JmiList<VariableDeclaration>) ( (IterateExpImpl) exp ).getIterators( this.connection ) ).iterator( this.connection ); i.hasNext( ); ) {
            visitVariableDeclaration( i.next( ) );
        }
        visitVariableDeclaration( ( (IterateExpImpl) exp ).getResult( this.connection ) );
        visitOclExpression( ( (IterateExpImpl) exp ).getBody( this.connection ) );
        upIterateExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>IteratorExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>source</li>
     * <li>iterators</li>
     * <li>body</li>
     * </ul>
     * 
     * @param exp the <code>IteratorExp</code> to visit
     */
    private void visitIteratorExp( IteratorExp exp ) {

        if ( exp == null ) {
            return;
        }
        downIteratorExp( exp );
        visitOclExpression( ( (IteratorExpImpl) exp ).getSource( this.connection ) );
        for ( Iterator<VariableDeclaration> i = ( (JmiList<VariableDeclaration>) ( (IteratorExpImpl) exp ).getIterators( this.connection ) ).iterator( this.connection ); i.hasNext( ); ) {
            visitVariableDeclaration( i.next( ) );
        }
        visitOclExpression( ( (IteratorExpImpl) exp ).getBody( this.connection ) );
        upIteratorExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>LetExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>variable</li>
     * <li>in</li>
     * </ul>
     * 
     * @param exp the <code>LetExp</code> to visit
     */
    private void visitLetExp( LetExp exp ) {

        if ( exp == null ) {
            return;
        }
        downLetExp( exp );
        visitVariableDeclaration( ( (LetExpImpl) exp ).getVariable( this.connection ) );
        visitOclExpression( ( (LetExpImpl) exp ).getIn( this.connection ) );
        upLetExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>OperationCallExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>source</li>
     * <li>arguments</li>
     * </ul>
     * 
     * @param exp the <code>OperationCallExp</code> to visit
     */
    private void visitOperationCallExp( OperationCallExp exp ) {

        if ( exp == null ) {
            return;
        }
        downOperationCallExp( exp );
        visitOclExpression( ( (OperationCallExpImpl) exp ).getSource( this.connection ) );
        JmiList<OclExpression> args = (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection );
        for ( int i = 0, n = args.size( this.connection.getSession( ) ); i < n; i++ ) {
            visitOclExpression( args.get( this.connection.getSession( ), i ) );
        }
        upOperationCallExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>RealLiteralExp</code>.
     * <p>
     * Visiting order: This is a leaf node.
     * 
     * @param exp the <code>RealLiteralExp</code> to visit
     */
    private void visitRealLiteralExp( RealLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downRealLiteralExp( exp );
        upRealLiteralExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>StringLiteralExp</code>.
     * <p>
     * Visiting order: This is a leaf node
     * 
     * @param exp the <code>StringLiteralExp</code> to visit
     */
    private void visitStringLiteralExp( StringLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downStringLiteralExp( exp );
        upStringLiteralExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>TupleLiteralExp</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>tupleParts</li>
     * </ul>
     * 
     * @param exp the <code>TupleLiteralExp</code> to visit
     */
    private void visitTupleLiteralExp( TupleLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downTupleLiteralExp( exp );
        JmiList<VariableDeclaration> tuplePart = (JmiList<VariableDeclaration>) ( (TupleLiteralExpImpl) exp ).getTuplePart( this.connection );
        for ( Iterator<VariableDeclaration> it = tuplePart.iterator( this.connection ); it.hasNext( ); ) {
            visitVariableDeclaration( it.next( ) );
        }
        upTupleLiteralExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>TypeExp</code>.
     * <p>
     * Visiting order: This is a leaf node.
     * 
     * @param exp the <code>TypeExp</code> to visit
     */
    private void visitTypeExp( TypeExp exp ) {

        if ( exp == null ) {
            return;
        }
        downTypeExp( exp );
        upTypeExp( exp );
    }

    /**
     * Implements the visiting algorithm for <code>VariableDeclaration</code>.
     * <p>
     * Visiting order
     * <ul>
     * <li>initExpression</li>
     * </ul>
     * 
     * @param decl the <code>VariableDeclaration</code> to visit
     */
    private void visitVariableDeclaration( VariableDeclaration decl ) {

        if ( decl == null ) {
            return;
        }
        downVariableDeclaration( decl );
        visitOclExpression( ( (VariableDeclarationImpl) decl ).getInitExpression( this.connection ) );
        upVariableDeclaration( decl );
    }

    /**
     * Implements the visiting algorithm for <code>VariableExp</code>.
     * <p>
     * Visiting order none
     * 
     * @param exp the <code>VariableExp</code> to visit
     */
    private void visitVariableExp( VariableExp exp ) {

        if ( exp == null ) {
            return;
        }
        downVariableExp( exp );
        // visitVariableDeclaration(exp.getReferredVariable());
        upVariableExp( exp );
    }

    /*
     * Methods called on the way down. the default implementation is empty.
     */

    /**
     * @param exp
     */
    protected void downAssociationEndCallExp( AssociationEndCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downAttributeCallExp( AttributeCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downBooleanLiteralExp( BooleanLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param item
     */
    protected void downCollectionItem( CollectionItem item ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downCollectionLiteralExp( CollectionLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param range
     */
    protected void downCollectionRange( CollectionRange range ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downEnumLiteralExp( EnumLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downIfExp( IfExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downIntegerLiteralExp( IntegerLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downIterateExp( IterateExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downIteratorExp( IteratorExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downLetExp( LetExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downOclExpression( OclExpression exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downOperationCallExp( OperationCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downRealLiteralExp( RealLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downStringLiteralExp( StringLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downTupleLiteralExp( TupleLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downTypeExp( TypeExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param decl
     */
    protected void downVariableDeclaration( VariableDeclaration decl ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downVariableExp( VariableExp exp ) {

        // to be implemented by subclasses
    }

    /*
     * Methodes called on the way up. The default implementation is empty.
     */

    /**
     * @param exp
     */
    protected void upAssociationEndCallExp( AssociationEndCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upAttributeCallExp( AttributeCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upBooleanLiteralExp( BooleanLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param item
     */
    protected void upCollectionItem( CollectionItem item ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upCollectionLiteralExp( CollectionLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param range
     */
    protected void upCollectionRange( CollectionRange range ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upEnumLiteralExp( EnumLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upIfExp( IfExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upIntegerLiteralExp( IntegerLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upIterateExp( IterateExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upIteratorExp( IteratorExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upLetExp( LetExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upOclExpression( OclExpression exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upOperationCallExp( OperationCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upRealLiteralExp( RealLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upStringLiteralExp( StringLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upTupleLiteralExp( TupleLiteralExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upTypeExp( TypeExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param decl
     */
    protected void upVariableDeclaration( VariableDeclaration decl ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upVariableExp( VariableExp exp ) {

        // to be implemented by subclasses
    }
}