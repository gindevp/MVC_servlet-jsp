package com.example.jstl_demo.product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static List<Product> productList= new ArrayList<>();
    static {
        productList.add(new Product(1,"bim",5000,"Ha Noi"));
        productList.add(new Product(2,"bim bim",5000,"Ha Noi"));
        productList.add(new Product(3,"bim bimm",5000,"Ha Noi"));
        productList.add(new Product(4,"bimm",5000,"Ha Noi"));
        productList.add(new Product(5,"bimbim",5000,"Ha Noi"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        int index=0;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId()==id){
                index=i;
            }
        }
        return productList.get(index);
    }

    @Override
    public Product findByName(String name) {
        int index=0;
        for (int i = 0; i < productList.size() ; i++) {
            if(name.equals(productList.get(i).getName())){
                index=i;
            }
        }
        return productList.get(index);
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        int index=0;
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId()==id){
                index=i;
            }
        }
        productList.set(index,product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
}
