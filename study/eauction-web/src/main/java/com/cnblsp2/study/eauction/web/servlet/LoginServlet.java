package com.cnblsp2.study.eauction.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.cnblsp2.commons.utils.web.BaseServlet;
import com.cnblsp2.commons.utils.web.ServletUtils;

public class LoginServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4067252478454180045L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = ServletUtils.getWriter(response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 获取系统业务逻辑组件

		JSONObject jsonObject = new JSONObject();

		if ("linshaopeng".equals(username) && "linshaopeng".equals(password)) {
			jsonObject.put("userId", 1);
		} else {
			jsonObject.put("userId", -1);
		}

		ServletUtils.printAndClose(out, jsonObject);

	}

}
