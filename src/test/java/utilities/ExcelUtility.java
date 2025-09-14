package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	public String path;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws IOException {
		fis= new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetname, int rowno) throws IOException {
		fis= new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet= wb.getSheet(sheetname);
		row=sheet.getRow(rowno);
		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
		
	}
	
	public String getCellData(String sheetname, int rowno, int cellno) throws IOException {
		fis= new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet= wb.getSheet(sheetname);
		row=sheet.getRow(rowno);
		cell=row.getCell(cellno);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e){
			data="";
		}
		
		wb.close();
		fis.close();		
		return data;
		
	}
	
	public void setCellData(String sheetname,int rownum, int cellnum, String data) throws IOException {
		File newfile= new File(path);
		if(!newfile.exists()) { //If file not exists create new file
			wb= new XSSFWorkbook();
			fos=new FileOutputStream(path);
			wb.write(fos);			
		}
		
		fis= new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		
		if(wb.getSheet(sheetname)==null) {//if sheet not exist create new sheet
			wb.createSheet(sheetname);
		}
		sheet = wb.getSheet(sheetname);
		
		if(sheet.getRow(rownum)==null) { //if row not exists create new Row
			sheet.createRow(rownum);
		}
		
		row= sheet.getRow(rownum);
		
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fos= new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
		
	}
	
	public void fillGreenColor(String sheetname,int rowno, int cellno) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet= wb.getSheet(sheetname);
		row=sheet.getRow(rowno);
		cell=row.getCell(cellno);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos= new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	public void fillRedColor(String sheetname,int rowno, int cellno) throws IOException {
		fis= new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rowno);
		cell=row.getCell(cellno);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos= new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	

}
