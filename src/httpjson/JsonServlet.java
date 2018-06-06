package httpjson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JsonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4129161491740488105L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		  response.setContentType("text/html");
		  response.setCharacterEncoding("UTF-8");      //解决中文乱码问题

		  PrintWriter out = response.getWriter();
		  Map<String,Object> map = new HashMap<String,Object>(); 

		  map.put("name", "Dana、Li"); 
		  map.put("age", new Integer(22)); 
		  map.put("Provinces", new String("广东省")); 
		  map.put("citiy", new String("珠海市")); 
		  map.put("Master", new String("C、C++、Linux、Java"));
		  JSONObject json = JSONObject.fromObject(map); 
		  
		  out.write(json.toString());
		  out.flush();
		  out.close();
	}

}
