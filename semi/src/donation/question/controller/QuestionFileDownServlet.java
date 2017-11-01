package donation.question.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionFileDownServlet
 */
@WebServlet("/qfdown")
public class QuestionFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� �ٿ�ε� ó���� ��Ʈ�ѷ�
		request.setCharacterEncoding("utf-8");
		
		String originalFileName = request.getParameter("ofile");
		String renameFileName = request.getParameter("rfile");
		
		//������Ʈ ���� ������ ����� ������ ��� ���� ����
		String savePath = request.getSession().getServletContext().getRealPath("/quploadfiles");
		
		//Ŭ���̾�Ʈ�� ������ ��� ��Ʈ�� ����
		ServletOutputStream downOut = response.getOutputStream();
		
		File downFile = new File(savePath + "/" + renameFileName);
		response.setContentType("text/plane; charset=utf-8");
		
		//�̴�� �ٿ������ ������������ �ѱ۸��� ����� ������ �ٿ�ε� ���� �� os�� ���ڵ� ����� �ٸ��� ������ �ѱ� ���ϸ��� ������.
		// �׷��� �ѱ� ���ϸ��� �ٿ�� os�� ���ڼ����� ����� ó����
		response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1") + "\"" );

		//originalFileName.getBytes("UTF-8")  -> utf-8�� �Ǿ��ִ� originalFileName�� ����Ʈ �������� �ٲ���
		
		response.setContentLength((int)downFile.length());   //downFile.length() �̰� long������ ��ȯ�Ǽ� int �� ��ȯ ����ߵ�
		
		//����� ������ ������ �о ��� ��Ʈ������ ������
		//���� �б�� ��Ʈ�� ����
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
		//IOException�� �ʿ������� �̹� doGet �޼ҵ忡���� throw IOException �ϰ� �ֱ⶧���� �ʿ����.
		//��������� downFile ���Ͽ� ���� ��Ʈ�� ��ü(���� ������ �� �ִ� ���)�� �ٿ��� ����� ������ read�Ѵ�.
		
		
		int read = -1;
		while((read = bin.read()) != -1){  //���ϰ��� ������ -1�� ������
			downOut.write(read); //downFile �� read�� �����͸� downOut ��Ʈ���� ���� write �ؼ� ���� �������ش�.
			downOut.flush(); //Buffer�� �̿��߱⶧���� flush ����
			
		}
		downOut.close();
		bin.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
