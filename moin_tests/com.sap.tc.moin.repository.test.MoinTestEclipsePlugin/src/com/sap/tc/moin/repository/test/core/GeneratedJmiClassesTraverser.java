package com.sap.tc.moin.repository.test.core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImplDynamic;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImplDynamicWrapper;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public class GeneratedJmiClassesTraverser {

    private CRI cri;

    private Connection connection;

    private Map<Class<?>, Object> interface2Instance;

    public GeneratedJmiClassesTraverser( CRI cri, Connection connection ) {

        this.cri = cri;
        this.connection = connection;
        initialize( );
    }

    private void initialize( ) {

        interface2Instance = new IdentityHashMap<Class<?>, Object>( );
        RefObject[] toplevelPackages = getToplevelPackages( );
        for ( RefObject refObject : toplevelPackages ) {
            MofPackage mofPackage = (MofPackage) refObject;
            RefPackage refPackage = connection.getJmiHelper( ).getRefPackageForMofPackage( mofPackage );
            Collection<RefClass> refAllClasses = refPackage.refAllClasses( );
            createInstancesMapping( refAllClasses );
            Collection<RefPackage> refAllPackages = refPackage.refAllPackages( );
            initialize( refAllPackages );
        }

    }

    private void initialize( Collection<RefPackage> refPackages ) {

        for ( RefPackage refPackage : refPackages ) {
            createInstancesMapping( refPackage.refAllClasses( ) );
            initialize( refPackage.refAllPackages( ) );
        }
    }

    private void createInstancesMapping( Collection<RefClass> refClasses ) {

        for ( RefClass refClass : refClasses ) {
            MofClass mofClass = (MofClass) refClass.refMetaObject( );
            if ( !mofClass.isAbstract( ) && !( refClass instanceof RefClassImplDynamic || refClass instanceof RefClassImplDynamicWrapper ) ) {
                RefObject instance = refClass.refCreateInstance( );
                Class[] interfaces = instance.getClass( ).getInterfaces( );
                for ( Class myInterface : interfaces ) {
                    Collection<Class> refBaseObjectInterfaceHierarchy = getRefBaseObjectInterfaceHierarchy( myInterface );
                    for ( Class relevantInterface : refBaseObjectInterfaceHierarchy ) {
                        Object result = interface2Instance.get( relevantInterface );
                        if ( result == null ) {
                            interface2Instance.put( relevantInterface, instance );
                        }
                    }
                }
            }
        }
    }

    private Collection<Class> getRefBaseObjectInterfaceHierarchy( Class someInterface ) {

        LinkedHashSet<Class> result = new LinkedHashSet<Class>( );
        if ( RefBaseObject.class.isAssignableFrom( someInterface ) ) {
            result.add( someInterface );
            Class[] interfaces = someInterface.getInterfaces( );
            for ( Class anotherInterface : interfaces ) {
                result.addAll( getRefBaseObjectInterfaceHierarchy( anotherInterface ) );
            }

        }
        return result;
    }

    public void run( ) throws Exception {

        RefObject[] toplevelPackages = getToplevelPackages( );
        for ( RefObject refObj : toplevelPackages ) {
            MofPackage mofPackage = (MofPackage) refObj;
            RefPackage refPackage = connection.getJmiHelper( ).getRefPackageForMofPackage( mofPackage );
            processRefPackage( refPackage );
        }

    }

    private RefObject[] getToplevelPackages( ) {

        String topLevelPackagesQuery = "select pkg from Model::Package as pkg where pkg.container = null";
        MQLResultSet resultSet = connection.getMQLProcessor( ).execute( topLevelPackagesQuery );
        List<RefObject> packages = new ArrayList<RefObject>( );
        for ( RefObject refObj : resultSet.getRefObjects( "pkg" ) ) {
            if ( refObj.get___Mri( ).getCri( ).equals( cri ) ) {
                packages.add( refObj );
            }
        }
        return packages.toArray( new RefObject[packages.size( )] );
    }

    private void processRefPackage( RefPackage refPackage ) {

        processStructureTypes( refPackage );
        callParameterlessMethods( refPackage );

        Collection<RefPackage> nestedPackages = refPackage.refAllPackages( );
        for ( RefPackage nestedPackage : nestedPackages ) {
            processRefPackage( nestedPackage );
        }

        Collection<RefClass> containedClasses = refPackage.refAllClasses( );
        for ( RefClass refClass : containedClasses ) {
            processRefClass( refClass );
        }

        Collection<RefAssociation> containedAssociations = refPackage.refAllAssociations( );
        for ( RefAssociation refAssociation : containedAssociations ) {
            processRefAssociation( refAssociation );
        }
    }

    private void processRefAssociation( RefAssociation refAssociation ) {

        callParameterlessMethods( refAssociation );
        Association assoc = (Association) refAssociation.refMetaObject( );
        List<AssociationEnd> associationEnds = connection.getJmiHelper( ).getAssociationEnds( assoc );
        MofClass class0 = (MofClass) associationEnds.get( 0 ).getType( );
        MofClass class0concrete = class0;
        if ( class0.isAbstract( ) ) {
            Collection<GeneralizableElement> allSubTypes = connection.getJmiHelper( ).getAllSubtypes( class0 );
            for ( GeneralizableElement subType : allSubTypes ) {
                if ( !subType.isAbstract( ) ) {
                    class0concrete = (MofClass) subType;
                    break;
                }
            }
        }
        MofClass class1 = (MofClass) associationEnds.get( 1 ).getType( );
        MofClass class1concrete = class1;
        if ( class1.isAbstract( ) ) {
            Collection<GeneralizableElement> allSubTypes = connection.getJmiHelper( ).getAllSubtypes( class1 );
            for ( GeneralizableElement subType : allSubTypes ) {
                if ( !subType.isAbstract( ) ) {
                    class1concrete = (MofClass) subType;
                    break;
                }
            }
        }
        if ( class0concrete.isAbstract( ) || class1concrete.isAbstract( ) ) {
            return;
        }

        RefObject instance0 = createInstanceOf( class0concrete );
        RefObject instance1 = createInstanceOf( class1concrete );

        Method[] publicMethods = getPublicMethods( refAssociation );
        for ( Method method : publicMethods ) {
            Class<?>[] parameterTypes = method.getParameterTypes( );
            if ( parameterTypes == null || parameterTypes.length == 0 ) {
                invokeNonRefAllMethod( refAssociation, method, (Object[]) null );
            } else {
                ArrayList<Object> arguments = new ArrayList<Object>( );
                boolean matchingArguments = true;
                for ( Class<?> parameterType : parameterTypes ) {
                    if ( parameterType.isAssignableFrom( instance0.getClass( ) ) ) {
                        arguments.add( instance0 );
                    } else if ( parameterType.isAssignableFrom( instance1.getClass( ) ) ) {
                        arguments.add( instance1 );
                    } else {
                        matchingArguments = false;
                        break;
                    }
                }
                if ( matchingArguments ) {
                    invokeNonRefAllMethod( refAssociation, method, arguments.toArray( new Object[arguments.size( )] ) );
                }

            }

        }

    }

    private Method[] getPublicMethods( RefBaseObject refBaseObject ) {

        Class _interface = refBaseObject.getClass( );
        ArrayList<Method> result = new ArrayList<Method>( );
        Method[] declaredMethods = _interface.getDeclaredMethods( );
        for ( Method method : declaredMethods ) {
            if ( Modifier.isPublic( method.getModifiers( ) ) ) {
                result.add( method );
            }
        }

        return result.toArray( new Method[result.size( )] );
    }

    private void processRefClass( RefClass refClass ) {

        callParameterlessMethods( refClass );
        processRefBaseObjectWithoutRefDelete( refClass, false );
        processRefBaseObjectWithoutRefDelete( refClass, true );
        processStructureTypes( refClass );
        if ( !( (MofClass) refClass.refMetaObject( ) ).isAbstract( ) && !( refClass instanceof RefClassImplDynamic || refClass instanceof RefClassImplDynamicWrapper ) ) {
            processRefObject( refClass.refCreateInstance( ) );
        }
    }

    private void processRefObject( RefObject instance ) {

        Collection<Operation> operations = getOperationsIncludingSupertypes( instance );
        for ( RefObject operation : operations ) {
            try {
                instance.refInvokeOperation( operation, Collections.emptyList( ) );
            } catch ( Exception e ) {
                //do nothing on purpose
            }
        }
        for ( RefObject operation : operations ) {
            try {
                instance.refInvokeOperation( operation, null );
            } catch ( Exception e ) {
                //do nothing on purpose
            }
        }

        for ( Operation operation : operations ) {
            try {
                instance.refInvokeOperation( operation.getName( ), Collections.emptyList( ) );
            } catch ( Exception e ) {
                //do nothing on purpose
            }
        }

        for ( Operation operation : operations ) {
            try {
                instance.refInvokeOperation( operation.getName( ), null );
            } catch ( Exception e ) {
                //do nothing on purpose
            }
        }

        try {
            instance.refInvokeOperation( (String) null, null );
        } catch ( Exception e ) {
            //do nothing on purpose
        }

        try {
            instance.refInvokeOperation( (Operation) null, null );
        } catch ( Exception e ) {
            //do nothing on purpose
        }

        try {
            instance.refInvokeOperation( (String) null, Collections.emptyList( ) );
        } catch ( Exception e ) {
            //do nothing on purpose
        }

        try {
            instance.refInvokeOperation( (Operation) null, Collections.emptyList( ) );
        } catch ( Exception e ) {
            //do nothing on purpose
        }

        processRefBaseObjectWithoutRefDelete( instance, false );
        processRefBaseObjectWithoutRefDelete( instance, true );
        instance.refDelete( );
        processRefBaseObjectWithoutRefDelete( instance, false );
    }

    private Collection<Operation> getOperationsIncludingSupertypes( RefObject instance ) {

        ArrayList<Operation> result = new ArrayList<Operation>( );
        MofClass mofClass = (MofClass) instance.refMetaObject( );
        result.addAll( getOperations( mofClass ) );
        List<GeneralizableElement> allSupertypes = connection.getJmiHelper( ).getAllSupertypes( mofClass );
        for ( GeneralizableElement generalizableElement : allSupertypes ) {
            result.addAll( getOperations( generalizableElement ) );
        }
        return result;
    }

    private Collection<Operation> getOperations( GeneralizableElement element ) {

        ArrayList<Operation> result = new ArrayList<Operation>( );
        List<ModelElement> contents = element.getContents( );
        for ( ModelElement modelElement : contents ) {
            if ( modelElement instanceof Operation ) {
                result.add( (Operation) modelElement );
            }
        }
        return result;
    }

    private void processRefBaseObjectWithoutRefDelete( RefBaseObject instance, boolean nullValues ) {

        callParameterlessMethods( instance );
        Method[] publicMethods = getPublicMethods( instance );
        for ( Method method : publicMethods ) {
            Class<?>[] parameterTypes = method.getParameterTypes( );
            if ( parameterTypes.length > 0 ) {
                Object[] args = determineArgs( parameterTypes );
                if ( nullValues ) {
                    if ( args == null ) {
                        args = new Object[parameterTypes.length];
                        invokeNonRefAllMethod( instance, method, args );
                    } else {
                        for ( int i = 0; i < parameterTypes.length; i++ ) {
                            Object[] newArgs = args.clone( );
                            newArgs[i] = null;
                            invokeNonRefAllMethod( instance, method, newArgs );
                        }
                    }
                } else {
                    if ( args != null ) {
                        invokeNonRefAllMethod( instance, method, args );

                    }
                }
            }
        }
    }

    private void processStructureTypes( RefClass refClass ) {

        // TODO Auto-generated method stub

    }

    private void processStructureTypes( RefPackage refPackage ) {

        // TODO                
    }

    private RefObject createInstanceOf( MofClass mofClass ) {

        RefClass classProxy = connection.getJmiHelper( ).getRefClassForMofClass( mofClass );
        return classProxy.refCreateInstance( );
    }

    private void callParameterlessMethods( Object object ) {

        Method[] declaredMethods = object.getClass( ).getMethods( );
        for ( Method method : declaredMethods ) {
            Class<?>[] parameterTypes = method.getParameterTypes( );
            if ( parameterTypes.length == 0 ) {
                invokeNonRefAllMethod( object, method, (Object[]) null );
            }
        }
    }

    private void invokeNonRefAllMethod( Object object, Method method, Object... args ) {

        if ( !method.getName( ).startsWith( "refAll" ) && ( !method.getName( ).startsWith( "refDelete" ) ) ) {
            try {
                method.invoke( object, args );
            } catch ( SecurityException e ) {
            } catch ( IllegalArgumentException e ) {
            } catch ( IllegalAccessException e ) {
            } catch ( InvocationTargetException e ) {
            }
        }
    }

    private Object[] determineArgs( Class... parameterTypes ) {

        Object[] result = new Object[parameterTypes.length];
        CoreConnection coreConn = connection instanceof Wrapper ? ( (Wrapper<CoreConnection>) connection ).unwrap( ) : (CoreConnection) connection;

        int index = 0;
        for ( Class parameterType : parameterTypes ) {
            Object arg = null;
            if ( parameterType.isPrimitive( ) ) {
                if ( Boolean.TYPE.equals( parameterType ) ) {
                    arg = Boolean.FALSE;
                } else if ( Character.TYPE.equals( parameterType ) ) {
                    arg = Character.valueOf( 'a' );
                } else if ( Byte.TYPE.equals( parameterType ) ) {
                    arg = Byte.valueOf( (byte) 1 );
                } else if ( Short.TYPE.equals( parameterType ) ) {
                    arg = Short.valueOf( (short) 1 );
                } else if ( Integer.TYPE.equals( parameterType ) ) {
                    arg = Integer.valueOf( 1 );
                } else if ( java.lang.Long.TYPE.equals( parameterType ) ) {
                    arg = Long.valueOf( 1 );
                } else if ( java.lang.Float.TYPE.equals( parameterType ) ) {
                    arg = Float.valueOf( 1 );
                } else if ( java.lang.Double.TYPE.equals( parameterType ) ) {
                    arg = Double.valueOf( 1 );
                } else {
                    return null;
                }
            } else if ( parameterType.equals( String.class ) ) {
                arg = "Test";
            } else if ( RefEnum.class.isAssignableFrom( parameterType ) ) {
                arg = getRefEnum( parameterType );
            } else if ( parameterType.equals( MultiplicityType.class ) ) {
                arg = coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, -1, true, false );
            } else if ( RefBaseObject.class.isAssignableFrom( parameterType ) ) {
                arg = interface2Instance.get( parameterType );
                if ( arg == null ) {
                    return null;
                }
            } else if ( parameterType.equals( ModelPartition.class ) ) {
                arg = connection.getNullPartition( );
            } else if ( CoreConnection.class.isAssignableFrom( parameterType ) ) {
                arg = connection instanceof Wrapper ? ( (Wrapper<CoreConnection>) connection ).unwrap( ) : connection;
            } else if ( List.class.isAssignableFrom( parameterType ) || Collection.class.isAssignableFrom( parameterType ) ) {
                arg = Collections.emptyList( );

            } else if ( parameterType.isArray( ) ) {
                Class componentType = parameterType.getComponentType( );
                Object[] determinedArgs = determineArgs( componentType );
                if ( determinedArgs != null ) {
                    arg = Array.newInstance( componentType, determinedArgs.length );
                } else {
                    return null;
                }
            } else {
                return null;
            }
            result[index++] = arg;
        }
        return result;
    }

    private Object getRefEnum( Class parameterType ) {

        String enumClassName = parameterType.getName( ) + "Enum";
        try {
            Class<?> enumClass = Class.forName( enumClassName );
            Field[] fields = enumClass.getFields( );
            for ( Field field : fields ) {
                int modifiers = field.getModifiers( );
                if ( Modifier.isStatic( modifiers ) && Modifier.isPublic( modifiers ) ) {

                    return field.get( null );
                }

            }
        } catch ( SecurityException e ) {
            e.printStackTrace( );
        } catch ( IllegalArgumentException e ) {
            e.printStackTrace( );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace( );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace( );
        }
        return null;
    }
}
