package com.sap.tc.moin.repository.core.mofrom.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;

import com.sap.tc.moin.repository.core.jmi.extension.AssociationEndExtension;

/**
 * This class provides information about an {@link AssociationEnd}, their
 * storage and their compositeness. This information is needed for
 * AssociationEnds instantiated by the MOF ROM, because this info cannot be
 * calculated on the fly.
 * <p>
 * This is what the MOF ROM provides:
 * 
 * @author d024227
 */
public final class MofRomAssociationEndImpl extends AssociationEndImpl implements AssociationEndExtension {

    protected Association ___association;

    protected byte ___endNumber;

    protected boolean ___composite;

    protected boolean ___ordered;

    protected boolean ___stored;

    public Association get___Association( ) {

        return this.___association;
    }

    public byte get___EndNumber( ) {

        return this.___endNumber;
    }

    public boolean is___EndComposite( ) {

        return this.___composite;
    }

    public boolean is___EndOrdered( ) {

        return this.___ordered;
    }

    public boolean is___EndStored( ) {

        return this.___stored;
    }

    public void set___ExtensionInfo( Association association, byte endNumber, boolean composite, boolean ordered, boolean stored ) {

        this.___association = association;
        this.___endNumber = endNumber;
        this.___composite = composite;
        this.___ordered = ordered;
        this.___stored = stored;
    }

    @Override
    public Namespace getContainer( ) {

        return get___Association( );
    }

    private List ___constraints = null;

    @Override
    public Collection getConstraints( ) {

        if ( this.___constraints == null ) {
            this.___constraints = Collections.unmodifiableList( new ArrayList( super.getConstraints( ) ) );
        }
        return this.___constraints;
    }

    private List ___requiredElements = null;

    @Override
    public Collection getRequiredElements( ) {

        if ( this.___requiredElements == null ) {
            this.___requiredElements = Collections.unmodifiableList( new ArrayList( super.getRequiredElements( ) ) );
        }
        return this.___requiredElements;
    }

    private Classifier ___type = null;

    private boolean ___type_Initialized = false;

    @Override
    public Classifier getType( ) {

        if ( !this.___type_Initialized ) {
            this.___type = super.getType( );
            this.___type_Initialized = true;
        }
        return this.___type;
    }

}