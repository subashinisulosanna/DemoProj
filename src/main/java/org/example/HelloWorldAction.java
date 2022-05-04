/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

@Conversion()
public class HelloWorldAction extends ActionSupport implements ServletRequestAware {
    HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
    private User user;
    private String name="g";
    private String password="k";
    private String email="k";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {
        int i=0;

        String name=getUser().getName();
        String password=getUser().getPassword();
        String email=getUser().getEmail();
        User obj=new User();
        obj.setName(name);
        obj.setPassword(password);
        obj.setEmail(email);
        setUser(obj);
        setName(name);
        setEmail(email);
        setPassword(password);
        System.out.println(name +"  "+password+" "+email);
        try{
            System.out.println("try0"+getUser());
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("try1");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/r1", "root", "suba");
            //String sql="insert into reg values(?,?,?)";
            System.out.println("try2");
            if(con==null)
            {
                System.out.println("not connected");
            }
            System.out.println("try3");
            Statement st=con.createStatement();
            st.executeUpdate("insert into reg values('"+name+"','"+password+"','"+email+"') ");
            System.out.println("try4");
            i++;

        }catch (Exception e){
            System.out.println("exception ");
            System.out.println(e);
            return ERROR;}
//            if(con==null)
//            {
//                System.out.println("shgshg");
//            }


        if(i>0)
        {
            System.out.println("succ");
            return SUCCESS;
        }
        else {
            System.out.println("fail");
            return ERROR;
        }

    }
}
