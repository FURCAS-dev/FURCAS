package com.sap.runlet.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.ap.metamodel.utils.StringFormatter;
import com.sap.runlet.abstractinterpreter.util.Tuple.Pair;

import data.classes.MethodSignature;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.SignatureOwner;
import data.classes.TypeAdapter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;

public class MethodCallResolver {
    /**
     * Caches the {@link URI}s of the signature implementation model elements; only URIs
     * because different ResourceSets may want to know.
     */
    private Map<Pair<MethodSignature, SapClass>, URI> cache =
	new HashMap<Pair<MethodSignature, SapClass>, URI>();
    
    private final MethodCallResolverCacheInvalidationListener listener;

    /**
     * Registers the method call resolver as an event listener with an event manager for the
     * resource set. Every time an event is received that may cause a change in method resolution,
     * the cache is invalidated.
     */
    public MethodCallResolver(ResourceSet resourceSet) {
        listener = new MethodCallResolverCacheInvalidationListener(this);
        EventManagerFactory.eINSTANCE.getEventManagerFor(resourceSet).subscribe(listener.getFilter(), listener);
    }

    public SignatureImplementation getImplementation(MethodSignature staticSignature, SapClass dynamicClass, ResourceSet resourceSet) {
	Pair<MethodSignature, SapClass> key = new Pair<MethodSignature, SapClass>(staticSignature, dynamicClass);
	SignatureImplementation result;
	URI implURI = cache.get(key);
	if (implURI == null) {
	    result = resolveMethodCallToImplementation(staticSignature, dynamicClass);
	    cache.put(key, EcoreUtil.getURI(result));
	} else {
	    result = (SignatureImplementation) resourceSet.getEObject(implURI, /* loadOnDemand */ true);
	}
	return result;
    }
    
    public void invalidateCache() {
	cache.clear();
    }

    /**
     * Implements the polymorphism strategy. When a method is to be invoked on
     * an object, the object's runtime type needs to be considered in order to
     * determine the right implementation for the method signature invoked.
     * <p>
     * 
     * The algorithm checks if there is a signature on the runtime type of the
     * <tt>thiz</tt> object that conforms to <tt>calledSignature</tt>. If one is
     * found, it is returned. If none is found, the set of adapters known for
     * <tt>thiz</tt>'s runtime class are transitively checked for matching
     * implementations. If none is found, this means there is a conformance
     * problem where <tt>thiz</tt> does not conform to the class by which
     * <tt>calledSignature</tt> is defined which points to a problem in the
     * design-time's type checks. A {@link RuntimeException} is thrown in this
     * case. Otherwise, the signature implementation found in an adapter will be
     * returned.
     * 
     * TODO what about delegation?
     */
    public SignatureImplementation resolveMethodCallToImplementation(MethodSignature calledSignature, SapClass thizClass) {
	SapClass staticClass = (SapClass) calledSignature.getOwner();
	SignatureImplementation result = findConformingSignature(calledSignature, thizClass);
	if (result == null) {
	    // No conforming signature found on thizClass; search along adapters
	    List<TypeAdapter> adapterChain = getAdapterChain(thizClass, staticClass);
	    if (adapterChain == null) {
		throw new RuntimeException("Internal error: couldn't resolve method " + StringFormatter.toString(calledSignature)
			+ " on type " + thizClass.getName());
	    }
	    for (TypeAdapter ta : getAdapterChain(thizClass, staticClass)) {
		result = findConformingSignature(calledSignature, ta);
		if (result != null) {
		    break;
		}
	    }
	}
	return result;
    }

    /**
     * Tries to locate an owned signature on the <tt>signatureOwner</tt> that
     * conforms to <tt>calledSignature</tt>. If no such signature can be found,
     * <tt>null</tt> is returned. <em>No</em> adapter lookups are performed by
     * this method.
     */
    private SignatureImplementation findConformingSignature(MethodSignature calledSignature, SignatureOwner signatureOwner) {
	for (MethodSignature thizClassSignature : signatureOwner.getOwnedSignatures()) {
	    if (thizClassSignature.conformsTo(calledSignature)) {
		return thizClassSignature.getImplementation();
	    }
	}
	return null;
    }

    /**
     * Attempts to find a chain of {@link TypeAdapter}s where the first's
     * {@link TypeAdapter#getAdapted()} equals <tt>from</tt> and the last
     * adapter's {@link TypeAdapter#getTo()} equals <tt>to</tt> and for each
     * consecutive pair of adapters <tt>a1</tt> and <tt>a2</tt> in the chain,
     * 
     * <tt>a1.{@link TypeAdapter#getTo() getTo}.equals(a2.{@link TypeAdapter#getAdapted() getAdapted})</tt>
     * .
     */
    private List<TypeAdapter> getAdapterChain(SapClass from, SapClass to) {
	// TODO consider caching the adapter chain results
	return getAdapterChain(from, to, new HashSet<SapClass>());
    }

    /**
     * Attempts to find a chain of {@link TypeAdapter}s where the first's
     * {@link TypeAdapter#getAdapted()} equals <tt>from</tt> and the last
     * adapter's {@link TypeAdapter#getTo()} equals <tt>to</tt> and for each
     * consecutive pair of adapters <tt>a1</tt> and <tt>a2</tt> in the chain,
     * 
     * <tt>a1.{@link TypeAdapter#getTo() getTo}.equals(a2.{@link TypeAdapter#getAdapted() getAdapted})</tt>
     * .
     * <p>
     * 
     * <tt>visitedClasses</tt> is the set of classes to which adaptation of
     * <tt>from</tt> has already been achieved. Paths leading this direction
     * therefore can be cut off, also avoiding endless recursions in case of
     * cyclic adapter definitions.
     * <p>
     * 
     * If no such adapter chain can be found, <tt>null</tt> is returned.
     */
    private List<TypeAdapter> getAdapterChain(SapClass from, SapClass to, Set<SapClass> visitedClasses) {
	List<TypeAdapter> result = null;
	if (from.equals(to)) {
	    result = new ArrayList<TypeAdapter>();
	} else {
	    visitedClasses.add(from);
	    Collection<TypeAdapter> candidates = from.getAdapters();
	    for (TypeAdapter candidate : candidates) {
		if (!visitedClasses.contains(candidate.getTo())) {
		    result = getAdapterChain(candidate.getTo(), to, visitedClasses);
		    if (result != null) {
			result.add(0, candidate);
			break;
		    }
		}
	    }
	}
	return result;
    }

}
