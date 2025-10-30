package me.trihung.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> userPassword;
	public static volatile SingularAttribute<Users, String> userImage;
	public static volatile SingularAttribute<Users, String> userfullName;
	public static volatile SingularAttribute<Users, String> userPhone;
	public static volatile SingularAttribute<Users, String> useraddress;
	public static volatile SingularAttribute<Users, String> userEmail;
	public static volatile SingularAttribute<Users, Boolean> userIsAdmin;
	public static volatile ListAttribute<Users, Orders> orders;
	public static volatile SingularAttribute<Users, String> userName;
	public static volatile SingularAttribute<Users, Date> userRegisDay;
	public static volatile SingularAttribute<Users, Integer> userId;

	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_IMAGE = "userImage";
	public static final String USERFULL_NAME = "userfullName";
	public static final String USER_PHONE = "userPhone";
	public static final String USERADDRESS = "useraddress";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_IS_ADMIN = "userIsAdmin";
	public static final String ORDERS = "orders";
	public static final String USER_NAME = "userName";
	public static final String USER_REGIS_DAY = "userRegisDay";
	public static final String USER_ID = "userId";

}

