package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

//
class FoodUtil{
    public static boolean isNonVeg(String item){
        return item.equals("nveg");
    }
}

public class MethodReference {
    public static void main(String[] args) {

//        long millis=System.currentTimeMillis();
//        System.out.println(millis);

//        LongSupplier longSupplier=()->{
//            return System.currentTimeMillis();
//        };
//
        // - or

//        LongSupplier longSupplier=System::currentTimeMillis;
//
//        long millis=longSupplier.getAsLong();
//        System.out.println(millis);


        //-----------------------------------------------------------

        List<String> menu=new ArrayList<>();
        menu.add("veg");
        menu.add("nveg");
        menu.add("nveg");
        menu.add("veg");
        menu.add("nveg");


        //
//        menu.removeIf(item->item.equals("nveg"));
//        menu.removeIf(item->FoodUtil.isNonVeg(item));
        menu.removeIf(FoodUtil::isNonVeg);
        System.out.println(menu);

        //-----------------------------------------------------------


    }
}
