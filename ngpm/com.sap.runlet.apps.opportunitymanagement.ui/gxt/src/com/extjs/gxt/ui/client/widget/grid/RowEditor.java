/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.Map;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ColumnModelEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.RowEditorEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TriggerField;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid.ClicksToEdit;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTip;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;

/**
 * This RowEditor should be used as a plugin to {@link Grid}. It displays an
 * editor for all cells in a row.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeEdit</b> : RowEditorEvent(rowEditor, rowIndex)<br>
 * <div>Fires before row editing is triggered. Listeners can cancel the action
 * by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>rowEditor : this</li>
 * <li>rowIndex : the row index of the row about to be edited</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ValidateEdit</b> : RowEditorEvent(rowEditor, rowIndex, changes)<br>
 * <div>Fires right before the model is updated. Listeners can cancel the action
 * by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>rowEditor : this</li>
 * <li>rowIndex : the row index of the row about to be edited</li>
 * <li>changes : a map of property name and new values</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>AfterEdit</b> : RowEditorEvent(rowEditor, rowIndex, changes)<br>
 * <div>Fires after a row has been edited.</div>
 * <ul>
 * <li>rowEditor : this</li>
 * <li>rowIndex : the row index of the row that was edited</li>
 * <li>changes : a map of property name and new values</li>
 * </ul>
 * </dd>
 * 
 * @param <M> the model type
 */
public class RowEditor<M extends ModelData> extends ContentPanel implements ComponentPlugin {

  private Grid<M> grid;
  private Listener<GridEvent<M>> listener;
  private ClicksToEdit clicksToEdit = ClicksToEdit.ONE;
  private int frameWidth = 5;
  private boolean initialized;
  private ContentPanel btns;
  private int buttonPad = 3;
  private boolean editing;
  private int rowIndex;
  private Record record;
  private M model;
  private Timer monitorTimer;
  private boolean monitorValid = true;
  private boolean bound;
  private int monitorPoll = 200;
  private boolean errorSummary = true;
  private boolean lastValid;
  private ToolTip tooltip;

  public RowEditor() {
    super();
    setFooter(true);
    setLayout(new HBoxLayout());
    addStyleName("x-small-editor");
    baseStyle = "x-row-editor";
  }

  @SuppressWarnings("unchecked")
  public void init(Component component) {
    grid = (Grid<M>) component;

    listener = new Listener<GridEvent<M>>() {

      public void handleEvent(GridEvent<M> be) {
        if (be.getType() == Events.RowDoubleClick) {
          onRowDblClick(be);
        } else if (be.getType() == Events.RowClick) {
          onRowClick(be);
        } else if (be.getType() == Events.OnKeyDown) {
          onGridKey(be);
        } else if (be.getType() == Events.ColumnResize) {
          verifyLayout(true);
        } else if (be.getType() == Events.BodyScroll) {
          positionButtons();
        } else if (be.getType() == Events.Detach || be.getType() == Events.Expand || be.getType() == Events.Collapse) {
          stopEditing(false);
        }

      }

    };
    if (clicksToEdit == ClicksToEdit.TWO) {
      grid.addListener(Events.RowDoubleClick, listener);
    } else {
      grid.addListener(Events.RowClick, listener);
    }
    grid.addListener(Events.OnKeyDown, listener);
    grid.addListener(Events.ColumnResize, listener);
    grid.addListener(Events.BodyScroll, listener);
    grid.addListener(Events.Attach, listener);
    grid.addListener(Events.Detach, listener);
    grid.addListener(Events.Expand, listener);
    grid.addListener(Events.Collapse, listener);
    grid.getColumnModel().addListener(Events.HiddenChange, new Listener<ColumnModelEvent>() {
      public void handleEvent(ColumnModelEvent be) {
        verifyLayout(true);
      }
    });
    grid.getView().addListener(Events.Refresh, new Listener<BaseEvent>() {
      public void handleEvent(BaseEvent be) {
        stopEditing(false);
      }
    });
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    if (ce.getEventTypeInt() == KeyNav.getKeyEvent().getEventCode()) {
      if (ce.getKeyCode() == KeyCodes.KEY_ENTER) {
        stopEditing(true);
      } else if (ce.getKeyCode() == KeyCodes.KEY_ESCAPE) {
        stopEditing(false);
      }
    }
  }

