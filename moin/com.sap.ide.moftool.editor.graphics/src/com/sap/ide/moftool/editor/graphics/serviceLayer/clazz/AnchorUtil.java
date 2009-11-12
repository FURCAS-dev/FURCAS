package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.Collection;
import java.util.Iterator;

import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;

public class AnchorUtil {

	public static ChopboxAnchor getChopboxAnchor(Collection<Anchor> anchors) {
		for (Iterator<Anchor> cIter = anchors.iterator(); cIter.hasNext();) {
			Anchor anchor = cIter.next();
			if (anchor instanceof ChopboxAnchor) {
				return (ChopboxAnchor)anchor;
			}
		}
		return null;
	}
}
