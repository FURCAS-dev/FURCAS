/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.query.ocl.tests;

import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;
import org.eclipse.emf.query.conditions.eobjects.EObjectSource;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.ocl.conditions.OclConstraintCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class QueryOclTest
	extends TestCase {

	private Library library = null;
	
	public static Test suite() {
		return new TestSuite(QueryOclTest.class);
	}

	protected void setUp()
		throws Exception {
		super.setUp();
		
		if (library == null) {
			library = EXTLibraryFactory.eINSTANCE.createLibrary();
			library.setName("foo"); //$NON-NLS-1$
			
			Book b = EXTLibraryFactory.eINSTANCE.createBook();
			b.setTitle("bar"); //$NON-NLS-1$
			
			library.getBooks().add(b);
			
			Writer w = EXTLibraryFactory.eINSTANCE.createWriter();
			w.setName("aWriter"); //$NON-NLS-1$
			
			library.getWriters().add(w);
			
			w.getBooks().add(b);
		}
	}
	
	public void testTrivialOclCondition() {
		SELECT s = new SELECT(
			new FROM(new EObjectSource(library)),
			new WHERE(new OclConstraintCondition(
				"true", //$NON-NLS-1$
				null,
				EStructuralFeatureValueGetter.getInstance())));
		
		IQueryResult result = s.execute();
		assertNull(result.getException());
		assertEquals(3, result.size());
	}
	
	public void testSimpleOclCondition() {
		SELECT s = new SELECT(
			new FROM(new EObjectSource(library)),
			new WHERE(new OclConstraintCondition(
				"title = 'bar'", //$NON-NLS-1$
				null,
				EStructuralFeatureValueGetter.getInstance())));
		
		IQueryResult result = s.execute();
		assertNull(result.getException());
		assertEquals(1, result.size());
	}
	
	public void testOclCondition() {
		SELECT s = new SELECT(
			new FROM(new EObjectSource(library)),
			new WHERE(new OclConstraintCondition(
				"author.name = 'aWriter'", //$NON-NLS-1$
				EXTLibraryPackage.eINSTANCE.getBook(),
				EStructuralFeatureValueGetter.getInstance())));
		
		IQueryResult result = s.execute();
		assertNull(result.getException());
		assertEquals(1, result.size());
	}
	
	protected void tearDown()
		throws Exception {
		
		library = null;
		super.tearDown();
	}
}
