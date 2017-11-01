package donation.freeBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.FreeBoard;
import donation.question.model.service.QuestionService;
import donation.question.model.vo.Question;

/**
 * Servlet implementation class QuestionTop3Servlet
 */
@WebServlet("/ftop3")
public class FreeBoardTop3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FreeBoardTop3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 조회수 탑 3 원글 조회 Ajax 요청 처리용 컨트롤러

		ArrayList<FreeBoard> list = new FreeBoardService().selectTop3();

		// 전송할 최종 json 객체
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		for (FreeBoard b : list) {
			// 한 사람의 정보를 저장할 json 객체
			JSONObject job = new JSONObject();
			job.put("bnum", b.getfreeBoardNo());
			// json에서 한글 깨짐을 막으려면, java.net.URLEncoder 클래스의 encode() 메소드로 인코딩 처리
			job.put("btitle", URLEncoder.encode(b.getfreeBoardTitle(), "UTF-8"));

			jarr.add(job);
		}

		json.put("list", jarr);
		// System.out.println(json.toJSONString());
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
