/*
 * Created on 02-Jun-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.oslo.ocl20.bridge4emf;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Property;

/**
 * @author dha To change the template for this generated type comment go to
 *         Window>Preferences>Java>Code Generation>Code and Comments
 */
public class EnumerationImpl extends org.oslo.ocl20.semantics.bridge.impl.EnumerationImpl implements Enumeration {

	protected EEnum _eenum;

	public EnumerationImpl(EEnum eenum, OclProcessor proc) {
		this._eenum = eenum;
		this.processor = proc;

		super.createOperations(this.processor.getTypeFactory());
		super.getOperations().add(
		    proc.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "=",
		        new Classifier[] { this }));
		super.getOperations().add(
		    proc.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "<>",
		        new Classifier[] { this }));
	}

	/** Get name */
	String name = null;

	@Override
	public String getName() {
		if (this._eenum != null) {
			this.name = "";
			EPackage pkg = this._eenum.getEPackage();
			while (pkg != null) {
				if (!this.name.equals("")) {
					this.name = "." + this.name;
				}
				this.name = pkg.getName() + this.name;
				pkg = pkg.getESuperPackage();
			}
			if (!this.name.equals("")) {
				this.name += ".";
			}
			this.name += this._eenum.getName();
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
		EEnumLiteral e = this._eenum.getEEnumLiteral(name);
		if (e == null) {
			return null; // do not create invalid literal
		}
		return ((EmfBridgeFactory) super.processor.getBridgeFactory()).buildEnumLiteral(e, this);
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
		if (this._eenum != null) {
			if (super.getLiteral().size() == 0) {
				Iterator i = this._eenum.getELiterals().iterator();
				while (i.hasNext()) {
					EEnumLiteral lit = (EEnumLiteral) i.next();
					super.getLiteral().add(
					    ((EmfBridgeFactory) super.processor.getBridgeFactory()).buildEnumLiteral(lit, this));
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
		return this._eenum.getName();
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
		if (this._eenum.getInstanceClass() != null) {
			return this._eenum.getInstanceClass();
		}
		return this._eenum;
	}
}
