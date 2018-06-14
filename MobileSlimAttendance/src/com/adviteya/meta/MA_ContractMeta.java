package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:10")
/** */
public final class MA_ContractMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_Contract> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract> active = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract>(this, "active", "active");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract> billingCycle = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract>(this, "billingCycle", "billingCycle");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Contract, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Contract, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Company>, com.adviteya.model.MA_Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Company.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_Contract, com.google.appengine.api.datastore.Text> contractDescription = new org.slim3.datastore.UnindexedAttributeMeta<com.adviteya.model.MA_Contract, com.google.appengine.api.datastore.Text>(this, "contractDescription", "contractDescription", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date> endDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date>(this, "endDate", "endDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Contract, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Package>, com.adviteya.model.MA_Package> packageRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_Contract, org.slim3.datastore.ModelRef<com.adviteya.model.MA_Package>, com.adviteya.model.MA_Package>(this, "packageRef", "packageRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_Package.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date> startDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date>(this, "startDate", "startDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_Contract>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_Contract, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_ContractMeta slim3_singleton = new MA_ContractMeta();

    /**
     * @return the singleton
     */
    public static MA_ContractMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_ContractMeta() {
        super("MA_Contract", com.adviteya.model.MA_Contract.class);
    }

    @Override
    public com.adviteya.model.MA_Contract entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_Contract model = new com.adviteya.model.MA_Contract();
        model.setActive((java.lang.String) entity.getProperty("active"));
        model.setBillingCycle((java.lang.String) entity.getProperty("billingCycle"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setContractDescription((com.google.appengine.api.datastore.Text) entity.getProperty("contractDescription"));
        model.setEndDate((java.util.Date) entity.getProperty("endDate"));
        if (model.getPackageRef() == null) {
            throw new NullPointerException("The property(packageRef) is null.");
        }
        model.getPackageRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("packageRef"));
        model.setStartDate((java.util.Date) entity.getProperty("startDate"));
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
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("active", m.getActive());
        entity.setProperty("billingCycle", m.getBillingCycle());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setUnindexedProperty("contractDescription", m.getContractDescription());
        entity.setProperty("endDate", m.getEndDate());
        if (m.getPackageRef() == null) {
            throw new NullPointerException("The property(packageRef) must not be null.");
        }
        entity.setProperty("packageRef", m.getPackageRef().getKey());
        entity.setProperty("startDate", m.getStartDate());
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
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getPackageRef() == null) {
            throw new NullPointerException("The property(packageRef) must not be null.");
        }
        m.getPackageRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
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
        com.adviteya.model.MA_Contract m = (com.adviteya.model.MA_Contract) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActive() != null){
            writer.setNextPropertyName("active");
            encoder0.encode(writer, m.getActive());
        }
        if(m.getBillingCycle() != null){
            writer.setNextPropertyName("billingCycle");
            encoder0.encode(writer, m.getBillingCycle());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getContractDescription() != null && m.getContractDescription().getValue() != null){
            writer.setNextPropertyName("contractDescription");
            encoder0.encode(writer, m.getContractDescription());
        }
        if(m.getEndDate() != null){
            writer.setNextPropertyName("endDate");
            encoder0.encode(writer, m.getEndDate());
        }
        if(m.getPackageRef() != null && m.getPackageRef().getKey() != null){
            writer.setNextPropertyName("packageRef");
            encoder0.encode(writer, m.getPackageRef(), maxDepth, currentDepth);
        }
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
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
    protected com.adviteya.model.MA_Contract jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_Contract m = new com.adviteya.model.MA_Contract();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("active");
        m.setActive(decoder0.decode(reader, m.getActive()));
        reader = rootReader.newObjectReader("billingCycle");
        m.setBillingCycle(decoder0.decode(reader, m.getBillingCycle()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("contractDescription");
        m.setContractDescription(decoder0.decode(reader, m.getContractDescription()));
        reader = rootReader.newObjectReader("endDate");
        m.setEndDate(decoder0.decode(reader, m.getEndDate()));
        reader = rootReader.newObjectReader("packageRef");
        decoder0.decode(reader, m.getPackageRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
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