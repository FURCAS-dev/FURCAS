package com.sap.tc.moin.ocl.utils.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceImpl;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionKindEnum;
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
import org.omg.ocl.expressions.PropertyCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.CollectionItemImpl;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionRangeImpl;
import org.omg.ocl.expressions.__impl.EnumLiteralExpImpl;
import org.omg.ocl.expressions.__impl.IfExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.PropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableExpImpl;
import org.omg.ocl.types.CollectionType;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.treewalker.TreeWalker;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * This class walks an OCL-tree and creates a semantically equivalent textual
 * representation of it. Do not use this class directly. Use OclSerializer
 * instead.
 */
class Ocl2TextTW extends TreeWalker {

    /**
     * Maps from AST node to serialization
     */
    private Map<Object, String> nodeToString = new HashMap<Object, String>( );

    /**
     * A list of type used to print package local type names
     */
    private List<List<String>> packageNames = new ArrayList<List<String>>( );

    /**
     * The serialization helper
     */
    private final SerializationHelper mySerializationHelper = new SerializationHelper( );
    
    /**
     * If non-<tt>null</tt>, highlight occurrences of this expression by prefixing and
     * postfixing with "^^^".
     */
    private final OclExpression highlight;

    /**
     * Attaches a String to a node
     * 
     * @param node
     * @param s
     */
    protected void setString( Object node, String s ) {

        this.nodeToString.put( node, s );
    }

    /**
     * returns a String which has been attached to the node
     * 
     * @param node
     * @return a String or <tt>null</tt>
     */
    protected String getString( Object node ) {
	StringBuilder result = new StringBuilder();
	boolean doHighlight = (highlight != null && node.equals(highlight));
	if (doHighlight) {
	    result.append(">>>");
	}
        result.append(this.nodeToString.get( node ));
	if (doHighlight) {
	    result.append("<<<");
	}
	return result.toString();
    }

    public Ocl2TextTW( CoreConnection actConnection, MofPackage mp ) {
	this(actConnection, /* highlight */ null, mp);
    }
    
    /**
     * @param actConnection the core connection
     * @param mp the MofPackage
     */
    public Ocl2TextTW( CoreConnection actConnection, OclExpression highlight, MofPackage mp ) {

        super( actConnection );
        if ( mp != null ) {
            this.packageNames.add( ( (MofPackageImpl) mp ).getQualifiedName( actConnection ) );
        }
        this.highlight = highlight;
    }

    public Ocl2TextTW( CoreConnection actConnection, MofPackage[] mp ) {
	this(actConnection, /* highlight */ null, mp);
    }
    
    /**
     * @param actConnection the core connection
     * @param mp the packages
     */
    public Ocl2TextTW( CoreConnection actConnection, OclExpression highlight, MofPackage[] mp ) {

        super( actConnection );
        for ( int i = 0; i < mp.length; i++ ) {
            this.packageNames.add( ( (MofPackageImpl) mp[i] ).getQualifiedName( actConnection ) );
        }
        this.highlight = highlight;
    }

    /**
     * Starts the transformation.
     * 
     * @param root the root of the OCL AST to transform
     * @return a textual representation of the OclExpression starting with
     * <tt>root</tt>
     */
    public String transformToText( OclExpression root ) {

        walk( root );
        return getString( root );
    }

    @Override
    protected void upAssociationEndCallExp( AssociationEndCallExp exp ) {

        String s = OclConstants.EMPTY;
        String atPre = OclConstants.EMPTY;
        if ( isMarkedAtPre( exp ) ) {
            atPre = OclConstants.ATPRE;
        }
        OclExpression source = ( (AssociationEndCallExpImpl) exp ).getSource( this.connection );
        AssociationEnd referredAssociationEnd = ( (AssociationEndCallExpImpl) exp ).getReferredAssociationEnd( this.connection );
        if ( source instanceof VariableExp ) {
            VariableExpImpl var = (VariableExpImpl) source;
            // implicit variables have "" as name
            if ( var.getReferredVariable( this.connection ).getVarName( ).equals( OclConstants.EMPTY ) ) {
                // omit variable name and dot
                s = referredAssociationEnd.getName( ) + atPre + getAssociationQualifier( source, referredAssociationEnd );
            } else {
                s = getString( source ) + OclConstants.DOT + referredAssociationEnd.getName( ) + atPre + getAssociationQualifier( source, referredAssociationEnd );
            }
        } else {
            s = getString( source ) + OclConstants.DOT + referredAssociationEnd.getName( ) + atPre + getAssociationQualifier( source, referredAssociationEnd );
        }

        setString( exp, s );
    }

