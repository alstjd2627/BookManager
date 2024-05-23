import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BookManagerTest extends BookManager {

	@BeforeEach
	void setUp() throws Exception {
	}
	

	@Test
	void testAddBook() {
		Book b1 = new Book(10,"어린왕자","생텍쥐베리","1999");
		addBook(b1);
		assertEquals(10,searchBook(10).getId());
	}
	

	@Test
	void testSearchBook() {
		Book b2 = new Book(20,"총균쇠","제레드","1888");
		addBook(b2);
		assertEquals(20,searchBook(20).getId());
	}
	

	@Test
	void testRemoveBook() {
		Book b1 = new Book(10,"어린왕자","생텍쥐베리","1999");
		addBook(b1);
		deleteBook(10);
		
		assertThrows(IllegalArgumentException.class, ()->searchBook(10));
	}
	
	@Test
	void addlexsistingBook() {
		Book b1 = new Book(10,"어린왕자","생텍쥐베리","1999");
		Book b2 = new Book(10,"총균쇠","제레드","1888");
		addBook(b1);
		assertThrows(IllegalArgumentException.class, ()->addBook(b2));
	}
	
	@Test
	void serachnotBook() {
		assertThrows(IllegalArgumentException.class, ()->searchBook(10));
	}
	
	@Test
	void deletenotBook() {
		Book b1 = new Book(10,"어린왕자","생텍쥐베리","1999");
		addBook(b1);
		assertThrows(IllegalArgumentException.class, ()->deleteBook(20));
		
	}

}
