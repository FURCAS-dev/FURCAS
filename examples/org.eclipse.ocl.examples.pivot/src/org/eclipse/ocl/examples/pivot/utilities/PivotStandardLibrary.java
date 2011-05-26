/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: PivotStandardLibrary.java,v 1.14 2011/05/22 16:42:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.osgi.util.NLS;

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

	private BagType bagType = null;
	private PrimitiveType booleanType = null;
	private ClassifierType classifierType = null;
	private CollectionType collectionType = null;
	private org.eclipse.ocl.examples.pivot.Class enumerationType = null;
	private PrimitiveType integerType = null;
	private AnyType oclAnyType = null;
	private InvalidType oclInvalidType = null;
	private VoidType oclVoidType = null;
	private OrderedSetType orderedSetType = null;
	private PrimitiveType realType = null;
	private SequenceType sequenceType = null;
	private SetType setType = null;
	private PrimitiveType stringType = null;
	private TupleType tupleType = null;
	private PrimitiveType unlimitedNaturalType = null;
	
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
		if (bagType == null) {
			Type type = getRequiredLibraryType("Bag");
			if (type instanceof BagType) {
				if (((BagType) type).getOwnedTemplateSignature() == null) {
					throw new IllegalLibraryException("Bag is not a templated type");
				}
				else if (((BagType) type).getOwnedTemplateSignature().getParameters().size() != 1) {
					throw new IllegalLibraryException("Bag is not a templated type with a single argument");
				}
				bagType = (BagType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Bag is not a BagType");
			}		
		}
		return bagType;
	}

	public PrimitiveType getBooleanType() {
		if (booleanType == null) {
			Type type = getRequiredLibraryType("Boolean");
			if (type instanceof PrimitiveType) {
				booleanType = (PrimitiveType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Boolean is not a PrimitiveType");
			}		
		}
		return booleanType;
	}

	public ClassifierType getClassifierType() {
		if (classifierType == null) {
			Type type = getRequiredLibraryType("Classifier");
			if (type instanceof ClassifierType) {
				if (((ClassifierType) type).getOwnedTemplateSignature() == null) {
					throw new IllegalLibraryException("Classifier is not a templated type");
				}
				else if (((ClassifierType) type).getOwnedTemplateSignature().getParameters().size() != 1) {
					throw new IllegalLibraryException("Classifier is not a templated type with a single argument");
				}
				classifierType = (ClassifierType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Classifier is not a ClassifierType");
			}		
		}
		return classifierType;
	}

	public CollectionType getCollectionType() {
		if (collectionType == null) {
			Type type = getRequiredLibraryType("Collection");
			if (type instanceof CollectionType) {
				if (((CollectionType) type).getOwnedTemplateSignature() == null) {
					throw new IllegalLibraryException("Collection is not a templated type");
				}
				else if (((CollectionType) type).getOwnedTemplateSignature().getParameters().size() != 1) {
					throw new IllegalLibraryException("Collection is not a templated type with a single argument");
				}
				collectionType = (CollectionType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Collection is not a CollectionType");
			}		
		}
		return collectionType;
	}

	public org.eclipse.ocl.examples.pivot.Class getEnumerationType() {
		if (enumerationType == null) {
			Type type = getRequiredLibraryType("Enumeration");
			if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
				enumerationType = (org.eclipse.ocl.examples.pivot.Class) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Enumeration is not a Class");
			}		
		}
		return enumerationType;
	}

	public PrimitiveType getIntegerType() {
		if (integerType == null) {
			Type type = getRequiredLibraryType("Integer");
			if (type instanceof PrimitiveType) {
				integerType = (PrimitiveType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Integer is not a PrimitiveType");
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
				throw new IllegalLibraryException("OclAny is not an AnyType");
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
				throw new IllegalLibraryException("OclInvalid is not an InvalidType");
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
				throw new IllegalLibraryException("OclVoid is not a VoidType");
			}		
		}
		return oclVoidType;
	}

	public OrderedSetType getOrderedSetType() {
		if (orderedSetType == null) {
			Type type = getRequiredLibraryType("OrderedSet");
			if (type instanceof OrderedSetType) {
				if (((OrderedSetType) type).getOwnedTemplateSignature() == null) {
					throw new IllegalLibraryException("OrderedSet is not a templated type");
				}
				else if (((OrderedSetType) type).getOwnedTemplateSignature().getParameters().size() != 1) {
					throw new IllegalLibraryException("OrderedSet is not a templated type with a single argument");
				}
				orderedSetType = (OrderedSetType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("OrderedSet is not an OrderedSetType");
			}		
		}
		return orderedSetType;
	}

	public PrimitiveType getRealType() {
		if (realType == null) {
			Type type = getRequiredLibraryType("Real");
			if (type instanceof PrimitiveType) {
				realType = (PrimitiveType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Real is not a PrimitiveType");
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
				throw new IllegalLibraryException(OCLMessages.EmptyLibrary_ERROR_);
			}
			else {
				throw new IllegalLibraryException(NLS.bind(OCLMessages.MissingLibraryType_ERROR_, typeName));
			}
		}
		return type;
	}

	public SequenceType getSequenceType() {
		if (sequenceType == null) {
			Type type = getRequiredLibraryType("Sequence");
			if (type instanceof SequenceType) {
				if (((SequenceType) type).getOwnedTemplateSignature() == null) {
					throw new IllegalLibraryException("Sequence is not a templated type");
				}
				else if (((SequenceType) type).getOwnedTemplateSignature().getParameters().size() != 1) {
					throw new IllegalLibraryException("Sequence is not a templated type with a single argument");
				}
				sequenceType = (SequenceType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Sequence is not a SequenceType");
			}		
		}
		return sequenceType;
	}

	public SetType getSetType() {
		if (setType == null) {
			Type type = getRequiredLibraryType("Set");
			if (type instanceof SetType) {
				if (((SetType) type).getOwnedTemplateSignature() == null) {
					throw new IllegalLibraryException("Set is not a templated type");
				}
				else if (((SetType) type).getOwnedTemplateSignature().getParameters().size() != 1) {
					throw new IllegalLibraryException("Set is not a templated type with a single argument");
				}
				setType = (SetType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Set is not a SetType");
			}		
		}
		return setType;
	}

	public PrimitiveType getStringType() {
		if (stringType == null) {
			Type type = getRequiredLibraryType("String");
			if (type instanceof PrimitiveType) {
				stringType = (PrimitiveType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("String is not a PrimitiveType");
			}		
		}
		return stringType;
	}

	public TupleType getTupleType() {
		if (tupleType == null) {
			Type type = getRequiredLibraryType("Tuple");
			if (type instanceof TupleType) {
				tupleType = (TupleType) type;
			}
			else if (type != null) {
				throw new IllegalLibraryException("Tuple is not a TupleType");
			}		
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
				throw new IllegalLibraryException("UnlimitedNatural is not a PrimitiveType");
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

	public void resetLibrary() {
		bagType = null;
		booleanType = null;
		classifierType = null;
		collectionType = null;
		enumerationType = null;
		integerType = null;
		oclAnyType = null;
		oclInvalidType = null;
		oclVoidType = null;
		orderedSetType = null;
		realType = null;
		sequenceType = null;
		setType = null;
		stringType = null;
		tupleType = null;
		unlimitedNaturalType = null;
		nameToLibraryTypeMap = null;
	}
}