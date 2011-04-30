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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.model.IPathEntry;
import org.eclipse.imp.model.ISourceEntity;
import org.eclipse.imp.model.ISourceFolder;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.model.IWorkspaceModel;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.model.IPathEntry.PathEntryType;
import org.eclipse.imp.model.ModelFactory.ModelException;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SourceProject implements ISourceProject {
    private static final String CONFIG_FILE_NAME= ".projectConfig";
    private final IProject fProject;
    private final List<IPathEntry> fBuildPath= new ArrayList<IPathEntry>();

    public SourceProject(IProject project) {
        fProject= project;

        if (!readMetaData()) {
//            initializeFromJavaProject();
        }
    }

    public void setBuildPath(List<IPathEntry> buildPath) {
        fBuildPath.clear();
        fBuildPath.addAll(buildPath);
    }

    public String getName() {
        return fProject.getName();
    }

    private void saveMetaData(IProgressMonitor monitor) {
        IFile file= fProject.getFile(CONFIG_FILE_NAME);
        String metaData= createProjectMetaData();
        try {
            InputStream is= new ByteArrayInputStream(metaData.getBytes(file.getCharset()));
            file.setContents(is, true, true, monitor);
        } catch (CoreException e) {
            ErrorHandler.reportError(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            ErrorHandler.reportError(e.getMessage(), e);
        }
    }

    private String createProjectMetaData() {
        StringBuffer buff= new StringBuffer();
        buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        buff.append("<project>\n");
        buff.append("  <searchPath>\n");
        for(IPathEntry path: fBuildPath) {
            buff.append("    <pathEntry type=\"" + path.getEntryType() + "\"\n");
            buff.append("               loc=\"" + path.getPath().toPortableString() + "\"/>\n");
        }
        buff.append("  </searchPath>\n");
        buff.append("</project>\n");
        return buff.toString();
    }

    private boolean readMetaData() {
        IFile file= fProject.getFile(CONFIG_FILE_NAME);
        if (file.exists()) {
            try {
                InputStream contents= file.getContents();
                DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
                DocumentBuilder builder= factory.newDocumentBuilder();
                Document document= builder.parse(contents);
                NodeList children= document.getChildNodes();
                Node project= children.item(0);

//              String projLabel= project.getNodeName();
                NodeList configItems= project.getChildNodes();

                for(int i= 0; i < configItems.getLength(); i++) {
                    Node configItem= configItems.item(i);
                    String itemName= configItem.getNodeName();

                    if (itemName.equals("searchPath")) {
                        NodeList pathItems= configItem.getChildNodes();

                        for(int p= 0; p < pathItems.getLength(); p++) {
                            Node pathItem= pathItems.item(p);
                            String nodeName= pathItem.getNodeName();

                            if (nodeName.equals("#text"))
                                continue;
                            if (!nodeName.equals("pathEntry")) {
                                ErrorHandler.reportError("Unexpected child " + nodeName + " of <searchPath> in " + fProject.getFullPath().toPortableString()
                                        + "/" + CONFIG_FILE_NAME);
                                continue;
                            }

                            NamedNodeMap attribs= pathItem.getAttributes();
                            Node typeNode= attribs.getNamedItem("type");
                            Node locNode= attribs.getNamedItem("loc");

                            if (typeNode == null || locNode == null) {
                                ErrorHandler.reportError("<pathEntry> missing type or location in " + fProject.getFullPath().toPortableString() + "/"
                                        + CONFIG_FILE_NAME);
                                continue;
                            }
                            String pathType= typeNode.getNodeValue();
                            String pathLoc= locNode.getNodeValue();
                            IPathEntry entry= new PathEntry(PathEntryType.valueOf(pathType), new Path(pathLoc));

                            fBuildPath.add(entry);
                        }
                    } else if (itemName.equals("#text")) {
                        // skip over these; should be empty anyway
                    } else
                        ErrorHandler.reportError("Unrecognized project configuration item: " + itemName);
                }
                return true;
            } catch (CoreException e) {
                ErrorHandler.reportError(e.getMessage(), e);
            } catch (ParserConfigurationException e) {
                ErrorHandler.reportError(e.getMessage(), e);
            } catch (SAXException e) {
                ErrorHandler.reportError(e.getMessage(), e);
            } catch (IOException e) {
                ErrorHandler.reportError(e.getMessage(), e);
            }
        }
        return false;
    }

    public IPath resolvePath(IPath path) {
        List<IPathEntry> buildPath= getBuildPath();
        IProject rawProject= fProject;

        if (path.isAbsolute()) {
            return path;
        }
        IFile projRelFile= rawProject.getFile(path);

        if (projRelFile.exists())
            return rawProject.getFullPath().append(path);

        for(IPathEntry pathEntry: buildPath) {
            IPath entryPath= pathEntry.getPath();
            IPathEntry.PathEntryType type= pathEntry.getEntryType();

            if (type == IPathEntry.PathEntryType.SOURCE_FOLDER) {
                if (!entryPath.isAbsolute()) {
                    IPath filePath= entryPath.removeFirstSegments(1).append(path);
                    IFile file= rawProject.getFile(filePath);
                    if (file.exists()) {
                        return filePath;
                    }
                } else {
                    // This is a pseudo source folder, not really contained within the project.
                    // The path points outside the workspace, and an IFile can't live outside the
                    // workspace. So use an ordinary Java File to determine whether this path is
                    // resolved.
                    IPath filePath= entryPath.append(path);
                    File f= new File(filePath.toOSString());
                    if (f.exists())
                        return filePath;
                }
            } else if (type == IPathEntry.PathEntryType.PROJECT) {
                try {
                    IProject defProject= ResourcesPlugin.getWorkspace().getRoot().getProject(entryPath.toPortableString());
                    ISourceProject defSrcProject= ModelFactory.open(defProject);
                    IPath defPath= scanSourceFoldersFor(defSrcProject, path);

                    if (defPath != null)
                        return defPath;
                } catch (ModelException e) {
                    ErrorHandler.reportError(e.getMessage());
                }
            } else if (type == IPathEntry.PathEntryType.ARCHIVE) {
                // ???
            }
        }
        return null;
    }

    private IPath scanSourceFoldersFor(ISourceProject srcProject, IPath path) {
        List<IPathEntry> buildPath= srcProject.getBuildPath();
        IProject rawProject= srcProject.getRawProject();

        for(IPathEntry pathEntry: buildPath) {
            IPath entryPath= pathEntry.getPath();
            IPathEntry.PathEntryType type= pathEntry.getEntryType();

            if (type == IPathEntry.PathEntryType.SOURCE_FOLDER) {
                entryPath= entryPath.removeFirstSegments(1); // make project-relative
                IPath filePath= entryPath.append(path);
                IFile f= rawProject.getFile(filePath);

                if (f.exists()) {
                    return filePath;
                }
            }
        }
        return null;
    }

    public List<IPathEntry> getBuildPath() {
        return fBuildPath;
    }

    public IProject getRawProject() {
        return fProject;
    }

    public IResource getResource() {
        return fProject;
    }

    public ISourceFolder[] getSourceRoots() {
        // TODO Bogus: considers ALL folders as source roots; need to read project config
        final Set<ISourceFolder> result= new HashSet<ISourceFolder>();
        Set<IResource> children= ResourceUtility.getImmediateChildren(fProject);

        for(IResource child: children) {
            if (child instanceof IFolder) {
                try {
                    result.add(ModelFactory.open((IFolder) child));
                } catch (ModelException e) {
                    RuntimePlugin.getInstance().logException(e.getMessage(), e);
                }
            }
        }
        return result.toArray(new ISourceFolder[result.size()]);
    }

    public ISourceEntity getParent() {
        return ModelFactory.getModelRoot();
    }

    public ISourceEntity getAncestor(Class ofType) {
        if (ofType == ISourceProject.class) {
            return this;
        } else if (ofType == IWorkspaceModel.class) {
            return ModelFactory.getModelRoot();
        }
        return null;
    }

    public ISourceEntity[] getChildren() {
        final Set<ISourceEntity> result= new HashSet<ISourceEntity>();
        Set<IResource> children= ResourceUtility.getImmediateChildren(fProject);

        for(IResource child: children) {
            try {
                result.add(ModelFactory.open(child));
            } catch (ModelException e) {
                RuntimePlugin.getInstance().logException(e.getMessage(), e);
            }
        }
        return result.toArray(new ISourceEntity[result.size()]);
    }

    // Presumably this will get called by the "New Project" wizard and the Project Properties pages
    public void commit(IProgressMonitor monitor) {
        saveMetaData(monitor);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SourceProject))
            return false;
        SourceProject other= (SourceProject) obj;
        return fProject.equals(other.fProject);
    }

    @Override
    public int hashCode() {
        int result= 6607;
        result= result * 7451 + fProject.hashCode();
        return result;
    }

    public String toString() {
        return "<project: " + fProject.getName() + ">";
    }
}
