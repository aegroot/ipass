package domain;

public class AssortimentProduct {
    private Product product;
    private int id;
    private double kilo;
    private  double nieuwprijs=berekenprijs();

    public double berekenprijs(){


        return kilo*product.getStartprijs();
    }


    public AssortimentProduct(Product product,double kilo) {
        this.product=product;
        this.kilo=kilo;
    }


    public void setProduct(Product product) {
        this.product = product;
    }



    public Product getProduct() {
        return product;
    }

}
