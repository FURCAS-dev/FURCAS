package com.sap.ide.moftool.editor.graphics.diagram;

import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * Used for the update that is triggered from the diagram root to
 * really enforce the update also if only positions of the decorators
 * will be adapted.
 * @author d027044
 */
public class ForcedUpdateContext extends UpdateContext {

	public ForcedUpdateContext(PictogramElement pictogramElement) {
		super(pictogramElement);
	}
}
