/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotStandardLibrary.java,v 1.5 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.model.OclMetaModel;

public abstract class PivotStandardLibrary implements StandardLibrary
{
	private static final Logger logger = Logger.getLogger(PivotStandardLibrary.class);

	/**
	 * The URI used by default for the MDT/OCL Standard Library. NB. This
	 * constant is repeated in GenersateOCLstdlibModel.mwe2 an in
	 * org.eclipse.ocl.examples.library/plugin.xml.
	 */
	public static final String DEFAULT_OCL_STDLIB_URI = "http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib";

	/**
	 * The URI to provide the default Standard Library. This value may be
	 * reassigned pior to any OCL analysis or evaluation to select a different
	 * default. Alternatively the need for default may be bypassed by explicitly
	 * invoking loadLibrary().
	 */
	protected String defaultStandardLibraryURI = DEFAULT_OCL_STDLIB_URI;

	private PrimitiveType booleanType = null;
	private org.eclipse.ocl.examples.pivot.Class classifierType = null;
	private PrimitiveType integerType = null;
	private AnyType oclAnyType = null;
	private InvalidType oclInvalidType = null;
	private VoidType oclVoidType = null;
	private PrimitiveType realType = null;
	private PrimitiveType stringType = null;
	private Type tupleType = null;
	private PrimitiveType unlimitedNaturalType = null;
	
	org.eclipse.ocl.examples.pivot.Package pivotPackage = null;
	
	private Map<String, Type> nameToLibraryTypeMap = null;

	protected void defineLibraryType(Type pivotType) {
		if (nameToLibraryTypeMap == null) {
			nameToLibraryTypeMap = new HashMap<String, Type>();
		}
		String name = pivotType.getName();
		Type oldType = nameToLibraryTypeMap.put(name, pivotType);
		if ((oldType != null) && (oldType != pivotType)) {
			logger.warn("Conflicting pivot type '" + name + "'");
		}
	}

	public BagType getBagType() {
		return (BagType) getRequiredLibraryType("Bag");
	}

	public Type getBagTypeType() {
		return getRequiredLibraryType("BagType");
	}

	public PrimitiveType getBooleanType() {
		if (booleanType == null) {
			Type type = getRequiredLibraryType("Boolean");
			if (type instanceof PrimitiveType) {
				booleanType = (PrimitiveType) type;
			}
			else if (type != null) {
				logger.error("Boolean is not a PrimitiveType");
			}		
		}
		return booleanType;
	}

