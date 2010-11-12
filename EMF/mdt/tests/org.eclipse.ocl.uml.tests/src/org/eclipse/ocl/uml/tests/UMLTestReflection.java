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
 * $Id: UMLTestReflection.java,v 1.3 2010/04/25 06:50:11 ewillink Exp $
 */
package org.eclipse.ocl.uml.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.tests.TestReflection;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.uml.internal.UMLReflectionImpl;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

@SuppressWarnings("nls")
public class UMLTestReflection 
extends UMLReflectionImpl
implements TestReflection<EObject, Package,
Type, Classifier, Class, DataType, PrimitiveType, Enumeration,
Operation, Parameter, Property, Property, Property,
EnumerationLiteral, State, CallOperationAction, SendSignalAction, Constraint>
{
	public static class Static implements TestReflection.Static<EObject, Package,
	Type, Classifier, Class, DataType, PrimitiveType, Enumeration,
	Operation, Parameter, Property, Property, Property,
	EnumerationLiteral, State, CallOperationAction, SendSignalAction, Constraint>
	{
		public static final Static INSTANCE = new Static();
		
		public OCL createOCL(ResourceSet resourceSet) {
			return OCL.newInstance(resourceSet);
		}

		public TestReflection<EObject, Package, Type, Classifier, Class, DataType, PrimitiveType, Enumeration, Operation, Parameter, Property, Property, Property, EnumerationLiteral, State, CallOperationAction, SendSignalAction, Constraint> createReflection(
			Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> environment) {
			return new UMLTestReflection((UMLEnvironment) environment);
		}
		
		public ResourceSet createResourceSet() {
			Environment.Registry.INSTANCE.registerEnvironment(
				new UMLEnvironmentFactory().createEnvironment());
			ResourceSet resourceSet = new ResourceSetImpl();
		    OCL.initialize(resourceSet);
			// Make sure that the UML metamodel and primitive types
			//   libraries are loaded
			umlMetamodel = (Package) resourceSet.getResource(
					URI.createURI(UMLResource.UML_METAMODEL_URI),
					true).getContents().get(0);
			umlPrimitiveTypes = (Package) resourceSet.getResource(
					URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
					true).getContents().get(0);
			ecorePrimitiveTypes = (Package) resourceSet.getResource(
					URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI),
					true).getContents().get(0);
		    return resourceSet;
		}

		public String getTestPlugInId() {
			return PLUGIN_ID;
		}
	}

	public static final String PLUGIN_ID = "org.eclipse.ocl.uml.tests";

	public static OCL createOCL(ResourceSet resourceSet) {
		OCL newInstance = OCL.newInstance(resourceSet);
		String repairs = System.getProperty(PLUGIN_ID + ".repairs");
		if (repairs != null)
			newInstance.setParserRepairCount(Integer.parseInt(repairs));
		return newInstance;
	}
	
	/**
	 * Map of %Key to value for denormalizing OCL test code.
	 */
	private Map<String, String> normalizers = null;

	public UMLTestReflection(UMLEnvironment env) {
		super(env);
	}

	protected static Package umlMetamodel;
	protected static Package umlPrimitiveTypes;
	protected static Package ecorePrimitiveTypes;
	protected static Package oclMetamodel;

	public void addSupertype(Class aClass, Class superType) {
		aClass.getSuperClasses().add(superType);
	}

	public Class createClass() {
		return UMLFactory.eINSTANCE.createClass();
	}

	public Comment createComment() {
		return UMLFactory.eINSTANCE.createComment();
	}

	public void createGeneralization(Classifier special, Classifier general) {
		special.createGeneralization(general);
	}

	public Package createNestedPackage(Package aPackage, String name) {
		return aPackage.createNestedPackage(name);
	}

	public Property createOwnedAttribute(Class aClass, String name, Classifier type) {
		return aClass.createOwnedAttribute(name, type);
	}

	public Class createOwnedClass(Package aPackage, String name, boolean isAbstract) {
		return aPackage.createOwnedClass(name, isAbstract);
	}

	public Enumeration createOwnedEnumeration(Package aPackage, String name) {
		return aPackage.createOwnedEnumeration(name);
	}

	public EnumerationLiteral createOwnedLiteral(Enumeration anEnumeration, String name) {
		return anEnumeration.createOwnedLiteral(name);
	}

	public Operation createOwnedOperation(Class aClass, String name, EList<String> paramNames, EList<Type> paramTypes, Type type, boolean isQuery) {
		Operation operation = aClass.createOwnedOperation(name, paramNames, paramTypes, type);
		if (isQuery) {
			operation.setIsQuery(true);
		}
		return operation;
	}

	public Operation createOwnedPrimitiveOperation(PrimitiveType aPrimitiveType, String name, EList<String> paramNames, EList<Type> paramTypes, Type type, boolean isQuery) {
		Operation operation = aPrimitiveType.createOwnedOperation(name, paramNames, paramTypes, type);
		if (isQuery) {
			operation.setIsQuery(true);
		}
		return operation;
	}

	public PrimitiveType createOwnedPrimitiveType(Package aPackage, String name) {
		return aPackage.createOwnedPrimitiveType(name);
	}

	public Property createOwnedReference(Class aClass, String name, Class type) {
		return aClass.createOwnedAttribute(name, type);
	}

	public Package createPackage(String name) {
		Package uPackage = UMLFactory.eINSTANCE.createPackage();
		uPackage.setName(name);
		return uPackage;
	}
	
