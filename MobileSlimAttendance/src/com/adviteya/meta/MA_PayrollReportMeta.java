package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:07")
/** */
public final class MA_PayrollReportMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_PayrollReport> {

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_PayrollReport, com.google.appengine.api.datastore.Text> Report = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_PayrollReport, com.google.appengine.api.datastore.Text>(this, "Report", "Report", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_PayrollReport, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_PayrollReport, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date> endDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date>(this, "endDate", "endDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer> intervalNum = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer>(this, "intervalNum", "intervalNum", int.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_PayrollReport, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location> locationRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_PayrollReport, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Location>, com.adviteya.model.MA_Location>(this, "locationRef", "locationRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Location.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer> monthNo = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer>(this, "monthNo", "monthNo", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Long> noOfRecords = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Long>(this, "noOfRecords", "noOfRecords", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer> processFreq = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer>(this, "processFreq", "processFreq", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date> startDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date>(this, "startDate", "startDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer> year = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Integer>(this, "year", "year", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_PayrollReport> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_PayrollReport>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_PayrollReport> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_PayrollReport>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_PayrollReport, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_PayrollReportMeta slim3_singleton = new MA_PayrollReportMeta();

    /**
     * @return the singleton
     */
    public static MA_PayrollReportMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_PayrollReportMeta() {
        super("MA_PayrollReport", com.adviteya.model.MA_PayrollReport.class);
    }

    @Override
    public com.adviteya.model.MA_PayrollReport entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_PayrollReport model = new com.adviteya.model.MA_PayrollReport();
        model.setReport((com.google.appengine.api.datastore.Text) entity.getProperty("Report"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setEndDate((java.util.Date) entity.getProperty("endDate"));
        model.setIntervalNum(longToPrimitiveInt((java.lang.Long) entity.getProperty("intervalNum")));
        if (model.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) is null.");
        }
        model.getLocationRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("locationRef"));
        model.setMonthNo(longToPrimitiveInt((java.lang.Long) entity.getProperty("monthNo")));
        model.setNoOfRecords(longToPrimitiveLong((java.lang.Long) entity.getProperty("noOfRecords")));
        model.setProcessFreq(longToPrimitiveInt((java.lang.Long) entity.getProperty("processFreq")));
        model.setStartDate((java.util.Date) entity.getProperty("startDate"));
        model.setYear(longToPrimitiveInt((java.lang.Long) entity.getProperty("year")));
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
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("Report", m.getReport());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("endDate", m.getEndDate());
        entity.setProperty("intervalNum", m.getIntervalNum());
        if (m.getLocationRef() == null) {
            throw new NullPointerException("The property(locationRef) must not be null.");
        }
        entity.setProperty("locationRef", m.getLocationRef().getKey());
        entity.setProperty("monthNo", m.getMonthNo());
        entity.setProperty("noOfRecords", m.getNoOfRecords());
        entity.setProperty("processFreq", m.getProcessFreq());
        entity.setProperty("startDate", m.getStartDate());
        entity.setProperty("year", m.getYear());
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
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
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
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
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
        com.adviteya.model.MA_PayrollReport m = (com.adviteya.model.MA_PayrollReport) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getReport() != null && m.getReport().getValue() != null){
            writer.setNextPropertyName("Report");
            encoder0.encode(writer, m.getReport());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getEndDate() != null){
            writer.setNextPropertyName("endDate");
            encoder0.encode(writer, m.getEndDate());
        }
        writer.setNextPropertyName("intervalNum");
        encoder0.encode(writer, m.getIntervalNum());
        if(m.getLocationRef() != null && m.getLocationRef().getKey() != null){
            writer.setNextPropertyName("locationRef");
            encoder0.encode(writer, m.getLocationRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("monthNo");
        encoder0.encode(writer, m.getMonthNo());
        writer.setNextPropertyName("noOfRecords");
        encoder0.encode(writer, m.getNoOfRecords());
        writer.setNextPropertyName("processFreq");
        encoder0.encode(writer, m.getProcessFreq());
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
        }
        writer.setNextPropertyName("year");
        encoder0.encode(writer, m.getYear());
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
    protected com.adviteya.model.MA_PayrollReport jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_PayrollReport m = new com.adviteya.model.MA_PayrollReport();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("Report");
        m.setReport(decoder0.decode(reader, m.getReport()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("endDate");
        m.setEndDate(decoder0.decode(reader, m.getEndDate()));
        reader = rootReader.newObjectReader("intervalNum");
        m.setIntervalNum(decoder0.decode(reader, m.getIntervalNum()));
        reader = rootReader.newObjectReader("locationRef");
        decoder0.decode(reader, m.getLocationRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("monthNo");
        m.setMonthNo(decoder0.decode(reader, m.getMonthNo()));
        reader = rootReader.newObjectReader("noOfRecords");
        m.setNoOfRecords(decoder0.decode(reader, m.getNoOfRecords()));
        reader = rootReader.newObjectReader("processFreq");
        m.setProcessFreq(decoder0.decode(reader, m.getProcessFreq()));
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
        reader = rootReader.newObjectReader("year");
        m.setYear(decoder0.decode(reader, m.getYear()));
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