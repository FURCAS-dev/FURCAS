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
 * $Id: AbstractReferencePropertySection.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.ReferenceViewerComposite;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget let the user to manipulate features with bounds higher than 1
 * This feature is also also non-containment, so the table will display a single
 * button to select the references inside the model
 * 
 * @author Alfredo Serrano
 */
public abstract class AbstractReferencePropertySection extends AbstractListPropertySection {

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	protected void createWidgets(Composite composite) {

		setTable(new ReferenceViewerComposite(composite, new String[] { getLabelText() }, getWidgetFactory()) {

			public void updateSelectedItem(Object data) {
				updateSelection(data);
			}
		});
		getTable().setLabelProvider(getLabelProvider());

		if (getFeature() != null) {
			getTable().setEnabled(getFeature().isChangeable());
		}
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	protected void setSectionData(Composite composite) {
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		getTable().setLayoutData(data);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#hookListeners()
	 */
	protected void hookListeners() {
		// DO NOTHING
	}
}
