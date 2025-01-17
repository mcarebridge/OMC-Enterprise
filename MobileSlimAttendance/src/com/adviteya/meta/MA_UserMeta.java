package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:05")
/** */
public final class MA_UserMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_User> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_User, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_User, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_User, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee> employeeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_User, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Employee>, com.adviteya.model.MA_Employee>(this, "employeeRef", "employeeRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Employee.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User> imeiCode = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User>(this, "imeiCode", "imeiCode");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User> licAgreement = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User>(this, "licAgreement", "licAgreement");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User> password = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User>(this, "password", "password");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User> userName = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User>(this, "userName", "userName");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_User, org.slim3.datastore.ModelRef<com.adviteya.model.MA_UserProfile>, com.adviteya.model.MA_UserProfile> userProfileRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_User, org.slim3.datastore.ModelRef<com.adviteya.model.MA_UserProfile>, com.adviteya.model.MA_UserProfile>(this, "userProfileRef", "userProfileRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_UserProfile.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_User>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_User, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_UserMeta slim3_singleton = new MA_UserMeta();

    /**
     * @return the singleton
     */
    public static MA_UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_UserMeta() {
        super("MA_User", com.adviteya.model.MA_User.class);
    }

    @Override
    public com.adviteya.model.MA_User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_User model = new com.adviteya.model.MA_User();
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        if (model.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) is null.");
        }
        model.getEmployeeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("employeeRef"));
        model.setImeiCode((java.lang.String) entity.getProperty("imeiCode"));
        model.setLicAgreement((java.lang.String) entity.getProperty("licAgreement"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setUserName((java.lang.String) entity.getProperty("userName"));
        if (model.getUserProfileRef() == null) {
            throw new NullPointerException("The property(userProfileRef) is null.");
        }
        model.getUserProfileRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userProfileRef"));
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
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
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
        if (m.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) must not be null.");
        }
        entity.setProperty("employeeRef", m.getEmployeeRef().getKey());
        entity.setProperty("imeiCode", m.getImeiCode());
        entity.setProperty("licAgreement", m.getLicAgreement());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("userName", m.getUserName());
        if (m.getUserProfileRef() == null) {
            throw new NullPointerException("The property(userProfileRef) must not be null.");
        }
        entity.setProperty("userProfileRef", m.getUserProfileRef().getKey());
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
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getEmployeeRef() == null) {
            throw new NullPointerException("The property(employeeRef) must not be null.");
        }
        m.getEmployeeRef().assignKeyIfNecessary(ds);
        if (m.getUserProfileRef() == null) {
            throw new NullPointerException("The property(userProfileRef) must not be null.");
        }
        m.getUserProfileRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
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
        com.adviteya.model.MA_User m = (com.adviteya.model.MA_User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getEmployeeRef() != null && m.getEmployeeRef().getKey() != null){
            writer.setNextPropertyName("employeeRef");
            encoder0.encode(writer, m.getEmployeeRef(), maxDepth, currentDepth);
        }
        if(m.getImeiCode() != null){
            writer.setNextPropertyName("imeiCode");
            encoder0.encode(writer, m.getImeiCode());
        }
        if(m.getLicAgreement() != null){
            writer.setNextPropertyName("licAgreement");
            encoder0.encode(writer, m.getLicAgreement());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder0.encode(writer, m.getPassword());
        }
        if(m.getUserName() != null){
            writer.setNextPropertyName("userName");
            encoder0.encode(writer, m.getUserName());
        }
        if(m.getUserProfileRef() != null && m.getUserProfileRef().getKey() != null){
            writer.setNextPropertyName("userProfileRef");
            encoder0.encode(writer, m.getUserProfileRef(), maxDepth, currentDepth);
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
    protected com.adviteya.model.MA_User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_User m = new com.adviteya.model.MA_User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("employeeRef");
        decoder0.decode(reader, m.getEmployeeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("imeiCode");
        m.setImeiCode(decoder0.decode(reader, m.getImeiCode()));
        reader = rootReader.newObjectReader("licAgreement");
        m.setLicAgreement(decoder0.decode(reader, m.getLicAgreement()));
        reader = rootReader.newObjectReader("password");
        m.setPassword(decoder0.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("userName");
        m.setUserName(decoder0.decode(reader, m.getUserName()));
        reader = rootReader.newObjectReader("userProfileRef");
        decoder0.decode(reader, m.getUserProfileRef(), maxDepth, currentDepth);
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