/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: AbstractFontPropertySection.java,v 1.2 2008/12/04 14:58:20 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * An abstract Font section used to select a Font.
 * 
 * Creation 29 sept. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractFontPropertySection extends AbstractTabbedPropertySection {

	/**
	 * The text displayed in the Text widget
	 */
	private Text fontText;

	private CLabel fontLabel;

	private Button fontButton;

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {
		fontLabel = getWidgetFactory().createCLabel(composite, getLabelText());

		fontText = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
		fontText.setEditable(false);

		fontButton = getWidgetFactory().createButton(composite, Messages.AbstractFontPropertySection_Change, SWT.PUSH);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(fontText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		fontLabel.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(fontLabel, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(fontButton, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		fontText.setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(fontLabel, ITabbedPropertyConstants.VSPACE, SWT.CENTER);
		fontButton.setLayoutData(data);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
	 */
	protected void hookListeners() {
		fontButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				handleButtonPressed();
			}
		});
	}

	/**
	 * Called when the selected font changes
	 */
	protected void handleButtonPressed() {
		FontDialog ftDialog = new FontDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		ftDialog.setFontList(getFontValue().getFontData());
		FontData fData = ftDialog.open();

		if (fData != null) {
			createCommand(getFontValue(), new Font(null, fData));
		}
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		fontText.setEnabled(!isReadOnly());
		fontButton.setEnabled(!isReadOnly());
		fontText.setText(StringConverter.asString(getFontValue().getFontData()));
	}

	/**
	 * Get the new Font value of the font feature for the section.
	 * 
	 * @return the Font value of the feature.
	 */
	protected abstract Font getFontValue();

}
