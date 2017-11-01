package com.cg.bal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.balance.exception.BalanceException;
import com.cg.balance.service.BalanceServiceImpl;
import com.cg.balance.service.IBalanceService;
import com.cg.bean.BalanceInfo;



@WebServlet("*.obj")
public class BalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  HttpSession session=request.getSession();
   		BalanceInfo bean=new BalanceInfo();
   		IBalanceService service=new BalanceServiceImpl();
   		PrintWriter out=response.getWriter();
   		String path=request.getServletPath();
   		String target=null;
   		
    	   
   		switch(path)
		{
		case "/add.obj":
			ArrayList<Integer> list;
			try {
				list = service.retrieveId();
				session.setAttribute("list", list);
				target="AddBalanceId.jsp";
			} catch (BalanceException e) {
				session.setAttribute("error", e.getMessage());
				target="Error.jsp";
				e.printStackTrace();
			}
			
			
			break;
		case "/check.obj":
			try{
			int id=Integer.parseInt(request.getParameter("ddlId"));
			String type=request.getParameter("ddlname");
			int amount=Integer.parseInt(request.getParameter("amount"));
			
			
			
			bean.setAccid(id);
			bean.setAccount_type(type);
			bean.setAmount(amount);
			if(service.setamt(amount))
			{
			//int amt=service.amt(amount);
			int balance=10000-amount;
			System.out.println(balance);
			
			
			
		
			int res=0;
			
			res=service.insert(bean);
			if(res>0)
			{
			
			session.setAttribute("id", id);
			session.setAttribute("type", type);
			session.setAttribute("balance", balance);
			
			target="resultscores.jsp";
			}
			else
			{
				target="Error.jsp";
			}
			}
			}
		
			catch(BalanceException e)
			{
				session.setAttribute("error", e.getMessage());
				target="Error.jsp";
				
			}
			
    	  break; 
	}
   		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	

       


}
}
