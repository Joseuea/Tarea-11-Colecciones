package actividad;

import java.util.*;

public class BuggyActividad {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Corrección: el índice válido máximo es 2, no 3
        System.out.println("Elemento en posición 2: " + nombres.get(2));

        // Corrección: comparación de cadenas con equals
        String buscado = new String("Ana");
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "123");
        telefonos.put("Luis", "456");
        // No sobrescribe si ya existe
        if (!telefonos.containsKey("Ana")) {
            telefonos.put("Ana", "789");
        } else {
            System.out.println("Advertencia: clave 'Ana' ya existe, no se sobrescribe.");
        }

        // Validación correcta antes de obtener valor
        if (telefonos.containsKey("Bea")) {
            System.out.println("Teléfono de Bea: " + telefonos.get("Bea"));
        } else {
            System.out.println("Bea no encontrada en la agenda.");
        }

        // SET de números
        Set<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(2); // no se duplica
        System.out.println("Tamaño del Set: " + numeros.size());

        // CLASE Alumno con equals y hashCode
        Set<Alumno> alumnos = new HashSet<>();
        alumnos.add(new Alumno(1, "Ana"));
        alumnos.add(new Alumno(2, "Luis"));
        alumnos.add(new Alumno(1, "Ana")); // no se repite porque equals/hashCode están implementados
        System.out.println(alumnos);
    }
}

class Alumno {
    int id;
    String nombre;

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre='" + nombre + ''' + '}';
    }
}
