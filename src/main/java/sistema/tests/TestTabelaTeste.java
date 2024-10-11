package sistema.tests;

import sistema.model.TabelaTeste;
import sistema.model.dao.TabelaTesteDAO;

public class TestTabelaTeste {
    public static void main(String[] args) {
//        TabelaTeste tt = new TabelaTeste();
//        tt.setId(1);
//        tt.setDescricao("teste5");
//
//        TabelaTesteDAO dao = new TabelaTesteDAO();
//        tt = dao.save(tt);
//
//        System.out.println("Descrição = " + tt.getDescricao());
//        System.out.println("ID = " + tt.getId());

//        TabelaTesteDAO dao = new TabelaTesteDAO();
//        TabelaTeste tt = dao.findById(1);
//        System.out.println("Descrição = " + tt.getDescricao());

//        TabelaTesteDAO dao = new TabelaTesteDAO();
//        for (TabelaTeste tt : dao.findAll()) {
//            System.out.println("Descrição = " + tt.getDescricao());
//        }

    TabelaTesteDAO dao = new TabelaTesteDAO();
    dao.remove(1);


    }

}