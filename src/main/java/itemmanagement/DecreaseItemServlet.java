package itemmanagement;

import db.DBItemList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/decreaseitem")
public class DecreaseItemServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession s = req.getSession();
        Object o = s.getAttribute("id");
        int idDB = Integer.parseInt(req.getParameter("idDB"));
        int qty = Integer.parseInt(req.getParameter("qty"));

        if (qty == 1) {
            MyItemList mfl = new MyItemList(idDB);
            DBItemList db = new DBItemList();
            db.DeleteItem(mfl);
        } else {
            --qty;
            MyItemList mfl = new MyItemList(idDB, qty);
            DBItemList db = new DBItemList();
            db.UpdateQtyItem(mfl);
        }
        resp.sendRedirect("listClientMenu.jsp");
    }
}