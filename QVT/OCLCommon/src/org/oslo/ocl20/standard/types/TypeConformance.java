/**
 * Kent Modelling Framework - KMFStudio
 * Copyright (C) 2002 University of Kent at Canterbury, UK 
 * Visit www.cs.ukc.ac.uk/kmf
 *
 */

package org.oslo.ocl20.standard.types;

import java.util.Iterator;
import java.util.List;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Primitive;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.TupleType;
import org.oslo.ocl20.semantics.model.types.VoidType;

/**
 * 
 * @author Octavian Patrascoiu
 * 
 */
/** OCL type checking */
public class TypeConformance {
	/** Get the main interface for a class */
	public static Class getInterface(Object t) {
		if (t == null) {
			return null;
		}
		Class c = t.getClass();
		if (!c.isInterface()) {
			String clsName = c.getName();
			String interfName = "";
			// Remove $Class or Impl
			if (clsName.endsWith("$Class")) {
				int pos = clsName.lastIndexOf('$');
				interfName = clsName.substring(0, pos);
			} else if (clsName.endsWith("Impl")) {
				int pos = clsName.lastIndexOf('I');
				interfName = clsName.substring(0, pos);
			}
			// Remove until last .
			int pos = interfName.lastIndexOf('.');
			if (pos != 1) {
				interfName = interfName.substring(pos + 1, interfName.length());
			}
			Class interfs[] = c.getInterfaces();
			for (int i = 0; i < interfs.length; i++) {
				String name = interfs[i].getName();
				if (name.endsWith(interfName)) {
					return interfs[i];
				}
			}
		}
		return c;
	}

	/** Check isAssignableTo */
	public static boolean isAssignableTo(Object t1, Object t2) {
		Class i1 = TypeConformance.getInterface(t1);
		Class i2 = TypeConformance.getInterface(t2);
		if (i2 == null) {
			return true;
		}
		if (i2.isAssignableFrom(i1)) {
			return true;
		} else {
			return false;
		}
	}

