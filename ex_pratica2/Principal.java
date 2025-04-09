package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			//Instancia o EntityManagerFactory com as configurações de persistencia
			emf = Persistence.createEntityManagerFactory("aula-jpa"); 
			//Intancia o EntityManager
			em = emf.createEntityManager(); 
			
			em.getTransaction().begin();
	
			// Inserir os objetos aqui!
			
			em.getTransaction().commit();//confirmar as alterações realizadas
			
			emf.close();
			em.close();
			
			// Inserir os laços for aqui!
			
		}catch (Exception e){
			if(em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			if(em != null) {
				em.close();
			}
			if(emf != null) {
				emf.close();
			}
		}
	}			
}
