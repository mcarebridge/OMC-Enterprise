package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:05")
/** */
public final class MA_WeeklyPayrollReportMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_WeeklyPayrollReport> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.lang.Long> noOfRecords = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.lang.Long>(this, "noOfRecords", "noOfRecords", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date> weekEndDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date>(this, "weekEndDate", "weekEndDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.lang.Integer> weekNo = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.lang.Integer>(this, "weekNo", "weekNo", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date> weekStartDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date>(this, "weekStartDate", "weekStartDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, com.google.appengine.api.datastore.Text> weeklyReport = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, com.google.appengine.api.datastore.Text>(this, "weeklyReport", "weeklyReport", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_WeeklyPayrollReport, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_WeeklyPayrollReportMeta slim3_singleton = new MA_WeeklyPayrollReportMeta();

    /**
     * @return the singleton
     */
    public static MA_WeeklyPayrollReportMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_WeeklyPayrollReportMeta() {
        super("MA_WeeklyPayrollReport", com.adviteya.model.MA_WeeklyPayrollReport.class);
    }

    @Override
    public com.adviteya.model.MA_WeeklyPayrollReport entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_WeeklyPayrollReport model = new com.adviteya.model.MA_WeeklyPayrollReport();
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setNoOfRecords(longToPrimitiveLong((java.lang.Long) entity.getProperty("noOfRecords")));
        model.setWeekEndDate((java.util.Date) entity.getProperty("weekEndDate"));
        model.setWeekNo(longToPrimitiveInt((java.lang.Long) entity.getProperty("weekNo")));
        model.setWeekStartDate((java.util.Date) entity.getProperty("weekStartDate"));
        model.setWeeklyReport((com.google.appengine.api.datastore.Text) entity.getProperty("weeklyReport"));
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
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
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
        entity.setProperty("noOfRecords", m.getNoOfRecords());
        entity.setProperty("weekEndDate", m.getWeekEndDate());
        entity.setProperty("weekNo", m.getWeekNo());
        entity.setProperty("weekStartDate", m.getWeekStartDate());
        entity.setUnindexedProperty("weeklyReport", m.getWeeklyReport());
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
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
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
        com.adviteya.model.MA_WeeklyPayrollReport m = (com.adviteya.model.MA_WeeklyPayrollReport) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("noOfRecords");
        encoder0.encode(writer, m.getNoOfRecords());
        if(m.getWeekEndDate() != null){
            writer.setNextPropertyName("weekEndDate");
            encoder0.encode(writer, m.getWeekEndDate());
        }
        writer.setNextPropertyName("weekNo");
        encoder0.encode(writer, m.getWeekNo());
        if(m.getWeekStartDate() != null){
            writer.setNextPropertyName("weekStartDate");
            encoder0.encode(writer, m.getWeekStartDate());
        }
        if(m.getWeeklyReport() != null && m.getWeeklyReport().getValue() != null){
            writer.setNextPropertyName("weeklyReport");
            encoder0.encode(writer, m.getWeeklyReport());
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
    protected com.adviteya.model.MA_WeeklyPayrollReport jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_WeeklyPayrollReport m = new com.adviteya.model.MA_WeeklyPayrollReport();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("noOfRecords");
        m.setNoOfRecords(decoder0.decode(reader, m.getNoOfRecords()));
        reader = rootReader.newObjectReader("weekEndDate");
        m.setWeekEndDate(decoder0.decode(reader, m.getWeekEndDate()));
        reader = rootReader.newObjectReader("weekNo");
        m.setWeekNo(decoder0.decode(reader, m.getWeekNo()));
        reader = rootReader.newObjectReader("weekStartDate");
        m.setWeekStartDate(decoder0.decode(reader, m.getWeekStartDate()));
        reader = rootReader.newObjectReader("weeklyReport");
        m.setWeeklyReport(decoder0.decode(reader, m.getWeeklyReport()));
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