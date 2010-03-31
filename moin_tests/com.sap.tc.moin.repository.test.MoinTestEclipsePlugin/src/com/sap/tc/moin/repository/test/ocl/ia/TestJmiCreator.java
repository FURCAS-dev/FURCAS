package com.sap.tc.moin.repository.test.ocl.ia;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.IfExpInternal;
import org.omg.ocl.expressions.__impl.LetExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.expressions.__impl.VariableExpImpl;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;

import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclTest;

/**
 * This tests the JmiCreator class
 * 
 * @author Thomas Hettel (d039141)
 */
public class TestJmiCreator extends BaseOclTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testAssociationCallExp( ) throws Exception {

        // TODO implement this
        this.warn( "No test coding" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testAttributeCallExp( ) throws Exception {

        // TODO implement this
        this.warn( "No test coding" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCollectionRange( ) throws Exception {

        // TODO implement this
        this.warn( "No test coding" );
    }

    /**
     * An element type can only be used once for a specific collection type,
     * otherwise an exception is thrown. This test tries to create a large
     * number of the same collection with the same element type. The JmiCreator
     * must return the existing one!
     * 
     * @throws Exception
     */
    @Test
    public void testCollectionTypes( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            /*
             * Test Set
             */
            SetType st = null;
            st = this.myJmiCreator.createSetType( this.myJmiCreator.getIntClass( ) );
            verify( st != null, "unable to create Set(Integer)" );
            for ( int i = 0; i < 10; i++ ) {
                SetType newSet = this.myJmiCreator.createSetType( this.myJmiCreator.getIntClass( ) );
                verify( newSet == st, "got a new Set(Integer)" );
            }
            /*
             * Test Bag
             */
            BagType bag = null;
            bag = this.myJmiCreator.createBagType( this.myJmiCreator.getIntClass( ) );
            verify( bag != null, "unable to create Bag(Integer)" );
            for ( int i = 0; i < 10; i++ ) {
                BagType newBag = this.myJmiCreator.createBagType( this.myJmiCreator.getIntClass( ) );
                verify( newBag == bag, "got a new Bag(Integer)" );
            }
            /*
             * Test Sequence
             */
            SequenceType seq = null;
            seq = this.myJmiCreator.createSequenceType( this.myJmiCreator.getIntClass( ) );
            verify( seq != null, "unable to create Sequence(Integer)" );
            for ( int i = 0; i < 10; i++ ) {
                SequenceType newSeq = this.myJmiCreator.createSequenceType( this.myJmiCreator.getIntClass( ) );
                verify( newSeq == seq, "got a new Sequence(Integer)" );
            }
            /*
             * Test OrderedSet
             */
            OrderedSetType ost = null;
            ost = this.myJmiCreator.createOrderedSetType( this.myJmiCreator.getIntClass( ) );
            verify( ost != null, "unable to create OrderedSet(Integer)" );
            for ( int i = 0; i < 10; i++ ) {
                OrderedSetType newOSet = this.myJmiCreator.createOrderedSetType( this.myJmiCreator.getIntClass( ) );
                verify( newOSet == ost, "got a new OrderedSet(Integer)" );
            }
        }

    }

    /**
     * @throws Exception
     */
    @Test
    public void testIfExp( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            VariableDeclaration bool = this.myJmiCreator.createVariableDeclaration( "boolean", this.myJmiCreator.getBoolClass( ), null );
            VariableDeclaration integer = this.myJmiCreator.createVariableDeclaration( "integer", this.myJmiCreator.getIntClass( ), null );
            VariableDeclaration string = this.myJmiCreator.createVariableDeclaration( "string", this.myJmiCreator.getStringClass( ), null );
            VariableExp cond = this.myJmiCreator.createVariableExp( bool );
            VariableExp intcond = this.myJmiCreator.createVariableExp( integer );
            VariableExp thenExp = this.myJmiCreator.createVariableExp( string );
            VariableExp elseExp = this.myJmiCreator.createVariableExp( string );
            Classifier ifType = this.myJmiCreator.getAnyClass( );

            IfExp ifExp = this.myJmiCreator.createIfExp( cond, thenExp, elseExp, ifType );

            verify( ifExp != null, "Creation of IfExp failed!" );
            if ( ifExp == null ) {
                return;
            }

            verify( ( (IfExpInternal) ifExp ).getCondition( coreConnection ).equals( cond ), "Wrong condition expression!" );

            verify( ( (IfExpInternal) ifExp ).getThenExpression( coreConnection ).equals( thenExp ), "Wrong then expression!" );

            verify( ( (IfExpInternal) ifExp ).getElseExpression( coreConnection ).equals( elseExp ), "Wrong else expression!" );

            verify( ( (IfExpInternal) ifExp ).getType( coreConnection ).equals( ifType ), "Wrong type!" );

            // provide invalid arguments
            try {
                ifExp = this.myJmiCreator.createIfExp( cond, null, elseExp, ifType );
                flop( "no exception thrown when passing no then expression" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }

            // provide invalid arguments
            try {
                ifExp = this.myJmiCreator.createIfExp( cond, thenExp, null, ifType );
                flop( "no exception thrown when passing no else expression" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }

            // provide invalid arguments
            try {
                ifExp = this.myJmiCreator.createIfExp( cond, thenExp, elseExp, null );
                flop( "no exception thrown when passing no type" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }

            // provide invalid arguments
            try {
                ifExp = this.myJmiCreator.createIfExp( intcond, thenExp, elseExp, ifType );
                flop( "no exception thrown when passing a non-boolean condition!" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testLetExp( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            Classifier inType = this.myJmiCreator.getStringClass( );
            VariableDeclaration string = this.myJmiCreator.createVariableDeclaration( "string", this.myJmiCreator.getStringClass( ), null );
            VariableExp inExp = this.myJmiCreator.createVariableExp( string );

            String varName = "myVar";
            Classifier varType = this.myJmiCreator.getIntClass( );
            IntegerLiteralExp initExp = this.myJmiCreator.createIntegerLiteralExp( "42" );

            VariableDeclaration varDecl = this.myJmiCreator.createVariableDeclaration( varName, varType, initExp );
            VariableDeclaration varDeclNoInit = this.myJmiCreator.createVariableDeclaration( varName, varType, null );

            LetExp let = this.myJmiCreator.createLetExp( inExp, varDecl );

            verify( let != null, "Creation of LetExp failed!" );
            if ( let == null ) {
                return;
            }

            verify( ( (LetExpInternal) let ).getType( coreConnection ) == inType, "Not the right type set!" );

            verify( ( (LetExpInternal) let ).getIn( coreConnection ) == inExp, "Wrong in expression!" );

            verify( ( (LetExpInternal) let ).getVariable( coreConnection ) == varDecl, "Wrong variable declaration set!" );

            // provide invalid arguments
            try {
                let = this.myJmiCreator.createLetExp( null, varDecl );
                flop( "no exception thrown when passing no in expression" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }

            // provide invalid arguments
            try {
                let = this.myJmiCreator.createLetExp( inExp, null );
                flop( "no exception thrown when passing no variable declaration" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }

            // provide invalid arguments
            try {
                let = this.myJmiCreator.createLetExp( inExp, varDeclNoInit );
                flop( "no exception thrown when passing a variable declaration with no init expr." );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testOperationCallExp( ) throws Exception {

        // TODO implement this
        this.warn( "No test coding" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testVariableDeclaration( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {

            String varName = "myVar";
            Classifier varType = this.myJmiCreator.getIntClass( );
            VariableDeclarationInternal varDecl = (VariableDeclarationInternal) this.myJmiCreator.createVariableDeclaration( varName, varType, null );

            verify( varDecl != null, "Creation of VariableDeclaration failed!" );
            if ( varDecl == null ) {
                return;
            }

            verify( varDecl.getVarName( ).equals( varName ), "Variable has wrong name!" );

            verify( varDecl.getType( coreConnection ).equals( varType ), "Variable has wrong type!" );

            verify( varDecl.getInitExpression( coreConnection ) == null, "Init expression not null!" );

            // provide invalid arguments
            try {
                varDecl = (VariableDeclarationInternal) this.myJmiCreator.createVariableDeclaration( varName, null, null );
                flop( "no exception thrown when passing null as type" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }

            // provide invalid arguments
            try {
                varDecl = (VariableDeclarationInternal) this.myJmiCreator.createVariableDeclaration( null, varType, null );
                flop( "no exception thrown when passing null as name" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }
        }

    }

    /**
     * @throws Exception
     */
    @Test
    public void testVariableExp( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            Classifier varType = this.myJmiCreator.getIntClass( );
            VariableDeclarationImpl varDecl = (VariableDeclarationImpl) this.myJmiCreator.createVariableDeclaration( "myVar", varType, null );
            VariableExpImpl varExp = (VariableExpImpl) this.myJmiCreator.createVariableExp( varDecl );
            // check type
            verify( varExp.getType( coreConnection ).equals( varType ), "Variable has wrong type!" );
            // check refered declaration
            verify( varExp.getReferredVariable( coreConnection ).equals( varDecl ), "Variable refers to the wrong declaration!" );

            // provide invalid arguments
            try {
                varDecl.setType( coreConnection, null );
                varExp = (VariableExpImpl) this.myJmiCreator.createVariableExp( varDecl );
                flop( "no exception thrown when passing varDecl.getType() == null" );
            } catch ( OclSemanticException e ) {
                // that's all right!
            }
        }
    }
}