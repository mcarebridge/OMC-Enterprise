package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:06")
/** */
public final class MA_ShiftMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Shift> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift>(this, "active", "active");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> endGMTHrs = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "endGMTHrs", "endGMTHrs", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> endGMTMin = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "endGMTMin", "endGMTMin", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> endHrs = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "endHrs", "endHrs", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> endMin = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "endMin", "endMin", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Shift, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Shift, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift> shiftName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift>(this, "shiftName", "shiftName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> startGMTHrs = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "startGMTHrs", "startGMTHrs", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> startGMTMin = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "startGMTMin", "startGMTMin", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> startHrs = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "startHrs", "startHrs", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer> startMin = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Integer>(this, "startMin", "startMin", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Shift, org.slim3.datastore.ModelRef<com.adviteya.model.MA_User>, com.adviteya.model.MA_User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Shift, org.slim3.datastore.ModelRef<com.adviteya.model.MA_User>, com.adviteya.model.MA_User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_User.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Shift>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Shift, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_ShiftMeta slim3_singleton = new MA_ShiftMeta();

    /**
     * @return the singleton
     */
    public static MA_ShiftMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_ShiftMeta() {
        super("MA_Shift", com.adviteya.model.MA_Shift.class);
    }

    @Override
    public com.adviteya.model.MA_Shift entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Shift model = new com.adviteya.model.MA_Shift();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setEndGMTHrs(longToPrimitiveInt((java.lang.Long) entity.getProperty("endGMTHrs")));
        model.setEndGMTMin(longToPrimitiveInt((java.lang.Long) entity.getProperty("endGMTMin")));
        model.setEndHrs(longToPrimitiveInt((java.lang.Long) entity.getProperty("endHrs")));
        model.setEndMin(longToPrimitiveInt((java.lang.Long) entity.getProperty("endMin")));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setShiftName((java.lang.String) entity.getProperty("shiftName"));
        model.setStartGMTHrs(longToPrimitiveInt((java.lang.Long) entity.getProperty("startGMTHrs")));
        model.setStartGMTMin(longToPrimitiveInt((java.lang.Long) entity.getProperty("startGMTMin")));
        model.setStartHrs(longToPrimitiveInt((java.lang.Long) entity.getProperty("startHrs")));
        model.setStartMin(longToPrimitiveInt((java.lang.Long) entity.getProperty("startMin")));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
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
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setProperty("endGMTHrs", m.getEndGMTHrs());
        entity.setProperty("endGMTMin", m.getEndGMTMin());
        entity.setProperty("endHrs", m.getEndHrs());
        entity.setProperty("endMin", m.getEndMin());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("shiftName", m.getShiftName());
        entity.setProperty("startGMTHrs", m.getStartGMTHrs());
        entity.setProperty("startGMTMin", m.getStartGMTMin());
        entity.setProperty("startHrs", m.getStartHrs());
        entity.setProperty("startMin", m.getStartMin());
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        entity.setProperty("createdBy", m.getCreatedBy());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("updatedBy", m.getUpdatedBy());
        entity.setProperty("updatedDate", m.getUpdatedDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 3);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
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
        com.adviteya.model.MA_Shift m = (com.adviteya.model.MA_Shift) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        writer.setNextPropertyName("endGMTHrs");
        encoder0.encode(writer, m.getEndGMTHrs());
        writer.setNextPropertyName("endGMTMin");
        encoder0.encode(writer, m.getEndGMTMin());
        writer.setNextPropertyName("endHrs");
        encoder0.encode(writer, m.getEndHrs());
        writer.setNextPropertyName("endMin");
        encoder0.encode(writer, m.getEndMin());
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
        }
        if(m.getShiftName() != null){
            writer.setNextPropertyName("shiftName");
            encoder0.encode(writer, m.getShiftName());
        }
        writer.setNextPropertyName("startGMTHrs");
        encoder0.encode(writer, m.getStartGMTHrs());
        writer.setNextPropertyName("startGMTMin");
        encoder0.encode(writer, m.getStartGMTMin());
        writer.setNextPropertyName("startHrs");
        encoder0.encode(writer, m.getStartHrs());
        writer.setNextPropertyName("startMin");
        encoder0.encode(writer, m.getStartMin());
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder0.encode(writer, m.getUserRef(), maxDepth, currentDepth);
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
    protected com.adviteya.model.MA_Shift jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Shift m = new com.adviteya.model.MA_Shift();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("endGMTHrs");
        m.setEndGMTHrs(decoder0.decode(reader, m.getEndGMTHrs()));
        reader = rootReader.newObjectReader("endGMTMin");
        m.setEndGMTMin(decoder0.decode(reader, m.getEndGMTMin()));
        reader = rootReader.newObjectReader("endHrs");
        m.setEndHrs(decoder0.decode(reader, m.getEndHrs()));
        reader = rootReader.newObjectReader("endMin");
        m.setEndMin(decoder0.decode(reader, m.getEndMin()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("shiftName");
        m.setShiftName(decoder0.decode(reader, m.getShiftName()));
        reader = rootReader.newObjectReader("startGMTHrs");
        m.setStartGMTHrs(decoder0.decode(reader, m.getStartGMTHrs()));
        reader = rootReader.newObjectReader("startGMTMin");
        m.setStartGMTMin(decoder0.decode(reader, m.getStartGMTMin()));
        reader = rootReader.newObjectReader("startHrs");
        m.setStartHrs(decoder0.decode(reader, m.getStartHrs()));
        reader = rootReader.newObjectReader("startMin");
        m.setStartMin(decoder0.decode(reader, m.getStartMin()));
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
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