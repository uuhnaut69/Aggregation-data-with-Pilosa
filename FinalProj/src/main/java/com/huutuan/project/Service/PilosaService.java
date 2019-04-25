package com.huutuan.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huutuan.project.Entity.BenchMarkAllRespModel;
import com.huutuan.project.Entity.BenchMarkByIdRespModel;
import com.huutuan.project.Entity.ImageEntry;
import com.huutuan.project.Entity.ImageInfo;
import com.huutuan.project.Repository.ImageRepository;
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

	@Autowired
	private ImageRepository imageRepository;

	public BenchMarkByIdRespModel getById(int id) {
		long pqlStart = new DateTime().getMillis();
		BenchMarkByIdRespModel respModel = new BenchMarkByIdRespModel();
		ImageEntry imageEntry = imageRepository.findById(id);
		ImageInfo imageInfo = new ImageInfo();
		imageInfo.setImage_id(imageEntry.getId());
		imageInfo.setTitle(imageEntry.getTitle());
		imageInfo.setDescription(imageEntry.getDescription());
		imageInfo.setUrl(imageEntry.getUrl());

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
		// Get Total Likes
		query = repository.count(imageuserlike.row(id));
		response = client.query(query);
		totalLikes = response.getResult().getCount();
		imageInfo.setTotalLikes(totalLikes);

		// ImageUserShare index interactions
		// Get Total Shares
		query = repository.count(imageusershare.row(id));
		response = client.query(query);
		totalShares = response.getResult().getCount();
		imageInfo.setTotalShares(totalShares);

		long pqlEnd = new DateTime().getMillis();
		long pqlRuntime = pqlEnd - pqlStart;
		respModel.setImageInfo(imageInfo);
		respModel.setRunTime(pqlRuntime);
		return respModel;
	}

	@SuppressWarnings("unused")
	public BenchMarkAllRespModel getAll() {
		long pqlStart = new DateTime().getMillis();
		BenchMarkAllRespModel respModel = new BenchMarkAllRespModel();
		List<ImageInfo> list = new ArrayList<ImageInfo>();

		PilosaClient client = PilosaClient.defaultClient();
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

		List<ImageEntry> listImage = imageRepository.findAll();
		if (listImage.size() > 0) {
			for (ImageEntry image : listImage) {
				ImageInfo item = new ImageInfo();
				item.setImage_id(image.getId());
				item.setTitle(image.getTitle());
				item.setDescription(image.getDescription());
				item.setUrl(image.getUrl());

				query = repository.count(imageuserlike.row(image.getId()));
				response = client.query(query);
				totalLikes = response.getResult().getCount();
				item.setTotalLikes(totalLikes);

				query = repository.count(imageusershare.row(image.getId()));
				response = client.query(query);
				totalShares = response.getResult().getCount();
				item.setTotalShares(totalShares);
				list.add(item);

			}
		}
		long pqlEnd = new DateTime().getMillis();
		long pqlRuntime = pqlEnd - pqlStart;
		respModel.setList(list);
		respModel.setRunTime(pqlRuntime);
		return respModel;
	}
}
