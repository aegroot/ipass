package domain;

import java.util.ArrayList;

public class Winkelwagen {
    private  ArrayList<AssortimentProduct> producten=new ArrayList<>();
    public  ArrayList<AssortimentProduct> getProducten() {
        return producten;
    }

    public boolean remproduct(AssortimentProduct product){
        if (producten.contains(product)){
        product=null;
        return true;
        }
        return false;
   }
   public AssortimentProduct getByid(int id){
       for (AssortimentProduct product:producten) {
           if (product.getId() == id){
               return product;
           }
       }
       return null;
   }

   public boolean addproduct(AssortimentProduct product){
       if (producten.contains(product)){producten.add(product); return true;}
   else return false;
    }
}
