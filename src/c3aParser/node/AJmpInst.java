/* This file was generated by SableCC (http://www.sablecc.org/). */

package c3aParser.node;

import c3aParser.analysis.*;

@SuppressWarnings("nls")
public final class AJmpInst extends PInst
{
    private PJmp _jmp_;

    public AJmpInst()
    {
        // Constructor
    }

    public AJmpInst(
        @SuppressWarnings("hiding") PJmp _jmp_)
    {
        // Constructor
        setJmp(_jmp_);

    }

    @Override
    public Object clone()
    {
        return new AJmpInst(
            cloneNode(this._jmp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAJmpInst(this);
    }

    public PJmp getJmp()
    {
        return this._jmp_;
    }

    public void setJmp(PJmp node)
    {
        if(this._jmp_ != null)
        {
            this._jmp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._jmp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._jmp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._jmp_ == child)
        {
            this._jmp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._jmp_ == oldChild)
        {
            setJmp((PJmp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}