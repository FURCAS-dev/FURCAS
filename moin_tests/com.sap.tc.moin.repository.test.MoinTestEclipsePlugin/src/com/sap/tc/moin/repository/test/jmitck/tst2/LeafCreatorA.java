/*
 * $File:
 * //moin/moin.test/dev/src/_tc~moin~test~jmitck/java/com/sap/tc/moin/repository
 * /test/jmitck/tst2/LeafCreatorA.java $ $Revision: #2 $ $Date: 2009/04/15 $
 * $Author: sapm_makeadm $ Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.sap.tc.moin.repository.test.jmitck.tst2;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.test.jmitck.tst2.links.Leaf;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.LinksPackage;

/**
 * ObjectCreator for creating instances of Leaf.
 */
@SuppressWarnings( "nls" )
public class LeafCreatorA implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    static int id;

    /**
     * Returns a new Leaf instance.
     * 
     * @param initValues ignored in this implementation
     * @param root a LinksPackage instance, the extent for the returned Leaf
     * instance
     * @return a new Leaf instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        LinksPackage lp = (LinksPackage) root;
        Leaf leaf = (Leaf) lp.getLeaf( ).refCreateInstance( );
        leaf.setRootAttr( "Base ID " + id++ );
        leaf.setLeafAttr( "leafy" );
        return leaf;
    }
}
