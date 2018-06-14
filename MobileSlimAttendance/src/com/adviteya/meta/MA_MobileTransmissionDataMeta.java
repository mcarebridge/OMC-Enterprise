package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:07")
/** */
public final class MA_MobileTransmissionDataMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_MobileTransmissionData> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> action = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "action", "action");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.GeoPt> attendanceCoordinates = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.GeoPt>(this, "attendanceCoordinates", "attendanceCoordinates", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer> createDay = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer>(this, "createDay", "createDay", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer> createMonth = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer>(this, "createMonth", "createMonth", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer> createYear = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer>(this, "createYear", "createYear", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> employeeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "employeeRef", "employeeRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Double> geoPtAccuracy = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Double>(this, "geoPtAccuracy", "geoPtAccuracy", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> imeiCode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "imeiCode", "imeiCode");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> logError = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "logError", "logError");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer> recordsReceived = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer>(this, "recordsReceived", "recordsReceived", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer> recordsSend = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Integer>(this, "recordsSend", "recordsSend", int.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.Text> requestData = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.Text>(this, "requestData", "requestData", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.Text> responseData = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.Text>(this, "responseData", "responseData", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Long> responseTime = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Long>(this, "responseTime", "responseTime", long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> state = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "state", "state");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> status = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "status", "status");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_MobileTransmissionData>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_MobileTransmissionData, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_MobileTransmissionDataMeta slim3_singleton = new MA_MobileTransmissionDataMeta();

    /**
     * @return the singleton
     */
    public static MA_MobileTransmissionDataMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_MobileTransmissionDataMeta() {
        super("MA_MobileTransmissionData", com.adviteya.model.MA_MobileTransmissionData.class);
    }

    @Override
    public com.adviteya.model.MA_MobileTransmissionData entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_MobileTransmissionData model = new com.adviteya.model.MA_MobileTransmissionData();
        model.setAction((java.lang.String) entity.getProperty("action"));
        model.setAttendanceCoordinates((com.google.appengine.api.datastore.GeoPt) entity.getProperty("attendanceCoordinates"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setCreateDay(longToPrimitiveInt((java.lang.Long) entity.getProperty("createDay")));
        model.setCreateMonth(longToPrimitiveInt((java.lang.Long) entity.getProperty("createMonth")));
        model.setCreateYear(longToPrimitiveInt((java.lang.Long) entity.getProperty("createYear")));
        if (model.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) is null.");
        }
        model.getEmployeeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("employeeRef"));
        model.setGeoPtAccuracy((java.lang.Double) entity.getProperty("geoPtAccuracy"));
        model.setImeiCode((java.lang.String) entity.getProperty("imeiCode"));
        model.setLogError((java.lang.String) entity.getProperty("logError"));
        model.setRecordsReceived(longToPrimitiveInt((java.lang.Long) entity.getProperty("recordsReceived")));
        model.setRecordsSend(longToPrimitiveInt((java.lang.Long) entity.getProperty("recordsSend")));
        model.setRequestData((com.google.appengine.api.datastore.Text) entity.getProperty("requestData"));
        model.setResponseData((com.google.appengine.api.datastore.Text) entity.getProperty("responseData"));
        model.setResponseTime(longToPrimitiveLong((java.lang.Long) entity.getProperty("responseTime")));
        model.setState((java.lang.String) entity.getProperty("state"));
        model.setStatus((java.lang.String) entity.getProperty("status"));
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
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("action", m.getAction());
        entity.setProperty("attendanceCoordinates", m.getAttendanceCoordinates());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("createDay", m.getCreateDay());
        entity.setProperty("createMonth", m.getCreateMonth());
        entity.setProperty("createYear", m.getCreateYear());
        if (m.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) must not be null.");
        }
        entity.setProperty("employeeRef", m.getEmployeeRef().getKey());
        entity.setProperty("geoPtAccuracy", m.getGeoPtAccuracy());
        entity.setProperty("imeiCode", m.getImeiCode());
        entity.setProperty("logError", m.getLogError());
        entity.setProperty("recordsReceived", m.getRecordsReceived());
        entity.setProperty("recordsSend", m.getRecordsSend());
        entity.setUnindexedProperty("requestData", m.getRequestData());
        entity.setUnindexedProperty("responseData", m.getResponseData());
        entity.setProperty("responseTime", m.getResponseTime());
        entity.setProperty("state", m.getState());
        entity.setProperty("status", m.getStatus());
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
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) must not be null.");
        }
        m.getEmployeeRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
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
        com.adviteya.model.MA_MobileTransmissionData m = (com.adviteya.model.MA_MobileTransmissionData) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAction() != null){
            writer.setNextPropertyName("action");
            encoder0.encode(writer, m.getAction());
        }
        if(m.getAttendanceCoordinates() != null){
            writer.setNextPropertyName("attendanceCoordinates");
            encoder0.encode(writer, m.getAttendanceCoordinates());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("createDay");
        encoder0.encode(writer, m.getCreateDay());
        writer.setNextPropertyName("createMonth");
        encoder0.encode(writer, m.getCreateMonth());
        writer.setNextPropertyName("createYear");
        encoder0.encode(writer, m.getCreateYear());
        if(m.getEmployeeRef() != null && m.getEmployeeRef().getKey() != null){
            writer.setNextPropertyName("employeeRef");
            encoder0.encode(writer, m.getEmployeeRef(), maxDepth, currentDepth);
        }
        if(m.getGeoPtAccuracy() != null){
            writer.setNextPropertyName("geoPtAccuracy");
            encoder0.encode(writer, m.getGeoPtAccuracy());
        }
        if(m.getImeiCode() != null){
            writer.setNextPropertyName("imeiCode");
            encoder0.encode(writer, m.getImeiCode());
        }
        if(m.getLogError() != null){
            writer.setNextPropertyName("logError");
            encoder0.encode(writer, m.getLogError());
        }
        writer.setNextPropertyName("recordsReceived");
        encoder0.encode(writer, m.getRecordsReceived());
        writer.setNextPropertyName("recordsSend");
        encoder0.encode(writer, m.getRecordsSend());
        if(m.getRequestData() != null && m.getRequestData().getValue() != null){
            writer.setNextPropertyName("requestData");
            encoder0.encode(writer, m.getRequestData());
        }
        if(m.getResponseData() != null && m.getResponseData().getValue() != null){
            writer.setNextPropertyName("responseData");
            encoder0.encode(writer, m.getResponseData());
        }
        writer.setNextPropertyName("responseTime");
        encoder0.encode(writer, m.getResponseTime());
        if(m.getState() != null){
            writer.setNextPropertyName("state");
            encoder0.encode(writer, m.getState());
        }
        if(m.getStatus() != null){
            writer.setNextPropertyName("status");
            encoder0.encode(writer, m.getStatus());
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
    protected com.adviteya.model.MA_MobileTransmissionData jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_MobileTransmissionData m = new com.adviteya.model.MA_MobileTransmissionData();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("action");
        m.setAction(decoder0.decode(reader, m.getAction()));
        reader = rootReader.newObjectReader("attendanceCoordinates");
        m.setAttendanceCoordinates(decoder0.decode(reader, m.getAttendanceCoordinates()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("createDay");
        m.setCreateDay(decoder0.decode(reader, m.getCreateDay()));
        reader = rootReader.newObjectReader("createMonth");
        m.setCreateMonth(decoder0.decode(reader, m.getCreateMonth()));
        reader = rootReader.newObjectReader("createYear");
        m.setCreateYear(decoder0.decode(reader, m.getCreateYear()));
        reader = rootReader.newObjectReader("employeeRef");
        decoder0.decode(reader, m.getEmployeeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("geoPtAccuracy");
        m.setGeoPtAccuracy(decoder0.decode(reader, m.getGeoPtAccuracy()));
        reader = rootReader.newObjectReader("imeiCode");
        m.setImeiCode(decoder0.decode(reader, m.getImeiCode()));
        reader = rootReader.newObjectReader("logError");
        m.setLogError(decoder0.decode(reader, m.getLogError()));
        reader = rootReader.newObjectReader("recordsReceived");
        m.setRecordsReceived(decoder0.decode(reader, m.getRecordsReceived()));
        reader = rootReader.newObjectReader("recordsSend");
        m.setRecordsSend(decoder0.decode(reader, m.getRecordsSend()));
        reader = rootReader.newObjectReader("requestData");
        m.setRequestData(decoder0.decode(reader, m.getRequestData()));
        reader = rootReader.newObjectReader("responseData");
        m.setResponseData(decoder0.decode(reader, m.getResponseData()));
        reader = rootReader.newObjectReader("responseTime");
        m.setResponseTime(decoder0.decode(reader, m.getResponseTime()));
        reader = rootReader.newObjectReader("state");
        m.setState(decoder0.decode(reader, m.getState()));
        reader = rootReader.newObjectReader("status");
        m.setStatus(decoder0.decode(reader, m.getStatus()));
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