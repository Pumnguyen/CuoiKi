package me.trihung.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class Orders_ {

	public static volatile SingularAttribute<Orders, Product> product;
	public static volatile SingularAttribute<Orders, Integer> orderId;
	public static volatile SingularAttribute<Orders, Long> orderCount;
	public static volatile SingularAttribute<Orders, Integer> orderStatus;
	public static volatile SingularAttribute<Orders, Long> orderPrice;
	public static volatile SingularAttribute<Orders, Users> user;

	public static final String PRODUCT = "product";
	public static final String ORDER_ID = "orderId";
	public static final String ORDER_COUNT = "orderCount";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String ORDER_PRICE = "orderPrice";
	public static final String USER = "user";

}

