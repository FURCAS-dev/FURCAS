package com.sap.mi.gfw.internal.contextbuttons;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.datatypes.IRectangle;
import com.sap.mi.gfw.tb.IContextButtonEntry;
import com.sap.mi.gfw.tb.IContextButtonPadData;

/**
 * An implementation of {@link IContextButtonPadDeclaration}. The calculation of the visual definition of the context button pad is based on
 * a reference rectangle (around which the context pad is aligned) and on the context button entries (which provided the functionality of
 * the context buttons).
 */
public abstract class AbstractContextButtonPadDeclaration implements IContextButtonPadDeclaration {

	// ===================== fields set in constructor ========================

	/**
	 * The original reference rectangle as described in {@link #getOriginalReferenceRectangle()}
	 */
	private Rectangle originalReferenceRectangle;

	/**
	 * The adjusted reference rectangle as described in {@link #getPadReferenceRectangle()}
	 */
	private Rectangle padReferenceRectangle;

	/**
	 * The context button pad data containing the {@link IContextButtonEntry}.
	 */
	private IContextButtonPadData contextButtonPadData;

	// ========================= calculated fields ============================

	/**
	 * The combined list of the collapse button and the generic context buttons as described in {@link #getCollapseAndGenericButtons()}
	 */
	private List<IContextButtonEntry> collapseAndGenericButtons;

	/**
	 * The right domain-specific context buttons as described in {@link #getDomainButtonsRight()}
	 */
	private List<IContextButtonEntry> domainButtonsRight;

	/**
	 * The left domain-specific context buttons as described in {@link #getDomainButtonsLeft()}
	 */
	private List<IContextButtonEntry> domainButtonsBottom;

	/**
	 * The bounds of the top pad as described in {@link #getTopPad()}
	 */
	private Rectangle top;

	/**
	 * The bounds of the right pad as described in {@link #getRightPad()}
	 */
	private Rectangle right;

	/**
	 * The bounds of the bottom pad as described in {@link #getBottomPad()}
	 */
	private Rectangle bottom;

	/**
	 * The style of the top pad as described in {@link #getTopPadStyle()}
	 */
	private PadStyle topStyle = PadStyle.STANDARD;

	/**
	 * The style of the right pad as described in {@link #getRightPadStyle()}
	 */
	private PadStyle rightStyle = PadStyle.STANDARD;

	/**
	 * The list of positioned context buttons as described in {@link #getPositionedContextButtons()}
	 */
	private List<PositionedContextButton> positionedButtons;

	/**
	 * The containment rectangles as described in {@link #getContainmentRectangles()}
	 */
	private List<Rectangle> containmentRectangles;

	/**
	 * The overlapping containment rectangles as described in {@link #getOverlappingContainmentRectangles()}
	 */
	private List<Rectangle> overlappingContainmentRectangles;

	// ============================= constructors =============================

	/**
	 * Creates a new AbstractContextButtonPadDeclaration.
	 * 
	 * @param referenceRectangle
	 *            The original reference rectangle as described in {@link #getOriginalReferenceRectangle()}
	 * @param contextButtonPadData
	 *            The context button data containing the {@link IContextButtonEntry}
	 */
	public AbstractContextButtonPadDeclaration(IContextButtonPadData contextButtonPadData) {
		this.contextButtonPadData = contextButtonPadData;

		IRectangle l = contextButtonPadData.getPadLocation();
		originalReferenceRectangle = new Rectangle(l.getX(), l.getY(), l.getWidth(), l.getHeight());
		padReferenceRectangle = new Rectangle(originalReferenceRectangle);
		padReferenceRectangle.grow(1, 1);

		initializeDomainButtonLists();
		initializeRectangles();
		initializeButtonPositions();
		initializeContainmentRectangles();
	}

	// ========================= abstract size getter =========================

	/**
	 * Returns the size of the generic and domain-specific context buttons.
	 * 
	 * @return The size of the generic and domain-specific context buttons.
	 */
	protected abstract int getButtonSize();

	/**
	 * Returns the padding between the generic and domain-specific context buttons.
	 * 
	 * @return The padding between the generic and domain-specific context buttons.
	 */
	protected abstract int getButtonPadding();

