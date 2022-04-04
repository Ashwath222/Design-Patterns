package dp;

import java.util.ArrayList;
import java.util.List;

abstract class Creature
{
    protected Game game;
    protected int attack, defense;

    public Creature(Game game, int attack, int defense) {
        this.game = game;
        this.attack = attack;
        this.defense = defense;
    }

    public abstract int getAttack();
    public abstract int getDefense();
    public abstract void query(Object source, StatQuery sq);
}

class Goblin extends Creature
{
    public Goblin(Game game, int attack, int defense) {
        super(game, attack, defense);
    }

    public Goblin(Game game)
    {
        super(game, 1, 1);
    }

    @Override
    public int getAttack()
    {
        StatQuery sq = new StatQuery(Statistic.ATTACK);
        for (Creature creature : game.creatures) {
            creature.query(this, sq);
        }
        return sq.result;
    }

    @Override
    public int getDefense()
    {
        StatQuery sq = new StatQuery(Statistic.DEFENSE);
        for (Creature creature : game.creatures) {
            creature.query(this, sq);
        }
        return sq.result;
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if(source == this) {
            switch (sq.statistic) {
                case ATTACK:
                    sq.result += attack;
                    break;
                case DEFENSE:
                    sq.result += defense;
                    break;
            }
        }
        else if(sq.statistic == Statistic.DEFENSE) {
            sq.result++;
        }
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game, 3, 3);
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source != this && sq.statistic == Statistic.ATTACK) {
            sq.result++;
        }
        super.query(source, sq);
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class StatQuery {
    public Statistic statistic;
    public int result;

    public StatQuery(Statistic statistic) {
        this.statistic = statistic;
    }
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}
