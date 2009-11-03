package com.sap.mi.gfw.features.context;

/**
 * This context contains the information, needed to let a feature add a pictogram element, which has to be linked to any domain model
 * element, to a container shape.
 * 
 * @see com.sap.mi.gfw.mm.pictograms.PictogramElement, com.sap.mi.gfw.mm.pictograms.ContainerShape
 */
public interface IAddContext extends IAreaContext, ITargetContext, ITargetConnectionContext {

	/**
	 * A pictogram element has to be added. This pictogram element has to link to a domain model element.
	 * 
	 * @return instance of a domain model element
	 */
	Object getNewObject();

}