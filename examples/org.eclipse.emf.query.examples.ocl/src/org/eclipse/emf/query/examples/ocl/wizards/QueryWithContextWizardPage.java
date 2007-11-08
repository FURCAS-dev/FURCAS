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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.query.examples.ocl.internal.l10n.QueryOCLMessages;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
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
 * A wizard the prompts the user for an OCL constraint condition expression
 * and context type.  Performs validation of the OCL expression.
 */
class QueryWithContextWizardPage
	extends WizardPage
	implements IOCLQueryWizardPage {

	private static String TITLE = QueryOCLMessages.oclQuery_title;
	private static String METACLASS_PROMPT = QueryOCLMessages.oclQuery_prompt_metaclass;
	private static String METACLASS_DEFAULT = QueryOCLMessages.oclQuery_default_metaclass;
	private static String CONDITION_PROMPT = QueryOCLMessages.oclQuery_prompt_condition;
	private static String CONDITION_DEFAULT = QueryOCLMessages.oclQuery_default_condition;
	
	private ComboViewer contextCombo;
	private Text conditionText;
	private BooleanOCLCondition<EClassifier, EClass, EObject> condition;
	
	/**
	 * Initializes me.
	 */
	public QueryWithContextWizardPage() {
		super("main", TITLE, null); //$NON-NLS-1$
	}

	public void createControl(Composite parent) {
		setMessage(QueryOCLMessages.oclQuery_message_wizard);
		
		Composite page = new Composite(parent, SWT.NONE);
		page.setLayout(new GridLayout(2, false));
		
		Label prompt = new Label(page, SWT.NONE);
		prompt.setText(METACLASS_PROMPT);
		
		// combobox from which user selects the OCL conditions' context type
		contextCombo = new ComboViewer(page, SWT.NONE);
		contextCombo.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		fillContextCombo();
		contextCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setPageComplete(validatePage());
			}});
		
		// spacer for nice UI layout
		Label spacer = new Label(page, SWT.NONE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		data.heightHint = 15;
		spacer.setLayoutData(data);
		
		prompt = new Label(page, SWT.NONE);
		prompt.setText(CONDITION_PROMPT);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		prompt.setLayoutData(data);
		
		// text area for user to enter OCL condition.  Force left-to-right
		//   orientation because the OCL language is based on English
		conditionText = new Text(page, SWT.BORDER | SWT.MULTI | SWT.LEFT_TO_RIGHT);
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		conditionText.setLayoutData(data);
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
	 * Fills the combo box with the available context metaclasses.
	 */
	private void fillContextCombo() {
		contextCombo.setContentProvider(new ArrayContentProvider());
		contextCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EClassifier) element).getName();
			}});
		contextCombo.setSorter(new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return ((EClassifier) e1).getName().compareTo(
					((EClassifier) e2).getName());
			}});
		
		// show only EClasses (cannot query for EDataType values)
		List<EClassifier> classes = new LinkedList<EClassifier>(
			EXTLibraryPackage.eINSTANCE.getEClassifiers());
		for (Iterator<EClassifier> iter = classes.iterator(); iter.hasNext();) {
			if (!(iter.next() instanceof EClass)) {
				iter.remove();
			}
		}
		contextCombo.setInput(classes);
		
		// apply the default selection, if possible
		EClassifier defaultSelection = EXTLibraryPackage.eINSTANCE.getEClassifier(
			METACLASS_DEFAULT);
		if (defaultSelection != null) {
			contextCombo.setSelection(
				new StructuredSelection(defaultSelection),
				true);
		}
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
			
			IStructuredSelection selection =
				(IStructuredSelection) contextCombo.getSelection();
			EClass contextClass = (EClass) selection.getFirstElement();
			
            OCL ocl = OCL.newInstance();
            condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
                ocl.getEnvironment(),
                text,
                contextClass);
			
			if (condition.getResultType(null).getInstanceClass() == Boolean.class) {
				setErrorMessage(null);
			} else {
				condition = null;
				result = false;
				setErrorMessage(QueryOCLMessages.oclQuery_message_boolean);
			}
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
