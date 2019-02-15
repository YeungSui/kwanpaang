package sport.fwansoccer.player.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerInfoController {
	@RequestMapping("/players")
	public String displayPlayers() {
		return "coming soon...";
	}
}
