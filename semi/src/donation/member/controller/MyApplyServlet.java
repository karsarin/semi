package donation.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.category.vo.CategoryUsed;
import donation.member.model.service.MemberService;

/**
 * Servlet implementation class MyApplyServlet
 */
@WebServlet("/myapp")
public class MyApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내가 신청한 글 리스트 조회 컨트롤러
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				String memberId = request.getParameter("memberid");
				MemberService mservice = new MemberService();
				
				int currentPage = 1;
				int limit = 5;
				if(request.getParameter("page")!=null)
					currentPage = Integer.parseInt(request.getParameter("page"));
				
				int listCount = mservice.getListCount(memberId);
				ArrayList<CategoryUsed> list = mservice.selectMyCategoryUsed(currentPage,limit,memberId);
				
				int maxPage = (int)((double)listCount / limit + 0.9);
				int startPage = ((int)((double)currentPage / limit + 0.9)-1) * limit + 1;
				int endPage = startPage + limit -1;
				if(maxPage <endPage){
					endPage = maxPage;
				}
				RequestDispatcher view = null;
				if(list!=null){
					view = request.getRequestDispatcher("views/member/categoryUsedListView.jsp");
					request.setAttribute("list", list);
					request.setAttribute("listCount", listCount);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					view.forward(request, response);
				}else{
					view = request.getRequestDispatcher("views/member/memberError.jsp");
					request.setAttribute("message", "내가 신청한 재능기부 조회 실패!");
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
