package com.kh.ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test4.do")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student1 = request.getParameter("student1");
		String student2 = request.getParameter("student2");
		String student3 = request.getParameter("student3");

		System.out.println("수업을 들은 학생은 " + student1 + ", " + student2 + ", " + student3 + "입니다.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
