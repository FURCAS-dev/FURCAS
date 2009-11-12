package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;

public class ConnectionDecoratorUtil {

    private static final String MULTIPLICITY_ONE = "1"; //$NON-NLS-1$

    private static final String MULTIPLICITY_ZERO_TO_ONE = "0..1"; //$NON-NLS-1$

    private static final String MULTIPLICITY_ZERO_TO_N = "0..*"; //$NON-NLS-1$

    private static final String MULTIPLICITY_ONE_TO_N = "1..*"; //$NON-NLS-1$

    public static String getMultiplicityAsText(MultiplicityType multiplicity) {
        StringBuffer ret = new StringBuffer();
        int lower = multiplicity.getLower();
        int upper = multiplicity.getUpper();

        String lowerBound = Integer.toString(lower);
        String upperBound = upper == -1 ? "*" : Integer.toString(upper); //$NON-NLS-1$

        ret.append(lowerBound + ".." + upperBound); //$NON-NLS-1$
        return ret.toString();
    }

	/**
	 * Checks if a name decorator for a GFW connection exists
	 * @param connection
	 * The GFW connection to check for
	 * @return
	 * true if the decorator exists, false otherwise
	 */
	public static boolean existNameDecorator(Connection connection) {
		return (getNameDecorator(connection) != null);
	}

	/**
	 * Returns the name decorator for a GFW connection
	 * @param connection
	 * The GFW connection to get the decorator for
	 * @return
	 * The decorator if it exists, null otherwise
	 */
	public static ConnectionDecorator getNameDecorator(Connection connection) {
		Collection<ConnectionDecorator> col = connection.getConnectionDecorators();

		for (Iterator<ConnectionDecorator> iter = col.iterator(); iter.hasNext();) {
			ConnectionDecorator cd = (ConnectionDecorator)iter.next();
			if (LinkUtil.hasLinkProperty(cd, MOFToolConstants.ASSOCIATION_NAME)) {
				return cd;
			}
		}
		return null;
	}

    /**
     * Creates the connection decorator for the GFW connection name. It does not yet create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createConnectionNameDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, true, 0.5, true);
		
		LinkUtil.setLinkProperty(cd, MOFToolConstants.ASSOCIATION_NAME);
		return cd;
	}

	/**
	 * Checks if a name decorator for the given end of a GFW connection exists
	 * @param connection
	 * @param ae
	 * The start AssociationEnd to decorate
	 * The GFW connection to check for
	 * @return
	 * true if the decorator exists, false otherwise
	 */
	public static boolean existEndNameDecorator(Connection connection, AssociationEnd ae,
			IFeatureProvider featureProvider) {
		return (getEndNameDecorator(connection, ae, featureProvider) != null);
	}

	/**
	 * Returns the name decorator for the given end of a GFW connection 
	 * @param connection
	 * @param ae
	 * The start AssociationEnd to decorate
	 * The GFW connection to check for
	 * @return
	 * The connection decorator for the name of the association end if it exists,
	 * null otherwise
	 */
	public static ConnectionDecorator getEndNameDecorator(Connection connection, AssociationEnd ae,
			IFeatureProvider featureProvider) {
		Collection<ConnectionDecorator> col = connection.getConnectionDecorators();

		for (Iterator<ConnectionDecorator> iter = col.iterator(); iter.hasNext();) {
			ConnectionDecorator cd = (ConnectionDecorator)iter.next();
			if (LinkUtil.hasLinkProperty(cd, MOFToolConstants.ASSOCIATION_END_NAME)) {
				Object bo = featureProvider.getBusinessObjectForPictogramElement(cd);
				if (ae != null && ae.equals(bo)) {
					return cd;
				}
			}
		}
		return null;
	}

    /**
     * Creates the start end connection decorator for the GFW connection name. It does not yet 
     * create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createStartEndNameDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, true, 0.0, true);
		LinkUtil.setLinkProperty(cd, MOFToolConstants.ASSOCIATION_END_NAME);
		return cd;
	}

    /**
     * Creates the target end connection decorator for the GFW connection name. It does not yet 
     * create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createTargetEndNameDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, true, 1.0, true);
		LinkUtil.setLinkProperty(cd, MOFToolConstants.ASSOCIATION_END_NAME);
		return cd;
	}

	/**
	 * Checks if a multiplicity decorator for the given end of a GFW connection exists
	 * @param connection
	 * @param ae
	 * The start AssociationEnd to decorate
	 * The GFW connection to check for
	 * @return
	 * true if the decorator exists, false otherwise
	 */
	public static boolean existEndMultiplicityDecorator(Connection connection, AssociationEnd ae,
			IFeatureProvider featureProvider) {
		return (getEndMultiplicityDecorator(connection, ae, featureProvider) != null);
	}

