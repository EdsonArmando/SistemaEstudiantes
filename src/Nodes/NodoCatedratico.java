package Nodes;

import Models.Catedratico;

public class NodoCatedratico {
	public Catedratico catedratico;
	public NodoCatedratico siguiente;
	
	public Catedratico getCatedratico() {
		return catedratico;
	}
	public void setCatedratico(Catedratico catedratico) {
		this.catedratico = catedratico;
	}
	public NodoCatedratico(Catedratico catedratico){
		super();
		this.catedratico=catedratico;
	}
	public NodoCatedratico(){
		
	}
}
