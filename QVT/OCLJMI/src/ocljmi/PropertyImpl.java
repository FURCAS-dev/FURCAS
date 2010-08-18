package ocljmi;



import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Property;


/**
 * @author dha
 *
 */
public class PropertyImpl extends org.oslo.ocl20.semantics.bridge.impl.PropertyImpl implements Property {

	EStructuralFeature _impl;
	OclProcessor processor;

	/**
	 * Constructor for Property$Impl.
	 */
	public PropertyImpl(EStructuralFeature sf, OclProcessor proc) {
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
			EClassifier moftype = _impl.getEType();
			Classifier type = this.processor.getBridgeFactory().buildClassifier(moftype);
			if (_impl.getUpperBound() > 1 || _impl.getUpperBound() == -1) {
				if (_impl.isUnique()) {
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
