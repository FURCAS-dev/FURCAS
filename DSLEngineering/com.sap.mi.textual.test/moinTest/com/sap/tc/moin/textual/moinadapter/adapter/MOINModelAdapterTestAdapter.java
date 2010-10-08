/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;

/**
 * helper class to help with changing method signatures
 */
public class MOINModelAdapterTestAdapter extends MOINModelAdapter{

    /**
     * @param root
     * @param connection
     * @param referenceScope
     */
    public MOINModelAdapterTestAdapter(RefPackage root, Connection connection,
            Collection<PRI> referenceScope, Collection<CRI> criScope) {
        super(root, connection, referenceScope, criScope);

    }

    /**
     * @param string
     * @return
     */
    public Object createElement(String string) throws ModelAdapterException {
        
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.createElement(typeName);
    }

    /**
     * @param string
     * @param string2
     * @return 
     * @throws ModelAdapterException 
     */
    public Object createEnumLiteral(String string, String string2) throws ModelAdapterException {
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.createEnumLiteral(typeName, string2);
        
    }

}
