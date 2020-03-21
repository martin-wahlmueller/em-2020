package at.ooe.fr.uwb.em.controllers;

import at.ooe.fr.uwb.em.dtos.GameDto;
import at.ooe.fr.uwb.em.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Autowired
    private IGameService gameService;

    @GetMapping("/game")
    public String games(Model model) {
        Iterable<GameDto> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "games";
    }
}
