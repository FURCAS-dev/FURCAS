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
 * $Id: PasteFromClipboardOverrideCommand.java,v 1.3 2006/12/29 18:29:10 marcelop Exp $
 */
package org.eclipse.emf.mapping.command;


import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.CreateCopyCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.mapping.domain.MappingDomain;


/**
 * This command overrides the PasteFromClipboardCommand for cross-domain (optimized) copies.
 */
public class PasteFromClipboardOverrideCommand extends PasteFromClipboardCommand
{
  public PasteFromClipboardOverrideCommand(MappingDomain domain, PasteFromClipboardCommand command)
  {
    super(domain, command.getOwner(), command.getFeature(), command.getIndex(), domain.getOptimizeCopy());
  }

  @Override
  protected boolean optimizedCanExecute()
  {
    Collection<?> collection = domain.getClipboard();
    if (collection == null)
    {
      return false;
    }

    // We'll try adding a shallow copy of the clipboard contents, instead of a full copy.
    // Note: we can't just try adding the clipboard contents itself, because the copy may be a
    //       different type then what's on the clipboard (e.g. EJB Field -> RDB Column).
    //
    CopyCommand.Helper copyHelper = new CopyCommand.Helper();
    CompoundCommand shallowCopyCommand = new CompoundCommand(CompoundCommand.MERGE_COMMAND_ALL);
    for (Object object : collection)
    {
      if (!shallowCopyCommand.appendAndExecute(CreateCopyCommand.create(domain, object, copyHelper)))
      {
        shallowCopyCommand.dispose();
        return false;
      }
    }

    Command addCommand = AddCommand.create(domain, owner, feature, shallowCopyCommand.getResult());
    boolean result = addCommand.canExecute();

    shallowCopyCommand.dispose();
    addCommand.dispose();

    return result;
  }

}
