package dp;

import java.util.ArrayList;
import java.util.List;

class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }
}

class Memento
{
    public List<Token> tokens = new ArrayList<>();

}

class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        Token token = new Token(value);
        tokens.add(token);
        Memento m = new Memento();
        m.tokens = new ArrayList<>(tokens);
        return m;
    }

    public Memento addToken(Token token)
    {
        return addToken(token.value);
    }

    public void revert(Memento m)
    {
        tokens = m.tokens;
    }
}

