package com.gologo13;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class SpringBootAppWithStormpathApplication {

	public static void main(String[] args) {
		configureStormpath();

		SpringApplication.run(SpringBootAppWithStormpathApplication.class, args);
	}

	private static void configureStormpath() {
		final Client client = Clients.builder().build();
		final Account account = client.instantiate(Account.class);
		final Application app = client.getResource(System.getenv("STORMPATH_APPLICATION_HREF"), Application.class);

		final Map<String, Object> queryParams = new HashMap<>();
		queryParams.put("username", "tk422");

		Iterable<Account> iterable = () -> app.getAccounts(queryParams).iterator();
		StreamSupport
				.stream(iterable.spliterator(), false)
				.findAny()
				.orElseGet(() -> {
					account
							.setGivenName("Bob")
							.setSurname("Robinson")
							.setUsername("tk422")
							.setEmail("tk422@stormpath.com")
							.setPassword("Changeme1")
							.getCustomData()
							.put("favoriteColor", "red");

					app.createAccount(account);
					return account;
				});
	}
}
