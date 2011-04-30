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

package org.eclipse.imp.model.internal;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.model.ISourceEntity;
import org.eclipse.imp.model.ISourceFolder;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.model.IWorkspaceModel;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.model.ModelFactory.ModelException;
import org.eclipse.imp.runtime.RuntimePlugin;

public class SourceFolder implements ISourceFolder {
    private static final ISourceEntity[] NO_CHILDREN= new ISourceEntity[0];

    private final ISourceProject fSrcProject;

    private final IPath fProjRelPath;

    public SourceFolder(ISourceProject srcProject, IPath projRelPath) {
        fSrcProject= srcProject;
        fProjRelPath= projRelPath;
    }

    public String getName() {
        return fProjRelPath.lastSegment();
    }

    public ISourceEntity[] getChildren() {
        Set<IResource> children= ResourceUtility.getImmediateChildren(fSrcProject.getRawProject().findMember(fProjRelPath));
        Set<ISourceEntity> result= new HashSet<ISourceEntity>();

        for(IResource child : children) {
            try {
                result.add(ModelFactory.open(child));
            } catch (ModelException e) {
                RuntimePlugin.getInstance().logException(e.getMessage(), e);
            }
        }
        return result.toArray(new ISourceEntity[children.size()]);
    }

    public ISourceEntity getParent() {
        try {
            if (fProjRelPath.segmentCount() > 1)
                return ModelFactory.open(fSrcProject.getRawProject().findMember(fProjRelPath.removeLastSegments(1)));
            else
                return fSrcProject;
        } catch (ModelException e) {
            RuntimePlugin.getInstance().logException("Error retrieving parent of source folder " + this, e);
            return null;
        }
    }

    public ISourceEntity getAncestor(Class ofType) {
        if (ofType == ISourceProject.class) {
            return fSrcProject;
        } else if (ofType == IWorkspaceModel.class) {
            return ModelFactory.getModelRoot();
        } else if (ofType == ISourceFolder.class) {
            return this;
        }
        return null;
    }

    public IPath getPath() {
        return fProjRelPath;
    }

    public ISourceProject getSrcProject() {
        return fSrcProject;
    }

    public IResource getResource() {
        return fSrcProject.getRawProject().findMember(fProjRelPath);
    }

    public void commit(IProgressMonitor monitor) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SourceFolder))
            return false;
        SourceFolder other= (SourceFolder) obj;
        return fSrcProject.equals(other.fSrcProject) && fProjRelPath.equals(other.fProjRelPath);
    }

    @Override
    public int hashCode() {
        int result= 199;
        result= result * 5827 + fSrcProject.hashCode();
        result= result * 4639 + fProjRelPath.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "<source folder @ " + fSrcProject.getRawProject().getName() + " : " + fProjRelPath.toPortableString() + ">";
    }
}
