package donation.category.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.category.service.CategoryService;

/**
 * Servlet implementation class CategoryApprove
 */
@WebServlet("/capprove")
public class CategoryApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryApprove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int result = new CategoryService().updateApprove(Integer.parseInt(request.getParameter("cno")));
		RequestDispatcher view = null;
		if(result>0) {
			view = request.getRequestDispatcher("mgrmain");
			view.forward(request, response);
			
		}else{
			view = request.getRequestDispatcher("views/category/categoryError.jsp");
			request.setAttribute("message", "카테고리 승인 실패 !");
			view.forward(request, response);
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
