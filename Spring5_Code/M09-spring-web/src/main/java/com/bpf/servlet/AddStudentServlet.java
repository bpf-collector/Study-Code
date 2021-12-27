package com.bpf.servlet;

import com.bpf.bean.Student;
import com.bpf.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        Student student = new Student(name, Integer.valueOf(age));

        // 方法一：直接创建容器对象
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 方法二：使用监听器，然后从 ServletContext 中获取容器对象
        // WebApplicationContext ctx = null;
        // ContextLoaderListener 监听器将容器对象保存到 ServletContext 中的key
        // String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        // Object attribute = getServletContext().getAttribute(key);
        // if (attribute != null) {
        //     ctx = (WebApplicationContext) attribute;
        // }

        // 方法三：使用 Spring工具类获取容器对象，本质是方法二的包装
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        System.out.println("ctx = " + ctx);

        // 从容器中获取 Service 对象
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        studentService.addStudent(student);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>注册成功</h1>");
    }
}
