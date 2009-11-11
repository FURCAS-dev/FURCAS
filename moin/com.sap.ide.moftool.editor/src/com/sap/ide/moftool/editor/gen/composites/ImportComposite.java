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

public class ImportComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Import> {

	private org.eclipse.swt.widgets.Text name = null;

	private org.eclipse.swt.widgets.Button is_clustered = null;

	private com.sap.ide.moftool.editor.fwk.BrowseTypeControl imported_namespace = null;

	private org.eclipse.jface.viewers.ComboViewer visibility = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	public ImportComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.ImportComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.ImportComposite_Annotation, 3, false, rootComposite, toolkit);

		imported_namespace = createTypeBrowser(Messages.ImportComposite_ImportedNamespace,
				com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter.Imports, false, rootComposite, toolkit);

		visibility = createCombo(Messages.ImportComposite_Visibility, true, rootComposite, toolkit);

		is_clustered = createCheckbox(Messages.ImportComposite_Clustered, false, rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Import refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Import.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Import.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		imported_namespace.setInput(refObject, Messages.ImportComposite_ImportedNamespace,
				com.sap.tc.moin.repository.mmi.model.Import.DESCRIPTORS.IMPORTED_NAMESPACE(), dbc);

		bincCombobox(visibility, dbc, refObject, com.sap.tc.moin.repository.mmi.model.Import.DESCRIPTORS.VISIBILITY());

		org.eclipse.core.databinding.observable.value.IObservableValue is_clusteredModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Import.DESCRIPTORS.IS_CLUSTERED());
		bindCheckbox(is_clustered, dbc, is_clusteredModel);

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
