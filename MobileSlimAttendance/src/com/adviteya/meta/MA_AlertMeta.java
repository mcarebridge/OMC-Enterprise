package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:11")
/** */
public final class MA_AlertMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Alert> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert>(this, "active", "active");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert> alertMeans = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert>(this, "alertMeans", "alertMeans");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_AlertType>, com.adviteya.model.MA_AlertType> alertTypeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_AlertType>, com.adviteya.model.MA_AlertType>(this, "alertTypeRef", "alertTypeRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_AlertType.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyref = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyref", "companyref", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> firstLevelManager = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "firstLevelManager", "firstLevelManager", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer> maxValueForAlert = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer>(this, "maxValueForAlert", "maxValueForAlert", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer> minValueForAlert = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer>(this, "minValueForAlert", "minValueForAlert", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> secondLevelManager = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "secondLevelManager", "secondLevelManager", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift> shiftRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Alert, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift>(this, "shiftRef", "shiftRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Shift.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer> targetValues = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer>(this, "targetValues", "targetValues", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer> toleranceLevelForEscalation = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Integer>(this, "toleranceLevelForEscalation", "toleranceLevelForEscalation", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Alert>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Alert, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_AlertMeta slim3_singleton = new MA_AlertMeta();

    /**
     * @return the singleton
     */
    public static MA_AlertMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_AlertMeta() {
        super("MA_Alert", com.adviteya.model.MA_Alert.class);
    }

    @Override
    public com.adviteya.model.MA_Alert entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Alert model = new com.adviteya.model.MA_Alert();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setAlertMeans((java.lang.String) entity.getProperty("alertMeans"));
        if (model.getAlertTypeRef() == null) {
            throw new NullPointerException("The property(alertTypeRef) is null.");
        }
        model.getAlertTypeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("alertTypeRef"));
        if (model.getCompanyref() == null) {
            throw new NullPointerException("The property(companyref) is null.");
        }
        model.getCompanyref().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyref"));
        if (model.getFirstLevelManager() == null) {
            throw new NullPointerException("The property(firstLevelManager) is null.");
        }
        model.getFirstLevelManager().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("firstLevelManager"));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setMaxValueForAlert(longToPrimitiveInt((java.lang.Long) entity.getProperty("maxValueForAlert")));
        model.setMinValueForAlert(longToPrimitiveInt((java.lang.Long) entity.getProperty("minValueForAlert")));
        if (model.getSecondLevelManager() == null) {
            throw new NullPointerException("The property(secondLevelManager) is null.");
        }
        model.getSecondLevelManager().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("secondLevelManager"));
        if (model.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) is null.");
        }
        model.getShiftRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("shiftRef"));
        model.setTargetValues(longToPrimitiveInt((java.lang.Long) entity.getProperty("targetValues")));
        model.setToleranceLevelForEscalation(longToPrimitiveInt((java.lang.Long) entity.getProperty("toleranceLevelForEscalation")));
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
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setProperty("alertMeans", m.getAlertMeans());
        if (m.getAlertTypeRef() == null) {
            throw new NullPointerException("The property(alertTypeRef) must not be null.");
        }
        entity.setProperty("alertTypeRef", m.getAlertTypeRef().getKey());
        if (m.getCompanyref() == null) {
            throw new NullPointerException("The property(companyref) must not be null.");
        }
        entity.setProperty("companyref", m.getCompanyref().getKey());
        if (m.getFirstLevelManager() == null) {
            throw new NullPointerException("The property(firstLevelManager) must not be null.");
        }
        entity.setProperty("firstLevelManager", m.getFirstLevelManager().getKey());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("maxValueForAlert", m.getMaxValueForAlert());
        entity.setProperty("minValueForAlert", m.getMinValueForAlert());
        if (m.getSecondLevelManager() == null) {
            throw new NullPointerException("The property(secondLevelManager) must not be null.");
        }
        entity.setProperty("secondLevelManager", m.getSecondLevelManager().getKey());
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        entity.setProperty("shiftRef", m.getShiftRef().getKey());
        entity.setProperty("targetValues", m.getTargetValues());
        entity.setProperty("toleranceLevelForEscalation", m.getToleranceLevelForEscalation());
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
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        if (m.getAlertTypeRef() == null) {
            throw new NullPointerException("The property(alertTypeRef) must not be null.");
        }
        m.getAlertTypeRef().assignKeyIfNecessary(ds);
        if (m.getCompanyref() == null) {
            throw new NullPointerException("The property(companyref) must not be null.");
        }
        m.getCompanyref().assignKeyIfNecessary(ds);
        if (m.getFirstLevelManager() == null) {
            throw new NullPointerException("The property(firstLevelManager) must not be null.");
        }
        m.getFirstLevelManager().assignKeyIfNecessary(ds);
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
        if (m.getSecondLevelManager() == null) {
            throw new NullPointerException("The property(secondLevelManager) must not be null.");
        }
        m.getSecondLevelManager().assignKeyIfNecessary(ds);
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        m.getShiftRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
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
        com.adviteya.model.MA_Alert m = (com.adviteya.model.MA_Alert) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        writer.setNextPropertyName("actualValues");
        encoder0.encode(writer, m.getActualValues());
        if(m.getAlertMeans() != null){
            writer.setNextPropertyName("alertMeans");
            encoder0.encode(writer, m.getAlertMeans());
        }
        if(m.getAlertTypeRef() != null && m.getAlertTypeRef().getKey() != null){
            writer.setNextPropertyName("alertTypeRef");
            encoder0.encode(writer, m.getAlertTypeRef(), maxDepth, currentDepth);
        }
        if(m.getCompanyref() != null && m.getCompanyref().getKey() != null){
            writer.setNextPropertyName("companyref");
            encoder0.encode(writer, m.getCompanyref(), maxDepth, currentDepth);
        }
        if(m.getFirstLevelManager() != null && m.getFirstLevelManager().getKey() != null){
            writer.setNextPropertyName("firstLevelManager");
            encoder0.encode(writer, m.getFirstLevelManager(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("escalated");
        encoder0.encode(writer, m.isEscalated());
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("maxValueForAlert");
        encoder0.encode(writer, m.getMaxValueForAlert());
        writer.setNextPropertyName("minValueForAlert");
        encoder0.encode(writer, m.getMinValueForAlert());
        if(m.getSecondLevelManager() != null && m.getSecondLevelManager().getKey() != null){
            writer.setNextPropertyName("secondLevelManager");
            encoder0.encode(writer, m.getSecondLevelManager(), maxDepth, currentDepth);
        }
        if(m.getShiftRef() != null && m.getShiftRef().getKey() != null){
            writer.setNextPropertyName("shiftRef");
            encoder0.encode(writer, m.getShiftRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("targetValues");
        encoder0.encode(writer, m.getTargetValues());
        writer.setNextPropertyName("toleranceLevelForEscalation");
        encoder0.encode(writer, m.getToleranceLevelForEscalation());
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
    protected com.adviteya.model.MA_Alert jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Alert m = new com.adviteya.model.MA_Alert();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("actualValues");
        m.setActualValues(decoder0.decode(reader, m.getActualValues()));
        reader = rootReader.newObjectReader("alertMeans");
        m.setAlertMeans(decoder0.decode(reader, m.getAlertMeans()));
        reader = rootReader.newObjectReader("alertTypeRef");
        decoder0.decode(reader, m.getAlertTypeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("companyref");
        decoder0.decode(reader, m.getCompanyref(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("firstLevelManager");
        decoder0.decode(reader, m.getFirstLevelManager(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("escalated");
        m.setEscalated(decoder0.decode(reader, m.isEscalated()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("maxValueForAlert");
        m.setMaxValueForAlert(decoder0.decode(reader, m.getMaxValueForAlert()));
        reader = rootReader.newObjectReader("minValueForAlert");
        m.setMinValueForAlert(decoder0.decode(reader, m.getMinValueForAlert()));
        reader = rootReader.newObjectReader("secondLevelManager");
        decoder0.decode(reader, m.getSecondLevelManager(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("shiftRef");
        decoder0.decode(reader, m.getShiftRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("targetValues");
        m.setTargetValues(decoder0.decode(reader, m.getTargetValues()));
        reader = rootReader.newObjectReader("toleranceLevelForEscalation");
        m.setToleranceLevelForEscalation(decoder0.decode(reader, m.getToleranceLevelForEscalation()));
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