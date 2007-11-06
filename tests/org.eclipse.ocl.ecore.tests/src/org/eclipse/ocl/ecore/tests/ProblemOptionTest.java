/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: ProblemOptionTest.java,v 1.2 2007/11/06 19:48:59 cdamus Exp $
 */

package org.eclipse.ocl.ecore.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.util.OCLUtil;

/**
 * Tests for problem-reporting options.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ProblemOptionTest
    extends AbstractTestSuite {

    public ProblemOptionTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(ProblemOptionTest.class, "Problem Option Tests"); //$NON-NLS-1$
    }

    /**
     * Tests the severity option for the <tt>toLower()</tt> and <tt>toUpper()</tt>
     * operations on strings.
     */
    public void test_stringCaseConversion_option() {
        helper.setContext(EcorePackage.Literals.ESTRING);

        BasicEnvironment benv = OCLUtil.getAdapter(ocl.getEnvironment(), BasicEnvironment.class);
        
    	// default severity is warning
    	assertWarning("self.toUpper()"); //$NON-NLS-1$
    	assertWarning("self.toLower()"); //$NON-NLS-1$
        
    	// ignore the operation
    	benv.setOption(ProblemOption.STRING_CASE_CONVERSION, ProblemHandler.Severity.OK);
    	assertOK("self.toUpper()"); //$NON-NLS-1$
    	assertOK("self.toLower()"); //$NON-NLS-1$
        
       	// the operation fails to parse
       	benv.setOption(ProblemOption.STRING_CASE_CONVERSION, ProblemHandler.Severity.ERROR);
       	assertError("self.toUpper()"); //$NON-NLS-1$
       	assertError("self.toLower()"); //$NON-NLS-1$
    }

    /**
     * Tests the severity option for the closure() iterator.
     */
    public void test_closure_option() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        BasicEnvironment benv = OCLUtil.getAdapter(ocl.getEnvironment(), BasicEnvironment.class);
        
    	// default severity is warning
    	assertWarning("self->closure(eSuperPackage)"); //$NON-NLS-1$
        
    	// ignore the closure iterator
    	benv.setOption(ProblemOption.CLOSURE_ITERATOR, ProblemHandler.Severity.OK);
    	assertOK("self->closure(eSuperPackage)"); //$NON-NLS-1$
        
       	// the closure iterator fails to parse
       	benv.setOption(ProblemOption.CLOSURE_ITERATOR, ProblemHandler.Severity.ERROR);
       	assertError("self->closure(eSuperPackage)"); //$NON-NLS-1$
    }

    /**
     * Tests the severity option for the <tt>''</tt> escape in strings.
     */
    public void test_singleQuoteEscape_option() {
        helper.setContext(EcorePackage.Literals.ESTRING);

        BasicEnvironment benv = OCLUtil.getAdapter(ocl.getEnvironment(), BasicEnvironment.class);
        
    	// default severity is warning
    	assertWarning("'this isn''t a nice string'"); //$NON-NLS-1$
        
    	// ignore the single-quote
    	benv.setOption(ProblemOption.STRING_SINGLE_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
    	
    	assertOK("'this isn''t a nice string'"); //$NON-NLS-1$
        
       	// the single-quote escape fails to parse
       	benv.setOption(ProblemOption.STRING_SINGLE_QUOTE_ESCAPE, ProblemHandler.Severity.ERROR);
       	assertError("'this isn''t a nice string'"); //$NON-NLS-1$
    }

    /**
     * Tests the severity option for the <tt>"..."</tt> escape for element names.
     */
    public void test_doubleQuoteElementName_option() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);

        BasicEnvironment benv = OCLUtil.getAdapter(ocl.getEnvironment(), BasicEnvironment.class);
        
    	// default severity is warning
    	assertWarning("self.\"eClassifiers\""); //$NON-NLS-1$
        
    	// ignore the double-quote
    	benv.setOption(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
    	
    	assertOK("self.\"eClassifiers\""); //$NON-NLS-1$
        
       	// the double-quote escape fails to parse
       	benv.setOption(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.ERROR);
       	assertError("self.\"eClassifiers\""); //$NON-NLS-1$
    }
    
    //
    // Framework methods
    //
    
    void assertOK(String oclQuery) {
    	try {
	    	helper.createQuery(oclQuery);
	    	
	    	Diagnostic problem = helper.getProblems();
	    	assertNull(problem);
	    } catch (Exception e) {
	        fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
	    }
    }
    
    void assertWarning(String oclQuery) {
    	try {
	    	helper.createQuery(oclQuery);
	    	
        	Diagnostic problem = helper.getProblems();
        	assertNotNull(problem);
        	assertEquals(Diagnostic.WARNING, problem.getSeverity());
	    } catch (Exception e) {
	        fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
	    }
    }
    
    void assertError(String oclQuery) {
        try {
        	helper.createQuery(oclQuery);
        	
        	fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (ParserException e) {
            // success
        	System.out.println("Got expected exception: " + e.getLocalizedMessage()); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse for unexpected reason: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
}