/*	public void disposeResourceSet(ResourceSet resourceSet) {
        if (resourceSet != null) {
            if (DISPOSE_UML_METAMODEL) {
                for (Resource res : resourceSet.getResources()) {
                    res.unload();
                    res.eAdapters().clear();
                }
                resourceSet.getResources().clear();
                resourceSet.eAdapters().clear();
                resourceSet = null;
                
                umlMetamodel = null;
                umlPrimitiveTypes = null;
                ecorePrimitiveTypes = null;
                oclMetamodel = null;
            } else {
                // unload and remove all resources but the UML Metamodel.
                // Don't clear the resource set's adapter-list
                
                Set<Resource> toPreserve = new java.util.HashSet<Resource>();
                toPreserve.add(umlMetamodel.eResource());
                toPreserve.add(umlPrimitiveTypes.eResource());
                toPreserve.add(ecorePrimitiveTypes.eResource());
//                toPreserve.add(oclExpressionTypes.eResource());
                
                for (Resource res : resourceSet.getResources()) {
                    if (!toPreserve.contains(res)) {
                        res.unload();
                        res.eAdapters().clear();
                    }
                }
                
                resourceSet.getResources().retainAll(toPreserve);
            }
        }
        
//        fruitPackage = null;
	} */

	public String denormalize(String key) {
		if (normalizers == null) {
			normalizers = new HashMap<String, String>();
			normalizers.put("Reference", "Property");
			normalizers.put("String", "\"String\"");
		}
		return normalizers.get(key);
	}

	public Property getAttribute(Classifier classifier, String name, Type type) {
		return classifier.getAttribute(name, type);
	}

	public Classifier getBigDecimal() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("EBigDecimal");
	}

	public Classifier getBigInteger() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("EBigInteger");
	}
	
	public OCLExpression<Classifier> getBodyExpression(Constraint constraint) {	
		return ((ExpressionInOCL) constraint.getSpecification()).getBodyExpression();
	}

	public Classifier getClassTypeContext() {
		return (Classifier) umlMetamodel.getOwnedType("Class");
	}

	public Classifier getClassifierTypeContext() {
		return (Classifier) umlMetamodel.getOwnedType("Classifier");
	}

	public Classifier getCollectionKindTypeContext() {		
		Package expressionsPackage = oclMetamodel.getNestedPackage("expressions");
		return (Classifier) expressionsPackage.getOwnedType("CollectionKind");
	}

	public Classifier getCommentTypeContext() {
		return (Classifier) umlMetamodel.getOwnedType("Comment");
	}
	
	public java.lang.Class<Constraint> getConstraintClass() {
		return Constraint.class;
	}

//	public Classifier getDefaultSetType(Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> environment) {
//		return environment.getOCLStandardLibrary().getInvalid();
//	}

	public EPackage getEPackage(Package pkg) {
		return UMLUtil.convertToEcore(pkg, null).iterator().next();
	}
	
	public PrimitiveType getEcoreBigDecimal() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("EBigDecimal");
	}
	
	public PrimitiveType getEcoreBigInteger() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("EBigInteger");
	}
	
	public PrimitiveType getEcoreLong() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("ELong");
	}

	public Package getEcorePrimitiveTypes() {
		return ecorePrimitiveTypes;
	}

	public String getFruitModelPath() {
		return "/model/OCLTest.uml";
	}
    
	public Classifier getMetaclass(String name) {
        return (Classifier) umlMetamodel.getOwnedType(name);
    }

	public Package getOCLMetaModel() {
		return oclMetamodel;
	}

	public String getNsURI(Package aPackage) {	// FIXME UOE
		throw new UnsupportedOperationException(getClass().getName() + ".getNsURI");
	}

	public Classifier getOwner(Operation context) {
		return (Classifier) context.getOwner();
	}

	public Package getResourcePackage(ResourceSet resourceSet, URI uri) {
		Resource res = resourceSet.getResource(uri, true);		
		return (Package) res.getContents().get(0);
	}

	public Classifier getStringTypeContext() {
		return OCLStandardLibraryImpl.INSTANCE.getString();
	}
	
	public PrimitiveType getUMLBoolean() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("Boolean");
	}

	public PrimitiveType getUMLInteger() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("Integer");
	}

	public PrimitiveType getUMLLong() {
		return (PrimitiveType) ecorePrimitiveTypes.getOwnedType("ELong");
	}

	public Package getUMLMetamodel() {
		return umlMetamodel;
	}

	public Package getUMLPrimitiveTypes() {
		return umlPrimitiveTypes;
	}
	
	public PrimitiveType getUMLString() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("String");
	}

	public PrimitiveType getUMLUnlimitedNatural() {
		return (PrimitiveType) umlPrimitiveTypes.getOwnedType("UnlimitedNatural");
	}

	public int getUnlimitedValue() {
		return LiteralUnlimitedNatural.UNLIMITED;
	}

