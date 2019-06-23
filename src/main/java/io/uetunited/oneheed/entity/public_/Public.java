/*
 * This file is generated by jOOQ.
 */
package io.uetunited.oneheed.entity.public_;


import io.uetunited.oneheed.entity.DefaultCatalog;
import io.uetunited.oneheed.entity.public_.tables.Conversations;
import io.uetunited.oneheed.entity.public_.tables.Customers;
import io.uetunited.oneheed.entity.public_.tables.Messages;
import io.uetunited.oneheed.entity.public_.tables.Pages;
import io.uetunited.oneheed.entity.public_.tables.Reports;
import io.uetunited.oneheed.entity.public_.tables.Roles;
import io.uetunited.oneheed.entity.public_.tables.TagConversations;
import io.uetunited.oneheed.entity.public_.tables.Tags;
import io.uetunited.oneheed.entity.public_.tables.UserRoles;
import io.uetunited.oneheed.entity.public_.tables.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1137848535;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.conversations</code>.
     */
    public final Conversations CONVERSATIONS = io.uetunited.oneheed.entity.public_.tables.Conversations.CONVERSATIONS;

    /**
     * The table <code>public.customers</code>.
     */
    public final Customers CUSTOMERS = io.uetunited.oneheed.entity.public_.tables.Customers.CUSTOMERS;

    /**
     * The table <code>public.messages</code>.
     */
    public final Messages MESSAGES = io.uetunited.oneheed.entity.public_.tables.Messages.MESSAGES;

    /**
     * The table <code>public.pages</code>.
     */
    public final Pages PAGES = io.uetunited.oneheed.entity.public_.tables.Pages.PAGES;

    /**
     * The table <code>public.reports</code>.
     */
    public final Reports REPORTS = io.uetunited.oneheed.entity.public_.tables.Reports.REPORTS;

    /**
     * The table <code>public.roles</code>.
     */
    public final Roles ROLES = io.uetunited.oneheed.entity.public_.tables.Roles.ROLES;

    /**
     * The table <code>public.tag_conversations</code>.
     */
    public final TagConversations TAG_CONVERSATIONS = io.uetunited.oneheed.entity.public_.tables.TagConversations.TAG_CONVERSATIONS;

    /**
     * The table <code>public.tags</code>.
     */
    public final Tags TAGS = io.uetunited.oneheed.entity.public_.tables.Tags.TAGS;

    /**
     * The table <code>public.user_roles</code>.
     */
    public final UserRoles USER_ROLES = io.uetunited.oneheed.entity.public_.tables.UserRoles.USER_ROLES;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = io.uetunited.oneheed.entity.public_.tables.Users.USERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.ROLES_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Conversations.CONVERSATIONS,
            Customers.CUSTOMERS,
            Messages.MESSAGES,
            Pages.PAGES,
            Reports.REPORTS,
            Roles.ROLES,
            TagConversations.TAG_CONVERSATIONS,
            Tags.TAGS,
            UserRoles.USER_ROLES,
            Users.USERS);
    }
}
