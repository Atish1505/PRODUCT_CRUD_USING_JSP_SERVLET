package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.ProductDao;
import com.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("b1").equals("Delete")) {
			if (new ProductDao().DeleteProductByID(Integer.parseInt(req.getParameter("pid"))) > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);

			}
		}
		if(req.getParameter("b1").equals("Display"))
		{
			Product p=new ProductDao().DisplayProductByID(Integer.parseInt(req.getParameter("pid")));
			if(p!=null)
			{
				req.setAttribute("p", p);
				req.getRequestDispatcher("ProductDetails.jsp").forward(req, resp);
			}
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("b1").equals("Add")) {
			Product p = new Product();
			p.setPname(req.getParameter("pname"));
			p.setPtype(req.getParameter("ptype"));
			p.setPdesc(req.getParameter("pdesc"));
			p.setPprice(Double.parseDouble(req.getParameter("pprice")));
			if (new ProductDao().InsertProduct(p) > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}

		}

		if (req.getParameter("b1").equals("Delete")) {
			if (new ProductDao().DeleteProductByID(Integer.parseInt(req.getParameter("pid"))) > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);

			}
		}
		if(req.getParameter("b1").equals("Display"))
		{
			Product p=new ProductDao().DisplayProductByID(Integer.parseInt(req.getParameter("pid")));
			if(p!=null)
			{
				req.setAttribute("p", p);
				req.getRequestDispatcher("ProductDetails.jsp").forward(req, resp);
			}
			
		}
		if (req.getParameter("b1").equals("Update")) {
			Product p = new Product();
			p.setPid(Integer.parseInt(req.getParameter("pid")));
			p.setPname(req.getParameter("pname"));
			p.setPtype(req.getParameter("ptype"));
			p.setPdesc(req.getParameter("pdesc"));
			p.setPprice(Double.parseDouble(req.getParameter("pprice")));
			if (new ProductDao().UpdateProductByID(p) > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}

		}
	}
}
