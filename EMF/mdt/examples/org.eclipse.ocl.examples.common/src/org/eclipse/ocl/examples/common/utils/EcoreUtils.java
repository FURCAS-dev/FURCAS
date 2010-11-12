/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EcoreUtils.java,v 1.3 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;
import org.eclipse.ocl.examples.common.label.ILabelGenerator;
import org.eclipse.ocl.examples.common.label.LabelGeneratorRegistry;
import org.eclipse.ocl.utilities.UMLReflection;

public class EcoreUtils
{	
	/**
	 * The global SIMPLE_NAME_REGISTRY is used by simpleNameFor to generate simple names 
	 * for objects; typically the name property. The SIMPLE_NAME_REGISTRY delegates unsupported
	 * label generation to the global ILabelGenerator.Registry.INSTANCE.
	 */
	public static ILabelGenerator.Registry SIMPLE_NAME_REGISTRY = new LabelGeneratorRegistry(ILabelGenerator.Registry.INSTANCE);

	/**
	 * The global QUALIFIED_NAME_REGISTRY is used by qualifiedNameFor to generate qualified names 
	 * for objects; typically a :: separted hierarchical name.  The QUALIFIED_NAME_REGISTRY delegates unsupported
	 * label generation to the SIMPLE_NAME_REGISTRY.
	 */
	public static ILabelGenerator.Registry QUALIFIED_NAME_REGISTRY = new LabelGeneratorRegistry(SIMPLE_NAME_REGISTRY);

	static {
		/**
		 * Install an ENamedElement label generator that suppresses hierarchy.
		 */
		SIMPLE_NAME_REGISTRY.install(ENamedElement.class, new AbstractLabelGenerator<ENamedElement>(ENamedElement.class)
		{
			public void buildLabelFor(Builder labelBuilder, ENamedElement labelledObject) {
				String name = labelledObject.getName();
				if (name != null)
					labelBuilder.appendString(name);
				else {
					labelBuilder.appendString("<null-named-");
					labelBuilder.appendString(labelledObject.getClass().getSimpleName());
					labelBuilder.appendString(">");
				}
			}
		});
		
		/**
		 * Install an ENamedElement label generator that :: separates hierarchical names.
		 */
		QUALIFIED_NAME_REGISTRY.install(ENamedElement.class, new AbstractLabelGenerator<ENamedElement>(ENamedElement.class)
		{
			public void buildLabelFor(Builder labelBuilder, ENamedElement labelledObject) {
				EObject eContainer = labelledObject.eContainer();
				if (eContainer != null) {
					labelBuilder.getRegistry().buildSubLabelFor(labelBuilder, eContainer);
					labelBuilder.appendString("::");
				}
				String name = labelledObject.getName();
				if (name != null)
					labelBuilder.appendString(name);
				else {
					labelBuilder.appendString("<null-named-");
					labelBuilder.appendString(labelledObject.getClass().getSimpleName());
					labelBuilder.appendString(">");
				}
			}
		});
	}

	public static <E extends EObject> E copy(E newObject) {
		return EcoreUtil.copy(newObject);
	}

