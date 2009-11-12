/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.desktop.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.event.WindowListener;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A desktop represents a desktop like application which contains a task bar,
 * start menu, and shortcuts.
 * 
 * <p/>
 * Rather than adding content directly to the root panel, content should be
 * wrapped in windows. Windows can be opened via shortcuts and the start menu.
 * 
 * <p />
 * Desktop requires a 'x-desktop' element in your host page.
 * 
 * <pre>
    &lt;div id="x-desktop">
        &lt;dl id="x-shortcuts">&lt;/dl>
    &lt;/div>
 * </pre>
 */
public class Desktop {

  protected TaskBar taskBar = new TaskBar();
  protected WindowListener listener;
  protected Viewport viewport;
  protected LayoutContainer desktop;
  protected Window activeWindow;
  protected List<Shortcut> shortcuts;
  protected List<Window> windows;
  protected El shortcutEl;

  public Desktop() {
    shortcuts = new ArrayList<Shortcut>();
    windows = new ArrayList<Window>();

    initListeners();

    viewport = new Viewport();
    viewport.setLayout(new RowLayout());

    desktop = new LayoutContainer() {
      @Override
      protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        getElement().appendChild(XDOM.getElementById("x-desktop"));
      }
    };

    viewport.add(desktop, new RowData(1, 1));
    viewport.add(taskBar, new RowData(1, 30));

    Element el = XDOM.getElementById("x-shortcuts");
    if (el == null) {
      el = DOM.createDiv();
      el.setClassName("x-shortcuts");
      XDOM.getBody().appendChild(el);
    }
    shortcutEl = new El(el);
    RootPanel.get().add(viewport);
  }

  /**
   * Adds a shortcut to the desktop.
   * 
   * @param shortcut the shortcut to add
   */
  public void addShortcut(Shortcut shortcut) {
    if (shortcutEl != null) {
      shortcuts.add(shortcut);
      shortcut.render(shortcutEl.dom);
      ComponentHelper.doAttach(shortcut);
    }
  }

  /**
   * Adds a window to the desktop.
   * 
   * @param window the window to add
   */
  public void addWindow(Window window) {
    if (windows.add(window)) {
      window.setContainer(desktop.getElement());
      window.addWindowListener(listener);
    }
  }

  /**
   * Returns the container of the "desktop", which is the viewport minus the
   * task bar.
   * 
   * @return the desktop layout container
   */
  public LayoutContainer getDesktop() {
    return desktop;
  }

  /**
   * Returns the start menu.
   * 
   * @return the start menu
   */
  public StartMenu getStartMenu() {
    return taskBar.getStartMenu();
  }

  /**
   * Returns a list of the desktop's shortcuts.
   * 
   * @return the shortcuts
   */
  public List<Shortcut> getShortcuts() {
    return shortcuts;
  }

  /**
   * Returns the desktop's task bar.
   * 
   * @return the task bar
   */
  public TaskBar getTaskBar() {
    return taskBar;
  }

  /**
   * Returns a list of the desktop's windows.
   * 
   * @return the windows
   */
  public List<Window> getWindows() {
    return windows;
  }

  /**
   * Minimizes the window.
   * 
   * @param window the window to minimize
   */
  public void minimizeWindow(Window window) {
    window.setData("minimize", true);
    window.hide();
  }

  /**
   * Removes a shortcut from the desktop.
   * 
   * @param shortcut the shortcut to remove
   */
  public void removeShortcut(Shortcut shortcut) {
    if (shortcutEl != null) {
      shortcuts.remove(shortcut);
      shortcutEl.dom.removeChild(shortcut.getElement());
      ComponentHelper.doDetach(shortcut);
    }
  }

  /**
   * Removes a window from the desktop.
   * 
   * @param window the window to remove
   */
  public void removeWindow(Window window) {
    if (windows.remove(window)) {
      window.removeWindowListener(listener);
      if (activeWindow == window) {
        activeWindow = null;
      }
      taskBar.removeTaskButton((TaskButton) window.getData("taskButton"));
    }
  }

  protected void initListeners() {
    listener = new WindowListener() {
      @Override
      public void windowActivate(WindowEvent we) {
        markActive(we.getWindow());
      }

      @Override
      public void windowDeactivate(WindowEvent we) {
        markInactive(we.getWindow());
      }

      @Override
      public void windowHide(WindowEvent we) {
        onHide(we.getWindow());
      }

      @Override
      public void windowMinimize(WindowEvent we) {
        minimizeWindow(we.getWindow());
      }

      @Override
      public void windowShow(WindowEvent we) {
        onShow(we.getWindow());
      }

    };

  }

  protected void onHide(Window window) {
    if (window.getData("minimize") != null) {
      return;
    }
    if (activeWindow == window) {
      activeWindow = null;
    }
    taskBar.removeTaskButton((TaskButton) window.getData("taskButton"));
  }

  private void markActive(Window window) {
    if (activeWindow != null && activeWindow != window) {
      markInactive(activeWindow);
    }
    taskBar.setActiveButton((TaskButton) window.getData("taskButton"));
    activeWindow = window;
    TaskButton btn = window.getData("taskButton");
    btn.addStyleName("active-win");
    window.setData("minimize", null);
  }

  private void markInactive(Window window) {
    if (window == activeWindow) {
      activeWindow = null;
      TaskButton btn = window.getData("taskButton");
      btn.removeStyleName("active-win");
    }
  }

  private void onShow(Window window) {
    TaskButton btn = window.getData("taskButton");
    if (btn != null && taskBar.getButtons().contains(btn)) {
      return;
    }
    taskBar.addTaskButton(window);
  }

}
