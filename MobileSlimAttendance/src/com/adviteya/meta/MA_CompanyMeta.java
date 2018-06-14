package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:11")
/** */
public final class MA_CompanyMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Company> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.lang.Boolean> accountVerified = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.lang.Boolean>(this, "accountVerified", "accountVerified", boolean.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "active", "active");

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_Company, com.google.appengine.api.datastore.Blob> companyLogo = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_Company, com.google.appengine.api.datastore.Blob>(this, "companyLogo", "companyLogo", com.google.appengine.api.datastore.Blob.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> companyName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "companyName", "companyName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.lang.Long> emplyoeePopulation = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.lang.Long>(this, "emplyoeePopulation", "emplyoeePopulation", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> logoFileName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "logoFileName", "logoFileName");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Company, org.slim3.datastore.ModelRef<com.adviteya.model.MA_NatureOfCompany>, com.adviteya.model.MA_NatureOfCompany> natureOfCompanyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Company, org.slim3.datastore.ModelRef<com.adviteya.model.MA_NatureOfCompany>, com.adviteya.model.MA_NatureOfCompany>(this, "natureOfCompanyRef", "natureOfCompanyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_NatureOfCompany.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Company, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Template>, com.adviteya.model.MA_Template> templateRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Company, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Template>, com.adviteya.model.MA_Template>(this, "templateRef", "templateRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Template.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> timeZone = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "timeZone", "timeZone");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> uniqueidFlag = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "uniqueidFlag", "uniqueidFlag");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Company>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Company, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_CompanyMeta slim3_singleton = new MA_CompanyMeta();

    /**
     * @return the singleton
     */
    public static MA_CompanyMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_CompanyMeta() {
        super("MA_Company", com.adviteya.model.MA_Company.class);
    }

    @Override
    public com.adviteya.model.MA_Company entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Company model = new com.adviteya.model.MA_Company();
        model.setAccountVerified(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("accountVerified")));
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setCompanyLogo((com.google.appengine.api.datastore.Blob) entity.getProperty("companyLogo"));
        model.setCompanyName((java.lang.String) entity.getProperty("companyName"));
        model.setEmplyoeePopulation((java.lang.Long) entity.getProperty("emplyoeePopulation"));
        model.setLogoFileName((java.lang.String) entity.getProperty("logoFileName"));
        if (model.getNatureOfCompanyRef() == null) {
            throw new NullPointerException("The property(natureOfCompanyRef) is null.");
        }
        model.getNatureOfCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("natureOfCompanyRef"));
        if (model.getTemplateRef() == null) {
            throw new NullPointerException("The property(templateRef) is null.");
        }
        model.getTemplateRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("templateRef"));
        model.setTimeZone((java.lang.String) entity.getProperty("timeZone"));
        model.setUniqueidFlag((java.lang.String) entity.getProperty("uniqueidFlag"));
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
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("accountVerified", m.isAccountVerified());
        entity.setProperty("active", m.getActive());
        entity.setProperty("companyLogo", m.getCompanyLogo());
        entity.setProperty("companyName", m.getCompanyName());
        entity.setProperty("emplyoeePopulation", m.getEmplyoeePopulation());
        entity.setProperty("logoFileName", m.getLogoFileName());
        if (m.getNatureOfCompanyRef() == null) {
            throw new NullPointerException("The property(natureOfCompanyRef) must not be null.");
        }
        entity.setProperty("natureOfCompanyRef", m.getNatureOfCompanyRef().getKey());
        if (m.getTemplateRef() == null) {
            throw new NullPointerException("The property(templateRef) must not be null.");
        }
        entity.setProperty("templateRef", m.getTemplateRef().getKey());
        entity.setProperty("timeZone", m.getTimeZone());
        entity.setProperty("uniqueidFlag", m.getUniqueidFlag());
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
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        if (m.getNatureOfCompanyRef() == null) {
            throw new NullPointerException("The property(natureOfCompanyRef) must not be null.");
        }
        m.getNatureOfCompanyRef().assignKeyIfNecessary(ds);
        if (m.getTemplateRef() == null) {
            throw new NullPointerException("The property(templateRef) must not be null.");
        }
        m.getTemplateRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
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
        com.adviteya.model.MA_Company m = (com.adviteya.model.MA_Company) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("accountVerified");
        encoder0.encode(writer, m.isAccountVerified());
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getCompanyLogo() != null && m.getCompanyLogo().getBytes() != null){
            writer.setNextPropertyName("companyLogo");
            encoder0.encode(writer, m.getCompanyLogo());
        }
        if(m.getCompanyName() != null){
            writer.setNextPropertyName("companyName");
            encoder0.encode(writer, m.getCompanyName());
        }
        if(m.getEmployeeList() != null){
            writer.setNextPropertyName("employeeList");
            // com.adviteya.model.MA_Employee is not supported.
        }
        if(m.getEmplyoeePopulation() != null){
            writer.setNextPropertyName("emplyoeePopulation");
            encoder0.encode(writer, m.getEmplyoeePopulation());
        }
        if(m.getLocationList() != null){
            writer.setNextPropertyName("locationList");
            // com.adviteya.model.MA_Location is not supported.
        }
        if(m.getLogoFileName() != null){
            writer.setNextPropertyName("logoFileName");
            encoder0.encode(writer, m.getLogoFileName());
        }
        if(m.getNatureOfCompanyRef() != null && m.getNatureOfCompanyRef().getKey() != null){
            writer.setNextPropertyName("natureOfCompanyRef");
            encoder0.encode(writer, m.getNatureOfCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getTemplateRef() != null && m.getTemplateRef().getKey() != null){
            writer.setNextPropertyName("templateRef");
            encoder0.encode(writer, m.getTemplateRef(), maxDepth, currentDepth);
        }
        if(m.getTimeZone() != null){
            writer.setNextPropertyName("timeZone");
            encoder0.encode(writer, m.getTimeZone());
        }
        if(m.getUniqueidFlag() != null){
            writer.setNextPropertyName("uniqueidFlag");
            encoder0.encode(writer, m.getUniqueidFlag());
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
    protected com.adviteya.model.MA_Company jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Company m = new com.adviteya.model.MA_Company();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("accountVerified");
        m.setAccountVerified(decoder0.decode(reader, m.isAccountVerified()));
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("companyLogo");
        m.setCompanyLogo(decoder0.decode(reader, m.getCompanyLogo()));
        reader = rootReader.newObjectReader("companyName");
        m.setCompanyName(decoder0.decode(reader, m.getCompanyName()));
        reader = rootReader.newObjectReader("employeeList");
        reader = rootReader.newObjectReader("emplyoeePopulation");
        m.setEmplyoeePopulation(decoder0.decode(reader, m.getEmplyoeePopulation()));
        reader = rootReader.newObjectReader("locationList");
        reader = rootReader.newObjectReader("logoFileName");
        m.setLogoFileName(decoder0.decode(reader, m.getLogoFileName()));
        reader = rootReader.newObjectReader("natureOfCompanyRef");
        decoder0.decode(reader, m.getNatureOfCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("templateRef");
        decoder0.decode(reader, m.getTemplateRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("timeZone");
        m.setTimeZone(decoder0.decode(reader, m.getTimeZone()));
        reader = rootReader.newObjectReader("uniqueidFlag");
        m.setUniqueidFlag(decoder0.decode(reader, m.getUniqueidFlag()));
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