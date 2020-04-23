package com.wj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wj.pojo.Pager;
import com.wj.service.Real_EstateService;

@WebServlet("/Real")
public class RealServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationcontext-mybatis.xml");
    private Real_EstateService re=(Real_EstateService) ctx.getBean("realService");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("show".equals(op)) {
            showReal(req,resp);
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void showReal(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Pager pg=new Pager();
			String pageIndex=req.getParameter("pageIndex");
			String tiaojian=req.getParameter("tiaojian");
			int currpage=1; 
			int totalCount=0;
            if(tiaojian ==null) {
            	totalCount=re.getCount(null, null);
            }else {
    			String cardid=req.getParameter("title");
    			if(tiaojian.equals("1")) {
    				totalCount=re.getCount(cardid, null);
    			}else {
    				totalCount=re.getCount(null, cardid);
    			}
            }
			pg.setTotalCount(totalCount);
			if(pageIndex==null || "".equals(pageIndex)) {
				currpage=1;
			}else {
				int num=Integer.parseInt(pageIndex);
				if(num<=0) {
					currpage=1;
				}else if(num>=pg.getTotalPages()) {
					currpage=pg.getTotalPages();
				}else {
					currpage=num;
				}
			}
			pg.setCurrPage(currpage);
			@SuppressWarnings("rawtypes")
			List list=null;
			int form=(currpage-1)*pg.getTotalPages();
            if(tiaojian ==null) {
            	list=re.getAll(form, pg.getPageSize(),null,null);
            	pg.setPageLists(list);
            }else {
    			String cardid=req.getParameter("title");
    			System.out.println(tiaojian.equals("1"));
    			if(tiaojian.equals("1")) {
    				list=re.getAll(form, pg.getPageSize(),null,cardid);
    				pg.setPageLists(list);
    			}else {
    				list=re.getAll(form, pg.getPageSize(),cardid,null);
    				pg.setPageLists(list);
    			}
            }
			req.getSession().setAttribute("pg", pg);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
