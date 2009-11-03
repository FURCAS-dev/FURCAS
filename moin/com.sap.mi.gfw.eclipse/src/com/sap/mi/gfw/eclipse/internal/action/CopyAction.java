package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.ICopyFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICopyContext;
import com.sap.mi.gfw.features.context.impl.CopyContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class CopyAction extends AbstractPreDefinedAction {

	private static final String TOOL_TIP = Messages.CopyAction_0_xmsg;

	private static final String TEXT = Messages.CopyAction_1_xfld;

	public static final String ACTION_ID = ActionFactory.COPY.getId(); // "predefined

	public CopyAction(IWorkbenchPart part, IConfigurationProvider configurationProvider) {
		super(part, configurationProvider);
		setId(ACTION_ID);
		setText(TEXT);
		setToolTipText(TOOL_TIP);
	}

	public boolean isAvailable() {
		PictogramElement[] pes = getSelectedPictogramElements();
		ICopyContext context = new CopyContext(pes);
		ICopyFeature feature = getFeatureProvider().getCopyFeature(context);
		if (feature == null) {
			return false;
		}

		return true;
	}

	@Override
	protected boolean calculateEnabled() {
		PictogramElement[] pes = getSelectedPictogramElements();
		ICopyContext context = new CopyContext(pes);
		IFeatureProvider featureProvider = getFeatureProvider();
		if (featureProvider == null) {
			return false;
		}
		ICopyFeature feature = featureProvider.getCopyFeature(context);
		if (feature == null || !feature.canCopy(context)) {
			return false;
		}

		return true;
	}

	@Override
	public void run() {
		PictogramElement[] pes = getSelectedPictogramElements();
		ICopyContext context = new CopyContext(pes);
		ICopyFeature copyFeature = getFeatureProvider().getCopyFeature(context);
		if (copyFeature != null) {
			copyFeature.copy(context);
		}
	}
}
