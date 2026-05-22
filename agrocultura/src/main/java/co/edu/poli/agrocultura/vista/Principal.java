package co.edu.poli.agrocultura.vista;

import co.edu.poli.agrocultura.modelo.*;
import co.edu.poli.agrocultura.servicios.Implementacionoperacioncrud;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static Implementacionoperacioncrud servicio = new Implementacionoperacioncrud();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("\n========== MENU PRINCIPAL ==========");
                System.out.println("1. Crear articulo");
                System.out.println("2. Leer articulo por indice");
                System.out.println("3. Leer todos los articulos");
                System.out.println("4. Modificar articulo");
                System.out.println("5. Eliminar articulo");
                System.out.println("6. Serializar");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opcion: ");

                String entrada = sc.nextLine().trim();

                switch (entrada) {
                    case "1": menuCrear();    break;
                    case "2": menuLeer();     break;
                    case "3": mostrarTodo();  break;
                    case "4": menuModificar();break;
                    case "5": menuEliminar(); break;
                    case "6": serializar();   break;
                    case "0": salir = true; System.out.println("Hasta luego."); break;
                    default:
                        System.out.println(">>> Opcion incorrecta. Por favor ingrese una opcion valida (0-6).");
                }
            } catch (Exception e) {
                System.out.println(">>> Error inesperado: " + e.getMessage() + ". Volviendo al menu principal.");
            }
        }
    }

    // ─── CREAR ────────────────────────────────────────────────────────────────
    static void menuCrear() {
        boolean volver = false;
        while (!volver) {
            try {
                System.out.println("\n--- CREAR ARTICULO ---");
                System.out.println("1. Semilla");
                System.out.println("2. Composta");
                System.out.println("3. Nutriente");
                System.out.println("4. Control de Plaga");
                System.out.println("0. Volver");
                System.out.print("Tipo de articulo: ");
                String op = sc.nextLine().trim();

                switch (op) {
                    case "1": crearSemilla();      volver = true; break;
                    case "2": crearComposta();     volver = true; break;
                    case "3": crearNutriente();    volver = true; break;
                    case "4": crearControlPlaga(); volver = true; break;
                    case "0": volver = true; break;
                    default:
                        System.out.println(">>> Opcion incorrecta. Ingrese una opcion valida (0-4).");
                }
            } catch (Exception e) {
                System.out.println(">>> Error al crear articulo: " + e.getMessage());
            }
        }
    }

    static void crearSemilla() {
        try {
            System.out.print("Codigo: ");       int cod  = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Descripcion: ");  String desc = sc.nextLine().trim();
            System.out.print("Stock: ");        double stock = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Fecha registro (yyyy-mm-dd): "); String fecha = sc.nextLine().trim();
            System.out.print("Tipo de semilla: "); String tipo = sc.nextLine().trim();
            Semilla s = new Semilla(cod, desc, stock, fecha, tipo);
            System.out.println(servicio.crear(s));
        } catch (NumberFormatException e) {
            System.out.println(">>> Dato numerico invalido: " + e.getMessage() + ". Intente de nuevo.");
        }
    }

    static void crearComposta() {
        try {
            System.out.print("Codigo: ");       int cod  = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Descripcion: ");  String desc = sc.nextLine().trim();
            System.out.print("Stock: ");        double stock = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Fecha registro (yyyy-mm-dd): "); String fecha = sc.nextLine().trim();
            System.out.print("Fuente: ");       String fuente = sc.nextLine().trim();
            System.out.print("Tiempo descomposicion (dias): "); int tiempo = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Tipo unidad: ");  String unidad = sc.nextLine().trim();
            Composta c = new Composta(cod, desc, stock, fecha, fuente, tiempo, unidad);
            System.out.println(servicio.crear(c));
        } catch (NumberFormatException e) {
            System.out.println(">>> Dato numerico invalido: " + e.getMessage() + ". Intente de nuevo.");
        }
    }

    static void crearNutriente() {
        try {
            System.out.print("Codigo: ");       int cod  = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Descripcion: ");  String desc = sc.nextLine().trim();
            System.out.print("Stock: ");        double stock = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Fecha registro (yyyy-mm-dd): "); String fecha = sc.nextLine().trim();
            System.out.print("Composicion: ");  String comp = sc.nextLine().trim();
            System.out.print("Tipo unidad: ");  String unidad = sc.nextLine().trim();
            Nutriente n = new Nutriente(cod, desc, stock, fecha, comp, unidad);
            System.out.println(servicio.crear(n));
        } catch (NumberFormatException e) {
            System.out.println(">>> Dato numerico invalido: " + e.getMessage() + ". Intente de nuevo.");
        }
    }

    static void crearControlPlaga() {
        try {
            System.out.print("Codigo: ");        int cod  = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Descripcion: ");   String desc = sc.nextLine().trim();
            System.out.print("Stock: ");         double stock = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Fecha registro (yyyy-mm-dd): "); String fecha = sc.nextLine().trim();
            System.out.print("Plaga objetivo: "); String plaga = sc.nextLine().trim();
            System.out.print("Nivel toxicidad: "); String tox  = sc.nextLine().trim();
            System.out.print("Tipo unidad: ");    String unidad = sc.nextLine().trim();
            Controlplaga cp = new Controlplaga(cod, desc, stock, fecha, plaga, tox, unidad);
            System.out.println(servicio.crear(cp));
        } catch (NumberFormatException e) {
            System.out.println(">>> Dato numerico invalido: " + e.getMessage() + ". Intente de nuevo.");
        }
    }

    // ─── LEER ────────────────────────────────────────────────────────────────
    static void menuLeer() {
        boolean volver = false;
        while (!volver) {
            try {
                System.out.print("\nIndice a leer (o 'salir'): ");
                String op = sc.nextLine().trim();
                if (op.equalsIgnoreCase("salir")) { volver = true; break; }
                int indice = Integer.parseInt(op);
                Articulo a = servicio.leer(indice);
                if (a != null) System.out.println(a.mostrarInfo());
                else           System.out.println("No hay articulo en el indice " + indice + ".");
                volver = true;
            } catch (NumberFormatException e) {
                System.out.println(">>> Opcion incorrecta. Ingrese un numero de indice valido o 'salir'.");
            } catch (Exception e) {
                System.out.println(">>> Error: " + e.getMessage());
                volver = true;
            }
        }
    }

    // ─── LEER TODO ───────────────────────────────────────────────────────────
    static void mostrarTodo() {
        try {
            Articulo[] todos = servicio.leertodo();
            boolean hayAlguno = false;
            for (int i = 0; i < todos.length; i++) {
                if (todos[i] != null) {
                    System.out.println("[" + i + "] " + todos[i].mostrarInfo());
                    hayAlguno = true;
                }
            }
            if (!hayAlguno) System.out.println("No hay articulos registrados.");
        } catch (Exception e) {
            System.out.println(">>> Error al leer articulos: " + e.getMessage());
        }
    }

    // ─── MODIFICAR ───────────────────────────────────────────────────────────
    static void menuModificar() {
        boolean volver = false;
        while (!volver) {
            try {
                System.out.print("\nIndice a modificar (o 'salir'): ");
                String op = sc.nextLine().trim();
                if (op.equalsIgnoreCase("salir")) { volver = true; break; }
                int indice = Integer.parseInt(op);

                boolean tipoValido = false;
                while (!tipoValido) {
                    System.out.println("Tipo de articulo nuevo:");
                    System.out.println("1. Semilla  2. Composta  3. Nutriente  4. Control de Plaga");
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine().trim();
                    switch (tipo) {
                        case "1": crearYModificar(indice, "semilla");      tipoValido = true; break;
                        case "2": crearYModificar(indice, "composta");     tipoValido = true; break;
                        case "3": crearYModificar(indice, "nutriente");    tipoValido = true; break;
                        case "4": crearYModificar(indice, "controlplaga"); tipoValido = true; break;
                        default:
                            System.out.println(">>> Opcion incorrecta. Ingrese una opcion valida (1-4).");
                    }
                }
                volver = true;
            } catch (NumberFormatException e) {
                System.out.println(">>> Opcion incorrecta. Ingrese un numero de indice valido o 'salir'.");
            } catch (Exception e) {
                System.out.println(">>> Error: " + e.getMessage());
                volver = true;
            }
        }
    }

    static void crearYModificar(int indice, String tipo) {
        try {
            Articulo nuevo = null;
            System.out.print("Codigo: ");      int cod   = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Descripcion: "); String desc = sc.nextLine().trim();
            System.out.print("Stock: ");       double stock = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Fecha (yyyy-mm-dd): "); String fecha = sc.nextLine().trim();

            switch (tipo) {
                case "semilla":
                    System.out.print("Tipo semilla: "); String ts = sc.nextLine().trim();
                    nuevo = new Semilla(cod, desc, stock, fecha, ts);
                    break;
                case "composta":
                    System.out.print("Fuente: ");  String fu = sc.nextLine().trim();
                    System.out.print("Tiempo descomposicion: "); int td = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Tipo unidad: "); String tu = sc.nextLine().trim();
                    nuevo = new Composta(cod, desc, stock, fecha, fu, td, tu);
                    break;
                case "nutriente":
                    System.out.print("Composicion: "); String co = sc.nextLine().trim();
                    System.out.print("Tipo unidad: ");  String un = sc.nextLine().trim();
                    nuevo = new Nutriente(cod, desc, stock, fecha, co, un);
                    break;
                case "controlplaga":
                    System.out.print("Plaga objetivo: ");  String pl = sc.nextLine().trim();
                    System.out.print("Nivel toxicidad: "); String to = sc.nextLine().trim();
                    System.out.print("Tipo unidad: ");     String tu2 = sc.nextLine().trim();
                    nuevo = new Controlplaga(cod, desc, stock, fecha, pl, to, tu2);
                    break;
            }
            System.out.println(servicio.modificar(indice, nuevo));
        } catch (NumberFormatException e) {
            System.out.println(">>> Dato numerico invalido: " + e.getMessage() + ". Intente de nuevo.");
        }
    }

    // ─── ELIMINAR ────────────────────────────────────────────────────────────
    static void menuEliminar() {
        boolean volver = false;
        while (!volver) {
            try {
                System.out.print("\nIndice a eliminar (o 'salir'): ");
                String op = sc.nextLine().trim();
                if (op.equalsIgnoreCase("salir")) { volver = true; break; }
                int indice = Integer.parseInt(op);
                System.out.println(servicio.eliminar(indice));
                volver = true;
            } catch (NumberFormatException e) {
                System.out.println(">>> Opcion incorrecta. Ingrese un numero de indice valido o 'salir'.");
            } catch (Exception e) {
                System.out.println(">>> Error: " + e.getMessage());
                volver = true;
            }
        }
    }

    // ─── SERIALIZAR ──────────────────────────────────────────────────────────
    static void serializar() {
        try {
            System.out.println("\n--- SERIALIZAR ---");
            System.out.println(servicio.serializar());
        } catch (Exception e) {
            System.out.println(">>> Error al serializar: " + e.getMessage());
        }
    }
}