package com.sap.tc.moin.repository.core.mofrom.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.jmi.extension.AssociationExtension;

/**
 * This class provides information about the ends of an {@link Association}.
 * This information is needed for Associations instantiated by the MOF ROM,
 * because this info cannot be calculated on the fly.
 * <p>
 * This is what the MOF ROM provides:
 * 
 * <pre>
 *               // AssociationEnd[]
 *  new String[]{&quot;&lt;MOFID0&gt;&quot;, &quot;&lt;MOFID1&gt;&quot;};
 *
 * </pre>
 * 
 * @author d024227
 */
public final class MofRomAssociationImpl extends AssociationImpl implements AssociationExtension {

    protected AssociationEnd[] ___associationEnds;

    public AssociationEnd[] get___AssociationEnds( ) {

        return this.___associationEnds;
    }

    public void set___AssociationEnds( AssociationEnd[] associationEnds ) {

        this.___associationEnds = associationEnds;
    }

    @Override
    public List getContents( ) {

        return Collections.unmodifiableList( Arrays.asList( get___AssociationEnds( ) ) );
    }

    private List ___allSupertypes = null;

    @Override
    public List allSupertypes( ) throws JmiException {

        if ( this.___allSupertypes == null ) {
            this.___allSupertypes = Collections.unmodifiableList( new ArrayList( super.allSupertypes( ) ) );
        }
        return this.___allSupertypes;
    }

    private List ___constraints = null;

    @Override
    public Collection getConstraints( ) {

        if ( this.___constraints == null ) {
            this.___constraints = Collections.unmodifiableList( new ArrayList( super.getConstraints( ) ) );
        }
        return this.___constraints;
    }

    private Namespace ___container = null;

    private boolean ___container_Initialized = false;

    @Override
    public Namespace getContainer( ) {

        if ( !this.___container_Initialized ) {
            this.___container = super.getContainer( );
            this.___container_Initialized = true;
        }
        return this.___container;
    }

    private List ___requiredElements = null;

    @Override
    public Collection getRequiredElements( ) {

        if ( this.___requiredElements == null ) {
            this.___requiredElements = Collections.unmodifiableList( new ArrayList( super.getRequiredElements( ) ) );
        }
        return this.___requiredElements;
    }

    private List ___supertypes = null;

    @Override
    public List getSupertypes( ) {

        if ( this.___supertypes == null ) {
            this.___supertypes = Collections.unmodifiableList( new ArrayList( super.getSupertypes( ) ) );
        }
        return this.___supertypes;
    }

    private Map<String, ModelElement> ___lookupElement = null;

    @Override
    public ModelElement lookupElement( String name ) throws NameNotFoundException, JmiException {

        ModelElement result = null;
        if ( this.___lookupElement == null ) {
            this.___lookupElement = new HashMap<String, ModelElement>( );
        }
        result = this.___lookupElement.get( name );
        if ( result == null ) {
            result = super.lookupElement( name );
            if ( result != null ) {
                this.___lookupElement.put( name, result );
            }
        }
        return result;
    }

    private Map<String, ModelElement> ___lookupElementExtended = null;

    @Override
    public ModelElement lookupElementExtended( String name ) throws NameNotFoundException, JmiException {

        ModelElement result = null;
        if ( this.___lookupElementExtended == null ) {
            this.___lookupElementExtended = new HashMap<String, ModelElement>( );
        }
        result = this.___lookupElementExtended.get( name );
        if ( result == null ) {
            result = super.lookupElementExtended( name );
            if ( result != null ) {
                this.___lookupElementExtended.put( name, result );
            }
        }
        return result;
    }

}