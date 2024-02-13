import java.util.ArrayList;
import java.util.Scanner;

public class MainLibro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Lista para almacenar los libros
        ArrayList<Book> libros = new ArrayList<>();

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Buscar un libro");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Consultar libros prestados por usuario");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarLibro(libros);
                    break;
                case 2:
                    buscarLibro(libros);
                    break;
                case 3:
                    prestarLibro(libros);
                    break;
                case 4:
                    devolverLibro(libros);
                    break;
                case 5:
                    consultarLibrosPrestadosPorUsuario(libros);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 6);
    }

    public static void registrarLibro(ArrayList<Book> libros) {
        Book book = new Book();
        book.newBook();
        libros.add(book);
    }

    public static void buscarLibro(ArrayList<Book> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el término de búsqueda (título o autor):");
        String searchTerm = scanner.nextLine();

        // Buscar libros que coincidan con el término de búsqueda
        boolean encontrado = false;
        for (Book libro : libros) {
            if (libro.buscarLibro(searchTerm)) {
                encontrado = true;
                libro.mostrarInformacion();
                System.out.println();
            }
        }

        // Mostrar un mensaje si no se encuentra ningún libro
        if (!encontrado) {
            System.out.println("No se encontraron libros con ese término de búsqueda.");
        }
    }

    public static void prestarLibro(ArrayList<Book> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ISBN del libro que desea prestar:");
        int ISBN = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar el libro por ISBN
        boolean encontrado = false;
        for (Book libro : libros) {
            if (libro.ISBN == ISBN) {
                encontrado = true;
                if (!libro.isBorrowed) {
                    System.out.println("Ingrese el nombre del prestamista:");
                    String nombrePrestamista = scanner.nextLine();
                    libro.borrowBook(nombrePrestamista);
                } else {
                    System.out.println("El libro ya está prestado.");
                }
                break;
            }
        }

        // Mostrar un mensaje si no se encuentra el libro
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    public static void devolverLibro(ArrayList<Book> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ISBN del libro que desea devolver:");
        int ISBN = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar el libro por ISBN
        boolean encontrado = false;
        for (Book libro : libros) {
            if (libro.ISBN == ISBN) {
                encontrado = true;
                if (libro.isBorrowed) {
                    libro.returnBook();
                } else {
                    System.out.println("El libro no está prestado.");
                }
                break;
            }
        }

        // Mostrar un mensaje si no se encuentra el libro
        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    public static void consultarLibrosPrestadosPorUsuario(ArrayList<Book> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario:");
        String nombreUsuario = scanner.nextLine();

        // Buscar libros prestados al usuario
        boolean encontrado = false;
        for (Book libro : libros) {
            if (libro.isBorrowed && libro.borrowerName.equals(nombreUsuario)) {
                encontrado = true;
                libro.mostrarInformacion();
                System.out.println();
            }
        }

        // Mostrar un mensaje si no se encuentran libros prestados al usuario
        if (!encontrado) {
            System.out.println("No se encontraron libros prestados al usuario " + nombreUsuario);
        }
    }
}






