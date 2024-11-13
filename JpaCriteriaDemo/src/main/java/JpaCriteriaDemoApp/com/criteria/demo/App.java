package JpaCriteriaDemoApp.com.criteria.demo;

import java.util.List;

import com.criteria.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class App {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaCriteriaApp");

	private static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		/*
		 * em.getTransaction().begin(); em.persist(new Book(1001, "JPA Book", 450.25,
		 * "Tim")); em.persist(new Book(1002, "JDBC Book", 550.25, "Nag"));
		 * em.persist(new Book(1003, "Spring Book", 350.25, "John")); em.persist(new
		 * Book(1004, "Java Book", 650.25, "Herbert")); em.persist(new Book(1005,
		 * "Spring in Action", 350.25, "John")); em.persist(new Book(1006,
		 * "HeadFirst Java", 650.25, "Herbert"));
		 * 
		 * em.getTransaction().commit();
		 * 
		 * System.out.println("book saved in db");
		 */

		CriteriaBuilder cb = em.getCriteriaBuilder(); // 1. get criteria builder
		CriteriaQuery<Book> cq = cb.createQuery(Book.class); // 2. obtain criteriaQuery on entity
		Root<Book> bookRoot = cq.from(Book.class); // 3. obtain root element for criteria
		CriteriaQuery<Book> selectCriteria = cq.select(bookRoot); // 4. apply criteria

		TypedQuery<Book> tq = em.createQuery(selectCriteria); // 5. making a typedquery with criteria

		List<Book> bookList = tq.getResultList(); // 6. obtain result

		for (Book book : bookList) {
			System.out.println(book);
		}

		/*
		 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery cq =
		 * cb.createQuery(); Root<Book> book = cq.from(Book.class); CriteriaQuery select
		 * = cq.select(book); TypedQuery<Book> tq = em.createQuery(select);
		 * 
		 * List<Book> bookList = tq.getResultList();
		 * 
		 * for (Book b : bookList) { System.out.println(b); }
		 * 
		 * findBookByAuthor("Tim");
		 */

		List<Book> books = findBookByAuthor("Herbert");

		System.out.println("Herbert is author for: " + books.size());

		List<Book> sortedBooksByName = getBooksSortedByName();
		System.out.println("--Books sorted by Name--");
		for(Book b:sortedBooksByName) {
			
			System.out.println(b);
		}
		
		System.out.print("No.of Books by John:");
		System.out.println(countBooksByAuthor("John"));

		em.close();
		emf.close();
	}

	private static List<Book> findBookByAuthor(String authorName) {

		// Step 1: Get the CriteriaBuilder instance from the EntityManager
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Step 2: Create a CriteriaQuery object for the Book entity
		CriteriaQuery<Book> query = cb.createQuery(Book.class);

		// Step 3: Define the root of the query (i.e., the Book entity)
		Root<Book> bookRoot = query.from(Book.class);

		// Step 4: Create a Predicate for the author's name condition
		Predicate authorNamePredicate = cb.equal(bookRoot.get("author"), authorName);

		// Step 5: Apply the Predicate to the query
		query.select(bookRoot).where(authorNamePredicate);

		// Step 6: Execute the query to get the list of matching books
		TypedQuery<Book> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}

	public static List<Book> getBooksSortedByName() {
		// Step 1: Get the CriteriaBuilder instance from the EntityManager
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Step 2: Create a CriteriaQuery object for the Book entity
		CriteriaQuery<Book> query = cb.createQuery(Book.class);

		// Step 3: Define the root of the query (i.e., the Book entity)
		Root<Book> bookRoot = query.from(Book.class);

		// Step 4: Set the ordering by the "name" field in ascending order
		query.select(bookRoot).orderBy(cb.asc(bookRoot.get("name")));

		// Step 5: Execute the query to get the list of sorted books
		TypedQuery<Book> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}

	public static long countBooksByAuthor(String authorName) {
		// Step 1: Get the CriteriaBuilder instance from the EntityManager
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Step 2: Create a CriteriaQuery object for a Long type (the count result)
		CriteriaQuery<Long> query = cb.createQuery(Long.class);

		// Step 3: Define the root of the query (i.e., the Book entity)
		Root<Book> bookRoot = query.from(Book.class);

		// Step 4: Create a Predicate for the author's name condition
		Predicate authorNamePredicate = cb.equal(bookRoot.get("author"), authorName);

		// Step 5: Set the selection to the count of books and apply the Predicate
		query.select(cb.count(bookRoot)).where(authorNamePredicate);

		// Step 6: Execute the query to get the count
		TypedQuery<Long> typedQuery = em.createQuery(query);
		return typedQuery.getSingleResult();
	}
}