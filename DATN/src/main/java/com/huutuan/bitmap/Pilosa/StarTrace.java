package com.huutuan.bitmap.Pilosa;

import com.pilosa.client.*;
import com.pilosa.client.orm.*;
import com.pilosa.client.exceptions.PilosaException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StarTrace {
	public void getData() {
		// We will just use the default client which assumes the server is at
		// http://localhost:10101
		PilosaClient client = PilosaClient.defaultClient();

		// Let's load the schema from the server.
		Schema schema;
		try {
			schema = client.readSchema();
		} catch (PilosaException ex) {
			// Most calls will return an error value.
			// You should handle them appropriately.
			// We will just terminate the program in this case.
			throw new RuntimeException(ex);
		}

		// We need to refer to indexes and fields before we can use them in a query.
		Index repository = schema.index("repository");
		Field stargazer = repository.field("stargazer");
		Field language = repository.field("language");

		QueryResponse response;
		QueryResult result;
		PqlQuery query;
		List<Long> repositoryIDs;

		// Which repositories did user 14 star:
		response = client.query(stargazer.row(14));
		repositoryIDs = response.getResult().getRow().getColumns();
		System.out.println("User 14 starred: " + repositoryIDs);

		// What are the top 5 languages in the sample data:
		response = client.query(language.topN(5));
		List<CountResultItem> top_languages = response.getResult().getCountItems();
		List<Long> languageIDs = new ArrayList<Long>();
		for (CountResultItem item : top_languages) {
			languageIDs.add(item.getID());
		}

		System.out.println("Top Languages: " + languageIDs);

		// Which repositories were starred by both user 14 and 19:
		query = repository.intersect(stargazer.row(14), stargazer.row(19));
		response = client.query(query);
		repositoryIDs = response.getResult().getRow().getColumns();
		System.out.println("Both user 14 and 19 starred: " + repositoryIDs);

		// Which repositories were starred by user 14 or 19:
		query = repository.union(stargazer.row(14), stargazer.row(19));
		response = client.query(query);
		repositoryIDs = response.getResult().getRow().getColumns();
		System.out.println("User 14 or 19 starred: " + repositoryIDs);

		// Which repositories were starred by user 14 or 19 and were written in language
		// 1:
		query = repository.intersect(repository.union(stargazer.row(14), stargazer.row(19)), language.row(1));
		response = client.query(query);
		repositoryIDs = response.getResult().getRow().getColumns();
		System.out.println("User 14 or 19 starred, written in language 1: " + repositoryIDs);

		// Set user 99999 as a stargazer for repository 77777:
		client.query(stargazer.set(99999, 77777));
	}
}
