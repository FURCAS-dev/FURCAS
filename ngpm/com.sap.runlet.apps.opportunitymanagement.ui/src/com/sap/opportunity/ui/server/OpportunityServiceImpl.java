package com.sap.opportunity.ui.server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sap.opportunity.ui.client.ExpectedSalesDTO;
import com.sap.opportunity.ui.client.OpportunityDTO;
import com.sap.opportunity.ui.client.OpportunityService;
import com.sap.opportunity.ui.client.SalesByMonthDTO;
import com.sap.runlet.interpreter.rucola.Entity;
import com.sap.runlet.interpreter.rucola.Function;
import com.sap.runlet.interpreter.rucola.Rucola;
import com.sap.runlet.interpreter.rucola.RucolaObject;
import com.sap.runlet.interpreter.rucola.Value;
import com.sap.runlet.tomcat.Activator;

/**
 * The server side implementation of the RPC service.
 */
public class OpportunityServiceImpl extends RemoteServiceServlet implements OpportunityService {
    private static final long serialVersionUID = -3807719400704313470L;
    List<Value> months = new ArrayList<Value>(4);
    List<String> phases = new ArrayList<String>(3);
    
    public void init(ServletConfig config) throws ServletException {
	super.init(config);
	
	// init months list
	GregorianCalendar cal = new GregorianCalendar();
	Rucola rucola = new Rucola(Activator.createConnection("com.sap.runlet.apps.opportunitymanagement"),
		Activator.getDefault().getRunletDataStore());
	Map<String, Object> mmap = new HashMap<String, Object>();
	for (int i = 0; i < 4; i++) {
	    mmap.put("year", cal.get(Calendar.YEAR));
	    mmap.put("month", cal.get(Calendar.MONTH));
	    months.add(rucola.value("MonthAndYear", mmap));
	    mmap.clear();
	    cal.add(Calendar.MONTH, 1);
	}
	
	// init phase list
	phases.add("Initial");
	phases.add("Decision Making");
	phases.add("Final Phase");
    }
    
    /**
     * Creates a new {@link Rucola} connector with a new {@link RiverInterpreter} but based
     * on the data store obtained from the surrounding servlet container.
     */
    private Rucola createRucola() {
	return new Rucola(Activator.createConnection("com.sap.runlet.apps.opportunitymanagement"),
		Activator.getDefault().getRunletDataStore());
    }
    
    public List<OpportunityDTO> getOpportunities() {
	Rucola rucola = createRucola();
	Value reports = rucola.value("Reports");
	Entity allOpportunities = (Entity) reports.call("getAllOpportunities");
	List<OpportunityDTO> opps = new ArrayList<OpportunityDTO>();
	
	for (RucolaObject opportunity : allOpportunities) {
	    Entity opportunityEntity = opportunity.asEntity();
	    OpportunityDTO o = createOpportunityDTO(opportunityEntity);
	    opps.add(o);
	}
	return opps;
    }

    @Override
    public List<OpportunityDTO> getOpportunities(int minRevenue) {
	List<OpportunityDTO> opps = getOpportunities();
	filterByRevenue(minRevenue, opps);
	return opps;
    }

    @Override
    public List<OpportunityDTO> getOpportunities(String phase) {
    	List<OpportunityDTO> opps = getOpportunities();
    	filterByPhase(phase, opps);
    	return opps;
    }


    @Override
    public List<OpportunityDTO> getOpportunities(int minRevenue, String phase) {
    	List<OpportunityDTO> opps = getOpportunities();
    	filterByPhase(phase, opps);
    	filterByRevenue(minRevenue, opps);
    	return opps;
    }

    @Override
    public List<OpportunityDTO> getHistoricOpportunities(Date transactionTime) {
	Rucola rucola = createRucola();
	Value reports = rucola.value("Reports");
	Entity allOpportunities = reports.call("getAllOpportunitiesAt", transactionTime).asEntity();

	List<OpportunityDTO> opps = new ArrayList<OpportunityDTO>();
	for (RucolaObject opportunity : allOpportunities) {
	    Entity opportunityEntity = opportunity.asEntity();
	    OpportunityDTO o = createOpportunityDTO(opportunityEntity);
	    opps.add(o);
	}
	return opps;
    }

    @Override
    public List<OpportunityDTO> getHistoricOpportunities(Date transactionTime, int minRevenue) {
	List<OpportunityDTO> opps = getHistoricOpportunities(transactionTime);
	filterByRevenue(minRevenue, opps);
	return opps;
    }

    @Override
    public List<OpportunityDTO> getHistoricOpportunities(Date transactionTime, String phase) {
	List<OpportunityDTO> opps = getHistoricOpportunities(transactionTime);
	filterByPhase(phase, opps);
	return opps;
    }

    @Override
    public List<OpportunityDTO> getHistoricOpportunities(Date transactionTime, int minRevenue, String phase) {
	List<OpportunityDTO> opps = getHistoricOpportunities(transactionTime);
	filterByPhase(phase, opps);
	filterByRevenue(minRevenue, opps);
	return opps;
    }

