package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:11")
/** */
public final class MA_AssignmentMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Assignment> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Assignment, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Department>, com.adviteya.model.MA_Department> deptRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Assignment, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Department>, com.adviteya.model.MA_Department>(this, "deptRef", "deptRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Department.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Assignment, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> employeeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Assignment, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "employeeRef", "employeeRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date> endDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date>(this, "endDate", "endDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Assignment, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift> shiftRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Assignment, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift>(this, "shiftRef", "shiftRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Shift.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date> startDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date>(this, "startDate", "startDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.lang.Integer> status = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.lang.Integer>(this, "status", "status", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Assignment> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Assignment>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Assignment> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Assignment>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Assignment, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_AssignmentMeta slim3_singleton = new MA_AssignmentMeta();

    /**
     * @return the singleton
     */
    public static MA_AssignmentMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_AssignmentMeta() {
        super("MA_Assignment", com.adviteya.model.MA_Assignment.class);
    }

    @Override
    public com.adviteya.model.MA_Assignment entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Assignment model = new com.adviteya.model.MA_Assignment();
        if (model.getDeptRef() == null) {
            throw new NullPointerException("The property(deptRef) is null.");
        }
        model.getDeptRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("deptRef"));
        if (model.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) is null.");
        }
        model.getEmployeeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("employeeRef"));
        model.setEndDate((java.util.Date) entity.getProperty("endDate"));
        if (model.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) is null.");
        }
        model.getShiftRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("shiftRef"));
        model.setStartDate((java.util.Date) entity.getProperty("startDate"));
        model.setStatus(longToPrimitiveInt((java.lang.Long) entity.getProperty("status")));
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
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getDeptRef() == null) {
            throw new NullPointerException("The property(deptRef) must not be null.");
        }
        entity.setProperty("deptRef", m.getDeptRef().getKey());
        if (m.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) must not be null.");
        }
        entity.setProperty("employeeRef", m.getEmployeeRef().getKey());
        entity.setProperty("endDate", m.getEndDate());
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        entity.setProperty("shiftRef", m.getShiftRef().getKey());
        entity.setProperty("startDate", m.getStartDate());
        entity.setProperty("status", m.getStatus());
        entity.setProperty("createdBy", m.getCreatedBy());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("updatedBy", m.getUpdatedBy());
        entity.setProperty("updatedDate", m.getUpdatedDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 2);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        if (m.getDeptRef() == null) {
            throw new NullPointerException("The property(deptRef) must not be null.");
        }
        m.getDeptRef().assignKeyIfNecessary(ds);
        if (m.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) must not be null.");
        }
        m.getEmployeeRef().assignKeyIfNecessary(ds);
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        m.getShiftRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
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
        com.adviteya.model.MA_Assignment m = (com.adviteya.model.MA_Assignment) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDeptRef() != null && m.getDeptRef().getKey() != null){
            writer.setNextPropertyName("deptRef");
            encoder0.encode(writer, m.getDeptRef(), maxDepth, currentDepth);
        }
        if(m.getEmployeeRef() != null && m.getEmployeeRef().getKey() != null){
            writer.setNextPropertyName("employeeRef");
            encoder0.encode(writer, m.getEmployeeRef(), maxDepth, currentDepth);
        }
        if(m.getEndDate() != null){
            writer.setNextPropertyName("endDate");
            encoder0.encode(writer, m.getEndDate());
        }
        if(m.getShiftRef() != null && m.getShiftRef().getKey() != null){
            writer.setNextPropertyName("shiftRef");
            encoder0.encode(writer, m.getShiftRef(), maxDepth, currentDepth);
        }
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
        }
        writer.setNextPropertyName("status");
        encoder0.encode(writer, m.getStatus());
        if(m.getTimesheets() != null){
            writer.setNextPropertyName("timesheets");
            // com.adviteya.model.MA_Timesheet is not supported.
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
    protected com.adviteya.model.MA_Assignment jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Assignment m = new com.adviteya.model.MA_Assignment();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("deptRef");
        decoder0.decode(reader, m.getDeptRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("employeeRef");
        decoder0.decode(reader, m.getEmployeeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("endDate");
        m.setEndDate(decoder0.decode(reader, m.getEndDate()));
        reader = rootReader.newObjectReader("shiftRef");
        decoder0.decode(reader, m.getShiftRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
        reader = rootReader.newObjectReader("status");
        m.setStatus(decoder0.decode(reader, m.getStatus()));
        reader = rootReader.newObjectReader("timesheets");
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