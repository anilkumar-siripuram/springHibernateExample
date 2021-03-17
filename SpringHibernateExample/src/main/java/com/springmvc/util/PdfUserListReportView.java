package com.springmvc.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.springmvc.Model.Employee;

public class PdfUserListReportView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		 response.setHeader("Content-Disposition", "attachment; filename=\"user_list.pdf\"");
		  
		  @SuppressWarnings("unchecked")
		  List<Employee> list = (List<Employee>) model.get("employees");
		  
		  Table table = new Table(4);
		  table.addCell("Name");
		  table.addCell("Joining Date");
		  table.addCell("Salary");
		  table.addCell("SSN");
		  
		  for(Employee e : list) {
			  table.addCell(e.getName());
			  table.addCell(String.valueOf(e.getJoiningDate()));
			  table.addCell(String.valueOf(e.getSalary()));
			  table.addCell(e.getSsn());
		  }
		
		  document.add(table);
	}

}
