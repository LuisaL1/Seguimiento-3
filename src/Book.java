import java.util.Scanner;

public class Book {
    public int ISBN;
    public String title;
    public String author;
    public String year;
    public String editorial;
    public int numberPages;
    public String category;
    public boolean isBorrowed;
    public String borrowerName;

    public Book() {
        this.isBorrowed = false;
    }

    public Book(int ISBN, String title, String author, String year, String editorial, int numberPages, String category) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.year = year;
        this.editorial = editorial;
        this.numberPages = numberPages;
        this.category = category;
        this.isBorrowed = false;
    }

    public void information() {
        System.out.println("Información del libro:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Título: " + title);
        System.out.println("Autor: " + author);
        System.out.println("Año: " + year);
        System.out.println("Editorial: " + editorial);
        System.out.println("Número de páginas: " + numberPages);
        System.out.println("Categoría: " + category);
        System.out.println("Estado: " + (isBorrowed ? "Prestado a " + borrowerName : "Disponible"));
    }

    public void newBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese ISBN del libro:");
        ISBN = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese título del libro:");
        title = scanner.nextLine();

        System.out.println("Ingrese autor del libro:");
        author = scanner.nextLine();

        System.out.println("Ingrese año del libro:");
        year = scanner.nextLine();

        System.out.println("Ingrese editorial del libro:");
        editorial = scanner.nextLine();

        System.out.println("Ingrese número de páginas del libro:");
        numberPages = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese categoría del libro:");
        category = scanner.nextLine();

        System.out.println("Libro registrado exitosamente");

        information();
    }

    public void borrowBook(String borrowerName) {
        if (isBorrowed) {
            System.out.println("El libro ya está prestado.");
        } else {
            this.isBorrowed = true;
            this.borrowerName = borrowerName;
            System.out.println("El libro ha sido prestado a " + borrowerName);
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            this.isBorrowed = false;
            this.borrowerName = null;
            System.out.println("El libro ha sido devuelto.");
        } else {
            System.out.println("El libro no estaba prestado.");
        }
    }

    public boolean buscarPorTitulo(String searchTerm) {
        return title.toLowerCase().contains(searchTerm.toLowerCase());
    }

    public boolean buscarPorAutor(String searchTerm) {
        return author.toLowerCase().contains(searchTerm.toLowerCase());
    }

    public boolean buscarPorISBN(int searchISBN) {
        return ISBN == searchISBN;
    }

    public boolean buscarLibro(String searchTerm) {
        return buscarPorTitulo(searchTerm) || buscarPorAutor(searchTerm);
    }

    public void mostrarInformacion() {
        System.out.println("Información del libro:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Título: " + title);
        System.out.println("Autor: " + author);
        System.out.println("Año: " + year);
        System.out.println("Editorial: " + editorial);
        System.out.println("Número de páginas: " + numberPages);
        System.out.println("Categoría: " + category);
        System.out.println("Estado: " + (isBorrowed ? "Prestado a " + borrowerName : "Disponible"));
    }
}



