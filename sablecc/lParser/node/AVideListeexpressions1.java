/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AVideListeexpressions1 extends PListeexpressions1
{

    public AVideListeexpressions1()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AVideListeexpressions1();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVideListeexpressions1(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
