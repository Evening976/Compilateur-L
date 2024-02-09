/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AExp1Exp extends PExp
{
    private PExp1 _exp1_;

    public AExp1Exp()
    {
        // Constructor
    }

    public AExp1Exp(
        @SuppressWarnings("hiding") PExp1 _exp1_)
    {
        // Constructor
        setExp1(_exp1_);

    }

    @Override
    public Object clone()
    {
        return new AExp1Exp(
            cloneNode(this._exp1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExp1Exp(this);
    }

    public PExp1 getExp1()
    {
        return this._exp1_;
    }

    public void setExp1(PExp1 node)
    {
        if(this._exp1_ != null)
        {
            this._exp1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp1_ == child)
        {
            this._exp1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp1_ == oldChild)
        {
            setExp1((PExp1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
