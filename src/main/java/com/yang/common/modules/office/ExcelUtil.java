package com.yang.common.modules.office;

import com.yang.common.modules.props.PropsKeys;
import com.yang.common.modules.props.PropsUtil;
import com.yang.common.modules.string.StringPool;
import com.yang.common.modules.time.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExcelUtil {

	public static String createExcel(List<Object[]> data,String[] title) throws Exception{
		return createExcel(data,title,null);
	}
	public static String createExcel(List<Object[]> data,String[] title,String sheetName) throws Exception{
		String filePath = createExcelFilePath();
		FileOutputStream fileos = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();

			XSSFSheet sheet;
			if(sheetName!=null) {
				sheet = workbook.createSheet(sheetName);
			}else {
				sheet = workbook.createSheet();
			}
			writeRow(title, sheet.createRow(0));

			writeRows(data, sheet, 1);


			fileos = new FileOutputStream(filePath);
			workbook.write(fileos);

		} catch (Exception e) {
			throw e;
		} finally{
			if(fileos!=null) fileos.close();
		}

		return filePath;
	}

	public static String createExcel(Long userId,String namespace,String[] sheets,List<Object[]> title,List<Object[]> ...lists) throws IOException {
		if (lists == null || lists.length==0) {
			return null;
		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		for (int i = 0; i < lists.length; i++) {
			XSSFSheet sheet = workbook.createSheet(sheets[i]);
			writeRowObject(title.get(i), sheet.createRow(0));
			writeRowsObject(lists[i], sheet, 1);
		}
		String filePath = createExcelFilePathForReport(namespace,userId);
		//System.out.println("filePath=======>>"+filePath);
		FileOutputStream fileos = new FileOutputStream(filePath);
		workbook.write(fileos);
		return filePath;
	}
	private static void writeRowObject(Object[] data,XSSFRow row){
		if (data==null||data.length==0) {
			return;
		}

		for (int i = 0; i < data.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			Object object = data[i];
			if (object == null || "".equals(object)) {
				cell.setCellValue("");
			}else{
				cell.setCellValue(object.toString());
			}

		}
	}
	private static void writeRowsObject(List<Object[]> data,XSSFSheet sheet,int offset){
		if (data==null||data.isEmpty()) {
			return;
		}

		for (int i = 0; i < data.size(); i++) {
			XSSFRow row = sheet.createRow(offset + i);
			writeRowObject(data.get(i), row);
		}
	}
	private static String createExcelFilePathForReport(String namespace,Long userId){
		Date now  = DateUtil.getCurrentDate();
		final String fileName = userId.toString()+DateUtil.convertToString(now, "yyyyMMddHHmm") + ".xlsx";
		final String basePath = PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_ROOT_PATH) ;
		final String filePath = basePath+ namespace+"/"+DateUtil.convertToString(now, DateUtil.YMD1)+"/excel/" ;
		File parentDir = new File(filePath);
		if(!parentDir.exists()) {
			parentDir.mkdirs();
		}
		return filePath+ fileName;
	}

	private static String createExcelFilePath(){
		String fileName = UUID.randomUUID().toString() + ".xlsx";
		String dateStr = DateUtil.convertToString(DateUtil.getCurrentDate(), DateUtil.YMD1);

		String path = PropsUtil.getProperty(PropsKeys.UPLOAD_FILE_ROOT_PATH)
				+ StringPool.FORWARD_SLASH + dateStr + StringPool.FORWARD_SLASH	+ "excel";

		File parentDir = new File(path);
		if(!parentDir.exists()) parentDir.mkdirs();

		return path + StringPool.FORWARD_SLASH + fileName;
	}

	private static void writeRows(List<Object[]> data,XSSFSheet sheet,int offset){
		if(data != null && data.size()>0){
			for (int i = 0; i < data.size(); i++) {
				XSSFRow row = sheet.createRow(offset + i);
				writeRow(data.get(i), row);
			}
        }

	}

	private static void writeRow(Object[] data,XSSFRow row){
		for (int i = 0; i < data.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(data[i]==null?"":data[i].toString());
		}
	}
	public static String createExcel(Long currentUserId, String orgSubDomain, String[] sheets, List<Object[]> title,
			List<List<Object[]>> list3) throws Exception {
		if (list3 == null || list3.size()==0) {
			return null;
		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		for (int i = 0; i < list3.size(); i++) {
			XSSFSheet sheet = workbook.createSheet(sheets[i]);
			writeRowObject(title.get(i), sheet.createRow(0));
			writeRowsObject(list3.get(i), sheet, 1);
		}
		String filePath = createExcelFilePathForReport(orgSubDomain,currentUserId);
		//System.out.println("filePath=======>>"+filePath);
		FileOutputStream fileos = new FileOutputStream(filePath);
		workbook.write(fileos);
		return filePath;
	}
}
