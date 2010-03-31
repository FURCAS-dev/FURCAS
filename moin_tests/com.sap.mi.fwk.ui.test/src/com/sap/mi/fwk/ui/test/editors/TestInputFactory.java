package com.sap.mi.fwk.ui.test.editors;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

import abbot.swt.Robot;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.editor.ModelObjectElementFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;

public class TestInputFactory extends ModelObjectElementFactory {

	public ModelEditorInput createEditorInput(RefBaseObject obj) {
		return new TestEditorInput(obj);
	}

	public ModelEditorInput createEditorInput(String mriString, String projectName) {
		return new TestEditorInput(mriString);
	}

	@Override
	public ModelEditorInput createEditorInput(IEditorInput otherInput) {
		if (otherInput instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) otherInput;
			IFile file = fileInput.getFile();
			IProject project = file.getProject();
			if (!ModelManager.getInstance().isMoinProject(project)) {
				return null;
			}
			CreateTestEditorInputRunnable runnable = new CreateTestEditorInputRunnable(file);
			ConnectionManagerUI.getInstance().createConnectionAsync(project, runnable);

			int i = 0;
			while (runnable.getInput() == null && i < 10) {
				Robot.delay(300);
				i++;
			}

			return runnable.getInput();
		}

		return super.createEditorInput(otherInput);
	}

	private class CreateTestEditorInputRunnable implements IRunnableWithConnection {
		private IFile mFile = null;
		private TestEditorInput mTestEditorInput = null;

		public CreateTestEditorInputRunnable(IFile file) {
			super();
			mFile = file;
		}

		public void run(Connection connection, IProgressMonitor monitor) {
			try {
				PRI pri = ModelAdapter.getInstance().getPri(mFile, connection);
				if (pri != null) {
					ModelPartition partition = connection.getPartition(pri);
					Collection<Partitionable> elements = partition.getElements();
					for (Partitionable element : elements) {
						if (element instanceof View) {
							mTestEditorInput = new TestEditorInput((View) element);
						}
					}
				}

			} finally {
				if (connection != null)
					connection.close();
			}
		}

		public TestEditorInput getInput() {
			return mTestEditorInput;
		}
	}
}
