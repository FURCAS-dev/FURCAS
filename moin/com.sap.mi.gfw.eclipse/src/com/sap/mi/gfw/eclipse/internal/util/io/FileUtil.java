package com.sap.mi.gfw.eclipse.internal.util.io;

import java.io.FileOutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.util.T;

/**
 * A collection of static helper methods regarding files and folders.
 */
public class FileUtil {

	/**
	 * Returns a WorkspeceModifyOperation, which saves the given contents to a File with the given filename.
	 * 
	 * @param filename
	 *            The name of the file, where to save the contents.
	 * @param contents
	 *            The contents to save into the file.
	 * @throws Exception
	 *             On any errors that occur.
	 */
	public static WorkspaceModifyOperation saveContentsToFile(final String filename, final byte contents[]) throws Exception {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException {
				FileOutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(filename);
					outputStream.write(contents);
				} catch (Exception e) {
					// convert exceptions to CoreExceptions
					Status status = new Status(IStatus.ERROR, GraphicsPlugin.getID(), IStatus.ERROR, "Can not save image as file: " //$NON-NLS-1$
							+ e.getMessage(), e);
					throw new CoreException(status);
				} finally {
					try {
						outputStream.close();
					} catch (Exception x) {
						T.racer().error("close output stream failed", x); //$NON-NLS-1$
					}
				}
			}
		};

		return operation;
	}
}
