package ocljmi;


//import org.eclipse.emf.ecore.EEnumLiteral;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.standard.lib.OclEnumerationImpl;
import org.oslo.ocl20.standard.lib.StdLibAdapter;


public class EnumLiteralImpl extends org.oslo.ocl20.semantics.bridge.impl.EnumLiteralImpl implements EnumLiteral {

	protected String _mofenumLit;
	private StdLibAdapter stdLibAdapter;
	public EnumLiteralImpl(String mofenumLit, Enumeration parent, StdLibAdapter adapter) {
		stdLibAdapter=adapter;
		_mofenumLit = mofenumLit;
		_enum=parent;
	}

	Enumeration _enum=null;
	public Enumeration getEnumeration() {
		return _enum;
	}

	public void setEnumeration(Enumeration enumerationType) {
		_enum = enumerationType;
	}

	String _name = null;
	public String getName() {
		if (_name == null) _name = _mofenumLit;
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	/**
	 * @see ocl20.bridge.Property#getType()
	 */
	Classifier type = null;
	public Classifier getType() {
		return getEnumeration(); 
	}

	/**
	 * @see ocl20.bridge.Property#setType(Classifier)
	 */
	public void setType(Classifier type) {
	}
	
	public Object accept(SemanticsVisitor v, Object data) {
		return  v.visit(this, data);
	}

	public Object clone() {
		return this;
	}
	public Object getDelegate() {
		return _mofenumLit;//.getEEnum().getEPackage().getEFactoryInstance().createFromString(_eenumLit.getEEnum(), _eenumLit.getName());
	}

    public Object getInstance() {
    	return new OclEnumerationImpl(getEnumeration(), getEnumeration().lookupEnumLiteral(_mofenumLit).getDelegate(), stdLibAdapter);
    }
}
