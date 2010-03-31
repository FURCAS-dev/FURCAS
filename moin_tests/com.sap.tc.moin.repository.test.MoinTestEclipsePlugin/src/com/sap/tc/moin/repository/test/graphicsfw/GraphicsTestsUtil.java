package com.sap.tc.moin.repository.test.graphicsfw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import javax.xml.parsers.ParserConfigurationException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.xml.sax.SAXException;

import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.links.DiagramLink;
import com.sap.moin.mm.gfw.links.Link;
import com.sap.moin.mm.gfw.pictograms.Diagram;
import com.sap.moin.mm.gfw.pictograms.PictogramElement;
import com.sap.tc.moin.test.xmlunit.XMIElementQualifier;

/**
 * Abstract class specialized by the TestsUtil classes for the test cases. It
 * contains abstract methods which are necessary for the execution of the test
 * cases to have the same structure. Only those methods which are usable with
 * every model are not abstract. <br>
 * <br>
 * Proposed structure of the test:<br>
 * <ol>
 * <li> Creation and persistence of the model with {@link #createModel()}</li>
 * <li> Checking if the model is correct with
 * {@link #checkModelAndCloseConnection()}</li>
 * <li> Loading the model from persistence with {@link #loadModel()}</li>
 * <li> Checking if the model is correct with
 * {@link #checkModelAndCloseConnection()}</li>
 * <li> Modifying the model with {@link #modifyModel()}</li>
 * <li> Checking the modifications with
 * {@link #checkModifiedModelAndCloseConnection()}</li>
 * <li> Loading the modified model with {@link #loadModel()}</li>
 * <li> Checking the modifications with
 * {@link #checkModifiedModelAndCloseConnection()}</li>
 * 
 * @author d043982
 */
public abstract class GraphicsTestsUtil {

    public static final String GRAPHICS_CONTAINER_NAME = "sap.com/com/sap/moin/mm/gfw";

    protected RepositoryFacade repository;

    protected GraphicsPackage graphicsPackage;

    protected ModelPackage modelPackage;

    protected Map mapOfElements;

    /**
     * @param repositoryImpl Implementation of RepositoryFacade with the methods
     * for the used infrastructure
     * @param uriReferenceModel Filename of the reference model for the
     * comparison of the created and saved model. The model must exist in
     * "com/sap/tc/moin/repository/test/graphicsfw/"
     * @throws FileNotFoundException when the reference model wasn't found
     * @throws IOException
     */
    public GraphicsTestsUtil( RepositoryFacade repositoryImpl ) throws FileNotFoundException, IOException {

        repository = repositoryImpl;
    }

    /**
     * Creates the model according to the documentation of the specialized
     * createModel() method and persists it
     * 
     * @throws RepositoryException
     */
    public abstract void createModel( ) throws RepositoryException;

    /**
     * Modifies the model according to the documentation of the specialized
     * modifyModel() method and persists it
     * 
     * @throws RepositoryException
     */
    public abstract void modifyModel( ) throws RepositoryException;

    /**
     * Loads the persisted root elements of model whose MofId are stored in
     * mapOfElements.
     * 
     * @throws RepositoryException
     * @throws ModelNotFoundException when the model wasn't found
     */
    public abstract void loadModel( ) throws RepositoryException, ModelNotFoundException;

    /**
     * The contained root elements of the model are nulled and the connection to
     * the infrastructure is closed.
     * 
     * @throws RepositoryException
     */
    public abstract void closeConnection( ) throws RepositoryException;

    /**
     * Checks the correct modification of the model with methods of
     * {@link GraphicsModelManipulation} and returns an ArrayList with
     * differences to the expected modifications.
     * 
     * @return ArrayList with all differences to the expected modified model
     * @throws RepositoryException
     */
    public abstract ArrayList checkModifiedModel( ) throws RepositoryException;

    /**
     * Returns a collection with all the root elements of the model.
     * 
     * @return Retruns a collection with all root elements that exist in the
     * created model
     */
    public abstract Collection getRootElements( );

    /**
     * Deletes the model from the persistence and closes the connection to the
     * infrastructure.
     * 
     * @throws RepositoryException
     * @throws ModelNotFoundException when the model wasn't found
     */
    public abstract void deleteModelAndCloseConnection( ) throws RepositoryException, ModelNotFoundException;

    /**
     * Test output for manual comparison
     * 
     * @param URI File name for the exportet XMI file
     */
    public void exportToXmi( String URI ) throws IOException {

        repository.writeToFile( getRootElements( ), URI );
    }

