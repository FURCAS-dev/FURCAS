package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.PrimitiveLiteralExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

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
    public WellformednessTests( ) {

    }

    /**
     * Checks well-formedness of the OclExpression and of its subtypes.
     * 
     * @param exp
     */
    public void checkOclExpression( OCLExpression<EClassifier> exp ) {

        if ( exp.getType( ) == null ) {
            fail( "OclExpression does not have a type" );
        }
        if ( exp.getType( ) instanceof CollectionType ) {
            if (((CollectionType) exp.getType( )).getElementType( ) == null ) {
                fail( "CollectionType does not have an elementType" );
            }
        }
        if ( exp instanceof PropertyCallExp ) {
            checkPropertyCallExp( (PropertyCallExp) exp );
        } else if ( exp instanceof LiteralExp ) {
            checkLiteralExp( (LiteralExp) exp );
        } else if ( exp instanceof IfExp ) {
            checkIfExp( (IfExp) exp );
        } else if ( exp instanceof VariableExp ) {
            checkVariableExp( (VariableExp) exp );
        } else if ( exp instanceof LetExp ) {
            checkLetExp( (LetExp) exp );
        } else if ( exp instanceof TypeExp ) {
            // checkLetExp((LetExp)exp);
        } else {
            fail( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * Checks well-formedness of PropertyCallExp and its subtypes.
     * 
     * @param exp
     */
    private void checkPropertyCallExp( PropertyCallExp exp ) {

        if ( exp instanceof PropertyCallExp ) {
            checkModelPropertyCallExp( (PropertyCallExp) exp );
        } else if ( exp instanceof LoopExp ) {
            checkLoopExp( (LoopExp) exp );
        } else {
            fail( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * Checks the well-formedness of a ModelPropertyCallExp and its subtypes.
     * 
     * @param exp
     */
    private void checkModelPropertyCallExp( PropertyCallExp exp ) {

        // no tests specified for this type

        // further tests depend on the subtype
        if ( exp instanceof PropertyCallExp ) {
            checkAttributeCallExp( (PropertyCallExp) exp );
        } else if ( exp instanceof NavigationCallExp ) {
            checkNavigationCallExp( (NavigationCallExp) exp );
        } else if ( exp instanceof OperationCallExp ) {
            checkOperationCallExp( (OperationCallExp) exp );
        } else {
            fail( "no test specified for " + exp.getClass( ) );
        }

    }

    /**
     * Checks the well-formedness of an AttributeCallExp
     * 
     * @param exp
     */
    private void checkAttributeCallExp( PropertyCallExp exp ) {

        // TODO Auto-generated method stub
        EClassifier cAttrExp = exp.getType( );
        if ( cAttrExp == null ) {
            fail( "PropertyCallExp must have a type" );
            return;
        }
        EStructuralFeature attr = exp.getReferredProperty();
        if ( attr == null  || (!(attr instanceof EAttribute))) {
            fail( "PropertyCallExp does not have a referredAttribute" );
            return;
        }
        EClassifier cAttr = attr.getEType( );
        if ( !cAttrExp.equals( cAttr ) && !( cAttr instanceof EStructuralFeature ) ) {
            fail( "PropertyCallExp does noth have the same type as its referred attribute" );
        }
        org.eclipse.ocl.expressions.OCLExpression<EClassifier> source = exp.getSource( );
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
    private void checkNavigationCallExp( NavigationCallExp exp ) {

        // an navigation source must be given
        if ( exp.getNavigationSource(  ) == null ) {
            // FIXME remove comment when navigationSource is fixed
            // flop("NavigationCallExp must have a navigationSource.");
        }

        // further test depend on the concrete subtype
        if ( exp instanceof PropertyCallExp ) {
            if ((PropertyCallExp) exp instanceof EReference)
            checkAssociationEndCallExp(  (EReference) exp);
        } else {
            fail( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * Checks the well-formedness of an AssociationCallExp.
     * 
     * @param exp
     */
    private void checkAssociationEndCallExp( EReference exp ) {

        // an AssociationEndCallExp must have a referredAssociationEnd
        if ( exp == null ) {
            fail( "AssociationEndCallExp must have a referredAssociationEnd!" );
        }
    }

    /**
     * Checks the well-formedness of a LiteralExp and its subtypes.
     * 
     * @param exp
     */
    private void checkLiteralExp( LiteralExp exp ) {

        if ( exp instanceof PrimitiveLiteralExp ) {
            checkPrimitiveLiteralExp( (PrimitiveLiteralExp) exp );
        } else if ( exp instanceof CollectionLiteralExp ) {
            checkCollectionLiteralExp( (CollectionLiteralExp) exp );
        } else if ( exp instanceof EnumLiteralExp ) {
            checkEnumLiteralExp( (EnumLiteralExp) exp );
        } else if ( exp instanceof TupleLiteralExp ) {
            checkTupleLiteralExp( (TupleLiteralExp) exp );
        } else {
            fail( "no test specified for " + exp.getClass( ) );
        }
    }

    /**
     * @param exp
     */
    private void checkTupleLiteralExp( TupleLiteralExp exp ) {

        // TODO Auto-generated method stub

    }

    /**
     * @param exp
     */
    private void checkEnumLiteralExp( EnumLiteralExp exp ) {

        // TODO implement em!
    }

    /**
     * @param exp
     */
    private void checkPrimitiveLiteralExp( PrimitiveLiteralExp exp ) {

        if ( exp instanceof BooleanLiteralExp ) {
            checkBooleanLiteralExp( (BooleanLiteralExp) exp );
        } else if ( exp instanceof RealLiteralExp ) {
            checkRealLiteralExp( (RealLiteralExp) exp );
        } else if ( exp instanceof StringLiteralExp ) {
            checkStringLiteralExp( (StringLiteralExp) exp );
        } else if ( exp instanceof IntegerLiteralExp ) {
            checkIntegerLiteralExp( (IntegerLiteralExp) exp );
        } else {
            fail( "no test specified for " + exp.getClass( ) );
        }
    }

    private void checkBooleanLiteralExp( BooleanLiteralExp exp ) {

        EClassifier cBool = exp.getType( );
        assertTrue( "BooleanLiteralExpession must have a type" , cBool != null);
        if ( cBool == null ) {
            return;
        }
        assertTrue( "Type of BooleanLiteralExp must be Boolean" , cBool.getName( ).equals( BOOLEAN ));

    }

    /**
     * Checks the well-formedness of a CollectionLiteralExp.
     * 
     * @param exp
     */
    private void checkCollectionLiteralExp( CollectionLiteralExp exp ) {

        EClassifier c = exp.getType(  );
        if ( c instanceof SetType ) {
            if ( !exp.getKind( ).equals( CollectionKind.SET ) ) {
                fail( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else if ( c instanceof SequenceType ) {
            if ( !exp.getKind( ).equals( CollectionKind.SEQUENCE ) ) {
                fail( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else if ( c instanceof BagType ) {
            if ( !exp.getKind( ).equals( CollectionKind.BAG ) ) {
                fail( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else if ( c instanceof OrderedSetType ) {
            if ( !exp.getKind( ).equals( CollectionKind.ORDERED_SET ) ) {
                fail( "Kind and Type properties of CollectionLiteralExp differ" );
            }
        } else {
            fail( "CollectionLiteralExp has an invalid type: " + c.getName( ) );
        }
        EList<CollectionLiteralPart<EClassifier>> parts = ( (CollectionLiteralExp) exp ).getPart( );
        for ( int i = 0, n = parts.size( ); i < n; i++ ) {
            CollectionLiteralPart<EClassifier> partExp = parts.get( i );
            // isConform(partExp.getType(), c);
            if ( partExp instanceof CollectionItem ) {
                CollectionItem item = (CollectionItem) partExp;
                if ( !item.getType( ).equals(  item.getItem( ).getType( ) ) ) {
                    fail( "The type of CollectionItem and CollectionItem.getItem must be the same" );
                }
                checkOclExpression( item.getItem( ) );
            } else if ( partExp instanceof CollectionRange ) {
                CollectionRange range = (CollectionRange) partExp;
                OCLExpression<EClassifier> firstExpr = range.getFirst( );
                OCLExpression<EClassifier> lastExpr = range.getLast( );
                if ( !isConform( ( firstExpr.getType( ) ), range.getType( ) ) ) {
                    fail( "The Type of first does not conform to the type of range" );
                }
                checkOclExpression( range.getFirst( ) );
                if ( !isConform( lastExpr.getType( ), range.getType( ) ) ) {
                    fail( "The Type of last does not conform to the type of range" );
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
    private boolean isConform( EClassifier c1, EClassifier c2 ) {

        // List superTypes1 = c1.allSupertypes();
        // return superTypes1.contains(c2);
        // FIXME implement me
        return true;
    }

    private void checkIfExp( IfExp ifExp ) {

        OCLExpression<EClassifier> cond = ifExp.getCondition( );
        // type of cond must be boolean
        EClassifier cCond = cond.getType( );

        assertTrue( "Condition of IfExp is not of type Boolean", cCond.getName( ).equals( BOOLEAN ) );

        OCLExpression<EClassifier> thenExp = ifExp.getThenExpression( );
        if ( thenExp == null ) {
            fail( "then expression is empty!" );
            return;
        }
        OCLExpression<EClassifier> elseExp = ifExp.getElseExpression( );
        if ( elseExp == null ) {
            fail( "else expression is empty!" );
            return;
        }
        EClassifier cThen = thenExp.getType( );
        EClassifier cElse = elseExp.getType( );
        EClassifier cIf = ifExp.getType( );
        if ( cIf == null ) {
            fail( "if expression does not have a type" );
        }
        if ( cThen == null ) {
            fail( "then expression does not have a type" );
        }
        if ( cElse == null ) {
            fail( "Else expression does not have a type" );
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
    private void checkIntegerLiteralExp( IntegerLiteralExp exp ) {

        EClassifier cInt = exp.getType( );
        if ( cInt == null ) {
            fail( "IntegerLiteralExp must have a type" );
            return;
        }
        assertTrue( "Type of IntegerLiteralExp must be Integer" , cInt.getName( ).equals( INTEGER ) );
    }

    /**
     * @param exp
     */
    private void checkLoopExp( LoopExp exp ) {

        OCLExpression<EClassifier> source = exp.getSource( );
        if ( source == null ) {
            fail( "LoopExp does not have a source" );
            return;
        }
        EClassifier cSource = source.getType( );
        if ( !( cSource instanceof CollectionType ) ) {
            fail( "Source of LoopExp must be of type CollectionType" );
        }

        CollectionType col = (CollectionType) cSource;
        EList<Variable<EClassifier, EParameter>> iterators = null;
        if ( exp instanceof IterateExp ) {
            iterators = ( (IterateExp) exp ).getIterator( );
        } else {
            iterators = ( (IteratorExp) exp ).getIterator( );
        }
        for ( Iterator<Variable<EClassifier, EParameter>> i = iterators.iterator( ); i.hasNext( ); ) {
            Variable<EClassifier, EParameter> varDecl = i.next( );
            if ( varDecl.getInitExpression( ) != null ) {
                fail( "VariableDeclarations of LoopExp are not allowed to have an initExpression." );
            }
            if ( !varDecl.getType( ).equals( ( (CollectionType) col ).getElementType( ) ) ) {
                fail( "Iterator of an LoopExp and the collection's elements must be of the same type" );
            }
            checkVariableDeclaration( varDecl );
        }

        if ( exp instanceof IterateExp ) {
            checkIterateExp( (IterateExp) exp );
            checkOclExpression( ( (IterateExp) exp ).getBody( ) );
            checkOclExpression( ( (IterateExp) exp ).getSource( ) );
        } else if ( exp instanceof IteratorExp ) {
            checkIteratorExp( (IteratorExp) exp );
            checkOclExpression( ( (IteratorExp) exp ).getBody( ) );
            checkOclExpression( ( (IteratorExp) exp ).getSource( ) );
        }
    }

    /**
     * Checks the well-formedness of an IterateExp
     * 
     * @param exp
     */
    private void checkIterateExp( IterateExp exp ) {

        // the type of the iterate is the type of the return variable
        Variable<EClassifier, EParameter> varDecl = exp.getResult( );
        if ( !exp.getType( ).equals( varDecl.getType( ) ) ) {
            fail( "the type of the iterate is the type of the return variable" );
        }
        // the type of the body must conform to the type of the result variable
        if ( !isConform( ( exp.getBody( ) ).getType( ), varDecl.getType( ) ) ) {
            fail( "the type of the body must conform to the type of the result variable" );
        }
        // a result variable must have an init expression
        if ( varDecl.getInitExpression( ) == null ) {
            fail( "a result variable must have an init expression" );
        }
        checkVariableDeclaration( varDecl );

    }

    /**
     * @param exp
     */
    private void checkIteratorExp( IteratorExp exp ) {

        // the body of forAll, isUnique and exists must be of type boolean
        if ( exp.getName( ) == null ) {
            fail( "IteratorExp must have a name" );
        }
        if ( exp.getName( ).equals( "forAll" ) || exp.getName( ).equals( "isUnique" ) || exp.getName( ).equals( "exists" ) ) {
            assertTrue( "the iterator of 'forAll', 'isUnique', 'exists' must be of type 'Boolean'. Type is: '" + exp.getType( ) + "'" , exp.getType( ).getName( ).equals( BOOLEAN ));

        }
        // the result type of the collect operation on a sequence type is a
        // sequence
        // on any other type it is a bag
        if ( exp.getName( ).equals( "collect" ) ) {
            if ( ( exp.getSource( ) ).getType( ) instanceof SequenceType ) {
                if ( !( exp.getType( ) instanceof SequenceType ) ) {
                    fail( "the result of a collect operation on a sequence must be a sequence" );
                }
            } else {
                if ( !( exp.getType( ) instanceof BagType ) ) {
                    fail( "the result of a collect operation on a non-sequence must be a bag" );
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
            EClassifier elemType = exp.getType( );
            EClassifier bodyType = exp.getBody( ).getType( );
            if ( bodyType instanceof CollectionType ) {
                bodyType = flattenedType( bodyType );
            }
            if ( !bodyType.equals( elemType ) ) {
                fail( "for a collect operation the elements of the return collection and the body must be of the same type" );
            }
        }
        if ( exp.getName( ).equals( "collect" ) || exp.getName( ).equals( "select" ) || exp.getName( ).equals( "reject" ) ) {
            if ( !( exp.getType( ) instanceof CollectionType ) ) {
                fail( "The type of '" + exp.getName( ) + "' must be a subtype of CollectionTyp. It is of type '" + exp.getType( ) + "'" );
            }
        }

        // 'select' and 'reject' must have the same type as its source
        if ( exp.getName( ).equals( "select" ) || exp.getName( ).equals( "reject" ) ) {
            if ( !exp.getType( ).equals( ( exp.getSource( ) ).getType( ) ) ) {
                fail( "'select' and 'reject' must have the same type as its source." );
            }
        }
        // the body of select, reject, exists, forAll must be of type boolean
        if ( exp.getName( ).equals( "select" ) || exp.getName( ).equals( "reject" ) || exp.getName( ).equals( "exists" ) || exp.getName( ).equals( "forAll" ) ) {
            assertTrue( "the body of 'select', 'reject', 'exists' and 'forAll' must be of type 'Boolean'" , exp.getBody( ).getType( ).getName( ).equals( BOOLEAN ));
        }

    }

    /**
     * checks the well-formedness of an LetExp i.e.: type != null, variable !=
     * null, in != null, type == in.type
     * 
     * @param exp
     */
    private void checkLetExp( LetExp exp ) {

        EClassifier cLet = exp.getType( );
        if ( cLet == null ) {
            fail( "let expression must have a type" );
        }
        Variable<EClassifier, EParameter> decl = exp.getVariable( );
        if ( decl == null ) {
            fail( "let expression does not have a variable declaration" );
        }
        OCLExpression<EClassifier> inExp = exp.getIn( );
        if ( inExp == null ) {
            fail( "in expression of let expression is not allowed to be empty" );
            return;
        }
        EClassifier cIn = inExp.getType( );
        if ( !cIn.equals( cLet ) ) {
            fail( "let expression and in expression must have the same type" );
        }

        checkVariableDeclaration( decl );

        checkOclExpression( inExp );
    }

    /**
     * checks the well-formedness of an OperationCallExp i.e.: type != null,
     * referredOperation != null, #arguments = operation.#arguments, the return
     * type of Operation conforms to the type of OperationCallExp, each argument
     * of OperationCallExp conforms to the corresponding argument of Operation.
     * 
     * @param exp
     */
    private void checkOperationCallExp( OperationCallExp exp ) {

        // check type
        EClassifier cOpExp = exp.getType( );
        if ( cOpExp == null ) {
            fail( "OperationCallExp does not have a type" );
        }
        // check operation
        EOperation op = exp.getReferredOperation( );
        if ( op == null ) {
            fail( "OperationiCall does not refer to an operation" );
        }
        EList<OCLExpression<EClassifier>> opCallParams = exp.getArgument( );
        
        // the return type
        // a list of parameters
        EClassifier returnType = op.getEType();
        EList<EParameter> opParams = op.getEParameters( );
         
        // check the number of arguments
        if ( !exp.getName( ).equals( "oclIsTypeOf" ) && !exp.getName( ).equals( "oclIsKindOf" ) && !exp.getName( ).equals( "oclAsType" ) ) {
            // oclIsTypeOf, oclIsKindOf, oclAsType are treated differently
            if ( opParams.size( ) != opCallParams.size( ) ) {
                fail( "OperationCallExp and Operation do not have the same number of parameters" );
            }
        }
        // there must be exactly one return type
        if ( returnType == null ) {
            fail( "Operation has wrong return type" );
        }

        // the return type must conform to the type of OperationCallExp
        if ( !isConform( returnType, cOpExp ) ) {
            fail( "OperationCallExp and the return type of Operation must be the same" );
        }
        // check each parameter whether each parameter of OperationCallExp
        // conforms to
        // the corresponding parameter of Operation
        if ( !exp.getName( ).equals( "oclIsTypeOf" ) && !exp.getName( ).equals( "oclIsKindOf" ) && !exp.getName( ).equals( "oclAsType" ) ) {
            // oclIsTypeOf, oclIsKindOf, oclAsType are treated differently
            for ( int i = 0; i < opParams.size( ); i++ ) {
                EClassifier cParamOpCall = ( opCallParams.get( i ) ).getType(  );
                EClassifier cParamOp = ( opParams.get( i ) ).getEType( );
                if ( !isConform( cParamOpCall, cParamOp ) ) {
                    fail( "Parameters of OperationCallExp does not conform to paramters of Operation" );
                }
            }
        }
        // check agruments of OperationCallExp
        EList<OCLExpression<EClassifier>> args = exp.getArgument( );
        for ( int i = 0, n = args.size( ); i < n; i++ ) {
            checkOclExpression( args.get( i ) );
        }
        // check source of operation call expression
        OCLExpression<EClassifier> source = exp.getSource( );
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
    private void checkRealLiteralExp( RealLiteralExp exp ) {

        EClassifier cReal = exp.getType( );
        if ( cReal == null ) {
            fail( "RealLiteralExp must have a type" );
            return;
        }
        assertTrue( "Type of RealLiteralExp must be Double" , cReal.getName( ).equals( DOUBLE ) );
    }

    /**
     * checks the well-formedness of a StringLiteralExp i.e.: type = String,
     * stringSymbol != null
     * 
     * @param exp
     */
    private void checkStringLiteralExp( StringLiteralExp exp ) {

        EClassifier cString = exp.getType( );
        if ( cString == null ) {
            fail( "StringLiteralExp must have a type" );
            return;
        }
        assertTrue( "Type of StringLiteralExp must be String" , cString.getName( ).equals( STRING ));

        String value = exp.getStringSymbol( );
        if ( value == null ) {
            fail( "StringLiteralExp must have a stringSymbol" );
        }
    }

    /**
     * checks the well-formedness of a VariableDeclaration i.e.: type != null,
     * varName != null and ((init != null) implies (init.type conformsTo type))
     * 
     * @param decl
     */
    private void checkVariableDeclaration( org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> decl ) {

        EClassifier cDecl = decl.getType( );
        if ( cDecl == null ) {
            fail( "VariableDeclaration does not have a type" );
        }
        String varName = decl.getName( );
        if ( varName == null ) {
            fail( "no variable name defined in variable declaration" );
        }
        OCLExpression<EClassifier> init = decl.getInitExpression( );
        if ( init != null ) {
            // this variable declaration has an init expression
            EClassifier cInit = init.getType( );
            if ( cInit == null ) {
                fail( "init expression does not have a type" );
            }
            if ( !isConform( cInit, cDecl ) ) {
                fail( "type of init expression does not conform to type of variable declaration" );
            }
            checkOclExpression( init );
        }
    }

    /**
     * @param exp
     */
    private void checkVariableExp( VariableExp exp ) {


        EClassifier cVar = exp.getType( );
        if ( cVar == null ) {
            fail( "VariableExp does not have a type" );
            return;
        }
        org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> decl = exp.getReferredVariable( );
        if ( decl == null ) {
            fail( "VariableExp does not have a VariableDeclaration" );
            return;
        }
        EClassifier cDecl = decl.getType( );
        if ( !cVar.equals( cDecl ) ) {
            fail( "Type of VariableExp and type ofVariableDeclaration must be the same" );
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

    private EClassifier flattenedType( EClassifier type ) {

        if ( type instanceof CollectionType ) {
            return flattenedType( ( (CollectionType) type ).getElementType( ) );
        }
        return type;
    }
}