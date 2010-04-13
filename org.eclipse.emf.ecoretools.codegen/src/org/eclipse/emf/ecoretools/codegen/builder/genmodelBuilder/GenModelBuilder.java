/***********************************************************************
 * Copyright (c) 2007,2008 Harman/Becker Automotive Systems GmbH and 
 * others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * GenModelBuilder.java
 * 
 * Contributors:
 *    Daniel Weber - initial API and implementation
 *    Lucas Bigeardel - IP integration
 * 
 * $Id: GenModelBuilder.java,v 1.4 2008/07/15 15:14:45 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.codegen.builder.genmodelBuilder;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.codegen.builder.EmfBuilderPrefsInitializer;
import org.eclipse.emf.ecoretools.codegen.builder.genmodelBuilder.l10n.Messages;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * An incremental project builder generating code from emf .genmodel files
 * 
 * @author DaWeber
 */
public class GenModelBuilder extends IncrementalProjectBuilder
{
   /**
    * A resource visitor used during incremental builds. It calls the emf
    * generator for every genmodel file that has changed.
    * 
    * @author DaWeber
    */
   private class GenModelDeltaVisitor implements IResourceDeltaVisitor
   {
      /*
       * (non-Javadoc)
       * 
       * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
       */
      public boolean visit(IResourceDelta delta) throws CoreException
      {
         IResource resource = delta.getResource();
         if(resource instanceof IFile && resource.getName().endsWith(".genmodel")) //$NON-NLS-1$
         {
            if(!resource.isDerived())
            {

               resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
               switch(delta.getKind())
               {
               case IResourceDelta.ADDED:
                  generateEmfCode(resource);
                  break;
               case IResourceDelta.CHANGED:
                  generateEmfCode(resource);
                  break;
               }
            }
         }
         // return true to continue visiting children.
         return true;
      }
   }

