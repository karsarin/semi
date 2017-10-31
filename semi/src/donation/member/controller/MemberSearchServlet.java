package donation.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donation.member.model.service.MemberService;
import donation.member.model.vo.Member;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/msearch")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String memberId = null;
		if(request.getParameter("memberid") !=null)
			memberId= request.getParameter("memberid");
		System.out.println(memberId);
		String memberName = request.getParameter("membername");
		String memberNo= request.getParameter("memberno");
		String member=null;
		if(memberId!=null)
			member = new MemberService().pwdSearch(memberId,memberName,memberNo);
		else
			member = new MemberService().idSearch(memberName,memberNo);
		
		RequestDispatcher view = null;
		System.out.println(member);
		if(member!=null){
			if(memberId!=null){
				view = request.getRequestDispatcher("views/member/pwdSearch.jsp");
				request.setAttribute("success", 1);
				request.setAttribute("member", member);
				view.forward(request, response);
			}else{
				view = request.getRequestDispatcher("views/member/idSearch.jsp");
				request.setAttribute("success", 1);
				request.setAttribute("member", member);
				view.forward(request, response);
			}
		}else{
			if(memberId!=null){
				view = request.getRequestDispatcher("views/member/pwdSearch.jsp");
				request.setAttribute("success", 2);
				view.forward(request, response);
			}else{
				view = request.getRequestDispatcher("views/member/idSearch.jsp");
				request.setAttribute("success", 2);
				view.forward(request, response);
			}
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
