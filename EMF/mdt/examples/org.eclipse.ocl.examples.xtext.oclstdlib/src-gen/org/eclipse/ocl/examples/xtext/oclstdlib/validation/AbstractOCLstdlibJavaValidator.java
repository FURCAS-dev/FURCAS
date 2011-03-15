package org.eclipse.ocl.examples.xtext.oclstdlib.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.validation.EssentialOCLJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractOCLstdlibJavaValidator extends EssentialOCLJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/OCLstdlibCST"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/BaseCST"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/ocl/3.1.0/EssentialOCLCST"));
		return result;
	}

}
