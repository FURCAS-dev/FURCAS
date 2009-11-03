package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;

import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.gfw.command.DirectEditingFeatureCommandWithContext;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.parts.directedit.IDirectEditHolder;
import com.sap.mi.gfw.eclipse.internal.requests.GfwDirectEditRequest;
import com.sap.mi.gfw.eclipse.internal.util.DataTypeTransformation;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.func.IDirectEditing;
import com.sap.mi.gfw.internal.util.LookManager;
import com.sap.mi.gfw.util.IColorConstant;

/**
 * An EditPolicy to handle direct-editing of EditParts. Typically not the complete EditPart shall be edited directly, but only one control
 * of it (e.g. one Label). For this control an appropiate CellEditor would usually be shown.
 * 
 * @see com.sap.ide.eclipse.gf.policy.IEditPolicyFactory#createDirectEditPolicy(com.sap.ide.eclipse.gf.command.ICommandFactory)
 */
public class DefaultDirectEditPolicy extends DirectEditPolicy {

	private IConfigurationProvider configurationProvider;

	public DefaultDirectEditPolicy(IConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	/**
	 * Is called, when the (already opened) cell-editor was closed (but not canceled).
	 * 
	 * @see org.eclipse.gef.editpolicies.DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {

		if (!(request instanceof GfwDirectEditRequest)) {
			return null;
		}

		String message = request.getCellEditor().getErrorMessage();
		if (message != null && message.length() != 0) {
			MessageDialog.openError(GraphicsPlugin.getShell(), Messages.DefaultDirectEditPolicy_0_xmsg, message);
			return null;
		}

		IDirectEditHolder directEditHolder = ((GfwDirectEditRequest) request).getDirectEditHolder();
		IDirectEditingFeature directEditingFeature = directEditHolder.getDirectEditingFeature();
		IDirectEditingContext directEditingContext = directEditHolder.getDirectEditingContext();

		Object valueObject = request.getCellEditor().getValue();

		if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_DROPDOWN) {
			int index = ((Integer) valueObject).intValue();

			// TODO: user inserted free value, what to do here?
			if (index < 0)
				return null;
			valueObject = directEditingFeature.getPossibleValues(directEditingContext)[index];

		}

		ICommand cmd = new DirectEditingFeatureCommandWithContext(directEditingFeature, directEditingContext, (String) valueObject);

		final IFeatureProvider fp = directEditingFeature.getFeatureProvider();
		final DiagramEditor diagramEditor = (DiagramEditor) fp.getDiagramTypeProvider().getDiagramEditor();
		CommandStack commandStack = diagramEditor.getEditDomain().getCommandStack();
		commandStack.execute(new GefCommandWrapper(cmd, fp.getConnection()));
		// CommandExec.getSingleton().executeCommand(cmd, fp.getConnection());

		return null;
	}

	/**
	 * Is called on every change in the cell-editor. For example on every key-press in a TextCellEditor. It then updates the Label, which
	 * the cell-editor edits. Note that this means, that the Label shows the new value, before it is committed to the underlying model.
	 * However, this can be useful, e.g. to adjust the layout of the editpart while changing the value in the cell-editor.
	 * 
	 * @see org.eclipse.gef.editpolicies.DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {

		Object currentValue = request.getCellEditor().getValue();
		if (currentValue != null) {
		}
		// ((StickyNoteFigure)getHostFigure()).setText(value);
		// hack to prevent async layout from placing the cell editor twice.
		getHostFigure().getUpdateManager().performUpdate();
	}

	@Override
	protected void showDirectEditFeedback(DirectEditRequest request) {
		super.showDirectEditFeedback(request);
		String errorMessage = request.getCellEditor().getErrorMessage();

		// mark cell editor background
		Control control = request.getCellEditor().getControl();
		if (errorMessage == null) {
			control.setBackground(ColorConstants.listBackground);
		} else {
			IColorConstant cc = LookManager.getLook().getFieldErrorBackgroundColor();
			int r = cc.getRed();
			int g = cc.getGreen();
			int b = cc.getBlue();
			Color errorColor = DataTypeTransformation.toSwtColor(configurationProvider, r, g, b);
			control.setBackground(errorColor);
		}

		// set status line message
		ModelEditorManager.getInstance().getActiveStatusLineManager().setErrorMessage(errorMessage);
	}
}