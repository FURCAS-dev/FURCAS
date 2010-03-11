/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.sections;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.examples.common.utils.TracingAdapter;
import org.eclipse.ocl.examples.editor.ui.commands.SetResourceURICommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class ResourcePropertySection extends AbstractTypedPropertySection<Resource>
{
	private Adapter adapter = new TracingAdapter() {
		@Override
		public void handleNotification(Notification msg) {
			if ((msg.getEventType() == Notification.SET)
			 && (msg.getNotifier() == element)) {
				int featureID = msg.getFeatureID(Resource.class);
				switch(featureID) {
					case Resource.RESOURCE__ERRORS: refreshErrors(); break;
					case Resource.RESOURCE__IS_MODIFIED: refreshIsModified(); break;
					case Resource.RESOURCE__IS_LOADED: refreshIsLoaded(); break;
					case Resource.RESOURCE__TIME_STAMP: refreshTimeStamp(); break;
					case Resource.RESOURCE__URI: refreshURI(); break;
					case Resource.RESOURCE__WARNINGS: refreshWarnings(); break;
				}
			}
			super.handleNotification(msg);
		}		
	};
	
/*	private SelectionListener isModifiedListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			boolean value = isModified.getSelection();
			EditingDomain domain = getEditingDomain();
			SetResourceURICommand command = new SetResourceURICommand(domain, element, uri);
			domain.getCommandStack().execute(command);
		}		
	}; */
	
	private ModifyListener uriListener = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			if (uriText != null) {
				URI uri = URI.createURI(uriText.getText(), true);
				EditingDomain domain = getEditingDomain();
				SetResourceURICommand command = new SetResourceURICommand(domain, element, uri);
				domain.getCommandStack().execute(command);
			}
		}		
	};

	private Text errorsText;
	private Button isLoaded;
	private Button isLocked;
	private Button isModified;
	private Button isReadOnly;
	private Text timeStampText;
	private Text uriText;
	private Text warningsText;
	
	public ResourcePropertySection() {
		super(Resource.class);
	}

	@Override
	public void aboutToBeHidden() {
		if (element != null)
			element.eAdapters().remove(adapter);
		super.aboutToBeHidden();
	}

	@Override
	public void aboutToBeShown() {
		if (element != null)
			element.eAdapters().add(adapter);
		super.aboutToBeShown();
	}
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		uriText = getWidgetFactory().createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		uriText.setLayoutData(data);
		
		CLabel uriLabel = getWidgetFactory().createCLabel(composite, "URI:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(uriText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0/*, SWT.CENTER*/);
		uriLabel.setLayoutData(data);

		CLabel flagsLabel = getWidgetFactory().createCLabel(composite, "State:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(uriText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(uriText);
		flagsLabel.setLayoutData(data);
		
		isLocked = getWidgetFactory().createButton(composite, "Locked", SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.top = new FormAttachment(uriText);
		isLocked.setLayoutData(data);
		
		isReadOnly = getWidgetFactory().createButton(composite, "Read Only", SWT.CHECK);
		data = new FormData();
		data.left = new FormAttachment(isLocked);
		data.top = new FormAttachment(uriText);
		isReadOnly.setLayoutData(data);
		
		isModified = getWidgetFactory().createButton(composite, "Modified", SWT.CHECK);
		isModified.setEnabled(false);
		data = new FormData();
		data.left = new FormAttachment(isReadOnly);
		data.top = new FormAttachment(uriText);
		isModified.setLayoutData(data);
		
		isLoaded = getWidgetFactory().createButton(composite, "Loaded", SWT.CHECK);
		isLoaded.setEnabled(false);
		data = new FormData();
		data.left = new FormAttachment(isModified);
		data.top = new FormAttachment(uriText);
		isLoaded.setLayoutData(data);

		CLabel timeStampLabel = getWidgetFactory().createCLabel(composite, "Time Stamp:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(uriText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(isLocked);
		timeStampLabel.setLayoutData(data);

		timeStampText = getWidgetFactory().createText(composite, "1234567890");
		timeStampText.setEditable(false);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.top = new FormAttachment(isLocked);
		timeStampText.setLayoutData(data);

		CLabel errorsLabel = getWidgetFactory().createCLabel(composite, "Errors:");
		data = new FormData();
		data.left = new FormAttachment(timeStampText);
		data.top = new FormAttachment(isLocked);
		errorsLabel.setLayoutData(data);

		errorsText = getWidgetFactory().createText(composite, "1234");
		errorsText.setEditable(false);
		data = new FormData();
		data.left = new FormAttachment(errorsLabel);
		data.top = new FormAttachment(isLocked);
		errorsText.setLayoutData(data);

		CLabel warningsLabel = getWidgetFactory().createCLabel(composite, "Warnings:");
		data = new FormData();
		data.left = new FormAttachment(errorsText);
		data.top = new FormAttachment(isLocked);
		warningsLabel.setLayoutData(data);

		warningsText = getWidgetFactory().createText(composite, "1234");
		warningsText.setEditable(false);
		data = new FormData();
		data.left = new FormAttachment(warningsLabel);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(isLocked);
		warningsText.setLayoutData(data);
		
		uriText.addModifyListener(uriListener);
	}

	@Override
	public void dispose() {
		if (uriText != null)
			uriText.removeModifyListener(uriListener);
		super.dispose();
	}

	protected String getErrorsText() {
		if (element == null)
			return "";
		long errors = element.getErrors().size();
		return Long.toString(errors);
	}

	protected boolean getIsLoaded() {
		return element != null ? element.isLoaded() : false;
	}

	protected boolean getIsModified() {
		return element != null ? element.isModified() : false;
	}

	protected String getTimeStampText() {
		if (element == null)
			return "";
		long timeStamp = element.getTimeStamp();
		return Long.toString(timeStamp);
	}

	protected String getURIText() {
		if (element == null)
			return "";
		URI uri = element.getURI();
		return uri != null ? uri.toString() : "<null-uri>";
	}

	protected String getWarningsText() {
		long warnings = element.getWarnings().size();
		return Long.toString(warnings);
	}

	@Override
	public void refresh() {
		refreshErrors();
		refreshIsLoaded();
		refreshIsModified();
		refreshTimeStamp();
		refreshURI();
		refreshWarnings();
	}

	protected void refreshButton(Button button, boolean newValue, SelectionListener listener) {
		boolean oldValue = button.getSelection();
		if (oldValue != newValue) {
			if (listener != null)
				button.removeSelectionListener(listener);
			button.setSelection(newValue);
			if (listener != null)
				button.addSelectionListener(listener);
		}
	}

	protected void refreshErrors() {
		refreshText(errorsText, getErrorsText(), null);
	}

	protected void refreshIsLoaded() {
		refreshButton(isLoaded, getIsLoaded(), null);
	}

	protected void refreshIsModified() {
		refreshButton(isModified, getIsModified(), null);
	}

	protected void refreshText(Text text, String newText, ModifyListener listener) {
		String oldText = text.getText();
		if (!oldText.equals(newText)) {
			if (listener != null)
				text.removeModifyListener(listener);
			text.setText(newText);
			if (listener != null)
				text.addModifyListener(listener);
		}
	}

	protected void refreshTimeStamp() {
		if (timeStampText != null)
			refreshText(timeStampText, getTimeStampText(), null);
	}

	protected void refreshURI() {
		if (uriText != null)
			refreshText(uriText, getURIText(), uriListener);
	}

	protected void refreshWarnings() {
		if (warningsText != null)
			refreshText(warningsText, getWarningsText(), null);
	}
}