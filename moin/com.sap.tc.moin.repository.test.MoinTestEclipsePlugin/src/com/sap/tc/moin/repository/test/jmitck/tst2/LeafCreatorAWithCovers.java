package com.sap.tc.moin.repository.test.jmitck.tst2;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.test.jmitck.tst2.links.Leaf;
import com.sap.tc.moin.repository.test.jmitck.tst2.links.LinksPackage;

/**
 * ObjectCreator for creating instances of Leaf. The returned Leaf instance is
 * given a number of <code>covers</code> reference elements.
 */
@SuppressWarnings( "nls" )
public class LeafCreatorAWithCovers implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    static int id;

    /**
     * Returns a new Leaf instance. A number of additional Leaf instances are
     * created, and added to the <code>covers</code> reference of the returned
     * Leaf instance.
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
        Leaf leaf1 = (Leaf) lp.getLeaf( ).refCreateInstance( );
        leaf1.setRootAttr( "Base ID " + id++ );
        leaf1.setLeafAttr( "covered1" );
        Leaf leaf2 = (Leaf) lp.getLeaf( ).refCreateInstance( );
        leaf2.setRootAttr( "Base ID " + id++ );
        leaf2.setLeafAttr( "covered2" );
        Leaf leaf3 = (Leaf) lp.getLeaf( ).refCreateInstance( );
        leaf3.setRootAttr( "Base ID " + id++ );
        leaf3.setLeafAttr( "covered3" );
        leaf.getCovers( ).add( leaf1 );
        leaf.getCovers( ).add( leaf2 );
        leaf.getCovers( ).add( leaf3 );
        return leaf;
    }
}
