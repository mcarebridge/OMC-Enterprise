package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:05")
/** */
public final class MA_UsageMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Usage> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Usage, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Usage, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Double> consumedUnit = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Double>(this, "consumedUnit", "consumedUnit", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Integer> createDay = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Integer>(this, "createDay", "createDay", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Integer> createMonth = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Integer>(this, "createMonth", "createMonth", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Integer> createYear = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Integer>(this, "createYear", "createYear", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Usage, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Usage, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Usage> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Usage>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Usage> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Usage>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Usage, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_UsageMeta slim3_singleton = new MA_UsageMeta();

    /**
     * @return the singleton
     */
    public static MA_UsageMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_UsageMeta() {
        super("MA_Usage", com.adviteya.model.MA_Usage.class);
    }

    @Override
    public com.adviteya.model.MA_Usage entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Usage model = new com.adviteya.model.MA_Usage();
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setConsumedUnit(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("consumedUnit")));
        model.setCreateDay(longToPrimitiveInt((java.lang.Long) entity.getProperty("createDay")));
        model.setCreateMonth(longToPrimitiveInt((java.lang.Long) entity.getProperty("createMonth")));
        model.setCreateYear(longToPrimitiveInt((java.lang.Long) entity.getProperty("createYear")));
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
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("consumedUnit", m.getConsumedUnit());
        entity.setProperty("createDay", m.getCreateDay());
        entity.setProperty("createMonth", m.getCreateMonth());
        entity.setProperty("createYear", m.getCreateYear());
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
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
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
        com.adviteya.model.MA_Usage m = (com.adviteya.model.MA_Usage) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("consumedUnit");
        encoder0.encode(writer, m.getConsumedUnit());
        writer.setNextPropertyName("createDay");
        encoder0.encode(writer, m.getCreateDay());
        writer.setNextPropertyName("createMonth");
        encoder0.encode(writer, m.getCreateMonth());
        writer.setNextPropertyName("createYear");
        encoder0.encode(writer, m.getCreateYear());
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
    protected com.adviteya.model.MA_Usage jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Usage m = new com.adviteya.model.MA_Usage();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("consumedUnit");
        m.setConsumedUnit(decoder0.decode(reader, m.getConsumedUnit()));
        reader = rootReader.newObjectReader("createDay");
        m.setCreateDay(decoder0.decode(reader, m.getCreateDay()));
        reader = rootReader.newObjectReader("createMonth");
        m.setCreateMonth(decoder0.decode(reader, m.getCreateMonth()));
        reader = rootReader.newObjectReader("createYear");
        m.setCreateYear(decoder0.decode(reader, m.getCreateYear()));
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