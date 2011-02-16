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
 * $Id: Ecore2Pivot.java,v 1.4 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Ecore2Pivot extends AbstractConversion implements Adapter, PivotConstants
{
	private static final Logger logger = Logger.getLogger(Ecore2Pivot.class);

	public static Ecore2Pivot findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return PivotUtil.getAdapter(Ecore2Pivot.class, resource);
	}

	public static Ecore2Pivot getAdapter(Resource resource, TypeManager typeManager) {
		if (resource == null) {
			return null;
		}
		List<Adapter> eAdapters = resource.eAdapters();
		Ecore2Pivot adapter = PivotUtil.getAdapter(Ecore2Pivot.class, resource);
		if (adapter != null) {
			return adapter;
		}
		adapter = new Ecore2Pivot(resource, typeManager);
		eAdapters.add(adapter);
		return adapter;
	}

	/**
	 * Convert an (annotated) Ecore resource to a Pivot Model.
	 * @param alias 
	 * 
	 * @param ecoreResource the annotated Ecore resource
	 * 
	 * @return the Pivot root package
	 */
	public static org.eclipse.ocl.examples.pivot.Package importFromEcore(TypeManager typeManager, String alias, Resource ecoreResource) {
		if (ecoreResource == null) {
			return null;
		}
		Ecore2Pivot conversion = getAdapter(ecoreResource, typeManager);
		return conversion.getPivotRoot();
	}

/*	public static Ecore2Pivot createConverter(TypeManager typeManager, Resource ecoreResource) {
		EList<Adapter> eAdapters = ecoreResource.eAdapters();
		Ecore2Pivot conversion = (Ecore2Pivot) EcoreUtil.getAdapter(eAdapters, Ecore2Pivot.class);
		if (conversion == null) {
			conversion = new Ecore2Pivot(typeManager);
			eAdapters.add(conversion);
		}
		return conversion;
	} */

	/**
	 * Convert an (annotated) Ecore object to a pivot element. 
	 * 
	 * @param eObject the annotated Ecore object
	 * 
	 * @return the pivot element
	 */
	public static Element importFromEcore(TypeManager typeManager, String alias, EObject eObject) {
		if (eObject == null) {
			return null;
		}
		Resource ecoreResource = eObject.eResource();
		Ecore2Pivot conversion = getAdapter(ecoreResource, typeManager);
		org.eclipse.ocl.examples.pivot.Package pivotRoot = conversion.getPivotRoot();
		if (pivotRoot == null) {
			return null;
		}
		return conversion.createMap.get(eObject);
	}

	/**
	 * Mapping of source Ecore objects to their resulting pivot element.
	 */
	private Map<EObject, Element> createMap = new HashMap<EObject, Element>();

	/**
	 * Set of all Ecore objects requiring further work during the reference pass.
	 */
	private Set<EObject> referencers = new HashSet<EObject>();
	
	/**
	 * Set of all converters used during session.
	 */
	private Set<Ecore2Pivot> allConverters = new HashSet<Ecore2Pivot>();
	
	/**
	 * List of all generic types.
	 */
	private List<EGenericType> genericTypes = new ArrayList<EGenericType>();
	
	/**
	 * List of all specializations for each specializable type.
	 */
	private Map<TemplateableElement, List<TemplateableElement>> specializations = new HashMap<TemplateableElement, List<TemplateableElement>>();
	
	private List<Resource.Diagnostic> errors = null;
	
	protected final TypeManager typeManager;
	protected final Resource ecoreResource;					// Set via eAdapters.add()
	
	protected org.eclipse.ocl.examples.pivot.Package pivotRoot = null;	// Set by importResource
	protected final Ecore2PivotDeclarationSwitch declarationPass = new Ecore2PivotDeclarationSwitch(this);	
	protected final Ecore2PivotReferenceSwitch referencePass = new Ecore2PivotReferenceSwitch(this);
	private HashMap<EClassifier, Type> ecore2PivotMap = null;
	
