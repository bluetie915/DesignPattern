package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testViewAndViewResolver\">Test ViewAndViewResolver</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t\t模拟修改操作\r\n");
      out.write("\t\t1.原始数据为：1,Tom,123456,Tom@qq.com,12\r\n");
      out.write("\t\t2.密码不能修改\r\n");
      out.write("\t\t3.表单回显，模拟操作直接在表单填写对应的属性值\r\n");
      out.write("\t-->\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<form action=\"springmvc/testModelAttribute\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"id\" value=\"1\"/>\r\n");
      out.write("\t\tusername:<input type=\"text\" name=\"username\" value=\"Tom\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tenail:<input type=\"text\" name=\"email\" value=\"Tom@qq.com\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tage:<input type=\"text\" name=\"age\" value=\"12\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Submit\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testSessionAttributes\">Test SessionAttributes</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testMap\">Test Map</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testModelAndView\">Test ModelAndView</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testServletAPI\">Test ServletAPI</a>\r\n");
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<form action=\"springmvc/testPojo\" method=\"post\">\r\n");
      out.write("\t\tusername:<input type=\"text\" name=\"username\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tpassword:<input type=\"password\" name=\"password\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\temail:<input type=\"text\" name=\"email\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tage:<input type=\"text\" name=\"age\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tcity:<input type=\"text\" name=\"address.city\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tprovince:<input type=\"text\" name=\"address.province\"/>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Submit\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testCookieValue\">Test CookieValue</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testRequestHeader\">Test RequestHeader</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testRequestParam?username=zhangsan&age=11\">Test RequestParam</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<form action=\"springmvc/testRest/1\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"_method\" value=\"PUT\"/> \r\n");
      out.write("\t\t<input type=\"submit\" value=\"Test Rest PUT\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<form action=\"springmvc/testRest/1\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"_method\" value=\"DELETE\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Test Rest DELETE\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<form action=\"springmvc/testRest\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Test Rest POST\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testRest/1\">Test Rest GET</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testPathVariable/1\">Test PathVariable</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testAntPath/lalala/abc\">Test AntPath</a>\r\n");
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"springmvc/testParamsAndHeaders?username=zhangsan&age=10\">Test ParamsAndHeaders</a>\r\n");
      out.write("\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<form action=\"springmvc/testMethod\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Submit\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"helloworld\">Hello World</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<a href=\"helloworld\">Hello World</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
