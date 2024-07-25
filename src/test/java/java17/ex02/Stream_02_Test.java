package java17.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Test;

import java17.data.Data;
import java17.data.domain.Customer;
import java17.data.domain.Order;
import java17.data.domain.Pizza;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

	@Test
	public void test_map() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Trouver la liste des clients associés aux commandes
		//List<Customer> result = null;
		List<Customer> result = orders.stream().map(Order::getCustomer).toList(); // Mappe chaque commande à son client
                // Collecte les clients dans une liste
		

		assertThat(result, hasSize(8));
	}

	@Test
	public void test_map_count() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Compter le nombre de clients associés aux commandes
		//long result = 0;
		long result = orders.stream().map(Order::getCustomer).count();

		assertThat(result, is(8L));
	}

	@Test
	public void test_map_distinct() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Trouver la liste des différents clients associés aux commandes (sans doublon)
		//List<Customer> result = null;
		List<Customer> result = orders.stream().map(Order::getCustomer).distinct().toList(); // Mappe chaque commande à son client
               
		

		assertThat(result, hasSize(2));
	}

	@Test
	public void test_map_distinct_count() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Compter le nombre des différents clients associés aux commandes
		//long result = 0L;
		long result = orders.stream().map(Order::getCustomer).distinct().count();

		assertThat(result, is(2L));
	}

	@Test
	public void test_mapToDouble_sum() throws Exception {

		List<Order> orders = new Data().getOrders();

		/*
		 * TODO Calculer le chiffre d'affaires total de la pizzeria (somme des prix des
		 * commandes)
		 */
		//double result = 0.0;
		double result =  orders.stream()
                .mapToDouble(Order::getPrice).sum();

		assertThat(result, is(10900.0));
	}

	@Test
	public void test_mapToDouble_avg() throws Exception {

		List<Order> orders = new Data().getOrders();

		/*
		 * TODO Calculer le prix moyen des commandes de la pizzeria
		 */
		//OptionalDouble result = null;
		 OptionalDouble result = orders.stream()
                 .mapToDouble(order -> order.getPizzas().stream()
                                             .mapToDouble(Pizza::getPrice) // Mappe chaque pizza à son prix
                                             .sum()) // Calcule la somme des prix des pizzas pour chaque commande
                 .average(); // Calcule la moyenne des prix totaux des commandes

		assertThat(result.isPresent(), is(true));
		assertThat(result.getAsDouble(), is(1362.5));
	}
}
