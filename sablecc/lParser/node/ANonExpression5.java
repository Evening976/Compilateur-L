/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ANonExpression5 extends PExpression5
{
    private TNon _non_;
    private PExpression5 _expression5_;

    public ANonExpression5()
    {
        // Constructor
    }

    public ANonExpression5(
        @SuppressWarnings("hiding") TNon _non_,
        @SuppressWarnings("hiding") PExpression5 _expression5_)
    {
        // Constructor
        setNon(_non_);

        setExpression5(_expression5_);

    }

    @Override
    public Object clone()
    {
        return new ANonExpression5(
            cloneNode(this._non_),
            cloneNode(this._expression5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANonExpression5(this);
    }

    public TNon getNon()
    {
        return this._non_;
    }

    public void setNon(TNon node)
    {
        if(this._non_ != null)
        {
            this._non_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._non_ = node;
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
            + toString(this._non_)
            + toString(this._expression5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._non_ == child)
        {
            this._non_ = null;
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
        if(this._non_ == oldChild)
        {
            setNon((TNon) newChild);
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