	/**
	 * Returns the padding between the collapse context button and the other generic context buttons.
	 * 
	 * @return The padding between the collapse context button and the other generic context buttons.
	 */
	protected abstract int getCollapseButtonPadding();

	/**
	 * Returns the padding of the generic and domain-specific context buttons at the outside of the context button pad.
	 * 
	 * @return The padding of the generic and domain-specific context buttons at the outside of the context button pad.
	 */
	protected abstract int getPadPaddingOutside();

	/**
	 * Returns the padding of the generic and domain-specific context buttons at the inside of the context button pad.
	 * 
	 * @return The padding of the generic and domain-specific context buttons at the inside of the context button pad.
	 */
	protected abstract int getPadPaddingInside();

	/**
	 * Returns the horizontal overlap of the pads (top with right, right with bottom).
	 * 
	 * @return The horizontal overlap of the pads (top with right, right with bottom).
	 */
	protected abstract int getPadHorizontalOverlap();

	/**
	 * Returns the vertical overlap of the pads (top with right, right with bottom).
	 * 
	 * @return The vertical overlap of the pads (top with right, right with bottom).
	 */
	protected abstract int getPadVerticalOverlap();

	/**
	 * Returns the length of the pad appendage, which is shown if the neighboring pad does not exist.
	 * 
	 * @return The length of the pad appendage, which is shown if the neighboring pad does not exist.
	 */
	protected abstract int getPadAppendageLength();

	// ====================== abstract button creators ========================

	/**
	 * Creates a {@link PositionedContextButton} for a given context button entry and position. This method can be implemented to set all
	 * the visual attributes of the context buttons (line-width, color, opacity, ...).
	 */
	public abstract PositionedContextButton createButton(IContextButtonEntry entry, Rectangle position);

	// =========================== field getter ===============================

	/**
	 * Returns the rectangular bounds of the top pad. The rectangular bounds were calculated by the constructor in
	 * {@link #initializeRectangles()}. It can be null.
	 * 
	 * @return The rectangular bounds of the top pad.
	 */
	public Rectangle getTopPad() {
		return top;
	}

	/**
	 * Returns the rectangular bounds of the right pad. The rectangular bounds were calculated by the constructor in
	 * {@link #initializeRectangles()}. It can be null.
	 * 
	 * @return The rectangular bounds of the right pad.
	 */
	public Rectangle getRightPad() {
		return right;
	}

	/**
	 * Returns the rectangular bounds of the bottom pad. The rectangular bounds were calculated by the constructor in
	 * {@link #initializeRectangles()}. It can be null.
	 * 
	 * @return The rectangular bounds of the bottom pad.
	 */
	public Rectangle getBottomPad() {
		return bottom;
	}

	/**
	 * Returns the top pad style. It is calculated by the constructor in {@link #initializeRectangles()}.
	 * 
	 * @return The top pad style.
	 */
	public PadStyle getTopPadStyle() {
		return topStyle;
	}

	/**
	 * Returns the right pad style. It is calculated by the constructor in {@link #initializeRectangles()}.
	 * 
	 * @return The right pad style.
	 */
	public PadStyle getRightPadStyle() {
		return rightStyle;
	}

	/**
	 * Returns the original reference rectangle around which the context button pad is aligned. It was given in the constructor. Typically
	 * these are the bounds of the shape around which the context button pad shall appear. It must not be null.
	 * 
	 * @return The original reference rectangle around which the context button pad is aligned.
	 */
	protected final Rectangle getOriginalReferenceRectangle() {
		return originalReferenceRectangle;
	}

	/**
	 * Returns the adjusted reference rectangle around which the context button pad is aligned. It was calculated in the constructor from
	 * the original reference rectangle. For example the original rectangle could be expanded to achieve a distance between the context
	 * button pad and the original reference rectangle. It must not be null.
	 * 
	 * @return The adjusted reference rectangle around which the context button pad is aligned.
	 */
	protected final Rectangle getPadReferenceRectangle() {
		return padReferenceRectangle;
	}

