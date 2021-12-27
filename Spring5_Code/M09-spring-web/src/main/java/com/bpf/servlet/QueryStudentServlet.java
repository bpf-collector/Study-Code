package com.bpf.servlet;

import com.bpf.bean.Student;
import com.bpf.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        // 直接创建容器对象
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 使用监听器，从 ServletContext 中获取容器对象
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        System.out.println("ctx = " + ctx);

        // 从容器中获取 Service 对象
        StudentService studentService = (StudentService) ctx.getBean("studentService");

        Student student = studentService.queryStudentById(Integer.valueOf(id));

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(student.toString());
    }
}
