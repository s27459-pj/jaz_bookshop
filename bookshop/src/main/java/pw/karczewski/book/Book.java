package pw.karczewski.book;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pw.karczewski.author.Author;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @NotBlank
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @NotNull
    @NotBlank
    private String genre;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer pages;

    @NotNull
    private Integer views = 0;

    @NotNull
    private Integer available;
}
