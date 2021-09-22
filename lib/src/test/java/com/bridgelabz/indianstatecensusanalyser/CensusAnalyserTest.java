package com.bridgelabz.indianstatecensusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest 
{
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/CensusDataInWrongFormat.txt";
	private static final String CSV_WITH_WRONG_DELIMITER = "./src/test/resources/CensusDataWithWrongDelimiter.csv";
	private static final String CSV_WITH_INCORRECT_HEADER = "./src/test/resources/CensusDataIncorrectHeader.csv";

	private static final String INDIAN_STATE_CODES = "./src/test/resources/IndianStateCode.csv";
	private static final String INDIAN_STATE_CODES_WITH_WRONG_FILEPATH = "./src/main/resources/IndianStateCodes.csv"; 	
	private static final String INDIAN_STATE_CODES_WITH_WRONG_FILE_FORMAT = "./src/test/resources/IndianStateCodesWithWrongFormat.txt";
	private static final String INDIAN_STATE_CODES_WITH_WRONG_DELIMITER = "./src/test/resources/IndianStateCodesWithWrongDelimiter.csv";
	private static final String INDIAN_STATE_CODES_WITH_WRONG_HEADER = "./src/test/resources/IndianStateCodesWithWrongHeader.csv";
	
	@Test
	public void givenStateCensusCSVFile_ShouldReturn_NumberOfRecords() 
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
	public void givenStateCensusCSVFile_WithIncorrectPath_ShouldThrowException() 
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

		}
	}
	@Test
	public void givenStateCensusCSVFile_WithWrongFileFormat_ShouldThrowException() 
	{
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(INCORRECT_FILE_FORMAT);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
			e.printStackTrace();
		}
	}
	@Test
	public void givenStateCensusCSVFile_WhenCorrectButIncorrectDelimiter_ShouldThrowException() 
	{
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(CSV_WITH_WRONG_DELIMITER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
	}
	@Test
	public void givenStateCensusCSVFile_WhenCorrectButHeaderIncorrect_ShouldThrowException() 
	{

		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianCensusData(CSV_WITH_INCORRECT_HEADER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
	}
	@Test
	public void givenIndianStateCodeCSVFile_ShouldReturn_NumberOfRecords() 
	{
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES);
			Assert.assertEquals(37,numOfRecords);
		} 
		catch (CensusAnalyserException e) 
		{ 
			e.printStackTrace();
		}
	}
	@Test
	public void givenIndianStateCodeCSVFile_WithIncorrectFilePath_ShouldThrowException() 
	{
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_FILEPATH);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}
	@Test
	public void givenIndianStateCodeCSVFile_WithWrongFileFormat_ShouldThrowException() 
	{
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_FILE_FORMAT);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
			e.printStackTrace();
		}
	}
	@Test
	public void givenIndianStateCodeCSVFile_WithIncorrectDelimiter_ShouldThrowException() 
	{
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_DELIMITER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
	}
	@Test
    public void givenIndianStateCodeCSVFile_IncorrectHeader_ShouldThrowException() 
    {
		try 
		{
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndianStateCode(INDIAN_STATE_CODES_WITH_WRONG_HEADER);
		} 
		catch (CensusAnalyserException e) 
		{
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_HEADER, e.type);
			e.printStackTrace();
		}
    }
}