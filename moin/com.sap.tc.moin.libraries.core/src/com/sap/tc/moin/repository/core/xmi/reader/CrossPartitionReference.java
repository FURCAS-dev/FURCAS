package com.sap.tc.moin.repository.core.xmi.reader;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.core.xmi.util.XmiHrefUtil;

/**
 * In partition mode, references to model elements hosted by a different
 * partition than the partition that is being read are represented by instances
 * of this class.
 */
public class CrossPartitionReference implements LinkEnd {

    /**
     * The value of the <code>href</code> attribute as it was found in the XMI
     * document.
     */
    private String href;

    /**
     * The MOF-ID encoded in the <code>href</code> attribute.
     */
    private String mofId;

    /**
     * Constructs a CrossPartitionReference with the given <code>href</code> and
     * type.
     */
    public CrossPartitionReference( String hrefFromXmi ) {

        href = hrefFromXmi;
        mofId = XmiHrefUtil.getIdPart( href, true /* partitionMode */);
        assert mofId != null && !mofId.equals( "" ) : "CrossPartitionReference.<init>: mofId = " + mofId; //$NON-NLS-1$ //$NON-NLS-2$
    }

    public String getMofId( ) {

        return mofId;
    }

    /**
     * Returns the <code>href</code> attribute value.
     */
    public String getHref( ) {

        return href;
    }

    public MofClass getType( ) {

        return null;
    }
}