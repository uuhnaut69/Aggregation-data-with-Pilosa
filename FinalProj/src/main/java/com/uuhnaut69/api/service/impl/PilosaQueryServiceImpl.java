package com.uuhnaut69.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pilosa.client.PilosaClient;
import com.pilosa.client.QueryResponse;
import com.pilosa.client.exceptions.PilosaException;
import com.pilosa.client.orm.Field;
import com.pilosa.client.orm.Index;
import com.pilosa.client.orm.PqlQuery;
import com.pilosa.client.orm.Schema;
import com.uuhnaut69.api.entity.Image;
import com.uuhnaut69.api.entity.view.ImageView;
import com.uuhnaut69.api.payload.BenchMarkAllResponse;
import com.uuhnaut69.api.payload.BenchMarkByIdResponse;
import com.uuhnaut69.api.repository.ImageRepository;
import com.uuhnaut69.api.service.PilosaQueryService;

import javassist.NotFoundException;

/**
 * @author uuhnaut
 *
 */
@Service
@Transactional(readOnly = true)
public class PilosaQueryServiceImpl implements PilosaQueryService {

	private final ImageRepository imageRepository;

	public PilosaQueryServiceImpl(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	@Override
	public BenchMarkByIdResponse getById(Long id) throws Exception {
		long pqlStart = new DateTime().getMillis();
		BenchMarkByIdResponse respModel = new BenchMarkByIdResponse();
		Image imageEntry = imageRepository.findById(id).orElseThrow(() -> new NotFoundException("Can't find"));
		ImageView imageInfo = new ImageView();
		imageInfo.setId(imageEntry.getId());
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

	@Override
	public BenchMarkAllResponse getAll() throws Exception {
		long pqlStart = new DateTime().getMillis();
		BenchMarkAllResponse respModel = new BenchMarkAllResponse();
		List<ImageView> list = new ArrayList<ImageView>();

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

		List<Image> listImage = imageRepository.findAll();
		if (!listImage.isEmpty()) {
			for (Image image : listImage) {
				ImageView item = new ImageView();
				item.setId(image.getId());
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
