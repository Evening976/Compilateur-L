/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AEgalExp2 extends PExp2
{
    private PExp2 _exp2_;
    private TEgal _egal_;
    private PExp3 _exp3_;

    public AEgalExp2()
    {
        // Constructor
    }

    public AEgalExp2(
        @SuppressWarnings("hiding") PExp2 _exp2_,
        @SuppressWarnings("hiding") TEgal _egal_,
        @SuppressWarnings("hiding") PExp3 _exp3_)
    {
        // Constructor
        setExp2(_exp2_);

        setEgal(_egal_);

        setExp3(_exp3_);

    }

    @Override
    public Object clone()
    {
        return new AEgalExp2(
            cloneNode(this._exp2_),
            cloneNode(this._egal_),
            cloneNode(this._exp3_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEgalExp2(this);
    }

    public PExp2 getExp2()
    {
        return this._exp2_;
    }

    public void setExp2(PExp2 node)
    {
        if(this._exp2_ != null)
        {
            this._exp2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp2_ = node;
    }

    public TEgal getEgal()
    {
        return this._egal_;
    }

    public void setEgal(TEgal node)
    {
        if(this._egal_ != null)
        {
            this._egal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._egal_ = node;
    }

    public PExp3 getExp3()
    {
        return this._exp3_;
    }

    public void setExp3(PExp3 node)
    {
        if(this._exp3_ != null)
        {
            this._exp3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp3_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp2_)
            + toString(this._egal_)
            + toString(this._exp3_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp2_ == child)
        {
            this._exp2_ = null;
            return;
        }

        if(this._egal_ == child)
        {
            this._egal_ = null;
            return;
        }

        if(this._exp3_ == child)
        {
            this._exp3_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp2_ == oldChild)
        {
            setExp2((PExp2) newChild);
            return;
        }

        if(this._egal_ == oldChild)
        {
            setEgal((TEgal) newChild);
            return;
        }

        if(this._exp3_ == oldChild)
        {
            setExp3((PExp3) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}