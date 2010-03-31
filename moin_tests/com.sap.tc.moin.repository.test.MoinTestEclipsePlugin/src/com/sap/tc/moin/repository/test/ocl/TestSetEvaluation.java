package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on Set operations.
 */
@SuppressWarnings( "nls" )
public class TestSetEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testIterate( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "Set {1, 2, 3}->iterate(i; x:Integer = 0 | x + i) = 6" );

        verify( evaluate( this.message, stmts ), "Set iterate() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testCount( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let test = Set {1, 2, 3} in " + "test->count(3) = 1" );

        verify( evaluate( this.message, stmts ), "Set count() should be valid" );
    }

    /**
   *
   */
    @Test
    public void testIntersection( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let first = Set {1, 2, 4}, second = Set {2, 3, 4} in " + "first->intersection(second)->size() = 2" );

        verify( evaluate( this.message, stmts ), "Set intersection() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testMinus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let first = Set {1, 2, 4}, second = Set {1, 4} in " + "(first-second)->size() = 1" );

        verify( evaluate( this.message, stmts ), "Set minus() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testExcludesAll( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let first = Set {1, 2, 4}, second = Set {2, 3, 4} in " + "first->excludesAll(second) = false" );

        verify( evaluate( this.message, stmts ), "Set excludesAll() should be valid" );
    }

    /**
    *
    */
    @Test
    public void testExcluding( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let first = Set {1, 2, 4}, second = Set {2, 3, 4} in " + "first->excluding(1)->size() = 2 and second->excluding(1)->size() = 3" );

        verify( evaluate( this.message, stmts ), "Set excluding() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIncludesAll( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let first = Set {1, 2, 4}, second = Set {2, 3, 4} in " + "first->includesAll(second) = false" );

        verify( evaluate( this.message, stmts ), "Set includesAll() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSymDiff( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let first = Set {1, 4}, second = Set {2, 3, 4} in " + "first->symmetricDifference(second)->size() = 3" );

        verify( evaluate( this.message, stmts ), "Set symmetricDifference() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Set {1, 2, 3, 4}->exists(i | i = 3)" );

        verify( evaluate( this.message, stmts ), "Set exists() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Set {1, 2, 3, 4}->exists(i, j | i + j = 7)" );

        verify( evaluate( this.message, stmts ), "Set exists() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:Set(Integer) = Set {1, 2, 3, 4} in " + "all->forAll(i | i < 5)" );

        verify( evaluate( this.message, stmts ), "Set forAll() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:Set(Integer) = Set{1, 2, 3, 4} in " + "all->forAll(i, j | i + j < 10)" );

        verify( evaluate( this.message, stmts ), "Set forAll() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIsUniqueIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Set(Integer) = Set {1, 2, 5, 6} in " + "all->isUnique(i | i)" );

        verify( evaluate( this.message, stmts ), "Set isUnique() iterator should be valid" );

        stmts = parse( "context Message inv: " + "let all:Set(Integer) = Set {1, 2, 5, 6} in " + "not all->isUnique(i | i.mod(2))" );

        verify( evaluate( this.message, stmts ), "Set isUnique() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testAnyIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let result = Set {1, 2, 3, 4}->any(i | i > 2) in " + "result = 3 or result = 4" );

        verify( evaluate( this.message, stmts ), "Set any() iterator should be valid" );

        stmts = parse( "context Message inv: " + "Set {1, 2, 3, 4}->any(i | i > 4).oclIsUndefined()" );

        verify( evaluate( this.message, stmts ), "Set any() iterator should be valid" );
    }

    /**
    *
    */
    @Test
    public void testAsBag( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let result = Set {1, 2, 3, 4} in " + "result->asBag()->count(2) = 1" );

        verify( evaluate( this.message, stmts ), "Set any() iterator should be valid" );

    }

    /**
     *
     */
    @Test
    public void testOneIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "Set {1, 2, 3, 4}->one(i | i > 3)" );

        verify( evaluate( this.message, stmts ), "Set one() iterator should be valid" );

        stmts = parse( "context Message inv: " + "not Set {1, 2, 3, 4}->one(i | i > 2)" );

        verify( evaluate( this.message, stmts ), "Set one() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let set:Set(String) = Set {'a', 'bb', 'cc'} in\n" + "set->collect(i | i.size()) = Bag {1, 2, 2}" );

        verify( evaluate( this.message, stmts ), "Set collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIteratorWithCollections( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let set:Set(Bag(String)) = " + "Set {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "set->collect(i | i) = Bag {'a', 'b', 'b', 'c'}" );

        verify( evaluate( this.message, stmts ), "Set collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectNestedIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let set:Set(Bag(String)) = " + "Set {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "set->collectNested(i | i) = " + "Bag {Bag{'a', 'b'}, Bag{'b', 'c'}}" );

        verify( evaluate( this.message, stmts ), "Set collectNested() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSelectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Set(Integer) = Set {1, 2, 5, 6} in " + "all->select(i | i.mod(2) = 0) = Set {2, 6}" );

        verify( evaluate( this.message, stmts ), "Set select() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testRejectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Set(Integer) = Set {1, 2, 5, 6} in " + "all->reject(i | i.mod(2) = 0) = Set {1, 5}" );

        verify( evaluate( this.message, stmts ), "Set reject() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSortedByIterator( ) {

        // In this test, we need compare the result as a Sequence, as
        // comparison of OrderedSet has the same semantics as Set comparison,
        // ie., it does not take ordering into account
        Collection<OclStatement> stmts = parse( "context Message " + "inv: let all:Set(Integer) = Set {2, 5, 1, 3} in " + "let sorted:OrderedSet(Integer) = all->sortedBy(i | i) in " + "sorted->asSequence() = Sequence {1, 2, 3, 5}" );

        verify( evaluate( this.message, stmts ), "Set sortedBy() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSum( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Set {1, 2, 3, 4, 5}->sum() = 15" );

        verify( evaluate( this.message, stmts ), "Set sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testTypedCollectionSumEmpty( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let set:Set(Integer) = Set {}" + "in set->sum() = 0" );

        verify( evaluate( this.message, stmts ), "Set sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testProduct( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let set1:Set(Integer) = Set {1, 3} in " + "let set2:Set(Integer) = Set {2, 4} in " + "set1->product(set2) = Set{" + "Tuple{first = 1, second = 2}," + "Tuple{first = 1, second = 4}," + "Tuple{first = 3, second = 2},"
                                                + "Tuple{first = 3, second = 4}" + "}" );

        verify( evaluate( this.message, stmts ), "Set product() should be valid" );
    }

    /**
     * 
     */
    @Test
    public void testUnionOnOneElement( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "self->union(Set{self})->isEmpty()" );

        verify( !evaluate( this.message, stmts ), "A bage with two elements should not be empty!" );
    }
}
