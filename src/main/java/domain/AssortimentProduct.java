package domain;

public class AssortimentProduct {
    private Product product;
    private double nieuwprijs;


    public AssortimentProduct(double nieuwprijs,Product product) {
        this.nieuwprijs = nieuwprijs;
        this.product=product;
    }

    public void alterPrijspercentage(int percentage){nieuwprijs=nieuwprijs*percentage;}

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getNieuwprijs() {
        return nieuwprijs;
    }

    public Product getProduct() {
        return product;
    }

    public void setNieuwprijs(double nieuwprijs) {
        this.nieuwprijs = nieuwprijs;
    }
}
