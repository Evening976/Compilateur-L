/* This file was generated by SableCC (http://www.sablecc.org/). */

package c3aParser.node;

import c3aParser.analysis.*;

@SuppressWarnings("nls")
public final class TParam extends Token
{
    public TParam()
    {
        super.setText("param");
    }

    public TParam(int line, int pos)
    {
        super.setText("param");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TParam(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTParam(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TParam text.");
    }
}
