package com.sap.trex.client.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import junit.framework.TestCase;

import com.sap.trex.client.AdminService;
import com.sap.trex.client.AggregationType;
import com.sap.trex.client.AttributeDefinition;
import com.sap.trex.client.AttributeType;
import com.sap.trex.client.Connection;
import com.sap.trex.client.CreateIndex_Request;
import com.sap.trex.client.DeleteIndex_Request;
import com.sap.trex.client.DocumentAction;
import com.sap.trex.client.GetVersion_Result;
import com.sap.trex.client.IndexAttribute;
import com.sap.trex.client.IndexColumnSpec;
import com.sap.trex.client.IndexDocument;
import com.sap.trex.client.IndexDocuments_Request;
import com.sap.trex.client.IndexDocuments_Result;
import com.sap.trex.client.IndexName;
import com.sap.trex.client.IndexService;
import com.sap.trex.client.IndexTableRow;
import com.sap.trex.client.IndexTable_Request;
import com.sap.trex.client.KeyFigure;
import com.sap.trex.client.ListIndex_Request;
import com.sap.trex.client.ListIndex_Result;
import com.sap.trex.client.OlapGuidedNavSearch_Request;
import com.sap.trex.client.OlapGuidedNavSearch_Result;
import com.sap.trex.client.Ping_Request;
import com.sap.trex.client.Ping_Result;
import com.sap.trex.client.QueryEntry;
import com.sap.trex.client.Request;
import com.sap.trex.client.RequestedAttribute;
import com.sap.trex.client.Result;
import com.sap.trex.client.ResultDocument;
import com.sap.trex.client.ResultTable;
import com.sap.trex.client.SearchDocuments_Request;
import com.sap.trex.client.SearchDocuments_Result;
import com.sap.trex.client.SearchTable_Request;
import com.sap.trex.client.SearchTable_Result;
import com.sap.trex.client.ShowIndexInfo_Request;
import com.sap.trex.client.ShowIndexInfo_Result;
import com.sap.trex.client.ShowIndex_Request;
import com.sap.trex.client.ShowIndex_Result;
import com.sap.trex.client.ShowJoinIndex_Request;
import com.sap.trex.client.ShowJoinIndex_Result;
import com.sap.trex.client.TreeNode;
import com.sap.trex.client.UnitConversion;
import com.sap.trex.client.VersionInfo;
import com.sap.trex.client.ViewAttribute;




public class Test extends TestCase {
  
  private Connection itsCon;
  
  public Test(String name) {
      super(name);
  }
  
  public Test(Connection theCon)
  {
     itsCon = theCon;
  }
  
