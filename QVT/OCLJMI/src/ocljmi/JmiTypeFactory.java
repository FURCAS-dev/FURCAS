package ocljmi;



import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.standard.types.TypeFactoryImpl;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;


/**
 * @author dha
 *
 */
public class JmiTypeFactory
	extends TypeFactoryImpl
{
	/** Construct an Enumeration */
	public JmiTypeFactory(OclProcessor proc) {
		super(proc);
	}
	
	public Classifier buildClassifier(MofClass ecl) {
		//EList ? -- see PropertyImpl, fix here.
		if (ecl instanceof MofClass)
			return buildOclModelElementType(ecl);
		else if (ecl instanceof EnumerationType)
			return null;
		else if (ecl instanceof PrimitiveType)
			return null;
		return null;
	}
	
	public OclModelElementType buildOclModelElementType(MofClass ecl) {
		return new OclModelElementTypeImpl(ecl, processor);
	}

}
