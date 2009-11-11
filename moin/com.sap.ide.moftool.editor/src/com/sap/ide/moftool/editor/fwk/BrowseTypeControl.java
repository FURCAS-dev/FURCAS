package com.sap.ide.moftool.editor.fwk;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.MoinUpdateValueStrategy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor;

public class BrowseTypeControl extends Composite {

	public static enum TypeFilter {
		All, Class, Primitive, Imports, DataTypes
	}

	private class MofTypeProposalProvider implements IContentProposalProvider {

		private final class ContentProposal implements IContentProposal, Comparable<IContentProposal> {
			private final Classifier classifier;
			String qualifiedPackageName = null;
			String qualifiedName = null;

			private ContentProposal(Classifier classifier) {
				this.classifier = classifier;
				qualifiedPackageName = MofService.getQualifiedNameAsString(classifier.getContainer().getQualifiedName());
				qualifiedName = MofService.getQualifiedNameAsString(classifier.getQualifiedName());
			}

			public String getLabel() {
				return classifier.getName();
			}

			public String getDescription() {
				return qualifiedPackageName;
			}

			public int getCursorPosition() {
				return getContent().length();
			}

			public String getContent() {
				return qualifiedName;
			}

			public int compareTo(IContentProposal o) {
				return getLabel().compareTo(o.getLabel());
			}
		}

		public IContentProposal[] getProposals(String contents, int position) {
			if (getConnection() == null) {
				return new IContentProposal[0];
			}
			Collection<Classifier> availableClassifiers = MofService.getAvailableClassifiers(connection);
			List<ContentProposal> result = new ArrayList<ContentProposal>();
			for (Classifier classifier : availableClassifiers) {
				ContentProposal contentProposal = new ContentProposal(classifier);
				if (contentProposal.getLabel().toLowerCase().startsWith(contents.toLowerCase())) {
					result.add(contentProposal);
				}
			}

			IContentProposal[] array = result.toArray(new IContentProposal[0]);
			Arrays.sort(array);
			return array;
		}

	}

	private final Text textWidget;
	private final Button browseButton;
	private Connection connection;
	private RefBaseObject modelElement;

	public BrowseTypeControl(FormToolkit formToolkit, final Composite parent, int style, final TypeFilter typeFilter) {
		super(parent, style);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);
		textWidget = formToolkit.createText(this, ""); //$NON-NLS-1$
		textWidget.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		ContentAssistCommandAdapter adapter = new ContentAssistCommandAdapter(textWidget, new TextContentAdapter(),
				new MofTypeProposalProvider(), null, null, true);
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		browseButton = formToolkit.createButton(this, LocalizationMessages.BrowseTypeControl_0_XBUT, SWT.PUSH);
		browseButton.setLayoutData(new GridData());
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectClassifierDialog scd = new SelectClassifierDialog(parent.getShell(), getConnection(), modelElement, typeFilter);
				if (scd.open() == SelectClassifierDialog.OK) {
					textWidget.setText((String) ConverterUtil.Ui.ModelElement2QualifiedName.convert(scd.getFirstResult()));
				}
			}
		});
	}

	public void setText(String text) {
		textWidget.setText(text);
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		textWidget.setEnabled(enabled);
		browseButton.setEnabled(enabled);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		textWidget.setVisible(visible);
		browseButton.setVisible(visible);
	}

	private Connection getConnection() {
		return connection;
	}

	public void setInput(RefBaseObject modelElement, final String errorMessageIfEmpty, ReferenceDescriptor<?, ?, ?> referenceDescriptor,
			DataBindingContext dbc) {
		this.modelElement = modelElement;
		connection = ((Partitionable) modelElement).get___Connection();
		IConverter toUiConverter = ConverterUtil.Ui.ModelElement2QualifiedName;
		IConverter toModelConverter = new ConverterUtil.Model.Qn2Classifier(connection);

		ISWTObservableValue text = SWTObservables.observeText(textWidget, SWT.Modify);
		IObservableValue referenceValue = MoinObservables.observeValue((ModelElement) modelElement, referenceDescriptor);
		// TODO Do we need this?
		IObservableValue nameValue = MoinObservables.observeDetailValue(referenceValue, Classifier.DESCRIPTORS.NAME());

		UpdateValueStrategy toModelStrategy = new MoinUpdateValueStrategy().setConverter(toModelConverter);
		if (errorMessageIfEmpty != null) {
			toModelStrategy.setAfterConvertValidator(new IValidator() {

				public IStatus validate(Object value) {
					if (value == null) {
						String currentText = textWidget.getText();
						if (currentText.trim().equals("")) { //$NON-NLS-1$
							return new Status(IStatus.ERROR,
									"MofTool", MessageFormat.format("{0}: Empty type is not allowed", errorMessageIfEmpty)); //$NON-NLS-1$ //$NON-NLS-2$
						} else {
							return new Status(
									IStatus.ERROR,
									"MofTool", MessageFormat.format("{0}: Type named \"{1}\" could not be found", errorMessageIfEmpty, currentText)); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}

					return Status.OK_STATUS;
				}
			});
		}
		dbc.bindValue(text, referenceValue, toModelStrategy, new MoinUpdateValueStrategy().setConverter(toUiConverter));

	}

	public void setInput(Attribute component, ReferenceDescriptor<Reference, TypedElement, Classifier> type, MoinDataBindingContext dbc) {
		setInput(component, null, type, dbc);
	}

}
