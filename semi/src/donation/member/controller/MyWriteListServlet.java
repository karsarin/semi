package donation.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.donate.model.service.DonateService;
import donation.donate.model.vo.Donate;
import donation.member.model.service.MemberService;
import donation.member.model.vo.MyWrite;

/**
 * Servlet implementation class MyWriteList
 */
@WebServlet("/mylist")
public class MyWriteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWriteListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내가 쓴 글 리스트 조회 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String memberId = request.getParameter("memberid");
		int boardNo = 0;
		if(request.getParameter("value")!=null)
			boardNo = Integer.parseInt(request.getParameter("value"));
		System.out.println(boardNo);
		MemberService mservice = new MemberService();
		
		int currentPage = 1;
		int limit = 10;
		if(request.getParameter("page")!=null)
			currentPage = Integer.parseInt(request.getParameter("page"));
		
		System.out.println(memberId);
		int listCount = mservice.getListCount(memberId,boardNo);
		ArrayList<MyWrite> list = mservice.selectMyWrite(currentPage,limit,memberId,boardNo);
		
		int maxPage = (int)((double)listCount / limit + 0.9);
		int startPage = ((int)((double)currentPage / limit + 0.9)-1) * limit + 1;
		int endPage = startPage + limit -1;
		if(maxPage <endPage){
			endPage = maxPage;
		}
		System.out.println(list);
		RequestDispatcher view = null;
		if(list!=null){
			view = request.getRequestDispatcher("views/member/myWriteListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("listCount", listCount);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("boardNo", boardNo);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "내가 쓴 글 조회 실패!");
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