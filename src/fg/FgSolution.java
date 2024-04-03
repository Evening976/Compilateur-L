package fg;

import util.graph.*;
import nasm.*;
import util.intset.*;
import java.io.*;
import java.util.*;

public class FgSolution {
	int iterNum = 0;
	public Nasm nasm;
	Fg fg;
	public Map<NasmInst, IntSet> use;
	public Map<NasmInst, IntSet> def;
	public Map<NasmInst, IntSet> in;
	public Map<NasmInst, IntSet> out;

	public FgSolution(Nasm nasm, Fg fg) {
		this.nasm = nasm;
		this.fg = fg;
		this.use = new HashMap<NasmInst, IntSet>();
		this.def = new HashMap<NasmInst, IntSet>();
		this.in = new HashMap<NasmInst, IntSet>();
		this.out = new HashMap<NasmInst, IntSet>();
	}

	public void solve(){
		boolean change = true;
		while(change){
			change = false;
			for(NasmInst nasmInst : this.nasm.sectionText){
				IntSet in = new IntSet(this.nasm.getTempCounter());
				IntSet out = new IntSet(this.nasm.getTempCounter());
				IntSet use = new IntSet(this.nasm.getTempCounter());
				IntSet def = new IntSet(this.nasm.getTempCounter());
				use = fg.use.get(nasmInst);
				def = fg.def.get(nasmInst);
				for(Node pred : fg.graph.pred(fg.inst2Node.get(nasmInst))){
					out = out.union(this.in.get(fg.node2Inst.get(pred)));
				}
				in = use.union(out.minus(def));
				if(!in.equals(this.in.get(nasmInst))){
					change = true;
					this.in.put(nasmInst, in);
				}
				if(!out.equals(this.out.get(nasmInst))){
					change = true;
					this.out.put(nasmInst, out);
				}
			}
			iterNum++;
		}

	}

	public void affiche(String baseFileName) {
		String fileName;
		PrintStream out = System.out;

		if (baseFileName != null) {
			try {
				baseFileName = baseFileName;
				fileName = baseFileName + ".fgs";
				out = new PrintStream(fileName);
			}

			catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

		out.println("iter num = " + iterNum);
		for (NasmInst nasmInst : this.nasm.sectionText) {
			out.println("use = " + this.use.get(nasmInst) + " def = " + this.def.get(nasmInst) + "\tin = "
					+ this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
		}

	}

}
