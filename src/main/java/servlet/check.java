package servlet;

import dao.usDAO;

public class check {
        public boolean checkNome(String nome) {
        boolean exists = new usDAO().checkNome(nome);
        if (!exists) {
            System.out.println("Não existe");
        } else {
            System.out.println("Já existe");
        }
        return exists;
    }
}