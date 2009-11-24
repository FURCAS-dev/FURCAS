package com.sap.tc.moin.repository.test.graphicsfw;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.moin.mm.gfw.datatypes.Color;
import com.sap.moin.mm.gfw.datatypes.Dimension;
import com.sap.moin.mm.gfw.datatypes.Point;
import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.links.DiagramLink;
import com.sap.moin.mm.gfw.links.Link;
import com.sap.moin.mm.gfw.links.PictogramLink;
import com.sap.moin.mm.gfw.pictograms.ChopboxAnchor;
import com.sap.moin.mm.gfw.pictograms.Connection;
import com.sap.moin.mm.gfw.pictograms.ContainerShape;
import com.sap.moin.mm.gfw.pictograms.Diagram;
import com.sap.moin.mm.gfw.pictograms.GraphicsAlgorithm;
import com.sap.moin.mm.gfw.pictograms.HorizontalConnection;
import com.sap.moin.mm.gfw.pictograms.PictogramElement;
import com.sap.moin.mm.gfw.pictograms.Polyline;
import com.sap.moin.mm.gfw.pictograms.Property;
import com.sap.moin.mm.gfw.pictograms.Rectangle;
import com.sap.moin.mm.gfw.pictograms.Shape;
import com.sap.moin.mm.gfw.pictograms.Text;
import com.sap.tc.moin.repository.Partitionable;

/**
 * Contains mehtods for the generation and modification of a Pictograms diagram
 * and a model with a link between a Pictograms diagram and a MOF Package
 * according to the documentation "TestGraphicsFramework.doc" for the JUnit
 * tests "TestPictogramModelCreationAndModification" and
 * "TestLinkModelCreationAndModification". This class also contains methods to
 * check if the modifications are done correctly.
 * 
 * @author d043982
 */
public class GraphicsModelManipulation {

    /**
     * Creates programatically a pictograms model according to the documentation "
     * TestGraphicsFramework.doc" of the JUnit test
     * "TestPictogramModelCreationAndModification". <br>
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
     * @param graphicsPackage Graphics package with the graphics model
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test containing the MofId
     * @return The diagram with the created model
     */

    public static Diagram createPictogramsModel( GraphicsPackage graphicsPackage, Map mapOfElements ) {

        com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );

        // create a diagram
        Diagram myDiagram = (Diagram) graphicsPackage.getPictograms( ).getDiagram( ).refCreateInstance( );
        mapOfElements.put( "diagram", myDiagram.refMofId( ) );

        // Create ContainerShape 2 and add it to Diagram
        ContainerShape myContainerShape2 = (ContainerShape) graphicsPackage.getPictograms( ).getContainerShape( ).refCreateInstance( );
        mapOfElements.put( "containerShape2", myContainerShape2.refMofId( ) );
        myDiagram.getChildren( ).add( myContainerShape2 );

        // Add Shape 2 to ContainerShape 2
        Shape myShape2 = (Shape) graphicsPackage.getPictograms( ).getShape( ).refCreateInstance( );
        mapOfElements.put( "shape2", myShape2.refMofId( ) );
        myContainerShape2.getChildren( ).add( myShape2 );

        // Add Text 2 to Shape 2
        Text myText2 = (Text) graphicsPackage.getPictograms( ).getText( ).refCreateInstance( );
        mapOfElements.put( "text2", myText2.refMofId( ) );
        myShape2.setGraphicsAlgorithm( myText2 );
        myText2.setValue( "This is the text of Shape 2" );

        // Add Color 1 to Text 2 as background color
        Color myColor1 = (Color) graphicsPackage.getDatatypes( ).getColor( ).refCreateInstance( );
        myColor1.setRed( 100 );
        myColor1.setGreen( 50 );
        mapOfElements.put( "color1", myColor1.refMofId( ) );
        myText2.setBackground( myColor1 );

        // Add ContainerShape 3 to ContainerShape 2
        ContainerShape myContainerShape3 = (ContainerShape) graphicsPackage.getPictograms( ).getContainerShape( ).refCreateInstance( );
        mapOfElements.put( "containerShape3", myContainerShape3.refMofId( ) );
        myContainerShape2.getChildren( ).add( myContainerShape3 );

        // Add Rectangle to ContainerShape 3
        Rectangle myRectangle = (Rectangle) graphicsPackage.getPictograms( ).getRectangle( ).refCreateInstance( );
        mapOfElements.put( "rectangle", myRectangle.refMofId( ) );
        myContainerShape3.setGraphicsAlgorithm( myRectangle );

        // Add Anchor 3 to Containershape 3
        ChopboxAnchor myAnchor3 = (ChopboxAnchor) graphicsPackage.getPictograms( ).getChopboxAnchor( ).refCreateInstance( );
        mapOfElements.put( "anchor3", myAnchor3.refMofId( ) );
        myContainerShape3.getAnchors( ).add( myAnchor3 );

        /*
         * Add Polyline to ContainerShape 3 with a size, a location, a color as
         * background color and three points
         */
        Polyline myPolyline = (Polyline) graphicsPackage.getPictograms( ).getPolyline( ).refCreateInstance( );
        mapOfElements.put( "polyline", myPolyline.refMofId( ) );

        Dimension mySize = (Dimension) graphicsPackage.getDatatypes( ).getDimension( ).refCreateInstance( );
        mySize.setWidth( 10 );
        mySize.setHeight( 12 );
        mapOfElements.put( "size", mySize.refMofId( ) );
        Point myLocation = conn.createElementInPartition( Point.class, null );
        mapOfElements.put( "location", myLocation.refMofId( ) );
        Color myColor2 = conn.createElementInPartition( Color.class, null );
        mapOfElements.put( "color2", myColor2.refMofId( ) );

        myPolyline.setSize( mySize );
        myPolyline.setLocation( myLocation );
        myPolyline.setBackground( myColor2 );

        Point myPoint1 = conn.createElementInPartition( Point.class, null );
        mapOfElements.put( "point1", myPoint1.refMofId( ) );
        Point myPoint2 = conn.createElementInPartition( Point.class, null );
        mapOfElements.put( "point2", myPoint2.refMofId( ) );
        Point myPoint3 = conn.createElementInPartition( Point.class, null );
        mapOfElements.put( "point3", myPoint3.refMofId( ) );

        myPolyline.getPoints( ).add( myPoint1 );
        myPolyline.getPoints( ).add( myPoint2 );
        myPolyline.getPoints( ).add( myPoint3 );

