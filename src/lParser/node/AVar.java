/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AVar extends PVar
{
    private TIdentif _identif_;

    public AVar()
    {
        // Constructor
    }

    public AVar(
        @SuppressWarnings("hiding") TIdentif _identif_)
    {
        // Constructor
        setIdentif(_identif_);

    }

    @Override
    public Object clone()
    {
        return new AVar(
            cloneNode(this._identif_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVar(this);
    }

    public TIdentif getIdentif()
    {
        return this._identif_;
    }

    public void setIdentif(TIdentif node)
    {
        if(this._identif_ != null)
        {
            this._identif_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identif_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identif_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
