package pw.karczewski.book;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pw.karczewski.openapi.api.BooksApi;
import pw.karczewski.openapi.model.BookCreate;
import pw.karczewski.openapi.model.BookRetrieve;
import pw.karczewski.openapi.model.BookUpdate;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController implements BooksApi {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookRetrieve>> getBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    // FIXME: For some reason, this handler is shadowed by the super implementation,
    // so we have to use a different path for it. It shouldn't be under `/create`.
    @PostMapping("/create")
    public ResponseEntity<BookRetrieve> createBook(@Valid @RequestBody BookCreate data) {
        return ResponseEntity.ok(bookService.create(data));
    }

    // FIXME: For some reason, this handler is shadowed by the super implementation,
    // so we have to use a different path for it. It shouldn't be under `/update`.
    @PutMapping("/update/{id}")
    public ResponseEntity<BookRetrieve> updateBook(@PathVariable UUID id, @Valid @RequestBody BookUpdate data) {
        return ResponseEntity.ok(bookService.update(id, data));
    }

    // FIXME: For some reason, this handler is shadowed by the super implementation,
    // so we have to use a different path for it. It shouldn't be under `/delete`.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
