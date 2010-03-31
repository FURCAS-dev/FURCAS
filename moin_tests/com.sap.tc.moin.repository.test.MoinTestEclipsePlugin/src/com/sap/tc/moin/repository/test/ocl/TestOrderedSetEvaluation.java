package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OrderedSet operations.
 */
@SuppressWarnings( "nls" )
public class TestOrderedSetEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testIterate( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "OrderedSet {1, 2, 3}->iterate(i;x:Integer = 0 | x + i) = 6" );

        verify( evaluate( this.message, stmts ), "OrderedSet iterate() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "OrderedSet {1, 2, 3, 4}->exists(i | i = 3)" );

        verify( evaluate( this.message, stmts ), "OrderedSet exists() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "OrderedSet {1, 2, 3, 4}->exists(i, j | i + j = 7)" );

        verify( evaluate( this.message, stmts ), "OrderedSet exists() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:OrderedSet(Integer) = OrderedSet {1, 2, 3, 4} in " + "all->forAll(i | i < 5)" );

        verify( evaluate( this.message, stmts ), "OrderedSet forAll() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:OrderedSet(Integer) = OrderedSet{1, 2, 3, 4} in " + "all->forAll(i, j | i + j < 10)" );

        verify( evaluate( this.message, stmts ), "OrderedSet forAll() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIsUniqueIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:OrderedSet(Integer) = OrderedSet {1, 2, 5, 6} in " + "all->isUnique(i | i)" );

        verify( evaluate( this.message, stmts ), "OrderedSet isUnique() iterator should be valid" );

        stmts = parse( "context Message inv: " + "let all:OrderedSet(Integer) = OrderedSet {1, 2, 5, 6} in " + "not all->isUnique(i | i.mod(2))" );

        verify( evaluate( this.message, stmts ), "OrderedSet isUnique() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testAnyIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let result = OrderedSet {1, 2, 3, 4}->any(i | i > 2) in " + "result = 3 or result = 4" );

        verify( evaluate( this.message, stmts ), "OrderedSet any() iterator should be valid" );

        stmts = parse( "context Message inv: " + "OrderedSet {1, 2, 3, 4}->any(i | i > 4).oclIsUndefined()" );

        verify( evaluate( this.message, stmts ), "OrderedSet any() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testOneIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "OrderedSet {1, 2, 3, 4}->one(i | i > 3)" );

        verify( evaluate( this.message, stmts ), "OrderedSet one() iterator should be valid" );

        stmts = parse( "context Message inv: " + "not OrderedSet {1, 2, 3, 4}->one(i | i > 2)" );

        verify( evaluate( this.message, stmts ), "OrderedSet one() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->collect(i | i.size()) = Bag {1, 2, 1}" );

        verify( evaluate( this.message, stmts ), "OrderedSet collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFirstAndLast( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->first() = 'a' and orderedSet->last() = 'c'" );

        verify( evaluate( this.message, stmts ), "OrderedSet first() and last() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIndexOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->indexOf('bb') = 2" );

        verify( evaluate( this.message, stmts ), "OrderedSet indexOf() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSubOrderedSet( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->subOrderedSet(1,2)->size() = 2" );

        verify( evaluate( this.message, stmts ), "OrderedSet subSequence() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testAppend( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->append('d')->indexOf('bb') = 2" );

        verify( evaluate( this.message, stmts ), "OrderedSet append() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testPrepend( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->prepend('d')->indexOf('bb') = 3" );

        verify( evaluate( this.message, stmts ), "OrderedSet prepend() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testInsertAt( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(String) = " + "OrderedSet {'a', 'bb', 'c'} in\n" + "orderedSet->insertAt(1, 'd')->indexOf('d') = 1" );

        verify( evaluate( this.message, stmts ), "OrderedSet insertAt() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIteratorWithCollections( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(Bag(String)) = " + "OrderedSet {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "orderedSet->collect(i | i) = Bag {'a', 'b', 'b', 'c'}" );

        verify( evaluate( this.message, stmts ), "OrderedSet collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectNestedIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let orderedSet:OrderedSet(Bag(String)) = " + "OrderedSet {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "orderedSet->collectNested(i | i) = " + "Bag {Bag{'a', 'b'}, Bag{'b', 'c'}}" );

        verify( evaluate( this.message, stmts ), "OrderedSet collectNested() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSelectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:OrderedSet(Integer) = OrderedSet {1, 2, 5, 6} in " + "all->select(i | i.mod(2) = 0) = OrderedSet {2, 6}" );

        verify( evaluate( this.message, stmts ), "OrderedSet select() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testRejectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:OrderedSet(Integer) = OrderedSet {1, 2, 5, 6} in " + "all->reject(i | i.mod(2) = 0) = OrderedSet {1, 5}" );

        verify( evaluate( this.message, stmts ), "OrderedSet reject() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSortedByIterator( ) {

        // In this test, we need compare the result as a Sequence, as
        // comparison of OrderedSet has the same semantics as Set comparison,
        // ie., it does not take ordering into account
        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:OrderedSet(Integer) = OrderedSet {2, 5, 1, 3} in " + "let sorted:OrderedSet(Integer) = all->sortedBy(i | i) in " + "sorted->asSequence() = Sequence {1, 2, 3, 5}" );

        verify( evaluate( this.message, stmts ), "OrderedSet sortedBy() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSum( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "OrderedSet {1, 2, 3, 4, 5}->sum() = 15" );

        verify( evaluate( this.message, stmts ), "OrderedSet sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testTypedCollectionSumEmpty( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let set:OrderedSet(Integer) = OrderedSet {}" + "in set->sum() = 0" );

        verify( evaluate( this.message, stmts ), "OrderedSet sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testProduct( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let orderedSet1:OrderedSet(Integer) = OrderedSet {1, 3} in " + "let orderedSet2:OrderedSet(Integer) = OrderedSet {2, 4} in " + "orderedSet1->product(orderedSet2) = Set{" + "Tuple{first = 1, second = 2},"
                                                + "Tuple{first = 1, second = 4}," + "Tuple{first = 3, second = 2}," + "Tuple{first = 3, second = 4}" + "}" );

        verify( evaluate( this.message, stmts ), "OrderedSet product() should be valid" );
    }
}
