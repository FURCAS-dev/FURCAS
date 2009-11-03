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

import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.pictograms.Diagram;

/**
 * Utility class for the test of the infrastrucutre by using a pictograms model.
 * For an overview about a proposed course which has to be implemented in a test
 * method of the test environment see {@link GraphicsTestsUtil}.<br>
 * <br>
 * For the model manipulation, the methods of {@link GraphicsModelManipulation}
 * are used and for the communication with the infrastructure those of the
 * implementation of {@link RepositoryFacade}.
 * 
 * @author d043982
 */
public class PictogramsTestsUtil extends GraphicsTestsUtil {

    /**
     * @param repositoryImpl Implementation of RepositoryFacade with the methods
     * for the used infrastructure
     * @throws FileNotFoundException when the reference model wasn't found
     * @throws IOException
     */
    public PictogramsTestsUtil( RepositoryFacade repositoryImpl ) throws FileNotFoundException, IOException {

        super( repositoryImpl );
    }

    private Diagram diagram = null;

    @Override
    public Collection getRootElements( ) {

        ArrayList re = new ArrayList( );
        re.add( diagram );
        return re;
    }

    /**
     * Calls the method
     * {@link GraphicsModelManipulation#createPictogramsModel(GraphicsPackage, Map)}
     * to create a model containing a diagram. The MofIds of all elements in the
     * model are stored in mapOfElements. Then the model is persisted. <br>
     * <br>
     * <b><u>Structure</u></b>
     * 
     * <pre> 
     * Diagram
     * |-ContainerShape 2
     * |   |-Shape 2 (visible = false)
     * |   |    -Text 2 (value = "This is the text of Shape 2")
     * |   |        -Color 1 (100, 50, 0)
     * |   |-ContainerShape 3
     * |   |   |-Rectangle
     * |   |    -Anchor 3
     * |   |-Polyline
     * |   |   |-Size
     * |   |   |-Location
     * |   |   |-Color 2
     * |   |   |-Point 1 (1, 1)
     * |   |   |-Point 2 (4, 2)
     * |   |    -Point 3 (4, 10)
     * |    -Anchor 2
     * |-Shape 1
     * |    -Text 1 ("This is the text of Shape 1")
     * |-Shape 3
     * |-Connection 23 (Anchor 2 to Anchor 3)
     *  -Connection 22 (Anchor 2 to Anchor 2)
     * </pre>
     * 
     * @throws RepositoryException
     */
    @Override
    public void createModel( ) throws RepositoryException {

        repository.getConnection( );
        graphicsPackage = (GraphicsPackage) repository.selectRefPackage( GRAPHICS_CONTAINER_NAME, "graphics" );
        if ( graphicsPackage == null ) {
            throw new RuntimeException( "Graphics package is null" );
        }
        // creating the model
        mapOfElements = new HashMap( );
        diagram = GraphicsModelManipulation.createPictogramsModel( graphicsPackage, mapOfElements );

        repository.save( );
    }

    @Override
    public void modifyModel( ) throws RepositoryException {

        GraphicsModelManipulation.modifyPictogramsModel( graphicsPackage, diagram, mapOfElements );

        repository.save( );
    }

    @Override
    public ArrayList checkModifiedModel( ) throws RepositoryException {

        List listOfDifferences = new ArrayList( );

        if ( diagram != null ) {

            // Check step 1
            GraphicsModelManipulation.checkModificationInDiagramStep1( diagram, listOfDifferences, mapOfElements );
            GraphicsModelManipulation.checkIfShape1AndText1AreInExtend( graphicsPackage, mapOfElements, listOfDifferences );

            // Check step 2
            GraphicsModelManipulation.checkModificationInDiagramStep2( diagram, listOfDifferences, mapOfElements );

            // Check step 3
            GraphicsModelManipulation.checkModificationInDiagramStep3( diagram, listOfDifferences, mapOfElements );
            GraphicsModelManipulation.checkIfColor1IsInExtend( graphicsPackage, mapOfElements, listOfDifferences );

            // Check step 4
            GraphicsModelManipulation.checkModificationInDiagramStep4( diagram, listOfDifferences, mapOfElements );

            // Check step 5
            GraphicsModelManipulation.checkModificationInDiagramStep5( diagram, listOfDifferences, mapOfElements );
            GraphicsModelManipulation.checkIfPoint3IsInExtend( graphicsPackage, mapOfElements, listOfDifferences );

            // Check step 6 & 7
            GraphicsModelManipulation.checkModificationInDiagramStep6And7( diagram, listOfDifferences, mapOfElements );

            // Check step 8
            GraphicsModelManipulation.checkModificationInDiagramStep8( diagram, listOfDifferences, mapOfElements );
            GraphicsModelManipulation.checkIfOldRectangleIsInExtend( graphicsPackage, mapOfElements, listOfDifferences );

            // Check step 9
            GraphicsModelManipulation.checkModificationInDiagramStep9( diagram, listOfDifferences, mapOfElements );
            GraphicsModelManipulation.checkIfConnection22IsInExtend( graphicsPackage, mapOfElements, listOfDifferences );

            // Check step 10
            GraphicsModelManipulation.checkModificationInDiagramStep10( diagram, listOfDifferences, mapOfElements );

        }

        return (ArrayList) listOfDifferences;
    }

    @Override
    public void loadModel( ) throws RepositoryException, ModelNotFoundException {

        repository.getConnection( );

        // loading the model from persistence
        diagram = getDiagramByMofId( );
    }

    @Override
    public void deleteModelAndCloseConnection( ) throws RepositoryException, ModelNotFoundException {

        repository.getConnection( );

        if ( (String) mapOfElements.get( "diagram" ) != null ) {
            diagram = getDiagramByMofId( );

            if ( diagram != null ) {
                diagram.refDelete( );
                repository.save( );
                diagram = null;
            }
        }
        graphicsPackage = null;
        repository.closeConnection( );
    }

    @Override
    public void closeConnection( ) throws RepositoryException {

        diagram = null;
        graphicsPackage = null;
        repository.closeConnection( );
    }

}