package me.trihung.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rating.class)
public abstract class Rating_ {

	public static volatile SingularAttribute<Rating, Date> ratingDate;
	public static volatile SingularAttribute<Rating, Integer> productId;
	public static volatile SingularAttribute<Rating, Integer> ratingId;
	public static volatile SingularAttribute<Rating, Integer> ratingValue;
	public static volatile SingularAttribute<Rating, String> ratingComment;
	public static volatile SingularAttribute<Rating, Users> user;

	public static final String RATING_DATE = "ratingDate";
	public static final String PRODUCT_ID = "productId";
	public static final String RATING_ID = "ratingId";
	public static final String RATING_VALUE = "ratingValue";
	public static final String RATING_COMMENT = "ratingComment";
	public static final String USER = "user";

}

