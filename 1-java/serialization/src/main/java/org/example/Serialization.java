package org.example;

import org.example.model.Product;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String[] args) throws Exception {


        Product product = new Product();
        product.setId(1);
        product.setName("test");
        product.setPrice(100);


        FileOutputStream fos = new FileOutputStream("product.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(product);
        oos.flush();
        oos.close();

        System.out.println("obj serialized");


    }
}
