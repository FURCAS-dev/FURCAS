package ocljmi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.eclipse.emf.common.util.EList;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.standard.types.OclAnyTypeImpl;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

/**
 * @author dha
 * 
 */
public class OclModelElementTypeImpl extends OclAnyTypeImpl implements OclModelElementType {
	private static final String REFLECT_ELEMENT_MOFID = "45ED2E29000DEAF733A545E62844AF3FC5E44767";

    public OclModelElementTypeImpl(com.sap.tc.moin.repository.mmi.model.Classifier impl, OclProcessor proc) {
		super(proc);
		this._impl = impl;
		List oper = super.getOperations();
		oper.add(proc.getBridgeFactory().buildOperation(proc.getTypeFactory().buildBooleanType(), "=", new Classifier[] { this }));
		oper.add(proc.getBridgeFactory().buildOperation(proc.getTypeFactory().buildBooleanType(), "<>", new Classifier[] { this }));
		List oclAnyOper = proc.getTypeFactory().buildOclAnyType().getOperations();
		oper.addAll(oclAnyOper);
	}

	com.sap.tc.moin.repository.mmi.model.Classifier _impl;

	public com.sap.tc.moin.repository.mmi.model.Classifier getImplementation() {
		return this._impl;
	}

	Map _properties = new HashMap();

	@Override
	public Property lookupProperty(String name) {
		Property prop = (Property) this._properties.get(name);
		if (prop == null) {
			if (this._impl instanceof MofClass) {
				// String emf_name = Ocl4Emf.adaptor.getGetterName(name);
				// getEStructuralFeature uses names from the model.
				//this._impl.refGetValue(name)
				StructuralFeature sf = getStructuralFeature(name);
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
			} else if (this._impl instanceof EnumerationType) {
			} else if (this._impl instanceof PrimitiveType) {
			}
		}
		// if still not found check for property in 'Classifier' for superclasses of _impl
		if (prop == null) {
			if (this._impl instanceof MofClass) {
				List l = ((MofClass) this._impl).getSupertypes();
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
			if (this._impl instanceof MofClass) {
				MofClass impCls = (MofClass) this._impl;
				if (o == null) {
					
					List operationsList = new ArrayList();
					Iterator operationsIterator=impCls.getContents().iterator();
					Object operationObject;
					while (operationsIterator.hasNext()){
						operationObject=operationsIterator.next();
						if (operationObject instanceof com.sap.tc.moin.repository.mmi.model.Operation){
							operationsList.add(operationObject);}
					}
					Iterator i = operationsList.iterator();
					//Iterator i = impCls.getEAllOperations().iterator();
					while (i.hasNext()) {
						com.sap.tc.moin.repository.mmi.model.Operation op = (com.sap.tc.moin.repository.mmi.model.Operation) i.next();
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
			if (this._impl instanceof MofClass) {
				List l = ((MofClass) this._impl).getSupertypes();
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
			ModelElement mofPackage=this._impl.getContainer();
			while (!(mofPackage.getContainer() instanceof MofPackage))
			{
				mofPackage=mofPackage.getContainer();
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
		if (this._impl instanceof MofClass) {
			if (c instanceof OclModelElementTypeImpl) {
				com.sap.tc.moin.repository.mmi.model.Classifier cc = ((OclModelElementTypeImpl) c)._impl;
				MofClass self = (MofClass) this._impl;
				return new Boolean(cc.equals(self) || self.allSupertypes().contains(cc) ||
				        cc.refMofId().equals(REFLECT_ELEMENT_MOFID));
			}
		} else if (this._impl instanceof EnumerationType) {
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
	 private StructuralFeature getStructuralFeature(String name){
		List sfList = ((MofClass) this._impl).getContents();
		Iterator i = sfList.iterator();
		Object obj;
		while (i.hasNext()) {
			obj = i.next();
			if (obj instanceof StructuralFeature) {
				if (((StructuralFeature) obj).getName().equals(name)) {
					return (StructuralFeature) obj;
				}
			}
		}
		return null;
	}

}
