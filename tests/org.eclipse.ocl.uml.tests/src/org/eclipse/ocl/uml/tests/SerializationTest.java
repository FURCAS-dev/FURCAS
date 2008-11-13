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
 * $Id: SerializationTest.java,v 1.9 2008/11/13 02:31:45 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

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
public class SerializationTest
	extends AbstractTestSuite {

	private Resource res;
	
	public SerializationTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(SerializationTest.class, "Serialization Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the serialization of an expression that uses no standard library types.
	 */
	public void test_basicSerialization() {
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"), //$NON-NLS-1$
				"self.nestingPackage"); //$NON-NLS-1$

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
				getMetaclass("Package"), //$NON-NLS-1$
				"self.nestedPackage->size() > 2"); //$NON-NLS-1$

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
				getMetaclass("Package"), //$NON-NLS-1$
				"self.nestedPackage->collect(ownedType->size())"); //$NON-NLS-1$

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
				getMetaclass("Package"), //$NON-NLS-1$
				"let subs : Collection(Package) = self.nestedPackage in subs->size() > 2"); //$NON-NLS-1$

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
				getMetaclass("Package"), //$NON-NLS-1$
				"self.ownedType->forAll(c | " + //$NON-NLS-1$
				"c.oclIsKindOf(Class) implies Class.allInstances()->includes(c.oclAsType(Class)))"); //$NON-NLS-1$

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
				getMetaclass("Package"), //$NON-NLS-1$
				"self.nestedPackage->collect(" + //$NON-NLS-1$
				"Tuple{pkg = name, size = ownedType->size()})"); //$NON-NLS-1$

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
				"let msgs : Sequence(OclMessage) = self^^ripen(?) in " + //$NON-NLS-1$
				"msgs->forAll(m | m.hasReturned() implies m.color <> Color::black)"); //$NON-NLS-1$

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
				"let msgs : Sequence(OclMessage) = self^^Drop(?, ?) in " + //$NON-NLS-1$
				"msgs->forAll(m | m.delay = 0 implies m.stem.oclIsUndefined())"); //$NON-NLS-1$

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
		helper.setContext(getMetaclass("Package")); //$NON-NLS-1$
		
		Operation oper = null;
		
		try {
			oper = helper.defineOperation(
					"getUniqueClassifierNames() : Set(String) = " + //$NON-NLS-1$
					"self.ownedType->collect(name)->asSet()"); //$NON-NLS-1$
			
			assertSame(oper,
					ocl.getEnvironment().getTypeResolver().resolveAdditionalOperation(
							getMetaclass("Package"), oper)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"), //$NON-NLS-1$
				"self.getUniqueClassifierNames()->size()"); //$NON-NLS-1$

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
                getMetaclass("Package"), oper); //$NON-NLS-1$
		assertNotSame(oper, newOper);
	}
	
	/**
	 * Tests the serialization of an expression referencing an additional property.
	 */
	public void test_additionalPropertySerialization() {
		helper.setContext(getMetaclass("Package")); //$NON-NLS-1$
		
		Property prop = null;
		
		try {
			prop = helper.defineAttribute(
					"uniqueClassifierNames : Set(String) = " + //$NON-NLS-1$
					"self.ownedType->collect(name)->asSet()"); //$NON-NLS-1$
			
			assertSame(prop,
					ocl.getEnvironment().getTypeResolver().resolveAdditionalAttribute(
							getMetaclass("Package"), prop)); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		OCLExpression<Classifier> expr = parseExpression(
				getMetaclass("Package"), //$NON-NLS-1$
				"self.uniqueClassifierNames->size()"); //$NON-NLS-1$

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
                getMetaclass("Package"), prop); //$NON-NLS-1$
		assertNotSame(prop, newProp);
	}
    
    /**
     * Tests the serialization of TypeTypes.
     */
    public void test_typeTypeSerialization_183494() {
        OCLExpression<Classifier> expr = parseExpression(
                getMetaclass("Package"), //$NON-NLS-1$
                "Package.allInstances()"); //$NON-NLS-1$

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
        assertSame(getMetaclass("Package"), typeType.getReferredType()); //$NON-NLS-1$
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
                getMetaclass("Package"), //$NON-NLS-1$
                "self.ownedType->any(oclIsKindOf(Class))"); //$NON-NLS-1$

        Resource res = ocl.getEnvironment().getTypeResolver().getResource();
        Package typesPackage = null;
        for (EObject next : res.getContents()) {
        	if ((next instanceof Package)
        			&& "types".equals(((Package) next).getName())) { //$NON-NLS-1$
        		typesPackage = (Package) next;
        		break;
        	}
        }
        assertNotNull(typesPackage);
        
        assertEquals(1, typesPackage.getOwnedTypes().size());
        
        Classifier first = (Classifier) typesPackage.getOwnedTypes().get(0);
        assertTrue(first instanceof TypeType);
        assertSame(getMetaclass("Class"), ((TypeType) first).getReferredType()); //$NON-NLS-1$
    }
    
    public void test_referenceToOCLEcoreMetamodel_214878() {
        EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("foo"); //$NON-NLS-1$
        
        EClass eclass = EcoreFactory.eINSTANCE.createEClass();
        eclass.setName("Foo"); //$NON-NLS-1$
        epackage.getEClassifiers().add(eclass);
        
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setName("expr"); //$NON-NLS-1$
        ref.setEType(UMLPackage.Literals.OCL_EXPRESSION);
        eclass.getEStructuralFeatures().add(ref);
        
        String serialForm = serialize(epackage);
        
        epackage = load(serialForm, EPackage.class);
        eclass = (EClass) epackage.getEClassifier("Foo"); //$NON-NLS-1$
        assertNotNull(eclass);
        assertFalse(eclass.eIsProxy());
        
        ref = (EReference) eclass.getEStructuralFeature("expr"); //$NON-NLS-1$
        assertNotNull(ref);
        assertFalse(ref.eIsProxy());
        
        assertSame(UMLPackage.Literals.OCL_EXPRESSION, ref.getEType());
        
        // correct loading is one thing.  but the reference must look
        // correct in the serial form, also
        assertFalse(serialForm.contains(Environment.OCL_NAMESPACE_URI + "#//uml/OCLExpression")); //$NON-NLS-1$
        assertTrue(serialForm.contains(UMLPackage.eNS_URI + "#//OCLExpression")); //$NON-NLS-1$
    }
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp()
		throws Exception {
		
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
		res.setURI(URI.createFileURI("/tmp/ocltest.xmi")); //$NON-NLS-1$
		((XMLResource) res).setEncoding("UTF-8"); //$NON-NLS-1$
		
        super.setUp();  // among other things, creates our resource set
        
        resourceSet.getResources().add(res);
	}
	
	@Override
	protected OCL createOCL() {
	    UMLEnvironmentFactory factory = new UMLEnvironmentFactory(resourceSet);
	    UMLEnvironment environment = (UMLEnvironment) factory.loadEnvironment(res);
	    
	    return OCL.newInstance(environment);
	}
	
	@Override
    protected void tearDown()
		throws Exception {
		
		res.unload();
		resourceSet.getResources().remove(res);
		res = null;
		
		super.tearDown();
	}
	
	protected OCLExpression<Classifier> parseExpression(
			Classifier context, String expr) {
		helper.setContext(context);
		
		OCLExpression<Classifier> result = null;
		
		try {
			result = helper.createQuery(expr);
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
			result = output.toString("UTF-8"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Exception serializing AST: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertNotNull(result);
		assertFalse(result.contains("ocl://")); //$NON-NLS-1$
		
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
			
			assertFalse("No contents in serial data", res.getContents().isEmpty()); //$NON-NLS-1$
			assertNoProxies(res);
			
			result = res.getContents();
		} catch (Exception e) {
			fail("Exception deserializing AST: " + e.getLocalizedMessage()); //$NON-NLS-1$
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
        
        assertNotNull("Did not deserialize a " + expectedType.getSimpleName(), result); //$NON-NLS-1$
        
        return result;
    }
    
	protected void assertNoProxies(Resource res) {
		for (Iterator<EObject> iter = res.getAllContents(); iter.hasNext();) {
			for (EObject xref : iter.next().eCrossReferences()) {
				assertFalse("Unresolved reference: " + xref, xref.eIsProxy()); //$NON-NLS-1$
			}
		}
	}
}