    /**
     * Creates an association qualifier (i.e. '[' + assoc.getQualifiedName() +
     * ']') if necessary. A qualifier is necessary if there is no reference to
     * the AssociationEnd and the name of the associationEnd is ambiguous.
     * 
     * @param exp the AssociationCallExp
     * @return an empty String or an Association Qualifier
     */
    private String getAssociationQualifier( OclExpression source, AssociationEnd assocEnd ) {

        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
        AssociationImpl assoc = (AssociationImpl) ( (AssociationEndImpl) assocEnd ).refImmediateComposite( this.connection.getSession( ) );
        SpiJmiHelper jmiHelper = this.connection.getCoreJmiHelper( );
        // maybe assocEnd used in a reference?
        List<Reference> references = jmiHelper.getReferences( this.connection.getSession( ), (MofClass) sourceType, true );
        for ( Iterator<Reference> i = references.iterator( ); i.hasNext( ); ) {
            ReferenceImpl r = (ReferenceImpl) i.next( );
            if ( r.getReferencedEnd( this.connection ).equals( assocEnd ) ) {
                // the association end is accessible via a reference
                // we don't need a qualifier
                return OclConstants.EMPTY;
            }

        }
        // no reference to the association end found
        Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( this.connection.getSession( ), sourceType, true );
        AssociationEnd alternativeEnd = null;
        for ( Iterator<AssociationEnd> i = associationEnds.iterator( ); i.hasNext( ); ) {
            AssociationEnd a = ( (AssociationEndImpl) ( i.next( ) ) ).otherEnd( this.connection );
            // check for ambiguous names of AssociationEnds
            if ( a.getName( ).equals( assocEnd.getName( ) ) && alternativeEnd != null ) {
                // found another association end with the same name!
                // we need the association qualifier
                return "[" + qNameToString( assoc.getQualifiedName( this.connection ) ) + "]"; //$NON-NLS-1$ //$NON-NLS-2$
            } else if ( a.getName( ).equals( assocEnd.getName( ) ) ) {
                alternativeEnd = a;
            }
        }
        // haven't found another association end with the same name
        // we don't need an association qualifier
        return OclConstants.EMPTY;
    }

    @Override
    protected void upAttributeCallExp( AttributeCallExp exp ) {

        String s = OclConstants.EMPTY;
        String atPre = OclConstants.EMPTY;
        if ( isMarkedAtPre( exp ) ) {
            atPre = OclConstants.ATPRE;
        }
        OclExpression source = ( (AttributeCallExpImpl) exp ).getSource( this.connection );
        if ( source instanceof VariableExp ) {
            VariableExpImpl var = (VariableExpImpl) source;
            // implicit variables have "" as name
            if ( var.getReferredVariable( this.connection ).getVarName( ).equals( OclConstants.EMPTY ) ) {
                // omit variable name and dot
                s = ( (AttributeCallExpImpl) exp ).getReferredAttribute( this.connection ).getName( ) + atPre;
            } else {
                s = getString( source ) + OclConstants.DOT + ( (AttributeCallExpImpl) exp ).getReferredAttribute( this.connection ).getName( ) + atPre;
            }
        } else {
            s = getString( source ) + OclConstants.DOT + ( (AttributeCallExpImpl) exp ).getReferredAttribute( this.connection ).getName( ) + atPre;
        }
        setString( exp, s );
    }

