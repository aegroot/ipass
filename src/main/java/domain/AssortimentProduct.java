package domain;

public class AssortimentProduct {
    private Product product;
    private int id;
    private double hoeveelheid;

    public int getId() {
        return id;
    }

    public double berekenprijs(){


        assert product != null;
        return hoeveelheid*product.getkiloprijs();
    }


    public AssortimentProduct(Product product, int id, double kilo) {
        this.product=product;
        this.id = id;
        this.hoeveelheid=kilo;
    }


    public void setProduct(Product product) {
        this.product = product;
    }



    public Product getProduct() {
        return product;
    }

}
