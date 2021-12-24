package mao.httpservletresponse_interface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：HttpServletResponse_interface
 * Package(包名): mao.httpservletresponse_interface
 * Class(类名): OutServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/24
 * Time(创建时间)： 12:36
 * Version(版本): 1.0
 * Description(描述)： 响应行相关的方法
 * 返回值类型        	方法	                描述
 * void	setStatus（int status）	用于设置 HTTP 响应消息的状态码，并生成响应状态行。
 * void	sendError（int sc）	用于发送表示错误信息的状态码。
 * 响应头相关的方法
 * 返回值类型    	方法	                            描述
 * void	addHeader(String name,String value)	用于增加响应头字段，其中，参数 name 用于指定响应头字段的名称，参数 value 用于指定响应头字段的值。
 * void	setHeader (String name,String value)	用于设置响应头字段，其中，参数 name 用于指定响应头字段的名称，参数 value 用于指定响应头字段的值。
 * void	addIntHeader(String name,int value)	用于增加值为 int 类型的响应头字段，其中，参数 name 用于指定响应头字段的名称，参数 value 用于指定响应头字段的值，类型为 int。
 * void	setIntHeader(String name, int value)	用于设置值为 int 类型的响应头字段，其中，参数 name 用于指定响应头字段的名称，参数 value 用于指定响应头字段的值，类型为 int。
 * void	setContentType(String type)	用于设置 Servlet 输出内容的 MIME 类型以及编码格式。
 * void	setCharacterEncoding(String charset)	用于设置输出内容使用的字符编码。
 * 响应体相关的方法
 * 返回值类型	        方法	                        描述
 * ServletOutputStream	getOutputStream()	用于获取字节输出流对象。
 * PrintWriter	getWriter()	用于获取字符输出流对象。
 */

public class OutServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        run1(response);
        run2(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

    // 使用字符流向页面输出
    public void run2(HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("字符流");
    }

    // 使用字节流向页面输出
    // 使用字节流向页面输出
    public void run1(HttpServletResponse response) throws IOException
    {
        // 设置浏览器打开文件时编码
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        // 获取字节输出流
        OutputStream outputStream = response.getOutputStream();
        byte[] str = "字节输出流".getBytes(StandardCharsets.UTF_8);
        // 输出中文
        outputStream.write(str);
    }
}
