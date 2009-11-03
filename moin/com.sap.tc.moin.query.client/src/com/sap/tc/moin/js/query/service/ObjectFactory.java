package com.sap.tc.moin.js.query.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.sap.tc.moin.js.query.service package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 */
@XmlRegistry
@SuppressWarnings( "nls" )
public class ObjectFactory {

    private final static QName _ExecuteQuery_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "executeQuery" );

    private final static QName _ExecuteQueryResponse_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "executeQueryResponse" );

    private final static QName _GetFacilities_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "getFacilities" );

    private final static QName _InvalidResourceIdentifierFaultInfo_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "InvalidResourceIdentifierFaultInfo" );

    private final static QName _ProcessReport_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "processReport" );

    private final static QName _QueryExecutionFaultInfo_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "QueryExecutionFaultInfo" );

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.sap.tc.moin.js.query.service
     */
    public ObjectFactory( ) {

    }

    /**
     * Create an instance of {@link ExecuteQuery }
     */
    public ExecuteQuery createExecuteQuery( ) {

        return new ExecuteQuery( );
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteQuery }
     * {@code >}
     */
    @XmlElementDecl( namespace = "http://sap.com/tc/moin/js/query/service/", name = "executeQuery" )
    public JAXBElement<ExecuteQuery> createExecuteQuery( ExecuteQuery value ) {

        return new JAXBElement<ExecuteQuery>( _ExecuteQuery_QNAME, ExecuteQuery.class, null, value );
    }

    /**
     * Create an instance of {@link ExecuteQueryResponse }
     */
    public ExecuteQueryResponse createExecuteQueryResponse( ) {

        return new ExecuteQueryResponse( );
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link ExecuteQueryResponse }{@code >}
     */
    @XmlElementDecl( namespace = "http://sap.com/tc/moin/js/query/service/", name = "executeQueryResponse" )
    public JAXBElement<ExecuteQueryResponse> createExecuteQueryResponse( ExecuteQueryResponse value ) {

        return new JAXBElement<ExecuteQueryResponse>( _ExecuteQueryResponse_QNAME, ExecuteQueryResponse.class, null, value );
    }

    /**
     * Create an instance of {@link GetDataArea }
     */
    public GetDataArea createGetDataArea( ) {

        return new GetDataArea( );
    }

    /**
     * Create an instance of {@link GetDataAreaConfig }
     */
    public GetDataAreaConfig createGetDataAreaConfig( ) {

        return new GetDataAreaConfig( );
    }

    /**
     * Create an instance of {@link GetDataAreaConfigResponse }
     */
    public GetDataAreaConfigResponse createGetDataAreaConfigResponse( ) {

        return new GetDataAreaConfigResponse( );
    }

    /**
     * Create an instance of {@link GetDataAreaResponse }
     */
    public GetDataAreaResponse createGetDataAreaResponse( ) {

        return new GetDataAreaResponse( );
    }

    /**
     * Create an instance of {@link GetDataAreas }
     */
    public GetDataAreas createGetDataAreas( ) {

        return new GetDataAreas( );
    }

    /**
     * Create an instance of {@link GetDataAreasResponse }
     */
    public GetDataAreasResponse createGetDataAreasResponse( ) {

        return new GetDataAreasResponse( );
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl( namespace = "http://sap.com/tc/moin/js/query/service/", name = "getFacilities" )
    public JAXBElement<Object> createGetFacilities( Object value ) {

        return new JAXBElement<Object>( _GetFacilities_QNAME, Object.class, null, value );
    }

    /**
     * Create an instance of {@link GetFacilitiesResponse }
     */
    public GetFacilitiesResponse createGetFacilitiesResponse( ) {

        return new GetFacilitiesResponse( );
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl( namespace = "http://sap.com/tc/moin/js/query/service/", name = "InvalidResourceIdentifierFaultInfo" )
    public JAXBElement<String> createInvalidResourceIdentifierFaultInfo( String value ) {

        return new JAXBElement<String>( _InvalidResourceIdentifierFaultInfo_QNAME, String.class, null, value );
    }

    /**
     * Create an instance of {@link KVList }
     */
    public KVList createKVList( ) {

        return new KVList( );
    }

    /**
     * Create an instance of {@link KVList.Entry }
     */
    public KVList.Entry createKVListEntry( ) {

        return new KVList.Entry( );
    }

    /**
     * Create an instance of {@link ProcessError }
     */
    public ProcessError createProcessError( ) {

        return new ProcessError( );
    }

    /**
     * Create an instance of {@link ProcessMessage }
     */
    public ProcessMessage createProcessMessage( ) {

        return new ProcessMessage( );
    }

    /**
     * Create an instance of {@link ProcessReport }
     */
    public ProcessReport createProcessReport( ) {

        return new ProcessReport( );
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessReport }
     * {@code >}
     */
    @XmlElementDecl( namespace = "http://sap.com/tc/moin/js/query/service/", name = "processReport" )
    public JAXBElement<ProcessReport> createProcessReport( ProcessReport value ) {

        return new JAXBElement<ProcessReport>( _ProcessReport_QNAME, ProcessReport.class, null, value );
    }

    /**
     * Create an instance of {@link ProcessWarning }
     */
    public ProcessWarning createProcessWarning( ) {

        return new ProcessWarning( );
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link QueryExecutionFaultInfo }{@code >}
     */
    @XmlElementDecl( namespace = "http://sap.com/tc/moin/js/query/service/", name = "QueryExecutionFaultInfo" )
    public JAXBElement<String> createQueryExecutionFaultInfo( String value ) {

        return new JAXBElement<String>( _QueryExecutionFaultInfo_QNAME, String.class, null, value );
    }

    /**
     * Create an instance of {@link WsColumnType }
     */
    public WsColumnType createWsColumnType( ) {

        return new WsColumnType( );
    }

    /**
     * Create an instance of {@link WsQueryScope }
     */
    public WsQueryScope createWsQueryScope( ) {

        return new WsQueryScope( );
    }

    /**
     * Create an instance of {@link WsResultObject }
     */
    public WsResultObject createWsResultObject( ) {

        return new WsResultObject( );
    }

    /**
     * Create an instance of {@link WsResultRow }
     */
    public WsResultRow createWsResultRow( ) {

        return new WsResultRow( );
    }

    /**
     * Create an instance of {@link WsResultSet }
     */
    public WsResultSet createWsResultSet( ) {

        return new WsResultSet( );
    }

    /**
     * Create an instance of {@link WsStackTraceElement }
     */
    public WsStackTraceElement createWsStackTraceElement( ) {

        return new WsStackTraceElement( );
    }

    /**
     * Create an instance of {@link WsThrowable }
     */
    public WsThrowable createWsThrowable( ) {

        return new WsThrowable( );
    }

}
