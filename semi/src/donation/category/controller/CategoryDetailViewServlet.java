package donation.category.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.category.service.CategoryService;
import donation.category.vo.Category;

/**
 * Servlet implementation class CategoryDetailViewServlet
 */
@WebServlet("/cdetail")
public class CategoryDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int ccnum;
    public static int ccpage;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		ccnum = Integer.parseInt(request.getParameter("cnum"));
		int ccurrentPage = Integer.parseInt(request.getParameter("cpage"));
		ccpage = ccurrentPage = Integer.parseInt(request.getParameter("cpage"));
		CategoryService cservice = new CategoryService();
		
		// 조회수 증가 처리
		cservice.addReadCount(cnum);
		
		Category category = cservice.selectCategory(cnum);
		System.out.println("addimage1 : " + category.getAddRenameImage1());
		System.out.println("addimage2 : " + category.getAddRenameImage2());
		System.out.println("addimage3 : " + category.getAddRenameImage3());
		System.out.println("addimage4 : " + category.getAddRenameImage4());
		RequestDispatcher view = null;
		
		if(category != null)
		{
			view = request.getRequestDispatcher("views/category/categoryDetailView.jsp");
			request.setAttribute("category", category);
			request.setAttribute("ccurrentPage", ccurrentPage);
			
			view.forward(request, response);	
			
		} else {
			view = request.getRequestDispatcher("views/category/categoryError.jsp");
			request.setAttribute("message", "게시글 상세 조회 실패");
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
