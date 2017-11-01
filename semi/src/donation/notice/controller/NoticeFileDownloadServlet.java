package donation.notice.controller;

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
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/nfdown")
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� �ٿ�ε� ó���� ��Ʈ�ѷ�
		request.setCharacterEncoding("utf-8");
		
		//������Ʈ ���� ����� ������ ���� ������� �˾Ƴ�
		String savePath = request.getSession().getServletContext().getRealPath("/uploadfiles/nuploadfiles");
			// getServletContext() ������ ������ �ִ� �� ������Ʈ�� �ǹ���
			
		String originalFileName = request.getParameter("oname");
		String renameFileName = request.getParameter("rname");
		
		File downFile = new File(savePath + "/" + renameFileName);
		
		//Ŭ���̾�Ʈ�� ������ ��� ��Ʈ�� ����
		ServletOutputStream downOut = response.getOutputStream();//response�� ������ �ִ� Ŭ���̾�Ʈ�� url�� ������ OutputStream ����
		
		
		//�о ������ ���� original ������ ���������ϴµ� 
		
		/*�ٿ������ OS�� �޾Ƽ� �����ϴµ�  �ٿ�ε� ������ �⺻���� �����
		�ٵ� OS�� �ѱ۹��ڼ���  ut-8 �ƴ�
		�׷��� �ѱ��̸����� �������� OS�� ���ڼ����� �ٲ�� ������ �и��� �ѱ� ����
		�������� ���� �����̸��� �޾��ִ� OS�� ���� ���ڵ����� �ٲ���ߵ�
		*/
		response.setContentType("text/plane; charset=utf-8");
		//���Ϸ� �������°� html�̶�� �ϸ� �ȵǰ� plane���� �ؾߵ�
	
		// �ѱ� ���ϸ� ���ڵ� ó���� : �޾��ִ� �ý����� ���ڵ����� ��ȯ��
		response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(originalFileName.getBytes("utf-8"), "ISO-8859-1") + "\"");  //�ٿ�ε� ���� ���ϸ� �����ϴ°�
		//�ڹٿ��� ����ǥ �ȿ� �� ����ǥ ������� �� �������� \ ���� " �̰� ���� ��
		//new String(originalFileName.getBytes("utf-8") -> String ��ü�� utf-8(���� ���ڿ� ����� ���ڼ�)�� ����� byte ��ü�� �ٲ���
		
		//"utf-8" �� �� ���ڿ���  "ISO-8859-1"�� �ٲ㼭 response �� Header�� attachment�ؼ� ������
		
		response.setContentLength((int)downFile.length()); //������ size �˾Ƴ��°� , long������ ���ϵǴϱ� int������ ����ȯ����
		
		
		//����� �������� ������ �о, Ŭ���̾�Ʈ���� ��������  : ���� �ٿ�
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
		//������ txt��� ������ ���⶧���� �׳� �⺻ ��Ʈ�� ��, ����Ʈ��Ʈ�� ��ߵ�		
		
		int read = -1;
		while((read = bin.read()) != -1 ){  //�� ������  -1�� ���ϵǴϱ� �� ������ ���� ����
			downOut.write(read);
			downOut.flush();
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
