package com.sap.tc.moin.nwdi.dctype;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.mi.fwk.dcfwk.BasicMoinDcType;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinFolderInfo;
import com.sap.mi.fwk.dcfwk.MoinProject;

/**
 * DC type for testing purposes
 * 
 * @author d031150
 */
public class MoinTestDcType extends BasicMoinDcType {

	public static final String DC_TYPE_ID = "com.sap.tc.moin.nwdi.dctype.Moin";//$NON-NLS-1$
	public static final String DC_TYPE_VENDOR = MoinProject.VENDOR_SAP;

	public static final String ID_NATURE = "com.sap.tc.moin.nwdi.dctype.MoinNature"; //$NON-NLS-1$

	/**
	 * The source folder of the Moin test DC type (value is <code>src</code>).
	 * Since other DC types may define other paths, <b>do not use this in
	 * productive code</b>.
	 */
	public static final IPath SOURCE_FOLDER = new Path("src"); //$NON-NLS-1$
	
	/**
	 * The name of the public part of type compilation, which is be default created. Value is
	 * <code>def_cmp</code>.
	 * 
	 * @value def_cmp
	 */
	public static final String PP_NAME_COMPILATION = "def_cmp"; //$NON-NLS-1$
	
	private static final MoinFolderInfo[] FOLDERS = new MoinFolderInfo[] { new MoinFolderInfo(SOURCE_FOLDER, true) };

	public static IComponentType getDcType() {
		IComponentType dcType = MoinProject.getDcType(DC_TYPE_ID, DC_TYPE_VENDOR, null);
		return dcType;
	}

	@Override
	protected MoinDcOptions newOptions() {
		return new MoinTestDcOptions();
	}

	private static final class MoinTestDcOptions extends MoinDcOptions {

		@Override
		public String[] getNatures() {
			return new String[] { ID_NATURE };
		}

		@Override
		public MoinFolderInfo[] getFolders() {
			return FOLDERS;
		}

		@Override
		public IMePublicPart[] getPublicParts(IDevelopmentComponent dc, IChangelistProvider changelistProvider) throws CoreException {
			IMePublicPart[] pps = MoinProject.getPublicPartsForModelFolderTree(this, dc, null, changelistProvider);
			return pps;
		}
	}

}
