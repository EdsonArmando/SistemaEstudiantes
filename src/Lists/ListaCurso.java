package Lists;

import Models.Curso;
import Nodes.NodoCurso;

public class ListaCurso {
	static NodoCurso primero;

	public static NodoCurso getPrimero() {
		return primero;
	}

	public static void insertarCurso(Curso curso) {
		NodoCurso nuevo = new NodoCurso(curso);
		if (primero == null) {
			nuevo.Siguiente = null;
			primero = nuevo;
		} else {
			nuevo.Siguiente = primero;
			primero = nuevo;
		}
		buscar2();
	}

	public boolean buscar(int referencia) {
		NodoCurso aux = primero;
		boolean encontrado = false;
		while (aux != null && encontrado != true) {
			if (referencia == aux.getCurso().getCodigo()) {
				encontrado = true;
			} else {
				aux = aux.getSiguiente();
			}
		}
		return encontrado;
	}

	public void eliminar(int referencia) {
		if (buscar(referencia)) {
			if (primero.getCurso().getCodigo() == referencia) {
				primero = primero.getSiguiente();
			} else {
				NodoCurso aux = primero;
				while (aux.getSiguiente().getCurso().getCodigo() != referencia) {
					aux = aux.getSiguiente();
				}
				NodoCurso siguiente = aux.getSiguiente().getSiguiente();
				aux.setSiguiente(siguiente);
			}
		}
		buscar2();
	}
	public  void modificar(int codigo2,int codigo,String nombre,String cui,int creditos, String seccion,String pre, String post){
		NodoCurso puntero = primero;
		while(puntero!=null){
			if(puntero.getCurso().getCodigo()==codigo2){
				puntero.getCurso().setCodigo(codigo);
				puntero.getCurso().setNombre(nombre);
				puntero.getCurso().setCuiCatedratico(cui);
				puntero.getCurso().setCreditos(creditos);
				puntero.getCurso().setSeccion(seccion);
				puntero.getCurso().setPre(pre);
				puntero.getCurso().setPost(post);				
			}
			puntero = puntero.Siguiente;
		}
	}
	public static void buscar2() {
		NodoCurso puntero = primero;
		while (puntero != null) {
			System.out.println("El codigo es: " + puntero.getCurso().getCodigo());
			puntero = puntero.Siguiente;
		}
	}
}
