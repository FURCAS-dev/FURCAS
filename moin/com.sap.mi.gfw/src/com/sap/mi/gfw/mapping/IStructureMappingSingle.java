package com.sap.mi.gfw.mapping;

/**
 * The Interface IStructureMappingSingle.
 */
public interface IStructureMappingSingle extends IStructureMapping {

	/**
	 * Returns an array of business objects. This array of business objects will be linked with a pictogram element acting as placeholder in
	 * a pattern.
	 * 
	 * @param mainBusinessObject
	 *            this is the main business object of the current pattern
	 * 
	 * @return the business object
	 */
	ILinkCreationInfo getLinkCreationInfo(Object mainBusinessObject);
}
