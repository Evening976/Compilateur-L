/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AExp7Exp6 extends PExp6
{
    private PExp7 _exp7_;

    public AExp7Exp6()
    {
        // Constructor
    }

    public AExp7Exp6(
        @SuppressWarnings("hiding") PExp7 _exp7_)
    {
        // Constructor
        setExp7(_exp7_);

    }

    @Override
    public Object clone()
    {
        return new AExp7Exp6(
            cloneNode(this._exp7_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExp7Exp6(this);
    }

    public PExp7 getExp7()
    {
        return this._exp7_;
    }

    public void setExp7(PExp7 node)
    {
        if(this._exp7_ != null)
        {
            this._exp7_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp7_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp7_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp7_ == child)
        {
            this._exp7_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp7_ == oldChild)
        {
            setExp7((PExp7) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
