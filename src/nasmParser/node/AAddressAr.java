/* This file was generated by SableCC (http://www.sablecc.org/). */

package nasmParser.node;

import nasmParser.analysis.*;

@SuppressWarnings("nls")
public final class AAddressAr extends PAr
{
    private PAddress _address_;

    public AAddressAr()
    {
        // Constructor
    }

    public AAddressAr(
        @SuppressWarnings("hiding") PAddress _address_)
    {
        // Constructor
        setAddress(_address_);

    }

    @Override
    public Object clone()
    {
        return new AAddressAr(
            cloneNode(this._address_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAddressAr(this);
    }

    public PAddress getAddress()
    {
        return this._address_;
    }

    public void setAddress(PAddress node)
    {
        if(this._address_ != null)
        {
            this._address_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._address_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._address_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._address_ == child)
        {
            this._address_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._address_ == oldChild)
        {
            setAddress((PAddress) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}