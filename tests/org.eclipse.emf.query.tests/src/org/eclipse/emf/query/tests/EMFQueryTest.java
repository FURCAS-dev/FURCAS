/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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

package org.eclipse.emf.query.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.Not;
import org.eclipse.emf.query.conditions.ObjectInstanceCondition;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.internal.statements.QueryStatement;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

/**
 * @author Yasser Lulu 
 */
public class EMFQueryTest
	extends TestCase {

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(EMFQueryTest.class);
	}

	private Collection<EObject> modelElements;

	private Library library;

	private Book instance_Book1;

	private Resource resource;

	protected IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;

	private EClass book_EClass;

	private EAttribute title_EAttribute;
	private EAttribute name_EAttribute;

	private EReference author_EReference;

	public EMFQueryTest(String name) {
		super(name);

	}

	protected IEStructuralFeatureValueGetter getEStructuralFeatureValueGetter() {
		if (eStructuralFeatureValueGetter == null) {
			eStructuralFeatureValueGetter = EStructuralFeatureValueGetter.getInstance();
		}
		return eStructuralFeatureValueGetter;
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		modelElements = new ArrayList<EObject>();
		modelElements.add(getLibrary());

		book_EClass = EXTLibraryPackage.Literals.BOOK;
		title_EAttribute = EXTLibraryPackage.Literals.BOOK__TITLE;
		name_EAttribute = EXTLibraryPackage.Literals.PERSON__LAST_NAME;
		author_EReference = EXTLibraryPackage.Literals.BOOK__AUTHOR;
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		resource = null;
		super.tearDown();
	}

	private void logicalOperatorsTesting() {
		Condition FALSE = new BooleanCondition(false) {

			@Override
			public boolean isSatisfied(Object object) {
				return false;
			}
		};
		Condition TRUE = new BooleanCondition(true) {

			@Override
			public boolean isSatisfied(Object object) {
				return true;
			}
		};

		boolean res_1 = (False() && False() || TRUE());
		boolean res_2 = (FALSE.AND(FALSE).OR(TRUE)).isSatisfied(null);
		assertEquals(res_1, res_2);
		assertTrue(res_1);

		res_1 = (False() && (False() || TRUE()));
		res_2 = (FALSE.AND((FALSE).OR(TRUE))).isSatisfied(null);
		assertEquals(res_1, res_2);
		assertFalse(res_1);
	}

	private boolean False() {
		return false;
	}

	private boolean TRUE() {
		return true;
	}

	public void test_EMFQuery() {
		logicalOperatorsTesting();

		IQueryResult resultSet = getBookInstances_TitledQuery(1, "Book1")//$NON-NLS-1$
			.execute();
		assertTrue(resultSet.size() == 1);
		instance_Book1 = (Book) resultSet.toArray()[0];
		Book bbb = getBookTitled_InstanceBruteForce("Book1"); //$NON-NLS-1$
		assertTrue(bbb.equals(instance_Book1));

		resultSet = getAllBooksQuery().execute();
		assertTrue(resultSet.size() == 6);

		resultSet = getBookInstances_NOT_TitledQuery("Book2").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 5);

		resultSet = getBookInstances_TitledQuery(1, "BookFoo").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 1);

		resultSet = getBooksWithAuthorNamedQuery("foo").execute(); //$NON-NLS-1$
		assertTrue(resultSet.getException() == null);
		assertTrue(resultSet.size() == 0);

		resultSet = getBooksWithAuthorNamedQuery("Doe").execute(); //$NON-NLS-1$
		assertTrue(resultSet.size() == 1);
	}

	public void test_QueryStatementExceptionHandling() {
		final RuntimeException exception = new RuntimeException();
		
		QueryStatement statement = new QueryStatement(false,
				new NullProgressMonitor()) {
			@Override
			public boolean canBeResumed() {
				return false;
			}

			@Override
			protected void doExecute() {
				throw exception;
			}

			@Override
			protected void doResume() {
				doExecute();
			}
		};
		
		final boolean[] addedLogEntry = new boolean[1];
		addedLogEntry[0] = false;
		
		ILogListener logListener = new ILogListener() {
			public void logging(IStatus status, String plugin) {
				if (status.getException() == exception) {
					addedLogEntry[0] = true;
				}
			}
		};
		
		Platform.addLogListener(logListener);
		assertEquals(statement.execute().getException(),exception);
		Platform.removeLogListener(logListener);
		assertTrue(addedLogEntry[0]);
	}
	
	public void test_EAttributeDefaultHandling_RATLC00536311() {
		Book b = EXTLibraryFactory.eINSTANCE.createBook();
		
		EAttribute categoryAttribute = EXTLibraryPackage.eINSTANCE.getBook_Category();
		
		SELECT s = new SELECT(
				new FROM(b),
				new WHERE(new EObjectAttributeValueCondition(categoryAttribute,
							new ObjectInstanceCondition(categoryAttribute.getDefaultValue()),
							EStructuralFeatureValueGetter.getInstance())));
		
		IQueryResult result = s.execute();
		
		assertNull(result.getException());
		assertEquals(1,result.getEObjects().size());
	}
	
	private QueryStatement getBooksWithAuthorNamedQuery(String lastName) {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(book_EClass)
				.AND(new EObjectReferenceValueCondition(author_EReference,
					new EObjectAttributeValueCondition(name_EAttribute,
						new StringValue(lastName),
						getEStructuralFeatureValueGetter()),
					getEStructuralFeatureValueGetter()))));
	}

	private QueryStatement getBookInstances_TitledQuery(int maxCount,
		String bookTitle) {
		return new SELECT(maxCount, new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(book_EClass)
				.AND(new EObjectAttributeValueCondition(title_EAttribute,
					new StringValue(bookTitle),
					getEStructuralFeatureValueGetter()))));
	}

	private QueryStatement getAllBooksQuery() {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectTypeRelationCondition(book_EClass)));
	}

	private QueryStatement getBookInstances_NOT_TitledQuery(String bookTitle) {
		return new SELECT(new FROM(getQueryObjects()), new WHERE(
			new EObjectAttributeValueCondition(
				new EObjectTypeRelationCondition(book_EClass),
				title_EAttribute, new Not(new StringValue(bookTitle)),
				getEStructuralFeatureValueGetter())));
	}

	private Book getBookTitled_InstanceBruteForce(
		final String title) {
		QueryStatement statement = new SELECT(new FROM(getQueryObjects()),
			new WHERE(new EObjectCondition() {

				private boolean shouldPrune;

				@Override
				public boolean shouldPrune(EObject object) {
					return shouldPrune;
				}

				@Override
				public boolean isSatisfied(EObject element) {
					if (element instanceof Book) {
						if (((Book) element).getTitle().equals(title)) {
							shouldPrune = true;
							return true;
						}
					}
					return false;
				}
			}));
		Collection<EObject> resultSet = statement.execute();
		instance_Book1 = ((resultSet.isEmpty()) ? null
			: resultSet.toArray(new Book[resultSet.size()])[0]);
		return instance_Book1;
	}

	private Resource getResource() {
		if (resource == null) {
			resource = new ResourceImpl(URI.createURI("foo:///foo.xml")); //$NON-NLS-1$
			
			List<EObject> contents = resource.getContents();
			
			Library l = EXTLibraryFactory.eINSTANCE.createLibrary();
			l.setName("New Library"); //$NON-NLS-1$
			contents.add(l);
			
			for (int i=1; i<=5; i++) {
				Book book = EXTLibraryFactory.eINSTANCE.createBook();
				book.setTitle("Book"+i); //$NON-NLS-1$
				l.getBooks().add(book);
			}
			
			Book book = EXTLibraryFactory.eINSTANCE.createBook();
			book.setTitle("BookFoo"); //$NON-NLS-1$
			l.getBooks().add(book);
			
			Writer writer = EXTLibraryFactory.eINSTANCE.createWriter();
			writer.setName("John Doe"); //$NON-NLS-1$
			l.getWriters().add(writer);
			
			book.setAuthor(writer);
			
			writer = EXTLibraryFactory.eINSTANCE.createWriter();
			writer.setName("Richard Roe"); //$NON-NLS-1$
			l.getWriters().add(writer);
		}
		return resource;
	}

	private Library getLibrary() {
		if (library == null) {
			library = (Library) (getResource().getContents().get(0));
		}
		return library;
	}

	private Collection<EObject> getQueryObjects() {
		return modelElements;
	}
}