/***********************************************************************************************************************
 * Copyright (c) 2004, 2005 IBM Corporation and others. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and implementation
 **********************************************************************************************************************/

package com.sap.mi.gfw.eclipse.internal.util.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * A simple pop-up menu with a list from which the user can select one item.
 * <p>
 * The <code>show()</code> method returns false if the user cancelled the gesture or clicked outside the popup.
 * </p>
 * <p>
 * The <code>getResult()</code> method returns the result which is the object from the content list that the user selected, or in the case
 * of cascading menus, a list of the results from each popup.
 * 
 * @author cmahoney
 */
public class PopupMenu {

	/**
	 * An instance of this class can be created to add a submenu to a menu item in a <code>PopupMenu</code>.
	 */
	public static class CascadingMenu {

		/** the content of the parent menu item */
		private Object parentMenuItem;

		/** the sub menu */
		private PopupMenu subMenu;

		/**
		 * Creates a new <code>CascadingMenu</code>.
		 * 
		 * @param aParentMenuItem
		 *            content of the parent menu item
		 * @param aSubMenu
		 *            PopupMenu to be used as a submenu
		 */
		public CascadingMenu(Object aParentMenuItem, PopupMenu aSubMenu) {
			this.parentMenuItem = aParentMenuItem;
			this.subMenu = aSubMenu;
		}

		/**
		 * Gets the parentMenuItem.
		 * 
		 * @return Returns the parentMenuItem.
		 */
		public Object getParentMenuItem() {
			return parentMenuItem;
		}

		/**
		 * Gets the subMenu.
		 * 
		 * @return Returns the subMenu.
		 */
		public PopupMenu getSubMenu() {
			return subMenu;
		}
	}

	/**
	 * The content of this menu. Each entry in the list becomes a menu item.
	 */
	private List content;

	/**
	 * Provides the text and icon for each menu item.
	 */
	private ILabelProvider labelProvider;

	/**
	 * The object from the content list that the user selected. In the case of cascading menus, this will have multiple objects.
	 */
	private List resultList = new ArrayList();

	private Menu menu;

	/**
	 * Creates a new <code>PopupMenu</code>.
	 * 
	 * @param aContent
	 *            the content for the menu, each object in the list represents a menu item
	 * @param aLabelProvider
	 *            the label provider used to provide the text for each object in the content list
	 */
	public PopupMenu(List aContent, ILabelProvider aLabelProvider) {
		setContent(aContent);
		setLabelProvider(aLabelProvider);
	}

	/**
	 * Shows the popup menu and sets the resultList selected by the user.
	 * 
	 * @param parent
	 *            menu will be shown in this parent Control
	 * @return true if this succeeded, false otherwise (e.g. if the user cancelled the gesture).
	 */
	public boolean show(Control parent) {
		menu = new Menu(parent);
		createMenuItems(menu, this, new ArrayList());

		menu.setVisible(true);

		Display display = menu.getDisplay();
		while (!menu.isDisposed() && menu.isVisible()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		if (!menu.isDisposed()) {
			menu.dispose();

			if (getResult() != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates the menu items based on the content list.
	 * 
	 * @param parentMenu
	 *            the parent Menu that the menu items will be created in
	 * @param rootMenu
	 *            the root level Menu
	 * @param resultThusFar
	 *            List of content objects, e.g. CascadingMenu objects
	 */
	protected void createMenuItems(Menu parentMenu, final PopupMenu rootMenu, final List resultThusFar) {
		Assert.isNotNull(getContent());
		Assert.isNotNull(getLabelProvider());

		for (Iterator iter = getContent().iterator(); iter.hasNext();) {
			Object contentObject = iter.next();

			MenuItem menuItem;

			if (contentObject instanceof CascadingMenu) {
				PopupMenu subMenu = ((CascadingMenu) contentObject).getSubMenu();
				contentObject = ((CascadingMenu) contentObject).getParentMenuItem();
				List thisResult = new ArrayList(resultThusFar);
				thisResult.add(contentObject);
				menuItem = new MenuItem(parentMenu, SWT.CASCADE);
				menuItem.setMenu(new Menu(parentMenu));

				subMenu.createMenuItems(menuItem.getMenu(), rootMenu, thisResult);
			} else {
				menuItem = new MenuItem(parentMenu, SWT.NONE);
			}

			final Object fContentObject = contentObject;
			menuItem.setText(getLabelProvider().getText(contentObject));
			menuItem.setImage(getLabelProvider().getImage(contentObject));
			menuItem.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					resultThusFar.add(fContentObject);
					rootMenu.setResult(resultThusFar);
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					resultThusFar.add(fContentObject);
					rootMenu.setResult(resultThusFar);
				}
			});
		}
	}

	/**
	 * Gets the content.
	 * 
	 * @return Returns the content.
	 */
	protected List getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 * 
	 * @param aContent
	 *            The content of this menu. Each entry in the list becomes a menu item.
	 */
	public void setContent(List aContent) {
		this.content = aContent;
	}

	/**
	 * Gets the labelProvider.
	 * 
	 * @return Returns the labelProvider.
	 */
	protected ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * Sets the labelProvider.
	 * 
	 * @param aLabelProvider
	 *            Provides the text and icon for each menu item.
	 */
	public void setLabelProvider(ILabelProvider aLabelProvider) {
		this.labelProvider = aLabelProvider;
	}

	/**
	 * Gets the result which is the object from the content list that the user selected, or in the case of cascading menus, a list of the
	 * results from each popup.
	 * 
	 * @return Returns the resultList.
	 */
	public Object getResult() {
		if (resultList == null || resultList.isEmpty()) {
			return null;
		} else if (resultList.size() == 1) {
			return resultList.get(0);
		}
		return resultList;
	}

	/**
	 * Sets the resultList.
	 * 
	 * @param aResultList
	 *            The resultList to set.
	 */
	protected void setResult(List aResultList) {
		this.resultList = aResultList;
	}

}