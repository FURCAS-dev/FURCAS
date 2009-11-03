package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.stdlibrary.StdLibraryPackage;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;

import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.ocl.parser.IOCLEnvironment;
import com.sap.tc.moin.ocl.parser.IOCLLookupTables;
import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Arguments;
import com.sap.tc.moin.ocl.parser.gen.oclAst.ContextDeclarations;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Iarguments;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IiterContents;
import com.sap.tc.moin.ocl.parser.gen.oclAst.InitOrDerValueN;
import com.sap.tc.moin.ocl.parser.gen.oclAst.InvOrDefs;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IoclExpression;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IpathName;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorOneVarDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorTwoVarDecl;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.gen.oclAst.OperationCall;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PackageDeclarations;
import com.sap.tc.moin.ocl.parser.gen.oclAst.PrePostOrBodyDecls;
import com.sap.tc.moin.ocl.parser.gen.oclAst.TimeExpressionOpt;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableAssignmentWithType;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclaration;
import com.sap.tc.moin.ocl.parser.gen.oclAst.WithTypeExpression;
import com.sap.tc.moin.ocl.parser.impl.OclAstBuilder;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * The error-tolerant parser for the OCL Editor helper This can compute
 * proposals for fixes and does a special treatment if no proposal was found
 */
public class EditorParsingVisitor extends OclAstBuilder {

    /**
     * @param actEnvironment the Environment
     * @param actTypeChecker the checker
     * @param actLookupTables the lookup
     */
    public EditorParsingVisitor( IOCLEnvironment actEnvironment, IOCLTypeChecker actTypeChecker, IOCLLookupTables actLookupTables ) {

        super( actEnvironment, actTypeChecker, actLookupTables );

    }

    /**
     * Handles an implicit operation call, i.e. one that operates implicitly on
     * a source
     */
    @Override
    protected void implicitOperationCall( OperationCall n ) {

        TimeExpressionOpt te = n.gettimeExpressionOpt( );
        IpathName pn = n.getpathName( );
        Iarguments origArgs = n.getarguments( );

        pn.accept( this );
        List<OclExpression> args;
        try {
            origArgs.accept( this );
            args = (List<OclExpression>) this.getUpProperty( (Node) origArgs );
        } catch ( RuntimeException e ) {
            args = new ArrayList<OclExpression>( 0 );
        }

        List<String> pathName = (List<String>) this.getUpProperty( (Node) pn );

        // obtain the name of the path which cannot be qualified
        String name = this.getNamePart( pathName, -1, (Node) pn, new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0003, new Object[] { StringHelper.toPathName( pathName ) } ) );

        List<Classifier> argTypes = this.getTypesForArgs( args );

