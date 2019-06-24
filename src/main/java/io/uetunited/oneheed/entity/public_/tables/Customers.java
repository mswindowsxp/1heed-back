/*
 * This file is generated by jOOQ.
 */
package io.uetunited.oneheed.entity.public_.tables;


import io.uetunited.oneheed.entity.public_.Public;
import io.uetunited.oneheed.entity.public_.tables.records.CustomersRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customers extends TableImpl<CustomersRecord> {

    private static final long serialVersionUID = 1533983441;

    /**
     * The reference instance of <code>public.customers</code>
     */
    public static final Customers CUSTOMERS = new Customers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomersRecord> getRecordType() {
        return CustomersRecord.class;
    }

    /**
     * The column <code>public.customers.id</code>.
     */
    public final TableField<CustomersRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.customers.social_id</code>.
     */
    public final TableField<CustomersRecord, String> SOCIAL_ID = createField("social_id", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.customers.name</code>.
     */
    public final TableField<CustomersRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.customers.email</code>.
     */
    public final TableField<CustomersRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.customers.phone</code>.
     */
    public final TableField<CustomersRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.customers.type</code>.
     */
    public final TableField<CustomersRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.customers.address</code>.
     */
    public final TableField<CustomersRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.customers</code> table reference
     */
    public Customers() {
        this(DSL.name("customers"), null);
    }

    /**
     * Create an aliased <code>public.customers</code> table reference
     */
    public Customers(String alias) {
        this(DSL.name(alias), CUSTOMERS);
    }

    /**
     * Create an aliased <code>public.customers</code> table reference
     */
    public Customers(Name alias) {
        this(alias, CUSTOMERS);
    }

    private Customers(Name alias, Table<CustomersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Customers(Name alias, Table<CustomersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Customers(Table<O> child, ForeignKey<O, CustomersRecord> key) {
        super(child, key, CUSTOMERS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customers as(String alias) {
        return new Customers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customers as(Name alias) {
        return new Customers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Customers rename(String name) {
        return new Customers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Customers rename(Name name) {
        return new Customers(name, null);
    }
}