public class TenantAlert {
    String name;
    String lastName;
    Long id;
    double price;

    public TenantAlert(String name,String lastName,long id,double price){
        this.name = name;
        this.lastName = lastName;
        this.id= id ;
        this.price=price;
    }

    @Override
    public String toString() {
        return "TenantAlert{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
