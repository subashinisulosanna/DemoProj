package org.example;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends ActionSupport {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String execute()
    {
        System.out.println("hiii");

        String email=getEmail();
        String password=getPassword();
        try {
            System.out.println("try");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("try1");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/r1", "root", "suba");
            Statement st = con.createStatement();
            System.out.println("try2");
            ResultSet rs = st.executeQuery("select * from reg where email='"+getEmail()+"' and password='"+getPassword()+"'");
            System.out.println("try3");
            if(rs.next())
            {
                return "success";
            }
            else {
                return "failure";
            }
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }

    }
}
