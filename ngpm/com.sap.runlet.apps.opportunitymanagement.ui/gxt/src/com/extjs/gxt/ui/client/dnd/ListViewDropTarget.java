/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.dnd;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.ListView;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;

/**
 * A <code>DropTarget</code> implementation for the ListView component.
 */
public class ListViewDropTarget extends DropTarget {

  protected ListView<ModelData> listView;
  protected int insertIndex;

  private boolean autoSelect;

  /**
   * Creates a new list view drop target instance.
   * 
   * @param listView the target list view
   */
  @SuppressWarnings("unchecked")
  public ListViewDropTarget(ListView listView) {
    super(listView);
    this.listView = listView;
  }

  /**
   * Returns the target's list view component.
   * 
   * @return the list view
   */
  public ListView<ModelData> getListView() {
    return listView;
  }

  /**
   * Returns true if auto select is enabled.
   * 
   * @return the auto select state
   */
  public boolean isAutoSelect() {
    return autoSelect;
  }

  @Override
  protected void onDragDrop(DNDEvent e) {
    super.onDragDrop(e);
    final Object data = e.getData();
    DeferredCommand.addCommand(new Command() {
      @SuppressWarnings("unchecked")
      public void execute() {
        List temp = new ArrayList();
        if (data instanceof ModelData) {
          temp.add((ModelData) data);
        } else if (data instanceof List) {
          temp = (List) data;
        }
        if (temp.size() > 0) {
          if (feedback == Feedback.APPEND) {
            listView.getStore().add(temp);
          } else {
            listView.getStore().insert(temp, insertIndex);
          }
          if (autoSelect) {
            listView.getSelectionModel().select(temp, false);
          }
        }
      }
    });
  }

  @Override
  protected void onDragEnter(DNDEvent e) {
    super.onDragEnter(e);
    e.setCancelled(false);
    e.getStatus().setStatus(true);
  }

  @Override
  protected void onDragLeave(DNDEvent e) {
    super.onDragLeave(e);
    Insert insert = Insert.get();
    insert.setVisible(false);
  }

  @Override
  protected void onDragMove(DNDEvent event) {
    event.setCancelled(false);
  }

  /**
   * True to automatically select and new items created after a drop (defaults
   * to false).
   * 
   * @param autoSelect true to auto select
   */
  public void setAutoSelect(boolean autoSelect) {
    this.autoSelect = autoSelect;
  }

  @Override
  protected void showFeedback(DNDEvent event) {
    if (feedback == Feedback.INSERT) {
      event.getStatus().setStatus(true);
      Element row = listView.findElement(event.getTarget()).cast();

      if (row == null && listView.getStore().getCount() > 0) {
        row = listView.getElement(listView.getStore().getCount() - 1).cast();
      }

      if (row != null) {
        int height = row.getOffsetHeight();
        int mid = height / 2;
        mid += row.getAbsoluteTop();
        int y = event.getClientY();
        boolean before = y < mid;
        int idx = listView.indexOf(row);
        insertIndex = before ? idx : idx + 1;
        if (before) {
          showInsert(event, row, true);
        } else {
          showInsert(event, row, false);
        }
      } else {
        insertIndex = 0;
      }
    }
  }

  private void showInsert(DNDEvent event, Element row, boolean before) {
    Insert insert = Insert.get();
    insert.setVisible(true);
    Rectangle rect = El.fly(row).getBounds();
    int y = !before ? (rect.y + rect.height - 4) : rect.y - 2;
    insert.el().setBounds(rect.x, y, rect.width, 6);
  }

}
