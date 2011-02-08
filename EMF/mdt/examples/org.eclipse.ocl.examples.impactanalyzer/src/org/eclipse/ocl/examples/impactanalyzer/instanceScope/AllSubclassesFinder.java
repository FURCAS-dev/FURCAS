package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class AllSubclassesFinder {
    private static final Logger logger = Logger.getLogger(AllSubclassesFinder.class.getName());
    
    private final EPackage.Registry registry;
    private static AllSubclassesFinder instance;

    /**
     * remembers which packages from the {@link #registry} have already been
     * cached in {@link #oppositeCache}.
     */
    private Set<EPackage> cachedPackages;

    /**
     * Caches the subclasses of all classes held by the Ecore package registry
     */
    private Map<EClass, Set<EClass>> subclasses = new HashMap<EClass, Set<EClass>>();

    public static AllSubclassesFinder getInstance() {
        if (instance == null) {
            instance = new AllSubclassesFinder();
        }
        return instance;
    }

    protected AllSubclassesFinder() {
        this(EPackage.Registry.INSTANCE);
    }

    public AllSubclassesFinder(EPackage.Registry registry) {
        this.registry = registry;
        cachedPackages = new HashSet<EPackage>();
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
        updateOppositeCache();
        Collection<EClass> result = subclasses.get(c);
        if (result == null) {
            result = Collections.emptySet();
        } else {
            result = Collections.unmodifiableCollection(result);
        }
        return result;
    }

    private void updateOppositeCache() {
        Set<String> registryKeys = new HashSet<String>(registry.keySet()); // avoid concurrent modifications
        for (String packageUri : registryKeys) {
            try {
                EPackage ePackage = registry.getEPackage(packageUri);
                if (!cachedPackages.contains(ePackage)) {
                    cachedPackages.add(ePackage);
                    cachePackage(ePackage);
                }
            } catch (Exception e) {
                // TODO problem resolving the packageUri into an EPackage; could be
                // that the package class doesn't exist in generated form;
                // ignore those for now (although it should somehow be possible
                // to instantiate this package dynamically)
                logger.warning("couldn't resolve Ecore package with URI " + packageUri + ": " + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }
}
