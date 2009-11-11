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

public class PackageComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofPackage> {

	private org.eclipse.swt.widgets.Text annotation = null;

	private org.eclipse.jface.viewers.ComboViewer visibility = null;

	private org.eclipse.swt.widgets.Text name = null;

	public PackageComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.PackageComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.PackageComposite_Annotation, 3, false, rootComposite, toolkit);

		visibility = createCombo(Messages.PackageComposite_Visibility, true, rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.MofPackage refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofPackage.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofPackage.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		bincCombobox(visibility, dbc, refObject, com.sap.tc.moin.repository.mmi.model.MofPackage.DESCRIPTORS.VISIBILITY());

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
