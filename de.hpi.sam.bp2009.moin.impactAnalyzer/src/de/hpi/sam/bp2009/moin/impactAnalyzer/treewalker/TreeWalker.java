package de.hpi.sam.bp2009.moin.impactAnalyzer.treewalker;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionLiteralPart;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.impl.CollectionLiteralExpImpl;
import org.eclipse.ocl.ecore.impl.CollectionRangeImpl;
import org.eclipse.ocl.ecore.impl.IfExpImpl;
import org.eclipse.ocl.ecore.impl.IterateExpImpl;
import org.eclipse.ocl.ecore.impl.IteratorExpImpl;
import org.eclipse.ocl.ecore.impl.LetExpImpl;
import org.eclipse.ocl.ecore.impl.NavigationCallExpImpl;
import org.eclipse.ocl.ecore.impl.OperationCallExpImpl;
import org.eclipse.ocl.ecore.impl.PropertyCallExpImpl;
import org.eclipse.ocl.ecore.impl.TupleLiteralExpImpl;
import org.eclipse.ocl.expressions.TupleLiteralPart;

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


    /**
     * Creates a new TreeWalker
     *
     */
    public TreeWalker( ) {
    }

    /**
     * This is a dispatcher method. For each non-abstract subclass of
     * OclExpression it calls the respective visit method. There is no
     * corresponding <code>down()</code> or <code>up()</code> method.
     * 
     * @param exp the OclExpression to visit
     */
    private void visitOclExpression( OCLExpression exp ) {

        if ( exp == null ) {
            return;
        }
        if ( exp instanceof NavigationCallExp ) {
            visitAssociationEndCallExp( (NavigationCallExpImpl) exp );
        } else if ( exp instanceof PropertyCallExp ) {
            visitAttributeCallExp( (PropertyCallExp) exp );
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
        	//TODO think of a useful error message
            //throw new MoinLocalizedBaseRuntimeException( OclServiceExceptions.NOVISITORFORCLASS, exp.getClass( ).getName( ) );
        	throw new RuntimeException("No visitor for class " + exp);
        }
    }

    /**
     * Starts the traversal of the tree
     * 
     * @param root the root of the OCL AST to walk
     */
    protected void walk( OCLExpression root ) {

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
    private void visitAssociationEndCallExp( NavigationCallExp exp ) {

        if ( exp == null ) {
            return;
        }
        downAssociationEndCallExp( exp );
        visitOclExpression( (OCLExpression) ( (NavigationCallExpImpl) exp ).getSource( ) );
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
    private void visitAttributeCallExp( PropertyCallExp exp ) {

        if ( exp == null ) {
            return;
        }
        downAttributeCallExp( exp );
        visitOclExpression( (OCLExpression) ( (PropertyCallExpImpl) exp ).getSource( ) );
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
        visitOclExpression( (OCLExpression) item.getItem( ) );
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
        EList<org.eclipse.ocl.expressions.CollectionLiteralPart<EClassifier>> parts = ( (CollectionLiteralExpImpl) exp ).getPart( ) ;
        for ( int i = 0; i < parts.size(); i++ ) {
            visitCollectionLiteralPart( (CollectionLiteralPart) parts.get( i ) );
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
        visitOclExpression( (OCLExpression) ( (CollectionRangeImpl) range ).getFirst(  ) );
        visitOclExpression( (OCLExpression) ( (CollectionRangeImpl) range ).getLast(  ) );
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
        visitOclExpression( (OCLExpression) ( (IfExpImpl) exp ).getCondition(  ) );
        visitOclExpression( (OCLExpression) ( (IfExpImpl) exp ).getThenExpression(  ) );
        visitOclExpression( (OCLExpression) ( (IfExpImpl) exp ).getElseExpression(  ) );
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
        visitOclExpression( (OCLExpression) ( (IterateExpImpl) exp ).getSource(  ) );
        EList<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>> iterator = ( (IterateExpImpl) exp ).getIterator( );
        for (int i = 0; i < iterator.size(); i++ ) {
            visitVariableDeclaration( (Variable) iterator.get(i) );
        }
        visitVariableDeclaration( exp.getResult(  ) );
        visitOclExpression( (OCLExpression) ( (IterateExpImpl) exp ).getBody(  ) );
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
        visitOclExpression( (OCLExpression) ( (IteratorExpImpl) exp ).getSource( ) );
        EList<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>> iterator = ( (IteratorExpImpl) exp ).getIterator(  );
        for ( int i = 0; i < iterator.size(); i++ ) {
            visitVariableDeclaration( iterator.get(i) );
        }
        visitOclExpression( (OCLExpression) ( (IteratorExpImpl) exp ).getBody( ) );
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
        visitVariableDeclaration( exp.getVariable( ) );
        visitOclExpression( (OCLExpression) ( (LetExpImpl) exp ).getIn( ) );
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
        visitOclExpression( (OCLExpression) ( (OperationCallExpImpl) exp ).getSource( ) );
        EList<org.eclipse.ocl.expressions.OCLExpression<EClassifier>> args = ( (OperationCallExpImpl) exp ).getArgument( );
        for ( int i = 0, n = args.size( ); i < n; i++ ) {
            visitOclExpression( (OCLExpression) args.get( i ) );
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
    @SuppressWarnings("unchecked")
	private void visitTupleLiteralExp( TupleLiteralExp exp ) {

        if ( exp == null ) {
            return;
        }
        downTupleLiteralExp( exp );
        EList<TupleLiteralPart<EClassifier, EStructuralFeature>> tuplePart = ( (TupleLiteralExpImpl) exp ).getPart( ) ;
        for ( int  i = 0; i < tuplePart.size(); i++ ) {
            visitVariableDeclaration(  (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>) tuplePart.get(i) );
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
   
	@SuppressWarnings("rawtypes")
	private void visitVariableDeclaration( org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> decl ) {

        if ( decl == null ) {
            return;
        }
        downVariableDeclaration( decl );
        visitOclExpression( (OCLExpression) (  (Variable) decl ).getInitExpression(  ) );
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
    protected void downAssociationEndCallExp( NavigationCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void downAttributeCallExp( PropertyCallExp exp ) {

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
    protected void downOclExpression( OCLExpression exp ) {

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
    protected void downVariableDeclaration( org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> decl ) {

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
    protected void upAssociationEndCallExp( NavigationCallExp exp ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upAttributeCallExp( PropertyCallExp exp ) {

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
    protected void upOclExpression( OCLExpression exp ) {

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
	protected void upVariableDeclaration( org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> decl ) {

        // to be implemented by subclasses
    }

    /**
     * @param exp
     */
    protected void upVariableExp( VariableExp exp ) {

        // to be implemented by subclasses
    }
}