        myContainerShape2.setGraphicsAlgorithm( myPolyline );

        // Add Anchor 2 to ContainerShape 2
        ChopboxAnchor myAnchor2 = conn.createElementInPartition( ChopboxAnchor.class, null );
        mapOfElements.put( "anchor2", myAnchor2.refMofId( ) );
        myContainerShape2.getAnchors( ).add( myAnchor2 );

        // Add Shape 1 to Diagram
        Shape myShape1 = conn.createElementInPartition( Shape.class, null );
        mapOfElements.put( "shape1", myShape1.refMofId( ) );
        myDiagram.getChildren( ).add( myShape1 );

        // Add Text 1 to Shape 1
        Text myText1 = conn.createElementInPartition( Text.class, null );
        mapOfElements.put( "text1", myText1.refMofId( ) );
        myShape1.setGraphicsAlgorithm( myText1 );
        myText1.setValue( "This is the text of Shape 1" );

        // Add Shape 3 to Diagram
        Shape myShape3 = conn.createElementInPartition( Shape.class, null );
        mapOfElements.put( "shape3", myShape3.refMofId( ) );
        myDiagram.getChildren( ).add( myShape3 );

        // Create Connection 23
        HorizontalConnection myConnection23 = conn.createElementInPartition( HorizontalConnection.class, null );
        mapOfElements.put( "connection23", myConnection23.refMofId( ) );
        myConnection23.setStart( myAnchor2 );
        myConnection23.setEnd( myAnchor3 );
        myDiagram.getConnections( ).add( myConnection23 );

        // Create Connection 22
        HorizontalConnection myConnection22 = conn.createElementInPartition( HorizontalConnection.class, null );
        mapOfElements.put( "connection22", myConnection22.refMofId( ) );
        myConnection22.setStart( myAnchor2 );
        myConnection22.setEnd( myAnchor2 );
        myDiagram.getConnections( ).add( myConnection22 );

