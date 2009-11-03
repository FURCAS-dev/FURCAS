package com.sap.tc.moin.versioning.di.impl;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.tc.moin.versioning.di.FileOperation;
import com.sap.tc.moin.versioning.di.impl.preferences.PreferenceHelper;

/**
 * <p>Title:       CheckoutDialog</p>
 * <p>Description: UI for checkout request</p>
 * <p>Copyright:   Copyright (c) 2003-2005</p>
 * <p>Company:     SAP AG</p>
 * @author        d038368
 * @version       $Id: //moin/moin.fct_nwdi_ide/NWCorr_publish/src/_com.sap.tc.moin.versioning.di.epi/ecp/core/com/sap/tc/moin/versioning/di/impl/CheckoutDialog.java#1 $
 */
public final class CheckoutDialog extends TitleAreaDialog {

    private final static String BUTTON_TEXT_PROCEED = Messages.CheckoutDialog_proceed_XBUT;

    private static int CHECKOUT_BUTTON_ID = IDialogConstants.CLIENT_ID + 1;
    
    private TreeViewer mTreeViewer = null;
    
    private Button mCheckbox = null;

    private String mMessage = null;

    private String mTitle = null;

    private boolean mCheckoutEnabled;

    private boolean mFilesCheckedOutByOthersExist;

    private boolean mDoCheckout = false;
    
    PreparationCheckResult mPreparationCheckResult;

    public boolean getDoCheckout( ) {

        return mDoCheckout;
    }
    
    public CheckoutDialog( String title, String message, PreparationCheckResult preparationCheckResult) {

        super( PlatformUI.getWorkbench( ).getActiveWorkbenchWindow( ).getShell( ) );

        mCheckoutEnabled = preparationCheckResult.isCheckoutPossible();
        mFilesCheckedOutByOthersExist = preparationCheckResult.foreignModifiersExist();
        mMessage = message;
        mTitle = title;
        mPreparationCheckResult = preparationCheckResult;
        setShellStyle( SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL );
    }

    protected void buttonPressed( int id ) {

        if ( id == CHECKOUT_BUTTON_ID ) {
            if ( mFilesCheckedOutByOthersExist ) {
                String title = Messages.CheckoutDialog_confirmCheckout_XGRP;
                String message = Messages.CheckoutDialog_warningOtherCheckouters_YMSG;
                if ( !askUserToConfirm( title, message, 1 ) )
                    return;
            }
            mDoCheckout = true;
            if (mCheckbox != null) {
	            boolean doNotShowAgain = mCheckbox.getSelection();
	            if (doNotShowAgain) {
	            	PreferenceHelper.getInstance().setShowPrepareDialog(false);
	            }
            }
            close( );
        }

        super.buttonPressed( id );
    }

    public static boolean askUserToConfirm( String title, String message, int defaultButtonIndex ) {

        String[] buttons = { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL };
        MessageDialog dialog = createMessageDialog( title, message, buttons, MessageDialog.QUESTION, null, defaultButtonIndex );
        return ( dialog.open( ) == Window.OK );
    }

    public static MessageDialog createMessageDialog( String dialogTitle, String dialogMessage, String[] buttons, int dialogImageType, Image titleImage, int defaultButtonIndex ) {

        Shell shell = PlatformUI.getWorkbench( ).getActiveWorkbenchWindow( ).getShell( );
        return new MessageDialog( shell, dialogTitle, titleImage, dialogMessage, dialogImageType, buttons, defaultButtonIndex );
    }



    protected void configureShell( Shell shell ) {

        super.configureShell( shell );
        shell.setText( mTitle );
    }

    protected void createButtonsForButtonBar( Composite parent ) {

        boolean cancelButtonIsDefault = true;
        if ( mCheckoutEnabled ) {
            createButton( parent, CHECKOUT_BUTTON_ID, BUTTON_TEXT_PROCEED, true );
            cancelButtonIsDefault = false;
        }
        createButton( parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, cancelButtonIsDefault );
    }