        this.handleImplicitCallExpression( name, argTypes, args, te, n );
    }

    /**
     * Handles an explicit operation call, i.e. the operation is directly called
     * on a source (can only be a MOF operation)
     */
    @Override
    protected void explicitOperationCall( OclExpression source, OperationCall n ) {

        TimeExpressionOpt te = n.gettimeExpressionOpt( );
        IpathName pn = n.getpathName( );
        Iarguments origArgs = n.getarguments( );

        pn.accept( this );
        List<OclExpression> args;
        try {
            origArgs.accept( this );
            args = (List<OclExpression>) this.getUpProperty( (Node) origArgs );
        } catch ( RuntimeException e ) {
            args = new ArrayList<OclExpression>( 0 );
        }
        List<String> pathName = (List<String>) this.getUpProperty( (Node) pn );

        // obtain the name of the path which cannot be qualified
        String opName = this.getNamePart( pathName, -1, (Node) pn, new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0003, new Object[] { StringHelper.toPathName( pathName ) } ) );

        // and the argument types
        List<Classifier> argTypes = this.getTypesForArgs( args );

        this.handleOperationCall( source, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), opName, argTypes, args, te, n, n.getarguments( ) );
    }

    /**
     * Handles an operation call where the source is explicit and known.
     */
    @Override
    protected void handleOperationCall( OclExpression originalSource, Classifier originalSourceType, String name, List<Classifier> argTypes, List<OclExpression> args, TimeExpressionOpt te, Node n, Iarguments nArgs ) {

        // some built-in types require special treatment

        if ( name.equals( OclConstants.OP_OCLISNEW ) && this.stereotype != POST_CONDITION ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0303 ), n );

        } else if ( name.equals( OclConstants.OP_OCLASTYPE ) && args.size( ) == 1 && args.get( 0 ) instanceof TypeExp ) {
            // in case of oclAsType, the referred type need to be conform to the
            // type or the other way around
            Classifier referredType = ( (TypeExpInternal) args.get( 0 ) ).getReferredType( this.jmiCreator.getConnection( ) );
            if ( !( this.checkTypesConform( originalSourceType, referredType ) || this.checkTypesConform( referredType, originalSourceType ) ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0717, new Object[] { StringHelper.toPathName( referredType.getQualifiedName( ) ), StringHelper.toPathName( originalSourceType.getQualifiedName( ) ) } ), (Node) nArgs );
            }
        }

        boolean withAtPre = this.handleWithAtPre( te, n );
        Operation op;
        try {
            op = this.lookupOperation( name, originalSourceType, argTypes, n );
        } catch ( RuntimeException e ) {
            ModelElement me;
            try {
                me = MoinMetamodelCode.lookupElementExtended( this.jmiCreator.getConnection( ), originalSourceType, (RefObjectImpl) originalSourceType, name );
                if ( me instanceof Operation ) {
                    op = (Operation) me;
//                    List<Parameter>
//                    List<ModelElement> content = op.getContents( );

                } else {
                    throw e;
                }
            } catch ( JmiException e1 ) {
                throw e;
            } catch ( NameNotFoundException e1 ) {
                throw e;
            }

        }
        OclExpression exp = null;
        try {
            exp = this.jmiCreator.createOperationCallExp( op, originalSource, args );

            if ( withAtPre ) {
                this.setDownProperty( n, exp );
                te.accept( this );
                exp = (OclExpression) this.getUpProperty( n );
            }

        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        this.setUpProperty( n, exp );
    }

    /**
     * Returns a list of Types for a list of OclExressions
     */
    private List<Classifier> getTypesForArgs( List<OclExpression> args ) {

        List<Classifier> argTypes = new ArrayList<Classifier>( );
        for ( OclExpression e : args ) {
            argTypes.add( ( (OclExpressionInternal) e ).getType( this.jmiCreator.getConnection( ) ) );
        }
        return argTypes;
    }

