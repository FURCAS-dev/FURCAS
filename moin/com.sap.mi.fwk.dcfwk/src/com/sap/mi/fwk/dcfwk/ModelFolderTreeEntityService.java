package com.sap.mi.fwk.dcfwk;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import com.sap.ide.dii05.lib.api.modeledit.IMeCommonEntity;
import com.sap.ide.dii05.lib.api.modeledit.IMeEntity;
import com.sap.ide.dii05.lib.api.typefw.IPublicPartEntityService2;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.internal.util.EqualityUtil;
import com.sap.ide.dii05.ui.api.typefw.IDevelopmentComponentTypeDelegate;

/**
 * Basic implementation of an entity servive for entities of type
 * {@link #TYPE_MODEL_FOLDER_TREE Model Folder Tree}. Returns all Moin resource
 * folders as entites. For now no <code>RefBaseObject</code>-based mapping to
 * entities is available. <p/> Clients may extend to provide a more specific
 * entity managment.
 *
 * @author d031150
 */
public class ModelFolderTreeEntityService implements IPublicPartEntityService2 {

	/**
	 * The id this service class is registered with. Value is
	 * <code>com.sap.mi.fwk.dcfwk.modelFolderTreeEntityService</code>. Must
	 * match to the id in an extension of extension point
	 * <code>com.sap.ide.dii05.lib.ppentityservices</code>, and the value
	 * returned in implementations of
	 * {@link IDevelopmentComponentTypeDelegate#getSupportedPublicPartEntityServiceIds(IDevelopmentComponent)}.
	 * Subclasses may register a different id.
	 *
	 * @see #getId()
	 */
	public static final String ID_SERVICE_MODEL_FOLDER_TREE = "com.sap.mi.fwk.dcfwk.modelFolderTreeEntityService"; //$NON-NLS-1$

	/**
	 * The type of entities this service class is able to handle. Value is
	 * <code>Model Folder Tree</code>. Note that subclasses may expect a
	 * different type.
	 *
	 * value: <code>Model Folder Tree</code>
	 * @see #getEntityType()
	 */
	public static final String TYPE_MODEL_FOLDER_TREE = "Model Folder Tree"; //$NON-NLS-1$

	private static final IMeEntity[] NO_ENTITIES = new IMeEntity[0];

	private IDevelopmentComponent mDc;

	/**
	 * Creates a service. Used by Eclipse extension instantiation.
	 */
	public ModelFolderTreeEntityService() {
	}

	public void initDevelopmentComponent(IDevelopmentComponent dc) {
		mDc = dc;
	}

	public IDevelopmentComponent getDevelopmentComponent() {
		return mDc;
	}

	/**
	 * @return the id of this service. Subclasses must override if they register
	 *         with a different id. Defaults to
	 *         {@value #ID_SERVICE_MODEL_FOLDER_TREE}.
	 */
	protected String getId() {
		return ID_SERVICE_MODEL_FOLDER_TREE;
	}

	/**
	 * @return the type of entites to handle. Defaults to
	 *         {@value #TYPE_MODEL_FOLDER_TREE}.
	 */
	protected String getEntityType() {
		return TYPE_MODEL_FOLDER_TREE;
	}

	public boolean contains(IMeEntity potentialAncestor, IMeEntity potentialDescendant) {
		return EqualityUtil.isEqual(potentialAncestor, potentialDescendant);
	}

	public String getDisplayName(IMeEntity entity) {
		if (entity != null) {
			String name = entity.getName();
			if (name != null) {
				int lastIndex = name.lastIndexOf("/"); //$NON-NLS-1$
				if (lastIndex != -1) {
					return name.substring(lastIndex + 1, name.length());
				}
			}
			return name;
		}
		return ""; //$NON-NLS-1$

	}

	public String getDisplayPath(IMeEntity entity) {
		if (entity != null) {
			String name = entity.getName();
			if (name != null) {
				return name;
			}
		}
		return null;
	}

	public IMeEntity[] getEntities(String entityType) {
		if (!entityType.equals(getEntityType())) {
			return NO_ENTITIES;
		}
		IProject project = DiiResourceService.getProject(getDevelopmentComponent());
		if (project == null || !project.isAccessible()) {
			return NO_ENTITIES;
		}
		IPath[] folders = MoinProject.getMoinResourceFolders(project);
		IMeEntity[] result = new IMeEntity[folders.length];
		for (int i = 0; i < folders.length; i++) {
			result[i] = MoinProject.createEntityForPath(folders[i], entityType);
		}
		return result;
	}

	public IMeEntity[] getEntititesForObject(Object obj) {
		// not called - IPublicPartEntityService2#getEntitiesForObjects()
		// is used instead
		return NO_ENTITIES;
	}

	public Map<Object, IMeCommonEntity[]> getEntitiesForObjects(Object[] objects) {
		// TODO [Projects] How to provide RefObject-based entity handling
		// without access to Moin?
		// Move whole project behind Moin facade? Move entity service to mi.fwk?
		return Collections.emptyMap();
	}

	public boolean isContainerNode(IMeEntity entity) {
		return true;
	}

	public boolean isProjectRequired() {
		return true;
	}

	public boolean supportsExcludeAndIncludeRules(IMeEntity entity) {
		return false;
	}

}
