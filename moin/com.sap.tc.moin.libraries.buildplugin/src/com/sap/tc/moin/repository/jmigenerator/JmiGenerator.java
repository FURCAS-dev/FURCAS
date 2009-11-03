package com.sap.tc.moin.repository.jmigenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The JMI Generator
 */
public class JmiGenerator {

    private Object myGeneratorImpl;

    /**
     * Create a generator instance
     * 
     * @param connection the connection
     */
    @SuppressWarnings( "unchecked" )
    public JmiGenerator( CoreConnection connection ) {

        try {
            Class generatorImpl = Class.forName( "com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl" ); //$NON-NLS-1$
            Constructor myGeneratorConstructor = generatorImpl.getConstructor( CoreConnection.class );
            this.myGeneratorImpl = myGeneratorConstructor.newInstance( connection );
        } catch ( SecurityException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORIMPL, e );
        } catch ( ClassNotFoundException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORIMPL, e );
        } catch ( InstantiationException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORIMPL, e );
        } catch ( IllegalAccessException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORIMPL, e );
        } catch ( NoSuchMethodException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORIMPL, e );
        } catch ( InvocationTargetException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORIMPL, e );
        }
    }

    /**
     * @param metamodelName
     * @param partitions
     * @return a list of model element wrappers used to generate the coding
     */
    @SuppressWarnings( "unchecked" )
    public List<JmiGeneratorModelElementWrapper> createObjectList( String metamodelName, Set<? extends ModelPartition> partitions ) {

        List<JmiGeneratorModelElementWrapper> result = new ArrayList<JmiGeneratorModelElementWrapper>( );
        Method getWrapper;
        try {
            Class generatorImpl = Class.forName( "com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl" ); //$NON-NLS-1$
            getWrapper = generatorImpl.getMethod( "getOrCreateWrapper", String.class, ModelElement.class ); //$NON-NLS-1$
        } catch ( SecurityException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
        } catch ( ClassNotFoundException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
        } catch ( NoSuchMethodException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
        }

        for ( ModelPartition partition : partitions ) {
            for ( Partitionable me : partition.getElements( ) ) {
                if ( !( me instanceof ModelElement ) ) {
                    continue;
                }
                if ( me instanceof MofClass || me instanceof MofPackage || me instanceof Association || me instanceof EnumerationType || me instanceof StructureType || me instanceof MofException ) {

                    try {
                        result.add( (JmiGeneratorModelElementWrapper) getWrapper.invoke( this.myGeneratorImpl, metamodelName, me ) );
                    } catch ( IllegalArgumentException e ) {
                        throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                    } catch ( IllegalAccessException e ) {
                        throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                    } catch ( InvocationTargetException e ) {
                        throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                    }
                }
            }
        }
        return result;
    }

    /**
     * This returns a tree with top level packages as root nodes
     * 
     * @param packages
     * @return a list of root nodes
     */
    @SuppressWarnings( "unchecked" )
    public List<JmiGeneratorModelElementWrapper> createObjectTree( Set<MofPackage> packages ) {

        Constructor constructor;
        try {
            Class pkgwrapper = Class.forName( "com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper" ); //$NON-NLS-1$
            Class generatorImpl = Class.forName( "com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl" ); //$NON-NLS-1$
            constructor = pkgwrapper.getConstructor( MofPackage.class, generatorImpl );
        } catch ( ClassNotFoundException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
        } catch ( NoSuchMethodException e ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
        }

        List<JmiGeneratorModelElementWrapper> result = new ArrayList<JmiGeneratorModelElementWrapper>( );

        for ( MofPackage mp : packages ) {
            if ( mp.getContainer( ) == null ) {
                try {
                    JmiGeneratorModelElementWrapper wrapper = (JmiGeneratorModelElementWrapper) constructor.newInstance( mp, this.myGeneratorImpl );
                    result.add( wrapper );
                } catch ( RuntimeException e ) {
                    throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                } catch ( InstantiationException e ) {
                    throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                } catch ( IllegalAccessException e ) {
                    throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                } catch ( InvocationTargetException e ) {
                    throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER, e );
                }
            }

        }

        return result;

    }

    /**
     * Get the deployment extensions for this meta model
     * 
     * @param metamodelName
     * @param partitions
     * @param generatedElements
     * @param kindFilter
     * @return a list of {@link JmiGeneratorPathCodePair}s
     */
    @SuppressWarnings( "unchecked" )
    public List<JmiGeneratorPathCodePair> getDeploymentExtensions( String metamodelName, Set<ModelPartition> partitions, List<JmiGeneratorModelElementWrapper> generatedElements, JmiGenerationKind[] kindFilter ) {

        Set<JmiGenerationKind> kinds = new HashSet<JmiGenerationKind>( );
        for ( int i = 0; i < kindFilter.length; i++ ) {
            kinds.add( kindFilter[i] );
        }
        if ( kinds.contains( JmiGenerationKind.CLASS ) ) {

            Method getDeploymentExtensions;
            try {
                Class generatorImpl = Class.forName( "com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl" ); //$NON-NLS-1$
                getDeploymentExtensions = generatorImpl.getMethod( "getDeploymentExtensions", String.class, Set.class, List.class ); //$NON-NLS-1$
                return (List<JmiGeneratorPathCodePair>) getDeploymentExtensions.invoke( this.myGeneratorImpl, metamodelName, partitions, generatedElements );
            } catch ( SecurityException e ) {
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGDEPLOYMENTEXTENSION, e );
            } catch ( ClassNotFoundException e ) {
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGDEPLOYMENTEXTENSION, e );
            } catch ( NoSuchMethodException e ) {
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGDEPLOYMENTEXTENSION, e );
            } catch ( InvocationTargetException e ) {
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGDEPLOYMENTEXTENSION, e );
            } catch ( IllegalAccessException e ) {
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.EXCEPTIONGETTINGDEPLOYMENTEXTENSION, e );
            }

        }

        return new ArrayList<JmiGeneratorPathCodePair>( );
    }
}
