/**
 * 
 */
package com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl;

import org.eclipse.core.resources.IResource;

public interface IExcludeFromSourceControlHandler {

    void excludeFromSourceControl( IResource resource );
}