        return myDiagram;

    }

    /**
     * Calls modifyPictogramsModelStep1 to 10 to modify the diagram created with
     * createPictogramsModel according to the reference dokument
     * "TestGraphicsModel.doc".<br>
     * <ul>
     * <li>Step 1: Delete Shape 1</li>
     * <li>Step 2: Set value of Text 2 to null</li>
     * <li>Step 3: Override Color 1 with a new Color object. The new color is
     * registered in the mapOfElements with the key "newColor1"</li>
     * <li>Step 4: Set visibility of Shape 2 to true</li>
     * <li>Step 5: Delete Point 3 and add Point 4 to the Polyline Point 4 is
     * registered in the mapOfElements with the key "point4"</li>
     * <li>Step 6: Remove Shape 3 from Diagram and add it to ContainerShape 3
     * by using Shape3.setContainer()</li>
     * <li>Step 7: Remove ContainerShape 3 from ContainerShape 2 and add it to
     * Diagram by using Diagram.getChildren().add(ContainerShape 3)</li>
     * <li>Step 8: Replace Rectangle by a new Rectangle object. The new
     * rectangle is registered in the mapOfElements with the key "newRectangle"</li>
     * <li>Step 9: Remove Connection 22</li>
     * <li>Step 10: Set the beginning of Connection 23 from Anchor 2 to Anchor
     * 3</li>
     * </ul>
     * <br>
     * <br>
     * <b><u>Structure after modifying</u></b>
     * 
     * <pre>
     * Diagram
     * |-ContainerShape 2
     * |   |-Shape 2 (visible = true)
     * |   |    -Text 2 (value = null)
     * |   |        -Color 1 (new Color(10, 5, 30))
     * |   |-Polyline
     * |   |   |-Size
     * |   |   |-Location
     * |   |   |-Color 2
     * |   |   |-Point 1 (1, 1)
     * |   |   |-Point 2 (4, 2)
     * |   |    -Point 4 (47, 11)
     * |    -Anchor 2
     * |-ContainerShape 3
     * |   |-Rectangle (new Rectangele())
     * |   |-Shape 3
     * |    -Anchor 3
     *  -Connection 23 (Anchor 3 to Anchor 3)
     * </pre>
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With this.createPictogramsModel(...) created model that
     * should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test containing the MofId
     */
    public static void modifyPictogramsModel( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        modifyPictogramsModelStep1( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep2( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep3( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep4( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep5( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep6( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep7( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep8( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep9( graphicsPackage, diagram, mapOfElements );
        modifyPictogramsModelStep10( graphicsPackage, diagram, mapOfElements );
    }

    /**
     * Step 1: Delete Shape 1
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep1( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator = diagramChildren.iterator( ); iterator.hasNext( ); ) {
            PictogramElement shape1Wanted = (PictogramElement) iterator.next( );
            // get the Shape 1 out of the Diagram and delete it
            if ( shape1Wanted.refMofId( ).equals( mapOfElements.get( "shape1" ) ) ) {
                shape1Wanted.refDelete( );
                return;
            }
        }
    }

    /**
     * Step 2: Set value of Text 2 to null
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep2( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );

            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                for ( Iterator iterator2 = containerShape2Children.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement shape2OrContainerShape3Wanted = (PictogramElement) iterator2.next( );
                    // get Shape 2 out of the ContainerShape 2
                    if ( shape2OrContainerShape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape2" ) ) ) {
                        GraphicsAlgorithm text2wanted = shape2OrContainerShape3Wanted.getGraphicsAlgorithm( );
                        // Step 2: Set value of Text 2 to null
                        if ( text2wanted.refMofId( ).equals( (String) mapOfElements.get( "text2" ) ) ) {
                            ( (Text) text2wanted ).setValue( null );
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * Step 3: Override Color 1 with a new Color object. The new color is
     * registered in the mapOfElements with the key "newColor1"
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep3( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );

            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                for ( Iterator iterator2 = containerShape2Children.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement shape2Wanted = (PictogramElement) iterator2.next( );
                    // get Shape 2 out of the ContainerShape 2
                    if ( shape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape2" ) ) ) {
                        GraphicsAlgorithm text2wanted = shape2Wanted.getGraphicsAlgorithm( );
                        // get Text2
                        if ( text2wanted.refMofId( ).equals( (String) mapOfElements.get( "text2" ) ) ) {
                            // Step 3: Override Color 1 with a new Color object
                            com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );
                            Color myColor1 = conn.createElementInPartition( Color.class, null );
                            // Delete old color
                            ( (Text) text2wanted ).getBackground( ).refDelete( );
                            // Set new color
                            ( (Text) text2wanted ).setBackground( myColor1 );
                            mapOfElements.put( "newColor1", myColor1.refMofId( ) );
                            return;
                        }
                    }
                }
            }
        }
    }


    /**
     * Step 4: Set visibility of Shape 2 to true
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep4( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );

            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                for ( Iterator iterator2 = containerShape2Children.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement shape2Wanted = (PictogramElement) iterator2.next( );
                    // get Shape 2 out of the ContainerShape 2
                    if ( shape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape2" ) ) ) {
                        // Step 4: Set visibility of Shape 2 to true
                        shape2Wanted.setVisible( true );
                        return;
                    }
                }
            }
        }
    }

    /**
     * Step 5: Delete Point 3 and add Point 4 to the Polyline Point 4 is
     * registered in the mapOfElements with the key "point4"
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep5( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );

            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                // Get Polyline from ContainerShape 2
                GraphicsAlgorithm polylineWanted = containerShape2Wanted.getGraphicsAlgorithm( );
                if ( polylineWanted.refMofId( ).equals( (String) mapOfElements.get( "polyline" ) ) ) {
                    List polylinePoints = ( (Polyline) polylineWanted ).getPoints( );
                    for ( Iterator iterator3 = polylinePoints.iterator( ); iterator3.hasNext( ); ) {
                        Point point3Wanted = (Point) iterator3.next( );
                        // Get Point 3
                        if ( point3Wanted.refMofId( ).equals( (String) mapOfElements.get( "point3" ) ) ) {
                            // Step 5: Delete Point 3 to the Polyline and
                            // add Point 4
                            point3Wanted.refDelete( );
                            com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );
                            Point myPoint4 = conn.createElementInPartition( Point.class, null );
                            mapOfElements.put( "point4", myPoint4.refMofId( ) );
                            polylinePoints.add( myPoint4 );
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * Step 6: Remove Shape 3 from Diagram and add it to ContainerShape 3 by
     * using Shape3.setContainer()
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep6( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement shape3Wanted = (PictogramElement) iterator1.next( );
            // get the Shape 3
            if ( shape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape3" ) ) ) {
                // when Shape 3 is found, go on and get ContainerShape 2
                for ( Iterator iterator2 = diagramChildren.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement containerShape2Wanted = (PictogramElement) iterator2.next( );
                    if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                        List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );
                        // get ContainerShape3
                        for ( Iterator iterator3 = containerShape2Children.iterator( ); iterator3.hasNext( ); ) {
                            PictogramElement containerShape3Wanted = (PictogramElement) iterator3.next( );
                            // Step 6: Remove Shape 3 from Diagram and add it to ContainerShape 3 by 
                            // using Shape3.setContainer()                            
                            if ( containerShape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape3" ) ) ) {
                                ( (Shape) shape3Wanted ).setContainer( (ContainerShape) containerShape3Wanted );
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Step 7: Remove ContainerShape 3 from ContainerShape 2 and add it to
     * Diagram by using Diagram.getChildren().add(ContainerShape 3)
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep7( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        ContainerShape containerShape2 = (ContainerShape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "containerShape2" ), diagram.getChildren( ) );
        if ( containerShape2 != null ) {

            ContainerShape containerShape3 = (ContainerShape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "containerShape3" ), containerShape2.getChildren( ) );

            /*
             * Step 7: Remove ContainerShape 3 from ContainerShape 2 and add it
             * to Diagram by using Diagram.getChildren().add(ContainerShape 3)
             */
            containerShape3.setContainer( diagram );
            // This dont work
            // diagram.getChildren().add(containerShape3);
            return;
        }
    }

    /**
     * Step 8: Replace Rectangle by a new Rectangle object. The new rectangle is
     * registered in the mapOfElements with the key "newRectangle"
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep8( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        List diagramChildren;
        diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape3Wanted = (PictogramElement) iterator1.next( );

            // get ContainerShape 3
            if ( containerShape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape3" ) ) ) {
                com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );
                Rectangle myRectangle = conn.createElementInPartition( Rectangle.class, null );
                mapOfElements.put( "newRectangle", myRectangle.refMofId( ) );
                // delete old Rectangle
                ( (ContainerShape) containerShape3Wanted ).getGraphicsAlgorithm( ).refDelete( );
                // set new Rectangle
                ( (ContainerShape) containerShape3Wanted ).setGraphicsAlgorithm( myRectangle );
                return;
            }
        }
    }

    /**
     * Step 9: Remove Connection 22
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep9( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        Collection diagramConnections = diagram.getConnections( );
        for ( Iterator iterator1 = diagramConnections.iterator( ); iterator1.hasNext( ); ) {
            HorizontalConnection connection22Wanted = (HorizontalConnection) iterator1.next( );

            //get Connection 22
            if ( connection22Wanted.refMofId( ).equals( (String) mapOfElements.get( "connection22" ) ) ) {
                if ( connection22Wanted.getEnd( ).equals( connection22Wanted.getStart( ) ) ) {
                    // Step 10: Remove Connection 22
                    connection22Wanted.refDelete( );
                    return;
                }
            }
        }
    }

    /**
     * Step 10: Set the beginning of Connection 23 from Anchor 2 to Anchor 3
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created model that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    private static void modifyPictogramsModelStep10( GraphicsPackage graphicsPackage, Diagram diagram, Map mapOfElements ) {

        Collection diagramConnections = diagram.getConnections( );
        for ( Iterator iterator1 = diagramConnections.iterator( ); iterator1.hasNext( ); ) {
            HorizontalConnection connection23Wanted = (HorizontalConnection) iterator1.next( );

            //get Connection 23
            if ( connection23Wanted.refMofId( ).equals( (String) mapOfElements.get( "connection23" ) ) ) {
                // if Connection 23 is found, get Anchor 3 out of ContainerShape 3
                List diagramChildren;
                diagramChildren = diagram.getChildren( );

                for ( Iterator iterator2 = diagramChildren.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement containerShape3Wanted = (PictogramElement) iterator2.next( );
                    // get ContainerShape 3
                    if ( containerShape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape3" ) ) ) {

                        Collection containerShape3Anchors = ( (ContainerShape) containerShape3Wanted ).getAnchors( );

                        for ( Iterator iterator3 = containerShape3Anchors.iterator( ); iterator3.hasNext( ); ) {
                            ChopboxAnchor anchor3Wanted = (ChopboxAnchor) iterator3.next( );
                            // get Anchor 3 
                            if ( anchor3Wanted.refMofId( ).equals( (String) mapOfElements.get( "anchor3" ) ) ) {
                                connection23Wanted.setStart( anchor3Wanted );
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Test of step 1 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Shape 1 is really deleted in the diagram
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep1( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement shape1Wanted = (PictogramElement) iterator1.next( );
            if ( shape1Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape1" ) ) ) {
                listOfDifferences.add( "\r\nStep 1: Shape 1 still exists in diagram" );
                return;
            }
        }
    }

    /**
     * Test of step 2 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * the value of Text 2 is really null
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep2( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                for ( Iterator iterator2 = containerShape2Children.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement shape2Wanted = (PictogramElement) iterator2.next( );
                    // get Shape 2
                    if ( shape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape2" ) ) ) {
                        // get value of Text 2
                        if ( ( (Text) shape2Wanted.getGraphicsAlgorithm( ) ).getValue( ) != null ) {
                            listOfDifferences.add( "\r\nStep 2: Value of Text 2 is not null" );
                        }
                        return;
                    }
                }
                listOfDifferences.add( "\r\nStep 2: ContainerShape 2 has no children or Shape 2 is no child of ContainerShape 2" );
                return;
            }
        }
        listOfDifferences.add( "\r\nStep 2: Diagram has no children or ContainerShape 2 is no child of Diagram" );
    }

    /**
     * Test of step 3 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Check if
     * the color of Text 2 is the new one
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep3( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                for ( Iterator iterator2 = containerShape2Children.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement shape2Wanted = (PictogramElement) iterator2.next( );
                    // get Shape 2
                    if ( shape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape2" ) ) ) {
                        // get Text 2
                        Text text2wanted = (Text) shape2Wanted.getGraphicsAlgorithm( );
                        if ( text2wanted.refMofId( ).equals( (String) mapOfElements.get( "text2" ) ) ) {
                            if ( !text2wanted.getBackground( ).refMofId( ).equals( (String) mapOfElements.get( "newColor1" ) ) ) {
                                if ( text2wanted.getBackground( ).refMofId( ).equals( (String) mapOfElements.get( "color1" ) ) ) {
                                    listOfDifferences.add( "\r\nStep 3: The background color of Text 2 is not the new one but still the initial one" );
                                } else {
                                    listOfDifferences.add( "\r\nStep 3: The background color of Text 2 is not the new one but another one" );
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        listOfDifferences.add( "\r\nStep 3: GraphicsAlgorithm of Shape 2 is not Text 2" );
                        return;
                    }
                }
                listOfDifferences.add( "\r\nStep 3: ContainerShape 2 has no children or Shape 2 is no child of ContainerShape 2" );
                return;
            }
        }
        listOfDifferences.add( "\r\nStep 3: Diagram has no children or ContainerShape 2 is no child of Diagram" );
    }

    /**
     * Test of step 4 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * "visible" of Shape 2 is true
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep4( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                List containerShape2Children = ( (ContainerShape) containerShape2Wanted ).getChildren( );

                for ( Iterator iterator2 = containerShape2Children.iterator( ); iterator2.hasNext( ); ) {
                    PictogramElement shape2Wanted = (PictogramElement) iterator2.next( );
                    // get Shape 2
                    if ( shape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "shape2" ) ) ) {
                        // get value of 'visible' of Shape 2
                        if ( !shape2Wanted.isVisible( ) ) {
                            listOfDifferences.add( "\r\nStep 4: 'Visible' of Shape 2 is not 'true' but still 'false'" );
                        }
                        return;
                    }
                }
                listOfDifferences.add( "\r\nStep 4: ContainerShape 2 has no children or Shape 2 is no child of ContainerShape 2" );
                return;
            }
        }
        listOfDifferences.add( "\r\nStep 4: Diagram has no children or ContainerShape 2 is no child of Diagram" );
    }

    /**
     * Test of step 5 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Point 4 is part of Polyline and Point 3 isn't anymore
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep5( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                // get Polyline
                Polyline polylineWanted = (Polyline) containerShape2Wanted.getGraphicsAlgorithm( );
                if ( polylineWanted.refMofId( ).equals( (String) mapOfElements.get( "polyline" ) ) ) {
                    List points = polylineWanted.getPoints( );
                    // get Point 4 and seach if Point 3 is still there
                    boolean point4Exists = false;
                    for ( Iterator iterator2 = points.iterator( ); iterator2.hasNext( ); ) {
                        Point point4Wanted = (Point) iterator2.next( );
                        if ( point4Wanted.refMofId( ).equals( (String) mapOfElements.get( "point3" ) ) ) {
                            listOfDifferences.add( "\r\nStep 5: Point 3 still exists in Polyline" );
                        } else if ( point4Wanted.refMofId( ).equals( (String) mapOfElements.get( "point4" ) ) ) {
                            point4Exists = true;
                        }
                    }
                    if ( !point4Exists ) {
                        listOfDifferences.add( "\r\nStep 5: Point 4 doesn't exist in Polyline or Polyline doesn't even have Points" );
                    }
                    return;
                }
                listOfDifferences.add( "\r\nStep 5: GraphicsAlgorithm of ContainerShape 2 is not Polyline" );
                return;
            }
        }
        listOfDifferences.add( "\r\nStep 5: Diagram has no children or ContainerShape 2 is no child of Diagram" );
    }

    /**
     * Test of steps 6&7 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Shape 3 isn't child of Diagram anymore but is child of ContainerShape 3
     * and if ContainerShape 3 is child of Diagram and not child of
     * ContainerShape 2 anymore
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep6And7( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );
        boolean containerShape2Found = false;

        // Check if Shape 3 is still child of Diagram
        Shape _S3 = (Shape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "shape3" ), diagram.getChildren( ) );
        if ( _S3 != null ) {
            listOfDifferences.add( "\r\nStep 6&7: Shape 3 is still a child of Diagram" );
            return;
        }

        // Check Container Shape 3 is not a children of Container Shape 2
        // Find Container Shape 3 as child of Diagram
        ContainerShape _CS2 = (ContainerShape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "containerShape2" ), diagram.getChildren( ) );
        if ( _CS2 == null ) {
            listOfDifferences.add( "\r\nStep 6&7: Container Shape 2 is not a child of Diagram" );
            return;
        }
        ContainerShape _CS3 = (ContainerShape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "containerShape3" ), _CS2.getChildren( ) );
        if ( _CS3 != null ) {
            listOfDifferences.add( "\r\nStep 6&7: Container Shape 3 is still a child of Container Shape 2" );
            return;
        }



        // Find Container Shape 3 as child of Diagram
        _CS3 = (ContainerShape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "containerShape3" ), diagram.getChildren( ) );
        if ( _CS3 == null ) {
            listOfDifferences.add( "\r\nStep 6&7: Container Shape 3 is not a child of Diagram" );
            return;
        }



        // Find Shape 3 as child of Container Shape 3
        _S3 = (Shape) getRefObjectByMofIdFromCollection( (String) mapOfElements.get( "shape3" ), _CS3.getChildren( ) );
        if ( _S3 == null ) {
            listOfDifferences.add( "\r\nStep 6&7: Shape 3 is not a child of Container Shape 3" );
            return;
        }
        return;

    }

    protected static RefObject getRefObjectByMofIdFromCollection( String mofId, Collection collection ) {

        RefObject ro;
        for ( Iterator it = collection.iterator( ); it.hasNext( ); ) {
            ro = (RefObject) it.next( );
            if ( ro.refMofId( ).equals( mofId ) ) {
                return ro;
            }
        }
        return null;
    }


    /**
     * Test of step 8 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Rectangle of ContainerShape 3 is the new one
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep8( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape3Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 3
            if ( containerShape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape3" ) ) ) {
                // get Rectangle
                Rectangle rectangleWanted = (Rectangle) containerShape3Wanted.getGraphicsAlgorithm( );
                if ( !rectangleWanted.refMofId( ).equals( (String) mapOfElements.get( "newRectangle" ) ) ) {
                    if ( rectangleWanted.refMofId( ).equals( (String) mapOfElements.get( "rectangle" ) ) ) {
                        listOfDifferences.add( "\r\nStep 8: The Rectangle of ContainerShape 3 is still the old Rectangle" );
                    } else {
                        listOfDifferences.add( "\r\nStep 8: The Rectangle of ContainerShape 3 is neither the new nor the old one" );
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        listOfDifferences.add( "\r\nStep 8: Diagram has no children or ContainerShape 3 is no child of Diagram" );
    }

    /**
     * Test of step 9 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Connection 22 is deleted and if Anchor 2 has a outgoing connection to
     * Connection 22
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep9( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        // part one: check if there is only one conneciton left
        Collection diagramConnections = diagram.getConnections( );

        for ( Iterator iterator1 = diagramConnections.iterator( ); iterator1.hasNext( ); ) {
            HorizontalConnection connection22Wanted = (HorizontalConnection) iterator1.next( );
            // look, if Connection 22 is still there
            if ( connection22Wanted.refMofId( ).equals( mapOfElements.get( "connection22" ) ) ) {
                listOfDifferences.add( "\r\nStep 9: Connection 22 still exists in Diagram" );
            }
        }

        // part two: check if Anchor 2 has an outgoing connection to Connection 22
        List diagramChildren = diagram.getChildren( );

        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                Collection containerShape2Anchors = ( (ContainerShape) containerShape2Wanted ).getAnchors( );
                for ( Iterator iterator2 = containerShape2Anchors.iterator( ); iterator2.hasNext( ); ) {
                    ChopboxAnchor anchor2Wanted = (ChopboxAnchor) iterator2.next( );
                    // get Anchor 2
                    if ( anchor2Wanted.refMofId( ).equals( mapOfElements.get( "anchor2" ) ) ) {
                        Collection anchor2OutgoingConnections = anchor2Wanted.getOutgoingConnections( );
                        for ( Iterator iterator3 = anchor2OutgoingConnections.iterator( ); iterator3.hasNext( ); ) {
                            HorizontalConnection connection22Wanted = (HorizontalConnection) iterator3.next( );
                            // look, if Connection 22 is still there
                            if ( connection22Wanted.refMofId( ).equals( mapOfElements.get( "connection22" ) ) ) {
                                listOfDifferences.add( "\r\nStep 9: Anchor 2 still has an outgoing connection to Connection 22" );
                                return;
                            }
                        }
                        // Anchor 2 is found but Connection 22 is not an outgoing connection of him
                        return;
                    }
                }
                listOfDifferences.add( "\r\nStep 9: ContainerShape 2 has no anchors or Anchor 2 is none of them" );
                return;
            }
        }
        listOfDifferences.add( "\r\nStep 9: Diagram has no children or ContainerShape 2 is no child of Diagram" );
    }

    /**
     * Test of step 10 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * outgoing connection of Anchor 2 is not to Connection 23 anymore and if
     * the outgoing connection of Anchor 3 is to Connection23
     * 
     * @param diagram With {@link #createPictogramsModel(GraphicsPackage, Map)}
     * created diagram that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInDiagramStep10( Diagram diagram, List listOfDifferences, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );
        // part one: Check if Anchor 2 still has outgoing connection to Connection 23
        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape2Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 2
            if ( containerShape2Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape2" ) ) ) {
                Collection containerShape2Anchors = ( (ContainerShape) containerShape2Wanted ).getAnchors( );
                for ( Iterator iterator2 = containerShape2Anchors.iterator( ); iterator2.hasNext( ); ) {
                    ChopboxAnchor anchor2Wanted = (ChopboxAnchor) iterator2.next( );
                    // get Anchor 2
                    if ( anchor2Wanted.refMofId( ).equals( mapOfElements.get( "anchor2" ) ) ) {
                        Collection anchor2OutgoingConnections = anchor2Wanted.getOutgoingConnections( );
                        for ( Iterator iterator3 = anchor2OutgoingConnections.iterator( ); iterator3.hasNext( ); ) {
                            HorizontalConnection connection23Wanted = (HorizontalConnection) iterator3.next( );
                            // look, if Connection 23 is still there
                            if ( connection23Wanted.refMofId( ).equals( mapOfElements.get( "connection23" ) ) ) {
                                listOfDifferences.add( "\r\nStep 10: Anchor 2 still has an outgoing connection to Connection 23" );
                            }
                        }
                    }
                }
            }
        }

        // part two: Check if Anchor 3 has outgoing connection to Connection 23
        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement containerShape3Wanted = (PictogramElement) iterator1.next( );
            // get ContainerShape 3
            if ( containerShape3Wanted.refMofId( ).equals( (String) mapOfElements.get( "containerShape3" ) ) ) {
                Collection containerShape3Anchors = ( (ContainerShape) containerShape3Wanted ).getAnchors( );
                for ( Iterator iterator4 = containerShape3Anchors.iterator( ); iterator4.hasNext( ); ) {
                    ChopboxAnchor anchor3Wanted = (ChopboxAnchor) iterator4.next( );
                    // get Anchor 3
                    if ( anchor3Wanted.refMofId( ).equals( mapOfElements.get( "anchor3" ) ) ) {
                        Collection anchor3OutgoingConnections = anchor3Wanted.getOutgoingConnections( );
                        for ( Iterator iterator5 = anchor3OutgoingConnections.iterator( ); iterator5.hasNext( ); ) {
                            HorizontalConnection connection23Wanted = (HorizontalConnection) iterator5.next( );
                            // look, if Connection 23 is there
                            if ( connection23Wanted.refMofId( ).equals( mapOfElements.get( "connection23" ) ) ) {
                                // everything is fine
                                return;
                            }
                        }
                        listOfDifferences.add( "\r\nStep10: Connection 23 is not an outgoing connection of Anchor 3" );
                        return;
                    }
                }
                listOfDifferences.add( "\r\nStep 10: ContainerShape 3 has no anchors or Anchor 3 is none of them" );
            }
        }
        listOfDifferences.add( "\r\nStep 10: Diagram has no children or ContainerShape 3 is none of them" );
    }

    /**
     * Test of step 1 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Shape 1 and Text 1 are still in the extend
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     */
    public static void checkIfShape1AndText1AreInExtend( GraphicsPackage graphicsPackage, Map mapOfElements, List listOfDifferences ) {

        Collection shapeExtend = graphicsPackage.getPictograms( ).getShape( ).refAllOfClass( );
        for ( Iterator iterator1 = shapeExtend.iterator( ); iterator1.hasNext( ); ) {
            Object shapeElement = (Object) iterator1.next( );
            if ( shapeElement instanceof Shape ) {
                if ( ( (Shape) shapeElement ).refMofId( ).equals( (String) mapOfElements.get( "shape1" ) ) ) {
                    listOfDifferences.add( "\r\nStep 1: Shape 1 is still in extend" );
                    return;
                }
            } else {
                listOfDifferences.add( "\r\nStep 1: Found " + shapeElement.getClass( ).toString( ) + " in extend of 'Shape'" );
            }
        }

        Collection textExtend = graphicsPackage.getPictograms( ).getText( ).refAllOfClass( );
        for ( Iterator iterator2 = textExtend.iterator( ); iterator2.hasNext( ); ) {
            Object textElement = (Object) iterator2.next( );
            if ( textElement instanceof Text ) {
                if ( ( (Text) textElement ).refMofId( ).equals( (String) mapOfElements.get( "text1" ) ) ) {
                    listOfDifferences.add( "\r\nStep 1: Text 1 is still in extend" );
                    return;
                }
            } else {
                listOfDifferences.add( "\r\nStep 1: Found " + textElement.getClass( ).toString( ) + " in extend of 'Text'" );
            }
        }
    }

    /**
     * Test of step 3 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Color 1 is still in the extend
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     */
    public static void checkIfColor1IsInExtend( GraphicsPackage graphicsPackage, Map mapOfElements, List listOfDifferences ) {

        Collection colorExtend = graphicsPackage.getDatatypes( ).getColor( ).refAllOfClass( );
        for ( Iterator iter = colorExtend.iterator( ); iter.hasNext( ); ) {
            Object colorElement = (Object) iter.next( );
            if ( colorElement instanceof Color ) {
                if ( ( (Color) colorElement ).refMofId( ).equals( (String) mapOfElements.get( "color1" ) ) ) {
                    listOfDifferences.add( "\r\nStep 3: Color 1 is still in extend" );
                    return;
                }
            } else {
                listOfDifferences.add( "\r\nStep 3: Found " + colorElement.getClass( ).toString( ) + " in extend of 'Color'" );
            }
        }
    }

    /**
     * Test of step 5 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Point 3 is still in the extend
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     */
    public static void checkIfPoint3IsInExtend( GraphicsPackage graphicsPackage, Map mapOfElements, List listOfDifferences ) {

        Collection pointExtend = graphicsPackage.getDatatypes( ).getPoint( ).refAllOfClass( );
        for ( Iterator iter = pointExtend.iterator( ); iter.hasNext( ); ) {
            Object pointElement = (Object) iter.next( );
            if ( pointElement instanceof Point ) {
                if ( ( (Point) pointElement ).refMofId( ).equals( (String) mapOfElements.get( "point3" ) ) ) {
                    listOfDifferences.add( "\r\nStep 5: Point 3 is still in extend" );
                    return;
                }
            } else {
                listOfDifferences.add( "\r\nStep 5: Found " + pointElement.getClass( ).toString( ) + " in extend of 'Point'" );
            }
        }
    }

    /**
     * Test of step 8 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * old Rectangle is still in the extend
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     */
    public static void checkIfOldRectangleIsInExtend( GraphicsPackage graphicsPackage, Map mapOfElements, List listOfDifferences ) {

        Collection rectangleExtend = graphicsPackage.getPictograms( ).getRectangle( ).refAllOfClass( );
        for ( Iterator iter = rectangleExtend.iterator( ); iter.hasNext( ); ) {
            Object rectangleElement = (Object) iter.next( );
            if ( rectangleElement instanceof Rectangle ) {
                if ( ( (Rectangle) rectangleElement ).refMofId( ).equals( (String) mapOfElements.get( "rectangle" ) ) ) {
                    listOfDifferences.add( "\r\nStep 8: Old Rectangle is still in extend" );
                    return;
                }
            } else {
                listOfDifferences.add( "\r\nStep 8: Found " + rectangleElement.getClass( ).toString( ) + " in extend of 'Rectangle'" );
            }

        }
    }

    /**
     * Test of step 9 executed in
     * {@link #modifyPictogramsModel(GraphicsPackage, Diagram, Map)}: Checks if
     * Connection 22 is still in the extend
     * 
     * @param graphicsPackage Graphics package with the graphics model
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this map
     */
    public static void checkIfConnection22IsInExtend( GraphicsPackage graphicsPackage, Map mapOfElements, List listOfDifferences ) {

        Collection connectionExtend = graphicsPackage.getPictograms( ).getConnection( ).refAllOfClass( );
        for ( Iterator iter = connectionExtend.iterator( ); iter.hasNext( ); ) {
            Object connectionElement = (HorizontalConnection) iter.next( );
            if ( connectionElement instanceof Connection ) {
                if ( ( (Connection) connectionElement ).refMofId( ).equals( (String) mapOfElements.get( "connection22" ) ) ) {
                    listOfDifferences.add( "\r\nStep 9: Connection 22 is still in extend" );
                    return;
                }
            } else {
                listOfDifferences.add( "\r\nStep 9: Found " + connectionElement.getClass( ).toString( ) + " in extend of 'Connection'" );
            }
        }
    }

    /**
     * Creates programatically a model with a PictogramLink between a pictograms
     * element and mof classes according to the documentation
     * "TestGraphicsFramework.doc" of the JUnit test
     * "TestLinkModelCreationAndModification". <br>
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
     * @param graphicsPackage Graphics package with the graphics model
     * @param modelPackage Package with the mof model
     * @param mapOfElements Map with all elements that ever existed in the model
     * during the test
     * @return HashMap with the created elements. Keys: "diagram",
     * "diagramLink", "mofPackage"
     */
    public static HashMap createLinkModel( GraphicsPackage graphicsPackage, ModelPackage modelPackage, Map mapOfElements ) {

        com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );

        // Create Diagram with two shapes
        Diagram myDiagram = conn.createElementInPartition( Diagram.class, null );
        mapOfElements.put( "diagram", myDiagram.refMofId( ) );

        Shape myShape1 = conn.createElementInPartition( Shape.class, null );
        mapOfElements.put( "shape1", myShape1.refMofId( ) );
        myDiagram.getChildren( ).add( myShape1 );

        Shape myShape2 = conn.createElementInPartition( Shape.class, null );
        mapOfElements.put( "shape2", myShape2.refMofId( ) );
        myDiagram.getChildren( ).add( myShape2 );

        // Create MofPackage with two mofClasses
        MofPackage myMofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        mapOfElements.put( "mofPackage", myMofPackage.refMofId( ) );
        myMofPackage.setName( "mofPackage" );

        MofClass myMofClass1 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        mapOfElements.put( "mofClass1", myMofClass1.refMofId( ) );
        myMofClass1.setName( "mofClass1" );
        myMofPackage.getContents( ).add( myMofClass1 );

        MofClass myMofClass2 = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        mapOfElements.put( "mofClass2", myMofClass2.refMofId( ) );
        myMofClass2.setName( "mofClass2" );
        myMofPackage.getContents( ).add( myMofClass2 );

        // Create DiagramLink with one pictogramLink
        DiagramLink myDiagramLink = conn.createElementInPartition( DiagramLink.class, null );
        mapOfElements.put( "diagramLink", myDiagramLink.refMofId( ) );
        myDiagramLink.setDiagram( myDiagram );

        PictogramLink myPictogramLink = conn.createElementInPartition( PictogramLink.class, null );
        mapOfElements.put( "pictogramLink", myPictogramLink.refMofId( ) );
        myPictogramLink.setPictogramElement( myShape1 );
        myPictogramLink.getBusinessObject( ).add( myMofClass1 );
        myDiagramLink.getPictogramLinks( ).add( myPictogramLink );

        HashMap mapOfRootElements = new HashMap( );
        mapOfRootElements.put( "diagram", myDiagram );
        mapOfRootElements.put( "diagramLink", myDiagramLink );
        mapOfRootElements.put( "mofPackage", myMofPackage );

        return mapOfRootElements;
    }

    /**
     * Calls modifyLinkModelStep1 and 2 to modify the model created with
     * createLinkModel.<br>
     * <ul>
     * <li>Step 1: Set Shape 2 as pictogram element of PictogramLink</li>
     * <li>Step 2: Delete MofClass 1 as business object out of PictogramLink,
     * set MofClass 2 as business object out of PictogramLink</li>
     * </ul>
     * <br>
     * <br>
     * <b><u>Structure after modifying</u></b>
     * 
     * <pre>
     * Diagram
     * Shape 1          Shape 2
     *                  /
     *                 /
     * DiagramLink    /
     *         PictogramLink
     *                 \
     *                  \
     * MofClass 1       MofClass 2
     * MofPackage
     * </pre>
     * 
     * @param diagram With this.createLinkModel(...) created diagram that should
     * be modified according to the documentation "TestGraphicsFramework.doc"
     * @param diagramLink With this.createLinkModel(...) created diagramLink
     * that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mofPackage With this.createLinkModel(...) created mofPackage that
     * should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the model
     * during the test
     */
    public static void modifyLinkModel( Diagram diagram, DiagramLink diagramLink, MofPackage mofPackage, Map mapOfElements ) {

        modifyLinkModelStep1( diagram, diagramLink, mofPackage, mapOfElements );
        modifyLinkModelStep2( diagram, diagramLink, mofPackage, mapOfElements );
    }

    /**
     * Step 1: Set Shape 2 as pictogram element of PictogramLink
     * 
     * @param diagram With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagram that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param diagramLink With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagramLink that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mofPackage With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * mofPackage that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the model
     * during the test
     */
    private static void modifyLinkModelStep1( Diagram diagram, DiagramLink diagramLink, MofPackage mofPackage, Map mapOfElements ) {

        List diagramChildren = diagram.getChildren( );
        for ( Iterator iterator1 = diagramChildren.iterator( ); iterator1.hasNext( ); ) {
            PictogramElement shape2Wanted = (PictogramElement) iterator1.next( );
            // get the Shape 2 out of the Diagram
            if ( shape2Wanted.refMofId( ).equals( mapOfElements.get( "shape2" ) ) ) {
                // get PictogramLink
                Collection diagramLinkPictogramLinks = diagramLink.getPictogramLinks( );
                for ( Iterator iterator2 = diagramLinkPictogramLinks.iterator( ); iterator2.hasNext( ); ) {
                    PictogramLink pictogramLinkWanted = (PictogramLink) iterator2.next( );
                    if ( pictogramLinkWanted.refMofId( ).equals( mapOfElements.get( "pictogramLink" ) ) ) {
                        if ( pictogramLinkWanted instanceof PictogramLink ) {
                            ( (PictogramLink) pictogramLinkWanted ).setPictogramElement( shape2Wanted );
                        }
                    }
                }
            }
        }
    }

    /**
     * Step 2: Delete MofClass 1 as business object out of PictogramLink, set
     * MofClass 2 as business object out of PictogramLink
     * 
     * @param diagram With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagram that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param diagramLink With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagramLink that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mofPackage With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * mofPackage that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mapOfElements Map with all elements that ever existed in the model
     * during the test
     */
    private static void modifyLinkModelStep2( Diagram diagram, DiagramLink diagramLink, MofPackage mofPackage, Map mapOfElements ) {

        Collection mofPackageContents = mofPackage.getContents( );

        for ( Iterator iterator1 = mofPackageContents.iterator( ); iterator1.hasNext( ); ) {
            ModelElement mofClass2Wanted = (ModelElement) iterator1.next( );
            // get MofClass 2 out of MofPackage            
            if ( ( (MofClass) mofClass2Wanted ).refMofId( ).equals( mapOfElements.get( "mofClass2" ) ) ) {

                Collection diagramLinkPictogramLinks = diagramLink.getPictogramLinks( );
                for ( Iterator iterator2 = diagramLinkPictogramLinks.iterator( ); iterator2.hasNext( ); ) {
                    Link pictogramLinkWanted = (Link) iterator2.next( );
                    // get PictogramLink
                    if ( pictogramLinkWanted.refMofId( ).equals( mapOfElements.get( "pictogramLink" ) ) ) {
                        List pictogramLinkBusinessObjects = pictogramLinkWanted.getBusinessObject( );

                        // add MofClass 2 as BusinessObject in DiagramLink
                        pictogramLinkBusinessObjects.add( mofClass2Wanted );
                        for ( Iterator iterator3 = pictogramLinkBusinessObjects.iterator( ); iterator3.hasNext( ); ) {
                            Object mofClass1Wanted = (Object) iterator3.next( );
                            if ( mofClass1Wanted instanceof MofClass ) {
                                if ( ( (MofClass) mofClass1Wanted ).refMofId( ).equals( mapOfElements.get( "mofClass1" ) ) ) {
                                    // delete MofClass 1 as BusinessObject of DiagramLink
                                    iterator3.remove( );
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Test of step 1 executed in
     * {@link #modifyLinkModel(Diagram, DiagramLink, MofPackage, Map)}: Checks
     * if Shape 2 is really the pictogram element of PictogramLink
     * 
     * @param diagram With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagram that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param diagramLink With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagramLink that should be modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this list
     * @param mapOfElements Map with all elements that ever existed in the model
     * during the test
     */
    public static void checkModificationInLinkModelStep1( Diagram diagram, DiagramLink diagramLink, List listOfDifferences, Map mapOfElements ) {

        Collection diagramLinkPictogramLinks = diagramLink.getPictogramLinks( );
        for ( Iterator iterator1 = diagramLinkPictogramLinks.iterator( ); iterator1.hasNext( ); ) {
            Link pictogramLinkWanted = (Link) iterator1.next( );
            // get PictogramLink
            if ( pictogramLinkWanted.refMofId( ).equals( mapOfElements.get( "pictogramLink" ) ) ) {
                if ( pictogramLinkWanted instanceof PictogramLink ) {
                    if ( !( (PictogramLink) pictogramLinkWanted ).getPictogramElement( ).refMofId( ).equals( mapOfElements.get( "shape2" ) ) ) {
                        listOfDifferences.add( "\r\nStep 1: Shape 2 is not the PictogramElement of PictogramLink" );
                        return;
                    }
                }
            }
        }
    }



    /**
     * Test of step 2 executed in
     * {@link #modifyLinkModel(Diagram, DiagramLink, MofPackage, Map)}: Checks
     * if MofClass 2 is really the business object of PictogramLink and MofClass
     * 1 isn't anymore
     * 
     * @param diagramLink With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * diagramLink that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param mofPackage With
     * {@link #createLinkModel(GraphicsPackage, ModelPackage, Map)} created
     * mofPackage that was modified according to the documentation
     * "TestGraphicsFramework.doc"
     * @param listOfDifferences When a difference to the expected modification
     * occurs, it is written in this list
     * @param mapOfElements Map with all elements that ever existed in the
     * diagram during the test
     */
    public static void checkModificationInLinkModelStep2( DiagramLink diagramLink, MofPackage mofPackage, List listOfDifferences, Map mapOfElements ) {

        Collection diagramLinkPictogramLinks = diagramLink.getPictogramLinks( );
        boolean mofClass2Found = false;

        for ( Iterator iterator1 = diagramLinkPictogramLinks.iterator( ); iterator1.hasNext( ); ) {
            Link pictogramLinkWanted = (Link) iterator1.next( );
            // get PictogramLink
            if ( pictogramLinkWanted.refMofId( ).equals( mapOfElements.get( "pictogramLink" ) ) ) {
                List pictogramLinkBusinessObjects = pictogramLinkWanted.getBusinessObject( );

                for ( Iterator iterator2 = pictogramLinkBusinessObjects.iterator( ); iterator2.hasNext( ); ) {
                    Object mofClass1And2Wanted = (Object) iterator2.next( );
                    if ( mofClass1And2Wanted instanceof MofClass ) {
                        if ( ( (MofClass) mofClass1And2Wanted ).refMofId( ).equals( mapOfElements.get( "mofClass1" ) ) ) {
                            listOfDifferences.add( "\r\nStep 2: MofClass 1 is still a BusinessObject of PictogramLink" );
                        }
                        if ( ( (MofClass) mofClass1And2Wanted ).refMofId( ).equals( mapOfElements.get( "mofClass2" ) ) ) {
                            mofClass2Found = true;
                        }
                    }
                }
            }
        }
        if ( !mofClass2Found ) {
            listOfDifferences.add( "\r\nStep 2: MofClass 2 is not a BusinessObject of PictogramLink" );
        }
        return;
    }

    public static void createLinkProperty( GraphicsPackage graphicsPackage, DiagramLink dl ) {

        com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );
        Property prop = conn.createElementInPartition( Property.class, null );
        prop.setKey( "PropKey" );
        prop.setValue( "PropValue" );
        dl.getProperties( ).add( prop );
    }
}