	/**
	 * Returns the list of generic, domain-independent context button entries. It was given in the constructor. The generic buttons will be
	 * located in the top pad. It must not be null but it can be empty.
	 * 
	 * @return The list of generic, domain-independent context button entries.
	 */
	protected final List<IContextButtonEntry> getGenericButtons() {
		return contextButtonPadData.getGenericContextButtons();
	}

	/**
	 * Returns the context button entry for the collapse/expand functionality. It was given in the constructor. It can be null.
	 * 
	 * @return The context button entry for the collapse/expand functionality. It was given in the constructor. It can be null.
	 */
	protected final IContextButtonEntry getCollapseButton() {
		return contextButtonPadData.getCollapseContextButton();
	}

	/**
	 * Returns the combined list of the collapse button and the generic context button entries. Those will be located in the top pad. It
	 * must not be null but it can be empty. See {@link #getCollapseButton()} and {@link #getGenericButtons()}.
	 * 
	 * @return The combined list of the collapse button and the generic context button entries.
	 */
	protected final List<IContextButtonEntry> getCollapseAndGenericButtons() {
		if (collapseAndGenericButtons == null) {
			collapseAndGenericButtons = new ArrayList<IContextButtonEntry>(getGenericButtons().size() + 1);
			if (getCollapseButton() != null)
				collapseAndGenericButtons.add(getCollapseButton());
			collapseAndGenericButtons.addAll(getGenericButtons());
		}
		return collapseAndGenericButtons;
	}

	/**
	 * Returns the list of domain-specific context button entries. It was given in the constructor. The domain-specific buttons will be
	 * located in the right pad and bottom pad. It must not be null but it can be empty.
	 * 
	 * @return The list of domain-specific context button entries.
	 */
	protected final List<IContextButtonEntry> getDomainButtons() {
		return contextButtonPadData.getDomainSpecificContextButtons();
	}

	/**
	 * Returns the list of domain-specific context button entries, which are located in the right pad. It is calculated in
	 * {@link #initializeDomainButtonLists()}. It must not be null but it can be empty.
	 * 
	 * @return The list of domain-specific context button entries, which are located in the right pad.
	 * 
	 * @see #getDomainButtons()
	 */
	protected final List<IContextButtonEntry> getDomainButtonsRight() {
		return domainButtonsRight;
	}

	/**
	 * Returns the list of domain-specific context button entries, which are located in the bottom pad. It is calculated in
	 * {@link #initializeDomainButtonLists()}. It must not be null but it can be empty.
	 * 
	 * @return The list of domain-specific context button entries, which are located in the bottom pad.
	 * 
	 * @see #getDomainButtons()
	 */
	protected final List<IContextButtonEntry> getDomainButtonsBottom() {
		return domainButtonsBottom;
	}

	/**
	 * Returns the list of all positioned context buttons. It must not be null but it can be empty. It is calculated in
	 * {@link #initializeButtonPositions()}.
	 * 
	 * @return The list of all positioned context buttons.
	 */
	public final List<PositionedContextButton> getPositionedContextButtons() {
		return positionedButtons;
	}

	/**
	 * Returns the rectangular bounds around all visible areas of the context button pad.
	 * 
	 * @return The rectangular bounds around all visible areas of the context button pad.
	 */
	public final List<Rectangle> getContainmentRectangles() {
		return containmentRectangles;
	}

	/**
	 * Returns the overlapping rectangular bounds around all visible areas of the context button pad.
	 * 
	 * @return The overlapping rectangular bounds around all visible areas of the context button pad.
	 */
	public final List<Rectangle> getOverlappingContainmentRectangles() {
		return overlappingContainmentRectangles;
	}

	// ==================== initializing calculated fields ====================

