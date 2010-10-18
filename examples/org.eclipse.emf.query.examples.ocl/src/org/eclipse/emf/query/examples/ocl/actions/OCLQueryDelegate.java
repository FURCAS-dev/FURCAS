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
 * $Id: OCLQueryDelegate.java,v 1.4 2007/11/08 23:00:35 cdamus Exp $
 */

package org.eclipse.emf.query.examples.ocl.actions;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.examples.ocl.internal.l10n.QueryOCLMessages;
import org.eclipse.emf.query.examples.ocl.wizards.QueryWithContextWizard;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;


/**
 * Action that pops up a dialog to accept a context metaclass and an OCL
 * condition expression, to query the model.
 */
public class OCLQueryDelegate
	extends AbstractQueryDelegate {

	private static String TITLE = QueryOCLMessages.oclQuery_title;
	private static String NOT_FOUND = QueryOCLMessages.oclQuery_message_notFound;
	
	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;
	
	/**
	 * Initializes me.
	 */
	public OCLQueryDelegate() {
		super();
	}

	@Override
	public void run(IAction action) {
		Collection<EObject> selection = getSelectedObjects();
		
		if (selection == null || selection.isEmpty()) {
			action.setEnabled(false);
			return;
		}

		QueryWithContextWizard wizard = new QueryWithContextWizard();
		WizardDialog dlg = new WizardDialog(getShell(), wizard);
		dlg.setTitle(TITLE);
		dlg.open();
		
		condition = wizard.getCondition();
		
		if (condition != null) {
			try {
				IQueryResult result = performQuery(getSelectedObjects(), null,
					new NullProgressMonitor());
				if (result.isEmpty()) {
					MessageDialog.openInformation(getShell(), TITLE, NOT_FOUND);
				} else {
					selectInEditor(result);
				}
			} catch (Exception e) {
				// Exceptions are not expected
				MessageDialog.openInformation(getShell(), TITLE,
					QueryOCLMessages.message_exception);
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * Implements the inherited method using an OCL query condition.
	 */
	protected IQueryResult performQuery(Collection<EObject> context, String value,
			IProgressMonitor monitor)
		throws Exception {
		if (null == context) {
			throw new NullPointerException("Argument 'context' is null"); //$NON-NLS-1$
		}

		// Build the select query statement
		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(context), new WHERE(condition), monitor);

		// clear the condition for next invocation
		condition = null;
		
		// Execute query
		return statement.execute();
	}
}
