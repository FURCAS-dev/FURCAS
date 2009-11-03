package com.sap.tc.moin.nwdi.dctype.mm;

import com.sap.mi.fwk.dcfwk.ModelFolderTreeEntityService;

public final class MetaModelFolderTreeEntityService extends ModelFolderTreeEntityService {

	public static final String ID_SERVICE_META_MODEL_FOLDER_TREE = "com.sap.tc.moin.nwdi.dctype.mm.metaModelFolderTreeEntityService"; //$NON-NLS-1$
	public static final String TYPE_META_MODEL_FOLDER_TREE = "Metamodel Folder Tree"; //$NON-NLS-1$

	public MetaModelFolderTreeEntityService() {
		super();
	}

	@Override
	protected String getId() {
		return ID_SERVICE_META_MODEL_FOLDER_TREE;
	}

	@Override
	protected String getEntityType() {
		return TYPE_META_MODEL_FOLDER_TREE;
	}
}
