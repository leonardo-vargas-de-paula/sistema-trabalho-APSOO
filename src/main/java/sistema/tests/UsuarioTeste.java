package sistema.tests;

import sistema.model.Usuario;
import sistema.model.dao.UsuarioDAO;

public class UsuarioTeste {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario.setId("lorem.ipsum");
        usuario.setSenha("123456");
//
//        usuario.setId("marcos.braz");
//        usuario.setSenha("2222222");

////        System.out.println("id= " + usuario.getId() + " senha= " + usuario.getSenha());
        dao.save(usuario);


    }
}
