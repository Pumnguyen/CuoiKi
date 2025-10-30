package me.trihung.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Long> productAmount;
	public static volatile SingularAttribute<Product, String> productImage;
	public static volatile SingularAttribute<Product, Integer> productId;
	public static volatile ListAttribute<Product, Rating> ratings;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, Long> productPrice;
	public static volatile SingularAttribute<Product, ProductCategory> productCategory;

	public static final String PRODUCT_AMOUNT = "productAmount";
	public static final String PRODUCT_IMAGE = "productImage";
	public static final String PRODUCT_ID = "productId";
	public static final String RATINGS = "ratings";
	public static final String PRODUCT_NAME = "productName";
	public static final String PRODUCT_PRICE = "productPrice";
	public static final String PRODUCT_CATEGORY = "productCategory";

}

