package com.sap.ide.moftool.editor.composites;

import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Tag;

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

import com.sap.ide.moftool.editor.core.commands.AddTagValueCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteTagValueCommand;
import com.sap.ide.moftool.editor.core.commands.EditTagValueCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.fwk.MultiLineInputDialog;
import com.sap.ide.moftool.editor.gen.composites.TagValuesCompositeBase;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

public class TagValuesComposite extends TagValuesCompositeBase {
	
	private ListViewer mValuesList = null;
	private Button mAddButton = null;
	private Button mEditButton = null;
	private Button mRemoveButton = null;
	private AddValueHandler mAddValueHandler = null;
	private EditValueHandler mEditValueHandler = null;
	private RemoveValueHandler mRemoveValueHandler = null;

	public TagValuesComposite(Section section, FormToolkit formToolkit,
			String title, String description) {
		super(section, formToolkit, title, description);
		
	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc,
			Tag tag) {

		IObservableList valuesModel = MoinObservables.observeList(tag, Tag.DESCRIPTORS.VALUES());
		mValuesList.setInput(valuesModel);	
		
		mAddValueHandler.setRootObject(tag);
		mRemoveValueHandler.setRootObject(tag);
		mEditValueHandler.setRootObject(tag);
		
		if (ModelElementService.isForeignObject(tag)) {
			mAddButton.setEnabled(false);
			mEditButton.setEnabled(false);
			mRemoveButton.setEnabled(false);
			mValuesList.getControl().setEnabled(false);
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
		gridData.minimumHeight = 50;
		list.setLayoutData(gridData);
		mValuesList = new ListViewer(list);
		mValuesList.setContentProvider(new ObservableListContentProvider());
		mValuesList.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof String) {
				    if(((String)element).length() > 50)
					return ((String)element).substring(0, 50) + "...";
				    else
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
				LocalizationMessages.TagValuesComposite_0_XBUT, SWT.NONE);
		mAddButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		mAddButton.setLayoutData(data);
		mAddButton.setToolTipText(LocalizationMessages.TagValuesComposite_1_XTOL);
		mAddButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mAddValueHandler.execute(null);
			}
		});
		mAddValueHandler = new AddValueHandler(rootComposite.getShell());
		// Edit button
		mEditButton = toolkit.createButton(buttonsComposite,
				LocalizationMessages.TagValuesComposite_2_XBUT, SWT.NONE);
		mEditButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		mEditButton.setLayoutData(data);
		mEditButton.setToolTipText(LocalizationMessages.TagValuesComposite_3_XTOL);
		mEditButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mEditValueHandler.execute(mValuesList.getSelection());
			}
		});
		mEditValueHandler = new EditValueHandler(rootComposite.getShell());
		// Delete Button
		mRemoveButton = toolkit.createButton(buttonsComposite,
				LocalizationMessages.TagValuesComposite_4_XBUT, SWT.NONE);
		mRemoveButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		mRemoveButton.setLayoutData(data);
		mRemoveButton.setToolTipText(LocalizationMessages.TagValuesComposite_5_XTOL);
		mRemoveButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mRemoveValueHandler.execute(mValuesList.getSelection());
			}
		});
		mRemoveValueHandler = new RemoveValueHandler();

	}

	@Override
	protected void bindValues(MoinDataBindingContext dbc, Tag refObject,
			Control values) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control createValues(Composite rootComposite,
			FormToolkit formToolkit) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class AddValueHandler {

		private Shell mShell = null;
		private Tag mRootObject = null;

		public AddValueHandler(Shell shell) {
			super();
			mShell = shell;
		}

		public void setRootObject(Tag rootObject) {
			mRootObject = rootObject;
		}

		public Object execute(ExecutionEvent e) {			
			InputDialog dialog = new InputDialog(mShell,
					LocalizationMessages.TagValuesComposite_6_XMSG,
					LocalizationMessages.TagValuesComposite_7_XGRP, "", null);   //$NON-NLS-1$
			if (dialog.open() == InputDialog.OK) {
				String entered = dialog.getValue();
				AddTagValueCommand command = new AddTagValueCommand(mRootObject,
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
	
	private class EditValueHandler {

		private Shell mShell = null;
		private Tag mRootObject = null;
		
		public EditValueHandler(Shell shell) {
			mShell = shell;
		}
		
		public void setRootObject(Tag rootObject) {
			mRootObject = rootObject;
		}

		public Object execute(ISelection selection) {
			int valueIndex = 0;			
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Object object = structuredSelection.getFirstElement();
				if (object instanceof String) {
					String value = (String) object;
					valueIndex = mRootObject.getValues().indexOf(value);
					MultiLineInputDialog dialog = new MultiLineInputDialog(mShell,
							LocalizationMessages.TagValuesComposite_8_XMSG,
							LocalizationMessages.TagValuesComposite_9_XGRP, value, null); 
					if (dialog.open() == InputDialog.OK) {
						String entered = dialog.getValue();
						EditTagValueCommand command = new EditTagValueCommand(mRootObject,
								valueIndex, entered, ModelAdapter.getInstance().getConnection(mRootObject));
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
	
	private class RemoveValueHandler {

		private Tag mRootObject = null;
		
		public void setRootObject(Tag rootObject) {
			mRootObject = rootObject;
		}

		public Object execute(ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				Iterator<?> it = structuredSelection.iterator();
				while (it.hasNext()) {
					Object object = it.next();
					if (object instanceof String) {
						String value = (String) object;
						DeleteTagValueCommand command = new DeleteTagValueCommand(mRootObject,
								value, ModelAdapter.getInstance().getConnection(mRootObject));
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