	/**
	 * Determines which domain buttons shall be located in the right pad and which in the bottom pad. The algorithm first calculates how
	 * many buttons fit into the height of the adjusted reference rectangle and locates those in the right pad. Any further buttons are
	 * located in the bottom pad.
	 * 
	 * @see #getDomainButtonsRight()
	 * @see #getDomainButtonsBottom()
	 */
	protected void initializeDomainButtonLists() {
		// calculate maximum number of domain buttons right
		int maxNumberOfButtons;
		int referenceHeight = getPadReferenceRectangle().height + (2 * getPadVerticalOverlap());
		// substract one button from reference height
		referenceHeight -= (2 * getPadPaddingOutside()) + getButtonSize();
		if (referenceHeight < 0) { // not even one button fits
			maxNumberOfButtons = 0;
		} else { // one button fits, plus how many other buttons with padding
			double additionalButtons = ((double) referenceHeight) / (getButtonSize() + getButtonPadding());
			// always round up
			maxNumberOfButtons = 1 + (int) Math.ceil(additionalButtons);
		}

		// determine domain buttons right
		domainButtonsRight = new ArrayList<IContextButtonEntry>();
		for (int i = 0; i < maxNumberOfButtons && i < getDomainButtons().size(); i++) {
			domainButtonsRight.add(getDomainButtons().get(i));
		}

		// determine domain buttons bottom
		int rightSize = getDomainButtonsRight().size();
		domainButtonsBottom = new ArrayList<IContextButtonEntry>();
		for (int i = rightSize; i < getDomainButtons().size(); i++) {
			domainButtonsBottom.add(getDomainButtons().get(i));
		}
	}

	/**
	 * Calculates the rectangular bounds for the top pad, right pad and bottom pad.
	 */
	protected void initializeRectangles() {
		Rectangle innerRectangle = new Rectangle(getPadReferenceRectangle());
		innerRectangle.height = getPadDynamicSize(getDomainButtonsRight().size());
		innerRectangle.height -= 2 * getPadVerticalOverlap();
		if (getDomainButtonsBottom().size() > 0 && innerRectangle.height > getPadReferenceRectangle().height) {
			// move upwards into the middle of the top buttons and bottom buttons
			innerRectangle.y -= (innerRectangle.height - getPadReferenceRectangle().height + 1) / 2;
		}

		Point innerTop = new Point(innerRectangle.x + innerRectangle.width, innerRectangle.y);
		Point innerBottom = new Point(innerTop.x, innerTop.y + innerRectangle.height);

		if (getCollapseAndGenericButtons().size() != 0) {
			top = new Rectangle();
			top.width = getPadDynamicSize(getCollapseAndGenericButtons().size());
			if (getCollapseButton() != null && getGenericButtons().size() > 0) {
				// adjust with different padding of collapse button
				top.width += getCollapseButtonPadding() - getButtonPadding();
			}
			top.height = getPadConstantSize();
			top.x = innerTop.x - top.width + getPadHorizontalOverlap();
			top.y = innerTop.y - top.height;
		} else if (getPadAppendageLength() > 0) {
			topStyle = PadStyle.APPENDAGE;
			top = new Rectangle();
			top.width = getPadAppendageLength() + getPadHorizontalOverlap();
			top.height = getPadVerticalOverlap();
			top.x = innerTop.x - top.width + getPadHorizontalOverlap();
			top.y = innerTop.y - top.height;
		}

		if (getDomainButtonsRight().size() != 0) {
			right = new Rectangle();
			right.width = getPadConstantSize();
			right.height = getPadDynamicSize(getDomainButtonsRight().size());
			right.x = innerTop.x;
			right.y = innerTop.y - getPadVerticalOverlap();
		} else if (getPadAppendageLength() > 0) {
			rightStyle = PadStyle.APPENDAGE;
			right = new Rectangle();
			right.width = getPadHorizontalOverlap();
			right.height = getPadAppendageLength() + getPadVerticalOverlap();
			right.x = innerTop.x;
			right.y = innerTop.y - getPadVerticalOverlap();
		}

		if (getDomainButtonsBottom().size() != 0) {
			bottom = new Rectangle();
			bottom.width = getPadDynamicSize(getDomainButtonsBottom().size());
			bottom.height = getPadConstantSize();
			bottom.x = innerBottom.x - bottom.width + getPadHorizontalOverlap();
			bottom.y = innerBottom.y;
		}
	}

