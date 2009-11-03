package com.sap.tc.moin.repository.test.ocl.base;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;

import org.omg.ocl.expressions.CollectionKindEnum;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;
import org.omg.ocl.expressions.__impl.BooleanLiteralExpInternal;
import org.omg.ocl.expressions.__impl.CollectionItemImpl;
import org.omg.ocl.expressions.__impl.CollectionItemInternal;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpInternal;
import org.omg.ocl.expressions.__impl.CollectionLiteralPartInternal;
import org.omg.ocl.expressions.__impl.CollectionRangeInternal;
import org.omg.ocl.expressions.__impl.EnumLiteralExpInternal;
import org.omg.ocl.expressions.__impl.IfExpInternal;
import org.omg.ocl.expressions.__impl.IntegerLiteralExpInternal;
import org.omg.ocl.expressions.__impl.IterateExpInternal;
import org.omg.ocl.expressions.__impl.IteratorExpInternal;
import org.omg.ocl.expressions.__impl.LetExpInternal;
import org.omg.ocl.expressions.__impl.LiteralExpInternal;
import org.omg.ocl.expressions.__impl.LoopExpInternal;
import org.omg.ocl.expressions.__impl.ModelPropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.NavigationCallExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.PrimitiveLiteralExpInternal;
import org.omg.ocl.expressions.__impl.PropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.RealLiteralExpInternal;
import org.omg.ocl.expressions.__impl.StringLiteralExpInternal;
import org.omg.ocl.expressions.__impl.TupleLiteralExpInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.expressions.__impl.VariableExpInternal;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.__impl.BagTypeInternal;
import org.omg.ocl.types.__impl.CollectionTypeInternal;
import org.omg.ocl.types.__impl.OrderedSetTypeInternal;
import org.omg.ocl.types.__impl.SequenceTypeInternal;
import org.omg.ocl.types.__impl.SetTypeInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;

/**
 * Wellformedness tests
 */
public class WellformednessTests extends BaseOclTest {

    private final static String BOOLEAN = "Boolean";

    private final static String INTEGER = "Integer";

    private final static String DOUBLE = "Double";

    private final static String STRING = "String";

    /**
     * See superclass.
     * 
     * @param coreConnection
     */
    public WellformednessTests( CoreConnection coreConnection ) {

        this.coreConnection = coreConnection;
    }

