package com.qainfotech.tap.training.resourceio.model;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.qainfotech.tap.training.resourceio.TeamsJsonReader;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class Team {

	private final String name;
	private final Integer id;
	private final List<Individual> members;
	TeamsJsonReader rdr = new TeamsJsonReader();

	@SuppressWarnings("unchecked")
	public Team(Map<String, Object> teamMap) {
		// throw new UnsupportedOperationException("Not implemented.");
		this.name = (String) teamMap.get("name");
		this.id = Integer.parseInt(teamMap.get("id").toString());
		this.members = (List<Individual>) teamMap.get("members");
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", id=" + id + ", members=" + members + "]";
	}

	/**
	 * get team name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * get team id
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * get list of individuals that are members of this team
	 * 
	 * @return
	 */
	public List<Individual> getMembers() {
		return members;
	}

	/**
	 * get a list of individuals that are members of this team and are also
	 * active
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Individual> getActiveMembers() {
		List<Individual> s = new ArrayList<>();
		//List<Individual> list1 = new ArrayList<>();
		        Iterator <Individual> itr = members.iterator();
		        while (itr.hasNext()) {
		        	
		             Individual ind = itr.next();
		             Boolean a = true;
		 
		             Boolean b = ind.isActive();
		 
		             if (a == b) {
		 
		                 s.add(ind);
		             }
		 
		         }
		 
		         return s;
	}
		/*List<Individual> idList = new ArrayList<>();
		System.out.println(rdr.getListOfActiveIndividuals());
	System.out.println(members);
	     return s;
	}*/
	/**
	 * get a list of individuals that are members of this team but are inactive
	 * 
	 * @return
	 */
	public List<Individual> getInactiveMembers() {
		throw new UnsupportedOperationException("Not implemented.");
	}

	/*
	 * public static void main(String[] args) { //Team team=new Team();
	 * 
	 * }
	 */
}
