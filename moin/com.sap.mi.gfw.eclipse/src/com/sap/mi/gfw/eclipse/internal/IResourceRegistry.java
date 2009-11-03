package com.sap.mi.gfw.eclipse.internal;

import org.eclipse.swt.graphics.Color;

public interface IResourceRegistry extends IDisposable {
	Color getSwtColor(int red, int green, int blue);
}