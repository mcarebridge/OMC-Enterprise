package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:08")
/** */
public final class MA_EscalationHierarchyMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_EscalationHierarchy> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy>(this, "active", "active");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy> city = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy>(this, "city", "city");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> managerEmp = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "managerEmp", "managerEmp", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> reporteeEmp = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "reporteeEmp", "reporteeEmp", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_EscalationHierarchy>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_EscalationHierarchy, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_EscalationHierarchyMeta slim3_singleton = new MA_EscalationHierarchyMeta();

    /**
     * @return the singleton
     */
    public static MA_EscalationHierarchyMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_EscalationHierarchyMeta() {
        super("MA_EscalationHierarchy", com.adviteya.model.MA_EscalationHierarchy.class);
    }

    @Override
    public com.adviteya.model.MA_EscalationHierarchy entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_EscalationHierarchy model = new com.adviteya.model.MA_EscalationHierarchy();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setCity((java.lang.String) entity.getProperty("city"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        if (model.getManagerEmp() == null) {
            throw new NullPointerException("The property(managerEmp) is null.");
        }
        model.getManagerEmp().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("managerEmp"));
        if (model.getReporteeEmp() == null) {
            throw new NullPointerException("The property(reporteeEmp) is null.");
        }
        model.getReporteeEmp().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("reporteeEmp"));
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
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setProperty("city", m.getCity());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        if (m.getManagerEmp() == null) {
            throw new NullPointerException("The property(managerEmp) must not be null.");
        }
        entity.setProperty("managerEmp", m.getManagerEmp().getKey());
        if (m.getReporteeEmp() == null) {
            throw new NullPointerException("The property(reporteeEmp) must not be null.");
        }
        entity.setProperty("reporteeEmp", m.getReporteeEmp().getKey());
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
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getManagerEmp() == null) {
            throw new NullPointerException("The property(managerEmp) must not be null.");
        }
        m.getManagerEmp().assignKeyIfNecessary(ds);
        if (m.getReporteeEmp() == null) {
            throw new NullPointerException("The property(reporteeEmp) must not be null.");
        }
        m.getReporteeEmp().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
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
        com.adviteya.model.MA_EscalationHierarchy m = (com.adviteya.model.MA_EscalationHierarchy) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getCity() != null){
            writer.setNextPropertyName("city");
            encoder0.encode(writer, m.getCity());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getManagerEmp() != null && m.getManagerEmp().getKey() != null){
            writer.setNextPropertyName("managerEmp");
            encoder0.encode(writer, m.getManagerEmp(), maxDepth, currentDepth);
        }
        if(m.getReporteeEmp() != null && m.getReporteeEmp().getKey() != null){
            writer.setNextPropertyName("reporteeEmp");
            encoder0.encode(writer, m.getReporteeEmp(), maxDepth, currentDepth);
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
    protected com.adviteya.model.MA_EscalationHierarchy jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_EscalationHierarchy m = new com.adviteya.model.MA_EscalationHierarchy();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("city");
        m.setCity(decoder0.decode(reader, m.getCity()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("managerEmp");
        decoder0.decode(reader, m.getManagerEmp(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("reporteeEmp");
        decoder0.decode(reader, m.getReporteeEmp(), maxDepth, currentDepth);
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