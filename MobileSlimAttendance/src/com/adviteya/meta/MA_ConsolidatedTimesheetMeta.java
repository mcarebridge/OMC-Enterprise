package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:11")
/** */
public final class MA_ConsolidatedTimesheetMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_ConsolidatedTimesheet> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double> actualDailyEffort = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double>(this, "actualDailyEffort", "actualDailyEffort", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet> approvalResult = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet>(this, "approvalResult", "approvalResult");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet> approved = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet>(this, "approved", "approved");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Assignment>, com.adviteya.model.MA_Assignment> assignmentRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Assignment>, com.adviteya.model.MA_Assignment>(this, "assignmentRef", "assignmentRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Assignment.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double> billableEfforts = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double>(this, "billableEfforts", "billableEfforts", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Long> companyId = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Long>(this, "companyId", "companyId", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer> createDay = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer>(this, "createDay", "createDay", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer> createMonth = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer>(this, "createMonth", "createMonth", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer> createYear = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer>(this, "createYear", "createYear", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double> dailyEffort = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double>(this, "dailyEffort", "dailyEffort", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer> effortResult = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer>(this, "effortResult", "effortResult", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> empModelRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "empModelRef", "empModelRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date> inDateTime = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date>(this, "inDateTime", "inDateTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer> inTimeResult = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer>(this, "inTimeResult", "inTimeResult", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet> marker = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet>(this, "marker", "marker");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date> outDateTime = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date>(this, "outDateTime", "outDateTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer> outTimeResult = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Integer>(this, "outTimeResult", "outTimeResult", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double> overTime = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Double>(this, "overTime", "overTime", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift> shiftRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift>(this, "shiftRef", "shiftRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Shift.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet> timesheetRuleResult = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet>(this, "timesheetRuleResult", "timesheetRuleResult");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ConsolidatedTimesheet, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_ConsolidatedTimesheetMeta slim3_singleton = new MA_ConsolidatedTimesheetMeta();

    /**
     * @return the singleton
     */
    public static MA_ConsolidatedTimesheetMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_ConsolidatedTimesheetMeta() {
        super("MA_ConsolidatedTimesheet", com.adviteya.model.MA_ConsolidatedTimesheet.class);
    }

    @Override
    public com.adviteya.model.MA_ConsolidatedTimesheet entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_ConsolidatedTimesheet model = new com.adviteya.model.MA_ConsolidatedTimesheet();
        model.setActualDailyEffort((java.lang.Double) entity.getProperty("actualDailyEffort"));
        model.setApprovalResult((java.lang.String) entity.getProperty("approvalResult"));
        model.setApproved((java.lang.String) entity.getProperty("approved"));
        if (model.getAssignmentRef() == null) {
            throw new NullPointerException("The property(assignmentRef) is null.");
        }
        model.getAssignmentRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("assignmentRef"));
        model.setBillableEfforts((java.lang.Double) entity.getProperty("billableEfforts"));
        model.setCompanyId((java.lang.Long) entity.getProperty("companyId"));
        model.setCreateDay(longToInteger((java.lang.Long) entity.getProperty("createDay")));
        model.setCreateMonth(longToInteger((java.lang.Long) entity.getProperty("createMonth")));
        model.setCreateYear(longToInteger((java.lang.Long) entity.getProperty("createYear")));
        model.setDailyEffort((java.lang.Double) entity.getProperty("dailyEffort"));
        model.setEffortResult(longToInteger((java.lang.Long) entity.getProperty("effortResult")));
        if (model.getEmpModelRef() == null) {
            throw new NullPointerException("The property(empModelRef) is null.");
        }
        model.getEmpModelRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("empModelRef"));
        model.setInDateTime((java.util.Date) entity.getProperty("inDateTime"));
        model.setInTimeResult(longToInteger((java.lang.Long) entity.getProperty("inTimeResult")));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setMarker((java.lang.String) entity.getProperty("marker"));
        model.setOutDateTime((java.util.Date) entity.getProperty("outDateTime"));
        model.setOutTimeResult(longToInteger((java.lang.Long) entity.getProperty("outTimeResult")));
        model.setOverTime((java.lang.Double) entity.getProperty("overTime"));
        if (model.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) is null.");
        }
        model.getShiftRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("shiftRef"));
        model.setTimesheetRuleResult((java.lang.String) entity.getProperty("timesheetRuleResult"));
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
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("actualDailyEffort", m.getActualDailyEffort());
        entity.setProperty("approvalResult", m.getApprovalResult());
        entity.setProperty("approved", m.getApproved());
        if (m.getAssignmentRef() == null) {
            throw new NullPointerException("The property(assignmentRef) must not be null.");
        }
        entity.setProperty("assignmentRef", m.getAssignmentRef().getKey());
        entity.setProperty("billableEfforts", m.getBillableEfforts());
        entity.setProperty("companyId", m.getCompanyId());
        entity.setProperty("createDay", m.getCreateDay());
        entity.setProperty("createMonth", m.getCreateMonth());
        entity.setProperty("createYear", m.getCreateYear());
        entity.setProperty("dailyEffort", m.getDailyEffort());
        entity.setProperty("effortResult", m.getEffortResult());
        if (m.getEmpModelRef() == null) {
            throw new NullPointerException("The property(empModelRef) must not be null.");
        }
        entity.setProperty("empModelRef", m.getEmpModelRef().getKey());
        entity.setProperty("inDateTime", m.getInDateTime());
        entity.setProperty("inTimeResult", m.getInTimeResult());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("marker", m.getMarker());
        entity.setProperty("outDateTime", m.getOutDateTime());
        entity.setProperty("outTimeResult", m.getOutTimeResult());
        entity.setProperty("overTime", m.getOverTime());
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        entity.setProperty("shiftRef", m.getShiftRef().getKey());
        entity.setProperty("timesheetRuleResult", m.getTimesheetRuleResult());
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
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        if (m.getAssignmentRef() == null) {
            throw new NullPointerException("The property(assignmentRef) must not be null.");
        }
        m.getAssignmentRef().assignKeyIfNecessary(ds);
        if (m.getEmpModelRef() == null) {
            throw new NullPointerException("The property(empModelRef) must not be null.");
        }
        m.getEmpModelRef().assignKeyIfNecessary(ds);
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        m.getLocationRef().assignKeyIfNecessary(ds);
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        m.getShiftRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
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
        com.adviteya.model.MA_ConsolidatedTimesheet m = (com.adviteya.model.MA_ConsolidatedTimesheet) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActualDailyEffort() != null){
            writer.setNextPropertyName("actualDailyEffort");
            encoder0.encode(writer, m.getActualDailyEffort());
        }
        if(m.getApprovalResult() != null){
            writer.setNextPropertyName("approvalResult");
            encoder0.encode(writer, m.getApprovalResult());
        }
        if(m.getApproved() != null){
            writer.setNextPropertyName("approved");
            encoder0.encode(writer, m.getApproved());
        }
        if(m.getAssignmentRef() != null && m.getAssignmentRef().getKey() != null){
            writer.setNextPropertyName("assignmentRef");
            encoder0.encode(writer, m.getAssignmentRef(), maxDepth, currentDepth);
        }
        if(m.getBillableEfforts() != null){
            writer.setNextPropertyName("billableEfforts");
            encoder0.encode(writer, m.getBillableEfforts());
        }
        if(m.getCompanyId() != null){
            writer.setNextPropertyName("companyId");
            encoder0.encode(writer, m.getCompanyId());
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
        if(m.getDailyEffort() != null){
            writer.setNextPropertyName("dailyEffort");
            encoder0.encode(writer, m.getDailyEffort());
        }
        if(m.getEffortResult() != null){
            writer.setNextPropertyName("effortResult");
            encoder0.encode(writer, m.getEffortResult());
        }
        if(m.getEmpModelRef() != null && m.getEmpModelRef().getKey() != null){
            writer.setNextPropertyName("empModelRef");
            encoder0.encode(writer, m.getEmpModelRef(), maxDepth, currentDepth);
        }
        if(m.getInDateTime() != null){
            writer.setNextPropertyName("inDateTime");
            encoder0.encode(writer, m.getInDateTime());
        }
        if(m.getInTimeResult() != null){
            writer.setNextPropertyName("inTimeResult");
            encoder0.encode(writer, m.getInTimeResult());
        }
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
        }
        if(m.getMarker() != null){
            writer.setNextPropertyName("marker");
            encoder0.encode(writer, m.getMarker());
        }
        if(m.getOutDateTime() != null){
            writer.setNextPropertyName("outDateTime");
            encoder0.encode(writer, m.getOutDateTime());
        }
        if(m.getOutTimeResult() != null){
            writer.setNextPropertyName("outTimeResult");
            encoder0.encode(writer, m.getOutTimeResult());
        }
        if(m.getOverTime() != null){
            writer.setNextPropertyName("overTime");
            encoder0.encode(writer, m.getOverTime());
        }
        if(m.getSecondsToHHMM() != null){
            writer.setNextPropertyName("secondsToHHMM");
            encoder0.encode(writer, m.getSecondsToHHMM());
        }
        if(m.getShiftRef() != null && m.getShiftRef().getKey() != null){
            writer.setNextPropertyName("shiftRef");
            encoder0.encode(writer, m.getShiftRef(), maxDepth, currentDepth);
        }
        if(m.getTimesheetRuleResult() != null){
            writer.setNextPropertyName("timesheetRuleResult");
            encoder0.encode(writer, m.getTimesheetRuleResult());
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
    protected com.adviteya.model.MA_ConsolidatedTimesheet jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_ConsolidatedTimesheet m = new com.adviteya.model.MA_ConsolidatedTimesheet();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("actualDailyEffort");
        m.setActualDailyEffort(decoder0.decode(reader, m.getActualDailyEffort()));
        reader = rootReader.newObjectReader("approvalResult");
        m.setApprovalResult(decoder0.decode(reader, m.getApprovalResult()));
        reader = rootReader.newObjectReader("approved");
        m.setApproved(decoder0.decode(reader, m.getApproved()));
        reader = rootReader.newObjectReader("assignmentRef");
        decoder0.decode(reader, m.getAssignmentRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("billableEfforts");
        m.setBillableEfforts(decoder0.decode(reader, m.getBillableEfforts()));
        reader = rootReader.newObjectReader("companyId");
        m.setCompanyId(decoder0.decode(reader, m.getCompanyId()));
        reader = rootReader.newObjectReader("createDay");
        m.setCreateDay(decoder0.decode(reader, m.getCreateDay()));
        reader = rootReader.newObjectReader("createMonth");
        m.setCreateMonth(decoder0.decode(reader, m.getCreateMonth()));
        reader = rootReader.newObjectReader("createYear");
        m.setCreateYear(decoder0.decode(reader, m.getCreateYear()));
        reader = rootReader.newObjectReader("dailyEffort");
        m.setDailyEffort(decoder0.decode(reader, m.getDailyEffort()));
        reader = rootReader.newObjectReader("effortResult");
        m.setEffortResult(decoder0.decode(reader, m.getEffortResult()));
        reader = rootReader.newObjectReader("empModelRef");
        decoder0.decode(reader, m.getEmpModelRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("inDateTime");
        m.setInDateTime(decoder0.decode(reader, m.getInDateTime()));
        reader = rootReader.newObjectReader("inTimeResult");
        m.setInTimeResult(decoder0.decode(reader, m.getInTimeResult()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("marker");
        m.setMarker(decoder0.decode(reader, m.getMarker()));
        reader = rootReader.newObjectReader("outDateTime");
        m.setOutDateTime(decoder0.decode(reader, m.getOutDateTime()));
        reader = rootReader.newObjectReader("outTimeResult");
        m.setOutTimeResult(decoder0.decode(reader, m.getOutTimeResult()));
        reader = rootReader.newObjectReader("overTime");
        m.setOverTime(decoder0.decode(reader, m.getOverTime()));
        reader = rootReader.newObjectReader("secondsToHHMM");
        m.setSecondsToHHMM(decoder0.decode(reader, m.getSecondsToHHMM()));
        reader = rootReader.newObjectReader("shiftRef");
        decoder0.decode(reader, m.getShiftRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("timesheetRuleResult");
        m.setTimesheetRuleResult(decoder0.decode(reader, m.getTimesheetRuleResult()));
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