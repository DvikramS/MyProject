package Util;

import java.io.File;





import java.io.FileInputStream;
import java.io.FileOutputStream;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelUtilities {

	
	private XSSFWorkbook wb;
	private XSSFSheet sh;
	private XSSFRow rw;
	private XSSFCell cl;
	public String path;
	public FileInputStream fi=null;;
	public FileOutputStream fo=null;;
	
	public ExcelUtilities(String path) {
		this.path=path;
		try{
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheetAt(0);
		fi.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getRowCount(String sheet){
		
		int index=wb.getSheetIndex(sheet);
		
		if(index==-1)
			return 0;
		else{
			sh=wb.getSheetAt(index);
			int number=sh.getLastRowNum()+1;
			return number;
		}
		
	
	}
	
	public String getCellData(String sheet, String colname, int rowN){
		if(rowN<=0)
			return "";
		int index=wb.getSheetIndex(sheet);
		if(index==-1)
			return"";
		sh=wb.getSheetAt(index);
		rw=sh.getRow(0);
		int colnum=-1;
		for(int i=0;i<rw.getLastCellNum();i++){
			if(rw.getCell(i).getStringCellValue().equalsIgnoreCase(colname)){
				colnum=i;
			}
		}
		if (colnum==-1)
				return "";
		rw=sh.getRow(rowN-1);
		if(rw==null)
			return"";
		cl=rw.getCell(colnum);
		if(cl==null){
			return "";
		}
		if(cl.getCellType()==cl.CELL_TYPE_STRING){
			
			return cl.getStringCellValue();
		}
		return cl.getStringCellValue();
		
		
	}
	public String getCellData(String sheet, int colN, int rowN){
		int index=wb.getSheetIndex(sheet);
		if (index==-1)
			return"";
		sh=wb.getSheetAt(index);
		if(sh==null)
			return"";
		rw=sh.getRow(rowN-1);
		if(rw==null)
			return "";
		cl=rw.getCell(colN-1);
		if(cl==null)
			return "";
		if(cl.getCellType()==cl.CELL_TYPE_STRING){

			return cl.getStringCellValue();
		}
		return cl.getStringCellValue();
		
	}
	/*public static void main(String[] args) {
		//ExcelUtility ex=new ExcelUtility("C:\\Users\\Dhirendrasingh\\Desktop\\MyFrameWork\\MyFramework\\TestData.xlsx");
		BasePage.xls.getRowCount("TestData");
		BasePage.xls.getCellData("TestCases", 1, 3);
	}*/
}