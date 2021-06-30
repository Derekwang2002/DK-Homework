package com.swufe.javaee.request_response;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.TriangleAvatar;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "UpLoadImagServlet", value = "/UpLoadImagServlet")
@MultipartConfig
public class UpLoadImagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Avatar avatar = TriangleAvatar.newAvatarBuilder().build();

        BufferedImage image=avatar.create(123456L);
        ImageIO.write(image,"png",response.getOutputStream());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part= request.getPart("file");
        part.write("/Users/derekedkwangxingen//Desktop/HW.png");
        response.sendRedirect("UploadImage.html");

    }
}
