package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on the evaluation of CollectionLiteral expressions
 */
public class TestCollectionLiteralEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */

    @Test
    public void testEmptySet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySet: Set(Integer) = Set {} in " + "mySet->isEmpty()" );

        this.verify( this.evaluate( this.message, stmts ), "Empty set invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testPopulatedSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySet: Set(Integer) = Set {1, 2, 1, 3} in " + "mySet->size() = 3 " + "and mySet->includes(1) " + "and mySet->includes(2) " + "and mySet->includes(3)" );

        this.verify( this.evaluate( this.message, stmts ), "Populated set invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testRangePopulatedSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySet: Set(Integer) = Set {2, 1..3} in " + "mySet->size() = 3 " + "and mySet->includes(1) " + "and mySet->includes(2) " + "and mySet->includes(3)" );

        this.verify( this.evaluate( this.message, stmts ), "Populated set invariant should be valid" );
    }

    /**
     *
     */
    @Test
    public void testReverseRangeSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySet: Set(Integer) = Set {3..1} in " + "mySet->size() = 0" );
        this.verify( this.evaluate( this.message, stmts ), "Reverse range set invariant should be empty" );
    }

    /**
     *
     */

    @Test
    public void testEmptyOrderedSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myOrdSet: OrderedSet(Integer) = OrderedSet {} in " + "myOrdSet->isEmpty()" );

        this.verify( this.evaluate( this.message, stmts ), "Empty ordered set invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testPopulatedOrderedSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myOrdSet: OrderedSet(Integer) = " + "OrderedSet {1, 2, 1, 3} in " + "myOrdSet->size() = 3 " + "and myOrdSet->at(1) = 1 " + "and myOrdSet->at(2) = 2 " + "and myOrdSet->at(3) = 3" );

        this.verify( this.evaluate( this.message, stmts ), "Populated ordered set invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testRangePopulatedOrderedSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myOrdSet: OrderedSet(Integer) = OrderedSet {2, 1..3} in " + "myOrdSet->size() = 3 " + "and myOrdSet->at(1) = 2 " + "and myOrdSet->at(2) = 1 " + "and myOrdSet->at(3) = 3" );

        this.verify( this.evaluate( this.message, stmts ), "Populated ordered set invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testReverseRangeOrderedSet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myOrdSet: OrderedSet(Integer) = OrderedSet {3..1} in " + "myOrdSet->size() = 0" );
        this.verify( this.evaluate( this.message, stmts ), "Reverse range ordered set invariant should be empty" );

    }

    /**
     *
     */

    @Test
    public void testEmptySequence( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySeq: Sequence(Integer) = Sequence {} in " + "mySeq->isEmpty()" );

        this.verify( this.evaluate( this.message, stmts ), "Empty sequence invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testPopulatedSequence( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySeq: Sequence(Integer) = Sequence {1, 2, 1, 3} in " + "mySeq->size() = 4 " + "and mySeq->at(1) = 1 " + "and mySeq->at(2) = 2 " + "and mySeq->at(3) = 1 " + "and mySeq->at(4) = 3" );

        this.verify( this.evaluate( this.message, stmts ), "Populated sequence invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testRangePopulatedSequence( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySeq: Sequence(Integer) = Sequence {2, 1..3} in " + "mySeq->size() = 4 " + "and mySeq->at(1) = 2 " + "and mySeq->at(2) = 1 " + "and mySeq->at(3) = 2 " + "and mySeq->at(4) = 3" );

        this.verify( this.evaluate( this.message, stmts ), "Populated sequence invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testReverseRangeSequence( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let mySeq: Sequence(Integer) = Sequence {3..1} in " + "mySeq->size() = 0" );
        this.verify( this.evaluate( this.message, stmts ), "Reverse range sequence invariant should be empty" );

    }

    /**
     *
     */

    @Test
    public void testEmptyBag( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myBag: Bag(Integer) = Bag {} in " + "myBag->isEmpty()" );

        this.verify( this.evaluate( this.message, stmts ), "Empty bag invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testPopulatedBag( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myBag: Bag(Integer) = Bag {1, 2, 1, 3} in " + "myBag->size() = 4 " + "and myBag->count(1) = 2 " + "and myBag->count(2) = 1 " + "and myBag->count(3) = 1" );

        this.verify( this.evaluate( this.message, stmts ), "Populated bag invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testRangePopulatedBag( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myBag: Bag(Integer) = Bag {2, 1..3} in " + "myBag->size() = 4 " + "and myBag->count(1) = 1 " + "and myBag->count(2) = 2 " + "and myBag->count(3) = 1" );

        this.verify( this.evaluate( this.message, stmts ), "Populated bag invariant should be valid" );
    }

    /**
     *
     */

    @Test
    public void testReverseRangeBag( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "let myBag: Bag(Integer) = Bag {3..1} in " + "myBag->size() = 0" );
        this.verify( this.evaluate( this.message, stmts ), "Reverse range bag invariant should be empty" );

    }

    @Test
    public void testEmptyAndNotEmptySet( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "(if self.isFault then Set{} else Set{} endif)->isEmpty()" );
        this.verify( this.evaluate( this.message, stmts ), "This evaluation should be true" );

    }

}
