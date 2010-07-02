package com.sap.ocl.oppositefinder.query2;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.emf.query2.QueryContext;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.ocl.oppositefinder.query2.internal.DefaultQueryContextProvider;

/**
 * Uses EMF query2 to reverse-navigate a reference that has no opposite. The search scope
 * is dynamically determined for the start object of the navigation, using a
 * {@link QueryContextProvider}. If none is specifically passed to the constructor,
 * a default one is used which searches in the {@link ResourceSet} of the object
 * where navigation starts. However, with this default the implementation should behave
 * roughly like the base class implementation, except that no {@link ECrossReferenceAdapter}
 * is required.
 *  
 * @author Axel Uhl (D043530)
 *
 */
public class Query2OppositeEndFinder implements OppositeEndFinder {
    /**
     * Used to obtain a query context for a given {@link EObject}.
     */
    private final QueryContextProvider queryContextProvider;
    
    private final OppositeEndFinder delegate;
    
    private static Query2OppositeEndFinder instance;
    
    public static Query2OppositeEndFinder getInstance() {
        if (instance == null) {
            instance = new Query2OppositeEndFinder();
        }
        return instance;
    }
    
    public Query2OppositeEndFinder() {
        this(new DefaultQueryContextProvider());
    }
    
    public Query2OppositeEndFinder(QueryContextProvider queryContextProvider) {
        this.queryContextProvider = queryContextProvider;
        delegate = DefaultOppositeEndFinder.getInstance();
    }
    
    @Override
    public Object navigateOppositeProperty(EStructuralFeature property, Object target)
            throws IllegalArgumentException {
        if (target instanceof EObject) {
            EObject etarget = (EObject) target;
            Collection<EObject> result = null;
            if (property instanceof EReference && ((EClass) ((EReference) property).getEType()).isSuperTypeOf(etarget.eClass())) {
                QueryContext queryContext = queryContextProvider.getQueryContext(etarget);
                ResourceSet rs = etarget.eResource().getResourceSet();
                if (rs == null) {
                    rs = new ResourceSetImpl();
                }
                result = EcoreHelper.getInstance().reverseNavigate(etarget, (EReference) property, queryContext, rs);
            }
            return result;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void findOppositeEnds(EClassifier classifier, String name, List<EStructuralFeature> ends) {
        delegate.findOppositeEnds(classifier, name, ends);
    }

    @Override
    public Map<String, EStructuralFeature> getAllOppositeEnds(EClassifier classifier) {
        return delegate.getAllOppositeEnds(classifier);
    }

}
