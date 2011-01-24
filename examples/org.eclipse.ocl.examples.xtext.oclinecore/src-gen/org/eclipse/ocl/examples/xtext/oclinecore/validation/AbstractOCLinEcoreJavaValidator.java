package org.eclipse.ocl.examples.xtext.oclinecore.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractOCLinEcoreJavaValidator extends AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/BaseCST"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/EssentialOCLCST"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/OCLinEcoreCST"));
		return result;
	}

}
