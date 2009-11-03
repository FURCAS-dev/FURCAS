package com.sap.mi.fwk.dcfwk;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IProject;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.ICustomProperty;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;

/**
 * INTERNAL - not to be used or sub classed by clients
 *
 * @author d024127
 */
public final class DCHelper {

	public static final String DESCRIPTION = "DESCRIPTION"; //$NON-NLS-1$
	public static final String NAME = "NAME"; //$NON-NLS-1$
	public static final String VENDOR = "VENDOR"; //$NON-NLS-1$

	private static final String LOCAL_DEVELOPMENT_ID = "LocalDevelopment"; //$NON-NLS-1$

	private static final DCHelper INSTANCE = new DCHelper();

	private DCHelper() {
	}

	public static final DCHelper getInstance() {
		return INSTANCE;
	}

	/**
	 * Gets the DC info for the given project. The following variables are supported
	 *
	 * <pre>
	 * {@link #DESCRIPTION}
	 * {@link #NAME}
	 * {@link #VENDOR}
	 * </pre>
	 *
	 * Example: <code><pre>
	 * IProject project = ...;
	 * Properties info = DCHelper.getInstance().getDCInfo(project);
	 * if( info == null ) {
	 *   // not a dc
	 * }
	 * String dcName = info.getProperty(DCHelper.NAME, null);
	 * </pre></code>
	 *
	 * @param project
	 *            the project to be tested
	 * @return properties containing the values
	 */
	public Properties getDCInfo(IProject project) {
		IDevelopmentComponent developmentComponent = DiiResourceService.getDevelopmentComponent(project);
		if (developmentComponent == null) {
			return null;
		}
		return getDCInfoInternal(developmentComponent);
	}

	/**
	 * Returns whether a given project is a DC
	 *
	 * @param project
	 *            the project to test
	 * @return True, if project represents a DC
	 */
	public boolean isDC(IProject project) {
		return (getDevConf(project) != null);
	}

	/**
	 * Returns whether a given project is a "Local Development" DC
	 *
	 * @param project
	 *            the project to test
	 * @return True, if project represents a "Local Development" DC
	 */
	public boolean isLocalDevelopmentDC(IProject project) {
		IDevelopmentConfiguration devConf = getDevConf(project);
		if (devConf != null) {
			if (devConf.isLocal() && devConf.getName() != null && devConf.getName().equals(LOCAL_DEVELOPMENT_ID)) {
				return true;
			}
		}
		return false;
	}

	public String getDCProperty(IProject project, String namespace, String name) {
		IDevelopmentComponent developmentComponent = DiiResourceService.getDevelopmentComponent(project);
		if (developmentComponent == null) {
			return null;
		}
		if (developmentComponent != null) {
			List properties = developmentComponent.getLocalState().getCustomProperties();
			for (Iterator it = properties.iterator(); it.hasNext();) {
				Object object = it.next();
				if (object instanceof ICustomProperty) {
					ICustomProperty property = (ICustomProperty)object;
					if (namespace.equals(property.getNamespace()) && "moin".equals(property.getName())) { //$NON-NLS-1$
						List subProperties = property.getChildren();
						for (Iterator subIt = subProperties.iterator(); subIt.hasNext();) {
							Object subObject = subIt.next();
							if (subObject instanceof ICustomProperty) {
								ICustomProperty subProperty = (ICustomProperty)subObject;
								if (namespace.equals(subProperty.getNamespace()) && name.equals(subProperty.getName())) {
									return subProperty.getValue();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	private IDevelopmentConfiguration getDevConf(IProject project) {
		IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
		if (dc != null) {
			ISoftwareComponent sc = dc.getContainingSoftwareComponent();
			if (sc != null) {
				IDevelopmentConfiguration devConf = sc.getContainingDevelopmentConfiguration();
				return devConf;
			}
		}
		return null;
	}

	private Properties getDCInfoInternal(IDevelopmentComponent developmentComponent) {
		final Properties dcInfo = new Properties();
		if (developmentComponent != null) {
			final String name = developmentComponent.getName();
			final String vendor = developmentComponent.getVendor();
			String description = developmentComponent.getLocalState().getDescription();
			if (description == null || description.length() == 0) {
				description = developmentComponent.getDisplayName();
			}

			dcInfo.put(DESCRIPTION, description);
			dcInfo.put(NAME, name);
			dcInfo.put(VENDOR, vendor);
		}
		return dcInfo;
	}
}