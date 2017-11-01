package donation.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.member.model.service.MemberService;

/**
 * Servlet implementation class MemberEnrollCk
 */
@WebServlet("/menrollcheck")
public class MemberEnrollCk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollCk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberNo = request.getParameter("memberNo");
		String memberPwd = request.getParameter("memberPwd");
		String memberNik = request.getParameter("memberNik");
		String memberPhone = request.getParameter("memberPhone");
		
		String result = "success";

		// 아이디, 비밀번호 글자수 체크
		if(memberId.length()>10 || memberPwd.length()>15) {
			result = "글자수초과";
		} else {
			/* 아이디, 비밀번호 영문과 숫자로만 이루어져있고 둘 다 사용했는지 확인
			 * 정규표현식
			 * [0-9] : 숫자
			 * [z-zA-Z] : 영문자
			 * [가-힣] : 한글
			 * [a-zA-Z0-9] : 영어/숫자 
			 * ex) boolean d = Pattern.matches("[가-힝]", "락"); */
			if(Pattern.matches("^[a-zA-Z]*$", memberId) || Pattern.matches("^[0-9]*$", memberId) ||
			   Pattern.matches("^[a-zA-Z]*$", memberPwd) || Pattern.matches("^[0-9]*$", memberPwd)) {
				result = "영문자와숫자모두";
			} else if(!(Pattern.matches("^[a-zA-Z0-9]*$", memberId)) || !(Pattern.matches("^[a-zA-Z0-9]*$", memberPwd))) {
				result = "영문자와숫자만";
			} else {
				// 아이디, 주민번호, 닉네임, 전화번호 중복확인
				result = new MemberService().mEnrollCk(memberId,memberNo,memberNik,memberPhone); 
			}
		}

		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
