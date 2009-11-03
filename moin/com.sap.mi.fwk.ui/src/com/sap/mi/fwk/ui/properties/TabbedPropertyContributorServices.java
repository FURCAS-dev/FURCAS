package com.sap.mi.fwk.ui.properties;

public final class TabbedPropertyContributorServices {
	
	private static final String DIAGRAM_PROPERTY_CONTRIBUTOR_SUFFIX = ".PropertyContributor"; //$NON-NLS-1$
		
	public static String getContributorId(String propertyContributorToken) {
		return (propertyContributorToken + DIAGRAM_PROPERTY_CONTRIBUTOR_SUFFIX);
	}
	
	private TabbedPropertyContributorServices() {
	}
}
