package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;

import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.expressions.__impl.VariableExpInternal;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;

import com.sap.tc.moin.friends.ocl.editor.RegionWrappedMRI;
import com.sap.tc.moin.ocl.parser.IOCLEnvironment;
import com.sap.tc.moin.ocl.parser.gen.oclAst.CollectionPropertyInvocation;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorAny;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorCollect;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorCollectNested;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorExists;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorForAll;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorIsUnique;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorOne;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorReject;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorSelect;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IteratorSortedBy;
import com.sap.tc.moin.ocl.parser.gen.oclAst.LoopPropertyInvocation;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.gen.oclAst.ObjectPropertyInvocation;
import com.sap.tc.moin.ocl.parser.gen.oclAst.OclFileOclExpression;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Self;
import com.sap.tc.moin.ocl.parser.gen.oclAst.TypeLiteral;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Variable;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Calculates the information (MRI at offset and Information at offset) for the
 * annotations (hyperlinks and information provider)
 */
public class AnnotationMRIVisitor extends TypeVisitor {

    private final OclEditorServiceImpl myEditorService;

    private final CoreConnection myConnection;

    static class Annotation {

        int offset;

        int length;

        private String myString;

        private MoinLocalizedString myLocalizedString;

        Annotation( MoinLocalizedString locString, int actOffset, int actLength ) {

            this.myLocalizedString = locString;
            this.offset = actOffset;
            this.length = actLength;
        }

        Annotation( String actString, int actOffset, int actLength ) {

            this.myString = actString;
            this.offset = actOffset;
            this.length = actLength;
        }

        public String getString( Locale locale ) {

            if ( this.myLocalizedString != null ) {
                return this.myLocalizedString.getLocalizedMessage( locale );
            }
            return this.myString;
        }

    }

    /**
     * @param editorService the editor service
     * @param actEnvironment the environment
     */
    public AnnotationMRIVisitor( OclEditorServiceImpl editorService, IOCLEnvironment actEnvironment ) {

        this( editorService, actEnvironment, 0 );

    }

    /**
     * The shift is needed when extracting the information from the
     * subexpression
     * 
     * @param editorService the editor service
     * @param actEnvironment the environment
     * @param actShift the offset
     */
    public AnnotationMRIVisitor( OclEditorServiceImpl editorService, IOCLEnvironment actEnvironment, int actShift ) {

        super( actEnvironment );
        this.myEditorService = editorService;
        this.myConnection = actEnvironment.getJmiCreator( ).getConnection( );
        this.shift = actShift;
    }

    private int shift;

    private final List<Annotation> annotations = new ArrayList<Annotation>( );

    private final List<RegionWrappedMRI> mRIs = new ArrayList<RegionWrappedMRI>( );

    String getAnnotation( int offset, Locale locale ) {

        ListIterator<Annotation> theAnotations = this.annotations.listIterator( this.annotations.size( ) );

        while ( theAnotations.hasPrevious( ) ) {
            Annotation anno = theAnotations.previous( );
            int start = anno.offset;
            int end = anno.offset + anno.length;
            if ( start <= offset && offset <= end ) {
                return anno.getString( locale );
            }
        }
        return null;
    }

    void setShift( int newShift ) {

        this.shift = newShift;
    }

//    MRI getMRI( int offset ) {
//
//        ListIterator<RegionWrappedMRI> mRIwithPositions = ( this.mRIs.listIterator( this.mRIs.size( ) ) );
//
//        while ( mRIwithPositions.hasPrevious( ) ) {
//            RegionWrappedMRI mwp = mRIwithPositions.previous( );
//            int start = mwp.getOffset( );
//            int end = mwp.getOffset( ) + mwp.getLength( );
//            if ( start <= offset && offset <= end ) {
//                return mwp.getMRI( );
//            }
//        }
//        return null;
//    }

