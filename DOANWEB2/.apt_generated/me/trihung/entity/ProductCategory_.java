package me.trihung.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductCategory.class)
public abstract class ProductCategory_ {

	public static volatile SingularAttribute<ProductCategory, Integer> productCategoryId;
	public static volatile SingularAttribute<ProductCategory, String> productCategoryName;
	public static volatile ListAttribute<ProductCategory, Product> products;

	public static final String PRODUCT_CATEGORY_ID = "productCategoryId";
	public static final String PRODUCT_CATEGORY_NAME = "productCategoryName";
	public static final String PRODUCTS = "products";

}

