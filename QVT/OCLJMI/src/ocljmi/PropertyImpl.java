package ocljmi;



import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Property;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;


/**
 * @author dha
 *
 */
public class PropertyImpl extends org.oslo.ocl20.semantics.bridge.impl.PropertyImpl implements Property {

	StructuralFeature _impl;
	OclProcessor processor;

	/**
	 * Constructor for Property$Impl.
	 */
	public PropertyImpl(StructuralFeature sf, OclProcessor proc) {
		_impl = sf;
		this.processor = proc;
	}

	/**
	 * @see ocl20.bridge.Property#getType()
	 */
	Classifier _type=null;
	public Classifier getType() {
		if (_type == null) {
			//????????????????????????????????????
			com.sap.tc.moin.repository.mmi.model.Classifier moftype = _impl.getType();
			Classifier type = this.processor.getBridgeFactory().buildClassifier(moftype);
			if (_impl.getMultiplicity().getUpper() > 1 || _impl.getMultiplicity().getUpper() == -1) {
				if (_impl.getMultiplicity().isUnique()) {
					_type = this.processor.getTypeFactory().buildOrderedSetType(type);
				} else {
					_type = this.processor.getTypeFactory().buildSequenceType(type);
				}
			} else {
				_type = type;
			}
		}
		return _type; 
	}

	/**
	 * @see ocl20.bridge.Property#setType(Classifier)
	 */
	public void setType(Classifier type) {
		_type = type;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		return new PropertyImpl(_impl, this.processor);
	}

	/**
	 * @see ocl20.bridge.ModelElement#getName()
	 */
	private String _name;
	public String getName() {
		if (_impl != null)
			return _impl.getName();
		else
			return _name;
	}

	/**
	 * @see ocl20.bridge.ModelElement#setName(String)
	 */
	public void setName(String name) {
		_name = name;
	}

	/**
	 * @see ocl20.ocl20Visitable#accept(ocl20Visitor, Object)
	 */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}

	public Object getDelegate() {
		return _impl;
	}

	public String toString() {
	    return getName();
	}
	
}
