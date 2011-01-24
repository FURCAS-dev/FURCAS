/**
 * <copyright>
 * 
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: PivotTestReflection.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.ecore;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.ObjectUtil;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PivotReflectionImpl;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.test.generic.TestReflection;

@SuppressWarnings("nls")
public class PivotTestReflection extends PivotReflectionImpl implements TestReflection,
TestReflection.Static
{
	public static final String PLUGIN_ID = "org.eclipse.ocl.ecore.tests";

	public static OCL createOCL() {
		OCL newInstance = OCL.newInstance();
		String repairs = System.getProperty(PLUGIN_ID + ".repairs");
		if (repairs != null)
			newInstance.setParserRepairCount(Integer.parseInt(repairs));
		return newInstance;
	}
	
	/**
	 * Map of %Key to value for denormalizing OCL test code.
	 */
	private Map<String, String> normalizers = null;

	public PivotTestReflection(TypeManager typeManager) {
		super(typeManager);
	}

	public void addSupertype(org.eclipse.ocl.examples.pivot.Class aClass, org.eclipse.ocl.examples.pivot.Class superClass) {
		aClass.getSuperClasses().add(superClass);
	}

	public org.eclipse.ocl.examples.pivot.Class createClass() {
		return PivotFactory.eINSTANCE.createClass();
	}

	public Comment createComment() {
		return PivotFactory.eINSTANCE.createComment();
	}

	public void createGeneralization(Type special, Type general) {
		if ((special instanceof org.eclipse.ocl.examples.pivot.Class) && (general instanceof org.eclipse.ocl.examples.pivot.Class))
			((org.eclipse.ocl.examples.pivot.Class)special).getSuperClasses().add((org.eclipse.ocl.examples.pivot.Class)general);
	}

	public org.eclipse.ocl.examples.pivot.Package createNestedPackage(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		org.eclipse.ocl.examples.pivot.Package nestedPackage = PivotFactory.eINSTANCE.createPackage();
		nestedPackage.setName(name);
		aPackage.getNestedPackages().add(nestedPackage);
		return nestedPackage;
	}

	public OCL createOCL(ResourceSet resourceSet) {
		Registry packageRegistry = resourceSet.getPackageRegistry();
		PivotEnvironmentFactory envFactory = new PivotEnvironmentFactory(packageRegistry, typeManager);
		return OCL.newInstance(envFactory);
	}

	public Property createOwnedAttribute(org.eclipse.ocl.examples.pivot.Class aClass, String name, Type type) {
		Property eAttribute = PivotFactory.eINSTANCE.createProperty();
		eAttribute.setName(name);
		eAttribute.setType(type);
		aClass.getOwnedAttributes().add(eAttribute);
		return eAttribute;
	}

	public org.eclipse.ocl.examples.pivot.Class createOwnedClass(org.eclipse.ocl.examples.pivot.Package aPackage, String name, boolean isAbstract) {
		org.eclipse.ocl.examples.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		eClass.setIsAbstract(isAbstract);
		aPackage.getOwnedTypes().add(eClass);
		return eClass;
	}

	public Enumeration createOwnedEnumeration(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		Enumeration eEnum = PivotFactory.eINSTANCE.createEnumeration();
		eEnum.setName(name);
		aPackage.getOwnedTypes().add(eEnum);
		return eEnum;
	}

	public EnumerationLiteral createOwnedLiteral(Enumeration anEnumeration, String name) {
		EnumerationLiteral eLiteral = PivotFactory.eINSTANCE.createEnumerationLiteral();
		eLiteral.setName(name);
		anEnumeration.getOwnedLiterals().add(eLiteral);
		return eLiteral;
	}

	public Operation createOwnedOperation(org.eclipse.ocl.examples.pivot.Class aClass, String name, List<String> paramNames, List<Type> paramTypes, Type type, boolean isQuery) {
		Operation eOperation = PivotFactory.eINSTANCE.createOperation();
		eOperation.setName(name);
		eOperation.setType(type);
		if (paramNames != null) {
			for (int i = 0; i < paramNames.size(); i++) {
				createOwnedParameter(eOperation, paramNames.get(i), paramTypes.get(i));
			}
		}
		aClass.getOwnedOperations().add(eOperation);
		return eOperation;
	}

	public Parameter createOwnedParameter(Operation eOperation, String name, Type type) {
		Parameter eParameter = PivotFactory.eINSTANCE.createParameter();
		eParameter.setName(name);
		eParameter.setType(type);
		eOperation.getOwnedParameters().add(eParameter);
		return eParameter;
	}

	public Operation createOwnedPrimitiveOperation(Type aPrimitiveType, String name, EList<String> paramNames, EList<Type> paramTypes, Type type, boolean isQuery) {
		return createOwnedOperation((org.eclipse.ocl.examples.pivot.Class) aPrimitiveType, name, paramNames, paramTypes, type, isQuery);
	}

	public org.eclipse.ocl.examples.pivot.Class createOwnedPrimitiveType(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		org.eclipse.ocl.examples.pivot.Class eClass = PivotFactory.eINSTANCE.createClass();
		eClass.setName(name);
		aPackage.getOwnedTypes().add(eClass);
		return eClass;
	}

	public Property createOwnedReference(org.eclipse.ocl.examples.pivot.Class aClass, String name, org.eclipse.ocl.examples.pivot.Class type) {
		Property eReference = PivotFactory.eINSTANCE.createProperty();
		eReference.setName(name);
		eReference.setType(type);
		aClass.getOwnedAttributes().add(eReference);
		return eReference;
	}

	public org.eclipse.ocl.examples.pivot.Package createPackage(String name) {
		org.eclipse.ocl.examples.pivot.Package pPackage = PivotFactory.eINSTANCE.createPackage();
		pPackage.setName(name);
		return pPackage;
	}

	public TestReflection createReflection(Environment environment) {
		return this;
	}

	public String denormalize(String key) {
		if (normalizers == null) {
			normalizers = new HashMap<String, String>();
//			normalizers.put("Date", "EDate");
//			normalizers.put("Package", "EPackage");
//			normalizers.put("Reference", "EReference");
//			normalizers.put("String", "EString");
//			normalizers.put("Type", "EClassifier");
//			normalizers.put("container", "eContainer");
//			normalizers.put("nestedPackage", "eSubpackages");
//			normalizers.put("nestingPackage", "eSuperPackage");
//			normalizers.put("opposite", "eOpposite");
//			normalizers.put("ownedType", "eClassifiers");
//			normalizers.put("uml", "ecore");
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

	public Property getAttribute(Type classifier, String name, Type type) {
		if (!(classifier instanceof org.eclipse.ocl.examples.pivot.Class))
			return null;
		Property feature = ObjectUtil.getNamedElement(((org.eclipse.ocl.examples.pivot.Class)classifier).getOwnedAttributes(), name);
		if (feature == null)
			return null;
		// check type
		return feature;
	}

//	public Type getBigDecimal() {
//		return EcorePackage.Literals.EBIG_DECIMAL;
//	}

//	public Type getBigInteger() {
//		return EcorePackage.Literals.EBIG_INTEGER;
//	}
	
	public OclExpression getBodyExpression(Constraint constraint) {
		return ((ExpressionInOcl)constraint.getSpecification()).getBodyExpression();
	}

//	public Type getClassTypeContext() {
//		return EcorePackage.Literals.ECLASS;
//	}

//	public Type getClassifierTypeContext() {
//		return EcorePackage.Literals.ECLASSIFIER;
//	}

//	public Type getCollectionKindTypeContext() {
//		return ExpressionsPackage.Literals.COLLECTION_KIND;
//	}

//	public Type getCommentTypeContext() {
//		return EcorePackage.Literals.EANNOTATION;
//	}
	
	public java.lang.Class<Constraint> getConstraintClass() {
		return Constraint.class;
	}

//	public Type getDefaultSetType(Environment environment) {
//		return EcorePackage.Literals.ERESOURCE;
//	}

//	public org.eclipse.ocl.examples.pivot.Package getEPackage(org.eclipse.ocl.examples.pivot.Package pkg) {
//		return pkg;
//	}
	
//	public Type getEcoreBigDecimal() {
//		return EcorePackage.Literals.EBIG_DECIMAL;
//	}
	
//	public Type getEcoreBigInteger() {
//		return EcorePackage.Literals.EBIG_INTEGER;
//	}
	
//	public Type getEcoreLong() {
//		return EcorePackage.Literals.ELONG;
//	}

	public org.eclipse.ocl.examples.pivot.Package getEcorePrimitiveTypes() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getEcorePrimitiveTypes");
	}

	public String getFruitModelPath() {
		return "/model/OCLTest.ecore";
	}
    
//	public Type getMetaclass(String name) {
//	    return EcorePackage.eINSTANCE.getEClassifier(name);
//    }
	
	public String getNsURI(org.eclipse.ocl.examples.pivot.Package aPackage) {
		return aPackage.getNsURI();
	}

	public org.eclipse.ocl.examples.pivot.Package getOCLExpressionTypes() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getOCLExpressionTypes");
	}

	public Type getOwner(Operation context) {
		return context.getClass_();
	}

	public org.eclipse.ocl.examples.pivot.Package getResourcePackage(ResourceSet resourceSet, URI uri) {
		Resource res = resourceSet.getResource(uri, true);		
		return (org.eclipse.ocl.examples.pivot.Package) res.getContents().get(0);
	}

