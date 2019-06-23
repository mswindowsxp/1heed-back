/*
 * This file is generated by jOOQ.
 */
package io.uetunited.oneheed.entity.public_.tables.records;


import io.uetunited.oneheed.entity.public_.tables.Messages;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;


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
public class MessagesRecord extends TableRecordImpl<MessagesRecord> implements Record13<String, String, String, String, String, String, String, Integer, Integer, Timestamp, Timestamp, String, String> {

    private static final long serialVersionUID = -1039285545;

    /**
     * Setter for <code>public.messages.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.messages.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.messages.social_id</code>.
     */
    public void setSocialId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.messages.social_id</code>.
     */
    public String getSocialId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.messages.channel</code>.
     */
    public void setChannel(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.messages.channel</code>.
     */
    public String getChannel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.messages.conversation_id</code>.
     */
    public void setConversationId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.messages.conversation_id</code>.
     */
    public String getConversationId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.messages.from</code>.
     */
    public void setFrom(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.messages.from</code>.
     */
    public String getFrom() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.messages.to</code>.
     */
    public void setTo(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.messages.to</code>.
     */
    public String getTo() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.messages.content</code>.
     */
    public void setContent(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.messages.content</code>.
     */
    public String getContent() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.messages.read_status</code>.
     */
    public void setReadStatus(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.messages.read_status</code>.
     */
    public Integer getReadStatus() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.messages.send_status</code>.
     */
    public void setSendStatus(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.messages.send_status</code>.
     */
    public Integer getSendStatus() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.messages.read_at</code>.
     */
    public void setReadAt(Timestamp value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.messages.read_at</code>.
     */
    public Timestamp getReadAt() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>public.messages.send_at</code>.
     */
    public void setSendAt(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.messages.send_at</code>.
     */
    public Timestamp getSendAt() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>public.messages.from_social_id</code>.
     */
    public void setFromSocialId(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.messages.from_social_id</code>.
     */
    public String getFromSocialId() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.messages.to_social_id</code>.
     */
    public void setToSocialId(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.messages.to_social_id</code>.
     */
    public String getToSocialId() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, String, String, String, String, Integer, Integer, Timestamp, Timestamp, String, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<String, String, String, String, String, String, String, Integer, Integer, Timestamp, Timestamp, String, String> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Messages.MESSAGES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Messages.MESSAGES.SOCIAL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Messages.MESSAGES.CHANNEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Messages.MESSAGES.CONVERSATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Messages.MESSAGES.FROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Messages.MESSAGES.TO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Messages.MESSAGES.CONTENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Messages.MESSAGES.READ_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return Messages.MESSAGES.SEND_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return Messages.MESSAGES.READ_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Messages.MESSAGES.SEND_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Messages.MESSAGES.FROM_SOCIAL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Messages.MESSAGES.TO_SOCIAL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSocialId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getChannel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getConversationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getReadStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getSendStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component10() {
        return getReadAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getSendAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getFromSocialId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getToSocialId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSocialId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getChannel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getConversationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getFrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getTo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getReadStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getSendStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getReadAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getSendAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getFromSocialId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getToSocialId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value2(String value) {
        setSocialId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value3(String value) {
        setChannel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value4(String value) {
        setConversationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value5(String value) {
        setFrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value6(String value) {
        setTo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value7(String value) {
        setContent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value8(Integer value) {
        setReadStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value9(Integer value) {
        setSendStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value10(Timestamp value) {
        setReadAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value11(Timestamp value) {
        setSendAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value12(String value) {
        setFromSocialId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord value13(String value) {
        setToSocialId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MessagesRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, Integer value8, Integer value9, Timestamp value10, Timestamp value11, String value12, String value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MessagesRecord
     */
    public MessagesRecord() {
        super(Messages.MESSAGES);
    }

    /**
     * Create a detached, initialised MessagesRecord
     */
    public MessagesRecord(String id, String socialId, String channel, String conversationId, String from, String to, String content, Integer readStatus, Integer sendStatus, Timestamp readAt, Timestamp sendAt, String fromSocialId, String toSocialId) {
        super(Messages.MESSAGES);

        set(0, id);
        set(1, socialId);
        set(2, channel);
        set(3, conversationId);
        set(4, from);
        set(5, to);
        set(6, content);
        set(7, readStatus);
        set(8, sendStatus);
        set(9, readAt);
        set(10, sendAt);
        set(11, fromSocialId);
        set(12, toSocialId);
    }
}
