package yong.controller;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.command.CommandHandler;
import yong.command.ContentAction;
import yong.command.ListAction;
import yong.command.UpdateAction;
import yong.command.WriteAction;

public class YongController extends HttpServlet {
	
	private Map commandMap;
	
	public YongController(){//값에 대한 초기화
		commandMap = new HashMap<String, Object>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {// 기능에 대한 초기화
		//프로퍼티스 파일을 찾아야한다.
		String path=config.getServletContext().getRealPath("/WEB-INF/yongCommand.properties");		//내가 작업하고있는 프로젝트의 위치값
		//System.out.println("path="+path);
		Properties prop = null;
		try {
			FileInputStream fis = new FileInputStream(path);//파일경로
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//파일을 가져오는 행위
		Iterator keys = prop.keySet().iterator();
		while(keys.hasNext()){//뒤에 데이터가 있느냐?
			String key=(String)keys.next();
			String classPath=prop.getProperty(key);
			
			try {
				Class obj_class=Class.forName(classPath);
				Object obj = obj_class.newInstance();//키에 해당하는 실제 객체.
				commandMap.put(key, obj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userProcess(req, resp);
	}
	protected void userProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      //액션 퍼포메드랑 같은 거
	      //1.http 요청받음(awt의 obj반환받음)
	      //String type=req.getParameter("type");
	    String type=null;  
		String userUrl=req.getRequestURI();
	      if(userUrl.indexOf(req.getContextPath())==0){
	    	  type=userUrl.substring(req.getContextPath().length());
	      }
	      //2.요구 기능 분석
	      CommandHandler command=(CommandHandler)commandMap.get(type);
	      String goPage=null;
	      
	      //4. 결과저장
	      goPage=command.process(req, resp);
	      //5. 이동
	      RequestDispatcher dis=req.getRequestDispatcher(goPage);
	      dis.forward(req, resp);
	   }
	
}
