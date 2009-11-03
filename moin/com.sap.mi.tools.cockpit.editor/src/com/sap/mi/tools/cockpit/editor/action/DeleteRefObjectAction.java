package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

import com.sap.mi.fwk.ui.handler.DeleteElementsHandler;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * @author d003456
 * 
 */
public class DeleteRefObjectAction extends Action {

	private static final String TOOL_TIP = Messages.DeleteRefObjectAction_0_xmit;

	private static final String TEXT = Messages.DeleteRefObjectAction_1_xtol;

	private static final String ERROR_MSG_DELETE = Messages.DeleteRefObjectAction_2_xmsg;

	private final IHandlerService handlerService;

	/**
	 * Creates {@link DeleteRefObjectAction}.
	 * 
	 * @param handlerService
	 */
	public DeleteRefObjectAction(IHandlerService handlerService) {

		super();
		Assert.isNotNull(handlerService);
		this.handlerService = handlerService;
		setId(DeleteRefObjectAction.class.getName());
		setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setText(DeleteRefObjectAction.TEXT);
		setToolTipText(DeleteRefObjectAction.TOOL_TIP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final IHandler handler = new DeleteElementsHandler();
		IHandlerActivation activation = this.handlerService.activateHandler("org.eclipse.ui.edit.delete", handler); //$NON-NLS-1$
		try {
			this.handlerService.executeCommand("org.eclipse.ui.edit.delete", null); //$NON-NLS-1$
			//otherwise you do not have a handler second time
			this.handlerService.deactivateHandler(activation);
		}
		catch (final Exception e) {
			ExtendedMessageDialog.showError(Display.getCurrent().getActiveShell(), DeleteRefObjectAction.ERROR_MSG_DELETE, e.getMessage(),
					null, new String[] { IDialogConstants.OK_LABEL }, e);
		}
	}
}
