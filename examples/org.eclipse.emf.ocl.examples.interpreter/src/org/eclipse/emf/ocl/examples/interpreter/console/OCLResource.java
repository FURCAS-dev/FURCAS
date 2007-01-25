/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: OCLResource.java,v 1.10 2007/01/25 18:34:43 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
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
		
		OCLExpression<EClassifier> expr = res.getOCLExpression();
		if (expr != null) {
			result = expr.accept(ToStringVisitor.getInstance(expr));
		}
		
		return result;
	}
	
	/**
	 * Saves the specified OCL expression to an XMI file.
	 * 
	 * @param path the fully-qualified path of the XMI file to save
	 * @param context the OCL context classifier
	 * @param expr the OCL expression to save
	 * 
	 * @throws RuntimeException if anything goes wrong in parsing
	 * @throws IOException if anything goes wrong in saving
	 * @throws OCLParsingException if anything goes wrong in parsing
	 */
	public static void save(String path, EClassifier context, String expr)
			throws IOException, ParserException {
		final OCLResource res = new OCLResource(URI.createFileURI(path));
		
		// create an OCL helper to do our parsing.  Use the current resource
		//    set's package registry to resolve OCL namespaces with the global
		//    registry as a back-up, and create an environment that persists
		//    the dynamically-generated types in me
        OCL ocl = OCL.newInstance(
            new EcoreEnvironmentFactory(
                new DelegatingPackageRegistry(
                        context.eResource().getResourceSet().getPackageRegistry(),
                        EPackage.Registry.INSTANCE)),
            res);
        OCL.Helper helper = ocl.createOCLHelper();
		
		// use an OCL helper to parse the OCL expression and extract
		//    the AST from it
		helper.setContext(context);
		
		OCLExpression<EClassifier> parsed = helper.createQuery(expr);
        
		// add the AST to the resource and save it
		res.setOCLExpression(parsed);
		
		res.save(saveOptions);
	}
	
	/**
	 * Sets my contents to the specified OCL expression.
	 * 
	 * @param expr an OCL expression
	 */
	public void setOCLExpression(OCLExpression<EClassifier> expr) {
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
	public OCLExpression<EClassifier> getOCLExpression() {
		OCLExpression<EClassifier> result = null;
		
		if (!getContents().isEmpty()) {
			result = (OCLExpression<EClassifier>) getContents().get(0);
		}
		
		return result;
	}
}