    /**
     * Checks whether a OclExpression is marked with atPre
     * 
     * @param exp
     * @return true if the expression is marked with atPre
     */
    private boolean isMarkedAtPre( PropertyCallExp exp ) {

        OclExpression source = ( (PropertyCallExpInternal) exp ).getSource( this.connection );
        if ( source instanceof OperationCallExp ) {
            Operation op = ( (OperationCallExpImpl) source ).getReferredOperation( this.connection );
            if ( op.getName( ).equals( OclConstants.OP_ATRPRE ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void upBooleanLiteralExp( BooleanLiteralExp exp ) {

        String s = Boolean.toString( exp.isBooleanSymbol( ) );
        setString( exp, s );
    }

    @Override
    protected void upCollectionItem( CollectionItem item ) {

        String s = getString( ( (CollectionItemImpl) item ).getItem( this.connection ) );
        setString( item, s );
    }

    @Override
    protected void upCollectionLiteralExp( CollectionLiteralExp exp ) {

        String s;

        if ( exp.getKind( ) == CollectionKindEnum.BAG ) {
            s = "Bag"; //$NON-NLS-1$
        } else if ( exp.getKind( ) == CollectionKindEnum.COLLECTION ) {
            s = "Collection"; //$NON-NLS-1$
        } else if ( exp.getKind( ) == CollectionKindEnum.ORDERED_SET ) {
            s = "OrderedSet"; //$NON-NLS-1$
        } else if ( exp.getKind( ) == CollectionKindEnum.SEQUENCE ) {
            s = "Sequence"; //$NON-NLS-1$
        } else if ( exp.getKind( ) == CollectionKindEnum.SET ) {
            s = "Set"; //$NON-NLS-1$
        } else {
            s = ""; //$NON-NLS-1$
        }
        s += "{";//$NON-NLS-1$
        JmiList<CollectionLiteralPart> parts = (JmiList<CollectionLiteralPart>) ( (CollectionLiteralExpImpl) exp ).getParts( this.connection );
        for ( int i = 0, n = parts.size( this.connection.getSession( ) ); i < n; i++ ) {
            // prepend a comma except for the fist part
            if ( i > 0 ) {
                s += ", " + getString( parts.get( this.connection.getSession( ), i ) ); //$NON-NLS-1$
            } else {
                s += getString( parts.get( this.connection.getSession( ), i ) );
            }
        }
        s += "}"; //$NON-NLS-1$
        setString( exp, s );
    }

    @Override
    protected void upCollectionRange( CollectionRange range ) {

        String s = getString( ( (CollectionRangeImpl) range ).getFirst( this.connection ) ) + ".." + getString( ( (CollectionRangeImpl) range ).getLast( this.connection ) ); //$NON-NLS-1$
        setString( range, s );
    }

    @Override
    protected void upEnumLiteralExp( EnumLiteralExp exp ) {

        String s = qNameToString( ( (EnumerationTypeImpl) ( (EnumLiteralExpImpl) exp ).getReferredEnum( this.connection ) ).getQualifiedName( this.connection ) ) + "::" + exp.getLiteral( ); //$NON-NLS-1$
        setString( exp, s );
    }

    /**
     * Serializes a qualified name
     * 
     * @param qualifiedName
     * @return a string representation of the qualified name
     */
    private String qNameToString( List<String> qualifiedName ) {

        return this.mySerializationHelper.qNameToLocalString( qualifiedName, this.packageNames );
    }

    @Override
    protected void upIfExp( IfExp exp ) {

        String s = "if " + getString( ( (IfExpImpl) exp ).getCondition( this.connection ) ); //$NON-NLS-1$
        s += " then " + getString( ( (IfExpImpl) exp ).getThenExpression( this.connection ) ); //$NON-NLS-1$
        s += " else " + getString( ( (IfExpImpl) exp ).getElseExpression( this.connection ) ); //$NON-NLS-1$
        s += " endif"; //$NON-NLS-1$
        setString( exp, s );
    }

    @Override
    protected void upIntegerLiteralExp( IntegerLiteralExp exp ) {

        String s = Integer.toString( exp.getIntegerSymbol( ) );
        setString( exp, s );
    }

    @Override
    protected void upIterateExp( IterateExp exp ) {

        String s = getString( ( (IterateExpImpl) exp ).getSource( this.connection ) ) + "->iterate("; //$NON-NLS-1$
        JmiList<VariableDeclaration> iterators = (JmiList<VariableDeclaration>) ( (IterateExpImpl) exp ).getIterators( this.connection );
        if ( iterators.size( this.connection.getSession( ) ) > 0 ) {
            Object[] array = iterators.toArray( this.connection );
            if ( array[0] instanceof VariableDeclaration ) {
                VariableDeclaration var = (VariableDeclaration) array[0];
                if ( !var.getVarName( ).equals( OclConstants.EMPTY ) ) {
                    // this is an explicit variable
                    s += getString( array[0] ) + "; "; //$NON-NLS-1$
                } else {
                    // do nothing!
                }
            }
        }
        s += getString( ( (IterateExpImpl) exp ).getResult( this.connection ) );
        s += " | " + getString( ( (IterateExpImpl) exp ).getBody( this.connection ) ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        setString( exp, s );
    }

    @Override
    protected void upIteratorExp( IteratorExp exp ) {

        String s = getString( ( (IteratorExpImpl) exp ).getSource( this.connection ) ) + "->" + exp.getName( ) + "("; //$NON-NLS-1$ //$NON-NLS-2$
        Object[] iterators = ( (JmiList<VariableDeclaration>) ( (IteratorExpImpl) exp ).getIterators( this.connection ) ).toArray( this.connection );

        // there can only be one implicit iterator variable
        // if there are two iterators they must be explicit
        if ( iterators.length == 1 ) {
            if ( iterators[0] instanceof VariableDeclaration ) {
                VariableDeclaration var = (VariableDeclaration) iterators[0];
                if ( !var.getVarName( ).equals( OclConstants.EMPTY ) ) {
                    // this is an explicit variable
                    s += getString( iterators[0] );
                    s += " | "; //$NON-NLS-1$
                } else {
                    // do nothing!
                }
            }
        } else if ( iterators.length > 1 ) {
            s += getString( iterators[0] );
            s += ", " + getString( iterators[1] ); //$NON-NLS-1$
            s += " | "; //$NON-NLS-1$
        }
        s += getString( ( (IteratorExpImpl) exp ).getBody( this.connection ) ) + ")"; //$NON-NLS-1$
        setString( exp, s );
    }

    @Override
    protected void upLetExp( LetExp exp ) {

        String s = "let "; //$NON-NLS-1$
        s += getString( ( (LetExpImpl) exp ).getVariable( this.connection ) );
        s += " in " + getString( ( (LetExpImpl) exp ).getIn( this.connection ) ); //$NON-NLS-1$
        setString( exp, s );
    }

    @Override
    protected void upOperationCallExp( OperationCallExp exp ) {

        String s;
        String atPre = OclConstants.EMPTY;
        if ( isMarkedAtPre( exp ) ) {
            atPre = OclConstants.ATPRE;
        }
        OclExpression sourceExpr = ( (OperationCallExpImpl) exp ).getSource( this.connection );
        if ( isInfixOperation( exp ) ) {
            String source = getString( sourceExpr );
            Object argObj = ( (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection ) ).get( this.connection.getSession( ), 0 );
            String arg = getString( argObj );
            // if source or argument is a letExp we have to put it in
            // parenthesis
            if ( sourceExpr instanceof LetExp ) {
                source = OclConstants.BRACKETLEFT + source + OclConstants.BRACKETRIGHT;
            }
            if ( argObj instanceof LetExp ) {
                arg = OclConstants.BRACKETLEFT + arg + OclConstants.BRACKETRIGHT;
            }
            s = source + OclConstants.SPACE + ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ) + OclConstants.SPACE + arg;
        } else if ( isPrefixOperation( exp ) ) {
            String source = getString( sourceExpr );
            // if source or argument is a letExp we have to put it in
            // parenthesis
            if ( sourceExpr instanceof LetExp ) {
                source = OclConstants.BRACKETLEFT + source + OclConstants.BRACKETRIGHT;
            }
            s = ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ) + OclConstants.SPACE + source;
        } else if ( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ).equals( OclConstants.OP_ASSET ) && !( ( (OclExpressionInternal) sourceExpr ).getType( this.connection ) instanceof CollectionType ) ) {
            // this is the implicit operation which turns a single element
            // into a Set.
            // omit this operation
            s = getString( sourceExpr );
        } else if ( ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ).equals( OclConstants.OP_ATRPRE ) ) {
            // omit this operation
            // we include it later one as '@pre' which does not look as an
            // actual operation
            s = getString( sourceExpr );
        } else {
            String accessOperator = OclConstants.DOT;
            Classifier sourceType = ( (OclExpressionInternal) sourceExpr ).getType( this.connection );
            if ( sourceType instanceof CollectionType ) {
                accessOperator = "->"; //$NON-NLS-1$
            }
            if ( sourceExpr instanceof VariableExp ) {
                VariableExpImpl var = (VariableExpImpl) sourceExpr;
                // implicit variables have "" as name
                if ( var.getReferredVariable( this.connection ).getVarName( ).equals( OclConstants.EMPTY ) ) {
                    // omit variable name and dot
                    s = ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ) + atPre + OclConstants.BRACKETLEFT;
                } else {
                    s = getString( sourceExpr ) + accessOperator + ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ) + atPre + OclConstants.BRACKETLEFT;
                }
            } else {
                s = getString( sourceExpr ) + accessOperator + ( (OperationCallExpImpl) exp ).getReferredOperation( this.connection ).getName( ) + OclConstants.BRACKETLEFT;
            }
            JmiList<OclExpression> args = (JmiList<OclExpression>) ( (OperationCallExpImpl) exp ).getArguments( this.connection );
            for ( int i = 0, n = args.size( this.connection.getSession( ) ); i < n; i++ ) {
                if ( i > 0 ) {
                    s += ", " + getString( args.get( this.connection.getSession( ), i ) ); //$NON-NLS-1$
                } else {
                    s += getString( args.get( this.connection.getSession( ), i ) );
                }
            }
            s += OclConstants.BRACKETRIGHT;
        }
        setString( exp, s );
    }

    @Override
    protected void upRealLiteralExp( RealLiteralExp exp ) {

        String s = Double.toString( exp.getRealSymbol( ) );
        setString( exp, s );
    }

    @Override
    protected void upStringLiteralExp( StringLiteralExp exp ) {

        String s = "'" + exp.getStringSymbol( ) + "'"; //$NON-NLS-1$//$NON-NLS-2$
        setString( exp, s );
    }

    @Override
    protected void upTupleLiteralExp( TupleLiteralExp exp ) {

        String s = "Tuple {"; //$NON-NLS-1$
        JmiList<VariableDeclaration> tuplePart = (JmiList<VariableDeclaration>) ( (TupleLiteralExpImpl) exp ).getTuplePart( this.connection );
        int index = 0;
        for ( Iterator<VariableDeclaration> i = tuplePart.iterator( this.connection ); i.hasNext( ); index++ ) {
            if ( index > 0 ) {
                s += ", " + getString( i.next( ) ); //$NON-NLS-1$
            } else {
                s += getString( i.next( ) );
            }
        }
        s += "}"; //$NON-NLS-1$
        setString( exp, s );
    }

    @Override
    protected void upTypeExp( TypeExp exp ) {

        String s = classifierToString( ( (TypeExpImpl) exp ).getReferredType( this.connection ) );
        setString( exp, s );
    }

    @Override
    protected void upVariableDeclaration( VariableDeclaration decl ) {

        String s = decl.getVarName( );
        s += ":" + classifierToString( ( (VariableDeclarationImpl) decl ).getType( this.connection ) ); //$NON-NLS-1$
        OclExpression initExpression = ( (VariableDeclarationImpl) decl ).getInitExpression( this.connection );
        if ( initExpression != null ) {
            s += " = " + getString( initExpression ); //$NON-NLS-1$
        }
        setString( decl, s );
    }

    /**
     * Serializes a classifier
     * 
     * @param type the classifier to serialize
     * @return a String representing the classifier <tt>type</tt>
     */
    private String classifierToString( Classifier type ) {

        return this.mySerializationHelper.classifierToLocalString( this.connection, type, this.packageNames );
    }

    @Override
    protected void upVariableExp( VariableExp exp ) {

        String s = ( (VariableExpImpl) exp ).getReferredVariable( this.connection ).getVarName( );
        setString( exp, s );
    }

    /**
     * Checks whether an OperationCallExp represents a infix operation (e.g.
     * <tt>and</tt>,<tt>=</tt>,<tt>+</tt>,<tt>/</tt>, ...)
     * 
     * @param opCall
     * @return <tt>true</tt> if OperationCallExp represents a infix operation.
     */
    private boolean isInfixOperation( OperationCallExp opCall ) {

        if ( ( (JmiList<OclExpression>) ( (OperationCallExpImpl) opCall ).getArguments( this.connection ) ).size( this.connection.getSession( ) ) == 1 ) {
            String opName = ( (OperationCallExpImpl) opCall ).getReferredOperation( this.connection ).getName( );
            if ( opName.equals( "and" ) || opName.equals( "or" ) || opName.equals( "xor" ) //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                 || opName.equals( "implies" ) || opName.equals( "=" ) || opName.equals( "<>" ) //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                 || opName.equals( ">" ) || opName.equals( "<" ) || opName.equals( ">=" ) //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ 
                 || opName.equals( "<=" ) || opName.equals( "+" ) || opName.equals( "-" ) //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ 
                 || opName.equals( "*" ) || opName.equals( "/" ) ) { //$NON-NLS-1$//$NON-NLS-2$
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Checks whether an OperationCallExp represents a prefix operation (i.e.
     * <tt>- (Real)</tt>,<tt>not (Boolean)</tt>)
     * 
     * @param opCall
     * @return true iff opCall represents <tt>-(Real)</tt>,
     * <tt>not(Boolean)</tt>
     */
    private boolean isPrefixOperation( OperationCallExp opCall ) {

        if ( ( (JmiList<OclExpression>) ( (OperationCallExpInternal) opCall ).getArguments( this.connection ) ).size( this.connection.getSession( ) ) == 0 ) {
            String opName = ( (OperationCallExpInternal) opCall ).getReferredOperation( this.connection ).getName( );
            if ( opName.equals( "not" ) || opName.equals( "-" ) ) { //$NON-NLS-1$//$NON-NLS-2$
                return true;
            }
            return false;

        }
        return false;
    }

}