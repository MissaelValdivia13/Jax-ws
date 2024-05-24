package com.example;

import java.util.Scanner;
import java.util.List;


public class UserCLI {

    private UserDao userDao;

    public UserCLI() {
        this.userDao = new UserDao();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Consultar todos los usuarios");
            System.out.println("3. Consultar usuario por ID");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    getAllUsers();
                    break;
                case 3:
                    getUserById(scanner);
                    break;
                case 4:
                    updateUser(scanner);
                    break;
                case 5:
                    deleteUser(scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private void addUser(Scanner scanner) {
        System.out.print("Nombre del usuario: ");
        String name = scanner.nextLine();
        System.out.print("Email del usuario: ");
        String email = scanner.nextLine();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        try {
            userDao.createUser(user);
            System.out.println("Usuario agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el usuario: " + e.getMessage());
        }
    }

    private void getAllUsers() {
        try {
            List<User> users = userDao.getAllUsers();
            System.out.println("Todos los usuarios:");
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }
    }

    private void getUserById(Scanner scanner) {
        System.out.print("ID del usuario: ");
        int id = scanner.nextInt();
        try {
            User user = userDao.getUserById(id);
            if (user != null) {
                System.out.println("Usuario encontrado:");
                System.out.println(user);
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
    }

    private void updateUser(Scanner scanner) {
        System.out.print("ID del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Nuevo nombre del usuario: ");
        String name = scanner.nextLine();
        System.out.print("Nuevo email del usuario: ");
        String email = scanner.nextLine();
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        try {
            userDao.updateUser(user);
            System.out.println("Usuario actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        try {
            userDao.deleteUser(id);
            System.out.println("Usuario eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
}
