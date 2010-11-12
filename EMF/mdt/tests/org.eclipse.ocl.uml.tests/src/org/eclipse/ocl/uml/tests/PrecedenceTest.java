/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 248869
 *   E.D.Willink - Bug 288040 xor/or/and
 *
 * </copyright>
 *
 * $Id: PrecedenceTest.java,v 1.11 2009/12/18 06:32:29 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.util.OCLUtil;
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
@SuppressWarnings("nls")
public class PrecedenceTest
	extends AbstractTestSuite {

    Resource res;
    Package pkg;
    Class class1;
    
	/**
	 * Test that let expressions require parenthesis when embedding them in
	 * other expressions.
	 */
    public void test_let() {
        helper.setContext(class1);

        try {
            helper.createInvariant(
                "self.base_Property.redefinedProperty->isEmpty() = false implies \n" +
                "   self.base_Property.redefinedProperty->size() = 1 and\n" +
                "   let rp : uml::Property =\n" +
                "            self.base_Property.redefinedProperty->asSequence()->at(1) in \n" +
                "     self.base_Property.name = rp.name and\n" +
                "     self.base_Property.type = rp.type");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
        
        helper.setContext(getMetaclass("NamedElement"));
        
        try {
            helper.createInvariant(
                "namespace.getNamesOfMember(\n" +
                "   let ne : NamedElement = self in ne)->exists(n |\n" +
                "       let len : Integer = n.size() in len = 1)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
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
    @SuppressWarnings("unchecked")
	public void test_let_inExpression_182201() {
        helper.setContext(getMetaclass("NamedElement"));

        OCLExpression<Classifier> expr = null;
        
        try {
            expr = helper.createQuery("let ne : NamedElement = self in ne.name");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }

        assertNotNull(expr);
        assertTrue(expr instanceof LetExp<?, ?>);  // not a PropertyCallExp
        
        LetExp<Classifier, ?> letExp = (LetExp<Classifier, ?>) expr;
        assertTrue(letExp.getIn() instanceof PropertyCallExp<?, ?>);
        
        try {
            expr = helper.createQuery(
                "let n : String = let ne : NamedElement = self in ne.name in n.size()");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }

        assertNotNull(expr);
        assertTrue(expr instanceof LetExp<?, ?>);  // not a PropertyCallExp
        
        letExp = (LetExp<Classifier, ?>) expr;
        assertTrue(letExp.getIn() instanceof OperationCallExp<?, ?>);
        
        OperationCallExp<Classifier, Operation> opCall =
            (OperationCallExp<Classifier, Operation>) letExp.getIn();
        
        assertEquals("size", opCall.getReferredOperation().getName());
        
        expr = letExp.getVariable().getInitExpression();
        assertTrue(expr instanceof LetExp<?, ?>);
        
        letExp = (LetExp<Classifier, ?>) letExp.getVariable().getInitExpression();
        assertTrue(letExp.getIn() instanceof PropertyCallExp<?, ?>);
        
        // a different nesting
        try {
            expr = helper.createQuery(
                "let ne : NamedElement = self in let n : String = ne.name in n.size()");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }

        assertNotNull(expr);
        assertTrue(expr instanceof LetExp<?, ?>);  // not a PropertyCallExp
        
        letExp = (LetExp<Classifier, ?>) expr;
        assertTrue(letExp.getIn() instanceof LetExp<?, ?>);
        
        letExp = (LetExp<Classifier, ?>) letExp.getIn();
        assertTrue(letExp.getIn() instanceof OperationCallExp<?, ?>);
        
        OperationCallExp<Classifier, Operation> opCall2 =
            (OperationCallExp<Classifier, Operation>) letExp.getIn();
        
        assertEquals("size", opCall2.getReferredOperation().getName());
    }
    
    public void test_equality_relational_179249() {
        helper.setContext(class1);
        
        try {
            // this should parse, because "1 < 2" has higher precedence.
            //    If it hadn't, then we would fail to parse because
            //    Integer has no "< Boolean" operation (we would parse this
            //    expression as "1 < (2 = true)"
            
            helper.createInvariant("1 < 2 = true");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
        
	public void test_or_and_precedence() throws ParserException {
        ParsingOptions.setOption(helper.getEnvironment(), ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
        helper.setContext(class1);
        assertTrueWithoutWarning("(true or (false and false)) = true");
        assertTrueWithoutWarning("(true or false.\"and\"(false)) = true");
        assertTrueWithoutWarning("((true or false) and false) = false");
		assertTrueWithoutWarning("(true or false and false) = true");
		ParsingOptions.setOption(helper.getEnvironment(), ParsingOptions.WARN_OF_XOR_OR_AND_PRECEDENCE_CHANGE, true);
        assertTrueWithoutWarning("(true or (false and false)) = true");
        assertTrueWithoutWarning("(true or false.\"and\"(false)) = true");
        assertTrueWithoutWarning("((true or false) and false) = false");
//1.x		assertTrue(check(helper, class1, "(true or false and false) = false"));
		assertTrueWithWarning("(true or false and false) = true", OCLMessages.XorOrAndPrecedence_WARNING);
    }
    
    public void test_xor_or_precedence() throws ParserException {
        ParsingOptions.setOption(helper.getEnvironment(), ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
        helper.setContext(class1);
        assertTrueWithoutWarning("(true xor (false or false)) = true");
        assertTrueWithoutWarning("(true xor false.\"or\"(false)) = true");
        assertTrueWithoutWarning("((true xor false) or true) = true");
		assertTrueWithoutWarning("(true xor false or true) = false");
		ParsingOptions.setOption(helper.getEnvironment(), ParsingOptions.WARN_OF_XOR_OR_AND_PRECEDENCE_CHANGE, true);
        assertTrueWithoutWarning("(true xor (false or false)) = true");
        assertTrueWithoutWarning("(true xor false.\"or\"(false)) = true");
        assertTrueWithoutWarning("((true xor false) or true) = true");
//1.x		assertTrue(check(helper, class1, "(true xor false or true) = true"));
        assertTrueWithWarning("(true xor false or true) = false", OCLMessages.XorOrAndPrecedence_WARNING);
    }

	protected void assertTrueWithWarning(String expression, String warning)throws ParserException {
		helper.createInvariant(expression);
		try {
			OCLUtil.checkForErrorsOrWarnings(helper.getEnvironment());
			fail("Missing warning: " + warning);
		} catch (SemanticException e) {
			System.out.println("Got expected warning: " + e.getLocalizedMessage());
			assertEquals(warning, e.getMessage());
		}
	}

	protected void assertTrueWithoutWarning(String expression)throws ParserException {
		helper.createInvariant(expression);
		OCLUtil.checkForErrorsOrWarnings(helper.getEnvironment());
	}
    
    //
    // Framework methods
    //
    
    @Override
    protected void setUp() {
        
        super.setUp();
        
        // create a little test model for a Smalltalk-like collection class that
        //    defines operations corresponding to OCL iterators
        
        res = new ResourceImpl(URI.createURI("foo://uml"));
        
        pkg = UMLFactory.eINSTANCE.createPackage();
        pkg.setName("testpkg");
        
        res.getContents().add(pkg);
        
        class1 = pkg.createOwnedClass("Class1", false);
        class1.createOwnedAttribute("base_Property", getMetaclass("Property"));
    }
}
