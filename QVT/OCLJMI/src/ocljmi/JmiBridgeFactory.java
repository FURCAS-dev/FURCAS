package ocljmi;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.PrimitiveType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Parameter;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.factories.BridgeFactoryImpl;


/**
 * @author dha
 * 
 */
public class JmiBridgeFactory extends BridgeFactoryImpl {

	private final ResourceSet connection;

	public JmiBridgeFactory(OclProcessor proc, ResourceSet conn) {
		super(proc);
		this.connection = conn;
	}

	public Environment buildEnvironment(EPackage mofPkg) {
		Namespace ns = new NamespaceImpl(mofPkg, super.processor);
		Environment env = super.buildEnvironment();
		return env.addNamespace(ns);
	}

	public Namespace buildNamespace(EPackage mofPkg) {
		return new NamespaceImpl(mofPkg, super.processor);
	}

	public Operation buildOperation(Classifier ret, String op_name, Classifier params[]) {
		Operation oper = new OperationImpl(null, super.processor);
		oper.setName(op_name);
		oper.setReturnType(ret);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				Classifier paramType = params[i];
				Parameter parameter = BridgeFactory.eINSTANCE.createParameter();
				parameter.setType(paramType);
				parameter.setName("arg" + i);
				oper.getOwnedParameter().add(parameter);
			}
		}
		return oper;
	}

	Map _properties = new HashMap();

	public Property buildProperty(EStructuralFeature sf) {
		Property p = (Property) this._properties.get(sf);
		if (p == null) {
			p = new PropertyImpl(sf, super.processor);
			this._properties.put(sf, p);
		}
		return p;
	}

	public Property buildProperty(Classifier ret, String name) {
		Property prop = new PropertyImpl(null, super.processor);
		prop.setName(name);
		prop.setType(ret);
		return prop;
	}

	public Classifier buildClassifier(EClassifier cls) {
		return (Classifier) this.buildModelElement(cls);
	}

	public ModelElement buildModelElement(Object o) {
		if (o instanceof EClass) {
			return this.buildOclModelElementType((EClass) o);
		} else if (o instanceof EEnum) {
			return this.buildEnumeration_((EEnum) o);
		} else if (o instanceof EDataType) {
			EDataType dt = (EDataType) o;
			//Class c = dt.getInstanceClass();
			//Class c = dt.getInstanceClass();
			if (dt.getName().equals("String")) {
				return super.processor.getTypeFactory().buildStringType();
			} else if (dt.getName().equals("Integer")) {
				return super.processor.getTypeFactory().buildIntegerType();
			} else if (dt.getName().equals("Long")) {
				return super.processor.getTypeFactory().buildIntegerType();
			} else if (dt.getName().equals("Boolean")) {
				return super.processor.getTypeFactory().buildBooleanType();
			} else if (dt.getName().equals("Float")) {
				return super.processor.getTypeFactory().buildRealType();
			} else if (dt.getName().equals("Double")) {
				return super.processor.getTypeFactory().buildRealType();
			} else {
				return this.buildOclModelElementType(dt);
			}
		}
		return null;
	}

	Map _modelElementTypes = new HashMap();

	public void resetModelElementType() {
		this._modelElementTypes.clear();
	}

	public OclModelElementType buildOclModelElementType(EClassifier ecls) {
		OclModelElementType t = (OclModelElementType) this._modelElementTypes.get(ecls);
		if (t == null) {
			t = new OclModelElementTypeImpl(ecls, super.processor);
			this._modelElementTypes.put(ecls, t);
		}
		return t;
	}

	public Enumeration buildEnumeration_(EEnum mofenum) {
		return new EnumerationImpl(mofenum, super.processor);
	}

	public EnumLiteral buildEnumLiteral(String mofenumLit, Enumeration enumerationType) {
		List<EEnum> enumLit = connection.getJmiHelper().getEnumerationConstants((EEnum) enumerationType.getDelegate());
		for (EEnum refEnum : enumLit) {
			if(refEnum.toString().equals(mofenumLit)) {
				return new EnumLiteralImpl(mofenumLit, enumerationType, this.getProcessor().getStdLibAdapter());
			}
		}
		return null;
	}

	public OclModelElementType buildOclModelElementType(Object o) {
		if (o instanceof EClass) {
			return this.buildOclModelElementType((EClass) o);
		} else {
			return null;
		}
	}

	public Enumeration buildEnumeration(Object o) {
		if (o instanceof EEnum) {
			return this.buildEnumeration(o);
		} else {
			return null;
		}
	}

	public EnumLiteral buildEnumLiteral(Object o) {
		if (o instanceof String) {
			return this.buildEnumLiteral(o);
		} else {
			return null;
		}
	}

	public Classifier buildClassifier(Object o) {
		if (o instanceof EClassifier) {
			return this.buildClassifier((EClassifier) o);
		} else {
			return null;
		}
	}

	public Namespace buildNamespace(Object o) {
		if (o instanceof EPackage) {
			return this.buildNamespace((EPackage) o);
		} else {
			return null;
		}
	}

	public Property buildProperty(Object o) {
		if (o instanceof EStructuralFeature) {
			return this.buildProperty((EStructuralFeature) o);
		} else {
			return null;
		}
	}

}
