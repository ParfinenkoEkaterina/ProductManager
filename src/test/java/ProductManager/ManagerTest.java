package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 450, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Ronny");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotAvailable() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 600, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 600, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Harry Potter");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testReturnThePartOfTheGoods() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 600, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 450, "Lingren");
        Book book4 = new Book(4, "Ronny", 1200, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book3, book4};
        Product[] actual = manager.searchBy("Ronny");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnAuthor() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 600, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 450, "Lingren");
        Book book4 = new Book(4, "Ronny", 1200, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        boolean expected = true;
        boolean actual = manager.matches(book1, "Usachev");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notToReturnAuthor() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Dog Sonya", 600, "Usachev");
        Book book2 = new Book(2, "Xobbit", 1000, "Tolkin");
        Book book3 = new Book(3, "Ronny", 450, "Lingren");
        Book book4 = new Book(4, "Ronny", 1200, "Lingren");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        boolean expected = false;
        boolean actual = manager.matches(book1, "Lingren");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnVendor() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Product smartphone1 = new Smartphone(10, "GoodPhone", 30000, "Good Vendor");
        Product smartphone2 = new Smartphone(11, "NewPhone", 35000, "New Vendor");
        Product smartphone3 = new Smartphone(12, "GreatPhone", 38000, "Greate Vendor");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        boolean expected = true;
        boolean actual = manager.matches(smartphone3, "Greate Vendor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotToReturnVendor() {
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

        boolean expected = false;
        boolean actual = manager.matches(smartphone1, "New Vendor");


        Assertions.assertEquals(expected, actual);
    }


}














