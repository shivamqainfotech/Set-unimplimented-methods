package com.qainfotech.tap.training.resourceio.model;

import java.util.Map;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class Individual {
    
    private final String name;
    private final Integer id;
    private final Boolean active;
    
    public Individual(Map<String, Object> individualMap){
       // throw new UnsupportedOperationException("Not implemented.");
    this.name= individualMap.get("name").toString();
    this.active=(Boolean) individualMap.get("active");
    this.id=Integer.parseInt(individualMap.get("id").toString());
    }
  
    
    @Override
	public String toString() {
		return "Individual [name=" + name + ", id=" + id + ", active=" + active + "]";
	}
	/**
     * get the name of individual
     * 
     * @return individual name
     */
    public String getName(){
        return name;
    }
    
    /**
     * get the employee of of individual
     * @return id
     */
    public Integer getId(){
        return id;
    }
    
    /**
     * get the active status of individual
     * 
     * @return 
     */
    public Boolean isActive(){
    	if(this.active.booleanValue()==true){
    		
    	return true;
    	}
		return false;
    }
}
