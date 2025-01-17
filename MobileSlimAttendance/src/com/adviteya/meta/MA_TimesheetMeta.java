package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:06")
/** */
public final class MA_TimesheetMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Timesheet> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Timesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Assignment>, com.adviteya.model.MA_Assignment> assignmentRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Timesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Assignment>, com.adviteya.model.MA_Assignment>(this, "assignmentRef", "assignmentRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Assignment.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, com.google.appengine.api.datastore.GeoPt> attendanceCoordinates = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, com.google.appengine.api.datastore.GeoPt>(this, "attendanceCoordinates", "attendanceCoordinates", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, com.google.appengine.api.datastore.GeoPt> attendanceCoordinatesOut = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, com.google.appengine.api.datastore.GeoPt>(this, "attendanceCoordinatesOut", "attendanceCoordinatesOut", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer> count = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer>(this, "count", "count", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer> createDay = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer>(this, "createDay", "createDay", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer> createMonth = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer>(this, "createMonth", "createMonth", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer> createYear = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Integer>(this, "createYear", "createYear", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Double> dailyEffort = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Double>(this, "dailyEffort", "dailyEffort", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Double> geoPtAccuracy = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Double>(this, "geoPtAccuracy", "geoPtAccuracy", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Double> geoPtAccuracyOut = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Double>(this, "geoPtAccuracyOut", "geoPtAccuracyOut", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet> imeiCode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet>(this, "imeiCode", "imeiCode");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date> inDateTime = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date>(this, "inDateTime", "inDateTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet> inMode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet>(this, "inMode", "inMode");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Timesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Timesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet> marker = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet>(this, "marker", "marker");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date> outDateTime = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date>(this, "outDateTime", "outDateTime", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet> outMode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet>(this, "outMode", "outMode");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Timesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift> shiftRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Timesheet, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Shift>, com.adviteya.model.MA_Shift>(this, "shiftRef", "shiftRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Shift.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Timesheet>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Timesheet, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_TimesheetMeta slim3_singleton = new MA_TimesheetMeta();

    /**
     * @return the singleton
     */
    public static MA_TimesheetMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_TimesheetMeta() {
        super("MA_Timesheet", com.adviteya.model.MA_Timesheet.class);
    }

    @Override
    public com.adviteya.model.MA_Timesheet entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Timesheet model = new com.adviteya.model.MA_Timesheet();
        if (model.getAssignmentRef() == null) {
            throw new NullPointerException("The property(assignmentRef) is null.");
        }
        model.getAssignmentRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("assignmentRef"));
        model.setAttendanceCoordinates((com.google.appengine.api.datastore.GeoPt) entity.getProperty("attendanceCoordinates"));
        model.setAttendanceCoordinatesOut((com.google.appengine.api.datastore.GeoPt) entity.getProperty("attendanceCoordinatesOut"));
        model.setCount(longToInteger((java.lang.Long) entity.getProperty("count")));
        model.setCreateDay(longToInteger((java.lang.Long) entity.getProperty("createDay")));
        model.setCreateMonth(longToInteger((java.lang.Long) entity.getProperty("createMonth")));
        model.setCreateYear(longToInteger((java.lang.Long) entity.getProperty("createYear")));
        model.setDailyEffort((java.lang.Double) entity.getProperty("dailyEffort"));
        model.setGeoPtAccuracy((java.lang.Double) entity.getProperty("geoPtAccuracy"));
        model.setGeoPtAccuracyOut((java.lang.Double) entity.getProperty("geoPtAccuracyOut"));
        model.setImeiCode((java.lang.String) entity.getProperty("imeiCode"));
        model.setInDateTime((java.util.Date) entity.getProperty("inDateTime"));
        model.setInMode((java.lang.String) entity.getProperty("inMode"));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setMarker((java.lang.String) entity.getProperty("marker"));
        model.setOutDateTime((java.util.Date) entity.getProperty("outDateTime"));
        model.setOutMode((java.lang.String) entity.getProperty("outMode"));
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
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getAssignmentRef() == null) {
            throw new NullPointerException("The property(assignmentRef) must not be null.");
        }
        entity.setProperty("assignmentRef", m.getAssignmentRef().getKey());
        entity.setProperty("attendanceCoordinates", m.getAttendanceCoordinates());
        entity.setProperty("attendanceCoordinatesOut", m.getAttendanceCoordinatesOut());
        entity.setProperty("count", m.getCount());
        entity.setProperty("createDay", m.getCreateDay());
        entity.setProperty("createMonth", m.getCreateMonth());
        entity.setProperty("createYear", m.getCreateYear());
        entity.setProperty("dailyEffort", m.getDailyEffort());
        entity.setProperty("geoPtAccuracy", m.getGeoPtAccuracy());
        entity.setProperty("geoPtAccuracyOut", m.getGeoPtAccuracyOut());
        entity.setProperty("imeiCode", m.getImeiCode());
        entity.setProperty("inDateTime", m.getInDateTime());
        entity.setProperty("inMode", m.getInMode());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("marker", m.getMarker());
        entity.setProperty("outDateTime", m.getOutDateTime());
        entity.setProperty("outMode", m.getOutMode());
        if (m.getShiftRef() == null) {
            throw new NullPointerException("The property(shiftRef) must not be null.");
        }
        entity.setProperty("shiftRef", m.getShiftRef().getKey());
        entity.setProperty("createdBy", m.getCreatedBy());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("updatedBy", m.getUpdatedBy());
        entity.setProperty("updatedDate", m.getUpdatedDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 4);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        if (m.getAssignmentRef() == null) {
            throw new NullPointerException("The property(assignmentRef) must not be null.");
        }
        m.getAssignmentRef().assignKeyIfNecessary(ds);
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
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
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
        com.adviteya.model.MA_Timesheet m = (com.adviteya.model.MA_Timesheet) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAssignmentRef() != null && m.getAssignmentRef().getKey() != null){
            writer.setNextPropertyName("assignmentRef");
            encoder0.encode(writer, m.getAssignmentRef(), maxDepth, currentDepth);
        }
        if(m.getAttendanceCoordinates() != null){
            writer.setNextPropertyName("attendanceCoordinates");
            encoder0.encode(writer, m.getAttendanceCoordinates());
        }
        if(m.getAttendanceCoordinatesOut() != null){
            writer.setNextPropertyName("attendanceCoordinatesOut");
            encoder0.encode(writer, m.getAttendanceCoordinatesOut());
        }
        if(m.getCount() != null){
            writer.setNextPropertyName("count");
            encoder0.encode(writer, m.getCount());
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
        if(m.getEmpCompanyId() != null){
            writer.setNextPropertyName("empCompanyId");
            encoder0.encode(writer, m.getEmpCompanyId());
        }
        if(m.getGeoPtAccuracy() != null){
            writer.setNextPropertyName("geoPtAccuracy");
            encoder0.encode(writer, m.getGeoPtAccuracy());
        }
        if(m.getGeoPtAccuracyOut() != null){
            writer.setNextPropertyName("geoPtAccuracyOut");
            encoder0.encode(writer, m.getGeoPtAccuracyOut());
        }
        if(m.getImeiCode() != null){
            writer.setNextPropertyName("imeiCode");
            encoder0.encode(writer, m.getImeiCode());
        }
        if(m.getInDateTime() != null){
            writer.setNextPropertyName("inDateTime");
            encoder0.encode(writer, m.getInDateTime());
        }
        if(m.getInMode() != null){
            writer.setNextPropertyName("inMode");
            encoder0.encode(writer, m.getInMode());
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
        if(m.getOutMode() != null){
            writer.setNextPropertyName("outMode");
            encoder0.encode(writer, m.getOutMode());
        }
        if(m.getSecondsToHHMM() != null){
            writer.setNextPropertyName("secondsToHHMM");
            encoder0.encode(writer, m.getSecondsToHHMM());
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
    protected com.adviteya.model.MA_Timesheet jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Timesheet m = new com.adviteya.model.MA_Timesheet();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("assignmentRef");
        decoder0.decode(reader, m.getAssignmentRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("attendanceCoordinates");
        m.setAttendanceCoordinates(decoder0.decode(reader, m.getAttendanceCoordinates()));
        reader = rootReader.newObjectReader("attendanceCoordinatesOut");
        m.setAttendanceCoordinatesOut(decoder0.decode(reader, m.getAttendanceCoordinatesOut()));
        reader = rootReader.newObjectReader("count");
        m.setCount(decoder0.decode(reader, m.getCount()));
        reader = rootReader.newObjectReader("createDay");
        m.setCreateDay(decoder0.decode(reader, m.getCreateDay()));
        reader = rootReader.newObjectReader("createMonth");
        m.setCreateMonth(decoder0.decode(reader, m.getCreateMonth()));
        reader = rootReader.newObjectReader("createYear");
        m.setCreateYear(decoder0.decode(reader, m.getCreateYear()));
        reader = rootReader.newObjectReader("dailyEffort");
        m.setDailyEffort(decoder0.decode(reader, m.getDailyEffort()));
        reader = rootReader.newObjectReader("empCompanyId");
        m.setEmpCompanyId(decoder0.decode(reader, m.getEmpCompanyId()));
        reader = rootReader.newObjectReader("geoPtAccuracy");
        m.setGeoPtAccuracy(decoder0.decode(reader, m.getGeoPtAccuracy()));
        reader = rootReader.newObjectReader("geoPtAccuracyOut");
        m.setGeoPtAccuracyOut(decoder0.decode(reader, m.getGeoPtAccuracyOut()));
        reader = rootReader.newObjectReader("imeiCode");
        m.setImeiCode(decoder0.decode(reader, m.getImeiCode()));
        reader = rootReader.newObjectReader("inDateTime");
        m.setInDateTime(decoder0.decode(reader, m.getInDateTime()));
        reader = rootReader.newObjectReader("inMode");
        m.setInMode(decoder0.decode(reader, m.getInMode()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("marker");
        m.setMarker(decoder0.decode(reader, m.getMarker()));
        reader = rootReader.newObjectReader("outDateTime");
        m.setOutDateTime(decoder0.decode(reader, m.getOutDateTime()));
        reader = rootReader.newObjectReader("outMode");
        m.setOutMode(decoder0.decode(reader, m.getOutMode()));
        reader = rootReader.newObjectReader("secondsToHHMM");
        m.setSecondsToHHMM(decoder0.decode(reader, m.getSecondsToHHMM()));
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