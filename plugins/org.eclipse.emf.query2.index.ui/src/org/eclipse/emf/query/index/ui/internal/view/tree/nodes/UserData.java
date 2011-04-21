package org.eclipse.emf.query.index.ui.internal.view.tree.nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.query.index.ui.internal.properties.IndexViewProperty;

public class UserData {

	private ArrayList<IndexViewProperty> userData;
	private Object res;

	public UserData(Object resource){
		userData = new ArrayList<IndexViewProperty>();
		res = resource;
	}
	
	public ArrayList<IndexViewProperty> getUserData() {
		return userData;
	}
	
	public Object getRes() {
		return res;
	}
	
	
}
