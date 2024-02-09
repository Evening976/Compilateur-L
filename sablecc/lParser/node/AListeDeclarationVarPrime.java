/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AListeDeclarationVarPrime extends PListeDeclarationVarPrime
{
    private TVirgule _virgule_;
    private PDeclarationVar _declarationVar_;
    private PListeDeclarationVarPrime _listeDeclarationVarPrime_;

    public AListeDeclarationVarPrime()
    {
        // Constructor
    }

    public AListeDeclarationVarPrime(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PDeclarationVar _declarationVar_,
        @SuppressWarnings("hiding") PListeDeclarationVarPrime _listeDeclarationVarPrime_)
    {
        // Constructor
        setVirgule(_virgule_);

        setDeclarationVar(_declarationVar_);

        setListeDeclarationVarPrime(_listeDeclarationVarPrime_);

    }

    @Override
    public Object clone()
    {
        return new AListeDeclarationVarPrime(
            cloneNode(this._virgule_),
            cloneNode(this._declarationVar_),
            cloneNode(this._listeDeclarationVarPrime_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListeDeclarationVarPrime(this);
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

    public PDeclarationVar getDeclarationVar()
    {
        return this._declarationVar_;
    }

    public void setDeclarationVar(PDeclarationVar node)
    {
        if(this._declarationVar_ != null)
        {
            this._declarationVar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._declarationVar_ = node;
    }

    public PListeDeclarationVarPrime getListeDeclarationVarPrime()
    {
        return this._listeDeclarationVarPrime_;
    }

    public void setListeDeclarationVarPrime(PListeDeclarationVarPrime node)
    {
        if(this._listeDeclarationVarPrime_ != null)
        {
            this._listeDeclarationVarPrime_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeDeclarationVarPrime_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._declarationVar_)
            + toString(this._listeDeclarationVarPrime_);
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

        if(this._declarationVar_ == child)
        {
            this._declarationVar_ = null;
            return;
        }

        if(this._listeDeclarationVarPrime_ == child)
        {
            this._listeDeclarationVarPrime_ = null;
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

        if(this._declarationVar_ == oldChild)
        {
            setDeclarationVar((PDeclarationVar) newChild);
            return;
        }

        if(this._listeDeclarationVarPrime_ == oldChild)
        {
            setListeDeclarationVarPrime((PListeDeclarationVarPrime) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}