    RegionWrappedMRI getRegionWrappedMRI( int offset ) {

        ListIterator<RegionWrappedMRI> mRIwithPositions = ( this.mRIs.listIterator( this.mRIs.size( ) ) );

        while ( mRIwithPositions.hasPrevious( ) ) {
            RegionWrappedMRI mwp = mRIwithPositions.previous( );
            int start = mwp.getOffset( );
            int end = mwp.getOffset( ) + mwp.getLength( );
            if ( start <= offset && offset <= end ) {
                return mwp;
            }
        }
        return null;
    }

    @Override
    public void visit( ObjectPropertyInvocation n ) {

        super.visit( n );
        String annotation = null;
        MRI mri = null;
        int offset = n.getpropertyCall( ).getLeftIToken( ).getStartOffset( );
        int length = n.getpropertyCall( ).getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getpropertyCall( ) );
        if ( exp instanceof AssociationEndCallExp ) {
            AssociationEndCallExp callExp = (AssociationEndCallExp) exp;
            mri = ( ( (AssociationEndCallExpInternal) callExp ).getReferredAssociationEnd( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (AssociationEndInternal) ( (AssociationEndCallExpInternal) callExp ).getReferredAssociationEnd( this.myConnection ), super.oclTypeChecker, true );

        } else if ( exp instanceof AttributeCallExp ) {
            AttributeCallExp callExp = (AttributeCallExp) exp;
            mri = ( ( (AttributeCallExpInternal) callExp ).getReferredAttribute( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (AttributeInternal) ( (AttributeCallExpInternal) callExp ).getReferredAttribute( this.myConnection ), super.oclTypeChecker, true );
        } else if ( exp instanceof OperationCallExp ) {
            OperationCallExp callExp = (OperationCallExp) exp;
            mri = ( ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (OperationInternal) ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ), super.oclTypeChecker, true );
        }
        if ( annotation != null ) {
            this.annotations.add( new Annotation( annotation, offset, length ) );
        }
        if ( mri != null ) {
            this.mRIs.add( new RegionWrappedMRIImpl( mri, offset, length ) );
        }
    }

    /**
     * <b> <li>oclFile ::= oclExpression </b>
     */
    @Override
    public void visit( OclFileOclExpression n ) {

        super.visit( n );
        String annotation = null;
        MRI mri = null;
        int offset = n.getoclExpression( ).getLeftIToken( ).getStartOffset( );
        int length = n.getoclExpression( ).getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        if ( exp instanceof AssociationEndCallExp ) {
            AssociationEndCallExp callExp = (AssociationEndCallExp) exp;
            mri = ( ( (AssociationEndCallExpInternal) callExp ).getReferredAssociationEnd( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (AssociationEndInternal) ( (AssociationEndCallExpInternal) callExp ).getReferredAssociationEnd( this.myConnection ), super.oclTypeChecker, true );

        } else if ( exp instanceof AttributeCallExp ) {
            AttributeCallExp callExp = (AttributeCallExp) exp;
            mri = ( ( (AttributeCallExpInternal) callExp ).getReferredAttribute( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (AttributeInternal) ( (AttributeCallExpInternal) callExp ).getReferredAttribute( this.myConnection ), super.oclTypeChecker, true );
        } else if ( exp instanceof OperationCallExp ) {
            OperationCallExp callExp = (OperationCallExp) exp;
            mri = ( ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (OperationInternal) ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ), super.oclTypeChecker, true );
        }
        if ( annotation != null ) {
            this.annotations.add( new Annotation( annotation, offset, length ) );
        }
        if ( mri != null ) {
            this.mRIs.add( new RegionWrappedMRIImpl( mri, offset, length ) );
        }

    }

    @Override
    public void visit( TypeLiteral n ) {

        super.visit( n );
        TypeExp exp = (TypeExp) this.getUpProperty( n );
        MRI mri = ( (TypeExpInternal) exp ).getReferredType( this.myConnection ).get___Mri( );
        this.mRIs.add( new RegionWrappedMRIImpl( mri, n.getStartOffset( ) + this.shift, n.getEndOffset( ) - n.getStartOffset( ) + 1 ) );
        String annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (ClassifierInternal) ( (TypeExpInternal) exp ).getReferredType( this.myConnection ), super.oclTypeChecker, true );
        this.annotations.add( new Annotation( annotation, n.getStartOffset( ) + this.shift, n.getEndOffset( ) - n.getStartOffset( ) + 1 ) );
    }

