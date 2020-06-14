package domain;

public class AssortimentProduct {
    private Product product;
    private int id;
    private double kilo;
    private double nieuwprijs;

    public double berekenprijs(){


        assert product != null;
        return kilo*product.getStartprijs();
    }


    public AssortimentProduct(Product product, int id, double kilo) {
        this.product=product;
        this.id = id;
        this.kilo=kilo;
    }


    public void setProduct(Product product) {
        this.product = product;
    }



    public Product getProduct() {
        return product;
    }

}
