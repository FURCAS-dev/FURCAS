/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLResource.java,v 1.14 2007/10/15 22:19:22 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ocl.examples.interpreter.console.text.OCLDocument;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.util.ToStringVisitor;


/**
 * A resource for loading and saving OCL expressions.
 */
public class OCLResource
	extends XMIResourceImpl {

    private static Map<String, Object> saveOptions = new java.util.HashMap<String, Object>();
    
    static {
        saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
    }
    
	/**
	 * Initializes me with my URI.
	 * 
	 * @param uri my URI
	 */
	public OCLResource(URI uri) {
		super(uri);
	}
	
	@Override
	protected boolean useIDs() {
	    return true;
	}
	
	@Override
	protected boolean useUUIDs() {
	    return true;
	}
	
	/**
	 * Loads an OCL expression from the specified <code>path</code>.  The
	 * OCL expression is converted to a string using a custom AST visitor that
	 * renders the string representation.
	 * 
	 * @param path the absolute path of the XMI file to load
	 * @return the string representation of the OCL expression, if found
	 * @throws IOException if anything goes wrong in loading the XMI file
	 */
	public static String load(String path) throws IOException {
		String result = null;
		
		ResourceSet rset = new ResourceSetImpl();
		
		// create and load the resource
		OCLResource res = new OCLResource(URI.createFileURI(path));
		rset.getResources().add(res);
		
		res.load(Collections.EMPTY_MAP);
		
		OCLExpression<Object> expr = res.getOCLExpression();
		if (expr != null) {
			result = expr.accept(ToStringVisitor.getInstance(expr));
		}
		
		return result;
	}
	
	/**
	 * Saves the specified OCL expression to an XMI file.
	 * 
	 * @param path the fully-qualified path of the XMI file to save
	 * @param document the current OCL document
	 * @param expression the expression to save
	 * 
	 * @throws RuntimeException if anything goes wrong in parsing
	 * @throws IOException if anything goes wrong in saving
	 * @throws OCLParsingException if anything goes wrong in parsing
	 */
	public static void save(String path, OCLDocument document, String expression)
			throws IOException, ParserException {
		final OCLResource res = new OCLResource(URI.createFileURI(path));
		
		// create an OCL helper to do our parsing
        OCL<?, Object, ?, ?, ?, ?, ?, ?, ?, Object, ?, ?> ocl =
            document.getOCLFactory().createOCL(document.getModelingLevel(), res);
        OCLHelper<Object, ?, ?, Object> helper = ocl.createOCLHelper();
        
        // set our helper's context classifier to parse against it
        ConstraintKind kind = document.getModelingLevel().setContext(
            helper, document.getOCLContext(), document.getOCLFactory());
		
		OCLExpression<Object> parsed = null;
        
        switch (document.getModelingLevel()) {
            case M2:
                parsed = helper.createQuery(expression);
                break;
            case M1:
                Object constraint = helper.createConstraint(kind, expression);
                parsed = ocl.getEnvironment().getUMLReflection().getSpecification(
                    constraint).getBodyExpression();
                break;
        }
        
		// add the AST to the resource and save it
		res.setOCLExpression(parsed);
		
		res.save(saveOptions);
	}
	
	/**
	 * Sets my contents to the specified OCL expression.
	 * 
	 * @param expr an OCL expression
	 */
	public void setOCLExpression(OCLExpression<Object> expr) {
		// add my expression as the first root, because I already contain
		//    variables and EPackages defining dynamically-generated types
		getContents().add(0, expr);
	}
	
	/**
	 * Obtains the OCL expression that I store.
	 * 
	 * @return my OCL expression
	 */
	@SuppressWarnings("unchecked")
	public OCLExpression<Object> getOCLExpression() {
		OCLExpression<Object> result = null;
		
		if (!getContents().isEmpty()) {
			result = (OCLExpression<Object>) getContents().get(0);
		}
		
		return result;
	}
}
