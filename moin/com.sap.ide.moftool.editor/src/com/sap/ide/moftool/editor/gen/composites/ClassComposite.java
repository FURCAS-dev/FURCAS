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

public class ClassComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofClass> {

	private org.eclipse.swt.widgets.Button is_leaf = null;

	private org.eclipse.swt.widgets.Button is_root = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	private org.eclipse.swt.widgets.Button is_abstract = null;

	private org.eclipse.swt.widgets.Text name = null;

	private org.eclipse.jface.viewers.ComboViewer visibility = null;

	public ClassComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.ClassComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.ClassComposite_Annotation, 3, false, rootComposite, toolkit);

		visibility = createCombo(Messages.ClassComposite_Visibility, true, rootComposite, toolkit);

		is_root = createCheckbox(Messages.ClassComposite_IsRoot, false, rootComposite, toolkit);

		is_leaf = createCheckbox(Messages.ClassComposite_IsLeaf, false, rootComposite, toolkit);

		is_abstract = createCheckbox(Messages.ClassComposite_IsAbstract, false, rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.MofClass refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofClass.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofClass.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		bincCombobox(visibility, dbc, refObject, com.sap.tc.moin.repository.mmi.model.MofClass.DESCRIPTORS.VISIBILITY());

		org.eclipse.core.databinding.observable.value.IObservableValue is_rootModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofClass.DESCRIPTORS.IS_ROOT());
		bindCheckbox(is_root, dbc, is_rootModel);

		org.eclipse.core.databinding.observable.value.IObservableValue is_leafModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofClass.DESCRIPTORS.IS_LEAF());
		bindCheckbox(is_leaf, dbc, is_leafModel);

		org.eclipse.core.databinding.observable.value.IObservableValue is_abstractModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.MofClass.DESCRIPTORS.IS_ABSTRACT());
		bindCheckbox(is_abstract, dbc, is_abstractModel);

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
