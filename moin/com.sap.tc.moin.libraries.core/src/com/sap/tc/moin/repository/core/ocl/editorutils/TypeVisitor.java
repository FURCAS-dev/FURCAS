package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstantInternal;

import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;

import com.sap.tc.moin.ocl.parser.IOCLEnvironment;
import com.sap.tc.moin.ocl.parser.gen.oclAst.BodyDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.DefDeclaration;
import com.sap.tc.moin.ocl.parser.gen.oclAst.DeriveValue;
import com.sap.tc.moin.ocl.parser.gen.oclAst.ExpDeclaration;
import com.sap.tc.moin.ocl.parser.gen.oclAst.InvDeclaration;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IterateVarDeclAndAcc;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorOneVarDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorTwoVarDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.gen.oclAst.OclFileOclExpression;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PostConditionDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PreConditionDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeBoolean;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeDouble;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeFloat;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeInteger;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeOclAny;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeOclInvalid;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeOclVoid;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeReal;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrimTypeString;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Variable;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableAssignment;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableAssignmentN;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableAssignmentWithType;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclarationWithType;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclarationWithTypeN;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.parser.impl.env.OCLLookupTables;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;

/**
 * Can return the type of the current expression. In addition, it can return the
 * variables of the last checked expression. Re-uses the {@link OCLEnvironment}
 * when parsing subexpressions as adding "self" again would create a new
 * variable scope which would be wrong here.
 */
public class TypeVisitor extends EditorParsingVisitor {

    private Classifier type = null;

    private Set<VariableDeclarationInternal> variableDecls = new HashSet<VariableDeclarationInternal>( 0 );

    /**
     * Creates a new Transformation
     * 
     * @param actEnvironment the Environment
     */
    public TypeVisitor( IOCLEnvironment actEnvironment ) {

        super( actEnvironment, new OCLTypeChecker( actEnvironment.getJmiCreator( ) ), new OCLLookupTables( actEnvironment.getJmiCreator( ) ) );

    }

    /**
     * Returns the last type.
     * 
     * @return the classifier
     */
    public Classifier getType( ) {

        return this.type;
    }

    /**
     * Returns the last type.
     * 
     * @return the variable declaration
     */
    public Set<VariableDeclarationInternal> getVariables( ) {

        return this.variableDecls;
    }



    /*
     * VISITORS
     */



    @Override
    /*
     * <b> <li>collectionType ::= collectionKind ( typePathName ) </b>
     */
    public void visit( com.sap.tc.moin.ocl.parser.gen.oclAst.CollectionType n ) {

        super.visit( n );
        this.type = (Classifier) getUpProperty( n );
    }



