package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MuxGate extends Gate {
	private NandGate nandGate;
	private NandGate nandGate2;
	private NandGate nandGate3;
	private NandGate nandGate4;

	public MuxGate() {
		super(2);
		nandGate = new NandGate();
		nandGate2 = new NandGate();
		nandGate3 = new NandGate();
		nandGate4 = new NandGate();
	}

	@Override
	public boolean read() {
		return nandGate4.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if (index == 0){
			nandGate.connect(emitter, 0);
			nandGate2.connect(emitter, 0);
		}
		else{
			nandGate.connect(emitter, 1);
			nandGate3.connect(emitter, 1);
		}
	}
}

