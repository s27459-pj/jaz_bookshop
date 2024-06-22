package pw.karczewski.book;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pw.karczewski.openapi.model.BookCreate;
import pw.karczewski.openapi.model.BookRetrieve;
import pw.karczewski.openapi.model.BookUpdate;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookRetrieve> getAll() {
        return bookRepository.findAll().stream().map(bookMapper::toRetrieve).toList();
    }

    public BookRetrieve create(BookCreate data) {
        var book = bookRepository.save(bookMapper.toEntity(data));
        return bookMapper.toRetrieve(book);
    }

    @Transactional
    public BookRetrieve update(UUID id, BookUpdate data) {
        var book = bookRepository.findById(id).orElseThrow();
        var updated = bookMapper.toUpdate(book, data);
        return bookMapper.toRetrieve(updated);
    }

    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
