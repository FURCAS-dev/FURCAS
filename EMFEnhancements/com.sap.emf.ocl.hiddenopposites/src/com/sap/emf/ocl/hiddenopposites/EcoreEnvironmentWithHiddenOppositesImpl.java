/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.hiddenopposites;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.emf.ecore.opposites.OppositeEndFinder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AmbiguousLookupException;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreOCLStandardLibrary;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.PrimitiveType;


public class EcoreEnvironmentWithHiddenOppositesImpl extends EcoreEnvironment
		implements EcoreEnvironmentWithHiddenOpposites {

	private final OppositeEndFinder oppositeEndFinder;

	/**
	 * The variables added using {@link #addElement(String, org.eclipse.ocl.expressions.Variable, boolean)}
	 * with <tt>isImplicit==true</tt> and not yet removed using {@link #deleteElement(String)}.
	 */
	private List<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>> implicitNamedElements =
		new ArrayList<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>>();

	public EcoreEnvironmentWithHiddenOppositesImpl(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
		super(parent);
		oppositeEndFinder = ((EcoreEnvironmentWithHiddenOppositesImpl) parent).oppositeEndFinder;
	}

	public EcoreEnvironmentWithHiddenOppositesImpl(EPackage.Registry registry, OppositeEndFinder oppositeEndFinder) {
		super(registry);
		this.oppositeEndFinder = oppositeEndFinder;
	}

	public EcoreEnvironmentWithHiddenOppositesImpl(EPackage.Registry registry, Resource resource, OppositeEndFinder oppositeEndFinder) {
		super(registry, resource);
		this.oppositeEndFinder = oppositeEndFinder;
	}

	/**
	 * Uses a {@link DefaultOppositeEndFinder}
	 */
	public EcoreEnvironmentWithHiddenOppositesImpl(org.eclipse.emf.ecore.EPackage.Registry packageRegistry) {
	    this(packageRegistry, DefaultOppositeEndFinder.getInstance());
        }

    /**
     * Looks up a non-navigable association end on behalf of
     * the specified <code>owner</code> classifier (which is at that end).
     * 
     * @param owner
     *            a classifier in the context of which the property is used
     * @param name
     *            the end name to look up
     * 
     * @return the non-navigable end, or <code>null</code> if it cannot
     *         be found
     *         
     * @throws LookupException in case that multiple non-navigable properties
     *     are found that have the same name and the problem option is ERROR
     *     or worse
     * @since 3.0
     */
    public EReference lookupOppositeProperty(EClassifier owner, String name) throws LookupException {
        if (owner == null) {
            org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> vdcl = lookupImplicitSourceForOppositeProperty(name);

            if (vdcl == null) {
                return null;
            }

            owner = vdcl.getType();
        }

        List<EStructuralFeature> matches = new java.util.ArrayList<EStructuralFeature>(2);
        findOppositeEnds(owner, name, matches);

        if (matches.isEmpty()) {
            return null;
        } else if (matches.size() > 1) {
            // ambiguous matches.  What to do?
            if (notOK(ProblemOption.AMBIGUOUS_ASSOCIATION_ENDS)) {
                ProblemHandler.Severity sev = getValue(ProblemOption.AMBIGUOUS_ASSOCIATION_ENDS);

                // will have to report the problem
                String message = OCLMessages.bind(OCLMessages.Ambig_AssocEnd_,
                    name, getUMLReflection().getName(owner));

                if (sev.getDiagnosticSeverity() >= Diagnostic.ERROR) {
                    throw new AmbiguousLookupException(message, matches);
                } else {
                    getProblemHandler().analyzerProblem(sev, message,
                        "lookupNonNavigableProperty", -1, -1); //$NON-NLS-1$
                }
            }
        }
        
        return (EReference) matches.get(0);
    }

    public EClassifier getOppositePropertyType(EClassifier owner, EStructuralFeature property) {
        return getOCLCollectionType((EClassifier) property.eContainer(),
        /* ordered */false, /* unique */false);
    }

    /**
     * Obtains the appropriate OCL collection type for an {@link EClassifier}, 
     * according to the collection's orderedness and uniqueness.  The mapping is
     * as follows:
     * <ul>
     *   <li>ordered, unique: ordered set type</li>
     *   <li>ordered, non-unique: sequence type</li>
     *   <li>non-ordered, unique: set type</li>
     *   <li>non-ordered, non-unique: bag type</li>
     * </ul>
     * <p>
     * Note that the collection's element <code>type</code> is mapped to an
     * OCL primitive type where possible.
     * </p>
     * 
     * @param type the type to get the corresponding OCL collection type for
     * @param isOrdered whether the OCL type should be ordered
     * @param isUnique whether the OCL type should be unique
     * 
     * @return the corresponding OCL type
     * 
     * @see #getOCLType(EClassifier)
     */ 
    EClassifier getOCLCollectionType(EClassifier type,
            boolean isOrdered, boolean isUnique) {
        EClassifier resultType = type;
    
        if (resultType instanceof EDataType) {
            resultType = getOCLTypeFor((EDataType) resultType);
        }
        
        if (isOrdered) {
            if (isUnique) {
                resultType = (EClassifier) getOCLFactory().createOrderedSetType(resultType);
            } else {
                resultType = (EClassifier) getOCLFactory().createSequenceType(resultType);
            }
        } else {
            if (isUnique) {
                resultType = (EClassifier) getOCLFactory().createSetType(resultType);
            } else {
                resultType = (EClassifier) getOCLFactory().createBagType(resultType);
            }
        }
        
        return resultType;
    }
    
    private final EcoreOCLStandardLibrary stdlib = new EcoreOCLStandardLibrary();

    /**
     * Translator from primitive EMF types to OCL types
     * 
     * @param dataType a data type in the EMF metamodel
     * @return  the corresponding OCL classifier
     */
    private EClassifier getOCLTypeFor(EDataType dataType) {
    
        // First check if it is already an OCL data type (EEnums represent
        //    themselves)
        if (dataType instanceof EEnum) {
            return dataType;
        }
        if (dataType instanceof CollectionType<?, ?>) {
            return dataType;
        }
        if (dataType instanceof PrimitiveType<?>) {
            return dataType;
        }
    
        Class<?> instanceClass = dataType.getInstanceClass();
    
        if (instanceClass != null) {
	        if (instanceClass == Boolean.class
	            || instanceClass == boolean.class) {
	            return stdlib.getBoolean();
	        } else if (instanceClass == Double.class
				|| instanceClass == BigDecimal.class
				|| instanceClass == double.class
				|| instanceClass == Float.class || instanceClass == float.class) {
				return stdlib.getReal();
			} else if (instanceClass == String.class) {
				return stdlib.getString();
			} else if (instanceClass == Integer.class
				|| instanceClass == int.class || instanceClass == Long.class
				|| instanceClass == long.class || instanceClass == Short.class
				|| instanceClass == short.class
				|| instanceClass == BigInteger.class) {
				return stdlib.getInteger();
	        } else if (List.class.isAssignableFrom(instanceClass)) {
	            return stdlib.getSequence();
	        } else if (Set.class.isAssignableFrom(instanceClass)) {
	            return stdlib.getSet();
	        } else if (Collection.class.isAssignableFrom(instanceClass)) {
	            return stdlib.getCollection();
	        } else if (instanceClass == Object.class) {
	            return stdlib.getOclAny();
	        }
        }
        
        // All other data types map to themselves
        return dataType;
    }
	public Map<String, EStructuralFeature> getHiddenOppositeProperties(
			EClassifier classifier) {
		Map<String, EStructuralFeature> result;
		if (oppositeEndFinder == null) {
			result = Collections.emptyMap();
		} else {
			result = oppositeEndFinder.getAllOppositeEnds(classifier);
		}
		return result;
	}

	@Override
	public boolean addElement(String name,
			org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> elem,
			boolean isExplicit) {
		boolean result = super.addElement(name, elem, isExplicit);
		if (result && !isExplicit) {
			implicitNamedElements.add(elem);
		}
		return result;
	}

	@Override
	public void deleteElement(String name) {
		for (Iterator<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>> i=implicitNamedElements.iterator(); i.hasNext(); ) {
			Variable<EClassifier, EParameter> implicitNamedElement = i.next();
			if (implicitNamedElement.getName().equals(name)) {
				i.remove();
				break;
			}
		}
		super.deleteElement(name);
	}

	private org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> lookupImplicitSourceForOppositeProperty(String name) {
		for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> vdcl : implicitNamedElements) {
		//for (int i = namedElements.size() - 1; i >= 0; i--) {
		//	VariableEntry element = namedElements.get(i);
		//	vdcl = element.variable;
			EClassifier owner = vdcl.getType();
			if (owner != null) {
				EStructuralFeature property = safeTryLookupOppositeProperty(owner, name);
				if (property != null) {
					return vdcl;
				}
			}
		}
		// try the "self" variable, last
		org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> vdcl = getSelfVariable();
		if (vdcl != null) {
			EClassifier owner = vdcl.getType();
			if (owner != null) {
				EStructuralFeature property = safeTryLookupOppositeProperty(owner, name);
				if (property != null) {
					return vdcl;
				}
			}
		}
		return null;
	}

	/**
	 * Wrapper for the "try" operation that doesn't throw, but just returns the
	 * first ambiguous match in case of ambiguity.
	 */
    private EStructuralFeature safeTryLookupOppositeProperty(EClassifier owner, String name) {
		EStructuralFeature result = null;
	    
	    try {
	        result = tryLookupOppositeProperty(owner, name);
        } catch (LookupException e) {
            if (!e.getAmbiguousMatches().isEmpty()) {
                result = (EStructuralFeature) e.getAmbiguousMatches().get(0);
            }
	    }
        
        return result;
	}

    /**
     * This default implementation simply delegates to the
     * {@link Environment#lookupOppositeProperty(Object, String)} method.
     * 
     * @since 3.0
     */
    private EStructuralFeature tryLookupOppositeProperty(EClassifier owner, String name)
        throws LookupException {
    	EStructuralFeature result = lookupOppositeProperty(owner, name);
        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            result = lookupOppositeProperty(owner, AbstractOCLAnalyzer.unescape(name));
        }
        return result;
    }

	private	void findOppositeEnds(EClassifier classifier, String name,
			List<EStructuralFeature> ends) {
		if (oppositeEndFinder != null) {
			oppositeEndFinder.findOppositeEnds(classifier, name, ends);
		}
	}
	
	// make visible in this package and beyond
	@Override
	public void setFactory(EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> factory) {
		super.setFactory(factory);
	}
}
