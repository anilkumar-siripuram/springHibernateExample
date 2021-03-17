package com.springmvc.util;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.springmvc.Model.Employee;

public class ExcelUserListReportView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");
		
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("employees");
		
		 Sheet sheet = workbook.createSheet("employees");
		  
		  Row header = sheet.createRow(0);
		  header.createCell(0).setCellValue("Name");
		  header.createCell(1).setCellValue("JoiningDate");
		  header.createCell(2).setCellValue("Salary");
		  header.createCell(3).setCellValue("SSN");
		  
		  int rowNum = 1;
		  
		  for(Employee emp : list){
		   Row row = sheet.createRow(rowNum++);
		   row.createCell(0).setCellValue(emp.getName());
		   row.createCell(1).setCellValue(String.valueOf(emp.getJoiningDate()));
		   row.createCell(2).setCellValue(String.valueOf(emp.getSalary()));
		   row.createCell(3).setCellValue(emp.getSsn());
		  }
		  
		
		
	}

}
