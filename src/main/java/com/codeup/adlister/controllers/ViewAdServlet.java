package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewAdServlet", urlPatterns = "/ads/view")
public class ViewAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")== null){
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }else {
            System.out.println(request.getParameter("id"));
            request.setAttribute("ad", DaoFactory.getAdsDao().viewOneAd(Long.valueOf(request.getParameter("id"))));
            request.getRequestDispatcher("/WEB-INF/ads/view.jsp").forward(request, response);
        }
    }
}
