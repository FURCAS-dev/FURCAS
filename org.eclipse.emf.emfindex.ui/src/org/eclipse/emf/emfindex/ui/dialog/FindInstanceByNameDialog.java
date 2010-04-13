/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.ui.dialog;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.query.EObjectDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;

import com.google.common.collect.Iterators;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class FindInstanceByNameDialog extends ListDialog {

	protected Text searchControl;

	protected Index index;

	private Label messageLabel;

	private EClass eClass;

	public FindInstanceByNameDialog(Shell parent, EClass eClass, Index index) {
		super(parent);
		this.index = index;
		this.eClass = eClass;
		setTitle("Find instances of " + eClass.getName());
		setMessage("Enter name");
		setAddCancelButton(false);
		setContentProvider(new EObjectContentProvider());
		setLabelProvider(new EObjectDescriptorLabelProvider());
	}

	@Override
	protected int getTableStyle() {
		return super.getTableStyle() | SWT.VIRTUAL;
	}

	@Override
	protected Control createDialogArea(Composite container) {
		Composite parent = (Composite) super.createDialogArea(container);
		messageLabel = new Label(parent, SWT.NONE);
		messageLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		return parent;
	}

	@Override
	protected Label createMessageArea(Composite composite) {
		Label label = super.createMessageArea(composite);
		searchControl = new Text(composite, SWT.BORDER);
		GridData layoutData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		searchControl.setLayoutData(layoutData);
		searchControl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				handleSearchPatternChanged(e);
			}
		});
		return label;
	}

	protected void handleSearchPatternChanged(ModifyEvent e) {
		String searchPattern = searchControl.getText();
		final EObjectDescriptorQuery eObjectDescriptorQuery = new EObjectDescriptorQuery();
		eObjectDescriptorQuery.setIsInstanceOf(eClass);
		eObjectDescriptorQuery.setNameStartsWith(searchPattern);
		QueryResult<EObjectDescriptor> matches = index.executeQueryCommand(new QueryCommand<QueryResult<EObjectDescriptor>>() {
			public QueryResult<EObjectDescriptor> execute(QueryExecutor queryExecutor) {
				return queryExecutor.execute(eObjectDescriptorQuery);
			}
		});
		getTableViewer().setInput(matches);
	}

	class EObjectContentProvider implements IStructuredContentProvider {

		private Iterator<EObjectDescriptor> iterator;

		public void dispose() {
			iterator = null;
		}

		@SuppressWarnings("unchecked")
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			iterator = null;
			if (newInput instanceof Iterable<?>)
				iterator = ((Iterable<EObjectDescriptor>) newInput).iterator();
			else if (newInput instanceof Iterator<?>)
				iterator = (Iterator<EObjectDescriptor>) newInput;
			System.out.println("Input changed " + iterator);
			viewer.refresh();
		}

		public Object[] getElements(Object inputElement) {
			System.out.println("Get elements " + iterator);
			if (iterator != null) {
				Object[] newArray = Iterators.newArray(iterator, Object.class);
				for (Object object : newArray) {
					System.out.println(object);
				}
				return newArray;
			}
			return new Object[] {};
		}
	}

	class EObjectDescriptorLabelProvider implements ILabelProvider {

		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			String string = (element instanceof EObjectDescriptor) ? 
					((EObjectDescriptor)element).getName() : element.toString();
					System.out.println(string);
			return string;
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}

	}

}
