/*
 * Created on 05.07.2005
 */
package com.sap.mi.gfw.command;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.util.T;

/**
 * The Class MoveShapeFeatureCommandWithContext.
 */
public class MoveShapeFeatureCommandWithContext extends FeatureCommandWithContext {

	/**
	 * The Constructor.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public MoveShapeFeatureCommandWithContext(IFeature feature, IMoveShapeContext context) {
		super(feature, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		boolean ret = getMoveShapeFeature().canMoveShape(getMoveShapeContext());
		return ret;
	}

	/**
	 * @return
	 */
	private IMoveShapeContext getMoveShapeContext() {
		IMoveShapeContext ret = null;
		if (getContext() instanceof IMoveShapeContext) {
			ret = (IMoveShapeContext) getContext();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public final boolean execute() {
		IMoveShapeContext layouShapeContext = getMoveShapeContext();
		IMoveShapeFeature moveShapeFeature = getMoveShapeFeature();

		if (T.racer().info()) {
			T.racer().info(
					"MoveShapeFeatureCommandWithContext", "execute", "call to IMoveShape.moveShape(IMoveShapeContext context) context: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							+ layouShapeContext);
		}
		moveShapeFeature.moveShape(layouShapeContext);
		return true;
	}

	/**
	 * Gets the move shape feature.
	 * 
	 * @return the move shape feature
	 */
	protected IMoveShapeFeature getMoveShapeFeature() {
		IMoveShapeFeature ret = null;
		if (getFeature() instanceof IMoveShapeFeature) {
			ret = (IMoveShapeFeature) getFeature();
		} else {
			return ret;
		}
		return ret;
	}
}