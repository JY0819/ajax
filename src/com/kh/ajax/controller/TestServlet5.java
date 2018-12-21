package com.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.ajax.model.vo.User;

@WebServlet("/test5.do")
public class TestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet5() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = new ArrayList<User>();
		
		User user1 = new User(1, "홍길동", "한국");
		User user2 = new User(2, "수지", "일본");
		User user3 = new User(3, "페이", "중국");
		User user4 = new User(4, "박문수", "일본");
		User user5 = new User(5, "유정훈", "독일");
		User user6 = new User(6, "노민수", "중국");
		User user7 = new User(7, "김동현", "프랑스");
		User user8 = new User(8, "이동헌", "호주");
		User user9 = new User(9, "김진호", "미국");
		User user10 = new User(10, "유병승", "호주");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10);
	
		int userIndex = Integer.parseInt(request.getParameter("userIndex"));
		
		// index는 0부터 시작하기 때문에
		User user = userList.get(userIndex - 1);
		
		// user를 자바 스크립트가 알아먹을 수 있게 json 사용
		// json은 Map 방식이다
		JSONObject result = new JSONObject();
		result.put("userNo", user.getUserNo());
		result.put("userName", URLEncoder.encode(user.getUserName(), "UTF-8"));
		result.put("userNation", URLEncoder.encode(user.getUserNation(), "UTF-8"));
		// encode = "%EC%88%98%EC%A7%80" 이런식으로 나옴 그래서 decodeURIComponent 해줘야 한다.
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		//result는 json 객체이기 때문에 toJSONString 사용
		out.print(result.toJSONString());
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
