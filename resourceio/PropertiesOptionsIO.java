package com.qainfotech.tap.training.resourceio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class PropertiesOptionsIO{
	Properties prop ;
	InputStream in;
    public Object getOptionValue(String optionKey) throws IOException {
    	
		return prop.getProperty(optionKey);
		
        //throw new UnsupportedOperationException("Not implemented.");
    }

    public void addOption(String optionKey, String optionValue) throws IOException {
    	prop = new Properties();
		in = getClass().getResourceAsStream("/options.properties");
		prop.load(in);
		prop.setProperty(optionKey, optionValue);
		prop.store(new FileOutputStream("D:\\Assignment2\\assignment-resource-io-master\\src\\main\\resources\\options.properties"), "Written");
		
    
    }
}
