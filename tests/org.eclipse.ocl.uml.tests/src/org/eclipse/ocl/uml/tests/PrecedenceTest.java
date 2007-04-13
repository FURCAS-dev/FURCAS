/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrecedenceTest.java,v 1.4 2007/04/13 17:26:23 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Operator precedence tests.
 *
 * @author Christian W. Damus (cwdamus)
 */
public class PrecedenceTest
	extends AbstractTestSuite {

    private Resource res;
    
    private Package pkg;
    private Class class1;

	public PrecedenceTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(PrecedenceTest.class, "Operator Precedence Tests"); //$NON-NLS-1$
	}
    
	/**
	 * Test that let expressions require parenthesis when embedding them in
	 * other expressions.
	 */
    public void test_let() {
        helper.setContext(class1);

        try {
            helper.createInvariant(
                "self.base_Property.redefinedProperty->isEmpty() = false implies \n" + //$NON-NLS-1$
                "   self.base_Property.redefinedProperty->size() = 1 and\n" + //$NON-NLS-1$
                "   let rp : uml::Property =\n" + //$NON-NLS-1$
                "            self.base_Property.redefinedProperty->asSequence()->at(1) in \n" + //$NON-NLS-1$
                "     self.base_Property.name = rp.name and\n" + //$NON-NLS-1$
                "     self.base_Property.type = rp.type"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        helper.setContext(getMetaclass("NamedElement")); //$NON-NLS-1$
        
        try {
            helper.createInvariant(
                "namespace.getNamesOfMember(\n" + //$NON-NLS-1$
                "   let ne : NamedElement = self in ne)->exists(n |\n" + //$NON-NLS-1$
                "       let len : Integer = n.size() in len = 1)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Test that the "in" expression part of a let expression consumes as much
     * of the input as possible, so that
     * <blockquote><code>let a = ... in a.b</code></blockquote>
     * parses as
     * <blockquote><code>let a = ... in (a.b)</code></blockquote>
     * not as
     * <blockquote><code>(let a = ... in a).b</code></blockquote>
     */
    public void test_let_inExpression_182201() {
        helper.setContext(getMetaclass("NamedElement")); //$NON-NLS-1$

        OCLExpression<Classifier> expr = null;
        
        try {
            expr = helper.createQuery("let ne : NamedElement = self in ne.name"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        assertNotNull(expr);
        assertTrue(expr instanceof LetExp);  // not a PropertyCallExp
        
        LetExp<Classifier, ?> letExp = (LetExp<Classifier, ?>) expr;
        assertTrue(letExp.getIn() instanceof PropertyCallExp);
        
        try {
            expr = helper.createQuery(
                "let n : String = let ne : NamedElement = self in ne.name in n.size()"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        assertNotNull(expr);
        assertTrue(expr instanceof LetExp);  // not a PropertyCallExp
        
        letExp = (LetExp<Classifier, ?>) expr;
        assertTrue(letExp.getIn() instanceof OperationCallExp);
        
        @SuppressWarnings("unchecked")
        OperationCallExp<Classifier, Operation> opCall =
            (OperationCallExp<Classifier, Operation>) letExp.getIn();
        
        assertEquals("size", opCall.getReferredOperation().getName()); //$NON-NLS-1$
        
        expr = letExp.getVariable().getInitExpression();
        assertTrue(expr instanceof LetExp);
        
        letExp = (LetExp<Classifier, ?>) letExp.getVariable().getInitExpression();
        assertTrue(letExp.getIn() instanceof PropertyCallExp);
        
        // a different nesting
        try {
            expr = helper.createQuery(
                "let ne : NamedElement = self in let n : String = ne.name in n.size()"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        assertNotNull(expr);
        assertTrue(expr instanceof LetExp);  // not a PropertyCallExp
        
        letExp = (LetExp<Classifier, ?>) expr;
        assertTrue(letExp.getIn() instanceof LetExp);
        
        letExp = (LetExp<Classifier, ?>) letExp.getIn();
        assertTrue(letExp.getIn() instanceof OperationCallExp);
        
        @SuppressWarnings("unchecked")
        OperationCallExp<Classifier, Operation> opCall2 =
            (OperationCallExp<Classifier, Operation>) letExp.getIn();
        
        assertEquals("size", opCall2.getReferredOperation().getName()); //$NON-NLS-1$
    }
    
    public void test_equality_relational_179249() {
        helper.setContext(class1);
        
        try {
            // this should parse, because "1 < 2" has higher precedence.
            //    If it hadn't, then we would fail to parse because
            //    Integer has no "< Boolean" operation (we would parse this
            //    expression as "1 < (2 = true)"
            
            helper.createInvariant("1 < 2 = true"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    //
    // Framework methods
    //
    
    @Override
    protected void setUp()
        throws Exception {
        
        super.setUp();
        
        // create a little test model for a Smalltalk-like collection class that
        //    defines operations corresponding to OCL iterators
        
        res = new ResourceImpl(URI.createURI("foo://uml")); //$NON-NLS-1$
        
        pkg = UMLFactory.eINSTANCE.createPackage();
        pkg.setName("testpkg"); //$NON-NLS-1$
        
        res.getContents().add(pkg);
        
        class1 = pkg.createOwnedClass("Class1", false); //$NON-NLS-1$
        class1.createOwnedAttribute("base_Property", getMetaclass("Property"));  //$NON-NLS-1$//$NON-NLS-2$
    }
    
    @Override
    protected void tearDown()
        throws Exception {
        
        pkg = null;
        class1 = null;
        
        res.unload();
        res = null;
        
        super.tearDown();
    }
}
