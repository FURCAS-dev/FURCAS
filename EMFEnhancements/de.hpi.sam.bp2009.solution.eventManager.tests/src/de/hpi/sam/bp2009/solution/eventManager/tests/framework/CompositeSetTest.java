package de.hpi.sam.bp2009.solution.eventManager.tests.framework;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.eventManager.CompositeCollection;
import de.hpi.sam.bp2009.solution.eventManager.CompositeSet;


public class CompositeSetTest extends TestCase {
    private Set<Integer> emptySet = Collections.emptySet();
    private Set<Integer> firstSet;
    private Set<Integer> secondSet;
    
    @Before
    public void setUp() {
        firstSet = new HashSet<Integer>();
        firstSet.add(1);
        firstSet.add(2);
        firstSet.add(3);
        secondSet = new HashSet<Integer>();
        secondSet.add(4);
        secondSet.add(5);
        secondSet.add(6);
    }
    
    @Test
    public void testEmpty() {
        @SuppressWarnings("unchecked")
        CompositeCollection<Integer> cs = new CompositeCollection<Integer>();
        assertTrue(cs.isEmpty());
        assertEquals(0, cs.size());
    }

    @Test
    public void testSimpleSet() {
        @SuppressWarnings("unchecked")
        CompositeCollection<Integer> cs = new CompositeSet<Integer>(firstSet);
        assertFalse(cs.isEmpty());
        assertEquals(firstSet.size(), cs.size());
        assertTrue(firstSet.containsAll(cs));
        assertTrue(cs.containsAll(firstSet));
        assertEquals(cs, firstSet);
    }
    
    @Test
    public void testTwoSets() {
        @SuppressWarnings("unchecked")
        CompositeCollection<Integer> cs = new CompositeCollection<Integer>(firstSet, secondSet);
        assertFalse(cs.isEmpty());
        assertEquals(firstSet.size()+secondSet.size(), cs.size());
        assertTrue(cs.containsAll(firstSet));
        assertTrue(cs.containsAll(secondSet));
        assertContainsAll(cs, firstSet);
        assertContainsAll(cs, secondSet);
    }
    
    @Test
    public void testIntermittentEmptySets() {
        @SuppressWarnings("unchecked")
        CompositeCollection<Integer> cs = new CompositeCollection<Integer>(emptySet, firstSet, emptySet, secondSet, emptySet);
        assertFalse(cs.isEmpty());
        assertEquals(firstSet.size()+secondSet.size(), cs.size());
        assertTrue(cs.containsAll(firstSet));
        assertTrue(cs.containsAll(secondSet));
        assertContainsAll(cs, firstSet);
        assertContainsAll(cs, secondSet);
    }
    
    private <T> void assertContainsAll(CompositeCollection<T> cs, Collection<T> other) {
        Set<T> notFound = new HashSet<T>(other);
        for (T t : cs) {
            notFound.remove(t);
        }
        assertEquals("Didn't find elements "+notFound+" in composite set's iterator", 0, notFound.size());
    }
    
}