   /**
    * A resource visitor used during full builds. It calls the emf generator for
    * all .genmodel files it visits.
    * 
    * @author DaWeber
    */
   private class GenModelResourceVisitor implements IResourceVisitor
   {
      public boolean visit(IResource resource) throws CoreException
      {
         if(resource instanceof IFile && resource.getName().endsWith(".genmodel")) //$NON-NLS-1$
         {
            if(!resource.isDerived())
            {
               resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE);
               generateEmfCode(resource);
            }
         }
         return true;
      }
   }

   public static final String          BUILDER_ID = "org.eclipse.emf.ecoretools.codegen.genModelBuilder"; //$NON-NLS-1$

   private ComposedAdapterFactory      adapterFactory;

   private final GenModelDeltaVisitor  deltaVisitor;
   private AdapterFactoryEditingDomain editingDomain;
   private Generator                   generator;
   private IProgressMonitor            monitor;
   private GenModelResourceVisitor     resourceVisitor;

   /**
    *
    */
   public GenModelBuilder()
   {
      deltaVisitor = new GenModelDeltaVisitor();
      resourceVisitor = new GenModelResourceVisitor();
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
    *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
    */
   @Override
   @SuppressWarnings("unchecked")
   protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
         throws CoreException
   {
      this.monitor = monitor;
      if(kind == FULL_BUILD)
      {
         getProject().accept(resourceVisitor);
      }
      else
      {
         IResourceDelta delta = getDelta(getProject());
         if(delta != null)
         {
            delta.accept(deltaVisitor);
         }
      }
      this.monitor = null;
      return null;
   }

   /**
    *
    */
   private void createEditingDomain()
   {
      adapterFactory = new ComposedAdapterFactory(
            ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

      // Create the editing domain with a special command stack.
      //
      editingDomain = new AdapterFactoryEditingDomain(adapterFactory, null) {
         @Override
         public CommandStack getCommandStack()
         {
            throw new RuntimeException(Messages.getString("GenModelBuilder.NoCommandStackError")); //$NON-NLS-1$
         }

         @Override
         public boolean isReadOnly(Resource resource)
         {
            return super.isReadOnly(resource)
                  || getResourceSet().getResources().indexOf(resource) != 0;
         }
      };

      editingDomain.getResourceSet().getURIConverter().getURIMap().putAll(
            EcorePlugin.computePlatformURIMap());
   }

   /**
    * Extracts the GenModel from a given resource
    * 
    * @param resource
    *            containing the GenModel
    * @return The extracted GenModel, null if something went wrong
    * @throws CoreException
    *             if error reporting fails
    */
   private GenModel createGenModel(IResource resource) throws CoreException
   {
      URI resourceURI = URI.createPlatformResourceURI(resource.getFullPath().toString(),
            true);
      Resource emfResource = null;
      GenModel ret = null;
      try
      {
         // Load the resource through the editing domain.
         //
         emfResource = editingDomain.getResourceSet().getResource(resourceURI, true);
         ret = (GenModel)emfResource.getContents().get(0);
         ret.reconcile();
         ret.setCanGenerate(true);

         generator = new Generator();
         generator.setInput(ret);
         JControlModel jControlModel = generator.getJControlModel();

         if(ret.isCodeFormatting())
         {
            jControlModel.setLeadingTabReplacement(null);
            jControlModel.setConvertToStandardBraceStyle(false);
         }
      }
      catch(Exception e)
      {
         reportBuildError(resource, e);
      }
      return ret;
   }

   /**
    * @param resource
    * @param genModel
    * @param projectType
    * @param projectName
    * @throws CoreException
    *             if error reporting fails
    */
   private void generateCode(IResource resource, final GenModel genModel,
         final String projectType, final String projectName) throws CoreException
   {
      // this is run as part of the build job, don't fork another
      // job/thread/operation
      try
      {
         BasicDiagnostic diagnostic = new BasicDiagnostic(GenModelEditPlugin.ID, 0, "", //$NON-NLS-1$
               null);

         diagnostic.add(generator.generate(genModel, projectType, projectName,
               BasicMonitor.toMonitor(new SubProgressMonitor(monitor, 0))));

         if(diagnostic.getSeverity() != Diagnostic.OK)
         {
            reportBuildError(resource, diagnostic.getMessage());
         }
      }
      catch(Exception exception)
      {
         reportBuildError(resource, exception);
      }
   }

   /**
    * Generates emf model and edit code
    * 
    * @param resource
    *            containing the GenModel
    * @throws CoreException
    *             if error reporting fails
    */
   private void generateEmfCode(IResource resource) throws CoreException
   {
      ScopedPreferenceStore preferenceStore = new ScopedPreferenceStore(new ProjectScope(
            resource.getProject()), EmfBuilderPrefsInitializer.PREFERENCE_NODE_NAME);
      boolean generateModelCode = preferenceStore
            .getBoolean(EmfBuilderPrefsInitializer.PREF_GENERATE_MODEL_CODE);
      boolean generateEditCode = preferenceStore
            .getBoolean(EmfBuilderPrefsInitializer.PREF_GENERATE_EDIT_CODE);
      boolean generateEditorCode = preferenceStore
            .getBoolean(EmfBuilderPrefsInitializer.PREF_GENERATE_EDITOR_CODE);
      boolean generateTestCode = preferenceStore
            .getBoolean(EmfBuilderPrefsInitializer.PREF_GENERATE_TEST_CODE);

      if(generateEditCode || generateEditorCode || generateModelCode || generateTestCode)
      {
         createEditingDomain();
         GenModel genModel = createGenModel(resource);
         if(null != genModel)
         {
            if(generateModelCode)
            {
               generateCode(resource, genModel,
                     GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, Messages.getString("GenModelBuilder.ModelProjectType.Label")); //$NON-NLS-1$
            }
            if(generateEditCode)
            {
               generateCode(resource, genModel,
                     GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, Messages.getString("GenModelBuilder.EditProjectType.Label")); //$NON-NLS-1$
            }
            if(generateEditorCode)
            {
               generateCode(resource, genModel,
                     GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, Messages.getString("GenModelBuilder.EditorProjectType.Label")); //$NON-NLS-1$

            }
            if(generateTestCode)
            {
               generateCode(resource, genModel,
                     GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE, Messages.getString("GenModelBuilder.TestProjectType.Label")); //$NON-NLS-1$

            }
         }
      }
   }

   /**
    * @param resource
    * @param e
    * @throws CoreException
    *             if reporting the error fails
    */
   private void reportBuildError(IResource resource, Exception e) throws CoreException
   {
      reportBuildError(resource, e.getMessage());
   }

   /**
    * Reports build errors by creating markers for the given resource
    * 
    * @param resource
    * @param msg
    * @throws CoreException
    *             if creating a marker fails
    */
   private void reportBuildError(IResource resource, String msg) throws CoreException
   {
      IMarker marker = resource.createMarker(IMarker.PROBLEM);
      marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
      marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
      marker.setAttribute(IMarker.MESSAGE, msg);
   }

}
