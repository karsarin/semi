package donation.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.category.service.CategoryService;
import donation.category.vo.Category;

/**
 * Servlet implementation class CategoryPurchaseListViewServlet
 */
@WebServlet("/cpurchaselist")
public class CategoryPurchaseListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryPurchaseListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String userid = request.getParameter("memberid");
		System.out.println("categoryNo : " + categoryNo);
		System.out.println("userid : " + userid);
		CategoryDetailViewServlet cdv = new CategoryDetailViewServlet();
		int cnum = 0;
		int ccurentPage = 0;
		
		cnum = cdv.ccnum;
		ccurentPage = cdv.ccpage;
		
		new CategoryService().addPurchaseCount(categoryNo);
		
		//int cnum = Integer.parseInt(request.getParameter("cnum"));
		//int ccurrentPage = Integer.parseInt(request.getParameter("cpage"));
		
		if(new CategoryService().insertPurchaseList(categoryNo, userid) > 0)
		{			 
			RequestDispatcher view = request.getRequestDispatcher("/cdetail?cnum=" + cnum + "&cpage="+ ccurentPage);
		
			view.forward(request, response);
		} else {
			RequestDispatcher errorPage = request.getRequestDispatcher("views/category/categoryError.jsp");
			request.setAttribute("message", "재능 신청 실패");
			errorPage.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
