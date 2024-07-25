package java17.ex02;

import java.util.function.BiFunction;

import org.junit.Test;

import java17.data.Account;
import java17.data.Person;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {

    //  tag::buildAccount[]
    // TODO Compléter la fonction buildAccount
    // TODO la fonction possède 2 paramètres en entrée : une personne et un solde
	//BiFunction<Person, Integer, Account> buildAccount = null
	BiFunction<Person, Integer, Account> buildAccount = (person, balance) -> 
    new Account(person, balance);
    //  end::buildAccount[]

    
    
    @Test
    public void test_build_account() throws Exception {

    	// Créez une instance de Person avec les valeurs attendues
        Person person = new Person("John", "France", 80, "pass");

        // Définissez le solde pour le compte
        int balance = 500;

        // Invoquez la fonction buildAccount avec la personne et le solde
        //Account account = null
        Account account = buildAccount.apply(person, balance);

        assert account.getBalance().equals(500);
        assert account.getOwner().getFirstname().equals("John");
        assert account.getOwner().getLastname().equals("France");
        assert account.getOwner().getAge().equals(80);
        assert account.getOwner().getPassword().equals("pass");
    }


}
