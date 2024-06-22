package pw.karczewski.author;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @NotBlank
    private String name;
}
