package com.sap.emf.ocl.hiddenopposites;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.TypedElement;

public class OCLUtilWithHiddenOpposites {
    @SuppressWarnings("unchecked")
    public static <T> T getAdapter(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env, Class<T> adapterType) {

	T result = OCLUtil.getAdapter(env, adapterType);
	if (result == null) {
	    if (adapterType == EcoreEnvironmentWithHiddenOpposites.Lookup.class) {
		final EcoreEnvironmentWithHiddenOpposites _env = (EcoreEnvironmentWithHiddenOpposites) env;

		result = (T) new EcoreEnvironmentWithHiddenOpposites.Lookup() {
		    public EPackage tryLookupPackage(List<String> names) throws LookupException {
			return _env.lookupPackage(names);
		    }

		    public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
			return _env.lookupClassifier(names);
		    }

		    public EOperation tryLookupOperation(EClassifier owner, String name,
			    List<? extends TypedElement<EClassifier>> args) throws LookupException {
			return _env.lookupOperation(owner, name, args);
		    }

		    public EStructuralFeature tryLookupProperty(EClassifier owner, String name) throws LookupException {
			return _env.lookupProperty(owner, name);
		    }

		    public EClassifier tryLookupAssociationClassReference(EClassifier owner, String name) throws LookupException {
			return _env.lookupAssociationClassReference(owner, name);
		    }

		    public EClassifier tryLookupSignal(EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args)
			    throws LookupException {
			return _env.lookupSignal(owner, name, args);
		    }

                    public EReference tryLookupOppositeProperty(EClassifier owner, String name) throws LookupException {
	                return _env.lookupOppositeProperty(owner, name);
                    }
		};
	    }
	}

	return result;
    }

}
