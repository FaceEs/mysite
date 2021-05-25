package ru.mysite.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.mysite.web.classes.User;

public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<table border=\"1\" width=\"100%\" cellpadding=\"5\">");
        resp.getWriter().write("<tr>" +
                "<th>ID</th>" +
                "<th>Name</th>" +
                "<th>Phone</th>");
        final String dir = System.getProperty("user.dir").
                substring(0,System.getProperty("user.dir").length()-4)
                + "\\webapps\\ROOT";
        System.out.println(dir);
        BufferedReader reader = new BufferedReader(new FileReader(
                dir + "\\table.csv"));

        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<User> users = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            User user = new User();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            resp.getWriter().write("<tr>");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) {
                    user.setId(Integer.parseInt(data));
                    resp.getWriter().write("<td>" + user.getId() + "</td>");
                }
                else if (index == 1) {
                    user.setName(data);
                    resp.getWriter().write("<td>" + user.getName() + "</td>");
                }
                else if (index == 2){
                    user.setPhone(data);
                    resp.getWriter().write("<td>" + user.getPhone() + "</td>");
                }
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            resp.getWriter().write("</tr>");

            users.add(user);
        }
        resp.getWriter().write("</table>");
        reader.close();

    }
}
