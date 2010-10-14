/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 248869, 242236
 *
 * </copyright>
 *
 * $Id: SerializationTest.java,v 1.11 2009/11/28 17:47:59 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;

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
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSuperPackage");

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
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSubpackages->size() > 2");

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
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSubpackages->collect(eClassifiers->size())");

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
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"let subs : Collection(EPackage) = self.eSubpackages in subs->size() > 2");

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
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eClassifiers->forAll(c | " +
				"c.oclIsKindOf(EClass) implies EClass.allInstances()->includes(c.oclAsType(EClass)))");

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
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.eSubpackages->collect(" +
				"Tuple{pkg = name, size = eClassifiers->size()})");

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
		OCLExpression<EClassifier> expr = parseExpression(
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
		expectModified = true;
		ocl.dispose();
		ocl = OCL.newInstance(new MessagesTest.MessagingFruitEnvironmentFactory(this),
		        res);
		helper = ocl.createOCLHelper();
		
		OCLExpression<EClassifier> expr = parseExpression(
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
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		
		EOperation eoper = null;
		
		try {
			eoper = helper.defineOperation(
					"getUniqueClassifierNames() : Set(String) = " +
					"self.eClassifiers->collect(name)->asSet()");
			
			assertSame(eoper,
					env.getTypeResolver().resolveAdditionalOperation(
							EcorePackage.Literals.EPACKAGE, eoper));
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.getUniqueClassifierNames()->size()");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
		
		// verify the loading of an environment from a resource
		OCL newOCL = OCL.newInstance(
				env.getFactory(),
				env.getTypeResolver().getResource());
        
        EOperation newOper = newOCL.getEnvironment().getTypeResolver().resolveAdditionalOperation(
                EcorePackage.Literals.EPACKAGE, eoper);
        assertNotSame(eoper, newOper);
	}
	
	/**
	 * Tests the serialization of an expression referencing an additional property.
	 */
	public void test_additionalPropertySerialization() {
		helper.setContext(EcorePackage.Literals.EPACKAGE);
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		
		EStructuralFeature esf = null;
		
		try {
			esf = helper.defineAttribute(
					"uniqueClassifierNames : Set(String) = " +
					"self.eClassifiers->collect(name)->asSet()");
			
			assertSame(esf,
					env.getTypeResolver().resolveAdditionalAttribute(
							EcorePackage.Literals.EPACKAGE, esf));
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
		
		OCLExpression<EClassifier> expr = parseExpression(
				EcorePackage.Literals.EPACKAGE,
				"self.uniqueClassifierNames->size()");

		String toStringForm = expr.toString();
		String serialForm = serialize(expr);
		
		expr = loadExpression(serialForm);
		
		validate(expr);  // ensure that it is structurally valid
		assertEquals(toStringForm, expr.toString());  // should "look" the same
		
		// verify the loading of an environment from a resource
		OCL newOCL = OCL.newInstance(
				env.getFactory(),
				env.getTypeResolver().getResource());
		
        EStructuralFeature newSF = newOCL.getEnvironment().getTypeResolver().resolveAdditionalAttribute(
                EcorePackage.Literals.EPACKAGE, esf);
        assertNotSame(esf, newSF);
	}
    
    /**
     * Tests the serialization of TypeTypes.
     */
    public void test_typeTypeSerialization_183494() {
        OCLExpression<EClassifier> expr = parseExpression(
                EcorePackage.Literals.EPACKAGE,
                "EPackage.allInstances()");

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
        assertSame(EcorePackage.Literals.EPACKAGE, typeType.getReferredType());
    }
    
    /**
     * Tests that the OclType constant is not serialized.
     */
    public void test_OclType_serialization_226455() {
        TypeResolver<EClassifier, EOperation, EStructuralFeature> resolver = ocl
				.getEnvironment().getTypeResolver();
        
        EClassifier oclType = resolver.resolve(getOCLStandardLibrary().getOclType());
        assertSame(getOCLStandardLibrary().getOclType(), oclType);
        assertTrue(resolver.getResource().getContents().isEmpty());
    }
    
    /**
     * Tests for appropriate resolution of 'typespec' as in oclIsKindOf() operation.
     */
    public void test_typespec_resolution_226455() {
        parseExpression(
                EcorePackage.Literals.EPACKAGE,
                "self.eClassifiers->any(oclIsKindOf(EClass))");

        Resource res = ocl.getEnvironment().getTypeResolver().getResource();
        EPackage typesPackage = null;
        for (EObject next : res.getContents()) {
        	if ((next instanceof EPackage)
        			&& "types".equals(((EPackage) next).getName())) {
        		typesPackage = (EPackage) next;
        		break;
        	}
        }
        assertNotNull(typesPackage);
        
        assertEquals(1, typesPackage.getEClassifiers().size());
        
        EClassifier first = typesPackage.getEClassifiers().get(0);
        assertTrue(first instanceof TypeType);
        assertSame(EcorePackage.Literals.ECLASS, ((TypeType) first).getReferredType());
    }
    
    public void test_referenceToGenericOCLExpressionsPackage_214878() {
        EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("foo");
        
        EClass eclass = EcoreFactory.eINSTANCE.createEClass();
        eclass.setName("Foo");
        epackage.getEClassifiers().add(eclass);
        
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setName("expr");
        ref.setEType(ExpressionsPackage.Literals.OCL_EXPRESSION);
        eclass.getEStructuralFeatures().add(ref);
        
        String serialForm = serialize(epackage);
        
        epackage = load(serialForm, EPackage.class);
        eclass = (EClass) epackage.getEClassifier("Foo");
        assertNotNull(eclass);
        assertFalse(eclass.eIsProxy());
        
        ref = (EReference) eclass.getEStructuralFeature("expr");
        assertNotNull(ref);
        assertFalse(ref.eIsProxy());
        
        assertSame(ExpressionsPackage.Literals.OCL_EXPRESSION, ref.getEType());
        
        // correct loading is one thing.  but the reference must look
        // correct in the serial form, also
        assertFalse(serialForm.contains(Environment.OCL_NAMESPACE_URI + "#//expressions/OCLExpression"));
        assertTrue(serialForm.contains(ExpressionsPackage.eNS_URI + "#//OCLExpression"));
    }
    
    public void test_referenceToGenericOCLTypesPackage_214878() {
        EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("foo");
        
        EClass eclass = EcoreFactory.eINSTANCE.createEClass();
        eclass.setName("Foo");
        epackage.getEClassifiers().add(eclass);
        
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setName("any");
        ref.setEType(TypesPackage.Literals.ANY_TYPE);
        eclass.getEStructuralFeatures().add(ref);
        
        String serialForm = serialize(epackage);
        
        epackage = load(serialForm, EPackage.class);
        eclass = (EClass) epackage.getEClassifier("Foo");
        assertNotNull(eclass);
        assertFalse(eclass.eIsProxy());
        
        ref = (EReference) eclass.getEStructuralFeature("any");
        assertNotNull(ref);
        assertFalse(ref.eIsProxy());
        
        assertSame(TypesPackage.Literals.ANY_TYPE, ref.getEType());
        
        // correct loading is one thing.  but the reference must look
        // correct in the serial form, also
        assertFalse(serialForm.contains(Environment.OCL_NAMESPACE_URI + "#//types/AnyType"));
        assertTrue(serialForm.contains(TypesPackage.eNS_URI + "#//AnyType"));
    }
    
    public void test_referenceToGenericOCLUtilitiesPackage_214878() {
        EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("foo");
        
        EClass eclass = EcoreFactory.eINSTANCE.createEClass();
        eclass.setName("Foo");
        epackage.getEClassifiers().add(eclass);
        
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setName("ast");
        ref.setEType(UtilitiesPackage.Literals.AST_NODE);
        eclass.getEStructuralFeatures().add(ref);
        
        String serialForm = serialize(epackage);
        
        epackage = load(serialForm, EPackage.class);
        eclass = (EClass) epackage.getEClassifier("Foo");
        assertNotNull(eclass);
        assertFalse(eclass.eIsProxy());
        
        ref = (EReference) eclass.getEStructuralFeature("ast");
        assertNotNull(ref);
        assertFalse(ref.eIsProxy());
        
        assertSame(UtilitiesPackage.Literals.AST_NODE, ref.getEType());
        
        // correct loading is one thing.  but the reference must look
        // correct in the serial form, also
        assertFalse(serialForm.contains(Environment.OCL_NAMESPACE_URI + "#//utilities/ASTNode"));
        assertTrue(serialForm.contains(UtilitiesPackage.eNS_URI + "#//ASTNode"));
    }
    
    public void test_referenceToOCLEcoreMetamodel_214878() {
        EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("foo");
        
        EClass eclass = EcoreFactory.eINSTANCE.createEClass();
        eclass.setName("Foo");
        epackage.getEClassifiers().add(eclass);
        
        EReference ref = EcoreFactory.eINSTANCE.createEReference();
        ref.setName("expr");
        ref.setEType(org.eclipse.ocl.ecore.EcorePackage.Literals.OCL_EXPRESSION);
        eclass.getEStructuralFeatures().add(ref);
        
        String serialForm = serialize(epackage);
        
        epackage = load(serialForm, EPackage.class);
        eclass = (EClass) epackage.getEClassifier("Foo");
        assertNotNull(eclass);
        assertFalse(eclass.eIsProxy());
        
        ref = (EReference) eclass.getEStructuralFeature("expr");
        assertNotNull(ref);
        assertFalse(ref.eIsProxy());
        
        assertSame(org.eclipse.ocl.ecore.EcorePackage.Literals.OCL_EXPRESSION, ref.getEType());
        
        // correct loading is one thing.  but the reference must look
        // correct in the serial form, also
        assertFalse(serialForm.contains(Environment.OCL_NAMESPACE_URI + "#//ecore/OCLExpression"));
        assertTrue(serialForm.contains(org.eclipse.ocl.ecore.EcorePackage.eNS_URI + "#//OCLExpression"));
    }
	
	//
	// Framework methods
	//
	
	@Override
    protected void setUp() {
        //FIXME:  Need to use extrinsic IDs because lookup fails on hierarchical
        //    name-based fragments owing to %-encoding of the names in references
        res = new XMIResourceImpl() {
            @Override
            protected boolean useIDs() {
                return true;
            }
            
            @Override
            protected boolean useUUIDs() {
                return true;
            }
        };
		res.setURI(URI.createFileURI("/tmp/ocltest.xmi"));
        ((XMLResource) res).setEncoding("UTF-8");
		
        super.setUp();

        resourceSet.getResources().add(res);
    }
    
    @Override
    protected OCL createOCL() {
//    	OCL ocl = super.createOCL();
        EcoreEnvironmentFactory factory = new EcoreEnvironmentFactoryWithHiddenOpposites(resourceSet.getPackageRegistry());
        EcoreEnvironment environment = (EcoreEnvironment) factory.loadEnvironment(res);

//        EcoreEnvironmentFactory factory = ocl.;
        
        
//		EcoreEnvironment result = new EcoreEnvironment(resourceSet.getPackageRegistry(), res);
//		result.setFactory(this);
        
        
        return OCLWithHiddenOpposites.newInstance(environment);
    }
	
	protected OCLExpression<EClassifier> parseExpression(
			EClassifier context, String expr) {
		helper.setContext(context);
		
		EcoreEnvironment env = (EcoreEnvironment) ocl.getEnvironment();
		resourceSet.getResources().add(env.getTypeResolver().getResource());
		
		OCLExpression<EClassifier> result = null;
		
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
	protected OCLExpression<EClassifier> loadExpression(String serial) {
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
