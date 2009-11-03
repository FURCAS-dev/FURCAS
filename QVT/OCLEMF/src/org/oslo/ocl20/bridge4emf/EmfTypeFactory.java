package org.oslo.ocl20.bridge4emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.standard.types.TypeFactoryImpl;

/**
 * @author dha
 */
public class EmfTypeFactory extends TypeFactoryImpl {
	/** Construct an Enumeration */
	public EmfTypeFactory(OclProcessor proc) {
		super(proc);
	}

	public Classifier buildClassifier(EClass ecl) {
		// EList ? -- see PropertyImpl, fix here.
		if (ecl instanceof EClass)
			return buildOclModelElementType(ecl);
		else if (ecl instanceof EEnum)
			return null;
		else if (ecl instanceof EDataType)
			return null;
		return null;
	}

	public OclModelElementType buildOclModelElementType(EClass ecl) {
		return new OclModelElementTypeImpl(ecl, processor);
	}

}
