import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BookManagerTest {

  private BookManager bookManager;

  @BeforeEach
  void setUp() throws Exception {
    bookManager = new BookManager();

  }

  @Test
  void addBook() {
    Book book1 = new Book(1, "자바 기초", "Jane", "2021");
    bookManager.addBook(book1);
    assertEquals(bookManager.searchBook(1), book1);
  }

  @Test
  void addDuplicatedBook() {
    Book book1 = new Book(1, "자바 기초", "Jane", "2021");
    Book book2 = new Book(1, "소프트웨어 공학", "Tom", "2014");
    bookManager.addBook(book1);
    assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(book2));

  }

  @Test
  void searchBook() {
    Book book1 = new Book(1, "자바 기초", "Jane", "2021");
    Book book2 = new Book(2, "소프트웨어 공학", "Tom", "2014");
    Book book3 = new Book(3, "분산 컴퓨팅", "Yoon", "2024");
    bookManager.addBook(book1);
    bookManager.addBook(book2);
    bookManager.addBook(book3);

    assertEquals(bookManager.searchBook(1), book1);
    assertEquals(bookManager.searchBook(2), book2);
    assertEquals(bookManager.searchBook(3), book3);
  }

  @Test
  void searchNotExistBook() {
    assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(1));
  }


  @Test
  void deleteBook() {
    Book book1 = new Book(1, "자바 기초", "Jane", "2021");
    Book book2 = new Book(2, "소프트웨어 공학", "Tom", "2014");
    bookManager.addBook(book1);
    bookManager.addBook(book2);

    bookManager.deleteBook(1);

    assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(1));
  }

  @Test
  void deleteNotExistBook() {
    Book book1 = new Book(1, "자바 기초", "Jane", "2021");
    bookManager.addBook(book1);

    assertThrows(IllegalArgumentException.class, () -> bookManager.deleteBook(2));
  }
  @Test
  void performance_test(){
    for(int i=0 ; i<30000 ; i++){ //검색시간 계산위해 적당히 많은 책 add
      Book book = new Book(i, String.valueOf(i), String.valueOf(i), "2024");
      bookManager.addBook(book);
    }

    assertEquals(bookManager.performance_test(200),2);
    //임의의 id값 검색, performance_test()는 search_bs()가 빠를경우 2를 리턴함
  }

}

