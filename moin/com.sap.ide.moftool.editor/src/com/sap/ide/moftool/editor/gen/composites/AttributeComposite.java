package com.sap.ide.moftool.editor.gen.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;

import com.sap.ide.moftool.editor.core.service.ModelElementService;

public class AttributeComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Attribute> {

	private com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl multiplicity = null;

	private org.eclipse.swt.widgets.Button is_changeable = null;

	private com.sap.ide.moftool.editor.fwk.BrowseTypeControl type = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	private org.eclipse.jface.viewers.ComboViewer visibility = null;

	private org.eclipse.swt.widgets.Text name = null;

	private org.eclipse.jface.viewers.ComboViewer scope = null;

	public AttributeComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.AttributeComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.AttributeComposite_Annotation, 3, false, rootComposite, toolkit);

		type = createTypeBrowser(Messages.AttributeComposite_Type,
				com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter.All, false, rootComposite, toolkit);

		visibility = createCombo(Messages.AttributeComposite_Visibility, true, rootComposite, toolkit);

		scope = createCombo(Messages.AttributeComposite_Scope, true, rootComposite, toolkit);

		multiplicity = createMultiplicity(Messages.AttributeComposite_Multiplicity, false, rootComposite, toolkit);

		is_changeable = createCheckbox(Messages.AttributeComposite_Changeable, false, rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Attribute refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		type.setInput(refObject, Messages.AttributeComposite_Type, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.TYPE(), dbc);

		bincCombobox(visibility, dbc, refObject, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.VISIBILITY());

		bincCombobox(scope, dbc, refObject, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.SCOPE());

		multiplicity.setInput(refObject, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.MULTIPLICITY(), dbc);

		org.eclipse.core.databinding.observable.value.IObservableValue is_changeableModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Attribute.DESCRIPTORS.IS_CHANGEABLE());
		bindCheckbox(is_changeable, dbc, is_changeableModel);

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
