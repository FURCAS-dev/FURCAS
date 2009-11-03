package com.sap.mi.gfw.datatypes.impl;

import com.sap.mi.gfw.datatypes.IInsets;

/**
 * The Class InsetsImpl.
 */
public class InsetsImpl implements IInsets {

	private int left;

	private int right;

	private int top;

	private int bottom;

	/**
	 * Instantiates a new insets impl.
	 * 
	 * @param left
	 *            the left
	 * @param right
	 *            the right
	 * @param top
	 *            the top
	 * @param bottom
	 *            the bottom
	 */
	public InsetsImpl(int left, int right, int top, int bottom) {
		setLeft(left);
		setRight(right);
		setTop(top);
		setBottom(bottom);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.IInsets#getBottom()
	 */
	public int getBottom() {
		return bottom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.IInsets#getLeft()
	 */
	public int getLeft() {
		return left;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.IInsets#getRight()
	 */
	public int getRight() {
		return right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.IInsets#getTop()
	 */
	public int getTop() {
		return top;
	}

	/**
	 * Sets the bottom.
	 * 
	 * @param bottom
	 *            the new bottom
	 */
	protected void setBottom(int bottom) {
		this.bottom = bottom;
	}

	/**
	 * Sets the left.
	 * 
	 * @param left
	 *            the new left
	 */
	protected void setLeft(int left) {
		this.left = left;
	}

	/**
	 * Sets the right.
	 * 
	 * @param right
	 *            the new right
	 */
	protected void setRight(int right) {
		this.right = right;
	}

	/**
	 * Sets the top.
	 * 
	 * @param top
	 *            the new top
	 */
	protected void setTop(int top) {
		this.top = top;
	}

}
