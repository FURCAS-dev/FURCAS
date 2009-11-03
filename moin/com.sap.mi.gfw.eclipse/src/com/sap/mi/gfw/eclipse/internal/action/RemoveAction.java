package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class RemoveAction extends AbstractPreDefinedAction implements IContextAndFeatureProvider {
	private static final String TOOL_TIP = Messages.RemoveAction_0_xmsg;

	private static final String TEXT = Messages.RemoveAction_1_xfld;

	public static final String ACTION_ID = "predefined remove action"; //$NON-NLS-1$

	public RemoveAction(IWorkbenchPart part, IConfigurationProvider configurationProvider) {
		super(part, configurationProvider);
		setId(ACTION_ID);
		setText(TEXT);
		setToolTipText(TOOL_TIP);
	}

	public boolean isAvailable() {
		PictogramElement pe[] = getSelectedPictogramElements();
		for (int i = 0; i < pe.length; i++) {
			IRemoveContext context = new RemoveContext(pe[i]);
			IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(context);
			if (removeFeature == null) {
				return false;
			}
		}

		return true;
	}

	@Override
	protected boolean calculateEnabled() {
		PictogramElement pe[] = getSelectedPictogramElements();
		IFeatureProvider featureProvider = getFeatureProvider();
		if (featureProvider == null) {
			return false;
		}

		for (int i = 0; i < pe.length; i++) {
			if (pe[i].is___Alive()) {

				IRemoveContext context = new RemoveContext(pe[i]);

				IRemoveFeature removeFeature = featureProvider.getRemoveFeature(context);
				if (removeFeature == null)
					return false;

				if (!removeFeature.canRemove(context)) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void run() {
		genericRun(this);

		setSelection(StructuredSelection.EMPTY);
	}

	public IFeature provideFeatureForContext(IContext context) {
		return getFeatureProvider().getRemoveFeature((IRemoveContext) context);
	}

	public IContext createContext(final PictogramElement pe) {
		return new RemoveContext(pe);
	}
}