//	private Map<String, MonikeredElement> moniker2PivotMap = null;
	
	public Ecore2Pivot(Resource ecoreResource, TypeManager typeManager) {
		this.ecoreResource = ecoreResource;
		this.typeManager = typeManager;
	}
	
	public void addCreated(EObject eObject, Element pivotElement) {
		if (eObject instanceof EClassifier) {
			Type pivotType = getEcore2PivotMap().get(eObject);
			if (pivotType != null) {
				pivotElement = pivotType;
			}
		}
		createMap.put(eObject, pivotElement);
	}

	public void addGenericType(EGenericType eObject) {
		genericTypes.add(eObject);
	}

	public Map<String, MonikeredElement> computeMoniker2PivotMap() {
		Map<String, MonikeredElement> map = new HashMap<String, MonikeredElement>();
		for (Iterator<EObject> it = ecoreResource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			if (eObject instanceof EModelElement) {
				Element pElement = createMap.get(eObject);
				if (pElement instanceof MonikeredElement) {
					String moniker = ((MonikeredElement)pElement).getMoniker();
					MonikeredElement oldElement = map.get(moniker);
					if (oldElement != null) {
						logger.warn("Duplicate moniker " + moniker + " for " + pElement.eClass().getName());
					}
					map.put(moniker, (MonikeredElement)pElement);
				}
			}
		}
		return map;
	}	

	protected void error(String message) {
		if (errors == null) {
			errors = new ArrayList<Resource.Diagnostic>();
		}
		errors.add(new XMIException(message));
	}

	public <T extends Element> T getCreated(Class<T> requiredClass, EObject eObject) {
		if (pivotRoot == null) {
			getPivotRoot();
		}
		Element element = createMap.get(eObject);
		if (element == null) {
			return null;
		}
		if (!requiredClass.isAssignableFrom(element.getClass())) {
			logger.error("Ecore " + element.getClass().getName() + "' element is not a '" + requiredClass.getName() + "'"); //$NON-NLS-1$
			return null;
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) element;
		return castElement;
	}

	public Map<EClassifier, Type> getEcore2PivotMap() {
		if (ecore2PivotMap == null) {
			ecore2PivotMap = new HashMap<EClassifier, Type>();
			initializeEcore2PivotMap();
		}
		return ecore2PivotMap;
	}

/*	public MonikeredElement getMoniker(String moniker) {
		if (moniker2PivotMap == null) {
			moniker2PivotMap = computeMoniker2PivotMap();
		}
		return moniker2PivotMap.get(moniker);
	}
	
	public Map<String, MonikeredElement> getMoniker2PivotMap() {
		if (moniker2PivotMap == null) {
			moniker2PivotMap = computeMoniker2PivotMap();
		}
		return moniker2PivotMap;
	} */
	
	public Type getPivotType(EObject eObject) {
		Element pivotElement = createMap.get(eObject);
		if (pivotElement == null) {
			Resource resource = eObject.eResource();
			if ((resource != ecoreResource) && (resource != null)) {
				Ecore2Pivot converter = getAdapter(resource, typeManager);
				if (allConverters.add(converter)) {
					converter.getPivotRoot();
//					allEClassifiers.addAll(converter.allEClassifiers);
//					allNames.addAll(converter.allNames);
					for (Map.Entry<EObject, Element> entry : converter.createMap.entrySet()) {
						createMap.put(entry.getKey(), entry.getValue());
					}
				}
			}
			pivotElement = createMap.get(eObject);
		}
		if (pivotElement == null) {
			error("Unresolved " + eObject);
		}
		else if (!(pivotElement instanceof Type)) {
			error("Incompatible " + eObject);
		}
		else {
			return (Type) pivotElement;
		}
		return null;
	}
	
/*	public Collection<EPackage> getReferencedEPackages() {
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EClassifier eClassifier : allEClassifiers) {
			EPackage ePackage = eClassifier.getEPackage();
			if (ePackage != null)
				ePackages.add(ePackage);
		}
		return ePackages;
	} */
	
	public org.eclipse.ocl.examples.pivot.Package getPivotRoot() {
		if (pivotRoot == null) {
			EcoreAliasCreator.refreshPackageAliases(ecoreResource);			
			Resource pivotResource = importObjects(ecoreResource.getContents(), ecoreResource.getURI());
			AliasAdapter ecoreAdapter = AliasAdapter.findAdapter(ecoreResource);
			if (ecoreAdapter != null) {
				Map<EObject, String> ecoreAliasMap = ecoreAdapter.getAliasMap();
				AliasAdapter pivotAdapter = AliasAdapter.getAdapter(pivotResource);
				Map<EObject, String> pivotAliasMap = pivotAdapter.getAliasMap();
				for (EObject eObject : ecoreAliasMap.keySet()) {
					String alias = ecoreAliasMap.get(eObject);
					Element element = createMap.get(eObject);
					pivotAliasMap.put(element, alias);
				}
			}
		}
		return pivotRoot;
	}

	public Notifier getTarget() {
		return ecoreResource;
	}

	public TypeManager getTypeManager() {
		return typeManager;
	}

	public Resource importObjects(Collection<EObject> ecoreContents, URI ecoreURI) {
		Resource pivotResource = typeManager.createResource(ecoreURI, PivotPackage.eCONTENT_TYPE);
		pivotRoot = PivotFactory.eINSTANCE.createPackage();
		pivotRoot.setName(ecoreURI.lastSegment());
		pivotResource.getContents().add(pivotRoot);
		List<org.eclipse.ocl.examples.pivot.Package> packages = pivotRoot.getNestedPackages();
		for (EObject eObject : ecoreContents) {
			Object pivotElement = declarationPass.doInPackageSwitch(eObject);
			if (pivotElement instanceof org.eclipse.ocl.examples.pivot.Package) {
				packages.add((org.eclipse.ocl.examples.pivot.Package) pivotElement);
			}
			else {
				error("Bad ecore content");
			}
		}
		Map<String, Type> resolvedSpecializations = new HashMap<String, Type>();
		for (EGenericType eGenericType : genericTypes) {
			Type pivotType = resolveType(resolvedSpecializations, eGenericType);
			createMap.put(eGenericType, pivotType);
		}
		for (List<TemplateableElement> pivotElements : specializations.values()) {
			for (TemplateableElement pivotElement : pivotElements) {
				typeManager.addOrphanType((Type)pivotElement);
			}
		}
		for (EObject eObject : referencers) {
			referencePass.doInPackageSwitch(eObject);
		}
		if (errors != null) {
			pivotResource.getErrors().addAll(errors);
		}
		return pivotResource;
	}

	public void initializeEcore2PivotMap() {
		ecore2PivotMap.put(EcorePackage.Literals.EBOOLEAN, typeManager.getBooleanType());
		ecore2PivotMap.put(EcorePackage.Literals.EBIG_INTEGER, typeManager.getIntegerType());
		ecore2PivotMap.put(EcorePackage.Literals.EBIG_DECIMAL, typeManager.getRealType());
		ecore2PivotMap.put(EcorePackage.Literals.ESTRING, typeManager.getStringType());
	}

	public boolean isAdapterForType(Object type) {
		return type == Ecore2Pivot.class;
	}

	public void notifyChanged(Notification notification) {}

	public void queueReference(EModelElement eObject) {
		referencers.add(eObject);
	}

