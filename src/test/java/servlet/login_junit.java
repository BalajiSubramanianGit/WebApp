package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.apache.commons.collections.FactoryUtils;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.message.BasicStatusLine;

import servlet.avnlogin;
import servlet.createpage;

public class login_junit {
	
	
	public avnlogin obj = new avnlogin();
	
	
	@Test
	public void test() throws ServletException, IOException
	{
		
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse(); response.setContentType("text/html;charset=UTF-8");
		request.addParameter("username", "guest");
		request.addParameter("userpassword", "guest");
		System.out.println("Hello");
		obj.doPost(request, response);
		
	}
	
	
	
	
	
	
	
	
	

}
