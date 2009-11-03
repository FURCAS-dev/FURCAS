package com.sap.mi.fwk.util.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.util.FileBasedBuilder;

/**
 * Test implementation of {@link FileBasedBuilder}
 * 
 * @author d031150
 */
public class TestFileBuilder extends FileBasedBuilder {

	static final String EXTENSION = "test";
	
	// Store statically since files need to be accessed from test outside.
	// Is reset before each build.
	private static volatile IFile[] msCreatedFiles;
	private static volatile IFile[] msDeletedFiles;
	private static volatile IFile[] msChangedFiles;
	private static volatile IFile[] msMovedFilesOld;
	private static volatile IFile[] msMovedFilesNew;

	@Override
	protected String[] getFileExtensions() {
		return new String[] {EXTENSION};
	}
	
	@Override
	protected IPath[] getRelevantFolders() throws CoreException {
		IPath[] moinFolders = ModelManager.getInstance().getMoinResourceFolders(getProject());
		return moinFolders;
	}

	@Override
	protected void processAddedFiles(IFile[] files, IProgressMonitor monitor) throws CoreException {
		msCreatedFiles = files;
	}

	@Override
	protected void processDeletedFiles(IFile[] files, IProgressMonitor monitor) throws CoreException {
		msDeletedFiles = files;
	}

	@Override
	protected void processFilesWithChangedContent(IFile[] files, IProgressMonitor monitor) throws CoreException {
		msChangedFiles = files;
	}

	@Override
	protected void processMovedFiles(IFile[] oldFiles, IFile[] newFiles, IProgressMonitor monitor) throws CoreException {
		msMovedFilesOld = oldFiles;
		msMovedFilesNew = newFiles;
	}
	
	static Set<IFile> getCreatedFiles() {
		if (msCreatedFiles != null) 
			return new HashSet<IFile>(Arrays.asList(msCreatedFiles));
		return Collections.emptySet();
	}

	static Set<IFile> getDeletedFiles() {
		if (msDeletedFiles != null)
			return new HashSet<IFile>(Arrays.asList(msDeletedFiles));
		return Collections.emptySet();
	}

	static Set<IFile> getChangedFiles() {
		if (msChangedFiles != null)
			return new HashSet<IFile>(Arrays.asList(msChangedFiles));
		return Collections.emptySet();
	}

	static List<IFile> getMovedFilesOld() {
		if (msMovedFilesOld != null)
			return Arrays.asList(msMovedFilesOld);
		return Collections.emptyList();
	}

	static List<IFile> getMovedFilesNew() {
		if (msMovedFilesNew != null)
			return Arrays.asList(msMovedFilesNew);
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		reset();
		return super.build(kind, args, monitor);
	}
	
	static void reset() {
		msCreatedFiles = null;
		msDeletedFiles = null;
		msChangedFiles = null;
		msMovedFilesOld = null;
		msMovedFilesNew = null;
	}
	
	static String stateToString() {
		StringBuilder b = new StringBuilder();
		b.append("Created: ").append(getCreatedFiles()).append("\n");
		b.append("Deleted: ").append(getDeletedFiles()).append("\n");
		b.append("MovedFrom: ").append(getMovedFilesOld()).append("\n");
		b.append("MovedTo: ").append(getMovedFilesNew()).append("\n");
		return b.toString();
	}
	
}