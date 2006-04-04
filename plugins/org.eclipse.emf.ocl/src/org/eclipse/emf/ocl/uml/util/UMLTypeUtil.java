/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 * 
 * $Id: UMLTypeUtil.java,v 1.1 2006/04/04 18:09:06 cdamus Exp $
 */
package org.eclipse.emf.ocl.uml.util;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ocl.types.TupleType;

/**
 * Utility methods for working with the annotations that extend the Ecore
 * model to implement certain UML semantics required by OCL.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLTypeUtil {
	
	/**
	 * Annotation that indicates what kind of a UML classifier is an
	 * {@link EClass}.  The details map has a <code>"kind"</code> key mapping
	 * to one of the following values:
	 * <ul>
	 *   <li><code>"AssociationClass"</code> - indicates association class</li>
	 *   <li><code>"Signal"</code> - indicates signal</li>
	 *   <li><code>"Class"</code> - indicates class (implicit for {@link EClass}es)</li>
	 *   <li><code>"DataType"</code> - indicates data type (implicit for {@link EDataType}s</li>
	 *   <li><code>"Enumeration"</code> - indicates enumeration (implicit for {@link EEnum}s</li>
	 * </ul>
	 */
	public static final String ANNOTATION_URI_CLASSIFIER = "http://www.eclipse.org/OCL/1.0.0/classifier"; //$NON-NLS-1$
	
	/**
	 * Annotation that stores references to which of the {@link EReference}s
	 * of an {@link EClass} representing an association class are its
	 * member ends.
	 */
	public static final String ANNOTATION_URI_MEMBER_ENDS = "http://www.eclipse.org/OCL/1.0.0/memberEnds"; //$NON-NLS-1$
	
	/**
	 * Annotation that stores the reference to the {@link EClass} representing
	 * an association class that includes an {@link EReference} as a member end.
	 */
	public static final String ANNOTATION_URI_ASSOCIATION_CLASS = "http://www.eclipse.org/OCL/1.0.0/associationClass"; //$NON-NLS-1$
	
	/**
	 * Annotation that stores details of the nature of a UML operation
	 * (modeled as an {@link EOperation}).  The details map supports the
	 * following keys:
	 * <ul>
	 *   <li><code>"isQuery"</code> - value "true" or "false" according to whether
	 *       the operation is a query (side-effect-free) operation</li>
	 * </ul>
	 */
	public static final String ANNOTATION_URI_OPERATION = "http://www.eclipse.org/OCL/1.0.0/operation"; //$NON-NLS-1$
	
	/**
	 * Annotation that stores qualifiers (if any) of a UML association end
	 * (modeled as an {@link EReference}).  The qualifiers are
	 * {@link EStructuralFeature}s in the annotation's contents list.
	 */
	public static final String ANNOTATION_URI_QUALIFIERS = "http://www.eclipse.org/OCL/1.0.0/qualifiers"; //$NON-NLS-1$
	
	/**
	 * Annotation that stores references to {@link EClass}es representing
	 * signals that an {@link EClass} can receive.
	 */
	public static final String ANNOTATION_URI_SIGNALS = "http://www.eclipse.org/OCL/1.0.0/signals"; //$NON-NLS-1$
	
	/**
	 * Not instantiable
	 */
	private UMLTypeUtil() {
		super();
	}

	/**
	 * Queries whether the specified classifier represents a UML signal.
	 * 
	 * @param classifier an OCL type
	 * 
	 * @return whether it represents a UML signal
	 */
	public static boolean isSignal(EClassifier classifier) {
		boolean result = false;
		
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (ann != null) {
				result = "Signal".equals(ann.getDetails().get("kind"));  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		return result;
	}

	/**
	 * Queries whether the specified classifier represents a UML association class.
	 * 
	 * @param classifier an OCL type
	 * 
	 * @return whether it represents a UML association class
	 */
	public static boolean isAssociationClass(EClassifier classifier) {
		boolean result = false;
		
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (ann != null) {
				result = "AssociationClass".equals(ann.getDetails().get("kind"));  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		return result;
	}

	/**
	 * Queries whether the specified classifier represents a UML class.
	 * 
	 * @param classifier an OCL type
	 * 
	 * @return whether it represents a UML class
	 */
	public static boolean isClass(EClassifier classifier) {
		boolean result = (classifier instanceof EClass)
				&& !(classifier instanceof TupleType);
		
		if (!result && (classifier != null)) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (ann != null) {
				result = "Class".equals(ann.getDetails().get("kind"));  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		return result;
	}

	/**
	 * Queries whether the specified classifier represents a UML data type.
	 * Note that an {@linkplain #isEnumeration(EClassifier) enumeration} is a
	 * data type.
	 * 
	 * @param classifier an OCL type
	 * 
	 * @return whether it represents a UML data type
	 */
	public static boolean isDataType(EClassifier classifier) {
		boolean result = (classifier instanceof EDataType)
				|| (classifier instanceof TupleType)
				|| isEnumeration(classifier);
		
		if (!result && (classifier != null)) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (ann != null) {
				result = "DataType".equals(ann.getDetails().get("kind"));  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		return result;
	}

	/**
	 * Queries whether the specified classifier represents a UML enumeration.
	 * 
	 * @param classifier an OCL type
	 * 
	 * @return whether it represents a UML enumeration
	 */
	public static boolean isEnumeration(EClassifier classifier) {
		boolean result = classifier instanceof EEnum;
		
		if (!result && (classifier != null)) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (ann != null) {
				result = "Enumeration".equals(ann.getDetails().get("kind"));  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		return result;
	}

	/**
	 * Queries whether the specified operation is a query (side-effect free).
	 * 
	 * @param classifier an OCL operation
	 * 
	 * @return whether it represents a query operation
	 */
	public static boolean isQuery(EOperation operation) {
		boolean result = true;
		
		if (operation != null) {
			EAnnotation ann = operation.getEAnnotation(ANNOTATION_URI_OPERATION);
			
			if (ann != null) {
				result = "false".equals(ann.getDetails().get("isQuery"));  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the member ends of an EMF classifier representing a UML association class.
	 * 
	 * @param associationClass representation of a UML association class
	 * 
	 * @return its member ends, as a list of {@link EReference}s
	 * 
	 * @see #isAssociationClass(EClassifier)
	 * @see #getAssociationClass(EReference)
	 */
	public static EList getMemberEnds(EClass associationClass) {
		EList result = ECollections.EMPTY_ELIST;
		
		if (associationClass != null) {
			EAnnotation ann = associationClass.getEAnnotation(ANNOTATION_URI_MEMBER_ENDS);
			
			if (ann != null) {
				result = ann.getReferences();
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the {@link EClass} representing the "class" aspect of the
	 * UML association class that the specified {@link EReference} represents.
	 * 
	 * @param reference an association class reference
	 * 
	 * @return the reference's association class
	 * 
	 * @see #getMemberEnds(EClass)
	 * @see #isAssociationClass(EClassifier)
	 */
	public static EClass getAssociationClass(EReference reference) {
		EClass result = null;
		
		if (reference != null) {
			EAnnotation ann = reference.getEAnnotation(ANNOTATION_URI_ASSOCIATION_CLASS);
			
			if (ann != null) {
				EList references = ann.getReferences();
				if (!references.isEmpty()) {
					result = (EClass) references.get(0);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the UML qualifiers, if any, associated with the specified property.
	 * 
	 * @param property the representation of a UML property
	 * 
	 * @return its qualifiers, as a list of {@link EStructuralFeature}s, if any
	 */
	public static EList getQualifiers(EStructuralFeature property) {
		EList result = ECollections.EMPTY_ELIST;
		
		if (property != null) {
			EAnnotation ann = property.getEAnnotation(ANNOTATION_URI_QUALIFIERS);
			
			if (ann != null) {
				result = ann.getContents();
			}
		}
		
		return result;
	}
	
	/**
	 * Queries the property that has the specified qualifier, if any.
	 * 
	 * @param qualifier a UML qualifier
	 * 
	 * @return the owning property, or <code>null</code> if none
	 */
	public static EStructuralFeature getProperty(EStructuralFeature qualifier) {
		EStructuralFeature result = null;
		
		if ((qualifier != null) && (qualifier.eContainer() instanceof EAnnotation)) {
			EAnnotation annotation = (EAnnotation) qualifier.eContainer();
			
			if (annotation.getEModelElement() instanceof EStructuralFeature) {
				result = (EStructuralFeature) annotation.getEModelElement();
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the UML signals that the specified classifier can receive, if any.
	 * 
	 * @param eclass an OCL type
	 * 
	 * @return its signals, as a list of {@link EClass}es, if any
	 */
	public static EList getSignals(EClass eclass) {
		EList result = ECollections.EMPTY_ELIST;
		
		if (eclass != null) {
			EAnnotation ann = eclass.getEAnnotation(ANNOTATION_URI_SIGNALS);
			
			if (ann != null) {
				result = ann.getReferences();
			}
		}
		
		return result;
	}

	/**
	 * Sets whether the specified classifier represents a UML signal.
	 * 
	 * @param classifier an OCL type
	 * @param isSignal whether it represents a UML signal
	 */
	public static void setSignal(EClassifier classifier, boolean isSignal) {
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (isSignal) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_CLASSIFIER);
					ann.setEModelElement(classifier);
				}
				
				ann.getDetails().put("kind", "Signal");  //$NON-NLS-1$//$NON-NLS-2$
			} else if (ann != null) {
				ann.setEModelElement(null);
			}
		}
	}

	/**
	 * Sets whether the specified classifier represents a UML association class.
	 * 
	 * @param classifier an OCL type
	 * @param isAssociationClass whether it represents a UML association class
	 */
	public static void setAssociationClass(EClassifier classifier, boolean isAssociationClass) {
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (isAssociationClass) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_CLASSIFIER);
					ann.setEModelElement(classifier);
				}
				
				ann.getDetails().put("kind", "AssociationClass");  //$NON-NLS-1$//$NON-NLS-2$
			} else if (ann != null) {
				ann.setEModelElement(null);
			}
		}
	}

	/**
	 * Sets whether the specified classifier represents a UML class.
	 * 
	 * @param classifier an OCL type
	 * @param isClass whether it represents a UML class
	 */
	public static void setClass(EClassifier classifier, boolean isClass) {
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (isClass) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_CLASSIFIER);
					ann.setEModelElement(classifier);
				}
				
				ann.getDetails().put("kind", "Class");  //$NON-NLS-1$//$NON-NLS-2$
			} else if (ann != null) {
				ann.setEModelElement(null);
			}
		}
	}

	/**
	 * Sets whether the specified classifier represents a UML data type.
	 * Note that an {@linkplain #isEnumeration(EClassifier) enumeration} is a
	 * data type.
	 * 
	 * @param classifier an OCL type
	 * @param isDataType whether it represents a UML data type
	 */
	public static void setDataType(EClassifier classifier, boolean isDataType) {
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (isDataType) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_CLASSIFIER);
					ann.setEModelElement(classifier);
				}
				
				ann.getDetails().put("kind", "DataType");  //$NON-NLS-1$//$NON-NLS-2$
			} else if (ann != null) {
				ann.setEModelElement(null);
			}
		}
	}

	/**
	 * Sets whether the specified classifier represents a UML enumeration.
	 * 
	 * @param classifier an OCL type
	 * @param isEnumeration whether it represents a UML enumeration
	 */
	public static void setEnumeration(EClassifier classifier, boolean isEnumeration) {
		if (classifier != null) {
			EAnnotation ann = classifier.getEAnnotation(ANNOTATION_URI_CLASSIFIER);
			
			if (isEnumeration) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_CLASSIFIER);
					ann.setEModelElement(classifier);
				}
				
				ann.getDetails().put("kind", "Enumeration");  //$NON-NLS-1$//$NON-NLS-2$
			} else if (ann != null) {
				ann.setEModelElement(null);
			}
		}
	}

	/**
	 * Sets whether the specified operation is a query (side-effect free).
	 * 
	 * @param classifier an OCL operation
	 * @param isQuery whether it represents a query operation
	 */
	public static void setQuery(EOperation operation, boolean isQuery) {
		if (operation != null) {
			EAnnotation ann = operation.getEAnnotation(ANNOTATION_URI_OPERATION);
			
			if (!isQuery) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_OPERATION);
					ann.setEModelElement(operation);
				}
				
				ann.getDetails().put("isQuery", "false");  //$NON-NLS-1$//$NON-NLS-2$
			} else if (ann != null) {
				ann.setEModelElement(null);
			}
		}
	}
	
	/**
	 * Adds a member end to an EMF classifier representing a UML association
	 * class.  This also sets the member end's association class reference.
	 * 
	 * @param associationClass representation of a UML association class
	 * @param memberEnd the member end to add
	 * 
	 * @see #isAssociationClass(EClassifier)
	 * @see #getAssociationClass(EReference)
	 */
	public static void addMemberEnd(EClass associationClass, EReference memberEnd) {
		if (associationClass != null) {
			EAnnotation ann = associationClass.getEAnnotation(ANNOTATION_URI_MEMBER_ENDS);
			
			if (memberEnd != null) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_MEMBER_ENDS);
					ann.setEModelElement(associationClass);
				}
				
				ann.getReferences().add(memberEnd);
				
				setAssociationClass(memberEnd, associationClass);
			}
		}
	}
	
	/**
	 * Sets the association class that an EReference represents (in its role
	 * of a UML association).  This is different than an association class
	 * member end, which is owned by an association class.  In this case, the
	 * <code>reference</code> actually represents the association class.
	 * 
	 * @param reference a reference representing a UML association class
	 * @param associationClass the Ecore representation of the association class's class-ness
	 */
	public static void setAssociationClass(EReference reference, EClass associationClass) {
		if (reference != null) {
			EAnnotation ann = reference.getEAnnotation(ANNOTATION_URI_ASSOCIATION_CLASS);
			
			if (associationClass != null) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_ASSOCIATION_CLASS);
					ann.setEModelElement(reference);
				}
				
				ann.getReferences().clear();
				ann.getReferences().add(associationClass);
			}
		}
	}
	
	/**
	 * Adds a UML qualifier to the specified property.
	 * 
	 * @param property the representation of a UML property
	 * @param qualifier a qualifier to add
	 */
	public static void addQualifier(EStructuralFeature property, EStructuralFeature qualifier) {
		if (property != null) {
			EAnnotation ann = property.getEAnnotation(ANNOTATION_URI_QUALIFIERS);
			
			if (qualifier != null) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_QUALIFIERS);
					ann.setEModelElement(property);
				}
				
				ann.getContents().add(qualifier);
			}
		}
	}
	
	/**
	 * Adds a UML signal that the specified classifier can receive.
	 * 
	 * @param eclass an OCL type
	 * @param signal a signal that it can receive
	 */
	public static void addSignal(EClass eclass, EClass signal) {
		if (eclass != null) {
			EAnnotation ann = eclass.getEAnnotation(ANNOTATION_URI_SIGNALS);
			
			if (signal != null) {
				if (ann == null) {
					ann = EcoreFactory.eINSTANCE.createEAnnotation();
					ann.setSource(ANNOTATION_URI_SIGNALS);
					ann.setEModelElement(eclass);
				}
				
				ann.getReferences().add(signal);
			}
		}
	}
}
