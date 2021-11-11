package bacit.web.bacit_web;

import bacit.web.bacit_models.HtmlGreier;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomePageServlet", value = "/home_page")
public class HomePageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        homePageForm(out,null);
    }

    private void homePageForm(PrintWriter out, String errorMessage) {
        HtmlGreier.writeHtmlStart(out, "Home Page");
        if (errorMessage != null) {
            out.println("<h3>" + errorMessage + "</h3>");
        }
        out.println("<form action='login' method='post'/>");
        out.println("<a href='/bacit-web-1.0-SNAPSHOT/upload'>Last opp fil</a>");
        out.println("<br>");
        out.println("<a href='/bacit-web-1.0-SNAPSHOT/download'>Last ned fil</a>");
        out.println("<br>");
        out.println("<a href='/bacit-web-1.0-SNAPSHOT/Product_list'>Produktliste</a>");
        out.println("<br>");
        HtmlGreier.writeHtmlEnd(out);
    }
}
