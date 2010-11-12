/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The set command logically acts upon an owner object to set a particular feature to a specified value or to unset a feature.
 * The static create methods delegate command creation to {@link EditingDomain#createCommand EditingDomain.createCommand},
 * which may or may not result in the actual creation of an instance of this class.
 *
 * <p>
 * The implementation of this class is low-level and EMF specific;
 * it allows a value to be set to a single-valued feature of an owner,
 * i.e., it is equivalent of the call
 * <pre>
 *   ((EObject)object).eSet((EStructuralFeature)feature, value);
 * </pre>
 * or to 
 * <pre>
 *   ((EObject)object).eUnset((EStructuralFeature)feature);
 * </pre>
 * if the value is {@link #UNSET_VALUE}.
 * <p>
 * Setting a feature that is a bidirectional reference with a multiplicity-many reverse or with a
 * multiplicity-1 reverse that is already set (on value), is not undoable.
 * In this case, the SetResourceURICommand static create function will not return an instance of this class, but
 * instead will return a compound command (e.g., a {@link RemoveCommand} followed by an {@link AddCommand}
 * for the other end of the relation) which could not be undone.
 * <p>
 * The exception to the above is when an empty list is being set to empty or unset. Such commands are undoable
 * and represent the only way to toggle whether the feature is set.
 * <p>
 * When setting a containment (or container) feature, we always assume that the object that will be
 * contained is not already in a container, but take no action in this class to ensure this is the case. 
 * <p>
 * A set command is an {@link OverrideableCommand}.
 */
public class SetResourceURICommand extends AbstractOverrideableCommand {

	/**
	 * This creates a command to set the owner's feature to the specified value.
	 */
	/*  public static Command create(EditingDomain domain, final Object owner, Object feature, Object value) 
	{
	// If the feature is a bidirectional reference with a multiplicity-many reverse, a composite reverse,
	// or a multiplicity-1 reverse that is already set (on value), then we'll switch things around and 
	// execute this command a little differently, because otherwise it's not undoable.
	//
	if (owner instanceof EObject && ((EObject)owner).eClass().getEAllReferences().contains(feature))
	{
	  EReference eReference = (EReference)feature;
	    {
	      compound = 
	        new CompoundCommand(CompoundCommand.LAST_COMMAND_ALL, LABEL, DESCRIPTION)
	        {
	          @Override
	          public Collection<?> getAffectedObjects()
	          {
	            return Collections.singleton(owner);
	          }
	        };
	    }

	    if (!oldValues.isEmpty())
	    {
	      if (!values.isEmpty())
	      {
	        List<Object> removedValues = new BasicEList.FastCompare<Object>(oldValues);
	        removedValues.removeAll(values);

	        // If we aren't simply removing all the old values...
	        //
	        if (!removedValues.equals(oldValues))
	        {
	          // If there are values to remove, append a command for them.
	          //
	          if (!removedValues.isEmpty())
	          {
	            compound.append(RemoveCommand.create(domain, owner, feature, new BasicEList<Object>(removedValues)));
	          }

	          // Determine the values that will remain and move them into the right order, if necessary.
	          //
	          List<Object> remainingValues = new BasicEList.FastCompare<Object>(oldValues);
	          remainingValues.removeAll(removedValues);
	          int count = -1;
	          for (Object object : values)
	          {
	            int position = remainingValues.indexOf(object);
	            if (position != -1 && position != ++count)
	            {
	              compound.append(MoveCommand.create(domain, owner, feature, object, count));
	            }
	          }

	          // Determine the values to be added and add them at the right position.
	          //
	          List<Object> addedValues = new BasicEList.FastCompare<Object>(values);
	          addedValues.removeAll(remainingValues);
	          for (ListIterator<?> i = values.listIterator(); i.hasNext(); )
	          {
	            Object object = i.next();
	            if (addedValues.contains(object))
	            {
	              int addIndex = i.previousIndex();
	              if (addIndex > oldValues.size())
	              {
	                addIndex = -1;
	              }
	              compound.append(AddCommand.create(domain, owner, feature, object, addIndex));
	            }
	          }
	          return compound;
	        }
	      }

	      compound.append(RemoveCommand.create(domain, owner, feature, new BasicEList<Object>(oldValues)));
	    }

	    if (!values.isEmpty())
	    {
	      compound.append(AddCommand.create(domain, owner, feature, values));
	    }
	    else
	    {
	      compound.append(domain.createCommand(SetResourceURICommand.class, new CommandParameter(owner, feature, value)));
	    }
	    return compound;
	  } // end setting whole list
	  else if (eReference.getEOpposite() != null)
	  {
	    EReference eOtherEnd = eReference.getEOpposite();
	    if (eOtherEnd.isMany())
	    {
	      if (eReference.isMany())
	      {
	        // For a many-to-many association, the command can only be undoable if the value or owner is last in its
	        // respective list, since the undo will include an inverse add.  So, if the value is last, but the owner is
	        // not, we create an undoable compound command that removes from the opposite end and then inserts the new
	        // value.
	        //
	        EList<?> list = (EList<?>)((EObject)owner).eGet(eReference);
	        if (index == list.size() - 1)
	        {
	          EObject oldValue = (EObject)list.get(index);
	          EList<?> oppositeList = (EList<?>)oldValue.eGet(eOtherEnd);
	          if (oppositeList.get(oppositeList.size() - 1) != owner)
	          {
	            CompoundCommand compound = 
	              new CompoundCommand(CompoundCommand.LAST_COMMAND_ALL, LABEL, DESCRIPTION)
	              {
	                @Override
	                public Collection<?> getAffectedObjects()
	                {
	                  return Collections.singleton(owner);
	                }
	              };
	            compound.append(RemoveCommand.create(domain, oldValue, eOtherEnd, owner));
	            compound.append(AddCommand.create(domain, owner, feature, value));
	            return compound;
	          }
	        }
	      }
	      else
	      {
	        // For a 1-to-many association, doing the set as a remove and add from the other end will make it undoable.
	        // In particular, if there is an existing non-null value, we first need to remove it from the other end, so
	        // that it will be reinserted at the correct index on undo. 
	        //
	        Object oldValue = ((EObject)owner).eGet(eReference);

	        if (value == null || value == UNSET_VALUE) 
	        {
	          if (oldValue == null) 
	          { // (value == null) && (oldValue == null)
	            // A simple set/unset will suffice.
	            //
	            return domain.createCommand(SetResourceURICommand.class, new CommandParameter(owner, eReference, value));
	          }
	          else 
	          { // (value == null) && (oldValue != null)
	            // Remove owner from the old value and unset if necessary.
	            //
	            Command removeCommand = RemoveCommand.create(domain, oldValue, eOtherEnd, Collections.singleton(owner));

	            if (value != UNSET_VALUE)
	            {
	              return removeCommand;
	            }
	            else
	            {
	              CompoundCommand compound = new PessimisticStrictCompoundCommand(LABEL, DESCRIPTION);
	              compound.append(removeCommand);
	              compound.append(domain.createCommand(SetResourceURICommand.class, new CommandParameter(owner, eReference, value)));
	              return compound;
	            }
	          }
	        }
	        else 
	        { // ((value != null) 
	          Command addCommand = 
	            new CommandWrapper(AddCommand.create(domain, value, eOtherEnd, Collections.singleton(owner)))
	            {
	              @Override
	              public Collection<?> getAffectedObjects()
	              {
	                return Collections.singleton(owner);
	              }
	            };

	          if (oldValue == null) 
	          { // (value != null) && (oldValue == null)
	            // Add owner to new value.
	            //
	            return addCommand;
	          }
	          else 
	          { // ((value != null) && (oldValue != null))
	            // Need a compound command to remove owner from old value and add it to new value.
	            //
	            CompoundCommand compound = new CompoundCommand(CompoundCommand.LAST_COMMAND_ALL, LABEL, DESCRIPTION);
	            compound.append(RemoveCommand.create(domain, oldValue, eOtherEnd, Collections.singleton(owner)));
	            compound.append(addCommand);
	            return compound;
	          }
	        }
	      }
	    }
	    else if (eOtherEnd.isContainment())
	    {
	      if (value != null && value != UNSET_VALUE)
	      {
	        // For consistency, we always set 1-1 container relations from the container end.
	        //
	        return 
	          new CommandWrapper(SetResourceURICommand.create(domain, value, eOtherEnd, owner))
	          {
	            @Override
	            public Collection<?> getResult()
	            {
	              return Collections.singleton(owner);
	            }
	            @Override
	            public Collection<?> getAffectedObjects()
	            {
	              return Collections.singleton(owner);
	            }
	          };
	      }
	    }
	    else
	    {
	      // For a many-to-1 or 1-to-1 association, if the opposite reference on the new value is already set to
	      // something, we need a compound command that first explicitly removes that reference, so that it will be
	      // restored in the undo.
	      //
	      if (value instanceof EObject && ((EObject)value).eGet(eOtherEnd) != null)
	      {
	        CompoundCommand compound = 
	          new CompoundCommand(CompoundCommand.LAST_COMMAND_ALL)
	          {
	            @Override
	            public boolean canUndo()
	            {
	              return true;
	            }
	          };
	        if (eReference.isMany())
	        {
	          // For a many-to-1, we use SetResourceURICommand.create() to create the command to remove the opposite reference;
	          // a RemoveCommand on its opposite will actually result.
	          //
	          compound.append(SetResourceURICommand.create(domain, value, eOtherEnd, null));
	        }
	        else
	        {
	          // For a 1-to-1, we can directly create a SetResourceURICommand.
	          //
	          compound.append(domain.createCommand(SetResourceURICommand.class, new CommandParameter(value, eOtherEnd, null)));
	        }
	        compound.append(domain.createCommand(SetResourceURICommand.class, new CommandParameter(owner, eReference, value, index)));
	        return compound;
	      }
	    }
	  }
	}
	return domain.createCommand(SetResourceURICommand.class, new CommandParameter(owner, feature, value, index));
	} */

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = "SetURILabel"; //EMFEditPlugin.INSTANCE.getString("_UI_SetCommand_label");

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = "SetURIDescription"; //EMFEditPlugin.INSTANCE.getString("_UI_SetCommand_description");

	/**
	 * This is the owner object upon which the command will act.
	 */
	protected Resource owner;

	/**
	 * This is the value to be set.
	 */
	protected URI value;

	/**
	 * This is the old value of the feature which must be restored during undo.
	 */
	protected URI oldValue;

	/**
	 * This constructs a primitive command to set the owner's feature to the specified value.
	 */
	public SetResourceURICommand(EditingDomain domain, Resource owner, URI value) {
		super(domain, LABEL, DESCRIPTION);
		this.owner = owner;
		this.value = value;
	}

	protected static final EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	@Override
	public void doExecute() {
		owner.setURI(value);
	}

	@Override
	public boolean doCanUndo() {
		return true;
	}

	@Override
	public Collection<?> doGetAffectedObjects() {
		return Collections.singleton(owner);
	}

	@Override
	public Collection<?> doGetResult() {
		return Collections.singleton(owner);
	}

	@Override
	public void doRedo() {
		owner.setURI(value);
	}

	@Override
	public void doUndo() {
		owner.setURI(oldValue);
	}

	/**
	 * This returns the old value of the feature which must be restored during undo.
	 */
	public URI getOldValue() {
		return oldValue;
	}

	/**
	 * This returns the owner object upon which the command will act.
	 */
	public Resource getOwner() {
		return owner;
	}

	/**
	 * This returns the value to be set.
	 */
	public URI getValue() {
		return value;
	}

	@Override
	protected boolean prepare() {
		oldValue = owner.getURI();
		return true;
	}

	/**
	 * This gives an abbreviated name using this object's own class' name, without package qualification,
	 * followed by a space separated list of <tt>field:value</tt> pairs.
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (owner: " + owner + ")");
		result.append(" (feature: URI)");
		result.append(" (value: " + value + ")");
		result.append(" (oldValue: " + oldValue + ")");

		return result.toString();
	}
}
