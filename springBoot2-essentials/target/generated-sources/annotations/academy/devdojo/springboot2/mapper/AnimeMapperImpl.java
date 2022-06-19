package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.domain.Anime.AnimeBuilder;
import academy.devdojo.springboot2.dto.AnimePostDTO;
import academy.devdojo.springboot2.dto.AnimePutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-19T16:31:37-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostDTO animePostDTO) {
        if ( animePostDTO == null ) {
            return null;
        }

        AnimeBuilder anime = Anime.builder();

        anime.name( animePostDTO.getName() );

        return anime.build();
    }

    @Override
    public Anime toAnime(AnimePutDTO animePutDTO) {
        if ( animePutDTO == null ) {
            return null;
        }

        AnimeBuilder anime = Anime.builder();

        anime.id( animePutDTO.getId() );
        anime.name( animePutDTO.getName() );

        return anime.build();
    }
}
