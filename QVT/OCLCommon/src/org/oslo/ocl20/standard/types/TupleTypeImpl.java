package org.oslo.ocl20.standard.types;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.impl.ElementImpl;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.types.TupleType;
import org.oslo.ocl20.semantics.model.types.VoidType;
import org.oslo.ocl20.standard.lib.OclTuple;

/**
 * @author dha
 * 
 */
public class TupleTypeImpl extends org.oslo.ocl20.semantics.model.types.impl.TupleTypeImpl implements TupleType {
	/** Construct a TupleType */
	public TupleTypeImpl(OclProcessor proc) {
		super();
		this.setProcessor(proc);
		this.setName("TupleType");
	}

	public void createOperations(TypeFactory tf) {
		this.getOperations().add(super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "=", new Classifier[] { this }));
		this.getOperations().add(super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "<>", new Classifier[] { this }));
	}

	/** PartType field */
	// protected List partType = new Vector();
	// public List getPartType() {
	// return partType;
	// }
	// public void setPartType(List partType) {
	// this.partType = partType;
	// }
	public List getNames() {
		Vector v = new Vector();
		Iterator i = this.getPartType().iterator();
		while (i.hasNext()) {
			VariableDeclaration vd = (VariableDeclaration) i.next();
			v.add(vd.getName());
		}
		return v;
	}

	public List getTypes() {
		Vector v = new Vector();
		Iterator i = this.getPartType().iterator();
		while (i.hasNext()) {
			VariableDeclaration vd = (VariableDeclaration) i.next();
			v.add(vd.getType());
		}
		return v;
	}

	public TupleType project(Set nameSet) {
		List names = this.getNames();
		List types = this.getTypes();
		Iterator i = this.getPartType().iterator();
		while (i.hasNext()) {
			VariableDeclaration p = (VariableDeclaration) i.next();
			if (!nameSet.contains(p.getName())) {
				types.remove(names.indexOf(p.getName()));
				names.remove(p.getName());
			}
		}
		return this.processor.getTypeFactory().buildTupleType((String[]) names.toArray(new String[] {}), (Classifier[]) types.toArray(new Classifier[] {}));
	}

	public TupleType join(TupleType t2) {
		List names = new Vector(this.getNames());
		List types = new Vector(this.getTypes());
		names.addAll(t2.getNames());
		types.addAll(t2.getTypes());
		return this.processor.getTypeFactory().buildTupleType((String[]) names.toArray(new String[] {}), (Classifier[]) types.toArray(new Classifier[] {}));
	}

	public Property lookupProperty(String name) {
		Iterator i = this.getPartType().iterator();
		while (i.hasNext()) {
			VariableDeclaration p = (VariableDeclaration) i.next();
			if (p.getName().equals(name)) {
				return new PropertyPartImpl(p);
			}
		}
		return null;
	}

	class PropertyPartImpl extends ElementImpl implements Property {
		VariableDeclaration part;

		PropertyPartImpl(VariableDeclaration part) {
			this.part = part;
		}

		public Classifier getType() {
			return this.part.getType();
		}

		public void setType(Classifier type) {
		}

		public Object clone() {
			return null;
		}

		public Object accept(SemanticsVisitor v, Object obj) {
			return v.visit(this, obj);
		}

		public String getName() {
			return this.part.getName();
		}

		public void setName(String name) {
		}

		public Object getDelegate() {
			return this.part;
		}
	};

	/** Check if this (a Tuple) conforms with c */
	public Boolean conformsTo(Classifier t2) {
		// --- T2 is undefined ---
		if (t2 instanceof VoidType) {
			return Boolean.TRUE;
		}
		// --- T2 is tuple ---
		if (t2 instanceof TupleType) {
			// --- Get the internal lists ---
			List l1 = ((TupleType) this).getPartType();
			List l2 = ((TupleType) t2).getPartType();
			// --- Check size ---
			if (l1.size() != l2.size()) {
				return Boolean.FALSE;
			}
			// --- Check each element from list
			Iterator i1 = l1.iterator();
			while (i1.hasNext()) {
				// --- Get current element ---
				VariableDeclaration var1 = (VariableDeclaration) i1.next();
				VariableDeclaration var2 = this.getVar(var1.getName(), l2); // (VariableDeclaration)i2.next();
				// var2 is null if no var in l2 found with same name as var1
				if (var2 == null) {
					return Boolean.FALSE;
				}
				// --- Check type
				Classifier t11 = var1.getType();
				Classifier t21 = var2.getType();
				Boolean conforms = t11.conformsTo(t21);
				if (!conforms.booleanValue()) {
					return Boolean.TRUE;
				}
			}
			return Boolean.TRUE;
			// --- Check for parents ---
		} else {
			return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
		}
	}

	VariableDeclaration getVar(String name, List list) {
		VariableDeclaration res = null;
		Iterator i = list.iterator();
		while (i.hasNext()) {
			// --- Get current element ---
			VariableDeclaration var = (VariableDeclaration) i.next();
			if (var.getName().equals(name)) {
				return var;
			}
		}
		return res;
	}

	/** Clone */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO unit test !!
			// TODOMWA
			throw new RuntimeException(e);
		}
	}

	/** Accept a Semantic Visitor */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	/** ToString */
	public String toString() {
		String str = "Tuple(";
		Iterator i = this.getPartType().iterator();
		while (i.hasNext()) {
			VariableDeclaration pt = (VariableDeclaration) i.next();
			str += pt.getName() + ":" + pt.getType();
			if (i.hasNext()) {
				str += ", ";
			}
		}
		return str + ")";
	}

	public Object getDelegate() {
		return java.util.Map.class;
	}

	public Class getImplClass() {
		return OclTuple.class;
	}
}
