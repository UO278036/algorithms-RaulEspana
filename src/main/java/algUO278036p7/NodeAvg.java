package algUO278036p7;

import java.util.ArrayList;
import java.util.UUID;

public class NodeAvg extends Node {

	private Imagen[] imagenes;
	private ArrayList<Integer> imagenesNodo;
	private Imagen half1_avg;
	private Imagen half2_avg;
	
	public NodeAvg(Imagen[] imagenes, ArrayList<Integer> imagenesNodo, int grupo) {
		ID = UUID.randomUUID();
		this.depth = grupo;
		this.imagenes = imagenes;
		this.imagenesNodo = new ArrayList<Integer>(imagenesNodo);
		calculateHeuristicValue();
	}
	
	
	@Override
	public void calculateHeuristicValue() {
		if (isSolution()) {
			int width, height;
			width = imagenes[0].getWidth();
			height = imagenes[0].getHeight();
			Imagen grupo1P = new Imagen(width, height);
			Imagen grupo2P = new Imagen(width, height);
			for (int i = 0; i < imagenesNodo.size(); i++) {
				if (imagenesNodo.get(i) == 1) {
					grupo1P.addSignal(this.imagenes[i]);
				}
				if (imagenesNodo.get(i) == 2) {
					grupo2P.addSignal(this.imagenes[i]);
				}
			}
			this.heuristicValue = grupo2P.zncc(grupo1P) * (-1);
			this.half1_avg = grupo1P.copy();
            this.half2_avg = grupo2P.copy();
		} else {
			this.heuristicValue = -2;
		}
	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> res = new ArrayList<Node>();
		imagenesNodo.add(0);
		
        res.add(new NodeAvg(imagenes, imagenesNodo, depth+1));
        imagenesNodo.set(depth, 1);
        res.add(new NodeAvg(imagenes, imagenesNodo, depth+1));
        imagenesNodo.set(depth, 2);
        res.add(new NodeAvg(imagenes, imagenesNodo, depth+1));
        return res;
	}

	@Override
	public boolean isSolution() {
		if (getDepth() == imagenes.length) {
			return true;
		}else {
			return false;
		}	
	}
	
	public Imagen getHalf1_avg() {
		return half1_avg;
	}
	
	public Imagen getHalf2_avg() {
		return half2_avg;
	}
	
}
