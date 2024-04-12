/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AModuloExp4 extends PExp4
{
    private PExp4 _exp4_;
    private TModulo _modulo_;
    private PExp5 _exp5_;

    public AModuloExp4()
    {
        // Constructor
    }

    public AModuloExp4(
        @SuppressWarnings("hiding") PExp4 _exp4_,
        @SuppressWarnings("hiding") TModulo _modulo_,
        @SuppressWarnings("hiding") PExp5 _exp5_)
    {
        // Constructor
        setExp4(_exp4_);

        setModulo(_modulo_);

        setExp5(_exp5_);

    }

    @Override
    public Object clone()
    {
        return new AModuloExp4(
            cloneNode(this._exp4_),
            cloneNode(this._modulo_),
            cloneNode(this._exp5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAModuloExp4(this);
    }

    public PExp4 getExp4()
    {
        return this._exp4_;
    }

    public void setExp4(PExp4 node)
    {
        if(this._exp4_ != null)
        {
            this._exp4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp4_ = node;
    }

    public TModulo getModulo()
    {
        return this._modulo_;
    }

    public void setModulo(TModulo node)
    {
        if(this._modulo_ != null)
        {
            this._modulo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._modulo_ = node;
    }

    public PExp5 getExp5()
    {
        return this._exp5_;
    }

    public void setExp5(PExp5 node)
    {
        if(this._exp5_ != null)
        {
            this._exp5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp5_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp4_)
            + toString(this._modulo_)
            + toString(this._exp5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp4_ == child)
        {
            this._exp4_ = null;
            return;
        }

        if(this._modulo_ == child)
        {
            this._modulo_ = null;
            return;
        }

        if(this._exp5_ == child)
        {
            this._exp5_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp4_ == oldChild)
        {
            setExp4((PExp4) newChild);
            return;
        }

        if(this._modulo_ == oldChild)
        {
            setModulo((TModulo) newChild);
            return;
        }

        if(this._exp5_ == oldChild)
        {
            setExp5((PExp5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
