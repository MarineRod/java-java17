package java17.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Exercice 01 - Les dates avant Java 8
 */
public class DateAndTime_01_Test {

	// Vous vous souvenez de java.util.Date (Java 1) ?
	@Test
	public void test_date() {

		// TODO modifier les paramètres du constructeur pour que le test soit passant
		 Date date = new Date(117, 2, 24, 1, 2, 3);

		assertThat(date.toString(), is("Fri Mar 24 01:02:03 CET 2017"));

		// TODO modifier le jour de la date avec une méthode set pour que le test soit
		// passant
		
		 Date date2 = new Date(117, 2, 25, 1, 2, 3);

		assertThat(date2.toString(), is("Sat Mar 25 01:02:03 CET 2017"));
	}

	// Vous vous souvenez de java.util.Calendar (Java 1.1) ?

	@Test
	public void test_calendar() throws Exception {
		Calendar calendar = Calendar.getInstance();

		  calendar.set(Calendar.YEAR, 2017);
	        calendar.set(Calendar.MONTH, Calendar.MARCH);
	        calendar.set(Calendar.DAY_OF_MONTH, 24);
	        calendar.set(Calendar.HOUR_OF_DAY, 1);
	        calendar.set(Calendar.MINUTE, 2);
	        calendar.set(Calendar.SECOND, 3);
	        calendar.set(Calendar.MILLISECOND, 0);

		assertThat(calendar.getTime().toString(), is("Fri Mar 24 01:02:03 CET 2017"));

		// calendar est mutable... :-(
		// TODO modifier l'objet calendar pour que le test soit passant
		
		 calendar.set(Calendar.DAY_OF_MONTH, 25);

		assertThat(calendar.getTime().toString(), is("Sat Mar 25 01:02:03 CET 2017"));
	}

}