	public org.eclipse.ocl.examples.pivot.Class getClassifierType() {
		if (classifierType == null) {
			Type type = getRequiredLibraryType("Classifier");
			if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
				classifierType = (org.eclipse.ocl.examples.pivot.Class) type;
			}
			else if (type != null) {
				logger.error("Classifier is not a Class");
			}		
		}
		return classifierType;
	}

	public CollectionType getCollectionType() {
		return (CollectionType) getRequiredLibraryType("Collection");
	}

	public Type getCollectionTypeType() {
		return getRequiredLibraryType("CollectionType");
	}

	public PrimitiveType getIntegerType() {
		if (integerType == null) {
			Type type = getRequiredLibraryType("Integer");
			if (type instanceof PrimitiveType) {
				integerType = (PrimitiveType) type;
			}
			else if (type != null) {
				logger.error("Integer is not a PrimitiveType");
			}		
		}
		return integerType;
	}

	public Type getLibraryType(String typeName) {
		if (nameToLibraryTypeMap == null) {
			nameToLibraryTypeMap = new HashMap<String, Type>();
			loadDefaultLibrary(defaultStandardLibraryURI);
		}
		return nameToLibraryTypeMap.get(typeName);
	}

	public AnyType getOclAnyType() {
		if (oclAnyType == null) {
			Type type = getRequiredLibraryType("OclAny");
			if (type instanceof AnyType) {
				oclAnyType = (AnyType) type;
			}
			else if (type != null) {
				logger.error("OclAny is not an AnyType");
			}		
		}
		return oclAnyType;
	}

	public InvalidType getOclInvalidType() {
		if (oclInvalidType == null) {
			Type type = getRequiredLibraryType("OclInvalid");
			if (type instanceof InvalidType) {
				oclInvalidType = (InvalidType) type;
			}
			else if (type != null) {
				logger.error("OclInvalid is not an InvalidType");
			}		
		}
		return oclInvalidType;
	}

	public Type getOclMessageType() {
		return getRequiredLibraryType("OclMessage");
	}

	public VoidType getOclVoidType() {
		if (oclVoidType == null) {
			Type type = getRequiredLibraryType("OclVoid");
			if (type instanceof VoidType) {
				oclVoidType = (VoidType) type;
			}
			else if (type != null) {
				logger.error("OclVoid is not a VoidType");
			}		
		}
		return oclVoidType;
	}

	public OrderedSetType getOrderedSetType() {
		Type type = getRequiredLibraryType("OrderedSet");
		return (OrderedSetType) type;
	}

	public Type getOrderedSetTypeType() {
		Type type = getRequiredLibraryType("OrderedSetType");
		return type;
	}
	
	public org.eclipse.ocl.examples.pivot.Package getPivotPackage() {
		if (pivotPackage == null) {
			pivotPackage = OclMetaModel.create(this);
		}
		return pivotPackage;
	}

	/**
	 * Return the pivot model class for className with the Pivot Model.
	 */
	public Type getPivotType(String className) {
		return PivotUtil.getNamedElement(getPivotPackage().getOwnedTypes(), className);
	}	

	public Type getPrimitiveTypeType() {
		return getRequiredLibraryType("PrimitiveType");
	}

	public PrimitiveType getRealType() {
		if (realType == null) {
			Type type = getRequiredLibraryType("Real");
			if (type instanceof PrimitiveType) {
				realType = (PrimitiveType) type;
			}
			else if (type != null) {
				logger.error("Real is not a PrimitiveType");
			}		
		}
		return realType;
	}

	public Type getRequiredLibraryType(String typeName) {
		Type type = getLibraryType(typeName);
		if (type == null) {
			nameToLibraryTypeMap = null;
			type = getLibraryType(typeName);	// FIXME just a debug retry
			if ((nameToLibraryTypeMap == null) || nameToLibraryTypeMap.isEmpty()) {
				logger.error("No OCL Standard Library available");
			}
			else {
				logger.error("No '" + typeName + "' type in the OCL Standard Library");
			}
		}
		return type;
	}

	public SequenceType getSequenceType() {
		Type type = getRequiredLibraryType("Sequence");
		return (SequenceType) type;
	}

	public Type getSequenceTypeType() {
		return getRequiredLibraryType("SequenceType");
	}

	public SetType getSetType() {
		Type type = getRequiredLibraryType("Set");
		return (SetType) type;
	}

	public Type getSetTypeType() {
		return getRequiredLibraryType("SetType");
	}

	public PrimitiveType getStringType() {
		if (stringType == null) {
			Type type = getRequiredLibraryType("String");
			if (type instanceof PrimitiveType) {
				stringType = (PrimitiveType) type;
			}
			else if (type != null) {
				logger.error("String is not a PrimitiveType");
			}		
		}
		return stringType;
	}

	public Type getTupleType() {
		if (tupleType == null) {
			tupleType = getRequiredLibraryType("Tuple");
		}
		return tupleType;
	}

	public PrimitiveType getUnlimitedNaturalType() {
		if (unlimitedNaturalType == null) {
			Type type = getRequiredLibraryType("UnlimitedNatural");
			if (type instanceof PrimitiveType) {
				unlimitedNaturalType = (PrimitiveType) type;
			}
			else if (type != null) {
				logger.error("UnlimitedNatural is not a PrimitiveType");
			}		
		}
		return unlimitedNaturalType;
	}

	public boolean isOrdered(Type sourceType) {
		if (sourceType instanceof OrderedSetType) {
			return true;
		}
		if (sourceType instanceof SequenceType) {
			return true;
		}
		return false;
	}

	public boolean isUnique(Type sourceType) {
		if (sourceType instanceof OrderedSetType) {
			return true;
		}
		if (sourceType instanceof SetType) {
			return true;
		}
		return false;
	}
	
	protected abstract Resource loadDefaultLibrary(String uri);
}