/*	public Map<URI, URI> initRegistries() {
		if (uriMap != null)
			return uriMap;
		uriMap = URIMappingRegistryImpl.INSTANCE.map();		
		URI oclStandardLibraryURI = URI.createURI(UMLEnvironment.OCL_STANDARD_LIBRARY_NS_URI);
		if (uriMap.get(oclStandardLibraryURI) == null) {			// If no mapping registered then must set up standalone context
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
			Environment.Registry.INSTANCE.registerEnvironment(
					new UMLEnvironmentFactory().createEnvironment());
			String oclLocation = System.getProperty("org.eclipse.ocl.uml");
			if (oclLocation == null)
				AbstractTestSuite.fail("'org.eclipse.ocl.uml' property not defined; use the launch configuration to define it");
			oclLocation = "file:/" + oclLocation;
			uriMap.put(URI.createURI(UMLEnvironment.OCL_STANDARD_LIBRARY_NS_URI), URI.createURI(oclLocation + "/model/oclstdlib.uml"));
			String resourcesLocation = System.getProperty("org.eclipse.uml2.uml.resources");
			if (resourcesLocation == null)
				AbstractTestSuite.fail("'org.eclipse.uml2.uml.resources' property not defined; use the launch configuration to define it");
			resourcesLocation = "file:/" + resourcesLocation;
			uriMap.put(URI.createURI(UMLResource.STANDARD_PROFILE_URI), URI.createURI(resourcesLocation + "/profiles/Standard.profile.uml"));
			uriMap.put(URI.createURI(UMLResource.ECORE_PROFILE_URI), URI.createURI(resourcesLocation + "/profiles/Ecore.profile.uml"));
			uriMap.put(URI.createURI(UMLResource.UML_METAMODEL_URI), URI.createURI(resourcesLocation + "/metamodels/UML.metamodel.uml"));
			uriMap.put(URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), URI.createURI(resourcesLocation + "/libraries/UMLPrimitiveTypes.library.uml"));
			uriMap.put(URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI), URI.createURI(resourcesLocation + "/libraries/EcorePrimitiveTypes.library.uml"));
			resourcesLocation = System.getProperty("org.eclipse.ocl");
			if (resourcesLocation == null)
				AbstractTestSuite.fail("'org.eclipse.ocl' property not defined; use the launch configuration to define it");
			resourcesLocation = "file:/" + resourcesLocation;
			uriMap.put(URI.createURI(OCL.OCL_METAMODEL_URI), URI.createURI(resourcesLocation + "/model/OCL.uml"));
		}
		OCLStandardLibraryImpl.INSTANCE.getClass();		// Ensure OCLStandardLibrary loaded before use
		return uriMap;
	} */

/*	public void initResourceSet(ResourceSet resourceSet) {
		// also make sure that the UML metamodel and primitive types
		//   libraries are loaded
		if (umlMetamodel == null) {
			umlMetamodel = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.UML_METAMODEL_URI),
				true).getContents().get(0);
		}
		if (umlPrimitiveTypes == null) {
			umlPrimitiveTypes = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI),
				true).getContents().get(0);
		}
		if (ecorePrimitiveTypes == null) {
			ecorePrimitiveTypes = (Package) resourceSet.getResource(
				URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI),
				true).getContents().get(0);
		}
		if (oclMetamodel == null) {
			oclMetamodel = (Package) resourceSet.getResource(
				URI.createURI(OCL.OCL_METAMODEL_URI),
				true).getContents().get(0);
		}
    } */

	public boolean isOrdered(String key) {
		return false;
	}

	public boolean isUnique(String key) {
		if ("nestedPackage".equals(key)) {
			return true;
		}
		return false;
	}
	
	public void setAbstract(Class aClass, boolean isAbstract) {
		aClass.setIsAbstract(isAbstract);
	}

	public void setIsOrdered(Property aProperty, boolean isOrdered) {
		aProperty.setIsOrdered(isOrdered);
	}

	public void setIsQuery(Operation anOperation, boolean isQuery) {
		anOperation.setIsQuery(isQuery);
	}

	public void setIsUnique(Property aProperty, boolean isUnique) {
		aProperty.setIsUnique(isUnique);
	}

	public void setName(Class aClass, String name) {
		aClass.setName(name);
	}

	public void setNsPrefix(Package aPackage, String name) {
//		aPackage.setNsPrefix(name);
	}

	public void setNsURI(Package aPackage, String name) {
//		aPackage.setNsPrefix(name);
	}

	public void setOperationUpper(Operation anOperation, int value) {
		anOperation.setUpper(value);
	}

	public void setUpper(Property aProperty, int value) {
		aProperty.setUpper(value);
	}

	public boolean usesCompareTo() {
		return false;
	}
}