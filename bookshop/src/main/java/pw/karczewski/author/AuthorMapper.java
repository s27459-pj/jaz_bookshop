package pw.karczewski.author;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import pw.karczewski.openapi.model.AuthorCreate;
import pw.karczewski.openapi.model.AuthorRetrieve;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper {
    @Mapping(target = "id", ignore = true)
    Author toEntity(AuthorCreate authorCreate);

    AuthorRetrieve toRetrieve(Author author);
}
