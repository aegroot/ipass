package domain;

public class AssortimentProduct {
    private Product product;
    private final int id;
    private final double hoeveelheid;

    public int getId() {
        return id;
    }

    public double berekenprijs(){
        assert product != null;
        assert hoeveelheid !=0;
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
