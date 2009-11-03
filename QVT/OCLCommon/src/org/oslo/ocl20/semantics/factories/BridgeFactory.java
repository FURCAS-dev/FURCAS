package org.oslo.ocl20.semantics.factories;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;

public interface BridgeFactory {
	/** Build a Property */
	Property buildProperty(Classifier ret, String op_name);

	/** Build an Operation */ 
	Operation buildOperation(Classifier ret, String op_name, Classifier params[]);

	/** Build a NamedElement */ 
	NamedElement buildNamedElement(String name, ModelElement referredElement, Boolean mayBeImplicit);

	/** Build an Environment */ 
	Environment buildEnvironment();
	
	OclModelElementType buildOclModelElementType(Object o);

	Enumeration buildEnumeration(Object o);

	EnumLiteral buildEnumLiteral(Object o);

	Classifier buildClassifier(Object o);
	
	ModelElement buildModelElement(Object o);

	Namespace buildNamespace(Object o);

	Property buildProperty(Object o);
	
	OclProcessor getProcessor();
}
