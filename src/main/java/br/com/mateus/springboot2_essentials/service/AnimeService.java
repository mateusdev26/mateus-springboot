package br.com.mateus.springboot2_essentials.service;

import br.com.mateus.springboot2_essentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes ;
    static{
        animes = new ArrayList<>(List.of(new Anime(1L, "Dragon Ball Super"), new Anime(2L, "Dragon Ball Z"), new Anime(3L, "One Piece"), new Anime(4L, "Death Note"), new Anime(5L, "Naruto")));
    }
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream().filter(a -> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }
    public Anime save(Anime anime){
        anime.setId(ThreadLocalRandom.current().nextLong(3,1_000_000));
        animes.add(anime);
        return anime ;
    }

}
