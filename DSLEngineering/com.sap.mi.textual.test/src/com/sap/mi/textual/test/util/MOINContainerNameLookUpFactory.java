/**
 * 
 */
package com.sap.mi.textual.test.util;

import java.io.IOException;
import java.util.HashSet;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 *
 */
public class MOINContainerNameLookUpFactory {

    
    /**
     * factory method for looking up in the provided container name using a transient connection.
     * @param connection
     * @param containerName
     * @throws IOException 
     * @throws IOException 
     */
    public static MoinMetaLookup getMOINContainerNameLookUpFactory(String containerName) throws IOException {
        HashSet<PRI> newPRIs = null;

        if ("sap.com/tc/moin/mof_1.4".equals(containerName)) {
            Moin moin = MoinFactory.getMoinInstance();
            newPRIs = new HashSet<PRI>();
            PRI pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
            newPRIs.add(pri);
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm");
            newPRIs.add(pri);
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
            newPRIs.add(pri); 
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/CorbaIdlTypes.moinmm");
            newPRIs.add(pri); 
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Reflect.moinmm");
            newPRIs.add(pri); 
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/MOIN.moinmm");
            newPRIs.add(pri); 
            
        } else {
            MmDeploymentInfo mm = MetamodelManager.getInstance().getDeployedMetamodel(containerName);
            if (mm != null) {
                newPRIs = new HashSet<PRI>(mm.getPRIs());
            }
        }
        MoinMetaLookup lookup = new MoinMetaLookup(ConnectionManager.getInstance().createTransientConnection(), newPRIs);
        return lookup;
    }


}