    /**
     * <b> <li>varPathName ::= self </b>
     */
    @Override
    public void visit( Self n ) {

        super.visit( n );
        String annotation = "self = " + ( (VariableDeclarationInternal) this.env.lookupVarByName( OclConstants.VAR_SELF ) ).getType( this.myConnection ).getName( ); //$NON-NLS-1$
        this.annotations.add( new Annotation( annotation, n.getStartOffset( ) + this.shift, n.getEndOffset( ) - n.getStartOffset( ) + 1 ) );
    }

    //        @Override
    //        /**
    //         * <b>
    //         * <li>Rule 70: classifierContextDecl ::= context sPathName invOrDefN
    //         * </b>
    //         */
    //        public void visit( ClassifierContextDecl n ) {
    //
    //            super.visit( n );
    //            int offset = n.getsPathName( ).getLeftIToken( ).getStartOffset( );
    //            int length = n.getsPathName( ).getRightIToken( ).getEndOffset( ) - offset + 1;
    //            String annotation = null;
    //            MRI mri = null;
    //            RefObject context = (RefObject) env.getContext( );
    //            if ( context instanceof ModelElement ) {
    //                ModelElement me = (ModelElement) context;
    //                mri = ( (Partitionable) me ).get___Mri( );
    //                annotation = computeAdditionalInformation( me, super.oclTypeChecker, false );
    //            }
    //            if ( annotation != null )
    //                annotations.add( new Annotation( annotation, offset, length ) );
    //            if ( mri != null )
    //                this.mRIs.add( new MRIwithPosition( mri, offset, length ) );
    //        }

