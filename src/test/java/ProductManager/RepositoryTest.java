package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {


    @Test
    public void shouldReturnNameSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("GoodPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOnlySmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOnlyBooks() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(smartphone2);

        repo.removeById(11);

        Product[] expected = new Product[]{};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteNotExistingProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(9);
        });
    }

    @Test
    public void shouldFindEmpty() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void setProductByPrice() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Product product = new Product(10, "GoodPhone", 30000);

        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        int expected = 30000;
        int actual = product.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveCorrectId() {
        Repository repo = new Repository();
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.removeById(10);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(10));
    }


    @Test
    public void shouldRemoveNotCorrectId() {
        Repository repo = new Repository();
        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(13));
    }
}