    private OpportunityDTO createOpportunityDTO(Entity opportunityEntity) {
	OpportunityDTO o = new OpportunityDTO(opportunityEntity.getId(),
	    opportunityEntity.get("description").asString(),
	    opportunityEntity.get("prospect").asEntity().get("name").asString(),
	    opportunityEntity.get("phase").asString(),
	    formatCompetitors(opportunityEntity.get("competitors").asEntity()),
	    opportunityEntity.get("expectedCloseDate").asDate(),
	    opportunityEntity.get("responsible").asEntity().get("name").asString(),
	    opportunityEntity.get("expectedSalesVolume").asValue().get("val").asInt(),
	    opportunityEntity.get("probability").asFraction().asFloat());
	return o;
    }

    private String formatCompetitors(Entity competitors) {
	StringBuilder result = new StringBuilder();
	boolean needComma = false;
	for (RucolaObject businessPartner : competitors) {
	    Entity businessPartnerEntity = businessPartner.asEntity();
	    if (needComma) {
		result.append(", ");
	    } else {
		needComma = true;
	    }
	    result.append(businessPartnerEntity.get("name").asString());
	}
	return result.toString();
    }

    @Override
    public void updateOpportunities(List<OpportunityDTO> dtos) {
	// TODO only update properties that really changed
	Rucola rucola = createRucola();
	Value reports = rucola.value("Reports");
	for (OpportunityDTO oDto : dtos) {
	    Entity opportunity;
	    if (oDto.id != null) {
		opportunity = rucola.getEntityById(oDto.id);
	    } else {
		opportunity = rucola.newEntity("Opportunity");
		rucola.store(opportunity);
	    }
	    opportunity.set("prospect", reports.call("findOrCreateBusinessPartner", oDto.prospect));
	    opportunity.set("description", oDto.description);
	    opportunity.set("phase", oDto.phase);
	    opportunity.set("expectedCloseDate", oDto.closeDate);
	    opportunity.set("responsible", reports.call("findOrCreateEmployee", oDto.responsibleEmployee));
	    opportunity.call("competitors-=", opportunity.get("competitors"));
	    for (String competitor : oDto.competitors.split(",")) {
		opportunity.call("competitors+=", reports.call("findOrCreateBusinessPartner", competitor.trim()));
	    }
	    Map<String, Object> currencyInit = new HashMap<String, Object>();
	    currencyInit.put("code", "USD");
	    Value currency = rucola.value("Currency", currencyInit);
	    Map<String, Object> amountInit = new HashMap<String, Object>();
	    amountInit.put("val", oDto.expectedSalesVolume);
	    amountInit.put("currency", currency);
	    Value amount = rucola.value("Amount", amountInit);
	    opportunity.set("expectedSalesVolume", amount);
	    opportunity.set("probability", oDto.probability);
	}
	rucola.commit();
    }

    @Override
    public List<SalesByMonthDTO> getChartData() {
	Rucola rucola = createRucola();
	Value reports = rucola.value("Reports");
	Entity opps = (Entity) reports.call("getAllOpportunities");

	return retrieveChartData(reports, opps);
    }

    @Override
    public List<SalesByMonthDTO> getChartData(Date transactionTime) {
	Rucola rucola = createRucola();
	Value reports = rucola.value("Reports");
	Entity opps = (Entity) reports.call("getAllOpportunitiesAt", transactionTime);

	return retrieveChartData(reports, opps);
    }
    
    private List<SalesByMonthDTO> retrieveChartData(Value reports, Entity opps) {
	System.out.println("Chart: found opportunities: " + opps.size());
	
	Function f = reports.call("getExpectedRevenueByMonthAndPhaseCube").asFunction();
	
	List<SalesByMonthDTO> sbm = new ArrayList<SalesByMonthDTO>(4);
	for (Value month : months) {
	    SalesByMonthDTO sales = new SalesByMonthDTO();
	    sales.month = month.get("month").asInt() + " / " + month.get("year").asInt();
	    System.out.println(" > month: " + sales.month);
	    sales.sales = new ArrayList<ExpectedSalesDTO>(3);
	    
	    for (String phase : phases) {
		ExpectedSalesDTO es = new ExpectedSalesDTO();
		Value amount = f.call(opps, month, phase).asValue(); 
		es.phase = phase;
		es.expectedVolume = amount.get("val").asInt();
		System.out.println(amount);
		System.out.println("  > phase: " + es.phase);
		System.out.println("  > val  : " + es.expectedVolume);
		sales.sales.add(es);
	    }
	    sbm.add(sales);
	}
	return sbm;
    }

    private void filterByPhase(String phase, List<OpportunityDTO> opps) {
	for (Iterator<OpportunityDTO> it = opps.iterator(); it.hasNext();) {
    		OpportunityDTO dto = it.next();
    		if (!dto.phase.equals(phase)) {
    			it.remove();
    		}
    	}
    }

    private void filterByRevenue(int minRevenue, List<OpportunityDTO> opps) {
	for (Iterator<OpportunityDTO> it = opps.iterator(); it.hasNext();) {
    		OpportunityDTO dto = it.next();
    		if (dto.expectedSalesVolume < minRevenue) {
    			it.remove();
    		}
    	}
    }
}
