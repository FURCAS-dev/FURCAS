package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.mi.gfw.command.FeatureCommandWithContext;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IPasteFeature;
import com.sap.mi.gfw.features.context.IPasteContext;
import com.sap.mi.gfw.features.context.impl.PasteContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class PasteAction extends AbstractPreDefinedAction {
	private static final String TEXT = Messages.PasteAction_0_xfld;

	private static final String TOOL_TIP = TEXT;

	public static final String ACTION_ID = ActionFactory.PASTE.getId(); // "predefined

	public PasteAction(IWorkbenchPart part, IConfigurationProvider configurationProvider) {
		super(part, configurationProvider);
		setId(ACTION_ID);
		setText(TEXT);
		setToolTipText(TOOL_TIP);
	}

	public boolean isAvailable() {
		PictogramElement[] pes = getSelectedPictogramElements();
		IPasteContext context = new PasteContext(pes);
		IPasteFeature feature = getFeatureProvider().getPasteFeature(context);
		if (feature == null) {
			return false;
		}

		return true;
	}

	@Override
	protected boolean calculateEnabled() {
		PictogramElement[] pes = getSelectedPictogramElements();
		IPasteContext context = new PasteContext(pes);
		IFeatureProvider featureProvider = getFeatureProvider();
		if (featureProvider == null) {
			return false;
		}
		IPasteFeature feature = featureProvider.getPasteFeature(context);
		if (feature == null || !feature.canPaste(context)) {
			return false;
		}

		return true;
	}

	@Override
	public void run() {
		PictogramElement[] pes = getSelectedPictogramElements();
		IPasteContext context = new PasteContext(pes);
		final IFeatureProvider featureProvider = getFeatureProvider();
		IPasteFeature feature = featureProvider.getPasteFeature(context);
		if (feature != null) {
			final FeatureCommandWithContext command = new GenericFeatureCommandWithContext(feature, context);
			executeOnCommandStack(command);
		}
	}
}
