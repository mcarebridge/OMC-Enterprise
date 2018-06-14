package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:09")
/** */
public final class MA_EmailTemplateMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_EmailTemplate> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate>(this, "active", "active");

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_EmailTemplate, com.google.appengine.api.datastore.Text> emailMessage = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_EmailTemplate, com.google.appengine.api.datastore.Text>(this, "emailMessage", "emailMessage", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate> emailSubject = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate>(this, "emailSubject", "emailSubject");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate> templateType = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate>(this, "templateType", "templateType");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EmailTemplate>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EmailTemplate, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_EmailTemplateMeta slim3_singleton = new MA_EmailTemplateMeta();

    /**
     * @return the singleton
     */
    public static MA_EmailTemplateMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_EmailTemplateMeta() {
        super("MA_EmailTemplate", com.adviteya.model.MA_EmailTemplate.class);
    }

    @Override
    public com.adviteya.model.MA_EmailTemplate entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_EmailTemplate model = new com.adviteya.model.MA_EmailTemplate();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setEmailMessage((com.google.appengine.api.datastore.Text) entity.getProperty("emailMessage"));
        model.setEmailSubject((java.lang.String) entity.getProperty("emailSubject"));
        model.setTemplateType((java.lang.String) entity.getProperty("templateType"));
        model.setCreatedBy((java.lang.String) entity.getProperty("createdBy"));
        model.setCreatedDate((java.util.Date) entity.getProperty("createdDate"));
        model.setKey(entity.getKey());
        model.setUpdatedBy((java.lang.String) entity.getProperty("updatedBy"));
        model.setUpdatedDate((java.util.Date) entity.getProperty("updatedDate"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setUnindexedProperty("emailMessage", m.getEmailMessage());
        entity.setProperty("emailSubject", m.getEmailSubject());
        entity.setProperty("templateType", m.getTemplateType());
        entity.setProperty("createdBy", m.getCreatedBy());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("updatedBy", m.getUpdatedBy());
        entity.setProperty("updatedDate", m.getUpdatedDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        m.setCreatedDate(slim3_createdDateAttributeListener.prePut(m.getCreatedDate()));
        m.setUpdatedDate(slim3_updatedDateAttributeListener.prePut(m.getUpdatedDate()));
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_EmailTemplate m = (com.adviteya.model.MA_EmailTemplate) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getEmailMessage() != null && m.getEmailMessage().getValue() != null){
            writer.setNextPropertyName("emailMessage");
            encoder0.encode(writer, m.getEmailMessage());
        }
        if(m.getEmailSubject() != null){
            writer.setNextPropertyName("emailSubject");
            encoder0.encode(writer, m.getEmailSubject());
        }
        if(m.getTemplateType() != null){
            writer.setNextPropertyName("templateType");
            encoder0.encode(writer, m.getTemplateType());
        }
        if(m.getCreatedBy() != null){
            writer.setNextPropertyName("createdBy");
            encoder0.encode(writer, m.getCreatedBy());
        }
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getUpdatedBy() != null){
            writer.setNextPropertyName("updatedBy");
            encoder0.encode(writer, m.getUpdatedBy());
        }
        if(m.getUpdatedDate() != null){
            writer.setNextPropertyName("updatedDate");
            encoder0.encode(writer, m.getUpdatedDate());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.adviteya.model.MA_EmailTemplate jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_EmailTemplate m = new com.adviteya.model.MA_EmailTemplate();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("emailMessage");
        m.setEmailMessage(decoder0.decode(reader, m.getEmailMessage()));
        reader = rootReader.newObjectReader("emailSubject");
        m.setEmailSubject(decoder0.decode(reader, m.getEmailSubject()));
        reader = rootReader.newObjectReader("templateType");
        m.setTemplateType(decoder0.decode(reader, m.getTemplateType()));
        reader = rootReader.newObjectReader("createdBy");
        m.setCreatedBy(decoder0.decode(reader, m.getCreatedBy()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("updatedBy");
        m.setUpdatedBy(decoder0.decode(reader, m.getUpdatedBy()));
        reader = rootReader.newObjectReader("updatedDate");
        m.setUpdatedDate(decoder0.decode(reader, m.getUpdatedDate()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}