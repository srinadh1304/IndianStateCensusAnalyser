package com.bridgelabz.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest 
{
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
  	
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
  	 @Test
 	public void givenStateCensusCSVFile_WhenIncorrect_ShouldThrowException() 
     {
 		try 
 		{
 			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
 			ExpectedException exceptionRule = ExpectedException.none();
 			exceptionRule.expect(CensusAnalyserException.class);
 			censusAnalyser.loadIndianCensusData(WRONG_CSV_FILE_PATH);
 		} 
 		catch (CensusAnalyserException e) 
 		{
 			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
 			e.printStackTrace();
 		}
 	}
    
}