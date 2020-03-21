package at.ooe.fr.uwb.em.services;

import at.ooe.fr.uwb.em.dtos.GameDto;

public interface IGameService {
    Iterable<GameDto> getAllGames();
}