  public void createIndex(String theIndexId, boolean theKeyAttrFlag) throws Exception
  {    
    IndexService anIndexService = new IndexService(itsCon);
    CreateIndex_Request aReq = new CreateIndex_Request();
    IndexName anIndexName = new IndexName();
    anIndexName.setIndexId(theIndexId);
    aReq.setIndexName(anIndexName);    
    AttributeDefinition anAttr = new AttributeDefinition();
    anAttr.setName("attribute1_string");
    anAttr.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_STRING);
    aReq.addAttribute(anAttr);
    AttributeDefinition anAttr2 = new AttributeDefinition();
    anAttr2.setName("attribute2_float");
    anAttr2.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_FLOAT);
    aReq.addAttribute(anAttr2);
    if (theKeyAttrFlag)
      aReq.addKeyAttribute("attribute1_string");
    Result aRes = new Result();
    anIndexService.createIndex(aReq, aRes);
    System.out.println("CreateIndex Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("CreateIndex Error Mess: "+ aRes.getError().getErrorMessage());
  }
  public void indexDocument(String theIndexId) throws Exception
  {    
    IndexService anIndexService = new IndexService(itsCon);
    IndexDocuments_Request aReq = new IndexDocuments_Request();    
    aReq.setIndexId(theIndexId);
    IndexDocument aDoc = new IndexDocument();
    aDoc.setLanguage("EN");
    IndexAttribute anIndexAttribute = new IndexAttribute();
    anIndexAttribute.setName("attribute1_string");
    anIndexAttribute.setValue("This is a string attribute.");
    anIndexAttribute.setType(AttributeType.ATTRIBUTETYPE_STRING);
    aDoc.addAttribute(anIndexAttribute);
    aDoc.setContent("this is the new content!");
    aDoc.setKey("key1");
    aDoc.setAction(DocumentAction.DOCUMENTACTION_INDEX);
    aReq.addDocument(aDoc);    
    aReq.setAutoOptimize(true);
    IndexDocuments_Result aRes = new IndexDocuments_Result();
    anIndexService.indexDocuments(aReq, aRes);   
    System.out.println("IndexDocument Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("IndexDocument Error Mess: "+ aRes.getError().getErrorMessage());
  }
    
  public void deleteIndex(String theIndexId) throws Exception
  {
    IndexService anIndexService = new IndexService(itsCon);
    DeleteIndex_Request aReq = new DeleteIndex_Request();
    IndexName anIndexName = new IndexName();
    Result aRes = new Result();
    anIndexName.setIndexId(theIndexId);   
    aReq.setIndexName(anIndexName);
    anIndexService.deleteIndex(aReq, aRes);
    System.out.println("DeleteIndex Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("DeleteIndex Error Mess: "+ aRes.getError().getErrorMessage());
   
  }
  public void showIndex(String theIndexId) throws Exception
  {
    IndexService anIndexService = new IndexService(itsCon);
    ShowIndex_Request aReq = new ShowIndex_Request();
    IndexName anIndexName = new IndexName();
    ShowIndex_Result aRes = new ShowIndex_Result();
    anIndexName.setIndexId(theIndexId);   
    aReq.setIndexName(anIndexName);
    anIndexService.showIndex(aReq, aRes);
    System.out.println("DeleteIndex Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("DeleteIndex Error Mess: "+ aRes.getError().getErrorMessage());
   
  }
  

  
  public void indexTable(String theIndexId) throws Exception
  {    
    IndexService anIndexService = new IndexService(itsCon);
    IndexTableRow row = new IndexTableRow();
    IndexTable_Request aReq = new IndexTable_Request();
    Result  aRes = new Result();
    aReq.setIndexId(theIndexId);
    aReq.setAutoCommit(true);
    IndexColumnSpec ics = new IndexColumnSpec();
    ics.setName("attribute1_string");
    ics.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_STRING);
    
    IndexColumnSpec ics2 = new IndexColumnSpec();
    ics2.setName("attribute2_float");
    ics2.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_FLOAT);
    aReq.addColumn(ics);
    aReq.addColumn(ics2);
    row.clear();
    row.addString("this is a first test string attribute");
    row.addFloat(3.5F);
    aReq.addRow(row);
    
    anIndexService.indexTable(aReq, aRes);
    System.out.println("IndexTable Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("IndexTable Error Mess: "+ aRes.getError().getErrorMessage());
    
  }
  
  public void listIndexes() throws Exception
  {    
    IndexService anIndexService = new IndexService(itsCon);
    ListIndex_Request aReq = new ListIndex_Request();
    ListIndex_Result aRes = new ListIndex_Result();
    aReq.setType(com.sap.trex.client.IndexType.INDEXTYPE_OLAP);
    anIndexService.listIndexes(aReq, aRes);
    System.out.println("ListIndexes Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("ListIndexes Error Mess: "+ aRes.getError().getErrorMessage());
    for (int i=0;i<aRes.getIndexes().size();i++)
      System.out.println((aRes.getIndexes().get(i)).getName());
  }
  
  public void searchDocuments(String theIndexId) throws Exception
  {
    IndexService anIndexService = new IndexService(itsCon);
    SearchDocuments_Request aReq = new SearchDocuments_Request();
    SearchDocuments_Result aRes = new SearchDocuments_Result();
    IndexName anIndexName = new IndexName();
    anIndexName.setIndexId(theIndexId);
    anIndexName.setLanguage("en");
    aReq.addIndexName(anIndexName);
    QueryEntry aQE = new QueryEntry();
    aQE.setAttribute("attribute1_string");
    aQE.addValue("*string*");
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    aReq.addQueryEntry(aQE);
    aReq.setTo(10);
    RequestedAttribute anReqAttr = new RequestedAttribute();
    anReqAttr.setName("*");
    aReq.addRequestedAttribute(anReqAttr);    
    anIndexService.searchDocuments(aReq, aRes);
    System.out.println("SearchDocuments Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("SearchDocuments Error Mess: "+ aRes.getError().getErrorMessage());
    System.out.println("SearchDocuments No of All Hits: " +  aRes.getNoOfAllHits());
    System.out.println("SearchDocuments IndexSize: " +  aRes.getIndexSize());
    ArrayList <ResultDocument> anIDArray = new ArrayList<ResultDocument> ();
    anIDArray = aRes.getDocuments();
    
    for (ResultDocument doc : anIDArray)
    {
      System.out.println("SearchDocuments DocKey: " +  doc.getKey());      
    }  
  }
  
  public void searchTable(String theIndexId) throws Exception
  {
    IndexService anIndexService = new IndexService(itsCon);
    SearchTable_Request aReq = new SearchTable_Request();
    SearchTable_Result aRes = new SearchTable_Result();
    IndexName anIndexName = new IndexName();
    anIndexName.setIndexId(theIndexId);
    anIndexName.setLanguage("en");
    RequestedAttribute aReqAttribute = new RequestedAttribute();
    aReqAttribute.setName("*");
    aReq.addRequestedAttribute(aReqAttribute);
    aReq.addIndexName(anIndexName);
    QueryEntry aQE = new QueryEntry();
    aQE.setAttribute("attribute1_string");
    aQE.addValue("*string*");
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    aReq.addQueryEntry(aQE);
    aReq.setTo(10);
    anIndexService.searchTable(aReq, aRes);
    System.out.println("SearchTable Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("SearchTable Error Mess: "+ aRes.getError().getErrorMessage());
    System.out.println("SearchTable No of All Hits: " +  aRes.getNoOfAllHits());
    System.out.println("SearchTable IndexSize: " +  aRes.getIndexSize());
    
    ResultTable aResTable = new ResultTable ();
    aResTable = aRes.getTable();
    int j=0;
    while(aResTable.nextRow())
    {      
      while(aResTable.nextColumn())
      {
        System.out.println("SearchTable Attributename: " +  aRes.getAttributes().get(j).getName());
        j++;
        switch (aResTable.getType())
        {
          case com.sap.trex.client.ColumnType.COLUMNTYPE_STRING:
            System.out.println("SearchTable Value: " + aResTable.getStringValue());
            break;
          case com.sap.trex.client.ColumnType.COLUMNTYPE_FLOAT:
            System.out.println(" SearchTable Value: " + aResTable.getFloatValue());
            break;
          case com.sap.trex.client.ColumnType.COLUMNTYPE_INT:
            System.out.println(" SearchTable Value: " + aResTable.getIntValue());
            break;
          case com.sap.trex.client.ColumnType.COLUMNTYPE_NULL:
            System.out.println(" SearchTable Value: <NULL>");
            break;
          default:
            System.out.println("SearchTable Unknown Attribute Type: " + aResTable.getType());
            break;
        }
      } 
       
   }
    
    
  }
  
  public void getVersion() throws Exception
  {
    AdminService anAdminService = new AdminService(itsCon);
    
    GetVersion_Result aRes = new GetVersion_Result();
    Request aReq = new Request();
    anAdminService.getVersion(aReq, aRes);
    System.out.println("GetVersion SAP System Name: " + aRes.getSapsystemName());
    for (VersionInfo info : aRes.getVersionInfos())
    {  
      System.out.println("GetVersion Version: " + info.getVersion());
      System.out.println("GetVersion BuildNr: " + info.getBuildNr());
      System.out.println("GetVersion ChangeList: " + info.getChangeList());      
      System.out.println("GetVersion Sapssytem: " + info.getSapsystem());
      System.out.println("GetVersion Hostname: " + info.getHostName());
    }
  }
 
  public void showJoinIndex(String anIndexId) throws Exception
  {
    IndexService anIndexService = new IndexService(itsCon);
    ShowJoinIndex_Request aReq = new ShowJoinIndex_Request();
    ShowJoinIndex_Result  aRes = new ShowJoinIndex_Result();
    IndexName aName = new IndexName();
    aName.setIndexId(anIndexId);
    aReq.setIndexName(aName);
    anIndexService.showJoinIndex(aReq, aRes);
    
    System.out.println("ShowJoinIndex ErrorCode: " + aRes.getError().getErrorCode());
    System.out.println("ShowJoinIndex ErrorMessage: " + aRes.getError().getErrorMessage());
    for (KeyFigure keyFigure : aRes.getKeyFigures())
    {
      System.out.println("ShowJoinIndex KF Name: " + keyFigure.getName());
      System.out.println("ShowJoinIndex KF Descr: " + keyFigure.getUnitConversionName());
      System.out.println("ShowJoinIndex KF AggrType: " + keyFigure.getAggregationType());      
    } 
    
    for (ViewAttribute viewAttribute : aRes.getViewAttributes())
    {
      System.out.println("ShowJoinIndex VA Name: " + viewAttribute.getName());
      System.out.println("ShowJoinIndex VA Descr: " + viewAttribute.getDescription());
      System.out.println("ShowJoinIndex VA Phys. Name: " + viewAttribute.getAttributeName());
    }
    for (UnitConversion unitConversion: aRes.getUnitConversions()) {
      System.out.println("ShowJoinIndex UC Name: " + unitConversion.getUnitConversionName());
      System.out.println("ShowJoinIndex UC Unit: " + unitConversion.getDestinationUnit());
    }
    
    for (String constraint : aRes.getConstraints()) {
      System.out.println("ShowJoinIndex C Name: " + constraint);
    }
    
    System.out.println("ShowJoinIndex IndexFlags: " + aRes.getIndexFlags());
    
  }
  
  public void olapSearch(String theIndexId) throws Exception
  {
    IndexService anIndexService = new IndexService(itsCon);
    OlapGuidedNavSearch_Request aReq = new OlapGuidedNavSearch_Request();
    OlapGuidedNavSearch_Result aRes  = new OlapGuidedNavSearch_Result();
    
    IndexName anIndexName = new IndexName();
    anIndexName.setIndexId(theIndexId);
    anIndexName.setLanguage("");    
    aReq.addIndexName(anIndexName);
    aReq.setTo(2);
    
    KeyFigure aKeyFigure = new KeyFigure();
    aKeyFigure.setName("quantity");
    aKeyFigure.setAggregationType(AggregationType.AGGREGATIONTYPE_SUM);
    aReq.addKeyFigure(aKeyFigure);
    
    aKeyFigure = new KeyFigure();
    aKeyFigure.setName("revenue");
    aKeyFigure.setAggregationType(AggregationType.AGGREGATIONTYPE_SUM);
    aReq.addKeyFigure(aKeyFigure);
    
    RequestedAttribute aReqAttr1 = new RequestedAttribute();
    aReqAttr1.setName("year");    
    RequestedAttribute aReqAttr2 = new RequestedAttribute();
    aReqAttr2.setName("category");
    aReq.addRequestedAttribute(aReqAttr1);
    aReq.addRequestedAttribute(aReqAttr2);
    
    RequestedAttribute aReqAttr3 = new RequestedAttribute();
    aReqAttr3.setName("line");
    
    QueryEntry aQE = new QueryEntry();
    aQE.setAttribute("category");
    aQE.addValue("Jewelry");
    aQE.setOperator(com.sap.trex.client.Operator.OPERATOR_EQ);
    aQE.setRowType(com.sap.trex.client.RowType.ROWTYPE_ATTRIBUTE);
    
    aReq.addQueryEntry(aQE);
    
    anIndexService.olapGuidedNavSearch(aReq, aRes);
    
    System.out.println("SearchTable Error Code: "+ aRes.getError().getErrorCode());
    System.out.println("SearchTable Error Mess: "+ aRes.getError().getErrorMessage());
    
    
    ResultTable aResTable = new ResultTable ();
    aResTable = aRes.getTable();
    while(aResTable.nextRow())
    {      
      System.out.println("-----------------------------------------------");
      for (int j = 0; aResTable.nextColumn();j++)
      {
        System.out.println("SearchTable Attributename: " +  aRes.getAttributes().get(j).getName());
      
        switch (aResTable.getType())
        {
          case com.sap.trex.client.AttributeType.ATTRIBUTETYPE_STRING:
            System.out.println("  SearchTable String Value: " + aResTable.getStringValue());
            break;
          case com.sap.trex.client.AttributeType.ATTRIBUTETYPE_FLOAT:
            System.out.println("  SearchTable Float Value: " + aResTable.getFloatValue());
            break;
          case com.sap.trex.client.AttributeType.ATTRIBUTETYPE_INT:
            System.out.println(" SearchTable Int Value: " + aResTable.getIntValue());
            break;
          case com.sap.trex.client.AttributeType.ATTRIBUTETYPE_FIXED:
            System.out.println(" SearchTable Fixed Value: " + aResTable.getIntValue());
            break;
          case com.sap.trex.client.AttributeType.ATTRIBUTETYPE_FIXEDSTRING:
            System.out.println(" SearchTable Fixedstring Value: " + aResTable.getIntValue());
            break;  
          case com.sap.trex.client.AttributeType.ATTRIBUTETYPE_TEXT:
            System.out.println(" SearchTable Text Value: " + aResTable.getStringValue());
            break;  
          default:
            System.out.println("SearchTable Unknown Attribute Type: " + aResTable.getType());
            break;
        }
      } 
       
   }
  }
  
  
  public  void showIndexInfo(String queryString) throws Exception {
    IndexService anIndexService = new IndexService(itsCon);
    ShowIndexInfo_Request aReq = new ShowIndexInfo_Request();
    ShowIndexInfo_Result  aRes = new ShowIndexInfo_Result();
    aReq.setQuery(queryString);
    anIndexService.showIndexInfo(aReq, aRes);
    System.out.println("ShowIndexInfo Erorr Code: " + aRes.getError().getErrorCode());
    System.out.println("ShowIndexInfo Erorr Code: " + aRes.getError().getErrorMessage());
    for (TreeNode tn : aRes.getNodes()) {
      System.out.println("ShowIndexInfo TN Level: "+ tn.getLevel());
      System.out.println("ShowIndexInfo TN Name: "+ tn.getName());      
      System.out.println("ShowIndexInfo TN Value: "+ tn.getValue());
      
    }     
    
  }
  
  public static void getDate() {
  //determine current date    
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = new Date();    
    System.out.println("date: " + dateFormat.format(date));    
  }

  public void testPing() throws Exception {
      Connection conn  = new Connection("trex://10.20.159.114:31316");
      AdminService as = new AdminService(conn);
      Ping_Request pReq = new Ping_Request();
      pReq.setPayload(new ArrayList<String>(Arrays.asList(new String[] { "Humba" })));
      Ping_Result pRes = new Ping_Result();
      as.ping(pReq, pRes);
      assertEquals(1, pRes.getPayload().size());
      assertEquals("Humba", pRes.getPayload().get(0));
      System.out.println("TREX Round Trip Time2: "+pRes.getTime2());
  }
  
  public void testAddRow() throws Exception {
      Connection conn  = new Connection("trex://10.20.159.114:31316");
      IndexService anIndexService = new IndexService(conn);
      IndexTableRow row = new IndexTableRow();
      IndexTable_Request aReq = new IndexTable_Request();
      Result  aRes = new Result();
      aReq.setIndexId("jk_areas");
      aReq.setAutoCommit(true);
      IndexColumnSpec ics = new IndexColumnSpec();
      ics.setName("southwestlatscaled");
      ics.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_INT);
      aReq.addColumn(ics);
      ics = new IndexColumnSpec();
      ics.setName("southwestlatscaled");
      ics.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_INT);
      aReq.addColumn(ics);
      ics = new IndexColumnSpec();
      ics.setName("southwestlngscaled");
      ics.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_INT);
      aReq.addColumn(ics);
      ics = new IndexColumnSpec();
      ics.setName("northeastlatscaled");
      ics.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_INT);
      aReq.addColumn(ics);
      ics = new IndexColumnSpec();
      ics.setName("northeastlngscaled");
      ics.setType(com.sap.trex.client.AttributeType.ATTRIBUTETYPE_INT);
      aReq.addColumn(ics);

      row.clear();
      row.addInt(1);
      row.addInt(2);
      row.addInt(3);
      row.addInt(4);
      aReq.addRow(row);
      anIndexService.indexTable(aReq, aRes);
      System.out.println("IndexTable Error Code: "+ aRes.getError().getErrorCode());
      System.out.println("IndexTable Error Mess: "+ aRes.getError().getErrorMessage());
  }
  
  public static void main(String[] args) throws Exception   { 
    Connection aCon  = new Connection("trex://wdfd00170230a:30203");
    Connection aCon2  = new Connection("trexs://wdfn00186368a:30101");

   //System.setProperty("javax.net.debug", "all" );      
   System.setProperty("javax.net.ssl.keyStore", "c:\\work\\ssl\\java\\keystore.jks" );      
   System.setProperty("javax.net.ssl.keyStorePassword", "trextrex" );      
   //System.setProperty("javax.net.ssl.trustStore", "c:\\work\\ssl\\java\\truststore" );      
   //System.setProperty("javax.net.ssl.trustStorePassword", "trextrex" );      
   
   getDate();
   Test t = new Test(aCon);
   Test t2 = new Test(aCon2);
  //t.showIndex("col_octocsgs3_ps");
  //t.showJoinIndex("y1w_0bwvc_ag2_ps");
  //t.showIndexInfo("IndexInfo+Index=*!+indexFlags=1");
   t.getVersion();
   t2.getVersion();
   /*t.deleteIndex("indexdocument");
   t.deleteIndex("indextable");
   
   t.createIndex("indexdocument", false);
   t.indexDocument("indexdocument");
   t.searchDocuments("indexdocument");
   */
   //t.createIndex("indextable", true);
   //t.indexTable("indextable");   
   //t.searchTable("indextable");
   
   
   //t.olapSearch("efashion_small");
   
   //t.listIndexes();
  /* t.getCubeSchema("bobj_efashion");*/
    
    //t.streamSearch();
    
  
   
  }
  
}