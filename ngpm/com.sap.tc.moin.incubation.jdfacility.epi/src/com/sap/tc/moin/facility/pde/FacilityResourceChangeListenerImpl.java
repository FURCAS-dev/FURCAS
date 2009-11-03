/**
 * 
 */
package com.sap.tc.moin.facility.pde;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.MultiRule;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionResourceRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionResourceRecord.InputStreamProvider;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionNameVerifier;

/**
 *
 */
public class FacilityResourceChangeListenerImpl implements FacilityResourceChangeListener, IpiFacilityComponent {

    public static final String CHANGE_LISTENER_OFF = "com.sap.tc.moin.resourcechangelistener.off";

    private static final String CONSOLE_LOG_ON = "com.sap.tc.moin.dcchangelistener.clog.on"; // console log for project changes

    private SpiPartitionNameVerifier _partitionNameVerifier = null;

    private IpiFsResourceManagement _fsResourceHandler = null;

    public FacilityResourceChangeListenerImpl( ) {

    }

    public void finalizeStartup( ) {

    }

    public void initialize( ) {

        ResourcesPlugin.getWorkspace( ).addResourceChangeListener( this, IResourceChangeEvent.POST_CHANGE );
    }

    public void tearDown( ) {

        ResourcesPlugin.getWorkspace( ).removeResourceChangeListener( this );
    }

    public void bind( SpiPartitionNameVerifier partitionNameVerifier ) {

        this._partitionNameVerifier = partitionNameVerifier;
    }

    public void bind( IpiFsResourceManagement fsResourceHandler ) {

        this._fsResourceHandler = fsResourceHandler;
    }

    class ResourceDeltaVisitor implements IResourceDeltaVisitor {

        private Set<String> _projectChanges;

        public ResourceDeltaVisitor( ) {

            super( );

            this._projectChanges = null;
            // if ( Boolean.getBoolean( PROJECTCHANGES_ECL_ACTIVE ) ) {
            this._projectChanges = new HashSet<String>( 2 );
            this._projectChanges.add( ".project" ); //$NON-NLS-1$
            // }
        }

        public List<PartitionResourceRecord> partitionsForUpdate = new ArrayList<PartitionResourceRecord>( );

        public List<IFile> resourceFiles = new ArrayList<IFile>( );

        public Set<IProject> projectsForUpdate = new HashSet<IProject>( );

        private void log( IResourceDelta project, IResourceDelta child ) {

            String message = null;

            //LOGGER.trace( MoinSeverity.INFO, message );
            if ( Boolean.getBoolean( CONSOLE_LOG_ON ) ) {
                message = "[FacilityResourceChangeListerner] - project " + change( project.getKind( ) ) + " - " + change( child.getKind( ) ) + project.getResource( ).getFullPath( ).toOSString( ) + " ";
                // $JL-SYS_OUT_ERR$ For testing only, having messages besides the
                // test messages
                java.lang.System.out.println( message );
                java.lang.System.out.flush( );
            }
        }

        private String change( int kind ) {

            String changeString = null;
            switch ( kind ) {
                case IResourceDelta.ADDED:
                    changeString = "added"; //$NON-NLS-1$
                    break;

                case IResourceDelta.REMOVED:
                    changeString = "removed"; //$NON-NLS-1$
                    break;

                case IResourceDelta.CHANGED:
                    changeString = "changed"; //$NON-NLS-1$
                    break;

                default:
                    changeString = "unknown"; //$NON-NLS-1$
                    break;
            }
            return changeString;
        }

        public boolean visit( IResourceDelta delta ) throws CoreException {

            IResource res = delta.getResource( );
            if ( res.getType( ) == IResource.ROOT ) {
                // continue
                return true;
            }
            if ( res.getType( ) == IResource.PROJECT ) {
                IResourceDelta[] children = delta.getAffectedChildren( );
                if ( children == null || children.length < 1 ) {
                    return false;
                }

                // check for project change on first child level
                if ( _projectChanges != null ) {
                    for ( int i = 0; i < children.length; i++ ) {
                        if ( _projectChanges.contains( children[i].getResource( ).getName( ) ) ) {
                            // log information 
                            log( delta, children[i] );

                            IProject project = (IProject) res;
                            projectsForUpdate.add( project );
                            // ignore anything else below
                            return false;
                        }
                    }
                }

                // check for partition changes
                String rootPath = res.getFullPath( ).toOSString( );
                Set<String> resourceFolders = FacilityResourceChangeListenerImpl.this._fsResourceHandler.getRegisteredResourceFoldersForRootPath( rootPath );
                if ( resourceFolders == null ) {
                    return false;
                } else {
                    // prepare resource folder table
                    Map<String, RFolder> rfMap = new HashMap<String, RFolder>( );
                    for ( Iterator<String> it = resourceFolders.iterator( ); it.hasNext( ); ) {
                        String rf = it.next( );
                        String[] rfArr = new Path( rf ).segments( );
                        RFolder folder = rfMap.get( rfArr[0] );
                        if ( folder == null ) {
                            folder = new RFolder( rf );
                        }
                        folder.putChildren( 1, rfArr );
                        rfMap.put( rfArr[0], folder );
                    }

                    // start checking resource folders
                    for ( int i = 0; i < children.length; i++ ) {
                        this.visit( children[i], rfMap );
                    }
                    return false;
                }
            }
            return false;
        }

