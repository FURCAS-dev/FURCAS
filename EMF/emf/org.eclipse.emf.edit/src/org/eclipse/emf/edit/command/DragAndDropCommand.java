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
 * $Id: DragAndDropCommand.java,v 1.10 2007/06/14 18:32:42 emerks Exp $
 */
package org.eclipse.emf.edit.command;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * The drag and drop command logically acts upon an owner object onto which a collection of things is being dragged.
 * The static create method delegates command creation to {@link EditingDomain#createCommand EditingDomain.createCommand},
 * which may or may not result in the actual creation of an instance of this class.
 * <p>
 * The implementation of this class is high-level and generic;
 * it ultimately delegates all behaviour to other types of command,
 * and is typically undoable as a result.
 */
public class DragAndDropCommand extends AbstractCommand implements DragAndDropFeedback
{
  /**
   * This class is used to encode the drag and drop arguments 
   * into an object that will be passed as the feature of a {@link CommandParameter}.
   */
  public static class Detail
  {
    public float location;
    public int operations;
    public int operation;

    public Detail(float location, int operations, int operation)
    {
      this.location = location;
      this.operations = operations;
      this.operation = operation;
    }
  }
 
  /**
   * This creates a command to perform a drag and drop operation upon the owner.
   * See {@link DragAndDropCommand DragAndDropCommand} for a description of the arguments.
   */
  public static Command create(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection)
  {
    return 
      domain.createCommand
        (DragAndDropCommand.class, new CommandParameter(owner, new Detail(location, operations, operation), collection));
  }

  /**
   * This caches the label.
   */
  protected static final String LABEL = EMFEditPlugin.INSTANCE.getString("_UI_DragAndDropCommand_label");

  /**
   * This caches the description.
   */
  protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE.getString("_UI_DragAndDropCommand_description");

  /**
   * This keeps track of the domain in which this command is created.
   */
  protected EditingDomain domain;

  /**
   * This keeps track of the owner that is the target of the drag and drop.
   */
  protected Object owner;

  /**
   * This keeps track of the location of the drag and drop.
   */
  protected float location;

  /**
   * This keeps track of the lower range of locations in which the effect of this command remains unchanged.
   */
  protected float lowerLocationBound;

  /**
   * This keeps track of the upper range of locations in which the effect of this command remains unchanged.
   */
  protected float upperLocationBound;

  /**
   * This keeps track of the permitted operations.
   */
  protected int operations;

  /**
   * This keeps track of the current operation that will be returned by {@link #getOperation}.
   */
  protected int operation;

  /**
   * This keeps track of the feedback that will be returned by {@link #getFeedback}.
   */
  protected int feedback;

  /**
   * This keeps track of the collection of dragged sources.
   */
  protected Collection<?> collection;

  /**
   * This keeps track of the command that implements the drag side of the operation.
   */
  protected Command dragCommand;

  /**
   * This keeps track of whether execute has been called on the {@link #dragCommand}.
   */
  protected boolean isDragCommandExecuted;

  /**
   * This keeps track of the command that implements the drop side of the operation.
   */
  protected Command dropCommand;

  /**
   * This controls whether or not to optimize the {@link #prepare}.
   */
  protected boolean optimize;

  /**
   * This is to remember which owner to use for the drop command in the optimized mode.
   */
  protected Object optimizedDropCommandOwner;

  /**
   * This creates and instance in the given domain and for the given information.
   * The location should be in the range of 0.0 to 1.0,
   * indicating the relative vertical location of the drag operation,
   * where 0.0 is at the top and 1.0 is at the bottom.
   * The operations is a bitwise mask of the DROP_* values.
   * The operation is the desired operation as specified by a DROP_* value.
   * And the collection contains the source objects being dragged.
   */
  public DragAndDropCommand(EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection)
  {
    this(domain, owner, location, operations, operation, collection, domain == null ? false : domain.getOptimizeCopy());
  }
  
  public DragAndDropCommand
    (EditingDomain domain, Object owner, float location, int operations, int operation, Collection<?> collection, boolean optimize)
  {
    super(LABEL, DESCRIPTION);

    this.domain = domain;
    this.owner = owner;
    this.location = location;
    this.operations = operations;
    this.operation = operation;
    this.collection = collection;
    this.optimize = optimize;

    // EATM Leave this disabled for now.
    //
    this.optimize = false;
  }
  
  protected boolean analyzeForNonContainment(Command command)
  {
    if (command instanceof AddCommand)
    {
      return isNonContainment(((AddCommand)command).getFeature());
    }
    else if (command instanceof SetCommand)
    {
      return isNonContainment(((SetCommand)command).getFeature());
    }
    else if (command instanceof CommandWrapper) 
    {
      return analyzeForNonContainment(((CommandWrapper)command).getCommand());
    }
    else if (command instanceof CompoundCommand) 
    {
      for (Command childCommand : ((CompoundCommand)command).getCommandList())
      {
        if (analyzeForNonContainment(childCommand))
        {
          return true;          
        }
      }
    }
  
    return false;
  }
  
  protected boolean isNonContainment(EStructuralFeature feature)
  {
    return feature instanceof EReference && !((EReference)feature).isContainment();
  }

  public Object getOwner()
  {
    return owner;
  }

  public float getLocation()
  {
    return location;
  }

  public int getOperations()
  {
    return operations;
  }

  public Collection<?> getCollection()
  {
    return collection;
  }

  /**
   * This implementation of prepare is called again to implement {@link #validate validate}.
   * The method {@link #reset} will have been called before doing so.
   */
  @Override
  protected boolean prepare()
  {
    // We'll default to this.
    //
    boolean result = false;

    // If there isn't something obviously wrong with the arguments...
    //
    if (owner != null && collection != null && operations != DROP_NONE && operation != DROP_NONE)
    {
      // If the location is near the boundary, we'll start by trying to do a drop insert.
      //
      if (location <= 0.20 || location >= 0.80)
      {
        // If we could do a drop insert operation...
        //
        result = prepareDropInsert();
        if (result)
        {
          // Set the bounds so that we re-check when we are closer to the middle.
          //
          if (location <= 0.20)
          {
            lowerLocationBound = 0.0F;
            upperLocationBound = 0.2F;
          }
          else 
          {
            lowerLocationBound = 0.8F;
            upperLocationBound = 1.0F;
          }
        }
        else
        {
          // We can try to do a drop on instead.
          //
          reset();
          result = prepareDropOn();

          // Set the bounds so that we re-check when we get near the other end.
          //
          if (location <= 0.20)
          {
            lowerLocationBound = 0.0F;
            upperLocationBound = 0.8F;
          }
          else
          {
            lowerLocationBound = 0.2F;
            upperLocationBound = 1.0F;
          }
        }
      }
      // We are near the middle, so we'll start by trying to do a drop on.
      //
      else
      {
        // If we can do a drop on operation.
        //
        result = prepareDropOn();
        if (result)
        {
          // Set the range so that we re-check when we get aren't in the middle.
          //
          lowerLocationBound = 0.2F;
          upperLocationBound = 0.8F;
        }
        else
        {
          // We can reset and try a drop insert instead.
          //
          reset();
          result = prepareDropInsert();

          // Set the range so that we re-check when we get into the other half.
          //
          if (location <= 0.50)
          {
            lowerLocationBound = 0.0F;
            upperLocationBound = 0.5F;
          }
          else 
          {
            lowerLocationBound = 0.5F;
            upperLocationBound = 1.0F;
          }
        }
      }
    }
    else
    {
      // We'll always be wrong for these arguments, so don't bother re-checking.
      //
      lowerLocationBound = 0.0F;
      upperLocationBound = 1.0F;
    }

    return result;
  }

  /**
   * This can be overridden to determine the parent of an object; this implementation uses {@link EditingDomain#getParent}.
   */
  protected Object getParent(Object object)
  {
    return domain.getParent(object);
  }

  /**
   * This can be overridden to determine the children of an object; this implementation uses {@link EditingDomain#getChildren}.
   */
  protected Collection<?> getChildren(Object object)
  {
    return domain.getChildren(object);
  }

  /**
   * This attempts to prepare a drop insert operation.
   */
  protected boolean prepareDropInsert()
  {
    // This will be the default return value.
    //
    boolean result = false;

    // The feedback is set based on which half we are in.
    // If the command isn't executable, these values won't be used.
    //
    feedback = location < 0.5 ? FEEDBACK_INSERT_BEFORE : FEEDBACK_INSERT_AFTER;

    // If we can't determine the parent.
    //
    Object parent = getParent(owner);
    if (parent == null)
    {
      dragCommand = UnexecutableCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    }
    else 
    {
      // Iterate over the children to find the owner.
      //
      Collection<?> children = getChildren(parent);
      int i = 0;
      for (Object child : children)
      {
        // When we match the owner, we're done.
        //
        if (child == owner)
        {
          break;
        }
        ++i;
      }
  
      // If the location indicates after, add one more.
      //
      if (location >= 0.5)
      {
        ++i;
      }

      // Try to create a specific command based on the current desired operation.
      //
      switch (operation)
      {
        case DROP_MOVE:
        {
          result = prepareDropMoveInsert(parent, children, i); 
          break;
        }
        case DROP_COPY:
        {
          result = prepareDropCopyInsert(parent, children, i);
          break;
        }
        case DROP_LINK:
        {
          result = prepareDropLinkInsert(parent, children, i);
          break;
        }
      }

      // If there isn't an executable command we should maybe try a copy operation, but only if we're allowed and not doing a link.
      //
      if (!result && operation != DROP_COPY && operation != DROP_LINK && (operations & DROP_COPY) != 0)
      {
        // Try again.
        //
        reset();
        result = prepareDropCopyInsert(parent, children, i);

        if (result)
        {
          // We've switch the operation!
          //
          operation = DROP_COPY;
        }
      }

      // If there isn't an executable command we should maybe try a link operation, but only if we're allowed and not doing a link.
      //
      if (!result && operation != DROP_LINK && (operations & DROP_LINK) != 0)
      {
        // Try again.
        //
        reset();
        result = prepareDropLinkInsert(parent, children, i);
        if (result)
        {
          // We've switch the operation!
          //
          operation = DROP_LINK;
        }
      }
    }

    return result;
  }

  /**
   * This attempts to prepare a drop move insert operation.
   */
  protected boolean prepareDropMoveInsert(Object parent, Collection<?> children, int index)
  {
    // We don't want to move insert an object before or after itself...
    //
    if (collection.contains(owner))
    {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    }
    // If the dragged objects share a parent...
    //
    else if (children.containsAll(collection))
    {
      dragCommand = IdentityCommand.INSTANCE;

      // Create move commands for all the objects in the collection.
      //
      CompoundCommand compoundCommand = new CompoundCommand();
      List<Object> before = new ArrayList<Object>();
      List<Object> after = new ArrayList<Object>();

      int j = 0;
      for (Object object : children)
      {
        if (collection.contains(object))
        {
          if (j < index)
          {
            before.add(object);
          }
          else if (j > index)
          {
            after.add(object);
          }
        }
        ++j;
      }

      for (Object object : before)
      {
        compoundCommand.append(MoveCommand.create(domain, parent, null, object, index - 1));
      }

      for (ListIterator<Object> objects = after.listIterator(after.size()); objects.hasPrevious(); )
      {
        Object object = objects.previous();
        compoundCommand.append(MoveCommand.create(domain, parent, null, object, index));
      }

      dropCommand = compoundCommand.getCommandList().size() == 0 ? (Command)IdentityCommand.INSTANCE : compoundCommand;
    }
    else if (isCrossDomain())
    {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    }
    else
    {
      // Just remove the objects and add them.
      //
      dropCommand = AddCommand.create(domain, parent, null, collection, index);
      if (analyzeForNonContainment(dropCommand))
      {
        dropCommand.dispose();
        dropCommand = UnexecutableCommand.INSTANCE;
        dragCommand = IdentityCommand.INSTANCE;
      }
      else
      {
        dragCommand = RemoveCommand.create(domain, collection);
      }
    }

    boolean result = dragCommand.canExecute() && dropCommand.canExecute();
    return result;
  }

  protected boolean isCrossDomain()
  {
    for (Object item : collection)
    {
      EditingDomain itemDomain = AdapterFactoryEditingDomain.getEditingDomainFor(item);
      if (itemDomain != null && itemDomain != domain)
      {
        return true;
      }
    }
    return false;
  }

  /**
   * This attempts to prepare a drop copy insert operation.
   */
  protected boolean prepareDropCopyInsert(final Object parent, Collection<?> children, final int index)
  {
    boolean result;
    
    // We don't want to copy insert an object before or after itself...
    //
    if (collection.contains(owner))
    {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
      result = false;
    }
    else
    {
      // Copy the collection
      //
      dragCommand = CopyCommand.create(domain, collection);

      if (optimize) 
      {
        result = optimizedCanExecute();
        if (result)
        {
          optimizedDropCommandOwner = parent;
        }
      }
      else 
      {
        if (dragCommand.canExecute() && dragCommand.canUndo())
        {
          dragCommand.execute();
          isDragCommandExecuted = true;

          // And add the copy.
          //
          dropCommand = AddCommand.create(domain, parent, null, dragCommand.getResult(), index);
          if (analyzeForNonContainment(dropCommand))
          {
            dropCommand.dispose();
            dropCommand = UnexecutableCommand.INSTANCE;

            dragCommand.undo();
            dragCommand.dispose();
            isDragCommandExecuted = false;
            dragCommand = IdentityCommand.INSTANCE;
          }
          result = dropCommand.canExecute();
        }
        else
        {
          dropCommand = UnexecutableCommand.INSTANCE;
          result = false;
        }
      } // if optimize
    } // if collection

    return result;
  }

  /**
   * This attempts to prepare a drop link insert operation.
   */
  protected boolean prepareDropLinkInsert(Object parent, Collection<?> children, int index)
  {
    boolean result;
    
    // We don't want to insert an object before or after itself...
    //
    if (collection.contains(owner))
    {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
      result = false;
    }
    else
    {
      dragCommand = IdentityCommand.INSTANCE;

      // Add the collection
      //
      dropCommand = AddCommand.create(domain, parent, null, collection, index);
      if (!analyzeForNonContainment(dropCommand))
      {
        dropCommand.dispose();
        dropCommand = UnexecutableCommand.INSTANCE;
      }
      result = dropCommand.canExecute();
    }

    return result;
  }

  /**
   * This attempts to prepare a drop on operation.
   */
  protected boolean prepareDropOn()
  {
    // This is the default return value.
    //
    boolean result = false;

    // This is the feedback we use to indicate drop on; it will only be used if the command is executable.
    //
    feedback = FEEDBACK_SELECT;

    // Prepare the right type of operation.
    //
    switch (operation)
    {
      case DROP_MOVE:
      {
        result = prepareDropMoveOn();
        break;
      }
      case DROP_COPY:
      {
        result = prepareDropCopyOn();
        break;
      }
      case DROP_LINK:
      {
        result = prepareDropLinkOn();
        break;
      }
    }

    // If there isn't an executable command we should maybe try a copy operation, but only if we're allowed and not doing a link.
    //
    if (!result && operation != DROP_COPY && operation != DROP_LINK && (operations & DROP_COPY) != 0)
    {
      reset();
      result = prepareDropCopyOn();
      if (result)
      {
        operation = DROP_COPY;
      }
    }

    // If there isn't an executable command we should maybe try a link operation, but only if we're allowed and not doing a link.
    //
    if (!result && operation != DROP_LINK && (operations & DROP_LINK) != 0)
    {
      reset();
      result = prepareDropLinkOn();
      if (result)
      {
        operation = DROP_LINK;
      }
    }

    return result;
  }

  /**
   * This attempts to prepare a drop move on operation.
   */
  protected boolean prepareDropMoveOn()
  {
    if (isCrossDomain())
    {
      dragCommand = IdentityCommand.INSTANCE;
      dropCommand = UnexecutableCommand.INSTANCE;
    }
    else
    {
      dropCommand = AddCommand.create(domain, owner, null, collection);
      if (analyzeForNonContainment(dropCommand))
      {
        dropCommand.dispose();
        dropCommand = UnexecutableCommand.INSTANCE;
        dragCommand = IdentityCommand.INSTANCE;
      }
      else
      {
        dragCommand = RemoveCommand.create(domain, collection);
      }
    }

    boolean result = dragCommand.canExecute() && dropCommand.canExecute();
    return result;
  }

  /**
   * This attempts to prepare a drop copy on operation.
   */
  protected boolean prepareDropCopyOn()
  {
    boolean result;
    
    dragCommand = CopyCommand.create(domain, collection);

    if (optimize) 
    {
      result = optimizedCanExecute();
      if (result)
      {
        optimizedDropCommandOwner = owner;
      }
    }
    else 
    {
      if (dragCommand.canExecute() && dragCommand.canUndo())
      {
        dragCommand.execute();
        isDragCommandExecuted = true; 
        dropCommand = AddCommand.create(domain, owner, null, dragCommand.getResult());
        if (analyzeForNonContainment(dropCommand))
        {
          dropCommand.dispose();
          dropCommand = UnexecutableCommand.INSTANCE;

          dragCommand.undo();
          dragCommand.dispose();
          isDragCommandExecuted = false;
          dragCommand = IdentityCommand.INSTANCE;
        }
      }
      else
      {
        dropCommand = UnexecutableCommand.INSTANCE;
      }
  
      result = dragCommand.canExecute() && dropCommand.canExecute();
    }
    return result;
  }

  /**
   * This attempts to prepare a drop link on operation.
   */
  protected boolean prepareDropLinkOn()
  {
    dragCommand = IdentityCommand.INSTANCE;
    dropCommand = SetCommand.create(domain, owner, null, collection);

    // If we can't set the collection, try setting use the single value of the collection.
    //
    if (!dropCommand.canExecute() && collection.size() == 1)
    {
      dropCommand.dispose();
      dropCommand = SetCommand.create(domain, owner, null, collection.iterator().next());
    }

    if (!dropCommand.canExecute() || !analyzeForNonContainment(dropCommand))
    {
      dropCommand.dispose();
      dropCommand = AddCommand.create(domain, owner, null, collection);
      if (!analyzeForNonContainment(dropCommand))
      {
        dropCommand.dispose();
        dropCommand = UnexecutableCommand.INSTANCE;
      }
    }

    boolean result = dropCommand.canExecute();
    return result;
  }

  protected boolean optimizedCanExecute()
  {
    // We'll assume that the copy command can execute and that adding a copy of the clipboard
    // is the same test as adding the clipboard contents itself.
    //
    Command addCommand = AddCommand.create(domain, owner, null, collection);
    boolean result = addCommand.canExecute() && !analyzeForNonContainment(addCommand);
    addCommand.dispose();
    return result;
  }

  /**
   * This restores the command to its default initialized state, disposing an command that may have been contained.
   */
  protected void reset()
  {
    if (dragCommand != null)
    {
      if (isDragCommandExecuted)
      {
        if (dragCommand.canUndo())
        {
          dragCommand.undo();
        }
      }
      dragCommand.dispose();
    }

    if (dropCommand != null)
    {
      dropCommand.dispose();
    }
  
    // Reset as in the constructor.
    //
    isPrepared = false;
    isExecutable = false;

    dragCommand = null;
    isDragCommandExecuted = false;
    dropCommand = null;
    optimizedDropCommandOwner = null;
  }

  /**
   * This is called by EditingDomainViewerDropAdapter to determine if the drag and drop operation is still enabled.
   */
  public boolean validate(Object owner, float location, int operations, int operation, Collection<?> collection)
  {
    // If the operation has changed significantly...
    //
    if (owner != this.owner ||
         location != this.location || (location < lowerLocationBound || location > upperLocationBound) ||
         operation != this.operation ||
         collection != this.collection)
    {
      // Clean it up.
      //
      reset();

      // Set the arguments again.
      //
      this.owner = owner;
      this.location = location;
      this.operations = operations;
      this.operation = operation;
      this.collection = collection;

      // Determine if the operation is executable.
      //
      return canExecute();
    }
    else
    {
      // Just return the cached result.
      //
      return isExecutable;
    }
  }

  public int getFeedback()
  {
    // Only return the feedback for an executable command.
    //
    return isExecutable ? feedback : FEEDBACK_SELECT;
  }

  public int getOperation()
  {
    // Only return the operation for an executable command.
    //
    return isExecutable ? operation : DROP_NONE;
  }

  public void execute()
  {
    if (dragCommand != null && !isDragCommandExecuted)
    {
      // special case in optimized mode, the drag command wasn't executed, so drag command was not yet created
      //if ((optimizedDropCommandOwner != null) && (dropCommand == null)) {
      if (optimizedDropCommandOwner != null) 
      {
        if (dragCommand.canExecute()) 
        {
          dragCommand.execute();
          dropCommand = AddCommand.create(domain, optimizedDropCommandOwner, null, dragCommand.getResult());
        }
        else 
        {
          // Thread.dumpStack();
        }
      }
      else 
      {
        dragCommand.execute();
      }
    }

    if (dropCommand != null)
    {
      if (dropCommand.canExecute()) 
      {
        dropCommand.execute();
      }
      else 
      {
        // Thread.dumpStack();
      }
    }
  }

  @Override
  public void undo()
  {
    if (dropCommand != null)
    {
      dropCommand.undo();
    }

    if (dragCommand != null)
    {
      dragCommand.undo();
    }
  }

  public void redo()
  {
    if (dragCommand != null)
    {
      dragCommand.redo();
    }

    if (dropCommand != null)
    {
      dropCommand.redo();
    }
  }

  @Override
  public void dispose()
  {
    if (dragCommand != null)
    {
      dragCommand.dispose();
    }
    if (dropCommand != null)
    {
      dropCommand.dispose();
    }
  }

  @Override
  public Collection<?> getResult()
  {
    return
      dropCommand != null ?
        dropCommand.getResult() :
        super.getResult();
  }

  @Override
  public Collection<?> getAffectedObjects()
  {
    return 
      dropCommand != null ?
        dropCommand.getAffectedObjects() :
        super.getAffectedObjects();
  }

  /**
   * This gives an abbreviated name using this object's own class' name, without package qualification,
   * followed by a space separated list of <tt>field:value</tt> pairs.
   */
  @Override
  public String toString()
  {
    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (domain: " + domain + ")");
    result.append(" (owner: " + owner + ")");
    result.append(" (location: " + location + ")");
    result.append(" (lowerLocationBound: " + lowerLocationBound + ")");
    result.append(" (upperLocationBound: " + upperLocationBound + ")");
    result.append(" (operations: " + operations + ")");
    result.append(" (operation: " + operation + ")");
    result.append(" (collection: " + collection + ")");
    result.append(" (feedback: " + feedback + ")");

    return result.toString();
  }
}
