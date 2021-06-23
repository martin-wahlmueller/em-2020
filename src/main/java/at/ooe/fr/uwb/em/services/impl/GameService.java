package at.ooe.fr.uwb.em.services.impl;

import at.ooe.fr.uwb.em.dtos.GameDto;
import at.ooe.fr.uwb.em.models.Game;
import at.ooe.fr.uwb.em.repositories.IGameRepository;
import at.ooe.fr.uwb.em.services.IGameService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class GameService implements IGameService {

    Logger logger = LoggerFactory.getLogger(GameService.class);

    private final IGameRepository gameRepository;

    private final ModelMapper modelMapper;

    public GameService(IGameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<GameDto> getAllGames() {
        Iterable<Game> games = gameRepository.findAll();
        Type listType = new TypeToken<Iterable<GameDto>>() {}.getType();
        return modelMapper.map(games, listType);
    }
}
