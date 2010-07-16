package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * Uses an {@link EPackage.Registry} to maintain a cache of all subclass relationships of all
 * {@link EClass}es registered in packages in the registry.
 * 
 * @author Axel Uhl
 */
public class AllEClassSubclassesFinder {

    private final EPackage.Registry registry;

    /**
     * Caches the subclasses of all classes held by the Ecore package registry
     */
    private final Map<EClass, Set<EClass>> subclasses;

    /**
     * remembers which packages from the {@link #registry} have already been cached in {@link #oppositeCache}.
     */
    private final Set<EPackage> cachedPackages;
    
    private static AllEClassSubclassesFinder instance;

    public static AllEClassSubclassesFinder getInstance() {
        if (instance == null) {
            instance = new AllEClassSubclassesFinder();
        }
        return instance;
    }

    
    /**
     * Uses the default {@link EPackage.Registry#INSTANCE} package registry.
     */
    public AllEClassSubclassesFinder() {
	this(EPackage.Registry.INSTANCE);
    }

    /**
     * A non-default instance can be created with this constructor, using a specific non-default registry.
     * If you don't need this, please use {@link #getInstance()} to obtain a singleton instance to save the
     * memory required to maintain the cache.
     */
    public AllEClassSubclassesFinder(EPackage.Registry registry) {
	this.registry = registry;
	cachedPackages = new HashSet<EPackage>();
	subclasses = new HashMap<EClass, Set<EClass>>();
    }

    private void updateSubclassCache() {
	Set<String> registryKeys = new HashSet<String>(registry.keySet()); // avoid concurrent modifications
	for (String packageUri : registryKeys) {
	    EPackage ePackage = registry.getEPackage(packageUri);
	    if (!cachedPackages.contains(ePackage)) {
		cachedPackages.add(ePackage);
		cachePackage(ePackage);
	    }
	}
    }

    private void cachePackage(EPackage ePackage) {
	for (EClassifier c : ePackage.getEClassifiers()) {
	    if (c instanceof EClass) {
	        cacheSubclassRelations((EClass) c);
	    }
	}
    }

    private void cacheSubclassRelations(EClass c) {
        for (EClass sup : c.getESuperTypes()) {
            cacheSubclassForSuperclass(c, sup);
        }
    }

    private void cacheSubclassForSuperclass(EClass sub, EClass sup) {
        Set<EClass> subclassesOfSup = subclasses.get(sup);
        if (subclassesOfSup == null) {
            subclassesOfSup = new HashSet<EClass>();
            subclasses.put(sup, subclassesOfSup);
        }
        subclassesOfSup.add(sub);
        for (EClass supsup : sup.getESuperTypes()) {
            cacheSubclassForSuperclass(sub, supsup);
        }
    }

    public Collection<EClass> getAllSubclasses(EClass c) {
        updateSubclassCache();
        Collection<EClass> result = subclasses.get(c);
        if (result == null) {
            result = Collections.emptySet();
        } else {
            result = Collections.unmodifiableCollection(result);
        }
        return result;
    }

}