  /**
   * Start editing of a specific row.
   * 
   * @param rowIndex the index of the row to edit.
   * @param doFocus true to focus the field
   */
  @SuppressWarnings("unchecked")
  public void startEditing(int rowIndex, boolean doFocus) {
    if (editing && isDirty()) {
      showTooltip("You need to commit or cancel your changes");
      return;
    }
    removeToolTip();

    RowEditorEvent ree = new RowEditorEvent(this, rowIndex);
    if (!fireEvent(Events.BeforeEdit, ree)) {
      return;
    }
    editing = true;
    Element row = (Element) grid.getView().getRow(rowIndex);

    model = grid.getStore().getAt(rowIndex);
    record = getRecord(model);
    this.rowIndex = rowIndex;
    // values = new ArrayList<Object>();
    if (!isRendered()) {
      render((Element) grid.getView().getEditorParent());
    }
    ComponentHelper.doAttach(this);

    if (!initialized) {
      initFields();
    }
    ColumnModel cm = grid.getColumnModel();

    for (int i = 0, len = cm.getColumnCount(); i < len; i++) {
      Field<Object> f = (Field<Object>) getItem(i);
      String dIndex = cm.getDataIndex(i);
      Object val = cm.getEditor(i).preProcessValue(record.get(dIndex));
      f.updateOriginalValue(val);
      f.setValue(val);
    }

    if (!isVisible()) {
      show();
      doLayout();
    }
    el().setXY(El.fly(row).getXY());
    verifyLayout(true);
    if (doFocus) {
      deferFocus(null);
    }
    lastValid = false;

    el().scrollIntoView((Element) grid.getView().getEditorParent(), false, new int[] {btns.getHeight(), 0});
  }

  /**
   * Stops editing.
   * 
   * @param saveChanges true to save the changes. false to ignore them.
   */
  public void stopEditing(boolean saveChanges) {
    editing = false;
    if (!isVisible()) {
      return;
    }
    if (!saveChanges || !isValid()) {
      hide();
      return;
    }

    Map<String, Object> data = new FastMap<Object>();
    boolean hasChange = false;
    ColumnModel cm = grid.getColumnModel();
    for (int i = 0, len = cm.getColumnCount(); i < len; i++) {
      if (!cm.isHidden(i)) {
        Field<?> f = (Field<?>) getItem(i);
        if (f instanceof LabelField) {
          continue;
        }
        String dindex = cm.getDataIndex(i);
        Object oldValue = record.get(dindex);
        Object value = cm.getEditor(i).postProcessValue(f.getValue());
        if ((oldValue == null && value != null) || (oldValue != null && !oldValue.equals(value))) {
          data.put(dindex, value);
          hasChange = true;
        }
      }
    }
    RowEditorEvent ree = new RowEditorEvent(this, rowIndex);
    ree.setRecord(record);
    ree.setChanges(data);

    if (hasChange && fireEvent(Events.ValidateEdit, ree)) {
      record.beginEdit();
      for (String k : data.keySet()) {
        record.set(k, data.get(k));
      }
      record.endEdit();
      ree.setRecord(record);
      fireEvent(Events.AfterEdit, ree);

    }
    hide();
  }

  protected void afterRender() {
    super.afterRender();
    positionButtons();
    if (monitorValid) {
      startMonitoring();
    }
    btns.setWidth((getMinButtonWidth() * 2) + (frameWidth * 2) + (buttonPad * 4));
  }

  // private
  protected void bindHandler() {
    boolean valid = isValid();
    if (!valid) {
      lastValid = false;
      if (errorSummary) {
        showTooltip(getErrorText());
      }
    } else if (valid && !lastValid) {
      removeToolTip();
      lastValid = true;
    }

    btns.getItem(0).setEnabled(valid);
    // this.fireEvent('validation', this, valid);
    if (!isVisible()) {
      monitorTimer.cancel();
      stopEditing(false);
      removeToolTip();
    }
  }

