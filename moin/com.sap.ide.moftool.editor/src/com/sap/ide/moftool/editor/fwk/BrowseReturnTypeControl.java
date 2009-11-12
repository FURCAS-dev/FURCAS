package com.sap.ide.moftool.editor.fwk;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;

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

import com.sap.ide.moftool.editor.core.commands.ChangeReturnTypeCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteModelElementCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.MoinUpdateValueStrategy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor;

public class BrowseReturnTypeControl extends Composite {

	private class MofTypeProposalProvider implements IContentProposalProvider {

		private final class ContentProposal implements IContentProposal, Comparable<IContentProposal> {
			private final Classifier classifier;
			String qualifiedPackageName = null;
			String qualifiedName = null;

			private ContentProposal(Classifier classifier) {
				this.classifier = classifier;
				qualifiedPackageName = MofService
						.getQualifiedNameAsString(classifier.getContainer().getQualifiedName());
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
	private Button browseButton;
	private Button deleteButton;
	private Connection connection;
	private Operation operation;
	

	public BrowseReturnTypeControl(FormToolkit formToolkit, final Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(3, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);
		textWidget = formToolkit.createText(this, ""); //$NON-NLS-1$
		textWidget.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		ContentAssistCommandAdapter adapter = new ContentAssistCommandAdapter(textWidget, new TextContentAdapter(),
				new MofTypeProposalProvider(), null, null, true);
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		browseButton = formToolkit.createButton(this, LocalizationMessages.BrowseReturnTypeControl_0_XBUT, SWT.PUSH);
		browseButton.setLayoutData(new GridData());
		browseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectClassifierDialog scd = new SelectClassifierDialog(parent.getShell(), getConnection(), operation, TypeFilter.All);
				if (scd.open() == SelectClassifierDialog.OK) {
					textWidget.setText((String) ConverterUtil.Ui.ModelElement2QualifiedName.convert(scd.getFirstResult()));
					if ((scd.getFirstResult() != null) && (scd.getFirstResult() instanceof Classifier)) {
						Classifier selectedType = (Classifier)scd.getFirstResult();
						ChangeReturnTypeCommand cmd = new ChangeReturnTypeCommand(connection, "", operation, selectedType); //$NON-NLS-1$
						cmd.execute();
					}
				}
			}
		});
		deleteButton = formToolkit.createButton(this, LocalizationMessages.BrowseReturnTypeControl_1_XBUT, SWT.PUSH);
		deleteButton.setLayoutData(new GridData());
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Parameter param = null;
				Parameter retParam = null;
				List<ModelElement> contents = operation.getContents();
				for (ModelElement obj : contents) {
					if (obj instanceof Parameter) {
						param = (Parameter)obj;					
						if(param.getDirection().equals(DirectionKindEnum.RETURN_DIR)){
							retParam = param;
							break;
						}
					}
				}
				if (retParam != null) {			
					DeleteModelElementCommand command = new DeleteModelElementCommand(retParam, connection);
					if (!command.canExecute()) {
						throw new InternalErrorException("Cannot execute delete return type command"); //$NON-NLS-1$
					}
			        command.execute();			        
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
		deleteButton.setEnabled(enabled);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		textWidget.setVisible(visible);
		browseButton.setVisible(visible);
		deleteButton.setVisible(visible);
	}

	private Connection getConnection() {
		return connection;
	}

	public void setInput(Operation op, Parameter retParam, final String errorMessageIfEmpty,
			ReferenceDescriptor<?, ?, ?> referenceDescriptor, DataBindingContext dbc) {
		operation = op;
		connection = ((Partitionable) op).get___Connection();
		IConverter toUiConverter = ConverterUtil.Ui.ModelElement2QualifiedName;
		IConverter toModelConverter = new ConverterUtil.Model.Qn2Classifier(connection);
		

		
		if (retParam == null) {
			textWidget.setText(""); //$NON-NLS-1$
			return;
		}

		ISWTObservableValue text = SWTObservables.observeText(textWidget, SWT.Modify);
		IObservableValue referenceValue = MoinObservables
				.observeValue((ModelElement) retParam, referenceDescriptor);
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
							return new Status(IStatus.ERROR,
									"MofTool", MessageFormat.format("{0}: Type named \"{1}\" could not be found", errorMessageIfEmpty, currentText)); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}

					return Status.OK_STATUS;
				}
			});
		}
		dbc.bindValue(text, referenceValue, toModelStrategy, new MoinUpdateValueStrategy().setConverter(toUiConverter));

	}


	
}
