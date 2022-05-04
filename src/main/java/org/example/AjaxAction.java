package org.example;

import java.io.*;
import javax.servlet.http.*;
import org.apache.struts2.*;
import com.opensymphony.xwork2.*;

public class AjaxAction extends ActionSupport{
    private static final long serialVersionUID=1L;
    public void hello()
    {
        try{
            HttpServletResponse response=ServletActionContext.getResponse();
            response.setContentType("text/plain;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("hello");
            out.flush();
        }catch (Exception e){

        }
    }
}
