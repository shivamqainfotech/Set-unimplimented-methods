package com.qainfotech.tap.training.resourceio;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsJsonReader {
	List<Team> teamList = null;
	Map<String, Object> teamMap=null;
	List<Individual> individualList = null;
	JSONParser parser = new JSONParser();

	/**
	 * get a list of individual objects from db json file
	 * 
	 * @return
	 */
	public List<Individual> getListOfIndividuals() {
		//throw new UnsupportedOperationException("Not implemented.");
		JSONObject individualObj;
		Individual obj2;
		teamMap=new HashMap<>();
		
		try {

			Object obj = parser.parse(
					new FileReader("D:\\Assignment2\\assignment-resource-io-master\\src\\main\\resources\\db.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray myfirst = (JSONArray) jsonObject.get("individuals");
			//System.out.println(myfirst.get(0));
			individualList=new ArrayList<>();
			for (int a = 0; a < myfirst.size(); a++) {
				individualObj = (JSONObject) myfirst.get(a);
				 teamMap=(Map<String, Object>) individualObj.clone();
				 obj2=new Individual(teamMap);
				individualList.add(obj2);
				
			}
			
			//System.out.println(individualList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return individualList;
	}
	

	/**
	 * get individual object by id
	 * 
	 * @param id
	 *            individual id
	 * @return
	 * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException
	 */
	public Individual getIndividualById(Integer id) throws ObjectNotFoundException {
		
		throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * get individual object by name
	 * 
	 * @param name
	 * @return
	 * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException
	 */
	public Individual getIndividualByName(String name) throws ObjectNotFoundException {
		throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * get a list of individual objects who are not active
	 * 
	 * @return List of inactive individuals object
	 */
	public List<Individual> getListOfInactiveIndividuals() {
		throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * get a list of individual objects who are active
	 * 
	 * @return List of active individuals object
	 */
	public List<Individual> getListOfActiveIndividuals() {
		List<Individual> idList = new ArrayList<>();
		int n=TeamsJsonReader.this.getListOfIndividuals().size();
		for (int i = 0; i <n; i++) {
			if (TeamsJsonReader.this.getListOfIndividuals().get(i).isActive()) {
				//System.out.println(rdr.getListOfIndividuals().get(i));
				idList.add(TeamsJsonReader.this.getListOfIndividuals().get(i));
				individualList=(List<Individual>)(Object)idList; 
				 
			}
			//return s;
		}
		return individualList;
		// throw new UnsupportedOperationException("Not implemented.");
	}


	/**
	 * get a list of team objects from db json
	 * 
	 * @return
	 */
	public List<Team> getListOfTeams() {
		JSONObject jsonObj;
		Team teamObject = null;
		try {

			teamList = new ArrayList<Team>();
			Object obj = parser.parse(
					new FileReader("D:\\Assignment2\\assignment-resource-io-master\\src\\main\\resources\\db.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray myfirst = (JSONArray) jsonObject.get("teams");
		
			teamList= new ArrayList<>();
			teamMap=new HashMap<>();
			for (int a = 0; a < myfirst.size(); a++) {
				jsonObj = (JSONObject) myfirst.get(a);
				teamMap=(Map<String, Object>) jsonObj.clone();
				teamObject = new Team(teamMap);
				teamList.add(teamObject);
				//System.out.println(teamObject);
				
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	
		return teamList;
		// throw new UnsupportedOperationException("Not implemented.");
	}

	public static void main(String... S) {
		TeamsJsonReader myobj = new TeamsJsonReader();
		//System.out.println(myobj.getListOfActiveIndividuals());
		System.out.println(myobj.getListOfTeams().get(0).getActiveMembers());
		//myobj.getListOfActiveIndividuals();
		//myobj.getListOfIndividuals();
		 

	}

}