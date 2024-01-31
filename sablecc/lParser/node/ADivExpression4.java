/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ADivExpression4 extends PExpression4
{
    private PExpression4 _expression4_;
    private TDiv _div_;
    private PExpression5 _expression5_;

    public ADivExpression4()
    {
        // Constructor
    }

    public ADivExpression4(
        @SuppressWarnings("hiding") PExpression4 _expression4_,
        @SuppressWarnings("hiding") TDiv _div_,
        @SuppressWarnings("hiding") PExpression5 _expression5_)
    {
        // Constructor
        setExpression4(_expression4_);

        setDiv(_div_);

        setExpression5(_expression5_);

    }

    @Override
    public Object clone()
    {
        return new ADivExpression4(
            cloneNode(this._expression4_),
            cloneNode(this._div_),
            cloneNode(this._expression5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivExpression4(this);
    }

    public PExpression4 getExpression4()
    {
        return this._expression4_;
    }

    public void setExpression4(PExpression4 node)
    {
        if(this._expression4_ != null)
        {
            this._expression4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression4_ = node;
    }

    public TDiv getDiv()
    {
        return this._div_;
    }

    public void setDiv(TDiv node)
    {
        if(this._div_ != null)
        {
            this._div_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._div_ = node;
    }

    public PExpression5 getExpression5()
    {
        return this._expression5_;
    }

    public void setExpression5(PExpression5 node)
    {
        if(this._expression5_ != null)
        {
            this._expression5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression5_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression4_)
            + toString(this._div_)
            + toString(this._expression5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression4_ == child)
        {
            this._expression4_ = null;
            return;
        }

        if(this._div_ == child)
        {
            this._div_ = null;
            return;
        }

        if(this._expression5_ == child)
        {
            this._expression5_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression4_ == oldChild)
        {
            setExpression4((PExpression4) newChild);
            return;
        }

        if(this._div_ == oldChild)
        {
            setDiv((TDiv) newChild);
            return;
        }

        if(this._expression5_ == oldChild)
        {
            setExpression5((PExpression5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
