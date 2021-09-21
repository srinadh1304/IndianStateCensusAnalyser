package com.bridgelabz.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest 
{
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
  	@Test
    public void givenStateCensusCSVFile_ShouldReturn_CorrectNumberOfRecords() 
    {
        try 
        {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndianCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } 
        catch (CensusAnalyserException e) 
        { 
        	e.printStackTrace();
        }
    }
    
}