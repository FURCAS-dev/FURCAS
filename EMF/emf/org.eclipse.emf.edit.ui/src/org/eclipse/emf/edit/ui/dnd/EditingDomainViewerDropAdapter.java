/**
 * <copyright> 
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EditingDomainViewerDropAdapter.java,v 1.10 2008/07/09 00:56:41 davidms Exp $
 */
package org.eclipse.emf.edit.ui.dnd;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * This implementation of a drop target listener is designed to turn a drag and drop
 * operation into a {@link Command} based on the model objects of an
 * {@link EditingDomain} and created by {@link DragAndDropCommand#create}. It is
 * designed to do early data transfer so the the enablement and feedback of the
 * drag and drop interaction can intimately depend on the state of the model objects
 * involved.  On some platforms, however, early data transfer is not available, so this
 * feedback cannot be provided.
 * <p>
 * The base implementation of this class should be sufficient for most applications.
 * Any change in behaviour is typically accomplished by overriding 
 * {@link org.eclipse.emf.edit.provider.ItemProviderAdapter}.createDragAndDropCommand
 * to return a derived implementation of {@link DragAndDropCommand}.
 * This is how one these adapters is typically hooked up:
 * <pre>
 *   viewer.addDropSupport
 *     (DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK,
 *      new Transfer [] { LocalTransfer.getInstance() },
 *      EditingDomainViewerDropAdapter(viewer));
 * </pre>
 * <p>
 * This implementation prefers to use a {@link LocalTransfer}, 
 * which short-circuits the transfer process for simple transfers within the workbench,
 * the method {@link #getDragSource} can be overridden to change the behaviour.
 * The implementation also only handles an {@link IStructuredSelection},
 * but the method {@link #extractDragSource} can be overridden to change the behaviour.
 * <p>
 * SWT's {@link DND#FEEDBACK_SCROLL auto-scroll} and {@link DND#FEEDBACK_EXPAND auto-expand}
 * (hover) are enabled by default.  The method {@link #getAutoFeedback} can be overridden
 * to change this behaviour.
 */
public class EditingDomainViewerDropAdapter extends DropTargetAdapter
{
  /**
   * This indicates whether the current platform is motif, which needs
   * special treatment, since it cannot do early data transfer, but doesn't
   * cleanly return null either.
   */
  protected final static boolean IS_MOTIF = "motif".equals(SWT.getPlatform());

  /**
   * This is the viewer for which this is a drop target listener.
   */
  protected Viewer viewer;

  /**
   * This is the domain in which drag and drop commands will be executed.
   */
  protected EditingDomain domain;

  /**
   * This is the collection of source objects being dragged.
   */
  protected Collection<?> source;

  /**
   * This is the command created during dragging which provides the feedback and will carry out the action upon completion.
   */
  protected Command command;
 
  /**
   * This records the object for which the {@link #command} was created.
   */
  protected Object commandTarget;

  /**
   * This keeps track of the original operation that the user requested, before
   * we started changing the event.detail. We always try to create the command
   * using this.
   */
  protected int originalOperation;

  /**
   * This keeps track of the information used to create {@link #command}, but
   * does not need to be disposed.  This allows us to dispose of the command
   * in dragLeave, and then, if we need to execute it, recreate it in drop.
   */
  protected DragAndDropCommandInformation dragAndDropCommandInformation;

  /**
   * This creates an instance with the given domain and viewer.
   */
  public EditingDomainViewerDropAdapter(EditingDomain domain, Viewer viewer)
  {
    this.viewer = viewer;
    this.domain = domain;
  }

  /**
   * This is called when the mouse first enters or starts dragging in the viewer.
   */
  @Override
  public void dragEnter(DropTargetEvent event)
  {
    // Remember the requested operation.
    originalOperation = event.detail;

    helper(event);
  }

  /**
   * This is called when the mouse leaves or stops dragging in the viewer,
   * whether the operation was aborted or is about to do a dropAccept and drop.
   * The event argument is uninitialized, so it is impossible to distinguish
   * between the two cases.  So, we do the clean-up now and recreate the
   * command later, if necessary.
   */
  @Override
  public void dragLeave(DropTargetEvent event)
  {
    // Clean up the command if there is one.  If we need it again in drop,
    // we'll recreate it from dragAndDropCommandInformation.
    //
    if (command != null)
    {
      command.dispose();
      command = null;
      commandTarget = null;
    }

    // Clear the source data.  We won't need this again, since, if it was
    // available, it's already in the command.
    //
    source = null;
  }

  /**
   * This is called when the operation has changed in some way, typically because the user changes keyboard modifiers.
   */
  @Override
  public void dragOperationChanged(DropTargetEvent event)
  {
    // Remember the requested operation.
    originalOperation = event.detail;

    helper(event);
  }

  /**
   * This is called repeatedly, as the mouse moves over the viewer.
   */
  @Override
  public void dragOver(DropTargetEvent event) 
  {
    helper(event);
  }

  /**
   * This is called when the mouse is released over the viewer to initiate a
   * drop, between dragLeave and drop.
   */
  @Override
  public void dropAccept(DropTargetEvent event) 
  {
    helper(event);
  }

  /**
   * This is called to indicate that the drop action should be invoked.
   */
  @Override
  public void drop(DropTargetEvent event)
  {
    // A command was created if the source was available early, and the
    // information used to create it was cached...
    //
    if (dragAndDropCommandInformation != null)
    {
      // Recreate the command.
      //
      command = dragAndDropCommandInformation.createCommand();
    }
    else
    {
      // Otherwise, the source should be available now as event.data, and we
      // can create the command.
      //
      source = extractDragSource(event.data);
      Object target = extractDropTarget(event.item);
      command = DragAndDropCommand.create(domain, target, getLocation(event), event.operations, originalOperation, source);
    }

    // If the command can execute...
    //
    if (command.canExecute())
    {
      // Execute it.
      //
      domain.getCommandStack().execute(command);
    }
    else
    {
      // Otherwise, let's call the whole thing off.
      //
      event.detail = DND.DROP_NONE;
      command.dispose();
    }

    // Clean up the state.
    //
    command = null;
    commandTarget = null;
    source = null;
    dragAndDropCommandInformation = null;
  }

  /**
   * This method is called the same way for each of the
   * {@link org.eclipse.swt.dnd.DropTargetListener} methods, except for leave
   * and drop.  If the source is available early, it creates or revalidates
   * the {@link DragAndDropCommand}, and updates the event's detail (operation)
   * and feedback (drag under effect), appropriately.
   */
  protected void helper(DropTargetEvent event)
  {
    // If we can't do anything else, we'll provide the default select feedback
    // and enable auto-scroll and auto-expand effects.
    event.feedback = DND.FEEDBACK_SELECT | getAutoFeedback();

    // If we don't already have it, try to get the source early. We can't give
    // feedback if it's not available yet (this is platform-dependent).
    //
    if (source == null)
    {
      source = getDragSource(event);
      if (source == null)
      {
        // Clear out any old information from a previous drag.
        //
        dragAndDropCommandInformation = null;
        return;
      }
    }

    // Get the target object from the item widget and the mouse location in it.
    //
    Object target = extractDropTarget(event.item);
    float location = getLocation(event);

    // Determine if we can create a valid command at the current location.
    //
    boolean valid = false;

    // If we don't have a previous cached command...
    //
    if (command == null)
    {
      // We'll need to keep track of the information we use to create the
      // command, so that we can recreate it in drop.
      dragAndDropCommandInformation = new DragAndDropCommandInformation(domain, target, location, event.operations, originalOperation, source);

      // Remember the target; create the command and test if it is executable.
      //
      commandTarget = target;
      command = dragAndDropCommandInformation.createCommand();
      valid = command.canExecute();
    }
    else
    {
      // Check if the cached command can provide DND feedback/revalidation.
      //
      if (target == commandTarget && command instanceof DragAndDropFeedback)
      {
        // If so, revalidate the command.
        //
        valid = ((DragAndDropFeedback)command).validate(target, location, event.operations, originalOperation, source);

        // Keep track of any changes to the command information.
        dragAndDropCommandInformation = new DragAndDropCommandInformation(domain, target, location, event.operations, originalOperation, source);
      }
      else
      {
        // If not, dispose the current command and create a new one.
        //
        dragAndDropCommandInformation = new DragAndDropCommandInformation(domain, target, location, event.operations, originalOperation, source);
        commandTarget = target;
        command.dispose();
        command = dragAndDropCommandInformation.createCommand();
        valid = command.canExecute();
      }
    }

    // If this command can provide detailed drag and drop feedback...
    //
    if (command instanceof DragAndDropFeedback)
    {
      // Use it for the operation and drag under effect.
      //
      DragAndDropFeedback dragAndDropFeedback = (DragAndDropFeedback)command;
      event.detail = dragAndDropFeedback.getOperation();
      event.feedback = dragAndDropFeedback.getFeedback() | getAutoFeedback();
    }
    else if (!valid)
    {
      // There is no executable command, so we'd better nix the whole deal.
      //
      event.detail = DND.DROP_NONE;
    }
  }

  /**
   * This returns the bitwise OR'ed flags for desired auto-feedback effects.
   * Drag under effect DND constants are always OR'ed with this to enable them.
   * This implementation enables {@link DND#FEEDBACK_SCROLL auto-scroll} and
   * {@link DND#FEEDBACK_EXPAND auto-expand} (hover).
   */
  protected int getAutoFeedback()
  {
    return DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
  }

  /** 
   * This attempts to extract the drag source from the event early, i.e.,
   * before the drop method. This implementation tries to use a
   * {@link org.eclipse.emf.edit.ui.dnd.LocalTransfer}. If the data is not yet
   * available (e.g. on platforms other than win32), it just returns null.
   */
  protected Collection<?> getDragSource(DropTargetEvent event)
  {
    // Check whether the current data type can be transfered locally.
    //
    LocalTransfer localTransfer = LocalTransfer.getInstance();
    if (!localTransfer.isSupportedType(event.currentDataType))
    {
      // Iterate over the data types to see if there is a data type that supports a local transfer.
      //
      TransferData [] dataTypes = event.dataTypes;
      for (int i = 0; i < dataTypes.length; ++i)
      {
        TransferData transferData = dataTypes[i];

        // If the local transfer supports this data type, switch to that data type
        //
        if (localTransfer.isSupportedType(transferData))
        {
          event.currentDataType = transferData;
        }
      }

      return null;
    }
    else
    {
      // Motif kludge: we would get something random instead of null.
      //
      if (IS_MOTIF) return null;

      // Transfer the data and, if non-null, extract it.
      //
      Object object = localTransfer.nativeToJava(event.currentDataType);
      return object == null ? null : extractDragSource(object);
    }
  }

  /**
   * This extracts a collection of dragged source objects from the given object retrieved from the transfer agent.
   * This default implementation converts a structured selection into a collection of elements.
   */
  protected Collection<?> extractDragSource(Object object)
  {
    // Transfer the data and convert the structured selection to a collection of objects.
    //
    if (object instanceof IStructuredSelection)
    {
      List<?> list = ((IStructuredSelection)object).toList();
      return list;
    }
    else
    {
      return Collections.EMPTY_LIST;
    }
  }

  /**
   * This extracts an object from the given item widget, providing the special
   * support required by an 
   * {@link org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ExtendedTableTreeItem}.
   */
  @SuppressWarnings("deprecation")
  protected Object extractDropTarget(Widget item)
  {
    if (item == null) return null;
    return item.getData(org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ITEM_ID) instanceof Item ?
      ((Item)item.getData(org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ITEM_ID)).getData() :
      item.getData();
  }


  /**
   * This returns the location of the mouse in the vertical direction, relative
   * to the item widget, from 0 (top) to 1 (bottom).
   */
  protected float getLocation(DropTargetEvent event) 
  {
    if (event.item instanceof TreeItem)
    {
      TreeItem treeItem = (TreeItem)event.item;
      Control control = treeItem.getParent();
      Point point = control.toControl(new Point(event.x, event.y));
      Rectangle bounds = treeItem.getBounds();
      return (float)(point.y - bounds.y) / (float)bounds.height;
    }
    else if (event.item instanceof TableItem)
    {
      TableItem tableItem = (TableItem)event.item;
      Control control = tableItem.getParent();
      Point point = control.toControl(new Point(event.x, event.y));
      Rectangle bounds = tableItem.getBounds(0);
      return (float)(point.y - bounds.y) / (float)bounds.height;
    }
    else
    {
      return 0.0F;
    }
  }
  
  /**
   * This holds all of the information used to create a
   * {@link DragAndDropCommand}, but does not need to be disposed.
   */
  protected static class DragAndDropCommandInformation
  {
    protected EditingDomain domain;
    protected Object target;
    protected float location;
    protected int operations;
    protected int operation;
    protected Collection<?> source;
    public DragAndDropCommandInformation
      (EditingDomain domain, Object target, float location, int operations, int operation, Collection<?> source)
    {
      this.domain = domain;
      this.target = target;
      this.location = location;
      this.operations = operations;
      this.operation = operation;
      this.source = new ArrayList<Object>(source);
    }

    public Command createCommand()
    {
      return DragAndDropCommand.create(domain, target, location, operations, operation, source);
    }
  }
}
