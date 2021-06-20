package br.univali.eng.karoline;

import br.univali.eng.karoline.model.game.Player;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player player = new Player("teste",
                "as",
                100,
                0,
                1,
                12);
        System.out.println(player.getPosition());
    }
}
