package com.sap.tc.moin.repository.test.jmitck.tst2;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.test.jmitck.tst2.links.Leaf;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.LinksPackage;

/**
 * ObjectCreator for creating instances of Leaf. The returned Leaf instance is
 * given a <code>coveredBy</code> reference value.
 */
@SuppressWarnings( "nls" )
public class LeafCreatorAWithLinks implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    static int id;

    /**
     * Returns a new Leaf instance. A second Leaf instance is created, and used
     * to set the <code>coveredBy</code> reference of the returned Leaf
     * instance.
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
        Leaf leaf2 = (Leaf) lp.getLeaf( ).refCreateInstance( );
        leaf2.setRootAttr( "Base ID " + id++ );
        leaf2.setLeafAttr( "covering" );
        leaf.setCoveredBy( leaf2 );
        return leaf;
    }
}
