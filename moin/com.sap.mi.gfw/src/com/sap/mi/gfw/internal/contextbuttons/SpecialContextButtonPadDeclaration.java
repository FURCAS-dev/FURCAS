package com.sap.mi.gfw.internal.contextbuttons;

import java.awt.Rectangle;

import com.sap.mi.gfw.tb.IContextButtonEntry;
import com.sap.mi.gfw.tb.IContextButtonPadData;
import com.sap.mi.gfw.util.ColorConstant;
import com.sap.mi.gfw.util.IColorConstant;

/**
 * An alternative implementation of {@link IContextButtonPadDeclaration} which is mainly used for testing.
 */
public class SpecialContextButtonPadDeclaration extends AbstractContextButtonPadDeclaration {

	private static final IColorConstant PAD_OUTER_LINE_COLOR = new ColorConstant(215, 255, 240);

	private static final IColorConstant PAD_MIDDLE_LINE_COLOR = new ColorConstant(205, 250, 230);

	private static final IColorConstant PAD_INNER_LINE_COLOR = new ColorConstant(195, 240, 220);

	private static final IColorConstant PAD_FILL_COLOR = new ColorConstant(185, 230, 210);

	private static final IColorConstant BUTTON_OUTER_LINE_COLOR = new ColorConstant(255, 240, 0);

	private static final IColorConstant BUTTON_MIDDLE_LINE_COLOR = new ColorConstant(255, 255, 232);

	private static final IColorConstant BUTTON_FILL_COLOR = new ColorConstant(255, 255, 232);

	public SpecialContextButtonPadDeclaration(IContextButtonPadData contextButtonPadData) {
		super(contextButtonPadData);
	}

	// ======================== overwritten size getter =======================

	@Override
	protected int getButtonSize() {
		return 22;
	}

	@Override
	protected int getButtonPadding() {
		return 3;
	}

	@Override
	protected int getCollapseButtonPadding() {
		return 20;
	}

	@Override
	protected int getPadPaddingOutside() {
		return 6;
	}

	@Override
	protected int getPadPaddingInside() {
		return 4;
	}

	@Override
	protected int getPadHorizontalOverlap() {
		return 6;
	}

	@Override
	protected int getPadVerticalOverlap() {
		return 6;
	}

	@Override
	public int getPadAppendageLength() {
		return 0;
	}

	// ===================== overwritten drawing getter =======================

	public int getPadLineWidth() {
		return 1;
	}

	public int getPadCornerRadius() {
		return 26;
	}

	public IColorConstant getPadOuterLineColor() {
		return PAD_OUTER_LINE_COLOR;
	}

	public IColorConstant getPadMiddleLineColor() {
		return PAD_MIDDLE_LINE_COLOR;
	}

	public IColorConstant getPadInnerLineColor() {
		return PAD_INNER_LINE_COLOR;
	}

	public IColorConstant getPadFillColor() {
		return PAD_FILL_COLOR;
	}

	public double getPadDefaultOpacity() {
		return 0.4;
	}

	// ===================== overwritten button creators ======================

	@Override
	public PositionedContextButton createButton(IContextButtonEntry entry, Rectangle position) {
		PositionedContextButton ret = new PositionedContextButton(entry, position);
		ret.setLine(2, 20);
		ret.setColors(BUTTON_OUTER_LINE_COLOR, BUTTON_MIDDLE_LINE_COLOR, BUTTON_FILL_COLOR);
		ret.setOpacity(0.0, 1.0, 1.0);
		return ret;
	}
}
