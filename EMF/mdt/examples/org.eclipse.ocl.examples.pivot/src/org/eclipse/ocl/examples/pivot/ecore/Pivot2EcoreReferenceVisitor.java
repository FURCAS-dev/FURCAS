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
 * $Id: Pivot2EcoreReferenceVisitor.java,v 1.3 2011/02/08 17:51:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.delegate.InvocationBehavior;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.SettingBehavior;
import org.eclipse.ocl.examples.pivot.delegate.ValidationBehavior;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

public class Pivot2EcoreReferenceVisitor
	extends AbstractExtendingVisitor<EObject, Pivot2Ecore>
{
	public static final Logger logger = Logger.getLogger(Pivot2EcoreDeclarationVisitor.class);

	protected final Pivot2EcoreTypeRefVisitor typeRefVisitor;
	
	public Pivot2EcoreReferenceVisitor(Pivot2Ecore context) {
		super(context);
		typeRefVisitor = new Pivot2EcoreTypeRefVisitor(context);
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	public <T extends EClassifier> void safeVisitAll(List<EGenericType> eGenericTypes, List<T> eTypes, List<? extends Type> superClasses) {
		if (superClasses.size() > 0) {
			List<EObject> superEClasses = new ArrayList<EObject>(superClasses.size());
			typeRefVisitor.safeVisitAll(superEClasses, superClasses);
			eTypes.clear();
			eGenericTypes.clear();
			for (EObject superEClass : superEClasses) {
				if (superEClass instanceof EGenericType) {
					eGenericTypes.add((EGenericType)superEClass);
				}
				else {
					@SuppressWarnings("unchecked")
					T castSuperEClass = (T)superEClass;
					eTypes.add(castSuperEClass);
				}
			}
		}
		else {
			eGenericTypes.clear();
		}
	}

	public EObject visiting(Visitable visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

	@Override
	public EObject visitAnnotation(Annotation pivotAnnotation) {
		EAnnotation eAnnotation = context.getCreated(EAnnotation.class, pivotAnnotation);
		eAnnotation.getReferences().clear();
		for (Element pivotReference : pivotAnnotation.getReferences()) {
			EObject eReference = context.getCreated(EObject.class, pivotReference);
			eAnnotation.getReferences().add(eReference);
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(Class pivotClass) {
		EClass eClass = context.getCreated(EClass.class, pivotClass);
		safeVisitAll(eClass.getEGenericSuperTypes(), eClass.getESuperTypes(), pivotClass.getSuperClasses());
		return eClass;
	}

	@Override
	public EObject visitDataType(DataType pivotDataType) {
		EDataType eDataType = context.getCreated(EDataType.class, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitOperation(Operation pivotOperation) {
		EOperation eOperation = context.getCreated(EOperation.class, pivotOperation);
		safeVisitAll(eOperation.getEGenericExceptions(), eOperation.getEExceptions(), pivotOperation.getRaisedExceptions());
		return super.visitOperation(pivotOperation);
	}

	@Override
	public EObject visitPackage(Package pivotPackage) {
		EPackage ePackage = context.getCreated(EPackage.class, pivotPackage);
		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = eFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		if (needsDelegates) {
		    EAnnotation packageAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
		    if (packageAnnotation == null) {
		    	packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    	packageAnnotation.setSource(EcorePackage.eNS_URI);
		    	ePackage.getEAnnotations().add(packageAnnotation);
		    }
		    EMap<String, String> details = packageAnnotation.getDetails();
			details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		    details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		    details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		}
		return null;
	}

	@Override
	public EObject visitProperty(Property pivotProperty) {
		EStructuralFeature eStructuralFeature = context.getCreated(EStructuralFeature.class, pivotProperty);
		if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference) eStructuralFeature;
			Property pivotOpposite = pivotProperty.getOpposite();
			if (pivotOpposite != null) {
				// FIXME Use EAnnotations for non-navigable opposites as identified by an Association
				EReference eOpposite = context.getCreated(EReference.class, pivotOpposite);
				if (eOpposite != null) {
					eReference.setEOpposite(eOpposite);
				}
			}
			for (Property pivotKey : pivotProperty.getKeys()) {
				EAttribute eAttribute = context.getCreated(EAttribute.class, pivotKey);
				if (eAttribute != null) {
					eReference.getEKeys().add(eAttribute);
				}
			}
		}
		return super.visitProperty(pivotProperty);
	}

	@Override
	public EObject visitTypeTemplateParameter(TypeTemplateParameter pivotTypeTemplateParameter) {
		ETypeParameter eTypeParameter = context.getCreated(ETypeParameter.class, pivotTypeTemplateParameter);
		for (Type constrainingType : pivotTypeTemplateParameter.getConstrainingTypes()) {
			EGenericType eGenericType = typeRefVisitor.resolveEGenericType(constrainingType);
			eTypeParameter.getEBounds().add(eGenericType);
		}
		return null;
	}

	@Override
	public EObject visitTypedElement(TypedElement pivotTypedElement) {
		ETypedElement eTypedElement = context.getCreated(ETypedElement.class, pivotTypedElement);
		Type pivotType = pivotTypedElement.getType();
		if (pivotType == null) {
			return null;				// Occurs for Operation return type
		}
		EObject eObject = typeRefVisitor.safeVisit(pivotType);
		if (eObject instanceof EGenericType) {
			eTypedElement.setEGenericType((EGenericType)eObject);
		}
		else if (eObject instanceof EClassifier) {
			eTypedElement.setEType((EClassifier)eObject);
		}
		else if (eObject instanceof ETypeParameter) {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			eGenericType.setETypeParameter((ETypeParameter)eObject);
//			for (Ex ex : pivotTypedElement.getCon)
			eTypedElement.setEGenericType(eGenericType);
		}
		else {
			logger.error("Unsupported pivot type '" + pivotType + "' in pass2");
		}
		return null;
	}
	
/*	@Override
	public Object caseEAnnotation(EAnnotation eAnnotation) {
		AnnotationCS csAnnotation = (AnnotationCS) deferMap.get(eAnnotation);
		for (ModelElementCSRef csReference : csAnnotation.getReferences()) {
			EObject eObject = createMap.get(csReference.getRef());
			if (eObject != null) {
				eAnnotation.getReferences().add(eObject);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEGenericType(EGenericType eGenericType) {
		TypedTypeRefCS csTypeRef = (TypedTypeRefCS) deferMap.get(eGenericType);
		TypeCS typeRef = csTypeRef.getType();
		if (typeRef != null) {
			EModelElement eType = (EModelElement) createMap.get(typeRef);
			if (eType == null) {
				eGenericType.setEClassifier((EClassifier) ((ModelElementCS)typeRef).getOriginalObject());
			}
			else if (eType instanceof EClassifier) {
				eGenericType.setEClassifier((EClassifier) eType);
			}
			else if (eType instanceof ETypeParameter) {
				eGenericType.setETypeParameter((ETypeParameter) eType);
			}
		}
		return null;
	} */

/*	@Override
	public Object caseEReference(EReference eReference) {
		OCLinEcoreReferenceCS csReference = (OCLinEcoreReferenceCS) deferMap.get(eReference);
		ReferenceCSRef csOpposite = csReference.getOpposite();
		if (csOpposite != null) {
			EReference eOpposite = (EReference) createMap.get(csOpposite.getRef());
			if (eOpposite != null) {
				eReference.setEOpposite(eOpposite);
			}
		}
		for (AttributeCSRef csKey : csReference.getKeys()) {
			EAttribute eAttribute = (EAttribute) createMap.get(csKey.getRef());
			if (eAttribute != null) {
				eReference.getEKeys().add(eAttribute);
			}
		}
		return null;
	} */

//	@Override
//	public Object caseETypeParameter(ETypeParameter eTypeParameter) {
//		TypeParameterCS csTypeParameter = (TypeParameterCS) deferMap.get(eTypeParameter);
/*			ClassifierRef classifierRef = csTypedElement.getType();
		if (classifierRef != null) {
			EClassifier eClassifier = resolveClassifierRef(classifierRef);
			if (eClassifier != null) {
				eTypedElement.setEType(eClassifier);
			}
		} */
//		return null;
//	}
	
}