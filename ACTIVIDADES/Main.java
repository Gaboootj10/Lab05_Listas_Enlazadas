package ACTIVIDAD;

import java.util.*;

public class Main {
	public static void main(String []args) {
		GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
		List<Tarea> tareasCompletadas = new ArrayList<>();
		Tarea t1 = new Tarea("Lab 1 AED", 5);
		Tarea t2 = new Tarea("Lab 2 AED", 2);
		Tarea t3 = new Tarea("Lab 3 AED", 1);
		gestor.agregarTarea(t1);
		gestor.agregarTarea(t2);
		gestor.agregarTarea(t3);
		gestor.eliminarTarea(t3);  
		gestor.imprimirTareas();
		System.out.println(gestor.contieneTarea(t2));
		System.out.println(gestor.contieneTarea(t3));
		gestor.invertirTareas();
		gestor.imprimirTareas();
		tareasCompletadas.add(t1);
		gestor.eliminarTarea(t1);
		System.out.println("---------------Tareas sin hacer---------------");
		gestor.imprimirTareas();
		System.out.println("------------Tareas hechas------------------");
		for(Tarea tarea : tareasCompletadas) {
			System.out.println(tarea);
		}
	}
}
