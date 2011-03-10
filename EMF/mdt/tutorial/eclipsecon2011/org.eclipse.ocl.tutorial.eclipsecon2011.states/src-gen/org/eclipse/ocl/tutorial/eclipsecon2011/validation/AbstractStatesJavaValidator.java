package org.eclipse.ocl.tutorial.eclipsecon2011.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractStatesJavaValidator extends AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage.eINSTANCE);
		return result;
	}

}
