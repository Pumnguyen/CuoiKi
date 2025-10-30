package me.quangtruong.entity.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import me.quangtruong.entity.Rating;
import me.quangtruong.utils.Utils;

@Getter
@Setter
public class RatingModel implements Serializable{
	
private static final long serialVersionUID = 5302027001308063983L;
	
	private int ratingId;
	
	private String ratingDate;
	
	private int ratingValue;
	
	private String ratingComment;
	
	private String user;
	
	private String img;
	
	private int product;
	
	public RatingModel(Rating rating) {
		ratingId = rating.getRatingId();
		ratingDate = Utils.toString2(rating.getRatingDate());
		ratingValue = rating.getRatingValue();
		ratingComment = rating.getRatingComment();
		user = rating.getUser().getUserfullName();
		product = rating.getProductId();
		img = "http://localhost:8080/DAWEBB/image?from=user&fname="+rating.getUser().getUserImage();
	}
	
	
}