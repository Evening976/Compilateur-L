/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AAppelfonction2Exp6 extends PExp6
{
    private TId _id_;
    private TParG _parG_;
    private PListeexpressions _listeexpressions_;
    private TParD _parD_;

    public AAppelfonction2Exp6()
    {
        // Constructor
    }

    public AAppelfonction2Exp6(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TParG _parG_,
        @SuppressWarnings("hiding") PListeexpressions _listeexpressions_,
        @SuppressWarnings("hiding") TParD _parD_)
    {
        // Constructor
        setId(_id_);

        setParG(_parG_);

        setListeexpressions(_listeexpressions_);

        setParD(_parD_);

    }

    @Override
    public Object clone()
    {
        return new AAppelfonction2Exp6(
            cloneNode(this._id_),
            cloneNode(this._parG_),
            cloneNode(this._listeexpressions_),
            cloneNode(this._parD_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAppelfonction2Exp6(this);
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public TParG getParG()
    {
        return this._parG_;
    }

    public void setParG(TParG node)
    {
        if(this._parG_ != null)
        {
            this._parG_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parG_ = node;
    }

    public PListeexpressions getListeexpressions()
    {
        return this._listeexpressions_;
    }

    public void setListeexpressions(PListeexpressions node)
    {
        if(this._listeexpressions_ != null)
        {
            this._listeexpressions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeexpressions_ = node;
    }

    public TParD getParD()
    {
        return this._parD_;
    }

    public void setParD(TParD node)
    {
        if(this._parD_ != null)
        {
            this._parD_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parD_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._parG_)
            + toString(this._listeexpressions_)
            + toString(this._parD_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._parG_ == child)
        {
            this._parG_ = null;
            return;
        }

        if(this._listeexpressions_ == child)
        {
            this._listeexpressions_ = null;
            return;
        }

        if(this._parD_ == child)
        {
            this._parD_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._parG_ == oldChild)
        {
            setParG((TParG) newChild);
            return;
        }

        if(this._listeexpressions_ == oldChild)
        {
            setListeexpressions((PListeexpressions) newChild);
            return;
        }

        if(this._parD_ == oldChild)
        {
            setParD((TParD) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}