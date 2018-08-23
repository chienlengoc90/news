package vn.chienlengoc.web.controller.admin.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.chienlengoc.dto.NewsDTO;
import vn.chienlengoc.service.INewsService;

@RestController
@RequestMapping("/ajax/news")
public class NewsAPI {

	@Autowired
	private INewsService newsService;

	@PostMapping
	public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO newsDTO, HttpSession session) {
		try {
			if (session.getAttribute("addOrEditNews") != null) {
				NewsDTO result = newsService.insert(newsDTO);
				session.removeAttribute("addOrEditNews");			
				return ResponseEntity.ok(result);
			}
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<NewsDTO> updateNews(@PathVariable("id") long id, @RequestBody NewsDTO newsDTO,
			HttpSession session) {
		try {
			if (session.getAttribute("addOrEditNews") != null) {
				NewsDTO result = newsService.update(id, newsDTO);
				session.removeAttribute("addOrEditNews");
				return ResponseEntity.ok(result);
			}
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping
	public ResponseEntity<Void> deleteNews(@RequestBody long[] id) {
		try {
			if (id.length > 0) {
				for (long l : id) {
					if (newsService.findNewsById(l) != null) {
						newsService.delete(l);
					}
				}
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	// @Autowired
	// private BookService bookService;
	//
	// /*---Add new book---*/
	// @PostMapping("/book")
	// public ResponseEntity<?> save(@RequestBody Book book) {
	// long id = bookService.save(book);
	// return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	// }
	//
	// /*---Get a book by id---*/
	// @GetMapping("/book/{id}")
	// public ResponseEntity<Book> get(@PathVariable("id") long id) {
	// Book book = bookService.get(id);
	// return ResponseEntity.ok().body(book);
	// }
	//
	// /*---get all books---*/
	// @GetMapping("/book")
	// public ResponseEntity<List<Book>> list() {
	// List<Book> books = bookService.list();
	// return ResponseEntity.ok().body(books);
	// }
	//
	// /*---Update a book by id---*/
	// @PutMapping("/book/{id}")
	// public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody
	// Book book) {
	// bookService.update(id, book);
	// return ResponseEntity.ok().body("Book has been updated successfully.");
	// }
	//
	// /*---Delete a book by id---*/
	// @DeleteMapping("/book/{id}")
	// public ResponseEntity<?> delete(@PathVariable("id") long id) {
	// bookService.delete(id);
	// return ResponseEntity.ok().body("Book has been deleted successfully.");
	// }
}
