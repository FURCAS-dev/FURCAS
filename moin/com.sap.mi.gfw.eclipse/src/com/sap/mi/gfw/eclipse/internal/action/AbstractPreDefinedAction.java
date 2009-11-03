package com.sap.mi.gfw.eclipse.internal.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.mi.gfw.command.CommandContainer;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public abstract class AbstractPreDefinedAction extends SelectionAction implements IAvailable {

	private IConfigurationProvider configurationProvider;

	public AbstractPreDefinedAction(IWorkbenchPart part, IConfigurationProvider configurationProvider) {
		super(part);
		this.configurationProvider = configurationProvider;
	}

	protected IConfigurationProvider getConfigurationProvider() {
		return configurationProvider;
	}

	protected IFeatureProvider getFeatureProvider() {
		return getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
	}

	protected PictogramElement[] getSelectedPictogramElements() {
		List selectedObjects = getSelectedObjects();
		List<Object> list = new ArrayList<Object>();
		for (Iterator iter = selectedObjects.iterator(); iter.hasNext();) {
			Object o = iter.next();
			if (o instanceof EditPart) {
				EditPart editPart = (EditPart) o;
				if (editPart.getModel() instanceof PictogramElement) {
					list.add(editPart.getModel());
				}
			}
		}

		return list.toArray(new PictogramElement[0]);
	}

	protected void executeOnCommandStack(ICommand command) {
		CommandStack commandStack = getConfigurationProvider().getDiagramEditor().getEditDomain().getCommandStack();
		commandStack.execute(new GefCommandWrapper(command, getFeatureProvider().getConnection()));
	}

	protected void genericRun(IContextAndFeatureProvider cfProvider) {
		final IFeatureProvider featureProvider = getFeatureProvider();
		CommandContainer commandContainer = new CommandContainer(featureProvider);

		PictogramElement pes[] = getSelectedPictogramElements();
		for (int i = 0; i < pes.length; i++) {
			final PictogramElement pe = pes[i];
			IContext context = cfProvider.createContext(pe);
			IFeature feature = cfProvider.provideFeatureForContext(context);
			if (feature != null) {
				// CommandExec.executeFeatureWithContext(feature, context);
				commandContainer.add(new GenericFeatureCommandWithContext(feature, context));
			}
		}

		executeOnCommandStack(commandContainer);
	}
}