	/**
	 * Convert the map return from EcoreUtil.UnresolvedProxyCrossReferencer.find(xx)
	 * into a textual diagnosis.
	 * <br>
	 * Returns null if there are no unresolved URIs.
	 * <br>
	 * Returns a String containing a title line containing the contextURI and
	 * subsequent lines identifying each distinct unresolved URI. 
	 */
	public static String diagnoseUnresolvedProxies(URI contextURI, Map<EObject, Collection<EStructuralFeature.Setting>> map) {
	    if (map.isEmpty())
	    	return null;	    
    	Map<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> unresolvedURIs = new HashMap<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>>(map.size());
    	for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : map.entrySet()) {
    		EObject key = entry.getKey();
    		URI uri = EcoreUtil.getURI(key);
			if (uri != null) {
				String uriString = uri.toString();
				if (!unresolvedURIs.containsKey(uriString))
					unresolvedURIs.put(uriString, entry);
			}
    	}
    	StringBuffer s = new StringBuffer();
		s.append("Unresolved URIs in '" + String.valueOf(contextURI) + "' :");
    	for (Map.Entry<String, Map.Entry<EObject, Collection<EStructuralFeature.Setting>>> unresolvedURI : unresolvedURIs.entrySet())
 			s.append("\n    '" + unresolvedURI.getKey() + "'");
    	return s.toString();
	}

	public static String formatMultiplicity(ETypedElement typedElement) {
		if (typedElement == null)
			return "";
		int lower = typedElement.getLowerBound();
		int upper = typedElement.getUpperBound();
		if (lower == upper)
			return Integer.toString(lower);
		else if (lower == 0) {
			if (upper < 0)
				return "*";
			else if (upper == 1)
				return "?";
		}
		else if (lower == 1) {
			if (upper < 0)
				return "+";
		}
		return Integer.toString(lower) + ".." + (upper >= 0 ? Integer.toString(upper) : "*");
	}

	public static String formatOrdered(ETypedElement typedElement) {
		boolean isOrdered = typedElement != null ? (typedElement.isOrdered() && typedElement.isMany()) : false;
		return isOrdered ? "{ordered}" : "";
	}

	public static String formatString(String name) {
		return name != null ? name : "<null>";
	}

	public static String formatUnique(ETypedElement typedElement) {
		boolean isOrdered = typedElement != null ? (typedElement.isUnique() && typedElement.isMany()) : false;
		return isOrdered ? "{unique}" : "";
	}
	
	public static <T extends Adapter> T getAdapter(Notifier notifier, Class<T> adapterClass) {
		if (notifier == null)
			return null;
		return getAdapter(notifier.eAdapters(), adapterClass);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Adapter> T getAdapter(List<Adapter> eAdapters, Class<T> adapterClass) {
		return (T) EcoreUtil.getAdapter(eAdapters, adapterClass);
	}

	/**
	 * Return the specialised value of feature.getEType() resolving any type parameters
	 * from the specialised type of the sourceObject of the feature.
	 * 
	 * @param sourceObject
	 * @param feature
	 * @return
	 */
	public static EClassifier getEType(EObject sourceObject, EStructuralFeature feature) {
		EGenericType targetGenericType = feature.getEGenericType();
		ETypeParameter targetTypeParameter = targetGenericType.getETypeParameter();
		if ((targetTypeParameter != null) && (sourceObject != null)) {
			EClass sourceGenericType = feature.getEContainingClass();
			EObject typeParameterContainer = targetTypeParameter.eContainer();
			EClass sourceClass = sourceObject.eClass();
			EList<EGenericType> allSourceGenericSuperTypes = sourceClass.getEAllGenericSuperTypes();
			for (EGenericType sourceGenericSuperType : allSourceGenericSuperTypes) {
				if (sourceGenericSuperType.getERawType() == typeParameterContainer) {
					EList<EGenericType> sourceTypeArguments = sourceGenericSuperType.getETypeArguments();
					int i = sourceGenericType.getETypeParameters().indexOf(targetTypeParameter);
					if ((0 <= i) && (i < sourceTypeArguments.size())) {
						EGenericType sourceTypeArgument = sourceTypeArguments.get(i);
						return sourceTypeArgument.getERawType();
					}
				}
			}
		}
		return targetGenericType.getERawType();
	}

	/**
	 * Return the Ecore EStringToStringMapEntry that realises a given Constraint.
	 * 
	 * @param constraint the constraint
	 * @return the annotation detail entry, null if not found
	 */
	public static Map.Entry<String, String> getEAnnotationDetail(Constraint constraint) {
		List<EModelElement> constrainedElements = constraint.getConstrainedElements();
		if (constrainedElements.isEmpty()) {
			return null;
		}
		EModelElement constrainedElement = constrainedElements.get(0);
		String keyName;
		String stereotype = constraint.getStereotype();
		if (UMLReflection.INVARIANT.equals(stereotype)) {
			keyName = constraint.getName();
			if (constrainedElement instanceof EClass) {
				EOperation apiOperation = EcoreUtils.getEcoreInvariant((EClass) constrainedElement, keyName);
				if (apiOperation != null) {
					constrainedElement = apiOperation;
					keyName = InvocationBehavior.BODY_CONSTRAINT_KEY;
				}
			}
		}
		else if (UMLReflection.DERIVATION.equals(stereotype)){
			keyName = SettingBehavior.DERIVATION_CONSTRAINT_KEY;
		}
		else if (UMLReflection.INITIAL.equals(stereotype)){
			keyName = SettingBehavior.INITIAL_CONSTRAINT_KEY;
		}
		else if (UMLReflection.BODY.equals(stereotype)){
			keyName = InvocationBehavior.BODY_CONSTRAINT_KEY;
		}
//			else if (UMLReflection.PRECONDITION.equals(stereotype)){
//				node = InvocationBehavior.PRECONDITION_CONSTRAINT_KEY;
//			}
//			else if (UMLReflection.POSTCONDITION.equals(stereotype)){
//				node = InvocationBehavior.POSTCONDITION_CONSTRAINT_KEY;
//			}
		else {
			keyName = null;
		}
	    EAnnotation eAnnotation = constrainedElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
	    if (eAnnotation == null) {
	    	return null;
	    }
	    EMap<String, String> details = eAnnotation.getDetails();
	    if (keyName != null) {
	    	int indexOfKey = details.indexOfKey(keyName);
		    if (indexOfKey >= 0) { 
		    	return details.get(indexOfKey);
		    }
	    }
		return null;
	}

	/**
	 * Return the EOperation that realises the name invariant for eClass.
	 * @param eClass with invariant
	 * @param name of invariant
	 * @return the EOperation or null
	 */
	public static EOperation getEcoreInvariant(EClass eClass, String name) {
		for (EOperation eOperation : eClass.getEOperations()) {
			if (ClassUtils.equals(name, eOperation.getName()) && EcoreUtil.isInvariant(eOperation)) {
				return eOperation;
			}
		}
		return null;
	}

	public static <T> int getFeatureID(Notification notification, T expectedNotifier, Class<T> featureClass) {
		if (expectedNotifier == null)
			return Notification.NO_FEATURE_ID;
		Object notifier = notification.getNotifier();
		if (notifier != expectedNotifier)
			return Notification.NO_FEATURE_ID;
		T castNotifier = ClassUtils.asClassOrNull(notifier, featureClass);
		if (castNotifier == null)
			throw new IllegalArgumentException("EcoreUtils.getFeatureID: " + featureClass.getName() + " for a " + notifier.getClass().getName());
		return notification.getFeatureID(featureClass);
	}

	public static <T extends ENamedElement> T getNamedElement(Collection<T> elements, String name) {
		if (elements == null)
			return null;
		for (T element : elements)
			if (ClassUtils.equals(name, element.getName()))
				return element;
		return null;				
	}

	@SuppressWarnings("unchecked")
	public static <T extends ENamedElement, R extends T> R getNamedElement(Collection<T> elements, String name, Class<R> returnClass) {
		if (elements == null)
			return null;
		if (name == null)
			return null;
		if (returnClass == null)
			return null;
		for (T element : elements)
			if (returnClass.isAssignableFrom(element.getClass()) && ClassUtils.equals(name, element.getName()))
				return (R) element;
		return null;				
	}
	
	/**
	 * Return a qualified name for object using the label generators registered
	 * in the QUALIFIED_NAME_REGISTRY.
	 * 
	 * @param object to be named
	 * @return qualified name
	 */
	public static String qualifiedNameFor(Object object) {
		return QUALIFIED_NAME_REGISTRY.labelFor(object);
	}

	/**
	 * Return a simple name for object using the label generators registered
	 * in the SIMPLE_NAME_REGISTRY.
	 * 
	 * @param object to be named
	 * @return simple name
	 */
	public static String simpleNameFor(Object object) {
		return SIMPLE_NAME_REGISTRY.labelFor(object);
	}
}
