package me.trihung.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static volatile SingularAttribute<Transaction, Long> transTotalValue;
	public static volatile SingularAttribute<Transaction, Date> transactionDay;
	public static volatile SingularAttribute<Transaction, String> transAddress;
	public static volatile SingularAttribute<Transaction, Users> user;
	public static volatile SingularAttribute<Transaction, Integer> transactionId;
	public static volatile SingularAttribute<Transaction, Integer> transStatus;

	public static final String TRANS_TOTAL_VALUE = "transTotalValue";
	public static final String TRANSACTION_DAY = "transactionDay";
	public static final String TRANS_ADDRESS = "transAddress";
	public static final String USER = "user";
	public static final String TRANSACTION_ID = "transactionId";
	public static final String TRANS_STATUS = "transStatus";

}

