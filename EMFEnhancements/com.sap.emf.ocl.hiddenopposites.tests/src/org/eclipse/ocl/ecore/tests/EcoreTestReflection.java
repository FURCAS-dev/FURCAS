/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 254919, 296409
 *
 * </copyright>
 *
 * $Id: EcoreTestReflection.java,v 1.3 2010/04/25 06:50:15 ewillink Exp $
 */
package org.eclipse.ocl.ecore.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.tests.TestReflection;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;

@SuppressWarnings("nls")
public class EcoreTestReflection extends UMLReflectionImpl implements TestReflection<
EObject, EPackage,
EClassifier, EClassifier, EClass, EDataType, EClassifier, EEnum,
EOperation, EParameter, EStructuralFeature, EAttribute, EReference,
EEnumLiteral, EObject, CallOperationAction, SendSignalAction, Constraint>,
TestReflection.Static<
EObject, EPackage,
EClassifier, EClassifier, EClass, EDataType, EClassifier, EEnum,
EOperation, EParameter, EStructuralFeature, EAttribute, EReference,
EEnumLiteral, EObject, CallOperationAction, SendSignalAction, Constraint>
{
	public static final EcoreTestReflection INSTANCE = new EcoreTestReflection();
	public static final String PLUGIN_ID = "com.sap.emf.ocl.hiddenopposites.tests";

	public static OCL createOCL() {
		OCL newInstance = OCLWithHiddenOpposites.newInstance();
		String repairs = System.getProperty(PLUGIN_ID + ".repairs");
		if (repairs != null)
			newInstance.setParserRepairCount(Integer.parseInt(repairs));
		return newInstance;
	}
	
	/**
	 * Map of %Key to value for denormalizing OCL test code.
	 */
	private Map<String, String> normalizers = null;

	public void addSupertype(EClass aClass, EClass superClass) {
		aClass.getESuperTypes().add(superClass);
	}

	public EClass createClass() {
		return EcoreFactory.eINSTANCE.createEClass();
	}

	public EAnnotation createComment() {
		return EcoreFactory.eINSTANCE.createEAnnotation();
	}

	public void createGeneralization(EClassifier special, EClassifier general) {
		if ((special instanceof EClass) && (general instanceof EClass))
			((EClass)special).getESuperTypes().add((EClass)general);
	}

	public EPackage createNestedPackage(EPackage aPackage, String name) {
		EPackage nestedPackage = EcoreFactory.eINSTANCE.createEPackage();
		nestedPackage.setName(name);
		aPackage.getESubpackages().add(nestedPackage);
		return nestedPackage;
	}

	public OCL createOCL(ResourceSet resourceSet) {
		return OCLWithHiddenOpposites.newInstance(new EcoreEnvironmentFactoryWithHiddenOpposites(resourceSet.getPackageRegistry()));
	}

	public EAttribute createOwnedAttribute(EClass aClass, String name, EClassifier type) {
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute.setName(name);
		eAttribute.setEType(type);
		aClass.getEStructuralFeatures().add(eAttribute);
		return eAttribute;
	}

	public EClass createOwnedClass(EPackage aPackage, String name, boolean isAbstract) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.setAbstract(isAbstract);
		aPackage.getEClassifiers().add(eClass);
		return eClass;
	}

	public EEnum createOwnedEnumeration(EPackage aPackage, String name) {
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		eEnum.setName(name);
		aPackage.getEClassifiers().add(eEnum);
		return eEnum;
	}

	public EEnumLiteral createOwnedLiteral(EEnum anEnumeration, String name) {
		EEnumLiteral eLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		eLiteral.setName(name);
		anEnumeration.getELiterals().add(eLiteral);
		return eLiteral;
	}

	public EOperation createOwnedOperation(EClass aClass, String name, EList<String> paramNames, EList<EClassifier> paramTypes, EClassifier type, boolean isQuery) {
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		eOperation.setName(name);
		eOperation.setEType(type);
		if (paramNames != null) {
			for (int i = 0; i < paramNames.size(); i++) {
				createOwnedParameter(eOperation, paramNames.get(i), paramTypes.get(i));
			}
		}
		aClass.getEOperations().add(eOperation);
		return eOperation;
	}

	public EParameter createOwnedParameter(EOperation eOperation, String name, EClassifier type) {
		EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		eParameter.setName(name);
		eParameter.setEType(type);
		eOperation.getEParameters().add(eParameter);
		return eParameter;
	}

	public EOperation createOwnedPrimitiveOperation(EClassifier aPrimitiveType, String name, EList<String> paramNames, EList<EClassifier> paramTypes, EClassifier type, boolean isQuery) {
		return createOwnedOperation((EClass) aPrimitiveType, name, paramNames, paramTypes, type, isQuery);
	}

	public EClass createOwnedPrimitiveType(EPackage aPackage, String name) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		aPackage.getEClassifiers().add(eClass);
		return eClass;
	}

	public EReference createOwnedReference(EClass aClass, String name, EClass type) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName(name);
		eReference.setEType(type);
		aClass.getEStructuralFeatures().add(eReference);
		return eReference;
	}

	public EPackage createPackage(String name) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(name);
		return ePackage;
	}

	public TestReflection<EObject, EPackage, EClassifier, EClassifier, EClass, EDataType, EClassifier, EEnum, EOperation, EParameter, EStructuralFeature, EAttribute, EReference, EEnumLiteral, EObject, CallOperationAction, SendSignalAction, Constraint> createReflection(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
		return this;
	}

	public String denormalize(String key) {
		if (normalizers == null) {
			normalizers = new HashMap<String, String>();
			normalizers.put("Date", "EDate");
			normalizers.put("Package", "EPackage");
			normalizers.put("Reference", "EReference");
			normalizers.put("String", "EString");
			normalizers.put("Type", "EClassifier");
			normalizers.put("container", "eContainer");
			normalizers.put("nestedPackage", "eSubpackages");
			normalizers.put("nestingPackage", "eSuperPackage");
			normalizers.put("opposite", "eOpposite");
			normalizers.put("ownedType", "eClassifiers");
			normalizers.put("uml", "ecore");
		}
		return normalizers.get(key);
	}
	
	public void disposeResourceSet(ResourceSet resourceSet) {
        if (resourceSet != null) {
        
            // unload and remove all resources but the UML Metamodel.
            // Don't clear the resource set's adapter-list
            
            for (Resource res : resourceSet.getResources()) {
                    res.unload();
                    res.eAdapters().clear();
            }
        }
        
//        fruitPackage = null;
	}

	public EStructuralFeature getAttribute(EClassifier classifier, String name, EClassifier type) {
		if (!(classifier instanceof EClass))
			return null;
		EStructuralFeature feature = ((EClass)classifier).getEStructuralFeature(name);
		if (feature == null)
			return null;
		// check type
		return feature;
	}

	public EClassifier getBigDecimal() {
		return EcorePackage.Literals.EBIG_DECIMAL;
	}

	public EClassifier getBigInteger() {
		return EcorePackage.Literals.EBIG_INTEGER;
	}
	
	public OCLExpression<EClassifier> getBodyExpression(Constraint constraint) {
		return constraint.getSpecification().getBodyExpression();
	}

	public EClassifier getClassTypeContext() {
		return EcorePackage.Literals.ECLASS;
	}

	public EClassifier getClassifierTypeContext() {
		return EcorePackage.Literals.ECLASSIFIER;
	}

	public EClassifier getCollectionKindTypeContext() {
		return ExpressionsPackage.Literals.COLLECTION_KIND;
	}

	public EClassifier getCommentTypeContext() {
		return EcorePackage.Literals.EANNOTATION;
	}
	
	public java.lang.Class<Constraint> getConstraintClass() {
		return Constraint.class;
	}

	public EClassifier getDefaultSetType(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> environment) {
		return EcorePackage.Literals.ERESOURCE;
	}

	public EPackage getEPackage(EPackage pkg) {
		return pkg;
	}
	
	public EClassifier getEcoreBigDecimal() {
		return EcorePackage.Literals.EBIG_DECIMAL;
	}
	
	public EClassifier getEcoreBigInteger() {
		return EcorePackage.Literals.EBIG_INTEGER;
	}
	
	public EClassifier getEcoreLong() {
		return EcorePackage.Literals.ELONG;
	}

	public EPackage getEcorePrimitiveTypes() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getEcorePrimitiveTypes");
	}

	public String getFruitModelPath() {
		return "/model/OCLTest.ecore";
	}
    
	public EClassifier getMetaclass(String name) {
	    return EcorePackage.eINSTANCE.getEClassifier(name);
    }
	
	public String getNsURI(EPackage aPackage) {
		return aPackage.getNsURI();
	}

	public EPackage getOCLExpressionTypes() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getOCLExpressionTypes");
	}

	public EClassifier getOwner(EOperation context) {
		return context.getEContainingClass();
	}

	public EPackage getResourcePackage(ResourceSet resourceSet, URI uri) {
		Resource res = resourceSet.getResource(uri, true);		
		return (EPackage) res.getContents().get(0);
	}

	public EClassifier getStringTypeContext() {
		return EcorePackage.Literals.ESTRING;
	}

	public String getTestPlugInId() {
		return PLUGIN_ID;
	}
	
	public EDataType getUMLBoolean() {
		return EcorePackage.Literals.EBOOLEAN;
	}

	public EClassifier getUMLInteger() {
		return EcorePackage.Literals.EINT;
	}

	public EClassifier getUMLLong() {
		return EcorePackage.Literals.ELONG;
	}

	public EPackage getUMLMetamodel() {	// FIXME UOE
		return EcorePackage.eINSTANCE;
	}

	public EPackage getUMLPrimitiveTypes() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getUMLPrimitiveTypes");
	}
	
	public EDataType getUMLString() {
		return EcorePackage.Literals.ESTRING;
	}

	public EDataType getUMLUnlimitedNatural() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getUnlimitedNatural");
	}

	public int getUnlimitedValue() {
		return -1;			// FIXME find symbolic value
	}

