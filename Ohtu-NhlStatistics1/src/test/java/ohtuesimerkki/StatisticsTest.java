package ohtuesimerkki;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Riku
 */
public class StatisticsTest {

    Player a = new Player("Semenko", "EDM", 4, 12);
    Player b = new Player("Lemieux", "PIT", 45, 54);
    Player c = new Player("Kurri", "EDM", 37, 53);
    Player d = new Player("Yzerman", "DET", 42, 56);
    Player e = new Player("Gretzky", "EDM", 35, 89);

    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(a);
            players.add(b);
            players.add(c);
            players.add(d);
            players.add(e);

            return players;
        }
    };

    Statistics stats = new Statistics(readerStub);

    @Test
    public void testSearch() {
        Assert.assertEquals(stats.search("Semenko"), a);
        Assert.assertEquals(stats.search("Gretzky"), e);
        Assert.assertEquals(stats.search("Poika"), null);
    }
     
    @Test
    public void testTeam() {
        boolean aa = false;
        boolean cc = false;
        boolean ee = false;
        List<Player> l = stats.team("EDM");
        for (Player p : l) {
            if (p == a) {
                aa = true;
            } else if (p == c) {
                cc = true;
            } else if (p == e) {
                ee = true;
            } else {
                Assert.assertEquals(p == a || p == c || p == e, false);
            }
        }
        Assert.assertEquals(aa && cc && ee, true);
    }

    @Test
    public void testTopScorers() {
        List<Player> l = stats.topScorers(3);
        boolean ee = false;
        boolean cc = false;
        boolean dd = false;
        int i = 0;
        for (Player p : l) {
            switch (i) {
                case 0: {
                    Assert.assertEquals(e, p);
                    ee = true;
                    break;
                }
                case 1: {
                    Assert.assertEquals(b, p);
                    dd = true;
                    break;
                }
                case 2: {
                    Assert.assertEquals(d, p);
                    cc = true;
                    break;
                }
            }

            i++;
        }
        Assert.assertEquals(ee && cc && dd, true);
    }

}
