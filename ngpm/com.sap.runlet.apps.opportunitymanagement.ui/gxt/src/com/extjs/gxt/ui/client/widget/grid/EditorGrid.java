/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.EditorEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * Adds editing capabilities to Grid.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeEdit</b> : GridEvent(grid, record, property, value, rowIndex,
 * colIndex)<br>
 * <div>Fires before cell editing is triggered. Listeners can cancel the action
 * by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>record : the record being edited</li>
 * <li>property : the property being edited</li>
 * <li>value : the value being edited</li>
 * <li>rowIndex : the current row</li>
 * <li>colIndex : the current column</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>AfterEdit</b> : GridEvent(grid, record, property, value, startValue,
 * rowIndex, colIndex)<br>
 * <div>Fires after a cell is edited.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>record : the record being edited</li>
 * <li>property : the property being edited</li>
 * <li>value : the value being set</li>
 * <li>startValue : the value before the edit</li>
 * <li>rowIndex : the current row</li>
 * <li>colIndex : the current column</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ValidateEdit</b> : GridEvent(grid, record, property, value,
 * startValue, rowIndex, colIndex)<br>
 * <div>Fires right before the record is updated. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>record : the record being edited</li>
 * <li>property : the property being edited</li>
 * <li>value : the value being set</li>
 * <li>startValue : the value before the edit</li>
 * <li>rowIndex : the current row</li>
 * <li>colIndex : the current column</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 */
public class EditorGrid<M extends ModelData> extends Grid<M> implements EditSupport {

  /**
   * ClicksToEdit enumeration.
   */
  public enum ClicksToEdit {
    /**
     * Editing start with one click.
     */
    ONE, 
    /**
     * Editing starts with double click.
     */
    TWO;
  }

  private boolean editing;
  private ClicksToEdit clicksToEdit = ClicksToEdit.ONE;
  protected CellEditor activeEditor;
  private Record activeRecord;
  private Listener<DomEvent> editorListener;
  private Listener<GridEvent<M>> gridListener;
  private boolean ignoreScroll;

  /**
   * Creates a new editor grid.
   * 
   * @param store the store
   * @param cm the column model
   */
  @SuppressWarnings("unchecked")
  public EditorGrid(ListStore store, ColumnModel cm) {
    super(store, cm);
    setSelectionModel(new CellSelectionModel<M>());
    setTrackMouseOver(false);
  }

  public CellEditor getActiveEditor() {
    return activeEditor;
  }

  /**
   * Returns the clicks to edit.
   * 
   * @return the clicks to edit
   */
  public ClicksToEdit getClicksToEdit() {
    return clicksToEdit;
  }

  /**
   * Returns true if editing is active.
   * 
   * @return the editing state
   */
  public boolean isEditing() {
    return editing;
  }

  /**
   * Sets the number of clicks to edit (defaults to ONE).
   * 
   * @param clicksToEdit the clicks to edit
   */
  public void setClicksToEdit(ClicksToEdit clicksToEdit) {
    this.clicksToEdit = clicksToEdit;
  }

  /**
   * Starts editing the specified for the specified row/column.
   * 
   * @param row the row index
   * @param col the column index
   */
  @SuppressWarnings("unchecked")
  public void startEditing(final int row, final int col) {
    stopEditing();
    if (cm.isCellEditable(col)) {
      getView().ensureVisible(row, col, false);

      final M m = store.getAt(row);
      activeRecord = store.getRecord(m);

      final String field = cm.getDataIndex(col);
      GridEvent<M> e = (GridEvent)createComponentEvent(null);
      e.setModel(m);
      e.setRecord(activeRecord);
      e.setProperty(field);
      e.setRowIndex(row);
      e.setColIndex(col);
      e.setValue(m.get(field));
      if (fireEvent(Events.BeforeEdit, e)) {
        DeferredCommand.addCommand(new Command() {

          public void execute() {
            editing = true;
            CellEditor ed = cm.getEditor(col);
            ed.row = row;
            ed.col = col;

            if (!ed.isRendered()) {
              ed.render((Element) view.getEditorParent());
            }

            if (editorListener == null) {
              editorListener = new Listener<DomEvent>() {
                public void handleEvent(DomEvent e) {
                  if (e.getType() == Events.Complete) {
                    EditorEvent ee = (EditorEvent) e;
                    onEditComplete((CellEditor) ee.getEditor(), ee.getValue(),
                        ee.getStartValue());
                  } else if (e.getType() == Events.SpecialKey) {
                    sm.onEditorKey(e);
                  } else if (e.getType() == Events.CancelEdit) {
                    EditorEvent ee = (EditorEvent) e;
                    onEditCancel((CellEditor) ee.getEditor(), ee.getValue(),
                        ee.getStartValue());
                  }
                }
              };
            }

            ed.addListener(Events.Complete, editorListener);
            ed.addListener(Events.SpecialKey, editorListener);
            ed.addListener(Events.CancelEdit, editorListener);

            activeEditor = ed;
            // when inserting the editor into the last row, the body is
            // scrolling and edit is being cancelled
            ignoreScroll = true;
            ed.startEdit((Element) view.getCell(row, col), m.get(field));
            DeferredCommand.addCommand(new Command() {
              public void execute() {
                ignoreScroll = false;
              }
            });
          }
        });

      }
    }
  }

