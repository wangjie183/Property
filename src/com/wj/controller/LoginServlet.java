package com.wj.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wj.pojo.Users;
import com.wj.service.UsersService;

@WebServlet("/Users")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationcontext-mybatis.xml");
    private UsersService us=(UsersService) ctx.getBean("userService");
    private boolean isOK;
    private Users user;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("login".equals(op)) {
			loginUsers(req,resp);
		}else if("add".equals(op)) {
			addUser(req,resp);
		}else if("out_login".equals(op)) {
			out_loginUser(req,resp);
		}
	}
	private void out_loginUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void addUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String cardid=req.getParameter("cardid");
			String psw=req.getParameter("password");
			String name=req.getParameter("name");
			String repassword=req.getParameter("repassword");
			int gender=0;
			String ss=cardid.substring(cardid.length()-1,cardid.length());
			if(Integer.parseInt(ss) %2==0) {
				gender=1;
			}else {
				gender=2;
			}
			if (repassword.equals(psw)) {
				if(us.getByCarId(cardid) ==null) {
					user=new Users(cardid, name, gender, new Date(), psw);
					isOK=us.addUsers(user);
					if(isOK) {
						resp.sendRedirect("login.jsp");
					}else {
						resp.sendRedirect("add.jsp");
					}
				}else {
					resp.sendRedirect("add.jsp");
				}				
			}else {
				resp.sendRedirect("add.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loginUsers(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String cardid=req.getParameter("cardid");
			String psw=req.getParameter("password");
			isOK=us.isValidation(cardid, psw);
			if(isOK) {
				user=us.getByCarId(cardid);
				if(user.getStatus()==2) {
					resp.sendRedirect("login.jsp");
				}else {
					req.getSession().setAttribute("name",user.getName());
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				} 
			}else {
				resp.sendRedirect("login.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
