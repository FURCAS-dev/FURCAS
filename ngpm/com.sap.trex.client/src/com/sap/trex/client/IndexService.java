//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexService.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sap.trex.client.*;

public class IndexService extends Service  {

    //
    // IndexService
    //

    public IndexService (Connection theConnection)
    { super(theConnection);}
    // Admin

    public boolean clearIndex(ClearIndex_Request theRequest, Result theResult) throws Exception
    {
        return call("clearIndex", theRequest, theResult);
    }

    public boolean createHierarchyIndex(CreateHierarchyIndex_Request theRequest, Result theResult) throws Exception
    {
        return call("createHierarchyIndex", theRequest, theResult);
    }

    public boolean createIndex(CreateIndex_Request theRequest, Result theResult) throws Exception
    {
        return call("createIndex", theRequest, theResult);
    }

    public boolean createJoinIndex(CreateJoinIndex_Request theRequest, Result theResult) throws Exception
    {
        return call("createJoinIndex", theRequest, theResult);
    }

    public boolean deleteIndex(DeleteIndex_Request theRequest, Result theResult) throws Exception
    {
        return call("deleteIndex", theRequest, theResult);
    }

    public boolean listIndexes(ListIndex_Request theRequest, ListIndex_Result theResult) throws Exception
    {
        return call("listIndexes", theRequest, theResult);
    }

    public boolean mergeDeltaIndex(MergeDeltaIndex_Request theRequest, Result theResult) throws Exception
    {
        return call("mergeDeltaIndex", theRequest, theResult);
    }

    public boolean pythonCall(PythonCall_Request theRequest, PythonCall_Result theResult) throws Exception
    {
        return call("pythonCall", theRequest, theResult);
    }

    public boolean showIndex(ShowIndex_Request theRequest, ShowIndex_Result theResult) throws Exception
    {
        return call("showIndex", theRequest, theResult);
    }

    public boolean showIndexInfo(ShowIndexInfo_Request theRequest, ShowIndexInfo_Result theResult) throws Exception
    {
        return call("showIndexInfo", theRequest, theResult);
    }

    public boolean showJoinIndex(ShowJoinIndex_Request theRequest, ShowJoinIndex_Result theResult) throws Exception
    {
        return call("showJoinIndex", theRequest, theResult);
    }
    // Cube

    public boolean createCube(CreateCube_Request theRequest, CreateCube_Result theResult) throws Exception
    {
        return call("createCube", theRequest, theResult);
    }

    public boolean deleteCube(DeleteCube_Request theRequest, Result theResult) throws Exception
    {
        return call("deleteCube", theRequest, theResult);
    }

    public boolean showCube(ShowCube_Request theRequest, ShowCube_Result theResult) throws Exception
    {
        return call("showCube", theRequest, theResult);
    }
    // Index

    public boolean indexDocuments(IndexDocuments_Request theRequest, IndexDocuments_Result theResult) throws Exception
    {
        return call("indexDocuments", theRequest, theResult);
    }

    public boolean indexTable(IndexTable_Request theRequest, Result theResult) throws Exception
    {
        return call("indexTable", theRequest, theResult);
    }
    // Search

    public boolean olapGuidedNavSearch(OlapGuidedNavSearch_Request theRequest, OlapGuidedNavSearch_Result theResult) throws Exception
    {
        return call("olapGuidedNavSearch", theRequest, theResult);
    }

    public boolean olapSearch(OlapSearch_Request theRequest, OlapSearch_Result theResult) throws Exception
    {
        return call("olapSearch", theRequest, theResult);
    }

    public boolean searchDocuments(SearchDocuments_Request theRequest, SearchDocuments_Result theResult) throws Exception
    {
        return call("searchDocuments", theRequest, theResult);
    }

    public boolean searchHierarchy(SearchHierarchy_Request theRequest, SearchHierarchy_Result theResult) throws Exception
    {
        return call("searchHierarchy", theRequest, theResult);
    }

    public boolean searchTable(SearchTable_Request theRequest, SearchTable_Result theResult) throws Exception
    {
        return call("searchTable", theRequest, theResult);
    }

    public boolean tmxSearch(TmxSearch_Request theRequest, TmxSearch_Result theResult) throws Exception
    {
        return call("tmxSearch", theRequest, theResult);
    }
    // Transaction

    public boolean beginTransaction(BeginTransaction_Request theRequest, BeginTransaction_Result theResult) throws Exception
    {
        return call("beginTransaction", theRequest, theResult);
    }

    public boolean commitTransaction(CommitTransaction_Request theRequest, CommitTransaction_Result theResult) throws Exception
    {
        return call("commitTransaction", theRequest, theResult);
    }

    public boolean lastTransaction(LastTransaction_Request theRequest, LastTransaction_Result theResult) throws Exception
    {
        return call("lastTransaction", theRequest, theResult);
    }

    public boolean listTransactions(Request theRequest, ListTransaction_Result theResult) throws Exception
    {
        return call("listTransactions", theRequest, theResult);
    }

    public boolean rollbackTransaction(RollbackTransaction_Request theRequest, Result theResult) throws Exception
    {
        return call("rollbackTransaction", theRequest, theResult);
    }
}