    @Override
    public void visit( Variable n ) {

        int offset = n.getStartOffset( );
        int length = n.getEndOffset( ) - offset + 1;
        offset += this.shift;
        try {
            super.visit( n );
        } catch ( RuntimeException e ) {
            //maybe it's a package
            Object o = this.getUpProperty( (Node) n.getpathName( ) );
            if ( o instanceof List ) {
                List<String> pathname = (List<String>) o;

                ModelElementInternal me = (ModelElementInternal) this.myEditorService.modelElementsByOclQualifiedName.get( StringHelper.toPathName( pathname ) );
                if ( me != null ) {
                    this.annotations.add( new Annotation( this.myEditorService.computeAdditionalInformation( this.myConnection, me, super.oclTypeChecker, true ), offset, length ) );
                    MRI mri = ( (Partitionable) me ).get___Mri( );
                    this.mRIs.add( new RegionWrappedMRIImpl( mri, offset, length ) );
                }
                // if we are in the context declaration and the context is not declared absolute
                else if ( pathname.size( ) == 2 && ( (VariableDeclarationInternal) this.env.lookupVarByName( OclConstants.VAR_SELF ) ).getType( this.myConnection ).getName( ).equals( pathname.get( 0 ) ) ) {
                    pathname.remove( 0 );
                    pathname.addAll( 0, ( (ModelElementInternal) ( (VariableDeclarationInternal) this.env.lookupVarByName( OclConstants.VAR_SELF ) ).getType( this.myConnection ) ).getQualifiedName( this.myConnection ) );

                    me = (ModelElementInternal) this.myEditorService.modelElementsByOclQualifiedName.get( StringHelper.toPathName( pathname ) );
                    if ( me != null ) {
                        this.annotations.add( new Annotation( this.myEditorService.computeAdditionalInformation( this.myConnection, me, super.oclTypeChecker, true ), offset, length ) );
                    }
                }
            }
            throw e;
        }

        String annotation = null;
        MRI mri = null;

        Object exp = this.getUpProperty( n );
        if ( exp instanceof TypeExp ) {
            TypeExp typeExp = (TypeExp) exp;
            mri = ( ( (TypeExpInternal) typeExp ).getReferredType( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (ClassifierInternal) ( (TypeExpInternal) typeExp ).getReferredType( this.myConnection ), super.oclTypeChecker, true );

        } else if ( exp instanceof VariableExp ) {
            VariableExp varExp = (VariableExp) exp;
            annotation = ( (VariableExpInternal) varExp ).getReferredVariable( this.myConnection ).getVarName( ) + " = " + ( (VariableDeclarationInternal) ( (VariableExpInternal) varExp ).getReferredVariable( this.myConnection ) ).getType( this.myConnection ).getName( ); //$NON-NLS-1$

        } else if ( exp instanceof AssociationEndCallExp ) {
            AssociationEndCallExp callExp = (AssociationEndCallExp) exp;
            mri = ( (AssociationEndCallExpInternal) callExp ).getReferredAssociationEnd( this.myConnection ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (AssociationEndInternal) ( (AssociationEndCallExpInternal) callExp ).getReferredAssociationEnd( this.myConnection ), super.oclTypeChecker, true );

        } else if ( exp instanceof AttributeCallExp ) {
            AttributeCallExp callExp = (AttributeCallExp) exp;
            mri = ( ( (AttributeCallExpInternal) callExp ).getReferredAttribute( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (AttributeInternal) ( (AttributeCallExpInternal) callExp ).getReferredAttribute( this.myConnection ), super.oclTypeChecker, true );
        } else if ( exp instanceof OperationCallExp ) {
            OperationCallExp callExp = (OperationCallExp) exp;
            mri = ( ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (OperationInternal) ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ), super.oclTypeChecker, true );
        }
        if ( annotation != null ) {
            this.annotations.add( new Annotation( annotation, offset, length ) );
        }
        if ( mri != null ) {
            this.mRIs.add( new RegionWrappedMRIImpl( mri, offset, length ) );
        }
    }

    @Override
    public void visit( CollectionPropertyInvocation n ) {

        super.visit( n );
        String annotation = null;
        MRI mri = null;
        int offset = n.getpropertyCall( ).getLeftIToken( ).getStartOffset( );
        int length = n.getpropertyCall( ).getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        Object exp = this.getUpProperty( n );
        if ( exp instanceof OperationCallExp ) {
            OperationCallExp callExp = (OperationCallExp) exp;
            mri = ( ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ) ).get___Mri( );
            annotation = this.myEditorService.computeAdditionalInformation( this.myConnection, (OperationInternal) ( (OperationCallExpInternal) callExp ).getReferredOperation( this.myConnection ), super.oclTypeChecker, true );
        }
        if ( annotation != null ) {
            this.annotations.add( new Annotation( annotation, offset, length ) );
        }
        if ( mri != null ) {
            this.mRIs.add( new RegionWrappedMRIImpl( mri, offset, length ) );
        }
    }

