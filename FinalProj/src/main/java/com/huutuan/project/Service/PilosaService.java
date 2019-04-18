package com.huutuan.project.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.pilosa.client.PilosaClient;
import com.pilosa.client.QueryResponse;
import com.pilosa.client.exceptions.PilosaException;
import com.pilosa.client.orm.Field;
import com.pilosa.client.orm.Index;
import com.pilosa.client.orm.PqlQuery;
import com.pilosa.client.orm.Schema;

/**
 * @author uuhnaut
 *
 */
@Service
public class PilosaService {

	public Map<String, Object> getById(int id) {
		long PqlStart = new DateTime().getMillis();
		Map<String, Object> respModel = new HashMap<String, Object>();
		// Create the default client
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

		// Refer to indexes and fields before use them in a query.
		Index repository = schema.index("dbfinal");
		Field imageuserlike = repository.field("imageuserlike");
		Field imageusershare = repository.field("imageusershare");

		QueryResponse response;
		PqlQuery query;
		long totalLikes;
		long totalShares;
		// ImageUserLike index interactions
		response = client.query(imageuserlike.row(id));
		// Get Attributes
		respModel = response.getResult().getRow().getAttributes();
		// Get Total Shares
		totalLikes = response.getResult().getRow().getColumns().size();

		// ImageUserShare index interactions
		// Get Total Shares
		query = repository.count(imageusershare.row(id));
		response = client.query(query);
		totalShares = response.getResult().getCount();
		respModel.put("totalLikes", totalLikes);
		respModel.put("totalShares", totalShares);

		long PqlEnd = new DateTime().getMillis();
		long PqlRuntime = PqlEnd - PqlStart;
		respModel.put("runTime", PqlRuntime);
		return respModel;
	}

	public List<Map<String, Object>> getAll() {
		PilosaClient client = PilosaClient.defaultClient();
		List<Map<String, Object>> respModel = new ArrayList<Map<String, Object>>();
		Schema schema;
		try {
			schema = client.readSchema();
		} catch (PilosaException ex) {
			throw new RuntimeException(ex);
		}

		Index repository = schema.index("dbfinal");
		Field imageuserlike = repository.field("imageuserlike");
		Field imageusershare = repository.field("imageusershare");

		QueryResponse response;
		PqlQuery query;
		long totalLikes;
		long totalShares;
		for (int i = 1; i <= 9; i++) {
			response = client.query(imageuserlike.row(i));
			Map<String, Object> attributes = response.getResult().getRow().getAttributes();
			totalLikes = response.getResult().getRow().getColumns().size();

			query = repository.count(imageusershare.row(i));
			response = client.query(query);
			totalShares = response.getResult().getCount();
			attributes.put("id", i);
			attributes.put("totalLikes", totalLikes);
			attributes.put("totalShares", totalShares);
			respModel.add(attributes);
		}
		return respModel;
	}
}
