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

public abstract class ReferenceCompositeBase extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Reference> {

	private com.sap.ide.moftool.editor.fwk.BrowseTypeControl type = null;

	private org.eclipse.swt.widgets.Button is_changeable = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	private com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl multiplicity = null;

	private org.eclipse.swt.widgets.Text name = null;

	private org.eclipse.swt.widgets.Control associationEnd = null;

	public ReferenceCompositeBase(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.ReferenceComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.ReferenceComposite_Annotation, 2, false, rootComposite, toolkit);

		type = createTypeBrowser(Messages.ReferenceComposite_Type,
				com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter.Class, false, rootComposite, toolkit);

		multiplicity = createMultiplicity(Messages.ReferenceComposite_Multiplicity, false, rootComposite, toolkit);

		is_changeable = createCheckbox(Messages.ReferenceComposite_Changeable, false, rootComposite, toolkit);

		associationEnd = createAssociationEnd(rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Reference refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Reference.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Reference.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		type.setInput(refObject, Messages.ReferenceComposite_Type, com.sap.tc.moin.repository.mmi.model.Reference.DESCRIPTORS.TYPE(), dbc);

		multiplicity.setInput(refObject, com.sap.tc.moin.repository.mmi.model.Reference.DESCRIPTORS.MULTIPLICITY(), dbc);

		org.eclipse.core.databinding.observable.value.IObservableValue is_changeableModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Reference.DESCRIPTORS.IS_CHANGEABLE());
		bindCheckbox(is_changeable, dbc, is_changeableModel);

		bindAssociationEnd(dbc, refObject, associationEnd);

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

	protected abstract org.eclipse.swt.widgets.Control createAssociationEnd(Composite rootComposite,
			FormToolkit formToolkit);

	protected abstract void bindAssociationEnd(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Reference refObject,
			org.eclipse.swt.widgets.Control associationEnd);

}