    @Override
    public void visit( LoopPropertyInvocation n ) {

        super.visit( n );
        int offset = n.getloopExp( ).getLeftIToken( ).getStartOffset( );
        int length = n.getloopExp( ).getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        Object exp = this.getUpProperty( n );
        if ( exp instanceof IterateExp ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.ITERATE, offset, length ) );
        }
    }

    /**
     * <b> <li>iteratorExp ::= any ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorAny n ) {

        super.visit( n );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        this.annotations.add( new Annotation( MoinAnnotationMessages.ANY, offset, length ) );

    }


    /**
     * <b> <li>iteratorExp ::= collect ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorCollect n ) {

        super.visit( n );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        this.annotations.add( new Annotation( MoinAnnotationMessages.COLLECT, offset, length ) );
    }


    /**
     * <b> <li>iteratorExp ::= collectNested ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorCollectNested n ) {

        super.visit( n );
        OclExpression source = (OclExpression) this.getDownProperty( n );
        Classifier classi = ( (OclExpressionInternal) source ).getType( this.myConnection );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        if ( classi instanceof BagType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.COLLECTNESTED_BAG, offset, length ) );
        } else if ( classi instanceof SetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.COLLECTNESTED_SET, offset, length ) );
        } else if ( classi instanceof SequenceType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.COLLECTNESTED_SEQUENCE, offset, length ) );
        } else if ( classi instanceof OrderedSetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.COLLECTNESTED_ORDEREDSET, offset, length ) );
        }
    }

    /**
     * <b> <li>iteratorExp ::= exists ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorExists n ) {

        super.visit( n );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        this.annotations.add( new Annotation( MoinAnnotationMessages.EXISTS, offset, length ) );
    }

    /**
     * <b> <li>iteratorExp ::= forAll ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorForAll n ) {

        super.visit( n );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        this.annotations.add( new Annotation( MoinAnnotationMessages.FORALL, offset, length ) );
    }

    /**
     * <b> <li>iteratorExp ::= isUnique ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorIsUnique n ) {

        super.visit( n );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        this.annotations.add( new Annotation( MoinAnnotationMessages.ISUNIQUE, offset, length ) );
    }

    /**
     * <b> <li>iteratorExp ::= one ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorOne n ) {

        super.visit( n );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        this.annotations.add( new Annotation( MoinAnnotationMessages.ONE, offset, length ) );
    }


    /**
     * <b> <li>iteratorExp ::= reject ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorReject n ) {

        super.visit( n );
        OclExpression source = (OclExpression) this.getDownProperty( n );
        Classifier classi = ( (OclExpressionInternal) source ).getType( this.myConnection );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        if ( classi instanceof BagType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.REJECT_BAG, offset, length ) );
        } else if ( classi instanceof SetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.REJECT_SET, offset, length ) );
        } else if ( classi instanceof SequenceType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.REJECT_SEQUENCE, offset, length ) );
        } else if ( classi instanceof OrderedSetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.REJECT_ORDEREDSET, offset, length ) );
        }
    }

    /**
     * <b> <li>iteratorExp ::= select ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorSelect n ) {

        super.visit( n );
        OclExpression source = (OclExpression) this.getDownProperty( n );
        Classifier classi = ( (OclExpressionInternal) source ).getType( this.myConnection );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        if ( classi instanceof BagType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SELECT_BAG, offset, length ) );
        } else if ( classi instanceof SetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SELECT_SET, offset, length ) );
        } else if ( classi instanceof SequenceType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SELECT_SEQUENCE, offset, length ) );
        } else if ( classi instanceof OrderedSetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SELECT_ORDEREDSET, offset, length ) );
        }
    }

    /**
     * <b> <li>iteratorExp ::= sortedBy ( iterContents ) </b>
     */
    @Override
    public void visit( IteratorSortedBy n ) {

        super.visit( n );
        OclExpression source = (OclExpression) this.getDownProperty( n );
        Classifier classi = ( (OclExpressionInternal) source ).getType( this.myConnection );
        int offset = n.getLeftIToken( ).getStartOffset( );
        int length = n.getLeftIToken( ).getEndOffset( ) - offset + 1;
        offset += this.shift;
        if ( classi instanceof BagType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SORTEDBY_BAG, offset, length ) );
        } else if ( classi instanceof SetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SORTEDBY_SET, offset, length ) );
        } else if ( classi instanceof SequenceType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SORTEDBY_SEQUENCE, offset, length ) );
        } else if ( classi instanceof OrderedSetType ) {
            this.annotations.add( new Annotation( MoinAnnotationMessages.SORTEDBY_ORDEREDSET, offset, length ) );
        }
    }
}