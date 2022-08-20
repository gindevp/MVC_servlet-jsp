package com.example.jstl_demo.product;

import com.example.jstl_demo.customer.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
private ProductService productService= new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action= req.getParameter("action");
       if(action==null){
           action="";
       }
       switch (action){
           case "create":
               showCreateForm(req,resp);
               break;
           case "update":
               showUpdateForm(req,resp);
               break;
           case "delete":
               showDeleteForm(req,resp);
               break;
           case "view":
               showViewForm(req,resp);
               break;
           default:
               listProduct(req,resp);
               break;
       }
    }

    private void showViewForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("product", product );
            dispatcher = req.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id= Integer.parseInt(req.getParameter("id"));
        Product product= this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product== null){
            dispatcher= req.getRequestDispatcher("customer/error-404.jsp");
        }else {
            req.setAttribute("product",product);
            dispatcher= req.getRequestDispatcher("product/delete.jsp");
        }
        try{
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp){
        int id= Integer.parseInt(req.getParameter("id"));
        Product product= productService.findById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher= req.getRequestDispatcher("customer/error-404.jsp");
        }else {
            req.setAttribute("product",product);
            dispatcher= req.getRequestDispatcher("product/update.jsp");
        }
        try{
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products= productService.findAll();
        req.setAttribute("products",products);
        RequestDispatcher dispatcher= req.getRequestDispatcher("product/list.jsp");
                try{
                    dispatcher.forward(req,resp);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("product/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "update":
                updateProduct(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            case "search":
                searchProduct(req,resp);
                break;
            default:
                break;
        }
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) {
        String search= req.getParameter("search");
        Product product= this.productService.findByName(search);
        RequestDispatcher dispatcher= req.getRequestDispatcher("product/search.jsp");
        req.setAttribute("product",product);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Product product= this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
            dispatcher.forward(req,resp);
        } else {
            this.productService.delete(id);
            try {
                resp.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id= Integer.parseInt(req.getParameter("id"));
        String name= req.getParameter("name");
        int cost= Integer.parseInt(req.getParameter("cost"));
        String address= req.getParameter("address");
        Product product= this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher= req.getRequestDispatcher("customer/error-404.jsp");
        }else{
            product.setName(name);
            product.setCost(cost);
            product.setAddress(address);
            this.productService.edit(id,product);
            req.setAttribute("product",product);
            req.setAttribute("message","Product infomation was updated");
            dispatcher= req.getRequestDispatcher("product/update.jsp");

        }
        try{
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name=req.getParameter("name");
        int cost= Integer.parseInt(req.getParameter("cost"));
        String address= req.getParameter("address");
        int id= (int)(Math.random()*1000);
         Product product= new Product(id,name,cost,address);
         productService.add(product);
         RequestDispatcher dispatcher= req.getRequestDispatcher("product/create.jsp");
         req.setAttribute("message","New product was created");
         try{
             dispatcher.forward(req,resp);
         } catch (ServletException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
