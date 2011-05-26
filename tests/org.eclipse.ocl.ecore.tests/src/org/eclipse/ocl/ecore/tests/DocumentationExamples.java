/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: DocumentationExamples.java,v 1.1 2011/05/09 16:43:53 ewillink Exp $
 */
package org.eclipse.ocl.ecore.tests;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;



/**
 * Tests for the OCL delegate implementations.
 */
@SuppressWarnings("nls")
public class DocumentationExamples extends AbstractTestSuite
{
	public InputStream getInputStream(String fileName) throws MalformedURLException, IOException {
		URI uri = getTestModelURI(fileName);
		URL url = new URL(uri.toString());
		return url.openStream();
	}

	public Library getLibrary() {
		Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
		Book aBook = EXTLibraryFactory.eINSTANCE.createBook();
		aBook.setTitle("Bleak House");
		library.getBooks().add(aBook);
		return library;
	}
	
	/*
	 * This 'test' provides the source text for the 'Parsing OCL Document' example
	 * in org.eclipse.ocl.doc/references/overview/parsingDocuments.html
	 */
	public void test_parsingDocumentsExample() throws IOException, ParserException {
		//-------------------------------------------------------------------------
		//	The OCL Input
		//-------------------------------------------------------------------------
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
		EcoreEnvironmentFactory environmentFactory = new EcoreEnvironmentFactory(registry);
		OCL ocl = OCL.newInstance(environmentFactory);

		// get an OCL text file via some hypothetical API
		InputStream in = getInputStream("/model/parsingDocumentsExample.ocl");

		Map<String, Constraint> constraintMap = new HashMap<String, Constraint>();

		// parse the contents as an OCL document
		try {
		    OCLInput document = new OCLInput(in);
		    
		    List<Constraint> constraints = ocl.parse(document);
		    for (Constraint next : constraints) {
		        constraintMap.put(next.getName(), next);
		        
		        OCLExpression<EClassifier> body = next.getSpecification().getBodyExpression();
		        System.out.printf("%s: %s%n", next.getName(), body);
		    }
		} finally {
		    in.close();
		}
		//-------------------------------------------------------------------------
		//	Accessing the Constraints
		//-------------------------------------------------------------------------
		Library library = getLibrary();  // get library from a hypothetical source

		OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

		// use the constraints defined in the OCL document

		// use the getBooks() additional operation to find a book
		helper.setContext(EXTLibraryPackage.Literals.LIBRARY);
		OCLExpression<EClassifier> query = helper.createQuery(
		    "getBooks('Bleak House')->asSequence()->first()");

		Book book = (Book) ocl.evaluate(library, query);
		System.out.printf("Got book: %s%n", book);

		// use the unique_title constraint to validate the book
		System.out.printf("Validate book: %b%n",
		    ocl.check(book, constraintMap.get("unique_title")));	
	}
}
