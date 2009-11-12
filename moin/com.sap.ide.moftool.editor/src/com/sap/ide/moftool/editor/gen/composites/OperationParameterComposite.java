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

public class OperationParameterComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Parameter> {

	private org.eclipse.swt.widgets.Text name = null;

	private com.sap.ide.moftool.editor.fwk.BrowseTypeControl type = null;

	private com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl multiplicity = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	public OperationParameterComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.OperationParameterComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.OperationParameterComposite_Annotation, 3, false, rootComposite,
				toolkit);

		type = createTypeBrowser(Messages.OperationParameterComposite_Type,
				com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter.All, false, rootComposite, toolkit);

		multiplicity = createMultiplicity(Messages.OperationParameterComposite_Multiplicity, false, rootComposite,
				toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Parameter refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Parameter.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Parameter.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		type.setInput(refObject, Messages.OperationParameterComposite_Type, com.sap.tc.moin.repository.mmi.model.Parameter.DESCRIPTORS
				.TYPE(), dbc);

		multiplicity.setInput(refObject, com.sap.tc.moin.repository.mmi.model.Parameter.DESCRIPTORS.MULTIPLICITY(), dbc);

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