    /**
     * Checks well-formedness of the OclExpression and of its subtypes.
     * 
     * @param exp
     */
    public void checkOclExpression( OclExpressionInternal exp ) {

        if ( exp.getType( coreConnection ) == null ) {
            flop( "OclExpression does not have a type" );
        }
        if ( exp.getType( coreConnection ) instanceof CollectionType ) {
            if ( ( (CollectionTypeInternal) exp.getType( coreConnection ) ).getElementType( coreConnection ) == null ) {
                flop( "CollectionType does not have an elementType" );
            }
        }
        if ( exp instanceof PropertyCallExpInternal ) {
            checkPropertyCallExp( (PropertyCallExpInternal) exp );
        } else if ( exp instanceof LiteralExpInternal ) {
            checkLiteralExp( (LiteralExpInternal) exp );
        } else if ( exp instanceof IfExpInternal ) {
            checkIfExp( (IfExpInternal) exp );
        } else if ( exp instanceof VariableExpInternal ) {
            checkVariableExp( (VariableExpInternal) exp );
        } else if ( exp instanceof LetExpInternal ) {
            checkLetExp( (LetExpInternal) exp );
        } else if ( exp instanceof TypeExpInternal ) {
            // checkLetExp((LetExp)exp);
        } else {
            flop( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * Checks well-formedness of PropertyCallExp and its subtypes.
     * 
     * @param exp
     */
    private void checkPropertyCallExp( PropertyCallExpInternal exp ) {

        if ( exp instanceof ModelPropertyCallExpInternal ) {
            checkModelPropertyCallExp( (ModelPropertyCallExpInternal) exp );
        } else if ( exp instanceof LoopExpInternal ) {
            checkLoopExp( (LoopExpInternal) exp );
        } else {
            flop( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * Checks the well-formedness of a ModelPropertyCallExp and its subtypes.
     * 
     * @param exp
     */
    private void checkModelPropertyCallExp( ModelPropertyCallExpInternal exp ) {

        // no tests specified for this type

        // further tests depend on the subtype
        if ( exp instanceof AttributeCallExpInternal ) {
            checkAttributeCallExp( (AttributeCallExpInternal) exp );
        } else if ( exp instanceof NavigationCallExpInternal ) {
            checkNavigationCallExp( (NavigationCallExpInternal) exp );
        } else if ( exp instanceof OperationCallExpInternal ) {
            checkOperationCallExp( (OperationCallExpInternal) exp );
        } else {
            flop( "no test specified for " + exp.getClass( ) );
        }

    }

    /**
     * Checks the well-formedness of an AttributeCallExp
     * 
     * @param exp
     */
    private void checkAttributeCallExp( AttributeCallExpInternal exp ) {

        // TODO Auto-generated method stub
        ClassifierInternal cAttrExp = (ClassifierInternal) exp.getType( coreConnection );
        if ( cAttrExp == null ) {
            flop( "AttributeCallExp must have a type" );
            return;
        }
        AttributeInternal attr = (AttributeInternal) exp.getReferredAttribute( coreConnection );
        if ( attr == null ) {
            flop( "AttributeCallExp does not have a referredAttribute" );
            return;
        }
        ClassifierInternal cAttr = (ClassifierInternal) attr.getType( coreConnection );
        if ( !cAttrExp.equals( cAttr ) && !( cAttr instanceof StructureTypeInternal ) ) {
            flop( "AttributeCallExp does noth have the same type as its referred attribute" );
        }
        OclExpressionInternal source = (OclExpressionInternal) exp.getSource( coreConnection );
        // if (source == null) {
        //			
        // flop("AttributeCallExp must have a source");
        // }
        if ( source != null ) {
            checkOclExpression( source );
        }

    }

    /**
     * Checks the well-formedness of a NavigationCallExp and its subtypes.
     * 
     * @param exp
     */
    private void checkNavigationCallExp( NavigationCallExpInternal exp ) {

        // an navigation source must be given
        if ( exp.getNavigationSource( coreConnection ) == null ) {
            // FIXME remove comment when navigationSource is fixed
            // flop("NavigationCallExp must have a navigationSource.");
        }

        // further test depend on the concrete subtype
        if ( exp instanceof AssociationEndCallExpInternal ) {
            checkAssociationEndCallExp( (AssociationEndCallExpInternal) exp );
        } else {
            flop( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * Checks the well-formedness of an AssociationCallExp.
     * 
     * @param exp
     */
    private void checkAssociationEndCallExp( AssociationEndCallExpInternal exp ) {

        // an AssociationEndCallExp must have a referredAssociationEnd
        if ( exp.getReferredAssociationEnd( coreConnection ) == null ) {
            flop( "AssociationEndCallExp must have a referredAssociationEnd!" );
        }
    }

    /**
     * Checks the well-formedness of a LiteralExp and its subtypes.
     * 
     * @param exp
     */
    private void checkLiteralExp( LiteralExpInternal exp ) {

        if ( exp instanceof PrimitiveLiteralExpInternal ) {
            checkPrimitiveLiteralExp( (PrimitiveLiteralExpInternal) exp );
        } else if ( exp instanceof CollectionLiteralExpInternal ) {
            checkCollectionLiteralExp( (CollectionLiteralExpInternal) exp );
        } else if ( exp instanceof EnumLiteralExpInternal ) {
            checkEnumLiteralExp( (EnumLiteralExpInternal) exp );
        } else if ( exp instanceof TupleLiteralExpInternal ) {
            checkTupleLiteralExp( (TupleLiteralExpInternal) exp );
        } else {
            flop( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * @param exp
     */
    private void checkTupleLiteralExp( TupleLiteralExpInternal exp ) {

        // TODO Auto-generated method stub

    }

    /**
     * @param exp
     */
    private void checkEnumLiteralExp( EnumLiteralExpInternal exp ) {

        // TODO implement em!
    }

    /**
     * @param exp
     */
    private void checkPrimitiveLiteralExp( PrimitiveLiteralExpInternal exp ) {

        if ( exp instanceof BooleanLiteralExpInternal ) {
            checkBooleanLiteralExp( (BooleanLiteralExpInternal) exp );
        } else if ( exp instanceof RealLiteralExpInternal ) {
            checkRealLiteralExp( (RealLiteralExpInternal) exp );
        } else if ( exp instanceof StringLiteralExpInternal ) {
            checkStringLiteralExp( (StringLiteralExpInternal) exp );
        } else if ( exp instanceof IntegerLiteralExpInternal ) {
            checkIntegerLiteralExp( (IntegerLiteralExpInternal) exp );
        } else {
            flop( "no test specified for " + exp.getClass( ) );
        }
    }

    private void checkBooleanLiteralExp( BooleanLiteralExpInternal exp ) {

        ClassifierInternal cBool = (ClassifierInternal) exp.getType( coreConnection );
        verify( cBool != null, "BooleanLiteralExpession must have a type" );
        if ( cBool == null ) {
            return;
        }
        verify( cBool.getName( ).equals( BOOLEAN ), "Type of BooleanLiteralExp must be Boolean" );

    }

    /**
     * Checks the well-formedness of a CollectionLiteralExp.
     * 
     * @param exp
     */
    private void checkCollectionLiteralExp( CollectionLiteralExpInternal exp ) {

        ClassifierInternal c = (ClassifierInternal) exp.getType( coreConnection );
        if ( c instanceof SetTypeInternal ) {
            if ( !exp.getKind( ).equals( CollectionKindEnum.SET ) ) {
                flop( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else if ( c instanceof SequenceTypeInternal ) {
            if ( !exp.getKind( ).equals( CollectionKindEnum.SEQUENCE ) ) {
                flop( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else if ( c instanceof BagTypeInternal ) {
            if ( !exp.getKind( ).equals( CollectionKindEnum.BAG ) ) {
                flop( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else if ( c instanceof OrderedSetTypeInternal ) {
            if ( !exp.getKind( ).equals( CollectionKindEnum.ORDERED_SET ) ) {
                flop( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else {
            flop( "CollectionLiteralExp has an invalid type: " + c.getName( ) );
        }
        JmiList parts = (JmiList) ( (CollectionLiteralExpImpl) exp ).getParts( coreConnection );
        for ( int i = 0, n = parts.size( coreConnection.getSession( ) ); i < n; i++ ) {
            CollectionLiteralPartInternal partExp = (CollectionLiteralPartInternal) parts.get( coreConnection.getSession( ), i );
            // isConform(partExp.getType(), c);
            if ( partExp instanceof CollectionItemInternal ) {
                CollectionItemImpl item = (CollectionItemImpl) partExp;
                if ( !item.getType( coreConnection ).equals( ( (OclExpressionInternal) item.getItem( coreConnection ) ).getType( coreConnection ) ) ) {
                    flop( "The type of CollectionItem and CollectionItem.getItem must be the same" );
                }
                checkOclExpression( (OclExpressionInternal) item.getItem( coreConnection ) );
            } else if ( partExp instanceof CollectionRange ) {
                CollectionRangeInternal range = (CollectionRangeInternal) partExp;
                OclExpressionInternal firstExpr = (OclExpressionInternal) range.getFirst( coreConnection );
                OclExpressionInternal lastExpr = (OclExpressionInternal) range.getLast( coreConnection );
                if ( !isConform( ( (ClassifierInternal) firstExpr.getType( coreConnection ) ), (ClassifierInternal) range.getType( coreConnection ) ) ) {
                    flop( "The Type of first does not conform to the type of range" );
                }
                checkOclExpression( (OclExpressionInternal) range.getFirst( coreConnection ) );
                if ( !isConform( (ClassifierInternal) lastExpr.getType( coreConnection ), (ClassifierInternal) range.getType( coreConnection ) ) ) {
                    flop( "The Type of last does not conform to the type of range" );
                }
                checkOclExpression( lastExpr );
            }
        }
    }

    /**
     * Checks whether c1 conforms to c2
     * 
     * @param c1
     * @param c2
     */
    private boolean isConform( ClassifierInternal c1, ClassifierInternal c2 ) {

        // List superTypes1 = c1.allSupertypes();
        // return superTypes1.contains(c2);
        // FIXME implement me
        return true;
    }

    private void checkIfExp( IfExpInternal ifExp ) {

        OclExpressionInternal cond = (OclExpressionInternal) ifExp.getCondition( coreConnection );
        // type of cond must be boolean
        Classifier cCond = cond.getType( coreConnection );

        verify( cCond.getName( ).equals( BOOLEAN ), "Condition of IfExp is not of type Boolean" );

        OclExpressionInternal thenExp = (OclExpressionInternal) ifExp.getThenExpression( coreConnection );
        if ( thenExp == null ) {
            flop( "then expression is empty!" );
            return;
        }
        OclExpressionInternal elseExp = (OclExpressionInternal) ifExp.getElseExpression( coreConnection );
        if ( elseExp == null ) {
            flop( "else expression is empty!" );
            return;
        }
        ClassifierInternal cThen = (ClassifierInternal) thenExp.getType( coreConnection );
        ClassifierInternal cElse = (ClassifierInternal) elseExp.getType( coreConnection );
        ClassifierInternal cIf = (ClassifierInternal) ifExp.getType( coreConnection );
        if ( cIf == null ) {
            flop( "if expression does not have a type" );
        }
        if ( cThen == null ) {
            flop( "then expression does not have a type" );
        }
        if ( cElse == null ) {
            flop( "Else expression does not have a type" );
        }
        // TODO check whether cIf is the most common super type of cThen and
        // cElse

        checkOclExpression( cond );
        checkOclExpression( thenExp );
        checkOclExpression( elseExp );
    }

    /**
     * checks the well-formedness of an IntegerLiteralExp i.e.: type == Integer
     * 
     * @param exp
     */
    private void checkIntegerLiteralExp( IntegerLiteralExpInternal exp ) {

        ClassifierInternal cInt = (ClassifierInternal) exp.getType( coreConnection );
        if ( cInt == null ) {
            flop( "IntegerLiteralExp must have a type" );
            return;
        }
        verify( cInt.getName( ).equals( INTEGER ), "Type of IntegerLiteralExp must be Integer" );
    }

    /**
     * @param exp
     */
    private void checkLoopExp( LoopExpInternal exp ) {

        OclExpressionInternal source = (OclExpressionInternal) exp.getSource( coreConnection );
        if ( source == null ) {
            flop( "LoopExp does not have a source" );
            return;
        }
        ClassifierInternal cSource = (ClassifierInternal) source.getType( coreConnection );
        if ( !( cSource instanceof CollectionTypeInternal ) ) {
            flop( "Source of LoopExp must be of type CollectionType" );
        }

        CollectionTypeInternal col = (CollectionTypeInternal) cSource;
        JmiList iterators = null;
        if ( exp instanceof IterateExpInternal ) {
            iterators = (JmiList) ( (IterateExpInternal) exp ).getIterators( coreConnection );
        } else {
            iterators = (JmiList) ( (IteratorExpInternal) exp ).getIterators( coreConnection );
        }
        for ( Iterator<VariableDeclarationInternal> i = iterators.iterator( coreConnection ); i.hasNext( ); ) {
            VariableDeclarationInternal varDecl = i.next( );
            if ( varDecl.getInitExpression( coreConnection ) != null ) {
                flop( "VariableDeclarations of LoopExp are not allowed to have an initExpression." );
            }
            if ( !varDecl.getType( coreConnection ).equals( ( (CollectionTypeInternal) col ).getElementType( coreConnection ) ) ) {
                flop( "Iterator of an LoopExp and the collection's elements must be of the same type" );
            }
            checkVariableDeclaration( varDecl );
        }

        if ( exp instanceof IterateExpInternal ) {
            checkIterateExp( (IterateExpInternal) exp );
            checkOclExpression( (OclExpressionInternal) ( (IterateExpInternal) exp ).getBody( coreConnection ) );
            checkOclExpression( (OclExpressionInternal) ( (IterateExpInternal) exp ).getSource( coreConnection ) );
        } else if ( exp instanceof IteratorExpInternal ) {
            checkIteratorExp( (IteratorExpInternal) exp );
            checkOclExpression( (OclExpressionInternal) ( (IteratorExpInternal) exp ).getBody( coreConnection ) );
            checkOclExpression( (OclExpressionInternal) ( (IteratorExpInternal) exp ).getSource( coreConnection ) );
        }
    }

    /**
     * Checks the well-formedness of an IterateExp
     * 
     * @param exp
     */
    private void checkIterateExp( IterateExpInternal exp ) {

        // the type of the iterate is the type of the return variable
        VariableDeclarationInternal varDecl = (VariableDeclarationInternal) exp.getResult( coreConnection );
        if ( !exp.getType( coreConnection ).equals( varDecl.getType( coreConnection ) ) ) {
            flop( "the type of the iterate is the type of the return variable" );
        }
        // the type of the body must conform to the type of the result variable
        if ( !isConform( (ClassifierInternal) ( (OclExpressionInternal) exp.getBody( coreConnection ) ).getType( coreConnection ), (ClassifierInternal) varDecl.getType( coreConnection ) ) ) {
            flop( "the type of the body must conform to the type of the result variable" );
        }
        // a result variable must have an init expression
        if ( varDecl.getInitExpression( coreConnection ) == null ) {
            flop( "a result variable must have an init expression" );
        }
        checkVariableDeclaration( varDecl );

    }

    /**
     * @param exp
     */
    private void checkIteratorExp( IteratorExpInternal exp ) {

        // the body of forAll, isUnique and exists must be of type boolean
        if ( exp.getName( ) == null ) {
            flop( "IteratorExp must have a name" );
        }
        if ( exp.getName( ).equals( "forAll" ) || exp.getName( ).equals( "isUnique" ) || exp.getName( ).equals( "exists" ) ) {
            verify( exp.getType( coreConnection ).getName( ).equals( BOOLEAN ), "the iterator of 'forAll', 'isUnique', 'exists' must be of type 'Boolean'. Type is: '" + exp.getType( coreConnection ) + "'" );

        }
        // the result type of the collect operation on a sequence type is a
        // sequence
        // on any other type it is a bag
        if ( exp.getName( ).equals( "collect" ) ) {
            if ( ( (OclExpressionInternal) exp.getSource( coreConnection ) ).getType( coreConnection ) instanceof SequenceTypeInternal ) {
                if ( !( exp.getType( coreConnection ) instanceof SequenceTypeInternal ) ) {
                    flop( "the result of a collect operation on a sequence must be a sequence" );
                }
            } else {
                if ( !( exp.getType( coreConnection ) instanceof BagTypeInternal ) ) {
                    flop( "the result of a collect operation on a non-sequence must be a bag" );
                }
            }
            // the type of the body must be the type of the elements in the
            // return collection
            /*
             * This doesn't really make sense. I know it's from the spec. (p.
             * 52), but collect is supposed to do a flatten, so this cannot hold
             * for collect on a body that is a collection type. So we change
             * this accordingly
             */
            ClassifierInternal elemType = (ClassifierInternal) ( (CollectionTypeInternal) exp.getType( coreConnection ) ).getElementType( coreConnection );
            ClassifierInternal bodyType = (ClassifierInternal) ( (OclExpressionInternal) exp.getBody( coreConnection ) ).getType( coreConnection );
            if ( bodyType instanceof CollectionTypeInternal ) {
                bodyType = flattenedType( bodyType );
            }
            if ( !bodyType.equals( elemType ) ) {
                flop( "for a collect operation the elements of the return collection and the body must be of the same type" );
            }
        }
        if ( exp.getName( ).equals( "collect" ) || exp.getName( ).equals( "select" ) || exp.getName( ).equals( "reject" ) ) {
            if ( !( exp.getType( coreConnection ) instanceof CollectionTypeInternal ) ) {
                flop( "The type of '" + exp.getName( ) + "' must be a subtype of CollectionTyp. It is of type '" + exp.getType( coreConnection ) + "'" );
            }
        }

        // 'select' and 'reject' must have the same type as its source
        if ( exp.getName( ).equals( "select" ) || exp.getName( ).equals( "reject" ) ) {
            if ( !exp.getType( coreConnection ).equals( ( (OclExpressionInternal) exp.getSource( coreConnection ) ).getType( coreConnection ) ) ) {
                flop( "'select' and 'reject' must have the same type as its source." );
            }
        }
        // the body of select, reject, exists, forAll must be of type boolean
        if ( exp.getName( ).equals( "select" ) || exp.getName( ).equals( "reject" ) || exp.getName( ).equals( "exists" ) || exp.getName( ).equals( "forAll" ) ) {
            verify( ( (OclExpressionInternal) exp.getBody( coreConnection ) ).getType( coreConnection ).getName( ).equals( BOOLEAN ), "the body of 'select', 'reject', 'exists' and 'forAll' must be of type 'Boolean'" );
        }

    }

    /**
     * checks the well-formedness of an LetExp i.e.: type != null, variable !=
     * null, in != null, type == in.type
     * 
     * @param exp
     */
    private void checkLetExp( LetExpInternal exp ) {

        ClassifierInternal cLet = (ClassifierInternal) exp.getType( coreConnection );
        if ( cLet == null ) {
            flop( "let expression must have a type" );
        }
        VariableDeclarationInternal decl = (VariableDeclarationInternal) exp.getVariable( coreConnection );
        if ( decl == null ) {
            flop( "let expression does not have a variable declaration" );
        }
        OclExpressionInternal inExp = (OclExpressionInternal) exp.getIn( coreConnection );
        if ( inExp == null ) {
            flop( "in expression of let expression is not allowed to be empty" );
            return;
        }
        ClassifierInternal cIn = (ClassifierInternal) inExp.getType( coreConnection );
        if ( !cIn.equals( cLet ) ) {
            flop( "let expression and in expression must have the same type" );
        }

        checkVariableDeclaration( decl );

        checkOclExpression( inExp );
    }

    /**
     * checks the well-formedness of an OperationCallExp i.e.: type != null,
     * referredOperation != null, #arguments = oparation.#arguments, the return
     * type of Operation conforms to the type of OperationCallExp, each argument
     * of OperationCallExp conforms to the corresponding argument of Operation.
     * 
     * @param exp
     */
    private void checkOperationCallExp( OperationCallExpInternal exp ) {

        // check type
        ClassifierInternal cOpExp = (ClassifierInternal) exp.getType( coreConnection );
        if ( cOpExp == null ) {
            flop( "OperationCallExp does not have a type" );
        }
        // check operation
        OperationInternal op = (OperationInternal) exp.getReferredOperation( coreConnection );
        if ( op == null ) {
            flop( "OperationiCall does not refer to an operation" );
        }
        JmiList opCallParams = (JmiList) exp.getArguments( coreConnection );
        List<ParameterInternal> opParams = new Vector<ParameterInternal>( );
        int returnTypes = 0;
        ClassifierInternal returnType = null;
        // find the return type
        // get a list of parameters
        JmiList contents = (JmiList) ( (NamespaceInternal) op ).getContents( coreConnection );
        for ( int i = 0, n = contents.size( coreConnection.getSession( ) ); i < n; i++ ) {
            ParameterInternal p = (ParameterImpl) contents.get( coreConnection.getSession( ), i );
            if ( p.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                returnTypes++;
                returnType = (ClassifierInternal) p.getType( coreConnection );
            } else if ( p.getDirection( ) != DirectionKindEnum.OUT_DIR ) {
                opParams.add( p );
            }

        }
        // check the number of arguments
        if ( !exp.getName( ).equals( "oclIsTypeOf" ) && !exp.getName( ).equals( "oclIsKindOf" ) && !exp.getName( ).equals( "oclAsType" ) ) {
            // oclIsTypeOf, oclIsKindOf, oclAsType are treated differently
            if ( opParams.size( ) != opCallParams.size( coreConnection.getSession( ) ) ) {
                flop( "OperationCallExp and Operation do not have the same number of parameters" );
            }
        }
        // there must be exaclty one return type
        if ( returnTypes != 1 ) {
            flop( "Operation has wrong amount of return types" );
        }

        // the return type must conform to the type of OperationCallExp
        if ( !isConform( returnType, cOpExp ) ) {
            flop( "OperationCallExp and the return type of Operation must be the same" );
        }
        // check each parameter whether each parameter of OperationCallExp
        // conforms to
        // the corresponding parameter of Operation
        if ( !exp.getName( ).equals( "oclIsTypeOf" ) && !exp.getName( ).equals( "oclIsKindOf" ) && !exp.getName( ).equals( "oclAsType" ) ) {
            // oclIsTypeOf, oclIsKindOf, oclAsType are treated differently
            for ( int i = 0; i < opParams.size( ); i++ ) {
                ClassifierInternal cParamOpCall = (ClassifierInternal) ( (OclExpressionInternal) opCallParams.get( coreConnection.getSession( ), i ) ).getType( coreConnection );
                ClassifierInternal cParamOp = (ClassifierInternal) ( opParams.get( i ) ).getType( coreConnection );
                if ( !isConform( cParamOpCall, cParamOp ) ) {
                    flop( "Parameters of OperationCallExp does not conform to paramters of Operation" );
                }
            }
        }
        // check agruments of OperationCallExp
        JmiList args = (JmiList) exp.getArguments( coreConnection );
        for ( int i = 0, n = args.size( coreConnection.getSession( ) ); i < n; i++ ) {
            checkOclExpression( (OclExpressionInternal) args.get( coreConnection.getSession( ), i ) );
        }
        // check source of operation call expression
        OclExpressionInternal source = (OclExpressionInternal) exp.getSource( coreConnection );
        // if (source == null) {
        // flop("OperationCallExp must have a source");
        // }
        if ( source != null ) {
            checkOclExpression( source );
        }

    }

    /**
     * checks the well-formedness of an RealLiteralExp i.e.: type = Real and
     * realSymbol != null.
     * 
     * @param exp
     */
    private void checkRealLiteralExp( RealLiteralExpInternal exp ) {

        ClassifierInternal cReal = (ClassifierInternal) exp.getType( coreConnection );
        if ( cReal == null ) {
            flop( "RealLiteralExp must have a type" );
            return;
        }
        verify( cReal.getName( ).equals( DOUBLE ), "Type of RealLiteralExp must be Double" );
    }

    /**
     * checks the well-formedness of a StringLiteralExp i.e.: type = String,
     * stringSymbol != null
     * 
     * @param exp
     */
    private void checkStringLiteralExp( StringLiteralExpInternal exp ) {

        ClassifierInternal cString = (ClassifierInternal) exp.getType( coreConnection );
        if ( cString == null ) {
            flop( "StringLiteralExp must have a type" );
            return;
        }
        verify( cString.getName( ).equals( STRING ), "Type of StringLiteralExp must be String" );

        String value = exp.getStringSymbol( );
        if ( value == null ) {
            flop( "StringLiteralExp must have a stringSymbol" );
        }
    }

    /**
     * checks the well-formedness of a VariableDeclaration i.e.: type != null,
     * varName != null and ((init != null) implies (init.type conformsTo type))
     * 
     * @param exp
     */
    private void checkVariableDeclaration( VariableDeclarationInternal exp ) {

        ClassifierInternal cDecl = (ClassifierInternal) exp.getType( coreConnection );
        if ( cDecl == null ) {
            flop( "VariableDeclaration does not have a type" );
        }
        String varName = exp.getVarName( );
        if ( varName == null ) {
            flop( "no variable name defined in variable declaration" );
        }
        OclExpressionInternal init = (OclExpressionInternal) exp.getInitExpression( coreConnection );
        if ( init != null ) {
            // this variable declaration has an init expression
            ClassifierInternal cInit = (ClassifierInternal) init.getType( coreConnection );
            if ( cInit == null ) {
                flop( "init expression does not have a type" );
            }
            if ( !isConform( cInit, cDecl ) ) {
                flop( "type of init expression does not conform to type of variable declaration" );
            }
            checkOclExpression( init );
        }
    }

    /**
     * @param exp
     */
    private void checkVariableExp( VariableExpInternal exp ) {


        Classifier cVar = exp.getType( coreConnection );
        if ( cVar == null ) {
            flop( "VariableExp does not have a type" );
            return;
        }
        VariableDeclarationInternal decl = (VariableDeclarationInternal) exp.getReferredVariable( coreConnection );
        if ( decl == null ) {
            flop( "VariableExp does not have a VariableDeclaration" );
            return;
        }
        Classifier cDecl = decl.getType( coreConnection );
        if ( !cVar.equals( cDecl ) ) {
            flop( "Type of VariableExp and type ofVariableDeclaration must be the same" );
        }
        checkVariableDeclaration( decl );
    }

    //
    // /**
    // * determines the most common Classifier for Classifier c1 and Classifier
    // * c2.
    // *
    // * @param c1
    // * @param c2
    // * @return
    // */
    // private Classifier getMostCommonClassifier(Classifier c1, Classifier c2)
    // {
    // // TODO implement me
    // return null;
    // }

    private ClassifierInternal flattenedType( ClassifierInternal type ) {

        if ( type instanceof CollectionTypeInternal ) {
            return flattenedType( (ClassifierInternal) ( (CollectionTypeInternal) type ).getElementType( coreConnection ) );
        }
        return type;
    }
}