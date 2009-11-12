/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.dnd.ListViewDragSource;
import com.extjs.gxt.ui.client.dnd.ListViewDropTarget;
import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.IconButton;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;

/**
 * Combines two list fields and allows selections to be moved between fields
 * either using buttons or by dragging and dropping selections.
 * 
 * @param <D> the model type
 */
public class DualListField<D extends ModelData> extends MultiField<Field<?>> {

  /**
   * The dual list field messages.
   */
  public class DualListFieldMessages extends FieldMessages {

    private String moveUp;
    private String moveDown;
    private String addAll;
    private String addSelected;
    private String removeSelected;
    private String removeAll;

    /**
     * Returns the add all tooltip.
     * 
     * @return the add all tooltip
     */
    public String getAddAll() {
      return addAll;
    }

    /**
     * Returns the add selected tooltip.
     * 
     * @return the add selected tooltip
     */
    public String getAddSelected() {
      return addSelected;
    }

    /**
     * Returns the move down tooltip.
     * 
     * @return the move down tooltip
     */
    public String getMoveDown() {
      return moveDown;
    }

    /**
     * Sets the move up tooltip.
     * 
     * @return the move up tooltip
     */
    public String getMoveUp() {
      return moveUp;
    }

    /**
     * Returns the remove all tooltip.
     * 
     * @return the remove all tooltip
     */
    public String getRemoveAll() {
      return removeAll;
    }

    /**
     * Returns the remove selected tooltip.
     * 
     * @return the remove selected tooltip
     */
    public String getRemoveSelected() {
      return removeSelected;
    }

    /**
     * Sets the add all tooltip (defaults to 'Add all').
     * 
     * @param addAll the add all tooltip
     */
    public void setAddAll(String addAll) {
      this.addAll = addAll;
    }

    /**
     * Sets the add selected tooltip (defaults to 'Add selected').
     * 
     * @param addSelected the add selected tooltip
     */
    public void setAddSelected(String addSelected) {
      this.addSelected = addSelected;
    }

    /**
     * Sets the move selected down tooltip (defaults to 'Move selected down').
     * 
     * @param moveDown the move down tootip
     */
    public void setMoveDown(String moveDown) {
      this.moveDown = moveDown;
    }

    /**
     * Sets the move selected up tooltip (defaults to 'Move selected up').
     * 
     * @param moveUp
     */
    public void setMoveUp(String moveUp) {
      this.moveUp = moveUp;
    }

    /**
     * Sets the remove all tooltip (defaults to 'Remove all').
     * 
     * @param removeAll the remove all tooltip
     */
    public void setRemoveAll(String removeAll) {
      this.removeAll = removeAll;
    }

    /**
     * Sets the remove selected tooltip (defaults to 'Remove selected').
     * 
     * @param removeSelected the remove selected tooltip
     */
    public void setRemoveSelected(String removeSelected) {
      this.removeSelected = removeSelected;
    }

  }

  public enum Mode {
    APPEND, INSERT;
  }

  protected ListField<D> fromField;
  protected ListField<D> toField;
  protected AdapterField buttonAdapter;
  protected VerticalPanel buttonBar;
  protected Mode mode = Mode.APPEND;

  private String dndGroup;
  private boolean enableDND = true;

  public DualListField() {
    fromField = new ListField<D>();
    toField = new ListField<D>();

    messages = new DualListFieldMessages();

    buttonBar = new VerticalPanel();
    buttonBar.setStyleAttribute("margin", "7px");
    buttonBar.setHorizontalAlign(HorizontalAlignment.CENTER);
    buttonAdapter = new AdapterField(buttonBar);

    add(fromField);
    add(buttonAdapter);
    add(toField);
  }

  public String getDNDGroup() {
    return dndGroup;
  }

  /**
   * Returns the from list field.
   * 
   * @return the field
   */
  public ListField<D> getFromList() {
    return fromField;
  }

  @Override
  public DualListFieldMessages getMessages() {
    return (DualListFieldMessages) messages;
  }

  /**
   * Returns the list field's mode.
   * 
   * @return the mode
   */
  public Mode getMode() {
    return mode;
  }

  /**
   * Returns the to list field.
   * 
   * @return the field
   */
  public ListField<D> getToList() {
    return toField;
  }

  /**
   * Returns true if drag and drop is enabled.
   * 
   * @return true if drag and drop is enabled
   */
  public boolean isEnableDND() {
    return enableDND;
  }

  /**
   * Sets the drag and drop group name. A group name will be generated if none
   * is specified.
   * 
   * @param group the group name
   */
  public void setDNDGroup(String group) {
    this.dndGroup = group;
  }

  /**
   * True to allow selections to be dragged and dropped between lists (defaults
   * to true).
   * 
   * @param enableDND true to enable drag and drop
   */
  public void setEnableDND(boolean enableDND) {
    this.enableDND = enableDND;
  }

