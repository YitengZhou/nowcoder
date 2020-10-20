public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new createProductB();
        Product product = application.getObject();
        product.method();
    }
}

interface Product{
    public void method();
}

class ProductA implements Product{

    @Override
    public void method() {
        System.out.println("A");
    }
}

class ProductB implements Product{
    @Override
    public void method() {
        System.out.println("B");
    }
}

abstract class Application{
    abstract Product createProduct();
    Product getObject(){
        Product product = createProduct();
        return product;
    }
}

class createProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class createProductB extends Application{

    @Override
    Product createProduct() {
        return new ProductB();
    }
}