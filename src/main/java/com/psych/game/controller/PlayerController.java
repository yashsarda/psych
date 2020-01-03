package com.psych.game.controller;

import com.psych.game.model.Player;
import com.psych.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev")
public class PlayerController {

    // What autowired does is, it automatically inserts the object of PlayerRepository when we create an Object of
    // PLayer Controller
    // The classes which are implemented by spring itself and whose objects we need can also be included with this
    @Autowired
    private PlayerRepository playerRepository;

    /*
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
         return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable(value = "id") Long id) throws Exception {
        return playerRepository.findById(id).orElseThrow(() -> new Exception("Something went wrong"));
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable(value = "id") Long id, @Valid @RequestBody Player player) throws Exception {
        Player p = playerRepository.findById(id).orElseThrow(() -> new Exception("Something went wrong"));
        p.setName(player.getName());
        playerRepository.save(p);
        return p;
    }

    @DeleteMapping("players/{id}")
    public ResponseEntity<Object> deletePlayer(@PathVariable(value = "id") Long id) throws Exception {
        Player p = playerRepository.findById(id).orElseThrow(() -> new Exception("Something went wrong"));
        playerRepository.delete(p);
        return ResponseEntity.ok().build();
    }
    */

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getAllPlayers(@PathVariable(value = "id") Long id) throws Exception {
        return playerRepository.findById(id).orElseThrow(() -> new Exception());
    }


}
