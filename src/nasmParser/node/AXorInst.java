/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class AXorInst extends PInst
{
    private POplabel _oplabel_;
    private TXor _xor_;
    private PAr _ar_;
    private TComma _comma_;
    private PAcr _acr_;

    public AXorInst()
    {
        // Constructor
    }

    public AXorInst(
        @SuppressWarnings("hiding") POplabel _oplabel_,
        @SuppressWarnings("hiding") TXor _xor_,
        @SuppressWarnings("hiding") PAr _ar_,
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PAcr _acr_)
    {
        // Constructor
        setOplabel(_oplabel_);

        setXor(_xor_);

        setAr(_ar_);

        setComma(_comma_);

        setAcr(_acr_);

    }

    @Override
    public Object clone()
    {
        return new AXorInst(
            cloneNode(this._oplabel_),
            cloneNode(this._xor_),
            cloneNode(this._ar_),
            cloneNode(this._comma_),
            cloneNode(this._acr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAXorInst(this);
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

    public TXor getXor()
    {
        return this._xor_;
    }

    public void setXor(TXor node)
    {
        if(this._xor_ != null)
        {
            this._xor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._xor_ = node;
    }

    public PAr getAr()
    {
        return this._ar_;
    }

    public void setAr(PAr node)
    {
        if(this._ar_ != null)
        {
            this._ar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ar_ = node;
    }

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
    }

    public PAcr getAcr()
    {
        return this._acr_;
    }

    public void setAcr(PAcr node)
    {
        if(this._acr_ != null)
        {
            this._acr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._acr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._oplabel_)
            + toString(this._xor_)
            + toString(this._ar_)
            + toString(this._comma_)
            + toString(this._acr_);
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

        if(this._xor_ == child)
        {
            this._xor_ = null;
            return;
        }

        if(this._ar_ == child)
        {
            this._ar_ = null;
            return;
        }

        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._acr_ == child)
        {
            this._acr_ = null;
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

        if(this._xor_ == oldChild)
        {
            setXor((TXor) newChild);
            return;
        }

        if(this._ar_ == oldChild)
        {
            setAr((PAr) newChild);
            return;
        }

        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._acr_ == oldChild)
        {
            setAcr((PAcr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
