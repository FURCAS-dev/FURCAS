package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on Bag operations.
 */
public class TestBagEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testIterate( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "Bag {1, 2, 3}->iterate(i; x:Integer = 0 | x + i) = 6" );

        verify( evaluate( this.message, stmts ), "Bag iterate() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 3, 4, 2, 3}->exists(i | i = 3)" );

        verify( evaluate( this.message, stmts ), "Bag exists() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 3, 4, 2, 3}->exists(i, j | i + j = 7)" );

        verify( evaluate( this.message, stmts ), "Bag exists() multiple iterator should be valid" );
    }

    /**
    *
    */
    @Test
    public void testAsBag( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 3}->asBag() = Bag {1, 2, 3}" );

        verify( evaluate( this.message, stmts ), "Bag asBag() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:Bag(Integer) = Bag {1, 2, 3, 4, 2, 3} in " + "all->forAll(i | i < 5)" );

        verify( evaluate( this.message, stmts ), "Bag forAll() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:Bag(Integer) = Bag {1, 2, 3, 4, 2, 3} in " + "all->forAll(i, j | i + j < 10)" );

        verify( evaluate( this.message, stmts ), "Bag forAll() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIsUniqueIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Bag(Integer) = Bag {1, 2, 3, 4} in " + "all->isUnique(i | i)" );

        verify( evaluate( this.message, stmts ), "Bag select() iterator should be valid" );

        stmts = parse( "context Message inv: " + "let all:Bag(Integer) = Bag {1, 2, 3, 4, 2} in " + "not all->isUnique(i | i)" );

        verify( evaluate( this.message, stmts ), "Bag isUnique() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testAnyIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let result = Bag {1, 2, 3, 4}->any(i | i > 2) in " + "result = 3 or result = 4" );

        verify( evaluate( this.message, stmts ), "Bag any() iterator should be valid" );

        stmts = parse( "context Message inv: " + "Bag {1, 2, 3, 4}->any(i | i > 4).oclIsUndefined()" );

        verify( evaluate( this.message, stmts ), "Bag any() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testOneIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "Bag {1, 2, 3, 4}->one(i | i > 3)" );

        verify( evaluate( this.message, stmts ), "Bag one() iterator should be valid" );

        stmts = parse( "context Message inv: " + "not Bag {1, 2, 3, 4}->one(i | i > 2)" );

        verify( evaluate( this.message, stmts ), "Bag one() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let bag:Bag(String) = Bag {'a', 'bb', 'bb', 'cc'} in\n" + "bag->collect(i | i.size()) = Bag {1, 2, 2, 2}" );

        verify( evaluate( this.message, stmts ), "Bag collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIteratorWithCollections( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let bag:Bag(Bag(String)) = " + "Bag {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "bag->collect(i | i) = Bag {'a', 'b', 'b', 'c'}" );

        verify( evaluate( this.message, stmts ), "Bag collect() iterator should be valid" );
    }

    /**
     *
     */

    @Test
    public void testCollectNestedIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let bag:Bag(Bag(String)) = " + "Bag {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "bag->collectNested(i | i) = " + "Bag {Bag{'a', 'b'}, Bag{'b', 'c'}}" );

        verify( evaluate( this.message, stmts ), "Bag collectNested() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSelectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Bag(Integer) = Bag {1, 2, 3, 4, 2, 3} in " + "all->select(i | i.mod(2) = 0) = Bag {2, 4, 2}" );

        verify( evaluate( this.message, stmts ), "Bag select() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testRejectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Bag(Integer) = Bag {1, 2, 3, 4, 2, 3} in " + "all->reject(i | i.mod(2) = 0) = Bag {1, 3, 3}" );

        verify( evaluate( this.message, stmts ), "Bag reject() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSortedByIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Bag(Integer) = Bag {2, 5, 1, 3, 2, 4} in " + "all->sortedBy(i | i) = Sequence {1, 2, 2, 3, 4, 5}" );

        verify( evaluate( this.message, stmts ), "Bag sortedBy() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSum( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 3, 4, 5}->sum() = 15" );

        verify( evaluate( this.message, stmts ), "Bag sum() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testIntersection( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 3, 4, 5}->intersection(Bag{1,2})->sum() = 3" );

        verify( evaluate( this.message, stmts ), "Bag intersection() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testIntersectionWithSet( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 3, 4, 5}->intersection(Set{1,3})->sum() = 4" );

        verify( evaluate( this.message, stmts ), "Bag intersection() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testUnion( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2}->union(Bag {3, 4})->size() = 4" );

        verify( evaluate( this.message, stmts ), "Bag union() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testCount( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Bag {1, 2, 1}->count(1) = 2" );

        verify( evaluate( this.message, stmts ), "Bag count() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testTypedCollectionSumEmpty( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let bag:Bag(Integer) = Bag {}" + "in bag->sum() = 0" );

        verify( evaluate( this.message, stmts ), "Bag sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testProduct( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let bag1:Bag(Integer) = Bag {1, 3} in " + "let bag2:Bag(Integer) = Bag {2, 4} in " + "bag1->product(bag2) = Set{" + "Tuple{first = 1, second = 2}," + "Tuple{first = 1, second = 4}," + "Tuple{first = 3, second = 2},"
                                                + "Tuple{first = 3, second = 4}" + "}" );

        verify( evaluate( this.message, stmts ), "Bag product() should be valid" );
    }
}
