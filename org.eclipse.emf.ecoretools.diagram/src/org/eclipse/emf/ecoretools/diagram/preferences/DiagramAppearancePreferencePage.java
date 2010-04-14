/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: DiagramAppearancePreferencePage.java,v 1.6 2009/05/06 14:19:21 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.preferences;

import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @generated
 */
public class DiagramAppearancePreferencePage extends AppearancePreferencePage {

	private BooleanFieldEditor fillFigureUsingGradient = null;

	private BooleanFieldEditor useShadowOnBorder = null;

	/**
	 * @generated
	 */
	public DiagramAppearancePreferencePage() {
		setPreferenceStore(EcoreDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage#
	 * addFields(org.eclipse.swt.widgets.Composite)
	 */
	protected void addFields(Composite parent) {
		Composite main = createPageLayout(parent);
		createFontAndColorGroup(main);
		createSexyUIGroup(main);
	}

	/**
	 * Create the sexyUI group for the preference page
	 * 
	 * @param parent
	 * @return composite fontAndColourGroup
	 */
	protected Composite createSexyUIGroup(Composite parent) {

		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(3, false));
		Composite composite = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		composite.setLayoutData(gridData);
		group.setText(Messages.DiagramAppearancePreferencePage_SexyUI_FiguresRendering);

		fillFigureUsingGradient = new BooleanFieldEditor(IEcoreToolsPreferenceConstants.PREF_FILL_FIGURE_USING_GRADIENT, Messages.DiagramAppearancePreferencePage_UseGradient, composite);
		addField(fillFigureUsingGradient);

		useShadowOnBorder = new BooleanFieldEditor(IEcoreToolsPreferenceConstants.PREF_USE_SHADOW_ON_BORDER, Messages.DiagramAppearancePreferencePage_ShowShadow, composite);
		addField(useShadowOnBorder);

		createNoteComposite(parent.getFont(), group, Messages.DiagramAppearancePreferencePage_Note, Messages.DiagramAppearancePreferencePage_NoteDescription);

		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 8;
		composite.setLayout(layout);

		return group;
	}
}
