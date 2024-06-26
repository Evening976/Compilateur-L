/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ATableauDeclarationVar extends PDeclarationVar
{
    private PType _type_;
    private TIdentif _identif_;
    private TCrochetGauche _crochetGauche_;
    private TNombre _nombre_;
    private TCrochetDroit _crochetDroit_;

    public ATableauDeclarationVar()
    {
        // Constructor
    }

    public ATableauDeclarationVar(
        @SuppressWarnings("hiding") PType _type_,
        @SuppressWarnings("hiding") TIdentif _identif_,
        @SuppressWarnings("hiding") TCrochetGauche _crochetGauche_,
        @SuppressWarnings("hiding") TNombre _nombre_,
        @SuppressWarnings("hiding") TCrochetDroit _crochetDroit_)
    {
        // Constructor
        setType(_type_);

        setIdentif(_identif_);

        setCrochetGauche(_crochetGauche_);

        setNombre(_nombre_);

        setCrochetDroit(_crochetDroit_);

    }

    @Override
    public Object clone()
    {
        return new ATableauDeclarationVar(
            cloneNode(this._type_),
            cloneNode(this._identif_),
            cloneNode(this._crochetGauche_),
            cloneNode(this._nombre_),
            cloneNode(this._crochetDroit_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATableauDeclarationVar(this);
    }

    public PType getType()
    {
        return this._type_;
    }

    public void setType(PType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
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

    public TCrochetGauche getCrochetGauche()
    {
        return this._crochetGauche_;
    }

    public void setCrochetGauche(TCrochetGauche node)
    {
        if(this._crochetGauche_ != null)
        {
            this._crochetGauche_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._crochetGauche_ = node;
    }

    public TNombre getNombre()
    {
        return this._nombre_;
    }

    public void setNombre(TNombre node)
    {
        if(this._nombre_ != null)
        {
            this._nombre_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nombre_ = node;
    }

    public TCrochetDroit getCrochetDroit()
    {
        return this._crochetDroit_;
    }

    public void setCrochetDroit(TCrochetDroit node)
    {
        if(this._crochetDroit_ != null)
        {
            this._crochetDroit_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._crochetDroit_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._type_)
            + toString(this._identif_)
            + toString(this._crochetGauche_)
            + toString(this._nombre_)
            + toString(this._crochetDroit_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        if(this._crochetGauche_ == child)
        {
            this._crochetGauche_ = null;
            return;
        }

        if(this._nombre_ == child)
        {
            this._nombre_ = null;
            return;
        }

        if(this._crochetDroit_ == child)
        {
            this._crochetDroit_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._type_ == oldChild)
        {
            setType((PType) newChild);
            return;
        }

        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        if(this._crochetGauche_ == oldChild)
        {
            setCrochetGauche((TCrochetGauche) newChild);
            return;
        }

        if(this._nombre_ == oldChild)
        {
            setNombre((TNombre) newChild);
            return;
        }

        if(this._crochetDroit_ == oldChild)
        {
            setCrochetDroit((TCrochetDroit) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
