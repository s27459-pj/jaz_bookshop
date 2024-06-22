package pw.karczewski.book;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import pw.karczewski.openapi.model.BookCreate;
import pw.karczewski.openapi.model.BookRetrieve;
import pw.karczewski.openapi.model.BookUpdate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "views", constant = "0")
    @Mapping(target = "author.id", source = "author")
    Book toEntity(BookCreate bookCreate);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "views", ignore = true)
    @Mapping(target = "author.id", source = "author")
    Book toUpdate(@MappingTarget Book book, BookUpdate bookUpdate);

    @Mapping(target = "author", source = "author.id")
    BookRetrieve toRetrieve(Book book);
}
