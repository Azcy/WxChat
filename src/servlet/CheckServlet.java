package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.CoreService;
import util.CheckUtil;

public class CheckServlet   extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//微信加密签名
		String signature=req.getParameter("signature");
		
		//时间戳
		String timestamp=req.getParameter("timestamp");
		
		//随机字符串
		String nonce=req.getParameter("nonce");
		
		//随机字符串
		String echostr=req.getParameter("echostr");
		
		//打印结果
		System.out.println("signature:"+signature);
	 	System.out.println("timestamp:"+timestamp);
        System.out.println("noce:"+nonce);
        System.out.println("echostr:"+echostr);
		 PrintWriter out = resp.getWriter();
		 
		 if (CheckUtil.checkSignature(signature, timestamp,nonce )) {
			 
	            out.print(echostr);
	        	
	        }
		 out.close();
		 out=null;
		 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  CoreService coreService =new CoreService();  
		 try {  
	            req.setCharacterEncoding("UTF-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        resp.setCharacterEncoding("UTF-8");  
	  
	        // 调用核心业务类接收消息、处理消息  
	        String respMessage = coreService.processRequest(req);  
	  
	        // 响应消息  
	        PrintWriter out = null;  
	        try {  
	            out = resp.getWriter();  
	            out.print(respMessage);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            out.close();  
	            out = null;  
	        }  
	    }  
	}

