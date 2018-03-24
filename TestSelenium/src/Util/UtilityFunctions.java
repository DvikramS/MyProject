package Util;

import java.util.Hashtable;



public class UtilityFunctions {

	
	public static boolean isExecutable(String testName, ExcelUtilities xls){
		for(int i=2;i<=xls.getRowCount("TestCases");i++){
			if(testName.equalsIgnoreCase(xls.getCellData("TestCases", "TCID", i))){
				if(xls.getCellData("TestCases", "RunMode", i).equalsIgnoreCase("Y"))
					return true;
			}
		}
		
		return false;
		
	}
	
	public static Object[][] getData(String testName, ExcelUtilities xls){
		int testcasestartindex=0;
		
		for(int i=1;i<=xls.getRowCount("TestData");i++){
			if(testName.equalsIgnoreCase(xls.getCellData("TestData", 1, i))){
				testcasestartindex=i;
				break;
			}
		}
		int testdatacolumns=2;
		int testdatastartindex=testcasestartindex+2;
int testdatacolumnstartindex=testcasestartindex+1;
while(!xls.getCellData("TestData", testdatacolumns,testdatacolumnstartindex ).equals("")){
	testdatacolumns++;
}
int numberoftestdatacolumns=testdatacolumns-2;
int testdataset=0;
while(!xls.getCellData("TestData", 2, testdatastartindex+testdataset).equals("")){
	testdataset++;
}
Object[] []datacollection=new Object[testdataset][1];
Hashtable<String, String> hs=null;
String datakey="";
String keyvalue="";
int index=0;
for(int i=testdatastartindex;i<(testdatastartindex+testdataset);i++){
	hs=new Hashtable<String, String>();
	for(int j=2;j<numberoftestdatacolumns+2;j++){
		datakey=xls.getCellData("TestData", j, testdatacolumnstartindex);
		keyvalue=xls.getCellData("TestData", j, i);
		hs.put(datakey, keyvalue);
	}
	datacollection[index][0]=hs;
	index++;
}

		
	
		
		
		
		
		
		return datacollection;
		
	}
	
}
