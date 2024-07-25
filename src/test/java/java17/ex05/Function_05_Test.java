package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // TODO compléter la fonction
    // TODO modifier le mot de passe en "secret"
	Consumer<Person> changePasswordToSecret = person -> person.setPassword("secret");

    // TODO compléter la fonction
    // TODO vérifier que l'age > 4 avec une assertion JUnit
	Consumer<Person> verifyAge = person -> {
	    if (person.getAge() <= 4) {
	        throw new AssertionError("L'âge doit être supérieur à 4. Age trouvé: " + person.getAge());
	    }
	};

    // TODO compléter la fonction
    // TODO vérifier que le mot de passe est "secret" avec une assertion JUnit
	Consumer<Person> verifyPassword = person -> {
	    if (!"secret".equals(person.getPassword())) {
	        throw new AssertionError("Le mot de passe doit être 'secret'. Mot de passe trouvé: " + person.getPassword());
	    }
	};
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret);
        // TODO remplacer la boucle for par l'invocation de la méthode forEach
        Consumer<Person> verifyAgeAndPassword = verifyAge.andThen(verifyPassword);
        
        // TODO Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
       
        personList.forEach(verifyAgeAndPassword);
    }
}