  /**
   * Stops any active editing.
   */
  public void stopEditing() {
    stopEditing(false);
  }

  /**
   * Stops any active editing.
   * 
   * @param cancel true to cancel, false to complete
   */
  public void stopEditing(boolean cancel) {
    if (activeEditor != null) {
      if (cancel) {
        activeEditor.cancelEdit();
      } else {
        activeEditor.completeEdit();
      }
    }
  }

  protected void onAutoEditClick(GridEvent<M> e) {
    if (e.getEvent().getButton() != Event.BUTTON_LEFT) {
      return;
    }
    int row = view.findRowIndex(e.getTarget());
    int cell = view.findRowIndex(e.getTarget());
    if (row != -1 && cell != -1) {
      stopEditing();
    }
  }

  protected void onCellDoubleClick(GridEvent<M> e) {
    startEditing(e.getRowIndex(), e.getColIndex());
  }

  protected void onEditCancel(CellEditor ed, Object value, Object startValue) {
    editing = false;
    activeEditor = null;
    ed.removeListener(Events.SpecialKey, editorListener);
    ed.removeListener(Events.Complete, editorListener);
    ed.removeListener(Events.CancelEdit, editorListener);
    getView().focusCell(ed.row, ed.col, false);
  }

  @SuppressWarnings("unchecked")
  protected void onEditComplete(CellEditor ed, Object value, Object startValue) {
    editing = false;
    activeEditor = null;
    ed.removeListener(Events.SpecialKey, editorListener);
    ed.removeListener(Events.Complete, editorListener);
    ed.removeListener(Events.CancelEdit, editorListener);
    Record r = activeRecord;
    String field = cm.getDataIndex(ed.col);
    if ((value == null && startValue != null)
        || (value != null && !value.equals(startValue))) {
      GridEvent<M> ge = (GridEvent)createComponentEvent(null);
      ge.setRecord(r);
      ge.setProperty(field);
      ge.setValue(value);
      ge.setStartValue(startValue);
      ge.setRowIndex(ed.row);
      ge.setColIndex(ed.col);

      if (fireEvent(Events.ValidateEdit, ge)) {
        r.set(ge.getProperty(), ge.getValue());
        r.setValid(ge.getProperty(), ed.getField().isValid(true));
        fireEvent(Events.AfterEdit, ge);
      }
    }

    getView().focusCell(ed.row, ed.col, false);
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);

    gridListener = new Listener<GridEvent<M>>() {
      public void handleEvent(GridEvent<M> e) {
        EventType type = e.getType();
        if (type == Events.BodyScroll) {
          if (!ignoreScroll) {
            stopEditing(true);
          }
        } else if (type == Events.CellClick || type == Events.CellDoubleClick) {
          e.cancelBubble();
          onCellDoubleClick(e);
        }
      }
    };

    addListener(Events.BodyScroll, gridListener);

    if (clicksToEdit == ClicksToEdit.ONE) {
      addListener(Events.CellClick, gridListener);
    } else {
      addListener(Events.CellDoubleClick, gridListener);
    }

    addStyleName("x-edit-grid");
    if (GXT.isSafari) {
      el().setTop(0);
      el().setScrollTop(0);
      el().makePositionable();
    }
  }

}
