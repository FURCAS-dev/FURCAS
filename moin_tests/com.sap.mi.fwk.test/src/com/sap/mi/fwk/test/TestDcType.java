package com.sap.mi.fwk.test;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

import com.sap.ide.dii05.lib.api.modeledit.IMeCustomProperty;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditFactory;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditPackage;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.dcfwk.BasicMoinDcType;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinFolderInfo;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

/**
 * DC type for testing purposes
 * 
 * @author d031150
 */
public class TestDcType extends BasicMoinDcType {

	public static final String DC_TYPE_ID = "com.sap.mi.fwk.test.TestDcType";
	public static final MoinFolderInfo SOURCE_FOLDER = new MoinFolderInfo(new Path("src"), true);
	public static final MoinFolderInfo[] RESOURCE_FOLDERS = new MoinFolderInfo[] {
			new MoinFolderInfo(new Path("myFolder"), true), SOURCE_FOLDER };
	public static final MoinFolderInfo[] FOLDERS = new MoinFolderInfo[] {
			new MoinFolderInfo(new Path("myFolder/sub"), false),
			new MoinFolderInfo(new Path("folder2"), false, false, true), RESOURCE_FOLDERS[0], RESOURCE_FOLDERS[1],
			new MoinFolderInfo(new Path("myFolder/sub/sub"), true) };
	static final String PROP_NAME = "testProperty";
	static final String PP_NAME = "def_cmp";

	@Override
	protected MoinDcOptions newOptions() {
		return new TestDcOptions();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void configure(IDevelopmentComponent dc, IMeDcMetadataState editableState) throws CoreException {
		super.configure(dc, editableState);

		ModelEditFactory factory = ModelEditPackage.eINSTANCE.getModelEditFactory();

		IMeCustomProperty prop = factory.createIMeCustomProperty();
		prop.setName(PROP_NAME);
		prop.setValue("someValue");
		editableState.getCustomProperties().add(prop);
	}

	/**
	 * Test whether Moin can be accessed (connection and partition creation)
	 */
	@Override
	public void init(IDevelopmentComponent dc, IProject project, IProgressMonitor monitor) throws CoreException {
		super.init(dc, project, monitor);

		// will fail return a connection
		Connection connection = ConnectionManager.getInstance().createConnection(project);

		IPath path = SOURCE_FOLDER.getPath().append("com/sap/test/someEarlyPartition.xmi");
		try {
			PRI pri = ModelManager.getPartitionService().getPRI(project, path);
			ModelPartition partition = connection.getPartition(pri);
			if (partition != null)
				partition.delete();
			partition = connection.createPartition(pri);
			ConnectionManager.getInstance().save(connection);
		} catch (Exception e) {
			ExtendedTestCase.fail(e);
		} finally {
			connection.close();
		}
	}

	@Override
	public boolean supportsPublicPartPurpose(Purpose purpose) {
		return super.supportsPublicPartPurpose(purpose);
	}

	private static final class TestDcOptions extends MoinDcOptions {
		@Override
		public String[] getNatures() {
			return new String[] { TestNature.NATURE_ID };
		}

		@Override
		public String[] getBuilders() {
			return new String[] { TestNature.BUILDER_ID };
		}

		@Override
		public boolean isPublicPartCreationChangeable(Purpose publicPartPurpose) {
			if (Purpose.COMPILATION_LITERAL == publicPartPurpose)
				return true;
			return false;
		}

		@Override
		public boolean getPublicPartCreationDefault(Purpose publicPartPurpose) {
			if (Purpose.COMPILATION_LITERAL == publicPartPurpose)
				return true;
			return false;
		}

		@Override
		public MoinFolderInfo[] getFolders() throws CoreException {
			return FOLDERS;
		}

		@Override
		public IMePublicPart[] getPublicParts(IDevelopmentComponent dc, IChangelistProvider changelistProvider)
				throws CoreException {
			IMePublicPart[] pps = MoinProject.getPublicPartsForModelFolderTree(this, dc, null, changelistProvider);
			return pps;
		}
	}

}
