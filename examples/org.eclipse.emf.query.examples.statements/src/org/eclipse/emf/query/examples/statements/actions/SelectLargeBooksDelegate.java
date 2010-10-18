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
 * $Id$
 */

package org.eclipse.emf.query.examples.statements.actions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.examples.statements.internal.l10n.QueryStatementsMessages;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;


/**
 * Selects large books (more than 500 pages).
 */
public class SelectLargeBooksDelegate extends AbstractQueryDelegate {

	public SelectLargeBooksDelegate() {
		super(QueryStatementsMessages.selectLargeBooks_title,
			null,
			QueryStatementsMessages.selectLargeBooks_message_notFound);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.query.examples.statements.actions.AbstractQueryDelegate#performQuery(java.lang.Object)
	 */
	@Override
	protected Collection<EObject> performQuery(Object value)
		throws Exception {
		
		SELECT select = new SELECT(
			new FROM(selectedEObjects),
			new WHERE(new EObjectAttributeValueCondition(
					EXTLibraryPackage.eINSTANCE.getBook_Pages(),
					NumberCondition.between(500, Integer.MAX_VALUE)
				)
			)
		);
		
		return select.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		try {
			Collection<EObject> result = performQuery(null);
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
