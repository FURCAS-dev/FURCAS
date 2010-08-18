package ocljmi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.PrimitiveType;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.standard.types.OclAnyTypeImpl;

/**
 * @author dha
 * 
 */
public class OclModelElementTypeImpl extends OclAnyTypeImpl implements OclModelElementType {
	private static final String REFLECT_ELEMENT_MOFID = "45ED2E29000DEAF733A545E62844AF3FC5E44767";

    public OclModelElementTypeImpl(EClassifier impl, OclProcessor proc) {
		super(proc);
		this._impl = impl;
		List oper = super.getOperations();
		oper.add(proc.getBridgeFactory().buildOperation(proc.getTypeFactory().buildBooleanType(), "=", new Classifier[] { this }));
		oper.add(proc.getBridgeFactory().buildOperation(proc.getTypeFactory().buildBooleanType(), "<>", new Classifier[] { this }));
		List oclAnyOper = proc.getTypeFactory().buildOclAnyType().getOperations();
		oper.addAll(oclAnyOper);
	}

	EClassifier _impl;

	public EClassifier getImplementation() {
		return this._impl;
	}

	Map _properties = new HashMap();

	@Override
	public Property lookupProperty(String name) {
		Property prop = (Property) this._properties.get(name);
		if (prop == null) {
			if (this._impl instanceof EClass) {
				// String emf_name = Ocl4Emf.adaptor.getGetterName(name);
				// getEStructuralFeature uses names from the model.
				//this._impl.refGetValue(name)
				EStructuralFeature sf = getStructuralFeature(name);
				if (sf == null && name.startsWith("_")) {
					sf = getStructuralFeature(name.substring(1));
				}
				if (sf == null) {
					String n2 = name.substring(0, 1).toUpperCase() + name.substring(1);
					sf = getStructuralFeature(n2);
				}
				if (sf != null) {
					prop = super.processor.getBridgeFactory().buildProperty(sf);
					this._properties.put(name, prop);
				}
			} else if (this._impl instanceof EEnum) {
			} else if (this._impl instanceof PrimitiveType) {
			}
		}
		// if still not found check for property in 'Classifier' for superclasses of _impl
		if (prop == null) {
			if (this._impl instanceof EClass) {
				List l = ((EClass) this._impl).getESuperTypes();
				Iterator i = l.iterator();
				while (i.hasNext()) {
					Classifier spCls = this.processor.getBridgeFactory().buildClassifier(i.next());
					prop = spCls.lookupProperty(name);
					if (prop != null) {
						this._properties.put(name, prop);
						break;
					}
				}
			}
		}
		return prop;
	}

	@Override
	public EList getProperties() {
		if (super.getProperties().size() == 0) {
			super.getProperties().addAll(this._properties.values());
		}
		return super.getProperties();
	}

	@Override
	public void addProperty(Property p) {
		this._properties.put(p.getName(), p);
	}

	/*
	 * class P{ public P(String name, List types) { this.name=name; this.types=types; } String name; List types; public int hashCode() { return name.hashCode();//*types.hashCode(); }
	 * public boolean equals(Object o) { if (!(o instanceof P)) return false; P p = (P)o; return ( name.equals(p.name) //&& types.equals(p.types) ); } } Map _operations = new
	 * HashMap();
	 */
	@Override
	public Operation lookupOperation(String name, List types) {
		Operation o = super.lookupOperation(name, types);
		// if (o==null) {
		// o = (Operation)_operations.get( new P(name,types) );
		if (o == null) {
			if (this._impl instanceof EClass) {
				EClass impCls = (EClass) this._impl;
				if (o == null) {
					
					List operationsList = new ArrayList();
					Iterator operationsIterator=impCls.eAllContents();
					Object operationObject;
					while (operationsIterator.hasNext()){
						operationObject=operationsIterator.next();
						if (operationObject instanceof EOperation){
							operationsList.add(operationObject);}
					}
					Iterator i = operationsList.iterator();
					//Iterator i = impCls.getEAllOperations().iterator();
					while (i.hasNext()) {
						EOperation op = (EOperation) i.next();
						if (op.getName().equals(name)) {
							o = new OperationImpl(op, super.processor);
							break;
						}

					}
				}
			}
		}
		// if still not found check for operation in 'Classifier' for superclasses of _impl
		if (o == null) {
			if (this._impl instanceof EClass) {
				List l = ((EClass) this._impl).getESuperTypes();
				Iterator i = l.iterator();
				while (i.hasNext()) {
					Classifier spCls = this.processor.getBridgeFactory().buildClassifier(i.next());
					o = spCls.lookupOperation(name, types);
					if (o != null) {
						break;
					}
				}
			}
		}
		// }
		// if (o!=null)
		// super.addOperation(o);
		return o;
	}

	/*
	 * public List getOperation() { return new Vector(_operations.values()); }
	 * 
	 * public void addOperation(Operation o) { _operations.put(new P(o.getName(),o.getParameterTypes()), o); }
	 */

	@Override
	public String getName() {
		return this._impl.getName();
	}

	@Override
	public Namespace getNamespace() {
		Namespace ns = super.getNamespace();
		if (ns == null) {
			EObject mofPackage=this._impl.eContainer();
			while (!(mofPackage.eContainer() instanceof EPackage))
			{
				mofPackage=mofPackage.eContainer();
			}
			ns = this.processor.getBridgeFactory().buildNamespace(mofPackage);
			
			//ns = this.processor.getBridgeFactory().buildNamespace(this._impl.getEPackage());
			
			super.setNamespace(ns);
		}
		return ns;
	}

	@Override
	public Boolean conformsTo(Classifier c) {
		if (c.equals(this.processor.getTypeFactory().buildOclAnyType())) {
			return Boolean.TRUE;
		}
		if (this._impl instanceof EClass) {
			if (c instanceof OclModelElementTypeImpl) {
				EClassifier cc = ((OclModelElementTypeImpl) c)._impl;
				EClass self = (EClass) this._impl;
				return new Boolean(cc.equals(self) || self.getESuperTypes().contains(cc) ||
				        cc.refMofId().equals(REFLECT_ELEMENT_MOFID));
			}
		} else if (this._impl instanceof EEnum) {
		} else if (this._impl instanceof PrimitiveType) {
		}
		return Boolean.FALSE;
	}

	@Override
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	@Override
	public String toString() {
		return this._impl.getName();
	}

	@Override
	public Object getDelegate() {
//		if (this._impl.getInstanceClass() != null) {
//			return this._impl.getInstanceClass();
//		}
		return this._impl;
	}
	 private EStructuralFeature getStructuralFeature(String name){
		List sfList = ((EClass) this._impl).eContents();
		Iterator i = sfList.iterator();
		Object obj;
		while (i.hasNext()) {
			obj = i.next();
			if (obj instanceof EStructuralFeature) {
				if (((EStructuralFeature) obj).getName().equals(name)) {
					return (EStructuralFeature) obj;
				}
			}
		}
		return null;
	}

}
