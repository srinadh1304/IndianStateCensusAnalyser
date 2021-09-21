package com.bridgelabz.indianstatecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.bridgelabz.indianstatecensusanalyser.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser 
{
	 public int loadIndianCensusData(String csvFilePath) throws CensusAnalyserException 
	 {

	    try 
	    {
	    	if(csvFilePath.contains(".txt")) 
	    	{
    			throw new CensusAnalyserException("File must be in CSV Format", ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
    		}
    		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
    		CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilderObject = new CsvToBeanBuilder<CSVStateCensus>(reader);
    		csvToBeanBuilderObject.withType(CSVStateCensus.class);
    		csvToBeanBuilderObject.withIgnoreLeadingWhiteSpace(true);
    		CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilderObject.build();
    		Iterator<CSVStateCensus> csvIteratorObject = csvToBean.iterator();
    		int numberOfEntries = 0;
    		while(csvIteratorObject.hasNext()) 
    		{
    			numberOfEntries++;
    			CSVStateCensus censusData = csvIteratorObject.next();
    		}
    		return numberOfEntries;		
	    }
	    catch(IOException e) 
	    {
	    	throw new CensusAnalyserException(e.getMessage(), ExceptionType.CENSUS_FILE_PROBLEM);
	    }
	    catch(RuntimeException e) 
	    {
	    	throw new CensusAnalyserException("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER);
	    }
	}
	 public int loadIndianStateCode(String csvFilePath) throws CensusAnalyserException 
	 {
	    	
	        try 
	        {
	        	if(csvFilePath.contains(".txt")) 
	        	{
	        		throw new CensusAnalyserException("File must be in CSV Format!", ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
	        	}
	        	
	        	Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
	            CsvToBeanBuilder<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder<CSVStates>(reader);
	            csvToBeanBuilder.withType(CSVStates.class);
	            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
	            CsvToBean<CSVStates> csvToBean = csvToBeanBuilder.build();
	            Iterator<CSVStates> stateCodesCSVIterator = csvToBean.iterator();
	            
	            int numberOfEntries = 0;
	    		while(stateCodesCSVIterator.hasNext()) 
	    		{
	    			numberOfEntries++;
	    			CSVStates censusData = stateCodesCSVIterator.next();
	    		}
	    		return numberOfEntries;
	        } 
	        catch (IOException e) 
	        {
	            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	        } 
	        catch(RuntimeException e) 
	        {
	    		throw new CensusAnalyserException(e.getMessage(), ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER);
	    	}
	    }
	 
}
