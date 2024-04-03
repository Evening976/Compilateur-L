package fg;

import nasm.*;
import util.graph.*;
import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor<Void> {
    public Nasm nasm;
    public Graph graph;
    Map<NasmInst, Node> inst2Node;
    Map<Node, NasmInst> node2Inst;
    Map<String, NasmInst> label2Inst;
    int nIter;

    public Fg(Nasm nasm) {
        this.nasm = nasm;
        this.inst2Node = new HashMap<NasmInst, Node>();
        this.node2Inst = new HashMap<Node, NasmInst>();
        this.label2Inst = new HashMap<String, NasmInst>();
        this.graph = new Graph();

        for (NasmInst nasmInst : nasm.sectionText) {
            // System.out.println("<" + nasmInst.getClass().getSimpleName() + ">");
            if (nasmInst.label != null)
                this.label2Inst.put(((NasmLabel) nasmInst.label).val, nasmInst);
            Node n = this.graph.newNode();
            this.inst2Node.put(nasmInst, n);
            this.node2Inst.put(n, nasmInst);
        }
        int instNb = nasm.sectionText.size();
        for (int i = 0; i < instNb; i++) {
            nIter = i;
            NasmInst nasmInst = nasm.sectionText.get(i);
            nasmInst.accept(this);

        }
    }

    public void affiche(String baseFileName) {
        String fileName;
        PrintStream out = System.out;

        if (baseFileName != null) {
            try {
                baseFileName = baseFileName;
                fileName = baseFileName + ".fg";
                out = new PrintStream(fileName);
            }

            catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        for (NasmInst nasmInst : nasm.sectionText) {
            Node n = this.inst2Node.get(nasmInst);
            out.print(n + " : ( ");
            for (NodeList q = n.succ(); q != null; q = q.tail) {
                out.print(q.head.toString());
                out.print(" ");
            }
            out.println(")\t" + nasmInst);
        }

    }

    public Void visit(NasmAdd inst) {
        Node n = this.inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmCall inst) {
        Node n = inst2Node.get(inst);
        String label = inst.address.toString();

        if (label.equals("iprintLF"))
            return null;
        graph.addEdge(n, inst2Node.get(label2Inst.get(label)));
        return null;
    }

    public Void visit(NasmDiv inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmJe inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmJle inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmJne inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmMul inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmOr inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmCmp inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmInst inst) {
        return null;
    }

    public Void visit(NasmJge inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmJl inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmNot inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmPop inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmRet inst) {
        return null;
    }

    public Void visit(NasmXor inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmAnd inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmJg inst) {
        Node n = inst2Node.get(inst);
        graph.addEdge(n, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmJmp inst) {
        Node n = inst2Node.get(inst);
        NasmInst dest = label2Inst.get(inst.address.toString());
        graph.addEdge(n, inst2Node.get(dest));
        return null;
    }

    public Void visit(NasmMov inst) {
        Node node = inst2Node.get(inst);
        graph.addEdge(node, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmPush inst) {
        Node node = inst2Node.get(inst);
        graph.addEdge(node, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmSub inst) {
        Node node = inst2Node.get(inst);
        graph.addEdge(node, inst2Node.get(nasm.sectionText.get(nIter + 1)));
        return null;
    }

    public Void visit(NasmEmpty inst) {
        return null;
    }

    public Void visit(NasmInt inst) {
        return null;
    }

    public Void visit(NasmAddress operand) {
        return null;
    }

    public Void visit(NasmConstant operand) {
        return null;
    }

    public Void visit(NasmLabel operand) {
        return null;
    }

    public Void visit(NasmRegister operand) {
        return null;
    }

    public Void visit(NasmResb pseudoInst) {
        return null;
    }

    public Void visit(NasmResw pseudoInst) {
        return null;
    }

    public Void visit(NasmResd pseudoInst) {
        return null;
    }

    public Void visit(NasmResq pseudoInst) {
        return null;
    }

    public Void visit(NasmRest pseudoInst) {
        return null;
    }

    public Void visit(NasmExpPlus exp) {
        return null;
    }

    public Void visit(NasmExpMinus exp) {
        return null;
    }

    public Void visit(NasmExpTimes exp) {
        return null;
    }

    public Void visit(NasmExp exp) {
        return null;
    }
}
