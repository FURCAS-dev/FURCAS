/*
 * Created on 30.01.2006
 */
package com.sap.tc.moin.repository.test.graphicsfw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.Test;

import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.links.DiagramLink;
import com.sap.moin.mm.gfw.pictograms.Diagram;

/**
 * Utility class for the test of the infrastrucutre by using a model with a link
 * between two metamodels. For an overview about a proposed course which has to
 * be implemented in a test method of the test environment see
 * {@link GraphicsTestsUtil}.<br>
 * <br>
 * For the model manipulation, the methods of {@link GraphicsModelManipulation}
 * are used and for the communication with the infrastructure those of the
 * implementation of {@link RepositoryFacade}.
 * 
 * @author d043982
 */
public class LinkTestsUtil extends GraphicsTestsUtil {

    private Diagram diagram = null;

    private DiagramLink diagramLink = null;

    private MofPackage mofPackage = null;

    /**
     * @param repositoryImpl Implementation of RepositoryFacade with the methods
     * for the used infrastructure
     * @param uriReferenceModel Filename of the reference model for the
     * comparison of the created and saved model. The model must exist in
     * "com/sap/tc/moin/repository/test/graphicsfw/"
     * @throws FileNotFoundException when the reference model wasn't found
     * @throws IOException
     */
    public LinkTestsUtil( RepositoryFacade repositoryImpl ) throws FileNotFoundException, IOException {

        super( repositoryImpl );
    }

    /**
     * Calls the method
     * {@link GraphicsModelManipulation#createLinkModel(GraphicsPackage, ModelPackage, Map)}
     * to create a model with a diagram, a diagramLink and a mofPackage. The
     * MofIds of all elements in the model are stored in mapOfElements. Then the
     * model is persisted. <br>
     * <br>
     * <b><u>Structure</u></b>
     * 
     * <pre>
     * Diagram
     * Shape 1          Shape 2
     *         \
     *          \
     * DiagramLink
     *         PictogramLink
     *          /
     *         /
     * MofClass 1       MofClass 2
     * MofPackage
     * </pre>
     * 
     * @throws RepositoryException
     */
    @Override
    public void createModel( ) throws RepositoryException {

        repository.getConnection( );
        graphicsPackage = (GraphicsPackage) repository.selectRefPackage( GRAPHICS_CONTAINER_NAME, "graphics" );
        modelPackage = (ModelPackage) repository.selectRefPackage( null, "Model" );

        // create the model
        mapOfElements = new HashMap( );
        HashMap mapOfRootElements = GraphicsModelManipulation.createLinkModel( graphicsPackage, modelPackage, mapOfElements );

        diagram = (Diagram) mapOfRootElements.get( "diagram" );
        diagramLink = (DiagramLink) mapOfRootElements.get( "diagramLink" );
        mofPackage = (MofPackage) mapOfRootElements.get( "mofPackage" );

        mapOfRootElements.clear( );
        mapOfRootElements = null;

        repository.save( );
    }

    public boolean testLinkOverAssociation( ) {

        Diagram d1 = diagramLink.getDiagram( );
        Diagram d2 = graphicsPackage.getLinks( ).getDiagramLinkReferencesDiagram( ).getDiagram( diagramLink );
        DiagramLink dl = graphicsPackage.getLinks( ).getDiagramLinkReferencesDiagram( ).getLink( diagram );
        if ( !diagramLink.equals( dl ) ) {
            return false;
        }
        return true;
    }

    @Override
    public void closeConnection( ) throws RepositoryException {

        diagram = null;
        diagramLink = null;
        mofPackage = null;
        graphicsPackage = null;
        modelPackage = null;
        repository.closeConnection( );
    }

    @Override
    public void modifyModel( ) throws RepositoryException {

        GraphicsModelManipulation.modifyLinkModel( diagram, diagramLink, mofPackage, mapOfElements );
        repository.save( );
    }

    @Override
    public ArrayList checkModifiedModel( ) {

        List listOfDifferences = new ArrayList( );

        // Check step 1
        GraphicsModelManipulation.checkModificationInLinkModelStep1( diagram, diagramLink, listOfDifferences, mapOfElements );

        // Check step 2
        GraphicsModelManipulation.checkModificationInLinkModelStep2( diagramLink, mofPackage, listOfDifferences, mapOfElements );

        return (ArrayList) listOfDifferences;
    }

    @Test
    public void testLinkProperty( ) {

        GraphicsModelManipulation.createLinkProperty( graphicsPackage, diagramLink );
    }

    @Override
    public Collection getRootElements( ) {

        ArrayList re = new ArrayList( );
        re.add( diagram );
        re.add( diagramLink );
        re.add( mofPackage );

        return re;
    }

    @Override
    public void loadModel( ) throws RepositoryException, ModelNotFoundException {

        repository.getConnection( );

        diagram = getDiagramByMofId( );
        diagramLink = getDiagramLinkByMofId( );
        mofPackage = getMofPackageByMofId( );
    }

    @Override
    public void deleteModelAndCloseConnection( ) throws RepositoryException, ModelNotFoundException {

        repository.getConnection( );

        if ( (String) mapOfElements.get( "diagram" ) != null ) {
            diagram = getDiagramByMofId( );
        }

        if ( (String) mapOfElements.get( "diagramLink" ) != null ) {
            diagramLink = getDiagramLinkByMofId( );
        }

        if ( (String) mapOfElements.get( "mofPackage" ) != null ) {
            mofPackage = getMofPackageByMofId( );
        }

        if ( diagram != null ) {
            diagram.refDelete( );
        }

        if ( diagramLink != null ) {
            diagramLink.refDelete( );
        }

        if ( mofPackage != null ) {
            mofPackage.refDelete( );
        }

        repository.save( );
        diagram = null;
        diagramLink = null;
        mofPackage = null;

        graphicsPackage = null;
        repository.closeConnection( );
    }

}
