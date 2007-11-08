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
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.examples.statements.actions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Writer;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.examples.statements.internal.l10n.QueryStatementsMessages;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;

/**
 * This action delegate queries user for the name of a type, then uses the query
 * APIs to find the properties of that type, and select them.
 */
public class SelectBooksDelegate
	extends AbstractQueryDelegate {

	/**
	 * Constructor
	 */
	public SelectBooksDelegate() {
		super(QueryStatementsMessages.selectBooks_title,
			QueryStatementsMessages.selectBooks_inputDialog_message,
			QueryStatementsMessages.selectBooks_message_notFound);
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
		
		Writer chosenWriter = (Writer)value;
		String name = chosenWriter.getName();

		/*
		 * Looking for books whose writer name is the specified name
		 */
		EObjectCondition condition = new EObjectReferenceValueCondition(
			new EObjectTypeRelationCondition(EXTLibraryPackage.eINSTANCE.getBook()),
			EXTLibraryPackage.eINSTANCE.getBook_Author(),
			new EObjectAttributeValueCondition(EXTLibraryPackage.eINSTANCE
				.getWriter_Name(), new StringValue(name)));

		// Build the select query statement
		SELECT statement = new SELECT(
			new FROM(chosenWriter.eResource().getContents()), 
			new WHERE(condition));

		// Execute query
		return statement.execute();
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.query.examples.statements.actions.AbstractQueryDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		try {
			Collection<EObject> result = performQuery(selectedEObjects.iterator().next());
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
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.query.examples.statements.actions.AbstractQueryDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		
		if (action.isEnabled()) {
			if (selectedEObjects.size() != 1) {
				action.setEnabled(false);
				return;
			}
			
			if (!(selectedEObjects.iterator().next() instanceof Writer)) {
				action.setEnabled(false);
				return;
			}
		}
	}
}