        private void visit( IResourceDelta delta, Map<String, RFolder> rfMap ) {

            IResource res = delta.getResource( );

            if ( rfMap != null ) {
                // check for resource folders
                String name = res.getName( );
                RFolder folder = rfMap.get( name );
                if ( folder == null ) {
                    // no matching entry - return
                    return;
                }

                if ( folder.isRFolder( ) ) {
                    // continue visiting tree without resource folder check
                    IResourceDelta[] children = delta.getAffectedChildren( );
                    if ( children == null || children.length < 1 ) {
                        return;
                    }
                    for ( int i = 0; i < children.length; i++ ) {
                        this.visit( children[i], null );
                    }
                    return;
                } else {
                    // continue visiting tree with resource folder check
                    IResourceDelta[] children = delta.getAffectedChildren( );
                    if ( children == null || children.length < 1 ) {
                        return;
                    }
                    for ( int i = 0; i < children.length; i++ ) {
                        this.visit( children[i], folder.getChildFolder( ) );
                    }
                    return;
                }
            }

            if ( res.getType( ) == IResource.FOLDER ) {
                // continue visiting tree without resource folder check
                IResourceDelta[] children = delta.getAffectedChildren( );
                if ( children == null || children.length < 1 ) {
                    return;
                }
                for ( int i = 0; i < children.length; i++ ) {
                    this.visit( children[i], null );
                }
                return;
            }

            if ( res.getType( ) == IResource.FILE ) {
                IFile file = (IFile) res;
                String partitionName = file.getProjectRelativePath( ).toString( );

                if ( FacilityResourceChangeListenerImpl.this._partitionNameVerifier.isValidPartitionName( partitionName ) ) {
                    resourceFiles.add( file );
                }
            }
        }

    }

    class RFolder {

        private String key = null;

        private boolean isRFolder = false;

        private Map<String, RFolder> children = new HashMap<String, RFolder>( );

