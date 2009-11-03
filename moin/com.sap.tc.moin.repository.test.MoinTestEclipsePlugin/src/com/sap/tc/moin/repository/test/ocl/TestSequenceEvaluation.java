package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on Sequence operations.
 */
@SuppressWarnings( "nls" )
public class TestSequenceEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testIterate( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "Sequence {1, 2, 3}->iterate(i; x:Integer = 0 | x + i) = 6" );

        verify( evaluate( this.message, stmts ), "Sequence iterate() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Sequence {1, 2, 3, 4, 2, 3}->exists(i | i = 3)" );

        verify( evaluate( this.message, stmts ), "Sequence  exists() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testExistsMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Sequence {1, 2, 3, 4, 2, 3}->exists(i, j | i + j = 7)" );

        verify( evaluate( this.message, stmts ), "Sequence exists() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllSingleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 2, 3} in " + "all->forAll(i | i < 5)" );

        verify( evaluate( this.message, stmts ), "Sequence forAll() single iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testForAllMultipleIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 2, 3} in " + "all->forAll(i, j | i + j < 10)" );

        verify( evaluate( this.message, stmts ), "Sequence forAll() multiple iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIsUniqueIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4} in " + "all->isUnique(i | i)" );

        verify( evaluate( this.message, stmts ), "Sequence isUnique() iterator should be valid" );

        stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 2} in " + "not all->isUnique(i | i)" );

        verify( evaluate( this.message, stmts ), "Sequence isUnique() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testAnyIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let result = Sequence {1, 2, 3, 4}->any(i | i > 2) in " + "result = 3 or result = 4" );

        verify( evaluate( this.message, stmts ), "Sequence any() iterator should be valid" );

        stmts = parse( "context Message inv: " + "Sequence {1, 2, 3, 4}->any(i | i > 4).oclIsUndefined()" );

        verify( evaluate( this.message, stmts ), "Sequence any() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testOneIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "Sequence {1, 2, 3, 4}->one(i | i > 3)" );

        verify( evaluate( this.message, stmts ), "Sequence one() iterator should be valid" );

        stmts = parse( "context Message inv: " + "not Sequence {1, 2, 3, 4}->one(i | i > 2)" );

        verify( evaluate( this.message, stmts ), "Sequence one() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let sequence:Sequence(String) = " + "Sequence {'a', 'bb', 'a', ''} in\n" + "sequence->collect(i | i.size()) = Sequence {1, 2, 1, 0}" );

        verify( evaluate( this.message, stmts ), "Sequence collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectIteratorWithCollections( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let sequence:Sequence(Bag(String)) = " + "Sequence {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "let result:Sequence(String) = sequence->collect(i | i) in\n" + "((result->at(1) = 'a' and result->at(2) = 'b') "
                                                + " or (result->at(1) = 'b' and result->at(2) = 'a'))\n" + "and\n" + "((result->at(3) = 'b' and result->at(4) = 'c') " + " or (result->at(3) = 'c' and result->at(4) = 'b'))" );

        verify( evaluate( this.message, stmts ), "Sequence collect() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCollectNestedIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let sequence:Sequence(Bag(String)) = " + "Sequence {Bag{'a', 'b'}, Bag{'b', 'c'}} in\n" + "sequence->collectNested(i | i) = " + "Sequence {Bag{'a', 'b'}, Bag{'b', 'c'}}" );

        verify( evaluate( this.message, stmts ), "Sequence collectNested() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSelectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->select(i | i.mod(2) = 0) = Sequence {2, 4, 2}" );

        verify( evaluate( this.message, stmts ), "Sequence select() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testRejectIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->reject(i | i.mod(2) = 0) = Sequence {1, 3, 3}" );

        verify( evaluate( this.message, stmts ), "Sequence reject() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFirstAndLast( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->first() = 1 and all->last() = 2" );

        verify( evaluate( this.message, stmts ), "Sequence first() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testCount( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->count(2) = 2" );

        verify( evaluate( this.message, stmts ), "Sequence count() iterator should be valid" );
    }

    /**
    *
    */
    @Test
    public void testAppend( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->append(15)->last() = 15" );

        verify( evaluate( this.message, stmts ), "Sequence append() iterator should be valid" );
    }

    /**
    *
    */
    @Test
    public void testIndexOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->indexOf(3) = 3" );

        verify( evaluate( this.message, stmts ), "Sequence indexOf() iterator should be valid" );
    }

    /**
    *
    */
    @Test
    public void testInsertAt( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->insertAt(3,15)->indexOf(15) = 3" );

        verify( evaluate( this.message, stmts ), "Sequence insertAt() iterator should be valid" );
    }

    /**
    *
    */
    @Test
    public void testSubSequence( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->insertAt(3,15)->subSequence(1,3)->size() = 3" );

        verify( evaluate( this.message, stmts ), "Sequence subSequence() iterator should be valid" );
    }

    /**
   *
   */
    @Test
    public void testPrepend( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {1, 2, 3, 4, 3, 2} in " + "all->prepend(15)->first() = 15" );

        verify( evaluate( this.message, stmts ), "Sequence prepend() iterator should be valid" );
    }

    /**
     * 
     */
    @Test
    public void testUnion( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let first:Sequence(Integer) = Sequence {1, 2}, second:Sequence(Integer) = Sequence {3, 4} in " + "first->union(second)->size() = 4" );

        verify( evaluate( this.message, stmts ), "Sequence prepend() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSortedByIterator( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let all:Sequence(Integer) = Sequence {2, 5, 1, 3, 2, 4} in " + "all->sortedBy(i | i) = Sequence {1, 2, 2, 3, 4, 5}" );

        verify( evaluate( this.message, stmts ), "Sequence sortedBy() iterator should be valid" );
    }

    /**
     *
     */
    @Test
    public void testSum( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "Sequence {1, 2, 3, 4, 5}->sum() = 15" );

        verify( evaluate( this.message, stmts ), "Sequence sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testTypedCollectionSumEmpty( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:" + "let sequence:Sequence(Integer) = Sequence {}" + "in sequence->sum() = 0" );

        verify( evaluate( this.message, stmts ), "Sequence sum() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testProduct( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let sequence1:Sequence(Integer) = Sequence {1, 3} in " + "let sequence2:Sequence(Integer) = Sequence {2, 4} in " + "sequence1->product(sequence2) = Set{" + "Tuple{first = 1, second = 2}," + "Tuple{first = 1, second = 4},"
                                                + "Tuple{first = 3, second = 2}," + "Tuple{first = 3, second = 4}" + "}" );

        verify( evaluate( this.message, stmts ), "Sequence product() should be valid" );
    }
}