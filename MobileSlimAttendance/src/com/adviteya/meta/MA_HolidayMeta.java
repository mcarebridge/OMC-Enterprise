package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:08")
/** */
public final class MA_HolidayMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Holiday> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday> countryCode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday>(this, "countryCode", "countryCode");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.util.Date> holidayDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.util.Date>(this, "holidayDate", "holidayDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday> holidayDesc = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday>(this, "holidayDesc", "holidayDesc");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Holiday, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Holiday, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Holiday>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Holiday, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_HolidayMeta slim3_singleton = new MA_HolidayMeta();

    /**
     * @return the singleton
     */
    public static MA_HolidayMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_HolidayMeta() {
        super("MA_Holiday", com.adviteya.model.MA_Holiday.class);
    }

    @Override
    public com.adviteya.model.MA_Holiday entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Holiday model = new com.adviteya.model.MA_Holiday();
        model.setCountryCode((java.lang.String) entity.getProperty("countryCode"));
        model.setHolidayDate((java.util.Date) entity.getProperty("holidayDate"));
        model.setHolidayDesc((java.lang.String) entity.getProperty("holidayDesc"));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
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
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("countryCode", m.getCountryCode());
        entity.setProperty("holidayDate", m.getHolidayDate());
        entity.setProperty("holidayDesc", m.getHolidayDesc());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
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
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
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
        com.adviteya.model.MA_Holiday m = (com.adviteya.model.MA_Holiday) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCountryCode() != null){
            writer.setNextPropertyName("countryCode");
            encoder0.encode(writer, m.getCountryCode());
        }
        if(m.getHolidayDate() != null){
            writer.setNextPropertyName("holidayDate");
            encoder0.encode(writer, m.getHolidayDate());
        }
        if(m.getHolidayDesc() != null){
            writer.setNextPropertyName("holidayDesc");
            encoder0.encode(writer, m.getHolidayDesc());
        }
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
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
    protected com.adviteya.model.MA_Holiday jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Holiday m = new com.adviteya.model.MA_Holiday();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("countryCode");
        m.setCountryCode(decoder0.decode(reader, m.getCountryCode()));
        reader = rootReader.newObjectReader("holidayDate");
        m.setHolidayDate(decoder0.decode(reader, m.getHolidayDate()));
        reader = rootReader.newObjectReader("holidayDesc");
        m.setHolidayDesc(decoder0.decode(reader, m.getHolidayDesc()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
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