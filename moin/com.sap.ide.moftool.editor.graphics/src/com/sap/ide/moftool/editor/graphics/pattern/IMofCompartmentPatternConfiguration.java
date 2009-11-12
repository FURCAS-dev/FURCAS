package com.sap.ide.moftool.editor.graphics.pattern;

import com.sap.mi.gfw.pattern.config.IColorConfiguration;
import com.sap.mi.gfw.pattern.config.IIndentConfiguration;
import com.sap.mi.gfw.pattern.config.IMinimumSizeConfiguration;

public interface IMofCompartmentPatternConfiguration extends IColorConfiguration,
		IIndentConfiguration,IMinimumSizeConfiguration {

	int getLineWidth();
	void setLineWidth(int lineWidth);

	int getCornerHeight();
	void setCornerHeight(int i);

	int getCornerWidth();
	void setCornerWidth(int i);
}
