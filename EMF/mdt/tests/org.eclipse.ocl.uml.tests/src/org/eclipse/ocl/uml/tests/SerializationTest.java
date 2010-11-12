/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 242236
 *
 * </copyright>
 *
 * $Id: SerializationTest.java,v 1.11 2009/11/28 18:10:47 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.TypeType;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

/**
 * Tests for serialization of OCL constraints and expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class SerializationTest
	extends AbstractTestSuite {

	Resource res;
	
	/**
	 * Tests the serialization of an expression that uses no standard library types.
	 */
	public void test_basicSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.nestingPackage");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that uses OCL primitive types.
	 */
	public void test_primitiveTypeSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.nestedPackage->size() > 2");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that uses collections of
	 * primitive types.
	 */
	public void test_primitiveCollectionTypeSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.nestedPackage->collect(ownedType->size())");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that uses collections of
	 * model types.  Incidentally tests variable serialization via a let expression.
	 */
	public void test_modelCollectionTypeSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"let subs : Collection(Package) = self.nestedPackage in subs->size() > 2");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression that references model types in
	 * type expressions.
	 */
	public void test_typeExpSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.ownedType->forAll(c | " +
				"c.oclIsKindOf(Class) implies Class.allInstances()->includes(c.oclAsType(Class)))");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression containing a tuple literal.
	 */
	public void test_tupleSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.nestedPackage->collect(" +
				"Tuple{pkg = name, size = ownedType->size()})");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression containing an operation message
	 * expression.
	 */
	public void test_operationMessageSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				fruit,
				"let msgs : Sequence(OclMessage) = self^^ripen(?) in " +
				"msgs->forAll(m | m.hasReturned() implies m.color <> Color::black)");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression containing an operation message
	 * expression.
	 */
	public void test_signalMessageSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				fruit,
				"let msgs : Sequence(OclMessage) = self^^Drop(?, ?) in " +
				"msgs->forAll(m | m.delay = 0 implies m.stem.oclIsUndefined())");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
	}
	
	/**
	 * Tests the serialization of an expression referencing an additional operation.
	 */
	public void test_additionalOperationSerialization() {
		helper.setContext(getMetaclass("Package"));
		
		Operation oper = null;
		
		try {
			oper = helper.defineOperation(
					"getUniqueClassifierNames() : Set(String) = " +
					"self.ownedType->collect(name)->asSet()");
			
			assertSame(oper,
					ocl.getEnvironment().getTypeResolver().resolveAdditionalOperation(
							getMetaclass("Package"), oper));
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.getUniqueClassifierNames()->size()");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
		
		// verify the loading of an environment from a resource
		OCL newOCL = OCL.newInstance(
				ocl.getEnvironment().getFactory(),
				ocl.getEnvironment().getTypeResolver().getResource());
		
		Operation newOper = newOCL.getEnvironment().getTypeResolver().resolveAdditionalOperation(
                getMetaclass("Package"), oper);
		assertNotSame(oper, newOper);
	}
	
	/**
	 * Tests the serialization of an expression referencing an additional property.
	 */
	public void test_additionalPropertySerialization() {
		helper.setContext(getMetaclass("Package"));
		
		Property prop = null;
		
		try {
			prop = helper.defineAttribute(
					"uniqueClassifierNames : Set(String) = " +
					"self.ownedType->collect(name)->asSet()");
			
			assertSame(prop,
					ocl.getEnvironment().getTypeResolver().resolveAdditionalAttribute(
							getMetaclass("Package"), prop));
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"),
				"self.uniqueClassifierNames->size()");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
		
		// verify the loading of an environment from a resource
		OCL newOCL = OCL.newInstance(
				ocl.getEnvironment().getFactory(),
				ocl.getEnvironment().getTypeResolver().getResource());
		
		Property newProp = newOCL.getEnvironment().getTypeResolver().resolveAdditionalAttribute(
                getMetaclass("Package"), prop);
		assertNotSame(prop, newProp);
	}
    
    /**
     * Tests the serialization of TypeTypes.
     */
    public void test_typeTypeSerialization_183494() {
        OCLExpression<Classifier> expr = parseExpression(
                getMetaclass("Package"),
                "Package.allInstances()");

        String toStringForm = expr.toString();
        String serialForm = serialize(expr);
        
        expr = loadExpression(serialForm);
        validate(expr);  // ensure that it is structurally valid
        assertEquals(toStringForm, expr.toString());  // should "look" the same
        
        assertTrue(expr instanceof OperationCallExp);
        expr = ((OperationCallExp) expr).getSource();
        
        assertNotNull(expr);
        assertTrue(expr.getType() instanceof TypeType);
        
        TypeType typeType = (TypeType) expr.getType();
        assertSame(getMetaclass("Package"), typeType.getReferredType());
    }
    
    /**
     * Tests that the OclType constant is not serialized.
     */
    public void test_OclType_serialization_226455() {
        TypeResolver<Classifier, Operation, Property> resolver = ocl
				.getEnvironment().getTypeResolver();
        
        Classifier oclType = resolver.resolve(getOCLStandardLibrary().getOclType());
        assertSame(getOCLStandardLibrary().getOclType(), oclType);
        assertTrue(resolver.getResource().getContents().isEmpty());
    }
    
    /**
     * Tests for appropriate resolution of 'typespec' as in oclIsKindOf() operation.
     */
    public void test_typespec_resolution_226455() {
        parseExpression(
                getMetaclass("Package"),
                "self.ownedType->any(oclIsKindOf(Class))");

        Resource res = ocl.getEnvironment().getTypeResolver().getResource();
        Package typesPackage = null;
        for (EObject next : res.getContents()) {
        	if ((next instanceof Package)
        			&& "types".equals(((Package) next).getName())) {
        		typesPackage = (Package) next;
        		break;
        	}
        }
        assertNotNull(typesPackage);
        
        assertEquals(1, typesPackage.getOwnedTypes().size());
        
        Classifier first = (Classifier) typesPackage.getOwnedTypes().get(0);
        assertTrue(first instanceof TypeType);
        assertSame(getMetaclass("Class"), ((TypeType) first).getReferredType());
    }
    
    public void test_referenceToOCLEcoreMetamodel_214878() {
        EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("foo");
        
        EClass eclass = EcoreFactory.eINSTANCE.createEClass();
        eclass.setName("Foo");
        epackage.getEClassifiers().add(eclass);
        
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setName("expr");
        ref.setEType(UMLPackage.Literals.OCL_EXPRESSION);
        eclass.getEStructuralFeatures().add(ref);
        
        String serialForm = serialize(epackage);
        
        epackage = load(serialForm, EPackage.class);
        eclass = (EClass) epackage.getEClassifier("Foo");
        assertNotNull(eclass);
        assertFalse(eclass.eIsProxy());
        
        ref = (EReference) eclass.getEStructuralFeature("expr");
        assertNotNull(ref);
        assertFalse(ref.eIsProxy());
        
        assertSame(UMLPackage.Literals.OCL_EXPRESSION, ref.getEType());
        
        // correct loading is one thing.  but the reference must look
        // correct in the serial form, also
        assertFalse(serialForm.contains(Environment.OCL_NAMESPACE_URI + "#//uml/OCLExpression"));
        assertTrue(serialForm.contains(UMLPackage.eNS_URI + "#//OCLExpression"));
    }
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp() {
		
		//FIXME:  Need to use extrinsic IDs because lookup fails on hierarchical
		//    name-based fragments
		res = new XMIResourceImpl() {
			@Override
			protected boolean useIDs() {
				return true;
			}
			
			@Override
			protected boolean useUUIDs() {
				return true;
			}};
		res.setURI(URI.createFileURI("/tmp/ocltest.xmi"));
		((XMLResource) res).setEncoding("UTF-8");
		
        super.setUp();  // among other things, creates our resource set
        
        resourceSet.getResources().add(res);
	}
	
	@Override
	protected OCL createOCL() {
	    UMLEnvironmentFactory factory = new UMLEnvironmentFactory(resourceSet);
	    UMLEnvironment environment = (UMLEnvironment) factory.loadEnvironment(res);
	    
	    return OCL.newInstance(environment);
	}
	
	protected OCLExpression<Classifier> parseExpression(
			Classifier context, String expr) {
		helper.setContext(context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = helper.createQuery(expr);
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		assertNotNull(result);
		return result;
	}
	
	protected String serialize(EObject eobject) {
		String result = null;
		
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			res.getContents().add(eobject);
			res.save(output,
					Collections.singletonMap(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE));
			result = output.toString("UTF-8");
		} catch (Exception e) {
			fail("Exception serializing AST: " + e.getLocalizedMessage());
		}
		
		assertNotNull(result);
		assertFalse(result.contains("ocl://"));
		
		return result;
	}
	
	protected List<EObject> deserialize(String serial) {
	    List<EObject> result;
		
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(serial.getBytes());
			res.unload();
			res.load(input, Collections.EMPTY_MAP);
			
			// reload the environment
			ocl = createOCL();
			helper = createHelper();
			
			assertFalse("No contents in serial data", res.getContents().isEmpty());
			assertNoProxies(res);
			
			result = res.getContents();
		} catch (Exception e) {
			fail("Exception deserializing AST: " + e.getLocalizedMessage());
			result = Collections.emptyList();  // fail will throw
		}
		
		assertNotNull(result);
		
		return result;
	}
	
    @SuppressWarnings("unchecked")
    protected OCLExpression<Classifier> loadExpression(String serial) {
        return load(serial, OCLExpression.class);
    }
    
    protected Constraint loadConstraint(String serial) {
        return load(serial, Constraint.class);
    }
    
    @SuppressWarnings("unchecked")
    protected <T extends EObject> T load(String serial, Class<T> expectedType) {
        T result = null;
        List<EObject> objects = deserialize(serial);
        
        for (Object next : objects) {
            if (expectedType.isInstance(next)) {
                result = (T) next;
                break;
            }
        }
        
        assertNotNull("Did not deserialize a " + expectedType.getSimpleName(), result);
        
        return result;
    }
    
	protected void assertNoProxies(Resource res) {
		for (Iterator<EObject> iter = res.getAllContents(); iter.hasNext();) {
			for (EObject xref : iter.next().eCrossReferences()) {
				assertFalse("Unresolved reference: " + xref, xref.eIsProxy());
			}
		}
	}
}
