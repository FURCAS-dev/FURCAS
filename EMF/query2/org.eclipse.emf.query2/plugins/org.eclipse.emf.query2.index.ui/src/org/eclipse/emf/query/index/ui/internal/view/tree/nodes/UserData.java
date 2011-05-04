package org.eclipse.emf.query.index.ui.internal.view.tree.nodes;

import java.util.ArrayList;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((res == null) ? 0 : res.hashCode());
		result = prime * result
				+ ((userData == null) ? 0 : userData.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
		if (res == null) {
			if (other.res != null)
				return false;
		} else if (!res.equals(other.res))
			return false;
		if (userData == null) {
			if (other.userData != null)
				return false;
		} else if (!userData.equals(other.userData))
			return false;
		return true;
	}
	

	
	
}
