package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EvaluationKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.junit.Test;
import org.omg.ocl.OclPackage;
import org.omg.ocl.attaching.OclConstraint;

import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.friends.ocl.editor.IncrementalProcessReport;
import com.sap.tc.moin.friends.ocl.editor.OclEditorService;
import com.sap.tc.moin.friends.ocl.editor.RegionWrappedMRI;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;

/**
 * Test for the OclEditor core part
 */
@SuppressWarnings( "nls" )
public class OclEditorHelperTest extends BaseOclIntegrationTest {


    /**
     * @throws Exception cover all
     */
    @Test
    public void formatExpressionOclIsUndefined( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        OclEditorService srv = utils.getOclEditorService( this.createConnection( ) );

        String unformatted = "context ModelElement inv: self . name . oclIsUndefined()";

        String formatted = srv.format( unformatted );

        verify( !formatted.contains( " . " ), "Removal of filler spaces failed" );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void formatChecks( ) throws Exception {

        Set<String> formatterExpressions = new HashSet<String>( );

        /**
         * BooleanLiteralTrue, ClassifierContextDecl, InvDeclaration,
         * PackageDeclaration, PathNameIdent
         */
        formatterExpressions.add( "package Company context Department inv:  if self.oclIsInvalid() or self.oclIsUndefined() then false else true endif endpackage" );
        /**
         * AndBooleanExpression, BooleanLiteralFalse, ClassifierConectDecl,
         * GreaterEqualRelationalExpression, GreaterRelationalExpression,
         * IntegerLiteral, InvDeclaration, LessEqualRelationalExpression,
         * LessRelationalExpression, NotEqualRelationalExpression,
         * OrBooleanExpression, ParanthesizedPrimaryExpression, PathNameIdent,
         * RealLiteral, XorBooleanExpression
         */
        formatterExpressions.add( "context Department inv: false or ( 1.0 > 0.2 ) xor 2 >= 3 and 5 < 5 xor 6 <= 7 or 5 <> 6 or 6 = 6" );
        /**
         * Arguments, BooleanLiteralTrue, CallEqual, ClassifierContextDecl,
         * Ident, IntegerLiteral, InvDeclaration, LetExpression,
         * MutipleArguments, ObjectPropertyInvocation, PathNameIdent,
         * PostfixExpression, PrimTypeBoolean, Self, Variable,
         * VariableAssignment, VariableAssignmentN, WithTypeExpression
         */
        formatterExpressions.add( "context Department inv: let a = 1, b:Boolean = true in self.=(a,b)" );
        /**
         * AndBooleanExpression, Arguments, BagKind, BooleanLiteralFalse,
         * BooleanLiteralTrue, CallAnd, CallDivide, CallEqual, CallGreater,
         * CallGreaterEqual, CallLess, CallLessEqual, CallMult, CallNotEqual,
         * CallOclAsType, CallOr, CallPlus, CallXor, ClassifierContextDecl,
         * CollectionLiteral, CollectionLiteralExpression,
         * CollectionLiteralIntegerRange, CollectionLiteralParts,
         * GreaterRelationalExpresion, Ident, IntegerLiteral,
         * IntegerLiteralRange, InvalidLiteral, InvDeclaration, LetExpression,
         * MultipleArguments, NullLiteral, ObjectPropertyInvocation,
         * OrderedSetKind, ParanthesizedPrimaryExpression, PathNameIdent,
         * PostfixExpression, PrimTypeBoolean, PrimTypeFloat, RealLiteral, Self,
         * SequenceKind, SetKind, StringLiteral, TypeLiteral, Variable,
         * VariableAssignment, VariableAssignmentN, WithTypeExpression
         */
        formatterExpressions
            .add( "context Department inv: let f:Float = 1.3, d:Double = 1.2, b:Boolean = true, s = Sequence{1..3}, bag = Bag{1.3, 4.5}, os = OrderedSet{'a', 'b'}, set = Set{null, invalid, (1.2).oclAsType(Float), (3.1).oclAsType(Real)} in self.and(true, true) and self.or(true, false) and self.xor(false, true) and self./(d,f) > 0 and self.*(d,f)>0 and self.<(d,f) and self.<=(d,f) and self.>(d,f) and self.=(d,f) and self.>=(d,f) and self.<>(d,f) and self.+(d,f)>0" );
        /**
         * BooleanLiteralTrue, ClassifierContextDecl, Ident, IntegerLiteral,
         * InvDeclaration, LetExpression, PathNameIdent, PrimTypeInteger,
         * PrimTypeString, StringLiteral, TupleLiteral, TupleType,
         * VariableAssignment, VariableAssignmentN, VariableDeclarationWithType,
         * VariableDeclarationWithTypeN, WithTypeExpression
         */
        formatterExpressions.add( "context Department inv: let test:Tuple(name:String,age:Integer) = Tuple{name:String='John', age:Integer=10} in true" );
        /**
         * BodyDecl, BooleanLiteralTrue, Ident, OperationContextDecl,
         * OperationDecl, PathNameIdent, PathNames, PrimTypeBoolean,
         * PrimTypeString, VariableDeclarationWithType, WithTypeExpression
         */
        formatterExpressions.add( "context Department::opName(param:String):Boolean body: true" );
        /**
         * AndBooleanExpression, AttrOrNavCall, BooleanLiteralTrue,
         * CallAllInstances, CallOclAsType, CallOclIsKindOf, CallOclIsTypeOf,
         * CallOclIsUndefined, ClassifierContextDecl,
         * CollectionPropertyInvocation, VariableDeclaration,
         * GreaterRelationalExpression, Ident, IntegerLiteral, InvDeclaration,
         * IteratorAny, IteratorCollect, IteratorCollectNested, IteratorExists,
         * IteratorIsUnique, IteratorOne, IteratorOneVarDecl, IteratorReject,
         * IteratorSelect, IteratorSortedBy, LoopPropertyInvocation,
         * MultipleArguments, NoArguments, ObjectPropertyInvocation,
         * OperationCall, OrBooleanExpression, PathNameIdent, PostfixExpression,
         * Self, TypeLiteral, Variable, WithTypeExpression
         */
        formatterExpressions.add( "context Department inv name: self.employee->select(age > 50)->isEmpty() or self.employee->select(e:Freelance | e.age > 50)->isEmpty()" );
        formatterExpressions.add( "context Department inv name: self.employee->reject(age > 50)->isEmpty() or self.employee->reject(e:Freelance | e.age > 50)->isEmpty()" );
        formatterExpressions.add( "context Department inv name: self.employee->collect(age > 50)->isEmpty()" );
        formatterExpressions.add( "context Department inv name: self.employee->collectNested(true)->flatten()->one(age > 50)->isEmpty()" );
        formatterExpressions.add( "context Department inv: self.allInstances()->exists(e:Employee | e.oclIsTypeOf(Freelance))" );
        formatterExpressions.add( "context Department inv: self.employee()->sortedBy(name)->any(e:Employee | e.oclIsKindOf(Freelance)->isUnique(e.name))" );
        /**
         * AssociationQualifier, AttrOrNavCall, ClassifierContextDecl,
         * VariableDeclaration, GreaterRelationalExpression, Ident,
         * IntegerLiteral, InvDeclaration, IteratorForAll, IteratorOneVarDecl,
         * IteratorTwoVarDecl, LogicalExpression, LoopPropertyInvocation,
         * NotEqualRelationalExpression, ObjectPropertyInvocation,
         * OrBooleanExpression, ParanthesizedPrimaryExpression,
         * PostfixExpression, Self, Variable, WithTypeExpression
         */
        formatterExpressions.add( "context Department inv name: self.employee[qual]->forAll(e:Employee | e.age > 50) or self.employee->forAll(e1, e2:Employee | e1 <> e1 implies e1.age <> e2.age)" );
        /**
         * BooleanLiteralTrue, CallOclAsType, ClassifierContextDecl,
         * ContainerNamePrefix, ExpDeclaration, Ident, IntegerLiteral,
         * InvalidLiteral, InvDeclaration, LetExpression, NullLiteral,
         * PathNameIdent, PrimTypeFloat, PrimTypeInteger, PrimtTypeOclAny,
         * PrimTypeOclInvalid, PrimTypeOclVoid, VariableAssignment,
         * VariableAssigmentN, WithTypeExpression
         */
        formatterExpressions.add( "context Department exp: let anys:OclAny = null, voids:OclVoid = null, invalids:OclInvalid = invalid, ints:Integer = 1, doubles:Double = 2, floats:Float = 2, reals:Real=3 in self.oclAsType(container#Path::Name)" );
        /**
         * AttrOrAssocContextDecl, Ident, InitValue, PathNameIdent, PathNames,
         * PrimTypeString, StringLiteral, WithTypeExpression
         */
        formatterExpressions.add( "context Department::name:String init: 'dummy'" );

        for ( String expression : formatterExpressions ) {
            this.testFormat( expression );
        }

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void formatExpressionOclAsType( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        OclEditorService srv = utils.getOclEditorService( this.createConnection( ) );

        String unformatted = "context ModelElement inv: self . name . oclAsType(String)";

        String formatted = srv.format( unformatted );

        verify( !formatted.contains( " . " ), "Removal of filler spaces failed" );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void formatExpressionOclIsKindIsType( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        OclEditorService srv = utils.getOclEditorService( this.createConnection( ) );

        String unformatted = "context ModelElement inv: self . name . oclIsKindOf(String) or self.nameoclIsTypeOf(String)";

        String formatted = srv.format( unformatted );

        verify( !formatted.contains( " . " ), "Removal of filler spaces failed" );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void formatExpressionAttribute( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        OclEditorService srv = utils.getOclEditorService( this.createConnection( ) );

        String unformatted = "context SourceClass inv: self . someAttribute.oclIsUndefined() and self.someAttribute->asSet().isEmpty()";

        String formatted = srv.format( unformatted );

        verify( !formatted.contains( " . " ), "Removal of filler spaces failed" );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsSelf( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.", 8 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsAttribute( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute.", 7 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsAttributeArrow( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->", 33 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeErrorFixAttribute( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribut", 1 );


        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );

            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            String expression = "context SourceClass inv: self.someAttribut";

            List<IOclProposal> proposals = srv.computeErrorFix( oc, expression, 30, 12, mmpartitions );

            verify( proposals.size( ) == 1, "1 error fix proposals expected, but " + proposals.size( ) + " found" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsAttributeArrowAsSet( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asSet()->", 33 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIf( ) throws Exception {

        testComputeProposal( "context SourceClass inv: if", 1 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIfThen( ) throws Exception {

        testComputeProposal( "context SourceClass inv: if self.someAttribute->sortedBy(name).size() > 1 then true else false ", 10 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsEmpty( ) throws Exception {

        testComputeProposal( "", 2 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsLet( ) throws Exception {

        testComputeProposal( "context SourceClass inv: let ", 1 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsLetVar( ) throws Exception {

        testComputeProposal( "context SourceClass inv: let dummy:", 15 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsLetVarAssign( ) throws Exception {

        testComputeProposal( "context SourceClass inv: let dummy = ", 10 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsLetVarComma( ) throws Exception {

        testComputeProposal( "context SourceClass inv: let dummy = 1, ", 1 );
    }

//    /**
//     * @throws Exception cover all
//     */
//    @Test
//    public void computeProposalsPath( ) throws Exception {
//
//        testCompute( "context SourceClass inv: self.oclAsType(Test", 1 );
//    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsPathEmpty( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.oclAsType(", 10 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsLetSet( ) throws Exception {

        testComputeProposal( "context SourceClass inv: let Set(", 15 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorForAll( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->forAll(true)", 10 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorReject( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->reject(true) ", 10 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorAny( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->any(true)", 10 );

    }


    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorSelectTrue( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->select(true)", 10 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorCollect( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->collect(true) ", 10 );

    }


    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorExists( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->exists(true) ", 10 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsForAllVariable( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->forAll( a: String | a.oclIsUndefined())", 10 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsForSequence( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asSequence()->", 38 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsForBag( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asBag()->", 31 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsForOrderedSet( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asOrderedSet()->", 34 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsAsOrderedSet( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asOrderedSet()->", 34 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsAsBag( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asBag()->", 31 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsPath( ) throws Exception {

        testComputeProposal( "context TestPackage::", 1 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsMultiLineComment( ) throws Exception {

        testComputeProposal( "/** multi */\n context Test ", 7 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsSingleLineComment( ) throws Exception {

        testComputeProposal( "// single\n context Test", 1 );
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsForAsOrderedSet( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asOrderedSet()->forAll(true) ", 10 );

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void computeProposalsIteratorOne( ) throws Exception {

        testComputeProposal( "context SourceClass inv: self.someAttribute->asOrderedSet()->one(true) ", 10 );

    }


    /**
     * @throws Exception cover all
     */
    @Test
    public void getMriAtOffset( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );
            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            // we expect the MRI of the attribute
            String expression = "context SourceClass inv: self.someAttribute";
            RegionWrappedMRI mri = srv.getMRIAtOffset( oc, expression, expression.length( ) - 3, mmpartitions );

            MRI attributeMri = ( (Partitionable) getTestAttribute( testPartition ) ).get___Mri( );

            verify( attributeMri.equals( mri.getMRI( ) ), "Attribute MRI not same" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void getInformationAtOffset( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );
            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            // we expect the MRI of the attribute
            String expression = "context SourceClass inv: self.someAttribute";
            String info = srv.getInformationAtOffset( oc, expression, expression.length( ) - 3, mmpartitions, Locale.ENGLISH );

            String attributeInfo = getTestAttribute( testPartition ).getAnnotation( );

            // Caution! The info string endswith the attribute info, but in case of operations, the parameters are following
            // TODO will this work with translation?

            verify( info.endsWith( attributeInfo ), "Attribute Info not same" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void parseWithSyntaxError( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );
            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            // we expect the MRI of the attribute
            String expression = "context SourceClass inv: self..someAttribute->size()>0";
            ProcessReport report = srv.parseOclConstraint( oc, expression, mmpartitions );

            ProcessError error = report.getErrors( ).get( 0 );

            boolean semantic = error.getRootCause( ) instanceof OclSemanticException;

            verify( !semantic, "Exception is not of type Syntax Error" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void parseWithSemanticError( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );
            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            // we expect the MRI of the attribute
            String expression = "context SourceClass inv: self.someAttributes";
            ProcessReport report = srv.parseOclConstraint( oc, expression, mmpartitions );

            ProcessError error = report.getErrors( ).get( 0 );

            boolean semantic = error.getRootCause( ) instanceof OclSemanticException;

            verify( semantic, "Exception is not of type Semantic Error" );

            boolean containsName = error.getRootCause( ).getMessage( ).contains( "someAttributes" );

            verify( containsName, "Semantic Exception does not contain name of wrong attribute" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void parseWithSemanticErrorAndOffset( ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );
            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            // we expect the MRI of the attribute
            // this is 10 junk 44 length and some more other stuff
            String expression = "junkstuff context SourceClass inv: self.someAttributes some other junk";
            IncrementalProcessReport report = srv.parseOclConstraint( oc, expression, mmpartitions, 10, 44, false );

            ProcessError error = report.getErrors( ).get( 0 );

            boolean semantic = error.getRootCause( ) instanceof OclSemanticException;

            verify( semantic, "Exception is not of type Semantic Error" );

            boolean containsName = error.getRootCause( ).getMessage( ).contains( "someAttributes" );

            verify( containsName, "Semantic Exception does not contain name of wrong attribute" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }
    }

    private void testComputeProposal( String expression, int expectedNumProposals ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            ModelPartition testPartition = getOrCreateModelPartition( connection );

            OclConstraint oc = getTestConstraint( testPartition );

            Set<ModelPartition> mmpartitions = new HashSet<ModelPartition>( );
            mmpartitions.add( testPartition );

            OclEditorService srv = utils.getOclEditorService( connection );

            List<IOclProposal> proposals = srv.computeProposals( oc, expression, expression.length( ), mmpartitions );
            // code coverage

            // try to get info and mri at each token
            for ( int i = 1; i < expression.length( ) - 1; i++ ) {
                if ( expression.charAt( i ) == ' ' || expression.charAt( i ) == '-' || expression.charAt( i ) == '.' || expression.charAt( i ) == '(' ) {
                    srv.getInformationAtOffset( oc, expression, i - 1, mmpartitions, Locale.ENGLISH );
                    //srv.getMRIAtOffset( oc, expression, i - 1, mmpartitions );
                }
            }

            verify( proposals.size( ) == expectedNumProposals, expectedNumProposals + " proposals expected, but " + proposals.size( ) + " found" );
        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }

    }

    /** just for code coverage */
    private void testFormat( String expression ) throws Exception {

        ConnectionUtil utils = UtilitiesFactory.getConnectionUtil( );
        Connection connection = null;
        try {
            connection = this.createConnection( );

            OclEditorService srv = utils.getOclEditorService( connection );

            // code coverage
            srv.format( expression );

        } finally {
            if ( connection != null ) {
                connection.revert( );
            }
        }

    }

    private ModelPartition getOrCreateModelPartition( Connection connection ) {

        ModelPartition result = connection.getOrCreateTransientPartition( "OclEditorHelperTest" );
        CoreConnection coreConnection = connection instanceof Wrapper ? ( (Wrapper<CoreConnection>) connection ).unwrap( ) : (CoreConnection) connection;
        if ( result.getElements( ).isEmpty( ) ) {
            ModelPackage mp = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
            MofPackage testpkg = (MofPackage) mp.getMofPackage( ).refCreateInstanceInPartition( Arrays.asList( "TestPackage", "", true, false, false, VisibilityKindEnum.PUBLIC_VIS ), result );
            MofPackage modelRoot = (MofPackage) mp.getMofPackage( ).refCreateInstanceInPartition( Arrays.asList( "Test", "", true, false, false, VisibilityKindEnum.PUBLIC_VIS ), result );
            MofClass modelClass1 = (MofClass) mp.getMofClass( ).refCreateInstanceInPartition( Arrays.asList( "SourceClass", "", true, false, false, VisibilityKindEnum.PUBLIC_VIS, false ), result );
            MofClass modelClass2 = (MofClass) mp.getMofClass( ).refCreateInstanceInPartition( Arrays.asList( "TargetClass", "", true, false, false, VisibilityKindEnum.PUBLIC_VIS, false ), result );
            testpkg.getContents( ).add( modelClass2 );
            Attribute att = (Attribute) mp.getAttribute( ).refCreateInstanceInPartition( result );
            att.setName( "someAttribute" );
            att.setAnnotation( "The Attribute Info" );
            MultiplicityType muti = coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 0, -1, false, true );
            att.setMultiplicity( muti );
            att.setType( modelClass2 );
            modelClass1.getContents( ).add( att );
            OclConstraint modelConstraint = (OclConstraint) connection.getPackage( OclPackage.PACKAGE_DESCRIPTOR ).getAttaching( ).getOclConstraint( ).refCreateInstanceInPartition( Arrays.asList( "TestConstraint", "", "context TestClass inv: true", "OCL", EvaluationKindEnum.DEFERRED ), result );
            modelRoot.getContents( ).add( modelConstraint );
        }
        return result;
    }

    private OclConstraint getTestConstraint( ModelPartition partition ) {

        for ( Partitionable partitionable : partition.getElements( ) ) {
            if ( partitionable instanceof OclConstraint ) {
                OclConstraint constraint = (OclConstraint) partitionable;
                if ( constraint.getName( ).equals( "TestConstraint" ) ) {
                    return constraint;
                }
            }
        }
        throw new IllegalStateException( "TestConstraint not found" );
    }

    private Attribute getTestAttribute( ModelPartition partition ) {

        for ( Partitionable partitionable : partition.getElements( ) ) {
            if ( partitionable instanceof Attribute ) {
                Attribute attribute = (Attribute) partitionable;
                if ( attribute.getName( ).equals( "someAttribute" ) ) {
                    return attribute;
                }
            }
        }
        throw new IllegalStateException( "Test attribute not found" );
    }
}
