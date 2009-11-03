package ocljmi;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;

/**
 * @author dha
 * 
 */
public class JmiBridgeFactory extends BridgeFactoryImpl {

	private final Connection connection;

	public JmiBridgeFactory(OclProcessor proc, Connection conn) {
		super(proc);
		this.connection = conn;
	}

	public Environment buildEnvironment(MofPackage mofPkg) {
		Namespace ns = new NamespaceImpl(mofPkg, super.processor);
		Environment env = super.buildEnvironment();
		return env.addNamespace(ns);
	}

	public Namespace buildNamespace(MofPackage mofPkg) {
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

	public Property buildProperty(StructuralFeature sf) {
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

	public Classifier buildClassifier(com.sap.tc.moin.repository.mmi.model.Classifier cls) {
		return (Classifier) this.buildModelElement(cls);
	}

	public ModelElement buildModelElement(Object o) {
		if (o instanceof MofClass) {
			return this.buildOclModelElementType((MofClass) o);
		} else if (o instanceof EnumerationType) {
			return this.buildEnumeration_((EnumerationType) o);
		} else if (o instanceof PrimitiveType) {
			PrimitiveType dt = (PrimitiveType) o;
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

	public OclModelElementType buildOclModelElementType(com.sap.tc.moin.repository.mmi.model.Classifier ecls) {
		OclModelElementType t = (OclModelElementType) this._modelElementTypes.get(ecls);
		if (t == null) {
			t = new OclModelElementTypeImpl(ecls, super.processor);
			this._modelElementTypes.put(ecls, t);
		}
		return t;
	}

	public Enumeration buildEnumeration_(EnumerationType mofenum) {
		return new EnumerationImpl(mofenum, super.processor);
	}

	public EnumLiteral buildEnumLiteral(String mofenumLit, Enumeration enumerationType) {
		List<RefEnum> enumLit = connection.getJmiHelper().getEnumerationConstants((EnumerationType) enumerationType.getDelegate());
		for (RefEnum refEnum : enumLit) {
			if(refEnum.toString().equals(mofenumLit)) {
				return new EnumLiteralImpl(mofenumLit, enumerationType, this.getProcessor().getStdLibAdapter());
			}
		}
		return null;
	}

	public OclModelElementType buildOclModelElementType(Object o) {
		if (o instanceof MofClass) {
			return this.buildOclModelElementType((MofClass) o);
		} else {
			return null;
		}
	}

	public Enumeration buildEnumeration(Object o) {
		if (o instanceof EnumerationType) {
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
		if (o instanceof com.sap.tc.moin.repository.mmi.model.Classifier) {
			return this.buildClassifier((com.sap.tc.moin.repository.mmi.model.Classifier) o);
		} else {
			return null;
		}
	}

	public Namespace buildNamespace(Object o) {
		if (o instanceof MofPackage) {
			return this.buildNamespace((MofPackage) o);
		} else {
			return null;
		}
	}

	public Property buildProperty(Object o) {
		if (o instanceof StructuralFeature) {
			return this.buildProperty((StructuralFeature) o);
		} else {
			return null;
		}
	}

}
