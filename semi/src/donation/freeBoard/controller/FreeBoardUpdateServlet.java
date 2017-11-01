package donation.freeBoard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import donation.freeBoard.model.service.FreeBoardService;
import donation.freeBoard.model.vo.FreeBoard;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/fupdate")
public class FreeBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ ���� ó���� ��Ʈ�ѷ�
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
	/*	Notice notice = new Notice();
		notice.setNoticeNo(Integer.parseInt(request.getParameter("no")));
		notice.setNoticeTitle(request.getParameter("title"));
		notice.setNoticeContent(request.getParameter("content"));*/
		
		
		//enctype �� mulitpart ������� ���۵Ǿ����� Ȯ���ϴ� �۾��� �ʿ���
		
		RequestDispatcher view = null;
		FreeBoard fboard = null;
		if(!ServletFileUpload.isMultipartContent(request) ){ // request�� ������ ��û�� view�� form ��������  multipart ������� Ȯ����
															//ServletFileUpload �̰� cos.jar(���� ����� ���̺귯��)�� ������ 
			view = request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
			request.setAttribute("message", "form �� enctype �Ӽ� ������!");
			view.forward(request, response);
		}
			//���ε� �� ������ �뷮 ���� : 10Mbyte �� �����Ѵٸ�
			int maxSize = 1024 * 1024  * 10;
			
			//���ε�� ������ ���� ��ġ ����
			//�ش� �����̳�(��Ĺ) �������� �� ���ø����̼� ��Ʈ ����(content directory)�� ��θ� �˾Ƴ�
			//�׷��� ���� ��Ĺ���� �������� ���ø����̼��� ��θ� �˾Ƴ��� �� �����ȿ� ����ǰ� �ҽ��ڵ�� ��������
			//�̷��� �ϸ� ������ �ٲ��� �ҽ� ������ �ʿ����
			String root = request.getSession().getServletContext().getRealPath("/");
			//���ǰ�ü�� ���������  ���ø����̼�(context)   "/" �� root ������ �ǹ��� 
			//���ø����̼��� ��Ʈ������ �˾Ƴ���� �� 
			
			//���ε� �� ������ ������� ��Ʈ ���� ���� ó��
			String savePath = root + "uploadfiles/" + "fuploadfiles";
			// web/uploadfiles �� �������
			 
			//request �� MultipartRequest ��ü�� ��ȯ��
			MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
			//MulitpartRequest ��� Ŭ����
			//new MultipartRequest(request��ü,  ���Ͼ��ε��ϴ� ������, ���ε� �� ������ �뷮, ���ڵ� ��, ����� ���� Ŭ����) 
			
			//new DefaultFileRenamePolicy()�� ������ ������ϴ°� �ƴ϶� �̸� �����ؼ�  �̸�(1).txt, �̸�(2)tx. �̷��� �����ؼ� ���� ���ε��ϴ� Ŭ����  
					
			int no = Integer.parseInt(mrequest.getParameter("no"));			
			//���� request�� mrequst�� �ٲ��� ������ mrequest���� getParameter() �ؾ��Ѵ�.
			String title = mrequest.getParameter("title");
			String writer = mrequest.getParameter("writer");
			String content = mrequest.getParameter("content");
			String originalImageName = mrequest.getFilesystemName("file"); //���� �̸��� ����
			String boardType = mrequest.getParameter("type");
			
			//���ε�Ǿ� �ִ� ���ϸ��� '����Ͻú���.Ȯ����' �������� �ٲٱ� ó��
			if(originalImageName != null){
				//������ ���ϸ� ����� 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String renameImageName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "." + 
				originalImageName.substring(originalImageName.lastIndexOf(".") + 1);
				
				//���ϸ� �ٲٷ��� File ��ü�� renameTo() �޼ҵ� �����
				File originalImage = new File(savePath + "\\" + originalImageName); // �������� ��ξ� �� /�� ������ ���⼭�� "\\" ��� 
				File renameImage = new File(savePath + "\\" + renameImageName); //java.io.File import �ؾߵ�
				//�����ϸ� true , �����ϸ� false�� ���ϵ�
				if(!originalImage.renameTo(renameImage)){
					//�̸��ٲٱⰡ �����ߴٸ�  �� ������ ������ �о, ���纻 ���Ͽ� �Ű� ����ϰ� �������� �� ������ ������
					int read = -1;
					byte[] buf = new byte[1024];
					
					FileInputStream fin = new FileInputStream(originalImage);
					FileOutputStream fout = new FileOutputStream(renameImage);
					
					
					while((read = fin.read(buf, 0, buf.length)) != -1){  //read���� �о���� ����Ʈ ����� �������, �� ������ -1�� ��
						fout.write(buf, 0 , read);					
						//buf�� ���� ���� 0 ����Ʈ���� read�� ���� ��ŭ write�ض�						
					}
					fin.close();
					fout.close();
					
					//�������� �� ������ ������
					originalImage.delete();
			
				}
				//���ε� �� ������ ���� ���
				 fboard = new FreeBoard(no, title, writer, content, null, originalImageName, renameImageName, 0, boardType, 2); //�ҷ��� ������ notice��ü �ʱ�ȭ
				
				
			}
			else{
				// ���ε� �� ������ ���� ���(÷�������� ���� ���)
				fboard = new FreeBoard(no, title, writer, content, null, null, null, 0, boardType, 2); //�ҷ��� ������ notice��ü �ʱ�ȭ
			}		
		
		
		
		if(new FreeBoardService().updateFreeBoard(fboard) > 0){
			response.sendRedirect("/semi/flist");
		}else{
			view= request.getRequestDispatcher("views/freeBoard/freeBoardError.jsp");
			request.setAttribute("message", "���� �Խñ� ���� ó�� ����!");
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
