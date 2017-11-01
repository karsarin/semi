/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2017-10-31 14:49:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import donation.category.vo.Category;
import donation.question.model.vo.Question;
import java.util.*;
import java.sql.*;
import donation.member.model.vo.Member;

public final class managerMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/views/manager/managerHeader.jsp", Long.valueOf(1509455793361L));
    _jspx_dependants.put("/views/manager/managerFooter.jsp", Long.valueOf(1509455800528L));
    _jspx_dependants.put("/views/manager/../../header.jsp", Long.valueOf(1509455795687L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("donation.category.vo.Category");
    _jspx_imports_classes.add("donation.question.model.vo.Question");
    _jspx_imports_classes.add("donation.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
 
	ArrayList<Category> clist = (ArrayList<Category>)request.getAttribute("clist");
	int clistCount = ((Integer)request.getAttribute("clistCount")).intValue();
	int ccurrentPage = ((Integer)request.getAttribute("ccurrentPage")).intValue();
	int cmaxPage = ((Integer)request.getAttribute("cmaxPage")).intValue();	
	
	ArrayList<Question> qlist = (ArrayList<Question>)request.getAttribute("qlist");

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<title>Talent Donation - Manager/main</title>\r\n");
      out.write("\t<link href=\"/semi/css/manager/main.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("\t<link href=\"/semi/css/manager/mainFonts.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("    <script src=\"/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("    <script src=\"/semi/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    \t$(function(){\r\n");
      out.write("    \t\t$('.main-menu ul #minfo').removeClass('active');\r\n");
      out.write("    \t\t$('.main-menu ul #category').removeClass('active');\r\n");
      out.write("    \t\t$('.main-menu ul #board').removeClass('active');\r\n");
      out.write("    \t\t$('.main-menu ul #home').addClass('active');\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\tvar qmaxPage = ");
      out.print(qlist.size());
      out.write(";\r\n");
      out.write("    \t\tvar qcurrentView = ");
      out.print(9);
      out.write(";\r\n");
      out.write("    \t\t$('.qnatb tbody tr').each(function(index){\r\n");
      out.write("    \t\t\tif(index > qcurrentView) {\r\n");
      out.write("    \t\t\t\t $(this).hide('fast');\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t$('#qmore').click(function(){\r\n");
      out.write("    \t\t\tif(!(qcurrentView>qmaxPage)) {\r\n");
      out.write("    \t\t\t\t$('.qnatb tbody tr').each(function(index){\r\n");
      out.write("    \t\t\t\t\tif(qmaxPage-qcurrentView > 10) {\r\n");
      out.write("    \t\t\t\t\t\tif(index > qcurrentView && index <= qcurrentView+10) {\r\n");
      out.write("    \t\t\t\t\t\t\t$(this).show('3000');\r\n");
      out.write("    \t\t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t\t} else {\r\n");
      out.write("    \t\t\t\t\t\tif(index > qcurrentView) {\r\n");
      out.write("    \t\t\t\t\t\t\t$(this).show('3000');\r\n");
      out.write("    \t\t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t});\r\n");
      out.write("    \t\t\t\tqcurrentView+=10;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t});\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
 Member member = (Member)session.getAttribute("member"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>header</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("div#loginbar{\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tmargin-right:50px;\r\n");
      out.write("\tmargin-top:5px;\r\n");
      out.write("\tfont-size:10pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=loginbar>\r\n");
 if(member ==null){ 
      out.write("\r\n");
      out.write("\t<a href=\"/semi/views/member/Login.jsp\">로그인</a>\r\n");
      out.write("\t<a href=\"/semi/mlist\" style=\"margin-left:10px;\">회원가입</a>\r\n");
 }else{ 
      out.write("\r\n");
      out.write("\t<a href=\"/semi/minfor?userid=");
      out.print(member.getMemberId());
      out.write('"');
      out.write('>');
      out.print(member.getMemberNik() );
      out.write("</a>님 환영합니다.\r\n");
      out.write("\t<a href=\"#\" style=\"margin-left:10px;\" onclick=\"logout();\">로그아웃</a>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function logout(){\r\n");
      out.write("\tlocation.href = \"/semi/logout?userid=");
      out.print(member.getMemberId() );
      out.write("\" \r\n");
      out.write("\t\t\talert(\"로그아웃되었습니다.\");\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write('	');
if(member!=null && member.getMemberId().equals("admin")) { 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<title>Talent Donation - Manager</title>\t\r\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/font-awesome.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/animate.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/templatemo_misc.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/templatemo_style.css\">\r\n");
      out.write("    <script src=\"/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("    <script src=\"/semi/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<br><br><br>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div id=\"menu-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"logo-wrapper col-md-4 col-sm-2\">\r\n");
      out.write("\t\t\t\t\t<a style=\"text-shadow:1px 1px 1px gray;\">다재다능</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-8 col-sm-10 main-menu text-right\">\r\n");
      out.write("\t\t\t\t\t<div class=\"toggle-menu visible-sm visible-xs\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-bars\"></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<ul class=\"menu-first\">\r\n");
      out.write("\t\t\t\t\t\t<li id=\"home\"><a href=\"/semi/mgrmain\">Home_관리자</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"minfo\"><a href=\"/semi/mgrmember\">회원정보</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"category\"><a href=\"/semi/clist\">카테고리</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"board\"><a href=\"/semi/nlist\">게시판</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<br><br><br><br>\r\n");
      out.write("\t<div class=\"content-section\" id=\"services\">\r\n");
      out.write("\t\t<div class=\"container\" align=\"center\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"heading-section col-sm-12 col-md-12 text-center\">\r\n");
      out.write("\t\t\t\t\t<h2 style=\"text-shadow:1px 1px 2px gray;\">재능기부 승인 요청</h2>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(clistCount);
      out.write("개</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div><br>\r\n");
      out.write("\t\t\t<div id=\"portfolio\">\r\n");
      out.write("\t\t\t\t");
 if(ccurrentPage<=1) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<button id=\"pre\">◀</button>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button id=\"pre\" onclick=\"location.href='/semi/mgrmain?cpage=");
      out.print(ccurrentPage-1);
      out.write("'\">◀</button>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t");
 for(Category c : clist) { 
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"columnC\">\r\n");
      out.write("\t\t\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t");
if(c.getCategoryTitle().length()>11) {
								String cTitle = c.getCategoryTitle().substring(0, 10)+"..."; 	
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(cTitle);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
} else {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(c.getCategoryTitle());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t");
if(c.getCategoryContent().length()>62) {
								String cContent = c.getCategoryContent().substring(0, 61)+"..."; 	
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(cContent);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
} else {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(c.getCategoryContent());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<a href=\"/semi/cdetail?cnum=");
      out.print(c.getCategoryNo());
      out.write("&cpage=");
      out.print(ccurrentPage);
      out.write("\" id=\"readBt\" class=\"icon icon-plus-sign button\">Read More</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
if((clist.size()%4)!=0) {
					for(int i=clist.size()%4; i<4; i++) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=\"columnC\"> &nbsp; </div>\r\n");
      out.write("\t\t\t\t");
}}
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 if(ccurrentPage>=cmaxPage) { 
      out.write("\r\n");
      out.write("\t\t\t\t<button id=\"next\">▶</button>\r\n");
      out.write("\t\t\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<button id=\"next\" onclick=\"location.href='/semi/mgrmain?cpage=");
      out.print(ccurrentPage+1);
      out.write("'\">▶</button>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</div><br><br>\r\n");
      out.write("\t\t\t<button id=\"tmore\">More</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br><br><br><br><br><br><br>\r\n");
      out.write("\t<div class=\"content-section col-md-12\" id=\"services\">\r\n");
      out.write("\t\t<div class=\"container\" align=\"center\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"heading-section text-center\">\r\n");
      out.write("\t\t\t\t\t<h2 style=\"text-shadow:1px 1px 2px gray;\">Q&A 답변 대기</h2>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.print(qlist.size());
      out.write("개</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<table class=\"qnatb\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"cols\">글번호</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"cols\">제목</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"cols\">내용</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"cols\">작성자</th>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"cols\">작성일</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t");
 for(Question q : qlist) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th scope=\"row\">");
      out.print(q.getQuestionNum());
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"/semi/qdetail?no=");
      out.print(q.getQuestionNum());
      out.write("&page=1\">");
      out.print(q.getQuestionTitle());
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t\t\t<td><a href=\"/semi/qdetail?no=");
      out.print(q.getQuestionNum());
      out.write("&page=1\">\r\n");
      out.write("\t\t\t\t\t\t\t");
if(q.getQuestionContent().length()>16) {
								String qcontent = q.getQuestionContent().substring(0, 15)+"..."; 	
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(qcontent);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
} else {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print(q.getQuestionContent());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</a></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(q.getQuestionWriter());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(q.getQuestionDate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table><br><br>\r\n");
      out.write("\t\t\t<button id=\"qmore\">more</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
 } else {  
      out.write("\r\n");
      out.write("\t<h2>관리자로 로그인해주세요.</h2>\r\n");
      out.write("\t");
 } 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<title>Talent Donation - Manager</title>\t\r\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/font-awesome.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/animate.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/templatemo_misc.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/semi/css/templatemo_style.css\">\r\n");
      out.write("    <script src=\"/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<br style=\"clear:left;\"><br>\r\n");
      out.write("\t<div id=\"footer\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-8 col-xs-12 text-left\">\r\n");
      out.write("\t\t\t\t\t<span>Copyright &copy; 2017 다재다능 (Talent Donation)</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4 hidden-xs text-right\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#top\" id=\"go-top\">Back to top</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