//	public Type getStringTypeContext() {
//		return EcorePackage.Literals.ESTRING;
//	}

	public String getTestPlugInId() {
		return PLUGIN_ID;
	}
	
//	public Type getUMLBoolean() {
//		return EcorePackage.Literals.EBOOLEAN;
//	}

//	public Type getUMLInteger() {
//		return EcorePackage.Literals.EINT;
//	}

//	public Type getUMLLong() {
//		return EcorePackage.Literals.ELONG;
//	}

//	public org.eclipse.ocl.examples.pivot.Package getUMLMetamodel() {	// FIXME UOE
//		return EcorePackage.eINSTANCE;
//	}

	public org.eclipse.ocl.examples.pivot.Package getUMLPrimitiveTypes() {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getUMLPrimitiveTypes");
	}
	
//	public Type getUMLString() {
//		return EcorePackage.Literals.ESTRING;
//	}

//	public Type getUMLUnlimitedNatural() {	// FIXME UOE
//		throw new UnsupportedOperationException(getClass().getName() + ".getUnlimitedNatural");
//	}

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
		resourceSet.getPackageRegistry().put(PivotPackage.eINSTANCE.getNsURI(), PivotPackage.eINSTANCE);
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
	
	public void setAbstract(org.eclipse.ocl.examples.pivot.Class aClass, boolean isAbstract) {
		aClass.setIsAbstract(isAbstract);
	}

	public void setIsOrdered(Property aProperty, boolean isOrdered) {
		aProperty.setIsOrdered(isOrdered);
	}

	public void setIsQuery(Operation anOperation, boolean isQuery) {
//		anOperation.setIsQuery(isQuery);
	}

	public void setIsUnique(Property aProperty, boolean isUnique) {
		aProperty.setIsUnique(isUnique);
	}

	public void setName(org.eclipse.ocl.examples.pivot.Class aClass, String name) {
		aClass.setName(name);
	}

	public void setNsPrefix(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		aPackage.setNsPrefix(name);
	}

	public void setNsURI(org.eclipse.ocl.examples.pivot.Package aPackage, String name) {
		aPackage.setNsPrefix(name);
	}

	public void setOperationUpper(Operation anOperation, int value) {
		anOperation.setUpper(BigInteger.valueOf(value));
	}

	public void setUpper(Property aProperty, int value) {
		aProperty.setUpper(BigInteger.valueOf(value));
	}

	public boolean usesCompareTo() {
		return true;
	}

	public Operation createOwnedPrimitiveOperation(Type aPrimitiveType,
			String name, List<String> paramNames, List<Type> paramTypes,
			Type type, boolean isQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public EPackage getEPackage(Package pkg) {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getMetaclass(String name) {
		return typeManager.getRequiredLibraryType(name);
	}

	public Type getUMLBoolean() {
		return typeManager.getBooleanType();
	}

	public Type getUMLInteger() {
		return typeManager.getIntegerType();
	}

//	public Type getUMLLong() {
		// TODO Auto-generated method stub
//		return null;
//	}

	public Package getUMLMetamodel() {
		// TODO Auto-generated method stub
		return typeManager.getPivotPackage();
	}

	public Type getUMLString() {
		return typeManager.getStringType();
	}

	public Type getUMLUnlimitedNatural() {
		return typeManager.getUnlimitedNaturalType();
	}
}