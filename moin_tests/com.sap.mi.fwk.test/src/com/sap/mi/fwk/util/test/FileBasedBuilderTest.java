package com.sap.mi.fwk.util.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.test.TestDcType;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.util.FileBasedBuilder;

/**
 * Tests {@link FileBasedBuilder}
 * 
 * @author d031150
 */
public class FileBasedBuilderTest extends ProjectBasedTest {

	private static final int NUM_FILES = 5;
	private static final String DC_NAME = "test/filebasedimporter";

	public FileBasedBuilderTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected IComponentType getDcType() {
		return MoinProject.getDcType(TestDcType.DC_TYPE_ID, null, null);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.setAutoBuilding(true);
	}

	@Override
	protected void tearDown() throws Exception {
		TestFileBuilder.reset();

		super.tearDown();
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	public void testAddFiles() throws Exception {
		IFolder srcFolder = getProject().getFolder(TestDcType.SOURCE_FOLDER.getPath());
		// Create one file first since the first build in a new project is a
		// full build, which we want to ignore for now.
		createFiles(srcFolder, TestFileBuilder.EXTENSION, 1);

		Set<IFile> files = createFiles(srcFolder, TestFileBuilder.EXTENSION, NUM_FILES);
		Set<IFile> builderFiles = TestFileBuilder.getCreatedFiles();
		assertEquals("File sets must be equal. Builder: " + TestFileBuilder.stateToString(), files, builderFiles);
	}

	public void testDeleteFiles() throws Exception {
		IFolder srcFolder = getProject().getFolder(TestDcType.SOURCE_FOLDER.getPath());
		Set<IFile> files = createFiles(srcFolder, TestFileBuilder.EXTENSION, NUM_FILES);

		deleteFiles(files);
		Set<IFile> builderFiles = TestFileBuilder.getDeletedFiles();
		assertEquals("File sets must be equal. Builder: " + TestFileBuilder.stateToString(), files, builderFiles);
	}

	public void testChangeFiles() throws Exception {
		IFolder srcFolder = getProject().getFolder(TestDcType.SOURCE_FOLDER.getPath());
		Set<IFile> files = createFiles(srcFolder, TestFileBuilder.EXTENSION, NUM_FILES);

		changeFiles(files);
		Set<IFile> builderFiles = TestFileBuilder.getChangedFiles();
		assertEquals("File sets must be equal. Builder: " + TestFileBuilder.stateToString(), files, builderFiles);
	}

	public void testMoveFilesTargetValid() throws Exception {
		IFolder srcFolder = getProject().getFolder(TestDcType.SOURCE_FOLDER.getPath());
		Set<IFile> files = createFiles(srcFolder, TestFileBuilder.EXTENSION, NUM_FILES);

		Map<IFile, IFile> newFiles = moveFiles(files, srcFolder.getFolder("target"));
		List<IFile> oldFilesBuilder = TestFileBuilder.getMovedFilesOld();
		List<IFile> newFilesBuilder = TestFileBuilder.getMovedFilesNew();
		assertEquals("File set must have same size for old and new files. Builder: " + TestFileBuilder.stateToString(),
				oldFilesBuilder.size(), newFilesBuilder.size());
		for (int i = 0; i < oldFilesBuilder.size(); i++) {
			IFile newFile = newFiles.get(oldFilesBuilder.get(i));
			IFile newFileBuilder = newFilesBuilder.get(i);
			assertEquals("New files must be the same", newFile, newFileBuilder);
		}

		Set<IFile> addedBuilderFiles = TestFileBuilder.getCreatedFiles();
		assertTrue("No file adds must be issued in case of move: " + addedBuilderFiles, addedBuilderFiles.isEmpty());
	}

	public void testMoveFilesTargetInvalid() throws Exception {
		IFolder srcFolder = getProject().getFolder(TestDcType.SOURCE_FOLDER.getPath());
		Set<IFile> files = createFiles(srcFolder, TestFileBuilder.EXTENSION, NUM_FILES);
		IFolder invalidFolder = getProject().getFolder("target");

		Set<IFile> deletedFiles = moveFiles(files, invalidFolder).keySet();
		List<IFile> oldFilesBuilder = TestFileBuilder.getMovedFilesOld();
		List<IFile> newFilesBuilder = TestFileBuilder.getMovedFilesNew();
		assertTrue("Old file set must be empty for move to invalid target", oldFilesBuilder.isEmpty());
		assertTrue("New file set must be empty for move to invalid target", newFilesBuilder.isEmpty());

		Set<IFile> deletedFilesBuilder = TestFileBuilder.getDeletedFiles();
		assertEquals("File sets must be equal. Builder: " + TestFileBuilder.stateToString(), deletedFiles,
				deletedFilesBuilder);
	}

	public void testFullBuild() throws Exception {
		IFolder srcFolder = getProject().getFolder(TestDcType.SOURCE_FOLDER.getPath());
		// first resource change in a project triggers a full build
		Set<IFile> expectedFiles = createFiles(srcFolder, TestFileBuilder.EXTENSION, NUM_FILES);

		// test the default implementation, which marks all files as changed
		Set<IFile> allFiles = TestFileBuilder.getChangedFiles();
		Set<IFile> createdFiles = TestFileBuilder.getCreatedFiles();
		if (allFiles.isEmpty() && !createdFiles.isEmpty()) {
			allFiles = createdFiles;
			String msg = "Warning: Builder received ADD Event from Eclipse instead of FULL event. "
					+ "Unclear under which conditions this happens (timing, random...).";
			new Exception(msg).printStackTrace();
		}
		assertEquals("File sets must be equal. Builder: " + TestFileBuilder.stateToString(), expectedFiles, allFiles);
	}

	private Set<IFile> createFiles(final IFolder parent, final String extension, final int num) throws Exception {
		final Set<IFile> files = new LinkedHashSet<IFile>(num);
		final InputStream stream = new ByteArrayInputStream("".getBytes());
		stream.close();

		parent.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (!parent.exists())
					parent.create(true, true, monitor);

				for (int i = 0; i < num; i++) {
					IFile file = null;
					int count = i + 1;
					do {
						IPath path = new Path("file_" + count++).addFileExtension(extension);
						file = parent.getFile(path);
					} while (file.exists());

					file.create(stream, true, monitor);
					files.add(file);
				}
			}

		}, null);

		PDEUtil.safeJoinAutoBuild(20000);

		return files;
	}

	private void deleteFiles(final Set<IFile> files) throws Exception {
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				for (IFile file : files) {
					file.delete(true, monitor);
				}
			}
		}, null);

		PDEUtil.safeJoinAutoBuild(3000);
	}

	private void changeFiles(final Set<IFile> files) throws Exception {
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				for (IFile file : files) {
					file.touch(monitor);
				}
			}
		}, null);

		PDEUtil.safeJoinAutoBuild(3000);
	}

	private Map<IFile, IFile> moveFiles(final Set<IFile> files, final IFolder destination) throws Exception {
		final Map<IFile, IFile> newFiles = new HashMap<IFile, IFile>(files.size());
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (!destination.exists())
					destination.create(true, true, monitor);

				for (IFile file : files) {
					IFile newFile = destination.getFile(file.getName());
					file.move(newFile.getFullPath(), true, monitor);
					assertTrue("File must exist after move: " + newFile, newFile.exists());
					newFiles.put(file, newFile);
				}
			}
		}, null);

		PDEUtil.safeJoinAutoBuild(3000);
		return newFiles;
	}

}