/**
 * <copyright>
 *
 * Copyright (c) 2003, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Kiril Mitov - Enumerator cast for EMF 2.3 compatibility
 * 
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.examples.statements.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.BookCategory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.query.conditions.ObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.examples.statements.internal.l10n.QueryStatementsMessages;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.dialogs.ListDialog;

/**
 * This action delegate queries user for the name of a type, then uses the query
 * APIs to find the properties of that type, and select them.
 */
public class SelectWritersDelegate
	extends AbstractQueryDelegate {

	/**
	 * InputDialog default value
	 */
	private static final BookCategory DEFAULT_VALUE = BookCategory.MYSTERY_LITERAL;

	/**
	 * Constructor
	 */
	public SelectWritersDelegate() {
		super(QueryStatementsMessages.selectWriters_title,
			QueryStatementsMessages.selectWriters_inputDialog_message,
			QueryStatementsMessages.selectWriters_message_notFound);
	}

	@Override
	protected Collection<EObject> performQuery(Object value)
		throws Exception {
		if (null == selectedEObjects) {
			throw new NullPointerException("Argument 'context' is null"); //$NON-NLS-1$
		}
		if (null == value) {
			throw new NullPointerException("Argument 'value' is null"); //$NON-NLS-1$
		}

		// Get the category
		BookCategory category = (BookCategory)value;
		if (category == null) {
			throw new NullPointerException("Specified category is invalid"); //$NON-NLS-1$
		}

		/*
		 * Looking for writers whose authored books of the specified category
		 */
		EObjectCondition condition = new EObjectReferenceValueCondition(
			new EObjectTypeRelationCondition(EXTLibraryPackage.eINSTANCE
				.getWriter()), EXTLibraryPackage.eINSTANCE.getWriter_Books(),
			new EObjectAttributeValueCondition(EXTLibraryPackage.eINSTANCE
				.getBook_Category(), new ObjectInstanceCondition(category)));

		// Build the select query statement
		SELECT statement = new SELECT(
			new FROM(selectedEObjects), 
			new WHERE(condition)
		);

		// Execute query
		return statement.execute();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.query.examples.statements.actions.AbstractQueryDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		final List<BookCategory> contents = BookCategory.VALUES;
		
		ListDialog dialog = new ListDialog(shell);
		dialog.setTitle(title);
		dialog.setInput(contents);
		dialog.setInitialElementSelections(Collections.singletonList(DEFAULT_VALUE));
		dialog.setContentProvider(new IStructuredContentProvider() {
			public void dispose() {
				// nothing to dispose
			}

			public Object[] getElements(Object inputElement) {
				if (contents != null && contents == inputElement) {
					return contents.toArray();
				}
				return new Object[0];
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// Do nothing.
			}
		});
		dialog.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Enumerator) {
					return ((Enumerator)element).getName();
				}
				return null;
			}
		});
		dialog.setMessage(QueryStatementsMessages.selectWriters_inputDialog_message);
		dialog.setBlockOnOpen(true);
		
		
		if (Window.OK == dialog.open()) {
			try {
				Collection<EObject> result = performQuery(dialog.getResult()[0]);
				if (result.isEmpty()) {
					MessageDialog
						.openInformation(shell, title, notFoundMessage);
				} else {
					this.editor.setSelectionToViewer(result);
				}
			} catch (Exception e) {
				// Exceptions are not expected
				MessageDialog.openInformation(shell, title, MESSAGE_EXCEPTION);
				throw new RuntimeException(e);
			}
		}
	}
	

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		
		if (action.isEnabled()) {
			// Ensure that the selection is a selection of library(ies).
			for (EObject o : selectedEObjects) {
				if (!(o instanceof Library)) {
					action.setEnabled(false);
					return;
				}
			}
		}
	}
}