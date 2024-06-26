/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class AJeInst extends PInst
{
    private POplabel _oplabel_;
    private TJe _je_;
    private PLabel _label_;

    public AJeInst()
    {
        // Constructor
    }

    public AJeInst(
        @SuppressWarnings("hiding") POplabel _oplabel_,
        @SuppressWarnings("hiding") TJe _je_,
        @SuppressWarnings("hiding") PLabel _label_)
    {
        // Constructor
        setOplabel(_oplabel_);

        setJe(_je_);

        setLabel(_label_);

    }

    @Override
    public Object clone()
    {
        return new AJeInst(
            cloneNode(this._oplabel_),
            cloneNode(this._je_),
            cloneNode(this._label_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAJeInst(this);
    }

    public POplabel getOplabel()
    {
        return this._oplabel_;
    }

    public void setOplabel(POplabel node)
    {
        if(this._oplabel_ != null)
        {
            this._oplabel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._oplabel_ = node;
    }

    public TJe getJe()
    {
        return this._je_;
    }

    public void setJe(TJe node)
    {
        if(this._je_ != null)
        {
            this._je_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._je_ = node;
    }

    public PLabel getLabel()
    {
        return this._label_;
    }

    public void setLabel(PLabel node)
    {
        if(this._label_ != null)
        {
            this._label_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._label_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._oplabel_)
            + toString(this._je_)
            + toString(this._label_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._oplabel_ == child)
        {
            this._oplabel_ = null;
            return;
        }

        if(this._je_ == child)
        {
            this._je_ = null;
            return;
        }

        if(this._label_ == child)
        {
            this._label_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._oplabel_ == oldChild)
        {
            setOplabel((POplabel) newChild);
            return;
        }

        if(this._je_ == oldChild)
        {
            setJe((TJe) newChild);
            return;
        }

        if(this._label_ == oldChild)
        {
            setLabel((PLabel) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
