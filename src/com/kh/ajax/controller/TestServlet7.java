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

@WebServlet("/test7.do")
public class TestServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet7() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		String userIndexes = request.getParameter("userIndexes");

		JSONObject result = new JSONObject();
		User selectedUser = null;
		JSONObject userInfo = null;
		JSONArray userArr = new JSONArray();

		String[] ids = userIndexes.split(", ");
		int index = -1;

		for (String id : ids) {
			index = Integer.parseInt(id) - 1;

			selectedUser = userList.get(index);

			if (selectedUser != null) {
				userInfo = new JSONObject();

				userInfo.put("userNo", selectedUser.getUserNo());
				userInfo.put("userName", URLEncoder.encode(selectedUser.getUserName(), "UTF-8"));
				userInfo.put("userNation", URLEncoder.encode(selectedUser.getUserNation(), "UTF-8"));

				userArr.add(userInfo);

			}
		}

		result.put("list", userArr);

		response.setContentType("application/json");

		PrintWriter out = response.getWriter();

		out.print(result.toJSONString());

		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
