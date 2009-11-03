package com.sap.tc.moin.repository.core.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

public final class AmbiguousLriMap<V> {

    private LRI lri;

    private PRI standardPri;

    private V standardValue;

    private Map<PRI, V> priToValue;

    private AmbiguousLriMap( MRI mri ) {

        if ( mri == null ) {
            throw new MoinIllegalNullArgumentException( "mri" ); //$NON-NLS-1$
        }
        this.lri = mri.getLri( );
        if ( this.lri == null ) {
            throw new MoinLocalizedBaseRuntimeException( CoreLinksMessages.LRIOFMRINULL, mri.toString( ) );
        }
    }

    public AmbiguousLriMap( MRI mri, V value ) {

        this( mri );
        this.standardPri = mri.getPri( );
        this.standardValue = value;
        this.priToValue = null;
    }

    public boolean isAmbiguous( ) {

        return this.priToValue != null;
    }

    public LRI getLri( ) {

        return this.lri;
    }

    public Collection<PRI> getPris( ) {

        if ( this.standardPri == null && this.priToValue == null ) {
            return Collections.emptyList( );
        }

        if ( this.standardPri != null && this.priToValue == null ) {
            return Collections.singletonList( this.standardPri );
        }
        if ( priToValue != null && this.standardPri == null ) {
            return new ArrayList<PRI>( this.priToValue.keySet( ) );
        }

        if ( priToValue != null && this.standardPri != null ) {
            ArrayList<PRI> result = new ArrayList<PRI>( this.priToValue.keySet( ) );
            result.add( this.standardPri );
            return result;
        }

        return null; // will never be reached, just to satisfy compiler
    }

    public Collection<MRI> getMris( ) {

        if ( this.standardPri == null && this.priToValue == null ) {
            return Collections.emptyList( );
        }
        Collection<MRI> result = new ArrayList<MRI>( );
        String mofId = this.lri.getMofId( );
        if ( this.standardPri != null ) {
            result.add( this.standardPri.createMri( mofId ) );
        }
        if ( priToValue != null ) {
            for ( PRI pri : this.priToValue.keySet( ) ) {
                result.add( pri.createMri( mofId ) );
            }
        }
        return result;
    }

    public void remove( PRI pri ) {

        if ( this.standardPri != null && this.standardPri.equals( pri ) ) {
            this.standardPri = null;
            this.standardValue = null;
            if ( this.priToValue != null ) {
                Set<PRI> pris = this.priToValue.keySet( );
                this.standardPri = pris.iterator( ).next( );
                this.standardValue = this.priToValue.get( this.standardPri );
                this.priToValue.remove( this.standardPri );
                if ( priToValue.isEmpty( ) ) {
                    this.priToValue = null;
                }

            }
        } else if ( this.priToValue != null ) {
            this.priToValue.remove( pri );
            if ( this.priToValue.isEmpty( ) ) {
                this.priToValue = null;
            }
        }
    }

    public V get( PRI pri ) {

        if ( this.standardPri != null && this.standardPri.equals( pri ) ) {
            return this.standardValue;
        }
        if ( priToValue != null ) {
            return this.priToValue.get( pri );
        }
        return null;
    }

    public V put( PRI pri, V value ) {

        if ( this.standardPri == null ) {
            this.standardPri = pri;
            this.standardValue = value;
            return null;
        } else {
            if ( this.standardPri.equals( pri ) ) {
                V formerValue = this.standardValue;
                this.standardValue = value;
                return formerValue;
            } else {
                if ( this.priToValue == null ) {
                    this.priToValue = new HashMap<PRI, V>( 2 );
                }
                return this.priToValue.put( pri, value );
            }
        }

    }

    public boolean isEmpty( ) {

        return this.standardPri == null && this.priToValue == null;
    }

    public PRI getStandardPri( ) {

        return this.standardPri;
    }

    public V getStandardValue( ) {

        return this.standardValue;
    }

    public int size( ) {

        if ( this.standardPri != null && this.priToValue == null ) {
            return 1;
        }

        if ( this.standardPri != null && this.priToValue != null ) {
            return priToValue.size( ) + 1;
        }

        if ( this.standardPri == null && this.priToValue == null ) {
            return 0;
        }

        if ( this.standardPri == null && this.priToValue != null ) {
            throw new MoinIllegalStateException( CoreLinksMessages.STANDARDPRINULL );
        }

        return 0;
    }
}