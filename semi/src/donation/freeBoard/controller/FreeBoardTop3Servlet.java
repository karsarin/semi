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
		// �Խñ� ��ȸ�� ž 3 ���� ��ȸ Ajax ��û ó���� ��Ʈ�ѷ�

		ArrayList<FreeBoard> list = new FreeBoardService().selectTop3();

		// ������ ���� json ��ü
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		for (FreeBoard b : list) {
			// �� ����� ������ ������ json ��ü
			JSONObject job = new JSONObject();
			job.put("bnum", b.getfreeBoardNo());
			// json���� �ѱ� ������ ��������, java.net.URLEncoder Ŭ������ encode() �޼ҵ�� ���ڵ� ó��
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
