/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AParenthesesExp6 extends PExp6
{
    private TParG _parG_;
    private PExpression _expression_;
    private TParD _parD_;

    public AParenthesesExp6()
    {
        // Constructor
    }

    public AParenthesesExp6(
        @SuppressWarnings("hiding") TParG _parG_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") TParD _parD_)
    {
        // Constructor
        setParG(_parG_);

        setExpression(_expression_);

        setParD(_parD_);

    }

    @Override
    public Object clone()
    {
        return new AParenthesesExp6(
            cloneNode(this._parG_),
            cloneNode(this._expression_),
            cloneNode(this._parD_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParenthesesExp6(this);
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

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
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
            + toString(this._parG_)
            + toString(this._expression_)
            + toString(this._parD_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parG_ == child)
        {
            this._parG_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
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
        if(this._parG_ == oldChild)
        {
            setParG((TParG) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
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