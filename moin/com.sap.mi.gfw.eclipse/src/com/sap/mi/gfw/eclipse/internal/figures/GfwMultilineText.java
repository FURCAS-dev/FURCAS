package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

public class GfwMultilineText extends Figure {

	private TextFlow textFlow;

	private GfwFlowPage flowPage;

	public GfwMultilineText() {
		setBorder(new MarginBorder(2));

		// textFlow = new GfwTextFlow();
		// textFlow.setLayoutManager(new GfwParagraphTextLayout(textFlow,
		// ParagraphTextLayout.WORD_WRAP_SOFT));
		textFlow = new TextFlow();
		textFlow.setLayoutManager(new ParagraphTextLayout(textFlow, ParagraphTextLayout.WORD_WRAP_SOFT));

		flowPage = new GfwFlowPage(textFlow);
		flowPage.add(textFlow);

		setLayoutManager(new StackLayout());
		add(flowPage);
	}

	/**
	 * Returns the text inside the TextFlow.
	 * 
	 * @return the text flow inside the text.
	 */
	public String getText() {
		return textFlow.getText();
	}

	/**
	 * Sets the text of the TextFlow to the given value.
	 * 
	 * @param newText
	 *            the new text value.
	 */
	public void setText(String newText) {
		textFlow.setText(newText);
	}

	/**
	 * Sets the horitontal aligment of the block. Valid values are:
	 * <UL>
	 * <LI>{@link PositionConstants#NONE NONE} - (default) Alignment is inherited from parent. If a parent is not found then LEFT is used.</LI>
	 * <LI>{@link PositionConstants#LEFT} - Alignment is with leading edge</LI>
	 * <LI>{@link PositionConstants#RIGHT} - Alignment is with trailing edge</LI>
	 * <LI>{@link PositionConstants#CENTER}</LI>
	 * <LI>{@link PositionConstants#ALWAYS_LEFT} - Left, irrespective of orientation</LI>
	 * <LI>{@link PositionConstants#ALWAYS_RIGHT} - Right, irrespective of orientation</LI>
	 * </UL>
	 * 
	 * @param value
	 *            the aligment
	 * @see #getHorizontalAligment()
	 */
	public void setHorizontalAligment(int value) {
		flowPage.setHorizontalAligment(value);
	}

	public int getHorizontalAligment() {
		return flowPage.getHorizontalAligment();
	}

	/**
	 * Sets the vertical aligment of the block. Valid values are:
	 * <UL>
	 * <LI>{@link PositionConstants#NONE NONE} - (default) Alignment is inherited from parent. If a parent is not found then TOP is used.</LI>
	 * <LI>{@link PositionConstants#TOP}</LI>
	 * <LI>{@link PositionConstants#BOTTOM}</LI>
	 * <LI>{@link PositionConstants#MIDDLE}</LI>
	 * </UL>
	 * 
	 * @param value
	 *            the aligment
	 * @see #getVerticalAligment()
	 */
	public void setVerticalAligment(int value) {
		flowPage.setVerticalAligment(value);
	}

	public int getVerticalAligment() {
		return flowPage.getVerticalAligment();
	}
}
