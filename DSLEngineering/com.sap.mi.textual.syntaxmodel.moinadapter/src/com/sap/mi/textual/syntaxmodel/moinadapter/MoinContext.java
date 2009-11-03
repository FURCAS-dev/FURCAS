/**
 * 
 */
package com.sap.mi.textual.syntaxmodel.moinadapter;

import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.ide.MoinFactory;

/**
 * Provides access to a moin instances, which is either the eclipse one or one set previously.
 */
public class MoinContext {

    private static Moin moin = null;
    
    public static Moin getMoin() {
        if (moin == null) {
            moin = MoinFactory.getMoinInstance();
        }
        return moin;
    }
    
    public static void setMoin(Moin newMoin) {
        if (moin == null) {
            moin = newMoin;
        } else {
            if (newMoin != moin) {
                throw new RuntimeException("Moin was already set");
            }
        }
        
    }
    
}
