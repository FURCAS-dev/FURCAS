package com.sap.ide.moftool.editor.composites;

import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.ide.moftool.editor.core.commands.AddEnumerationTypeLabelCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteEnumerationTypeLabelCommand;
import com.sap.ide.moftool.editor.core.commands.EditEnumerationTypeLabelCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.gen.composites.EnumLabelCompositeBase;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

public class EnumLabelComposite extends EnumLabelCompositeBase {
	
	private ListViewer mLabelsList = null;
	private Button mAddButton = null;
	private Button mEditButton = null;
	private Button mRemoveButton = null;
	private AddLabelHandler mAddLabelHandler = null;
	private EditLabelHandler mEditLabelHandler = null;
	private RemoveLabelHandler mRemoveLabelHandler = null;


	@Override
	protected void createBindings(MoinDataBindingContext dbc,
			EnumerationType enumType) {


		IObservableList labelsModel = MoinObservables.observeList(enumType, EnumerationType.DESCRIPTORS.LABELS());
		mLabelsList.setInput(labelsModel);	
		
		mAddLabelHandler.setRootObject(enumType);
		mRemoveLabelHandler.setRootObject(enumType);
		mEditLabelHandler.setRootObject(enumType);
		
		if (ModelElementService.isForeignObject(enumType)) {
			mAddButton.setEnabled(false);
			mEditButton.setEnabled(false);
			mRemoveButton.setEnabled(false);
			mLabelsList.getControl().setEnabled(false);
		}
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {

		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));	
		
		List list = new List(rootComposite, SWT.SINGLE | SWT.FLAT | SWT.V_SCROLL);
		list.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TREE_BORDER);
		toolkit.adapt(list, false, false);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.minimumHeight = 200;
		list.setLayoutData(gridData);
		mLabelsList = new ListViewer(list);
		mLabelsList.setContentProvider(new ObservableListContentProvider());
		mLabelsList.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof String) {					
					return (String)element;
				}
				return super.getText(element);
			}
		});
		
		Composite buttonsComposite = toolkit.createComposite(rootComposite, SWT.FILL);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		buttonsComposite.setLayout(gridLayout);
		buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

		// Add button
		mAddButton = toolkit.createButton(buttonsComposite,
				LocalizationMessages.EnumLabelComposite_0_XBUT, SWT.NONE);
		mAddButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		mAddButton.setLayoutData(data);
		mAddButton.setToolTipText(LocalizationMessages.EnumLabelComposite_1_XTOL);
		mAddButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mAddLabelHandler.execute(null);
			}
		});
		mAddLabelHandler = new AddLabelHandler(rootComposite.getShell());
		// Edit button
		mEditButton = toolkit.createButton(buttonsComposite,
				LocalizationMessages.EnumLabelComposite_2_XBUT, SWT.NONE);
		mEditButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		mEditButton.setLayoutData(data);
		mEditButton.setToolTipText(LocalizationMessages.EnumLabelComposite_3_XTOL);
		mEditButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mEditLabelHandler.execute(mLabelsList.getSelection());
			}
		});
		mEditLabelHandler = new EditLabelHandler(rootComposite.getShell());
		// Delete Button
		mRemoveButton = toolkit.createButton(buttonsComposite,
				LocalizationMessages.EnumLabelComposite_4_XBUT, SWT.NONE);
		mRemoveButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		mRemoveButton.setLayoutData(data);
		mRemoveButton.setToolTipText(LocalizationMessages.EnumLabelComposite_5_XTOL);
		mRemoveButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mRemoveLabelHandler.execute(mLabelsList.getSelection());
			}
		});
		mRemoveLabelHandler = new RemoveLabelHandler();
		
		
		
	}

	public EnumLabelComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);		
	}

	@Override
	protected void bindLabel(MoinDataBindingContext dbc, EnumerationType refObject, Control label) {		

	}

	@Override
	protected Control createLabel(Composite rootComposite, FormToolkit formToolkit) {		
		return null;
	}
	
	
	private class AddLabelHandler {

		private Shell mShell = null;
		private EnumerationType mRootObject = null;

		public AddLabelHandler(Shell shell) {			
			mShell = shell;
		}

		public void setRootObject(EnumerationType rootObject) {
			mRootObject = rootObject;
		}

		public Object execute(ExecutionEvent e) {			
			InputDialog dialog = new InputDialog(mShell,
					LocalizationMessages.EnumLabelComposite_6_XMSG,
					LocalizationMessages.EnumLabelComposite_7_XGRP, "", null);   //$NON-NLS-1$
			if (dialog.open() == InputDialog.OK) {
				String entered = dialog.getValue();
				AddEnumerationTypeLabelCommand command = new AddEnumerationTypeLabelCommand(mRootObject,
						entered, ModelAdapter.getInstance().getConnection(mRootObject));
				CommandHandle handle = null;
				try {
					handle = command.execute();
				}
				catch (ExecutionCancelledException ecEx) {
					return null;
				} 
				catch (Exception exc) {
					throw new InternalErrorException(exc);
				}
				if (handle == null) {
					throw new InternalErrorException("Error while executing " + command.getDescription()); //$NON-NLS-1$
				}				

			}
			return null;
		}
	}
	
	
	private class EditLabelHandler {

		private Shell mShell = null;
		private EnumerationType mRootObject = null;
		
		public EditLabelHandler(Shell shell) {
			mShell = shell;
		}
		
		public void setRootObject(EnumerationType rootObject) {
			mRootObject = rootObject;
		}

		public Object execute(ISelection selection) {
			int labelIndex = 0;			
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object object = structuredSelection.getFirstElement();
				if (object instanceof String) {
					String label = (String) object;
					labelIndex = mRootObject.getLabels().indexOf(label);
					InputDialog dialog = new InputDialog(mShell,
							LocalizationMessages.EnumLabelComposite_9_XMSG,
							LocalizationMessages.EnumLabelComposite_10_XGRP, label, null); 
					if (dialog.open() == InputDialog.OK) {
						String entered = dialog.getValue();
						EditEnumerationTypeLabelCommand command = new EditEnumerationTypeLabelCommand(mRootObject,
								labelIndex, entered, ModelAdapter.getInstance().getConnection(mRootObject));
						CommandHandle handle = null;
						try {
							handle = command.execute();
						}
						catch (ExecutionCancelledException ecEx) {
							return null;
						} 
						catch (Exception e) {
							throw new InternalErrorException(e);
						}
						if (handle == null) {
							throw new InternalErrorException("Error while executing " + command.getDescription()); //$NON-NLS-1$
						}						

					}
				}
			}
			return null;
		}
	}
	
	
	private class RemoveLabelHandler {

		private EnumerationType mRootObject = null;
		
		public void setRootObject(EnumerationType rootObject) {
			mRootObject = rootObject;
		}

		public Object execute(ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Iterator<?> it = structuredSelection.iterator();
				while (it.hasNext()) {
					Object object = it.next();
					if (object instanceof String) {
						String label = (String) object;
						DeleteEnumerationTypeLabelCommand command = new DeleteEnumerationTypeLabelCommand(mRootObject,
								label, ModelAdapter.getInstance().getConnection(mRootObject));
						CommandHandle handle = null;
						try {
							handle = command.execute();
						}
						catch (ExecutionCancelledException ecEx) {
							return null;
						} 
						catch (Exception exc) {
							throw new InternalErrorException(exc);
						}
						if (handle == null) {
							throw new InternalErrorException("Error while executing " + command.getDescription()); //$NON-NLS-1$
						}				
					
					}
				}
			}
			return null;
		}
	}

}
