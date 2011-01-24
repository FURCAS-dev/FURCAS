package org.eclipse.ocl.examples.xtext.oclstdlib.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.utilities.NoEObjectCompositeEValidator;
 
public class OCLstdlibCompositeEValidator extends NoEObjectCompositeEValidator
{
	@Override
	public boolean validate(EObject csObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (csObject instanceof Pivotable) {
			EObject pivotObject = ((Pivotable)csObject).getPivot();
			if (pivotObject != null) {
				return super.validate(pivotObject, diagnostics, context);
			}
		}
		return super.validate(csObject, diagnostics, context);
	}

	@Override
	public boolean validate(EClass eClass, EObject csObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (csObject instanceof Pivotable) {
			EObject pivotObject = ((Pivotable)csObject).getPivot();
			if (pivotObject != null) {
				return super.validate(pivotObject.eClass(), pivotObject, diagnostics, context);
			}
		}
		return super.validate(eClass, csObject, diagnostics, context);
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return super.validate(eDataType, value, diagnostics, context);
	}
}
