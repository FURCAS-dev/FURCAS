/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.indexing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.language.LanguageValidator;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.utils.StreamUtils;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 2005  All Rights Reserved
 */

/**
 * @author rfuhrer@watson.ibm.com
 */
public class Indexer {
    private final Language fLanguage; // used to locate the index file

    private IndexContributorBase fIndexer;

    private IParseController fParser;

    /**
     * The set of index entries for the current project being indexed
     */
    private Set/*<IndexEntry>*/ fProjectEntries= new HashSet();

    /**
     * Creates an index for the shared elements in this language
     */
    public Indexer(String languageName) {
        fLanguage= LanguageRegistry.findLanguage(languageName);
        fIndexer= ServiceFactory.getInstance().getIndexContributor(fLanguage);
        fParser= ServiceFactory.getInstance().getParseController(fLanguage);
    }

    // Probably don't ever want to do this; the complete set of indexes is huge.
    // Instead, each project index should probably be loaded and then searched
    // from within the top-level search loop.
    public void loadAll() {
        IProject[] projects= ResourcesPlugin.getWorkspace().getRoot().getProjects();

        for(int i= 0; i < projects.length; i++) {
            load(projects[i]);
        }
    }

    /**
     * Opens the index file for reading. The index file is stored in the plug-in's state location. If this is the first
     * time the index is opened, it will be created. The inputstream has to be closed after usage.
     * 
     * @return an inputstream containing the index file
     */
    public void load(IProject project) {
        try {
            File file= getPersistentIndexFile(project);

            readEntries(new BufferedReader(new FileReader(file)));
        } catch (IOException e) {
            ErrorHandler.reportError("Cannot open persistent index for " + fLanguage);
        }
    }

    private void readEntries(BufferedReader reader) throws IOException {
        String line;

        while ((line= reader.readLine()) != null) {
            IndexEntry entry= fIndexer.parseEntry(line);

            addEntry(entry);
        }
    }

    public void clearEntries() {
        fProjectEntries.clear();
    }

    public void addEntry(IndexEntry entry) {
        fProjectEntries.add(entry);
    }

    public void createAllIndexes() {
	if (fParser == null) {
	    RuntimePlugin.getInstance().writeErrorMsg("No parser for language " + fLanguage + "; indexing disabled.");
	    return;
	}

	IProject[] projects= ResourcesPlugin.getWorkspace().getRoot().getProjects();

        for(int i= 0; i < projects.length; i++) {
            clearEntries(); // no turds from previous projects
            createProjectIndex(projects[i]);
            save(projects[i]);
        }
    }

    public void createProjectIndex(IProject project) {
        final LanguageValidator validator= fLanguage.getValidator();
        final IProgressMonitor monitor= new NullProgressMonitor();

        try {
            project.accept(new IResourceProxyVisitor() {
                public boolean visit(IResourceProxy proxy) throws CoreException {
                    if (proxy.getType() == IResource.FILE) {
                        String name= proxy.getName();

                        if (fLanguage.hasExtension(name.substring(name.lastIndexOf('.') + 1))) {
                            IFile file= (IFile) proxy.requestResource();

                            if (validator == null || validator.validate(file)) {
                        	String contents= StreamUtils.readStreamContents(file.getContents(), file.getCharset());
                                Object ast= fParser.parse(contents, monitor);

                                if (ast != null)
                                    fIndexer.contributeEntries(ast, Indexer.this);
                                else
                                    RuntimePlugin.getInstance().writeErrorMsg("Unable to parse file " + file.getFullPath() + "; indexing suppressed.");
                            }
                        }
                    }
                    return false;
                }
            }, 0);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the index file for saving. The output stream should be closed after usage.
     * 
     * @return an outputStream the user can write to.
     */
    public void save(IProject project) {
        try {
            File file= getPersistentIndexFile(project);
            FileWriter writer= new FileWriter(file);

            for(Iterator iter= fProjectEntries.iterator(); iter.hasNext(); ) {
                IndexEntry entry= (IndexEntry) iter.next();

                entry.saveToStream(writer);
            }
        } catch (IOException e) {
            ErrorHandler.reportError("Cannot open persistent index for " + fLanguage + " and project " + project.getName(), e);
        }
    }

    /**
     * Returns the index file. The index file is stored in the plug-in's state location. If this is the first time the
     * index is opened, it will be created.
     * @param project the project whose index file should be loaded
     * 
     * @return the file where the persistent index is stored
     * @return null when the file cannot be created
     */
    private File getPersistentIndexFile(IProject project) {
        try {
            IPath path= RuntimePlugin.getInstance().getStateLocation().append(project.getName());
            File file= new File(path.toFile(), fLanguage + ".index");

            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            ErrorHandler.reportError("Cannot locate index file for " + fLanguage + " and project " + project.getName(), e);
            return null;
        }
    }
}
