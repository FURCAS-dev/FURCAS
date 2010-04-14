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
 * $Id: AbstractColorPropertySection.java,v 1.2 2008/12/04 14:58:20 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * An abstract Color section used to select a Color.
 * 
 * Creation 29 sept. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractColorPropertySection extends AbstractTabbedPropertySection {

	private ColorSelector colorSelector;

	private CLabel colorLabel;

	private Composite compositeColorSelector;

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {
		colorLabel = getWidgetFactory().createCLabel(composite, getLabelText());
		compositeColorSelector = getWidgetFactory().createFlatFormComposite(composite);
		colorSelector = new ColorSelector(compositeColorSelector);

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		data.right = new FormAttachment(compositeColorSelector, -ITabbedPropertyConstants.HSPACE);
		colorLabel.setLayoutData(data);

		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(colorLabel, 0, SWT.CENTER);
		data.left = new FormAttachment(colorLabel, ITabbedPropertyConstants.HSPACE);
		compositeColorSelector.setLayoutData(data);

	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
	 */
	protected void hookListeners() {
		colorSelector.addListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				handleColorChanged();
			}
		});

	}

	/**
	 * Called when the selected color changes
	 */
	protected void handleColorChanged() {
		createCommand(new Color(null, getRGBValue()), new Color(null, colorSelector.getColorValue()));
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		colorSelector.setEnabled(!isReadOnly());
		colorSelector.setColorValue(getRGBValue());
	}

	/**
	 * Get the new RGB value of the color feature for the section.
	 * 
	 * @return the RGB value of the feature.
	 */
	protected abstract RGB getRGBValue();

}