/*	public Map<URI, URI> initRegistries() {
		if (uriMap != null)
			return uriMap;
		uriMap = URIMappingRegistryImpl.INSTANCE.map();		
		URI oclStandardLibraryURI = URI.createURI(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI);
		if (uriMap.get(oclStandardLibraryURI) == null) {			// If no mapping registered then must set up standalone context
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"ecore", new EcoreResourceFactoryImpl());
			Environment.Registry.INSTANCE.registerEnvironment(
					new EcoreEnvironmentFactory().createEnvironment());
			String oclLocation = System.getProperty("org.eclipse.ocl.ecore");
			if (oclLocation == null)
				AbstractTestSuite.fail("'org.eclipse.ocl.ecore' property not defined; use the launch configuration to define it");
			oclLocation = "file:/" + oclLocation;
			uriMap.put(URI.createURI(EcoreEnvironment.OCL_STANDARD_LIBRARY_NS_URI), URI.createURI(oclLocation + "/model/oclstdlib.ecore"));
		}
		return uriMap;
	} */
	
	public ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		return resourceSet;
	}

	public boolean isOrdered(String key) {
		if ("nestedPackage".equals(key)) {
			return true;
		}
		return false;
	}

	public boolean isUnique(String key) {
		if ("nestedPackage".equals(key)) {
			return true;
		}
		return false;
	}
	
	public void setAbstract(EClass aClass, boolean isAbstract) {
		aClass.setAbstract(isAbstract);
	}

	public void setIsOrdered(EStructuralFeature aProperty, boolean isOrdered) {
		aProperty.setOrdered(isOrdered);
	}

	public void setIsQuery(EOperation anOperation, boolean isQuery) {
//		anOperation.setIsQuery(isQuery);
	}

	public void setIsUnique(EStructuralFeature aProperty, boolean isUnique) {
		aProperty.setUnique(isUnique);
	}

	public void setName(EClass aClass, String name) {
		aClass.setName(name);
	}

	public void setNsPrefix(EPackage aPackage, String name) {
		aPackage.setNsPrefix(name);
	}

	public void setNsURI(EPackage aPackage, String name) {
		aPackage.setNsPrefix(name);
	}

	public void setOperationUpper(EOperation anOperation, int value) {
		anOperation.setUpperBound(value);
	}

	public void setUpper(EStructuralFeature aProperty, int value) {
		aProperty.setUpperBound(value);
	}

	public boolean usesCompareTo() {
		return true;
	}
}