    @Override
    /*
     * <b> <li> oclFile ::= oclExpression </b>
     */
    public void visit( OclFileOclExpression n ) {

        n.getoclExpression( ).accept( this );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        if ( exp != null ) {
            this.type = ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) );
        } else {
            this.type = null;
        }

    }



    @Override
    /*
     * <b> <li>initOrDerValue ::= derive : oclExpression </b>
     */
    public void visit( DeriveValue n ) {

        super.visit( n );
        setTypeFromStatements( );
    }


    @Override
    /*
     * <b> <li>invOrDef ::= def identifierOpt : defExpression </b>
     */
    public void visit( DefDeclaration n ) {

        super.visit( n );
        setTypeFromStatements( );
    }



    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= body identifierOpt : oclExpression </b>
     */
    public void visit( BodyDecl n ) {

        super.visit( n );
        setTypeFromStatements( );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= pre identifierOpt : oclExpression </b>
     */
    public void visit( PreConditionDecl n ) {

        super.visit( n );
        setTypeFromStatements( );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= post identifierOpt : oclExpression </b>
     */
    public void visit( PostConditionDecl n ) {

        super.visit( n );
        setTypeFromStatements( );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= inv identifierOpt : oclExpression </b>
     */
    public void visit( InvDeclaration n ) {

        super.visit( n );
        setTypeFromStatements( );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= exp identifierOpt : oclExpression </b>
     */
    public void visit( ExpDeclaration n ) {

        super.visit( n );
        setTypeFromStatements( );
    }

    @Override
    /*
     * <b> <li>iterateExp ::= iterate ( variableDeclaration ; variableAssignment
     * | oclExpression ) </b>
     */
    public void visit( IterateVarDeclAndAcc n ) {

        super.visit( n );

        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) getUpProperty( n.getvariableDeclaration( ) ) );
        this.variableDecls.add( (VariableDeclarationInternal) getUpProperty( n.getvariableAssignment( ) ) );

    }

    @Override
    /*
     * <b> <li>iterContents ::= variableDeclaration | oclExpression </b>
     */
    public void visit( IteratorOneVarDecl n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n.getvariableDeclaration( ) ) );
    }


    @Override
    /*
     * <b> <li>iterContents ::= variableDeclaration , variableDeclaration |
     * oclExpression </b>
     */
    public void visit( IteratorTwoVarDecl n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n.getvariableDeclaration( ) ) );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n.getvariableDeclaration3( ) ) );

    }

    @Override
    /*
     * <b> <li>primitiveType ::= Boolean </b>
     */
    public void visit( PrimTypeBoolean n ) {

        this.setUpProperty( n, this.boolType );
        this.type = this.boolType;
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Integer </b>
     */
    public void visit( PrimTypeInteger n ) {

        this.setUpProperty( n, this.integerType );
        this.type = this.integerType;
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Double </b>
     */
    public void visit( PrimTypeDouble n ) {

        this.setUpProperty( n, this.doubleType );
        this.type = this.doubleType;
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Float </b>
     */
    public void visit( PrimTypeFloat n ) {

        this.setUpProperty( n, this.floatType );
        this.type = this.floatType;
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclInvalid </b>
     */
    public void visit( PrimTypeOclInvalid n ) {

        this.setUpProperty( n, this.jmiCreator.getOclInvalidClass( ) );
        this.type = this.jmiCreator.getOclInvalidClass( );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclAny </b>
     */
    public void visit( PrimTypeOclAny n ) {

        this.setUpProperty( n, this.jmiCreator.getAnyClass( ) );
        this.type = this.jmiCreator.getAnyClass( );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclVoid </b>
     */
    public void visit( PrimTypeOclVoid n ) {

        this.setUpProperty( n, this.jmiCreator.getOclVoidClass( ) );
        this.type = this.jmiCreator.getOclVoidClass( );
    }

    @Override
    /*
     * <b> <li>Rule 35: primitiveType ::= Real </b>
     */
    public void visit( PrimTypeReal n ) {

        this.setUpProperty( n, this.floatType );
        this.type = this.floatType;
    }

    @Override
    /*
     * <b> <li>primitiveType ::= String </b>
     */
    public void visit( PrimTypeString n ) {

        this.setUpProperty( n, this.stringType );
        this.type = this.stringType;
    }


    @Override
    /*
     * <b> <li>varPathName ::= sPathName timeExpressionOpt
     * associationQualifierOpt</b>
     */
    public void visit( Variable n ) {

        // here is some guesswork necessary, as we dont exactly what we've found
        // 1) could be a type literal, then the type was already looked up. we
        // just have to create the type exp
        // 2) could be a "normal" variable
        // 3) could be an access to an implicit feature, i.e. attribute or
        // association end
        // 4) could be a globally defined constant
        // 5) could be an enumeration literal

        n.getpathName( ).accept( this );
        List<String> pathName = null;

        OclExpression exp = null;

        Object o = this.getUpProperty( (Node) n.getpathName( ) );
        if ( o instanceof List ) {
            // ok, we've got a pathname, now we have to guess...
            pathName = (List<String>) o;
        } else {
            // impossible
            this.reportInternalError( n, OclParserMessages.VARPATHNAMEMUSTBELIST );
            return;
        }

        // TODO this is from the supertype; we might have to adjust this
        // TODO (disambiguiting for association end names)
        String containerName = null;
        if ( this.hasUpProperty( (Node) n.getpathName( ), OclConstants.N_CONTAINERNAME ) ) {
            containerName = (String) this.getUpProperty( (Node) n.getpathName( ), OclConstants.N_CONTAINERNAME );
        }

        if ( pathName.size( ) == 1 ) {
            // could be a variable or an implicit access to a feature
            exp = this.varOrImplFeature( pathName.get( 0 ), n.gettimeExpressionOpt( ), n.getassociationQualifierOpt( ), n );
            if ( exp != null ) {
                this.setUpProperty( n, exp );
                return;
            }
        }

        // From here, both time expr and assoc qualifier have to be null no
        // assoc qualifier allowed
        if ( n.getassociationQualifierOpt( ) != null ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1020 ), n );
        }

        if ( n.gettimeExpressionOpt( ) != null ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1021 ), n );
        }

        // It could be a type
        Classifier c = this.env.lookupClassifierByPathName( pathName );
        if ( c != null ) {
            try {
                exp = this.jmiCreator.createTypeExp( c );
                this.setUpProperty( n, exp );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
            return;
        }

        // maybe it is a constant
        Constant cs = this.env.lookupConstantByPathName( pathName );
        if ( cs != null ) {

            try {
                String typeName = ( (ConstantInternal) cs ).getType( this.jmiCreator.getConnection( ) ).getName( );

                if ( !( ( (ConstantInternal) cs ).getType( this.jmiCreator.getConnection( ) ) instanceof PrimitiveType ) ) {
                    throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0715, StringHelper.toPathName( pathName ), StringHelper.toString( ( (ConstantInternal) cs ).getType( this.jmiCreator.getConnection( ) ) ) );
                }

                if ( typeName.equals( OclConstants.T_STRING ) ) {
                    exp = this.jmiCreator.createStringLiteralExp( cs.getValue( ) );
                } else if ( typeName.equals( OclConstants.T_BOOLEAN ) ) {
                    exp = this.jmiCreator.createBooleanLiteralExp( cs.getValue( ) );
                } else if ( typeName.equals( OclConstants.T_INTEGER ) || typeName.equals( OclConstants.T_LONG ) ) {
                    exp = this.jmiCreator.createIntegerLiteralExp( cs.getValue( ) );
                } else if ( typeName.equals( OclConstants.T_REAL ) || typeName.equals( OclConstants.T_FLOAT ) || typeName.equals( OclConstants.T_DOUBLE ) ) {
                    exp = this.jmiCreator.createRealLiteralExp( cs.getValue( ) );
                } else {
                    this.reportInternalError( n, OclParserMessages.UNEXPECTEDPRIMTYPEFORCONST );
                }
                this.setUpProperty( n, exp );
                return;
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        // It could be an enumeration. For an enumeration, we have to drop the
        // label bit of the path
        if ( pathName.size( ) >= 2 ) {
            ModelElement me = this.env.lookupModelElementByPathName( pathName.subList( 0, pathName.size( ) - 1 ) );
            if ( me != null && me instanceof EnumerationType ) {

                EnumerationType enumType = (EnumerationType) me;
                String enumLiteral = pathName.get( pathName.size( ) - 1 );
                if ( enumType.getLabels( ).contains( enumLiteral ) ) {
                    // the enumeration has a literal with the specified name
                    // create the EnumLiteralExp.
                    try {
                        exp = this.jmiCreator.createEnumLiteralExp( enumType, enumLiteral );
                        this.setUpProperty( n, exp );
                    } catch ( OclSemanticException e ) {
                        this.reportInternalError( e, n );
                    }
                    return;
                }
                // this enumeration does not have the specified enumeration
                // literal                    
                reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0103, new Object[] { StringHelper.toPathName( pathName.subList( 0, pathName.size( ) - 1 ) ), enumLiteral } ), n );
                return;
            }
        }

        // nothing worked :-(
        this.noIdentifierFound( pathName, n );
    }

    @Override
    /*
     * <b> <li>variableDeclaration ::= identifier withTypeExpressionOpt </b>
     */
    public void visit( com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclaration n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n ) );
    }

    @Override
    /*
     * <b> <li>variableAssignment ::= identifier withTypeExpressionOpt =
     * oclExpression </b>
     */
    public void visit( VariableAssignment n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n ) );

    }

    @Override
    /*
     * <b> <li>variableAssignmentWithType ::= identifier withTypeExpression =
     * oclExpression </b>
     */
    public void visit( VariableAssignmentWithType n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n ) );
    }

    @Override
    /*
     * <b> <li>variableDeclarationWithType ::= identifier withTypeExpression
     * </b>
     */
    public void visit( VariableDeclarationWithType n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.add( (VariableDeclarationInternal) this.getUpProperty( n ) );
    }

    @Override
    /*
     * <b> <li>variableAssignmentN ::= variableAssignment , variableAssignmentN
     * </b>
     */
    public void visit( VariableAssignmentN n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.addAll( (List<VariableDeclarationInternal>) this.getUpProperty( n ) );
    }

    @Override
    /*
     * <b> <li>variableDeclarationWithTypeN ::= variableDeclarationWithType ,
     * variableDeclarationWithTypeN </b>
     */
    public void visit( VariableDeclarationWithTypeN n ) {

        super.visit( n );
        this.variableDecls.clear( );
        this.variableDecls.addAll( (List<VariableDeclarationInternal>) this.getUpProperty( n ) );
    }


    private void setTypeFromStatements( ) {

        if ( super.getStatements( ).size( ) != 1 ) {
            this.type = null;
        }
        this.type = ( (OclExpressionInternal) super.getStatements( ).iterator( ).next( ).getExpression( ) ).getType( this.jmiCreator.getConnection( ) );
    }

    /**
     * 
     */
    public void clear( ) {

        this.type = null;
        super.getStatements( ).clear( );
        this.variableDecls.clear( );
        clearReport( );

    }

    /**
     * 
     */
    public void clearReport( ) {

        this.env.getReport( ).getErrors( ).clear( );
        this.env.getReport( ).getWarnings( ).clear( );
        this.report = this.env.getReport( );
    }

}