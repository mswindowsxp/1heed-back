/*
 * This file is generated by jOOQ.
 */
package io.uetunited.oneheed.entity.public_;


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

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.conversations</code>.
     */
    public static final Conversations CONVERSATIONS = io.uetunited.oneheed.entity.public_.tables.Conversations.CONVERSATIONS;

    /**
     * The table <code>public.customers</code>.
     */
    public static final Customers CUSTOMERS = io.uetunited.oneheed.entity.public_.tables.Customers.CUSTOMERS;

    /**
     * The table <code>public.messages</code>.
     */
    public static final Messages MESSAGES = io.uetunited.oneheed.entity.public_.tables.Messages.MESSAGES;

    /**
     * The table <code>public.pages</code>.
     */
    public static final Pages PAGES = io.uetunited.oneheed.entity.public_.tables.Pages.PAGES;

    /**
     * The table <code>public.reports</code>.
     */
    public static final Reports REPORTS = io.uetunited.oneheed.entity.public_.tables.Reports.REPORTS;

    /**
     * The table <code>public.roles</code>.
     */
    public static final Roles ROLES = io.uetunited.oneheed.entity.public_.tables.Roles.ROLES;

    /**
     * The table <code>public.tag_conversations</code>.
     */
    public static final TagConversations TAG_CONVERSATIONS = io.uetunited.oneheed.entity.public_.tables.TagConversations.TAG_CONVERSATIONS;

    /**
     * The table <code>public.tags</code>.
     */
    public static final Tags TAGS = io.uetunited.oneheed.entity.public_.tables.Tags.TAGS;

    /**
     * The table <code>public.user_roles</code>.
     */
    public static final UserRoles USER_ROLES = io.uetunited.oneheed.entity.public_.tables.UserRoles.USER_ROLES;

    /**
     * The table <code>public.users</code>.
     */
    public static final Users USERS = io.uetunited.oneheed.entity.public_.tables.Users.USERS;
}
