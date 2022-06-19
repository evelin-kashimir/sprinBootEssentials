package academy.devdojo.springboot2.mapper;

//NESTA CLASSE É TUDO CONVERTIDO PARA O TIPO DA CLASSE QUE ESTÁ SENDO MAPEADA
import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.dto.AnimePostDTO;
import academy.devdojo.springboot2.dto.AnimePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostDTO animePostDTO);

    public abstract Anime toAnime(AnimePutDTO animePutDTO);
}
