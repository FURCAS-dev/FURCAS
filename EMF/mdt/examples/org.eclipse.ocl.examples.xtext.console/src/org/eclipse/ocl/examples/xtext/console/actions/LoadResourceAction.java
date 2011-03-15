/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: LoadResourceAction.java,v 1.1 2011/03/11 20:23:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.console.actions;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.xtext.console.OCLConsolePage;
import org.eclipse.ocl.examples.xtext.console.XtextConsolePlugin;
import org.eclipse.ocl.examples.xtext.console.messages.OCLInterpreterMessages;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * An action that loads the last-evaluated OCL expression to an XMI file.
 */
public class LoadResourceAction extends org.eclipse.emf.edit.ui.action.LoadResourceAction
{
    protected final OCLConsolePage consolePage;
//	private final String tip;
	
	/**
	 * Initializes me.
	 */
	public LoadResourceAction(OCLConsolePage consolePage) {
		this.consolePage = consolePage;
		Bundle bundle = XtextConsolePlugin.getInstance().getBundle();
		Path imagePath = new Path("$nl$/icons/elcl16/OCLModelFile.gif"); //$NON-NLS-1$
		URL imageFile = FileLocator.find(bundle, imagePath, null);
		setImageDescriptor(ImageDescriptor.createFromURL(imageFile));
		setToolTipText(OCLInterpreterMessages.console_loadResourceAction_tip);
	}

	@Override
	public void run() {
	      Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	      ExtendedLoadResourceDialog loadResourceDialog =
	        new ExtendedLoadResourceDialog(shell, domain)
	      {

			@Override
			protected boolean processResources() {
				ResourceSet resourceSet = consolePage.getEditorDocument().getResourceSet();
		        for (URI uri : getURIs())
		        {
		          try
		          {
					Resource resource = resourceSet.getResource(uri, true);
					if (!processResource(resource))
		            {
		              return false;
		            }
		          }
		          catch (RuntimeException exception)
		          {
		            EMFEditUIPlugin.INSTANCE.log(exception);
		          }
		        }
				return true;
			}

			@Override
			protected boolean processResource(Resource resource) {
				// TODO Auto-generated method stub
				return true;
			}
	    	  
	      };
	      loadResourceDialog.open();
/*	      if (loadResourceDialog.open() == Window.OK && !loadResourceDialog.getRegisteredPackages().isEmpty())
	      {
	        String source = EcoreEditorPlugin.INSTANCE.getSymbolicName();
	        BasicDiagnostic diagnosic = 
	          new BasicDiagnostic(Diagnostic.INFO, source, 0, EcoreEditorPlugin.INSTANCE.getString("_UI_RuntimePackageDetail_message"), null);
	        for (EPackage ePackage : loadResourceDialog.getRegisteredPackages())
	        {
	          diagnosic.add(new BasicDiagnostic(Diagnostic.INFO, source, 0, ePackage.getNsURI(), null));
	        }
	        new DiagnosticDialog
	         (shell, 
	          EcoreEditorPlugin.INSTANCE.getString("_UI_Information_title"), 
	          EcoreEditorPlugin.INSTANCE.getString("_UI_RuntimePackageHeader_message"),
	          diagnosic,
	          Diagnostic.INFO).open();
	      } */
	 	}

	@Override
	public void update() {
		super.update();
	}
}