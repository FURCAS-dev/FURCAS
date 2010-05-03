package org.eclipse.ocl.examples.xtext.oclstdlib.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractOCLstdlibJavaValidator extends AbstractDeclarativeValidator {

    @Override
    protected List<EPackage> getEPackages() {
        List<EPackage> result = new ArrayList<EPackage>();
        return result;
    }

}
