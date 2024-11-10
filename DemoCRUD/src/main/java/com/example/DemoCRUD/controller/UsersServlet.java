package com.example.DemoCRUD.controller;

import com.example.DemoCRUD.model.Users;
import com.example.DemoCRUD.repository.UsersRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UsersServlet",
        value={"/user/hien-thi",
                "/user/remove",
                "/user/view-update",
                "/user/add",
                "/user/update"
        })
public class UsersServlet extends HttpServlet {
    private UsersRepository repository = new UsersRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("user/hien-thi")) {
            this.viewUsers(request,response);
        }  else if (uri.contains("user/remove")){
            this.viewRemove(request, response);
        } else {
            this.viewUpdateUsers(request, response);
        }
    }

    private void viewUpdateUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Users u = repository.getOne(id);
        request.setAttribute("u", u);
        request.getRequestDispatcher("/view/update.jsp").forward(request,response);
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Users u = repository.getOne(id);
        repository.delete(u);
        response.sendRedirect("/user/hien-thi");
    }

    private void viewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", repository.getAll());
        request.getRequestDispatcher("/view/user.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("user/add")) {
            this.addUsers(request, response);
        } else {
            this.updateUsers(request, response);
        }
    }

    private void updateUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Users u = repository.getOne(id);
        repository.update(u);
        response.sendRedirect("/user/hien-thi");
    }

    private void addUsers(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Users u = new Users();
        BeanUtils.populate(u, request.getParameterMap());
        repository.add(u);
        response.sendRedirect("/user/hien-thi");
    }
}