	/** Check if t1 conforms to t2 */
	public static boolean conformsTo(Classifier t1, Classifier t2) {
		/** Check the primitive types */
		// --- T1 is void ---
		if (t1 instanceof VoidType) {
			return true;
			// --- T1 is primitive ---
		}
		if (t1 instanceof Primitive) {
			return TypeConformance.isAssignableTo(t1, t2);
			// --- T1 TupleType ---
		} else if (t1 instanceof TupleType) {
			// --- T2 is undefined ---
			if (t2 instanceof VoidType) {
				return true;
			}
			// --- T2 is tuple ---
			if (t2 instanceof TupleType) {
				// --- Get the internal lists ---
				List l1 = ((TupleType) t1).getPartType();
				List l2 = ((TupleType) t2).getPartType();
				// --- Check size ---
				if (l1.size() != l2.size()) {
					return false;
				}
				// --- Check each element from list
				Iterator i1 = l1.iterator();
				Iterator i2 = l2.iterator();
				while (i1.hasNext()) {
					// --- Get current element ---
					VariableDeclaration var1 = (VariableDeclaration) i1.next();
					VariableDeclaration var2 = (VariableDeclaration) i2.next();
					// --- Check name ---
					String name1 = var1.getName();
					String name2 = var2.getName();
					if (!name1.equals(name2)) {
						return false;
					}
					// --- Check type
					Classifier t11 = var1.getType();
					Classifier t21 = var2.getType();
					boolean conforms = TypeConformance.conformsTo(t11, t21);
					if (!conforms) {
						return false;
					}
				}
				return true;
				// --- Check for parents ---
			} else {
				return TypeConformance.isAssignableTo(t1, t2);
			}

			// --- T1 is a BagType ---
		} else if (t1 instanceof BagType) {
			// --- T2 is undefined ---
			if (t2 instanceof VoidType) {
				return true;
			}
			// --- T2 is BagType ---
			if (t2 instanceof BagType) {
				return TypeConformance.conformsTo(((BagType) t1).getElementType(), ((BagType) t2).getElementType());
			}
			// --- T2 is a CollectionType --
			if (t2 instanceof CollectionType && !(t2 instanceof SetType) && !(t2 instanceof OrderedSetType) && !(t2 instanceof SequenceType)) {
				return TypeConformance.conformsTo(((BagType) t1).getElementType(), ((CollectionType) t2).getElementType());
				// --- Check for parents ---
			} else {
				return TypeConformance.isAssignableTo(t1, t2);
			}

			// --- T1 is SetType ---
		} else if (t1 instanceof SetType) {
			// --- T2 is undefined ---
			if (t2 instanceof VoidType) {
				return true;
			}
			// --- T2 is SetType ---
			if (t2 instanceof SetType) {
				return TypeConformance.conformsTo(((SetType) t1).getElementType(), ((SetType) t2).getElementType());
			}
			// --- T2 is CollectionType ---
			if (t2 instanceof CollectionType && !(t2 instanceof BagType) && !(t2 instanceof OrderedSetType) && !(t2 instanceof SequenceType)) {
				return TypeConformance.conformsTo(((SetType) t1).getElementType(), ((CollectionType) t2).getElementType());
				// --- Check for parents ---
			} else {
				return TypeConformance.isAssignableTo(t1, t2);
			}

			// --- T1 is OrderedSetType ---
		} else if (t1 instanceof OrderedSetType) {
			// --- T2 is undefined ---
			if (t2 instanceof VoidType) {
				return true;
			}
			// --- T2 is OrderedSetType ---
			if (t2 instanceof OrderedSetType) {
				return TypeConformance.conformsTo(((OrderedSetType) t1).getElementType(), ((OrderedSetType) t2).getElementType());
			}
			// --- T2 is CollectionType ---
			if (t2 instanceof CollectionType && !(t2 instanceof SetType) && !(t2 instanceof BagType) && !(t2 instanceof SequenceType)) {
				return TypeConformance.conformsTo(((OrderedSetType) t1).getElementType(), ((CollectionType) t2).getElementType());
				// --- Check for parents ---
			} else {
				return TypeConformance.isAssignableTo(t1, t2);
			}

			// --- T1 is SequenceType ---
		} else if (t1 instanceof SequenceType) {
			// --- T2 is undefined ---
			if (t2 instanceof VoidType) {
				return true;
			}
			// --- T2 is SequenceType ---
			if (t2 instanceof SequenceType) {
				return TypeConformance.conformsTo(((SequenceType) t1).getElementType(), ((SequenceType) t2).getElementType());
			}
			// --- T2 is CollectionType ---
			if (t2 instanceof CollectionType && !(t2 instanceof SetType) && !(t2 instanceof OrderedSetType) && !(t2 instanceof BagType)) {
				return TypeConformance.conformsTo(((SequenceType) t1).getElementType(), ((CollectionType) t2).getElementType());
				// --- Check for parents ---
			} else {
				return TypeConformance.isAssignableTo(t1, t2);
			}

			// --- T1 is CollectionType ---
		} else if (t1 instanceof CollectionType) {
			// --- T2 is undefined ---
			if (t2 instanceof VoidType) {
				return true;
			}
			// --- T2 is CollectionType ---
			if (t2 instanceof CollectionType && !(t2 instanceof SetType) && !(t2 instanceof OrderedSetType) && !(t2 instanceof SequenceType) && !(t2 instanceof BagType)) {
				return TypeConformance.conformsTo(((CollectionType) t1).getElementType(), ((CollectionType) t2).getElementType());
				// --- Check for parents ---
			} else {
				return TypeConformance.isAssignableTo(t1, t2);
				// -- T1 is another type ---
			}
		} else {
			return TypeConformance.isAssignableTo(t1, t2);
		}
	}

	/** Check if two classifiers are identical */
	public static boolean identical(Classifier t1, Classifier t2) {
		String name1 = t1.getClass().toString();
		String name2 = t2.getClass().toString();
		return name1.equals(name2);
	}
}
