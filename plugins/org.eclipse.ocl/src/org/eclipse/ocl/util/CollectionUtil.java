/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CollectionUtil.java,v 1.5 2008/03/26 21:17:25 cdamus Exp $
 */
package org.eclipse.ocl.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;

/**
 * Utility methods for working with OCL collection values.
 *
 * @author Christian W. Damus (cdamus)
 */
public class CollectionUtil {

    // not instantiable
	private CollectionUtil() {
		super();
	}

    /**
     * Implementation of the OCL
     * <tt>Collection::includes(object : T) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return whether the collection includes the object
     */
    public static boolean includes(Collection<?> self, Object object) {
    	return self.contains(object);
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::excludes(object : T) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return whether the collection does not include the object
     */
    public static boolean excludes(Collection<?> self, Object object) {
        return !includes(self, object);
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::count(object : T) : Integer</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return the number of occurrences of the object in the collection
     */
    public static int count(Collection<?> self, Object object) {
        int count = 0;
        for (Object next : self) {
            if (ObjectUtil.equal(next, object)) {
                count++;
            }
        }
        
        return count;
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::includesAll(c : Collection(T)) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param c another collection
     * @return whether the source collection includes all of the elements
     *     of the other
     */
    public static boolean includesAll(Collection<?> self, Collection<?> c) {
    	for (Object next : c) {
    		if (!includes(self, next)) {
    			return false;
    		}
    	}
    	
        return true;
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::excludesAll(c : Collection(T)) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param c another collection
     * @return whether the source collection does not contain any of the
     *     elements of the other
     */
    public static boolean excludesAll(Collection<?> self, Collection<?> c) {
        for (Object next : c) {
            if (includes(self, next)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::isEmpty() : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @return whether the collection does not have any elements
     */
    public static boolean isEmpty(Collection<?> self) {
        return self.isEmpty();
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::notEmpty() : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @return whether the collection has any elements
     */
    public static boolean notEmpty(Collection<?> self) {
        return !self.isEmpty();
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::sum() : T</tt>
     * operation.
     * 
     * @param self the source collection
     * @return the sum of the collection's elements
     */
    // Assumes the elements of the collection are all Integer or
    // all Double.
    public static Object sum(Collection<?> self) {

        if (self.isEmpty()) {
            return null; // undefined
        }
        
        Iterator<?> it = self.iterator();
        Object object = it.next();

        // two cases: Integer and Double
        if (object instanceof Integer) {
            int currVal = 0;
            for (it = self.iterator(); it.hasNext();) {
                currVal += ((Integer) it.next()).intValue();
            }
            return new Integer(currVal);
        } else if (object instanceof Double) {
            double currVal = 0.0;
            for (it = self.iterator(); it.hasNext();) {
                currVal += ((Double) it.next()).doubleValue();
            }
            return new Double(currVal);
        } else {
            IllegalArgumentException error = new IllegalArgumentException(
            		OCLMessages.SumOperator_ERROR_);
            OCLPlugin.throwing(CollectionUtil.class, "sum", error);//$NON-NLS-1$
            throw error;
        }
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::=(set : Set(T)) : Boolean</tt></li>
     * <li><tt>OrderedSet::=(set : OrderedSet(T)) : Boolean</tt></li>
     * <li><tt>Bag::=(bag : Bag(T)) : Boolean</tt></li>
     * <li><tt>Sequence::=(s : Sequence(T)) : Boolean</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param c another collection of the same kind
     * @return whether collections are equal
     */
    public static boolean equals(Collection<?> self, Collection<?> c) {
    	if (self.size() != c.size()) {
    		// collections of different sizes cannot be equal
    		return false;
    	} else if (self instanceof Bag && c instanceof Bag) {
            return ((Bag<?>) self).equals(c);
    	} else if (self instanceof List && c instanceof List) {
            return ((List<?>) self).equals(c);
    	} else if (self instanceof LinkedHashSet && c instanceof LinkedHashSet) {
            // OrderedSet

            // LinkedHashSet.equals() doesn't care about order but we do
            int size1 = self.size();
            int size2 = c.size();
            if (size1 != size2) {
                return false;
            }
            Iterator<?> it1 = self.iterator();
            Iterator<?> it2 = c.iterator();
            while (it1.hasNext()) {
                Object o1 = it1.next();
                Object o2 = it2.next();
                if (!o1.equals(o2)) {
                    return false;
                }
            }
            
            return true;
        } else if (self instanceof Set && c instanceof Set) {
        	return ((Set<?>) self).equals(c);
        } else {
        	// incompatible OCL types
        	return false;
        }
    }
    
    /**
     * Computes the hash of a collection, accounting for the similar hashing of
     * primitive numeric values that OCL considers equal but Java does not.
     * 
     * @param c a collection
     * 
     * @return its hash
     */
    public static int hashCode(Collection<?> c) {
    	int result = 1;
    	
    	for (Object next : c) {
    		result = 37 * result + ObjectUtil.hashCode(next);
    	}
    	
    	return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::intersection(set : Set(T)) : Set(T)</tt></li>
     * <li><tt>Set::intersection(bag : Bag(T)) : Set(T)</tt></li>
     * <li><tt>Bag::intersection(set : Set(T)) : Set(T)</tt></li>
     * <li><tt>Bag::intersection(bag : Bag(T)) : Set(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source set or bag
     * @param c another set or bag
     * @return the intersection of the source set or bag with the other set or bag
     */
    public static <E> Collection<E> intersection(
    		Collection<? extends E> self, Collection<? extends E> c) {
    	
        int size1 = self.size();
        int size2 = c.size();
        
        // if either collection is empty, then so is the result
        if (size1 == 0) {
            return createNewCollection(self);
        } else if (size2 == 0) {
            return createNewCollection(c);
        }
        
        Collection<E> result = null;

        if (self instanceof Set || c instanceof Set) {
            // if either argument is a set, so is the result
            if (size1 == 0 || size2 == 0) {
                return Collections.emptySet();
            }
            result = createNewSet();
        } else {
            // both arguments are bags, so is the result
            if (size1 == 0 || size2 == 0) {
                return BagImpl.emptyBag();
            }
            result = createNewBag();
        }

        // loop over the smaller collection and add only elements
        // that are in the larger collection
        if (self.size() > c.size()) {
            for (E e : c) {
                if (includes(self, e)) {
                    result.add(e);
                }
            }
        } else {
            for (E e : self) {
                if (includes(c, e)) {
                    result.add(e);
                }
            }
        }

        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::union(set : Set(T)) : Set(T)</tt></li>
     * <li><tt>Set::union(bag : Bag(T)) : Bag(T)</tt></li>
     * <li><tt>Bag::union(set : Set(T)) : Bag(T)</tt></li>
     * <li><tt>Bag::union(bag : Bag(T)) : Bag(T)</tt></li>
     * <li><tt>Sequence::union(s : Sequence(T)) : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param c another collection
     * @return the union of the source collection with the other
     */
    public static <E> Collection<E> union(
    		Collection<? extends E> self, Collection<? extends E> c) {
    	
    	// if either argument is empty, then the union is the other
    	if (self.isEmpty()) {
            return createNewCollection(c);
        } else if (c.isEmpty()) {
            return createNewCollection(self);
        }
    	
        Collection<E> result = null;
        if (self instanceof Bag || c instanceof Bag) {
            result = createNewBag(self);
        } else if (self instanceof List || c instanceof List) {
            result = createNewSequence(self);
        } else {
            result = createNewSet(self);
        }
        
        result.addAll(c);

        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::flatten() : Set(T2)</tt></li>
     * <li><tt>Bag::flatten() : Bag(T2)</tt></li>
     * <li><tt>Sequence::flatten() : Sequence(T2)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the flattened collection
     */
    public static Collection<?> flatten(Collection<?> self) {
        Collection<?> result = self;
        
        for (;;) {
            if (result.isEmpty()) {
                break;
            }
            
            Iterator<?> it = result.iterator();
            Object object = it.next();
    
            // if the element type is not a collection type, the result is the
            // current collection.
            if (!(object instanceof Collection)) {
                break;
            }
    
            Collection<Object> newResult = null;
            if (result instanceof Bag) {
                newResult = createNewBag();
            } else if (result instanceof Set) {
                newResult = createNewSet();
            } else {
                // Sequence
                newResult = createNewSequence();
            }
            
            // the element type is a collection type -- flatten one level
            newResult.addAll((Collection<?>) object);
            while (it.hasNext()) {
                newResult.addAll((Collection<?>) it.next());
            }
            
            result = newResult;
            // loop until the result is empty or the first element is not a
            // collection
        }
        
        return result;
    }

    /**
     * Obtains the type of the flattened form of the specified collection type.
     * 
     * @param type a collection type
     * @return the flattened collection type
     * 
     * @since 1.2
     */
    @SuppressWarnings("unchecked")
    public static <C> C getFlattenedElementType(
            CollectionType<C, ?> type) {
        
        C result = type.getElementType();
        
        while (result instanceof CollectionType) {
            result = ((CollectionType<C, ?>) result).getElementType();
        }
        
        return result;
    }

    /**
     * Implementation of the OCL
     * <tt>Set::-(set : Set(T)) : Set(T)</tt>
     * operation.
     * 
     * @param self the source set
     * @param set another set
     * @return the subtraction of the other set from the source set
     */
    public static <E> Set<E> minus(Set<? extends E> self, Set<? extends E> set) {
        Set<E> result = createNewSet(self);
        result.removeAll(set);
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::excluding(object : T) : Set(T)</tt></li>
     * <li><tt>Bag::excluding(object : T) : Bag(T)</tt></li>
     * <li><tt>Sequence::excluding(object : T) : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param object an object
     * @return the source collection without any occurences of the object
     */
    public static <E> Collection<E> excluding(Collection<E> self, Object object) {
        Collection<E> result = null;
        if (self instanceof Set) {
            result = createNewSet(self);
        } else if (self instanceof Bag) {
            result = createNewBag(self);
        } else if (self instanceof List) {
            List<E> resultSeq = createNewSequence(self);
            while (resultSeq.remove(object)) {
                ; // for sequences we need to remove all the matching elements
            }
            return resultSeq;
        } else {
            result = createNewOrderedSet(self);
        }

        // non-sequences (bags remove all occurrences internally)
        result.remove(object);
        return result;
    }

    /**
     * Implementation of the OCL
     * <tt>Set::symmetricDifference(set : Set(T)) : Set(T)</tt>
     * operation.
     * 
     * @param self the source set
     * @param set another set
     * @return the set of elements in either the source or the other set but not
     *     in both
     */
    public static <E> Set<E> symmetricDifference(Set<? extends E> self,
        Set<? extends E> set) {
        
        Set<E> result = createNewSet(self);
        
        for (E e : set) {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        }
        
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::including(object : T) : Set(T)</tt></li>
     * <li><tt>Bag::including(object : T) : Bag(T)</tt></li>
     * <li><tt>Sequence::including(object : T) : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param object an object
     * @return the source collection with the object added
     */
    public static <E> Collection<E> including(Collection<E> self, E object) {
        Collection<E> result;
        
        if (self instanceof Set) {
            result = createNewSet(self);
        } else if (self instanceof Bag) {
            result = createNewBag(self);
        } else {
            result = createNewSequence(self);
        }

        result.add(object);
        
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::asSet() : Set(T)</tt></li>
     * <li><tt>Bag::asSet() : Set(T)</tt></li>
     * <li><tt>Sequence::asSet() : Set(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the source collection as a set
     */
    public static <E> Set<E> asSet(Collection<E> self) {
        if (self instanceof Set) {
            return (Set<E>) self;
        }
        return createNewSet(self);
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::asBag() : Bag(T)</tt></li>
     * <li><tt>Bag::asBag() : Bag(T)</tt></li>
     * <li><tt>Sequence::asBag() : Bag(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the source collection as a bag
     */
    public static <E> Bag<E> asBag(Collection<E> self) {
        if (self instanceof Bag) {
            return (Bag<E>) self;
        }
        return createNewBag(self);
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::asSequence() : Sequence(T)</tt></li>
     * <li><tt>Bag::asSequence() : Sequence(T)</tt></li>
     * <li><tt>Sequence::asSequence() : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the source collection as a sequence
     */
    public static <E> List<E> asSequence(Collection<E> self) {
        if (self instanceof List) {
            return (List<E>) self;
        }
        return createNewSequence(self);
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>Set::asOrderedSet() : OrderedSet(T)</tt></li>
     * <li><tt>Bag::asOrderedSet() : OrderedSet(T)</tt></li>
     * <li><tt>Sequence::asOrderedSet() : OrderedSet(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the source collection as an ordered set
     */
    public static <E> LinkedHashSet<E> asOrderedSet(Collection<E> self) {
        // TODO: create an interface for OrderedSet
        if (self instanceof LinkedHashSet) {
            return (LinkedHashSet<E>) self;
        }
        return createNewOrderedSet(self);
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::product(c : Collection(T2)) : Set(Tuple(first : T, second : T2))</tt>
     * operations.
     * 
     * @param evalEnv the current evaluation environment (for construction of
     *     tuples)
     * @param env the current OCL environment (for introspection of the tuple type)
     * @param self the source collection
     * @param c another collection
     * @return the product of the collections
     */
    public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    Set<Tuple<O, P>> product(EvaluationEnvironment<C, O, P, CLS, E> evalEnv,
    		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
    		Collection<?> self, Collection<?> c, C tupleType) {
    	
        Set<Tuple<O, P>> result = createNewSet();
        
		Map<P, Object> propertyValues = new HashMap<P, Object>();
		P firstProperty = env.lookupProperty(
				tupleType,
				OCLStandardLibraryUtil.PRODUCT_FIRST);
		P secondProperty = env.lookupProperty(
				tupleType,
				OCLStandardLibraryUtil.PRODUCT_SECOND);
		
        for (Object next1 : self) {
        	for (Object next2 : c) {
        		propertyValues.put(firstProperty, next1);
    			propertyValues.put(secondProperty, next2);
    			
        		result.add(evalEnv.createTuple(tupleType, propertyValues));
        	}
        }
        
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::append(object : T) : OrderedSet(T)</tt></li>
     * <li><tt>Sequence::append(object : T) : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param object an object
     * @return the source collection with the object appended
     */
    public static <E> Collection<E> append(Collection<E> self, E object) {
        Collection<E> result;
        // TODO: make an interface for OrderedSet
        if (self instanceof LinkedHashSet) {
            result = createNewOrderedSet(self);
            result.remove(object);  // appended object must be last
        } else {
            result = createNewSequence(self);
        }
        
        result.add(object);
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::prepend(object : T) : OrderedSet(T)</tt></li>
     * <li><tt>Sequence::prepend(object : T) : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param object an object
     * @return the source collection with the object prepended
     */
    public static <E> Collection<E> prepend(Collection<E> self, E object) {
        Collection<E> result;
        if (self instanceof LinkedHashSet) {
            result = createNewOrderedSet();
        } else {
            result = createNewSequence();
        }
        result.add(object);
        result.addAll(self);
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::insertAt(index : Integer, object : T) : OrderedSet(T)</tt></li>
     * <li><tt>Sequence::insertAt(index : Integer, object : T) : Sequence(T)</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param index the 1-based (in OCL fashion) index
     * @param object an object
     * @return the source collection with the object inserted at the index
     */
    public static <E> Collection<E> insertAt(Collection<E> self, int index, E object) {
        index = index - 1;
        
        if (index - 1 < 0 || index > self.size()) {
            return null; // undefined
        }
        
        Collection<E> result;
        if (self instanceof LinkedHashSet) {
            result = createNewOrderedSet();
        } else {
            result = createNewSequence();
        }
        int curr = 0;
        for (Iterator<E> it = self.iterator(); it.hasNext();) {
            if (curr == index) {
                result.add(object);
            }
            result.add(it.next());
            curr++;
        }
        return result;
    }

    /**
     * Implementation of the OCL
     * <tt>OrderedSet::subOrderedSet(lower : Integer, upper : Integer) : OrderedSet(T)</tt>
     * operation.
     * 
     * @param self the source set
     * @param lower the 1-based (in OCL fashion) inclusive lower bound
     * @param upper the 1-based (in OCL fashion) inclusive upper bound
     * @return the slice of the source set
     */
    public static <E> Collection<E> subOrderedSet(Collection<E> self, int lower,
            int upper) {
        lower = lower - 1;
        upper = upper - 1;
        
        if (lower < 0 || upper >= self.size() || upper < lower) {
            return null; // undefined
        }
        
        Collection<E> result;
        if (self instanceof LinkedHashSet) {
            result = createNewOrderedSet();
        } else {
            result = createNewSequence();
        }
        int curr = 0;
        for (Iterator<E> it = self.iterator(); it.hasNext();) {
            E object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return result;
    }

    /**
     * Implementation of the OCL
     * <tt>Sequence::subSequence(lower : Integer, upper : Integer) : Sequence(T)</tt></li>
     * operation.
     * 
     * @param self the source sequence
     * @param lower the 1-based (in OCL fashion) inclusive lower bound
     * @param upper the 1-based (in OCL fashion) inclusive upper bound
     * @return the source collection with the object inserted at the index
     */
    public static <E> Collection<E> subSequence(Collection<E> self, int lower,
            int upper) {
        lower = lower - 1;
        upper = upper - 1;
        
        if (lower < 0 || upper >= self.size() || upper < lower) {
            return null; // undefined
        }
        
        Collection<E> result = createNewSequence();
        int curr = 0;
        for (Iterator<E> it = self.iterator(); it.hasNext();) {
            E object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::at(index : Integer) : T</tt></li>
     * <li><tt>Sequence::at(index : Integer) : T</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param index the 1-based (in OCL fashion) index
     * @return the object at the specified index of the source collection
     */
    public static <E> E at(Collection<E> self, int index) {
        index = index - 1;
        
        if (index < 0 || index >= self.size()) {
            return null; // undefined
        }
        
        int curr = 0;
        for (Iterator<E> it = self.iterator(); it.hasNext();) {
            E object = it.next();
            if (curr++ == index) {
                return object;
            }
        }
        return null; // undefined
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::first() : T</tt></li>
     * <li><tt>Sequence::first() : T</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the first object of the source collection
     */
    public static <E> E first(Collection<E> self) {
        if (self.isEmpty()) {
            return null; // undefined
        }
        return self.iterator().next();
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::lset() : T</tt></li>
     * <li><tt>Sequence::lset() : T</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @return the last object in the source collection
     */
    public static <E> E last(Collection<E> self) {
        if (self.isEmpty()) {
            return null; // undefined
        }
        E result = null;
        for (E next : self) {
            result = next;
        }
        return result;
    }

    /**
     * Implementation of the OCL
     * <ul>
     * <li><tt>OrderedSet::indexOf(object : T) : Integer</tt></li>
     * <li><tt>Sequence::indexOf(object : T) : Integer</tt></li>
     * </ul>
     * operations.
     * 
     * @param self the source collection
     * @param object an object
     * @return the index of the object in the source collection
     */
    public static <E> Integer indexOf(Collection<? extends E> self, E object) {
        int index = 1;
        
        for (E next : self) {
            if (object.equals(next)) {
                return index;
            }
            index++;
        }
        
        return null; // undefined
    }

    /**
     * Creates a new OCL <tt>Set</tt>.
     */
    @SuppressWarnings("unchecked")
    public static <E> Set<E> createNewSet() {
        return (Set<E>) createNewCollection(CollectionKind.SET_LITERAL);
    }

    /**
     * Creates a new OCL <tt>Set</tt> with initial contents supplied.
     */
    @SuppressWarnings("unchecked")
    public static <E> Set<E> createNewSet(Collection<? extends E> c) {
        return (Set<E>) createNewCollection(CollectionKind.SET_LITERAL, c);
    }

    /**
     * Creates a new OCL <tt>Bag</tt>.
     */
    @SuppressWarnings("unchecked")
    public static <E> Bag<E> createNewBag() {
        return (Bag<E>) createNewCollection(CollectionKind.BAG_LITERAL);
    }

    /**
     * Creates a new OCL <tt>Bag</tt> with initial contents supplied.
     */
    @SuppressWarnings("unchecked")
    public static <E> Bag<E> createNewBag(Collection<? extends E> c) {
        return (Bag<E>) createNewCollection(CollectionKind.BAG_LITERAL, c);
    }

    /**
     * Creates a new OCL <tt>OrderedSet</tt>.
     */
    @SuppressWarnings("unchecked")
    public static <E> LinkedHashSet<E> createNewOrderedSet() {
        return (LinkedHashSet<E>) createNewCollection(
        		CollectionKind.ORDERED_SET_LITERAL);
    }

    /**
     * Creates a new OCL <tt>OrderedSet</tt> with initial contents supplied.
     */
    @SuppressWarnings("unchecked")
    public static <E> LinkedHashSet<E> createNewOrderedSet(Collection<? extends E> c) {
        return (LinkedHashSet<E>) createNewCollection(
        		CollectionKind.ORDERED_SET_LITERAL, c);
    }

    /**
     * Creates a new OCL <tt>Sequence</tt>.
     */
    @SuppressWarnings("unchecked")
    public static <E> List<E> createNewSequence() {
        return (List<E>) createNewCollection(CollectionKind.SEQUENCE_LITERAL);
    }

    /**
     * Creates a new OCL <tt>Sequence</tt> with initial contents supplied.
     */
    @SuppressWarnings("unchecked")
    public static <E> List<E> createNewSequence(Collection<? extends E> c) {
        return (List<E>) createNewCollection(CollectionKind.SEQUENCE_LITERAL, c);
    }
    
    /**
     * Creates a new, empty OCL collection of the same kind as the specified
     * prototype.
     * 
     * @param c a collection
     * @return a new, empty collection of the same kind as <code>c</code>
     */
    public static <E> Collection<E> createNewCollectionOfSameKind(Collection<?> c) {
    	Collection<E> result;
    	
    	if (c instanceof Bag) {
    		result = createNewBag();
    	} else if (c instanceof LinkedHashSet) {
    		result = createNewOrderedSet();
    	} else if (c instanceof Set) {
    		result = createNewSet();
    	} else {
    		result = createNewSequence();
    	}
    	
    	return result;
    }
    
    /**
     * Creates a new OCL collection of the same kind and contents as the
     * specified prototype.
     * 
     * @param c a collection
     * @return a copy of <code>c</code>
     */
    public static <E> Collection<E> createNewCollection(Collection<? extends E> c) {
    	Collection<E> result;
    	
    	if (c instanceof Bag) {
    		result = createNewBag(c);
    	} else if (c instanceof LinkedHashSet) {
    		result = createNewOrderedSet(c);
    	} else if (c instanceof Set) {
    		result = createNewSet(c);
    	} else {
    		result = createNewSequence(c);
    	}
    	
    	return result;
    }
    
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified kind.
     * 
	 * @param kind the OCL collection kind
	 * @return the new collection
	 */
	public static <E> Collection<E> createNewCollection(CollectionKind kind) {
		switch (kind) {
			case SET_LITERAL:
				return new HashSet<E>();
			case SEQUENCE_LITERAL:
				return new ArrayList<E>();
			case ORDERED_SET_LITERAL:
				return new LinkedHashSet<E>();
			case BAG_LITERAL:
				return new BagImpl<E>();
			default: {
				String message = OCLMessages.bind(
						OCLMessages.OCLCollectionKindNotImpl_ERROR_,
						kind);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(
						CollectionUtil.class,
						"createNewCollection", error);//$NON-NLS-1$
				throw error;

			}
		}
	}
	
    /**
     * Creates a new OCL <tt>Collection</tt> of the specified kind.
     * 
     * @param kind the OCL collection kind
     * @param c the contents of the new collection
     * @return the new collection of the specified <code>kind</code>, containing
     *     the same elements as <code>c</code>
     */
	public static <E> Collection<E> createNewCollection(
			CollectionKind kind, Collection<E> c) {
		switch (kind) {
			case SET_LITERAL:
				return new HashSet<E>(c);
			case SEQUENCE_LITERAL:
				return new ArrayList<E>(c);
			case BAG_LITERAL:
				return new BagImpl<E>(c);
			case ORDERED_SET_LITERAL:
				return new LinkedHashSet<E>(c);
			default: {
				String message = OCLMessages.bind(
						OCLMessages.OCLCollectionKindNotImpl_ERROR_,
						kind);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(
						CollectionUtil.class,
						"createNewCollection", error);//$NON-NLS-1$
				throw error;
			}
		}
	}
	
	/**
	 * Infers the OCL kind of a collection.
	 * 
	 * @param c a collection (not <code>null</code>)
	 * 
	 * @return its kind (likewise, not <code>null</code>)
	 */
	private static CollectionKind kindOf(Collection<?> c) {
	    CollectionKind result;
	    
        if (c instanceof List){
            result = CollectionKind.SEQUENCE_LITERAL;
        } else if (c instanceof LinkedHashSet) {
            result = CollectionKind.ORDERED_SET_LITERAL;
        } else if (c instanceof Set) {
            result = CollectionKind.SET_LITERAL;
        } else if (c instanceof Bag) {
            result = CollectionKind.BAG_LITERAL;
        } else {
            result = CollectionKind.COLLECTION_LITERAL;
        }
        
        return result;
	}
	
	/**
	 * Computes the string representation of a collection value using syntax
	 * like OCL's collection literals (e.g., <tt>OrderedSet{...}</tt>) instead
	 * of Java's default (i.e., <tt>[...]</tt>).
	 * 
	 * @param c a collection (not <code>null</code>)
	 * @return the string representation of the specified collection
	 * 
	 * @since 1.2
	 */
	public static String toString(Collection<?> c) {
	    StringBuilder result = new StringBuilder();
	    
        result.append(kindOf(c).getName());
        result.append('{');
        
        boolean notFirst = false;
        for (Iterator<?> iter = c.iterator();;) {
            if (iter.hasNext()) {
                if (notFirst) {
                    result.append(", ");
                } else {
                    notFirst = true;
                }
                
                Object next = iter.next();
                if (next instanceof Collection) {
                    // nested collection
                    result.append(toString((Collection<?>) next));
                } else if (next instanceof String) {
                    // string literal
                    result.append('\'').append(next).append('\'');
                } else {
                    result.append(next);
                }
            } else {
                break;
            }
        }
        
        result.append('}');
        
	    return result.toString();
	}
}
