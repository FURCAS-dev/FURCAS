package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.ui.IWorkbenchPart;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class UpdateAction extends AbstractPreDefinedAction implements IContextAndFeatureProvider {

	private static final String TOOL_TIP = Messages.UpdateAction_0_xmsg;

	private static final String TEXT = Messages.UpdateAction_1_xfld;

	public static final String ACTION_ID = "predefined update action"; //$NON-NLS-1$

	public UpdateAction(IWorkbenchPart part, IConfigurationProvider configurationProvider) {
		super(part, configurationProvider);
		setId(ACTION_ID);
		setText(TEXT);
		setToolTipText(TOOL_TIP);
		setLazyEnablementCalculation(false);
	}

	public boolean isAvailable() {
		PictogramElement pe[] = getSelectedPictogramElements();
		for (int i = 0; i < pe.length; i++) {
			IUpdateContext context = new UpdateContext(pe[i]);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature == null) {
				return false;
			}
		}

		return true;
	}

	@Override
	protected boolean calculateEnabled() {
		PictogramElement pe[] = getSelectedPictogramElements();
		for (int i = 0; i < pe.length; i++) {
			IUpdateContext context = new UpdateContext(pe[i]);
			IFeatureProvider featureProvider = getFeatureProvider();
			if (featureProvider != null) {
				IUpdateFeature updateFeature = featureProvider.getUpdateFeature(context);
				if (updateFeature != null && updateFeature.canExecute(context)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Performs the delete action on the selected objects.
	 */
	@Override
	public void run() {
		genericRun(this);
	}

	public IContext createContext(PictogramElement pe) {
		return new UpdateContext(pe);
	}

	public IFeature provideFeatureForContext(IContext context) {
		return getFeatureProvider().getUpdateFeature((IUpdateContext) context);
	}
}