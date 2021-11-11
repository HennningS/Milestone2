package bacit.web.bacit_web;

import bacit.web.bacit_models.HtmlGreier;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "productList", value = "/Product_list")
public class ProductListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String ProduktID = request.getParameter("produkt");

        if( ProduktID != null ) {

        }
        else {


            out.println("<ul>");

            try {

                Connection con = DBUtils.getINSTANCE().getConnection();
                PreparedStatement ps = con.prepareStatement("select * from Produkter where brukes = 0");
                ResultSet res = ps.executeQuery();

                while (res.next()){
                    out.println("<li><a href='#'>"+res.getString("Produkt_navn")+"</a></li>");
                    out.println("<li>"+res.getString("Kategori")+"</li>");
                    out.println("<li>"+res.getString("Beskrivelse")+"</li>");
                }

                out.println("</ul>");
            }
            catch (SQLException | ClassNotFoundException e){
                out.println("Noe funket ikke: "+e);
            }
        }
        addProductForm(out,null);
    }

    private void addProductForm(PrintWriter out, String errorMessage) {
        HtmlGreier.writeHtmlStart(out, "Legg til nytt produkt");
        if (errorMessage != null) {
            out.println("<h3>" + errorMessage + "</h3>");
        }
        out.println("<form action='login' method='post'/>");
        out.println("<a href='/bacit-web-1.0-SNAPSHOT/register_product'>Legg til nytt produkt</a>");
        HtmlGreier.writeHtmlEnd(out);
    }
}


