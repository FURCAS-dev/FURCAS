package org.oslo.ocl20.bridge4emf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Parameter;

/**
 * @author dha
 */
public class OperationImpl extends org.oslo.ocl20.semantics.bridge.impl.OperationImpl implements Operation {

	EOperation _impl;

	OclProcessor processor;

	/**
	 * Constructor for Operation$Impl.
	 */
	public OperationImpl(EOperation op, OclProcessor proc) {
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
		EClassifier etype = this._impl.getEType();
		Classifier type = this.processor.getBridgeFactory().buildClassifier(etype);
		if (this._impl.isMany()) {
			if (this._impl.isUnique()) {
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
				Iterator i = this._impl.getEParameters().iterator();
				while (i.hasNext()) {
					EParameter p = (EParameter) i.next();
					// TODO use Bridge factory to build parameters
					Parameter parameter = BridgeFactory.eINSTANCE.createParameter();
					parameter.setType(this.processor.getBridgeFactory().buildClassifier(p.getEType()));
					parameter.setName(p.getName());
					this._ownedParameters.add(parameter);
				}
			}
			super.getOwnedParameter().addAll(this._ownedParameters);
		}
		return super.getOwnedParameter();
	}

}
