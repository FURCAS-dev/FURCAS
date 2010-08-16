package com.sap.runlet.interpreter.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.sap.runlet.interpreter.rucola.Entity;
import com.sap.runlet.interpreter.rucola.Function;
import com.sap.runlet.interpreter.rucola.Rucola;
import com.sap.runlet.interpreter.rucola.RucolaObject;
import com.sap.runlet.interpreter.rucola.Value;

public class RucolaTests extends TestCase {
    private Rucola rucola;
    
    @Override
    public void setUp() {
	rucola = new Rucola(Activator.createConnection("ngpm.stdlib"));
    }
    
    public void testSimpleEntityCreationAndAssocMethodCall() {
	Entity org = rucola.newEntity("Organization");
	Entity person = rucola.newEntity("Person");
	org.call("persons+=", person);
	RucolaObject persons = org.call(".persons");
	assertEquals(1, persons.size());
	assertEquals(person, persons);
    }
    
    public void testPassingString() {
	Entity city = rucola.newEntity("City");
	city.set("name", "Mannheim");
	String cityName = city.call(".name").asString();
	assertEquals("Mannheim", cityName);
    }
    
    public void testFunctionCall() {
	Entity cellSetTest = rucola.newEntity("CellSetTest");
	Function cellSet = (Function) cellSetTest.call("getCellSet");
	Entity organizations = cellSetTest.call("createOrganizations").asEntity();
	assertEquals(2, organizations.size());
	RucolaObject persons = organizations.call(".persons");
	int result = cellSet.call(persons, "Mannheim", "John").asInt();
	assertEquals(2, result);
    }
    
    public void testStructuredValue() {
	Map<String, Object> values = new HashMap<String, Object>();
	Entity city = rucola.newEntity("City");
	city.set("name", "Dallas");
	values.put("street", "4711 Main Street");
	values.put("city", city);
	Value address = rucola.value("Address", values);
	assertEquals("4711 Main Street", address.get("street").asString());
	assertEquals("Dallas", address.get("city").asEntity().get("name").asString());
    }

    public void testEntityId() {
	Entity city = rucola.newEntity("City");
	city.set("name", "Dallas");
	String cityId = city.getId();
	Entity restoredCity = rucola.getEntityById(cityId);
	assertEquals("Dallas", restoredCity.get("name").asString());
    }
}
