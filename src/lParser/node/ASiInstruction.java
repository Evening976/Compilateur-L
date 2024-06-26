/* This file was generated by SableCC (http://www.sablecc.org/). */

package lParser.node;

import lParser.analysis.*;

@SuppressWarnings("nls")
public final class ASiInstruction extends PInstruction
{
    private TSi _si_;
    private PExp _exp_;
    private TAlors _alors_;
    private PBlocInstruction _blocInstruction_;

    public ASiInstruction()
    {
        // Constructor
    }

    public ASiInstruction(
        @SuppressWarnings("hiding") TSi _si_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TAlors _alors_,
        @SuppressWarnings("hiding") PBlocInstruction _blocInstruction_)
    {
        // Constructor
        setSi(_si_);

        setExp(_exp_);

        setAlors(_alors_);

        setBlocInstruction(_blocInstruction_);

    }

    @Override
    public Object clone()
    {
        return new ASiInstruction(
            cloneNode(this._si_),
            cloneNode(this._exp_),
            cloneNode(this._alors_),
            cloneNode(this._blocInstruction_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASiInstruction(this);
    }

    public TSi getSi()
    {
        return this._si_;
    }

    public void setSi(TSi node)
    {
        if(this._si_ != null)
        {
            this._si_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._si_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TAlors getAlors()
    {
        return this._alors_;
    }

    public void setAlors(TAlors node)
    {
        if(this._alors_ != null)
        {
            this._alors_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._alors_ = node;
    }

    public PBlocInstruction getBlocInstruction()
    {
        return this._blocInstruction_;
    }

    public void setBlocInstruction(PBlocInstruction node)
    {
        if(this._blocInstruction_ != null)
        {
            this._blocInstruction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._blocInstruction_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._si_)
            + toString(this._exp_)
            + toString(this._alors_)
            + toString(this._blocInstruction_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._si_ == child)
        {
            this._si_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._alors_ == child)
        {
            this._alors_ = null;
            return;
        }

        if(this._blocInstruction_ == child)
        {
            this._blocInstruction_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._si_ == oldChild)
        {
            setSi((TSi) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._alors_ == oldChild)
        {
            setAlors((TAlors) newChild);
            return;
        }

        if(this._blocInstruction_ == oldChild)
        {
            setBlocInstruction((PBlocInstruction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
