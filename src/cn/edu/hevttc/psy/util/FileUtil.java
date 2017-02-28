package cn.edu.hevttc.psy.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hevttc.psy.bean.*;

import javax.servlet.ServletContext;
import javax.servlet.jsp.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.jspsmart.upload.SmartUpload;


public class FileUtil {

	/**
	 * 从一个单元格中以字符串的形式取值。
	 * 例如，对于联系方式，单元格中为12345，此时只能用getNumericCellValue()方法取值，取得的值为12345.0
	 * 将其强制类型转换为int，即12345，然后转成字符串。
	 * 注意：当一个单元格内容为空时，取得的HSSFCell对象为null，如果不处理就会报NullPointerException。
	 * @param HSSFCell cell，哪个单元格。
	 * @return 字符串形式的单元格值，单元格对象为空则返回null。
	 */

	public String getString(HSSFCell cell){
		String value = null;
		//单元格不为null，才可以继续处理，否则报空指针异常。
		if(cell!=null){
			//用switch语句判断单元类内容的类型，HSSFCell中已经预定义了一些常量，可以参考API
			switch(cell.getCellType()){
			case HSSFCell.CELL_TYPE_NUMERIC:
				value = String.valueOf((int)cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value = cell.getStringCellValue();
				break;
			}
		}
		return value;
	}
	
	/**
	 * 从一个单元格中以int的形式取值。
	 * 例如，对于年龄，单元格中为22，此时用getNumericCellValue()方法取值，取得的值为22.0
	 * 将其强制类型转换为int，即22。
	 * 注意：当一个单元格内容为空时，取得的HSSFCell对象为null，如果不处理就会报NullPointerException。
	 * @param HSSFCell cell，哪个单元格。
	 * @return int形式的单元格值，单元格对象为空则返回0。
	 */
	
	public int getInt(HSSFCell cell){
		int value = 0;
		//单元格不为null，才可以继续处理，否则报空指针异常。
		if(cell!=null){
			//用switch语句判断单元类内容的类型，HSSFCell中已经预定义了一些常量，可以参考API
			switch(cell.getCellType()){
			case HSSFCell.CELL_TYPE_NUMERIC:
				value = (int)cell.getNumericCellValue();
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value = Integer.parseInt(cell.getStringCellValue());
				break;
			}
		}
		return value;
	}	
	public static String exportResult1(List<Result> list,String filePath){
		String fileName=null;
		HSSFWorkbook xls = new HSSFWorkbook();
		Sheet sheet = xls.createSheet("测试结果");
		Row rowTitle = sheet.createRow(0);
		rowTitle.createCell(0).setCellValue("编号");
		rowTitle.createCell(1).setCellValue("学号");
		rowTitle.createCell(2).setCellValue("姓名");
		rowTitle.createCell(3).setCellValue("性别");
		rowTitle.createCell(4).setCellValue("测试结果");
		rowTitle.createCell(5).setCellValue("院系");
		rowTitle.createCell(6).setCellValue("专业");
		rowTitle.createCell(7).setCellValue("导师");
		rowTitle.createCell(8).setCellValue("入学时间");
		rowTitle.createCell(9).setCellValue("年级");
		rowTitle.createCell(10).setCellValue("联系方式");
		rowTitle.createCell(11).setCellValue("测试试卷");
		rowTitle.createCell(12).setCellValue("测试日期");
		for(int i=0;i<list.size();i++){
			Row row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue(list.get(i).getStudentID());
			row.createCell(2).setCellValue(list.get(i).getName());
			row.createCell(3).setCellValue(list.get(i).getSex());
			row.createCell(4).setCellValue(list.get(i).getResultInfo());
			row.createCell(5).setCellValue(list.get(i).getDept());
			row.createCell(6).setCellValue(list.get(i).getMajor());
			row.createCell(7).setCellValue(list.get(i).getTutor());
			row.createCell(8).setCellValue(list.get(i).getYear());
			row.createCell(9).setCellValue(list.get(i).getGrade());
			row.createCell(10).setCellValue(list.get(i).getPhone());
			row.createCell(11).setCellValue(list.get(i).getExamName());
			row.createCell(12).setCellValue(list.get(i).getResultDate());
			}
		try {
			FileOutputStream fos;
			fileName= String.valueOf(System.currentTimeMillis());
			fos = new FileOutputStream(filePath+"/"+fileName+".xls");
			//System.out.println(filePath+"/"+fileName+".xls");
			try {
				xls.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}
	public static String exportResult(List<Temporary> list,String filePath){
		String fileName=null;
		HSSFWorkbook xls = new HSSFWorkbook();
		Sheet sheet = xls.createSheet("测试结果");
		Row rowTitle = sheet.createRow(0);
		rowTitle.createCell(0).setCellValue("编号");
		rowTitle.createCell(1).setCellValue("身份证号");
		rowTitle.createCell(2).setCellValue("姓名");
		rowTitle.createCell(3).setCellValue("测试结果");
		rowTitle.createCell(4).setCellValue("院系");
		rowTitle.createCell(5).setCellValue("测试试卷");
		rowTitle.createCell(6).setCellValue("测试日期");
		for(int i=0;i<list.size();i++){
			Row row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(i+1);
			row.createCell(1).setCellValue(list.get(i).getCardID());
			row.createCell(2).setCellValue(list.get(i).getName());
			row.createCell(3).setCellValue(list.get(i).getResultInfo());
			row.createCell(4).setCellValue(list.get(i).getDept());
			row.createCell(5).setCellValue(list.get(i).getExamName());
			row.createCell(6).setCellValue(list.get(i).getResultDate());
			}
		try {
			FileOutputStream fos;
			fileName= String.valueOf(System.currentTimeMillis());
			fos = new FileOutputStream(filePath+"/"+fileName+".xls");
			//System.out.println(filePath+"/"+fileName+".xls");
			try {
				xls.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}
	public List<Student> getStudent(String fileName){
		List<Student> list = new ArrayList<Student>();
		HSSFWorkbook workbook;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(fileName));
			HSSFSheet sheet = workbook.getSheet("sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows()-1;
			HSSFRow row = null;
			for(int i=1;i<=rowCount;i++){
				row = sheet.getRow(i);
				Student student=new Student();
				student.setName(this.getString(row.getCell(0)));
				student.setStudentID(this.getString(row.getCell(1)));
				student.setSex(this.getString(row.getCell(2)));
				student.setDept(this.getString(row.getCell(3)));
				student.setMajor(this.getString(row.getCell(4)));
				student.setTutor(this.getString(row.getCell(5)));
				student.setYear(this.getInt(row.getCell(6)));
				student.setGrade(this.getInt(row.getCell(7)));
				student.setPhone(this.getString(row.getCell(8)));
				list.add(student);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	public List<Question> getExamFromXls(String fileName){
		List<Question> exam = new ArrayList<Question>();
		try{
			//创建一个工作簿对象。用FileInputStream构造一个HSSFWorkbook对象。
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileName));
			//取得工作簿中指定的工作表对象。用HSSFWorkbook的getSheet(String sheetName)方法取得一个HSSFSheet对象。
			HSSFSheet sheet = workbook.getSheet("sheet1");
			//取得工作表中的记录数。sheet.getPhysicalNumberOfRows()返回总行数，第一行为标题行，因此减1.
			int rowCount = sheet.getPhysicalNumberOfRows()-1;
			//取得工作表中的列数。
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			HSSFRow row = null;
			HSSFCell cell = null;			
			//依次处理每一行
			for(int i=1;i<=rowCount;i++){
				//取得工作表中指定的行对象。
				row = sheet.getRow(i);
				//new Exam对象，并用各字段的值为其赋值。
				Question question = new Question();
				//row.getCell(int index)会返回指定的单元格，但如果单元格中没有内容，则返回null，注意处理。
				question.setId(this.getInt(row.getCell(0)));
				question.setTableName(this.getString(row.getCell(1)));
				question.setType(this.getInt(row.getCell(2)));
				question.setQuestionTitle(this.getString(row.getCell(3)));
				int k=4;
				while(row.getCell(k)!=null){
					question.addAnswer(this.getString(row.getCell(k)));
					k++;
				}
				//将Student对象放入List中
				exam.add(question);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return exam;		
	}
	public List<Question> getExamFromXls1(String fileName){
		List<Question> exam = new ArrayList<Question>();
		try{
			//创建一个工作簿对象。用FileInputStream构造一个HSSFWorkbook对象。
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileName));
			//取得工作簿中指定的工作表对象。用HSSFWorkbook的getSheet(String sheetName)方法取得一个HSSFSheet对象。
			HSSFSheet sheet = workbook.getSheet("sheet1");
			//取得工作表中的记录数。sheet.getPhysicalNumberOfRows()返回总行数，第一行为标题行，因此减1.
			int rowCount = sheet.getPhysicalNumberOfRows()-1;
			//取得工作表中的列数。
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			HSSFRow row = null;
			HSSFCell cell = null;			
			//依次处理每一行
			for(int i=1;i<=rowCount;i++){
				//取得工作表中指定的行对象。
				row = sheet.getRow(i);
				//new Exam对象，并用各字段的值为其赋值。
				Question question = new Question();
				//row.getCell(int index)会返回指定的单元格，但如果单元格中没有内容，则返回null，注意处理。
				question.setId(this.getInt(row.getCell(0)));
				int k=1;
				while(row.getCell(k)!=null){
					question.addAnswer(this.getString(row.getCell(k)));
					k++;
				}
				//将Student对象放入List中
				exam.add(question);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return exam;		
	}
	public List<String> getExamTitle(String fileName){
		List<String> examTitle = new ArrayList<String>();
		try{
			//创建一个工作簿对象。用FileInputStream构造一个HSSFWorkbook对象。
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileName));
			//取得工作簿中指定的工作表对象。用HSSFWorkbook的getSheet(String sheetName)方法取得一个HSSFSheet对象。
			HSSFSheet sheet = workbook.getSheet("sheet1");
			HSSFRow row = sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				examTitle.add(this.getString(row.getCell(i)));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return examTitle;		
	}
	public String getFileNamea(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length()))) {   
                return filename.substring(0,dot);   
            }   
        }   
        return filename;   
    }   

	public String getFileNameNoEx(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length()-1))) {   
                return filename.substring(dot+1);   
            }   
        }   
        return filename;   
    }   
}