    /**
     * Diffs the model in the output stream with the reference model whether
     * they are similar
     * 
     * @param out OutputStream with the model that should be diffed
     * @return The diff of the reference model and the model in the memory
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    protected Diff diffSimilar( OutputStream out, String referenceModel ) throws SAXException, IOException, ParserConfigurationException {

        String string2 = out.toString( );

        Diff diff = new Diff( referenceModel, string2 );
        diff.overrideElementQualifier( new XMIElementQualifier( ) );

        int[] ignoreValues = new int[] { DifferenceConstants.CHILD_NODELIST_SEQUENCE.getId( ), DifferenceConstants.ATTR_SEQUENCE.getId( ) };

        // Sets own rules for diffing including the ignorance of the timestamp
        DifferenceListener diffListener = new IgnoreTestListenerForPictogramsTest( );
        ( (IgnoreTestListenerForPictogramsTest) diffListener ).setIgnoreValues( ignoreValues );

        diff.overrideDifferenceListener( diffListener );

        return diff;

    }

    /**
     * Returns the diagram with the mofId from persistence
     * 
     * @param mofId MofId of the diagram that should be loaded
     * @return Diagram with the mofId
     * @throws ModelNotFoundException when the diagram wasn't found on
     * persistence
     */
    protected Diagram getDiagramByMofId( ) throws ModelNotFoundException {

        graphicsPackage = (GraphicsPackage) repository.selectRefPackage( GRAPHICS_CONTAINER_NAME, "graphics" );
        RefClass dc = graphicsPackage.getPictograms( ).getDiagram( );
        Collection diagramCollection = dc.refAllOfClass( );
        PictogramElement ldiagram = null;
        if ( diagramCollection != null ) {
            for ( Iterator iter = diagramCollection.iterator( ); iter.hasNext( ); ) {
                ldiagram = (PictogramElement) iter.next( );

                if ( ldiagram instanceof Diagram && ldiagram != null ) {
                    if ( ( (String) mapOfElements.get( "diagram" ) ).equals( ldiagram.refMofId( ) ) ) {
                        return (Diagram) ldiagram;
                    }
                }
            }
        }
        if ( ldiagram == null ) {
            throw new ModelNotFoundException( "diagram", (String) mapOfElements.get( "diagram" ) );
        }

        return null;
    }

    /**
     * Returns the diagramLink with the mofId from persistence
     * 
     * @param mofId MofId of the diagramLink that should be loaded
     * @return DiagramLink with the mofId
     * @throws ModelNotFoundException when the diagramLink wasn't found on
     * persistence
     */
    protected DiagramLink getDiagramLinkByMofId( ) throws ModelNotFoundException {

        graphicsPackage = (GraphicsPackage) repository.selectRefPackage( GRAPHICS_CONTAINER_NAME, "graphics" );
        Collection diagramLinkCollection = graphicsPackage.getLinks( ).getDiagramLink( ).refAllOfClass( );
        Link ldiagramlink = null;
        if ( diagramLinkCollection != null ) {
            for ( Iterator iter = diagramLinkCollection.iterator( ); iter.hasNext( ); ) {
                ldiagramlink = (Link) iter.next( );

                if ( ldiagramlink instanceof DiagramLink && ldiagramlink != null ) {
                    if ( ( (String) mapOfElements.get( "diagramLink" ) ).equals( ldiagramlink.refMofId( ) ) ) {
                        return (DiagramLink) ldiagramlink;
                    }
                }
            }
        }
        if ( ldiagramlink == null ) {
            throw new ModelNotFoundException( "diagramLink", (String) mapOfElements.get( "diagram" ) );
        }

        return null;
    }

    /**
     * Returns the mofPackage with the mofId from persistence
     * 
     * @param mofId MofId of the mofPackage that should be loaded
     * @return MofPackage with the mofId
     * @throws ModelNotFoundException when the mofPackage wasn't found on
     * persistence
     */
    protected MofPackage getMofPackageByMofId( ) throws ModelNotFoundException {

        modelPackage = (ModelPackage) repository.selectRefPackage( null, "Model" );
        Collection mofPackageCollection = modelPackage.getMofPackage( ).refAllOfClass( );
        ModelElement lmodelelement = null;
        if ( mofPackageCollection != null ) {
            for ( Iterator iter = mofPackageCollection.iterator( ); iter.hasNext( ); ) {
                lmodelelement = (MofPackage) iter.next( );

                if ( lmodelelement instanceof MofPackage && lmodelelement != null ) {
                    if ( ( (String) mapOfElements.get( "mofPackage" ) ).equals( lmodelelement.refMofId( ) ) ) {
                        return (MofPackage) lmodelelement;
                    }
                }
            }
        }
        if ( lmodelelement == null ) {
            throw new ModelNotFoundException( "mofClass", (String) mapOfElements.get( "diagram" ) );
        }
        return null;
    }
}