/*	protected void refreshAnnotation(NamedElement pivotElement, String key, String value) {
		String source = PIVOT_URI;
		Annotation pivotAnnotation = null;
		for (Annotation annotation : pivotElement.getOwnedAnnotations()) {
			if (annotation.getName().equals(source)) {
				pivotAnnotation = annotation;
				break;
			}
		}
		if (pivotAnnotation == null) {
			pivotAnnotation = PivotFactory.eINSTANCE.createAnnotation();
			pivotAnnotation.setName(source);
			pivotElement.getOwnedAnnotations().add(pivotAnnotation);
		}
		Detail pivotDetail = PivotFactory.eINSTANCE.createDetail();
		pivotDetail.setName(key);
		pivotDetail.getValues().add(value);
		pivotAnnotation.getOwnedDetails().add(pivotDetail);
	} */

	protected <T extends NamedElement> T refreshNamedElement(Class<T> pivotClass,
			EClass pivotEClass, ENamedElement eNamedElement) {
		EFactory eFactoryInstance = pivotEClass.getEPackage().getEFactoryInstance();
		EObject pivotElement = eFactoryInstance.create(pivotEClass);
		if (!pivotClass.isAssignableFrom(pivotElement.getClass())) {
			throw new ClassCastException();
		}
		@SuppressWarnings("unchecked")
		T castElement = (T) pivotElement;
		return castElement;
	}
	
	protected Type resolveDataType(EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		EDataType eClassifier = (EDataType) eGenericType.getEClassifier();
		Type pivotType = getEcore2PivotMap().get(eClassifier);
//		if (eClassifier.getEPackage() == EcorePackage.eINSTANCE) {
//			pivotType = getEcore2PivotMap().get(eClassifier);
//			if (primitiveTypeName != null) {
//				PrimitiveTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createPrimitiveTypeRefCS();
//				csTypeRef.setName(primitiveTypeName);
//				setOriginalMapping(csTypeRef, eObject);
//				return csTypeRef;
//			}
//		}
		if (pivotType == null) {
			pivotType = getPivotType(eClassifier);
		}
		return pivotType;
	}

	protected Type resolveGenericType(Map<String, Type> resolvedSpecializations, EGenericType eGenericType) {
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert !eGenericType.getETypeArguments().isEmpty();
		EClassifier eClassifier = eGenericType.getEClassifier();
		List<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
		assert eTypeParameters.size() == eTypeArguments.size();
		Type specializedPivotElement;
		Type unspecializedPivotType = getPivotType(eClassifier);
		if (unspecializedPivotType instanceof DataType) {
			specializedPivotElement = refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, null);
		}
		else {
			specializedPivotElement = refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, null);
		}
		specializedPivotElement.setName(unspecializedPivotType.getName());
		TemplateBinding templateBinding = PivotFactory.eINSTANCE.createTemplateBinding();
		TemplateSignature templateSignature = unspecializedPivotType.getOwnedTemplateSignature();
		templateBinding.setSignature(templateSignature);
		specializedPivotElement.getTemplateBindings().add(templateBinding);
		for (int i = 0; i < eTypeParameters.size(); i++) {
			TemplateParameterSubstitution templateParameterSubstitution = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
			templateParameterSubstitution.setFormal(templateSignature.getParameters().get(i));
			EGenericType eTypeArgument = eTypeArguments.get(i);
			Type typeArgument = resolveType(resolvedSpecializations, eTypeArgument);
			if (typeArgument.eContainer() == null) {
				templateParameterSubstitution.setOwnedActual(typeArgument);
			}
			else {
				templateParameterSubstitution.setActual(typeArgument);
			}
			templateBinding.getParameterSubstitutions().add(templateParameterSubstitution);
		}
		//
		//	Cache the pivot specialization
		//
		List<TemplateableElement> specializationList = specializations.get(unspecializedPivotType);
		if (specializationList == null) {
			specializationList = new ArrayList<TemplateableElement>();
			specializations.put(unspecializedPivotType, specializationList);
		}
		specializationList.add(specializedPivotElement);
		return specializedPivotElement;
	}

	protected Type resolveSimpleType(EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		EClassifier eClassifier = eGenericType.getEClassifier();
		Type pivotType = getPivotType(eClassifier);
		if (eClassifier != null) {
/*			TypedTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
			setOriginalMapping(csTypeRef, eObject);
			deferred.add(csTypeRef);		// defer eGenericType.getETypeParameter()
//			doSwitchAll(csTypeRef.getTypeArguments(), eGenericType.getETypeArguments());
			return csTypeRef;
		}
		else {
			ETypeParameter eTypeParameter = eObject.getETypeParameter();
			if (eTypeParameter != null) {
				TypedTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
				setOriginalMapping(csTypeRef, eObject);
				deferred.add(csTypeRef);		// defer eGenericType.getETypeParameter()
				return csTypeRef;				
			}
			else {
				WildcardTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createWildcardTypeRefCS();
				setOriginalMapping(csTypeRef, eObject);
//				csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//				csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
				return csTypeRef;
			}*/
		}
		return pivotType;
	}

	protected Type resolveType(Map<String, Type> resolvedSpecializations, EGenericType eGenericType) {
		Type pivotType = getCreated(Type.class, eGenericType);
		if (pivotType != null) {
			return pivotType;
		}
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		if (eTypeParameter != null) {
			pivotType = resolveTypeParameter(eGenericType);
		}
		else if (eClassifier == null) {
			pivotType = resolveWildcardType(eGenericType);
		}
		else if (!eTypeArguments.isEmpty()) {
			String ecoreMoniker = Ecore2Moniker.toString(eGenericType);
			pivotType = resolvedSpecializations.get(ecoreMoniker);
			if (pivotType == null) {
				pivotType = resolveGenericType(resolvedSpecializations, eGenericType);
				resolvedSpecializations.put(ecoreMoniker, pivotType);
			}
		}
		else if (eClassifier instanceof EDataType) {
			pivotType = resolveDataType(eGenericType);
		}
		else { 
			pivotType = resolveSimpleType(eGenericType);
		}
		createMap.put(eGenericType, pivotType);
		return pivotType;
	}

	protected Type resolveTypeParameter(EGenericType eGenericType) {
		EClassifier eClassifier = eGenericType.getEClassifier();
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		List<EGenericType> eTypeArguments = eGenericType.getETypeArguments();
		assert eClassifier == null;
		assert eTypeArguments.isEmpty();
		Type pivotType = getCreated(Type.class, eTypeParameter);
		return pivotType;
	}

	protected Type resolveWildcardType(EGenericType eGenericType) {
		assert eGenericType.getETypeArguments().isEmpty();
		assert eGenericType.getEClassifier() == null;
		EClassifier eClassifier = eGenericType.getERawType();
		assert eClassifier == EcorePackage.Literals.EJAVA_OBJECT;
/*			WildcardTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createWildcardTypeRefCS();
			setOriginalMapping(csTypeRef, eObject);
//			csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//			csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
			return csTypeRef; */
		org.eclipse.ocl.examples.pivot.Class pivotElement = PivotFactory.eINSTANCE.createClass();
		String name = PivotConstants.WILDCARD_NAME;
		EStructuralFeature eFeature = eGenericType.eContainmentFeature();
		if ((eFeature != null) && eFeature.isMany()) {
			EObject eContainer = eGenericType.eContainer();
			List<?> list = (List<?>)eContainer.eGet(eGenericType.eContainingFeature());
			int index = list.indexOf(eGenericType);
			if (index != 0) {
				name += index;
			}
		}
		pivotElement.setName(name);		
		return pivotElement;
	}

	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || (newTarget == ecoreResource);
	}
}