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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.ajax.model.vo.User;

/**
 * Servlet implementation class TestServlet6
 */
@WebServlet("/test6.do")
public class TestServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		User selectedUser = null;
		JSONObject userInfo = null;
		JSONArray userArr = new JSONArray();
		
		if(0 < userIndex && userIndex <= 10) {
			selectedUser = userList.get(userIndex - 1);
			
			userInfo = new JSONObject();
			
			userInfo.put("userNo", selectedUser.getUserNo());
			userInfo.put("userName", 
					URLEncoder.encode(selectedUser.getUserName(), "UTF-8"));
			userInfo.put("userNation", 
					URLEncoder.encode(selectedUser.getUserNation(), "UTF-8"));
			
			userArr.add(userInfo);
		}else {
			for(User user : userList) {
				userInfo = new JSONObject();
				userInfo.put("userNo", user.getUserNo());
				userInfo.put("userName",
						URLEncoder.encode(user.getUserName(), "UTF-8"));
				userInfo.put("userNation", 
						URLEncoder.encode(user.getUserNation(), "UTF-8"));
				
				userArr.add(userInfo);
			}
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(userArr.toJSONString());
		
		out.flush();
		out.close();
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





