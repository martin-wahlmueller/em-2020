package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.dtos.GameDto;
import at.ooe.fr.uwb.em.models.Game;
import at.ooe.fr.uwb.em.repositories.IGameRepository;
import at.ooe.fr.uwb.em.services.IGameService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class GameService implements IGameService {

    @Autowired
    private IGameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<GameDto> getAllGames() {
        Iterable<Game> games = gameRepository.findAll();
        Type listType = new TypeToken<Iterable<GameDto>>() {}.getType();
        Iterable<GameDto> gamesDtoList = modelMapper.map(games, listType);
        return gamesDtoList;
    }
}
