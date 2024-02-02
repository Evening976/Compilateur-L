/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class TCroG extends Token
{
    public TCroG()
    {
        super.setText("[");
    }

    public TCroG(int line, int pos)
    {
        super.setText("[");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCroG(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCroG(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCroG text.");
    }
}
