package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:11")
/** */
public final class MA_AlertTypeMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_AlertType> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType>(this, "active", "active");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType> alertKey = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType>(this, "alertKey", "alertKey");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType> description = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType>(this, "description", "description");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType> displayName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType>(this, "displayName", "displayName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertType>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertType, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_AlertTypeMeta slim3_singleton = new MA_AlertTypeMeta();

    /**
     * @return the singleton
     */
    public static MA_AlertTypeMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_AlertTypeMeta() {
        super("MA_AlertType", com.adviteya.model.MA_AlertType.class);
    }

    @Override
    public com.adviteya.model.MA_AlertType entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_AlertType model = new com.adviteya.model.MA_AlertType();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setAlertKey((java.lang.String) entity.getProperty("alertKey"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setDisplayName((java.lang.String) entity.getProperty("displayName"));
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
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setProperty("alertKey", m.getAlertKey());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("displayName", m.getDisplayName());
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
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
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
        com.adviteya.model.MA_AlertType m = (com.adviteya.model.MA_AlertType) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getAlertKey() != null){
            writer.setNextPropertyName("alertKey");
            encoder0.encode(writer, m.getAlertKey());
        }
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getDisplayName() != null){
            writer.setNextPropertyName("displayName");
            encoder0.encode(writer, m.getDisplayName());
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
    protected com.adviteya.model.MA_AlertType jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_AlertType m = new com.adviteya.model.MA_AlertType();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("alertKey");
        m.setAlertKey(decoder0.decode(reader, m.getAlertKey()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("displayName");
        m.setDisplayName(decoder0.decode(reader, m.getDisplayName()));
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