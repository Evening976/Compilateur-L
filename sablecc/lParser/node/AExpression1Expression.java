/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class AExpression1Expression extends PExpression
{
    private PExpression1 _expression1_;

    public AExpression1Expression()
    {
        // Constructor
    }

    public AExpression1Expression(
        @SuppressWarnings("hiding") PExpression1 _expression1_)
    {
        // Constructor
        setExpression1(_expression1_);

    }

    @Override
    public Object clone()
    {
        return new AExpression1Expression(
            cloneNode(this._expression1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpression1Expression(this);
    }

    public PExpression1 getExpression1()
    {
        return this._expression1_;
    }

    public void setExpression1(PExpression1 node)
    {
        if(this._expression1_ != null)
        {
            this._expression1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expression1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expression1_ == child)
        {
            this._expression1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expression1_ == oldChild)
        {
            setExpression1((PExpression1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
