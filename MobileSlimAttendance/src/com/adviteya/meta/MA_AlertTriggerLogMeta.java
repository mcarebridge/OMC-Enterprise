package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:11")
/** */
public final class MA_AlertTriggerLogMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_AlertTriggerLog> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Alert>, com.adviteya.model.MA_Alert> alertRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Alert>, com.adviteya.model.MA_Alert>(this, "alertRef", "alertRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Alert.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Integer> createDay = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Integer>(this, "createDay", "createDay", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Integer> createMonth = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Integer>(this, "createMonth", "createMonth", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Integer> createYear = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Integer>(this, "createYear", "createYear", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Boolean> firstAlert = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Boolean>(this, "firstAlert", "firstAlert", java.lang.Boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date> firstAlertTimeStamp = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date>(this, "firstAlertTimeStamp", "firstAlertTimeStamp", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Boolean> secondAlert = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Boolean>(this, "secondAlert", "secondAlert", java.lang.Boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date> secondAlertTimeStamp = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date>(this, "secondAlertTimeStamp", "secondAlertTimeStamp", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift> shiftRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift>(this, "shiftRef", "shiftRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Shift.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertTriggerLog> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertTriggerLog>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertTriggerLog> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_AlertTriggerLog>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_AlertTriggerLog, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_AlertTriggerLogMeta slim3_singleton = new MA_AlertTriggerLogMeta();

    /**
     * @return the singleton
     */
    public static MA_AlertTriggerLogMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_AlertTriggerLogMeta() {
        super("MA_AlertTriggerLog", com.adviteya.model.MA_AlertTriggerLog.class);
    }

    @Override
    public com.adviteya.model.MA_AlertTriggerLog entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_AlertTriggerLog model = new com.adviteya.model.MA_AlertTriggerLog();
        if (model.getAlertRef() == null) {
            throw new NullPointerException("The property(alertRef) is null.");
        }
        model.getAlertRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("alertRef"));
        model.setCreateDay(longToInteger((java.lang.Long) entity.getProperty("createDay")));
        model.setCreateMonth(longToInteger((java.lang.Long) entity.getProperty("createMonth")));
        model.setCreateYear(longToInteger((java.lang.Long) entity.getProperty("createYear")));
        model.setFirstAlert((java.lang.Boolean) entity.getProperty("firstAlert"));
        model.setFirstAlertTimeStamp((java.util.Date) entity.getProperty("firstAlertTimeStamp"));
        model.setSecondAlert((java.lang.Boolean) entity.getProperty("secondAlert"));
        model.setSecondAlertTimeStamp((java.util.Date) entity.getProperty("secondAlertTimeStamp"));
        if (model.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) is null.");
        }
        model.getShiftRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("shiftRef"));
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
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getAlertRef() == null) {
            throw new NullPointerException("The property(alertRef) must not be null.");
        }
        entity.setProperty("alertRef", m.getAlertRef().getKey());
        entity.setProperty("createDay", m.getCreateDay());
        entity.setProperty("createMonth", m.getCreateMonth());
        entity.setProperty("createYear", m.getCreateYear());
        entity.setProperty("firstAlert", m.getFirstAlert());
        entity.setProperty("firstAlertTimeStamp", m.getFirstAlertTimeStamp());
        entity.setProperty("secondAlert", m.getSecondAlert());
        entity.setProperty("secondAlertTimeStamp", m.getSecondAlertTimeStamp());
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        entity.setProperty("shiftRef", m.getShiftRef().getKey());
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
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        if (m.getAlertRef() == null) {
            throw new NullPointerException("The property(alertRef) must not be null.");
        }
        m.getAlertRef().assignKeyIfNecessary(ds);
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        m.getShiftRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
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
        com.adviteya.model.MA_AlertTriggerLog m = (com.adviteya.model.MA_AlertTriggerLog) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAlertRef() != null && m.getAlertRef().getKey() != null){
            writer.setNextPropertyName("alertRef");
            encoder0.encode(writer, m.getAlertRef(), maxDepth, currentDepth);
        }
        if(m.getCreateDay() != null){
            writer.setNextPropertyName("createDay");
            encoder0.encode(writer, m.getCreateDay());
        }
        if(m.getCreateMonth() != null){
            writer.setNextPropertyName("createMonth");
            encoder0.encode(writer, m.getCreateMonth());
        }
        if(m.getCreateYear() != null){
            writer.setNextPropertyName("createYear");
            encoder0.encode(writer, m.getCreateYear());
        }
        if(m.getFirstAlert() != null){
            writer.setNextPropertyName("firstAlert");
            encoder0.encode(writer, m.getFirstAlert());
        }
        if(m.getFirstAlertTimeStamp() != null){
            writer.setNextPropertyName("firstAlertTimeStamp");
            encoder0.encode(writer, m.getFirstAlertTimeStamp());
        }
        if(m.getSecondAlert() != null){
            writer.setNextPropertyName("secondAlert");
            encoder0.encode(writer, m.getSecondAlert());
        }
        if(m.getSecondAlertTimeStamp() != null){
            writer.setNextPropertyName("secondAlertTimeStamp");
            encoder0.encode(writer, m.getSecondAlertTimeStamp());
        }
        if(m.getShiftRef() != null && m.getShiftRef().getKey() != null){
            writer.setNextPropertyName("shiftRef");
            encoder0.encode(writer, m.getShiftRef(), maxDepth, currentDepth);
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
    protected com.adviteya.model.MA_AlertTriggerLog jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_AlertTriggerLog m = new com.adviteya.model.MA_AlertTriggerLog();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("alertRef");
        decoder0.decode(reader, m.getAlertRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("createDay");
        m.setCreateDay(decoder0.decode(reader, m.getCreateDay()));
        reader = rootReader.newObjectReader("createMonth");
        m.setCreateMonth(decoder0.decode(reader, m.getCreateMonth()));
        reader = rootReader.newObjectReader("createYear");
        m.setCreateYear(decoder0.decode(reader, m.getCreateYear()));
        reader = rootReader.newObjectReader("firstAlert");
        m.setFirstAlert(decoder0.decode(reader, m.getFirstAlert()));
        reader = rootReader.newObjectReader("firstAlertTimeStamp");
        m.setFirstAlertTimeStamp(decoder0.decode(reader, m.getFirstAlertTimeStamp()));
        reader = rootReader.newObjectReader("secondAlert");
        m.setSecondAlert(decoder0.decode(reader, m.getSecondAlert()));
        reader = rootReader.newObjectReader("secondAlertTimeStamp");
        m.setSecondAlertTimeStamp(decoder0.decode(reader, m.getSecondAlertTimeStamp()));
        reader = rootReader.newObjectReader("shiftRef");
        decoder0.decode(reader, m.getShiftRef(), maxDepth, currentDepth);
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