    protected Control createDialogArea( Composite parent ) {

        // create top level composite
        Composite parentComposite = (Composite) super.createDialogArea( parent );
        int messageType;
        if ( mCheckoutEnabled )
            messageType = IMessageProvider.INFORMATION;
        else
            messageType = IMessageProvider.ERROR;
        setMessage( mMessage, messageType );
        Composite contents = new Composite( parentComposite, SWT.NONE );
        contents.setLayout( new GridLayout( ) );
        contents.setLayoutData( new GridData( GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL ) );
        setTitle( mTitle );
        // tree
        mTreeViewer = new TreeViewer(contents, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
        setupTreeViewer();
        mTreeViewer.getControl().setLayoutData( new GridData( GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.GRAB_VERTICAL ) );
        // checkbox
        if (!mPreparationCheckResult.containsWarnings() && mPreparationCheckResult.isCheckoutPossible()) {
        	mCheckbox = new Button(contents, SWT.CHECK);
        	mCheckbox.setText(Messages.CheckoutDialog_doNotShowAgain_XCKL);
        }
        return contents;
    }
    
    private void setupTreeViewer() {
		mTreeViewer.setContentProvider(new TreeContentProvider(mPreparationCheckResult));
		mTreeViewer.setLabelProvider(new TreeLabelProvider());
		mTreeViewer.setInput(this);
		mTreeViewer.expandAll();
		IDoubleClickListener listener = new IDoubleClickListener(){
			public void doubleClick(DoubleClickEvent event) {
				TreeSelection selection = (TreeSelection) event.getSelection();
				Object selectedObject = selection.getFirstElement();
				if (!(selectedObject instanceof FileOperation))
					return;
				FileOperation fileOperation = (FileOperation) selection.getFirstElement();
				if (mPreparationCheckResult.getFileOperationStatus(fileOperation).isOK()) {
					return;
				}
				showDetails(fileOperation);
			}

		};
		mTreeViewer.addDoubleClickListener(listener);
    }

	private void showDetails(FileOperation fileOperation) {
		IStatus status = mPreparationCheckResult.getFileOperationStatus(fileOperation);
		String title = Messages.CheckoutDialog_problemDetails_XGRP;
		String message = status.getMessage();
		if(status.getSeverity()==IStatus.ERROR) {
			MessageDialog.openError(this.getShell(), title, message);
		} else {
			MessageDialog.openWarning(this.getShell(), title, message);
		}
	}	
    
	private class TreeContentProvider implements ITreeContentProvider {
		PreparationCheckResult mPreparationCheckResult;
		
		TreeContentProvider(PreparationCheckResult preparationCheckResult) {
			mPreparationCheckResult = preparationCheckResult;
		}
		
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			if (!(parentElement instanceof FileOperations)) {
				return null;
			}
			FileOperations fileOperations = (FileOperations) parentElement;
			List<FileOperation> operations = fileOperations.getFileOperations();
			return (Object[]) operations.toArray(new Object[operations.size()]);
		}

		public Object getParent(Object element) {
			// TODO
			return null;
		}

		public boolean hasChildren(Object element) {
			return element instanceof FileOperations;
		}

		public Object[] getElements(Object inputElement) {
			if (!(inputElement instanceof CheckoutDialog))
				return new Object[0];
			List<FileOperations> result = new ArrayList<FileOperations>();
			if (!mPreparationCheckResult.getCreateOperations().isEmpty()) {
				result.add(mPreparationCheckResult.getCreateOperations());
			}
			if (!mPreparationCheckResult.getEditOperations().isEmpty()) {
				result.add(mPreparationCheckResult.getEditOperations());
			}
			if (!mPreparationCheckResult.getEditExclusiveOperations().isEmpty()) {
				result.add(mPreparationCheckResult.getEditExclusiveOperations());
			}
			if (!mPreparationCheckResult.getDeleteOperations().isEmpty()) {
				result.add(mPreparationCheckResult.getDeleteOperations());
			}
			return (Object[]) result.toArray(new Object[result.size()]);
		}
	}

	private class TreeLabelProvider extends LabelProvider {
		private final Image IMG_FOLDER = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		private final Image IMG_FILE = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		
		@Override
		public String getText(Object element) {
			if (element instanceof FileOperations) {
				FileOperations fileOperations = (FileOperations) element;
				if (fileOperations==mPreparationCheckResult.getCreateOperations()) {
					return Messages.CheckoutDialog_filesToBeCreated_XTND;
				}
				if (fileOperations==mPreparationCheckResult.getEditOperations()) {
					return Messages.CheckoutDialog_filesToBeEdited_XTND;
				}
				if (fileOperations==mPreparationCheckResult.getEditExclusiveOperations()) {
					return Messages.CheckoutDialog_filesToBeEditedExclusive_XTND;
				}
				if (fileOperations==mPreparationCheckResult.getDeleteOperations()) {
					return Messages.CheckoutDialog_filesToBeDeleted_XTND;
				}
			}
			if (element instanceof FileOperation) {
				FileOperation fileOperation = (FileOperation) element;
				return Utils.getFilePath(fileOperation.getFile());
			}
			return "unknown node"; //$NON-NLS-1$
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof FileOperations) {
				FileOperations fileOperations = (FileOperations) element;
				return getImage(true, fileOperations.containsErrors, fileOperations.containsWarnings);
			}
			if (element instanceof FileOperation) {
				FileOperation fileOperation = (FileOperation) element;
				IStatus status = mPreparationCheckResult.getFileOperationStatus(fileOperation);
				boolean hasError = status.getSeverity() == IStatus.ERROR;
				boolean hasWarning = status.getSeverity() == IStatus.WARNING;
				return getImage(false, hasError, hasWarning);				
			}
			return super.getImage(element);
		}
		
		private Image getImage(boolean folder, boolean hasErrors, boolean hasWarnings) {
			Activator activator = Activator.getDefault();
			if (folder) {
				if (hasErrors) {
					return activator.getImage(Activator.FOLDER_IMAGE_WITH_ERROR_DECORATOR);
				}
				if (hasWarnings) {
					return activator.getImage(Activator.FOLDER_IMAGE_WITH_WARNING_DECORATOR); 
				}
				return IMG_FOLDER;
			} else {
				if (hasErrors) {
					return activator.getImage(Activator.FILE_IMAGE_WITH_ERROR_DECORATOR);
				}
				if (hasWarnings) {
					return activator.getImage(Activator.FILE_IMAGE_WITH_WARNING_DECORATOR); 
				}
				return IMG_FILE;
			}
		}
	}
    

}
