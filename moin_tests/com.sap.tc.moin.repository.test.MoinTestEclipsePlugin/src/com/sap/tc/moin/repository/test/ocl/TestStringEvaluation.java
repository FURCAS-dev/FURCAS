package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclString;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclString operations.
 */
public class TestStringEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testStringsEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abc' = 'abc'" );
        verify( evaluate( this.message, stmts ), "Strings equal should be valid" );

        stmts = parse( "context Message inv: '' = ''" );
        verify( evaluate( this.message, stmts ), "Empty Strings equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testStringEscape( ) {

        OclExpression exp = parseExp( "'this is \\n \\\\ an \\' escaping string with \\uabcd as unicode and \\333 as latin-1'" );
        OclAny result = evaluateExpression( exp, this.message );

        assertTrue( "expression did not evaluate to a string", result instanceof OclString );

        String value = ( (OclString) result ).getWrappedString( );

        verify( "this is \n \\ an ' escaping string with \uabcd as unicode and \333 as latin-1".equals( value ), "Evaluate string not as expected" );
    }

    /**
     *
     */
    @Test
    public void testStringsNotEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abc' <> 'ab'" );
        verify( evaluate( this.message, stmts ), "Strings equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSize( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abc'.size() = 3" );
        verify( evaluate( this.message, stmts ), "String size should be valid" );

        stmts = parse( "context Message inv: ''.size() = 0" );
        verify( evaluate( this.message, stmts ), "Empty String size should be valid" );
    }

    /**
     *
     */
    @Test
    public void testConcat( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abc'.concat('def') = 'abcdef'" );
        verify( evaluate( this.message, stmts ), "String concat should be valid" );

        stmts = parse( "context Message inv: ''.concat('abc') = 'abc'" );
        verify( evaluate( this.message, stmts ), "Empty String concat should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSubstring( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abcdef'.subString(1, 6) = 'abcdef'" );
        verify( evaluate( this.message, stmts ), "String substring should be valid" );

        stmts = parse( "context Message inv: 'abcdef'.subString(1, 3) = 'abc'" );
        verify( evaluate( this.message, stmts ), "String substring should be valid" );

        stmts = parse( "context Message inv: 'abcdef'.subString(4, 6) = 'def'" );
        verify( evaluate( this.message, stmts ), "String substring should be valid" );

        stmts = parse( "context Message inv: 'abcdef'.subString(1, 1) = 'a'" );
        verify( evaluate( this.message, stmts ), "String substring should be valid" );
    }

    /**
     *
     */
    @Test
    public void testToInteger( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: '31'.toInteger() = 31" );
        verify( evaluate( this.message, stmts ), "String toInteger should be valid" );

        stmts = parse( "context Message inv: 'abc'.toInteger().oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Undefined String toInteger should be valid" );
    }

    /**
     *
     */
    @Test
    public void testToDouble( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: '31.52'.toDouble() = 31.52" );
        verify( evaluate( this.message, stmts ), "String toDouble should be valid" );

        stmts = parse( "context Message inv: 'abc'.toDouble().oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Undefined String toDouble should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFromDoubleToString( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (31.52).toString() = '31.52'" );
        verify( evaluate( this.message, stmts ), "double toString should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFromIntegerToString( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (31).toString() = '31'" );
        verify( evaluate( this.message, stmts ), "double toString should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFromTupleToString( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (Tuple{a = 3, b = 'false'}).toString() = 'Tuple{a = 3, b = false}'" );
        verify( evaluate( this.message, stmts ), "tuple toString should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFromOneElementTupleToString( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (Tuple{a = 3.34e3}).toString() = 'Tuple{a = 3340.0}'" );
        verify( evaluate( this.message, stmts ), "tuple toString should be valid" );
    }

    /**
     *
     */
    @Test
    public void testNormalizedConcat( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 't1' + 't2' = 't1t2'" );
        verify( evaluate( this.message, stmts ), "concat in form of + does not produce correct value" );
    }

    /**
     *
     */
    @Test
    public void testNormalizedConcatWithInt( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 't_' + 42 = 't_42'" );
        verify( evaluate( this.message, stmts ), "concat in form of + with an integer does not produce correct value" );
    }

    /**
     *
     */
    @Test
    public void testNormalizedConcatWithIntReversed( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 42 + '_t' = '42_t'" );
        verify( evaluate( this.message, stmts ), "concat in form of + with an integer (in first position) does not produce correct value" );
    }

    /**
     *
     */
    @Test
    public void testNormalizedConcatWithDouble( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 't_' + 42.42 = 't_42.42'" );
        verify( evaluate( this.message, stmts ), "concat in form of + with a double does not produce correct value" );
    }

    /**
     *
     */
    @Test
    public void testNormalizedConcatWithDoubleAndInteger( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 't_' + 42.42 + 42 = 't_42.4242'" );
        verify( evaluate( this.message, stmts ), "concat in form of + with a double and integer does not produce correct value" );
    }

    /**
     *
     */
    @Test
    public void testToUpperCase( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abc'.toUpperCase() = 'ABC'" );
        verify( evaluate( this.message, stmts ), "'abc'.toUpperCase() = 'ABC'" );
    }

    /**
     *
     */
    @Test
    public void testToLowerCase( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'ABC'.toLowerCase() = 'abc'" );
        verify( evaluate( this.message, stmts ), "'ABC'.toLowerCase() = 'abc'" );
    }

    /**
     *
     */
    @Test
    public void testMatches( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 'abc'.matches('[a-z]+')" );
        verify( evaluate( this.message, stmts ), "'abc'.matches('[a-z]+')" );
    }

    /**
     *
     */
    @Test
    public void testStringNullConcat( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let var:String = null in 'test' + var = 'testnull'" );
        verify( evaluate( this.message, stmts ), "<null> concatenates to null" );
    }

    /**
     *
     */
    @Test
    public void testStringNullConcatUntyped( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let var = null in 'test' + var = 'testnull'" );
        verify( evaluate( this.message, stmts ), "<null> concatenates to null" );
    }

}
