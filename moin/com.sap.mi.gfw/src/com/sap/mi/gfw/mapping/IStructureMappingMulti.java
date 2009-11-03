package com.sap.mi.gfw.mapping;

import java.util.List;

/**
 * The Interface IStructureMappingMulti.
 */
public interface IStructureMappingMulti extends IStructureMapping {

	/**
	 * Returns the list of business object arrays. Each array of business objects will be linked with a pictogram element acting as
	 * placeholder in a pattern.
	 * 
	 * @param mainBusinessObject
	 *            this is the main business object of the current pattern
	 * 
	 * @return the list of business objects
	 */
	List<ILinkCreationInfo> getLinkCreationInfos(Object mainBusinessObject);
}
