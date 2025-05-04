package ACTIVIDAD;

import java.util.*;

class GestorDeTareas<T> {
    private Node<T> head;

    public GestorDeTareas() {
        this.head = null;
    }

    public void agregarTarea(T tarea) {
        Node<T> newNode = new Node<>(tarea);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (head == null){ 
        	return false;
        }
        
        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }
        
        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(tarea)) {
            temp = temp.next;
        }
        
        if (temp.next != null) {
            temp.next = temp.next.next;
            return true;
        }
        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(tarea)){ 
            	return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int contarTareas() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public T obtenerTareaMasPrioritaria() {
        if (head == null) {
        	return null;
        }
        Node<T> temp = head;
        T tareaMasPrioritaria = head.data;
        while (temp != null) {
            if (temp.data instanceof Tarea && ((Tarea)temp.data).getPrioridad() > ((Tarea)tareaMasPrioritaria).getPrioridad()) {
                tareaMasPrioritaria = temp.data;
            }
            temp = temp.next;
        }
        return tareaMasPrioritaria;
    }

    public void invertirTareas() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}
