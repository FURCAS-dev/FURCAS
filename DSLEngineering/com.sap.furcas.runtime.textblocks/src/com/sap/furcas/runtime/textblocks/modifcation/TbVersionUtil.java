package com.sap.furcas.runtime.textblocks.modifcation;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodesSize;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;

public class TbVersionUtil {

	public static void setVersion(DocumentNode node, Version version){
		node.setVersion(version);
		//node.getOtherVersions().add(node);
	}
	
	@SuppressWarnings("unchecked")
    public static <Type extends DocumentNode> Type getOtherVersion(Type documentNode,
			Version version) {
		if (documentNode.getVersion() == version) {
		    return documentNode;
		} else {
			List<DocumentNode> otherVersions = documentNode.getOtherVersions();
			for (DocumentNode otherVersion : otherVersions) {
				if (otherVersion.getVersion() == version) {
					return (Type) otherVersion;
				}
			}
		}
		return null;
	}
	
	/**
	 * @param node
	 * @param version
	 * @return
	 */
	public static boolean hasChildChanges(TextBlock node, Version version) {
        TextBlock otherVersion = getOtherVersion(node, version);
        return otherVersion != null
                && (getSubNodesSize(node) != getSubNodesSize(otherVersion));
    }
}
