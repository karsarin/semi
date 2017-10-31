package donation.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.member.model.service.MemberService;

/**
 * Servlet implementation class MemberPwdUpdateServlet
 */
@WebServlet("/mpwdupdate")
public class MemberPwdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String memberId = request.getParameter("memberid");
		String memberPwd = request.getParameter("memberpwd");
		System.out.println("memberId = "+memberId);
		System.out.println("memberPwd = "+memberPwd);
		int result = new MemberService().pwdUpdate(memberId,memberPwd);
		RequestDispatcher view = null;
		if(result > 0){
			view = request.getRequestDispatcher("views/member/pwdSearch.jsp");
			request.setAttribute("success", 3);
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
