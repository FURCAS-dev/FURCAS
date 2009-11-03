package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.ui.IWorkbenchPart;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.impl.DeleteContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class DeleteAction extends AbstractPreDefinedAction implements IContextAndFeatureProvider {

	private static final String TOOL_TIP = Messages.DeleteAction_0_xmsg;

	private static final String TEXT = Messages.DeleteAction_1_xfld;

	public static final String ACTION_ID = "predefined delete action"; //$NON-NLS-1$

	public DeleteAction(IWorkbenchPart part, IConfigurationProvider configurationProvider) {
		super(part, configurationProvider);
		setId(ACTION_ID);
		setText(TEXT);
		setToolTipText(TOOL_TIP);
	}

	public boolean isAvailable() {
		PictogramElement pe[] = getSelectedPictogramElements();
		for (int i = 0; i < pe.length; i++) {
			IDeleteContext context = new DeleteContext(pe[i]);
			IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(context);
			if (deleteFeature == null) {
				return false;
			}
		}

		return true;
	}

	@Override
	protected boolean calculateEnabled() {
		PictogramElement pe[] = getSelectedPictogramElements();
		for (int i = 0; i < pe.length; i++) {
			IDeleteContext context = new DeleteContext(pe[i]);
			IFeatureProvider featureProvider = getFeatureProvider();
			if (featureProvider == null) {
				return false;
			}
			IDeleteFeature deleteFeature = featureProvider.getDeleteFeature(context);
			if (deleteFeature != null && !deleteFeature.canDelete(context)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void run() {
		genericRun(this);
	}

	public IContext createContext(PictogramElement pe) {
		return new DeleteContext(pe);
	}

	public IFeature provideFeatureForContext(IContext context) {
		return getFeatureProvider().getDeleteFeature((IDeleteContext) context);
	}
}