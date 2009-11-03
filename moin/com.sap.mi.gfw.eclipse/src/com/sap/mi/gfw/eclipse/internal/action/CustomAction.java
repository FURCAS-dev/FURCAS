package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;

import com.sap.mi.gfw.command.CommandContainer;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;

public class CustomAction extends Action {

	private ICustomFeature customFeature;

	private ICustomContext context;

	private DiagramEditor graphicsEditor;

	public CustomAction(ICustomFeature customFeature, ICustomContext context, DiagramEditor graphicsEditor) {
		super();
		this.customFeature = customFeature;
		this.context = context;
		this.graphicsEditor = graphicsEditor;
		setText(customFeature.getName());
		setToolTipText(customFeature.getDescription());
	}

	@Override
	public boolean isEnabled() {
		return customFeature.canExecute(context);
	}

	@Override
	public void run() {
		// CommandExec.executeFeatureWithContext(customFeature, context);
		CommandContainer commandContainer = new CommandContainer(customFeature.getFeatureProvider());
		commandContainer.add(new GenericFeatureCommandWithContext(customFeature, context));
		executeOnCommandStack(commandContainer);

		if (graphicsEditor != null) {
			// graphicsEditor.refresh();
		}
	}

	protected void executeOnCommandStack(ICommand command) {
		final IConfigurationProvider configurationProvider = graphicsEditor.getConfigurationProvider();
		final IFeatureProvider featureProvider = configurationProvider.getFeatureProvider();
		CommandStack commandStack = configurationProvider.getDiagramEditor().getEditDomain().getCommandStack();
		commandStack.execute(new GefCommandWrapper(command, featureProvider.getConnection()));
	}
}