package com.adviteya.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-19 16:33:09")
/** */
public final class MA_ContractorSkillMeta extends org.slim3.datastore.ModelMeta<com.adviteya.model.MA_ContractorSkill> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ContractorSkill, org.slim3.datastore.ModelRef<com.adviteya.model.MA_ContractorCompany>, com.adviteya.model.MA_ContractorCompany> contractorRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ContractorSkill, org.slim3.datastore.ModelRef<com.adviteya.model.MA_ContractorCompany>, com.adviteya.model.MA_ContractorCompany>(this, "contractorRef", "contractorRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_ContractorCompany.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ContractorSkill, org.slim3.datastore.ModelRef<com.adviteya.model.MA_TemplateSkill>, com.adviteya.model.MA_TemplateSkill> templateSkillRef = new org.slim3.datastore.ModelRefAttributeMeta<com.adviteya.model.MA_ContractorSkill, org.slim3.datastore.ModelRef<com.adviteya.model.MA_TemplateSkill>, com.adviteya.model.MA_TemplateSkill>(this, "templateSkillRef", "templateSkillRef", org.slim3.datastore.ModelRef.class, com.adviteya.model.MA_TemplateSkill.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ContractorSkill> createdBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ContractorSkill>(this, "createdBy", "createdBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ContractorSkill> updatedBy = new org.slim3.datastore.StringAttributeMeta<com.adviteya.model.MA_ContractorSkill>(this, "updatedBy", "updatedBy");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, java.util.Date> updatedDate = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, java.util.Date>(this, "updatedDate", "updatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.adviteya.model.MA_ContractorSkill, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedDateAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final MA_ContractorSkillMeta slim3_singleton = new MA_ContractorSkillMeta();

    /**
     * @return the singleton
     */
    public static MA_ContractorSkillMeta get() {
       return slim3_singleton;
    }

    /** */
    public MA_ContractorSkillMeta() {
        super("MA_ContractorSkill", com.adviteya.model.MA_ContractorSkill.class);
    }

    @Override
    public com.adviteya.model.MA_ContractorSkill entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.adviteya.model.MA_ContractorSkill model = new com.adviteya.model.MA_ContractorSkill();
        if (model.getContractorRef() == null) {
            throw new NullPointerException("The property(contractorRef) is null.");
        }
        model.getContractorRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("contractorRef"));
        if (model.getTemplateSkillRef() == null) {
            throw new NullPointerException("The property(templateSkillRef) is null.");
        }
        model.getTemplateSkillRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("templateSkillRef"));
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
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getContractorRef() == null) {
            throw new NullPointerException("The property(contractorRef) must not be null.");
        }
        entity.setProperty("contractorRef", m.getContractorRef().getKey());
        if (m.getTemplateSkillRef() == null) {
            throw new NullPointerException("The property(templateSkillRef) must not be null.");
        }
        entity.setProperty("templateSkillRef", m.getTemplateSkillRef().getKey());
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
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        if (m.getContractorRef() == null) {
            throw new NullPointerException("The property(contractorRef) must not be null.");
        }
        m.getContractorRef().assignKeyIfNecessary(ds);
        if (m.getTemplateSkillRef() == null) {
            throw new NullPointerException("The property(templateSkillRef) must not be null.");
        }
        m.getTemplateSkillRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
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
        com.adviteya.model.MA_ContractorSkill m = (com.adviteya.model.MA_ContractorSkill) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContractorRef() != null && m.getContractorRef().getKey() != null){
            writer.setNextPropertyName("contractorRef");
            encoder0.encode(writer, m.getContractorRef(), maxDepth, currentDepth);
        }
        if(m.getTemplateSkillRef() != null && m.getTemplateSkillRef().getKey() != null){
            writer.setNextPropertyName("templateSkillRef");
            encoder0.encode(writer, m.getTemplateSkillRef(), maxDepth, currentDepth);
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
    protected com.adviteya.model.MA_ContractorSkill jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.adviteya.model.MA_ContractorSkill m = new com.adviteya.model.MA_ContractorSkill();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("contractorRef");
        decoder0.decode(reader, m.getContractorRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("templateSkillRef");
        decoder0.decode(reader, m.getTemplateSkillRef(), maxDepth, currentDepth);
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