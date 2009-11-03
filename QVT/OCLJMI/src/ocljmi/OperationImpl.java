package ocljmi;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Parameter;

/**
 * @author dha
 * 
 */
public class OperationImpl extends org.oslo.ocl20.semantics.bridge.impl.OperationImpl implements Operation {

	com.sap.tc.moin.repository.mmi.model.Operation _impl;

	OclProcessor processor;

	/**
	 * Constructor for Operation$Impl.
	 */
	public OperationImpl(com.sap.tc.moin.repository.mmi.model.Operation op, OclProcessor proc) {
		this._impl = op;
		this.processor = proc;
	}

	// --- Operation ---
	/**
	 * @see ocl20.bridge.Operation#getRetrunType()
	 */
	Classifier _returnType = null;

	public Classifier getReturnType() {
		if (this._impl == null) {
			return this._returnType;
			
		}
		// return this.processor.getBridgeFactory().buildClassifier(_impl.getEType());
		Classifier _type;


		Iterator operationsIterator= this._impl.getContents().iterator();
		Object operationObject;
		com.sap.tc.moin.repository.mmi.model.Parameter mofParam=null;
		while (operationsIterator.hasNext()){
			operationObject=operationsIterator.next();
			if (operationObject instanceof com.sap.tc.moin.repository.mmi.model.Parameter){
				mofParam=(com.sap.tc.moin.repository.mmi.model.Parameter) operationObject;
				break;
				}
		}
		//????????
		
		//com.sap.tc.moin.repository.mmi.model.Classifier moftype = this._impl.getEType();
		
		Classifier type = this.processor.getBridgeFactory().buildClassifier(mofParam.getType());
		if (mofParam.getMultiplicity().getUpper() > 1) {
			if (mofParam.getMultiplicity().isUnique()) {
				_type = this.processor.getTypeFactory().buildOrderedSetType(type);
			} else {
				_type = this.processor.getTypeFactory().buildSequenceType(type);
			}
		} else {
			_type = type;
		}
		return _type;
	}

	public void setReturnType(Classifier cl) {
		this._returnType = cl;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return null;
	}

	/**
	 * @see ocl20.bridge.ModelElement#getName()
	 */
	String _name = null;

	public String getName() {
		if (this._impl == null) {
			return this._name;
		}
		return this._impl.getName();
	}

	/**
	 * @see ocl20.bridge.ModelElement#setName(String)
	 */
	public void setName(String name) {
		this._name = name;
	}

	/**
	 * @see ocl20.ocl20Visitable#accept(ocl20Visitor, Object)
	 */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	public Object getDelegate() {
		return this._impl;
	}

	public String toString() {
		String s = "";
		s += this.getName() + "(";
		Iterator i = this.getOwnedParameter().iterator();
		while (i.hasNext()) {
			Parameter parameter = (Parameter) i.next();
			Classifier c = parameter.getType();
			s += c.getName();
			if (i.hasNext()) {
				s += ", ";
			}
		}
		s += ")";
		return s;
	}

	List _ownedParameters = null;

	public EList getOwnedParameter() {
		if (this._ownedParameters == null) {
			this._ownedParameters = new ArrayList();
			if (this._impl != null) {
				

				
				List parametersList=new ArrayList();
				Iterator j = this._impl.getContents().iterator();
				Object obj;
				while(j.hasNext()){
					obj=j.next();
					if (obj instanceof Parameter){
						parametersList.add(obj);
					}
				}
				Iterator i = parametersList.iterator();
				while (i.hasNext()) {
					com.sap.tc.moin.repository.mmi.model.Parameter p = (com.sap.tc.moin.repository.mmi.model.Parameter) i.next();
					// TODO use Bridge factory to build parameters
					Parameter parameter = BridgeFactory.eINSTANCE.createParameter();
					parameter.setType(this.processor.getBridgeFactory().buildClassifier(p.getType()));
					parameter.setName(p.getName());
					this._ownedParameters.add(parameter);
				}
			}
			super.getOwnedParameter().addAll(this._ownedParameters);
		}
		return super.getOwnedParameter();
	}

}