  /**
   * Specifies if selections are either inserted or appended when moving between
   * lists.
   * 
   * @param mode the mode
   */
  public void setMode(Mode mode) {
    this.mode = mode;
  }

  protected void initButtons() {
    if (mode == Mode.INSERT) {
      String tip = "";
      if (getMessages().getMoveUp() == null) {
        tip = GXT.MESSAGES.listField_moveSelectedUp();
      } else {
        tip = getMessages().getMoveUp();
      }

      IconButton up = new IconButton("arrow-up");
      up.setHeight(18);
      up.setToolTip(tip);
      up.addListener(Events.Select, new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent be) {
          toField.getListView().moveSelectedUp();
        }
      });
      buttonBar.add(up);
    }

    String tip = "";
    if (getMessages().getAddAll() == null) {
      tip = GXT.MESSAGES.listField_addAll();
    } else {
      tip = getMessages().getAddAll();
    }

    IconButton allRight = new IconButton("arrow-double-right");
    allRight.setHeight(18);
    allRight.setToolTip(tip);
    allRight.addListener(Events.Select, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent be) {
        List<D> sel = fromField.getStore().getModels();
        toField.getStore().add(sel);
        fromField.getStore().removeAll();
      }
    });
    buttonBar.add(allRight);

    tip = "";
    if (getMessages().getAddSelected() == null) {
      tip = GXT.MESSAGES.listField_addSelected();
    } else {
      tip = getMessages().getAddSelected();
    }

    IconButton right = new IconButton("arrow-right");
    right.setHeight(18);
    right.setToolTip(tip);
    right.addListener(Events.Select, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent be) {
        List<D> sel = fromField.getSelection();
        for (D model : sel) {
          fromField.getStore().remove(model);
        }
        toField.getStore().add(sel);
        select(toField, sel);
      }
    });

    tip = "";
    if (getMessages().getRemoveSelected() == null) {
      tip = GXT.MESSAGES.listField_removeSelected();
    } else {
      tip = getMessages().getRemoveSelected();
    }

    IconButton left = new IconButton("arrow-left");
    left.setHeight(18);
    left.setToolTip(tip);
    left.addListener(Events.Select, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent be) {
        List<D> sel = toField.getSelection();
        for (D model : sel) {
          toField.getStore().remove(model);
        }
        fromField.getStore().add(sel);
        select(fromField, sel);
      }
    });

    buttonBar.add(right);
    buttonBar.add(left);

    tip = "";
    if (getMessages().getRemoveAll() == null) {
      tip = GXT.MESSAGES.listField_removeAll();
    } else {
      tip = getMessages().getRemoveAll();
    }

    IconButton allLeft = new IconButton("arrow-double-left");
    allLeft.setHeight(18);
    allLeft.setToolTip(tip);
    allLeft.addListener(Events.Select, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent be) {
        List<D> sel = toField.getStore().getModels();
        fromField.getStore().add(sel);
        toField.getStore().removeAll();
      }
    });
    buttonBar.add(allLeft);

    if (mode == Mode.INSERT) {
      tip = "";
      if (getMessages().getMoveDown() == null) {
        tip = GXT.MESSAGES.listField_moveSelectedDown();
      } else {
        tip = getMessages().getMoveDown();
      }

      IconButton down = new IconButton("arrow-down");
      down.setHeight(18);
      down.setToolTip(tip);
      down.addListener(Events.Select, new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent be) {
          toField.getListView().moveSelectedDown();
        }
      });
      buttonBar.add(down);
    }
  }

  protected void initDND() {
    if (dndGroup == null) {
      dndGroup = getId() + "-group";
    }

    ListViewDragSource source1 = new ListViewDragSource(fromField.getListView());
    ListViewDragSource source2 = new ListViewDragSource(toField.getListView());

    source1.setGroup(dndGroup);
    source2.setGroup(dndGroup);

    ListViewDropTarget target1 = new ListViewDropTarget(fromField.getListView());
    target1.setAutoSelect(true);
    ListViewDropTarget target2 = new ListViewDropTarget(toField.getListView());
    target2.setAutoSelect(true);

    target1.setGroup(dndGroup);
    target2.setGroup(dndGroup);

    if (mode == Mode.INSERT) {
      target1.setFeedback(Feedback.INSERT);
      target2.setFeedback(Feedback.INSERT);
    }
  }

  protected void initLists() {
    fromField.setHeight(125);
    toField.setHeight(125);
  }

  @Override
  protected void onRender(Element target, int index) {
    initLists();
    initButtons();

    super.onRender(target, index);

    if (enableDND) {
      initDND();
    }
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    if (orientation == Orientation.HORIZONTAL) {
      int w = (width - buttonAdapter.el().getParent().getWidth()) / 2;
      w -= (fields.size() * spacing);
      fromField.setWidth(w);
      toField.setWidth(w);
    } else {
      for (Field<?> f : fields) {
        f.setWidth(width);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void select(final ListField<?> field, final List list) {
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        field.getListView().getSelectionModel().select(list, false);
      }
    });
  }

}
