package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Version;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDeploymentExtensionTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * The metamode extension template
 */
public class JmiGeneratorMetamodelExtensionTemplateImpl implements JmiGeneratorDeploymentExtensionTemplate {

    private static final int MAX_METHOD_SIZE = 1000;

    private final String packageName;

    private final List<JmiGeneratorModelElementWrapper> myGeneratedObjects;

    private final List<String> implementsList = new ArrayList<String>( );

    private Map<String, String> mofIdImplMap;

    private Map<String, String> nameImplMap;

    private final Version coreRuntimeVersion;

    private final List<Partitionable> allModelElements;

    private String metamodelName = ""; //$NON-NLS-1$

    /**
     * @param thePackageName
     * @param implementedInterfaces
     * @param generatedObjects
     */
    public JmiGeneratorMetamodelExtensionTemplateImpl( String metamodelName, String thePackageName, String implementedInterfaces, List<JmiGeneratorModelElementWrapper> generatedObjects, Version coreRuntimeVersion, Set<Partitionable> elements ) {

        this.metamodelName = metamodelName;
        this.packageName = thePackageName;
        this.implementsList.add( implementedInterfaces );
        this.myGeneratedObjects = generatedObjects;
        this.coreRuntimeVersion = coreRuntimeVersion;
        this.allModelElements = new ArrayList<Partitionable>( elements );
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return null;
    }

    public List<String> getExtends( ) {

        return null;
    }

    public List<String> getImplements( ) {

        return this.implementsList;
    }

    /**
     * @return nothing
     */
    public Set<String> getImports( ) {

        return null;
    }

    public String getJavaName( ) {

        return "MetamodelExtension"; //$NON-NLS-1$
    }

    public String getPackageName( ) {

        return this.packageName;
    }

    public String getPreamble( ) {

        return JmiGeneratorBaseWrapper.PREAMBLE;
    }

    public String getVersion( ) {

        return JmiGeneratorBaseWrapper.GENERATOR_VERSION;
    }

    public List<String> getImplementations( ) {

        List<String> result = new ArrayList<String>( );
        for ( JmiGeneratorModelElementWrapper wrapper : this.myGeneratedObjects ) {
            if ( wrapper.getMofType( ) == JmiGeneratorMofType.EXCEPTION ) {
                // no such thing
                continue;
            }
            result.add( ( (JmiGeneratorBaseWrapper) wrapper ).getJavaClassName( JmiGenerationKind.CLASS, true ) );
        }
        return result;
    }

    public Map<String, String> getMofIdImplementationMap( ) {

        if ( this.mofIdImplMap == null ) {
            this.mofIdImplMap = new HashMap<String, String>( );
            for ( JmiGeneratorModelElementWrapper wrapper : this.myGeneratedObjects ) {
                if ( wrapper.getMofType( ) == JmiGeneratorMofType.EXCEPTION ) {
                    // no such thing
                    continue;
                }
                JmiGeneratorBaseWrapper bwrapper = (JmiGeneratorBaseWrapper) wrapper;
                this.mofIdImplMap.put( bwrapper.getModelElementMofId( ), bwrapper.getJavaClassName( JmiGenerationKind.CLASS, true ) );
            }
        }
        return this.mofIdImplMap;
    }

    public Map<String, String> getNameImplementationMap( ) {

        if ( this.nameImplMap == null ) {
            this.nameImplMap = new HashMap<String, String>( );
            for ( JmiGeneratorModelElementWrapper wrapper : this.myGeneratedObjects ) {
                if ( wrapper.getMofType( ) == JmiGeneratorMofType.EXCEPTION ) {
                    // no such thing
                    continue;
                }
                JmiGeneratorBaseWrapper bwrapper = (JmiGeneratorBaseWrapper) wrapper;
                this.nameImplMap.put( bwrapper.getModelElementQualifiedName( ), bwrapper.getJavaClassName( JmiGenerationKind.CLASS, true ) );
            }
        }
        return this.nameImplMap;
    }

    public String getCoreRuntimeVersion_Major( ) {

        return Integer.toString( this.coreRuntimeVersion.getMajor( ) );
    }

    public String getCoreRuntimeVersion_Minor( ) {

        return Integer.toString( this.coreRuntimeVersion.getMinor( ) );
    }

