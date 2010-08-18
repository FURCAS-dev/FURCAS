package ocljmi;


import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Property;

/**
 * @author dha
 * 
 * To change the template for this generated type comment go to Window>Preferences>Java>Code Generation>Code and Comments
 */
public class EnumerationImpl extends org.oslo.ocl20.semantics.bridge.impl.EnumerationImpl implements Enumeration {

	protected EEnum _mofenum;

	public EnumerationImpl(EEnum mofenum, OclProcessor proc) {
		this._mofenum = mofenum;
		this.processor = proc;

		super.createOperations(this.processor.getTypeFactory());
		super.getOperations().add(proc.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "=", new Classifier[] { this }));
		super.getOperations().add(proc.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "<>", new Classifier[] { this }));
	}

	/** Get name */
	String name = null;

	@Override
	public String getName() {
		if (this._mofenum != null) {
			this.name = "";
			EPackage pkg = (EPackage) this._mofenum.eContainer();
			while (pkg != null) {
				if (!this.name.equals("")) {
					this.name = "." + this.name;
				}
				this.name = pkg.getName() + this.name;
				pkg = (EPackage) pkg.eContainer();
			}
			if (!this.name.equals("")) {
				this.name += ".";
			}
			this.name += this._mofenum.getName();
		}
		return this.name;
	}

	/** Check if this (an Enumeration) conforms with t2 */
	@Override
	public Boolean conformsTo(Classifier t2) {
		if (t2 instanceof Enumeration) {
			return this.getName().equals(t2.getName()) ? Boolean.TRUE : Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

	/** Search for an Enumeration Literal with a given name */
	@Override
	public EnumLiteral lookupEnumLiteral(String name) {
		List<String> e = this._mofenum.getLabels();
		for (String string : e) {
			if (string.equals(name)) {
				return ((JmiBridgeFactory) super.processor.getBridgeFactory())
						.buildEnumLiteral(string, this);
			}
		}
		return null;
	}

	/** Search for an Enumeration Literal with a given name */
	@Override
	public Property lookupProperty(String name) {
		return this.lookupEnumLiteral(name);
	}

	/** Search for an owned element */
	@Override
	public ModelElement lookupOwnedElement(String name) {
		return this.lookupEnumLiteral(name);
	}

	/** Get Enumeration Literals */
	// List literals = null;
	@Override
	public EList getLiteral() {
		if (this._mofenum != null) {
			if (super.getLiteral().size() == 0) {
				Iterator i = this._mofenum.getLabels().iterator();
				while (i.hasNext()) {
					String lit = (String) i.next();
					super.getLiteral().add(((JmiBridgeFactory) super.processor.getBridgeFactory()).buildEnumLiteral(lit, this));
				}

			}
		}
		return super.getLiteral();
	}

	/** Set Enumeration Literals */
	public void setLiteral(List literals) {
	}

	/** Accept a Sematics Visitor */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	@Override
	public String toString() {
		return this._mofenum.getName();
	}

	/** Equals */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Enumeration) {
			Enumeration enumerationType = (Enumeration) o;
			return this.getName().equals(enumerationType.getName());
		}
		return false;
	}

	@Override
	public Object getDelegate() {
//		if (this._mofenum.getInstanceClass() != null) {
//			return this._mofenum.getInstanceClass();
//		}
		return this._mofenum;
	}
}
