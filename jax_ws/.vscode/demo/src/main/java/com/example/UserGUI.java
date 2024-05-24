package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserGUI {

    private UserDao userDao;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField idField;

    public UserGUI() {
        this.userDao = new UserDao();
    }

    public void start() {
        JFrame frame = new JFrame("User Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new GridLayout(8, 2, 5, 5));

        JLabel nameLabel = new JLabel("Nombre:");
        nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        JButton addUserBtn = new JButton("Agregar usuario");
        JButton getAllUsersBtn = new JButton("Consultar todos los usuarios");
        JButton getUserByIdBtn = new JButton("Consultar usuario por ID");
        JButton updateUserBtn = new JButton("Actualizar usuario");
        JButton deleteUserBtn = new JButton("Eliminar usuario");
        JButton exitBtn = new JButton("Salir");

        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser(nameField.getText(), emailField.getText());
            }
        });

        getAllUsersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllUsers();
            }
        });

        getUserByIdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUserById(Integer.parseInt(idField.getText()));
            }
        });

        updateUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser(Integer.parseInt(idField.getText()), nameField.getText(), emailField.getText());
            }
        });

        deleteUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser(Integer.parseInt(idField.getText()));
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(addUserBtn);
        frame.add(getAllUsersBtn);
        frame.add(getUserByIdBtn);
        frame.add(updateUserBtn);
        frame.add(deleteUserBtn);
        frame.add(exitBtn);

        frame.setVisible(true);
    }

    private void addUser(String name, String email) {
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

    private void getUserById(int id) {
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

    private void updateUser(int id, String name, String email) {
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

    private void deleteUser(int id) {
        try {
            userDao.deleteUser(id);
            System.out.println("Usuario eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserGUI().start();
            }
        });
    }
}
