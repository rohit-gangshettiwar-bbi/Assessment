import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Human {
    int hp;

    public Human() {
        hp = 50;
    }
}

class Hero extends Human {
    int lightAttack;

    public Hero(boolean highIQ) {
        super();
        lightAttack = 10;
        if (highIQ) {
            lightAttack += 5;
        }
    }
}

class Monster extends Human {
    int darkAttack;

    public Monster(boolean bigBody) {
        super();
        darkAttack = 10;
        if (bigBody) {
            hp += 5;
        }
    }
}

public class Fight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of heroes:");
        int h = scanner.nextInt();
        System.out.print("Enter number of monsters:");
        int m = scanner.nextInt();
        System.out.print("Enter number of High_IQ heroes:");
        int highIQLimit = scanner.nextInt();
        System.out.print("Enter number of Big Body monsters:");
        int bigBodyLimit = scanner.nextInt();

        System.out.println("\nFight Night\nHeros vs Monsters \n\nwinners are:");
        List<Hero> heroes = team(h, m, highIQLimit, bigBodyLimit);
        List<Monster> monsters = teamMonsters(m);

        String result = fight(heroes, monsters);
        System.out.println(result);
    }

    public static List<Hero> team(int nHero, int nMonster, int nHighIQ, int nBigBody) {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < nHero; i++) {
            heroes.add(i < nHighIQ ? new Hero(true) : new Hero(false));
        }
        return heroes;
    }

    public static List<Monster> teamMonsters(int nMonster) {
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < nMonster; i++) {
            monsters.add(new Monster(false));
        }
        return monsters;
    }

    public static String fight(List<Hero> heroes, List<Monster> monsters) {
        Random random = new Random();

        while (!heroes.isEmpty() && !monsters.isEmpty()) {
            for (Hero hero : heroes) {
                if (!monsters.isEmpty()) {
                    Monster target = monsters.get(random.nextInt(monsters.size()));
                    target.hp -= hero.lightAttack;
                    if (target.hp <= 0) {
                        monsters.remove(target);
                    }
                }
            }

            for (Monster monster : monsters) {
                if (!heroes.isEmpty()) {
                    Hero target = heroes.get(random.nextInt(heroes.size()));
                    target.hp -= monster.darkAttack;
                    if (target.hp <= 0) {
                        heroes.remove(target);
                    }
                }
            }
        }

        if (!heroes.isEmpty()) {
            for (Hero hero : heroes) {
                System.out.print("🦸");
            }
            return "Heroes Won";
        } else if (!monsters.isEmpty()) {
            for (Monster monster : monsters) {
                System.out.print("👹");
            }
            return "Monsters Won";
        } else {
            return "Draw";
        }
    }
}