  protected void deferFocus(final Point pt) {
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        doFocus(pt);
      }
    });
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(btns);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(btns);
  }

  protected void doFocus(Point pt) {
    if (isVisible()) {
      int index = 0;
      if (pt != null) {
        index = getTargetColumnIndex(pt);
      }
      ColumnModel cm = this.grid.getColumnModel();
      for (int i = index, len = cm.getColumnCount(); i < len; i++) {
        ColumnConfig c = cm.getColumn(i);
        if (!c.isHidden() && c.getEditor() != null) {
          c.getEditor().getField().focus();
          break;
        }
      }
    }
  }

  protected void ensureVisible(CellEditor editor) {
    if (isVisible()) {
      grid.getView().ensureVisible(this.rowIndex, indexOf(editor), true);
    }
  }

  protected String getErrorText() {
    StringBuffer sb = new StringBuffer();
    sb.append("<ul>");
    for (int i = 0; i < getItemCount(); i++) {

      Field<?> f = (Field<?>) getItem(i);
      if (!f.isValid(true)) {
        sb.append("<li><b>");
        sb.append(grid.getColumnModel().getColumn(i).getHeader());
        sb.append("</b>: ");
        sb.append(f.getErrorMessage());
        sb.append("</li>");
      }
    }
    sb.append("</ul>");
    return sb.toString();
  }

  protected Record getRecord(M model) {
    return grid.getStore().getRecord(model);
  }

  protected int getTargetColumnIndex(Point pt) {
    int x = pt.x;
    int match = -1;
    for (int i = 0; i < grid.getColumnModel().getColumnCount(); i++) {
      ColumnConfig c = grid.getColumnModel().getColumn(i);
      if (!c.isHidden()) {
        if (El.fly(grid.getView().getHeaderCell(i)).getRegion().right >= x) {
          match = i;
          break;
        }
      }
    }
    return match;
  }

  protected void initFields() {
    ColumnModel cm = grid.getColumnModel();
    for (int i = 0, len = cm.getColumnCount(); i < len; i++) {
      ColumnConfig c = cm.getColumn(i);
      CellEditor ed = c.getEditor();
      if (ed == null) {
        ed = new CellEditor(new LabelField());
        c.setEditor(ed);
      }
      Field<?> f = ed.getField();
      if (f instanceof TriggerField) {
        ((TriggerField<? extends Object>) f).setMonitorTab(true);
      }
      f.setWidth(cm.getColumnWidth(i));
      HBoxLayoutData ld = new HBoxLayoutData();
      if (i == 0) {
        ld.setMargins(new Margins(0, 1, 2, 1));
      } else if (i == len - 1) {
        ld.setMargins(new Margins(0, 0, 2, 1));
      } else {
        ld.setMargins(new Margins(0, 1, 2, 2));
      }

      setNormalWidth(f);
      f.setMessageTarget("tooltip");
      insert(f, i, ld);
    }
    initialized = true;
  }

  @SuppressWarnings("unchecked")
  protected boolean isDirty() {
    for (Component f : getItems()) {
      if (((Field<Object>) f).isDirty()) {
        return true;
      }
    }
    return false;
  }

  protected boolean isValid() {
    boolean valid = true;
    for (Component c : getItems()) {
      Field<?> f = (Field<?>) c;
      if (!f.isValid(true)) {
        return false;
      }
    }
    return valid;
  }

  protected void onGridKey(GridEvent<M> e) {
    if (e.getKeyCode() == KeyCodes.KEY_ENTER && !isVisible()) {
      M r = grid.getSelectionModel().getSelectedItem();
      if (r != null) {
        int index = this.grid.store.indexOf(r);
        startEditing(index, true);
        e.cancelBubble();
      }
    }
  }

  protected void onHide() {
    super.onHide();
    stopMonitoring();
    grid.getView().focusRow(rowIndex);
    record = null;
    model = null;
    ComponentHelper.doDetach(this);
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);

    el().makePositionable(true);
    sinkEvents(KeyNav.getKeyEvent().getEventCode());

    swallowEvent(Events.OnKeyDown, el().dom, false);
    swallowEvent(Events.OnKeyUp, el().dom, false);
    swallowEvent(Events.OnKeyPress, el().dom, false);

    btns = new ContentPanel() {
      protected void createStyles(String baseStyle) {
        baseStyle = "x-plain";
        headerStyle = baseStyle + "-header";
        headerTextStyle = baseStyle + "-header-text";
        bwrapStyle = baseStyle + "-bwrap";
        tbarStyle = baseStyle + "-tbar";
        bodStyle = baseStyle + "-body";
        bbarStyle = baseStyle + "-bbar";
        footerStyle = baseStyle + "-footer";
        collapseStyle = baseStyle + "-collapsed";
      }
    };

    btns.setHeaderVisible(false);
    btns.addStyleName("x-btns");
    btns.setLayout(new TableLayout(2));

    Button saveBtn = new Button("Save", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        stopEditing(true);
      }

    });
    saveBtn.setMinWidth(getMinButtonWidth());
    btns.add(saveBtn);

    Button cancelBtn = new Button("Cancel", new SelectionListener<ButtonEvent>() {

      @Override
      public void componentSelected(ButtonEvent ce) {
        stopEditing(false);
      }

    });
    cancelBtn.setMinWidth(getMinButtonWidth());
    btns.add(cancelBtn);
    btns.render(getElement("bwrap"));
    btns.layout();

  }

  protected void onRowClick(GridEvent<M> e) {
    startEditing(e.getRowIndex(), false);
    deferFocus(e.getXY());
  }

  protected void onRowDblClick(GridEvent<M> e) {
    startEditing(e.getRowIndex(), false);
    deferFocus(e.getXY());
  }

  protected void onShow() {
    super.onShow();
    if (monitorValid) {
      startMonitoring();
    }
  }

  protected void positionButtons() {
    if (btns != null) {
      int h = el().getClientHeight();
      GridView view = grid.getView();
      int scroll = view.getScrollState().x;
      int width = view.mainBody.getWidth(true);
      int bw = btns.getWidth(true);
      btns.setPosition((width / 2) - (bw / 2) + scroll, h - 2);
    }
  }

  protected void removeToolTip() {
    if (tooltip != null) {
      tooltip.disable();
      tooltip.hide();
    }
  }

  protected void showTooltip(String msg) {

    if (tooltip == null) {
      ToolTipConfig config = new ToolTipConfig();
      config.setAutoHide(false);
      config.setMouseOffset(new int[] {25, 0});
      config.setTitle("Errors");
      config.setAnchor("left");
      tooltip = new ToolTip(this, config);
      tooltip.setMaxWidth(600);
    }
    ToolTipConfig config = tooltip.getToolTipConfig();
    config.setText(msg);
    tooltip.update(config);
    tooltip.enable();
    tooltip.show();
  }

  protected void startMonitoring() {
    if (!bound && monitorValid) {
      bound = true;
      if (monitorTimer == null) {
        monitorTimer = new Timer() {

          @Override
          public void run() {
            RowEditor.this.bindHandler();

          }

        };

      }
      monitorTimer.scheduleRepeating(monitorPoll);
    }
  }

  protected void stopMonitoring() {
    bound = false;
    if (monitorTimer != null) {
      monitorTimer.cancel();
    }
    removeToolTip();
  }

  protected void verifyLayout(boolean force) {
    if (isRendered() && (isVisible() || force)) {
      Element row = (Element) grid.getView().getRow(rowIndex);
      setSize(El.fly(row).getWidth(false), btns.getHeight());
      syncSize();
      ColumnModel cm = grid.getColumnModel();
      for (int i = 0, len = cm.getColumnCount(); i < len; i++) {
        if (!cm.isHidden(i)) {
          Field<?> f = (Field<?>) getItem(i);
          f.show();
          MarginData md = (MarginData) ComponentHelper.getLayoutData(f);
          f.setWidth(cm.getColumnWidth(i) - md.getMargins().left - md.getMargins().right);
        } else {
          getItem(i).hide();
        }
      }
      layout();
      positionButtons();
    }
  }

  private native void setNormalWidth(Field<?> f) /*-{
    f.@com.extjs.gxt.ui.client.widget.form.Field::normalWidth = true;
  }-*/;
}
