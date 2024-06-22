package pw.karczewski.author;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pw.karczewski.openapi.api.AuthorsApi;
import pw.karczewski.openapi.model.AuthorCreate;
import pw.karczewski.openapi.model.AuthorRetrieve;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController implements AuthorsApi {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorRetrieve>> getAuthors() {
        return ResponseEntity.ok(authorService.getAll());
    }

    // FIXME: For some reason, this handler is shadowed by the super implementation,
    // so we have to use a different path for it. It shouldn't be under `/create`.
    @PostMapping("/create")
    public ResponseEntity<AuthorRetrieve> createAuthor(@Valid @RequestBody AuthorCreate data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(data));
    }
}
