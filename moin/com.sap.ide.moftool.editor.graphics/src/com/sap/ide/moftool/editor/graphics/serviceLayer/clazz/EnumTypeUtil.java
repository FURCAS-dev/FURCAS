package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.graphics.serviceLayer.Messages;

public class EnumTypeUtil {

	/**
	 * @param enumType
	 * @return index of added label
	 */
	public static int addNewLabel(EnumerationType enumType) {
		String labelName = Messages.EnumTypeUtil_0_xmsg;
		List<String> contents = enumType.getLabels();
		int indexCount = contents.size() + 1;
		while (true) {
			String newName = labelName + Integer.toString(indexCount);
			if (!contents.contains(newName)) {
				contents.add(newName);
				return contents.indexOf(newName);
			}
			indexCount++;
		}
	}

	public static int calculateASuitableWidth(EnumerationType type) {
		int ret = 0;
		List<String> contents = type.getLabels();
		for (String label:contents) {
			ret = Math.max(ret, label.length());
		}
		ret = 30 + ret*7;
		if (ret < 150) {
			ret = 150;
		}
		return ret;
	}
}
