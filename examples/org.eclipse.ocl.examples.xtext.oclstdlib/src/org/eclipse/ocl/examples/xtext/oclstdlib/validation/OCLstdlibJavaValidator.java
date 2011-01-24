package org.eclipse.ocl.examples.xtext.oclstdlib.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;
 

public class OCLstdlibJavaValidator extends AbstractOCLstdlibJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
//		}
//	}

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(BaseCSTPackage.eINSTANCE);
	    result.add(OCLstdlibCSTPackage.eINSTANCE);
		return result;
	}


/*	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return super.validate(eDataType, value, diagnostics, context);
	}


	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (eObject instanceof ModelElementCS) {
			ModelElementCS csElement = (ModelElementCS) eObject;
			EObject pivotObject = csElement.getOriginalObject();
			if (pivotObject == null) {
				recreatePivot(csElement.eResource());
			}
			return super.validate(pivotObject, diagnostics, context);
		}
		else {
			return super.validate(eObject, diagnostics, context);
		}
	}


	private void recreatePivot(Resource eResource) {
		// TODO Auto-generated method stub
		
	} &
	*/

}