//    /**
//     * A wrapper method for
//     * {@link com.sap.tc.moin.ocl.parser.impl.env.Environment#lookupOperation(Classifier, String, List)}
//     */
//    protected Operation lookupOperation( String name, Classifier type, List<Classifier> argTypes, Node n ) {
//
//        // the list of messages, a warning in position 0 and an error in
//        // position 1
//        OclSemanticException[] messages = new OclSemanticException[2];
//        Operation op = this.oclLookupTables.lookupOperation( type, name, argTypes, this.oclTypeChecker, messages );
//
//        // first check if we actually found an operation
//        if ( op == null ) {
//            // we did not find an operation, see if we have a better error
//            // message
//            if ( messages[1] != null ) {
//                this.reportFixableFatalOCLError( messages[1], n, FixableProcessError.PROPOSAL, null, FixableProcessError.TYPE.OPERATION );
//            } else {
//                this.reportFixableFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0402, new Object[] { name, StringHelper.toString( type ), StringHelper.toString( argTypes ) } ), n, FixableProcessError.PROPOSAL, null, FixableProcessError.TYPE.OPERATION );
//            }
//        }
//
//        // we have an operation, deal with warnings
//
//        // provided during lookup
//        if ( messages[0] != null ) {
//            this.reportWarning( messages[0], n );
//        }
//
//        // test whether op is side-effect free
//        if ( !op.isQuery( ) ) {
//            this.reportWarning( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1017, new Object[] { name, StringHelper.toString( argTypes ) } ), n );
//        }
//        return op;
//    }

    /**
     * Constructs the infix operator based on the two arguments and the
     * operation name
     */
    @Override
    protected void infixOperation( String opName, IoclExpression child1, IoclExpression child2, Node n ) {

        // visit children
        RuntimeException exc = null;
        try {
            child1.accept( this );
        } catch ( RuntimeException e ) {
            exc = e;
        }
        try {
            child2.accept( this );
        } catch ( RuntimeException e ) {
            if ( exc == null ) {
                exc = e;
            }
        }
        if ( exc != null ) {
            throw exc;
        }

        // get children's results
        OclExpression source = (OclExpression) this.getUpProperty( (Node) child1 );
        OclExpression arg = (OclExpression) this.getUpProperty( (Node) child2 );

        OclExpression exp = null;
        // special handling for concatenation possible with strings
        if ( opName.equals( OclConstants.A_PLUS ) ) {
            exp = this.manageSpecialStringconcatenation( source, arg, (Node) child1 );
        } else {
            // get the operation
            Operation op = this.lookupOperation( opName, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), ( (OclExpressionInternal) arg ).getType( this.jmiCreator.getConnection( ) ), (Node) child1 );
            try {
                exp = this.jmiCreator.createOperationCallExp( op, source, arg );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        // pass the result up the tree
        this.setUpProperty( n, exp );
    }

    @Override
    protected OclExpression implVarIterator( OclExpression source, String opName, IiterContents iterContents, Node n ) {

        CoreConnection conn = this.jmiCreator.getConnection( );
        Classifier elmType = ( (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( conn ) ).getElementType( conn );
        org.omg.ocl.expressions.VariableDeclaration var = null;
        try {
            var = this.defineVariable( OclConstants.EMPTY, elmType, null, true, true );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, (Node) iterContents );
        }
        iterContents.accept( this );

        OclExpression body = (OclExpression) this.getUpProperty( (Node) iterContents );
        OclExpression exp = null;
        try {
            exp = this.jmiCreator.createIteratorExp( opName, source, var, null, body );
        } catch ( OclSemanticException e ) {
            if ( opName.equals( OclConstants.OP_FORALL ) || opName.equals( OclConstants.OP_ONE ) || opName.equals( OclConstants.OP_EXISTS ) || opName.equals( OclConstants.OP_ISUNIQUE ) ) {
                try {
                    exp = this.jmiCreator.createBooleanLiteralExp( OclConstants.TRUE );
                } catch ( OclSemanticException e1 ) {
                    // $JL-EXC$ ignore here
                }
            } else if ( opName.equals( OclConstants.OP_SELECT ) || opName.equals( OclConstants.OP_REJECT ) ) {
                exp = source;
            } else if ( opName.equals( OclConstants.OP_ANY ) ) {
                exp = source;
                this.jmiCreator.changeType( exp, elmType );
            }

            if ( exp == null ) {
                reportFatalOCLError( e, n );
            }
            this.reportFatalError( e, n );

        }

        this.env.leaveVariableScope( );

        return exp;
    }

    @Override
    protected OclExpression oneVarIterator( OclExpression source, String opName, IteratorOneVarDecl iterContents, Node n ) {

        // evaluate the iterContents
        this.setDownProperty( iterContents, source );

        boolean correct = true;

        OclExpression body = null;
        OclExpression exp = null;
        // has exactly one variable declaration
        org.omg.ocl.expressions.VariableDeclaration iter1 = null;
        RuntimeException collectReason = null;
        try {
            iterContents.accept( this );
            iter1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration( ) );
            body = (OclExpression) this.getUpProperty( (Node) iterContents.getoclExpression( ) );
        } catch ( RuntimeException e2 ) {
            correct = false;
            collectReason = e2;
        }

//        // has exactly one variable declaration
//        org.omg.ocl.expressions.VariableDeclaration iter1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration( ) );
//
//        // obtain the body
//        OclExpression body = (OclExpression) this.getUpProperty( (Node) iterContents.getoclExpression( ) );
//
//        OclExpression exp = null;
        try {
            exp = this.jmiCreator.createIteratorExp( opName, source, iter1, null, body );
        } catch ( OclSemanticException e ) {
            if ( opName.equals( OclConstants.OP_FORALL ) || opName.equals( OclConstants.OP_ONE ) || opName.equals( OclConstants.OP_EXISTS ) || opName.equals( OclConstants.OP_ISUNIQUE ) ) {
                try {
                    exp = this.jmiCreator.createBooleanLiteralExp( OclConstants.TRUE );
                } catch ( OclSemanticException e1 ) {
                    // $JL-EXC$ ignore here
                }
            } else if ( opName.equals( OclConstants.OP_SELECT ) || opName.equals( OclConstants.OP_REJECT ) ) {
                exp = source;
            } else if ( opName.equals( OclConstants.OP_ANY ) ) {
                exp = source;
                if ( exp != null ) {
                    CoreConnection conn = this.jmiCreator.getConnection( );
                    Classifier elmType = ( (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( conn ) ).getElementType( conn );
                    this.jmiCreator.changeType( exp, elmType );
                }
            }

            if ( exp == null ) {
                reportFatalOCLError( e, n );
            }
            if ( correct ) {
                this.reportFatalError( e, n );
            }
        } catch ( RuntimeException e ) {
            if ( !correct && ( opName.equals( OclConstants.OP_COLLECT ) || opName.equals( OclConstants.OP_COLLECTNESTED ) ) ) {
                throw collectReason;
            }
            throw e;
        }


        return exp;
    }

    @Override
    protected OclExpression twoVarIterator( OclExpression source, String opName, IteratorTwoVarDecl iterContents, Node n ) {

        org.omg.ocl.expressions.VariableDeclaration iter1 = null;
        org.omg.ocl.expressions.VariableDeclaration iter2 = null;

        this.setDownProperty( iterContents, source );

        boolean correct = true;
        RuntimeException collectReason = null;

        OclExpression body = null;
        OclExpression exp = null;
        // has exactly one variable declaration        
        try {
            iterContents.accept( this );
            iter1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration( ) );
            iter2 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration3( ) );
            body = (OclExpression) this.getUpProperty( (Node) iterContents.getoclExpression( ) );
        } catch ( RuntimeException e2 ) {
            correct = false;
            collectReason = e2;
        }

        // evaluate contents
        iterContents.accept( this );

