/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ARestedecvarListedecvar1 extends PListedecvar1
{
    private TVirgule _virgule_;
    private PDecvar _decvar_;
    private PListedecvar1 _listedecvar1_;

    public ARestedecvarListedecvar1()
    {
        // Constructor
    }

    public ARestedecvarListedecvar1(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PDecvar _decvar_,
        @SuppressWarnings("hiding") PListedecvar1 _listedecvar1_)
    {
        // Constructor
        setVirgule(_virgule_);

        setDecvar(_decvar_);

        setListedecvar1(_listedecvar1_);

    }

    @Override
    public Object clone()
    {
        return new ARestedecvarListedecvar1(
            cloneNode(this._virgule_),
            cloneNode(this._decvar_),
            cloneNode(this._listedecvar1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARestedecvarListedecvar1(this);
    }

    public TVirgule getVirgule()
    {
        return this._virgule_;
    }

    public void setVirgule(TVirgule node)
    {
        if(this._virgule_ != null)
        {
            this._virgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._virgule_ = node;
    }

    public PDecvar getDecvar()
    {
        return this._decvar_;
    }

    public void setDecvar(PDecvar node)
    {
        if(this._decvar_ != null)
        {
            this._decvar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._decvar_ = node;
    }

    public PListedecvar1 getListedecvar1()
    {
        return this._listedecvar1_;
    }

    public void setListedecvar1(PListedecvar1 node)
    {
        if(this._listedecvar1_ != null)
        {
            this._listedecvar1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listedecvar1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._decvar_)
            + toString(this._listedecvar1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._virgule_ == child)
        {
            this._virgule_ = null;
            return;
        }

        if(this._decvar_ == child)
        {
            this._decvar_ = null;
            return;
        }

        if(this._listedecvar1_ == child)
        {
            this._listedecvar1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._virgule_ == oldChild)
        {
            setVirgule((TVirgule) newChild);
            return;
        }

        if(this._decvar_ == oldChild)
        {
            setDecvar((PDecvar) newChild);
            return;
        }

        if(this._listedecvar1_ == oldChild)
        {
            setListedecvar1((PListedecvar1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