    private String getQualifiedNameForStringArrayInitializer( ModelElement element ) {

        List<String> qName = element.getQualifiedName( );
        String result = "\"" + qName.get( 0 ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        for ( int i = 1; i < qName.size( ); i++ ) {
            result += ", \"" + escapeQuotes( qName.get( i ) ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return result;
    }

    private String escapeQuotes( String string ) {

        if ( string.indexOf( '"' ) == -1 ) {
            return string;
        }
        return string.replace( "\"", "\\\"" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public String getMofIdQualifiedNameMapping( ) {

        StringBuilder result = new StringBuilder( );
        int elements = 0;
        for ( Partitionable element : allModelElements ) {
            if ( element instanceof ModelElement ) {
                elements++;
            }
        }
        int numInitMethods = elements / MAX_METHOD_SIZE;
        if ( numInitMethods > 0 && elements % 1000 != 0 ) {
            numInitMethods++; // Need one more for the rest.
        }
        if ( numInitMethods > 0 ) {
            for ( int i = 0; i < numInitMethods; i++ ) {
                result.append( "    private void initQualifiedNameMap" ).append( i ).append( "( ) {\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                for ( int j = i * 1000; j < ( i + 1 ) * 1000 && j < allModelElements.size( ); j++ ) {
                    Partitionable element = allModelElements.get( j );
                    if ( element instanceof ModelElement ) { // false for OCL elements !!!
                        result.append( "        this.mofIdToQualifiedNameMapping.put(\"" ).append( element.refMofId( ) ).append( "\", java.util.Collections.unmodifiableList(java.util.Arrays.asList(new String[]{" ).append( getQualifiedNameForStringArrayInitializer( (ModelElement) element ) ) //$NON-NLS-1$ //$NON-NLS-2$
                            .append( "})));\n" ); //$NON-NLS-1$
                    }
                }
                result.append( "    }\n\n" ); //$NON-NLS-1$
            }
        }
        result.append( "    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getMofIdQualifiedNameMapping() {\n" ); //$NON-NLS-1$
        result.append( "        if (this.mofIdToQualifiedNameMapping == null) {\n" ); //$NON-NLS-1$
        result.append( "            this.mofIdToQualifiedNameMapping = new java.util.HashMap<java.lang.String, java.util.List<java.lang.String>>(" + Utilities.calcInitialCapacity( allModelElements.size( ) ) + ");\n" ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( numInitMethods > 0 ) {
            for ( int i = 0; i < numInitMethods; i++ ) {
                result.append( "            initQualifiedNameMap" ).append( i ).append( "();\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        } else {
            for ( Partitionable element : allModelElements ) {
                if ( element instanceof ModelElement ) { // false for OCL elements !!!
                    result.append( "            this.mofIdToQualifiedNameMapping.put(\"" ).append( element.refMofId( ) ).append( "\", java.util.Collections.unmodifiableList(java.util.Arrays.asList(new String[]{" ).append( getQualifiedNameForStringArrayInitializer( (ModelElement) element ) ) //$NON-NLS-1$ //$NON-NLS-2$
                        .append( "})));\n" ); //$NON-NLS-1$
                }
            }
        }
        result.append( "        }\n" ); //$NON-NLS-1$
        result.append( "        return this.mofIdToQualifiedNameMapping;\n" ); //$NON-NLS-1$
        result.append( "    }\n" ); //$NON-NLS-1$
        return result.toString( );
    }

    public String getMofIdImmediateCompositeMofIdMapping( ) {

        StringBuilder result = new StringBuilder( );
        int elements = 0;
        for ( Partitionable element : allModelElements ) {
            if ( ( (RefObject) element ).refImmediateComposite( ) != null ) {
                elements++;
            }
        }
        int numInitMethods = elements / MAX_METHOD_SIZE;
        if ( numInitMethods > 0 && elements % 1000 != 0 ) {
            numInitMethods++; // Need one more for the rest.
        }
        if ( numInitMethods > 0 ) {
            for ( int i = 0; i < numInitMethods; i++ ) {
                result.append( "    private void initImmediateCompositeMofIdMap" ).append( i ).append( "( ) {\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                for ( int j = i * 1000; j < ( i + 1 ) * 1000 && j < allModelElements.size( ); j++ ) {
                    Partitionable element = allModelElements.get( j );
                    RefFeatured composite = ( (RefObject) element ).refImmediateComposite( );
                    if ( composite != null ) {
                        result.append( "        this.mofIdToImmediateCompositeMofIdMapping.put(\"" ).append( element.refMofId( ) ).append( "\", \"" ).append( composite.refMofId( ) ).append( "\");\n" ); //$NON-NLS-1$ //$NON-NLS-2$  //$NON-NLS-3$
                    }
                }
                result.append( "    }\n\n" ); //$NON-NLS-1$
            }
        }
        result.append( "    public java.util.Map<java.lang.String, java.lang.String> getMofIdImmediateCompositeMofIdMapping() {\n" ); //$NON-NLS-1$
        result.append( "        if (this.mofIdToImmediateCompositeMofIdMapping == null) {\n" ); //$NON-NLS-1$
        result.append( "            this.mofIdToImmediateCompositeMofIdMapping = new java.util.HashMap<java.lang.String, java.lang.String>(" + Utilities.calcInitialCapacity( allModelElements.size( ) ) + ");\n" ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( numInitMethods > 0 ) {
            for ( int i = 0; i < numInitMethods; i++ ) {
                result.append( "            initImmediateCompositeMofIdMap" ).append( i ).append( "();\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        } else {
            for ( Partitionable element : allModelElements ) {
                RefFeatured composite = ( (RefObject) element ).refImmediateComposite( );
                if ( composite != null ) {
                    result.append( "            this.mofIdToImmediateCompositeMofIdMapping.put(\"" ).append( element.refMofId( ) ).append( "\", \"" ).append( composite.refMofId( ) ).append( "\");\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
            }
        }
        result.append( "        }\n" ); //$NON-NLS-1$
        result.append( "        return this.mofIdToImmediateCompositeMofIdMapping;\n" ); //$NON-NLS-1$
        result.append( "    }\n" ); //$NON-NLS-1$
        return result.toString( );
    }

    public boolean getBelongsToMof( ) {

        return JmiGeneratorBaseWrapper.belongsToMof( metamodelName );
    }
}
