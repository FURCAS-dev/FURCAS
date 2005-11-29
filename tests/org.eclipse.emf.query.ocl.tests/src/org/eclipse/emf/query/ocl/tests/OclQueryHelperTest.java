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
 * $Id$
 */

package org.eclipse.emf.query.ocl.tests;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.BookCategory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.ocl.conditions.OclConstraintCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
;

/**
 * Tests the {@link OclQueryHelper} class.
 * 
 * @author Christian W. Damus
 */
public class OclQueryHelperTest
	extends TestCase {

	private static final String MYSTERY_BOOK1 = "mysteryBook1"; //$NON-NLS-1$
	private static final String MYSTERY_BOOK2 = "mysteryBook2"; //$NON-NLS-1$
	private static final String BIOGRAPHY_BOOK1 = "biographyBook1"; //$NON-NLS-1$
	private static final String BIOGRAPHY_BOOK2 = "biographyBook2"; //$NON-NLS-1$

	private EXTLibraryPackage extlib;
	private Library library;
	private Writer writer1;

	public OclQueryHelperTest(String name) {
		super(name);
	}

	public void test_executeQueryUsingOclFilter() throws Exception {
		Set result = executeQueryUsingOclFilter(
			library,
			extlib.getBook(),
			"category = BookCategory::Mystery", //$NON-NLS-1$
			new NullProgressMonitor());
		
		assertEquals("Missing query result(s)", 2, result.size()); //$NON-NLS-1$
	}
	
	public Set executeQueryUsingOclFilter(EObject queryRoot, EClass selfType,
			String oclFilter, IProgressMonitor monitor)
		throws InterruptedException {

		if (null == queryRoot) {
			throw new NullPointerException("Argument 'queryRoot' was null"); //$NON-NLS-1$
		}

		if (null == oclFilter) {
			throw new NullPointerException("Argument 'oclFilter' was null"); //$NON-NLS-1$
		}

		if (oclFilter.length() == 0) {
			throw new IllegalArgumentException("Argument 'oclFilter' was empty"); //$NON-NLS-1$
		}

		if (null == monitor) {
			monitor = new NullProgressMonitor();
		}

		// build the OCL condition
		OclConstraintCondition oclCondition = null;

		oclCondition = new OclConstraintCondition(oclFilter, selfType,
				EStructuralFeatureValueGetter.getInstance());

		// build the select query statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, true, new FROM(
			queryRoot), new WHERE(oclCondition), monitor);

		// execute query
		Set results = new HashSet();
		results.addAll(statement.execute());
		return results;
	}

	/** Backward compatibility test for the deprecated method. */
	public void test_RATLC00535288_executeOclStatement_nullResult() throws Exception {
		library.setName(null);
		Set result = executeOclStatement(
			library,
			null,
			"name", //$NON-NLS-1$
			new NullProgressMonitor());
		
		assertTrue("Result set not empty", result.isEmpty()); //$NON-NLS-1$
	}
	
	public Set executeOclStatement(EObject self, EClass selfType,
			String oclStatement, IProgressMonitor monitor)
		throws InterruptedException {

		Object result = evaluate(self, oclStatement, monitor);

		// wrap the result in a set
		Set resultSet = new HashSet();
		if (result instanceof Collection) {
			resultSet.addAll((Collection) result);
		} else {
			if (result != null) {
				resultSet.add(result);
			}
		}

		return resultSet;
	}

	/** Backward compatibility test for the deprecated method. */
	public void test_RATLC00535288_executeOclStatement_singleResult() throws Exception {
		Set result = executeOclStatement(
			library,
			null,
			"name", //$NON-NLS-1$
			new NullProgressMonitor());
		
		assertEquals("Wrong number of results", 1, result.size()); //$NON-NLS-1$
		assertTrue("Wrong result found", result.contains(library.getName())); //$NON-NLS-1$
	}
	
	/** Backward compatibility test for the deprecated method. */
	public void test_RATLC00535288_executeOclStatement_multipleResults() throws Exception {
		Set result = executeOclStatement(
			writer1,
			null,
			"books->select(b|b.category = BookCategory::Mystery)", //$NON-NLS-1$
			new NullProgressMonitor());
		
		assertEquals("Wrong number of results", 2, result.size()); //$NON-NLS-1$
		assertTrue("Wrong results found", //$NON-NLS-1$
			result.contains(getBook(writer1, MYSTERY_BOOK1)) &&
				result.contains(getBook(writer1, MYSTERY_BOOK2)));
	}

	/** Tests the new method. */
	public void test_RATLC00535288_evaluate_nullResult() throws Exception {
		library.setName(null);
		Object result = evaluate(
			library,
			"name", //$NON-NLS-1$
			new NullProgressMonitor());
		
		assertNull("Result not null", result); //$NON-NLS-1$
	}
	
	public Object evaluate(EObject self, String oclExpression,
			IProgressMonitor monitor)
		throws InterruptedException {

		//TODO: Make use of the monitor

		if (null == self) {
			throw new NullPointerException("Argument 'self' was null"); //$NON-NLS-1$
		}

		if (null == oclExpression) {
			throw new NullPointerException("Argument 'oclExpression' was null"); //$NON-NLS-1$
		}

		if (oclExpression.length() == 0) {
			throw new IllegalArgumentException(
				"Argument 'oclExpression' was empty"); //$NON-NLS-1$
		}

		if (null == monitor) {
			monitor = new NullProgressMonitor();
		}

		// Build the OCL query
		Query query = QueryFactory.eINSTANCE.createQuery(oclExpression, self.eClass());

		// Evaluate the OCL expression
		return query.evaluate(self);
	}

	/** Tests the new method. */
	public void test_RATLC00535288_evaluate_singleResult() throws Exception {
		Object result = evaluate(
			library,
			"name", //$NON-NLS-1$
			new NullProgressMonitor());
		
		assertEquals("Wrong result found", library.getName(), result); //$NON-NLS-1$
	}
	
	/** Tests the new method. */
	public void test_RATLC00535288_evaluate_multipleResults() throws Exception {
		Object result = evaluate(
			writer1,
			"books->select(b|b.category = BookCategory::Mystery)", //$NON-NLS-1$
			new NullProgressMonitor());
		
		// result should be a set because the OCL type is OrderedSet(Book).
		//    Note that the set implementation is ordered
		assertTrue("Wrong kind of result", result instanceof Set); //$NON-NLS-1$
		Set setResult = (Set) result;
		
		assertEquals("Wrong number of results", 2, setResult.size()); //$NON-NLS-1$
		
		// test preservation of order
		Iterator iter = setResult.iterator();
		
		assertSame("Wrong results found at index 0", //$NON-NLS-1$
			getBook(writer1, MYSTERY_BOOK1),
			iter.next());
		assertSame("Wrong results found at index 1", //$NON-NLS-1$
			getBook(writer1, MYSTERY_BOOK2),
			iter.next());
	}
	
	//
	// Fixture methods.
	//
	
	protected void setUp()
		throws Exception {
		
		super.setUp();
		
		extlib = EXTLibraryPackage.eINSTANCE;
		EXTLibraryFactory factory = extlib.getEXTLibraryFactory();
		
		library = factory.createLibrary();
		library.setName("Test Library"); //$NON-NLS-1$
		writer1 = factory.createWriter();
		writer1.setName("Writer1");//$NON-NLS-1$
		library.getWriters().add(writer1);
		
		// add books
		Book book = factory.createBook();
		book.setTitle(MYSTERY_BOOK1);
		book.setAuthor(writer1);
		book.setCategory(BookCategory.MYSTERY_LITERAL);
		library.getBooks().add(book);
		
		book = factory.createBook();
		book.setTitle(MYSTERY_BOOK2);
		book.setAuthor(writer1);
		book.setCategory(BookCategory.MYSTERY_LITERAL);
		library.getBooks().add(book);
		
		book = factory.createBook();
		book.setTitle(BIOGRAPHY_BOOK1);
		book.setAuthor(writer1);
		book.setCategory(BookCategory.BIOGRAPHY_LITERAL);
		library.getBooks().add(book);
		
		book = factory.createBook();
		book.setTitle(BIOGRAPHY_BOOK2);
		book.setAuthor(writer1);
		book.setCategory(BookCategory.BIOGRAPHY_LITERAL);
		library.getBooks().add(book);
	}
	
	protected void tearDown()
		throws Exception {
		
		writer1 = null;
		library = null;
		extlib = null;
		
		super.tearDown();
	}
	
	private Book getBook(Writer writer, String title) {
		Book result = null;
		
		for (Iterator iter = writer.getBooks().iterator(); (result == null) && iter.hasNext();) {
			Book next = (Book) iter.next();
			
			if (title.equals(next.getTitle())) {
				result = next;
			}
		}
		
		return result;
	}
}
