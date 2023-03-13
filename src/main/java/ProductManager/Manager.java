package ProductManager;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for(Product product: repository.findAll() {
            if (matches(product, text)) {

        }
    }
    return result;
}
}
