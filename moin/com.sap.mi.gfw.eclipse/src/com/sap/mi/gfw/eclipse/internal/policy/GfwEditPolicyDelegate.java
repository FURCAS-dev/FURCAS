package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.draw2d.IFigure;

import com.sap.mi.gfw.eclipse.internal.config.AbstractConfigurationProviderHolder;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.platform.ga.IVisualState;
import com.sap.mi.gfw.platform.ga.IVisualStateHolder;

public class GfwEditPolicyDelegate extends AbstractConfigurationProviderHolder {

	public GfwEditPolicyDelegate(IConfigurationProvider configurationProvider) {
		super(configurationProvider);
	}

	boolean isFigureOwnSelectionHandlingActive(IFigure figure) {
		if (figure instanceof IVisualStateHolder) {
			return true;
		} else {
			return false;
		}
	}

	boolean showPrimarySelection(IFigure figure) {
		if (figure instanceof IVisualStateHolder) {
			IVisualStateHolder visualStateHolder = (IVisualStateHolder) figure;
			visualStateHolder.getVisualState().setSelectionFeedback(IVisualState.SELECTION_PRIMARY);
			return true;
		} else {
			return false;
		}
	}

	boolean showSelection(IFigure figure) {
		if (figure instanceof IVisualStateHolder) {
			IVisualStateHolder visualStateHolder = (IVisualStateHolder) figure;
			visualStateHolder.getVisualState().setSelectionFeedback(IVisualState.SELECTION_SECONDARY);
			return true;
		} else {
			return false;
		}
	}

	boolean hideSelection(IFigure figure) {
		if (figure instanceof IVisualStateHolder) {
			IVisualStateHolder visualStateHolder = (IVisualStateHolder) figure;
			visualStateHolder.getVisualState().setSelectionFeedback(IVisualState.SELECTION_FEEDBACK_OFF);
			return true;
		} else {
			return false;
		}
	}
}