	/**
	 * Determines the positions and sizes of all context buttons.
	 */
	protected void initializeButtonPositions() {
		positionedButtons = new ArrayList<PositionedContextButton>();

		for (int i = 0; i < getCollapseAndGenericButtons().size(); i++) {
			int iBackwards = getCollapseAndGenericButtons().size() - 1 - i;
			int x = top.x + getPadPaddingOutside() + (iBackwards * (getButtonSize() + getButtonPadding()));
			if (i == 0 && getCollapseButton() != null && getGenericButtons().size() > 0) {
				// adjust with different padding of collapse button
				x += getCollapseButtonPadding() - getButtonPadding();
			}
			int y = top.y + getPadPaddingInside();
			Rectangle position = new Rectangle(x, y, getButtonSize(), getButtonSize());
			positionedButtons.add(createButton(getCollapseAndGenericButtons().get(i), position));
		}
		for (int i = 0; i < getDomainButtonsRight().size(); i++) {
			int x = right.x + getPadPaddingInside();
			int y = right.y + getPadPaddingOutside() + (i * (getButtonSize() + getButtonPadding()));
			Rectangle position = new Rectangle(x, y, getButtonSize(), getButtonSize());
			positionedButtons.add(createButton(getDomainButtonsRight().get(i), position));
		}
		for (int i = 0; i < getDomainButtonsBottom().size(); i++) {
			int iBackwards = getDomainButtonsBottom().size() - 1 - i;
			int x = bottom.x + getPadPaddingOutside() + (iBackwards * (getButtonSize() + getButtonPadding()));
			int y = bottom.y + getPadPaddingInside();
			Rectangle position = new Rectangle(x, y, getButtonSize(), getButtonSize());
			positionedButtons.add(createButton(getDomainButtonsBottom().get(i), position));
		}
	}

	/**
	 * Determines the containment rectangles.
	 * 
	 * @see #getContainmentRectangles()
	 * @see #getOverlappingContainmentRectangles()
	 */
	protected void initializeContainmentRectangles() {
		containmentRectangles = new ArrayList<Rectangle>();
		overlappingContainmentRectangles = new ArrayList<Rectangle>();

		// first add all pads
		if (getTopPad() != null)
			containmentRectangles.add(getTopPad());
		if (getRightPad() != null)
			containmentRectangles.add(getRightPad());
		if (getBottomPad() != null)
			containmentRectangles.add(getBottomPad());

		// then add all buttons which are not completely inside already added
		// rectangles (mostly they will be inside the pads)
		for (PositionedContextButton button : getPositionedContextButtons()) {
			boolean buttonInside = false;
			for (Rectangle rectangle : containmentRectangles) {
				if (rectangle.contains(button.getPosition())) {
					buttonInside = true;
					break;
				}
			}
			if (!buttonInside) {
				containmentRectangles.add(button.getPosition());
			}
		}

		// create the overlapping containment rectangles from the just chosen
		// containment rectangles
		Rectangle r = getOriginalReferenceRectangle();
		Point referencePoint = new Point(r.x + (r.width / 2), r.y + (r.height / 2));
		for (Rectangle rectangle : containmentRectangles) {
			Rectangle unionRectangle = rectangle.union(new Rectangle(referencePoint));
			overlappingContainmentRectangles.add(unionRectangle);
		}
		// and add the original reference rectangle itself
		overlappingContainmentRectangles.add(getOriginalReferenceRectangle());
	}

	/**
	 * Returns the constant size of the pads (width of the right pad, height of the top and bottom pad).
	 * 
	 * @return The constant size of the pads (width of the right pad, height of the top and bottom pad).
	 */
	private int getPadConstantSize() {
		return getPadPaddingInside() + getButtonSize() + getPadPaddingInside();
	}

	/**
	 * Returns the dynamic size of the pads (height of the right pad, width of the top and bottom pad).
	 * 
	 * @param numberOfButtons
	 *            The number of buttons in the pad for which to calculate the size.
	 * @return The dynamic size of the pads (height of the right pad, width of the top and bottom pad).
	 */
	private int getPadDynamicSize(int numberOfButtons) {
		return (2 * getPadPaddingOutside()) + (numberOfButtons * getButtonSize()) + ((numberOfButtons - 1) * getButtonPadding());
	}
}