//        iter1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration( ) );
//        iter2 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration3( ) );
//        OclExpression body = (OclExpression) this.getUpProperty( (Node) iterContents.getoclExpression( ) );
//
//        OclExpression exp = null;

        try {
            exp = this.jmiCreator.createIteratorExp( opName, source, iter1, iter2, body );
        } catch ( OclSemanticException e ) {
            if ( opName.equals( OclConstants.OP_FORALL ) || opName.equals( OclConstants.OP_ONE ) || opName.equals( OclConstants.OP_EXISTS ) || opName.equals( OclConstants.OP_ISUNIQUE ) ) {
                try {
                    exp = this.jmiCreator.createBooleanLiteralExp( OclConstants.TRUE );
                } catch ( OclSemanticException e1 ) {
                    // $JL-EXC$ ignore here
                }
            } else if ( opName.equals( OclConstants.OP_SELECT ) || opName.equals( OclConstants.OP_REJECT ) ) {
                exp = source;
            } else if ( opName.equals( OclConstants.OP_ANY ) ) {
                exp = source;
                if ( exp != null ) {
                    CoreConnection conn = this.jmiCreator.getConnection( );
                    Classifier elmType = ( (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( conn ) ).getElementType( conn );
                    this.jmiCreator.changeType( exp, elmType );
                }
            }

            if ( exp == null ) {
                reportFatalOCLError( e, n );
            }
            if ( correct ) {
                this.reportFatalError( e, n );
            }
        } catch ( RuntimeException e ) {
            if ( !correct && ( opName.equals( OclConstants.OP_COLLECT ) || opName.equals( OclConstants.OP_COLLECTNESTED ) ) ) {
                throw collectReason;
            }
            throw e;
        }
        return exp;
    }

    @Override
    protected void noPropertyFound( String name, Classifier sourceType, Node n, boolean fatal ) {

        if ( fatal ) {
            OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0701, new Object[] { name, StringHelper.toPathName( ( (ModelElementInternal) sourceType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } );
            IOclProposal[] proposals = computePropertyCallProposals( sourceType, n.getStartOffset( ), n.getEndOffset( ) - n.getStartOffset( ) + 1 );
            if ( proposals.length > 0 ) {
                this.reportFixableFatalOCLError( ex, n, proposals );
            } else {
                this.reportFatalOCLError( ex, n );
            }
        }
    }

    protected void reportFixableFatalOCLError( OclSemanticException e, Node n, IOclProposal[] proposals ) {

        ProcessError error = (ProcessError) super.reportFatalError( e, n );
        this.report.getErrors( ).remove( error );
        error = new FixableProcessErrorImpl( error, proposals );
        this.report.getErrors( ).add( error );
        throw new FatalParsingException( e, error );
    }

    @Override
    protected void handleVariableAssignment( WithTypeExpression withType, IoclExpression exp, String name, Node n ) {

        // get the initial expression

        OclExpression initExp;
        // get its type
        Classifier typeOfExp;
        try {
            exp.accept( this );

            initExp = (OclExpression) this.getUpProperty( (Node) exp );
            typeOfExp = ( (OclExpressionInternal) initExp ).getType( this.jmiCreator.getConnection( ) );
        } catch ( RuntimeException fpe ) {
            initExp = null;
            typeOfExp = this.env.getJmiCreator( ).getOclInvalidClass( );
        }

        Classifier explicitType = null;
        if ( withType != null ) {

            boolean ignoreWithType = false;
            withType.accept( this );


            Object o = this.getUpProperty( withType );
            if ( o instanceof Classifier ) {
                explicitType = (Classifier) o;
            } else if ( o instanceof List ) {
                List<String> pathName = (List<String>) o;

                // we perhaps have a container name
                String containerName = null;
                if ( this.hasUpProperty( withType, OclConstants.N_CONTAINERNAME ) ) {
                    containerName = (String) this.getUpProperty( withType, OclConstants.N_CONTAINERNAME );
                }
                try {
//                    explicitType = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, n );
                    explicitType = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, (Node) withType.gettypePathName( ) );
                } catch ( RuntimeException e ) {
//                    if(initExp!=null){
                    explicitType = typeOfExp;
//                    }
                }
            } else {
                this.reportInternalError( withType, OclParserMessages.EXPLICITASSIGNMENTRESULT );
                return;
            }

            // the type of the expression has to conform the (optional) explicit
            // type
            if ( !this.checkTypesConform( typeOfExp, explicitType ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0712, new Object[] { StringHelper.toPathName( typeOfExp.getQualifiedName( ) ), StringHelper.toPathName( explicitType.getQualifiedName( ) ) } ), n );
                explicitType = this.jmiCreator.getOclInvalidClass( );
            }

        } else {
            explicitType = typeOfExp;
        }

        // build the assignment
        org.omg.ocl.expressions.VariableDeclaration var = null;
        try {
            var = this.jmiCreator.createVariableDeclaration( name, explicitType, initExp );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
        this.setUpProperty( n, var );
    }

    /**
     * <b> <li>argumentN ::= argumentN , oclExpression </b>
     */
    @Override
    public void visit( Arguments n ) {

        RuntimeException exc = null;
        try {
            n.getargumentN( ).accept( this );
        } catch ( RuntimeException e ) {
            exc = e;
        }
        try {
            n.getoclExpression( ).accept( this );
        } catch ( RuntimeException e ) {
            try {
                this.setUpProperty( (Node) n.getoclExpression( ), this.jmiCreator.createVariableExp( this.jmiCreator.getOclInvalidVariable( ) ) );
            } catch ( OclSemanticException e1 ) {
                if ( exc == null ) {
                    exc = e;
                }
            }

        }
        if ( exc != null ) {
            throw exc;
        }

        Object o = this.getUpProperty( (Node) n.getargumentN( ) );
        OclExpression arg = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        List<OclExpression> args = new ArrayList<OclExpression>( );
        if ( o instanceof List ) {
            args = (List<OclExpression>) o;
        } else if ( o instanceof OclExpression ) {
            args.add( (OclExpression) o );
        } else {
            this.reportInternalError( n, OclParserMessages.UNEXPECTEDPROPSRETURNEDTOARGS );
        }
        args.add( arg );
        this.setUpProperty( n, args );
    }


    /**
     * <b> <li>contextDeclarationN ::= contextDeclarationN contextDeclaration
     * </b>
     */
    @Override
    public void visit( ContextDeclarations n ) {

        //TODO: throw exception?
        // simply work over all different declarations
        try {
            n.getcontextDeclarationN( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
        try {
            n.getcontextDeclaration( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
    }

    /**
     * <b> <li>initOrDerValueN ::= initOrDerValueN initOrDerValue </b>
     */
    @Override
    public void visit( InitOrDerValueN n ) {

        //TODO: throw exception?
        // we have a list of init or derive statements, which we simply process
        // one after each other
        try {
            n.getinitOrDerValueN( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
        try {
            n.getinitOrDerValue( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
    }

    /**
     * <b> <li>invOrDefN ::= invOrDefN invOrDef </b>
     */
    @Override
    public void visit( InvOrDefs n ) {

        //TODO: throw exception?
        // simply process over different invariants or definitions
        try {
            n.getinvOrDefN( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
        try {
            n.getinvOrDef( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
    }

    /**
     * <b> <li>packageDeclarationN ::= packageDeclarationN packageDeclaration
     * </b>
     */
    @Override
    public void visit( PackageDeclarations n ) {

        //TODO:throw exception?
        try {
            n.getpackageDeclarationN( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
        try {
            n.getpackageDeclaration( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
    }

    /**
     * <b> <li>prePostOrBodyDeclN ::= prePostOrBodyDeclN prePostOrBodyDecl </b>
     */
    @Override
    public void visit( PrePostOrBodyDecls n ) {

        //TODO: throw exception?
        try {
            n.getprePostOrBodyDeclN( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
        try {
            n.getprePostOrBodyDecl( ).accept( this );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
    }

    /**
     * <b> <li>variableDeclaration ::= identifier withTypeExpressionOpt </b>
     */
    @Override
    public void visit( VariableDeclaration n ) {

        WithTypeExpression withType = n.getwithTypeExpressionOpt( );
        String name = n.getLeftIToken( ).toString( );

        try {
            this.handleVariableDeclaration( withType, name, n );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }

    }


    /**
     * <b> <li>variableAssignmentWithType ::= identifier withTypeExpression =
     * oclExpression </b>
     */
    @Override
    public void visit( VariableAssignmentWithType n ) {

        WithTypeExpression withType = n.getwithTypeExpression( );
        IoclExpression exp = n.getoclExpression( );
        String name = n.getLeftIToken( ).toString( );
        try {
            this.handleVariableAssignment( withType, exp, name, n );
        } catch ( RuntimeException e ) {
            // $JL-EXC$ ignore here
        }
    }

    private IOclProposal[] computePropertyCallProposals( Classifier type, int offset, int length ) {

        IOclProposal[] empty = new IOclProposal[0];
        ArrayList<IOclProposal> result = new ArrayList<IOclProposal>( );

        if ( type == null ) {
            return empty;
        }

        List<ModelElement> elements = new ArrayList<ModelElement>( );

        Classifier classifier = type;

        StdLibraryPackage stdLibpck = this.env.getJmiCreator( ).getConnection( ).getPackage( StdLibraryPackage.PACKAGE_DESCRIPTOR );

        List<Classifier> classifiers = new ArrayList<Classifier>( 0 );

        boolean oclAny = true;

//      if ( classifier instanceof DataType && /*!(classifier instanceof TupleType)*/ ) {
        if ( classifier instanceof CollectionType || classifier instanceof PrimitiveType ) {
            try {
                MofPackageImpl mp = (MofPackageImpl) stdLibpck.refMetaObject( );
                String name = classifier.getName( ).split( "\\(|Lit" )[0]; //$NON-NLS-1$
                ModelElement me;
                if ( classifier instanceof CollectionType ) {
                    me = mp.lookupElement( name + "TypeStdLib" ); //$NON-NLS-1$
                    classifiers.add( stdLibpck.getCollectionTypeStdLib( ).refMetaObject( ) );
                } else {
                    me = mp.lookupElement( name + "StdLib" ); //$NON-NLS-1$
                }

                if ( me instanceof Classifier ) {
                    classifiers.add( (Classifier) me );
                } else {
                    return empty;
                }

                if ( name.equals( OclConstants.T_OCLANY ) ) {
                    oclAny = false;
                }
            } catch ( JmiException e ) {
                return empty;
            } catch ( NameNotFoundException e ) {
                return empty;
            }
        } else if ( classifier.getName( ).contains( OclConstants.STDLIBSUBTRING ) ) {
            classifiers.add( stdLibpck.getOclTypeStdLib( ).refMetaObject( ) );
        } else {
            classifiers.add( classifier );
            List<GeneralizableElement> supertypes = ( (GeneralizableElementInternal) classifier ).allSupertypes( this.jmiCreator.getConnection( ) );
            for ( GeneralizableElement gE : supertypes ) {
                if ( gE instanceof Classifier ) {
                    classifiers.add( (Classifier) gE );
                }
            }
        }
        if ( oclAny ) {
            classifiers.add( stdLibpck.getOclAnyStdLib( ).refMetaObject( ) );
        }

        for ( Classifier currentClassifier : classifiers ) {

            boolean isStdType = currentClassifier.getName( ).contains( OclConstants.STDLIBSUBTRING );

            JmiList<ModelElement> list = (JmiList<ModelElement>) ( (ClassifierInternal) currentClassifier ).getContents( this.env.getJmiCreator( ).getConnection( ) );

            //add attributes, references and operations
            for ( Iterator<ModelElement> iterator = list.iteratorReadOnly( this.env.getJmiCreator( ).getConnection( ).getSession( ) ); iterator.hasNext( ); ) {
                ModelElement modelElement = iterator.next( );

                /*
                 * if ( modelElement instanceof Operation ) { if ( isStdType &&
                 * modelElement.getName( ).contains( "StdLib" ) ) { continue; }
                 * elements.add( modelElement ); } else
                 */if ( !( isStdType ) && modelElement instanceof Attribute ) {
                    elements.add( modelElement );
                } else if ( !( isStdType ) && modelElement instanceof Reference ) {
                    elements.add( modelElement );
                } else if ( !( isStdType ) && modelElement instanceof AssociationEnd ) {
                    elements.add( modelElement );
                }
            }

            //add association ends
            if ( !( isStdType ) ) {
                Set<AssociationEnd> assoEnds = this.env.getJmiCreator( ).getConnection( ).getCoreJmiHelper( ).getAssociationEnds( this.env.getJmiCreator( ).getConnection( ).getSession( ), currentClassifier, false );
                for ( AssociationEnd associationEnd : assoEnds ) {
                    elements.add( associationEnd.otherEnd( ) );
                }
            }
        }

        for ( ModelElement modelElement : elements ) {
            result.add( computeFixProposalForElement( modelElement, offset, length ) );
        }
        result.trimToSize( );

        return result.toArray( new IOclProposal[result.size( )] );
    }

    private IOclProposal computeFixProposalForElement( ModelElement element, int offset, int length ) {

        if ( element instanceof Attribute || element instanceof Reference || element instanceof AssociationEnd ) {
            MoinLocalizedString replacementPattern;
            if ( element instanceof Attribute ) {
                replacementPattern = MoinReplacementStrings.REPLACETOKENATTRIBUTE;
            } else if ( element instanceof Reference ) {
                replacementPattern = MoinReplacementStrings.REPLACETOKENREFERENCE;
            } else {
                replacementPattern = MoinReplacementStrings.REPLACETOKENASSOCEND;
            }
            String replacement = element.getName( );
            return new OCLProposalImpl( replacementPattern, new Object[] { replacement }, replacement, null, offset, length, IOclProposal.TYPE.REPLACE, OCLProposalImpl.STANDARDPRIORITY );
        }
        return null;

    }

}
