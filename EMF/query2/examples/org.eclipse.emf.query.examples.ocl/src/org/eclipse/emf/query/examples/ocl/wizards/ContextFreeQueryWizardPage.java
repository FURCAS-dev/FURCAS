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

package org.eclipse.emf.query.examples.ocl.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.examples.ocl.internal.l10n.QueryOCLMessages;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * A wizard the prompts the user for a context-free OCL constraint condition
 * expression and context type.  Performs validation of the OCL expression.
 */
class ContextFreeQueryWizardPage
	extends WizardPage
	implements IOCLQueryWizardPage {

	private static String TITLE = QueryOCLMessages.cfQuery_title;
	private static String CONDITION_PROMPT = QueryOCLMessages.cfQuery_prompt_condition;
	private static String CONDITION_DEFAULT = QueryOCLMessages.cfQuery_default_condition;
	
	private Text conditionText;
	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;
	
	/**
	 * Initializes me.
	 */
	public ContextFreeQueryWizardPage() {
		super("main", TITLE, null); //$NON-NLS-1$
	}

	public void createControl(Composite parent) {
		setMessage(QueryOCLMessages.oclQuery_message_wizard);
		
		Composite page = new Composite(parent, SWT.NONE);
		page.setLayout(new GridLayout(1, false));
		
		Label prompt = new Label(page, SWT.NONE);
		prompt.setText(CONDITION_PROMPT);
		
		// text area for user to enter OCL condition.  Force left-to-right
		//   orientation because the OCL language is based on English
		conditionText = new Text(page, SWT.BORDER | SWT.MULTI | SWT.LEFT_TO_RIGHT);
		conditionText.setLayoutData(new GridData(GridData.FILL_BOTH));
		conditionText.setText(CONDITION_DEFAULT);
		
		conditionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(validatePage());
			}});
		
		setControl(page);
		
		// validate and compute the default settings
		setPageComplete(validatePage());
	}
	
	/**
	 * Validates the page input.
	 * 
	 * @return <code>true</code> if I can finish; <code>false</code>, otherwise
	 */
	private boolean validatePage() {
		boolean result = true;
		
		try {
			String text = conditionText.getText();
			
            OCL ocl = OCL.newInstance();
			condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
                ocl.getEnvironment(),
				text,
				null);
			
			setErrorMessage(null);
		} catch (Exception e) {
			result = false;
			setErrorMessage(e.getLocalizedMessage());
		}
		
		return result;
	}
	
	public BooleanOCLCondition<EClassifier, EClass, EObject> getCondition() {
		return condition;
	}
	
	/* (non-Javadoc)
	 * Redefines/Implements/Extends the inherited method.
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

}