        public RFolder( String key ) {

            super( );
            this.key = key;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals( Object obj ) {

            if ( obj instanceof RFolder ) {
                return this.key.equals( ( (RFolder) obj ).getKey( ) );
            }
            return false;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode( ) {

            return this.key.hashCode( );
        }


        /**
         * @return the key
         */
        public String getKey( ) {

            return key;
        }

        public void putChildren( int level, String[] path ) {

            if ( level < path.length ) {
                RFolder folder = children.get( path[level] );
                if ( folder == null ) {
                    folder = new RFolder( path[level] );
                }
                folder.putChildren( level + 1, path );
                children.put( path[level], folder );
            } else {
                //  already resource folder
                this.isRFolder = true;
            }
        }

        public boolean isRFolder( ) {

            return isRFolder;
        }

        public Map<String, RFolder> getChildFolder( ) {

            return children;
        }

    }


    private static class FileStreamProvider implements InputStreamProvider {

        private IFile _file = null;

        public FileStreamProvider( IFile file ) {

            super( );
            this._file = file;
        }

        public InputStream getInputStream( ) {

            // provider delegates to StorageHandler to obtain streams
            InputStream stream;
            try {
                stream = this._file.getContents( );
            } catch ( CoreException e ) {
                throw new RuntimeException( e );
            }
            return stream;
        }
    };

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_EVENTS_PARTITIONS, FacilityResourceChangeListenerImpl.class );

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org
     * .eclipse.core.resources.IResourceChangeEvent)
     */
    public void resourceChanged( IResourceChangeEvent event ) {

        if ( Boolean.getBoolean( CHANGE_LISTENER_OFF ) ) {
            // is switched off, but listener is registered: skip here 
            return;
        }
        ResourceDeltaVisitor visitor = new ResourceDeltaVisitor( );

        try {
            event.getDelta( ).accept( visitor );
            // ignore projects here: they should be handled in a separate listener on dii events
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                FacilityResourceChangeListenerImpl.LOGGER.trace( new Exception( "Resource change event" ), MoinSeverity.DEBUG, "Resource change event" );
                FacilityResourceChangeListenerImpl.LOGGER.trace( MoinSeverity.DEBUG, "Projects for update ignored: " + visitor.projectsForUpdate );
                FacilityResourceChangeListenerImpl.LOGGER.trace( MoinSeverity.DEBUG, "Files for update: " + visitor.resourceFiles );
            }
            visitor.projectsForUpdate.clear( );

            // process partition update
            if ( !visitor.resourceFiles.isEmpty( ) ) {
                final List<IFile> passFiles = visitor.resourceFiles;

                Date now = new Date( );
                SimpleDateFormat format = new SimpleDateFormat( "(yyyyMMdd_HHmmss_SSS)" ); //$NON-NLS-1$
                String time = format.format( now );
                final String passTime = time;

                log( "[FacilityResourceChangeListenerImpl] " + time + "schedule partitions update: " + visitor.resourceFiles );

                scheduleUpdate( passFiles, passTime, _fsResourceHandler );
            } else if ( !visitor.partitionsForUpdate.isEmpty( ) ) {
                log( "[FacilityResourceChangeListenerImpl] update partitions: " + visitor.partitionsForUpdate );
                this._fsResourceHandler.updatePartitions( visitor.partitionsForUpdate );
            }

        } catch ( CoreException ex ) {
            FacilityResourceChangeListenerImpl.LOGGER.trace( ex, MoinSeverity.ERROR, "Resource change event problem: " + ex.getMessage( ));
        }
    }

    private void scheduleUpdate( final List<IFile> files, final String passTime, final IpiFsResourceManagement resourceHandler ) {



        Job updateJob = new Job( "UpdatePartitions" + passTime ) { //$NON-NLS-1$


            @Override
            protected IStatus run( IProgressMonitor monitor ) {

                Date now = new Date( );
                SimpleDateFormat format = new SimpleDateFormat( "(yyyyMMdd_HHmmss_SSS)" ); //$NON-NLS-1$
                String time = format.format( now );
                String thread = "<" + Thread.currentThread( ).getId( ) + ">"; //$NON-NLS-1$ //$NON-NLS-2$

                List<PartitionResourceRecord> partitionsForUpdate = new ArrayList<PartitionResourceRecord>( );
                for ( IFile file : files ) {
                    IProject project = file.getProject( );
                    // we must use toOSString here to make sure that the string compare works (is also used by the project handler before resource registration)
                    String rootPath = project.getFullPath( ).toOSString( );

                    // get relative partition name
                    String partitionName = file.getProjectRelativePath( ).toString( );

                    // time stamp and stream provider are required only for some operations
                    // set default
                    long timestamp = 0L;
                    InputStreamProvider streamProvider = null;
                    PartitionResourceRecord.Operation operation = PartitionResourceRecord.Operation.DELETED;

                    if ( file.exists( ) ) {
                        // get time stamp
                        timestamp = file.getLocalTimeStamp( );

                        // use resource for stream provider
                        streamProvider = new FileStreamProvider( file );

                        operation = PartitionResourceRecord.Operation.CHANGED;
                    }

                    // set up partition resource record
                    PartitionResourceRecord prr = new PartitionResourceRecord( );
                    prr.rootPath = rootPath;
                    prr.partitionName = partitionName;
                    prr.timestamp = timestamp;
                    prr.streamProvider = streamProvider;
                    prr.operation = operation;
                    partitionsForUpdate.add( prr );
                }

                log( "[FacilityResourceChangeListenerImpl] " + thread + passTime + "-" + time + " Begin update partitions: " + partitionsForUpdate ); //$NON-NLS-2$
                resourceHandler.updatePartitions( partitionsForUpdate );
                log( "[FacilityResourceChangeListenerImpl] " + thread + passTime + "-" + time + " End update partitions: " + partitionsForUpdate ); //$NON-NLS-2$

                return Status.OK_STATUS;
            }


        };

        ISchedulingRule rule = null;
        if ( files != null && files.size( ) > 0 ) {
            rule = new MultiRule( files.toArray( new ISchedulingRule[files.size( )] ) );
        }


        updateJob.setRule( rule );

        updateJob.schedule( );
    }

    protected void log( String message ) {

        boolean logAlways = false; // option to force output
        if ( logAlways || Boolean.getBoolean( CONSOLE_LOG_ON ) ) {
            //$JL-SYS_OUT_ERR$ For testing only, having messages besides the test messages
            java.lang.System.out.println( message );
            java.lang.System.out.flush( );
        }
        LOGGER.trace( MoinSeverity.INFO, message );
    }

}
