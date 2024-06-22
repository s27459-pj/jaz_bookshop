package pw.karczewski.author;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pw.karczewski.openapi.model.AuthorCreate;
import pw.karczewski.openapi.model.AuthorRetrieve;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorRetrieve> getAll() {
        return authorRepository.findAll().stream().map(authorMapper::toRetrieve).toList();
    }

    public AuthorRetrieve create(AuthorCreate data) {
        var author = authorRepository.save(authorMapper.toEntity(data));
        return authorMapper.toRetrieve(author);
    }
}