	/**
	 * Returns the multiplicity decorator for the given end of a GFW connection
	 * @param connection
	 * @param ae
	 * The start AssociationEnd to decorate
	 * The GFW connection to check for
	 * @return
	 * The multiplicity decorator for the given association end if it exists,
	 * null otherwise
	 */
	public static ConnectionDecorator getEndMultiplicityDecorator(Connection connection, AssociationEnd ae,
			IFeatureProvider featureProvider) {
		Collection<ConnectionDecorator> col = connection.getConnectionDecorators();

		for (Iterator<ConnectionDecorator> iter = col.iterator(); iter.hasNext();) {
			ConnectionDecorator cd = (ConnectionDecorator)iter.next();
			if (LinkUtil.hasLinkProperty(cd, MOFToolConstants.MULTIPLICITY)) {
				Object bo = featureProvider.getBusinessObjectForPictogramElement(cd);
				if (ae != null && ae.equals(bo)) {
					return cd;
				}
			}
		}
		return null;
	}

    /**
     * Creates the start end connection decorator for the GFW connection multiplicity. It does not yet 
     * create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createStartEndMultiplicityDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, true, 0.0, true);
		LinkUtil.setLinkProperty(cd, MOFToolConstants.MULTIPLICITY);
		return cd;
	}

    /**
     * Creates the target end connection decorator for the GFW connection multiplicity. It does not yet 
     * create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createTargetEndMultiplicityDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, true, 1.0, true);
		LinkUtil.setLinkProperty(cd, MOFToolConstants.MULTIPLICITY);
		return cd;
	}

	/**
	 * Checks if a navigability decorator for the given end of a GFW connection exists
	 * @param connection
	 * @param ae
	 * The start AssociationEnd to decorate
	 * The GFW connection to check for
	 * @return
	 * true if the decorator exists, false otherwise
	 */
	public static boolean existEndNavigabilityDecorator(Connection connection, AssociationEnd ae,
			IFeatureProvider featureProvider) {
		Collection<ConnectionDecorator> col = connection.getConnectionDecorators();

		for (Iterator<ConnectionDecorator> iter = col.iterator(); iter.hasNext();) {
			ConnectionDecorator cd = (ConnectionDecorator)iter.next();
			if (LinkUtil.hasLinkProperty(cd, MOFToolConstants.NAVIGABLE)) {
				Object bo = featureProvider.getBusinessObjectForPictogramElement(cd);
				if (ae != null && ae.equals(bo)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
     * Creates the start end connection decorator for the GFW connection navigability. It does not yet 
     * create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createStartEndNavigationDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, false, 0.0, true);
		LinkUtil.setLinkProperty(cd, MOFToolConstants.NAVIGABLE);
		return cd;
	}

    /**
     * Creates the target end connection decorator for the GFW connection navigability. It does not yet 
     * create the pictogram element 
     * @param connection
     * The GFW connection to decorate
     * @return
     * The new connection decorator
     */
	public static ConnectionDecorator createTargetEndNavigationDecorator(Connection connection) {
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, false, 1.0, true);
		LinkUtil.setLinkProperty(cd, MOFToolConstants.NAVIGABLE);
		return cd;
	}

    public static String[] getPossibleMultiplicityValues() {
        return new String[] { MULTIPLICITY_ONE, MULTIPLICITY_ZERO_TO_ONE, MULTIPLICITY_ZERO_TO_N, MULTIPLICITY_ONE_TO_N };
    }

    public static int[] calculateMultiplicityFromString(String text) {

        int lower = 1;
        int upper = 1;

        if (text != null) {
            int firstDotIndex = text.indexOf('.');
            int secondDotIndex = text.lastIndexOf('.');
            String lowerBound = text.substring(0, firstDotIndex);
            String upperBound = text.substring(secondDotIndex + 1);
            lower = Integer.valueOf(lowerBound);
            if (upperBound.trim().equals("*") || upperBound.trim().equals("n")) //$NON-NLS-1$ //$NON-NLS-2$
                upper = -1;
            else
                upper = Integer.valueOf(upperBound);

        }

        return new int[] { lower, upper };
    }
}
