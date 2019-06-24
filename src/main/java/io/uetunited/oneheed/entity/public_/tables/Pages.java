/*
 * This file is generated by jOOQ.
 */
package io.uetunited.oneheed.entity.public_.tables;


import io.uetunited.oneheed.entity.public_.Public;
import io.uetunited.oneheed.entity.public_.tables.records.PagesRecord;

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
public class Pages extends TableImpl<PagesRecord> {

    private static final long serialVersionUID = 414231957;

    /**
     * The reference instance of <code>public.pages</code>
     */
    public static final Pages PAGES = new Pages();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PagesRecord> getRecordType() {
        return PagesRecord.class;
    }

    /**
     * The column <code>public.pages.id</code>.
     */
    public final TableField<PagesRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.pages.social_id</code>.
     */
    public final TableField<PagesRecord, String> SOCIAL_ID = createField("social_id", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.pages.name</code>.
     */
    public final TableField<PagesRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.pages.avatar</code>.
     */
    public final TableField<PagesRecord, String> AVATAR = createField("avatar", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.pages.access_token</code>.
     */
    public final TableField<PagesRecord, String> ACCESS_TOKEN = createField("access_token", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.pages.type</code>.
     */
    public final TableField<PagesRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.pages.is_active</code>.
     */
    public final TableField<PagesRecord, Boolean> IS_ACTIVE = createField("is_active", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * Create a <code>public.pages</code> table reference
     */
    public Pages() {
        this(DSL.name("pages"), null);
    }

    /**
     * Create an aliased <code>public.pages</code> table reference
     */
    public Pages(String alias) {
        this(DSL.name(alias), PAGES);
    }

    /**
     * Create an aliased <code>public.pages</code> table reference
     */
    public Pages(Name alias) {
        this(alias, PAGES);
    }

    private Pages(Name alias, Table<PagesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Pages(Name alias, Table<PagesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Pages(Table<O> child, ForeignKey<O, PagesRecord> key) {
        super(child, key, PAGES);
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
    public Pages as(String alias) {
        return new Pages(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pages as(Name alias) {
        return new Pages(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Pages rename(String name) {
        return new Pages(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Pages rename(Name name) {
        return new Pages(name, null);
    }
}