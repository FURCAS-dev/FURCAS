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

public class ConstraintComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constraint> {

	private org.eclipse.swt.widgets.Text name = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	private org.eclipse.jface.viewers.ComboViewer evaluation_policy = null;

	private org.eclipse.swt.widgets.Text expression = null;

	private org.eclipse.swt.widgets.Text language = null;

	public ConstraintComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.ConstraintComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.ConstraintComposite_Annotation, 3, false, rootComposite, toolkit);

		language = createSingleLineText(Messages.ConstraintComposite_Language, false, rootComposite, toolkit);

		expression = createMultiLineText(Messages.ConstraintComposite_Expression, 2, false, rootComposite, toolkit);

		evaluation_policy = createCombo(Messages.ConstraintComposite_Evaluation, true, rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Constraint refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Constraint.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Constraint.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		org.eclipse.core.databinding.observable.value.IObservableValue languageModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Constraint.DESCRIPTORS.LANGUAGE());
		bindText(language, dbc, languageModel);

		org.eclipse.core.databinding.observable.value.IObservableValue expressionModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Constraint.DESCRIPTORS.EXPRESSION());
		bindText(expression, dbc, expressionModel);

		bincCombobox(evaluation_policy, dbc, refObject, com.sap.tc.moin.repository.mmi.model.Constraint.DESCRIPTORS.EVALUATION_POLICY());

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
