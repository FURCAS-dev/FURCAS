package com.sap.mi.gfw.internal.util;

import com.sap.mi.gfw.util.ColorConstant;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.ILook;

public class DynamicLook implements ILook {

	public DynamicLook() {
		super();
	}

	public IColorConstant getFieldErrorBackgroundColor() {
		return randomColorConstant();
	}

	public IColorConstant getGridBackgroundColor() {
		return randomColorConstant();
	}

	public int getGridLineThickness() {
		return randomInt(1, 3);
	}

	public IColorConstant getMajorGridLineColor() {
		return randomColorConstant();
	}

	public int getMajorGridLineDistance() {
		return randomInt(1, 10);
	}

	public IColorConstant getMinorGridLineColor() {
		return randomColorConstant();
	}

	public int getMinorGridLineDistance() {
		return randomInt(1, 5);
	}

	private int random255() {
		return randomInt(255);
	}

	private int randomInt(int i) {
		return randomInt(0, i);
	}

	private int randomInt(int from, int to) {
		int ret = (int) (Math.random() * (to - from)) + from;
		return ret;
	}

	private ColorConstant randomColorConstant() {
		return new ColorConstant(random255(), random255(), random255());
	}
}
